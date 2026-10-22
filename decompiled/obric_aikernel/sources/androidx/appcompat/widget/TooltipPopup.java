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

    TooltipPopup(@NonNull Context r10) {
        WindowManager.LayoutParams r11 = new WindowManager.LayoutParams();
        this.mLayoutParams = r11;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = r10;
        View r12 = LayoutInflater.from(r10).inflate(R.layout.abc_tooltip, null);
        this.mContentView = r12;
        this.mMessageView = (TextView) r12.findViewById(R.id.message);
        r11.setTitle(getClass().getSimpleName());
        r11.packageName = r10.getPackageName();
        r11.type = PointerIconCompat.TYPE_HAND;
        r11.width = -2;
        r11.height = -2;
        r11.format = -3;
        r11.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        r11.flags = 24;
    }

    private void computePosition(View r10, int r11, int r12, boolean r13, WindowManager.LayoutParams r14) {
        r14.token = r10.getApplicationWindowToken();
        int r15 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (r10.getWidth() >= r15) goto L7;
        r11 = r10.getWidth() / 2;
    L7:
        if (r10.getHeight() < r15) goto L9;
        int r16 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
        int r17 = r12 + r16;
        int r18 = r12 - r16;
    L10:
        r14.gravity = 49;
        Resources r19 = this.mContext.getResources();
        if (r13 == false) goto L13;
        int r20 = R.dimen.tooltip_y_offset_touch;
    L14:
        int r21 = r19.getDimensionPixelOffset(r20);
        View r22 = getAppRootView(r10);
        if (r22 != null) goto L18;
        Log.e(TAG, "Cannot find app view");
        return;
    L18:
        r22.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect r23 = this.mTmpDisplayFrame;
        if (r23.left < 0) goto L21;
    L27:
        r22.getLocationOnScreen(this.mTmpAppPos);
        r10.getLocationOnScreen(this.mTmpAnchorPos);
        int[] r24 = this.mTmpAnchorPos;
        int r25 = r24[0];
        int[] r26 = this.mTmpAppPos;
        r24[0] = r25 - r26[0];
        r24[1] = r24[1] - r26[1];
        r14.x = (r24[0] + r11) - (r22.getWidth() / 2);
        int r27 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(r27, r27);
        int r28 = this.mContentView.getMeasuredHeight();
        int[] r110 = this.mTmpAnchorPos;
        int r29 = ((r110[1] + r18) - r21) - r28;
        int r111 = (r110[1] + r17) + r21;
        if (r13 == false) goto L32;
        if (r29 >= 0) goto L34;
    L33:
        r14.y = r111;
        return;
    L34:
        r14.y = r29;
        return;
    L32:
        if ((r28 + r111) > this.mTmpDisplayFrame.height()) goto L34;
    L21:
        if (r23.top >= 0) goto L27;
        Resources r30 = this.mContext.getResources();
        int r31 = r30.getIdentifier("status_bar_height", "dimen", "android");
        if (r31 == 0) goto L25;
        int r32 = r30.getDimensionPixelSize(r31);
    L26:
        DisplayMetrics r33 = r30.getDisplayMetrics();
        this.mTmpDisplayFrame.set(0, r32, r33.widthPixels, r33.heightPixels);
        goto L27
    L25:
        r32 = 0;
        goto L26
    L13:
        r20 = R.dimen.tooltip_y_offset_non_touch;
        goto L14
    L9:
        r17 = r10.getHeight();
        r18 = 0;
        goto L10
    }

    private static View getAppRootView(View r10) {
        View r11 = r10.getRootView();
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof WindowManager.LayoutParams) == true) goto L5;
    L7:
        Context r13 = r10.getContext();
    L9:
        if ((r13 instanceof ContextWrapper) == false) goto L15;
        if ((r13 instanceof Activity) == true) goto L13;
        r13 = ((ContextWrapper) r13).getBaseContext();
        goto L9
    L13:
        return ((Activity) r13).getWindow().getDecorView();
    L15:
        return r11;
    L5:
        if (((WindowManager.LayoutParams) r12).type != 2) goto L7;
        return r11;
    }

    void hide() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
    }

    boolean isShowing() {
        if (this.mContentView.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    void show(View r10, int r11, int r12, boolean r13, CharSequence r14) {
        if (isShowing() == false) goto L5;
        hide();
    L5:
        this.mMessageView.setText(r14);
        computePosition(r10, r11, r12, r13, this.mLayoutParams);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }
}
