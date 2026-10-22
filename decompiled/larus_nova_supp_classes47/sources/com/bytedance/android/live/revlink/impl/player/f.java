package com.bytedance.android.live.revlink.impl.player;

import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.scope.o;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements d, o {
    public final /* synthetic */ j a;

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final boolean O(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        return this.a.O(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void a(int r2) {
        this.a.a(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void c(boolean r2) {
        this.a.c(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void d(boolean r2) {
        this.a.d(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void f(int r2) {
        this.a.f(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void g(boolean r2) {
        this.a.g(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final h handleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        return this.a.handleSei(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void i(k31.a r2) {
        this.a.i(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void j(int r2) {
        this.a.j(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void k(boolean r2) {
        this.a.k(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final void me(StreamLayoutManager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.a.me(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void n(boolean r2) {
        this.a.n(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void o(boolean r2) {
        this.a.o(r2);
    }

    public final void onStart() {
        this.a.getClass();
    }

    public final void onStop() {
        this.a.getClass();
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void q(boolean r2) {
        this.a.q(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final void q1() {
        this.a.q1();
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void s(LiveMode r2) {
        this.a.s(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void w(int r2) {
        this.a.w(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void x(k31.k r2) {
        this.a.x(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final PublishSubject ml() {
        return this.a.h;
    }

    public f(xq2.a r4) {
        Intrinsics.checkNotNullParameter(r4, "dataScopeProvider");
        cy0.c r1 = r4.c0();
        cy0.c r5 = r4.c0();
        if (r5 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        ld.a r6 = (ld.a) com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(ld.a.class));
    L6:
        this.a = new j(r1, r6);
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void h(Function1<? super b, Unit> r2) {
        this.a.l.p = r2;
    }
}
