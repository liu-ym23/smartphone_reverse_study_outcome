package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {179, 182}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$singleOrNull$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$singleOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$singleOrNull$1> r5) {
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
        throw null;     // Catch: Throwable -> L40
    L40:
        th = th;
    L49:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        p.d(r14, th);
        throw th;
    L9:
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L17;
        Object r15 = this.L$1;
        w r16 = (w) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L28:
        if (((Boolean) r12).booleanValue() == false) goto L31;
        r16.cancel(null);
    L55:
        return null;
    L31:
        r16.cancel(null);
        return r15;
    L14:
        th = th;
        r14 = r16;
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        k r17 = (k) this.L$1;
        w r18 = (w) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L34
        if (((Boolean) r12).booleanValue() == true) goto L53;
        r18.cancel(null);
        goto L55
    L53:
        e r19 = (e) r17;     // Catch: Throwable -> L36
        Object r20 = r19.d();     // Catch: Throwable -> L36
        this.L$0 = r18;     // Catch: Throwable -> L34
        this.L$1 = r20;     // Catch: Throwable -> L34
        this.label = 2;     // Catch: Throwable -> L34
        Object r21 = r19.c(this);     // Catch: Throwable -> L34
        if (r21 == r5) goto L56;
        r15 = r20;
        r12 = r21;
        r16 = r18;
        goto L28
    L56:
        return r5;
    L36:
        th = move-exception;
        th = th;
    L33:
        r14 = r18;
    L34:
        th = th;
        goto L33
    L5:
        ChannelsKt__DeprecatedKt$singleOrNull$1<E> this = new ChannelsKt__DeprecatedKt$singleOrNull$1(this);
        goto L6
    }
}
