package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {41}, m = "consumeEach", n = {"action", "channel$iv"}, s = {"L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$consumeEach$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$consumeEach$1(Continuation<? super ChannelsKt__DeprecatedKt$consumeEach$1> r5) {
        super(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.k] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, kotlinx.coroutines.channels.e] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label = (this.label | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 != 0) goto L5;
        ResultKt.throwOnFailure(r10);
        throw null;
    L5:
        if (r11 != 1) goto L21;
        ?? r12 = (k) this.L$2;
        w r13 = (w) this.L$1;
        Function1 r14 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r10).booleanValue() == false) goto L15;
        r12 = (e) r12;     // Catch: Throwable -> L13
        r14.invoke(r12.d());     // Catch: Throwable -> L13
        this.L$0 = r14;     // Catch: Throwable -> L13
        this.L$1 = r13;     // Catch: Throwable -> L13
        this.L$2 = r12;     // Catch: Throwable -> L13
        this.label = 1;     // Catch: Throwable -> L13
        r10 = r12.c(this);     // Catch: Throwable -> L13
        if (r10 != r5) goto L9;
        return r5;
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        r13.cancel(null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r13.cancel(null);
        InlineMarker.finallyEnd(1);
        throw th;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
