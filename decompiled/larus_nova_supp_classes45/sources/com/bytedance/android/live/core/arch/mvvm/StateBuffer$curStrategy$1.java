package com.bytedance.android.live.core.arch.mvvm;

import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "p1", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class StateBuffer$curStrategy$1 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    public StateBuffer$curStrategy$1(StateBuffer r8) {
        super(1, r8, StateBuffer.class, "processState", "processState(Ljava/lang/Object;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m563invoke(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        StateBuffer r0 = (StateBuffer) ((CallableReference) this).receiver;
        r0.a.invoke(r3);
        PublishSubject<T> r1 = r0.b;
        Intrinsics.checkNotNull(r3);
        r1.onNext(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m563invoke(r1);
        return Unit.INSTANCE;
    }
}
