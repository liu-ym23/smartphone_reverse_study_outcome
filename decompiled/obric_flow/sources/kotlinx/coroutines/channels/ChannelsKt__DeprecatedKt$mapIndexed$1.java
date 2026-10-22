package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {374, 375, 375}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $this_mapIndexed;
    final /* synthetic */ Function3<Integer, Object, Continuation<Object>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(w r5, Function3<? super Integer, Object, ? super Continuation<Object>, ? extends Object> r10, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> r11) {
        this.$this_mapIndexed = r5;
        this.$transform = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 r11 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b1 -> B:13:0x0059). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 3) goto L9;
        int r11 = this.I$0;
        k r13 = (k) this.L$1;
        u r14 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        u r15 = r14;
        int r16 = r11;
        k r17 = r13;
    L13:
        this.L$0 = r15;
        this.L$1 = r17;
        this.I$0 = r16;
        this.label = 1;
        e r18 = (e) r17;
        Object r19 = r18.c(this);
        if (r19 != r5) goto L16;
        return r5;
    L16:
        u r20 = r15;
        r12 = r19;
        int r110 = r16;
        k r21 = r18;
        int r22 = r110;
    L18:
        if (((Boolean) r12).booleanValue() == false) goto L28;
        e r23 = (e) r21;
        Object r111 = r23.d();
        Function3<Integer, Object, Continuation<Object>, Object> r24 = this.$transform;
        int r25 = r22 + 1;
        Integer r26 = Boxing.boxInt(r22);
        this.L$0 = r20;
        this.L$1 = r23;
        this.L$2 = r20;
        this.I$0 = r25;
        this.label = 2;
        r12 = r24.invoke(r26, r111, this);
        if (r12 != r5) goto L22;
        return r5;
    L22:
        u r27 = r20;
        int r28 = r25;
        k r29 = r23;
        Object r30 = r27;
    L23:
        this.L$0 = r27;
        this.L$1 = r29;
        this.L$2 = null;
        this.I$0 = r28;
        this.label = 3;
        if (((j) r30).d.r(r12, this) != r5) goto L26;
        return r5;
    L26:
        r16 = r28;
        r17 = r29;
        r15 = r27;
        goto L13
    L28:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r28 = this.I$0;
        r30 = (u) this.L$2;
        r29 = (k) this.L$1;
        r27 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        goto L23
    L11:
        r22 = this.I$0;
        r21 = (k) this.L$1;
        r20 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        goto L18
    L12:
        ResultKt.throwOnFailure(r12);
        r15 = (u) this.L$0;
        r17 = this.$this_mapIndexed.iterator();
        r16 = 0;
        goto L13
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
