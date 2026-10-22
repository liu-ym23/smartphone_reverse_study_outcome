package kotlinx.coroutines.channels;

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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {514, 363, 363}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,509:1\n160#2:510\n94#2,3:511\n161#2,2:514\n101#2:516\n97#2,3:517\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n362#1:510\n362#1:511,3\n362#1:514,2\n362#1:516\n362#1:517,3\n*E\n"})
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $this_map;
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$map$1(w r5, Function2<Object, ? super Continuation<Object>, ? extends Object> r10, Continuation<? super ChannelsKt__DeprecatedKt$map$1> r11) {
        this.$this_map = r5;
        this.$transform = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$map$1 r11 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00cb -> B:24:0x0075). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L22;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L14;
        if (r10 != 3) goto L13;
        k r11 = (k) this.L$3;
        w r12 = (w) this.L$2;
        Function2<Object, Continuation<Object>, Object> r14 = (Function2) this.L$1;
        u r15 = (u) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L10
        u r16 = r15;
        k r17 = r11;
        Function2<Object, Continuation<Object>, Object> r18 = r14;
    L24:
        this.L$0 = r16;     // Catch: Throwable -> L10
        this.L$1 = r18;     // Catch: Throwable -> L10
        this.L$2 = r12;     // Catch: Throwable -> L10
        this.L$3 = r17;     // Catch: Throwable -> L10
        this.label = 1;     // Catch: Throwable -> L10
        e r19 = (e) r17;     // Catch: Throwable -> L10
        Object r20 = r19.c(this);     // Catch: Throwable -> L10
        if (r20 != r5) goto L27;
        return r5;
    L27:
        u r21 = r16;
        r13 = r20;
        Function2<Object, Continuation<Object>, Object> r22 = r18;
        k r23 = r19;
    L29:
        if (((Boolean) r13).booleanValue() == false) goto L38;
        e r24 = (e) r23;     // Catch: Throwable -> L10
        Object r110 = r24.d();     // Catch: Throwable -> L10
        this.L$0 = r21;     // Catch: Throwable -> L10
        this.L$1 = r22;     // Catch: Throwable -> L10
        this.L$2 = r12;     // Catch: Throwable -> L10
        this.L$3 = r24;     // Catch: Throwable -> L10
        this.L$4 = r21;     // Catch: Throwable -> L10
        this.label = 2;     // Catch: Throwable -> L10
        r13 = r22.mo2invoke(r110, this);     // Catch: Throwable -> L10
        if (r13 != r5) goto L33;
        return r5;
    L33:
        u r25 = r21;
        Function2<Object, Continuation<Object>, Object> r26 = r22;
        w r27 = r12;
        k r28 = r24;
        Object r29 = r25;
    L34:
        this.L$0 = r25;     // Catch: Throwable -> L17
        this.L$1 = r26;     // Catch: Throwable -> L17
        this.L$2 = r27;     // Catch: Throwable -> L17
        this.L$3 = r28;     // Catch: Throwable -> L17
        this.L$4 = null;     // Catch: Throwable -> L17
        this.label = 3;     // Catch: Throwable -> L17
        if (((j) r29).d.r(r13, this) != r5) goto L37;
        return r5;
    L37:
        r18 = r26;
        r16 = r25;
        w r111 = r27;
        r17 = r28;
        r12 = r111;
    L17:
        th = th;
        r12 = r27;
    L45:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        p.d(r12, th);
        throw th;
    L38:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r12.cancel(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r29 = (u) this.L$4;
        r28 = (k) this.L$3;
        r27 = (w) this.L$2;
        r26 = (Function2) this.L$1;
        r25 = (u) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L17
        goto L34
    L19:
        r23 = (k) this.L$3;
        r12 = (w) this.L$2;
        r22 = (Function2) this.L$1;
        r21 = (u) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L10
        goto L29
    L22:
        ResultKt.throwOnFailure(r13);
        r16 = (u) this.L$0;
        r12 = this.$this_map;
        r18 = this.$transform;
        r17 = r12.iterator();     // Catch: Throwable -> L10
    L10:
        th = th;
        goto L45
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
