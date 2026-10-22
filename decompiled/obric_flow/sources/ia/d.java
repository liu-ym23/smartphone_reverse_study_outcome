package ia;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.apm.k;
import com.lynx.tasm.ui.image.h;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f17557b;

    public /* synthetic */ d(int r5, String r10, Object r11) {
        this.f17556a = r5;
        this.f17557b = r11;
        super(r10);
    }

    /* JADX WARN: Failed to build post-dominance tree
    java.lang.ArrayIndexOutOfBoundsException: Index 27 out of bounds for length 22
    	at jadx.core.dex.visitors.blocks.DominatorTree.build(DominatorTree.java:54)
    	at jadx.core.dex.visitors.blocks.PostDominatorTree.compute(PostDominatorTree.java:32)
    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:93)
    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
     */
    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        switch(this.f17556a) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        super.onLooperPrepared();
        Object r5 = ((z6.e) this.f17557b).d;
        monitor-enter(r5);
        z6.e r10 = (z6.e) this.f17557b;     // Catch: Throwable -> L13
        r10.f23410a = new Handler();     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        ((Handler) ((z6.e) this.f17557b).f23410a).post(new jm.a((z6.e) this.f17557b, 20));
    L29:
        Looper.loop();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        k.f3892a.getClass();
        f9.a.i(th);
    L13:
        th = move-exception;
        throw th;
    L16:
        super.onLooperPrepared();
        Object r11 = ((f) this.f17557b).e;
        monitor-enter(r11);
        f r12 = (f) this.f17557b;     // Catch: Throwable -> L23
        r12.d = new Handler();     // Catch: Throwable -> L23
        monitor-exit(r11);     // Catch: Throwable -> L23
        ((f) this.f17557b).d.post(new h((f) this.f17557b, 24));
    L31:
        Looper.loop();     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;
    }
}
