package kotlinx.coroutines.channels;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {194, 199, 200}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$drop$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,509:1\n1#2:510\n*E\n"})
final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ w $this_drop;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$drop$1(int r5, w r10, Continuation r11) {
        this.$n = r5;
        this.$this_drop = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$drop$1 r11 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Object r10) {
        return invoke((u) r5, (Continuation) r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0062 -> B:20:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ac -> B:8:0x001c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L13;
        if (r11 == 1) goto L12;
        if (r11 == 2) goto L11;
        if (r11 != 3) goto L10;
        k r12 = (k) this.L$1;
        u r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        k r14 = r12;
    L8:
        u r15 = r13;
        k r16 = r14;
    L26:
        this.L$0 = r15;
        this.L$1 = r16;
        this.label = 2;
        e r17 = (e) r16;
        Object r18 = r17.c(this);
        if (r18 != r5) goto L29;
        return r5;
    L29:
        r13 = r15;
        r10 = r18;
        k r19 = r17;
    L31:
        if (((Boolean) r10).booleanValue() == false) goto L36;
        e r20 = (e) r19;
        Object r21 = r20.d();
        this.L$0 = r13;
        this.L$1 = r20;
        this.label = 3;
        r14 = r20;
        if (((j) r13).d.r(r21, this) != r5) goto L8;
        return r5;
    L36:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        k r22 = (k) this.L$1;
        r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        r19 = r22;
        goto L31
    L12:
        int r23 = this.I$0;
        k r24 = (k) this.L$1;
        u r25 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        k r26 = r24;
    L21:
        if (((Boolean) r10).booleanValue() == false) goto L24;
        e r27 = (e) r26;
        r27.d();
        r23 = r23 - 1;
        Object r28 = r27;
        if (r23 == 0) goto L24;
    L17:
        this.L$0 = r25;
        this.L$1 = r28;
        this.I$0 = r23;
        this.label = 1;
        e r29 = (e) r28;
        r10 = r29.c(this);
        r26 = r29;
        if (r10 != r5) goto L21;
        return r5;
    L24:
        r15 = r25;
    L25:
        r16 = this.$this_drop.iterator();
        goto L26
    L13:
        ResultKt.throwOnFailure(r10);
        r15 = (u) this.L$0;
        r23 = this.$n;
        if (r23 < 0) goto L38;
        if (r23 <= 0) goto L25;
        r25 = r15;
        r28 = this.$this_drop.iterator();
        goto L17
    L38:
        throw new IllegalArgumentException(j0.h(r23, "Requested element count ", " is less than zero.").toString());
    }

    public final Object invoke(u r5, Continuation r10) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
