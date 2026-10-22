package com.bytedance.android.live.effect.api;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 implements o {
    public final ILiveEffectComposerManager a;

    @Override // com.bytedance.android.live.effect.api.o
    public final List c() {
        Intrinsics.checkNotNullParameter("livedigitavatar", "panel");
        return this.a.o("livedigitavatar");
    }

    public h0(ILiveEffectComposerManager r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void d(kh0.a.d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a.V(new f0(r3));
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void e(Sticker r4) {
        Intrinsics.checkNotNullParameter("livedigitavatar", "panel");
        Intrinsics.checkNotNullParameter(r4, "sticker");
        Intrinsics.checkNotNullParameter("KtvDigitAvatar_showAvatarPreviewView", "trace");
        this.a.O("livedigitavatar", r4, "KtvDigitAvatar_showAvatarPreviewView");
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void f(kh0.a.d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a.g(new g0(r3));
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "trace");
        this.a.b(r2, r3);
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void a(String r2, Sticker r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "sticker");
        Intrinsics.checkNotNullParameter(r4, "trace");
        this.a.a(r2, r3, r4);
    }
}
