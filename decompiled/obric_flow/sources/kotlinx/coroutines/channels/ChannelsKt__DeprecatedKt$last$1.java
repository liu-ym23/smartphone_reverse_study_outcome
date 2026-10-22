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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {127, 130}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
final class ChannelsKt__DeprecatedKt$last$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$last$1(Continuation<? super ChannelsKt__DeprecatedKt$last$1> r5) {
        super(r5);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:26:0x006c). Please report as a decompilation issue!!! */
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
        throw null;     // Catch: Throwable -> L39
    L39:
        th = th;
    L46:
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        p.d(r14, th);
        throw th;
    L9:
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L17;
        Object r15 = this.L$2;
        k r16 = (k) this.L$1;
        w r17 = (w) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
        k r18 = r16;
    L26:
        if (((Boolean) r12).booleanValue() == false) goto L30;
        e r19 = (e) r18;     // Catch: Throwable -> L14
        r15 = r19.d();     // Catch: Throwable -> L14
        e r20 = r19;
    L23:
        this.L$0 = r17;     // Catch: Throwable -> L14
        this.L$1 = r20;     // Catch: Throwable -> L14
        this.L$2 = r15;     // Catch: Throwable -> L14
        this.label = 2;     // Catch: Throwable -> L14
        r12 = r20.c(this);     // Catch: Throwable -> L14
        r18 = r20;
        if (r12 != r5) goto L26;
        return r5;
    L30:
        r17.cancel(null);
        return r15;
    L14:
        th = th;
        r14 = r17;
        goto L46
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        k r21 = (k) this.L$1;
        w r22 = (w) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L35
        if (((Boolean) r12).booleanValue() == false) goto L34;
        e r23 = (e) r21;     // Catch: Throwable -> L35
        r17 = r22;
        r20 = r23;
        r15 = r23.d();     // Catch: Throwable -> L35
        goto L23
    L34:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L35
    L35:
        th = th;
        r14 = r22;
        goto L46
    L5:
        ChannelsKt__DeprecatedKt$last$1<E> this = new ChannelsKt__DeprecatedKt$last$1(this);
        goto L6
    }
}
