package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements qja.c.a {
    public final /* synthetic */ PlayerController a;

    @Override // qja.c.a
    public final void onCompletion() {
        tja.a r0 = this.a.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r0.onCompletion();
        PlayerController r1 = this.a;
        r1.g = PlayerState.PAUSED;
        r1.b();
    }

    public e(PlayerController r1) {
        this.a = r1;
    }
}
