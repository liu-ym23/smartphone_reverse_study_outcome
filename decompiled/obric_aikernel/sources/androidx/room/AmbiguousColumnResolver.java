package androidx.room;

import androidx.annotation.RestrictTo;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = null;

    private static final class Match {
        private final List<Integer> resultIndices;
        private final IntRange resultRange;

        public Match(IntRange r10, List<Integer> r11) {
            Intrinsics.checkNotNullParameter(r10, "resultRange");
            Intrinsics.checkNotNullParameter(r11, "resultIndices");
            this.resultRange = r10;
            this.resultIndices = r11;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final IntRange getResultRange() {
            return this.resultRange;
        }
    }

    private static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            this.name = r10;
            this.index = r11;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn r10, String r11, int r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r11 = r10.name;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r12 = r10.index;
        L9:
            return r10.copy(r11, r12);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return new ResultColumn(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ResultColumn) == true) goto L8;
            return false;
        L8:
            ResultColumn r11 = (ResultColumn) r10;
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L12;
            return false;
        L12:
            if (this.index == r11.index) goto L14;
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

    private static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = null;
        private static final Solution NO_SOLUTION = null;
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final Solution build(List<Match> r10) {
                Intrinsics.checkNotNullParameter(r10, "matches");
                Iterator<T> r11 = r10.iterator();
                int r12 = 0;
                int r13 = 0;
            L4:
                if (r11.hasNext() == false) goto L6;
                Match r14 = (Match) r11.next();
                r13 = r13 + (((r14.getResultRange().getLast() - r14.getResultRange().getFirst()) + 1) - r14.getResultIndices().size());
                goto L4
            L6:
                Iterator<T> r15 = r10.iterator();
                if (r15.hasNext() == false) goto L49;
                int r16 = ((Match) r15.next()).getResultRange().getFirst();
            L10:
                if (r15.hasNext() == false) goto L14;
                int r17 = ((Match) r15.next()).getResultRange().getFirst();
                if (r16 <= r17) goto L10;
                r16 = r17;
                goto L10
            L14:
                Iterator<T> r18 = r10.iterator();
                if (r18.hasNext() == false) goto L47;
                int r19 = ((Match) r18.next()).getResultRange().getLast();
            L18:
                if (r18.hasNext() == false) goto L22;
                int r20 = ((Match) r18.next()).getResultRange().getLast();
                if (r19 >= r20) goto L18;
                r19 = r20;
                goto L18
            L22:
                Iterable r21 = new IntRange(r16, r19);
                if ((r21 instanceof Collection) == true) goto L25;
            L27:
                Iterator r22 = r21.iterator();
                int r23 = 0;
            L29:
                if (r22.hasNext() == false) goto L43;
                int r24 = ((IntIterator) r22).nextInt();
                Iterator<T> r25 = r10.iterator();
                int r26 = 0;
            L32:
                if (r25.hasNext() == false) goto L38;
                if (((Match) r25.next()).getResultRange().contains(r24) == false) goto L36;
                r26 = r26 + 1;
            L36:
                if (r26 <= 1) goto L32;
                boolean r27 = true;
            L39:
                if (r27 == false) goto L29;
                r23 = r23 + 1;
                if (r23 >= 0) goto L29;
                CollectionsKt.throwCountOverflow();
                goto L29
            L38:
                r27 = false;
                goto L39
            L43:
                r12 = r23;
            L45:
                return new Solution(r10, r13, r12);
            L25:
                if (((Collection) r21).isEmpty() == false) goto L27;
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

        public Solution(List<Match> r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "matches");
            this.matches = r10;
            this.coverageOffset = r11;
            this.overlaps = r12;
        }

        public static final /* synthetic */ Solution access$getNO_SOLUTION$cp() {
            return NO_SOLUTION;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Solution r10) {
            Intrinsics.checkNotNullParameter(r10, "other");
            int r11 = Intrinsics.compare(this.overlaps, r10.overlaps);
            if (r11 == 0) goto L6;
            return r11;
        L6:
            return Intrinsics.compare(this.coverageOffset, r10.coverageOffset);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Solution r10) {
            return compareTo2(r10);
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

    private final <T> void dfs(List<? extends List<? extends T>> r10, List<T> r11, int r12, Function1<? super List<? extends T>, Unit> r13) {
        if (r12 != r10.size()) goto L6;
        r13.invoke(CollectionsKt.toList(r11));
        return;
    L6:
        Iterator<T> r14 = r10.get(r12).iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r11.add(r14.next());
        INSTANCE.dfs(r10, r11, r12 + 1, r13);
        CollectionsKt.removeLast(r11);
        goto L8
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver r10, List r11, List r12, int r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = new ArrayList();
    L6:
        if ((r15 & 4) == 0) goto L8;
        r13 = 0;
    L8:
        r10.dfs(r11, r12, r13, r14);
    }

    private final void rabinKarpSearch(List<ResultColumn> r10, String[] r11, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, Unit> r12) {
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r16 = r16 + r11[r15].hashCode();
        r15 = r15 + 1;
        goto L3
    L5:
        int r17 = r11.length;
        Iterator<T> r18 = r10.subList(0, r17).iterator();
        int r19 = 0;
    L7:
        if (r18.hasNext() == false) goto L9;
        r19 = r19 + ((ResultColumn) r18.next()).getName().hashCode();
    L9:
        if (r16 != r19) goto L11;
        r12.invoke(Integer.valueOf(r14), Integer.valueOf(r17), r10.subList(r14, r17));
    L11:
        r14 = r14 + 1;
        r17 = r17 + 1;
        if (r17 > r10.size()) goto L13;
        r19 = (r19 - r10.get(r14 - 1).getName().hashCode()) + r10.get(r17 - 1).getName().hashCode();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    @JvmStatic
    public static final int[][] resolve(String[] r18, String[][] r19) {
        Intrinsics.checkNotNullParameter(r18, "resultColumns");
        Intrinsics.checkNotNullParameter(r19, "mappings");
        int r10 = r18.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        boolean r13 = true;
        if (r12 >= r10) goto L11;
        String r14 = r18[r12];
        if (r14.charAt(0) != '`') goto L10;
        if (r14.charAt(r14.length() - 1) != '`') goto L10;
        r14 = r14.substring(1, r14.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        Locale r15 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r15, "US");
        String r16 = r14.toLowerCase(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).toLowerCase(locale)");
        r18[r12] = r16;
        r12 = r12 + 1;
        goto L3
    L11:
        int r17 = r19.length;
        int r20 = 0;
    L12:
        if (r20 >= r17) goto L17;
        int r21 = r19[r20].length;
        int r22 = 0;
    L14:
        if (r22 >= r21) goto L16;
        String[] r110 = r19[r20];
        String r111 = r19[r20][r22];
        Locale r112 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r112, "US");
        String r113 = r111.toLowerCase(r112);
        Intrinsics.checkNotNullExpressionValue(r113, "this as java.lang.String).toLowerCase(locale)");
        r110[r22] = r113;
        r22 = r22 + 1;
        goto L14
    L16:
        r20 = r20 + 1;
        goto L12
    L17:
        Set r23 = SetsKt.createSetBuilder();
        int r24 = r19.length;
        int r25 = 0;
    L18:
        if (r25 >= r24) goto L20;
        CollectionsKt.addAll(r23, r19[r25]);
        r25 = r25 + 1;
        goto L18
    L20:
        Set r26 = SetsKt.build(r23);
        List r27 = CollectionsKt.createListBuilder();
        int r28 = r18.length;
        int r29 = 0;
        int r30 = 0;
    L21:
        if (r29 >= r28) goto L26;
        String r31 = r18[r29];
        int r114 = r30 + 1;
        if (r26.contains(r31) == false) goto L25;
        r27.add(new ResultColumn(r31, r30));
    L25:
        r29 = r29 + 1;
        r30 = r114;
        goto L21
    L26:
        List<ResultColumn> r32 = CollectionsKt.build(r27);
        int r33 = r19.length;
        final ArrayList r34 = new ArrayList(r33);
        int r35 = 0;
    L27:
        if (r35 >= r33) goto L29;
        r34.add(new ArrayList());
        r35 = r35 + 1;
        goto L27
    L29:
        int r36 = r19.length;
        int r37 = 0;
        final int r38 = 0;
    L30:
        if (r37 >= r36) goto L50;
        final String[] r39 = r19[r37];
        int r40 = r38 + 1;
        INSTANCE.rabinKarpSearch(r32, r39, new AmbiguousColumnResolver$resolve$1$1(r39, r34, r38));
        if (((List) r34.get(r38)).isEmpty() == false) goto L48;
        ArrayList r115 = new ArrayList(r39.length);
        int r116 = r39.length;
        int r117 = r11;
    L34:
        if (r117 >= r116) goto L47;
        String r118 = r39[r117];
        List r119 = CollectionsKt.createListBuilder();
        Iterator<T> r120 = r32.iterator();
    L37:
        if (r120.hasNext() == false) goto L42;
        ResultColumn r121 = (ResultColumn) r120.next();
        if (Intrinsics.areEqual(r118, r121.getName()) == false) goto L37;
        r119.add(Integer.valueOf(r121.getIndex()));
        goto L37
    L42:
        List r41 = CollectionsKt.build(r119);
        if ((!r41.isEmpty()) == false) goto L46;
        r115.add(r41);
        r117 = r117 + 1;
        goto L34
    L46:
        throw new IllegalStateException(("Column " + r118 + " not found in result").toString());
    L47:
        dfs$default(INSTANCE, r115, null, 0, new AmbiguousColumnResolver$resolve$1$2(r34, r38), 6, null);
    L48:
        r37 = r37 + 1;
        r38 = r40;
        r11 = 0;
        goto L30
    L50:
        if (r34.isEmpty() == true) goto L58;
        Iterator r42 = r34.iterator();
    L54:
        if (r42.hasNext() == false) goto L58;
        if ((!((List) r42.next()).isEmpty()) == true) goto L54;
        r13 = false;
    L58:
        if (r13 == false) goto L66;
        final Ref.ObjectRef r43 = new Ref.ObjectRef();
        r43.element = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, r34, null, 0, new AnonymousClass4(r43), 6, null);
        List<Match> r44 = ((Solution) r43.element).getMatches();
        ArrayList r45 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator<T> r46 = r44.iterator();
    L61:
        if (r46.hasNext() == false) goto L63;
        r45.add(CollectionsKt.toIntArray(((Match) r46.next()).getResultIndices()));
        goto L61
    L63:
        Object[] r47 = r45.toArray(new int[0][]);
        Intrinsics.checkNotNull(r47, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) r47;
    L66:
        throw new IllegalStateException("Failed to find matches for all mappings".toString());
    }
}
