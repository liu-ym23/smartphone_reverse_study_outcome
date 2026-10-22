package u7;

import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f12505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<u7.b> f12506c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12507a;

        public a(c r8) {
            this.f12507a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r8 = this.f12507a;
            Iterator<u7.b> r10 = r8.f12506c.iterator();     // Catch: OutOfMemoryError -> L9
        L5:
            if (r10.hasNext() == false) goto L7;
            r10.next().a(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L9
            goto L5
        L7:
            d r11 = r8.f12504a;     // Catch: OutOfMemoryError -> L9
            r11.e(Message.obtain(r11.f12514d, this), 5000);     // Catch: OutOfMemoryError -> L9
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12508a = null;

        static {
            f12508a = new c();
        }
    }

    public c() {
        this.f12505b = new a(this);
        this.f12506c = new CopyOnWriteArraySet();
        d r8 = new d("LogSendManager-Thread");
        this.f12504a = r8;
        r8.f12511a.start();
    }
}
