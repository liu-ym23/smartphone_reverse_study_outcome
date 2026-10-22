package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00070\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u00040\rH\u0002JO\u0010\u000e\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\u0004\u0012\u00020\u00040\u0014H\u0002¢\u0006\u0002\u0010\u0015J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0011H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", "()V", "dfs", "", ExifInterface.GPS_DIRECTION_TRUE, Params.CONTENT, "", "current", "", "depth", "", "block", "Lkotlin/Function1;", "rabinKarpSearch", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", XSDatatype.FACET_PATTERN, "", "", "onHashMatch", "Lkotlin/Function3;", "(Ljava/util/List;[Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "resolve", "", "resultColumns", "mappings", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "Match", "ResultColumn", "Solution", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "resultRange", "Lkotlin/ranges/IntRange;", "resultIndices", "", "", "(Lkotlin/ranges/IntRange;Ljava/util/List;)V", "getResultIndices", "()Ljava/util/List;", "getResultRange", "()Lkotlin/ranges/IntRange;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Match {
        private final List<Integer> resultIndices;
        private final IntRange resultRange;

        public Match(IntRange r3, List<Integer> r4) {
            List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "resultRange");
            Intrinsics.checkNotNullParameter(r5, "resultIndices");
            this.resultRange = r3;
            this.resultIndices = r5;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final IntRange getResultRange() {
            return this.resultRange;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", ActivityLifecycle.NAME, "", "index", "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            this.name = r2;
            this.index = r3;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.name;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.index;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, ActivityLifecycle.NAME);
            return new ResultColumn(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ResultColumn.class) == true) goto L8;
            return false;
        L8:
            ResultColumn r6 = (ResultColumn) ZeusTransformUtils.preCheckCast(r5, ResultColumn.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
            return false;
        L12:
            if (this.index == r6.index) goto L14;
            return false;
        L14:
            return true;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Integer.hashCode(this.index);
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", "(Ljava/util/List;II)V", "getCoverageOffset", "()I", "getMatches", "()Ljava/util/List;", "getOverlaps", "compareTo", "other", "Companion", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = null;
        private static final Solution NO_SOLUTION = null;
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", "build", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final Solution build(List<Match> r11) {
                List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r10, "matches");
                Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
                int r1 = 0;
                int r2 = 0;
            L4:
                if (r12.hasNext() == false) goto L6;
                Match r3 = (Match) ZeusTransformUtils.preCheckCast(r12.next(), Match.class, "com.obric.memorydata.plugin");
                r2 = r2 + (((r3.getResultRange().getLast() - r3.getResultRange().getFirst()) + 1) - r3.getResultIndices().size());
                goto L4
            L6:
                Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
                if (r13.hasNext() == false) goto L49;
                int r4 = ((Match) ZeusTransformUtils.preCheckCast(r13.next(), Match.class, "com.obric.memorydata.plugin")).getResultRange().getFirst();
            L10:
                if (r13.hasNext() == false) goto L14;
                int r5 = ((Match) ZeusTransformUtils.preCheckCast(r13.next(), Match.class, "com.obric.memorydata.plugin")).getResultRange().getFirst();
                if (r4 <= r5) goto L10;
                r4 = r5;
                goto L10
            L14:
                Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
                if (r14.hasNext() == false) goto L47;
                int r6 = ((Match) ZeusTransformUtils.preCheckCast(r14.next(), Match.class, "com.obric.memorydata.plugin")).getResultRange().getLast();
            L18:
                if (r14.hasNext() == false) goto L22;
                int r7 = ((Match) ZeusTransformUtils.preCheckCast(r14.next(), Match.class, "com.obric.memorydata.plugin")).getResultRange().getLast();
                if (r6 >= r7) goto L18;
                r6 = r7;
                goto L18
            L22:
                Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(r4, r6), Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L25;
            L27:
                Iterator r16 = r15.iterator();
                int r8 = 0;
            L29:
                if (r16.hasNext() == false) goto L43;
                int r9 = ((IntIterator) ZeusTransformUtils.preCheckCast(r16, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
                Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
                int r18 = 0;
            L32:
                if (r17.hasNext() == false) goto L38;
                if (((Match) ZeusTransformUtils.preCheckCast(r17.next(), Match.class, "com.obric.memorydata.plugin")).getResultRange().contains(r9) == false) goto L36;
                r18 = r18 + 1;
            L36:
                if (r18 <= 1) goto L32;
                boolean r19 = true;
            L39:
                if (r19 == false) goto L29;
                r8 = r8 + 1;
                if (r8 >= 0) goto L29;
                CollectionsKt.throwCountOverflow();
                goto L29
            L38:
                r19 = false;
                goto L39
            L43:
                r1 = r8;
            L45:
                return new Solution(r10, r2, r1);
            L25:
                if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
            L47:
                throw new NoSuchElementException();
            L49:
                throw new NoSuchElementException();
            }

            public final Solution getNO_SOLUTION() {
                return Solution.access$getNO_SOLUTION$cp();
            }
        }

        static {
            Companion = new Companion(null);
            NO_SOLUTION = new Solution(CollectionsKt.emptyList(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Solution(List<Match> r3, int r4, int r5) {
            List<Match> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "matches");
            this.matches = r6;
            this.coverageOffset = r4;
            this.overlaps = r5;
        }

        public static final /* synthetic */ Solution access$getNO_SOLUTION$cp() {
            return NO_SOLUTION;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Solution r3) {
            Intrinsics.checkNotNullParameter(r3, "other");
            int r0 = Intrinsics.compare(this.overlaps, r3.overlaps);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return Intrinsics.compare(this.coverageOffset, r3.coverageOffset);
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(Solution r3) {
            return compareTo2((Solution) ZeusTransformUtils.preCheckCast(r3, Solution.class, "com.obric.memorydata.plugin"));
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }
    }

    static {
        INSTANCE = new AmbiguousColumnResolver();
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> r3, List<T> r4, int r5, Function1<? super List<? extends T>, Unit> r6) {
        List<? extends List<? extends T>> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Function1<? super List<? extends T>, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        if (r5 != r2.size()) goto L6;
        r8.invoke(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")));
        return;
    L6:
        Iterator<T> r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.get(r5), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r7.add(r9.next());
        INSTANCE.dfs(r2, r7, r5 + 1, r8);
        CollectionsKt.removeLast(r7);
        goto L8
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver r1, List r2, List r3, int r4, Function1 r5, int r6, Object r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        r1.dfs(r8, r9, r4, r10);
    }

    private final void rabinKarpSearch(List<ResultColumn> r7, String[] r8, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, Unit> r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Function3 r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r9, Function3.class, "com.obric.memorydata.plugin");
        int r11 = r8.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r11) goto L5;
        r3 = r3 + r8[r2].hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        int r12 = r8.length;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.subList(0, r12), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
    L7:
        if (r13.hasNext() == false) goto L9;
        r4 = r4 + ((ResultColumn) ZeusTransformUtils.preCheckCast(r13.next(), ResultColumn.class, "com.obric.memorydata.plugin")).getName().hashCode();
    L9:
        if (r3 != r4) goto L11;
        r10.invoke(Integer.valueOf(r1), Integer.valueOf(r12), r6.subList(r1, r12));
    L11:
        r1 = r1 + 1;
        r12 = r12 + 1;
        if (r12 > r6.size()) goto L13;
        r4 = (r4 - ((ResultColumn) ZeusTransformUtils.preCheckCast(r6.get(r1 - 1), ResultColumn.class, "com.obric.memorydata.plugin")).getName().hashCode()) + ((ResultColumn) ZeusTransformUtils.preCheckCast(r6.get(r12 - 1), ResultColumn.class, "com.obric.memorydata.plugin")).getName().hashCode();
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    @JvmStatic
    public static final int[][] resolve(String[] r24, String[][] r25) {
        Intrinsics.checkNotNullParameter(r24, "resultColumns");
        Intrinsics.checkNotNullParameter(r25, "mappings");
        int r2 = r24.length;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L11;
        String r8 = r24[r4];
        if (r8.charAt(0) != '`') goto L10;
        if (r8.charAt(r8.length() - 1) != '`') goto L10;
        r8 = r8.substring(1, r8.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        Locale r7 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r7, "US");
        String r6 = r8.toLowerCase(r7);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(locale)");
        r24[r4] = r6;
        r4 = r4 + 1;
        goto L4
    L11:
        int r5 = ((Object[]) ZeusTransformUtils.preCheckCast(r25, Object[].class, "com.obric.memorydata.plugin")).length;
        int r9 = 0;
    L12:
        if (r9 >= r5) goto L17;
        int r10 = r25[r9].length;
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L16;
        String[] r12 = r25[r9];
        String r13 = r25[r9][r11];
        Locale r14 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r14, "US");
        String r15 = r13.toLowerCase(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(locale)");
        r12[r11] = r15;
        r11 = r11 + 1;
        goto L14
    L16:
        r9 = r9 + 1;
        goto L12
    L17:
        Set r16 = SetsKt.createSetBuilder();
        Object[] r17 = (Object[]) ZeusTransformUtils.preCheckCast(r25, Object[].class, "com.obric.memorydata.plugin");
        int r18 = r17.length;
        int r19 = 0;
    L18:
        if (r19 >= r18) goto L20;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r17[r19], String[].class, "com.obric.memorydata.plugin"));
        r19 = r19 + 1;
        goto L18
    L20:
        Set r20 = SetsKt.build(r16);
        List r21 = CollectionsKt.createListBuilder();
        int r22 = r24.length;
        int r23 = 0;
        int r26 = 0;
    L21:
        if (r23 >= r22) goto L26;
        String r110 = r24[r23];
        int r111 = r26 + 1;
        if (r20.contains(r110) == false) goto L25;
        r21.add(new ResultColumn(r110, r26));
    L25:
        r23 = r23 + 1;
        r26 = r111;
        goto L21
    L26:
        List<ResultColumn> r0 = CollectionsKt.build(r21);
        int r27 = ((Object[]) ZeusTransformUtils.preCheckCast(r25, Object[].class, "com.obric.memorydata.plugin")).length;
        ArrayList r28 = new ArrayList(r27);
        int r29 = 0;
    L27:
        if (r29 >= r27) goto L29;
        r28.add((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        r29 = r29 + 1;
        goto L27
    L29:
        final List r30 = (List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin");
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r25, Object[].class, "com.obric.memorydata.plugin");
        int r31 = r1.length;
        int r32 = 0;
        final int r33 = 0;
    L30:
        if (r32 >= r31) goto L50;
        int r112 = r33 + 1;
        final String[] r34 = (String[]) ZeusTransformUtils.preCheckCast(r1[r32], String[].class, "com.obric.memorydata.plugin");
        INSTANCE.rabinKarpSearch(r0, r34, (Function3) ZeusTransformUtils.preCheckCast(new AmbiguousColumnResolver$resolve$1$1(r34, r30, r33), Function3.class, "com.obric.memorydata.plugin"));
        if (((List) ZeusTransformUtils.preCheckCast(r30.get(r33), List.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L48;
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r34.length), Collection.class, "com.obric.memorydata.plugin");
        int r114 = r34.length;
        int r115 = r3;
    L34:
        if (r115 >= r114) goto L47;
        String r116 = r34[r115];
        List r117 = CollectionsKt.createListBuilder();
        Iterator r35 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L37:
        if (r35.hasNext() == false) goto L42;
        List<ResultColumn> r210 = r0;
        ResultColumn r36 = (ResultColumn) ZeusTransformUtils.preCheckCast(r35.next(), ResultColumn.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r116, r36.getName()) == false) goto L41;
        r117.add(Integer.valueOf(r36.getIndex()));
    L41:
        r0 = r210;
        goto L37
    L42:
        List<ResultColumn> r211 = r0;
        List r37 = CollectionsKt.build(r117);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r37, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L46;
        r113.add(r37);
        r115 = r115 + 1;
        r0 = r211;
        goto L34
    L46:
        throw new IllegalStateException(("Column " + r116 + " not found in result").toString());
    L47:
        List<ResultColumn> r212 = r0;
        dfs$default(INSTANCE, (List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin"), null, 0, (Function1) ZeusTransformUtils.preCheckCast(new AmbiguousColumnResolver$resolve$1$2(r30, r33), Function1.class, "com.obric.memorydata.plugin"), 6, null);
    L49:
        r32 = r32 + 1;
        r0 = r212;
        r33 = r112;
        r3 = 0;
        goto L30
    L48:
        r212 = r0;
        goto L49
    L50:
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r38, Collection.class) == true) goto L53;
    L55:
        Iterator r39 = r38.iterator();
    L57:
        if (r39.hasNext() == false) goto L61;
        if ((!((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r39.next(), List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L57;
        boolean r40 = false;
    L62:
        if (r40 == false) goto L70;
        final Ref.ObjectRef r41 = new Ref.ObjectRef();
        r41.element = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, r30, null, 0, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r41), Function1.class, "com.obric.memorydata.plugin"), 6, null);
        Iterable r42 = (Iterable) ZeusTransformUtils.preCheckCast(((Solution) ZeusTransformUtils.preCheckCast(r41.element, Solution.class, "com.obric.memorydata.plugin")).getMatches(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r43 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r44 = r42.iterator();
    L65:
        if (r44.hasNext() == false) goto L67;
        r43.add(CollectionsKt.toIntArray((Collection) ZeusTransformUtils.preCheckCast(((Match) ZeusTransformUtils.preCheckCast(r44.next(), Match.class, "com.obric.memorydata.plugin")).getResultIndices(), Collection.class, "com.obric.memorydata.plugin")));
        goto L65
    L67:
        Object[] r45 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r43, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new int[0][]);
        Intrinsics.checkNotNull(r45, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) ZeusTransformUtils.preCheckCast(r45, int[][].class, "com.obric.memorydata.plugin");
    L70:
        throw new IllegalStateException("Failed to find matches for all mappings".toString());
    L61:
        r40 = true;
        goto L62
    L53:
        if (((Collection) ZeusTransformUtils.preCheckCast(r38, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L55;
        r40 = true;
        goto L62
    }
}
