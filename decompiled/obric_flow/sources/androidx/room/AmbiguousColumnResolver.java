package androidx.room;

import ai.j0;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00070\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u00040\rH\u0002JO\u0010\u000e\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\u0004\u0012\u00020\u00040\u0014H\u0002¢\u0006\u0002\u0010\u0015J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0011H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", "()V", "dfs", "", ExifInterface.GPS_DIRECTION_TRUE, "content", "", "current", "", "depth", "", "block", "Lkotlin/Function1;", "rabinKarpSearch", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "pattern", "", "", "onHashMatch", "Lkotlin/Function3;", "(Ljava/util/List;[Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "resolve", "", "resultColumns", "mappings", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "Match", "ResultColumn", "Solution", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "resultRange", "Lkotlin/ranges/IntRange;", "resultIndices", "", "", "(Lkotlin/ranges/IntRange;Ljava/util/List;)V", "getResultIndices", "()Ljava/util/List;", "getResultRange", "()Lkotlin/ranges/IntRange;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Match {
        private final List<Integer> resultIndices;
        private final IntRange resultRange;

        public Match(IntRange r5, List<Integer> r10) {
            Intrinsics.checkNotNullParameter(r5, "resultRange");
            Intrinsics.checkNotNullParameter(r10, "resultIndices");
            this.resultRange = r5;
            this.resultIndices = r10;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final IntRange getResultRange() {
            return this.resultRange;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", "name", "", "index", "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            this.name = r5;
            this.index = r10;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn r5, String r10, int r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.name;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.index;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return new ResultColumn(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ResultColumn) == true) goto L8;
            return false;
        L8:
            ResultColumn r10 = (ResultColumn) r5;
            if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
            return false;
        L12:
            if (this.index == r10.index) goto L14;
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
            int r5 = this.name.hashCode() * 31;
            return Integer.hashCode(this.index) + r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("ResultColumn(name=");
            r5.append(this.name);
            r5.append(", index=");
            return j0.n(r5, this.index, ')');
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", "(Ljava/util/List;II)V", "getCoverageOffset", "()I", "getMatches", "()Ljava/util/List;", "getOverlaps", "compareTo", "other", "Companion", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = null;
        private static final Solution NO_SOLUTION = null;
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", "build", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final Solution build(List<Match> r10) {
                Intrinsics.checkNotNullParameter(r10, "matches");
                Iterator<T> r11 = r10.iterator();
                int r5 = 0;
                int r12 = 0;
            L4:
                if (r11.hasNext() == false) goto L6;
                Match r13 = (Match) r11.next();
                r12 = r12 + (((r13.getResultRange().getLast() - r13.getResultRange().getFirst()) + 1) - r13.getResultIndices().size());
                goto L4
            L6:
                Iterator<T> r14 = r10.iterator();
                if (r14.hasNext() == false) goto L46;
                int r15 = ((Match) r14.next()).getResultRange().getFirst();
            L10:
                if (r14.hasNext() == false) goto L14;
                int r16 = ((Match) r14.next()).getResultRange().getFirst();
                if (r15 <= r16) goto L10;
                r15 = r16;
                goto L10
            L14:
                Iterator<T> r17 = r10.iterator();
                if (r17.hasNext() == false) goto L44;
                int r18 = ((Match) r17.next()).getResultRange().getLast();
            L18:
                if (r17.hasNext() == false) goto L22;
                int r19 = ((Match) r17.next()).getResultRange().getLast();
                if (r18 >= r19) goto L18;
                r18 = r19;
                goto L18
            L22:
                Iterable r20 = new IntRange(r15, r18);
                if ((r20 instanceof Collection) == true) goto L25;
            L27:
                Iterator r21 = r20.iterator();
                int r22 = 0;
            L29:
                if (r21.hasNext() == false) goto L40;
                int r23 = ((IntIterator) r21).nextInt();
                Iterator<T> r24 = r10.iterator();
                int r25 = 0;
            L32:
                if (r24.hasNext() == false) goto L29;
                if (((Match) r24.next()).getResultRange().contains(r23) == false) goto L36;
                r25 = r25 + 1;
            L36:
                if (r25 <= 1) goto L32;
                r22 = r22 + 1;
                if (r22 >= 0) goto L29;
                CollectionsKt.throwCountOverflow();
                goto L29
            L40:
                r5 = r22;
            L42:
                return new Solution(r10, r12, r5);
            L25:
                if (((Collection) r20).isEmpty() == false) goto L27;
            L44:
                throw new NoSuchElementException();
            L46:
                throw new NoSuchElementException();
            }

            public final Solution getNO_SOLUTION() {
                return Solution.access$getNO_SOLUTION$cp();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            NO_SOLUTION = new Solution(CollectionsKt.emptyList(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Solution(List<Match> r5, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r5, "matches");
            this.matches = r5;
            this.coverageOffset = r10;
            this.overlaps = r11;
        }

        public static final /* synthetic */ Solution access$getNO_SOLUTION$cp() {
            return NO_SOLUTION;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Solution r5) {
            return compareTo2(r5);
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

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Solution r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            int r10 = Intrinsics.compare(this.overlaps, r5.overlaps);
            if (r10 == 0) goto L6;
            return r10;
        L6:
            return Intrinsics.compare(this.coverageOffset, r5.coverageOffset);
        }
    }

    static {
        INSTANCE = new AmbiguousColumnResolver();
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> r5, List<T> r10, int r11, Function1<? super List<? extends T>, Unit> r12) {
        if (r11 != r5.size()) goto L6;
        r12.invoke(CollectionsKt.toList(r10));
        return;
    L6:
        Iterator<T> r13 = r5.get(r11).iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r10.add(r13.next());
        INSTANCE.dfs(r5, r10, r11 + 1, r12);
        CollectionsKt.removeLast(r10);
        goto L8
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver r5, List r10, List r11, int r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = new ArrayList();
    L6:
        if ((r14 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        r5.dfs(r10, r11, r12, r13);
    }

    private final void rabinKarpSearch(List<ResultColumn> r10, String[] r11, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, Unit> r12) {
        int r5 = r11.length;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r5) goto L5;
        r15 = r15 + r11[r14].hashCode();
        r14 = r14 + 1;
        goto L3
    L5:
        int r16 = r11.length;
        Iterator<T> r17 = r10.subList(0, r16).iterator();
        int r18 = 0;
    L7:
        if (r17.hasNext() == false) goto L9;
        r18 = r18 + ((ResultColumn) r17.next()).getName().hashCode();
    L9:
        if (r15 != r18) goto L11;
        r12.invoke(Integer.valueOf(r13), Integer.valueOf(r16), r10.subList(r13, r16));
    L11:
        int r19 = r13 + 1;
        int r20 = r16 + 1;
        if (r20 > r10.size()) goto L13;
        r18 = (r18 - r10.get(r13).getName().hashCode()) + r10.get(r16).getName().hashCode();
        r13 = r19;
        r16 = r20;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    @JvmStatic
    public static final int[][] resolve(String[] r17, String[][] r18) {
        Intrinsics.checkNotNullParameter(r17, "resultColumns");
        Intrinsics.checkNotNullParameter(r18, "mappings");
        int r5 = r17.length;
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        String r12 = r17[r11];
        if (r12.charAt(0) != '`') goto L9;
        if (r12.charAt(r12.length() - 1) != '`') goto L9;
        r12 = androidx.constraintlayout.motion.widget.a.n(r12, 1, 1);
    L9:
        r17[r11] = r12.toLowerCase(Locale.US);
        r11 = r11 + 1;
        goto L3
    L10:
        int r13 = r18.length;
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L16;
        int r15 = r18[r14].length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L15;
        String[] r19 = r18[r14];
        r19[r16] = r19[r16].toLowerCase(Locale.US);
        r16 = r16 + 1;
        goto L13
    L15:
        r14 = r14 + 1;
        goto L11
    L16:
        Set r20 = SetsKt.createSetBuilder();
        int r21 = r18.length;
        int r22 = 0;
    L17:
        if (r22 >= r21) goto L19;
        CollectionsKt.c(r20, r18[r22]);
        r22 = r22 + 1;
        goto L17
    L19:
        Set r23 = SetsKt.build(r20);
        List r24 = CollectionsKt.createListBuilder();
        int r25 = r17.length;
        int r26 = 0;
        int r27 = 0;
    L20:
        if (r26 >= r25) goto L25;
        String r28 = r17[r26];
        int r29 = r27 + 1;
        if (r23.contains(r28) == false) goto L24;
        r24.add(new ResultColumn(r28, r27));
    L24:
        r26 = r26 + 1;
        r27 = r29;
        goto L20
    L25:
        List<ResultColumn> r30 = CollectionsKt.build(r24);
        int r31 = r18.length;
        final ArrayList r32 = new ArrayList(r31);
        int r33 = 0;
    L26:
        if (r33 >= r31) goto L28;
        r32.add(new ArrayList());
        r33 = r33 + 1;
        goto L26
    L28:
        int r34 = r18.length;
        int r35 = 0;
        final int r36 = 0;
    L29:
        if (r35 >= r34) goto L49;
        final String[] r37 = r18[r35];
        int r38 = r36 + 1;
        INSTANCE.rabinKarpSearch(r30, r37, new AmbiguousColumnResolver$resolve$1$1(r37, r32, r36));
        if (((List) r32.get(r36)).isEmpty() == false) goto L47;
        ArrayList r110 = new ArrayList(r37.length);
        int r39 = r37.length;
        int r111 = r10;
    L33:
        if (r111 >= r39) goto L46;
        String r112 = r37[r111];
        List r113 = CollectionsKt.createListBuilder();
        Iterator<T> r114 = r30.iterator();
    L36:
        if (r114.hasNext() == false) goto L41;
        ResultColumn r115 = (ResultColumn) r114.next();
        if (Intrinsics.areEqual(r112, r115.getName()) == false) goto L36;
        r113.add(Integer.valueOf(r115.getIndex()));
        goto L36
    L41:
        List r40 = CollectionsKt.build(r113);
        if (r40.isEmpty() == true) goto L45;
        r110.add(r40);
        r111 = r111 + 1;
        goto L33
    L45:
        throw new IllegalStateException(j0.k("Column ", r112, " not found in result").toString());
    L46:
        dfs$default(INSTANCE, r110, null, 0, new AmbiguousColumnResolver$resolve$1$2(r32, r36), 6, null);
    L47:
        r35 = r35 + 1;
        r36 = r38;
        r10 = 0;
        goto L29
    L49:
        if (r32.isEmpty() == true) goto L59;
        Iterator r41 = r32.iterator();
    L53:
        if (r41.hasNext() == false) goto L59;
        if (((List) r41.next()).isEmpty() == false) goto L53;
        throw new IllegalStateException("Failed to find matches for all mappings");
    L59:
        final Ref.ObjectRef r42 = new Ref.ObjectRef();
        r42.element = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, r32, null, 0, new AnonymousClass4(r42), 6, null);
        List<Match> r43 = ((Solution) r42.element).getMatches();
        ArrayList r44 = new ArrayList(CollectionsKt.h(r43));
        Iterator<T> r45 = r43.iterator();
    L61:
        if (r45.hasNext() == false) goto L63;
        r44.add(CollectionsKt.toIntArray(((Match) r45.next()).getResultIndices()));
        goto L61
    L63:
        Object[] r46 = r44.toArray(new int[0][]);
        Intrinsics.checkNotNull(r46, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) r46;
    }
}
