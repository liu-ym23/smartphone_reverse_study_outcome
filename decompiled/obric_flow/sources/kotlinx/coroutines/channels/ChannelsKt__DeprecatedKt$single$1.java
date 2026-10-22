package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {166, 169}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$single$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$single$1(Continuation<? super ChannelsKt__DeprecatedKt$single$1> r5) {
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
        throw null;     // Catch: Throwable -> L41
    L41:
        th = th;
    L53:
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        p.d(r14, th);
        throw th;
    L9:
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L17;
        r5 = this.L$1;
        w r15 = (w) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L27:
        if (((Boolean) r12).booleanValue() == true) goto L31;
        r15.cancel(null);
    L29:
        return r5;
    L31:
        throw new IllegalArgumentException("ReceiveChannel has more than one element.");     // Catch: Throwable -> L14
    L14:
        th = th;
        r14 = r15;
        goto L53
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        k r16 = (k) this.L$1;
        w r17 = (w) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L33
        if (((Boolean) r12).booleanValue() == false) goto L38;
        e r18 = (e) r16;     // Catch: Throwable -> L35
        Object r19 = r18.d();     // Catch: Throwable -> L35
        this.L$0 = r17;     // Catch: Throwable -> L33
        this.L$1 = r19;     // Catch: Throwable -> L33
        this.label = 2;     // Catch: Throwable -> L33
        Object r20 = r18.c(this);     // Catch: Throwable -> L33
        if (r20 == r5) goto L29;
        r5 = r19;
        r12 = r20;
        r15 = r17;
    L35:
        th = move-exception;
        th = th;
    L32:
        r14 = r17;
        goto L53
    L38:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L32
    L5:
        ChannelsKt__DeprecatedKt$single$1<E> this = new ChannelsKt__DeprecatedKt$single$1(this);
        goto L6
    }
}
