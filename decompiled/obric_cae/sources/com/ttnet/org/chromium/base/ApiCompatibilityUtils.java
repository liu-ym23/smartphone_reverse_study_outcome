package com.ttnet.org.chromium.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import android.os.UserManager;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class ApiCompatibilityUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static class FinishAndRemoveTaskWithRetry implements Runnable {
        private static final long MAX_TRY_COUNT = 3;
        private static final long RETRY_DELAY_MS = 500;
        private final Activity mActivity;
        private int mTryCount;

        public FinishAndRemoveTaskWithRetry(Activity r8) {
            this.mActivity = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mActivity.finishAndRemoveTask();
            this.mTryCount++;
            if (this.mActivity.isFinishing() == false) goto L5;
            return;
        L5:
            if (this.mTryCount >= MAX_TRY_COUNT) goto L7;
            ThreadUtils.postOnUiThreadDelayed(this, RETRY_DELAY_MS);
            return;
        L7:
            this.mActivity.finish();
        }
    }

    public static class LayerDrawableCompat extends LayerDrawable {
        private boolean mMutated;

        public LayerDrawableCompat(Drawable[] r8) {
            super(r8);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public Drawable mutate() {
            if (this.mMutated == false) goto L5;
            return this;
        L5:
            Rect[] r8 = ApiCompatibilityUtils.access$000(this);
            Drawable r10 = super.mutate();
            if (r10 == this) goto L8;
            return r10;
        L8:
            ApiCompatibilityUtils.access$100(this, r8);
            this.mMutated = true;
            return this;
        }
    }

    public static class TransitionDrawableCompat extends TransitionDrawable {
        private boolean mMutated;

        public TransitionDrawableCompat(Drawable[] r8) {
            super(r8);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public Drawable mutate() {
            if (this.mMutated == false) goto L5;
            return this;
        L5:
            Rect[] r8 = ApiCompatibilityUtils.access$000(this);
            Drawable r10 = super.mutate();
            if (r10 == this) goto L8;
            return r10;
        L8:
            ApiCompatibilityUtils.access$100(this, r8);
            this.mMutated = true;
            return this;
        }
    }

    private ApiCompatibilityUtils() {
    }

    public static /* synthetic */ Rect[] access$000(LayerDrawable r8) {
        return getLayersBounds(r8);
    }

    public static /* synthetic */ void access$100(LayerDrawable r8, Rect[] r10) {
        restoreLayersBounds(r8, r10);
    }

    public static int checkPermission(Context r8, String r10, int r11, int r12) {
        return r8.checkPermission(r10, r11, r12);
    L4:
        return -1;
    }

    public static int compareBoolean(boolean r8, boolean r10) {
        if (r8 != r10) goto L4;
        return 0;
    L4:
        if (r8 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static int compareLong(long r8, long r10) {
        if (r8 >= r10) goto L5;
        return -1;
    L5:
        if (r8 != r10) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static Bundle createLaunchDisplayIdActivityOptions(int r8) {
        ActivityOptions r10 = ActivityOptions.makeBasic();
        r10.setLaunchDisplayId(r8);
        return r10.toBundle();
    }

    public static LayerDrawable createLayerDrawable(Drawable[] r8) {
        return new LayerDrawable(r8);
    }

    public static TransitionDrawable createTransitionDrawable(Drawable[] r8) {
        return new TransitionDrawable(r8);
    }

    @TargetApi(26)
    public static void disableSmartSelectionTextClassifier(TextView r8) {
        r8.setTextClassifier(TextClassifier.NO_OP);
    }

    public static void finishAfterTransition(Activity r8) {
        r8.finishAfterTransition();
    }

    public static void finishAndRemoveTask(Activity r8) {
        r8.finishAndRemoveTask();
    }

    public static int getActivityNewDocumentFlag() {
        return 524288;
    }

    public static long getAvailableBlocks(StatFs r8) {
        return r8.getAvailableBlocksLong();
    }

    public static long getBlockCount(StatFs r8) {
        return r8.getBlockCountLong();
    }

    public static long getBlockSize(StatFs r8) {
        return r8.getBlockSizeLong();
    }

    public static byte[] getBytesUtf8(String r8) {
        return r8.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new IllegalStateException("UTF-8 encoding not available.", e);
    }

    public static int getColor(Resources r8, int r10) {
        return r8.getColor(r10, null);
    }

    public static ColorFilter getColorFilter(Drawable r8) {
        return r8.getColorFilter();
    }

    public static Drawable getDrawable(Resources r8, int r10) {
        StrictMode.ThreadPolicy r11 = StrictMode.allowThreadDiskReads();
        Drawable r12 = r8.getDrawable(r10, null);     // Catch: Throwable -> L6
        StrictMode.setThreadPolicy(r11);
        return r12;
    L6:
        th = move-exception;
        StrictMode.setThreadPolicy(r11);
        throw th;
    }

    public static Drawable getDrawableForDensity(Resources r8, int r10, int r11) {
        return r8.getDrawableForDensity(r10, r11, null);
    }

    private static Rect[] getLayersBounds(LayerDrawable r8) {
        Rect[] r10 = new Rect[r8.getNumberOfLayers()];
        int r11 = 0;
    L4:
        if (r11 >= r8.getNumberOfLayers()) goto L6;
        r10[r11] = r8.getDrawable(r11).getBounds();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public static String getLocale(InputMethodSubtype r8) {
        return r8.getLanguageTag();
    }

    public static Intent getNotificationSettingsIntent(Context r8) {
        Intent r10 = new Intent();
        r10.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        r10.putExtra("android.provider.extra.APP_PACKAGE", r8.getPackageName());
        return r10;
    }

    public static Uri getUriForDownloadedFile(File r8) {
        return FileUtils.getUriForFile(r8);
    }

    public static Drawable getUserBadgedDrawableForDensity(Context r8, Drawable r10, Rect r11, int r12) {
        return r8.getPackageManager().getUserBadgedDrawableForDensity(r10, Process.myUserHandle(), r11, r12);
    }

    public static Drawable getUserBadgedIcon(Context r8, int r10) {
        Drawable r11 = getDrawable(r8.getResources(), r10);
        return r8.getPackageManager().getUserBadgedIcon(r11, Process.myUserHandle());
    }

    public static boolean isDemoUser(Context r8) {
        return ((UserManager) r8.getSystemService("user")).isDemoUser();
    }

    public static boolean isElevationSupported() {
        return true;
    }

    public static boolean isInMultiWindowMode(Activity r8) {
        return r8.isInMultiWindowMode();
    }

    public static boolean isInteractive(Context r8) {
        return ((PowerManager) r8.getSystemService("power")).isInteractive();
    }

    private static boolean isPasswordInputType(int r8) {
        int r10 = r8 & 4095;
        if (r10 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r10 == 225) goto L10;
        if (r10 == 18) goto L10;
        return false;
    }

    public static boolean isPrintingSupported() {
        return true;
    }

    public static <T> T requireNonNull(T r8) {
        if (r8 == null) goto L5;
        return r8;
    L5:
        throw null;
    }

    private static void restoreLayersBounds(LayerDrawable r8, Rect[] r10) {
        int r11 = 0;
    L4:
        if (r11 >= r8.getNumberOfLayers()) goto L6;
        r8.getDrawable(r11).setBounds(r10[r11]);
        r11 = r11 + 1;
        goto L4
    }

    public static void setAccessibilityTraversalBefore(View r8, int r10) {
        r8.setAccessibilityTraversalBefore(r10);
    }

    @TargetApi(21)
    public static boolean setElevation(View r8, float r10) {
        if (isElevationSupported() == true) goto L6;
        return false;
    L6:
        r8.setElevation(r10);
        return true;
    }

    public static void setImageTintList(ImageView r8, ColorStateList r10) {
        androidx.core.widget.f.c(r8, r10);
    }

    public static void setPasswordEditTextContentDescription(EditText r8) {
    }

    public static void setStatusBarColor(Window r8, int r10) {
        r8.addFlags(Integer.MIN_VALUE);
        r8.setStatusBarColor(r10);
    }

    public static void setStatusBarIconColor(View r8, boolean r10) {
        int r11 = r8.getSystemUiVisibility();
        if (r10 == false) goto L5;
        int r12 = r11 | 8192;
    L6:
        r8.setSystemUiVisibility(r12);
        return;
    L5:
        r12 = r11 & (-8193);
        goto L6
    }

    public static void setTaskDescription(Activity r8, String r10, Bitmap r11, int r12) {
        r8.setTaskDescription(new ActivityManager.TaskDescription(r10, r11, r12));
    }

    public static void setTextAppearance(TextView r8, int r10) {
        r8.setTextAppearance(r10);
    }

    public static void setWindowIndeterminateProgress(Window r8) {
    }

    public static boolean shouldSkipFirstUseHints(ContentResolver r8) {
        if (Settings.Secure.getInt(r8, "skip_first_use_hints", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static String toHtml(Spanned r8, int r10) {
        return Html.toHtml(r8, r10);
    }

    public static <T> T requireNonNull(T r8, String r10) {
        if (r8 == null) goto L5;
        return r8;
    L5:
        throw new NullPointerException(r10);
    }

    @TargetApi(21)
    public static boolean setElevation(PopupWindow r8, float r10) {
        if (isElevationSupported() == true) goto L6;
        return false;
    L6:
        r8.setElevation(r10);
        return true;
    }
}
