package androidx.recyclerview.widget;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int r5, int r10);

        @SuppressLint({"UnknownNullness"})
        void recycleTile(TileList.Tile<T> r5);

        void refresh(int r5);

        void updateRange(int r5, int r10, int r11, int r12, int r13);
    }

    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void addTile(int r5, TileList.Tile<T> r10);

        void removeTile(int r5, int r10);

        void updateItemCount(int r5, int r10);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> r5);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> r5);
}
