package com.bytedance.awemeopen.infra.base.player;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements r64.d {
    public final /* synthetic */ AoDefaultPlayer a;
    public final /* synthetic */ k b;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.base.player.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0191a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlayState.values().length];
            r0[PlayState.STATE_PAUSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PlayState.STATE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // r64.d
    public final void c(String r2) {
        this.b.c(r2);
    }

    @Override // r64.d
    public final void h(String r2) {
        this.b.h(r2);
    }

    @Override // r64.d
    public final void onPlayPrepare(String r4) {
        if (this.a.g.getAndSet(true) == false) goto L5;
        return;
    L5:
        AoDefaultPlayer r0 = this.a;
        PlayState r2 = r0.b;
        if (r0.f.get() == false) goto L17;
        this.b.onPlayPrepare(r4);
        if (this.a.b == r2) goto L10;
        return;
    L10:
        int r5 = C0191a.a[r2.ordinal()];
        if (r5 != 1) goto L13;
        this.a.pause();
        return;
    L13:
        if (r5 != 2) goto L21;
        this.a.resume();
        return;
    L21:
        return;
    L17:
        AoDefaultPlayer r1 = this.a;
        r1.b = PlayState.STATE_START;
        this.b.onPlayPrepare(r4);
    }

    @Override // r64.d
    public final void onPlaying(String r3) {
        g(r3, this.a.a.h(), "");
        this.b.onPlaying(r3);
    }

    public a(AoDefaultPlayer r1, k r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // r64.d
    public final void a(String r4, r64.c r5) {
        Intrinsics.checkNotNullParameter(r5, "statusInfo");
        AoDefaultPlayer r0 = this.a;
        if (r0.b != PlayState.STATE_PAUSE) goto L5;
        r0.a.pause();
    L5:
        k r1 = this.b;
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r5, "bdpPlayerStatusInfo");
        l r3 = new l();
        r3.a = r5.a;
        r1.l(r4, r3);
    }

    @Override // r64.d
    public final void d(String r2, long r3, int r5) {
        this.b.d(r2, r3, r5);
    }

    @Override // r64.d
    public final void e(String r2, int r3, String r4) {
        this.b.e(r2, r3, r4);
    }

    @Override // r64.d
    public final void g(String r3, boolean r4, String r5) {
        onPlayPrepare(r3);
        if (this.a.h.getAndSet(true) == true) goto L6;
        this.b.g(r3, r4, r5);
        return;
    }

    @Override // r64.d
    public final void f(String r2, boolean r3, int r4, int r5) {
        this.b.f(r2, r3, r4, r5);
    }
}
