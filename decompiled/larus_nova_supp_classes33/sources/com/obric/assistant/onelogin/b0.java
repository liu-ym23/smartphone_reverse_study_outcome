package com.obric.assistant.onelogin;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b0 extends com.ss.android.account.group_onekey.e {
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Function0<Unit> f;
    public final /* synthetic */ Function4<ua7.h, String, String, String, Unit> g;
    public final /* synthetic */ Function3<ua7.h, String, String, Unit> h;

    public final void a(ua7.h r4, com.ss.android.account.group_onekey.e.a r5) {
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter(r5, "extra");
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("AccountGroupAuthService.startAuth onError, loginId=");
        r0.append(this.d);
        r0.append(", source=");
        r0.append(this.e);
        r0.append(", msg: ");
        String r1 = r4.toString();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        g2a.e r2 = g2a.e.a;
        r0.append(g2a.f.a(r1, false, false));
        r6.e("ObricOneLoginUtils", r0.toString());
        this.f.invoke();
        this.g.invoke(r4, String.valueOf(((ua7.b) r4).g), "start_auth", "start_auth");
    }

    public b0(String r1, String r2, Function0<Unit> r3, Function4<? super ua7.h, ? super String, ? super String, ? super String, Unit> r4, Function3<? super ua7.h, ? super String, ? super String, Unit> r5, Context r6, String r7) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        Intrinsics.checkNotNull(r6);
        super(r6, r7);
    }
}
