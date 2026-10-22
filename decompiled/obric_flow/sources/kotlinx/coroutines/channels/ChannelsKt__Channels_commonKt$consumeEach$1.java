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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {161}, m = "consumeEach", n = {"action", "$this$consume$iv"}, s = {"L$0", "L$1"})
final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$consumeEach$1(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$1> r5) {
        super(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.k] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, kotlinx.coroutines.channels.e] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        int r11 = this.label | Integer.MIN_VALUE;
        this.label = r11;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r11 - Integer.MIN_VALUE;
    L6:
        Object r12 = this.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = this.label;
        w r14 = null;
        if (r13 == 0) goto L24;
        if (r13 != 1) goto L23;
        ?? r15 = (k) this.L$2;
        w r16 = (w) this.L$1;
        Function1 r17 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L17
    L12:
        if (((Boolean) r12).booleanValue() == false) goto L19;
        r15 = (e) r15;     // Catch: Throwable -> L17
        r17.invoke(r15.d());     // Catch: Throwable -> L17
        this.L$0 = r17;     // Catch: Throwable -> L17
        this.L$1 = r16;     // Catch: Throwable -> L17
        this.L$2 = r15;     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        r12 = r15.c(this);     // Catch: Throwable -> L17
        if (r12 != r5) goto L12;
        return r5;
    L19:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L17
        InlineMarker.finallyStart(1);
        r16.cancel(null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L17:
        th = th;
        r14 = r16;
    L33:
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        InlineMarker.finallyStart(1);
        p.d(r14, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        ResultKt.throwOnFailure(r12);
        throw null;     // Catch: Throwable -> L26
    L26:
        th = th;
        goto L33
    L5:
        ChannelsKt__Channels_commonKt$consumeEach$1<E> this = new ChannelsKt__Channels_commonKt$consumeEach$1(this);
        goto L6
    }
}
