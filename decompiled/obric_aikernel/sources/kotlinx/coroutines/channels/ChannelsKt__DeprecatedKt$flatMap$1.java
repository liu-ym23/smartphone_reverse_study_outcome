package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$flatMap$1<R> extends SuspendLambda implements Function2<l<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_flatMap;
    final /* synthetic */ Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel<? extends E> r10, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$flatMap$1> r12) {
        this.$this_flatMap = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$flatMap$1 r12 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
        return invoke((l) r10, r11);
    }

    public final Object invoke(l<? super R> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007f -> B:13:0x004b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1<R> for r7v3 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r7.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L8;
        java.lang.Object r1 = r7.L$1;
        kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1;
        java.lang.Object r5 = r7.L$0;
        kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5;
        kotlin.ResultKt.throwOnFailure(r8);
    L13:
        r7.L$0 = r5;
        r7.L$1 = r1;
        r7.label = 1;
        r8 = r1.a(r7);
        if (r8 != r0) goto L16;
        return r0;
    L16:
        java.lang.Boolean r8 = (java.lang.Boolean) r8;
        boolean r8 = r8.booleanValue();
        if (r8 == false) goto L24;
        java.lang.Object r8 = r1.next();
        kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<? extends R>>, java.lang.Object> r6 = r7.$transform;
        r7.L$0 = r5;
        r7.L$1 = r1;
        r7.label = 2;
        E r8 = (E) r8;
        java.lang.Object r7 = (kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<? extends R>>) r7;
        r8 = r6.invoke(r8, r7);
        if (r8 != r0) goto L21;
        return r0;
    L21:
        kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8;
        r7.L$0 = r5;
        r7.L$1 = r1;
        r7.label = 3;
        java.lang.Object r8 = kotlinx.coroutines.channels.i.s(r8, r5, r7);
        if (r8 != r0) goto L13;
        return r0;
    L24:
        kotlin.Unit r7 = kotlin.Unit.INSTANCE;
        return r7;
    L8:
        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r7;
    L10:
        java.lang.Object r1 = r7.L$1;
        r1 = (kotlinx.coroutines.channels.ChannelIterator) r1;
        java.lang.Object r5 = r7.L$0;
        r5 = (kotlinx.coroutines.channels.l) r5;
        kotlin.ResultKt.throwOnFailure(r8);
        goto L21
    L11:
        java.lang.Object r1 = r7.L$1;
        r1 = (kotlinx.coroutines.channels.ChannelIterator) r1;
        java.lang.Object r5 = r7.L$0;
        r5 = (kotlinx.coroutines.channels.l) r5;
        kotlin.ResultKt.throwOnFailure(r8);
        goto L16
    L12:
        kotlin.ResultKt.throwOnFailure(r8);
        java.lang.Object r8 = r7.L$0;
        kotlinx.coroutines.channels.l r8 = (kotlinx.coroutines.channels.l) r8;
        kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r7.$this_flatMap;
        r1 = r1.iterator();
        r5 = r8;
        goto L13
    }
}
