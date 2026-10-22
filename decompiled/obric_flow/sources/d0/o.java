package d0;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class o extends com.lynx.animax.player.e {
    @Override // com.lynx.animax.player.e
    public final void d(Object r5, Object r10) {
        p r11 = (p) r5;
        r11.getClass();
        ArrayDeque r12 = p.f16563b;
        monitor-enter(r12);
        r12.offer(r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
