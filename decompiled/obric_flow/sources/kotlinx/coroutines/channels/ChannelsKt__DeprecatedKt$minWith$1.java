package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {464, 466}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$minWith$1(Continuation<? super ChannelsKt__DeprecatedKt$minWith$1> r5) {
        super(r5);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007a -> B:28:0x007d). Please report as a decompilation issue!!! */
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
    L45:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        p.d(r14, th);
        throw th;
    L9:
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L17;
        Object r15 = this.L$3;
        k r16 = (k) this.L$2;
        w r17 = (w) this.L$1;
        Comparator r18 = (Comparator) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
        k r19 = r16;
    L28:
        if (((Boolean) r12).booleanValue() == false) goto L33;
        e r20 = (e) r19;     // Catch: Throwable -> L14
        Object r21 = r20.d();     // Catch: Throwable -> L14
        e r22 = r20;
        e r23 = r20;
        if (r18.compare(r15, r21) > 0) goto L24;
    L25:
        this.L$0 = r18;     // Catch: Throwable -> L14
        this.L$1 = r17;     // Catch: Throwable -> L14
        this.L$2 = r22;     // Catch: Throwable -> L14
        this.L$3 = r15;     // Catch: Throwable -> L14
        this.label = 2;     // Catch: Throwable -> L14
        r12 = r22.c(this);     // Catch: Throwable -> L14
        r19 = r22;
        if (r12 != r5) goto L28;
        return r5;
    L24:
        r15 = r21;
        r22 = r23;
        goto L25
    L33:
        r17.cancel(null);
        return r15;
    L14:
        th = th;
        r14 = r17;
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        k r24 = (k) this.L$2;
        w r25 = (w) this.L$1;
        Comparator r26 = (Comparator) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L36
        if (((Boolean) r12).booleanValue() == true) goto L22;
        r25.cancel(null);
        return null;
    L22:
        e r27 = (e) r24;     // Catch: Throwable -> L36
        r21 = r27.d();     // Catch: Throwable -> L36
        r18 = r26;
        r17 = r25;
        r23 = r27;
    L36:
        th = th;
        r14 = r25;
        goto L45
    L5:
        ChannelsKt__DeprecatedKt$minWith$1<E> this = new ChannelsKt__DeprecatedKt$minWith$1(this);
        goto L6
    }
}
