package sf;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lg.c;
import lg.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final ArrayList<i> a = null;
    public static final a b = null;

    /* JADX INFO: renamed from: sf.a$a, reason: collision with other inner class name */
    public static final class CallableC0198a<V> implements Callable {
        public final /* synthetic */ c a;

        public CallableC0198a(c r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            a r0 = a.b;     // Catch: Throwable -> L19
            c r1 = this.a;     // Catch: Throwable -> L19
            monitor-enter(r0);     // Catch: Throwable -> L19
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L5:
            if ((r1 instanceof lg.a) == false) goto L13;
            Iterator<i> r10 = a.a.iterator();     // Catch: Throwable -> L15
        L8:
            if (r10.hasNext() == false) goto L11;
            r10.next().a((lg.a) r1);     // Catch: Throwable -> L15
            goto L26
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public a() {
    }

    static {
        b = new a();
        a = new ArrayList();
    }

    public static void a(c r1) {
        Intrinsics.checkNotNullParameter(r1, "node");
        Single.fromCallable(new CallableC0198a(r1)).subscribeOn(Schedulers.io()).subscribe();
    }
}
