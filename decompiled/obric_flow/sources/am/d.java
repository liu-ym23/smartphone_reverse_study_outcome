package am;

import android.os.Looper;
import android.os.Message;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends PhantomReference {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f321c = null;
    public static final Object d = null;
    public static final HashSet e = null;
    public static final ConcurrentHashMap.KeySetView f = null;
    public static final ConcurrentLinkedQueue g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f323b;

    static {
        f321c = new ReferenceQueue();
        d = new Object();
        a r5 = new a("CleanupReference", 0);
        r5.setDaemon(true);
        r5.start();
        e = new HashSet();
        f = ConcurrentHashMap.newKeySet();
        g = new ConcurrentLinkedQueue();
    }

    public d(Object r5, Runnable r10) {
        super(r5, f321c);
        this.f323b = r10;
        this.f322a = true;
        Message r11 = Message.obtain(c.f320a, 1, this);
        if (Looper.myLooper() != r11.getTarget().getLooper()) goto L6;
        r11.getTarget().handleMessage(r11);
        r11.recycle();
        return;
    L6:
        r11.sendToTarget();
    }

    public final void a() {
        if (this.f322a == true) goto L6;
        b(f);
        return;
    L6:
        Message r5 = Message.obtain(c.f320a, 2, this);
        if (Looper.myLooper() != r5.getTarget().getLooper()) goto L10;
        r5.getTarget().handleMessage(r5);
        r5.recycle();
        return;
    L10:
        r5.sendToTarget();
    }

    public final void b(Set r5) {
        if (r5.remove(this) == true) goto L5;
        return;
    L5:
        Runnable r10 = this.f323b;
        this.f323b = null;
        if (r10 == null) goto L8;
        r10.run();
    L8:
        clear();
    }
}
