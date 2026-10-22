package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class KeyboardShadowView extends View {
    private static final String TAG = "KeyboardShadowView";
    private Activity activity;
    private b mCallback;
    private boolean mEnableDispatchTouchEventToActivity;
    private boolean mIsAnchor;
    private boolean mIsDigHole;
    private boolean mIsPortrait;
    private boolean mShowStatusBar;
    private int statusBarHeight;

    public class a extends AccessibilityDelegateCompat {
        public a() {
        }

        public final void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            if (r2 != null) goto L5;
            return;
        L5:
            r2.setContentDescription("关闭");
            r2.setClassName(Button.class.getName());
        }
    }

    public interface b {
    }

    public void setCallback(b r1) {
    }

    public KeyboardShadowView(Context r1) {
        super(r1);
        this.mEnableDispatchTouchEventToActivity = true;
        this.mIsPortrait = false;
        this.mIsAnchor = false;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.mEnableDispatchTouchEventToActivity == true) goto L7;
        return super.dispatchTouchEvent(r4);
    L7:
        if (this.activity == null) goto L30;
        if (this.mShowStatusBar == false) goto L11;
    L12:
        r4.offsetLocation(0.0f, this.statusBarHeight);
    L13:
        DialogFragment r0 = this.activity.getSupportFragmentManager().findFragmentByTag("AbsInteractionFragment");
        if (r0 == null) goto L31;
        boolean r2 = false;
        if ((r0 instanceof DialogFragment) == false) goto L23;
        Dialog r1 = r0.getDialog();
        if (r1 == null) goto L23;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L25;
        r2 = r3.superDispatchTouchEvent(r4);
    L25:
        if (r3 == this.activity.getWindow()) goto L28;
        return super.dispatchTouchEvent(r4);
    L28:
        return r2;
    L23:
        r3 = null;
        goto L25
    L31:
        return this.activity.dispatchTouchEvent(r4);
    L11:
        if (this.mIsDigHole == false) goto L13;
    L30:
        return super.dispatchTouchEvent(r4);
    }

    public void enableDispatchTouchEventToActivity(boolean r1) {
        this.mEnableDispatchTouchEventToActivity = r1;
    }

    public void setActivity(Activity r3) {
        this.activity = r3;
        this.mIsDigHole = DigHoleScreenUtil.isNeedStatusBarAdapt(r3, this.mIsPortrait, this.mIsAnchor);
        this.statusBarHeight = UIUtils.getStatusBarHeight(r3);
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    public void setIsAnchor(boolean r1) {
        this.mIsAnchor = r1;
    }

    public void setIsPortrait(boolean r1) {
        this.mIsPortrait = r1;
    }

    public void setShowStatusBar(boolean r1) {
        this.mShowStatusBar = r1;
    }

    public KeyboardShadowView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mEnableDispatchTouchEventToActivity = true;
        this.mIsPortrait = false;
        this.mIsAnchor = false;
    }

    public KeyboardShadowView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mEnableDispatchTouchEventToActivity = true;
        this.mIsPortrait = false;
        this.mIsAnchor = false;
    }

    public KeyboardShadowView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mEnableDispatchTouchEventToActivity = true;
        this.mIsPortrait = false;
        this.mIsAnchor = false;
    }
}
