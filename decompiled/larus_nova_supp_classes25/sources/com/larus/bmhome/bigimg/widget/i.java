package com.larus.bmhome.bigimg.widget;

import android.net.Uri;
import android.view.View;
import com.larus.bmhome.bigimg.m1;
import com.larus.home.impl.sdk.b1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements j {
    public final /* synthetic */ CreationSidebarView a;

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void f() {
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void h() {
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void i() {
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void a() {
        CreationSidebarView r0 = this.a;
        ic8.d r1 = r0.b;
        if (r1 == null) goto L23;
        Function1<ic8.f, Unit> r2 = r1.b;
        if (r2 == null) goto L24;
        Uri r3 = r0.g;
        Integer r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.toString();
    L10:
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        String r6 = r5;
        CreationSidebarView r7 = this.a;
        Message r8 = r7.o;
        m1 r9 = r7.h;
        if (r9 == null) goto L15;
        String r10 = r9.f;
    L16:
        if (r9 == null) goto L18;
        Integer r11 = r9.d;
    L19:
        if (r9 == null) goto L21;
        r4 = r9.e;
    L21:
        r2.invoke(new ic8.f(r6, r8, r10, r11, r4, r7.p));
        return;
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L24:
        return;
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void b() {
        CreationSidebarView r0 = this.a;
        ic8.d r1 = r0.c;
        if (r1 == null) goto L23;
        Function1<ic8.f, Unit> r2 = r1.b;
        if (r2 == null) goto L24;
        Uri r3 = r0.g;
        Integer r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.toString();
    L10:
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        String r6 = r5;
        CreationSidebarView r7 = this.a;
        Message r8 = r7.o;
        m1 r9 = r7.h;
        if (r9 == null) goto L15;
        String r10 = r9.f;
    L16:
        if (r9 == null) goto L18;
        Integer r11 = r9.d;
    L19:
        if (r9 == null) goto L21;
        r4 = r9.e;
    L21:
        r2.invoke(new ic8.f(r6, r8, r10, r11, r4, r7.p));
        return;
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L24:
        return;
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void c() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L15;
        r0.D0();
        b1 r1 = b1.a;
        CreationSidebarView r2 = this.a;
        r1.c("creation_share_save");
        nr9.g r3 = r2.j;
        if (r3 == null) goto L8;
        String r4 = r3.c;
        if (r4 == null) goto L8;
    L12:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r1.d(r4);
    L8:
        Uri r5 = r2.g;
        if (r5 == null) goto L11;
        r4 = r5.toString();
        goto L12
    L11:
        r4 = null;
    L15:
        Function0<Unit> r6 = this.a.q;
        if (r6 == null) goto L19;
        r6.invoke();
        return;
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void d() {
        CreationSidebarView r0 = this.a;
        ic8.d r1 = r0.f;
        if (r1 == null) goto L23;
        Function1<ic8.f, Unit> r2 = r1.b;
        if (r2 == null) goto L24;
        Uri r3 = r0.g;
        Integer r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.toString();
    L10:
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        String r6 = r5;
        CreationSidebarView r7 = this.a;
        Message r8 = r7.o;
        m1 r9 = r7.h;
        if (r9 == null) goto L15;
        String r10 = r9.f;
    L16:
        if (r9 == null) goto L18;
        Integer r11 = r9.d;
    L19:
        if (r9 == null) goto L21;
        r4 = r9.e;
    L21:
        r2.invoke(new ic8.f(r6, r8, r10, r11, r4, r7.p));
        return;
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L24:
        return;
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void g() {
        if (Intrinsics.areEqual(this.a.i, Boolean.TRUE) == true) goto L5;
        return;
    L5:
        CreationSidebarView r0 = this.a;
        nr9.g r2 = r0.j;
        if (r2 == null) goto L13;
        ic8.d r1 = r0.k;
        if (r1 == null) goto L14;
        Function5<nr9.g, String, String, String, Message, Unit> r3 = r1.f;
        if (r3 == null) goto L15;
        r3.invoke(r2, null, null, null, null);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void j() {
        CreationSidebarView r0 = this.a;
        ic8.d r1 = r0.d;
        if (r1 == null) goto L23;
        Function1<ic8.f, Unit> r2 = r1.b;
        if (r2 == null) goto L24;
        Uri r3 = r0.g;
        Integer r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.toString();
    L10:
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        String r6 = r5;
        CreationSidebarView r7 = this.a;
        Message r8 = r7.o;
        m1 r9 = r7.h;
        if (r9 == null) goto L15;
        String r10 = r9.f;
    L16:
        if (r9 == null) goto L18;
        Integer r11 = r9.d;
    L19:
        if (r9 == null) goto L21;
        r4 = r9.e;
    L21:
        r2.invoke(new ic8.f(r6, r8, r10, r11, r4, r7.p));
        return;
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L24:
        return;
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void k() {
        CreationSidebarView r0 = this.a;
        ic8.d r1 = r0.e;
        if (r1 == null) goto L23;
        Function1<ic8.f, Unit> r2 = r1.b;
        if (r2 == null) goto L24;
        Uri r3 = r0.g;
        Integer r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.toString();
    L10:
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        String r6 = r5;
        CreationSidebarView r7 = this.a;
        Message r8 = r7.o;
        m1 r9 = r7.h;
        if (r9 == null) goto L15;
        String r10 = r9.f;
    L16:
        if (r9 == null) goto L18;
        Integer r11 = r9.d;
    L19:
        if (r9 == null) goto L21;
        r4 = r9.e;
    L21:
        r2.invoke(new ic8.f(r6, r8, r10, r11, r4, r7.p));
        return;
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L24:
        return;
    }

    public i(CreationSidebarView r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.bigimg.widget.j
    public final void e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }
}
