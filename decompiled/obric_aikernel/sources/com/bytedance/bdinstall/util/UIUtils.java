package com.bytedance.bdinstall.util;

import android.annotation.SuppressLint;
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
        boolean r10 = true;
    L6:
        API_ET_20 = r10;
        sScreenResolution = "";
        DPI = -1;
        sTempEllipsisResult = new EllipsisMeasureResult();
        return;
    L5:
        r10 = false;
        goto L6
    }

    public UIUtils() {
    }

    @Deprecated
    public static boolean clearAnimation(View r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if (r10.getAnimation() == null) goto L10;
        r10.clearAnimation();
        return true;
    L10:
        return false;
    }

    @Deprecated
    public static void detachFromParent(View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getParent() == null) goto L17;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == true) goto L14;
        return;
    L14:
        ((ViewGroup) r11).removeView(r10);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Deprecated
    public static float dip2Px(Context r10, float r11) {
        return (r11 * r10.getResources().getDisplayMetrics().density) + 0.5f;
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
        int r15 = floatToIntBig(r12.measureText(r10));
        if (r15 > r11) goto L11;
        r14.ellipsisStr = r10;
        r14.length = r15;
        return;
    L11:
        StringBuilder r16 = new StringBuilder();
        int r17 = r12.breakText(r10, 0, r10.length(), true, r11 - r13, null);
        if (r17 >= 1) goto L15;
        r14.ellipsisStr = "";
        r14.length = 0;
        return;
    L15:
        r16.append(r10.substring(0, r17));
        r16.append(8230);
        r14.ellipsisStr = r16.toString();
        r14.length = r11;
    }

    @Deprecated
    public static void expandClickRegion(final View r10, final int r11, final int r12, final int r13, final int r14) {
        r10.post(new AnonymousClass1(r10, r12, r14, r11, r13));
    }

    public static int floatToIntBig(float r10) {
        return (int) (r10 + 0.999f);
    }

    @Deprecated
    public static int getDiggBuryWidth(Context r10) {
        return ((r10.getResources().getDisplayMetrics().widthPixels * 1375) / 10000) + ((int) dip2Px(r10, 20.0f));
    }

    @Deprecated
    public static String getDisplayCount(int r10) {
        if (r10 <= 10000) goto L11;
        String r11 = String.format("%.1f", new Object[]{Double.valueOf((((double) r10) * 1.0d) / 10000.0d)});
        if ('0' != r11.charAt(r11.length() - 1)) goto L9;
        StringBuilder r12 = new StringBuilder();
        r11 = r11.substring(0, r11.length() - 2);
    L7:
        r12.append(r11);
        r12.append("万");
        return r12.toString();
    L9:
        r12 = new StringBuilder();
        goto L7
    L11:
        return String.valueOf(r10);
    }

    public static int getDpi(Context r10) {
        if (DPI != (-1)) goto L7;
        if (r10 == null) goto L7;
        DPI = r10.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L7:
        return DPI;
    }

    @Deprecated
    public static int getIndexInParent(View r10) {
        if (r10 != null) goto L5;
    L11:
        return -1;
    L5:
        if (r10.getParent() == null) goto L11;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L11;
        return ((ViewGroup) r11).indexOfChild(r10);
    }

    @Deprecated
    public static int[] getLocationInAncestor(View r10, View r11) {
        if (r10 == null) goto L18;
        if (r11 == null) goto L18;
        int[] r12 = new int[2];
        float[] r13 = {0.0f, 0.0f};
        r13[0] = r13[0] + r10.getLeft();
        r13[1] = r13[1] + r10.getTop();
        ViewParent r14 = r10.getParent();
    L8:
        if ((r14 instanceof View) == false) goto L13;
        View r15 = (View) r14;
        if (r14 == r11) goto L11;
        r13[0] = r13[0] - r15.getScrollX();
        r13[1] = r13[1] - r15.getScrollY();
        r13[0] = r13[0] + r15.getLeft();
        r13[1] = r13[1] + r15.getTop();
        r14 = r15.getParent();
        goto L8
    L11:
        boolean r16 = true;
    L14:
        if (r16 == true) goto L16;
        return null;
    L16:
        r12[0] = (int) (r13[0] + 0.5f);
        r12[1] = (int) (r13[1] + 0.5f);
        return r12;
    L13:
        r16 = false;
    L18:
        return null;
    }

    @Deprecated
    public static void getLocationInUpView(View r10, View r11, int[] r12, boolean r13) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L14;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.length < 2) goto L16;
        r10.getLocationInWindow(r12);
        int r14 = r12[0];
        int r15 = r12[1];
        r11.getLocationInWindow(r12);
        int r16 = r12[0] - r14;
        int r17 = r12[1] - r15;
        if (r13 == false) goto L11;
        int r18 = r11.getWidth();
        r16 = r16 + (r18 / 2);
        r17 = r17 + (r11.getHeight() / 2);
    L11:
        r12[0] = r16;
        r12[1] = r17;
        return;
    L16:
        return;
    L14:
        return;
    }

    private static int getScreenHeight(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.heightPixels;
    }

    public static String getScreenResolution(Context r10) {
        if (TextUtils.isEmpty(sScreenResolution) == false) goto L10;
        if (r10 == null) goto L10;
        int r11 = getScreenWidth(r10);
        int r12 = getScreenHeight(r10);
        if (r11 <= 0) goto L10;
        if (r12 <= 0) goto L10;
        sScreenResolution = r11 + "*" + r12;
    L10:
        return sScreenResolution;
    }

    private static int getScreenWidth(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.widthPixels;
    }

    @Deprecated
    public static final int getStatusBarHeight(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r11 > 0) goto L8;
        return 0;
    L8:
        return r10.getResources().getDimensionPixelSize(r11);
    }

    @Deprecated
    public static final boolean isViewVisible(View r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Deprecated
    public static int px2dip(Context r10, float r11) {
        return (int) ((r11 / r10.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public static void requestOrienation(Activity r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isFinishing() == true) goto L13;
        r10.setRequestedOrientation(!r11 ? 1 : 0);
        Window r12 = r10.getWindow();
        if (r11 == false) goto L9;
        r12.setFlags(1024, 1024);
        return;
    L9:
        r12.clearFlags(1024);
        return;
    }

    @Deprecated
    public static void setClickListener(boolean r10, View r11, View.OnClickListener r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 == false) goto L6;
        r11.setOnClickListener(r12);
        boolean r13 = true;
    L7:
        r11.setClickable(r13);
        return;
    L6:
        r11.setOnClickListener(null);
        r13 = false;
        goto L7
    }

    @Deprecated
    public static int setColorAlpha(int r10, int r11) {
        if (r11 <= 255) goto L5;
        r11 = 255;
    L8:
        return (r10 & ViewCompat.MEASURED_SIZE_MASK) | (r11 * 16777216);
    L5:
        if (r11 >= 0) goto L8;
        r11 = 0;
        goto L8
    }

    @Deprecated
    public static void setLayoutParams(View r10, int r11, int r12) {
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 != null) goto L6;
        return;
    L6:
        if (r11 == Integer.MIN_VALUE) goto L8;
        r13.width = r11;
    L8:
        if (r12 == Integer.MIN_VALUE) goto L11;
        r13.height = r12;
        return;
    }

    @Deprecated
    public static void setText(TextView r10, CharSequence r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        r10.setText(r11);
        return;
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    public static void setTextViewMaxLines(TextView r10, int r11) {
        if (r10 == null) goto L16;
        if (r11 > 0) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
    L10:
        boolean r12 = true;
        if (r11 == 1) goto L14;
        r12 = false;
    L14:
        r10.setSingleLine(r12);
        r10.setMaxLines(r11);
        return;
    L8:
        if (r10.getMaxLines() != r11) goto L10;
        return;
    }

    @Deprecated
    public static void setTopMargin(View r10, float r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        updateLayoutMargin(r10, -3, (int) TypedValue.applyDimension(1, r11, r10.getContext().getResources().getDisplayMetrics()), -3, -3);
    }

    @Deprecated
    public static void setTxtAndAdjustVisible(TextView r10, CharSequence r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        setViewVisibility(r10, 8);
        return;
    L7:
        setViewVisibility(r10, 0);
        r10.setText(r11);
    }

    @Deprecated
    public static void setViewBackgroundWithPadding(View r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = r10.getPaddingLeft();
        int r13 = r10.getPaddingRight();
        int r14 = r10.getPaddingTop();
        int r15 = r10.getPaddingBottom();
        r10.setBackgroundResource(r11);
        r10.setPadding(r12, r14, r13, r15);
    }

    @Deprecated
    public static void setViewBackgroundWithPadding(View r10, Resources r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r13 = r10.getPaddingLeft();
        int r14 = r10.getPaddingRight();
        int r15 = r10.getPaddingTop();
        int r16 = r10.getPaddingBottom();
        r10.setBackgroundColor(r11.getColor(r12));
        r10.setPadding(r13, r15, r14, r16);
    }

    public static void setViewBackgroundWithPadding(View r10, Drawable r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = r10.getPaddingLeft();
        int r13 = r10.getPaddingRight();
        int r14 = r10.getPaddingTop();
        int r15 = r10.getPaddingBottom();
        r10.setBackgroundDrawable(r11);
        r10.setPadding(r12, r14, r13, r15);
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    public static void setViewMinHeight(View r10, int r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L7;
    L9:
        r10.setMinimumHeight(r11);
        return;
    L7:
        if (r10.getMinimumHeight() != r11) goto L9;
    }

    @Deprecated
    public static final void setViewVisibility(View r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getVisibility() != r11) goto L6;
        return;
    L6:
        if (visibilityValid(r11) == false) goto L12;
        r10.setVisibility(r11);
        return;
    }

    @Deprecated
    public static float sp2px(Context r10, float r11) {
        return TypedValue.applyDimension(2, r11, r10.getResources().getDisplayMetrics());
    }

    @Deprecated
    public static void updateLayout(View r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.width != r11) goto L12;
        if (r13.height != r12) goto L12;
        return;
    L12:
        if (r11 == (-3)) goto L14;
        r13.width = r11;
    L14:
        if (r12 == (-3)) goto L16;
        r13.height = r12;
    L16:
        r10.setLayoutParams(r13);
    }

    @Deprecated
    public static void updateLayoutMargin(View r10, int r11, int r12, int r13, int r14) {
        if (r10 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        if (r15 != null) goto L8;
        return;
    L8:
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        updateMargin(r10, (ViewGroup.MarginLayoutParams) r15, r11, r12, r13, r14);
        return;
    }

    private static void updateMargin(View r10, ViewGroup.MarginLayoutParams r11, int r12, int r13, int r14, int r15) {
        if (r10 == null) goto L24;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.leftMargin != r12) goto L14;
        if (r11.topMargin != r13) goto L14;
        if (r11.rightMargin != r14) goto L14;
        if (r11.bottomMargin != r15) goto L14;
        return;
    L14:
        if (r12 == (-3)) goto L16;
        r11.leftMargin = r12;
    L16:
        if (r13 == (-3)) goto L18;
        r11.topMargin = r13;
    L18:
        if (r14 == (-3)) goto L20;
        r11.rightMargin = r14;
    L20:
        if (r15 == (-3)) goto L22;
        r11.bottomMargin = r15;
    L22:
        r10.setLayoutParams(r11);
        return;
    }

    @Deprecated
    private static boolean visibilityValid(int r10) {
        if (r10 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r10 == 8) goto L9;
        if (r10 == 4) goto L9;
        return false;
    }
}
