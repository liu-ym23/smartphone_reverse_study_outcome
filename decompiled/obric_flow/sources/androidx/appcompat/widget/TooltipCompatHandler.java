package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500;
    private static final String TAG = "TooltipCompatHandler";
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mForceNextChangeSignificant;
    private boolean mFromTouch;
    private final Runnable mHideRunnable;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final Runnable mShowRunnable;
    private final CharSequence mTooltipText;

    private TooltipCompatHandler(View r5, CharSequence r10) {
        final int r11 = 0;
        this.mShowRunnable = new c(this, r11);
        final int r12 = 1;
        this.mHideRunnable = new c(this, r12);
        this.mAnchor = r5;
        this.mTooltipText = r10;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(r5.getContext()));
        forceNextChangeSignificant();
        r5.setOnLongClickListener(this);
        r5.setOnHoverListener(this);
    }

    public static /* synthetic */ void a(TooltipCompatHandler r5) {
        r5.lambda$new$0();
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void forceNextChangeSignificant() {
        this.mForceNextChangeSignificant = true;
    }

    private /* synthetic */ void lambda$new$0() {
        show(false);
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
    }

    private static void setPendingHandler(TooltipCompatHandler r5) {
        TooltipCompatHandler r10 = sPendingHandler;
        if (r10 == null) goto L5;
        r10.cancelPendingShow();
    L5:
        sPendingHandler = r5;
        if (r5 == null) goto L9;
        r5.scheduleShow();
        return;
    }

    public static void setTooltipText(View r5, CharSequence r10) {
        TooltipCompatHandler r11 = sPendingHandler;
        if (r11 == null) goto L8;
        if (r11.mAnchor != r5) goto L8;
        setPendingHandler(null);
    L8:
        if (TextUtils.isEmpty(r10) == false) goto L15;
        TooltipCompatHandler r12 = sActiveHandler;
        if (r12 != null) goto L12;
    L14:
        r5.setOnLongClickListener(null);
        r5.setLongClickable(false);
        r5.setOnHoverListener(null);
        return;
    L12:
        if (r12.mAnchor != r5) goto L14;
        r12.hide();
        goto L14
    L15:
        new TooltipCompatHandler(r5, r10);
    }

    private boolean updateAnchorPos(MotionEvent r5) {
        int r10 = (int) r5.getX();
        int r11 = (int) r5.getY();
        if (this.mForceNextChangeSignificant == false) goto L5;
    L10:
        this.mAnchorX = r10;
        this.mAnchorY = r11;
        this.mForceNextChangeSignificant = false;
        return true;
    L5:
        if (Math.abs(r10 - this.mAnchorX) > this.mHoverSlop) goto L10;
        if (Math.abs(r11 - this.mAnchorY) > this.mHoverSlop) goto L10;
        return false;
    }

    public void hide() {
        if (sActiveHandler != this) goto L9;
        sActiveHandler = null;
        TooltipPopup r5 = this.mPopup;
        if (r5 == null) goto L7;
        r5.hide();
        this.mPopup = null;
        forceNextChangeSignificant();
        this.mAnchor.removeOnAttachStateChangeListener(this);
        goto L9
    L7:
        Log.e(TAG, "sActiveHandler.mPopup == null");
    L9:
        if (sPendingHandler != this) goto L11;
        setPendingHandler(null);
    L11:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View r5, MotionEvent r10) {
        if (this.mPopup != null) goto L5;
    L7:
        AccessibilityManager r11 = (AccessibilityManager) this.mAnchor.getContext().getSystemService("accessibility");
        if (r11.isEnabled() == true) goto L10;
    L12:
        int r12 = r10.getAction();
        if (r12 == 7) goto L19;
        if (r12 != 10) goto L25;
        forceNextChangeSignificant();
        hide();
    L25:
        return false;
    L19:
        if (this.mAnchor.isEnabled() == false) goto L25;
        if (this.mPopup != null) goto L25;
        if (updateAnchorPos(r10) == false) goto L25;
        setPendingHandler(this);
        goto L25
    L10:
        if (r11.isTouchExplorationEnabled() == false) goto L12;
        return false;
    L5:
        if (this.mFromTouch == false) goto L7;
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r5) {
        this.mAnchorX = r5.getWidth() / 2;
        this.mAnchorY = r5.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r5) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r5) {
        hide();
    }

    public void show(boolean r10) {
        if (ViewCompat.isAttachedToWindow(this.mAnchor) == true) goto L5;
        return;
    L5:
        setPendingHandler(null);
        TooltipCompatHandler r5 = sActiveHandler;
        if (r5 == null) goto L8;
        r5.hide();
    L8:
        sActiveHandler = this;
        this.mFromTouch = r10;
        TooltipPopup r11 = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup = r11;
        r11.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(this);
        if (this.mFromTouch == false) goto L12;
        long r12 = LONG_CLICK_HIDE_TIMEOUT_MS;
    L16:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, r12);
        return;
    L12:
        if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) != 1) goto L15;
        long r13 = ViewConfiguration.getLongPressTimeout();
        long r14 = 3000;
    L14:
        r12 = r14 - r13;
        goto L16
    L15:
        r13 = ViewConfiguration.getLongPressTimeout();
        r14 = HOVER_HIDE_TIMEOUT_MS;
        goto L14
    }
}
