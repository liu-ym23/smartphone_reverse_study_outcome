package com.bytedance.android.live.broadcastgame.api.xplay.basic;

import com.bytedance.android.live.liveinteract.hamlet.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements a {
    public static final b b = null;
    public final /* synthetic */ a a;

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void a(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "extension");
        this.a.a(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void b(boolean r2) {
        this.a.b(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void c() {
        this.a.c();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void d(c r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        this.a.d(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stopReason");
        this.a.e(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void f(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "extension");
        this.a.f(r2);
    }

    static {
        b = new b();
    }

    public b() {
        this.a = (a) LiveXPlayBasicGlobalServiceKt.a.getValue();
    }
}
