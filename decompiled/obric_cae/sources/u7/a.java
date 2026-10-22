package u7;

import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RunnableC0172a f12500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<u7.b> f12501c;

    /* JADX INFO: renamed from: u7.a$a, reason: collision with other inner class name */
    public class RunnableC0172a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f12502a;

        public RunnableC0172a(a r8) {
            this.f12502a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r8 = this.f12502a;
            Iterator<u7.b> r10 = r8.f12501c.iterator();     // Catch: OutOfMemoryError -> L9
        L5:
            if (r10.hasNext() == false) goto L7;
            r10.next().a(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L9
            goto L5
        L7:
            d r11 = r8.f12499a;     // Catch: OutOfMemoryError -> L9
            r11.e(Message.obtain(r11.f12514d, this), 30000);     // Catch: OutOfMemoryError -> L9
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12503a = null;

        static {
            f12503a = new a();
        }
    }

    public a() {
        this.f12500b = new RunnableC0172a(this);
        this.f12501c = new CopyOnWriteArraySet();
        d r8 = new d("AsyncEventManager-Thread");
        this.f12499a = r8;
        r8.f12511a.start();
    }

    public final void a(Runnable r8) {
        d r10 = this.f12499a;
        r10.e(Message.obtain(r10.f12514d, r8), 0);
    }
}
