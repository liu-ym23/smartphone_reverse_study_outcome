package rd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f11798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<rd.b> f11799b;

    /* JADX INFO: renamed from: rd.a$a, reason: collision with other inner class name */
    public class RunnableC0149a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f11800a;

        public RunnableC0149a(a r8) {
            this.f11800a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r8 = this.f11800a;
            r8.getClass();
            r8.getClass();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11801a = null;

        static {
            f11801a = new a();
        }
    }

    public a() {
        new ArrayList();
        this.f11798a = new ReentrantReadWriteLock();
        this.f11799b = new LinkedList();
        new RunnableC0149a(this);
    }

    public final ArrayList a(int r8) {
        LinkedList<rd.b> r10 = this.f11799b;
        if (r10.isEmpty() == true) goto L15;
        ArrayList r11 = new ArrayList();
        if (r10.isEmpty() == true) goto L20;
        ReentrantReadWriteLock r12 = this.f11798a;
        r12.readLock().lock();
        int r13 = Math.min(r8, r10.size());     // Catch: Throwable -> L12
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L11;
        r11.add(r10.get(r14));     // Catch: Throwable -> L12
        r14 = r14 + 1;
        goto L8
    L11:
        r12.readLock().unlock();
        return r11;
    L12:
        th = move-exception;
        r12.readLock().unlock();
        throw th;
    L20:
        return r11;
    L15:
        return null;
    }
}
