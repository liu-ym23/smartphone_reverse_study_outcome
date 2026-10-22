package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    @Deprecated
    public AccessibilityRecordCompat(Object r5) {
        this.mRecord = (AccessibilityRecord) r5;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat r5) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(r5.mRecord));
    }

    @Deprecated
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AccessibilityRecordCompat) == true) goto L8;
        return false;
    L8:
        AccessibilityRecordCompat r10 = (AccessibilityRecordCompat) r5;
        AccessibilityRecord r11 = this.mRecord;
        if (r11 != null) goto L16;
        if (r10.mRecord != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r11.equals(r10.mRecord);
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
        AccessibilityRecord r5 = this.mRecord;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
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
    public void setAddedCount(int r5) {
        this.mRecord.setAddedCount(r5);
    }

    @Deprecated
    public void setBeforeText(CharSequence r5) {
        this.mRecord.setBeforeText(r5);
    }

    @Deprecated
    public void setChecked(boolean r5) {
        this.mRecord.setChecked(r5);
    }

    @Deprecated
    public void setClassName(CharSequence r5) {
        this.mRecord.setClassName(r5);
    }

    @Deprecated
    public void setContentDescription(CharSequence r5) {
        this.mRecord.setContentDescription(r5);
    }

    @Deprecated
    public void setCurrentItemIndex(int r5) {
        this.mRecord.setCurrentItemIndex(r5);
    }

    @Deprecated
    public void setEnabled(boolean r5) {
        this.mRecord.setEnabled(r5);
    }

    @Deprecated
    public void setFromIndex(int r5) {
        this.mRecord.setFromIndex(r5);
    }

    @Deprecated
    public void setFullScreen(boolean r5) {
        this.mRecord.setFullScreen(r5);
    }

    @Deprecated
    public void setItemCount(int r5) {
        this.mRecord.setItemCount(r5);
    }

    @Deprecated
    public void setMaxScrollX(int r5) {
        setMaxScrollX(this.mRecord, r5);
    }

    @Deprecated
    public void setMaxScrollY(int r5) {
        setMaxScrollY(this.mRecord, r5);
    }

    @Deprecated
    public void setParcelableData(Parcelable r5) {
        this.mRecord.setParcelableData(r5);
    }

    @Deprecated
    public void setPassword(boolean r5) {
        this.mRecord.setPassword(r5);
    }

    @Deprecated
    public void setRemovedCount(int r5) {
        this.mRecord.setRemovedCount(r5);
    }

    @Deprecated
    public void setScrollX(int r5) {
        this.mRecord.setScrollX(r5);
    }

    @Deprecated
    public void setScrollY(int r5) {
        this.mRecord.setScrollY(r5);
    }

    @Deprecated
    public void setScrollable(boolean r5) {
        this.mRecord.setScrollable(r5);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public void setSource(View r5) {
        this.mRecord.setSource(r5);
    }

    @Deprecated
    public void setToIndex(int r5) {
        this.mRecord.setToIndex(r5);
    }

    public static int getMaxScrollX(@NonNull AccessibilityRecord r5) {
        return r5.getMaxScrollX();
    }

    public static int getMaxScrollY(@NonNull AccessibilityRecord r5) {
        return r5.getMaxScrollY();
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(@NonNull AccessibilityRecord r5, int r10) {
        r5.setMaxScrollX(r10);
    }

    public static void setMaxScrollY(@NonNull AccessibilityRecord r5, int r10) {
        r5.setMaxScrollY(r10);
    }

    @Deprecated
    public void setSource(View r5, int r10) {
        setSource(this.mRecord, r5, r10);
    }

    public static void setSource(@NonNull AccessibilityRecord r5, @Nullable View r10, int r11) {
        r5.setSource(r10, r11);
    }
}
