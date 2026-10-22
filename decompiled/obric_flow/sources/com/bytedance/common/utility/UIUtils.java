package com.bytedance.common.utility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class UIUtils {
    public static final boolean API_ET_20 = false;
    private static final int BURY_WIDTH_DP = 20;
    public static final char ELLIPSIS_CHAR = 8230;
    private static final float FLOAT_BIAS = 0.5f;
    private static final float FLOAT_DOT999 = 0.999f;
    public static final int LAYOUT_PARAMS_KEEP_OLD = -3;
    private static final int MASK_1000 = 16777216;
    private static final int MASK_FF = 255;
    private static final int MASK_FFFF = 16777215;
    private static final int MAX_COUNT = 10000;
    private static final int MAX_WIDTH = 1375;
    private static int mDpi;
    private static String sScreenResolution;
    public static i sTempEllipsisResult;
    private static j sToastHook;

    static {
        API_ET_20 = true;
        sScreenResolution = "";
        mDpi = -1;
        sTempEllipsisResult = new i();
    }

    private UIUtils() {
    }

    public static /* synthetic */ void access$000(Context r5, int r10, String r11, int r12, int r13) {
        displayToastInternal(r5, r10, r11, r12, r13);
    }

    public static void assertInUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return;
    L5:
        Logger.alertErrorInfo("not in UI thread");
    }

    public static boolean clearAnimation(View r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.getAnimation() == null) goto L10;
        r5.clearAnimation();
        return true;
    L10:
        return false;
    }

    public static void detachFromParent(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getParent() == null) goto L17;
        ViewParent r10 = r5.getParent();
        if ((r10 instanceof ViewGroup) == true) goto L14;
        return;
    L14:
        ((ViewGroup) r10).removeView(r5);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Logger.throwException(e);
        return;
    }

    public static float dip2Px(Context r5, float r10) {
        if (r5 != null) goto L4;
        return 0.0f;
    L4:
        return (r10 * r5.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static void displayLongTimeToast(Context r5, int r10, int r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r12 = r5.getString(r11);
        if (b.b(r12) == false) goto L7;
        return;
    L7:
        displayToastInternal(r5, r10, r12, 1, 17);
    }

    public static void displayToast(Context r5, String r10) {
        displayToast(r5, 0, r10);
    }

    private static void displayToastInternal(Context r10, int r11, String r12, int r13, int r14) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (b.b(r12) == false) goto L7;
        return;
    L7:
        if (isInUIThread() == true) goto L16;
        new Handler(Looper.getMainLooper()).post(new g(r10, r11, r12, r13, r14));
        return;
    L16:
        Toast r15 = Toast.makeText(r10, r12, r13);     // Catch: Exception -> L13
        if (r15 == null) goto L20;
        r15.setGravity(r14, 0, 0);     // Catch: Exception -> L13
        r15.show();     // Catch: Exception -> L13
        return;
    L20:
        return;
    L13:
        e = move-exception;
        Logger.throwException(e);
    }

    public static void displayToastWithIcon(Context r5, int r10, int r11) {
        displayToast(r5, r10, r5.getString(r11));
    }

    public static void ellipseSingleLineStr(String r10, int r11, Paint r12, int r13, i r14) {
        if (r11 > r13) goto L4;
    L16:
        r14.getClass();
        return;
    L4:
        if (b.b(r10) == true) goto L16;
        if (floatToIntBig(r12.measureText(r10)) > r11) goto L10;
        r14.getClass();
        return;
    L10:
        int r15 = r12.breakText(r10, 0, r10.length(), true, r11 - r13, null);
        if (r15 >= 1) goto L14;
        r14.getClass();
        return;
    L14:
        r10.substring(0, r15);
        r14.getClass();
    }

    public static void expandClickRegion(View r10, int r11, int r12, int r13, int r14) {
        r10.post(new h(r10, r12, r14, r11, r13));
    }

    public static int floatToIntBig(float r5) {
        return (int) (r5 + FLOAT_DOT999);
    }

    public static int getDiggBuryWidth(Context r5) {
        return ((r5.getResources().getDisplayMetrics().widthPixels * MAX_WIDTH) / 10000) + ((int) dip2Px(r5, 20.0f));
    }

    public static String getDisplayCount(int r5) {
        if (r5 <= 10000) goto L11;
        String r10 = String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf((((double) r5) * 1.0d) / 10000.0d)});
        if ('0' != r10.charAt(r10.length() - 1)) goto L9;
        return r10.substring(0, r10.length() - 2) + "万";
    L9:
        return r10.concat("万");
    L11:
        return String.valueOf(r5);
    }

    public static int getDpi(Context r5) {
        if (mDpi != (-1)) goto L7;
        if (r5 == null) goto L7;
        mDpi = r5.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L7:
        return mDpi;
    }

    public static int getIndexInParent(View r5) {
        if (r5 != null) goto L5;
    L11:
        return -1;
    L5:
        if (r5.getParent() == null) goto L11;
        ViewParent r10 = r5.getParent();
        if ((r10 instanceof ViewGroup) == false) goto L11;
        return ((ViewGroup) r10).indexOfChild(r5);
    }

    public static int[] getLocationInAncestor(View r10, View r11) {
        if (r10 == null) goto L16;
        if (r11 == null) goto L16;
        float[] r5 = {0.0f, 0.0f};
        r5[0] = 0.0f + r10.getLeft();
        r5[1] = r5[1] + r10.getTop();
        ViewParent r12 = r10.getParent();
    L8:
        if ((r12 instanceof View) == false) goto L14;
        View r13 = (View) r12;
        if (r12 == r11) goto L12;
        r5[0] = r5[0] - r13.getScrollX();
        r5[1] = r5[1] - r13.getScrollY();
        r5[0] = r5[0] + r13.getLeft();
        r5[1] = r5[1] + r13.getTop();
        r12 = r13.getParent();
        goto L8
    L12:
        return new int[]{(int) (r5[0] + 0.5f), (int) (r5[1] + 0.5f)};
    L14:
        Logger.alertErrorInfo("ancestorView:" + r11 + " is not the ancestor of child : " + r10);
        return null;
    L16:
        Logger.alertErrorInfo("invalid params: child:" + r10 + ",ancestor:" + r11);
        return null;
    }

    public static void getLocationInUpView(View r5, View r10, int[] r11, boolean r12) {
        if (r5 == null) goto L13;
        if (r10 == null) goto L14;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.length < 2) goto L16;
        r5.getLocationInWindow(r11);
        int r13 = r11[0];
        int r14 = r11[1];
        r10.getLocationInWindow(r11);
        int r15 = r11[0] - r13;
        int r16 = r11[1] - r14;
        if (r12 == false) goto L11;
        int r17 = r10.getWidth();
        r15 = r15 + (r17 / 2);
        r16 = r16 + (r10.getHeight() / 2);
    L11:
        r11[0] = r15;
        r11[1] = r16;
        return;
    L16:
        return;
    L14:
        return;
    }

    public static int getRatioOfScreen(Context r5, float r10) {
        DisplayMetrics r11 = r5.getResources().getDisplayMetrics();
        if (r11 != null) goto L7;
        return 0;
    L7:
        return (int) (r11.widthPixels * r10);
    }

    public static int getScreenHeight(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r10 = r5.getResources().getDisplayMetrics();
        if (r10 != null) goto L9;
        return 0;
    L9:
        return r10.heightPixels;
    }

    public static String getScreenResolution(Context r5) {
        if (b.b(sScreenResolution) == false) goto L10;
        if (r5 == null) goto L10;
        int r10 = getScreenWidth(r5);
        int r11 = getScreenHeight(r5);
        if (r10 <= 0) goto L10;
        if (r11 <= 0) goto L10;
        sScreenResolution = r10 + XPath.WILDCARD + r11;
    L10:
        return sScreenResolution;
    }

    public static int getScreenWidth(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r10 = r5.getResources().getDisplayMetrics();
        if (r10 != null) goto L9;
        return 0;
    L9:
        return r10.widthPixels;
    }

    public static int getStatusBarHeight(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r10 = r5.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r10 > 0) goto L8;
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r10);
    }

    public static boolean isInUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isViewVisible(View r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int px2dip(Context r5, float r10) {
        if (r5 != null) goto L4;
        return 0;
    L4:
        return (int) ((r10 / r5.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void requestOrienation(Activity r5, boolean r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isFinishing() == true) goto L13;
        r5.setRequestedOrientation(!r10 ? 1 : 0);
        if (r10 == false) goto L9;
        r5.getWindow().setFlags(1024, 1024);
        return;
    L9:
        r5.getWindow().clearFlags(1024);
        return;
    }

    public static void setClickListener(boolean r5, View r10, View.OnClickListener r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r5 == false) goto L6;
        r10.setOnClickListener(r11);
        r10.setClickable(true);
        return;
    L6:
        r10.setOnClickListener(null);
        r10.setClickable(false);
    }

    public static int setColorAlpha(int r5, int r10) {
        if (r10 <= 255) goto L5;
        r10 = 255;
    L8:
        return (r5 & 16777215) | (r10 * 16777216);
    L5:
        if (r10 >= 0) goto L8;
        r10 = 0;
        goto L8
    }

    public static void setLayoutParams(View r5, int r10, int r11) {
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        if (r12 != null) goto L6;
        return;
    L6:
        if (r10 == Integer.MIN_VALUE) goto L8;
        r12.width = r10;
    L8:
        if (r11 == Integer.MIN_VALUE) goto L11;
        r12.height = r11;
        return;
    }

    public static void setText(TextView r5, CharSequence r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r5.setText(r10);
        return;
    }

    @SuppressLint({"NewApi"})
    public static void setTextViewMaxLines(TextView r5, int r10) {
        if (r5 == null) goto L14;
        if (r10 > 0) goto L6;
        return;
    L6:
        if (r5.getMaxLines() != r10) goto L8;
        return;
    L8:
        boolean r11 = true;
        if (r10 == 1) goto L12;
        r11 = false;
    L12:
        r5.setSingleLine(r11);
        r5.setMaxLines(r10);
        return;
    }

    public static void setToastHook(j r5) {
    }

    public static void setTopMargin(View r5, float r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        updateLayoutMargin(r5, -3, (int) TypedValue.applyDimension(1, r10, r5.getContext().getResources().getDisplayMetrics()), -3, -3);
    }

    public static void setTxtAndAdjustVisible(TextView r5, CharSequence r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        setViewVisibility(r5, 8);
        return;
    L7:
        setViewVisibility(r5, 0);
        r5.setText(r10);
    }

    public static void setViewBackgroundWithPadding(View r5, int r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r11 = r5.getPaddingLeft();
        int r12 = r5.getPaddingRight();
        int r13 = r5.getPaddingTop();
        int r14 = r5.getPaddingBottom();
        r5.setBackgroundResource(r10);
        r5.setPadding(r11, r13, r12, r14);
    }

    @SuppressLint({"NewApi"})
    public static void setViewMinHeight(View r5, int r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getMinimumHeight() != r10) goto L7;
        return;
    L7:
        r5.setMinimumHeight(r10);
    }

    public static void setViewVisibility(View r5, int r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getVisibility() != r10) goto L6;
        return;
    L6:
        if (visibilityValid(r10) == false) goto L12;
        r5.setVisibility(r10);
        return;
    }

    public static float sp2px(Context r5, float r10) {
        if (r5 != null) goto L4;
        return 0.0f;
    L4:
        return TypedValue.applyDimension(2, r10, r5.getResources().getDisplayMetrics());
    }

    public static void updateLayout(View r5, int r10, int r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.width != r10) goto L12;
        if (r12.height != r11) goto L12;
        return;
    L12:
        if (r10 == (-3)) goto L14;
        r12.width = r10;
    L14:
        if (r11 == (-3)) goto L16;
        r12.height = r11;
    L16:
        r5.setLayoutParams(r12);
    }

    public static void updateLayoutMargin(View r10, int r11, int r12, int r13, int r14) {
        if (r10 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r5 = r10.getLayoutParams();
        if (r5 != null) goto L8;
        return;
    L8:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        updateMargin(r10, (ViewGroup.MarginLayoutParams) r5, r11, r12, r13, r14);
        return;
    }

    private static void updateMargin(View r5, ViewGroup.MarginLayoutParams r10, int r11, int r12, int r13, int r14) {
        if (r5 == null) goto L25;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.leftMargin != r11) goto L15;
        if (r10.topMargin != r12) goto L15;
        if (r10.rightMargin != r13) goto L15;
        if (r10.bottomMargin != r14) goto L15;
        return;
    L15:
        if (r11 == (-3)) goto L17;
        r10.leftMargin = r11;
    L17:
        if (r12 == (-3)) goto L19;
        r10.topMargin = r12;
    L19:
        if (r13 == (-3)) goto L21;
        r10.rightMargin = r13;
    L21:
        if (r14 == (-3)) goto L23;
        r10.bottomMargin = r14;
    L23:
        r5.setLayoutParams(r10);
        return;
    }

    private static boolean visibilityValid(int r5) {
        if (r5 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r5 == 8) goto L9;
        if (r5 == 4) goto L9;
        return false;
    }

    public static void displayToast(Context r5, int r10) {
        displayToast(r5, r5.getString(r10));
    }

    public static void displayToastWithIcon(Context r5, int r10, String r11) {
        displayToast(r5, r10, r11);
    }

    public static void displayToast(Context r5, int r10, int r11) {
        displayToast(r5, r5.getString(r10), r11);
    }

    public static void displayToast(Context r5, String r10, int r11) {
        displayToastInternal(r5, 0, r10, 0, r11);
    }

    public static void displayToast(Context r5, int r10, String r11) {
        displayToastInternal(r5, r10, r11, 0, 17);
    }

    public static void setViewBackgroundWithPadding(View r5, Resources r10, int r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r12 = r5.getPaddingLeft();
        int r13 = r5.getPaddingRight();
        int r14 = r5.getPaddingTop();
        int r15 = r5.getPaddingBottom();
        r5.setBackgroundColor(r10.getColor(r11));
        r5.setPadding(r12, r14, r13, r15);
    }

    public static void setViewBackgroundWithPadding(View r5, Drawable r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r11 = r5.getPaddingLeft();
        int r12 = r5.getPaddingRight();
        int r13 = r5.getPaddingTop();
        int r14 = r5.getPaddingBottom();
        r5.setBackgroundDrawable(r10);
        r5.setPadding(r11, r13, r12, r14);
    }
}
