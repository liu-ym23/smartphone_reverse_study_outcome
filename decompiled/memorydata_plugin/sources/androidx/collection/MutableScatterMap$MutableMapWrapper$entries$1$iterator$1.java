package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$entries$1$iterator$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "iterator", "", "getIterator", "()Ljava/util/Iterator;", "setIterator", "(Ljava/util/Iterator;)V", "hasNext", "", "next", "remove", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableScatterMap$MutableMapWrapper$entries$1$iterator$1<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
    private int current;
    private Iterator<? extends Map.Entry<K, V>> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    /* JADX INFO: renamed from: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1328}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<K, V>>, Continuation<? super Unit>, Object> {
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
        final /* synthetic */ MutableScatterMap<K, V> this$0;
        final /* synthetic */ MutableScatterMap$MutableMapWrapper$entries$1$iterator$1<K, V> this$1;

        AnonymousClass1(MutableScatterMap<K, V> r3, MutableScatterMap$MutableMapWrapper$entries$1$iterator$1<K, V> r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.this$1 = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.this$1, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(SequenceScope<? super Map.Entry<K, V>> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0083 -> B:14:0x0096). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00d3 -> B:23:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f1 -> B:30:0x00f6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            int r3 = 8;
            int r5 = 1;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            int r4 = this.I$3;
            int r7 = this.I$2;
            long r8 = this.J$0;
            int r10 = this.I$1;
            int r11 = this.I$0;
            long[] r12 = (long[]) ZeusTransformUtils.preCheckCast(this.L$3, long[].class, "com.obric.memorydata.plugin");
            MutableScatterMap<K, V> r13 = (MutableScatterMap) ZeusTransformUtils.preCheckCast(this.L$2, MutableScatterMap.class, "com.obric.memorydata.plugin");
            MutableScatterMap$MutableMapWrapper$entries$1$iterator$1<K, V> r14 = (MutableScatterMap$MutableMapWrapper$entries$1$iterator$1) ZeusTransformUtils.preCheckCast(this.L$1, MutableScatterMap$MutableMapWrapper$entries$1$iterator$1.class, "com.obric.memorydata.plugin");
            SequenceScope r6 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r23);
        L24:
            int r9 = r5;
        L25:
            r8 = r8 >> 8;
            r4 = r4 + r9;
            r5 = r9;
            r3 = 8;
        L14:
            if (r4 < r7) goto L16;
            int r20 = r5;
            int r15 = r3;
            int r16 = r20;
            if (r7 != r15) goto L33;
            SequenceScope r17 = r6;
            int r18 = r10;
            int r19 = r11;
            long[] r21 = r12;
            MutableScatterMap<K, V> r22 = r13;
            MutableScatterMap$MutableMapWrapper$entries$1$iterator$1<K, V> r24 = r14;
        L30:
            if (r18 == r19) goto L33;
            r18 = r18 + 1;
            int r25 = r15;
            r5 = r16;
            r3 = r25;
        L11:
            long r110 = r21[r18];
            if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L29;
            r14 = r24;
            r13 = r22;
            r7 = 8 - ((~(r18 - r19)) >>> 31);
            r12 = r21;
            r6 = r17;
            r4 = 0;
            r11 = r19;
            r10 = r18;
            r8 = r110;
            goto L14
        L29:
            int r26 = r5;
            r15 = r3;
            r16 = r26;
        L33:
            return Unit.INSTANCE;
        L16:
            if ((r8 & 255) >= 128) goto L34;
            if (r5 == 0) goto L24;
            r14.setCurrent((r10 << 3) + r4);
            MutableMapEntry r27 = new MutableMapEntry(r13.keys, r13.values, r14.getCurrent());
            this.L$0 = r6;
            this.L$1 = r14;
            this.L$2 = r13;
            this.L$3 = r12;
            this.I$0 = r11;
            this.I$1 = r10;
            this.J$0 = r8;
            this.I$2 = r7;
            this.I$3 = r4;
            r9 = 1;
            this.label = 1;
            if (r6.yield(r27, this) != r1) goto L25;
            return r1;
        L34:
            if (0 == 0) goto L24;
            goto L24
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            r17 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ScatterMap r28 = (ScatterMap) ZeusTransformUtils.preCheckCast(this.this$0, ScatterMap.class, "com.obric.memorydata.plugin");
            r24 = this.this$1;
            r22 = this.this$0;
            r21 = r28.metadata;
            r19 = r21.length - 2;
            if (r19 < 0) goto L33;
            r18 = 0;
            goto L11
        }
    }

    MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(MutableScatterMap<K, V> r3) {
        this.this$0 = r3;
        this.current = -1;
        this.iterator = SequencesKt.iterator((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, this, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public final int getCurrent() {
        return this.current;
    }

    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(this.iterator.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Iterator
    public void remove() {
        int r0 = this.current;
        if (r0 == (-1)) goto L6;
        this.this$0.removeValueAt(r0);
        this.current = -1;
        return;
    }

    public final void setCurrent(int r1) {
        this.current = r1;
    }

    public final void setIterator(Iterator<? extends Map.Entry<K, V>> r3) {
        Iterator<? extends Map.Entry<K, V>> r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.iterator = r4;
    }
}
