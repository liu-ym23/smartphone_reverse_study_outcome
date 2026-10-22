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
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {236}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.m<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ j<T> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> r3, j<? super T> r4, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> r5) {
        j<T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$lastValue = r3;
        this.$downstream = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__DelayKt$debounceInternal$1$3$2 r0 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.m<? extends Object> r3, Continuation<? super Unit> r4) {
        return m2910invokeWpGqRn0(((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m2910invokeWpGqRn0(Object r3, Continuation<? super Unit> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) ZeusTransformUtils.preCheckCast(create(kotlinx.coroutines.channels.m.i(r3), r5), FlowKt__DelayKt$debounceInternal$1$3$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 for r6v10 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r6.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        java.lang.Object r6 = r6.L$1;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlin.jvm.internal.Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6;
        kotlin.ResultKt.throwOnFailure(r7);
    L24:
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> r1 = r6;
    L25:
        kotlinx.coroutines.internal.aj r6 = kotlinx.coroutines.flow.internal.s.c;
        r1.element = r6;
    L27:
        kotlin.Unit r6 = kotlin.Unit.INSTANCE;
        return r6;
    L6:
        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r6;
    L8:
        kotlin.ResultKt.throwOnFailure(r7);
        java.lang.Object r7 = r6.L$0;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.m r7 = (kotlinx.coroutines.channels.m) r7;
        ?? r7 = r7.a();
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> r1 = r6.$lastValue;
        boolean r2 = com.volcengine.zeus.transform.ZeusTransformUtils.instanceOf(r7, kotlinx.coroutines.channels.m.c.class);
        if (r2 == true) goto L11;
        r1.element = r7;
    L11:
        r1 = r6.$lastValue;
        kotlinx.coroutines.flow.j<T> r2 = r6.$downstream;
        boolean r4 = com.volcengine.zeus.transform.ZeusTransformUtils.instanceOf(r7, kotlinx.coroutines.channels.m.c.class);
        if (r4 == false) goto L27;
        java.lang.Throwable r4 = kotlinx.coroutines.channels.m.e(r7);
        if (r4 != null) goto L26;
        java.lang.Object r4 = r1.element;
        if (r4 == null) goto L25;
        kotlinx.coroutines.internal.aj r4 = kotlinx.coroutines.flow.internal.s.f17463a;
        java.lang.Object r5 = r1.element;
        if (r5 != r4) goto L20;
        r5 = null;
    L20:
        r6.L$0 = r7;
        r6.L$1 = r1;
        r6.label = 1;
        T r5 = (T) r5;
        kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r6;
        java.lang.Object r6 = r2.emit(r5, r6);
        if (r6 != r0) goto L23;
        return r0;
    L23:
        r6 = r1;
        goto L24
    L26:
        throw r4;
    }
}
