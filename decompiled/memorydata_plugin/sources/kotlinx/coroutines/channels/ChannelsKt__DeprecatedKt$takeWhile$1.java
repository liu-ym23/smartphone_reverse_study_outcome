package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.obric.cae.userAware.WifiScanSceneType;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {WifiScanSceneType.ELEVATOR_END, 300, 301}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$takeWhile$1<E> extends SuspendLambda implements Function2<w<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ y<E> $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    ChannelsKt__DeprecatedKt$takeWhile$1(y<? extends E> r3, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r4, Continuation<? super ChannelsKt__DeprecatedKt$takeWhile$1> r5) {
        y<E> r6 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        Function2<E, Continuation<? super Boolean>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_takeWhile = r6;
        this.$predicate = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$takeWhile$1 r0 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super E> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$takeWhile$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00df -> B:13:0x0079). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        k<E> r2 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        w r6 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        ?? r7 = r6;
    L13:
        Continuation<? super Boolean> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r7;
        this.L$1 = r2;
        this.label = 1;
        r11 = r2.a(r12);
        ?? r8 = r7;
        if (r11 != r0) goto L17;
        return r0;
    L17:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L31;
        E r13 = r2.a();
        Function2<E, Continuation<? super Boolean>, Object> r9 = this.$predicate;
        this.L$0 = r8;
        this.L$1 = r2;
        this.L$2 = r13;
        this.label = 2;
        Object r10 = r9.invoke(r13, this);
        if (r10 != r0) goto L21;
        return r0;
    L21:
        k<E> r14 = r2;
        Object r3 = r13;
        r11 = r10;
        ?? r15 = r8;
        k<E> r16 = r14;
    L23:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L25;
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = null;
        this.label = 3;
        if (r15.send(r3, r17) != r0) goto L29;
        return r0;
    L29:
        r2 = r16;
        r7 = r15;
        goto L13
    L25:
        return Unit.INSTANCE;
    L31:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r3 = this.L$2;
        r16 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        w r18 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        r15 = r18;
        goto L23
    L11:
        r2 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        w r19 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        r8 = r19;
        goto L17
    L12:
        ResultKt.throwOnFailure(r11);
        w r110 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        r2 = this.$this_takeWhile.l();
        r7 = r110;
        goto L13
    }
}
