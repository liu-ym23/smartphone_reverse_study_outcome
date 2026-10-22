package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {241, 242, 242}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1<E> extends SuspendLambda implements Function2<w<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ y<E> $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    ChannelsKt__DeprecatedKt$filterIndexed$1(y<? extends E> r3, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> r4, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> r5) {
        y<E> r6 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        Function3<Integer, E, Continuation<? super Boolean>, Object> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_filterIndexed = r6;
        this.$predicate = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$filterIndexed$1 r0 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super E> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$filterIndexed$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v18, types: [kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        int r2 = this.I$0;
        k<E> r7 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        ?? r8 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L13:
        Continuation<? super Boolean> r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r8;
        this.L$1 = r7;
        this.L$2 = null;
        this.I$0 = r2;
        this.label = 1;
        r13 = r7.a(r14);
        ?? r9 = r8;
        if (r13 != r0) goto L17;
        return r0;
    L17:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L29;
        E r15 = r7.a();
        Function3<Integer, E, Continuation<? super Boolean>, Object> r10 = this.$predicate;
        int r11 = r2 + 1;
        Integer r3 = Boxing.boxInt(r2);
        this.L$0 = r9;
        this.L$1 = r7;
        this.L$2 = r15;
        this.I$0 = r11;
        this.label = 2;
        Object r4 = r10.invoke(r3, r15, this);
        if (r4 != r0) goto L21;
        return r0;
    L21:
        ?? r12 = r9;
        Object r16 = r15;
        r13 = r4;
        r2 = r11;
    L23:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L27;
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r12;
        this.L$1 = r7;
        this.L$2 = null;
        this.I$0 = r2;
        this.label = 3;
        if (r12.send(r16, r17) != r0) goto L27;
        return r0;
    L27:
        r8 = r12;
        goto L13
    L30:
        r8 = r12;
        goto L13
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = this.I$0;
        Object r18 = this.L$2;
        k<E> r19 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        w r20 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
        r16 = r18;
        r7 = r19;
        r12 = r20;
        goto L23
    L11:
        r2 = this.I$0;
        r7 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        w r21 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
        r9 = r21;
        goto L17
    L12:
        ResultKt.throwOnFailure(r13);
        w r110 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        r2 = 0;
        r7 = this.$this_filterIndexed.l();
        r8 = r110;
        goto L13
    }
}
