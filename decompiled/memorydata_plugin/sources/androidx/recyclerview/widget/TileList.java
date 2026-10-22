package androidx.recyclerview.widget;

import android.util.SparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        Tile(Class<T> r2, int r3) {
            this.mItems = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r2, r3), Object[].class, "com.obric.memorydata.plugin"));
        }

        boolean containsPosition(int r2) {
            int r0 = this.mStartPosition;
            if (r0 <= r2) goto L5;
        L7:
            return false;
        L5:
            if (r2 >= (r0 + this.mItemCount)) goto L7;
            return true;
        }

        T getByPosition(int r2) {
            return this.mItems[r2 - this.mStartPosition];
        }
    }

    public TileList(int r3) {
        this.mTiles = new SparseArray(10);
        this.mTileSize = r3;
    }

    public Tile<T> addOrReplace(Tile<T> r5) {
        int r0 = this.mTiles.indexOfKey(r5.mStartPosition);
        if (r0 >= 0) goto L6;
        this.mTiles.put(r5.mStartPosition, r5);
        return null;
    L6:
        Tile<T> r1 = (Tile) ZeusTransformUtils.preCheckCast(this.mTiles.valueAt(r0), Tile.class, "com.obric.memorydata.plugin");
        this.mTiles.setValueAt(r0, r5);
        if (this.mLastAccessedTile != r1) goto L9;
        this.mLastAccessedTile = r5;
    L9:
        return r1;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.mTiles.size()) goto L7;
        return null;
    L7:
        return (Tile) ZeusTransformUtils.preCheckCast(this.mTiles.valueAt(r2), Tile.class, "com.obric.memorydata.plugin");
    }

    public T getItemAt(int r4) {
        Tile<T> r0 = this.mLastAccessedTile;
        if (r0 != null) goto L5;
    L6:
        int r1 = r4 - (r4 % this.mTileSize);
        int r2 = this.mTiles.indexOfKey(r1);
        if (r2 >= 0) goto L10;
        return null;
    L10:
        this.mLastAccessedTile = (Tile) ZeusTransformUtils.preCheckCast(this.mTiles.valueAt(r2), Tile.class, "com.obric.memorydata.plugin");
    L12:
        return this.mLastAccessedTile.getByPosition(r4);
    L5:
        if (r0.containsPosition(r4) == true) goto L12;
        goto L6
    }

    public Tile<T> removeAtPos(int r4) {
        Tile<T> r0 = (Tile) ZeusTransformUtils.preCheckCast(this.mTiles.get(r4), Tile.class, "com.obric.memorydata.plugin");
        if (this.mLastAccessedTile != r0) goto L5;
        this.mLastAccessedTile = null;
    L5:
        this.mTiles.delete(r4);
        return r0;
    }

    public int size() {
        return this.mTiles.size();
    }
}
