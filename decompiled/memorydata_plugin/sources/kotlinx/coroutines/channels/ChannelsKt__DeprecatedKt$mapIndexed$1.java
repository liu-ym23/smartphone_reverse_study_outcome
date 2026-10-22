package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {374, 375, 375}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$mapIndexed$1<R> extends SuspendLambda implements Function2<w<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ y<E> $this_mapIndexed;
    final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    ChannelsKt__DeprecatedKt$mapIndexed$1(y<? extends E> r3, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> r4, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> r5) {
        y<E> r6 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        Function3<Integer, E, Continuation<? super R>, Object> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_mapIndexed = r6;
        this.$transform = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$mapIndexed$1 r0 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super R> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$mapIndexed$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ec -> B:13:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1<R> for r12v3 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r12.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L8;
        int r1 = r12.I$0;
        java.lang.Object r6 = r12.L$1;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) r6;
        java.lang.Object r7 = r12.L$0;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.w r7 = (kotlinx.coroutines.channels.w) r7;
        kotlin.ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.channels.w r13 = r7;
    L13:
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r12, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation<? super java.lang.Boolean> r7 = (kotlin.coroutines.Continuation) r7;
        r12.L$0 = r13;
        r12.L$1 = r6;
        r12.I$0 = r1;
        r12.label = 1;
        java.lang.Object r7 = r6.a(r7);
        if (r7 != r0) goto L16;
        return r0;
    L16:
        kotlinx.coroutines.channels.w r7 = r13;
        r13 = r7;
    L17:
        java.lang.Object r13 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r13, java.lang.Boolean.class, "com.obric.memorydata.plugin");
        java.lang.Boolean r13 = (java.lang.Boolean) r13;
        boolean r13 = r13.booleanValue();
        if (r13 == false) goto L27;
        java.lang.Object r13 = r6.a();
        kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r8 = r12.$transform;
        int r9 = r1 + 1;
        java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1);
        r12.L$0 = r7;
        r12.L$1 = r6;
        r12.L$2 = r7;
        r12.I$0 = r9;
        r12.label = 2;
        E r13 = (E) r13;
        java.lang.Object r12 = (kotlin.coroutines.Continuation<? super R>) r12;
        r13 = r8.invoke(r1, r13, r12);
        if (r13 != r0) goto L22;
        return r0;
    L22:
        kotlinx.coroutines.channels.w r8 = r7;
        r1 = r9;
        kotlinx.coroutines.channels.k r7 = r6;
        kotlinx.coroutines.channels.w r6 = r8;
    L23:
        java.lang.Object r9 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r12, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation<? super kotlin.Unit> r9 = (kotlin.coroutines.Continuation) r9;
        r12.L$0 = r8;
        r12.L$1 = r7;
        r12.L$2 = null;
        r12.I$0 = r1;
        r12.label = 3;
        java.lang.Object r13 = r6.send(r13, r9);
        if (r13 != r0) goto L26;
        return r0;
    L26:
        r6 = r7;
        r13 = r8;
        goto L13
    L27:
        kotlin.Unit r12 = kotlin.Unit.INSTANCE;
        return r12;
    L8:
        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r12;
    L10:
        r1 = r12.I$0;
        java.lang.Object r6 = r12.L$2;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        r6 = (kotlinx.coroutines.channels.w) r6;
        java.lang.Object r7 = r12.L$1;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r7 = (kotlinx.coroutines.channels.k) r7;
        java.lang.Object r8 = r12.L$0;
        java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        r8 = (kotlinx.coroutines.channels.w) r8;
        kotlin.ResultKt.throwOnFailure(r13);
        goto L23
    L11:
        r1 = r12.I$0;
        java.lang.Object r6 = r12.L$1;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r6 = (kotlinx.coroutines.channels.k) r6;
        java.lang.Object r7 = r12.L$0;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        r7 = (kotlinx.coroutines.channels.w) r7;
        kotlin.ResultKt.throwOnFailure(r13);
        goto L17
    L12:
        kotlin.ResultKt.throwOnFailure(r13);
        java.lang.Object r13 = r12.L$0;
        java.lang.Object r13 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r13, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        r13 = (kotlinx.coroutines.channels.w) r13;
        r1 = 0;
        kotlinx.coroutines.channels.y<E> r6 = r12.$this_mapIndexed;
        r6 = r6.l();
        goto L13
    }
}
