package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable;
    private DataSetObserver mViewPagerObserver;

    public PagerAdapter() {
        this.mObservable = new DataSetObservable();
    }

    @Deprecated
    public void destroyItem(@NonNull View r10, int r11, @NonNull Object r12) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void destroyItem(@NonNull ViewGroup r10, int r11, @NonNull Object r12) {
        destroyItem(r10, r11, r12);
    }

    @Deprecated
    public void finishUpdate(@NonNull View r10) {
    }

    public void finishUpdate(@NonNull ViewGroup r10) {
        finishUpdate(r10);
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object r10) {
        return -1;
    }

    @Nullable
    public CharSequence getPageTitle(int r10) {
        return null;
    }

    public float getPageWidth(int r10) {
        return 1.0f;
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View r10, int r11) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r10, int r11) {
        return instantiateItem(r10, r11);
    }

    public abstract boolean isViewFromObject(@NonNull View r10, @NonNull Object r11);

    public void notifyDataSetChanged() {
        monitor-enter(this);
        DataSetObserver r10 = this.mViewPagerObserver;     // Catch: Throwable -> L9
        if (r10 == null) goto L6;
        r10.onChanged();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.mObservable.notifyChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void registerDataSetObserver(@NonNull DataSetObserver r10) {
        this.mObservable.registerObserver(r10);
    }

    public void restoreState(@Nullable Parcelable r10, @Nullable ClassLoader r11) {
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View r10, int r11, @NonNull Object r12) {
    }

    public void setPrimaryItem(@NonNull ViewGroup r10, int r11, @NonNull Object r12) {
        setPrimaryItem(r10, r11, r12);
    }

    void setViewPagerObserver(DataSetObserver r10) {
        monitor-enter(this);
        this.mViewPagerObserver = r10;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void startUpdate(@NonNull View r10) {
    }

    public void startUpdate(@NonNull ViewGroup r10) {
        startUpdate(r10);
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver r10) {
        this.mObservable.unregisterObserver(r10);
    }
}
