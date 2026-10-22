package com.obric.cae.userAware.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.dataanalysis.b;
import he.i;
import o5.p;
import o5.r;

/* JADX INFO: loaded from: classes2.dex */
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

    public static /* synthetic */ void a() {
        lambda$updateCachedDid$2();
    }

    public static /* synthetic */ void b() {
        lambda$getDid$1();
    }

    public static /* synthetic */ void c(int r8) {
        lambda$tryGetDidWithRetry$0(r8);
    }

    public static String getDid() {
        if (TextUtils.isEmpty(sCachedDid) == true) goto L7;
        return sCachedDid;
    L7:
        if (sContext == null) goto L15;
        if (TextUtils.isEmpty(sCachedDid) == false) goto L15;
        String r8 = sContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_DID, "");
        sCachedDid = r8;
        if (TextUtils.isEmpty(r8) == true) goto L15;
        return sCachedDid;
    L15:
        if (sInitialized == false) goto L18;
        sRetryHandler.post(new r(3));
    L18:
        return sCachedDid;
    }

    private static String getDidFromSdk() {
    L13:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to get did from SDK: " + e.getMessage());
        return "";
    L4:
        if (sInitialized == true) goto L7;
        CommSenseLog.w(TAG, "getDidFromSdk called before init");     // Catch: Exception -> L13
        return "";
    L7:
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L13
        MatrixTeaManager r10 = MatrixTeaManager.f6122l;     // Catch: Exception -> L13
        if (r10 == null) goto L12;
        r8.append(r10.c());     // Catch: Exception -> L13
        r8.append("");     // Catch: Exception -> L13
        return r8.toString();
    L12:
        throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());     // Catch: Exception -> L13
    }

    public static void init(Context r8) {
        if (sInitialized == false) goto L6;
        CommSenseLog.d(TAG, "Already initialized");
        return;
    L6:
        Context r10 = r8.getApplicationContext();
        sContext = r10;
        sCachedDid = r10.getSharedPreferences(PREF_NAME, 0).getString(KEY_DID, "");
        new b.a();     // Catch: Exception -> L9
        String r11 = r8.getPackageName();     // Catch: Exception -> L9
        i.f(r11, "pkgName");     // Catch: Exception -> L9
        MatrixTeaManager.a.a(r8, new b(r11, 0, "", false));     // Catch: Exception -> L9
        sInitialized = true;     // Catch: Exception -> L9
        CommSenseLog.d(TAG, "MatrixTeaManager initialized successfully");     // Catch: Exception -> L9
        tryGetDidWithRetry(1);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to initialize MatrixTeaManager: " + e.getMessage());
    }

    private static /* synthetic */ void lambda$getDid$1() {
        String r8 = getDidFromSdk();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (r8.equals("null") == false) goto L7;
        return;
    L7:
        if (r8.equals("0") == false) goto L9;
        return;
    L9:
        if (TextUtils.equals(sCachedDid, r8) == true) goto L15;
        updateCachedDid(r8);
        CommSenseLog.d(TAG, "Matrix did updated async: " + sCachedDid);
        return;
    }

    private static /* synthetic */ void lambda$tryGetDidWithRetry$0(int r8) {
        tryGetDidWithRetry(r8 + 1);
    }

    private static /* synthetic */ void lambda$updateCachedDid$2() {
        BdLocationManager.getInstance().init(sContext);
    }

    private static void tryGetDidWithRetry(final int r8) {
        String r10 = getDidFromSdk();
        if (TextUtils.isEmpty(r10) == true) goto L13;
        if (r10.equals("null") == true) goto L13;
        if (r10.equals("0") == true) goto L13;
        if (TextUtils.equals(sCachedDid, r10) == true) goto L17;
        updateCachedDid(r10);
        CommSenseLog.d(TAG, "Matrix did initialized: " + sCachedDid + " (attempt " + r8 + ")");
        return;
    L17:
        return;
    L13:
        if (r8 >= 60) goto L15;
        CommSenseLog.d(TAG, "Matrix did is empty/0 (attempt " + r8 + "), retry after 1000ms");
        sRetryHandler.postDelayed(new a(r8), 1000);
        return;
    L15:
        CommSenseLog.d(TAG, "Matrix did is empty/0 after 60 attempts, will get later");
    }

    private static void updateCachedDid(String r8) {
        if (TextUtils.equals(sCachedDid, r8) == false) goto L5;
        return;
    L5:
        sCachedDid = r8;
        Context r10 = sContext;
        if (r10 == null) goto L9;
        r10.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_DID, r8).apply();
        sRetryHandler.post(new p(2));
        return;
    }

    public static String getDid(Context r8) {
        if (sContext != null) goto L7;
        if (r8 == null) goto L7;
        sContext = r8.getApplicationContext();
    L7:
        return getDid();
    }
}
