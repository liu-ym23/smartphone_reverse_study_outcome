package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {514, 499, LynxErrorCode.LYNX_ERROR_CODE_CANVAS}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,509:1\n160#2:510\n94#2,3:511\n161#2,2:514\n101#2:516\n97#2,3:517\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n*L\n498#1:510\n498#1:511,3\n498#1:514,2\n498#1:516\n498#1:517,3\n*E\n"})
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $other;
    final /* synthetic */ w $this_zip;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    public ChannelsKt__DeprecatedKt$zip$2(w r5, w r10, Function2<Object, Object, Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> r12) {
        this.$other = r5;
        this.$this_zip = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__DeprecatedKt$zip$2 r11 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00fd -> B:40:0x0100). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0104 -> B:24:0x0089). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L22;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L14;
        if (r10 != 3) goto L13;
        k r11 = (k) this.L$4;
        w r12 = (w) this.L$3;
        Function2<Object, Object, Object> r13 = (Function2) this.L$2;
        k r15 = (k) this.L$1;
        u r16 = (u) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L10
        k r17 = r11;
    L40:
        k r18 = r15;
        k r19 = r17;
        k r20 = r18;
    L24:
        this.L$0 = r16;     // Catch: Throwable -> L10
        this.L$1 = r20;     // Catch: Throwable -> L10
        this.L$2 = r13;     // Catch: Throwable -> L10
        this.L$3 = r12;     // Catch: Throwable -> L10
        this.L$4 = r19;     // Catch: Throwable -> L10
        this.L$5 = null;     // Catch: Throwable -> L10
        this.label = 1;     // Catch: Throwable -> L10
        e r110 = (e) r19;     // Catch: Throwable -> L10
        Object r21 = r110.c(this);     // Catch: Throwable -> L10
        if (r21 != r5) goto L27;
        return r5;
    L27:
        k r111 = r20;
        k r22 = r110;
        r14 = r21;
        k r23 = r111;
    L29:
        if (((Boolean) r14).booleanValue() == false) goto L42;
        e r24 = (e) r22;     // Catch: Throwable -> L10
        Object r112 = r24.d();     // Catch: Throwable -> L10
        this.L$0 = r16;     // Catch: Throwable -> L10
        this.L$1 = r23;     // Catch: Throwable -> L10
        this.L$2 = r13;     // Catch: Throwable -> L10
        this.L$3 = r12;     // Catch: Throwable -> L10
        this.L$4 = r24;     // Catch: Throwable -> L10
        this.L$5 = r112;     // Catch: Throwable -> L10
        this.label = 2;     // Catch: Throwable -> L10
        e r25 = (e) r23;     // Catch: Throwable -> L10
        Object r113 = r25.c(this);     // Catch: Throwable -> L10
        if (r113 != r5) goto L33;
        return r5;
    L33:
        w r114 = r12;
        Object r26 = r112;
        r14 = r113;
        k r115 = r25;
        Function2<Object, Object, Object> r27 = r13;
        w r28 = r114;
        k r29 = r24;
    L34:
        if (((Boolean) r14).booleanValue() == false) goto L41;
        e r116 = (e) r115;     // Catch: Throwable -> L17
        Object r30 = r27.mo2invoke(r26, r116.d());     // Catch: Throwable -> L17
        this.L$0 = r16;     // Catch: Throwable -> L17
        this.L$1 = r116;     // Catch: Throwable -> L17
        this.L$2 = r27;     // Catch: Throwable -> L17
        this.L$3 = r28;     // Catch: Throwable -> L17
        this.L$4 = r29;     // Catch: Throwable -> L17
        this.L$5 = null;     // Catch: Throwable -> L17
        this.label = 3;     // Catch: Throwable -> L17
        if (((j) r16).d.r(r30, this) != r5) goto L39;
        return r5;
    L39:
        r12 = r28;
        r13 = r27;
        r15 = r116;
        r17 = r29;
        goto L40
    L41:
        r12 = r28;
        r13 = r27;
        r19 = r29;
        r20 = r115;
    L17:
        th = th;
        r12 = r28;
    L49:
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        p.d(r12, th);
        throw th;
    L42:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r12.cancel(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        Object r31 = this.L$5;
        k r32 = (k) this.L$4;
        r28 = (w) this.L$3;
        r27 = (Function2) this.L$2;
        k r33 = (k) this.L$1;
        u r118 = (u) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L17
        r26 = r31;
        r29 = r32;
        r115 = r33;
        r16 = r118;
        goto L34
    L19:
        r22 = (k) this.L$4;
        r12 = (w) this.L$3;
        r13 = (Function2) this.L$2;
        r23 = (k) this.L$1;
        r16 = (u) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L10
        goto L29
    L22:
        ResultKt.throwOnFailure(r14);
        u r119 = (u) this.L$0;
        r20 = this.$other.iterator();
        r12 = this.$this_zip;
        r13 = this.$transform;
        r16 = r119;
        r19 = r12.iterator();     // Catch: Throwable -> L10
    L10:
        th = th;
        goto L49
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
