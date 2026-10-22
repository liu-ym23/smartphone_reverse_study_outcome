package kotlinx.coroutines.channels;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {209}, m = "toList", n = {"$this$toList_u24lambda_u242", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
final class ChannelsKt__Channels_commonKt$toList$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$toList$1(Continuation<? super ChannelsKt__Channels_commonKt$toList$1> r5) {
        super(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.k] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, kotlinx.coroutines.channels.e] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.List] */
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
        CollectionsKt.createListBuilder();
        throw null;     // Catch: Throwable -> L27
    L27:
        th = th;
    L34:
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        p.d(r14, th);
        throw th;
    L9:
        if (r13 != 1) goto L24;
        ?? r15 = (k) this.L$3;
        w r16 = (w) this.L$2;
        ?? r17 = (List) this.L$1;
        List r18 = (List) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L18
    L13:
        if (((Boolean) r12).booleanValue() == false) goto L20;
        r15 = (e) r15;     // Catch: Throwable -> L18
        r17.add(r15.d());     // Catch: Throwable -> L18
        this.L$0 = r18;     // Catch: Throwable -> L18
        this.L$1 = r17;     // Catch: Throwable -> L18
        this.L$2 = r16;     // Catch: Throwable -> L18
        this.L$3 = r15;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r12 = r15.c(this);     // Catch: Throwable -> L18
        if (r12 != r5) goto L13;
        return r5;
    L20:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r16.cancel(null);
        return CollectionsKt.build(r18);
    L18:
        th = th;
        r14 = r16;
        goto L34
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        ChannelsKt__Channels_commonKt$toList$1<E> this = new ChannelsKt__Channels_commonKt$toList$1(this);
        goto L6
    }
}
