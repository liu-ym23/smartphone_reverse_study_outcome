package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.UserManager;
import android.provider.MediaStore;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.widget.ImageViewCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ApiCompatibilityUtils {

    private static class ApisLmr1 {
        private ApisLmr1() {
        }

        static void setAccessibilityTraversalBefore(View r10, int r11) {
            r10.setAccessibilityTraversalBefore(r11);
        }
    }

    @RequiresApi(23)
    private static class ApisM {
        private ApisM() {
        }

        public static void setStatusBarIconColor(View r10, boolean r11) {
            int r12 = r10.getSystemUiVisibility();
            if (r11 == false) goto L5;
            int r13 = r12 | 8192;
        L6:
            r10.setSystemUiVisibility(r13);
            return;
        L5:
            r13 = r12 & (-8193);
            goto L6
        }
    }

    @RequiresApi(24)
    private static class ApisN {
        private ApisN() {
        }

        static String getLocale(InputMethodSubtype r10) {
            return r10.getLanguageTag();
        }

        @RequiresApi(25)
        static boolean isDemoUser() {
            return ((UserManager) ContextUtils.getApplicationContext().getSystemService("user")).isDemoUser();
        }

        static boolean isInMultiWindowMode(Activity r10) {
            return r10.isInMultiWindowMode();
        }

        static String toHtml(Spanned r10, int r11) {
            return Html.toHtml(r10, r11);
        }
    }

    @RequiresApi(26)
    private static class ApisO {
        private ApisO() {
        }

        static Bundle createLaunchDisplayIdActivityOptions(int r10) {
            ActivityOptions r11 = ActivityOptions.makeBasic();
            r11.setLaunchDisplayId(r10);
            return r11.toBundle();
        }

        static void disableSmartSelectionTextClassifier(TextView r10) {
            r10.setTextClassifier(TextClassifier.NO_OP);
        }

        static void initNotificationSettingsIntent(Intent r10, String r11) {
            r10.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            r10.putExtra("android.provider.extra.APP_PACKAGE", r11);
        }
    }

    @RequiresApi(28)
    private static class ApisP {
        private ApisP() {
        }

        static Bitmap getBitmapByUri(ContentResolver r10, Uri r11) {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(r10, r11));
        }

        static String getProcessName() {
            return Application.getProcessName();
        }
    }

    @RequiresApi(29)
    private static class ApisQ {
        private ApisQ() {
        }

        static List<Integer> getTargetableDisplayIds(@Nullable Activity r10) {
            ArrayList r11 = new ArrayList();
            if (r10 != null) goto L5;
            return r11;
        L5:
            DisplayManager r12 = (DisplayManager) r10.getSystemService("display");
            if (r12 != null) goto L8;
            return r11;
        L8:
            Display[] r13 = r12.getDisplays();
            ActivityManager r14 = (ActivityManager) r10.getSystemService("activity");
            int r15 = r13.length;
            int r16 = 0;
        L9:
            if (r16 >= r15) goto L16;
            Display r17 = r13[r16];
            if (r17.getState() != 2) goto L15;
            if (r14.isActivityStartAllowedOnDisplay(r10, r17.getDisplayId(), new Intent(r10, r10.getClass())) == false) goto L15;
            r11.add(Integer.valueOf(r17.getDisplayId()));
        L15:
            r16 = r16 + 1;
            goto L9
        L16:
            return r11;
        }

        static boolean isRunningInUserTestHarness() {
            return ActivityManager.isRunningInUserTestHarness();
        }
    }

    private ApiCompatibilityUtils() {
    }

    public static int checkPermission(Context r10, String r11, int r12, int r13) {
        return r10.checkPermission(r11, r12, r13);
    L4:
        return -1;
    }

    public static int compareBoolean(boolean r10, boolean r11) {
        if (r10 != r11) goto L4;
        return 0;
    L4:
        if (r10 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static int compareLong(long r10, long r11) {
        if (r10 >= r11) goto L5;
        return -1;
    L5:
        if (r10 != r11) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static Bundle createLaunchDisplayIdActivityOptions(int r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return ApisO.createLaunchDisplayIdActivityOptions(r10);
    }

    public static void disableSmartSelectionTextClassifier(TextView r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        ApisO.disableSmartSelectionTextClassifier(r10);
        return;
    }

    public static Bitmap getBitmapByUri(ContentResolver r10, Uri r11) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApisP.getBitmapByUri(r10, r11);
    L7:
        return MediaStore.Images.Media.getBitmap(r10, r11);
    }

    public static byte[] getBytesUtf8(String r10) {
        return r10.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static int getColor(Resources r10, int r11) {
        return r10.getColor(r11);
    }

    public static Drawable getDrawable(Resources r10, int r11) {
        return getDrawableForDensity(r10, r11, 0);
    }

    public static Drawable getDrawableForDensity(Resources r10, int r11, int r12) {
        StrictMode.ThreadPolicy r13 = StrictMode.allowThreadDiskReads();
        if (r12 != 0) goto L7;
        Drawable r14 = r10.getDrawable(r11, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r13);
        return r14;
    L7:
        Drawable r15 = r10.getDrawableForDensity(r11, r12, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r13);
        return r15;
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(r13);
        throw th;
    }

    public static String getLocale(InputMethodSubtype r10) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.getLocale(r10);
    L7:
        return r10.getLocale();
    }

    public static Intent getNotificationSettingsIntent() {
        Intent r10 = new Intent();
        String r11 = ContextUtils.getApplicationContext().getPackageName();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ApisO.initNotificationSettingsIntent(r10, r11);
    L6:
        return r10;
    L5:
        r10.setAction("android.settings.ACTION_APP_NOTIFICATION_SETTINGS");
        r10.putExtra("app_package", r11);
        r10.putExtra("app_uid", ContextUtils.getApplicationContext().getApplicationInfo().uid);
        goto L6
    }

    static String getProcessName() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (String) Class.forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ApisP.getProcessName();
    }

    @NonNull
    public static List<Integer> getTargetableDisplayIds(Activity r10) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return ApisQ.getTargetableDisplayIds(r10);
    L7:
        return new ArrayList();
    }

    public static boolean isDemoUser() {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
    L7:
        return false;
    L5:
        if (ApisN.isDemoUser() == false) goto L7;
        return true;
    }

    public static boolean isInMultiWindowMode(Activity r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return ApisN.isInMultiWindowMode(r10);
    }

    private static boolean isPasswordInputType(int r10) {
        int r11 = r10 & 4095;
        if (r11 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r11 == 225) goto L10;
        if (r11 == 18) goto L10;
        return false;
    }

    public static boolean isRunningInUserTestHarness() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return ApisQ.isRunningInUserTestHarness();
    }

    @NonNull
    public static <T> T requireNonNull(T r10) {
        Objects.requireNonNull(r10);
        return r10;
    }

    @NonNull
    public static <T> T requireNonNull(T r10, String r11) {
        Objects.requireNonNull(r10, r11);
        return r10;
    }

    public static void setAccessibilityTraversalBefore(View r10, int r11) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        ApisLmr1.setAccessibilityTraversalBefore(r10, r11);
        return;
    }

    public static void setImageTintList(ImageView r10, @Nullable ColorStateList r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 != 21) goto L8;
        if (r11 == null) goto L8;
        if (r10.getImageTintMode() != null) goto L8;
        r10.setImageTintMode(PorterDuff.Mode.SRC_IN);
    L8:
        ImageViewCompat.setImageTintList(r10, r11);
        if (r12 != 21) goto L13;
        if (r11 != null) goto L14;
        r10.refreshDrawableState();
        return;
    L14:
        return;
    }

    public static void setPasswordEditTextContentDescription(EditText r10) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return;
    L6:
        if (isPasswordInputType(r10.getInputType()) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r10.getHint()) == true) goto L12;
        r10.setContentDescription(r10.getHint());
        return;
    }

    public static void setStatusBarColor(Window r10, int r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
    L9:
        r10.addFlags(Integer.MIN_VALUE);
    L10:
        r10.setStatusBarColor(r11);
        return;
    L5:
        if (r11 != (-16777216)) goto L9;
        if (r10.getNavigationBarColor() != (-16777216)) goto L9;
        r10.clearFlags(Integer.MIN_VALUE);
        goto L10
    }

    public static void setStatusBarIconColor(View r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        ApisM.setStatusBarIconColor(r10, r11);
        return;
    }

    public static void setTextAppearance(TextView r10, int r11) {
        r10.setTextAppearance(r10.getContext(), r11);
    }

    public static String toHtml(Spanned r10, int r11) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.toHtml(r10, r11);
    L7:
        return Html.toHtml(r10);
    }
}
