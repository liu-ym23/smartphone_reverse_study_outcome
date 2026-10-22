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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {284, 285}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,509:1\n1#2:510\n*E\n"})
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ w $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$take$1(int r5, w r10, Continuation r11) {
        this.$n = r5;
        this.$this_take = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$take$1 r11 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Object r10) {
        return invoke((u) r5, (Continuation) r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007c -> B:7:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        int r12 = this.I$0;
        k r13 = (k) this.L$1;
        u r14 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        k r15 = r13;
    L7:
        u r16 = r14;
        r12 = r12 - 1;
        k r17 = r15;
        if (r12 == 0) goto L29;
    L17:
        this.L$0 = r16;
        this.L$1 = r17;
        this.I$0 = r12;
        this.label = 1;
        e r18 = (e) r17;
        Object r19 = r18.c(this);
        if (r19 != r5) goto L20;
        return r5;
    L20:
        r14 = r16;
        r10 = r19;
        k r20 = r18;
    L22:
        if (((Boolean) r10).booleanValue() == false) goto L31;
        e r21 = (e) r20;
        Object r22 = r21.d();
        this.L$0 = r14;
        this.L$1 = r21;
        this.I$0 = r12;
        this.label = 2;
        r15 = r21;
        if (((j) r14).d.r(r22, this) != r5) goto L7;
        return r5;
    L31:
        return Unit.INSTANCE;
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r12 = this.I$0;
        k r23 = (k) this.L$1;
        r14 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        r20 = r23;
        goto L22
    L11:
        ResultKt.throwOnFailure(r10);
        r16 = (u) this.L$0;
        r12 = this.$n;
        if (r12 == 0) goto L14;
        if (r12 < 0) goto L33;
        r17 = this.$this_take.iterator();
        goto L17
    L33:
        throw new IllegalArgumentException(j0.h(r12, "Requested element count ", " is less than zero.").toString());
    L14:
        return Unit.INSTANCE;
    }

    public final Object invoke(u r5, Continuation r10) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
