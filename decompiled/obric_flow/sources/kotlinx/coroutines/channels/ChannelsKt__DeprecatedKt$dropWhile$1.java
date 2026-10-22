package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import cn.nubia.neopush.commons.Constant;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {211, 212, 213, Constant.SDK_VERSION, 218}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ w $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$dropWhile$1(w r5, Function2 r10, Continuation r11) {
        this.$this_dropWhile = r5;
        this.$predicate = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$dropWhile$1 r11 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Object r10) {
        return invoke((u) r5, (Continuation) r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a1 -> B:27:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00fb -> B:10:0x0023). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L14;
        if (r10 == 4) goto L13;
        if (r10 != 5) goto L12;
        k r11 = (k) this.L$1;
        u r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        k r14 = r11;
    L10:
        k r15 = r14;
        u r16 = r13;
    L36:
        this.L$0 = r16;
        this.L$1 = r15;
        this.label = 4;
        e r17 = (e) r15;
        r12 = r17.c(this);
        if (r12 != r5) goto L39;
        return r5;
    L39:
        r13 = r16;
        k r18 = r17;
    L41:
        if (((Boolean) r12).booleanValue() == false) goto L46;
        e r19 = (e) r18;
        Object r110 = r19.d();
        this.L$0 = r13;
        this.L$1 = r19;
        this.label = 5;
        r14 = r19;
        if (((j) r13).d.r(r110, this) != r5) goto L10;
        return r5;
    L46:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        k r20 = (k) this.L$1;
        r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        r18 = r20;
        goto L41
    L14:
        u r21 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
    L33:
        r16 = r21;
    L35:
        r15 = this.$this_dropWhile.iterator();
        goto L36
    L15:
        Object r22 = this.L$2;
        k r23 = (k) this.L$1;
        u r24 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        Object r25 = r22;
        k r26 = r23;
    L28:
        if (((Boolean) r12).booleanValue() == true) goto L34;
        this.L$0 = r24;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (((j) r24).d.r(r25, this) != r5) goto L32;
        return r5;
    L32:
        r21 = r24;
        goto L33
    L34:
        r16 = r24;
    L18:
        this.L$0 = r16;
        this.L$1 = r26;
        this.L$2 = null;
        this.label = 1;
        e r27 = (e) r26;
        r12 = r27.c(this);
        k r28 = r27;
        if (r12 != r5) goto L22;
        return r5;
    L22:
        if (((Boolean) r12).booleanValue() == false) goto L35;
        e r111 = (e) r28;
        Object r29 = r111.d();
        Function2 r30 = this.$predicate;
        this.L$0 = r16;
        this.L$1 = r111;
        this.L$2 = r29;
        this.label = 2;
        Object r31 = r30.mo2invoke(r29, this);
        if (r31 != r5) goto L26;
        return r5;
    L26:
        r26 = r111;
        r12 = r31;
        r24 = r16;
        r25 = r29;
        goto L28
    L16:
        k r32 = (k) this.L$1;
        r16 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
        r28 = r32;
        goto L22
    L17:
        ResultKt.throwOnFailure(r12);
        u r112 = (u) this.L$0;
        r26 = this.$this_dropWhile.iterator();
        r16 = r112;
        goto L18
    }

    public final Object invoke(u r5, Continuation r10) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
