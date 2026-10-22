package kotlinx.coroutines.flow;

import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class u {
    public static final Object a(l1 r4, Function3 r5, Throwable r6, Continuation r7) {
        if ((r7 instanceof FlowKt__EmittersKt$invokeSafely$1) == false) goto L7;
        FlowKt__EmittersKt$invokeSafely$1 r0 = (FlowKt__EmittersKt$invokeSafely$1) r7;
        int r1 = r0.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (Throwable) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
    L20:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r6;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        if (r5.invoke(r4, r6, r0) != r2) goto L20;
        return r2;
    L22:
        th = move-exception;
        if (r6 == null) goto L26;
        if (r6 == th) goto L26;
        ExceptionsKt.addSuppressed(th, r6);
    L26:
        throw th;
    L7:
        r0 = new FlowKt__EmittersKt$invokeSafely$1(r7);
        goto L8
    }
}
