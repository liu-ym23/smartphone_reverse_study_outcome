package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableInterval extends Observable<Long> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final xb.p f9546c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f9547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long f9548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final TimeUnit f9549i;

    static final class IntervalObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final xb.o<? super Long> downstream;

        IntervalObserver(xb.o<? super Long> r10) {
            this.downstream = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == DisposableHelper.DISPOSED) goto L6;
            xb.o<? super Long> r10 = this.downstream;
            long r11 = this.count;
            this.count = 1 + r11;
            r10.onNext(Long.valueOf(r11));
            return;
        }

        public void setResource(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public ObservableInterval(long r10, long r11, TimeUnit r12, xb.p r13) {
        this.f9547g = r10;
        this.f9548h = r11;
        this.f9549i = r12;
        this.f9546c = r13;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.Observable
    public void f(xb.o<? super Long> r10) {
        IntervalObserver r11 = new IntervalObserver(r10);
        r10.onSubscribe(r11);
        xb.p r12 = this.f9546c;
        if ((r12 instanceof io.reactivex.internal.schedulers.i) == false) goto L5;
        xb.p.c r13 = r12.a();
        r11.setResource(r13);
        r13.d(r11, this.f9547g, this.f9548h, this.f9549i);
        return;
    L5:
        r11.setResource(r12.e(r11, this.f9547g, this.f9548h, this.f9549i));
    }
}
