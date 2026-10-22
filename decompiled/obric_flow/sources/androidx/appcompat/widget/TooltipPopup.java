package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    public TooltipPopup(@NonNull Context r5) {
        WindowManager.LayoutParams r10 = new WindowManager.LayoutParams();
        this.mLayoutParams = r10;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = r5;
        View r11 = LayoutInflater.from(r5).inflate(R.layout.abc_tooltip, null);
        this.mContentView = r11;
        this.mMessageView = (TextView) r11.findViewById(R.id.message);
        r10.setTitle(getClass().getSimpleName());
        r10.packageName = r5.getPackageName();
        r10.type = PointerIconCompat.TYPE_HAND;
        r10.width = -2;
        r10.height = -2;
        r10.format = -3;
        r10.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        r10.flags = 24;
    }

    private void computePosition(View r10, int r11, int r12, boolean r13, WindowManager.LayoutParams r14) {
        r14.token = r10.getApplicationWindowToken();
        int r5 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (r10.getWidth() >= r5) goto L7;
        r11 = r10.getWidth() / 2;
    L7:
        if (r10.getHeight() < r5) goto L9;
        int r15 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
        int r16 = r12 + r15;
        int r17 = r12 - r15;
    L10:
        r14.gravity = 49;
        Resources r18 = this.mContext.getResources();
        if (r13 == false) goto L13;
        int r19 = R.dimen.tooltip_y_offset_touch;
    L14:
        int r20 = r18.getDimensionPixelOffset(r19);
        View r21 = getAppRootView(r10);
        if (r21 != null) goto L18;
        Log.e(TAG, "Cannot find app view");
        return;
    L18:
        r21.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect r22 = this.mTmpDisplayFrame;
        if (r22.left < 0) goto L21;
    L27:
        r21.getLocationOnScreen(this.mTmpAppPos);
        r10.getLocationOnScreen(this.mTmpAnchorPos);
        int[] r23 = this.mTmpAnchorPos;
        int r24 = r23[0];
        int[] r25 = this.mTmpAppPos;
        int r26 = r24 - r25[0];
        r23[0] = r26;
        r23[1] = r23[1] - r25[1];
        r14.x = (r26 + r11) - (r21.getWidth() / 2);
        int r27 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(r27, r27);
        int r28 = this.mContentView.getMeasuredHeight();
        int r110 = this.mTmpAnchorPos[1];
        int r111 = ((r17 + r110) - r20) - r28;
        int r112 = (r110 + r16) + r20;
        if (r13 == false) goto L33;
        if (r111 < 0) goto L31;
        r14.y = r111;
        return;
    L31:
        r14.y = r112;
        return;
    L33:
        if ((r28 + r112) > this.mTmpDisplayFrame.height()) goto L35;
        r14.y = r112;
        return;
    L35:
        r14.y = r111;
        return;
    L21:
        if (r22.top >= 0) goto L27;
        Resources r29 = this.mContext.getResources();
        int r30 = r29.getIdentifier("status_bar_height", "dimen", "android");
        if (r30 == 0) goto L25;
        int r31 = r29.getDimensionPixelSize(r30);
    L26:
        DisplayMetrics r32 = r29.getDisplayMetrics();
        this.mTmpDisplayFrame.set(0, r31, r32.widthPixels, r32.heightPixels);
        goto L27
    L25:
        r31 = 0;
        goto L26
    L13:
        r19 = R.dimen.tooltip_y_offset_non_touch;
        goto L14
    L9:
        r16 = r10.getHeight();
        r17 = 0;
        goto L10
    }

    private static View getAppRootView(View r5) {
        View r10 = r5.getRootView();
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof WindowManager.LayoutParams) == true) goto L5;
    L7:
        Context r12 = r5.getContext();
    L9:
        if ((r12 instanceof ContextWrapper) == false) goto L15;
        if ((r12 instanceof Activity) == true) goto L13;
        r12 = ((ContextWrapper) r12).getBaseContext();
        goto L9
    L13:
        return ((Activity) r12).getWindow().getDecorView();
    L15:
        return r10;
    L5:
        if (((WindowManager.LayoutParams) r11).type != 2) goto L7;
        return r10;
    }

    public void hide() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
    }

    public boolean isShowing() {
        if (this.mContentView.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void show(View r10, int r11, int r12, boolean r13, CharSequence r14) {
        if (isShowing() == false) goto L5;
        hide();
    L5:
        this.mMessageView.setText(r14);
        computePosition(r10, r11, r12, r13, this.mLayoutParams);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }
}
