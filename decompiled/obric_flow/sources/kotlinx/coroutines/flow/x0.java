package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18913a;

    public x0(Ref.ObjectRef r5) {
        this.f18913a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        this.f18913a.element = r5;
        throw new AbortFlowException(this);
    }
}
