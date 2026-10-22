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

    private TooltipCompatHandler(View r10, CharSequence r11) {
        this.mShowRunnable = new d(this);
        this.mHideRunnable = new c(this);
        this.mAnchor = r10;
        this.mTooltipText = r11;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(r10.getContext()));
        forceNextChangeSignificant();
        r10.setOnLongClickListener(this);
        r10.setOnHoverListener(this);
    }

    public static /* synthetic */ void a(TooltipCompatHandler r10) {
        r10.lambda$new$0();
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

    private static void setPendingHandler(TooltipCompatHandler r10) {
        TooltipCompatHandler r11 = sPendingHandler;
        if (r11 == null) goto L5;
        r11.cancelPendingShow();
    L5:
        sPendingHandler = r10;
        if (r10 == null) goto L9;
        r10.scheduleShow();
        return;
    }

    public static void setTooltipText(View r10, CharSequence r11) {
        TooltipCompatHandler r12 = sPendingHandler;
        if (r12 == null) goto L8;
        if (r12.mAnchor != r10) goto L8;
        setPendingHandler(null);
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L15;
        TooltipCompatHandler r13 = sActiveHandler;
        if (r13 != null) goto L12;
    L14:
        r10.setOnLongClickListener(null);
        r10.setLongClickable(false);
        r10.setOnHoverListener(null);
        return;
    L12:
        if (r13.mAnchor != r10) goto L14;
        r13.hide();
        goto L14
    L15:
        new TooltipCompatHandler(r10, r11);
    }

    private boolean updateAnchorPos(MotionEvent r10) {
        int r11 = (int) r10.getX();
        int r12 = (int) r10.getY();
        if (this.mForceNextChangeSignificant == false) goto L5;
    L10:
        this.mAnchorX = r11;
        this.mAnchorY = r12;
        this.mForceNextChangeSignificant = false;
        return true;
    L5:
        if (Math.abs(r11 - this.mAnchorX) > this.mHoverSlop) goto L10;
        if (Math.abs(r12 - this.mAnchorY) > this.mHoverSlop) goto L10;
        return false;
    }

    void hide() {
        if (sActiveHandler != this) goto L9;
        sActiveHandler = null;
        TooltipPopup r10 = this.mPopup;
        if (r10 == null) goto L7;
        r10.hide();
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
    public boolean onHover(View r10, MotionEvent r11) {
        if (this.mPopup != null) goto L5;
    L7:
        AccessibilityManager r12 = (AccessibilityManager) this.mAnchor.getContext().getSystemService("accessibility");
        if (r12.isEnabled() == true) goto L10;
    L12:
        int r13 = r11.getAction();
        if (r13 == 7) goto L19;
        if (r13 != 10) goto L25;
        forceNextChangeSignificant();
        hide();
    L25:
        return false;
    L19:
        if (this.mAnchor.isEnabled() == false) goto L25;
        if (this.mPopup != null) goto L25;
        if (updateAnchorPos(r11) == false) goto L25;
        setPendingHandler(this);
        goto L25
    L10:
        if (r12.isTouchExplorationEnabled() == false) goto L12;
        return false;
    L5:
        if (this.mFromTouch == false) goto L7;
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r10) {
        this.mAnchorX = r10.getWidth() / 2;
        this.mAnchorY = r10.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r10) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r10) {
        hide();
    }

    void show(boolean r10) {
        if (ViewCompat.isAttachedToWindow(this.mAnchor) == true) goto L5;
        return;
    L5:
        setPendingHandler(null);
        TooltipCompatHandler r11 = sActiveHandler;
        if (r11 == null) goto L8;
        r11.hide();
    L8:
        sActiveHandler = this;
        this.mFromTouch = r10;
        TooltipPopup r12 = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup = r12;
        r12.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(this);
        if (this.mFromTouch == false) goto L12;
        long r13 = LONG_CLICK_HIDE_TIMEOUT_MS;
    L16:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, r13);
        return;
    L12:
        if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) != 1) goto L14;
        long r14 = 3000;
    L15:
        r13 = r14 - ((long) ViewConfiguration.getLongPressTimeout());
        goto L16
    L14:
        r14 = HOVER_HIDE_TIMEOUT_MS;
        goto L15
    }
}
