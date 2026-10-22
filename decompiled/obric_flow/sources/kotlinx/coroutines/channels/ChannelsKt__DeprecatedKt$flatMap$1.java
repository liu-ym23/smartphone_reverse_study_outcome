package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {351, 352, 352}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ w $this_flatMap;
    final /* synthetic */ Function2 $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$flatMap$1(w r5, Function2 r10, Continuation r11) {
        this.$this_flatMap = r5;
        this.$transform = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$flatMap$1 r11 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Object r10) {
        return invoke((u) r5, (Continuation) r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0083 -> B:13:0x004b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        k r12 = (k) this.L$1;
        u r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        k r14 = r12;
    L13:
        this.L$0 = r13;
        this.L$1 = r14;
        this.label = 1;
        e r15 = (e) r14;
        r10 = r15.c(this);
        k r16 = r15;
        if (r10 != r5) goto L17;
        return r5;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L25;
        e r17 = (e) r16;
        Object r18 = r17.d();
        Function2 r19 = this.$transform;
        this.L$0 = r13;
        this.L$1 = r17;
        this.label = 2;
        r10 = r19.mo2invoke(r18, this);
        k r20 = r17;
        if (r10 != r5) goto L21;
        return r5;
    L21:
        this.L$0 = r13;
        this.L$1 = r20;
        this.label = 3;
        r14 = r20;
        if (p.e((w) r10, r13, this) != r5) goto L13;
        return r5;
    L25:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        k r21 = (k) this.L$1;
        r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        r20 = r21;
        goto L21
    L11:
        k r22 = (k) this.L$1;
        r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        r16 = r22;
        goto L17
    L12:
        ResultKt.throwOnFailure(r10);
        u r23 = (u) this.L$0;
        r13 = r23;
        r14 = this.$this_flatMap.iterator();
        goto L13
    }

    public final Object invoke(u r5, Continuation r10) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
