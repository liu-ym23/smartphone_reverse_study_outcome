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

    public void destroyItem(@NonNull ViewGroup r5, int r10, @NonNull Object r11) {
        destroyItem(r5, r10, r11);
    }

    @Deprecated
    public void finishUpdate(@NonNull View r5) {
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object r5) {
        return -1;
    }

    @Nullable
    public CharSequence getPageTitle(int r5) {
        return null;
    }

    public float getPageWidth(int r5) {
        return 1.0f;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r5, int r10) {
        return instantiateItem(r5, r10);
    }

    public abstract boolean isViewFromObject(@NonNull View r5, @NonNull Object r10);

    public void notifyDataSetChanged() {
        monitor-enter(this);
        DataSetObserver r5 = this.mViewPagerObserver;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.onChanged();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.mObservable.notifyChanged();
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void registerDataSetObserver(@NonNull DataSetObserver r5) {
        this.mObservable.registerObserver(r5);
    }

    public void restoreState(@Nullable Parcelable r5, @Nullable ClassLoader r10) {
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View r5, int r10, @NonNull Object r11) {
    }

    public void setViewPagerObserver(DataSetObserver r5) {
        monitor-enter(this);
        this.mViewPagerObserver = r5;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void startUpdate(@NonNull View r5) {
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver r5) {
        this.mObservable.unregisterObserver(r5);
    }

    @Deprecated
    public void destroyItem(@NonNull View r5, int r10, @NonNull Object r11) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void finishUpdate(@NonNull ViewGroup r5) {
        finishUpdate(r5);
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View r5, int r10) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void setPrimaryItem(@NonNull ViewGroup r5, int r10, @NonNull Object r11) {
        setPrimaryItem(r5, r10, r11);
    }

    public void startUpdate(@NonNull ViewGroup r5) {
        startUpdate(r5);
    }
}
