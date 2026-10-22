package z51;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class d<T> {
    public final PropertyOwner<sh6.b<T>> a;
    public final Observable<T> b;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return sh6.c.b(r3);
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (sh6.c.b(r3) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: z51.d$d, reason: collision with other inner class name */
    public static final class C0352d<T, R> implements Function {
        public static final C0352d a = null;

        static {
            a = new C0352d();
        }

        public C0352d() {
        }

        public final Object apply(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return sh6.c.b(r3);
        }
    }

    public static final class e<T> implements Predicate {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean test(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (sh6.c.b(r3) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return sh6.c.b(r3);
        }
    }

    static {
    }

    public d() {
        this(null);
    }

    public final Observable<T> a() {
        PropertyOwner<sh6.b<T>> r0 = this.a;
        return r0.startWith(r0.a).filter(e.a).map(f.a);
    }

    public d(T r3) {
        PropertyOwner<sh6.b<T>> r0 = new PropertyOwner(sh6.c.a(r3));
        this.a = r0;
        this.b = r0.filter(c.a).map(C0352d.a);
        r0.map(b.a);
    }
}
