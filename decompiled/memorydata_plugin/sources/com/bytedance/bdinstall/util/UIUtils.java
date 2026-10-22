package com.bytedance.bdinstall.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class UIUtils {
    public static final boolean API_ET_20 = false;
    private static int DPI = 0;
    private static final char ELLIPSIS_CHAR = 8230;
    private static final int LAYOUT_PARAMS_KEEP_OLD = -3;
    private static String sScreenResolution;
    public static EllipsisMeasureResult sTempEllipsisResult;

    public static class EllipsisMeasureResult {
        public String ellipsisStr;
        public int length;

        public EllipsisMeasureResult() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 19) goto L5;
        boolean r0 = true;
    L6:
        API_ET_20 = r0;
        sScreenResolution = "";
        DPI = -1;
        sTempEllipsisResult = new EllipsisMeasureResult();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public UIUtils() {
    }

    @Deprecated
    public static boolean clearAnimation(View r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.getAnimation() == null) goto L10;
        r1.clearAnimation();
        return true;
    L10:
        return false;
    }

    @Deprecated
    public static void detachFromParent(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getParent() == null) goto L17;
        ViewParent r0 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == true) goto L14;
        return;
    L14:
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r3);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Deprecated
    public static float dip2Px(Context r2, float r3) {
        return (r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f;
    }

    @Deprecated
    public static void ellipseSingleLineStr(String r10, int r11, Paint r12, int r13, EllipsisMeasureResult r14) {
        if (r11 > r13) goto L5;
    L17:
        r14.ellipsisStr = "";
        r14.length = 0;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L17;
        int r2 = floatToIntBig(r12.measureText(r10));
        if (r2 > r11) goto L11;
        r14.ellipsisStr = r10;
        r14.length = r2;
        return;
    L11:
        StringBuilder r3 = new StringBuilder();
        int r15 = r12.breakText(r10, 0, r10.length(), true, r11 - r13, null);
        if (r15 >= 1) goto L15;
        r14.ellipsisStr = "";
        r14.length = 0;
        return;
    L15:
        r3.append(r10.substring(0, r15));
        r3.append(8230);
        r14.ellipsisStr = r3.toString();
        r14.length = r11;
    }

    @Deprecated
    public static void expandClickRegion(final View r7, final int r8, final int r9, final int r10, final int r11) {
        r7.post(new AnonymousClass1(r7, r9, r11, r8, r10));
    }

    public static int floatToIntBig(float r1) {
        return (int) (r1 + 0.999f);
    }

    @Deprecated
    public static int getDiggBuryWidth(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return ((ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels * 1375) / 10000) + ((int) dip2Px(r3, 20.0f));
    }

    @Deprecated
    public static String getDisplayCount(int r6) {
        if (r6 <= 10000) goto L11;
        String r7 = String.format("%.1f", new Object[]{Double.valueOf((((double) r6) * 1.0d) / 10000.0d)});
        if ('0' != r7.charAt(r7.length() - 1)) goto L9;
        StringBuilder r0 = new StringBuilder();
        r7 = r7.substring(0, r7.length() - 2);
    L8:
        return r0.append(r7).append("万").toString();
    L9:
        r0 = new StringBuilder();
        goto L8
    L11:
        return String.valueOf(r6);
    }

    public static int getDpi(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (DPI != (-1)) goto L7;
        if (r4 == null) goto L7;
        DPI = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().densityDpi;
    L7:
        return DPI;
    }

    @Deprecated
    public static int getIndexInParent(View r3) {
        if (r3 != null) goto L5;
    L11:
        return -1;
    L5:
        if (r3.getParent() == null) goto L11;
        ViewParent r1 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L11;
        return ((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin")).indexOfChild(r3);
    }

    @Deprecated
    public static int[] getLocationInAncestor(View r7, View r8) {
        if (r7 == null) goto L18;
        if (r8 == null) goto L18;
        int[] r2 = new int[2];
        float[] r1 = {0.0f, 0.0f};
        r1[0] = r1[0] + r7.getLeft();
        r1[1] = r1[1] + r7.getTop();
        ViewParent r9 = r7.getParent();
    L8:
        if (ZeusTransformUtils.instanceOf(r9, View.class) == false) goto L13;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin");
        if (r9 == r8) goto L11;
        r1[0] = r1[0] - r5.getScrollX();
        r1[1] = r1[1] - r5.getScrollY();
        r1[0] = r1[0] + r5.getLeft();
        r1[1] = r1[1] + r5.getTop();
        r9 = r5.getParent();
        goto L8
    L11:
        boolean r10 = true;
    L14:
        if (r10 == true) goto L16;
        return null;
    L16:
        r2[0] = (int) (r1[0] + 0.5f);
        r2[1] = (int) (r1[1] + 0.5f);
        return r2;
    L13:
        r10 = false;
    L18:
        return null;
    }

    @Deprecated
    public static void getLocationInUpView(View r5, View r6, int[] r7, boolean r8) {
        if (r5 == null) goto L13;
        if (r6 == null) goto L14;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.length < 2) goto L16;
        r5.getLocationInWindow(r7);
        int r0 = r7[0];
        int r3 = r7[1];
        r6.getLocationInWindow(r7);
        int r4 = r7[0] - r0;
        int r1 = r7[1] - r3;
        if (r8 == false) goto L11;
        int r9 = r6.getWidth();
        r4 = r4 + (r9 / 2);
        r1 = r1 + (r6.getHeight() / 2);
    L11:
        r7[0] = r4;
        r7[1] = r1;
        return;
    L16:
        return;
    L14:
        return;
    }

    private static int getScreenHeight(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.heightPixels;
    }

    public static String getScreenResolution(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(sScreenResolution) == false) goto L10;
        if (r3 == null) goto L10;
        int r0 = getScreenWidth(r3);
        int r4 = getScreenHeight(r3);
        if (r0 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        sScreenResolution = r0 + "*" + r4;
    L10:
        return sScreenResolution;
    }

    private static int getScreenWidth(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.widthPixels;
    }

    @Deprecated
    public static final int getStatusBarHeight(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r2 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r2 > 0) goto L8;
        return 0;
    L8:
        return ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDimensionPixelSize(r2);
    }

    @Deprecated
    public static final boolean isViewVisible(View r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Deprecated
    public static int px2dip(Context r2, float r3) {
        return (int) ((r3 / ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public static void requestOrienation(Activity r2, boolean r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isFinishing() == true) goto L14;
        r4.setRequestedOrientation(!r3 ? 1 : 0);
        Window r5 = ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin");
        if (r3 == false) goto L10;
        r5.setFlags(1024, 1024);
        return;
    L10:
        r5.clearFlags(1024);
        return;
    }

    @Deprecated
    public static void setClickListener(boolean r2, View r3, View.OnClickListener r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        r3.setOnClickListener(r5);
        boolean r6 = true;
    L8:
        r3.setClickable(r6);
        return;
    L7:
        r3.setOnClickListener(null);
        r6 = false;
        goto L8
    }

    @Deprecated
    public static int setColorAlpha(int r1, int r2) {
        if (r2 <= 255) goto L5;
        r2 = 255;
    L8:
        return (r1 & ViewCompat.MEASURED_SIZE_MASK) | (r2 * 16777216);
    L5:
        if (r2 >= 0) goto L8;
        r2 = 0;
        goto L8
    }

    @Deprecated
    public static void setLayoutParams(View r1, int r2, int r3) {
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        if (r4 != null) goto L6;
        return;
    L6:
        if (r2 == Integer.MIN_VALUE) goto L8;
        r4.width = r2;
    L8:
        if (r3 == Integer.MIN_VALUE) goto L11;
        r4.height = r3;
        return;
    }

    @Deprecated
    public static void setText(TextView r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r2.setText(r4);
        return;
    }

    @Deprecated
    public static void setTextViewMaxLines(TextView r2, int r3) {
        if (r2 == null) goto L16;
        if (r3 > 0) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
    L10:
        boolean r0 = true;
        if (r3 == 1) goto L14;
        r0 = false;
    L14:
        r2.setSingleLine(r0);
        r2.setMaxLines(r3);
        return;
    L8:
        if (r2.getMaxLines() != r3) goto L10;
        return;
    }

    @Deprecated
    public static void setTopMargin(View r3, float r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        updateLayoutMargin(r3, -3, (int) TypedValue.applyDimension(1, r4, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics()), -3, -3);
    }

    @Deprecated
    public static void setTxtAndAdjustVisible(TextView r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        setViewVisibility(r2, 8);
        return;
    L8:
        setViewVisibility(r2, 0);
        r2.setText(r4);
    }

    @Deprecated
    public static void setViewBackgroundWithPadding(View r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getPaddingLeft();
        int r1 = r4.getPaddingRight();
        int r2 = r4.getPaddingTop();
        int r3 = r4.getPaddingBottom();
        r4.setBackgroundResource(r5);
        r4.setPadding(r0, r2, r1, r3);
    }

    @Deprecated
    public static void setViewBackgroundWithPadding(View r4, Resources r5, int r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getPaddingLeft();
        int r1 = r4.getPaddingRight();
        int r2 = r4.getPaddingTop();
        int r3 = r4.getPaddingBottom();
        r4.setBackgroundColor(r5.getColor(r6));
        r4.setPadding(r0, r2, r1, r3);
    }

    public static void setViewBackgroundWithPadding(View r4, Drawable r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getPaddingLeft();
        int r1 = r4.getPaddingRight();
        int r2 = r4.getPaddingTop();
        int r3 = r4.getPaddingBottom();
        r4.setBackgroundDrawable(r5);
        r4.setPadding(r0, r2, r1, r3);
    }

    @Deprecated
    public static void setViewMinHeight(View r2, int r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L7;
    L9:
        r2.setMinimumHeight(r3);
        return;
    L7:
        if (r2.getMinimumHeight() != r3) goto L9;
    }

    @Deprecated
    public static final void setViewVisibility(View r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.getVisibility() != r2) goto L6;
        return;
    L6:
        if (visibilityValid(r2) == false) goto L12;
        r1.setVisibility(r2);
        return;
    }

    @Deprecated
    public static float sp2px(Context r2, float r3) {
        return TypedValue.applyDimension(2, r3, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics());
    }

    @Deprecated
    public static void updateLayout(View r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.width != r3) goto L12;
        if (r0.height != r4) goto L12;
        return;
    L12:
        if (r3 == (-3)) goto L14;
        r0.width = r3;
    L14:
        if (r4 == (-3)) goto L16;
        r0.height = r4;
    L16:
        r2.setLayoutParams(r0);
    }

    @Deprecated
    public static void updateLayoutMargin(View r7, int r8, int r9, int r10, int r11) {
        if (r7 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if (r0 != null) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L11;
        updateMargin(r7, (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        return;
    }

    private static void updateMargin(View r1, ViewGroup.MarginLayoutParams r2, int r3, int r4, int r5, int r6) {
        if (r1 == null) goto L24;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.leftMargin != r3) goto L14;
        if (r2.topMargin != r4) goto L14;
        if (r2.rightMargin != r5) goto L14;
        if (r2.bottomMargin != r6) goto L14;
        return;
    L14:
        if (r3 == (-3)) goto L16;
        r2.leftMargin = r3;
    L16:
        if (r4 == (-3)) goto L18;
        r2.topMargin = r4;
    L18:
        if (r5 == (-3)) goto L20;
        r2.rightMargin = r5;
    L20:
        if (r6 == (-3)) goto L22;
        r2.bottomMargin = r6;
    L22:
        r1.setLayoutParams(r2);
        return;
    }

    @Deprecated
    private static boolean visibilityValid(int r1) {
        if (r1 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r1 == 8) goto L9;
        if (r1 == 4) goto L9;
        return false;
    }
}
