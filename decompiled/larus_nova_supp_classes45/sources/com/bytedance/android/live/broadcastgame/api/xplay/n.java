package com.bytedance.android.live.broadcastgame.api.xplay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements e {
    public static final n b = null;
    public final /* synthetic */ e a;

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void a() {
        this.a.a();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void b(boolean r2) {
        this.a.b(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void c() {
        this.a.c();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void d() {
        this.a.d();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stopReason");
        this.a.e(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void f(g10.b r2) {
        Intrinsics.checkNotNullParameter(r2, "extension");
        this.a.f(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void g() {
        this.a.g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void h(g10.b r2) {
        Intrinsics.checkNotNullParameter(r2, "extension");
        this.a.h(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void i(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appId");
        this.a.i(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void j(p r2) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        this.a.j(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.k(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final boolean l() {
        return this.a.l();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void m(XplayScene r2) {
        Intrinsics.checkNotNullParameter(r2, "newScene");
        this.a.m(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final f n() {
        return this.a.n();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void updateEnableAudioFrame(boolean r2) {
        this.a.updateEnableAudioFrame(r2);
    }

    static {
        b = new n();
    }

    public n() {
        this.a = (e) XplayGlobalServiceKt.a.getValue();
    }
}
