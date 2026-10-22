package m1;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class e extends HandlerThread {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile e f10999j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f11000c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f11001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f11002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedList<Runnable> f11003i;

    private e() {
        super("TeaThread");
        this.f11001g = new Object();
        this.f11002h = false;
        this.f11003i = new LinkedList();
    }

    public static e d() {
        if (f10999j != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f10999j != null) goto L9;
        f10999j = new e();     // Catch: Throwable -> L11
        f10999j.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f10999j;
    }

    public void a(Runnable r10) {
        b(r10);
    }

    public void b(Runnable r10) {
        c(r10, 0);
    }

    public void c(Runnable r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f11002h == false) goto L7;
        g(r10, r11);
        return;
    L7:
        Object r12 = this.f11001g;
        monitor-enter(r12);
    L18:
        th = move-exception;
        throw th;
    L10:
        if (this.f11002h == false) goto L13;
        g(r10, r11);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        return;
    L13:
        if (this.f11003i.size() <= 1000) goto L15;
        this.f11003i.poll();     // Catch: Throwable -> L18
    L15:
        this.f11003i.add(r10);     // Catch: Throwable -> L18
        goto L16
    }

    @NonNull
    public Handler e() {
        if (this.f11000c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f11000c != null) goto L8;
        this.f11000c = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f11000c;
    }

    public void f(Runnable r10) {
        if (r10 == null) goto L5;
        e().post(r10);
        return;
    }

    public void g(Runnable r10, long r11) {
        if (r10 == null) goto L5;
        e().postDelayed(r10, r11);
        return;
    }

    public void h(Runnable r10) {
        e().removeCallbacks(r10);
    }

    public void i(Runnable r10, long r11) {
        if (r10 == null) goto L5;
        h(r10);
        g(r10, r11);
        return;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        Object r10 = this.f11001g;
        monitor-enter(r10);
        this.f11002h = true;     // Catch: Throwable -> L13
        ArrayList r11 = new ArrayList(this.f11003i);     // Catch: Throwable -> L13
        this.f11003i.clear();     // Catch: Throwable -> L13
        if (r11.isEmpty() == true) goto L11;
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L13
    L9:
        if (r12.hasNext() == false) goto L11;
        f((Runnable) r12.next());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
