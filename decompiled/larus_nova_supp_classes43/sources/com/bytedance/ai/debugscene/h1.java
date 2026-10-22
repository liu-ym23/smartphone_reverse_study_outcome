package com.bytedance.ai.debugscene;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.debug.IAISDKDebugService$a;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.net.AIRealDeviceDebugVerifyResponseData;
import com.bytedance.debugrouter.DebugRouter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h1 {
    public static final h1 a = null;
    public static volatile boolean b;
    public static volatile boolean c;
    public static volatile String d;
    public static volatile IAISDKDebugService$a e;
    public static volatile boolean f;
    public static volatile AppletDebugTool g;
    public static final Handler h = null;
    public static final Object i = null;
    public static e j;
    public static long k;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ai.debugscene.h1$a$a, reason: collision with other inner class name */
        public static final class C0038a extends a {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0038a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0038a) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Rejected(message=" + this.a + ')';
            }

            public C0038a(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        public static final class b extends a {
            public final long a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof b) == true) goto L9;
                return false;
            L9:
                if (this.a == ((b) r10).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                return (int) (r0 ^ (r0 >>> 32));
            }

            public final String toString() {
                return "Started(openRequestId=" + this.a + ')';
            }

            public b(long r1) {
                this.a = r1;
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Failure(message=" + this.a + ')';
            }

            public a(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.debugscene.h1$b$b, reason: collision with other inner class name */
        public static final class C0039b extends b {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0039b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0039b) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Success(debugContext=" + this.a + ')';
            }

            public C0039b(String r10) {
                Intrinsics.checkNotNullParameter(r10, "debugContext");
                this.a = r10;
            }
        }

        public b() {
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final String e;
        public final boolean f;
        public final String g;
        public final boolean h;
        public final String i;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r11.h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r11.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            int r10 = 1231;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r11 = (r0 + r1) * 31;
            String r12 = this.e;
            int r13 = 0;
            if (r12 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r11 + r14) * 31;
            if (this.f == false) goto L13;
            int r16 = 1231;
        L14:
            int r17 = (r15 + r16) * 31;
            String r18 = this.g;
            if (r18 != null) goto L17;
            int r19 = 0;
        L18:
            int r20 = (r17 + r19) * 31;
            if (this.h == true) goto L22;
            r10 = 1237;
        L22:
            int r21 = (r20 + r10) * 31;
            String r22 = this.i;
            if (r22 == null) goto L27;
            r13 = r22.hashCode();
        L27:
            return r21 + r13;
        L17:
            r19 = r18.hashCode();
            goto L18
        L13:
            r16 = 1237;
            goto L14
        L9:
            r14 = r12.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "DebugPackageInfo(packageName=" + this.a + ", hostUrl=" + this.b + ", appletType=" + this.c + ", isSigned=" + this.d + ", signVersion=" + this.e + ", isEncrypted=" + this.f + ", versionTag=" + this.g + ", showDebugTag=" + this.h + ", wifiConnectUrl=" + this.i + ')';
        }

        public c(String r10, String r11, String r12, boolean r13, String r14, boolean r15, String r16, boolean r17, String r18) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, "hostUrl");
            Intrinsics.checkNotNullParameter(r12, "appletType");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Failure(message=" + this.a + ')';
            }

            public a(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        public static final class b extends d {
            public final c a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Success(packageInfo=" + this.a + ')';
            }

            public b(c r10) {
                Intrinsics.checkNotNullParameter(r10, "packageInfo");
                this.a = r10;
            }
        }

        public d() {
        }
    }

    public static final class e {
        public final Function0<Unit> a;
        public final Function1<Throwable, Unit> b;
        public final Runnable c;
        public final long d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof e) == true) goto L8;
            return false;
        L8:
            e r11 = (e) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            long r1 = this.d;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "PendingDebugChannelOpenRequest(resolve=" + this.a + ", reject=" + this.b + ", timeoutRunnable=" + this.c + ", openRequestId=" + this.d + ')';
        }

        public e(a1 r10, b1 r11, c1 r12, long r13) {
            Intrinsics.checkNotNullParameter(r10, "resolve");
            Intrinsics.checkNotNullParameter(r11, "reject");
            Intrinsics.checkNotNullParameter(r12, "timeoutRunnable");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public h1() {
    }

    static {
        a = new h1();
        h = new Handler(Looper.getMainLooper());
        i = new Object();
    }

    public static void b() {
        Object r0 = i;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (c == false) goto L7;
        c = false;     // Catch: Throwable -> L10
        k++;     // Catch: Throwable -> L10
    L7:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public static void g() {
        Object r0 = i;
        monitor-enter(r0);
        e r1 = j;     // Catch: Throwable -> L16
        if (r1 == null) goto L10;
        j = null;     // Catch: Throwable -> L16
        h.removeCallbacks(r1.c);     // Catch: Throwable -> L16
        b = true;     // Catch: Throwable -> L16
        if (k != r1.d) goto L11;
        c = false;     // Catch: Throwable -> L16
    L11:
        monitor-exit(r0);
        if (r1 != null) goto L14;
        return;
    L14:
        r1.a.invoke();
        return;
    L10:
        r1 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public static JSONObject d(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r10) == false) goto L10;
        r10 = null;
    L10:
        return (JSONObject) r10;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void e(String r1) {
        if (g != null) goto L5;
        return;
    L5:
        AppletDebugTool.c();
        if ((!StringsKt.isBlank(r1)) == false) goto L8;
        AppletDebugTool.k(r1);
        return;
    L8:
        AIDebugManager.a.getClass();
        Iterator r10 = AIDebugManager.c().iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        AppletDebugTool.k((String) r10.next());
        goto L10
    }

    public static String f(Integer r10) {
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L10;
    L12:
        if (r10 != null) goto L15;
    L17:
        if (r10 != null) goto L20;
    L22:
        return null;
    L20:
        if (r10.intValue() != 7) goto L22;
        return "token app_key 校验失败";
    L15:
        if (r10.intValue() != 6) goto L17;
        return "token 过期";
    L10:
        if (r10.intValue() != 5) goto L12;
        return "token 校验失败";
    L5:
        if (r10.intValue() != 4) goto L7;
        return "未命中任何白名单";
    }

    public static String h(String r1) {
        if (r1 == null) goto L13;
        String r10 = StringsKt.trim(r1).toString();
        if (r10 == null) goto L13;
        String r11 = StringsKt.trim(r10, new char[]{'`', '\"'});
        if (r11 == null) goto L13;
        if (r11.length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return r11;
    L10:
        r0 = false;
    L13:
        return null;
    }

    public static void l(Long r10) {
        Object r0 = i;
        monitor-enter(r0);
        if (r10 != null) goto L14;
    L7:
        c = false;     // Catch: Throwable -> L11
    L8:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        if (k != r10.longValue()) goto L8;
        goto L7
    }

    public static void c(Throwable r10, Long r11) {
        Object r0 = i;
        monitor-enter(r0);
        e r1 = j;     // Catch: Throwable -> L23
        if (r1 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        if (r11 == null) goto L15;
        if (r1.d == r11.longValue()) goto L15;
        monitor-exit(r0);
        return;
    L15:
        j = null;     // Catch: Throwable -> L23
        h.removeCallbacks(r1.c);     // Catch: Throwable -> L23
        if (r11 != null) goto L18;
    L19:
        c = false;     // Catch: Throwable -> L23
    L20:
        monitor-exit(r0);
        r1.b.invoke(r10);
        return;
    L18:
        if (k != r1.d) goto L20;
    L23:
        th = move-exception;
        throw th;
    }

    public static void i(String r10, boolean r11, String r12) {
        JSONObject r0 = new JSONObject();
        r0.put("packageName", r10);
        r0.put("success", r11);
        r0.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r12);
        m("Applet_InstallResult", r0.toString(), -1);
    }

    public static b k(String r10, String r11, String r12) {
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L50
        OpenPlatformBaseResponse r14 = o5.c.a(r10, r11, r12);     // Catch: Throwable -> L50
        boolean r15 = false;
        if (r14.getCode() != 0) goto L7;
        boolean r16 = true;
    L8:
        Integer r17 = null;
        String r18 = null;
        r18 = null;
        if (r16 == true) goto L21;
        com.bytedance.ai.utils.g.a.e("AppletDebugTool", "verify debug channel failed, code: " + r14.getCode() + ", message: " + r14.getMessage() + ", logId: " + r14.getLogId());     // Catch: Throwable -> L50
        int r19 = r14.getCode();     // Catch: Throwable -> L50
        String r20 = r14.getMessage();     // Catch: Throwable -> L50
        String r21 = f(Integer.valueOf(r19));     // Catch: Throwable -> L50
        if (r21 != null) goto L20;
        if (r20 != null) goto L14;
    L16:
        if (r18 != null) goto L18;
        r21 = "debug channel verification failed";
        goto L20
    L18:
        r21 = r18;
        goto L20
    L14:
        if ((!StringsKt.isBlank(r20)) == false) goto L16;
        r18 = r20;
    L20:
        return new b.a(r21);
    L21:
        AIRealDeviceDebugVerifyResponseData r22 = (AIRealDeviceDebugVerifyResponseData) r14.getData();     // Catch: Throwable -> L50
        if (r22 != null) goto L24;
    L26:
        if (r15 == true) goto L44;
        com.bytedance.ai.utils.g r23 = com.bytedance.ai.utils.g.a;     // Catch: Throwable -> L50
        StringBuilder r24 = new StringBuilder("verify debug channel denied, reason: ");     // Catch: Throwable -> L50
        if (r22 == null) goto L30;
        Integer r25 = r22.getReason();     // Catch: Throwable -> L50
    L31:
        r24.append(r25);     // Catch: Throwable -> L50
        r24.append(", logId: ");     // Catch: Throwable -> L50
        r24.append(r14.getLogId());     // Catch: Throwable -> L50
        r23.e("AppletDebugTool", r24.toString());     // Catch: Throwable -> L50
        if (r22 == null) goto L34;
        r17 = r22.getReason();     // Catch: Throwable -> L50
    L34:
        String r26 = f(r17);     // Catch: Throwable -> L50
        if (r26 != null) goto L43;
        StringBuilder r27 = new StringBuilder("debug channel verification denied, reason: ");     // Catch: Throwable -> L50
        if (r22 == null) goto L40;
        Object r28 = r22.getReason();     // Catch: Throwable -> L50
        if (r28 == null) goto L40;
    L41:
        r27.append(r28);     // Catch: Throwable -> L50
        r26 = r27.toString();     // Catch: Throwable -> L50
    L40:
        r28 = "unknown";
    L43:
        return new b.a(r26);
    L30:
        r25 = null;
        goto L31
    L44:
        String r29 = r22.getDebugContext();     // Catch: Throwable -> L50
        if (r29 == null) goto L47;
        Object r30 = new b.C0039b(r29);     // Catch: Throwable -> L50
    L48:
        Object r31 = Result.constructor-impl(r30);     // Catch: Throwable -> L50
    L52:
        Throwable r32 = Result.exceptionOrNull-impl(r31);
        if (r32 == null) goto L57;
        com.bytedance.ai.utils.g.a.e("AppletDebugTool", "verify debug channel exception: " + ExceptionsKt.stackTraceToString(r32));
        r31 = new b.a("debug channel verification request failed");
    L57:
        return (b) r31;
    L47:
        r30 = new b.a("invalid debug package info");     // Catch: Throwable -> L50
        goto L48
    L24:
        if (r22.getAllowed() != true) goto L26;
        r15 = true;
        goto L26
    L7:
        r16 = false;
    L50:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    }

    public static void m(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "type");
        if (f == true) goto L6;
        com.bytedance.ai.utils.g.a.w("AppletDebugTool", "skip sending message to devtools because debug router is not ready. type: ".concat(r10));
        return;
    L6:
        com.bytedance.ai.utils.g.a.i("AppletDebugTool", "sendMessageToDevtools. type: " + r10 + ", message: " + r11);
        DebugRouter.getInstance().sendDataAsync(r10, r12, r11);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.bytedance.ai.debugscene.a1] */
    public static final void a(h1 r10, final c r11, final long r12, final Function2 r13) {
        r10.getClass();
        ?? r14 = new a1(r11, r12, r13);
        AppletDebugTool r0 = g;
        if (r0 != null) goto L6;
    L16:
        j(r11, r12, r14, new b1(r12, r11, r13));
        return;
    L6:
        if (AppletDebugTool.f == true) goto L16;
        monitor-enter(AppletDebugTool.class);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (AppletDebugTool.f == false) goto L14;
        monitor-exit(AppletDebugTool.class);
        goto L16
    L14:
        com.bytedance.ai.utils.g.a.i("AppletDebugTool", "initDebugRouter, do initialize task for devtool");     // Catch: Throwable -> L18
        DebugRouter.getInstance().addGlobalHandler(r0);     // Catch: Throwable -> L18
        DebugRouter.getInstance().addSessionHandler(r0);     // Catch: Throwable -> L18
        DebugRouter r15 = DebugRouter.getInstance();     // Catch: Throwable -> L18
        LinkedHashMap r16 = new LinkedHashMap();     // Catch: Throwable -> L18
        r16.put("App", r0.a);     // Catch: Throwable -> L18
        r16.put("AppVersion", r0.b);     // Catch: Throwable -> L18
        r15.setAppInfo(r16);     // Catch: Throwable -> L18
        AppletDebugTool.f = true;     // Catch: Throwable -> L18
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(AppletDebugTool.class);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.ai.debugscene.c1, java.lang.Runnable] */
    public static void j(final c r15, final long r16, a1 r18, b1 r19) {
        ?? r10 = new c1(r15, r16);
        Object r13 = i;
        monitor-enter(r13);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (j == null) goto L10;
        r19.invoke(new IllegalStateException("debug router channel is opening"));     // Catch: Throwable -> L39
        monitor-exit(r13);
        return;
    L10:
        j = new e(r18, r19, r10, r16);     // Catch: Throwable -> L39
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(r13);
        h.postDelayed(r10, 30000);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        DebugRouter r14 = DebugRouter.getInstance();     // Catch: Throwable -> L33
        String r17 = r15.i;     // Catch: Throwable -> L33
        if (r17 != null) goto L16;
    L19:
        boolean r20 = true;
    L20:
        if (r20 == false) goto L23;
        r14.enableDebugChannel();     // Catch: Throwable -> L33
    L29:
        if (f == false) goto L31;
        com.bytedance.ai.utils.g.a.i("AppletDebugTool", "debug router connection already established, reuse existing Applet_Connected state");     // Catch: Throwable -> L33
        g();     // Catch: Throwable -> L33
    L31:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L45;
        com.bytedance.ai.utils.g.a.e("AppletDebugTool", "open debug router channel failed. packageName: " + r15.a + ", error: " + r1.getMessage());
        a.getClass();
        c(r1, null);
        return;
    L45:
        return;
    L23:
        if (r14.isValidSchema(r17) == true) goto L25;
        IllegalStateException r21 = new IllegalStateException("invalid wifi connect schema, please make sure it is valid and try again");     // Catch: Throwable -> L33
        com.bytedance.ai.utils.g.a.e("AppletDebugTool", "open debug router channel failed. packageName: " + r15.a + ", error: " + r21.getMessage());     // Catch: Throwable -> L33
        c(r21, Long.valueOf(r16));     // Catch: Throwable -> L33
        goto L31
    L25:
        com.bytedance.ai.utils.g r22 = com.bytedance.ai.utils.g.a;     // Catch: Throwable -> L33
        r22.i("AppletDebugTool", "wifi connect url: " + r17);     // Catch: Throwable -> L33
        if (r14.handleSchema(r17) == true) goto L29;
        IllegalStateException r23 = new IllegalStateException("fail to handle wifi connect schema, please scan again to restart the debug flow");     // Catch: Throwable -> L33
        r22.e("AppletDebugTool", "open debug router channel failed. packageName: " + r15.a + ", error: " + r23.getMessage());     // Catch: Throwable -> L33
        c(r23, Long.valueOf(r16));     // Catch: Throwable -> L33
        goto L31
    L16:
        if (StringsKt.isBlank(r17) == true) goto L19;
        r20 = false;
    L33:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }
}
