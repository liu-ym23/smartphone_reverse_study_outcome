package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements qja.c.InterfaceC0068c {
    public final /* synthetic */ PlayerController a;

    @Override // qja.c.InterfaceC0068c
    public final void onFirstFrame() {
        tja.a r0 = this.a.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r0.onFirstFrame();
    }

    public d(PlayerController r1) {
        this.a = r1;
    }
}
