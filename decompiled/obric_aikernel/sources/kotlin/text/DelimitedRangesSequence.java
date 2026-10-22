package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes3.dex */
final class DelimitedRangesSequence implements Sequence<IntRange> {
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
    private final CharSequence input;
    private final int limit;
    private final int startIndex;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<IntRange>, KMappedMarker {
        private int counter;
        private int currentStartIndex;
        private IntRange nextItem;
        private int nextSearchIndex;
        private int nextState;
        final /* synthetic */ DelimitedRangesSequence this$0;

        AnonymousClass1(DelimitedRangesSequence r10) {
            this.this$0 = r10;
            this.nextState = -1;
            int r11 = RangesKt.coerceIn(DelimitedRangesSequence.access$getStartIndex$p(r10), 0, DelimitedRangesSequence.access$getInput$p(r10).length());
            this.currentStartIndex = r11;
            this.nextSearchIndex = r11;
        }

        private final void calcNext() {
            int r10 = 0;
            if (this.nextSearchIndex >= 0) goto L5;
            this.nextState = 0;
            this.nextItem = null;
            return;
        L5:
            int r11 = -1;
            if (DelimitedRangesSequence.access$getLimit$p(this.this$0) <= 0) goto L10;
            int r12 = this.counter + 1;
            this.counter = r12;
            if (r12 < DelimitedRangesSequence.access$getLimit$p(this.this$0)) goto L10;
        L11:
            IntRange r13 = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
        L12:
            this.nextItem = r13;
        L13:
            this.nextSearchIndex = r11;
            this.nextState = 1;
            return;
        L10:
            if (this.nextSearchIndex > DelimitedRangesSequence.access$getInput$p(this.this$0).length()) goto L11;
            Pair r14 = (Pair) DelimitedRangesSequence.access$getGetNextMatch$p(this.this$0).invoke(DelimitedRangesSequence.access$getInput$p(this.this$0), Integer.valueOf(this.nextSearchIndex));
            if (r14 != null) goto L17;
            r13 = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
            goto L12
        L17:
            int r15 = ((Number) r14.component1()).intValue();
            int r16 = ((Number) r14.component2()).intValue();
            this.nextItem = RangesKt.until(this.currentStartIndex, r15);
            int r17 = r15 + r16;
            this.currentStartIndex = r17;
            if (r16 != 0) goto L20;
            r10 = 1;
        L20:
            r11 = r17 + r10;
            goto L13
        }

        public final int getCounter() {
            return this.counter;
        }

        public final int getCurrentStartIndex() {
            return this.currentStartIndex;
        }

        public final IntRange getNextItem() {
            return this.nextItem;
        }

        public final int getNextSearchIndex() {
            return this.nextSearchIndex;
        }

        public final int getNextState() {
            return this.nextState;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState != (-1)) goto L6;
            calcNext();
        L6:
            if (this.nextState == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ IntRange next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public IntRange next2() {
            if (this.nextState != (-1)) goto L6;
            calcNext();
        L6:
            if (this.nextState == 0) goto L10;
            IntRange r10 = this.nextItem;
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return r10;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setCounter(int r10) {
            this.counter = r10;
        }

        public final void setCurrentStartIndex(int r10) {
            this.currentStartIndex = r10;
        }

        public final void setNextItem(IntRange r10) {
            this.nextItem = r10;
        }

        public final void setNextSearchIndex(int r10) {
            this.nextSearchIndex = r10;
        }

        public final void setNextState(int r10) {
            this.nextState = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence r10, int r11, int r12, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> r13) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r13, "getNextMatch");
        this.input = r10;
        this.startIndex = r11;
        this.limit = r12;
        this.getNextMatch = r13;
    }

    public static final /* synthetic */ Function2 access$getGetNextMatch$p(DelimitedRangesSequence r10) {
        return r10.getNextMatch;
    }

    public static final /* synthetic */ CharSequence access$getInput$p(DelimitedRangesSequence r10) {
        return r10.input;
    }

    public static final /* synthetic */ int access$getLimit$p(DelimitedRangesSequence r10) {
        return r10.limit;
    }

    public static final /* synthetic */ int access$getStartIndex$p(DelimitedRangesSequence r10) {
        return r10.startIndex;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new AnonymousClass1(this);
    }
}
