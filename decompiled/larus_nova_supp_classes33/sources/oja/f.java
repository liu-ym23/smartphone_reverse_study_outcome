package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements qja.c.b {
    public final /* synthetic */ PlayerController a;

    @Override // qja.c.b
    public final void onError() {
        Intrinsics.checkNotNullParameter("", "desc");
        PlayerController r0 = this.a;
        int r1 = PlayerController.n;
        r0.getClass();
        this.a.b();
    }

    public f(PlayerController r1) {
        this.a = r1;
    }
}
