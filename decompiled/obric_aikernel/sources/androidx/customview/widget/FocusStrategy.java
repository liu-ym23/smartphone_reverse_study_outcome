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
        void obtainBounds(T r10, Rect r11);
    }

    public interface CollectionAdapter<T, V> {
        V get(T r10, int r11);

        int size(T r10);
    }

    private static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1;
        private final Rect mTemp2;

        SequentialComparator(boolean r10, BoundsAdapter<T> r11) {
            this.mTemp1 = new Rect();
            this.mTemp2 = new Rect();
            this.mIsLayoutRtl = r10;
            this.mAdapter = r11;
        }

        @Override // java.util.Comparator
        public int compare(T r10, T r11) {
            Rect r12 = this.mTemp1;
            Rect r13 = this.mTemp2;
            this.mAdapter.obtainBounds(r10, r12);
            this.mAdapter.obtainBounds(r11, r13);
            int r14 = r12.top;
            int r15 = r13.top;
            if (r14 >= r15) goto L6;
            return -1;
        L6:
            if (r14 <= r15) goto L8;
            return 1;
        L8:
            int r16 = r12.left;
            int r17 = r13.left;
            if (r16 < r17) goto L11;
            if (r16 > r17) goto L16;
            int r18 = r12.bottom;
            int r19 = r13.bottom;
            if (r18 >= r19) goto L23;
            return -1;
        L23:
            if (r18 <= r19) goto L25;
            return 1;
        L25:
            int r20 = r12.right;
            int r21 = r13.right;
            if (r20 < r21) goto L28;
            if (r20 > r21) goto L33;
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

    private static boolean beamBeats(int r10, @NonNull Rect r11, @NonNull Rect r12, @NonNull Rect r13) {
        boolean r14 = beamsOverlap(r10, r11, r12);
        if (beamsOverlap(r10, r11, r13) == true) goto L19;
        if (r14 == false) goto L19;
        if (isToDirectionOf(r10, r11, r13) == true) goto L10;
        return true;
    L10:
        if (r10 != 17) goto L12;
    L18:
        return true;
    L12:
        if (r10 == 66) goto L18;
        if (majorAxisDistance(r10, r11, r12) < majorAxisDistanceToFarEdge(r10, r11, r13)) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    private static boolean beamsOverlap(int r10, @NonNull Rect r11, @NonNull Rect r12) {
        if (r10 == 17) goto L21;
        if (r10 == 33) goto L14;
        if (r10 == 66) goto L21;
        if (r10 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        if (r12.right < r11.left) goto L19;
        if (r12.left > r11.right) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (r12.bottom < r11.top) goto L26;
        if (r12.top > r11.bottom) goto L26;
        return true;
    L26:
        return false;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L r10, @NonNull CollectionAdapter<L, T> r11, @NonNull BoundsAdapter<T> r12, @Nullable T r13, @NonNull Rect r14, int r15) {
        Rect r16 = new Rect(r14);
        int r17 = 0;
        if (r15 != 17) goto L5;
        int r18 = r14.width() + 1;
    L17:
        r16.offset(r18, 0);
    L18:
        T r19 = null;
        int r20 = r11.size(r10);
        Rect r21 = new Rect();
    L19:
        if (r17 >= r20) goto L27;
        T r22 = r11.get(r10, r17);
        if (r22 == r13) goto L26;
        r12.obtainBounds(r22, r21);
        if (isBetterCandidate(r15, r14, r21, r16) == false) goto L26;
        r16.set(r21);
        r19 = r22;
    L26:
        r17 = r17 + 1;
        goto L19
    L27:
        return r19;
    L5:
        if (r15 != 33) goto L7;
        int r23 = r14.height() + 1;
    L15:
        r16.offset(0, r23);
        goto L18
    L7:
        if (r15 != 66) goto L9;
        r18 = -(r14.width() + 1);
        goto L17
    L9:
        if (r15 != 130) goto L12;
        r23 = -(r14.height() + 1);
        goto L15
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L r10, @NonNull CollectionAdapter<L, T> r11, @NonNull BoundsAdapter<T> r12, @Nullable T r13, int r14, boolean r15, boolean r16) {
        int r17 = r11.size(r10);
        ArrayList r18 = new ArrayList(r17);
        int r19 = 0;
    L3:
        if (r19 >= r17) goto L5;
        r18.add(r11.get(r10, r19));
        r19 = r19 + 1;
        goto L3
    L5:
        Collections.sort(r18, new SequentialComparator(r15, r12));
        if (r14 == 1) goto L14;
        if (r14 != 2) goto L12;
        return (T) getNextFocusable(r13, r18, r16);
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    L14:
        return (T) getPreviousFocusable(r13, r18, r16);
    }

    private static <T> T getNextFocusable(T r10, ArrayList<T> r11, boolean r12) {
        int r13 = r11.size();
        if (r10 != null) goto L5;
        int r14 = -1;
    L6:
        int r15 = r14 + 1;
        if (r15 < r13) goto L9;
        if (r12 == false) goto L14;
        if (r13 > 0) goto L13;
        return null;
    L13:
        return r11.get(0);
    L14:
        return null;
    L9:
        return r11.get(r15);
    L5:
        r14 = r11.lastIndexOf(r10);
        goto L6
    }

    private static <T> T getPreviousFocusable(T r10, ArrayList<T> r11, boolean r12) {
        int r13 = r11.size();
        if (r10 != null) goto L5;
        int r14 = r13;
    L6:
        int r15 = r14 - 1;
        if (r15 >= 0) goto L9;
        if (r12 == false) goto L14;
        if (r13 > 0) goto L13;
        return null;
    L13:
        return r11.get(r13 - 1);
    L14:
        return null;
    L9:
        return r11.get(r15);
    L5:
        r14 = r11.indexOf(r10);
        goto L6
    }

    private static int getWeightedDistanceFor(int r10, int r11) {
        return ((r10 * 13) * r10) + (r11 * r11);
    }

    private static boolean isBetterCandidate(int r10, @NonNull Rect r11, @NonNull Rect r12, @NonNull Rect r13) {
        if (isCandidate(r11, r12, r10) == true) goto L6;
        return false;
    L6:
        if (isCandidate(r11, r13, r10) == true) goto L9;
        return true;
    L9:
        if (beamBeats(r10, r11, r12, r13) == false) goto L12;
        return true;
    L12:
        if (beamBeats(r10, r11, r13, r12) == false) goto L15;
        return false;
    L15:
        if (getWeightedDistanceFor(majorAxisDistance(r10, r11, r12), minorAxisDistance(r10, r11, r12)) < getWeightedDistanceFor(majorAxisDistance(r10, r11, r13), minorAxisDistance(r10, r11, r13))) goto L17;
        return false;
    L17:
        return true;
    }

    private static boolean isCandidate(@NonNull Rect r10, @NonNull Rect r11, int r12) {
        if (r12 != 17) goto L5;
        int r13 = r10.right;
        int r14 = r11.right;
        if (r13 > r14) goto L44;
        if (r10.left >= r14) goto L44;
    L47:
        return false;
    L44:
        if (r10.left <= r11.left) goto L47;
        return true;
    L5:
        if (r12 != 33) goto L7;
        int r15 = r10.bottom;
        int r16 = r11.bottom;
        if (r15 > r16) goto L35;
        if (r10.top >= r16) goto L35;
    L38:
        return false;
    L35:
        if (r10.top <= r11.top) goto L38;
        return true;
    L7:
        if (r12 != 66) goto L9;
        int r17 = r10.left;
        int r18 = r11.left;
        if (r17 < r18) goto L26;
        if (r10.right <= r18) goto L26;
    L29:
        return false;
    L26:
        if (r10.right >= r11.right) goto L29;
        return true;
    L9:
        if (r12 != 130) goto L20;
        int r19 = r10.top;
        int r20 = r11.top;
        if (r19 < r20) goto L15;
        if (r10.bottom <= r20) goto L15;
    L18:
        return false;
    L15:
        if (r10.bottom >= r11.bottom) goto L18;
        return true;
    L20:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean isToDirectionOf(int r10, @NonNull Rect r11, @NonNull Rect r12) {
        if (r10 == 17) goto L28;
        if (r10 == 33) goto L23;
        if (r10 == 66) goto L18;
        if (r10 != 130) goto L16;
        if (r11.bottom > r12.top) goto L14;
        return true;
    L14:
        return false;
    L16:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L18:
        if (r11.right > r12.left) goto L21;
        return true;
    L21:
        return false;
    L23:
        if (r11.top < r12.bottom) goto L26;
        return true;
    L26:
        return false;
    L28:
        if (r11.left < r12.right) goto L31;
        return true;
    L31:
        return false;
    }

    private static int majorAxisDistance(int r10, @NonNull Rect r11, @NonNull Rect r12) {
        return Math.max(0, majorAxisDistanceRaw(r10, r11, r12));
    }

    private static int majorAxisDistanceRaw(int r10, @NonNull Rect r11, @NonNull Rect r12) {
        if (r10 != 17) goto L5;
        int r13 = r11.left;
        int r14 = r12.right;
    L12:
        return r13 - r14;
    L5:
        if (r10 != 33) goto L7;
        r13 = r11.top;
        r14 = r12.bottom;
        goto L12
    L7:
        if (r10 != 66) goto L9;
        r13 = r12.left;
        r14 = r11.right;
        goto L12
    L9:
        if (r10 != 130) goto L14;
        r13 = r12.top;
        r14 = r11.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int majorAxisDistanceToFarEdge(int r10, @NonNull Rect r11, @NonNull Rect r12) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(r10, r11, r12));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int r10, @NonNull Rect r11, @NonNull Rect r12) {
        if (r10 != 17) goto L5;
        int r13 = r11.left;
        int r14 = r12.left;
    L12:
        return r13 - r14;
    L5:
        if (r10 != 33) goto L7;
        r13 = r11.top;
        r14 = r12.top;
        goto L12
    L7:
        if (r10 != 66) goto L9;
        r13 = r12.right;
        r14 = r11.right;
        goto L12
    L9:
        if (r10 != 130) goto L14;
        r13 = r12.bottom;
        r14 = r11.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int minorAxisDistance(int r10, @NonNull Rect r11, @NonNull Rect r12) {
        if (r10 != 17) goto L5;
    L16:
        int r13 = r11.top + (r11.height() / 2);
        int r14 = r12.top;
        int r15 = r12.height();
    L15:
        return Math.abs(r13 - (r14 + (r15 / 2)));
    L5:
        if (r10 != 33) goto L7;
    L13:
        r13 = r11.left + (r11.width() / 2);
        r14 = r12.left;
        r15 = r12.width();
        goto L15
    L7:
        if (r10 == 66) goto L16;
        if (r10 == 130) goto L13;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
}
