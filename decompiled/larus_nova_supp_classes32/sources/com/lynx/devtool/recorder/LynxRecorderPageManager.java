package com.lynx.devtool.recorder;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderPageManager {
    private static final String TAG = "LynxRecorderPageManager";
    private static LynxRecorderPageManager instance;
    private AtomicInteger count;
    private JSONObject mActivities;
    private int mActivityLaunchFlags;
    private ArrayList<LynxRecorderActionCallback> mCallbacks;
    private JSONObject mGroups;
    private boolean mIsMultiEnv;
    private ArrayList<String> mPageStack;
    private JSONObject mPages;
    private JSONObject mRouters;

    private void clear() {
        this.mIsMultiEnv = false;
        this.mPages = new JSONObject();
        this.mRouters = new JSONObject();
        this.mActivities = new JSONObject();
        this.mGroups = new JSONObject();
        this.mPageStack = new ArrayList();
    }

    public static synchronized LynxRecorderPageManager getInstance() {
        monitor-enter(LynxRecorderPageManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        LynxRecorderPageManager r1 = new LynxRecorderPageManager();     // Catch: Throwable -> L10
        instance = r1;     // Catch: Throwable -> L10
        r1.clear();     // Catch: Throwable -> L10
    L7:
        LynxRecorderPageManager r2 = instance;     // Catch: Throwable -> L10
        monitor-exit(LynxRecorderPageManager.class);
        return r2;
    }

    private int incrementAndGet() {
        return this.count.incrementAndGet();
    }

    private LynxRecorderPageManager() {
        this.count = new AtomicInteger(0);
        this.mCallbacks = new ArrayList();
    }

    public ArrayList<LynxRecorderActionCallback> getCallbacks() {
        return this.mCallbacks;
    }

    public static /* synthetic */ ArrayList access$300(LynxRecorderPageManager r0) {
        return r0.mPageStack;
    }

    private String buildPageName(String r2) {
        return r2 + "#" + String.valueOf(incrementAndGet());
    }

    private String getRawPageName(String r2) {
        return r2.split("#")[0];
    }

    private boolean isDescribeFile(String r4) {
        QueryMapUtils r0 = new QueryMapUtils();
        r0.parse(r4);
        if (r0.getString("describe_file") != null) goto L5;
    L8:
        return false;
    L5:
        if (r0.getBoolean("describe_file", false) == false) goto L8;
        return true;
    }

    private boolean isMultiPagesFile(String r4) {
        QueryMapUtils r0 = new QueryMapUtils();
        r0.parse(r4);
        if (r0.getString("multi-page") != null) goto L5;
    L8:
        return false;
    L5:
        if (r0.getBoolean("multi-page", false) == false) goto L8;
        return true;
    }

    public void registerCallback(LynxRecorderActionCallback r2) {
        this.mCallbacks.add(r2);
    }

    public void replayPageFromOpenSchema(ReadableMap r5) {
        if (this.mIsMultiEnv == true) goto L5;
        return;
    L5:
        ArrayList<String> r0 = this.mPageStack;
        String r1 = (String) ListProtector.get(r0, r0.size() - 1);
        String r2 = getRawPageName(r1);
        JSONObject r6 = this.mRouters.optJSONObject(r2).optJSONObject(r5.getString("label"));
        boolean r3 = r6.optBoolean("popLast");
        String r7 = r6.optString("next");
        if (r3 == false) goto L8;
        ArrayList<String> r4 = this.mPageStack;
        ListProtector.remove(r4, r4.size() - 1);
    L8:
        this.mPageStack.add(buildPageName(r7));
        replayCurrPage((LynxRecorderActivity) this.mActivities.opt(r1), r3);
    }

    public static /* synthetic */ JSONObject access$002(LynxRecorderPageManager r0, JSONObject r1) {
        r0.mPages = r1;
        return r1;
    }

    public static /* synthetic */ JSONObject access$102(LynxRecorderPageManager r0, JSONObject r1) {
        r0.mRouters = r1;
        return r1;
    }

    public static /* synthetic */ String access$200(LynxRecorderPageManager r0, String r1) {
        return r0.buildPageName(r1);
    }

    private Intent getTestBenchIntent(Context r3, String r4) {
        Intent r0 = new Intent(r3, LynxRecorderActivity.class);
        r0.addFlags(this.mActivityLaunchFlags);
        r0.putExtra(LynxRecorderEnv.getInstance().mUriKey, r4);
        return r0;
    }

    public void initLynxGroup(String r2, LynxRecorderActivity r3) {
        if (this.mIsMultiEnv == true) goto L5;
        return;
    L5:
        LynxRecorderActivity r0 = (LynxRecorderActivity) this.mGroups.opt(r2);
        if (r0 == null) goto L13;
        r3.setLynxGroup(r0.getLynxGroup());
        return;
    L13:
        this.mGroups.put(r2, r3);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public void loadDescribeFile(String r3, final Context r4) {
        QueryMapUtils r0 = new QueryMapUtils();
        r0.parse(r3);
        String r5 = r0.getString(LynxEventReporter.PROP_NAME_URL);
        LynxEnv.inst().getTemplateProvider().loadTemplate(r5, new AnonymousClass1(this, r4));
    }

    public void onActivityDestroy(String r2, boolean r3) {
        if (this.mIsMultiEnv == true) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
        ArrayList<String> r4 = this.mPageStack;
        ListProtector.remove(r4, r4.size() - 1);
    L7:
        this.mActivities.remove(r2);
    }

    public void registerActivity(String r2, LynxRecorderActivity r3) {
        if (this.mIsMultiEnv == true) goto L10;
        return;
    L10:
        this.mActivities.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replayCurrPage(Context r6, boolean r7) {
        ArrayList<String> r0 = this.mPageStack;
        String r1 = (String) ListProtector.get(r0, r0.size() - 1);
        String r2 = getRawPageName(r1);
        JSONObject r3 = this.mPages.optJSONObject(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        Intent r4 = getTestBenchIntent(r6, r3.optString(LynxEventReporter.PROP_NAME_URL));
        r4.putExtra("groupName", r3.optString("group"));
        r4.putExtra("pageName", r1);
        r6.startActivity(r4);
        if (r7 == false) goto L9;
        LynxRecorderActivity r8 = (LynxRecorderActivity) r6;
        r8.setState(true);
        r8.finish();
        return;
    }

    public void replayMultiPages(String r2, Context r3) {
        clear();
        this.mIsMultiEnv = true;
        loadDescribeFile(r2, r3);
    }

    public void replayMultiPagesInOneActivity(String r3, Context r4) {
        clear();
        this.mIsMultiEnv = true;
        Intent r0 = new Intent(r4, LynxRecorderMultiPagesActivity.class);
        r0.addFlags(this.mActivityLaunchFlags);
        r0.putExtra(LynxRecorderEnv.getInstance().mUriKey, r3);
        r4.startActivity(r0);
    }

    public void replaySignalPage(String r2, Context r3) {
        clear();
        this.mIsMultiEnv = false;
        r3.startActivity(getTestBenchIntent(r3, r2));
    }

    public void startReplay(String r1, Context r2, int r3) {
        this.mActivityLaunchFlags = r3;
        if (isDescribeFile(r1) == false) goto L6;
        replayMultiPages(r1, r2);
        return;
    L6:
        if (isMultiPagesFile(r1) == false) goto L8;
        replayMultiPagesInOneActivity(r1, r2);
        return;
    L8:
        replaySignalPage(r1, r2);
    }
}
