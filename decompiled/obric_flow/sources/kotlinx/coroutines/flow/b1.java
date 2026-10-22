package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class b1 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18829a;

    public b1(Ref.ObjectRef r5) {
        this.f18829a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, g8.g] */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        Ref.ObjectRef r11 = this.f18829a;
        T r12 = r11.element;
        ?? r13 = kotlinx.coroutines.flow.internal.b.f18863b;
        if (r12 != r13) goto L6;
        r11.element = r5;
        return Unit.INSTANCE;
    L6:
        r11.element = r13;
        throw new AbortFlowException(this);
    }
}
