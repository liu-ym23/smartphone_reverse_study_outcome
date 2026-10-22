package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles;

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        public Tile(Class<T> r10, int r11) {
            this.mItems = (T[]) ((Object[]) Array.newInstance(r10, r11));
        }

        boolean containsPosition(int r10) {
            int r11 = this.mStartPosition;
            if (r11 <= r10) goto L5;
        L7:
            return false;
        L5:
            if (r10 >= (r11 + this.mItemCount)) goto L7;
            return true;
        }

        T getByPosition(int r10) {
            return this.mItems[r10 - this.mStartPosition];
        }
    }

    public TileList(int r10) {
        this.mTiles = new SparseArray(10);
        this.mTileSize = r10;
    }

    public Tile<T> addOrReplace(Tile<T> r10) {
        int r11 = this.mTiles.indexOfKey(r10.mStartPosition);
        if (r11 >= 0) goto L6;
        this.mTiles.put(r10.mStartPosition, r10);
        return null;
    L6:
        Tile<T> r12 = this.mTiles.valueAt(r11);
        this.mTiles.setValueAt(r11, r10);
        if (this.mLastAccessedTile != r12) goto L9;
        this.mLastAccessedTile = r10;
    L9:
        return r12;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int r10) {
        return this.mTiles.valueAt(r10);
    }

    public T getItemAt(int r10) {
        Tile<T> r11 = this.mLastAccessedTile;
        if (r11 != null) goto L5;
    L6:
        int r12 = r10 - (r10 % this.mTileSize);
        int r13 = this.mTiles.indexOfKey(r12);
        if (r13 >= 0) goto L10;
        return null;
    L10:
        this.mLastAccessedTile = this.mTiles.valueAt(r13);
    L12:
        return this.mLastAccessedTile.getByPosition(r10);
    L5:
        if (r11.containsPosition(r10) == true) goto L12;
        goto L6
    }

    public Tile<T> removeAtPos(int r10) {
        Tile<T> r11 = this.mTiles.get(r10);
        if (this.mLastAccessedTile != r11) goto L5;
        this.mLastAccessedTile = null;
    L5:
        this.mTiles.delete(r10);
        return r11;
    }

    public int size() {
        return this.mTiles.size();
    }
}
