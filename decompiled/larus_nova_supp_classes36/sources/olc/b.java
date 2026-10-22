package olc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements olc.a {
    public final TreeSet<Bitmap> a;
    public final ReentrantLock b;
    public final Handler c;
    public final int d;
    public final long e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        ReentrantLock r0 = this.b;
        r0.lock();
        this.c.removeMessages(1);     // Catch: Throwable -> L10
        if (this.a.isEmpty() == false) goto L7;
        r0.unlock();
        return;
    L7:
        this.c.sendEmptyMessageDelayed(1, this.e);     // Catch: Throwable -> L10
        r0.unlock();
        return;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public b() {
        this.d = 5;
        this.e = 3000;
        this.a = new TreeSet(d.a);
        this.b = new ReentrantLock();
        this.c = new Handler(Looper.getMainLooper(), new c(this));
    }

    @Override // olc.a
    public final void a(Bitmap r3) {
        ReentrantLock r0 = this.b;
        r0.lock();
        this.a.add(r3);     // Catch: Throwable -> L9
        if (this.a.size() <= this.d) goto L6;
        Iterator<Bitmap> r4 = this.a.iterator();     // Catch: Throwable -> L9
        r4.next().recycle();     // Catch: Throwable -> L9
        r4.remove();     // Catch: Throwable -> L9
    L6:
        b();     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r0.unlock();
        return;
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // olc.a
    public final Bitmap obtain(int r6, int r7, Bitmap.Config r8) {
        ReentrantLock r0 = this.b;
        r0.lock();
        Iterator<Bitmap> r1 = this.a.iterator();     // Catch: Throwable -> L22
    L5:
        if (r1.hasNext() == false) goto L16;
        Bitmap r2 = r1.next();     // Catch: Throwable -> L22
        if (r2.getWidth() >= r6) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L5;
        if (r2.getConfig() != r8) goto L5;
        r1.remove();     // Catch: Throwable -> L22
        r2.eraseColor(0);     // Catch: Throwable -> L22
    L17:
        if (r2 != null) goto L20;
        r2 = e.b.obtain(r6, r7, r8);     // Catch: Throwable -> L22
    L20:
        r0.unlock();
        return r2;
    L9:
        if (r2.getHeight() < r7) goto L11;
        r3 = true;
        goto L12
    L16:
        r2 = null;
    L22:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
