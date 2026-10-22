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

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.ScatterMap$MapWrapper$values$1$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {744}, m = "invokeSuspend", n = {"$this$iterator", "v$iv", "m$iv$iv", "lastIndex$iv$iv", "i$iv$iv", "slot$iv$iv", "bitCount$iv$iv", "j$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
final class ScatterMap$MapWrapper$values$1$iterator$1<V> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super V>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScatterMap<K, V> this$0;

    ScatterMap$MapWrapper$values$1$iterator$1(ScatterMap<K, V> r3, Continuation<? super ScatterMap$MapWrapper$values$1$iterator$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        ScatterMap$MapWrapper$values$1$iterator$1 r0 = new ScatterMap$MapWrapper$values$1$iterator$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(SequenceScope<? super V> r3, Continuation<? super Unit> r4) {
        return ((ScatterMap$MapWrapper$values$1$iterator$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScatterMap$MapWrapper$values$1$iterator$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x006e -> B:26:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0070 -> B:14:0x0082). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00ad -> B:23:0x00b0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$3;
        int r7 = this.I$2;
        long r8 = this.J$0;
        int r10 = this.I$1;
        int r11 = this.I$0;
        long[] r12 = (long[]) ZeusTransformUtils.preCheckCast(this.L$2, long[].class, "com.obric.memorydata.plugin");
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(this.L$1, Object[].class, "com.obric.memorydata.plugin");
        SequenceScope r5 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r21);
    L23:
        r8 = r8 >> 8;
        r3 = r3 + 1;
    L14:
        if (r3 < r7) goto L16;
        if (r7 != 8) goto L29;
        SequenceScope r4 = r5;
        int r9 = r10;
        int r14 = r11;
        long[] r6 = r12;
        Object[] r15 = r13;
    L26:
        if (r9 == r14) goto L29;
        r9 = r9 + 1;
    L11:
        long r16 = r6[r9];
        if (((((~r16) << 7) & r16) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        r13 = r15;
        r7 = 8 - ((~(r9 - r14)) >>> 31);
        r12 = r6;
        r5 = r4;
        r3 = 0;
        r11 = r14;
        r10 = r9;
        r8 = r16;
    L29:
        return Unit.INSTANCE;
    L16:
        if ((255 & r8) >= 128) goto L30;
        if (1 == 0) goto L23;
        Object r17 = r13[(r10 << 3) + r3];
        this.L$0 = r5;
        this.L$1 = r13;
        this.L$2 = r12;
        this.I$0 = r11;
        this.I$1 = r10;
        this.J$0 = r8;
        this.I$2 = r7;
        this.I$3 = r3;
        this.label = 1;
        if (r5.yield(r17, this) != r1) goto L23;
        return r1;
    L30:
        if (0 == 0) goto L23;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        r4 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ScatterMap<K, V> r18 = this.this$0;
        r15 = r18.values;
        r6 = r18.metadata;
        r14 = r6.length - 2;
        if (r14 < 0) goto L29;
        r9 = 0;
        goto L11
    }
}
