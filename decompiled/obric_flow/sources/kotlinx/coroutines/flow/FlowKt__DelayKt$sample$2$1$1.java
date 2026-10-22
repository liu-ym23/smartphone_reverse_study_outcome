package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/channels/n;", "", "result", "", "<anonymous>", "(Lkotlinx/coroutines/channels/n;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n529#2,2:408\n544#2:410\n545#2:412\n1#3:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n281#1:408,2\n282#1:410\n282#1:412\n*E\n"})
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.n, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    final /* synthetic */ kotlinx.coroutines.channels.w $ticker;
    /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> r5, kotlinx.coroutines.channels.w r10, Continuation<? super FlowKt__DelayKt$sample$2$1$1> r11) {
        this.$lastValue = r5;
        this.$ticker = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        FlowKt__DelayKt$sample$2$1$1 r11 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* synthetic */ Object mo2invoke(kotlinx.coroutines.channels.n r5, Continuation<? super Unit> r10) {
        return m1632invokeWpGqRn0(r5.f18815a, r10);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m1632invokeWpGqRn0(Object r5, Continuation<? super Unit> r10) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(new kotlinx.coroutines.channels.n(r5), r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, g8.g] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r5);
        ?? r10 = ((kotlinx.coroutines.channels.n) this.L$0).f18815a;
        Ref.ObjectRef<Object> r11 = this.$lastValue;
        boolean r12 = r10 instanceof kotlinx.coroutines.channels.m;
        if (r12 == true) goto L7;
        r11.element = r10;
    L7:
        kotlinx.coroutines.channels.w r13 = this.$ticker;
        if (r12 == false) goto L14;
        Throwable r14 = kotlinx.coroutines.channels.n.a(r10);
        if (r14 != null) goto L12;
        r13.cancel(new ChildCancelledException());
        r11.element = kotlinx.coroutines.flow.internal.b.d;
        goto L14
    L12:
        throw r14;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
