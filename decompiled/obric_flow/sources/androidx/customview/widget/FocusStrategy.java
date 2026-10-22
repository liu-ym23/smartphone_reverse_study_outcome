package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class FocusStrategy {

    public interface BoundsAdapter<T> {
        void obtainBounds(T r5, Rect r10);
    }

    public interface CollectionAdapter<T, V> {
        V get(T r5, int r10);

        int size(T r5);
    }

    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1;
        private final Rect mTemp2;

        public SequentialComparator(boolean r5, BoundsAdapter<T> r10) {
            this.mTemp1 = new Rect();
            this.mTemp2 = new Rect();
            this.mIsLayoutRtl = r5;
            this.mAdapter = r10;
        }

        @Override // java.util.Comparator
        public int compare(T r5, T r10) {
            Rect r11 = this.mTemp1;
            Rect r12 = this.mTemp2;
            this.mAdapter.obtainBounds(r5, r11);
            this.mAdapter.obtainBounds(r10, r12);
            int r13 = r11.top;
            int r14 = r12.top;
            if (r13 >= r14) goto L6;
            return -1;
        L6:
            if (r13 <= r14) goto L8;
            return 1;
        L8:
            int r15 = r11.left;
            int r16 = r12.left;
            if (r15 < r16) goto L11;
            if (r15 > r16) goto L16;
            int r17 = r11.bottom;
            int r18 = r12.bottom;
            if (r17 >= r18) goto L23;
            return -1;
        L23:
            if (r17 <= r18) goto L25;
            return 1;
        L25:
            int r19 = r11.right;
            int r20 = r12.right;
            if (r19 < r20) goto L28;
            if (r19 > r20) goto L33;
            return 0;
        L33:
            if (this.mIsLayoutRtl == false) goto L36;
            return -1;
        L36:
            return 1;
        L28:
            if (this.mIsLayoutRtl == true) goto L30;
            return -1;
        L30:
            return 1;
        L16:
            if (this.mIsLayoutRtl == false) goto L19;
            return -1;
        L19:
            return 1;
        L11:
            if (this.mIsLayoutRtl == true) goto L13;
            return -1;
        L13:
            return 1;
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int r5, @NonNull Rect r10, @NonNull Rect r11, @NonNull Rect r12) {
        boolean r13 = beamsOverlap(r5, r10, r11);
        if (beamsOverlap(r5, r10, r12) == true) goto L19;
        if (r13 == false) goto L19;
        if (isToDirectionOf(r5, r10, r12) == true) goto L10;
        return true;
    L10:
        if (r5 != 17) goto L12;
    L18:
        return true;
    L12:
        if (r5 == 66) goto L18;
        if (majorAxisDistance(r5, r10, r11) < majorAxisDistanceToFarEdge(r5, r10, r12)) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    private static boolean beamsOverlap(int r5, @NonNull Rect r10, @NonNull Rect r11) {
        if (r5 == 17) goto L20;
        if (r5 == 33) goto L14;
        if (r5 == 66) goto L20;
        if (r5 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        if (r11.right >= r10.left) goto L16;
        return false;
    L16:
        if (r11.left <= r10.right) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (r11.bottom >= r10.top) goto L22;
        return false;
    L22:
        if (r11.top <= r10.bottom) goto L24;
        return false;
    L24:
        return true;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L r10, @NonNull CollectionAdapter<L, T> r11, @NonNull BoundsAdapter<T> r12, @Nullable T r13, @NonNull Rect r14, int r15) {
        Rect r5 = new Rect(r14);
        int r16 = 0;
        if (r15 != 17) goto L5;
        r5.offset(r14.width() + 1, 0);
    L16:
        int r17 = r11.size(r10);
        Rect r18 = new Rect();
        T r19 = null;
    L17:
        if (r16 >= r17) goto L25;
        T r20 = r11.get(r10, r16);
        if (r20 == r13) goto L24;
        r12.obtainBounds(r20, r18);
        if (isBetterCandidate(r15, r14, r18, r5) == false) goto L24;
        r5.set(r18);
        r19 = r20;
    L24:
        r16 = r16 + 1;
        goto L17
    L25:
        return r19;
    L5:
        if (r15 != 33) goto L7;
        r5.offset(0, r14.height() + 1);
        goto L16
    L7:
        if (r15 != 66) goto L9;
        r5.offset(-(r14.width() + 1), 0);
        goto L16
    L9:
        if (r15 != 130) goto L12;
        r5.offset(0, -(r14.height() + 1));
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L r5, @NonNull CollectionAdapter<L, T> r10, @NonNull BoundsAdapter<T> r11, @Nullable T r12, int r13, boolean r14, boolean r15) {
        int r16 = r10.size(r5);
        ArrayList r17 = new ArrayList(r16);
        int r18 = 0;
    L3:
        if (r18 >= r16) goto L5;
        r17.add(r10.get(r5, r18));
        r18 = r18 + 1;
        goto L3
    L5:
        Collections.sort(r17, new SequentialComparator(r14, r11));
        if (r13 == 1) goto L14;
        if (r13 != 2) goto L12;
        return (T) getNextFocusable(r12, r17, r15);
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    L14:
        return (T) getPreviousFocusable(r12, r17, r15);
    }

    private static <T> T getNextFocusable(T r5, ArrayList<T> r10, boolean r11) {
        int r12 = r10.size();
        if (r5 != null) goto L5;
        int r13 = -1;
    L6:
        int r14 = r13 + 1;
        if (r14 < r12) goto L9;
        if (r11 == false) goto L14;
        if (r12 > 0) goto L13;
        return null;
    L13:
        return r10.get(0);
    L14:
        return null;
    L9:
        return r10.get(r14);
    L5:
        r13 = r10.lastIndexOf(r5);
        goto L6
    }

    private static <T> T getPreviousFocusable(T r5, ArrayList<T> r10, boolean r11) {
        int r12 = r10.size();
        if (r5 != null) goto L5;
        int r13 = r12;
    L6:
        int r14 = r13 - 1;
        if (r14 >= 0) goto L9;
        if (r11 == false) goto L14;
        if (r12 > 0) goto L13;
        return null;
    L13:
        return r10.get(r12 - 1);
    L14:
        return null;
    L9:
        return r10.get(r14);
    L5:
        r13 = r10.indexOf(r5);
        goto L6
    }

    private static int getWeightedDistanceFor(int r5, int r10) {
        int r11 = r10 * r10;
        return r11 + ((r5 * 13) * r5);
    }

    private static boolean isBetterCandidate(int r5, @NonNull Rect r10, @NonNull Rect r11, @NonNull Rect r12) {
        if (isCandidate(r10, r11, r5) == true) goto L6;
        return false;
    L6:
        if (isCandidate(r10, r12, r5) == true) goto L9;
        return true;
    L9:
        if (beamBeats(r5, r10, r11, r12) == false) goto L12;
        return true;
    L12:
        if (beamBeats(r5, r10, r12, r11) == false) goto L15;
        return false;
    L15:
        if (getWeightedDistanceFor(majorAxisDistance(r5, r10, r11), minorAxisDistance(r5, r10, r11)) < getWeightedDistanceFor(majorAxisDistance(r5, r10, r12), minorAxisDistance(r5, r10, r12))) goto L17;
        return false;
    L17:
        return true;
    }

    private static boolean isCandidate(@NonNull Rect r5, @NonNull Rect r10, int r11) {
        if (r11 != 17) goto L5;
        int r12 = r5.right;
        int r13 = r10.right;
        if (r12 > r13) goto L41;
        if (r5.left >= r13) goto L41;
        return false;
    L41:
        if (r5.left > r10.left) goto L43;
        return false;
    L43:
        return true;
    L5:
        if (r11 != 33) goto L7;
        int r14 = r5.bottom;
        int r15 = r10.bottom;
        if (r14 > r15) goto L33;
        if (r5.top >= r15) goto L33;
        return false;
    L33:
        if (r5.top > r10.top) goto L35;
        return false;
    L35:
        return true;
    L7:
        if (r11 != 66) goto L9;
        int r16 = r5.left;
        int r17 = r10.left;
        if (r16 < r17) goto L25;
        if (r5.right <= r17) goto L25;
        return false;
    L25:
        if (r5.right < r10.right) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r11 != 130) goto L19;
        int r18 = r5.top;
        int r19 = r10.top;
        if (r18 < r19) goto L15;
        if (r5.bottom <= r19) goto L15;
        return false;
    L15:
        if (r5.bottom < r10.bottom) goto L17;
        return false;
    L17:
        return true;
    L19:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean isToDirectionOf(int r5, @NonNull Rect r10, @NonNull Rect r11) {
        if (r5 == 17) goto L25;
        if (r5 == 33) goto L21;
        if (r5 == 66) goto L17;
        if (r5 != 130) goto L15;
        if (r10.bottom <= r11.top) goto L13;
        return false;
    L13:
        return true;
    L15:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L17:
        if (r10.right <= r11.left) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (r10.top >= r11.bottom) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (r10.left >= r11.right) goto L27;
        return false;
    L27:
        return true;
    }

    private static int majorAxisDistance(int r5, @NonNull Rect r10, @NonNull Rect r11) {
        return Math.max(0, majorAxisDistanceRaw(r5, r10, r11));
    }

    private static int majorAxisDistanceRaw(int r5, @NonNull Rect r10, @NonNull Rect r11) {
        if (r5 != 17) goto L5;
        int r12 = r10.left;
        int r13 = r11.right;
    L12:
        return r12 - r13;
    L5:
        if (r5 != 33) goto L7;
        r12 = r10.top;
        r13 = r11.bottom;
        goto L12
    L7:
        if (r5 != 66) goto L9;
        r12 = r11.left;
        r13 = r10.right;
        goto L12
    L9:
        if (r5 != 130) goto L14;
        r12 = r11.top;
        r13 = r10.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int majorAxisDistanceToFarEdge(int r5, @NonNull Rect r10, @NonNull Rect r11) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(r5, r10, r11));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int r5, @NonNull Rect r10, @NonNull Rect r11) {
        if (r5 != 17) goto L5;
        int r12 = r10.left;
        int r13 = r11.left;
    L12:
        return r12 - r13;
    L5:
        if (r5 != 33) goto L7;
        r12 = r10.top;
        r13 = r11.top;
        goto L12
    L7:
        if (r5 != 66) goto L9;
        r12 = r11.right;
        r13 = r10.right;
        goto L12
    L9:
        if (r5 != 130) goto L14;
        r12 = r11.bottom;
        r13 = r10.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int minorAxisDistance(int r5, @NonNull Rect r10, @NonNull Rect r11) {
        if (r5 != 17) goto L5;
    L15:
        int r12 = r10.top;
        int r13 = (r10.height() / 2) + r12;
        int r14 = r11.top;
        return Math.abs(r13 - ((r11.height() / 2) + r14));
    L5:
        if (r5 != 33) goto L7;
    L13:
        int r15 = r10.left;
        int r16 = (r10.width() / 2) + r15;
        int r17 = r11.left;
        return Math.abs(r16 - ((r11.width() / 2) + r17));
    L7:
        if (r5 == 66) goto L15;
        if (r5 == 130) goto L13;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
}
