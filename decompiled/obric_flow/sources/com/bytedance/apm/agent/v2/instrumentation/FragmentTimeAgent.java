package com.bytedance.apm.agent.v2.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.internal.b;
import com.bytedance.apm.j;
import d7.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
import so.e;
import u5.c;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FragmentTimeAgent {
    private static final String TAG = "FragmentTimeAgent";
    private static long sCheckVisibilityStartTime = 0;
    private static String sFragmentName = null;
    private static long sMaxWaitTime = 60000;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static boolean sReported;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    static {
        sMethodSet = new HashSet(32);
    }

    public FragmentTimeAgent() {
    }

    public static /* synthetic */ String access$000() {
        return sFragmentName;
    }

    public static /* synthetic */ HashSet access$100() {
        return sMethodSet;
    }

    public static /* synthetic */ void access$200(boolean r5, String r10, long r11, long r12) {
        reportStats(r5, r10, r11, r12);
    }

    public static /* synthetic */ WeakReference access$300() {
        return sRootViewRef;
    }

    public static /* synthetic */ WeakReference access$302(WeakReference r5) {
        sRootViewRef = r5;
        return r5;
    }

    public static /* synthetic */ long access$400() {
        return sCheckVisibilityStartTime;
    }

    public static /* synthetic */ long access$402(long r5) {
        sCheckVisibilityStartTime = r5;
        return r5;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$500() {
        return sOnGlobalLayoutListener;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$502(ViewTreeObserver.OnGlobalLayoutListener r5) {
        sOnGlobalLayoutListener = r5;
        return r5;
    }

    public static /* synthetic */ Runnable access$600() {
        return sWaitViewTimeoutRunnable;
    }

    public static /* synthetic */ long access$700() {
        return sMaxWaitTime;
    }

    public static /* synthetic */ void access$800(String r5, String r10, long r11, long r12) {
        reportTraceTime(r5, r10, r11, r12);
    }

    private static boolean isValid(String r5) {
        if (sReported == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r5, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onHiddenChanged(Fragment r10, boolean r11) {
        if (r11 == false) goto L12;
        return;
    L12:
        String r5 = r10.getClass().getCanonicalName();     // Catch: Exception -> L11
        Integer r12 = a.a(r5);     // Catch: Exception -> L11
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.intValue() <= 0) goto L15;
        registerOnGlobalLayoutListener(r5, r10.getView(), r12, System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    public static void onResumeShow(Fragment r10, String r11) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L20;
        Integer r5 = a.a(r11);     // Catch: Exception -> L14
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.intValue() <= 0) goto L19;
        registerOnGlobalLayoutListener(r11, r10.getView(), r5, sOnCreateStart, "fragmentOnCreateToViewShow");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    @Keep
    public static void onTrace(Fragment r5, String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L13;
        if (r12 == false) goto L10;
        sFragmentName = r10;
        sOnCreateStart = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L8;
        ApmDelegate r13 = b.f3886a;
        sMaxWaitTime = ApmDelegate.a().f16760b;
    L8:
        sReported = false;
        return;
    L10:
        if (isValid(r10) == false) goto L56;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L56:
        return;
    L13:
        if (TextUtils.equals("onViewCreated", r11) == false) goto L24;
        if (isValid(r10) == false) goto L24;
        if (r12 == false) goto L21;
        if (sOnCreateStart <= 0) goto L58;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L58:
        return;
    L21:
        if (sOnCreateStart <= 0) goto L60;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L60:
        return;
    L24:
        if (TextUtils.equals("onActivityCreated", r11) == false) goto L35;
        if (isValid(r10) == false) goto L35;
        if (r12 == false) goto L32;
        if (sOnCreateStart <= 0) goto L62;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L62:
        return;
    L32:
        if (sOnCreateStart <= 0) goto L64;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L64:
        return;
    L35:
        if (TextUtils.equals("onResume", r11) == true) goto L37;
        return;
    L37:
        if (isValid(r10) == false) goto L67;
        if (r12 == false) goto L43;
        if (sOnCreateStart <= 0) goto L68;
        sOnResumeStart = System.currentTimeMillis();
        onResumeShow(r5, r10);
        return;
    L68:
        return;
    L43:
        if (sOnCreateStart <= 0) goto L70;
        sOnResumeEnd = System.currentTimeMillis();
        Integer r14 = a.a(r10);     // Catch: Exception -> L52
        if (r14 != null) goto L48;
    L49:
        z6.b.f23409a.d(new e(3));     // Catch: Exception -> L52
        goto L50
    L48:
        if (r14.intValue() <= 0) goto L49;
    L50:
        sReported = true;
        sFragmentName = null;
        return;
    L70:
        return;
    }

    @TargetApi(16)
    private static void registerOnGlobalLayoutListener(String r10, View r11, Integer r12, long r13, String r14) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.intValue() <= 0) goto L21;
        sFragmentName = r10;
        WeakReference<View> r15 = sRootViewRef;
        if (r15 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r11);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new com.bytedance.apm.agent.instrumentation.a(r12, r13, r14, 1);
        r11.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new e(4);
        z6.a.f23408a.postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r15.get() == r11) goto L18;
        ViewTreeObserver r16 = sRootViewRef.get().getViewTreeObserver();
        if (r16.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r5 = sOnGlobalLayoutListener;
        if (r5 == null) goto L16;
        r16.removeOnGlobalLayoutListener(r5);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        z6.a.f23408a.removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }

    private static void reportStats(boolean r10, String r11, long r12, long r13) {
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L6
        r5.put("name", "onCreate");     // Catch: Exception -> L6
        r5.put("start", sOnCreateStart);     // Catch: Exception -> L6
        r5.put("end", sOnCreateEnd);     // Catch: Exception -> L6
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L6
        r14.put("name", "onViewCreated");     // Catch: Exception -> L6
        r14.put("start", sOnViewCreatedStart);     // Catch: Exception -> L6
        r14.put("end", sOnViewCreatedEnd);     // Catch: Exception -> L6
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L6
        r15.put("name", "onActivityCreated");     // Catch: Exception -> L6
        r15.put("start", sOnActivityCreatedStart);     // Catch: Exception -> L6
        r15.put("end", sOnActivityCreatedEnd);     // Catch: Exception -> L6
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L6
        r16.put("name", "onResume");     // Catch: Exception -> L6
        r16.put("start", sOnResumeStart);     // Catch: Exception -> L6
        r16.put("end", sOnResumeEnd);     // Catch: Exception -> L6
        JSONArray r17 = new JSONArray();     // Catch: Exception -> L6
        r17.put(r5);     // Catch: Exception -> L6
        r17.put(r14);     // Catch: Exception -> L6
        r17.put(r15);     // Catch: Exception -> L6
        r17.put(r16);     // Catch: Exception -> L6
        if (r11 == null) goto L8;
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L6
        r18.put("name", r11);     // Catch: Exception -> L6
        r18.put("start", r12);     // Catch: Exception -> L6
        r18.put("end", r13);     // Catch: Exception -> L6
        r17.put(r18);     // Catch: Exception -> L6
    L8:
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L6
        r19.put("name", "page_load_stats");     // Catch: Exception -> L6
        r19.put("page_type", "fragment");     // Catch: Exception -> L6
        r19.put("start", sOnCreateStart);     // Catch: Exception -> L6
        r19.put("spans", r17);     // Catch: Exception -> L6
        if (r10 == false) goto L11;
        int r20 = 2;
    L12:
        r19.put("launch_mode", r20);     // Catch: Exception -> L6
        r19.put("collect_from", 1);     // Catch: Exception -> L6
        r19.put("page_name", sFragmentName);     // Catch: Exception -> L6
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L6
        r21.put("trace", r19);     // Catch: Exception -> L6
        z6.b.f23409a.d(new com.bytedance.apm.e("page_load_trace", null, null, r21));     // Catch: Exception -> L6
        return;
    L11:
        r20 = 1;
    L6:
        e = move-exception;
        if (j.f3887a == false) goto L20;
        e.printStackTrace();
        return;
    }

    private static void reportTraceTime(String r10, String r11, long r12, long r13) {
        z6.b.f23409a.d(new c(r11, r12, r13));
    }

    @Keep
    public static void setUserVisibleHint(Fragment r10, boolean r11) {
        if (r11 == true) goto L4;
        return;
    L4:
        if (r10.isResumed() == true) goto L6;
        return;
    L6:
        if (r10.isHidden() == true) goto L22;
        String r5 = r10.getClass().getCanonicalName();     // Catch: Exception -> L15
        Integer r12 = a.a(r5);     // Catch: Exception -> L15
        if (r12 != null) goto L11;
        return;
    L11:
        if (r12.intValue() <= 0) goto L21;
        registerOnGlobalLayoutListener(r5, r10.getView(), r12, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L15
        return;
    L21:
        return;
    L23:
        return;
    }
}
