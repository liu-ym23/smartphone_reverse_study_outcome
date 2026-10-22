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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {228, 229, 229}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ w $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filter$1(w r5, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> r10, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> r11) {
        this.$this_filter = r5;
        this.$predicate = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$filter$1 r11 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

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
    L13:
        this.L$0 = r13;
        this.L$1 = r12;
        this.L$2 = null;
        this.label = 1;
        e r14 = (e) r12;
        r10 = r14.c(this);
        k r15 = r14;
        if (r10 != r5) goto L17;
        return r5;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L29;
        e r16 = (e) r15;
        Object r17 = r16.d();
        Function2<Object, Continuation<? super Boolean>, Object> r18 = this.$predicate;
        this.L$0 = r13;
        this.L$1 = r16;
        this.L$2 = r17;
        this.label = 2;
        Object r19 = r18.mo2invoke(r17, this);
        if (r19 != r5) goto L21;
        return r5;
    L21:
        u r20 = r13;
        Object r21 = r17;
        r10 = r19;
        u r22 = r20;
        r12 = r16;
    L23:
        if (((Boolean) r10).booleanValue() == false) goto L27;
        this.L$0 = r22;
        this.L$1 = r12;
        this.L$2 = null;
        this.label = 3;
        if (((j) r22).d.r(r21, this) != r5) goto L27;
        return r5;
    L27:
        r13 = r22;
        goto L13
    L30:
        r13 = r22;
        goto L13
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Object r23 = this.L$2;
        k r24 = (k) this.L$1;
        r22 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        r21 = r23;
        r12 = r24;
        goto L23
    L11:
        k r25 = (k) this.L$1;
        r13 = (u) this.L$0;
        ResultKt.throwOnFailure(r10);
        r15 = r25;
        goto L17
    L12:
        ResultKt.throwOnFailure(r10);
        u r110 = (u) this.L$0;
        r12 = this.$this_filter.iterator();
        r13 = r110;
        goto L13
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
