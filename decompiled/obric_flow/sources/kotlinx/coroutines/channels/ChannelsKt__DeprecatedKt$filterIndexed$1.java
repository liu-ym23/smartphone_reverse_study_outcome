package kotlinx.coroutines.channels;

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
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {241, 242, 242}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function3 $predicate;
    final /* synthetic */ w $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$filterIndexed$1(w r5, Function3 r10, Continuation r11) {
        this.$this_filterIndexed = r5;
        this.$predicate = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 r11 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Object r10) {
        return invoke((u) r5, (Continuation) r10);
    }

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
        int r15 = r11;
        k r16 = r13;
    L13:
        this.L$0 = r14;
        this.L$1 = r16;
        this.L$2 = null;
        this.I$0 = r15;
        this.label = 1;
        e r17 = (e) r16;
        Object r18 = r17.c(this);
        if (r18 != r5) goto L16;
        return r5;
    L16:
        int r19 = r15;
        k r20 = r17;
        r12 = r18;
        int r21 = r19;
    L18:
        if (((Boolean) r12).booleanValue() == false) goto L30;
        e r22 = (e) r20;
        Object r110 = r22.d();
        Function3 r23 = this.$predicate;
        int r24 = r21 + 1;
        Integer r25 = Boxing.boxInt(r21);
        this.L$0 = r14;
        this.L$1 = r22;
        this.L$2 = r110;
        this.I$0 = r24;
        this.label = 2;
        Object r26 = r23.invoke(r25, r110, this);
        if (r26 != r5) goto L22;
        return r5;
    L22:
        u r27 = r14;
        Object r28 = r110;
        r12 = r26;
        r16 = r22;
        r15 = r24;
    L24:
        if (((Boolean) r12).booleanValue() == false) goto L28;
        this.L$0 = r27;
        this.L$1 = r16;
        this.L$2 = null;
        this.I$0 = r15;
        this.label = 3;
        if (((j) r27).d.r(r28, this) != r5) goto L28;
        return r5;
    L28:
        r14 = r27;
        goto L13
    L31:
        r14 = r27;
        goto L13
    L30:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r29 = this.I$0;
        Object r30 = this.L$2;
        k r31 = (k) this.L$1;
        r27 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        r15 = r29;
        r16 = r31;
        r28 = r30;
        goto L24
    L11:
        r21 = this.I$0;
        r20 = (k) this.L$1;
        r14 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        goto L18
    L12:
        ResultKt.throwOnFailure(r12);
        u r111 = (u) this.L$0;
        r16 = this.$this_filterIndexed.iterator();
        r15 = 0;
        r14 = r111;
        goto L13
    }

    public final Object invoke(u r5, Continuation r10) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
