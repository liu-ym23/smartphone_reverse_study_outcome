package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalBadgeUtils
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT = false;

    static {
        USE_COMPAT_PARENT = false;
    }

    private BadgeUtils() {
    }

    public static /* synthetic */ void access$000(BadgeDrawable r5, View r10) {
        attachBadgeContentDescription(r5, r10);
    }

    private static void attachBadgeContentDescription(@NonNull final BadgeDrawable r5, @NonNull View r10) {
        if (ViewCompat.hasAccessibilityDelegate(r10) == false) goto L5;
        final View.AccessibilityDelegate r11 = r10.getAccessibilityDelegate();
        ViewCompat.setAccessibilityDelegate(r10, new AnonymousClass2(r11, r5));
        return;
    L5:
        ViewCompat.setAccessibilityDelegate(r10, new AnonymousClass3(r5));
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r5, @NonNull View r10) {
        attachBadgeDrawable(r5, r10, null);
    }

    @NonNull
    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context r5, @NonNull ParcelableSparseArray r10) {
        SparseArray<BadgeDrawable> r11 = new SparseArray(r10.size());
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L10;
        int r13 = r10.keyAt(r12);
        BadgeState.State r14 = (BadgeState.State) r10.valueAt(r12);
        if (r14 == null) goto L8;
        BadgeDrawable r15 = BadgeDrawable.createFromSavedState(r5, r14);
    L9:
        r11.put(r13, r15);
        r12 = r12 + 1;
        goto L4
    L8:
        r15 = null;
        goto L9
    L10:
        return r11;
    }

    @NonNull
    public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> r5) {
        ParcelableSparseArray r10 = new ParcelableSparseArray();
        int r11 = 0;
    L4:
        if (r11 >= r5.size()) goto L10;
        int r12 = r5.keyAt(r11);
        BadgeDrawable r13 = r5.valueAt(r11);
        if (r13 == null) goto L8;
        BadgeState.State r14 = r13.getSavedState();
    L9:
        r10.put(r12, r14);
        r11 = r11 + 1;
        goto L4
    L8:
        r14 = null;
        goto L9
    L10:
        return r10;
    }

    private static void detachBadgeContentDescription(@NonNull View r5) {
        if (ViewCompat.hasAccessibilityDelegate(r5) == false) goto L5;
        final View.AccessibilityDelegate r10 = r5.getAccessibilityDelegate();
        ViewCompat.setAccessibilityDelegate(r5, new AnonymousClass4(r10));
        return;
    L5:
        ViewCompat.setAccessibilityDelegate(r5, null);
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable r5, @NonNull View r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (USE_COMPAT_PARENT == false) goto L7;
    L10:
        r5.getCustomBadgeParent().setForeground(null);
        return;
    L7:
        if (r5.getCustomBadgeParent() != null) goto L10;
        r10.getOverlay().remove(r5);
    }

    @VisibleForTesting
    public static void removeToolbarOffset(BadgeDrawable r5) {
        r5.setAdditionalHorizontalOffset(0);
        r5.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable r5, @NonNull View r10, @Nullable FrameLayout r11) {
        Rect r12 = new Rect();
        r10.getDrawingRect(r12);
        r5.setBounds(r12);
        r5.updateBadgeCoordinates(r10, r11);
    }

    @VisibleForTesting
    public static void setToolbarOffset(BadgeDrawable r5, Resources r10) {
        r5.setAdditionalHorizontalOffset(r10.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        r5.setAdditionalVerticalOffset(r10.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(@NonNull Rect r5, float r10, float r11, float r12, float r13) {
        r5.set((int) (r10 - r12), (int) (r11 - r13), (int) (r10 + r12), (int) (r11 + r13));
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r5, @NonNull View r10, @Nullable FrameLayout r11) {
        setBadgeDrawableBounds(r5, r10, r11);
        if (r5.getCustomBadgeParent() == null) goto L6;
        r5.getCustomBadgeParent().setForeground(r5);
        return;
    L6:
        if (USE_COMPAT_PARENT == true) goto L10;
        r10.getOverlay().add(r5);
        return;
    L10:
        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable r5, @NonNull Toolbar r10, @IdRes int r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        ActionMenuItemView r12 = ToolbarUtils.getActionMenuItemView(r10, r11);
        if (r12 == null) goto L7;
        removeToolbarOffset(r5);
        detachBadgeDrawable(r5, r12);
        detachBadgeContentDescription(r12);
        return;
    L7:
        Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + r11);
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r5, @NonNull Toolbar r10, @IdRes int r11) {
        attachBadgeDrawable(r5, r10, r11, null);
    }

    public static void attachBadgeDrawable(@NonNull final BadgeDrawable r5, @NonNull final Toolbar r10, @IdRes final int r11, @Nullable final FrameLayout r12) {
        r10.post(new AnonymousClass1(r10, r11, r5, r12));
    }
}
