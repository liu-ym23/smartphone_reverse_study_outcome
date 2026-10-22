package com.larus.audioplayer.impl.news;

import b88.f;
import com.larus.audioplayer.api.news.UrlAudioLoadState;
import com.larus.platform.api.l0;
import com.larus.platform.api.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements b88.b, b.InterfaceC0090b {
    public final b88.c a;
    public final b b;

    @Override // b88.b
    public final float e() {
        return this.b.m.a().a;
    }

    @Override // b88.b
    public final int f() {
        return this.b.m.getCurrentPlaybackTime();
    }

    @Override // b88.b
    public final int getAudioDuration() {
        return this.b.m.n();
    }

    @Override // b88.b
    public final boolean isWorking() {
        return this.b.o;
    }

    @Override // b88.b
    public final int k() {
        return this.b.m.o();
    }

    @Override // b88.b
    public final void release() {
        this.b.m.release();
    }

    @Override // b88.b
    public final void c(float r2) {
        this.b.m.c(r2);
    }

    @Override // b88.b
    public final void d(float r3) {
        b r0 = this.b;
        n r1 = new n();
        r1.a = r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "params");
        r0.m.H(r1);
    }

    @Override // b88.b
    public final void g(Function0<Unit> r2) {
        this.b.d(r2);
    }

    @Override // b88.b
    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.b.c(r2);
    }

    @Override // b88.b
    public final void setLooping(boolean r2) {
        this.b.m.setLooping(r2);
    }

    @Override // b88.b
    public final void h(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "pausedReason");
        this.b.b(r2, r3);
    }

    @Override // b88.b
    public final boolean j(int r2, l0 r3) {
        this.b.m.A(r2, r3);
        return true;
    }

    @Override // com.larus.audioplayer.impl.news.b.InterfaceC0090b
    public final void l(String r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "player");
        b88.c r4 = this.a;
        if (r4 == null) goto L6;
        r4.b(r2);
        return;
    }

    public c(f r21, b88.a r22, b88.c r23) {
        Intrinsics.checkNotNullParameter(r21, "config");
        this.a = r23;
        b r15 = new b(r21.a, r21.b, null, null, r22, r21.c, r21.d, null, null, r21.e, r21.f, r21.g, r21.h, r21.i, r21.j, 396);
        Intrinsics.checkNotNullParameter(this, "callback");
        r15.z = this;
        this.b = r15;
    }

    @Override // com.larus.audioplayer.impl.news.b.InterfaceC0090b
    public final void a(String r2, b r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "player");
        b88.c r5 = this.a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 != 1) goto L7;
        UrlAudioLoadState r6 = UrlAudioLoadState.PLAYABLE;
    L14:
        r5.a(r2, r6);
        return;
    L7:
        if (r4 != 2) goto L9;
        r6 = UrlAudioLoadState.STALLED;
        goto L14
    L9:
        if (r4 == 3) goto L11;
        r6 = UrlAudioLoadState.UNKNOWN;
        goto L14
    L11:
        r6 = UrlAudioLoadState.ERROR;
        goto L14
    }

    @Override // com.larus.audioplayer.impl.news.b.InterfaceC0090b
    public final void b(String r2, b r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "player");
        b88.c r5 = this.a;
        if (r5 == null) goto L6;
        r5.c(r2, r4);
        return;
    }
}
