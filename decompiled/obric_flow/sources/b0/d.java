package b0;

import com.bumptech.glide.load.engine.d0;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.lynx.animax.player.e {
    public s d;

    @Override // com.lynx.animax.player.e
    public final int b(Object r5) {
        d0 r10 = (d0) r5;
        if (r10 != null) goto L6;
        return 1;
    L6:
        return r10.a();
    }

    @Override // com.lynx.animax.player.e
    public final void d(Object r5, Object r10) {
        z.c r11 = (z.c) r5;
        d0 r12 = (d0) r10;
        s r13 = this.d;
        if (r13 == null) goto L7;
        if (r12 == null) goto L8;
        r13.e.b(r12, true);
        return;
    L8:
        return;
    }
}
