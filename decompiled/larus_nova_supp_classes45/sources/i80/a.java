package i80;

import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {

    /* JADX INFO: renamed from: i80.a$a, reason: collision with other inner class name */
    public static final class C0239a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public C0239a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.invoke(r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(c.b((sh6.b) r2));
        }
    }

    public static final <T> Disposable a(m<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeChangeWithNotify");
        Intrinsics.checkNotNullParameter(r2, "notify");
        r2.invoke(r1.getValue());
        return r1.a().subscribe(new C0239a(r2));
    }

    public static final <T> Disposable b(n<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeChangeWithNotify");
        Intrinsics.checkNotNullParameter(r2, "notify");
        r2.invoke(r1.getValue());
        return r1.a().subscribe(new b(r2));
    }
}
