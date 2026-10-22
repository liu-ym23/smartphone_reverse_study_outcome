package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f18840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.r f18841c;

    public d1(Ref.ObjectRef r5, CoroutineScope r10, kotlinx.coroutines.r r11) {
        this.f18839a = r5;
        this.f18840b = r10;
        this.f18841c = r11;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.flow.d2, kotlinx.coroutines.flow.q2] */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        Ref.ObjectRef r11 = this.f18839a;
        d2 r12 = (d2) r11.element;
        if (r12 == null) goto L5;
        ((q2) r12).i(r5);
    L7:
        return Unit.INSTANCE;
    L5:
        ?? r13 = i.b(r5);
        e2 r14 = new e2(r13, kotlinx.coroutines.j0.g(this.f18840b.getCoroutineContext()));
        ((kotlinx.coroutines.s) this.f18841c).N(r14);
        r11.element = r13;
        goto L7
    }
}
