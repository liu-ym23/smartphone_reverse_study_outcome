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

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {517, 363, 363}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
final class ChannelsKt__DeprecatedKt$map$1<R> extends SuspendLambda implements Function2<w<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ y<E> $this_map;
    final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    ChannelsKt__DeprecatedKt$map$1(y<? extends E> r3, Function2<? super E, ? super Continuation<? super R>, ? extends Object> r4, Continuation<? super ChannelsKt__DeprecatedKt$map$1> r5) {
        y<E> r6 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        Function2<E, Continuation<? super R>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_map = r6;
        this.$transform = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$map$1 r0 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super R> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$map$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$map$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x011a -> B:22:0x00c9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        k r2 = (k) ZeusTransformUtils.preCheckCast(this.L$3, k.class, "com.obric.memorydata.plugin");
        y r7 = (y) ZeusTransformUtils.preCheckCast(this.L$2, y.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.preCheckCast(this.L$1, Function2.class, "com.obric.memorydata.plugin");
        w r9 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L39
        w r15 = r9;
    L22:
        this.L$0 = r15;     // Catch: Throwable -> L39
        this.L$1 = r8;     // Catch: Throwable -> L39
        this.L$2 = r7;     // Catch: Throwable -> L39
        this.L$3 = r2;     // Catch: Throwable -> L39
        this.label = 1;     // Catch: Throwable -> L39
        Object r10 = r2.a(this);     // Catch: Throwable -> L39
        if (r10 != r0) goto L25;
        return r0;
    L25:
        w r11 = r15;
        r14 = r10;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L36;
        Object r16 = r2.a();     // Catch: Throwable -> L39
        this.L$0 = r11;     // Catch: Throwable -> L39
        this.L$1 = r8;     // Catch: Throwable -> L39
        this.L$2 = r7;     // Catch: Throwable -> L39
        this.L$3 = r2;     // Catch: Throwable -> L39
        this.L$4 = r11;     // Catch: Throwable -> L39
        this.label = 2;     // Catch: Throwable -> L39
        r14 = r8.invoke(r16, this);     // Catch: Throwable -> L39
        if (r14 != r0) goto L31;
        return r0;
    L31:
        w r12 = r11;
        Function2 r13 = r8;
        y r17 = r7;
        k r18 = r2;
        w r3 = r12;
    L32:
        this.L$0 = r12;     // Catch: Throwable -> L15
        this.L$1 = r13;     // Catch: Throwable -> L15
        this.L$2 = r17;     // Catch: Throwable -> L15
        this.L$3 = r18;     // Catch: Throwable -> L15
        this.L$4 = null;     // Catch: Throwable -> L15
        this.label = 3;     // Catch: Throwable -> L15
        if (r3.send(r14, this) != r0) goto L35;
        return r0;
    L35:
        r2 = r18;
        r7 = r17;
        r8 = r13;
        r15 = r12;
    L15:
        th = th;
        r7 = r17;
    L48:
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        o.a(r7, th);
        throw th;
    L36:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L39
        o.a(r7, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r3 = (w) ZeusTransformUtils.preCheckCast(this.L$4, w.class, "com.obric.memorydata.plugin");
        r18 = (k) ZeusTransformUtils.preCheckCast(this.L$3, k.class, "com.obric.memorydata.plugin");
        r17 = (y) ZeusTransformUtils.preCheckCast(this.L$2, y.class, "com.obric.memorydata.plugin");
        r13 = (Function2) ZeusTransformUtils.preCheckCast(this.L$1, Function2.class, "com.obric.memorydata.plugin");
        r12 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
        goto L32
    L17:
        r2 = (k) ZeusTransformUtils.preCheckCast(this.L$3, k.class, "com.obric.memorydata.plugin");
        r7 = (y) ZeusTransformUtils.preCheckCast(this.L$2, y.class, "com.obric.memorydata.plugin");
        r8 = (Function2) ZeusTransformUtils.preCheckCast(this.L$1, Function2.class, "com.obric.memorydata.plugin");
        r11 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L39
        goto L27
    L20:
        ResultKt.throwOnFailure(r14);
        r15 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        r7 = this.$this_map;
        Function2 r4 = this.$transform;
        r8 = r4;
        r2 = r7.l();     // Catch: Throwable -> L39
    L39:
        th = th;
        goto L48
    }
}
