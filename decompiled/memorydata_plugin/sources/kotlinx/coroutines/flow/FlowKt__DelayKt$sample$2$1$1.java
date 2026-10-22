package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "result", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.m<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    final /* synthetic */ kotlinx.coroutines.channels.y<Unit> $ticker;
    /* synthetic */ Object L$0;
    int label;

    FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> r3, kotlinx.coroutines.channels.y<Unit> r4, Continuation<? super FlowKt__DelayKt$sample$2$1$1> r5) {
        kotlinx.coroutines.channels.y<Unit> r6 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$lastValue = r3;
        this.$ticker = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__DelayKt$sample$2$1$1 r0 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.m<? extends Object> r3, Continuation<? super Unit> r4) {
        return m2911invokeWpGqRn0(((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m2911invokeWpGqRn0(Object r3, Continuation<? super Unit> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((FlowKt__DelayKt$sample$2$1$1) ZeusTransformUtils.preCheckCast(create(kotlinx.coroutines.channels.m.i(r3), r5), FlowKt__DelayKt$sample$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [T, kotlinx.coroutines.internal.aj] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        ?? r5 = ((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a();
        Ref.ObjectRef<Object> r0 = this.$lastValue;
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.channels.m.c.class) == true) goto L7;
        r0.element = r5;
    L7:
        kotlinx.coroutines.channels.y<Unit> r1 = this.$ticker;
        Ref.ObjectRef<Object> r3 = this.$lastValue;
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.channels.m.c.class) == false) goto L14;
        Throwable r6 = kotlinx.coroutines.channels.m.e(r5);
        if (r6 != null) goto L12;
        r1.a((CancellationException) ZeusTransformUtils.preCheckCast(new ChildCancelledException(), CancellationException.class, "com.obric.memorydata.plugin"));
        r3.element = kotlinx.coroutines.flow.internal.s.c;
        goto L14
    L12:
        throw r6;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
