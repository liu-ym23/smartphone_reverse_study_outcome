package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View r5) {
        this.mView = r5;
    }

    private boolean dispatchNestedScrollInternal(int r16, int r17, int r18, int r19, @Nullable int[] r20, int r21, @Nullable int[] r22) {
        if (isNestedScrollingEnabled() == false) goto L25;
        ViewParent r5 = getNestedScrollingParentForType(r21);
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r16 != 0) goto L15;
        if (r17 != 0) goto L15;
        if (r18 != 0) goto L15;
        if (r19 != 0) goto L15;
        if (r20 == null) goto L25;
        r20[0] = 0;
        r20[1] = 0;
    L15:
        if (r20 == null) goto L17;
        this.mView.getLocationInWindow(r20);
        int r13 = r20[0];
        int r14 = r20[1];
    L18:
        if (r22 != null) goto L20;
        int[] r10 = getTempNestedScrollConsumed();
        r10[0] = 0;
        r10[1] = 0;
        int[] r11 = r10;
    L21:
        ViewParentCompat.onNestedScroll(r5, this.mView, r16, r17, r18, r19, r21, r11);
        if (r20 == null) goto L24;
        this.mView.getLocationInWindow(r20);
        r20[0] = r20[0] - r13;
        r20[1] = r20[1] - r14;
    L24:
        return true;
    L20:
        r11 = r22;
        goto L21
    L17:
        r13 = 0;
        r14 = 0;
    L25:
        return false;
    }

    private ViewParent getNestedScrollingParentForType(int r5) {
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L8;
        return null;
    L8:
        return this.mNestedScrollingParentNonTouch;
    L10:
        return this.mNestedScrollingParentTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed != null) goto L6;
        this.mTempNestedScrollConsumed = new int[2];
    L6:
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int r5, ViewParent r10) {
        if (r5 != 0) goto L4;
        this.mNestedScrollingParentTouch = r10;
        return;
    L4:
        if (r5 != 1) goto L10;
        this.mNestedScrollingParentNonTouch = r10;
        return;
    }

    public boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        if (isNestedScrollingEnabled() == false) goto L8;
        ViewParent r12 = getNestedScrollingParentForType(0);
        if (r12 == null) goto L8;
        return ViewParentCompat.onNestedFling(r12, this.mView, r5, r10, r11);
    L8:
        return false;
    }

    public boolean dispatchNestedPreFling(float r5, float r10) {
        if (isNestedScrollingEnabled() == false) goto L8;
        ViewParent r11 = getNestedScrollingParentForType(0);
        if (r11 == null) goto L8;
        return ViewParentCompat.onNestedPreFling(r11, this.mView, r5, r10);
    L8:
        return false;
    }

    public boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13) {
        return dispatchNestedPreScroll(r10, r11, r12, r13, 0);
    }

    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14) {
        return dispatchNestedScrollInternal(r10, r11, r12, r13, r14, 0, null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View r5) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean r5) {
        if (this.mIsNestedScrollingEnabled == false) goto L5;
        ViewCompat.stopNestedScroll(this.mView);
    L5:
        this.mIsNestedScrollingEnabled = r5;
    }

    public boolean startNestedScroll(int r5) {
        return startNestedScroll(r5, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int r11, int r12, @Nullable int[] r13, @Nullable int[] r14, int r15) {
        if (isNestedScrollingEnabled() == false) goto L27;
        ViewParent r5 = getNestedScrollingParentForType(r15);
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r11 != 0) goto L13;
        if (r12 != 0) goto L13;
        if (r14 == null) goto L28;
        r14[0] = 0;
        r14[1] = 0;
        return false;
    L28:
        return false;
    L13:
        if (r14 == null) goto L15;
        this.mView.getLocationInWindow(r14);
        int r10 = r14[0];
        int r16 = r14[1];
    L16:
        if (r13 != null) goto L18;
        r13 = getTempNestedScrollConsumed();
    L18:
        r13[0] = 0;
        r13[1] = 0;
        ViewParentCompat.onNestedPreScroll(r5, this.mView, r11, r12, r13, r15);
        if (r14 == null) goto L22;
        this.mView.getLocationInWindow(r14);
        r14[0] = r14[0] - r10;
        r14[1] = r14[1] - r16;
    L22:
        if (r13[0] != 0) goto L26;
        if (r13[1] != 0) goto L26;
        return false;
    L26:
        return true;
    L15:
        r10 = 0;
        r16 = 0;
        goto L16
    L27:
        return false;
    }

    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15) {
        return dispatchNestedScrollInternal(r10, r11, r12, r13, r14, r15, null);
    }

    public boolean hasNestedScrollingParent(int r5) {
        if (getNestedScrollingParentForType(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean startNestedScroll(int r5, int r10) {
        if (hasNestedScrollingParent(r10) == false) goto L6;
        return true;
    L6:
        if (isNestedScrollingEnabled() == false) goto L17;
        ViewParent r11 = this.mView.getParent();
        View r12 = this.mView;
    L8:
        if (r11 == null) goto L23;
        if (ViewParentCompat.onStartNestedScroll(r11, r12, this.mView, r5, r10) == true) goto L11;
        if ((r11 instanceof View) == false) goto L16;
        r12 = (View) r11;
    L16:
        r11 = r11.getParent();
        goto L8
    L11:
        setNestedScrollingParentForType(r10, r11);
        ViewParentCompat.onNestedScrollAccepted(r11, r12, this.mView, r5, r10);
        return true;
    L23:
        return false;
    L17:
        return false;
    }

    public void stopNestedScroll(int r5) {
        ViewParent r10 = getNestedScrollingParentForType(r5);
        if (r10 == null) goto L6;
        ViewParentCompat.onStopNestedScroll(r10, this.mView, r5);
        setNestedScrollingParentForType(r5, null);
        return;
    }

    public void dispatchNestedScroll(int r5, int r10, int r11, int r12, @Nullable int[] r13, int r14, @Nullable int[] r15) {
        dispatchNestedScrollInternal(r5, r10, r11, r12, r13, r14, r15);
    }
}
