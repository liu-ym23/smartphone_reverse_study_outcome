package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {395}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
final class FlowKt__DelayKt$timeoutInternal$1$1$1<T> extends SuspendLambda implements Function2<kotlinx.coroutines.channels.m<? extends T>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ j<T> $downStream;
    /* synthetic */ Object L$0;
    int label;

    FlowKt__DelayKt$timeoutInternal$1$1$1(j<? super T> r3, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> r4) {
        j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$downStream = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__DelayKt$timeoutInternal$1$1$1 r0 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Boolean> r4) {
        return m2912invokeWpGqRn0(((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m2912invokeWpGqRn0(Object r3, Continuation<? super Boolean> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) ZeusTransformUtils.preCheckCast(create(kotlinx.coroutines.channels.m.i(r3), r5), FlowKt__DelayKt$timeoutInternal$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1<T> for r4v12 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r4.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        java.lang.Object r4 = r4.L$0;
        kotlin.ResultKt.throwOnFailure(r5);
    L14:
        java.lang.Object r5 = r4;
    L15:
        boolean r4 = com.volcengine.zeus.transform.ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.channels.m.a.class);
        if (r4 == false) goto L22;
        java.lang.Throwable r4 = kotlinx.coroutines.channels.m.e(r5);
        if (r4 != null) goto L21;
        java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false);
        return r4;
    L21:
        throw r4;
    L22:
        java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
        return r4;
    L6:
        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r4;
    L8:
        kotlin.ResultKt.throwOnFailure(r5);
        java.lang.Object r5 = r4.L$0;
        java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.m r5 = (kotlinx.coroutines.channels.m) r5;
        r5 = r5.a();
        kotlinx.coroutines.flow.j<T> r1 = r4.$downStream;
        boolean r3 = com.volcengine.zeus.transform.ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.channels.m.c.class);
        if (r3 == true) goto L15;
        r4.L$0 = r5;
        r4.label = 1;
        T r5 = (T) r5;
        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4;
        java.lang.Object r4 = r1.emit(r5, r4);
        if (r4 != r0) goto L13;
        return r0;
    L13:
        r4 = r5;
        goto L14
    }
}
