package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/n;", "value", "", "<anonymous>", "(Lkotlinx/coroutines/channels/n;)Z"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {395}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n529#2,2:408\n562#2:410\n563#2:412\n1#3:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n394#1:408,2\n396#1:410\n396#1:412\n*E\n"})
public final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.n, Continuation<? super Boolean>, Object> {
    final /* synthetic */ h $downStream;
    /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$timeoutInternal$1$1$1(h r5, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> r10) {
        this.$downStream = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 r11 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* synthetic */ Object mo2invoke(kotlinx.coroutines.channels.n r5, Continuation<? super Boolean> r10) {
        return m1633invokeWpGqRn0(r5.f18815a, r10);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m1633invokeWpGqRn0(Object r5, Continuation<? super Boolean> r10) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(new kotlinx.coroutines.channels.n(r5), r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        Object r12 = this.L$0;
        ResultKt.throwOnFailure(r5);
    L14:
        Object r13 = r12;
    L16:
        if ((r13 instanceof kotlinx.coroutines.channels.l) == false) goto L23;
        Throwable r14 = kotlinx.coroutines.channels.n.a(r13);
        if (r14 == null) goto L20;
        throw r14;
    L20:
        return Boxing.boxBoolean(false);
    L23:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        r13 = ((kotlinx.coroutines.channels.n) this.L$0).f18815a;
        h r15 = this.$downStream;
        if ((r13 instanceof kotlinx.coroutines.channels.m) == true) goto L16;
        this.L$0 = r13;
        this.label = 1;
        if (r15.emit(r13, this) != r10) goto L13;
        return r10;
    L13:
        r12 = r13;
        goto L14
    }
}
