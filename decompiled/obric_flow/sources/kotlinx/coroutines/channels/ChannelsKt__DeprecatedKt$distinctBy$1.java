package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashSet;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {417, 418, 420}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $selector;
    final /* synthetic */ w $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(w r5, Function2<Object, ? super Continuation<Object>, ? extends Object> r10, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> r11) {
        this.$this_distinctBy = r5;
        this.$selector = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$distinctBy$1 r11 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c5 -> B:8:0x0024). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00cc -> B:14:0x0069). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L13;
        if (r10 == 1) goto L12;
        if (r10 == 2) goto L11;
        if (r10 != 3) goto L10;
        Object r12 = this.L$3;
        k r13 = (k) this.L$2;
        HashSet r14 = (HashSet) this.L$1;
        u r15 = (u) this.L$0;
        ResultKt.throwOnFailure(r11);
        r11 = r12;
        HashSet r16 = r14;
    L8:
        u r17 = r15;
        r16.add(r11);
    L14:
        this.L$0 = r17;
        this.L$1 = r16;
        this.L$2 = r13;
        this.L$3 = null;
        this.label = 1;
        e r18 = (e) r13;
        Object r19 = r18.c(this);
        if (r19 != r5) goto L17;
        return r5;
    L17:
        HashSet r20 = r16;
        k r21 = r18;
        r11 = r19;
        HashSet r22 = r20;
    L19:
        if (((Boolean) r11).booleanValue() == false) goto L33;
        e r23 = (e) r21;
        Object r110 = r23.d();
        Function2<Object, Continuation<Object>, Object> r24 = this.$selector;
        this.L$0 = r17;
        this.L$1 = r22;
        this.L$2 = r23;
        this.L$3 = r110;
        this.label = 2;
        Object r25 = r24.mo2invoke(r110, this);
        if (r25 != r5) goto L23;
        return r5;
    L23:
        HashSet r26 = r22;
        Object r27 = r110;
        r11 = r25;
        r15 = r17;
        k r28 = r23;
        r16 = r26;
    L25:
        if (r16.contains(r11) == true) goto L31;
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r28;
        this.L$3 = r11;
        this.label = 3;
        if (((j) r15).d.r(r27, this) != r5) goto L29;
        return r5;
    L29:
        r13 = r28;
        goto L8
    L31:
        r13 = r28;
        r17 = r15;
        goto L14
    L33:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Object r29 = this.L$3;
        k r30 = (k) this.L$2;
        HashSet r31 = (HashSet) this.L$1;
        r15 = (u) this.L$0;
        ResultKt.throwOnFailure(r11);
        r27 = r29;
        r16 = r31;
        r28 = r30;
        goto L25
    L12:
        r21 = (k) this.L$2;
        r22 = (HashSet) this.L$1;
        r17 = (u) this.L$0;
        ResultKt.throwOnFailure(r11);
        goto L19
    L13:
        ResultKt.throwOnFailure(r11);
        u r111 = (u) this.L$0;
        r16 = new HashSet();
        r13 = this.$this_distinctBy.iterator();
        r17 = r111;
        goto L14
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
