package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class TooltipCompatHandler implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
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

    private TooltipCompatHandler(View r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        this.mShowRunnable = new $$Lambda$TooltipCompatHandler$3aFESLcagOxECyCXdU9G39Uust4(this);
        this.mHideRunnable = new $$Lambda$S9N95ygqizWQY8TZdkma301qYbk(this);
        this.mAnchor = r3;
        this.mTooltipText = r5;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        forceNextChangeSignificant();
        r3.setOnLongClickListener(this);
        r3.setOnHoverListener(this);
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void forceNextChangeSignificant() {
        this.mForceNextChangeSignificant = true;
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
    }

    private static void setPendingHandler(TooltipCompatHandler r1) {
        TooltipCompatHandler r0 = sPendingHandler;
        if (r0 == null) goto L5;
        r0.cancelPendingShow();
    L5:
        sPendingHandler = r1;
        if (r1 == null) goto L9;
        r1.scheduleShow();
        return;
    }

    public static void setTooltipText(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        TooltipCompatHandler r0 = sPendingHandler;
        if (r0 == null) goto L8;
        if (r0.mAnchor != r2) goto L8;
        setPendingHandler(null);
    L8:
        if (TextUtils.isEmpty(r4) == false) goto L15;
        TooltipCompatHandler r5 = sActiveHandler;
        if (r5 != null) goto L12;
    L14:
        r2.setOnLongClickListener(null);
        r2.setLongClickable(false);
        r2.setOnHoverListener(null);
        return;
    L12:
        if (r5.mAnchor != r2) goto L14;
        r5.hide();
        goto L14
    L15:
        new TooltipCompatHandler(r2, r4);
    }

    private boolean updateAnchorPos(MotionEvent r5) {
        int r0 = (int) r5.getX();
        int r6 = (int) r5.getY();
        if (this.mForceNextChangeSignificant == false) goto L5;
    L10:
        this.mAnchorX = r0;
        this.mAnchorY = r6;
        this.mForceNextChangeSignificant = false;
        return true;
    L5:
        if (Math.abs(r0 - this.mAnchorX) > this.mHoverSlop) goto L10;
        if (Math.abs(r6 - this.mAnchorY) > this.mHoverSlop) goto L10;
        return false;
    }

    void hide() {
        if (sActiveHandler != this) goto L9;
        sActiveHandler = null;
        TooltipPopup r0 = this.mPopup;
        if (r0 == null) goto L7;
        r0.hide();
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

    public /* synthetic */ void lambda$new$0$TooltipCompatHandler() {
        show(false);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View r4, MotionEvent r5) {
        if (this.mPopup != null) goto L5;
    L7:
        AccessibilityManager r6 = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mAnchor.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.memorydata.plugin");
        if (r6.isEnabled() == true) goto L10;
    L12:
        int r7 = r5.getAction();
        if (r7 == 7) goto L19;
        if (r7 != 10) goto L25;
        forceNextChangeSignificant();
        hide();
    L25:
        return false;
    L19:
        if (this.mAnchor.isEnabled() == false) goto L25;
        if (this.mPopup != null) goto L25;
        if (updateAnchorPos(r5) == false) goto L25;
        setPendingHandler(this);
        goto L25
    L10:
        if (r6.isTouchExplorationEnabled() == false) goto L12;
        return false;
    L5:
        if (this.mFromTouch == false) goto L7;
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r2) {
        this.mAnchorX = r2.getWidth() / 2;
        this.mAnchorY = r2.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        hide();
    }

    void show(boolean r8) {
        if (ViewCompat.isAttachedToWindow(this.mAnchor) == true) goto L5;
        return;
    L5:
        setPendingHandler(null);
        TooltipCompatHandler r0 = sActiveHandler;
        if (r0 == null) goto L8;
        r0.hide();
    L8:
        sActiveHandler = this;
        this.mFromTouch = r8;
        TooltipPopup r1 = new TooltipPopup((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mAnchor.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.mPopup = r1;
        r1.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(this);
        if (this.mFromTouch == false) goto L12;
        long r2 = 2500;
    L16:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, r2);
        return;
    L12:
        if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) != 1) goto L14;
        long r3 = 3000;
    L15:
        r2 = r3 - ((long) ViewConfiguration.getLongPressTimeout());
        goto L16
    L14:
        r3 = 15000;
        goto L15
    }
}
