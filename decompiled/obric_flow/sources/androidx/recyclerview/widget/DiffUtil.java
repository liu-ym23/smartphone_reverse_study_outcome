package androidx.recyclerview.widget;

import ai.j0;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = null;

    public static abstract class Callback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(int r5, int r10);

        public abstract boolean areItemsTheSame(int r5, int r10);

        @Nullable
        public Object getChangePayload(int r5, int r10) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int r5) {
            int[] r10 = new int[r5];
            this.mData = r10;
            this.mMid = r10.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int r5) {
            Arrays.fill(this.mData, r5);
        }

        public int get(int r5) {
            return this.mData[r5 + this.mMid];
        }

        public void set(int r5, int r10) {
            this.mData[r5 + this.mMid] = r10;
        }
    }

    public static class Diagonal {
        public final int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f567x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f568y;

        public Diagonal(int r5, int r10, int r11) {
            this.f567x = r5;
            this.f568y = r10;
            this.size = r11;
        }

        public int endX() {
            return this.f567x + this.size;
        }

        public int endY() {
            return this.f568y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(Callback r5, List<Diagonal> r10, int[] r11, int[] r12, boolean r13) {
            this.mDiagonals = r10;
            this.mOldItemStatuses = r11;
            this.mNewItemStatuses = r12;
            Arrays.fill(r11, 0);
            Arrays.fill(r12, 0);
            this.mCallback = r5;
            this.mOldListSize = r5.getOldListSize();
            this.mNewListSize = r5.getNewListSize();
            this.mDetectMoves = r13;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            if (this.mDiagonals.isEmpty() == false) goto L5;
            Diagonal r5 = null;
        L6:
            if (r5 != null) goto L8;
        L11:
            this.mDiagonals.add(0, new Diagonal(0, 0, 0));
        L12:
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
            return;
        L8:
            if (r5.f567x != 0) goto L11;
            if (r5.f568y == 0) goto L12;
        L5:
            r5 = this.mDiagonals.get(0);
            goto L6
        }

        private void findMatchingAddition(int r10) {
            int r5 = this.mDiagonals.size();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r11 >= r5) goto L19;
            Diagonal r13 = this.mDiagonals.get(r11);
        L6:
            if (r12 >= r13.f568y) goto L18;
            if (this.mNewItemStatuses[r12] != 0) goto L17;
            if (this.mCallback.areItemsTheSame(r10, r12) == false) goto L17;
            if (this.mCallback.areContentsTheSame(r10, r12) == false) goto L14;
            int r14 = 8;
        L15:
            this.mOldItemStatuses[r10] = (r12 << 4) | r14;
            this.mNewItemStatuses[r12] = (r10 << 4) | r14;
            return;
        L14:
            r14 = 4;
        L17:
            r12 = r12 + 1;
            goto L6
        L18:
            r12 = r13.endY();
            r11 = r11 + 1;
            goto L3
        }

        private void findMatchingItems() {
            Iterator<Diagonal> r5 = this.mDiagonals.iterator();
        L4:
            if (r5.hasNext() == false) goto L14;
            Diagonal r10 = r5.next();
            int r11 = 0;
        L7:
            if (r11 >= r10.size) goto L4;
            int r12 = r10.f567x + r11;
            int r13 = r10.f568y + r11;
            if (this.mCallback.areContentsTheSame(r12, r13) == false) goto L11;
            int r14 = 1;
        L12:
            this.mOldItemStatuses[r12] = (r13 << 4) | r14;
            this.mNewItemStatuses[r13] = (r12 << 4) | r14;
            r11 = r11 + 1;
            goto L7
        L11:
            r14 = 2;
            goto L12
        L14:
            if (this.mDetectMoves == false) goto L21;
            findMoveMatches();
            return;
        }

        private void findMoveMatches() {
            Iterator<Diagonal> r5 = this.mDiagonals.iterator();
            int r10 = 0;
        L4:
            if (r5.hasNext() == false) goto L13;
            Diagonal r11 = r5.next();
        L7:
            if (r10 >= r11.f567x) goto L12;
            if (this.mOldItemStatuses[r10] != 0) goto L11;
            findMatchingAddition(r10);
        L11:
            r10 = r10 + 1;
            goto L7
        L12:
            r10 = r11.endX();
            goto L4
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> r5, int r10, boolean r11) {
            Iterator<PostponedUpdate> r12 = r5.iterator();
        L4:
            if (r12.hasNext() == false) goto L10;
            PostponedUpdate r13 = r12.next();
            if (r13.posInOwnerList != r10) goto L4;
            if (r13.removal != r11) goto L4;
            r12.remove();
        L12:
            if (r12.hasNext() == false) goto L17;
            PostponedUpdate r14 = r12.next();
            if (r11 == true) goto L15;
            r14.currentPos++;
            goto L12
        L15:
            r14.currentPos--;
            goto L12
        L17:
            return r13;
        L10:
            r13 = null;
            goto L12
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int r5) {
            if (r5 >= 0) goto L4;
        L11:
            StringBuilder r10 = j0.s(r5, "Index out of bounds - passed position = ", ", new list size = ");
            r10.append(this.mNewListSize);
            throw new IndexOutOfBoundsException(r10.toString());
        L4:
            if (r5 >= this.mNewListSize) goto L11;
            int r11 = this.mNewItemStatuses[r5];
            if ((r11 & 15) != 0) goto L10;
            return -1;
        L10:
            return r11 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int r5) {
            if (r5 >= 0) goto L4;
        L11:
            StringBuilder r10 = j0.s(r5, "Index out of bounds - passed position = ", ", old list size = ");
            r10.append(this.mOldListSize);
            throw new IndexOutOfBoundsException(r10.toString());
        L4:
            if (r5 >= this.mOldListSize) goto L11;
            int r11 = this.mOldItemStatuses[r5];
            if ((r11 & 15) != 0) goto L10;
            return -1;
        L10:
            return r11 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter r5) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(r5));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback r13) {
            if ((r13 instanceof BatchingListUpdateCallback) == false) goto L5;
            BatchingListUpdateCallback r14 = (BatchingListUpdateCallback) r13;
        L6:
            int r5 = this.mOldListSize;
            ArrayDeque r10 = new ArrayDeque();
            int r11 = this.mOldListSize;
            int r12 = this.mNewListSize;
            int r15 = this.mDiagonals.size() - 1;
        L7:
            if (r15 < 0) goto L38;
            Diagonal r16 = this.mDiagonals.get(r15);
            int r17 = r16.endX();
            int r18 = r16.endY();
        L9:
            int r19 = 0;
            if (r11 <= r17) goto L20;
            r11 = r11 - 1;
            int r110 = this.mOldItemStatuses[r11];
            if ((r110 & 12) != 0) goto L13;
            r14.onRemoved(r11, 1);
            r5 = r5 - 1;
            goto L9
        L13:
            int r111 = r110 >> 4;
            PostponedUpdate r20 = getPostponedUpdate(r10, r111, false);
            if (r20 != null) goto L15;
            r10.add(new PostponedUpdate(r11, (r5 - r11) - 1, true));
            goto L9
        L15:
            int r21 = (r5 - r20.currentPos) - 1;
            r14.onMoved(r11, r21);
            if ((r110 & 4) == 0) goto L9;
            r14.onChanged(r21, 1, this.mCallback.getChangePayload(r11, r111));
        L20:
            if (r12 <= r18) goto L30;
            r12 = r12 - 1;
            int r22 = this.mNewItemStatuses[r12];
            if ((r22 & 12) != 0) goto L23;
            r14.onInserted(r11, 1);
            r5 = r5 + 1;
            goto L20
        L23:
            int r112 = r22 >> 4;
            PostponedUpdate r113 = getPostponedUpdate(r10, r112, true);
            if (r113 == null) goto L25;
            r14.onMoved((r5 - r113.currentPos) - 1, r11);
            if ((r22 & 4) == 0) goto L20;
            r14.onChanged(r11, 1, this.mCallback.getChangePayload(r112, r12));
            goto L20
        L25:
            r10.add(new PostponedUpdate(r12, r5 - r11, false));
            goto L20
        L30:
            int r23 = r16.f567x;
            int r24 = r16.f568y;
        L32:
            if (r19 >= r16.size) goto L37;
            if ((this.mOldItemStatuses[r23] & 15) != 2) goto L36;
            r14.onChanged(r23, 1, this.mCallback.getChangePayload(r23, r24));
        L36:
            r23 = r23 + 1;
            r24 = r24 + 1;
            r19 = r19 + 1;
            goto L32
        L37:
            r11 = r16.f567x;
            r12 = r16.f568y;
            r15 = r15 - 1;
            goto L7
        L38:
            r14.dispatchLastEvent();
            return;
        L5:
            r14 = new BatchingListUpdateCallback(r13);
            goto L6
        }
    }

    public static abstract class ItemCallback<T> {
        public ItemCallback() {
        }

        public abstract boolean areContentsTheSame(@NonNull T r5, @NonNull T r10);

        public abstract boolean areItemsTheSame(@NonNull T r5, @NonNull T r10);

        @Nullable
        public Object getChangePayload(@NonNull T r5, @NonNull T r10) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int r5, int r10, boolean r11) {
            this.posInOwnerList = r5;
            this.currentPos = r10;
            this.removal = r11;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int r5, int r10, int r11, int r12) {
            this.oldListStart = r5;
            this.oldListEnd = r10;
            this.newListStart = r11;
            this.newListEnd = r12;
        }
    }

    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public Snake() {
        }

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            if ((this.endY - this.startY) == (this.endX - this.startX)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isAddition() {
            if ((this.endY - this.startY) <= (this.endX - this.startX)) goto L5;
            return true;
        L5:
            return false;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (hasAdditionOrRemoval() == true) goto L5;
            int r5 = this.startX;
            return new Diagonal(r5, this.startY, this.endX - r5);
        L5:
            if (this.reverse == false) goto L9;
            return new Diagonal(this.startX, this.startY, diagonalSize());
        L9:
            if (isAddition() == false) goto L13;
            return new Diagonal(this.startX, this.startY + 1, diagonalSize());
        L13:
            return new Diagonal(this.startX + 1, this.startY, diagonalSize());
        }
    }

    static {
        DIAGONAL_COMPARATOR = new AnonymousClass1();
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range r11, Callback r12, CenteredArray r13, CenteredArray r14, int r15) {
        if (((r11.oldSize() - r11.newSize()) % 2) != 0) goto L5;
        boolean r5 = true;
    L6:
        int r10 = r11.oldSize() - r11.newSize();
        int r16 = -r15;
        int r17 = r16;
    L7:
        if (r17 > r15) goto L38;
        if (r17 == r16) goto L14;
        if (r17 != r15) goto L11;
    L13:
        int r18 = r14.get(r17 - 1);
        int r19 = r18 - 1;
    L15:
        int r20 = r11.newListEnd - ((r11.oldListEnd - r19) - r17);
        if (r15 == 0) goto L20;
        if (r19 != r18) goto L20;
        int r21 = r20 + 1;
    L22:
        if (r19 <= r11.oldListStart) goto L28;
        if (r20 <= r11.newListStart) goto L28;
        if (r12.areItemsTheSame(r19 - 1, r20 - 1) == false) goto L28;
        r19 = r19 - 1;
        r20 = r20 - 1;
    L28:
        r14.set(r17, r19);
        if (r5 == false) goto L37;
        int r22 = r10 - r17;
        if (r22 < r16) goto L37;
        if (r22 > r15) goto L37;
        if (r13.get(r22) < r19) goto L37;
        Snake r110 = new Snake();
        r110.startX = r19;
        r110.startY = r20;
        r110.endX = r18;
        r110.endY = r21;
        r110.reverse = true;
        return r110;
    L37:
        r17 = r17 + 2;
    L20:
        r21 = r20;
        goto L22
    L11:
        if (r14.get(r17 + 1) >= r14.get(r17 - 1)) goto L13;
    L14:
        r18 = r14.get(r17 + 1);
        r19 = r18;
        goto L15
    L38:
        return null;
    L5:
        r5 = false;
        goto L6
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback r5) {
        return calculateDiff(r5, true);
    }

    @Nullable
    private static Snake forward(Range r11, Callback r12, CenteredArray r13, CenteredArray r14, int r15) {
        boolean r5 = true;
        if ((Math.abs(r11.oldSize() - r11.newSize()) % 2) == 1) goto L6;
        r5 = false;
    L6:
        int r10 = r11.oldSize() - r11.newSize();
        int r16 = -r15;
        int r17 = r16;
    L7:
        if (r17 > r15) goto L39;
        if (r17 == r16) goto L14;
        if (r17 != r15) goto L11;
    L13:
        int r18 = r13.get(r17 - 1);
        int r19 = r18 + 1;
    L15:
        int r20 = ((r19 - r11.oldListStart) + r11.newListStart) - r17;
        if (r15 == 0) goto L20;
        if (r19 != r18) goto L20;
        int r21 = r20 - 1;
    L22:
        if (r19 >= r11.oldListEnd) goto L28;
        if (r20 >= r11.newListEnd) goto L28;
        if (r12.areItemsTheSame(r19, r20) == false) goto L28;
        r19 = r19 + 1;
        r20 = r20 + 1;
    L28:
        r13.set(r17, r19);
        if (r5 == false) goto L38;
        int r22 = r10 - r17;
        if (r22 < (r16 + 1)) goto L38;
        if (r22 > (r15 - 1)) goto L38;
        if (r14.get(r22) > r19) goto L38;
        Snake r110 = new Snake();
        r110.startX = r18;
        r110.startY = r21;
        r110.endX = r19;
        r110.endY = r20;
        r110.reverse = false;
        return r110;
    L38:
        r17 = r17 + 2;
    L20:
        r21 = r20;
        goto L22
    L11:
        if (r13.get(r17 + 1) <= r13.get(r17 - 1)) goto L13;
    L14:
        r18 = r13.get(r17 + 1);
        r19 = r18;
        goto L15
    L39:
        return null;
    }

    @Nullable
    private static Snake midPoint(Range r5, Callback r10, CenteredArray r11, CenteredArray r12) {
        if (r5.oldSize() >= 1) goto L5;
    L16:
        return null;
    L5:
        if (r5.newSize() < 1) goto L16;
        int r13 = ((r5.oldSize() + r5.newSize()) + 1) / 2;
        r11.set(1, r5.oldListStart);
        r12.set(1, r5.oldListEnd);
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L16;
        Snake r15 = forward(r5, r10, r11, r12, r14);
        if (r15 != null) goto L11;
        Snake r16 = backward(r5, r10, r11, r12, r14);
        if (r16 != null) goto L14;
        r14 = r14 + 1;
        goto L8
    L14:
        return r16;
    L11:
        return r15;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback r10, boolean r11) {
        int r5 = r10.getOldListSize();
        int r12 = r10.getNewListSize();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        r14.add(new Range(0, r5, 0, r12));
        int r15 = ((((r5 + r12) + 1) / 2) * 2) + 1;
        CenteredArray r16 = new CenteredArray(r15);
        CenteredArray r17 = new CenteredArray(r15);
        ArrayList r18 = new ArrayList();
    L4:
        if (r14.isEmpty() == true) goto L16;
        Range r19 = (Range) r14.remove(r14.size() - 1);
        Snake r20 = midPoint(r19, r10, r16, r17);
        if (r20 != null) goto L8;
        r18.add(r19);
        goto L4
    L8:
        if (r20.diagonalSize() <= 0) goto L11;
        r13.add(r20.toDiagonal());
    L11:
        if (r18.isEmpty() == false) goto L13;
        Range r21 = new Range();
    L14:
        r21.oldListStart = r19.oldListStart;
        r21.newListStart = r19.newListStart;
        r21.oldListEnd = r20.startX;
        r21.newListEnd = r20.startY;
        r14.add(r21);
        r19.oldListEnd = r19.oldListEnd;
        r19.newListEnd = r19.newListEnd;
        r19.oldListStart = r20.endX;
        r19.newListStart = r20.endY;
        r14.add(r19);
        goto L4
    L13:
        r21 = (Range) r18.remove(r18.size() - 1);
        goto L14
    L16:
        Collections.sort(r13, DIAGONAL_COMPARATOR);
        return new DiffResult(r10, r13, r16.backingData(), r17.backingData(), r11);
    }
}
