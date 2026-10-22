package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {351, 352, 352}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$flatMap$1<R> extends SuspendLambda implements Function2<w<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ y<E> $this_flatMap;
    final /* synthetic */ Function2<E, Continuation<? super y<? extends R>>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    ChannelsKt__DeprecatedKt$flatMap$1(y<? extends E> r3, Function2<? super E, ? super Continuation<? super y<? extends R>>, ? extends Object> r4, Continuation<? super ChannelsKt__DeprecatedKt$flatMap$1> r5) {
        y<E> r6 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        Function2<E, Continuation<? super y<? extends R>>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_flatMap = r6;
        this.$transform = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$flatMap$1 r0 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super R> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$flatMap$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00cf -> B:13:0x0077). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1<R> for r9v3 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r9.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L8;
        java.lang.Object r1 = r9.L$1;
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.k r1 = (kotlinx.coroutines.channels.k) r1;
        java.lang.Object r6 = r9.L$0;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.w r6 = (kotlinx.coroutines.channels.w) r6;
        kotlin.ResultKt.throwOnFailure(r10);
    L13:
        java.lang.Object r10 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r9, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation<? super java.lang.Boolean> r10 = (kotlin.coroutines.Continuation) r10;
        r9.L$0 = r6;
        r9.L$1 = r1;
        r9.label = 1;
        r10 = r1.a(r10);
        if (r10 != r0) goto L16;
        return r0;
    L16:
        java.lang.Object r10 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r10, java.lang.Boolean.class, "com.obric.memorydata.plugin");
        java.lang.Boolean r10 = (java.lang.Boolean) r10;
        boolean r10 = r10.booleanValue();
        if (r10 == false) goto L24;
        java.lang.Object r10 = r1.a();
        kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.y<? extends R>>, java.lang.Object> r7 = r9.$transform;
        r9.L$0 = r6;
        r9.L$1 = r1;
        r9.label = 2;
        E r10 = (E) r10;
        java.lang.Object r9 = (kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.y<? extends R>>) r9;
        r10 = r7.invoke(r10, r9);
        if (r10 != r0) goto L21;
        return r0;
    L21:
        java.lang.Object r10 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.y r10 = (kotlinx.coroutines.channels.y) r10;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.z.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7;
        java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r9, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8;
        r9.L$0 = r6;
        r9.L$1 = r1;
        r9.label = 3;
        java.lang.Object r10 = kotlinx.coroutines.channels.o.b(r10, r7, r8);
        if (r10 != r0) goto L13;
        return r0;
    L24:
        kotlin.Unit r9 = kotlin.Unit.INSTANCE;
        return r9;
    L8:
        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r9;
    L10:
        java.lang.Object r1 = r9.L$1;
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r1 = (kotlinx.coroutines.channels.k) r1;
        java.lang.Object r6 = r9.L$0;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        r6 = (kotlinx.coroutines.channels.w) r6;
        kotlin.ResultKt.throwOnFailure(r10);
        goto L21
    L11:
        java.lang.Object r1 = r9.L$1;
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r1 = (kotlinx.coroutines.channels.k) r1;
        java.lang.Object r6 = r9.L$0;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        r6 = (kotlinx.coroutines.channels.w) r6;
        kotlin.ResultKt.throwOnFailure(r10);
        goto L16
    L12:
        kotlin.ResultKt.throwOnFailure(r10);
        java.lang.Object r10 = r9.L$0;
        java.lang.Object r10 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.w r10 = (kotlinx.coroutines.channels.w) r10;
        kotlinx.coroutines.channels.y<E> r1 = r9.$this_flatMap;
        r1 = r1.l();
        r6 = r10;
        goto L13
    }
}
