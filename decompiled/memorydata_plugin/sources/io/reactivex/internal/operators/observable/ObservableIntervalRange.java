package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.k;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableIntervalRange extends Observable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final u f16954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16955b;
    final long c;
    final long d;
    final long e;
    final TimeUnit f;

    static final class IntervalRangeObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final t<? super Long> downstream;
        final long end;

        IntervalRangeObserver(t<? super Long> r3, long r4, long r6) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.count = r4;
            this.end = r6;
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
            if (isDisposed() == true) goto L10;
            long r0 = this.count;
            this.downstream.onNext(Long.valueOf(r0));
            if (r0 != this.end) goto L8;
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
            return;
        L8:
            this.count = r0 + 1;
            return;
        }

        public void setResource(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
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
    public void a(t<? super Long> r9) {
        t r10 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        IntervalRangeObserver r7 = new IntervalRangeObserver(r10, this.f16955b, this.c);
        r10.onSubscribe(r7);
        u r0 = this.f16954a;
        if (ZeusTransformUtils.instanceOf(r0, k.class) == false) goto L5;
        u.c r1 = r0.a();
        r7.setResource(r1);
        r1.a(r7, this.d, this.e, this.f);
        return;
    L5:
        r7.setResource(r0.a(r7, this.d, this.e, this.f));
    }
}
