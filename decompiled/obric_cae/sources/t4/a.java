package t4;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class a extends HandlerThread {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile a f12270n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Handler f12271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12272b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList<Runnable> f12273m;

    public a() {
        super("TeaThread");
        this.f12272b = new Object();
        this.f12273m = new LinkedList();
    }

    public static a a() {
        if (f12270n != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12270n != null) goto L9;
        f12270n = new a();     // Catch: Throwable -> L11
        f12270n.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12270n;
    }

    public final Handler b() {
        if (this.f12271a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f12271a != null) goto L8;
        this.f12271a = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f12271a;
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        Object r8 = this.f12272b;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.f12273m);     // Catch: Throwable -> L14
        this.f12273m.clear();     // Catch: Throwable -> L14
        if (r10.isEmpty() == true) goto L12;
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L14
    L8:
        if (r11.hasNext() == false) goto L12;
        Runnable r12 = (Runnable) r11.next();     // Catch: Throwable -> L14
        if (r12 == null) goto L8;
        b().post(r12);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
