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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    TooltipPopup(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.mLayoutParams = r0;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        Context r9 = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.mContext = r9;
        View r2 = ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.abc_tooltip, "layout", "abc_tooltip"), null, "com.obric.memorydata.plugin");
        this.mContentView = r2;
        this.mMessageView = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.message, OaidModel.KEY_ID, "message")), TextView.class, "com.obric.memorydata.plugin");
        r0.setTitle(getClass().getSimpleName());
        r0.packageName = r9.getPackageName();
        r0.type = 1002;
        r0.width = -2;
        r0.height = -2;
        r0.format = -3;
        r0.windowAnimations = ZeusTransformUtils.mapRes(R.style.Animation_AppCompat_Tooltip, "style", "Animation_AppCompat_Tooltip");
        r0.flags = 24;
    }

    private void computePosition(View r10, int r11, int r12, boolean r13, WindowManager.LayoutParams r14) {
        r14.token = r10.getApplicationWindowToken();
        int r0 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.tooltip_precise_anchor_threshold, "dimen", "tooltip_precise_anchor_threshold"));
        if (r10.getWidth() >= r0) goto L7;
        r11 = r10.getWidth() / 2;
    L7:
        if (r10.getHeight() < r0) goto L9;
        int r1 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.tooltip_precise_anchor_extra_offset, "dimen", "tooltip_precise_anchor_extra_offset"));
        int r2 = r12 + r1;
        int r15 = r12 - r1;
    L10:
        r14.gravity = 49;
        Resources r3 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin");
        if (r13 == false) goto L13;
        int r5 = R.dimen.tooltip_y_offset_touch;
        String r6 = "tooltip_y_offset_touch";
    L14:
        int r4 = r3.getDimensionPixelOffset(ZeusTransformUtils.mapRes(r5, "dimen", r6));
        View r7 = getAppRootView(r10);
        if (r7 != null) goto L18;
        Log.e(TAG, "Cannot find app view");
        return;
    L18:
        r7.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        if (this.mTmpDisplayFrame.left < 0) goto L21;
    L27:
        r7.getLocationOnScreen(this.mTmpAppPos);
        r10.getLocationOnScreen(this.mTmpAnchorPos);
        int[] r16 = this.mTmpAnchorPos;
        int r8 = r16[0];
        int[] r9 = this.mTmpAppPos;
        r16[0] = r8 - r9[0];
        r16[1] = r16[1] - r9[1];
        r14.x = (r16[0] + r11) - (r7.getWidth() / 2);
        int r17 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(r17, r17);
        int r18 = this.mContentView.getMeasuredHeight();
        int[] r19 = this.mTmpAnchorPos;
        int r20 = ((r19[1] + r15) - r4) - r18;
        int r110 = (r19[1] + r2) + r4;
        if (r13 == false) goto L32;
        if (r20 >= 0) goto L34;
    L33:
        r14.y = r110;
        return;
    L34:
        r14.y = r20;
        return;
    L32:
        if ((r18 + r110) > this.mTmpDisplayFrame.height()) goto L34;
    L21:
        if (this.mTmpDisplayFrame.top >= 0) goto L27;
        Resources r21 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin");
        int r22 = ZeusTransformUtils.getIdentifier(r21, "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r22 == 0) goto L25;
        int r23 = r21.getDimensionPixelSize(r22);
    L26:
        DisplayMetrics r24 = r21.getDisplayMetrics();
        this.mTmpDisplayFrame.set(0, r23, r24.widthPixels, r24.heightPixels);
        goto L27
    L25:
        r23 = 0;
        goto L26
    L13:
        r5 = R.dimen.tooltip_y_offset_non_touch;
        r6 = "tooltip_y_offset_non_touch";
        goto L14
    L9:
        r2 = r10.getHeight();
        r15 = 0;
        goto L10
    }

    private static View getAppRootView(View r4) {
        View r0 = r4.getRootView();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, WindowManager.LayoutParams.class) == true) goto L5;
    L7:
        Context r5 = r4.getContext();
    L8:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ContextWrapper.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == true) goto L13;
        r5 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r6, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L8
    L13:
        return ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDecorView();
    L15:
        return r0;
    L5:
        if (((WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r1, WindowManager.LayoutParams.class, "com.obric.memorydata.plugin")).type != 2) goto L7;
        return r0;
    }

    void hide() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        ((WindowManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).removeView(this.mContentView);
    }

    boolean isShowing() {
        if (this.mContentView.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    void show(View r9, int r10, int r11, boolean r12, CharSequence r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (isShowing() == false) goto L5;
        hide();
    L5:
        this.mMessageView.setText(r14);
        computePosition(r9, r10, r11, r12, this.mLayoutParams);
        ((WindowManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).addView(this.mContentView, this.mLayoutParams);
    }
}
