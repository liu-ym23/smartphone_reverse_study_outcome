package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    static class Api15Impl {
        private Api15Impl() {
        }

        static int getMaxScrollX(AccessibilityRecord r0) {
            return r0.getMaxScrollX();
        }

        static int getMaxScrollY(AccessibilityRecord r0) {
            return r0.getMaxScrollY();
        }

        static void setMaxScrollX(AccessibilityRecord r0, int r1) {
            r0.setMaxScrollX(r1);
        }

        static void setMaxScrollY(AccessibilityRecord r0, int r1) {
            r0.setMaxScrollY(r1);
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static void setSource(AccessibilityRecord r0, View r1, int r2) {
            r0.setSource(r1, r2);
        }
    }

    @Deprecated
    public AccessibilityRecordCompat(Object r3) {
        this.mRecord = (AccessibilityRecord) ZeusTransformUtils.preCheckCast(r3, AccessibilityRecord.class, "com.obric.memorydata.plugin");
    }

    public static int getMaxScrollX(AccessibilityRecord r2) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return 0;
    L5:
        return Api15Impl.getMaxScrollX(r2);
    }

    public static int getMaxScrollY(AccessibilityRecord r2) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return 0;
    L5:
        return Api15Impl.getMaxScrollY(r2);
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat r1) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(r1.mRecord));
    }

    public static void setMaxScrollX(AccessibilityRecord r2, int r3) {
        if (Build.VERSION.SDK_INT < 15) goto L6;
        Api15Impl.setMaxScrollX(r2, r3);
        return;
    }

    public static void setMaxScrollY(AccessibilityRecord r2, int r3) {
        if (Build.VERSION.SDK_INT < 15) goto L6;
        Api15Impl.setMaxScrollY(r2, r3);
        return;
    }

    public static void setSource(AccessibilityRecord r2, View r3, int r4) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        Api16Impl.setSource(r2, r3, r4);
        return;
    }

    @Deprecated
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AccessibilityRecordCompat.class) == true) goto L8;
        return false;
    L8:
        AccessibilityRecordCompat r6 = (AccessibilityRecordCompat) ZeusTransformUtils.preCheckCast(r5, AccessibilityRecordCompat.class, "com.obric.memorydata.plugin");
        AccessibilityRecord r4 = this.mRecord;
        if (r4 != null) goto L16;
        if (r6.mRecord != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r4.equals(r6.mRecord);
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
        AccessibilityRecord r0 = this.mRecord;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
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
    public void setAddedCount(int r1) {
        this.mRecord.setAddedCount(r1);
    }

    @Deprecated
    public void setBeforeText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mRecord.setBeforeText(r4);
    }

    @Deprecated
    public void setChecked(boolean r1) {
        this.mRecord.setChecked(r1);
    }

    @Deprecated
    public void setClassName(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mRecord.setClassName(r4);
    }

    @Deprecated
    public void setContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mRecord.setContentDescription(r4);
    }

    @Deprecated
    public void setCurrentItemIndex(int r1) {
        this.mRecord.setCurrentItemIndex(r1);
    }

    @Deprecated
    public void setEnabled(boolean r1) {
        this.mRecord.setEnabled(r1);
    }

    @Deprecated
    public void setFromIndex(int r1) {
        this.mRecord.setFromIndex(r1);
    }

    @Deprecated
    public void setFullScreen(boolean r1) {
        this.mRecord.setFullScreen(r1);
    }

    @Deprecated
    public void setItemCount(int r1) {
        this.mRecord.setItemCount(r1);
    }

    @Deprecated
    public void setMaxScrollX(int r1) {
        setMaxScrollX(this.mRecord, r1);
    }

    @Deprecated
    public void setMaxScrollY(int r1) {
        setMaxScrollY(this.mRecord, r1);
    }

    @Deprecated
    public void setParcelableData(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        this.mRecord.setParcelableData(r4);
    }

    @Deprecated
    public void setPassword(boolean r1) {
        this.mRecord.setPassword(r1);
    }

    @Deprecated
    public void setRemovedCount(int r1) {
        this.mRecord.setRemovedCount(r1);
    }

    @Deprecated
    public void setScrollX(int r1) {
        this.mRecord.setScrollX(r1);
    }

    @Deprecated
    public void setScrollY(int r1) {
        this.mRecord.setScrollY(r1);
    }

    @Deprecated
    public void setScrollable(boolean r1) {
        this.mRecord.setScrollable(r1);
    }

    @Deprecated
    public void setSource(View r1) {
        this.mRecord.setSource(r1);
    }

    @Deprecated
    public void setSource(View r1, int r2) {
        setSource(this.mRecord, r1, r2);
    }

    @Deprecated
    public void setToIndex(int r1) {
        this.mRecord.setToIndex(r1);
    }
}
