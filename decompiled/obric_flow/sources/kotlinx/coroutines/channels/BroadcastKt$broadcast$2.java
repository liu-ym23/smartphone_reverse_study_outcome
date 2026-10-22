package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {26, 27}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
final class BroadcastKt$broadcast$2 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public BroadcastKt$broadcast$2(w r5, Continuation<? super BroadcastKt$broadcast$2> r10) {
        this.$channel = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        BroadcastKt$broadcast$2 r11 = new BroadcastKt$broadcast$2(this.$channel, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006b -> B:7:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        k r12 = (k) this.L$1;
        u r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        k r14 = r12;
    L7:
        u r15 = r13;
        k r16 = r14;
    L12:
        this.L$0 = r15;
        this.L$1 = r16;
        this.label = 1;
        e r17 = (e) r16;
        Object r18 = r17.c(this);
        if (r18 != r5) goto L15;
        return r5;
    L15:
        r13 = r15;
        r10 = r18;
        k r19 = r17;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L22;
        e r20 = (e) r19;
        Object r21 = r20.d();
        this.L$0 = r13;
        this.L$1 = r20;
        this.label = 2;
        r14 = r20;
        if (((j) r13).d.r(r21, this) != r5) goto L7;
        return r5;
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        k r22 = (k) this.L$1;
        r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        r19 = r22;
        goto L17
    L11:
        ResultKt.throwOnFailure(r10);
        r15 = (u) this.L$0;
        r16 = this.$channel.iterator();
        goto L12
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((BroadcastKt$broadcast$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
