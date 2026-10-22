package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f18831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f18832b;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(g r5, Function2 r10) {
        this.f18831a = (SuspendLambda) r10;
        this.f18832b = r5;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r10, Continuation r11) {
        if ((r11 instanceof FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1) == false) goto L7;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r5 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L20;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SafeCollector r16 = (SafeCollector) r5.L$2;
        r10 = (h) r5.L$1;
        c0 r17 = (c0) r5.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L18
    L25:
        r16.releaseIntercepted();
        g r18 = r17.f18832b;
        r5.L$0 = null;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.label = 2;
        if (r18.collect(r10, r5) != r14) goto L29;
        return r14;
    L18:
        th = th;
    L32:
        r16.releaseIntercepted();
        throw th;
    L20:
        ResultKt.throwOnFailure(r13);
        SafeCollector r19 = new SafeCollector(r10, r5.getContext());
        ?? r20 = this.f18831a;     // Catch: Throwable -> L30
        r5.L$0 = this;     // Catch: Throwable -> L30
        r5.L$1 = r10;     // Catch: Throwable -> L30
        r5.L$2 = r19;     // Catch: Throwable -> L30
        r5.label = 1;     // Catch: Throwable -> L30
        InlineMarker.mark(6);     // Catch: Throwable -> L30
        Object r21 = r20.mo2invoke(r19, r5);     // Catch: Throwable -> L30
        InlineMarker.mark(7);     // Catch: Throwable -> L30
        if (r21 != r14) goto L24;
        return r14;
    L24:
        r17 = this;
        r16 = r19;
    L30:
        th = th;
        r16 = r19;
    L7:
        r5 = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1(this, r11);
        goto L8
    }
}
