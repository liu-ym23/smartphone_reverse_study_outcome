package r22;

import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<T> {
    public final c a;
    public final r22.b<T> b;

    /* JADX INFO: renamed from: r22.a$a, reason: collision with other inner class name */
    public static final class C0270a {
    }

    public interface b<T> {
        void a(T r1);
    }

    public static final class c implements b<T> {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // r22.a.b
        public final void a(T r2) {
            this.a.e(r2);
        }
    }

    static {
    }

    public boolean c(T r1) {
        return false;
    }

    public abstract Queue<T> h();

    public void i(T r1) {
    }

    public abstract T j();

    public final void d() {
        h().clear();
    }

    public final void k() {
        if (f().a() == false) goto L8;
        T r0 = j();
        if (r0 == null) goto L9;
        f().b(r0);
        return;
    L9:
        return;
    }

    public r22.b<T> f() {
        return this.b;
    }

    public b<T> g() {
        return this.a;
    }

    public a(r22.b<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        this.b = r2;
        this.a = new c(this);
    }

    public final void a(T r2) {
        if (c(r2) == false) goto L6;
        i(r2);
        return;
    L6:
        b(r2, g());
    }

    public void e(T r3) {
        if (c(r3) == false) goto L7;
        i(r3);
        return;
    L7:
        if (h().size() < 200) goto L9;
        h().poll();
    L9:
        h().add(r3);
        k();
    }

    public void b(T r2, b<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "notifier");
        r3.a(r2);
    }
}
