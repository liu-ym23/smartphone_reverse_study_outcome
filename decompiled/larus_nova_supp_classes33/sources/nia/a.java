package nia;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.crypto.nativelib.CryptoManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.account.base.api.ILoginService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.audio.enroll.sidauth.j;
import com.obric.audio.enroll.sidauth.k;
import com.obric.audio.enroll.sidauth.l;
import f06.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
import sia.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;
    public static volatile boolean b;
    public static Context c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static volatile JSONObject j;
    public static volatile b k;
    public static volatile long l;
    public static volatile C0064a m;
    public static volatile long n;

    /* JADX INFO: renamed from: nia.a$a, reason: collision with other inner class name */
    public static final class C0064a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final boolean f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0064a) == true) goto L8;
            return false;
        L8:
            C0064a r6 = (C0064a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            if (this.f == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "AuthModelSnapshot(modelPath=" + this.a + ", keyInfoPath=" + this.b + ", rawFileMd5=" + this.c + ", modelVersion=" + this.d + ", qnnLibDir=" + this.e + ", authReady=" + this.f + ')';
        }

        public C0064a(String r2, String r3, String r4, String r5, String r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "modelPath");
            Intrinsics.checkNotNullParameter(r3, "keyInfoPath");
            Intrinsics.checkNotNullParameter(r4, "rawFileMd5");
            Intrinsics.checkNotNullParameter(r5, "modelVersion");
            Intrinsics.checkNotNullParameter(r6, "qnnLibDir");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "SidModelSnapshot(modelPath=" + this.a + ", keyInfoPath=" + this.b + ", rawFileMd5=" + this.c + ", fromWakeupProcess=" + this.d + ')';
        }

        public b(String r2, String r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "modelPath");
            Intrinsics.checkNotNullParameter(r3, "keyInfoPath");
            Intrinsics.checkNotNullParameter(r4, "rawFileMd5");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public a() {
    }

    static {
        a = new a();
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        i = "";
    }

    public static boolean b() {
        String r0 = l.a;
        a.getClass();
        String r1 = l().e;
        boolean r3 = true;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        FLogger.a.w("SidAuthQnnRuntime", "ensureLoaded skip: qnnDir empty");
    L11:
        return false;
    L9:
        if (new PolarisFileWrapper(r1).isDirectory() == true) goto L13;
        FLogger.a.w("SidAuthQnnRuntime", "ensureLoaded qnnDir not a directory: ".concat(r1));
        goto L11
    L13:
        if (Intrinsics.areEqual(l.a, r1) == true) goto L32;
        Object r4 = l.b;
        monitor-enter(r4);
    L26:
        th = move-exception;
        throw th;
    L18:
        if (Intrinsics.areEqual(l.a, r1) == true) goto L24;
        com.obric.assistant.common.utils.b r5 = com.obric.assistant.common.utils.b.a;     // Catch: Throwable -> L26
        Function1 r6 = new j();     // Catch: Throwable -> L26
        Function1 r7 = new k();     // Catch: Throwable -> L26
        r5.getClass();     // Catch: Throwable -> L26
        if (com.obric.assistant.common.utils.b.a(r1, r6, r7) == true) goto L23;
        r3 = false;
        goto L24
    L23:
        l.a = r1;     // Catch: Throwable -> L26
        FLogger.a.i("SidAuthQnnRuntime", "ensureLoaded path ready qnnDir=".concat(r1));     // Catch: Throwable -> L26
    L24:
        monitor-exit(r4);
        return r3;
    L32:
        return true;
    L5:
        r2 = false;
        goto L6
    }

    public static String d() {
        return ObricEnrollInteropDelegate.b.c();
    }

    public static String f() {
        AccountService r0 = AccountService.a;
        if (r0.isLogin().booleanValue() == false) goto L5;
        Map r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("proto-version", "v2"), TuplesKt.to("Passport-Auth", "session"), TuplesKt.to("sdk-version", "2"), TuplesKt.to("X-tt-Token", String.valueOf(r0.getXTTToken()))});
    L6:
        JSONObject r2 = new JSONObject();
        Iterator r3 = r1.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        Map.Entry r4 = (Map.Entry) r3.next();
        r2.put((String) r4.getKey(), (String) r4.getValue());
        goto L8
    L11:
        return r2.toString();
    L5:
        r1 = MapsKt.emptyMap();
        goto L6
    }

    public static String g() {
        return ILoginService.a.getAccountInfo().c;
    }

    public static b j() {
        if (c != null) goto L5;
        return null;
    L5:
        Bundle r0 = k("loadWakeupSidModelSnapshot");
        if (r0 != null) goto L9;
        return null;
    L9:
        if (r0.getBoolean("ready", false) == true) goto L11;
        return null;
    L11:
        String r3 = r0.getString("sidModelPath");
        String r4 = "";
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r5 = r0.getString("sidKeyInfoPath");
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r1 = r0.getString("sidRawFileMd5");
        if (r1 == null) goto L21;
        r4 = r1;
    L21:
        b r2 = new b(r3, r5, r4, true);
        a.getClass();
        if (h(r2, true) == true) goto L24;
        return null;
    L24:
        return r2;
    }

    public static C0064a l() {
        long r0 = SystemClock.elapsedRealtime();
        C0064a r2 = m;
        C0064a r4 = null;
        if (r2 == null) goto L14;
        if ((r0 - n) >= 1000) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L14;
        return r2;
    L7:
        r5 = false;
    L14:
        if (c == null) goto L49;
        Bundle r3 = k("loadWakeupAuthModelSnapshot");
        if (r3 == null) goto L49;
        boolean r11 = r3.getBoolean("authReady", false);
        String r6 = r3.getString("qnnLibDir");
        if (r6 != null) goto L22;
        String r10 = "";
    L24:
        if (r11 == false) goto L29;
        String r7 = r3.getString("authModelPath");
        if (r7 == null) goto L29;
        String r8 = r7;
    L30:
        if (r11 == false) goto L35;
        String r9 = r3.getString("authKeyInfoPath");
        if (r9 == null) goto L35;
        String r12 = r9;
    L36:
        if (r11 == false) goto L41;
        String r13 = r3.getString("authRawFileMd5");
        if (r13 == null) goto L41;
        String r14 = r13;
    L42:
        if (r11 == false) goto L47;
        String r15 = r3.getString("authModelVersion");
        if (r15 == null) goto L47;
        String r16 = r15;
    L48:
        r4 = new C0064a(r8, r12, r14, r16, r10, r11);
    L47:
        r16 = "";
    L41:
        r14 = "";
    L35:
        r12 = "";
    L29:
        r8 = "";
        goto L30
    L22:
        r10 = r6;
    L49:
        if (r4 != null) goto L51;
        r4 = new C0064a("", "", "", "", "", false);
    L51:
        FLogger.a.i("EnrollGlobal", "resolveAuthModelSnapshot auth=" + r4.a + " authKey=" + r4.b + " authReady=" + r4.f + " qnnDir=" + r4.e + " authRawMd5Len=" + r4.c.length());
        m = r4;
        n = r0;
        return r4;
    }

    public static b m() {
        long r0 = SystemClock.elapsedRealtime();
        b r2 = k;
        String r3 = null;
        boolean r4 = true;
        if (r2 != null) goto L5;
    L15:
        JSONObject r5 = j;
        if (r5 == null) goto L19;
    L39:
        String r7 = "kws_sid_model.bin";
        if (r5 == null) goto L51;
        String r8 = r5.optString("voiceprint-file");
        Intrinsics.checkNotNull(r8);
        if (r8.length() <= 0) goto L44;
        boolean r9 = true;
    L45:
        if (r9 == true) goto L48;
        r8 = null;
    L48:
        if (r8 == null) goto L51;
        r7 = r8;
        goto L51
    L44:
        r9 = false;
    L51:
        String r10 = "key_info_kws_sid_model.txt";
        if (r5 == null) goto L64;
        String r11 = r5.optString("voiceprint-key");
        Intrinsics.checkNotNull(r11);
        if (r11.length() <= 0) goto L56;
        boolean r12 = true;
    L57:
        if (r12 == true) goto L60;
        r11 = null;
    L60:
        if (r11 == null) goto L64;
        r10 = r11;
        goto L64
    L56:
        r12 = false;
    L64:
        if (d.length() != 0) goto L66;
        boolean r13 = true;
    L67:
        if (r13 == false) goto L69;
        String r14 = File.separator;
    L70:
        String r15 = r14 + r7;
        String r16 = r14 + r10;
        if (r5 == null) goto L73;
        r3 = r5.optString("voiceprint-rawfile-md5");
    L73:
        if (r3 != null) goto L75;
        r3 = "";
    L75:
        b r17 = new b(r15, r16, r3, false);
        if (d.length() == 0) goto L79;
        r4 = false;
    L79:
        if (r4 == false) goto L81;
        return r17;
    L81:
        b r6 = j();
        if (r6 == null) goto L85;
        r17 = r6;
    L85:
        FLogger.a.i("EnrollGlobal", "resolveSidModelSnapshot sid=" + r17.a + " sidKey=" + r17.b + " fromWakeup=" + r17.d + " sidRawMd5Len=" + r17.c.length());
        k = r17;
        l = r0;
        return r17;
    L69:
        r14 = d + File.separator;
        goto L70
    L66:
        r13 = false;
        goto L67
    L19:
        if (d.length() != 0) goto L21;
        boolean r18 = true;
    L22:
        if (r18 == true) goto L27;
        PolarisFileWrapper r19 = new PolarisFileWrapper(d, "default_config.json");
        if (r19.isFile() == true) goto L87;
        FLogger.a.w("EnrollGlobal", "ensureDefaultModelConfig file not exist: " + r19.getAbsolutePath());
        goto L27
    L87:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r21 = new JSONObject(FilesKt.readText(r19, Charsets.UTF_8));     // Catch: Throwable -> L30
        j = r21;     // Catch: Throwable -> L30
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L30
    L32:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L36;
        FLogger.a.e("EnrollGlobal", "ensureDefaultModelConfig parse failed: " + r23.getMessage());
    L36:
        if (Result.isFailure-impl(r22) == false) goto L38;
        r22 = null;
    L38:
        r5 = (JSONObject) r22;
    L30:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        r5 = null;
        goto L39
    L21:
        r18 = false;
        goto L22
    L5:
        if ((r0 - l) >= 1000) goto L9;
        a.getClass();
        if (h(r2, false) == false) goto L9;
        boolean r25 = true;
    L10:
        if (r25 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        return r2;
    L9:
        r25 = false;
        goto L10
    }

    public static boolean c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "purpose");
        b r0 = j();
        if (r0 != null) goto L6;
        FLogger.a.e("EnrollGlobal", "ensureWakeupSidModelSnapshotReady failed purpose=" + r5 + ": wakeup sid snapshot unavailable");
        return false;
    L6:
        long r2 = SystemClock.elapsedRealtime();
        k = r0;
        l = r2;
        FLogger.a.i("EnrollGlobal", "ensureWakeupSidModelSnapshotReady success purpose=" + r5 + " sid=" + r0.a + " sidKey=" + r0.b + " sidRawMd5Len=" + r0.c.length());
        return true;
    }

    public static String e(String r7) {
        Intrinsics.checkNotNullParameter(r7, "filePath");
        JSONObject r4 = new JSONObject(FilesKt.readText$default(new PolarisFileWrapper(r7), null, 1, null));     // Catch: Exception -> L13
        String r3 = ObricFeatureServiceDelegate.b.d();     // Catch: Exception -> L13
        FLogger.a.i("EnrollGlobal", "productName = " + r3);     // Catch: Exception -> L13
        JSONObject r2 = r4.optJSONObject(r3);     // Catch: Exception -> L13
        if (r2 == null) goto L18;
        String r8 = r2.toString();     // Catch: Exception -> L13
        if (r8 != null) goto L20;
        return "";
    L20:
        return r8;
    L18:
        return "";
    L13:
        e = move-exception;
        FLogger.a.e("EnrollGlobal", "解析keyinfo密钥信息JSON失败，路径：" + r7, e);
        return "";
    L10:
        e = move-exception;
        FLogger.a.e("EnrollGlobal", "读取keyinfo密钥信息文件失败，路径：" + r7, e);     // Catch: Exception -> L13
        return "";
    }

    public static Bundle k(String r5) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L33
        Context r2 = c;     // Catch: Throwable -> L33
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");     // Catch: Throwable -> L33
        r2 = null;
    L7:
        ContentProviderClient r3 = a(r2.getContentResolver(), com.obric.assistant.voice.k.a);     // Catch: Throwable -> L33
        if (r3 == null) goto L32;
        Bundle r4 = r3.call("sva-get-effective-model-snapshot", null, null);     // Catch: Throwable -> L21
    L49:
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L33
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
    L19:
        Object r7 = Result.constructor-impl(r4);     // Catch: Throwable -> L33
    L35:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L39;
        FLogger.a.w("EnrollGlobal", r5 + " IPC failed: " + r8.getMessage());
    L39:
        if (Result.isFailure-impl(r7) == true) goto L43;
        r0 = r7;
    L43:
        return (Bundle) r0;
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        r3.close();     // Catch: Throwable -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Result.constructor-impl(r9);     // Catch: Throwable -> L17
    L14:
        r9 = Boolean.valueOf(r3.release());     // Catch: Throwable -> L17
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L28
        if (Build.VERSION.SDK_INT < 24) goto L25;
        r3.close();     // Catch: Throwable -> L28
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L26:
        Result.constructor-impl(r11);     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L33
    L25:
        r11 = Boolean.valueOf(r3.release());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L30
    L32:
        throw new IllegalStateException("SVA interactor provider is unavailable".toString());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }

    public final void i(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if (b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L7:
        if (b == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        Context r9 = r8.getApplicationContext();     // Catch: Throwable -> L32
        c = r9;     // Catch: Throwable -> L32
        CryptoManager.getInstance().init(r9);     // Catch: Throwable -> L32
        LocalDataCrypto.getInstance().init(r9);     // Catch: Throwable -> L32
        FLogger r3 = FLogger.a;     // Catch: Throwable -> L32
        r3.i("EnrollGlobal", "CryptoManager init");     // Catch: Throwable -> L32
        String r4 = null;
        File r5 = r9.getExternalFilesDir(null);     // Catch: Throwable -> L32
        if (r5 == null) goto L14;
        String r6 = r5.getAbsolutePath();     // Catch: Throwable -> L32
        if (r6 == null) goto L14;
    L15:
        d = r6;     // Catch: Throwable -> L32
        e = d + "/enroll";     // Catch: Throwable -> L32
        f = e + "/wakeup_sid";     // Catch: Throwable -> L32
        File r10 = r9.getFilesDir();     // Catch: Throwable -> L32
        if (r10 == null) goto L20;
        File r11 = r10.getParentFile();     // Catch: Throwable -> L32
        if (r11 == null) goto L20;
        r4 = r11.getAbsolutePath();     // Catch: Throwable -> L32
    L20:
        if (r4 != null) goto L23;
        r4 = "";
    L23:
        if (r4.length() <= 0) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L28;
        String r13 = r4.concat("/voiceprint_db");     // Catch: Throwable -> L32
        c.a(r13);     // Catch: Throwable -> L32
        String r14 = r13.concat("/voice_print.db");     // Catch: Throwable -> L32
    L29:
        g = r14;     // Catch: Throwable -> L32
        c.a(d);     // Catch: Throwable -> L32
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L32
        r15.append(d);     // Catch: Throwable -> L32
        String r1 = File.separator;     // Catch: Throwable -> L32
        r15.append(r1);     // Catch: Throwable -> L32
        r15.append("kws_silence_5s_use.wav");     // Catch: Throwable -> L32
        i = r15.toString();     // Catch: Throwable -> L32
        h = d + r1 + "lp_engine_res_cpu.bin";     // Catch: Throwable -> L32
        r3.i("Global", "PATH_SPEECH_SM_MODEL_CPU=" + h + " PATH_SPEECH_SILENCE_AUDIO_FILE=" + i);     // Catch: Throwable -> L32
        b = true;     // Catch: Throwable -> L32
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L28:
        r14 = "";
        goto L29
    L25:
        r12 = false;
    L14:
        r6 = "";
        goto L15
    }

    public static ContentProviderClient a(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static boolean h(b r12, boolean r13) {
        List r14 = CollectionsKt.listOf(new String[]{r12.a, r12.b});
        ArrayList r0 = new ArrayList();
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L18;
        Object r3 = r15.next();
        String r4 = (String) r3;
        if (r4.length() != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L4;
        r0.add(r3);
        goto L4
    L11:
        if (new PolarisFileWrapper(r4).isFile() == false) goto L14;
        r6 = false;
        goto L15
    L8:
        r5 = false;
        goto L9
    L18:
        if ((!r0.isEmpty()) == false) goto L22;
        if (r13 == false) goto L22;
        FLogger.a.w("EnrollGlobal", "wakeup sid model snapshot has missing files: " + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null));
    L22:
        return r0.isEmpty();
    }
}
