package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r0 implements o99.a {
    public final /* synthetic */ q0 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Button c;
    public final /* synthetic */ Message d;

    public final void d() {
    }

    public final void e(q99.d r1) {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final Bundle b(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return r2;
    }

    public final hq9.n3 f(hq9.n3 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        return r2;
    }

    public final void a(q99.m r2, q99.l r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "error");
        this.a.o(ActiveStatus.INACTIVE);
        this.a.n(this.b, this.c);
        Function1<? super Boolean, Unit> r4 = this.a.r;
        if (r4 == null) goto L5;
        r4.invoke(Boolean.FALSE);
    L5:
        t19.s r5 = t19.s.a;
        Context r6 = this.b;
        r5.getClass();
        t19.s.b(r6, 2131907052, false);
    }

    public final void c(q99.e r1, q99.a r2) {
        o99.a.a.a(r1, r2);
    }

    public final void g(q99.m r3, q99.n r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "result");
        Function1<? super Boolean, Unit> r5 = this.a.r;
        if (r5 == null) goto L5;
        r5.invoke(Boolean.TRUE);
    L5:
        this.a.o(ActiveStatus.ACTIVE);
        this.a.n(this.b, this.c);
        final q0 r6 = this.a;
        Message r7 = this.d;
        r6.getClass();
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        String r8 = r7.getMessageId();
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        r0.x(r8, new p0(r6), null);
        t19.s r9 = t19.s.a;
        Context r10 = this.b;
        r9.getClass();
        t19.s.o(r10, 2131908223, false);
    }

    public final void j(q99.e r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "delivery");
        Intrinsics.checkNotNullParameter(r1, "delivery");
    }

    public r0(q0 r1, Context r2, Button r3, Message r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
