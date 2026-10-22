package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.k;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableIntervalRange extends g<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16779b;
    final long c;
    final long d;
    final long e;
    final long f;
    final TimeUnit g;

    static final class IntervalRangeSubscriber extends AtomicLong implements Runnable, org.a.d {
        private static final long serialVersionUID = -2809475196591179431L;
        long count;
        final org.a.c<? super Long> downstream;
        final long end;
        final AtomicReference<io.reactivex.disposables.b> resource;

        IntervalRangeSubscriber(org.a.c<? super Long> r3, long r4, long r6) {
            org.a.c<? super Long> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.resource = new AtomicReference();
            this.downstream = r5;
            this.count = r4;
            this.end = r6;
        }

        @Override // org.a.d
        public void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this, r2);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.resource.get() == DisposableHelper.DISPOSED) goto L18;
            long r0 = get();
            if (r0 == 0) goto L16;
            long r2 = this.count;
            this.downstream.onNext(Long.valueOf(r2));
            if (r2 == this.end) goto L9;
            this.count = r2 + 1;
            if (r0 == Long.MAX_VALUE) goto L19;
            decrementAndGet();
            return;
        L19:
            return;
        L9:
            if (this.resource.get() == DisposableHelper.DISPOSED) goto L11;
            this.downstream.onComplete();
        L11:
            DisposableHelper.dispose(this.resource);
            return;
        L16:
            this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
            return;
        }

        public void setResource(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.resource, r4);
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
    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> r9) {
        org.a.c r10 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r9, org.a.c.class, "com.obric.memorydata.plugin");
        IntervalRangeSubscriber r7 = new IntervalRangeSubscriber(r10, this.c, this.d);
        r10.onSubscribe(r7);
        u r0 = this.f16779b;
        if (ZeusTransformUtils.instanceOf(r0, k.class) == false) goto L5;
        u.c r1 = r0.a();
        r7.setResource(r1);
        r1.a(r7, this.e, this.f, this.g);
        return;
    L5:
        r7.setResource(r0.a(r7, this.e, this.f, this.g));
    }
}
