package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {477}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
final class ChannelsKt__DeprecatedKt$none$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$none$1(Continuation<? super ChannelsKt__DeprecatedKt$none$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r10 = this.label | Integer.MIN_VALUE;
        this.label = r10;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r10 - Integer.MIN_VALUE;
    L6:
        Object r11 = this.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        w r13 = null;
        if (r12 != 0) goto L9;
        ResultKt.throwOnFailure(r11);
        throw null;     // Catch: Throwable -> L20
    L20:
        th = th;
    L29:
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        p.d(r13, th);
        throw th;
    L9:
        if (r12 != 1) goto L17;
        w r14 = (w) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
        Boolean r15 = Boxing.boxBoolean(!((Boolean) r11).booleanValue());     // Catch: Throwable -> L14
        r14.cancel(null);
        return r15;
    L14:
        th = th;
        r13 = r14;
        goto L29
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        ChannelsKt__DeprecatedKt$none$1<E> this = new ChannelsKt__DeprecatedKt$none$1(this);
        goto L6
    }
}
