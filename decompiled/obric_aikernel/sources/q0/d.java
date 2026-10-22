package q0;

import android.os.Build;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f12438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Runnable> f12439b;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f12440c;

        a(d r10) {
            this.f12440c = r10;
        }

        /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
        L6:
            ((Runnable) d.a(this.f12440c).take()).run();     // Catch: InterruptedException -> L4
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }
    }

    public d(String r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        BlockingQueue<Runnable> r11 = new LinkedTransferQueue();
    L6:
        this.f12439b = r11;
        this.f12438a = new Thread(new a(this), r10);
        return;
    L5:
        r11 = new LinkedBlockingQueue();
        goto L6
    }

    static /* synthetic */ BlockingQueue a(d r10) {
        return r10.f12439b;
    }

    public final boolean b(Runnable r10) {
        return this.f12439b.offer(r10);
    }

    public void c() {
        this.f12438a.start();
    }
}
