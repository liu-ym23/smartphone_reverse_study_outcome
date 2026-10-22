package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static int getMaxScrollX(AccessibilityRecord r10) {
            return r10.getMaxScrollX();
        }

        @DoNotInline
        static int getMaxScrollY(AccessibilityRecord r10) {
            return r10.getMaxScrollY();
        }

        @DoNotInline
        static void setMaxScrollX(AccessibilityRecord r10, int r11) {
            r10.setMaxScrollX(r11);
        }

        @DoNotInline
        static void setMaxScrollY(AccessibilityRecord r10, int r11) {
            r10.setMaxScrollY(r11);
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void setSource(AccessibilityRecord r10, View r11, int r12) {
            r10.setSource(r11, r12);
        }
    }

    @Deprecated
    public AccessibilityRecordCompat(Object r10) {
        this.mRecord = (AccessibilityRecord) r10;
    }

    public static int getMaxScrollX(@NonNull AccessibilityRecord r10) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return 0;
    L5:
        return Api15Impl.getMaxScrollX(r10);
    }

    public static int getMaxScrollY(@NonNull AccessibilityRecord r10) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return 0;
    L5:
        return Api15Impl.getMaxScrollY(r10);
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat r10) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(r10.mRecord));
    }

    public static void setMaxScrollX(@NonNull AccessibilityRecord r10, int r11) {
        if (Build.VERSION.SDK_INT < 15) goto L6;
        Api15Impl.setMaxScrollX(r10, r11);
        return;
    }

    public static void setMaxScrollY(@NonNull AccessibilityRecord r10, int r11) {
        if (Build.VERSION.SDK_INT < 15) goto L6;
        Api15Impl.setMaxScrollY(r10, r11);
        return;
    }

    public static void setSource(@NonNull AccessibilityRecord r10, @Nullable View r11, int r12) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        Api16Impl.setSource(r10, r11, r12);
        return;
    }

    @Deprecated
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AccessibilityRecordCompat) == true) goto L8;
        return false;
    L8:
        AccessibilityRecordCompat r11 = (AccessibilityRecordCompat) r10;
        AccessibilityRecord r12 = this.mRecord;
        if (r12 != null) goto L16;
        if (r11.mRecord != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r12.equals(r11.mRecord);
    }

    @Deprecated
    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.mRecord;
    }

    @Deprecated
    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.mRecord);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.mRecord);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.mRecord.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord r10 = this.mRecord;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.mRecord.recycle();
    }

    @Deprecated
    public void setAddedCount(int r10) {
        this.mRecord.setAddedCount(r10);
    }

    @Deprecated
    public void setBeforeText(CharSequence r10) {
        this.mRecord.setBeforeText(r10);
    }

    @Deprecated
    public void setChecked(boolean r10) {
        this.mRecord.setChecked(r10);
    }

    @Deprecated
    public void setClassName(CharSequence r10) {
        this.mRecord.setClassName(r10);
    }

    @Deprecated
    public void setContentDescription(CharSequence r10) {
        this.mRecord.setContentDescription(r10);
    }

    @Deprecated
    public void setCurrentItemIndex(int r10) {
        this.mRecord.setCurrentItemIndex(r10);
    }

    @Deprecated
    public void setEnabled(boolean r10) {
        this.mRecord.setEnabled(r10);
    }

    @Deprecated
    public void setFromIndex(int r10) {
        this.mRecord.setFromIndex(r10);
    }

    @Deprecated
    public void setFullScreen(boolean r10) {
        this.mRecord.setFullScreen(r10);
    }

    @Deprecated
    public void setItemCount(int r10) {
        this.mRecord.setItemCount(r10);
    }

    @Deprecated
    public void setMaxScrollX(int r10) {
        setMaxScrollX(this.mRecord, r10);
    }

    @Deprecated
    public void setMaxScrollY(int r10) {
        setMaxScrollY(this.mRecord, r10);
    }

    @Deprecated
    public void setParcelableData(Parcelable r10) {
        this.mRecord.setParcelableData(r10);
    }

    @Deprecated
    public void setPassword(boolean r10) {
        this.mRecord.setPassword(r10);
    }

    @Deprecated
    public void setRemovedCount(int r10) {
        this.mRecord.setRemovedCount(r10);
    }

    @Deprecated
    public void setScrollX(int r10) {
        this.mRecord.setScrollX(r10);
    }

    @Deprecated
    public void setScrollY(int r10) {
        this.mRecord.setScrollY(r10);
    }

    @Deprecated
    public void setScrollable(boolean r10) {
        this.mRecord.setScrollable(r10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public void setSource(View r10) {
        this.mRecord.setSource(r10);
    }

    @Deprecated
    public void setSource(View r10, int r11) {
        setSource(this.mRecord, r10, r11);
    }

    @Deprecated
    public void setToIndex(int r10) {
        this.mRecord.setToIndex(r10);
    }
}
