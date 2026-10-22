package com.privacy.azerothprivacy;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.common.utility.NetworkClient;
import com.privacy.azerothprivacy.alarm.receiver.ColdBootDelayExecutor;
import com.privacy.azerothprivacy.alarm.receiver.KeyAgreementUpdater;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import dpa.d;
import dpa.h;
import fpa.c;
import java.security.Key;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import org.json.JSONException;
import org.json.JSONObject;
import poa.a;
import poa.b;
import poa.e;
import poa.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AzerothPrivacy {
    private static final String TAG = "AzerothPrivacy";
    private static Application app;
    private static Context appContext;
    private static a appInfo;
    private static volatile boolean hasInitiated;
    private static f sdkConfig;

    public AzerothPrivacy() {
    }

    public static /* synthetic */ void a() {
        lambda$initAsync$1();
    }

    public static /* synthetic */ void b(a r0) {
        lambda$init$0(r0);
    }

    public static /* synthetic */ void c() {
        lambda$invokeAfterLogin$3();
    }

    public static /* synthetic */ void d(String r0) {
        lambda$invokeAfterLogin$2(r0);
    }

    public static String getVersion() {
        return "1.5.1";
    }

    public static synchronized a getAppInfo() {
        monitor-enter(AzerothPrivacy.class);
        a r1 = appInfo;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return r1;
    L8:
        a r2 = new a();     // Catch: Throwable -> L11
        monitor-exit(AzerothPrivacy.class);
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized f getSdkConfig() {
        monitor-enter(AzerothPrivacy.class);
        f r1 = sdkConfig;     // Catch: Throwable -> L7
        monitor-exit(AzerothPrivacy.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static void initAsync() {
        Runnable r0 = new b();
        c.a.execute(r0);
    }

    private static void lambda$initAsync$1() {
        apa.a.a(TAG, "initAsync start");     // Catch: Exception -> L4
        zoa.a.a();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        xoa.a.a(e, "initAsync exception", null);
    }

    private static void lambda$invokeAfterLogin$3() {
        com.privacy.azerothprivacy.userAuthToken.b.b.a();
    }

    public static synchronized void invokeAfterLogout() {
        monitor-enter(AzerothPrivacy.class);
    L46:
        th = move-exception;
        throw th;
    L5:
        if (hasInitiated == true) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return;
    L8:
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L46
        String r4 = appInfo.e;     // Catch: Throwable -> L46
        String r0 = "user logout: " + r4;     // Catch: Throwable -> L23 Exception -> L25
        if (apa.a.a == null) goto L15;
        apa.a.a.i(r0);     // Catch: Throwable -> L23 Exception -> L25
    L15:
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L35;
        long r6 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L46
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L46
        r1.put("running_status", 1);     // Catch: JSONException -> L19 Throwable -> L46
        r3.put("running_time", r6);     // Catch: JSONException -> L19 Throwable -> L46
        r5.put("user_id", null);     // Catch: JSONException -> L19 Throwable -> L46
    L34:
        bpa.a.b("invokeAfterLogout", r1, r3, r5);     // Catch: Throwable -> L46
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L46
    L35:
        monitor-exit(AzerothPrivacy.class);
        return;
    L23:
        th = move-exception;
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L45;
        long r7 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L46
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L46
        r8.put("running_status", 1);     // Catch: JSONException -> L42 Throwable -> L46
        r9.put("running_time", r7);     // Catch: JSONException -> L42 Throwable -> L46
        r10.put("user_id", r4);     // Catch: JSONException -> L42 Throwable -> L46
    L44:
        bpa.a.b("invokeAfterLogout", r8, r9, r10);     // Catch: Throwable -> L46
        goto L45
    L42:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L46
    L45:
        throw th;     // Catch: Throwable -> L46
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        HashMap r11 = new HashMap();     // Catch: Throwable -> L23
        r11.put("user_id", r4);     // Catch: Throwable -> L23
        xoa.a.a(e, "invokeAfterLogout exception", r11);     // Catch: Throwable -> L23
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L35;
        long r12 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L46
        r1 = new JSONObject();     // Catch: Throwable -> L46
        r3 = new JSONObject();     // Catch: Throwable -> L46
        r5 = new JSONObject();     // Catch: Throwable -> L46
        r1.put("running_status", 2);     // Catch: JSONException -> L32 Throwable -> L46
        r3.put("running_time", r12);     // Catch: JSONException -> L32 Throwable -> L46
        r5.put("user_id", r4);     // Catch: JSONException -> L32 Throwable -> L46
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L46
        goto L34
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static Application getApplication() {
        return app;
    }

    public static boolean isInitiated() {
        return hasInitiated;
    }

    public static synchronized void invokeAfterLogin(String r9) {
        monitor-enter(AzerothPrivacy.class);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (hasInitiated == true) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return;
    L8:
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L47
        int r4 = 1;
        String r0 = "user login: " + r9;     // Catch: Throwable -> L24 Exception -> L26
        if (apa.a.a == null) goto L14;
        apa.a.a.i(r0);     // Catch: Throwable -> L24 Exception -> L26
    L14:
        appInfo.e = r9;     // Catch: Throwable -> L24 Exception -> L26
        ThreadMethodProxy.start(new PthreadThreadV2(new poa.c(r9), "zerothPrivacy"));     // Catch: Throwable -> L24 Exception -> L26
        c.a.execute(new poa.d());     // Catch: Throwable -> L24 Exception -> L26
    L16:
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L36;
        long r5 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L47
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L47
        r1.put("running_status", 1);     // Catch: JSONException -> L20 Throwable -> L47
        r3.put("running_time", r5);     // Catch: JSONException -> L20 Throwable -> L47
        r6.put("user_id", r9);     // Catch: JSONException -> L20 Throwable -> L47
    L35:
        bpa.a.b("invokeAfterLogin", r1, r3, r6);     // Catch: Throwable -> L47
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L36:
        monitor-exit(AzerothPrivacy.class);
        return;
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        r4 = 2;
        HashMap r7 = new HashMap();     // Catch: Throwable -> L24
        r7.put("user_id", r9);     // Catch: Throwable -> L24
        xoa.a.a(e, "invokeAfterLogin exception", r7);     // Catch: Throwable -> L24
    L29:
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L36;
        long r8 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L47
        r1 = new JSONObject();     // Catch: Throwable -> L47
        r3 = new JSONObject();     // Catch: Throwable -> L47
        r6 = new JSONObject();     // Catch: Throwable -> L47
        r1.put("running_status", 2);     // Catch: JSONException -> L33 Throwable -> L47
        r3.put("running_time", r8);     // Catch: JSONException -> L33 Throwable -> L47
        r6.put("user_id", r9);     // Catch: JSONException -> L33 Throwable -> L47
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L24:
        th = move-exception;
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L46;
        long r10 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L47
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L47
        r11.put("running_status", r4);     // Catch: JSONException -> L43 Throwable -> L47
        r12.put("running_time", r10);     // Catch: JSONException -> L43 Throwable -> L47
        r13.put("user_id", r9);     // Catch: JSONException -> L43 Throwable -> L47
    L45:
        bpa.a.b("invokeAfterLogin", r11, r12, r13);     // Catch: Throwable -> L47
        goto L46
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L46:
        throw th;     // Catch: Throwable -> L47
    }

    private static void lambda$init$0(a r4) {
        toa.d r0 = toa.d.h;
        Context r1 = appContext;
        String r5 = r4.e;
        monitor-enter(r0);
        Key r3 = toa.d.h(r1, r5, null);     // Catch: Throwable -> L14
        if (r3 != null) goto L8;
    L11:
        r0.c(r1, r5);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return;
    L8:
        if (toa.d.g(r1, r5, null) == null) goto L11;
        toa.d.k(r1, r5, r3);     // Catch: Throwable -> L14
        qoa.b.b(r1, new KeyAgreementUpdater());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static void lambda$invokeAfterLogin$2(String r4) {
        toa.d r0 = toa.d.h;
        Context r1 = appContext;
        monitor-enter(r0);
        Key r3 = toa.d.h(r1, r4, null);     // Catch: Throwable -> L14
        if (r3 != null) goto L8;
    L11:
        r0.c(r1, r4);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return;
    L8:
        if (toa.d.g(r1, r4, null) == null) goto L11;
        toa.d.k(r1, r4, r3);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static voa.a encryptArray(Context r6, byte[] r7) {
        if (TextUtils.isEmpty(appInfo.e) == false) goto L7;
        new Exception("UID is not found");
        return new voa.a();
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        if (d.a().cryptoSetting.disable_crypto == true) goto L24;
        JSONObject r0 = new JSONObject();
        long r1 = System.currentTimeMillis();
        r0.put("SYMMETRIC", "EncryptArray");     // Catch: JSONException -> L14
    L16:
        int r3 = 0;
        toa.d.h.getClass();     // Catch: Throwable -> L19 Exception -> L21
        uoa.a.a(r7, toa.d.a(r6));     // Catch: Throwable -> L19 Exception -> L21
        voa.a r8 = new voa.a();     // Catch: Throwable -> L19 Exception -> L21
    L18:
        bpa.a.d(r1, r3, r0);
        return r8;
    L21:
        e = move-exception;
        HashMap r9 = new HashMap();     // Catch: Throwable -> L19
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L19
        r9.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L19
        xoa.a.a(e, "AES encryption exception", r9);     // Catch: Throwable -> L19
        r3 = 1;
        r8 = new voa.a();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        bpa.a.d(r1, r3, r0);
        throw th;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L16
    L24:
        return new voa.a();
    L28:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    public static voa.b encryptString(Context r9, String r10) {
        if (TextUtils.isEmpty(appInfo.e) == false) goto L7;
        return new voa.b(r10, 2, new Exception("UID is not found"));
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L32;
        int r2 = 1;
        if (d.a().cryptoSetting.disable_crypto == true) goto L40;
        JSONObject r0 = new JSONObject();
        long r4 = System.currentTimeMillis();
        r0.put("SYMMETRIC", "EncryptString");     // Catch: JSONException -> L14
    L33:
        toa.d.h.getClass();     // Catch: Throwable -> L19 Exception -> L21
        uoa.b r11 = toa.d.a(r9);     // Catch: Throwable -> L19 Exception -> L21
        voa.b r7 = new voa.b(Base64.encodeToString(uoa.a.a(r10.getBytes(EffectRequest.DEFAULT_PARAMS_ENCODING), r11), 2), 0, null);     // Catch: Throwable -> L19 Exception -> L21
        bpa.a.d(r4, 0, r0);
        return r7;
    L21:
        e = move-exception;
        HashMap r3 = new HashMap();     // Catch: Throwable -> L19
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L19
        r3.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L19
        xoa.a.a(e, "AES encryption exception", r3);     // Catch: Throwable -> L19
        voa.b r5 = new voa.b(r10, 2, e);     // Catch: Throwable -> L26
        bpa.a.d(r4, 1, r0);
        return r5;
    L26:
        th = th;
    L29:
        bpa.a.d(r4, r2, r0);
        throw th;
    L19:
        th = th;
        r2 = 0;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L33
    L40:
        return new voa.b(r10, 1, null);
    L32:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    public static voa.a decryptArray(Context r8, byte[] r9, byte[] r10) {
        if (TextUtils.isEmpty(appInfo.e) == false) goto L7;
        new Exception("UID is not found");
        return new voa.a();
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L42;
        if (d.a().cryptoSetting.disable_crypto == true) goto L49;
        JSONObject r11 = new JSONObject();
        long r0 = System.currentTimeMillis();
        Key r2 = null;
        r11.put("SYMMETRIC", "DecryptString");     // Catch: JSONException -> L14
    L16:
        int r3 = 0;
        uoa.d r5 = new uoa.d(r9);     // Catch: Throwable -> L24 Exception -> L26
        if (Arrays.equals(r5.a, uoa.d.e) == false) goto L29;
        toa.d r12 = toa.d.h;     // Catch: Throwable -> L24 Exception -> L26
        long r6 = r5.b;     // Catch: Throwable -> L24 Exception -> L26
        r12.getClass();     // Catch: Throwable -> L24 Exception -> L26
        r2 = toa.d.h(r8, getAppInfo().e, Long.valueOf(r6));     // Catch: Throwable -> L24 Exception -> L26
        if (r2 == null) goto L23;
    L31:
        Cipher r13 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Throwable -> L24 Exception -> L26
        r13.init(2, r2, new GCMParameterSpec(128, r5.c));     // Catch: Throwable -> L24 Exception -> L26
        r13.doFinal(r5.d);     // Catch: Throwable -> L24 Exception -> L26
        voa.a r14 = new voa.a();     // Catch: Throwable -> L24 Exception -> L26
        bpa.a.d(r0, 0, r11);
        return r14;
    L23:
        throw new KeyStoreException("null key returned");     // Catch: Throwable -> L24 Exception -> L26
    L29:
        if (Arrays.equals(r5.a, uoa.d.f) == false) goto L31;
        toa.d r15 = toa.d.h;     // Catch: Throwable -> L24 Exception -> L26
        long r7 = r5.b;     // Catch: Throwable -> L24 Exception -> L26
        r15.getClass();     // Catch: Throwable -> L24 Exception -> L26
        r2 = toa.d.b(r8, r7);     // Catch: Throwable -> L24 Exception -> L26
    L26:
        e = move-exception;
        HashMap r16 = new HashMap();     // Catch: Throwable -> L24
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L24
        r16.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L24
        xoa.a.a(e, "AES decryption exception", r16);     // Catch: Throwable -> L24
        voa.a r17 = new voa.a();     // Catch: Throwable -> L37
        bpa.a.d(r0, 2, r11);
        return r17;
    L37:
        th = th;
        r3 = 2;
    L39:
        bpa.a.d(r0, r3, r11);
        throw th;
    L24:
        th = th;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L16
    L49:
        return new voa.a();
    L42:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    public static voa.b decryptString(Context r10, String r11, String r12) {
        int r1 = 2;
        if (TextUtils.isEmpty(appInfo.e) == false) goto L7;
        return new voa.b(r12, 2, new Exception("UID is not found"));
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L44;
        if (d.a().cryptoSetting.disable_crypto == true) goto L51;
        JSONObject r0 = new JSONObject();
        long r3 = System.currentTimeMillis();
        r0.put("SYMMETRIC", "DecryptString");     // Catch: JSONException -> L14
    L50:
        uoa.d r6 = new uoa.d(r11);     // Catch: Exception -> L24 Throwable -> L32
        if (Arrays.equals(r6.a, uoa.d.e) == false) goto L27;
        toa.d r13 = toa.d.h;     // Catch: Exception -> L24 Throwable -> L32
        long r7 = r6.b;     // Catch: Exception -> L24 Throwable -> L32
        r13.getClass();     // Catch: Exception -> L24 Throwable -> L32
        Key r14 = toa.d.h(r10, getAppInfo().e, Long.valueOf(r7));     // Catch: Exception -> L24 Throwable -> L32
        if (r14 == null) goto L23;
    L30:
        Cipher r15 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L24 Throwable -> L32
        r15.init(2, r14, new GCMParameterSpec(128, r6.c));     // Catch: Exception -> L24 Throwable -> L32
        voa.b r16 = new voa.b(new String(r15.doFinal(r6.d)), 0, null);     // Catch: Exception -> L24 Throwable -> L32
        bpa.a.d(r3, 0, r0);
        return r16;
    L23:
        throw new KeyStoreException("null key returned");     // Catch: Exception -> L24 Throwable -> L32
    L27:
        if (Arrays.equals(r6.a, uoa.d.f) == false) goto L29;
        toa.d r17 = toa.d.h;     // Catch: Exception -> L24 Throwable -> L32
        long r8 = r6.b;     // Catch: Exception -> L24 Throwable -> L32
        r17.getClass();     // Catch: Exception -> L24 Throwable -> L32
        r14 = toa.d.b(r10, r8);     // Catch: Exception -> L24 Throwable -> L32
        goto L30
    L29:
        r14 = null;
    L24:
        e = move-exception;
        HashMap r18 = new HashMap();     // Catch: Throwable -> L32
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L32
        r18.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L32
        xoa.a.a(e, "AES decryption exception", r18);     // Catch: Throwable -> L32
        voa.b r19 = new voa.b(r12, 2, e);     // Catch: Throwable -> L38
        bpa.a.d(r3, 2, r0);
        return r19;
    L38:
        th = th;
    L41:
        bpa.a.d(r3, r1, r0);
        throw th;
    L32:
        th = th;
        r1 = 0;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L50
    L51:
        return new voa.b(r11, 1, null);
    L44:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized void init(Application r20, final a r21, f r22, NetworkClient r23, h r24, xoa.b r25, soa.b r26, apa.b r27) {
        monitor-enter(AzerothPrivacy.class);
    L159:
        th = move-exception;
        throw th;
    L5:
        if (hasInitiated == false) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return;
    L8:
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L159
        app = r20;     // Catch: Throwable -> L82 Exception -> L86
        appContext = r20.getApplicationContext();     // Catch: Throwable -> L82 Exception -> L86
        appInfo = r21;     // Catch: Throwable -> L82 Exception -> L86
        sdkConfig = r22;     // Catch: Throwable -> L82 Exception -> L86
        apa.a.a = r27;     // Catch: Throwable -> L82 Exception -> L86
        fpa.d.a = r23;     // Catch: Throwable -> L82 Exception -> L86
        d.a = r24;     // Catch: Throwable -> L82 Exception -> L86
        xoa.a.a = r25;     // Catch: Throwable -> L82 Exception -> L86
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L82 Exception -> L86
        long r7 = r5 - r3;
        bpa.a.a(appContext);     // Catch: Throwable -> L78 Exception -> L80
        long r9 = System.currentTimeMillis();     // Catch: Throwable -> L78 Exception -> L80
        long r6 = r9 - r5;
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L72 Exception -> L76
        long r10 = r11 - r9;
        Context r0 = appContext;     // Catch: Throwable -> L68 Exception -> L70
        ColdBootDelayExecutor r13 = new ColdBootDelayExecutor();     // Catch: Throwable -> L68 Exception -> L70
        qoa.b.a(r0, r13);     // Catch: Throwable -> L68 Exception -> L70
        qoa.b.b(r0, r13);     // Catch: Throwable -> L68 Exception -> L70
        qoa.b.a(appContext, new KeyAgreementUpdater());     // Catch: Throwable -> L68 Exception -> L70
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L68 Exception -> L70
        long r12 = r14 - r11;
        if (TextUtils.isEmpty(r21.e) == false) goto L189;
    L22:
        long r15 = System.currentTimeMillis() - r14;
        initAsync();     // Catch: Throwable -> L56 Exception -> L58
        hasInitiated = true;     // Catch: Throwable -> L56 Exception -> L58
        if (apa.a.a == null) goto L28;
        apa.a.a.i("Azeroth SDK inited");     // Catch: Throwable -> L56 Exception -> L58
    L28:
        long r1 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L159
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L159
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L159
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L159
        r4.put("running_status", 1);     // Catch: JSONException -> L51 Throwable -> L159
        r8.put("running_time", r1);     // Catch: JSONException -> L51 Throwable -> L159
        if (r7 == (-1)) goto L34;
        r8.put("runningTimeSetAttr", r7);     // Catch: JSONException -> L51 Throwable -> L159
    L34:
        if (r6 == (-1)) goto L37;
        r8.put("runningTimeMonitorInit", r6);     // Catch: JSONException -> L51 Throwable -> L159
    L37:
        if (r10 == (-1)) goto L40;
        r8.put("runningTimePLOInit", r10);     // Catch: JSONException -> L51 Throwable -> L159
    L40:
        if (r12 == (-1)) goto L43;
        r8.put("runningTimeSetAlarm", r12);     // Catch: JSONException -> L51 Throwable -> L159
    L43:
        if (r15 == (-1)) goto L45;
        r8.put("runningTimeSessionKeyInit", r15);     // Catch: JSONException -> L51 Throwable -> L159
    L45:
        JSONObject r17 = r16;
        r17.put("user_id", r21.e);     // Catch: JSONException -> L49 Throwable -> L159
        epa.a.b(getAppContext()).getClass();     // Catch: JSONException -> L49 Throwable -> L159
        r17.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L49 Throwable -> L159
    L54:
        String r2 = "sdk_init";
        JSONObject r18 = r17;
    L176:
        bpa.a.b(r2, r4, r8, r18);     // Catch: Exception -> L123 Throwable -> L159
    L125:
        monitor-exit(AzerothPrivacy.class);
        return;
    L123:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
    L49:
        e = e;
    L53:
        e.printStackTrace();     // Catch: Throwable -> L159
    L51:
        e = e;
        r17 = r16;
    L58:
        e = e;
    L174:
        e.printStackTrace();     // Catch: Throwable -> L131
        HashMap r19 = new HashMap();     // Catch: Throwable -> L131
        long r28 = r15;
        r19.put("app_info", r21.toString());     // Catch: Throwable -> L127
        if (r24 != null) goto L162;
    L99:
        xoa.a.a(e, "sdk init exception", r19);     // Catch: Throwable -> L127
        long r29 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L159
        r4 = new JSONObject();     // Catch: Throwable -> L159
        r8 = new JSONObject();     // Catch: Throwable -> L159
        r18 = new JSONObject();     // Catch: Throwable -> L159
        r4.put("running_status", 2);     // Catch: JSONException -> L118 Throwable -> L159
        r8.put("running_time", r29);     // Catch: JSONException -> L118 Throwable -> L159
        if (r7 == (-1)) goto L105;
        r8.put("runningTimeSetAttr", r7);     // Catch: JSONException -> L118 Throwable -> L159
    L105:
        if (r6 == (-1)) goto L108;
        r8.put("runningTimeMonitorInit", r6);     // Catch: JSONException -> L118 Throwable -> L159
    L108:
        if (r10 == (-1)) goto L111;
        r8.put("runningTimePLOInit", r10);     // Catch: JSONException -> L118 Throwable -> L159
    L111:
        if (r12 == (-1)) goto L114;
        r8.put("runningTimeSetAlarm", r12);     // Catch: JSONException -> L118 Throwable -> L159
    L114:
        if (r28 == (-1)) goto L116;
        r8.put("runningTimeSessionKeyInit", r28);     // Catch: JSONException -> L118 Throwable -> L159
    L116:
        r18.put("user_id", r21.e);     // Catch: JSONException -> L118 Throwable -> L159
        epa.a.b(getAppContext()).getClass();     // Catch: JSONException -> L118 Throwable -> L159
        r18.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L118 Throwable -> L159
    L120:
        r2 = "sdk_init";
        goto L176
    L118:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
        goto L120
    L162:
        com.larus.security.api.a r30 = (com.larus.security.api.a) r24;     // Catch: Throwable -> L97
        r30.a();     // Catch: Throwable -> L97
        r19.put("settings", r30.a().toString());     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        long r110 = r12;
        int r111 = 2;
        long r112 = r10;
        long r31 = r7;
        long r32 = r6;
        Throwable r33 = th;
        long r34 = r28;
    L134:
        long r35 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L159
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L159
        Throwable r210 = r33;
        JSONObject r36 = new JSONObject();     // Catch: Throwable -> L159
        long r211 = r34;
        JSONObject r37 = new JSONObject();     // Catch: Throwable -> L159
        r113.put("running_status", r111);     // Catch: JSONException -> L152 Throwable -> L159
        r36.put("running_time", r35);     // Catch: JSONException -> L152 Throwable -> L159
        if (r31 == (-1)) goto L139;
        r36.put("runningTimeSetAttr", r31);     // Catch: JSONException -> L152 Throwable -> L159
    L139:
        if (r32 == (-1)) goto L142;
        r36.put("runningTimeMonitorInit", r32);     // Catch: JSONException -> L152 Throwable -> L159
    L142:
        if (r112 == (-1)) goto L145;
        r36.put("runningTimePLOInit", r112);     // Catch: JSONException -> L152 Throwable -> L159
    L145:
        if (r110 == (-1)) goto L148;
        r36.put("runningTimeSetAlarm", r110);     // Catch: JSONException -> L152 Throwable -> L159
    L148:
        if (r211 == (-1)) goto L150;
        r36.put("runningTimeSessionKeyInit", r211);     // Catch: JSONException -> L152 Throwable -> L159
    L150:
        r37.put("user_id", r21.e);     // Catch: JSONException -> L152 Throwable -> L159
        epa.a.b(getAppContext()).getClass();     // Catch: JSONException -> L152 Throwable -> L159
        r37.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L152 Throwable -> L159
    L166:
        bpa.a.b("sdk_init", r113, r36, r37);     // Catch: Exception -> L156 Throwable -> L159
    L195:
        throw r210;     // Catch: Throwable -> L159
    L156:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
        throw r210;     // Catch: Throwable -> L159
    L152:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
    L127:
        Throwable th = th;
        r15 = r28;
    L132:
        r111 = 2;
    L133:
        long r114 = r6;
        r33 = th;
        r34 = r15;
        r110 = r12;
        r112 = r10;
        r31 = r7;
        r32 = r114;
    L131:
        th = th;
    L56:
        th = th;
        r111 = 1;
        goto L133
    L62:
        e = e;
    L67:
        r15 = -1;
    L60:
        th = th;
    L75:
        long r115 = -1;
    L85:
        r110 = r12;
        r112 = r10;
        r31 = r7;
        r32 = r6;
        r33 = th;
        r34 = r115;
        r111 = 1;
        goto L134
    L189:
        if (r21.e.equals("0") == true) goto L22;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(r21), "zerothPrivacy"));     // Catch: Throwable -> L60 Exception -> L62
        goto L22
    L66:
        e = e;
    L64:
        th = th;
        goto L75
    L70:
        e = e;
    L89:
        r15 = -1;
        r12 = -1;
    L68:
        th = th;
    L74:
        r12 = -1;
        goto L75
    L76:
        e = e;
    L88:
        r10 = -1;
    L72:
        th = th;
        r10 = -1;
        goto L74
    L80:
        e = e;
        r6 = -1;
    L78:
        th = th;
    L84:
        r115 = -1;
        r6 = -1;
        r10 = -1;
        r12 = -1;
        goto L85
    L86:
        e = e;
        r6 = -1;
        r7 = -1;
    L82:
        th = th;
        r7 = -1;
        goto L84
    }
}
