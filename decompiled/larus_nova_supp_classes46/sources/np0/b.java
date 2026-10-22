package np0;

import com.bytedance.android.live.core.utils.z0;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> {
    public T a;
    public final PublishSubject b;
    public final Observable<T> c;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            h80.c r3 = (h80.c) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.b();
        }
    }

    /* JADX INFO: renamed from: np0.b$b, reason: collision with other inner class name */
    public static final class C0245b<T, R> implements Function {
        public static final C0245b a = null;

        static {
            a = new C0245b();
        }

        public C0245b() {
        }

        public final Object apply(Object r2) {
            h80.c r3 = (h80.c) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return z0.b(r3);
        }
    }

    public b() {
        PublishSubject r0 = PublishSubject.create();
        this.b = r0;
        this.c = r0.filter(a.a).map(C0245b.a);
    }

    public final void a(T r2) {
        this.a = r2;
        this.b.onNext(h80.c.c(r2));
    }
}
