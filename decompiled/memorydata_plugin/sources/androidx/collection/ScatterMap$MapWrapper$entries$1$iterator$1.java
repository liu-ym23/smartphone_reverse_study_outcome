package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {701}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
final class ScatterMap$MapWrapper$entries$1$iterator$1<K, V> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<? extends K, ? extends V>>, Continuation<? super Unit>, Object> {
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

    ScatterMap$MapWrapper$entries$1$iterator$1(ScatterMap<K, V> r3, Continuation<? super ScatterMap$MapWrapper$entries$1$iterator$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        ScatterMap$MapWrapper$entries$1$iterator$1 r0 = new ScatterMap$MapWrapper$entries$1$iterator$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(SequenceScope<? super Map.Entry<? extends K, ? extends V>> r3, Continuation<? super Unit> r4) {
        return ((ScatterMap$MapWrapper$entries$1$iterator$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScatterMap$MapWrapper$entries$1$iterator$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x006b -> B:27:0x00c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006d -> B:14:0x0082). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00b8 -> B:23:0x00bb). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 8;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r4 = this.I$3;
        int r7 = this.I$2;
        long r8 = this.J$0;
        int r10 = this.I$1;
        int r11 = this.I$0;
        long[] r12 = (long[]) ZeusTransformUtils.preCheckCast(this.L$2, long[].class, "com.obric.memorydata.plugin");
        ScatterMap<K, V> r13 = (ScatterMap) ZeusTransformUtils.preCheckCast(this.L$1, ScatterMap.class, "com.obric.memorydata.plugin");
        SequenceScope r5 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r22);
    L23:
        r3 = 8;
    L24:
        r8 = r8 >> r3;
        r4 = r4 + 1;
    L14:
        if (r4 < r7) goto L16;
        if (r7 != r3) goto L30;
        SequenceScope r6 = r5;
        int r9 = r10;
        int r14 = r11;
        long[] r15 = r12;
        ScatterMap<K, V> r16 = r13;
    L27:
        if (r9 == r14) goto L30;
        r9 = r9 + 1;
    L11:
        long r17 = r15[r9];
        if (((((~r17) << 7) & r17) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L27;
        r13 = r16;
        r5 = r6;
        r4 = 0;
        r12 = r15;
        r7 = 8 - ((~(r9 - r14)) >>> 31);
        r11 = r14;
        r10 = r9;
        r8 = r17;
    L30:
        return Unit.INSTANCE;
    L16:
        if ((255 & r8) >= 128) goto L31;
        if (1 == 0) goto L24;
        int r18 = (r10 << 3) + r4;
        MapEntry r19 = new MapEntry(r13.keys[r18], r13.values[r18]);
        this.L$0 = r5;
        this.L$1 = r13;
        this.L$2 = r12;
        this.I$0 = r11;
        this.I$1 = r10;
        this.J$0 = r8;
        this.I$2 = r7;
        this.I$3 = r4;
        this.label = 1;
        if (r5.yield(r19, this) != r1) goto L23;
        return r1;
    L31:
        if (0 == 0) goto L24;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        r6 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        r16 = this.this$0;
        r15 = r16.metadata;
        r14 = r15.length - 2;
        if (r14 < 0) goto L30;
        r9 = 0;
        goto L11
    }
}
