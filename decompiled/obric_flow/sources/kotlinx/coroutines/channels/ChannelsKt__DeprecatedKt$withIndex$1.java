package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/u;", "Lkotlin/collections/IndexedValue;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {400, LynxErrorCode.LYNX_ERROR_CODE_UPDATE}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ w $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$withIndex$1(w r5, Continuation r10) {
        this.$this_withIndex = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$withIndex$1 r11 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Object r10) {
        return invoke((u) r5, (Continuation) r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0084 -> B:11:0x0044). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L9;
        if (r10 != 2) goto L8;
        int r12 = this.I$0;
        k r13 = (k) this.L$1;
        u r14 = (u) this.L$0;
        ResultKt.throwOnFailure(r11);
        u r15 = r14;
        int r16 = r12;
        k r17 = r13;
    L11:
        this.L$0 = r15;
        this.L$1 = r17;
        this.I$0 = r16;
        this.label = 1;
        e r18 = (e) r17;
        Object r19 = r18.c(this);
        if (r19 != r5) goto L14;
        return r5;
    L14:
        u r20 = r15;
        r11 = r19;
        int r21 = r16;
        k r22 = r18;
        int r23 = r21;
    L16:
        if (((Boolean) r11).booleanValue() == false) goto L22;
        e r24 = (e) r22;
        int r25 = r23 + 1;
        IndexedValue r26 = new IndexedValue(r23, r24.d());
        this.L$0 = r20;
        this.L$1 = r24;
        this.I$0 = r25;
        this.label = 2;
        if (((j) r20).d.r(r26, this) != r5) goto L20;
        return r5;
    L20:
        r17 = r24;
        r15 = r20;
        r16 = r25;
        goto L11
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r23 = this.I$0;
        r22 = (k) this.L$1;
        r20 = (u) this.L$0;
        ResultKt.throwOnFailure(r11);
        goto L16
    L10:
        ResultKt.throwOnFailure(r11);
        r15 = (u) this.L$0;
        r17 = this.$this_withIndex.iterator();
        r16 = 0;
        goto L11
    }

    public final Object invoke(u r5, Continuation r10) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
