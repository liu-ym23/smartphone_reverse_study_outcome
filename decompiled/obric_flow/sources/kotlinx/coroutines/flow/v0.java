package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18909a;

    public v0(Ref.ObjectRef r5) {
        this.f18909a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        this.f18909a.element = r5;
        throw new AbortFlowException(this);
    }
}
