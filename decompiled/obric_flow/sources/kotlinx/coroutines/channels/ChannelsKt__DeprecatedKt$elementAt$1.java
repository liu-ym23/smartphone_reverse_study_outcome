package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {68}, m = "elementAt", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$elementAt$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAt$1> r5) {
        super(r5);
    }

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
        if (r13 != 0) goto L9;
        ResultKt.throwOnFailure(r12);
        throw null;     // Catch: Throwable -> L31
    L31:
        th = th;
    L40:
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        p.d(r14, th);
        throw th;
    L9:
        if (r13 != 1) goto L28;
        int r15 = this.I$1;
        int r16 = this.I$0;
        k r17 = (k) this.L$1;
        w r18 = (w) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L23
        Object r19 = r17;
    L13:
        if (((Boolean) r12).booleanValue() == false) goto L26;
        e r20 = (e) r19;     // Catch: Throwable -> L23
        Object r110 = r20.d();     // Catch: Throwable -> L23
        int r21 = r15 + 1;
        if (r16 == r15) goto L17;
        this.L$0 = r18;     // Catch: Throwable -> L23
        this.L$1 = r20;     // Catch: Throwable -> L23
        this.I$0 = r16;     // Catch: Throwable -> L23
        this.I$1 = r21;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        r12 = r20.c(this);     // Catch: Throwable -> L23
        if (r12 == r5) goto L45;
        r15 = r21;
        r19 = r20;
        goto L13
    L45:
        return r5;
    L17:
        r18.cancel(null);
        return r110;
    L26:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r16 + '.');     // Catch: Throwable -> L23
    L23:
        th = th;
        r14 = r18;
        goto L40
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        ChannelsKt__DeprecatedKt$elementAt$1<E> this = new ChannelsKt__DeprecatedKt$elementAt$1(this);
        goto L6
    }
}
