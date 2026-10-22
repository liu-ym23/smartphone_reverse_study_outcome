package com.bytedance.securityguardkit;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.securityguardkit.ai.ContentCategory;
import com.bytedance.securityguardkit.ai.a;
import com.bytedance.securityguardkit.wordfilter.b;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityGuardKitManager {
    private static final String TAG = "SecurityGuardKitManager";
    private static SecurityGuardKitManager sInstance;
    private final int MAX_BATCH_SIZE;
    private final Context mContext;
    private final b mSensitiveWordFilter;

    private SecurityGuardKitManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.MAX_BATCH_SIZE = AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD;
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        b r0 = new b(r4);
        this.mSensitiveWordFilter = r0;
        r0.a();
    }

    public static SecurityGuardKitManager getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(SecurityGuardKitManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SecurityGuardKitManager(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecurityGuardKitManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void processBatchInferResult(JSONArray r4, HashSet<String>[] r5) {
        int r0 = 0;
    L10:
    L7:
        e = move-exception;
        Log.e(TAG, "batchInferResult: JSONException", e);
        return;
    L4:
        if (r0 >= r4.length()) goto L13;
        processInferResult(r4.getJSONObject(r0), r5[r0]);     // Catch: JSONException -> L7
        r0 = r0 + 1;
        goto L10
    }

    private void processInferResult(JSONObject r5, Set<String> r6) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        int r7 = r5.getInt("label_id");     // Catch: JSONException -> L12
        if (r5.getDouble("score") <= 0.9d) goto L9;
        ContentCategory r8 = ContentCategory.fromValue(r7);     // Catch: JSONException -> L12
        if (r8 == null) goto L9;
        r4.add(r8.getCategoryName());     // Catch: JSONException -> L12
    L9:
        if (r4.isEmpty() == false) goto L17;
        r4.add(ContentCategory.SECURITY.getCategoryName());     // Catch: JSONException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        Log.e(TAG, "inferResult: JSONException", e);
    }

    public Set<String>[] batchInferSensitiveContent(String[] r10) {
        if (r10 != null) goto L5;
    L28:
        return null;
    L5:
        if (r10.length == 0) goto L28;
        if (r10.length <= 150) goto L10;
        r10 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r10, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD), String[].class, "com.obric.memorydata.plugin");
    L10:
        HashSet<String>[] r1 = new HashSet[r10.length];
        int r2 = 0;
    L12:
        if (r2 >= r10.length) goto L18;
        if (TextUtils.isEmpty(r10[r2]) == true) goto L15;
        r1[r2] = new HashSet();
        r2 = r2 + 1;
        goto L12
    L15:
        Log.e(TAG, "invalid text at index: " + r2);
        return null;
    L18:
        Log.i(TAG, "start batch infer.");
        long r3 = System.currentTimeMillis();
        JSONArray r11 = a.f3165a.a(this.mContext).a(r10);     // Catch: Exception -> L26
        Log.i(TAG, "batch infer cost: " + (System.currentTimeMillis() - r3));
        if (r11 != null) goto L24;
        Log.e(TAG, "batchResult is empty.");
        return null;
    L24:
        processBatchInferResult(r11, r1);
        return r1;
    L26:
        e = move-exception;
        Log.e(TAG, "batchInfer failed.", e);
        goto L28
    }

    public void deinitSensitiveCategories() {
        this.mSensitiveWordFilter.b();
    }

    public Set<String> findSensitiveCategories(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return null;
    L7:
        return this.mSensitiveWordFilter.b(r3.replaceAll("\\s+", ""));
    }

    public Set<String> findSensitiveWords(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return null;
    L7:
        return this.mSensitiveWordFilter.a(r3.replaceAll("\\s+", ""));
    }

    public String getCapabilityInfo() {
        JSONObject r0 = this.mSensitiveWordFilter.c();
        JSONObject r3 = a.f3165a.a(this.mContext).b();
        JSONObject r1 = new JSONObject();
        r1.put("sensitive_word", r0);     // Catch: JSONException -> L5
        r1.put("model", r3);     // Catch: JSONException -> L5
    L8:
        return r1.toString();
    L5:
        e = move-exception;
        Log.e(TAG, "build capability failed.", e);
        goto L8
    }

    public void getSecurityContentModel() {
        Log.i(TAG, "config security content model.");
        a.f3165a.a(this.mContext).a();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "init content detector failed: " + e.getMessage());
    }

    public Set<String> inferSensitiveContent(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return null;
    L5:
        Log.i(TAG, "start infer.");
        long r2 = System.currentTimeMillis();
        JSONObject r10 = a.f3165a.a(this.mContext).a(r9);     // Catch: Exception -> L13
        Log.i(TAG, "infer cost: " + (System.currentTimeMillis() - r2));
        if (r10 != null) goto L11;
        Log.e(TAG, "inferResult is empty.");
        return null;
    L11:
        HashSet r0 = new HashSet();
        processInferResult(r10, r0);
        return r0;
    L13:
        e = move-exception;
        Log.e(TAG, "infer failed.", e);
        return null;
    }

    public boolean initSensitiveCategories(Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L14:
        String r3 = "categories is empty.";
    L10:
        Log.i(TAG, r3);
        return false;
    L5:
        if (r5.isEmpty() == true) goto L14;
        if (this.mSensitiveWordFilter.a(r5) == true) goto L12;
        r3 = "initCategories failed.";
        goto L10
    L12:
        return true;
    }
}
