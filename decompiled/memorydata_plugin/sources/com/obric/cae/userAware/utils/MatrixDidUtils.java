package com.obric.cae.userAware.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.obric.cae.log.a;
import com.obric.matrix.platform.sdk.ones.a.d;
import com.obric.matrix.platform.sdk.ones.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MatrixDidUtils {
    private static final String KEY_DID = "did";
    private static final int MAX_RETRY_COUNT = 60;
    private static final String PREF_NAME = "matrix_did_pref";
    private static final long RETRY_DELAY_MS = 1000;
    private static final String TAG = "MatrixDidUtils";
    private static String sCachedDid = "";
    private static Context sContext = null;
    private static volatile boolean sInitialized = false;
    private static Handler sRetryHandler;

    static {
        sRetryHandler = new Handler(Looper.getMainLooper());
    }

    private MatrixDidUtils() {
    }

    public static String getDid() {
        if (TextUtils.isEmpty(sCachedDid) == true) goto L7;
        return sCachedDid;
    L7:
        if (sContext == null) goto L15;
        if (TextUtils.isEmpty(sCachedDid) == false) goto L15;
        String r0 = sContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_DID, "");
        sCachedDid = r0;
        if (TextUtils.isEmpty(r0) == true) goto L15;
        return sCachedDid;
    L15:
        if (sInitialized == false) goto L18;
        sRetryHandler.post($$Lambda$MatrixDidUtils$1MtWDZbOlDrZreRfLtRVBLfWEIs.INSTANCE);
    L18:
        return sCachedDid;
    }

    public static String getDid(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sContext != null) goto L7;
        if (r3 == null) goto L7;
        sContext = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L7:
        return getDid();
    }

    private static String getDidFromSdk() {
    L9:
        e = move-exception;
        a.i(TAG, "Failed to get did from SDK: " + e.getMessage());
        return "";
    L4:
        if (sInitialized == true) goto L8;
        a.g(TAG, "getDidFromSdk called before init");     // Catch: Exception -> L9
        return "";
    L8:
        return e.f8062a.a().c() + "";
    }

    public static void init(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (sInitialized == false) goto L6;
        a.c(TAG, "Already initialized");
        return;
    L6:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        sContext = r0;
        sCachedDid = r0.getSharedPreferences(PREF_NAME, 0).getString(KEY_DID, "");
        e.f8062a.a(r6, new d.a().a(r6.getPackageName()).a(0).a(false).b("").a());     // Catch: Exception -> L9
        sInitialized = true;     // Catch: Exception -> L9
        a.c(TAG, "MatrixTeaManager initialized successfully");     // Catch: Exception -> L9
        tryGetDidWithRetry(1);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        a.i(TAG, "Failed to initialize MatrixTeaManager: " + e.getMessage());
    }

    static /* synthetic */ void lambda$getDid$1() {
        String r0 = getDidFromSdk();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        if (r0.equals("null") == false) goto L7;
        return;
    L7:
        if (r0.equals("0") == false) goto L9;
        return;
    L9:
        if (TextUtils.equals(sCachedDid, r0) == true) goto L15;
        updateCachedDid(r0);
        a.c(TAG, "Matrix did updated async: " + sCachedDid);
        return;
    }

    static /* synthetic */ void lambda$tryGetDidWithRetry$0(int r0) {
        tryGetDidWithRetry(r0 + 1);
    }

    static /* synthetic */ void lambda$updateCachedDid$2() {
        com.obric.cae.location.geosdk.bytedance.a.a().a(sContext);
    }

    private static void tryGetDidWithRetry(final int r4) {
        String r0 = getDidFromSdk();
        if (TextUtils.isEmpty(r0) == true) goto L13;
        if (r0.equals("null") == true) goto L13;
        if (r0.equals("0") == true) goto L13;
        if (TextUtils.equals(sCachedDid, r0) == true) goto L17;
        updateCachedDid(r0);
        a.c(TAG, "Matrix did initialized: " + sCachedDid + " (attempt " + r4 + ")");
        return;
    L17:
        return;
    L13:
        if (r4 >= 60) goto L15;
        a.c(TAG, "Matrix did is empty/0 (attempt " + r4 + "), retry after 1000ms");
        sRetryHandler.postDelayed(new $$Lambda$MatrixDidUtils$GmcDzbTcSY2k_7_vnWmRSbMSs(r4), 1000);
        return;
    L15:
        a.c(TAG, "Matrix did is empty/0 after 60 attempts, will get later");
    }

    private static void updateCachedDid(String r3) {
        if (TextUtils.equals(sCachedDid, r3) == false) goto L5;
        return;
    L5:
        sCachedDid = r3;
        Context r0 = sContext;
        if (r0 == null) goto L9;
        r0.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_DID, r3).apply();
        sRetryHandler.post($$Lambda$MatrixDidUtils$cYWmvTZgjtSVV7OC3sFxRNrPrE.INSTANCE);
        return;
    }
}
