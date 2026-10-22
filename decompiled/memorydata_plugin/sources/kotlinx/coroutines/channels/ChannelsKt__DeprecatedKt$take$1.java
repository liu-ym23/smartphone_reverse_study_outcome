package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {284, 285}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$take$1<E> extends SuspendLambda implements Function2<w<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ y<E> $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    ChannelsKt__DeprecatedKt$take$1(int r3, y<? extends E> r4, Continuation<? super ChannelsKt__DeprecatedKt$take$1> r5) {
        y<E> r6 = (y) ZeusTransformUtils.wrapperContextForParams(r4, y.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$n = r3;
        this.$this_take = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$take$1 r0 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super E> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$take$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$take$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00af -> B:7:0x0029). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        int r2 = this.I$0;
        k<E> r5 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        w r6 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L7:
        w r11 = r6;
        r2 = r2 - 1;
        if (r2 == 0) goto L32;
    L20:
        Continuation<? super Boolean> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r11;
        this.L$1 = r5;
        this.I$0 = r2;
        this.label = 1;
        Object r8 = r5.a(r7);
        if (r8 != r0) goto L23;
        return r0;
    L23:
        r6 = r11;
        r10 = r8;
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L34;
        E r12 = r5.a();
        Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r6;
        this.L$1 = r5;
        this.I$0 = r2;
        this.label = 2;
        if (r6.send(r12, r9) != r0) goto L7;
        return r0;
    L34:
        return Unit.INSTANCE;
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = this.I$0;
        r5 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        r6 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
        goto L25
    L11:
        ResultKt.throwOnFailure(r10);
        r11 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        r2 = this.$n;
        if (r2 == 0) goto L14;
        if (r2 < 0) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == false) goto L36;
        r5 = this.$this_take.l();
        goto L20
    L36:
        throw new IllegalArgumentException(("Requested element count " + r2 + " is less than zero.").toString());
    L17:
        r13 = false;
        goto L18
    L14:
        return Unit.INSTANCE;
    }
}
