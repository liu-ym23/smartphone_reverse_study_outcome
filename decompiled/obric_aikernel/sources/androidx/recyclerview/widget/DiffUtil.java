package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = null;

    public static abstract class Callback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(int r10, int r11);

        public abstract boolean areItemsTheSame(int r10, int r11);

        @Nullable
        public Object getChangePayload(int r10, int r11) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback r10, List<Snake> r11, int[] r12, int[] r13, boolean r14) {
            this.mSnakes = r11;
            this.mOldItemStatuses = r12;
            this.mNewItemStatuses = r13;
            Arrays.fill(r12, 0);
            Arrays.fill(r13, 0);
            this.mCallback = r10;
            this.mOldListSize = r10.getOldListSize();
            this.mNewListSize = r10.getNewListSize();
            this.mDetectMoves = r14;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            if (this.mSnakes.isEmpty() == false) goto L5;
            Snake r10 = null;
        L6:
            if (r10 != null) goto L8;
        L11:
            Snake r11 = new Snake();
            r11.f405x = 0;
            r11.f406y = 0;
            r11.removal = false;
            r11.size = 0;
            r11.reverse = false;
            this.mSnakes.add(0, r11);
            return;
        L8:
            if (r10.f405x != 0) goto L11;
            if (r10.f406y != 0) goto L11;
            return;
        L5:
            r10 = this.mSnakes.get(0);
            goto L6
        }

        private void dispatchAdditions(List<PostponedUpdate> r10, ListUpdateCallback r11, int r12, int r13, int r14) {
            if (this.mDetectMoves == true) goto L6;
            r11.onInserted(r12, r13);
            return;
        L6:
            int r15 = r13 - 1;
        L7:
            if (r15 < 0) goto L27;
            int[] r16 = this.mNewItemStatuses;
            int r17 = r14 + r15;
            int r18 = r16[r17] & 31;
            if (r18 != 0) goto L11;
            r11.onInserted(r12, 1);
            Iterator<PostponedUpdate> r19 = r10.iterator();
        L24:
            if (r19.hasNext() == false) goto L26;
            r19.next().currentPos++;
        L26:
            r15 = r15 - 1;
            goto L7
        L11:
            if (r18 != 4) goto L13;
        L19:
            int r20 = r16[r17] >> 5;
            r11.onMoved(removePostponedUpdate(r10, r20, true).currentPos, r12);
            if (r18 != 4) goto L26;
            r11.onChanged(r12, 1, this.mCallback.getChangePayload(r20, r17));
            goto L26
        L13:
            if (r18 == 8) goto L19;
            if (r18 != 16) goto L18;
            r10.add(new PostponedUpdate(r17, r12, false));
            goto L26
        L18:
            throw new IllegalStateException("unknown flag for pos " + r17 + " " + Long.toBinaryString(r18));
        }

        private void dispatchRemovals(List<PostponedUpdate> r10, ListUpdateCallback r11, int r12, int r13, int r14) {
            if (this.mDetectMoves == true) goto L6;
            r11.onRemoved(r12, r13);
            return;
        L6:
            int r15 = r13 - 1;
        L7:
            if (r15 < 0) goto L27;
            int[] r16 = this.mOldItemStatuses;
            int r17 = r14 + r15;
            int r18 = r16[r17] & 31;
            if (r18 != 0) goto L11;
            r11.onRemoved(r12 + r15, 1);
            Iterator<PostponedUpdate> r19 = r10.iterator();
        L24:
            if (r19.hasNext() == false) goto L26;
            r19.next().currentPos--;
        L26:
            r15 = r15 - 1;
            goto L7
        L11:
            if (r18 != 4) goto L13;
        L19:
            int r20 = r16[r17] >> 5;
            PostponedUpdate r21 = removePostponedUpdate(r10, r20, false);
            r11.onMoved(r12 + r15, r21.currentPos - 1);
            if (r18 != 4) goto L26;
            r11.onChanged(r21.currentPos - 1, 1, this.mCallback.getChangePayload(r17, r20));
            goto L26
        L13:
            if (r18 == 8) goto L19;
            if (r18 != 16) goto L18;
            r10.add(new PostponedUpdate(r17, r12 + r15, true));
            goto L26
        L18:
            throw new IllegalStateException("unknown flag for pos " + r17 + " " + Long.toBinaryString(r18));
        }

        private void findAddition(int r10, int r11, int r12) {
            if (this.mOldItemStatuses[r10 - 1] == 0) goto L5;
            return;
        L5:
            findMatchingItem(r10, r11, r12, false);
        }

        private boolean findMatchingItem(int r10, int r11, int r12, boolean r13) {
            if (r13 == false) goto L4;
            r11 = r11 - 1;
            int r14 = r10;
            int r15 = r11;
        L5:
            if (r12 < 0) goto L31;
            Snake r16 = this.mSnakes.get(r12);
            int r17 = r16.f405x;
            int r18 = r16.size;
            int r19 = r17 + r18;
            int r20 = r16.f406y + r18;
            int r21 = 8;
            if (r13 == false) goto L19;
            int r22 = r14 - 1;
        L9:
            if (r22 < r19) goto L30;
            if (this.mCallback.areItemsTheSame(r22, r15) == true) goto L13;
            r22 = r22 - 1;
            goto L9
        L13:
            if (this.mCallback.areContentsTheSame(r22, r15) == true) goto L16;
            r21 = 4;
        L16:
            this.mNewItemStatuses[r15] = (r22 << 5) | 16;
            this.mOldItemStatuses[r22] = (r15 << 5) | r21;
            return true;
        L30:
            r14 = r16.f405x;
            r11 = r16.f406y;
            r12 = r12 - 1;
            goto L5
        L19:
            int r110 = r11 - 1;
        L20:
            if (r110 < r20) goto L30;
            if (this.mCallback.areItemsTheSame(r15, r110) == true) goto L24;
            r110 = r110 - 1;
            goto L20
        L24:
            if (this.mCallback.areContentsTheSame(r15, r110) == true) goto L27;
            r21 = 4;
        L27:
            int r23 = r10 - 1;
            this.mOldItemStatuses[r23] = (r110 << 5) | 16;
            this.mNewItemStatuses[r110] = (r23 << 5) | r21;
            return true;
        L31:
            return false;
        L4:
            r15 = r10 - 1;
            r14 = r15;
            goto L5
        }

        private void findMatchingItems() {
            int r10 = this.mOldListSize;
            int r11 = this.mNewListSize;
            int r12 = this.mSnakes.size() - 1;
        L3:
            if (r12 < 0) goto L19;
            Snake r13 = this.mSnakes.get(r12);
            int r14 = r13.f405x;
            int r15 = r13.size;
            int r16 = r14 + r15;
            int r17 = r13.f406y + r15;
            if (this.mDetectMoves == false) goto L10;
        L6:
            if (r10 <= r16) goto L8;
            findAddition(r10, r11, r12);
            r10 = r10 - 1;
        L8:
            if (r11 <= r17) goto L10;
            findRemoval(r10, r11, r12);
            r11 = r11 - 1;
        L10:
            int r18 = 0;
        L12:
            if (r18 >= r13.size) goto L18;
            int r19 = r13.f405x + r18;
            int r20 = r13.f406y + r18;
            if (this.mCallback.areContentsTheSame(r19, r20) == false) goto L16;
            int r21 = 1;
        L17:
            this.mOldItemStatuses[r19] = (r20 << 5) | r21;
            this.mNewItemStatuses[r20] = (r19 << 5) | r21;
            r18 = r18 + 1;
            goto L12
        L16:
            r21 = 2;
            goto L17
        L18:
            r10 = r13.f405x;
            r11 = r13.f406y;
            r12 = r12 - 1;
            goto L3
        }

        private void findRemoval(int r10, int r11, int r12) {
            if (this.mNewItemStatuses[r11 - 1] == 0) goto L5;
            return;
        L5:
            findMatchingItem(r10, r11, r12, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> r10, int r11, boolean r12) {
            int r13 = r10.size() - 1;
        L3:
            if (r13 < 0) goto L18;
            PostponedUpdate r14 = r10.get(r13);
            if (r14.posInOwnerList != r11) goto L17;
            if (r14.removal != r12) goto L17;
            r10.remove(r13);
        L10:
            if (r13 >= r10.size()) goto L16;
            PostponedUpdate r15 = r10.get(r13);
            int r16 = r15.currentPos;
            if (r12 == false) goto L14;
            int r17 = 1;
        L15:
            r15.currentPos = r16 + r17;
            r13 = r13 + 1;
            goto L10
        L14:
            r17 = -1;
            goto L15
        L16:
            return r14;
        L17:
            r13 = r13 - 1;
            goto L3
        L18:
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int r10) {
            if (r10 < 0) goto L12;
            if (r10 >= this.mNewListSize) goto L12;
            int r11 = this.mNewItemStatuses[r10];
            if ((r11 & 31) != 0) goto L10;
            return -1;
        L10:
            return r11 >> 5;
        L12:
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + r10 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int r10) {
            if (r10 < 0) goto L12;
            if (r10 >= this.mOldListSize) goto L12;
            int r11 = this.mOldItemStatuses[r10];
            if ((r11 & 31) != 0) goto L10;
            return -1;
        L10:
            return r11 >> 5;
        L12:
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + r10 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback r15) {
            if ((r15 instanceof BatchingListUpdateCallback) == false) goto L5;
            BatchingListUpdateCallback r16 = (BatchingListUpdateCallback) r15;
        L6:
            List<PostponedUpdate> r10 = new ArrayList();
            int r11 = this.mOldListSize;
            int r12 = this.mNewListSize;
            int r13 = this.mSnakes.size() - 1;
        L7:
            if (r13 < 0) goto L20;
            Snake r14 = this.mSnakes.get(r13);
            int r17 = r14.size;
            int r18 = r14.f405x + r17;
            int r19 = r14.f406y + r17;
            if (r18 >= r11) goto L11;
            dispatchRemovals(r10, r16, r18, r11 - r18, r18);
        L11:
            if (r19 >= r12) goto L13;
            dispatchAdditions(r10, r16, r18, r12 - r19, r19);
        L13:
            int r110 = r17 - 1;
        L14:
            if (r110 < 0) goto L19;
            int[] r20 = this.mOldItemStatuses;
            int r21 = r14.f405x;
            if ((r20[r21 + r110] & 31) != 2) goto L18;
            r16.onChanged(r21 + r110, 1, this.mCallback.getChangePayload(r21 + r110, r14.f406y + r110));
        L18:
            r110 = r110 - 1;
            goto L14
        L19:
            r11 = r14.f405x;
            r12 = r14.f406y;
            r13 = r13 - 1;
            goto L7
        L20:
            r16.dispatchLastEvent();
            return;
        L5:
            r16 = new BatchingListUpdateCallback(r15);
            goto L6
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter r10) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(r10));
        }

        @VisibleForTesting
        List<Snake> getSnakes() {
            return this.mSnakes;
        }
    }

    public static abstract class ItemCallback<T> {
        public ItemCallback() {
        }

        public abstract boolean areContentsTheSame(@NonNull T r10, @NonNull T r11);

        public abstract boolean areItemsTheSame(@NonNull T r10, @NonNull T r11);

        @Nullable
        public Object getChangePayload(@NonNull T r10, @NonNull T r11) {
            return null;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int r10, int r11, boolean r12) {
            this.posInOwnerList = r10;
            this.currentPos = r11;
            this.removal = r12;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int r10, int r11, int r12, int r13) {
            this.oldListStart = r10;
            this.oldListEnd = r11;
            this.newListStart = r12;
            this.newListEnd = r13;
        }
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f405x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f406y;

        Snake() {
        }
    }

    static {
        SNAKE_COMPARATOR = new AnonymousClass1();
    }

    private DiffUtil() {
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback r10) {
        return calculateDiff(r10, true);
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback r15, boolean r16) {
        int r10 = r15.getOldListSize();
        int r11 = r15.getNewListSize();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        r13.add(new Range(0, r10, 0, r11));
        int r14 = (r10 + r11) + Math.abs(r10 - r11);
        int r17 = r14 * 2;
        int[] r18 = new int[r17];
        int[] r19 = new int[r17];
        ArrayList r110 = new ArrayList();
    L4:
        if (r13.isEmpty() == true) goto L33;
        Range r111 = (Range) r13.remove(r13.size() - 1);
        Snake r20 = diffPartial(r15, r111.oldListStart, r111.oldListEnd, r111.newListStart, r111.newListEnd, r18, r19, r14);
        if (r20 != null) goto L8;
        r110.add(r111);
        goto L4
    L8:
        if (r20.size <= 0) goto L10;
        r12.add(r20);
    L10:
        r20.f405x += r111.oldListStart;
        r20.f406y += r111.newListStart;
        if (r110.isEmpty() == false) goto L13;
        Range r21 = new Range();
    L14:
        r21.oldListStart = r111.oldListStart;
        r21.newListStart = r111.newListStart;
        if (r20.reverse == false) goto L20;
        int r22 = r20.f405x;
    L17:
        r21.oldListEnd = r22;
        int r23 = r20.f406y;
    L18:
        r21.newListEnd = r23;
        r13.add(r21);
        if (r20.reverse == true) goto L26;
        int r24 = r20.f405x;
        int r25 = r20.size;
        int r26 = r24 + r25;
    L30:
        r111.oldListStart = r26;
        int r27 = r20.f406y + r25;
    L31:
        r111.newListStart = r27;
        r13.add(r111);
        goto L4
    L26:
        if (r20.removal == false) goto L28;
        int r28 = r20.f405x;
        r25 = r20.size;
        r26 = (r28 + r25) + 1;
        goto L30
    L28:
        int r29 = r20.f405x;
        int r30 = r20.size;
        r111.oldListStart = r29 + r30;
        r27 = (r20.f406y + r30) + 1;
        goto L31
    L20:
        if (r20.removal == false) goto L22;
        r22 = r20.f405x - 1;
        goto L17
    L22:
        r21.oldListEnd = r20.f405x;
        r23 = r20.f406y - 1;
        goto L18
    L13:
        r21 = (Range) r110.remove(r110.size() - 1);
        goto L14
    L33:
        Collections.sort(r12, SNAKE_COMPARATOR);
        return new DiffResult(r15, r12, r18, r19, r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Snake diffPartial(Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        int r10 = r21 - r20;
        int r11 = r23 - r22;
        int r12 = 1;
        if (r10 < 1) goto L70;
        if (r11 < 1) goto L91;
        int r13 = r10 - r11;
        int r14 = ((r10 + r11) + 1) / 2;
        int r15 = (r26 - r14) - 1;
        int r16 = (r26 + r14) + 1;
        boolean r17 = false;
        Arrays.fill(r24, r15, r16, 0);
        Arrays.fill(r25, r15 + r13, r16 + r13, r10);
        if ((r13 % 2) == 0) goto L9;
        boolean r18 = true;
    L10:
        int r27 = 0;
    L11:
        if (r27 > r14) goto L69;
        int r110 = -r27;
        int r111 = r110;
    L13:
        if (r111 > r27) goto L38;
        if (r111 == r110) goto L20;
        if (r111 == r27) goto L19;
        int r112 = r26 + r111;
        if (r24[r112 - 1] < r24[r112 + r12]) goto L20;
    L19:
        int r113 = r24[(r26 + r111) - r12] + r12;
        boolean r114 = r12;
    L21:
        int r115 = r113 - r111;
    L22:
        if (r113 >= r10) goto L27;
        if (r115 >= r11) goto L27;
        if (r19.areItemsTheSame(r20 + r113, r22 + r115) == false) goto L27;
        r113 = r113 + 1;
        r115 = r115 + 1;
    L27:
        int r28 = r26 + r111;
        r24[r28] = r113;
        if (r18 == false) goto L37;
        if (r111 < ((r13 - r27) + 1)) goto L37;
        if (r111 > ((r13 + r27) - 1)) goto L37;
        if (r24[r28] < r25[r28]) goto L37;
        Snake r29 = new Snake();
        int r30 = r25[r28];
        r29.f405x = r30;
        r29.f406y = r30 - r111;
        r29.size = r24[r28] - r25[r28];
        r29.removal = r114;
        r29.reverse = false;
        return r29;
    L37:
        r111 = r111 + 2;
        r17 = false;
        r12 = 1;
    L20:
        r113 = r24[(r26 + r111) + r12];
        r114 = r17;
        goto L21
    L38:
        boolean r116 = r17;
        int r31 = r110;
    L39:
        if (r31 > r27) goto L67;
        int r117 = r31 + r13;
        if (r117 != (r27 + r13)) goto L43;
        int r118 = 1;
    L50:
        int r119 = r25[(r26 + r117) - r118];
        boolean r120 = r116;
    L51:
        int r121 = r119 - r117;
    L52:
        if (r119 <= 0) goto L57;
        if (r121 <= 0) goto L57;
        int r122 = r10;
        if (r19.areItemsTheSame((r20 + r119) - 1, (r22 + r121) - 1) == false) goto L58;
        r119 = r119 - 1;
        r121 = r121 - 1;
        r10 = r122;
    L58:
        int r32 = r26 + r117;
        r25[r32] = r119;
        if (r18 == true) goto L66;
        if (r117 < r110) goto L66;
        if (r117 > r27) goto L66;
        if (r24[r32] < r25[r32]) goto L66;
        Snake r33 = new Snake();
        int r34 = r25[r32];
        r33.f405x = r34;
        r33.f406y = r34 - r117;
        r33.size = r24[r32] - r25[r32];
        r33.removal = r120;
        r33.reverse = true;
        return r33;
    L66:
        r31 = r31 + 2;
        r10 = r122;
        r116 = false;
    L57:
        r122 = r10;
        goto L58
    L43:
        if (r117 == (r110 + r13)) goto L47;
        int r123 = r26 + r117;
        r118 = 1;
        if (r25[r123 - 1] < r25[r123 + 1]) goto L50;
    L48:
        r119 = r25[(r26 + r117) + r118] - r118;
        r120 = r118;
        goto L51
    L47:
        r118 = 1;
        goto L48
    L67:
        r27 = r27 + 1;
        r12 = 1;
        r10 = r10;
        r17 = false;
        goto L11
    L69:
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    L9:
        r18 = false;
        goto L10
    L91:
        return null;
    L70:
        return null;
    }
}
