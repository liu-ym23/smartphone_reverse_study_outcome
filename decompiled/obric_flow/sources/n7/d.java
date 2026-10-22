package n7;

import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends um.a {
    @Override // um.a
    public final void w() {
        super.w();
        com.bytedance.geckox.c r5 = (com.bytedance.geckox.c) this.f22372b;
        monitor-enter(r5);
        r5.b((e) r5.d);     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // um.a
    public final StateType y() {
        return StateType.IDLE;
    }
}
