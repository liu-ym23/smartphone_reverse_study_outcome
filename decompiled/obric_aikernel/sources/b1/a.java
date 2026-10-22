package b1;

import android.os.Process;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final o1.a<a> f507c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<b> f508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f509b;

    /* JADX INFO: renamed from: b1.a$a, reason: collision with other inner class name */
    static class C0023a extends o1.a<a> {
        C0023a() {
        }

        @Override // o1.a
        protected /* bridge */ /* synthetic */ a a(Object[] r10) {
            return c(r10);
        }

        protected a c(Object... r10) {
            return new a(null);
        }
    }

    static {
        f507c = new C0023a();
    }

    private a() {
        this.f508a = new CopyOnWriteArraySet();
        this.f509b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* synthetic */ a(C0023a r10) {
        this();
    }

    public static a b() {
        return f507c.b(new Object[0]);
    }

    private void c(@NonNull Thread r10, @NonNull Throwable r11) {
        Thread.UncaughtExceptionHandler r12 = this.f509b;
        if (r12 == null) goto L8;
        r12.uncaughtException(r10, r11);
        return;
    L8:
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L7
        System.exit(10);     // Catch: Throwable -> L7
        return;
    }

    public void a(b r10) {
        this.f508a.add(r10);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r10, Throwable r11) {
        Iterator<b> r12 = this.f508a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().a(r10, r11);
        goto L4
    L6:
        c(r10, r11);
    }
}
