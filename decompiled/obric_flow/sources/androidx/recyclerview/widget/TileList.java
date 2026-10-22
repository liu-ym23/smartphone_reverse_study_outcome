package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
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

        public Tile(@NonNull Class<T> r5, int r10) {
            this.mItems = (T[]) ((Object[]) Array.newInstance(r5, r10));
        }

        public boolean containsPosition(int r5) {
            int r10 = this.mStartPosition;
            if (r10 <= r5) goto L5;
        L7:
            return false;
        L5:
            if (r5 >= (r10 + this.mItemCount)) goto L7;
            return true;
        }

        public T getByPosition(int r5) {
            return this.mItems[r5 - this.mStartPosition];
        }
    }

    public TileList(int r5) {
        this.mTiles = new SparseArray(10);
        this.mTileSize = r5;
    }

    public Tile<T> addOrReplace(Tile<T> r5) {
        int r10 = this.mTiles.indexOfKey(r5.mStartPosition);
        if (r10 >= 0) goto L6;
        this.mTiles.put(r5.mStartPosition, r5);
        return null;
    L6:
        Tile<T> r11 = this.mTiles.valueAt(r10);
        this.mTiles.setValueAt(r10, r5);
        if (this.mLastAccessedTile != r11) goto L9;
        this.mLastAccessedTile = r5;
    L9:
        return r11;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int r5) {
        if (r5 >= 0) goto L4;
        return null;
    L4:
        if (r5 < this.mTiles.size()) goto L7;
        return null;
    L7:
        return this.mTiles.valueAt(r5);
    }

    public T getItemAt(int r5) {
        Tile<T> r10 = this.mLastAccessedTile;
        if (r10 != null) goto L5;
    L6:
        int r11 = r5 - (r5 % this.mTileSize);
        int r12 = this.mTiles.indexOfKey(r11);
        if (r12 >= 0) goto L10;
        return null;
    L10:
        this.mLastAccessedTile = this.mTiles.valueAt(r12);
    L12:
        return this.mLastAccessedTile.getByPosition(r5);
    L5:
        if (r10.containsPosition(r5) == true) goto L12;
        goto L6
    }

    public Tile<T> removeAtPos(int r5) {
        Tile<T> r10 = this.mTiles.get(r5);
        if (this.mLastAccessedTile != r10) goto L5;
        this.mLastAccessedTile = null;
    L5:
        this.mTiles.delete(r5);
        return r10;
    }

    public int size() {
        return this.mTiles.size();
    }
}
