package com.obric.assistant.onelogin;

import android.app.Activity;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 implements fra.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function4<ua7.h, String, String, String, Unit> c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ WeakReference<Activity> e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Function0<Unit> g;
    public final /* synthetic */ Function0<Unit> h;
    public final /* synthetic */ Function3<ua7.h, String, String, Unit> i;

    public static final class a extends yb7.i {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function3<ua7.h, String, String, Unit> d;
        public final /* synthetic */ WeakReference<Activity> e;
        public final /* synthetic */ Function4<ua7.h, String, String, String, Unit> f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Function0<Unit> i;
        public final /* synthetic */ Function0<Unit> j;

        public final void onSuccess(ua7.b r4) {
            FLogger.a.i("ObricOneLoginUtils", "safeOneLogin onSuccess, loginId=" + this.a + ", source=" + this.b + ", enableSafeOneLogin=" + this.c);
            this.d.invoke((ua7.h) r4, "safe_one_login", "safe_one_login");
        }

        public final void onError(ua7.b r14, int r15) {
            ua7.h r16 = (ua7.h) r14;
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("safeOneLogin onError, loginId=");
            r1.append(this.a);
            r1.append(", source=");
            r1.append(this.b);
            r1.append(", enableSafeOneLogin=");
            r1.append(this.c);
            r1.append(", response: ");
            if (r16 == null) goto L5;
            String r2 = c0.j(r16);
        L6:
            r1.append(r2);
            r1.append(", error: ");
            r1.append(r15);
            r0.e("ObricOneLoginUtils", r1.toString());
            if (c0.c(this.e) != null) goto L9;
            this.f.invoke(r16, String.valueOf(r15), "safe_one_login", "no_activity");
            return;
        L9:
            c0.a(this.e, this.a, this.b, this.h, this.c, this.i, this.f, this.j, this.d, this.g);
            return;
        L5:
            r2 = null;
            goto L6
        }

        public a(String r1, String r2, boolean r3, Function3<? super ua7.h, ? super String, ? super String, Unit> r4, WeakReference<Activity> r5, Function4<? super ua7.h, ? super String, ? super String, ? super String, Unit> r6, String r7, String r8, Function0<Unit> r9, Function0<Unit> r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }
    }

    public final void a() {
    }

    public final void b(fra.c r19) {
        Intrinsics.checkNotNullParameter(r19, WindowEvent.Params.RESULT);
        FLogger.a.i("ObricOneLoginUtils", "SecShareDataReadManager.readData onResult, loginId=" + this.a + ", source=" + this.b + ", result: " + c0.j(r19));
        era.a r3 = (era.a) new Gson().fromJson(r19.b, era.a.class);     // Catch: Exception -> L5
    L7:
        if (r3 != null) goto L10;
        FLogger.a.e("ObricOneLoginUtils", "accountInfo is null, loginId=" + this.a + ", source=" + this.b + ", return");
        this.c.invoke(null, "accountInfo is null", "none", "parse_account_info");
        return;
    L10:
        String r0 = r3.a();
        boolean r4 = true;
        if (r0 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == false) goto L40;
    L27:
        String r1 = null;
    L28:
        if (r1 != null) goto L30;
        r1 = "com.obric.matrix";
    L30:
        FLogger r5 = FLogger.a;
        r5.i("ObricOneLoginUtils", "accountInfo parsed, loginId=" + this.a + ", source=" + this.b + ", serverPkg=" + r1);
        if (this.d == false) goto L33;
        com.bytedance.sdk.account.impl.d r2 = com.bytedance.sdk.account.impl.d.l();
        r2.q(r3.c(), r3.b(), new a(this.a, this.b, this.d, this.i, this.e, this.c, r1, this.f, this.g, this.h));
        return;
    L33:
        if (c0.c(this.e) != null) goto L36;
        r5.e("ObricOneLoginUtils", "safeOneLogin disabled and no alive activity, loginId=" + this.a + ", source=" + this.b + ", type=" + this.f + ", enableSafeOneLogin=" + this.d);
        this.c.invoke(null, "safeOneLogin disabled and activity is null", "start_auth", "no_activity");
        return;
    L36:
        r5.i("ObricOneLoginUtils", "safeOneLogin disabled, loginId=" + this.a + ", source=" + this.b + ", type=" + this.f + ", enableSafeOneLogin=" + this.d);
        c0.a(this.e, this.a, this.b, this.f, this.d, this.g, this.c, this.h, this.i, r1);
        return;
    L40:
        r1 = new JSONObject(r0).optString("auth_package");     // Catch: Exception -> L25
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L25
        if (r1.length() > 0) goto L23;
        r4 = false;
    L23:
        if (r4 == false) goto L27;
    L25:
        e = move-exception;
        FLogger.a.e("ObricOneLoginUtils", "parseAuthPackage error: " + e);
        goto L27
    L13:
        if (r0.length() == 0) goto L16;
        r8 = false;
    L5:
        e = move-exception;
        FLogger.a.e("ObricOneLoginUtils", "SecShareDataReadManager.readData onResult, loginId=" + this.a + ", source=" + this.b + ", Gson().fromJson error: " + e);
        r3 = null;
        goto L7
    }

    public a0(String r1, String r2, y r3, boolean r4, WeakReference r5, String r6, Function0 r7, Function0 r8, x r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
