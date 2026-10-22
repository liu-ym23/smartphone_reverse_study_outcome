package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1060}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
final class MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableScatterSet<E> this$0;
    final /* synthetic */ MutableScatterSet$MutableSetWrapper$iterator$1<E> this$1;

    MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(MutableScatterSet<E> r3, MutableScatterSet$MutableSetWrapper$iterator$1<E> r4, Continuation<? super MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.this$1 = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 r0 = new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(SequenceScope<? super E> r3, Continuation<? super Unit> r4) {
        return ((MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0081 -> B:26:0x00d7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0083 -> B:14:0x0096). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00c9 -> B:23:0x00cc). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$3;
        int r7 = this.I$2;
        long r8 = this.J$0;
        int r10 = this.I$1;
        int r11 = this.I$0;
        long[] r12 = (long[]) ZeusTransformUtils.preCheckCast(this.L$3, long[].class, "com.obric.memorydata.plugin");
        MutableScatterSet<E> r13 = (MutableScatterSet) ZeusTransformUtils.preCheckCast(this.L$2, MutableScatterSet.class, "com.obric.memorydata.plugin");
        MutableScatterSet$MutableSetWrapper$iterator$1<E> r14 = (MutableScatterSet$MutableSetWrapper$iterator$1) ZeusTransformUtils.preCheckCast(this.L$1, MutableScatterSet$MutableSetWrapper$iterator$1.class, "com.obric.memorydata.plugin");
        SequenceScope r4 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);
    L23:
        r8 = r8 >> 8;
        r3 = r3 + 1;
    L14:
        if (r3 < r7) goto L16;
        if (r7 != 8) goto L29;
        SequenceScope r5 = r4;
        int r9 = r10;
        int r15 = r11;
        long[] r6 = r12;
        MutableScatterSet<E> r16 = r13;
        MutableScatterSet$MutableSetWrapper$iterator$1<E> r17 = r14;
    L26:
        if (r9 == r15) goto L29;
        r9 = r9 + 1;
    L11:
        long r18 = r6[r9];
        if (((((~r18) << 7) & r18) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        r14 = r17;
        r13 = r16;
        r7 = 8 - ((~(r9 - r15)) >>> 31);
        r12 = r6;
        r4 = r5;
        r3 = 0;
        r11 = r15;
        r10 = r9;
        r8 = r18;
    L29:
        return Unit.INSTANCE;
    L16:
        if ((r8 & 255) >= 128) goto L30;
        if (1 == 0) goto L23;
        int r19 = (r10 << 3) + r3;
        r14.setCurrent(r19);
        Object r20 = r13.elements[r19];
        this.L$0 = r4;
        this.L$1 = r14;
        this.L$2 = r13;
        this.L$3 = r12;
        this.I$0 = r11;
        this.I$1 = r10;
        this.J$0 = r8;
        this.I$2 = r7;
        this.I$3 = r3;
        this.label = 1;
        if (r4.yield(r20, this) != r1) goto L23;
        return r1;
    L30:
        if (0 == 0) goto L23;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        r5 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ScatterSet r21 = (ScatterSet) ZeusTransformUtils.preCheckCast(this.this$0, ScatterSet.class, "com.obric.memorydata.plugin");
        r17 = this.this$1;
        r16 = this.this$0;
        r6 = r21.metadata;
        r15 = r6.length - 2;
        if (r15 < 0) goto L29;
        r9 = 0;
        goto L11
    }
}
