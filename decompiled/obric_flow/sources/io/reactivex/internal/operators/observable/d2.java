package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class d2 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.z f17757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17759c;
    public final TimeUnit d;

    public d2(long r5, long r10, TimeUnit r11, mt.z r12) {
        this.f17758b = r5;
        this.f17759c = r10;
        this.d = r11;
        this.f17757a = r12;
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
    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        ObservableInterval$IntervalObserver r11 = new ObservableInterval$IntervalObserver(r10);
        r10.onSubscribe(r11);
        mt.z r5 = this.f17757a;
        if ((r5 instanceof io.reactivex.internal.schedulers.s) == false) goto L5;
        ((io.reactivex.internal.schedulers.s) r5).getClass();
        io.reactivex.internal.schedulers.r r12 = new io.reactivex.internal.schedulers.r();
        r11.setResource(r12);
        TimeUnit r13 = this.d;
        r12.c(r11, this.f17758b, this.f17759c, r13);
        return;
    L5:
        TimeUnit r14 = this.d;
        r11.setResource(r5.e(r11, this.f17758b, this.f17759c, r14));
    }
}
