package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements c0 {
    public final c0 a;
    public final c0 b;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void c(ExtendedToolbarButton r2) {
        this.a.c(r2);
        this.b.c(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean g(ToolbarButton r2) {
        if (this.a.g(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.b.g(r2) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void h(ExtendedToolbarButton r2) {
        this.a.h(r2);
        this.b.h(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void i(ExtendedToolbarButton r2) {
        this.a.i(r2);
        this.b.i(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final String j(ToolbarButton r2) {
        if (this.a.j(r2) == null) goto L5;
        c0 r0 = this.a;
    L7:
        return r0.j(r2);
    L5:
        r0 = this.b;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void m(com.bytedance.android.livesdk.chatroom.utils.c0 r2) {
        this.a.m(r2);
        this.b.m(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean n(ToolbarButton r2) {
        if (this.a.n(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.b.n(r2) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void o(ToolbarButton r2) {
        this.a.o(r2);
        this.b.o(r2);
    }

    public o(c0 r1, g3 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void a(ToolbarButton r2, String r3) {
        this.a.a(r2, r3);
        this.b.a(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void b(ToolbarButton r2, e r3) {
        this.a.b(r2, r3);
        this.b.b(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void d(ToolbarButton r2, c0.b r3) {
        this.a.d(r2, r3);
        this.b.d(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, c0.b r3) {
        this.a.e(r2, r3);
        this.b.e(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void f(ExtendedToolbarButton r2, c0.b r3) {
        this.a.f(r2, r3);
        this.b.f(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void k(ToolbarButton r2, c0.b r3) {
        this.a.k(r2, r3);
        this.b.k(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void l(ExtendedToolbarButton r2, String r3) {
        this.a.l(r2, r3);
        this.b.l(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void p(ExtendedToolbarButton r2, c0.b r3) {
        this.a.p(r2, r3);
        this.b.p(r2, r3);
    }
}
