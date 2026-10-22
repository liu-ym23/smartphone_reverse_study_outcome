package androidx.compose.runtime.snapshots;

import ai.j0;
import androidx.compose.runtime.Immutable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J \u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\bø\u0001\u0000J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Immutable
@SourceDebugExtension({"SMAP\nSnapshotIdSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotIdSet.kt\nandroidx/compose/runtime/snapshots/SnapshotIdSet\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,397:1\n13600#2,2:398\n1789#3,3:400\n1789#3,3:403\n1789#3,3:406\n1789#3,3:409\n1789#3,3:412\n1549#3:415\n1620#3,3:416\n*S KotlinDebug\n*F\n+ 1 SnapshotIdSet.kt\nandroidx/compose/runtime/snapshots/SnapshotIdSet\n*L\n107#1:398,2\n236#1:400,3\n257#1:403,3\n261#1:406,3\n283#1:409,3\n286#1:412,3\n343#1:415\n343#1:416,3\n*E\n"})
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final Companion Companion = null;
    private static final SnapshotIdSet EMPTY = null;
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.access$getEMPTY$cp();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, StatusLine.HTTP_TEMP_REDIRECT}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ SnapshotIdSet this$0;

        public AnonymousClass1(SnapshotIdSet r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass1 r11 = new AnonymousClass1(this.this$0, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super Integer> r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0072 -> B:19:0x0075). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0092 -> B:30:0x00ae). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ab -> B:30:0x00ae). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ca -> B:43:0x00ea). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e8 -> B:42:0x00e9). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r20) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L12;
            if (r10 == 1) goto L11;
            if (r10 == 2) goto L10;
            if (r10 != 3) goto L9;
            int r11 = this.I$0;
            SequenceScope r12 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L42:
            int r13 = r11;
        L43:
            r13 = r13 + 1;
        L35:
            if (r13 >= 64) goto L45;
            if ((SnapshotIdSet.access$getUpperSet$p(this.this$0) & (1 << r13)) == 0) goto L43;
            int r14 = SnapshotIdSet.access$getLowerBound$p(this.this$0);
            Integer r15 = Boxing.boxInt(r14 + (r13 + 64));
            this.L$0 = r12;
            this.L$1 = null;
            this.I$0 = r13;
            this.label = 3;
            if (r12.yield(r15, this) != r5) goto L41;
            return r5;
        L41:
            r11 = r13;
        L45:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r16 = this.I$0;
            SequenceScope r17 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L30:
            r16 = r16 + 1;
        L24:
            if (r16 < 64) goto L26;
            SequenceScope r18 = r17;
        L33:
            if (SnapshotIdSet.access$getUpperSet$p(this.this$0) == 0) goto L45;
            r12 = r18;
            r13 = 0;
            goto L35
        L26:
            if ((SnapshotIdSet.access$getLowerSet$p(this.this$0) & (1 << r16)) == 0) goto L30;
            Integer r19 = Boxing.boxInt(SnapshotIdSet.access$getLowerBound$p(this.this$0) + r16);
            this.L$0 = r17;
            this.L$1 = null;
            this.I$0 = r16;
            this.label = 2;
            if (r17.yield(r19, this) != r5) goto L30;
            return r5;
        L11:
            int r21 = this.I$1;
            int r110 = this.I$0;
            int[] r111 = (int[]) this.L$1;
            SequenceScope r112 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L19:
            r110 = r110 + 1;
        L15:
            if (r110 >= r21) goto L20;
            Integer r22 = Boxing.boxInt(r111[r110]);
            this.L$0 = r112;
            this.L$1 = r111;
            this.I$0 = r110;
            this.I$1 = r21;
            this.label = 1;
            if (r112.yield(r22, this) != r5) goto L19;
            return r5;
        L20:
            r18 = r112;
        L22:
            if (SnapshotIdSet.access$getLowerSet$p(this.this$0) == 0) goto L33;
            r17 = r18;
            r16 = 0;
            goto L24
        L12:
            ResultKt.throwOnFailure(r20);
            r18 = (SequenceScope) this.L$0;
            int[] r113 = SnapshotIdSet.access$getBelowBound$p(this.this$0);
            if (r113 == null) goto L22;
            r112 = r18;
            r21 = r113.length;
            r111 = r113;
            r110 = 0;
            goto L15
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Integer> r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new SnapshotIdSet(0, 0, 0, null);
    }

    private SnapshotIdSet(long r5, long r10, int r11, int[] r12) {
        this.upperSet = r5;
        this.lowerSet = r10;
        this.lowerBound = r11;
        this.belowBound = r12;
    }

    public static final /* synthetic */ int[] access$getBelowBound$p(SnapshotIdSet r5) {
        return r5.belowBound;
    }

    public static final /* synthetic */ SnapshotIdSet access$getEMPTY$cp() {
        return EMPTY;
    }

    public static final /* synthetic */ int access$getLowerBound$p(SnapshotIdSet r5) {
        return r5.lowerBound;
    }

    public static final /* synthetic */ long access$getLowerSet$p(SnapshotIdSet r5) {
        return r5.lowerSet;
    }

    public static final /* synthetic */ long access$getUpperSet$p(SnapshotIdSet r5) {
        return r5.upperSet;
    }

    public final SnapshotIdSet and(SnapshotIdSet r18) {
        Intrinsics.checkNotNullParameter(r18, "bits");
        SnapshotIdSet r5 = EMPTY;
        if (Intrinsics.areEqual(r18, r5) == false) goto L6;
        return r5;
    L6:
        if (Intrinsics.areEqual(this, r5) == false) goto L8;
        return r5;
    L8:
        int r10 = r18.lowerBound;
        int r11 = this.lowerBound;
        if (r10 != r11) goto L20;
        int[] r12 = r18.belowBound;
        int[] r13 = this.belowBound;
        if (r12 != r13) goto L20;
        long r14 = this.upperSet;
        long r15 = r18.upperSet;
        long r16 = r14 & r15;
        long r17 = this.lowerSet;
        long r19 = r18.lowerSet;
        long r110 = r17 & r19;
        if (r16 != 0) goto L33;
        if (r110 != 0) goto L33;
        if (r13 != null) goto L33;
        return r5;
    L33:
        return new SnapshotIdSet(r15 & r14, r17 & r19, r11, r13);
    L20:
        if (this.belowBound != null) goto L27;
        Iterator<Integer> r20 = iterator();
    L23:
        if (r20.hasNext() == false) goto L45;
        int r21 = r20.next().intValue();
        if (r18.get(r21) == false) goto L23;
        r5 = r5.set(r21);
        goto L23
    L45:
        return r5;
    L27:
        Iterator<Integer> r22 = r18.iterator();
    L29:
        if (r22.hasNext() == false) goto L46;
        int r23 = r22.next().intValue();
        if (get(r23) == false) goto L29;
        r5 = r5.set(r23);
        goto L29
    L46:
        return r5;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet r10) {
        Intrinsics.checkNotNullParameter(r10, "bits");
        SnapshotIdSet r5 = EMPTY;
        if (r10 != r5) goto L5;
        return this;
    L5:
        if (this != r5) goto L7;
        return r5;
    L7:
        int r11 = r10.lowerBound;
        int r12 = this.lowerBound;
        if (r11 != r12) goto L12;
        int[] r13 = r10.belowBound;
        int[] r14 = this.belowBound;
        if (r13 != r14) goto L12;
        return new SnapshotIdSet(this.upperSet & (~r10.upperSet), this.lowerSet & (~r10.lowerSet), r12, r14);
    L12:
        Iterator<Integer> r15 = r10.iterator();
    L14:
        if (r15.hasNext() == false) goto L17;
        SnapshotIdSet this = this.clear(r15.next().intValue());
        goto L14
    L17:
        return this;
    }

    public final SnapshotIdSet clear(int r20) {
        int r5 = this.lowerBound;
        int r10 = r20 - r5;
        if (r10 < 0) goto L9;
        if (r10 >= 64) goto L9;
        long r11 = 1 << r10;
        long r12 = this.lowerSet;
        if ((r12 & r11) != 0) goto L8;
    L32:
        return this;
    L8:
        return new SnapshotIdSet(this.upperSet, r12 & (~r11), r5, this.belowBound);
    L9:
        if (r10 >= 64) goto L11;
    L16:
        if (r10 >= 0) goto L32;
        int[] r13 = this.belowBound;
        if (r13 == null) goto L32;
        int r14 = SnapshotIdSetKt.binarySearch(r13, r20);
        if (r14 < 0) goto L32;
        int r15 = r13.length;
        int r16 = r15 - 1;
        if (r16 == 0) goto L24;
        int[] r17 = new int[r16];
        if (r14 <= 0) goto L28;
        ArraysKt.a(0, 0, r13, r17, r14);
    L28:
        if (r14 >= r16) goto L31;
        ArraysKt.a(r14, r14 + 1, r13, r17, r15);
    L31:
        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, r17);
    L24:
        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
    L11:
        if (r10 >= 128) goto L16;
        long r18 = 1 << (r10 - 64);
        long r19 = this.upperSet;
        if ((r19 & r18) == 0) goto L32;
        return new SnapshotIdSet((~r18) & r19, this.lowerSet, r5, this.belowBound);
    }

    public final void fastForEach(Function1<? super Integer, Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "block");
        int[] r5 = access$getBelowBound$p(this);
        int r10 = 0;
        if (r5 == null) goto L8;
        int r11 = r5.length;
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L8;
        r12.invoke(Integer.valueOf(r5[r13]));
        r13 = r13 + 1;
    L8:
        if (access$getLowerSet$p(this) == 0) goto L16;
        int r14 = 0;
    L10:
        if (r14 >= 64) goto L16;
        if ((access$getLowerSet$p(this) & (1 << r14)) == 0) goto L14;
        r12.invoke(Integer.valueOf(access$getLowerBound$p(this) + r14));
    L14:
        r14 = r14 + 1;
    L16:
        if (access$getUpperSet$p(this) == 0) goto L22;
    L17:
        if (r10 >= 64) goto L30;
        if ((access$getUpperSet$p(this) & (1 << r10)) == 0) goto L21;
        r12.invoke(Integer.valueOf(access$getLowerBound$p(this) + (r10 + 64)));
    L21:
        r10 = r10 + 1;
        goto L17
    L30:
        return;
    }

    public final boolean get(int r10) {
        int r5 = r10 - this.lowerBound;
        boolean r11 = true;
        if (r5 < 0) goto L10;
        if (r5 >= 64) goto L10;
        if ((this.lowerSet & (1 << r5)) == 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r5 >= 64) goto L12;
    L18:
        if (r5 <= 0) goto L20;
        return false;
    L20:
        int[] r12 = this.belowBound;
        if (r12 != null) goto L23;
        return false;
    L23:
        if (SnapshotIdSetKt.binarySearch(r12, r10) >= 0) goto L27;
        r11 = false;
    L27:
        return r11;
    L12:
        if (r5 >= 128) goto L18;
        if ((this.upperSet & (1 << (r5 - 64))) == 0) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new AnonymousClass1(this, null)).iterator();
    }

    public final int lowest(int r10) {
        int[] r5 = this.belowBound;
        if (r5 != null) goto L5;
        long r11 = this.lowerSet;
        if (r11 == 0) goto L11;
        int r12 = this.lowerBound;
        int r13 = SnapshotIdSetKt.access$lowestBitOf(r11);
    L10:
        return r13 + r12;
    L11:
        long r14 = this.upperSet;
        if (r14 == 0) goto L14;
        r12 = this.lowerBound + 64;
        r13 = SnapshotIdSetKt.access$lowestBitOf(r14);
        goto L10
    L14:
        return r10;
    L5:
        return r5[0];
    }

    public final SnapshotIdSet or(SnapshotIdSet r10) {
        Intrinsics.checkNotNullParameter(r10, "bits");
        SnapshotIdSet r5 = EMPTY;
        if (r10 != r5) goto L5;
        return this;
    L5:
        if (this != r5) goto L7;
        return r10;
    L7:
        int r11 = r10.lowerBound;
        int r12 = this.lowerBound;
        if (r11 != r12) goto L13;
        int[] r13 = r10.belowBound;
        int[] r14 = this.belowBound;
        if (r13 != r14) goto L13;
        return new SnapshotIdSet(this.upperSet | r10.upperSet, this.lowerSet | r10.lowerSet, r12, r14);
    L13:
        if (this.belowBound != null) goto L19;
        Iterator<Integer> r15 = iterator();
    L16:
        if (r15.hasNext() == false) goto L28;
        r10 = r10.set(r15.next().intValue());
        goto L16
    L28:
        return r10;
    L19:
        Iterator<Integer> r16 = r10.iterator();
    L21:
        if (r16.hasNext() == false) goto L24;
        SnapshotIdSet this = this.set(r16.next().intValue());
        goto L21
    L24:
        return this;
    }

    public final SnapshotIdSet set(int r20) {
        int r5 = this.lowerBound;
        int r10 = r20 - r5;
        long r11 = 1;
        long r12 = 0;
        if (r10 < 0) goto L10;
        if (r10 >= 64) goto L10;
        long r13 = 1 << r10;
        long r14 = this.lowerSet;
        if ((r14 & r13) == 0) goto L8;
    L60:
        return this;
    L8:
        return new SnapshotIdSet(this.upperSet, r14 | r13, r5, this.belowBound);
    L10:
        if (r10 < 64) goto L16;
        if (r10 >= 128) goto L16;
        long r15 = 1 << (r10 - 64);
        long r16 = this.upperSet;
        if ((r16 & r15) != 0) goto L60;
        return new SnapshotIdSet(r15 | r16, this.lowerSet, r5, this.belowBound);
    L16:
        if (r10 >= 128) goto L18;
        int[] r17 = this.belowBound;
        if (r17 == null) goto L55;
        int r18 = SnapshotIdSetKt.binarySearch(r17, r20);
        if (r18 >= 0) goto L60;
        int r19 = -(r18 + 1);
        int r21 = r17.length;
        int[] r110 = new int[r21 + 1];
        ArraysKt.a(0, 0, r17, r110, r19);
        ArraysKt.a(r19 + 1, r19, r17, r110, r21);
        r110[r19] = r20;
        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, r110);
    L55:
        return new SnapshotIdSet(this.upperSet, this.lowerSet, r5, new int[]{r20});
    L18:
        if (get(r20) == true) goto L60;
        long r111 = this.upperSet;
        long r112 = this.lowerSet;
        int r22 = this.lowerBound;
        int r23 = ((r20 + 1) / 64) * 64;
        ArrayList r24 = null;
        long r113 = r112;
        long r114 = r111;
    L20:
        if (r22 >= r23) goto L42;
        if (r113 == r12) goto L37;
        if (r24 != null) goto L29;
        r24 = new ArrayList();
        int[] r115 = this.belowBound;
        if (r115 == null) goto L29;
        int r116 = r115.length;
        int r25 = 0;
    L27:
        if (r25 >= r116) goto L29;
        r25 = j0.d(r115[r25], r24, r25, 1);
    L29:
        int r26 = 0;
    L30:
        long r27 = 1;
        if (r26 >= 64) goto L39;
        if (((1 << r26) & r113) == 0) goto L35;
        r24.add(Integer.valueOf(r26 + r22));
    L35:
        r26 = r26 + 1;
    L39:
        if (r114 == 0) goto L40;
        r22 = r22 + 64;
        r113 = r114;
        r114 = 0;
        r11 = r27;
        r12 = 0;
        goto L20
    L40:
        r113 = 0;
        int r117 = r23;
    L44:
        if (r24 == null) goto L49;
        int[] r28 = CollectionsKt.toIntArray(r24);
        if (r28 == null) goto L49;
        int[] r118 = r28;
    L51:
        return new SnapshotIdSet(r114, r113, r117, r118).set(r20);
    L49:
        r118 = this.belowBound;
        goto L51
    L37:
        r27 = r11;
        goto L39
    L42:
        r117 = r22;
        goto L44
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        r5.append(" [");
        ArrayList r10 = new ArrayList(CollectionsKt.h(this));
        Iterator<Integer> r11 = iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10.add(String.valueOf(r11.next().intValue()));
        goto L4
    L7:
        return j0.p(r5, ListUtilsKt.fastJoinToString$default(r10, null, null, null, 0, null, null, 63, null), ']');
    }
}
