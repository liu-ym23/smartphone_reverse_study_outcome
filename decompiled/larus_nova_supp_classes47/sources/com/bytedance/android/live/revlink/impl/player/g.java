package com.bytedance.android.live.revlink.impl.player;

import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements d {
    public final j a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final PublishSubject ml() {
        return this.a.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final void q1() {
        this.a.q1();
    }

    public g() {
        this.a = new j(null, null);
    }

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

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void h(Function1<? super b, Unit> r2) {
        this.a.l.p = r2;
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

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void q(boolean r2) {
        this.a.q(r2);
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
}
