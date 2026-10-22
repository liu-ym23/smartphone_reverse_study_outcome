package com.larksuite.framework.utils;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UIUtils {
    private static final String TAG = "UIUtils";
    private static int navigationHeight = -1;
    private static int realScreenHeight;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Context b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            float r0 = UIUtils.getScreenHeight(this.b) / 3.0f;
            int[] r1 = new int[2];
            this.a.getLocationOnScreen(r1);
            this.a.setTranslationY(r0 - (r1[1] - this.a.getTranslationY()));
            return false;
        }

        public a(View r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public UIUtils() {
    }

    public static boolean canShowSkeleton() {
        return !RomUtils.n[0].equals(RomUtils.e().a);
    }

    public static View INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static RectF calcViewScreenLocation(View r7) {
        int[] r0 = new int[2];
        r7.getLocationOnScreen(r0);
        int r2 = r0[0];
        return new RectF(r2, r0[1], r2 + r7.getWidth(), r0[1] + r7.getHeight());
    }

    public static boolean canLoadImage(Context r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if ((r1 instanceof Activity) == true) goto L8;
        return true;
    L8:
        return isActivityRunningInner((Activity) r1);
    }

    public static void disableAllParentClipChild(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getParent() == null) goto L12;
        Object r3 = r2.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L11;
        ViewGroup r0 = (ViewGroup) r3;
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        disableAllParentClipChild((View) r3);
        return;
    L11:
        return;
    }

    public static void disableGrandParentClipChild(View r1) {
        ViewParent r2 = r1.getParent();
        if (r2 == null) goto L10;
        ViewParent r3 = r2.getParent();
        if (r3 != null) goto L7;
        return;
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r3).setClipChildren(false);
        return;
    L12:
        return;
    }

    public static Activity getActivityFromContext(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof Activity) == true) goto L7;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L7:
        return (Activity) r1;
    L9:
        return null;
    }

    public static Activity getActivityFromView(View r0) {
        return getActivityFromContext(r0.getContext());
    }

    public static AssetManager getAssets(Context r0) {
        return getResources(r0).getAssets();
    }

    public static DisplayMetrics getDisplayMetrics(Context r0) {
        return INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources(r0));
    }

    public static int getHeight(View r2) {
        if (r2 == null) goto L6;
        r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r2.getMeasuredHeight();
    L6:
        return 0;
    }

    public static int getNavigationBarHeight(Context r3) {
        int r0 = navigationHeight;
        if (r0 != (-1)) goto L10;
        Resources r4 = r3.getResources();
        int r1 = r4.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r1 <= 0) goto L8;
        int r5 = r4.getDimensionPixelSize(r1);
        navigationHeight = r5;
        return r5;
    L8:
        return 0;
    L10:
        return r0;
    }

    public static Resources getResources(Context r0) {
        return r0.getResources();
    }

    public static int getScaledTouchSlop(Context r0) {
        return ViewConfiguration.get(r0).getScaledTouchSlop();
    }

    public static int getScreenHeight(Context r1) {
        int r0 = realScreenHeight;
        if (r0 != 0) goto L6;
        Display r2 = ((WindowManager) r1.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics r3 = new DisplayMetrics();
        r2.getRealMetrics(r3);
        int r4 = r3.heightPixels;
        realScreenHeight = r4;
        return r4;
    L6:
        return r0;
    }

    public static int getScreenOrientation(Context r0) {
        return r0.getResources().getConfiguration().orientation;
    }

    public static int getWidth(View r2) {
        if (r2 == null) goto L6;
        r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r2.getMeasuredWidth();
    L6:
        return 0;
    }

    public static void hide(View r1) {
        if (r1 == null) goto L5;
        r1.setVisibility(8);
        return;
    }

    public static void invisible(View r1) {
        if (r1 == null) goto L5;
        r1.setVisibility(4);
        return;
    }

    public static boolean isActivityRunning(Activity r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return isActivityRunningInner(r0);
    }

    private static boolean isActivityRunningInner(Activity r1) {
        if (r1.isDestroyed() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.isFinishing() == true) goto L7;
        return true;
    }

    public static boolean isVisible(View r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean performParentLongClick(View r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        ViewParent r4 = r3.getParent();
    L6:
        if (r4 == null) goto L14;
        if ((r4 instanceof ViewGroup) == false) goto L14;
        ViewGroup r1 = (ViewGroup) r4;
        if (r1.isLongClickable() == true) goto L11;
        r4 = r4.getParent();
        goto L6
    L11:
        r1.performLongClick();
        return true;
    L14:
        return false;
    }

    public static void setStatusBarTransparent(Context r2) {
        Activity r3 = (Activity) r2;
        INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3.getWindow()).setSystemUiVisibility(1280);
        r3.getWindow().setStatusBarColor(0);
        com.ss.android.lark.insets.h r4 = WindowInsetsUtils.c(r3);
        r4.b(0);
        r4.c(false);
    }

    public static void setViewOnScreenOneThirdPlaceByTranslationY(View r3) {
        Context r0 = r3.getContext();
        r3.getViewTreeObserver().addOnPreDrawListener(new a(r3, r0));
    }

    public static void show(View r1) {
        if (r1 == null) goto L5;
        r1.setVisibility(0);
        return;
    }

    public static void display(View r0, boolean r1) {
        if (r1 == false) goto L4;
        show(r0);
        return;
    L4:
        hide(r0);
    }

    public static int dp2px(Context r0, float r1) {
        return (int) ((r1 * INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).density) + 0.5f);
    }

    public static <T extends View> T findViewById(View r0, int r1) {
        return (T) r0.findViewById(r1);
    }

    public static int getAlphaColor(int r3, double r4) {
        if (r4 < 0.0d) goto L9;
        if (r4 > 1.0d) goto L9;
        return ColorUtils.setAlphaComponent(r3, (int) (r4 * 255.0d));
    L9:
        throw new IllegalArgumentException();
    }

    public static int getColor(Context r0, int r1) {
        return getResources(r0).getColor(r1);
    }

    public static ColorStateList getColorStateList(Context r0, int r1) {
        return getResources(r0).getColorStateList(r1);
    }

    public static Drawable getCompatDrawable(Context r0, int r1) {
        return AppCompatResources.getDrawable(r0, r1);
    }

    public static int getDimens(Context r0, int r1) {
        return getResources(r0).getDimensionPixelSize(r1);
    }

    public static Drawable getDrawable(Context r0, int r1) {
        return AppCompatResources.getDrawable(r0, r1);
    }

    public static void getScreenShot(Activity r1, IGetDataCallback<Bitmap> r2) {
        int r0 = d0.a;
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "callback");
        d0.a(((ViewGroup) r1.findViewById(R.id.content)).getRootView(), r1.getWindow(), r2);
    }

    public static String getString(Context r0, int r1) {
        return getResources(r0).getString(r1);
    }

    public static String[] getStringArray(Context r0, int r1) {
        return getResources(r0).getStringArray(r1);
    }

    public static View inflate(Context r1, int r2) {
        return LayoutInflater.from(r1).inflate(r2, null);
    }

    public static boolean isActivityAlive(Context r3, String r4) {
        ActivityManager r5 = (ActivityManager) r3.getSystemService("activity");
        if (r5 != null) goto L5;
        return false;
    L5:
        List<ActivityManager.RunningTaskInfo> r6 = r5.getRunningTasks(100);
        if (q.a(r6) == false) goto L8;
        return false;
    L8:
        Iterator<ActivityManager.RunningTaskInfo> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L24;
        ActivityManager.RunningTaskInfo r1 = r7.next();
        if (r1 == null) goto L10;
        ComponentName r2 = r1.topActivity;
        if (r2 != null) goto L17;
    L18:
        ComponentName r8 = r1.baseActivity;
        if (r8 == null) goto L10;
        if (r8.toString().contains(r4) == false) goto L10;
    L22:
        Log.i(TAG, r1.topActivity.getPackageName() + " info.baseActivity.getPackageName()=" + r1.baseActivity.getPackageName());
        return true;
    L17:
        if (r2.toString().contains(r4) == true) goto L22;
    L24:
        return false;
    }

    public static AssetFileDescriptor openRawResourceFd(Context r0, int r1) {
        return getResources(r0).openRawResourceFd(r1);
    }

    public static int px2dp(Context r0, float r1) {
        return (int) ((r1 / INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).density) + 0.5f);
    }

    public static int px2sp(Context r0, int r1) {
        return (int) ((r1 / INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).scaledDensity) + 0.5f);
    }

    public static void setForegroundAlpha(Activity r1, float r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        Window r3 = r1.getWindow();
        if (r3 != null) goto L7;
        return;
    L7:
        WindowManager.LayoutParams r0 = r3.getAttributes();
        r0.alpha = r2;
        r3.setAttributes(r0);
    }

    public static void setTextStyle(TextView r2, int r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        r2.setTextAppearance(r2.getContext(), r3);
        return;
    L5:
        r2.setTextAppearance(r3);
    }

    public static boolean setTextViewCursorDrawable(TextView r2, Drawable r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 <= 28) goto L7;
        r2.setTextCursorDrawable(r3);
        r2.invalidate();
        return true;
    L7:
        return setTextViewEditorDrawable(r0, r2, r3);
    }

    public static boolean setTextViewEditorDrawable(TextView r1, Drawable r2) {
        return setTextViewEditorDrawable(Build.VERSION.SDK_INT, r1, r2);
    }

    public static float sp2px(Context r0, float r1) {
        return r1 * INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).scaledDensity;
    }

    public static Bitmap toRoundCorner(Bitmap r7, float r8) {
        Bitmap r0 = Bitmap.createBitmap(r7.getWidth(), r7.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        Paint r2 = new Paint();
        Rect r3 = new Rect(0, 0, r7.getWidth(), r7.getHeight());
        RectF r4 = new RectF(r3);
        r2.setAntiAlias(true);
        r1.drawARGB(0, 0, 0, 0);
        r2.setColor(-12434878);
        r1.drawRoundRect(r4, r8, r8, r2);
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r1.drawBitmap(r7, r3, r3, r2);
        return r0;
    }

    public static String getQuantityString(Context r3, int r4, int r5) {
        return getResources(r3).getQuantityString(r4, r5, new Object[]{Integer.valueOf(r5)});
    }

    public static void getScreenViewShot(View r0, Window r1, IGetDataCallback<Bitmap> r2) {
        d0.a(r0, r1, r2);
    }

    public static String getString(Context r0, int r1, Object... r2) throws Resources.NotFoundException {
        return getResources(r0).getString(r1, r2);
    }

    public static View inflate(Context r0, int r1, ViewGroup r2) {
        return LayoutInflater.from(r0).inflate(r1, r2);
    }

    public static void setForegroundDrawable(Activity r3, float r4, Drawable r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        Window r6 = r3.getWindow();
        if (r6 != null) goto L7;
        return;
    L7:
        View r0 = INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r6);
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r0.setForeground(r5);
        return;
    L10:
        WindowManager.LayoutParams r7 = r6.getAttributes();
        r7.alpha = r4;
        r6.setAttributes(r7);
    }

    public static boolean setTextViewCursorColor(Context r5, TextView r6, int r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 <= 28) goto L17;
        Drawable r8 = r6.getTextCursorDrawable();
        if (r8 != null) goto L7;
        return false;
    L7:
        r8.setColorFilter(new BlendModeColorFilter(r7, BlendMode.SRC_IN));
        r6.setTextCursorDrawable(r8);
        r6.invalidate();
        return true;
    L17:
        Field r1 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L14
        r1.setAccessible(true);     // Catch: Exception -> L14
        Drawable r9 = AppCompatResources.getDrawable(r5, r1.getInt(r6));     // Catch: Exception -> L14
        if (r9 != null) goto L12;
        return false;
    L12:
        r9.setColorFilter(new PorterDuffColorFilter(r7, PorterDuff.Mode.SRC_IN));     // Catch: Exception -> L14
        return setTextViewEditorDrawable(r0, r6, r9);
    L14:
        e = move-exception;
        Log.d(TAG, "setTextViewCursorColor: " + e.getMessage());
        return false;
    }

    private static boolean setTextViewEditorDrawable(int r4, TextView r5, Drawable r6) {
        if (r4 <= 28) goto L16;
        return setTextViewCursorDrawable(r5, r6);
    L16:
        Field r2 = TextView.class.getDeclaredField("mEditor");     // Catch: Exception -> L13
        r2.setAccessible(true);     // Catch: Exception -> L13
        Object r3 = r2.get(r5);     // Catch: Exception -> L13
        if (r4 != 28) goto L10;
        Field r7 = TextView.class.getDeclaredField("mDrawableForCursor");     // Catch: Exception -> L13
        r7.setAccessible(true);     // Catch: Exception -> L13
        r7.set(r3, r6);     // Catch: Exception -> L13
    L11:
        r5.invalidate();     // Catch: Exception -> L13
        return true;
    L10:
        Field r8 = TextView.class.getDeclaredField("mCursorDrawable");     // Catch: Exception -> L13
        r8.setAccessible(true);     // Catch: Exception -> L13
        r8.set(r3, new Drawable[]{r6, r6});     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "setTextViewEditorDrawable: " + e.getMessage());
        return false;
    }

    public static void setViewLayoutParam(ViewGroup r1, int r2, int r3) {
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = r2;
        r0.height = r3;
        r1.setLayoutParams(r0);
    }

    public static void showByStatus(TextView r0, String r1, boolean r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        if (r2 == false) goto L6;
        r0.setText(r1);
        r0.setVisibility(0);
        return;
    L6:
        r0.setVisibility(8);
    }

    public static Bitmap getBitmapFromLayout(Context r2, int r3, int r4, int r5) {
        View r6 = LayoutInflater.from(r2).inflate(r3, null, false);
        r6.measure(View.MeasureSpec.makeMeasureSpec(r4, 1073741824), View.MeasureSpec.makeMeasureSpec(r5, 1073741824));
        r6.layout(0, 0, r4, r5);
        Bitmap r7 = Bitmap.createBitmap(r4, r5, Bitmap.Config.ARGB_8888);
        r6.draw(new Canvas(r7));
        return r7;
    }

    public static Drawable getDrawableFromLayout(Context r2, int r3, int r4, int r5) {
        return new BitmapDrawable(r2.getResources(), getBitmapFromLayout(r2, r3, r4, r5));
    }

    public static void setMargins(View r1, int r2, int r3, int r4, int r5) {
        if ((r1.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r1.getLayoutParams()).setMargins(r2, r3, r4, r5);
        r1.requestLayout();
        return;
    }
}
