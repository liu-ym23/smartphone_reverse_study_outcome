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

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {517, WifiScanSceneType.GEO_END, 501}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$zip$2<V> extends SuspendLambda implements Function2<w<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ y<R> $other;
    final /* synthetic */ y<E> $this_zip;
    final /* synthetic */ Function2<E, R, V> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    ChannelsKt__DeprecatedKt$zip$2(y<? extends R> r3, y<? extends E> r4, Function2<? super E, ? super R, ? extends V> r5, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> r6) {
        y<R> r7 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        y<E> r8 = (y) ZeusTransformUtils.wrapperContextForParams(r4, y.class, "com.obric.memorydata.plugin");
        Function2<E, R, V> r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$other = r7;
        this.$this_zip = r8;
        this.$transform = r9;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$zip$2 r0 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super V> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$zip$2) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$zip$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        k r2 = (k) ZeusTransformUtils.preCheckCast(this.L$4, k.class, "com.obric.memorydata.plugin");
        y r7 = (y) ZeusTransformUtils.preCheckCast(this.L$3, y.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.preCheckCast(this.L$2, Function2.class, "com.obric.memorydata.plugin");
        k r9 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        w r10 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L40
    L22:
        this.L$0 = r10;     // Catch: Throwable -> L40
        this.L$1 = r9;     // Catch: Throwable -> L40
        this.L$2 = r8;     // Catch: Throwable -> L40
        this.L$3 = r7;     // Catch: Throwable -> L40
        this.L$4 = r2;     // Catch: Throwable -> L40
        this.L$5 = null;     // Catch: Throwable -> L40
        this.label = 1;     // Catch: Throwable -> L40
        r15 = r2.a(this);     // Catch: Throwable -> L40
        if (r15 != r0) goto L26;
        return r0;
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L37;
        Object r16 = r2.a();     // Catch: Throwable -> L40
        this.L$0 = r10;     // Catch: Throwable -> L40
        this.L$1 = r9;     // Catch: Throwable -> L40
        this.L$2 = r8;     // Catch: Throwable -> L40
        this.L$3 = r7;     // Catch: Throwable -> L40
        this.L$4 = r2;     // Catch: Throwable -> L40
        this.L$5 = r16;     // Catch: Throwable -> L40
        this.label = 2;     // Catch: Throwable -> L40
        Object r11 = r9.a(this);     // Catch: Throwable -> L40
        if (r11 != r0) goto L30;
        return r0;
    L30:
        y r13 = r7;
        Object r12 = r16;
        r15 = r11;
        w r14 = r10;
        k r17 = r9;
        Function2 r18 = r8;
        y r19 = r13;
    L31:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L36;
        Object r110 = r18.invoke(r12, r17.a());     // Catch: Throwable -> L15
        this.L$0 = r14;     // Catch: Throwable -> L15
        this.L$1 = r17;     // Catch: Throwable -> L15
        this.L$2 = r18;     // Catch: Throwable -> L15
        this.L$3 = r19;     // Catch: Throwable -> L15
        this.L$4 = r2;     // Catch: Throwable -> L15
        this.L$5 = null;     // Catch: Throwable -> L15
        this.label = 3;     // Catch: Throwable -> L15
        if (r14.send(r110, this) != r0) goto L36;
        return r0;
    L36:
        r7 = r19;
        r8 = r18;
        r9 = r17;
        r10 = r14;
        goto L22
    L51:
        r7 = r19;
        r8 = r18;
        r9 = r17;
        r10 = r14;
    L15:
        th = th;
        r7 = r19;
    L47:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        o.a(r7, th);
        throw th;
    L37:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L40
        o.a(r7, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Object r3 = this.L$5;
        k r20 = (k) ZeusTransformUtils.preCheckCast(this.L$4, k.class, "com.obric.memorydata.plugin");
        r19 = (y) ZeusTransformUtils.preCheckCast(this.L$3, y.class, "com.obric.memorydata.plugin");
        r18 = (Function2) ZeusTransformUtils.preCheckCast(this.L$2, Function2.class, "com.obric.memorydata.plugin");
        r17 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        r14 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
        r12 = r3;
        r2 = r20;
        goto L31
    L17:
        r2 = (k) ZeusTransformUtils.preCheckCast(this.L$4, k.class, "com.obric.memorydata.plugin");
        r7 = (y) ZeusTransformUtils.preCheckCast(this.L$3, y.class, "com.obric.memorydata.plugin");
        r8 = (Function2) ZeusTransformUtils.preCheckCast(this.L$2, Function2.class, "com.obric.memorydata.plugin");
        r9 = (k) ZeusTransformUtils.preCheckCast(this.L$1, k.class, "com.obric.memorydata.plugin");
        r10 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L40
        goto L26
    L20:
        ResultKt.throwOnFailure(r15);
        w r112 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        k r4 = this.$other.l();
        r7 = this.$this_zip;
        r8 = this.$transform;
        r10 = r112;
        r9 = r4;
        r2 = r7.l();     // Catch: Throwable -> L40
    L40:
        th = th;
        goto L47
    }
}
