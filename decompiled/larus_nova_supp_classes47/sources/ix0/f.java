package ix0;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<V> implements Callable {
    public final /* synthetic */ Single a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef a;

        public a(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.element = r2;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ Ref.ObjectRef a;

        public b(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.element = null;
        }
    }

    public f(Single r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // java.util.concurrent.Callable
    public final ObservableSource<Object> call() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        return Observable.concat(this.a.toObservable(), Observable.never()).doOnNext(new a(r0)).doOnDispose(new b(r0));
    }
}
