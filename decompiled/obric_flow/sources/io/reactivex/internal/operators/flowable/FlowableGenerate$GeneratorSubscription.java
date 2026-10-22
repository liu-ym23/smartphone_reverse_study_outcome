package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableGenerate$GeneratorSubscription<T, S> extends AtomicLong implements mt.d, zu.d {
    private static final long serialVersionUID = 7565982551505011832L;
    volatile boolean cancelled;
    final pt.g disposeState;
    final zu.c downstream;
    final pt.c generator;
    boolean hasNext;
    S state;
    boolean terminate;

    public FlowableGenerate$GeneratorSubscription(zu.c r5, pt.c r10, pt.g r11, S r12) {
        this.downstream = r5;
        this.generator = r10;
        this.disposeState = r11;
        this.state = r12;
    }

    public final void a(Object r5) {
        this.disposeState.accept(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        if (v0.r(this, 1) != 0) goto L9;
        S r5 = this.state;
        this.state = null;
        a(r5);
        return;
    L9:
        return;
    }

    @Override // mt.d
    public void onComplete() {
        if (this.terminate == true) goto L6;
        this.terminate = true;
        this.downstream.onComplete();
        return;
    }

    @Override // mt.d
    public void onError(Throwable r5) {
        if (this.terminate == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L7:
        this.terminate = true;
        this.downstream.onError(r5);
    }

    @Override // mt.d
    public void onNext(T r5) {
        if (this.terminate == false) goto L5;
        return;
    L5:
        if (this.hasNext == false) goto L7;
        onError(new IllegalStateException("onNext already called in this generate turn"));
        return;
    L7:
        if (r5 != null) goto L9;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L9:
        this.hasNext = true;
        this.downstream.onNext(r5);
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
    @Override // zu.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L6;
        return;
    L6:
        if (v0.r(this, r10) == 0) goto L8;
        return;
    L8:
        S r5 = this.state;
        pt.c r11 = this.generator;
    L9:
        long r12 = 0;
    L11:
        if (r12 != r10) goto L13;
        r10 = get();
        if (r12 != r10) goto L11;
        this.state = r5;
        r10 = addAndGet(-r12);
        if (r10 != 0) goto L9;
        return;
    L13:
        if (this.cancelled == true) goto L14;
        this.hasNext = false;
        r5 = (S) r11.apply(r5, this);
        if (this.terminate == true) goto L20;
        r12 = r12 + 1;
        goto L11
    L20:
        this.cancelled = true;
        this.state = null;
        a(r5);
        return;
    L23:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.cancelled = true;
        this.state = null;
        onError(th);
        a(r5);
        return;
    L14:
        this.state = null;
        a(r5);
    }
}
