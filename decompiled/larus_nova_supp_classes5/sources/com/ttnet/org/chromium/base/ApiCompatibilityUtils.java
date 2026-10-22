package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.ImageViewCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import el9.a;
import f06.b;
import f06.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.IntCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ApiCompatibilityUtils {
    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static int compareBoolean(boolean r0, boolean r1) {
        if (r0 != r1) goto L4;
        return 0;
    L4:
        if (r0 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static int compareLong(long r1, long r3) {
        if (r1 >= r3) goto L5;
        return -1;
    L5:
        if (r1 != r3) goto L7;
        return 0;
    L7:
        return 1;
    }

    private static boolean isPasswordInputType(int r1) {
        int r2 = r1 & 4095;
        if (r2 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 225) goto L10;
        if (r2 == 18) goto L10;
        return false;
    }

    public static Intent getNotificationSettingsIntent() {
        Intent r0 = new Intent();
        String r1 = ContextUtils.getApplicationContext().getPackageName();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ApisO.initNotificationSettingsIntent(r0, r1);
    L6:
        return r0;
    L5:
        r0.setAction("android.settings.ACTION_APP_NOTIFICATION_SETTINGS");
        r0.putExtra("app_package", r1);
        r0.putExtra("app_uid", ContextUtils.getApplicationContext().getApplicationInfo().uid);
        goto L6
    }

    public static String getProcessName() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (String) INVOKESTATIC_com_ttnet_org_chromium_base_ApiCompatibilityUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ApisP.getProcessName();
    }

    public static boolean isDemoUser() {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
    L7:
        return false;
    L5:
        if (ApisN.isDemoUser() == false) goto L7;
        return true;
    }

    public static boolean isRunningInUserTestHarness() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return ApisQ.isRunningInUserTestHarness();
    }

    private ApiCompatibilityUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_ApiCompatibilityUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static Bundle createLaunchDisplayIdActivityOptions(int r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return ApisO.createLaunchDisplayIdActivityOptions(r2);
    }

    public static void disableSmartSelectionTextClassifier(TextView r2) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        ApisO.disableSmartSelectionTextClassifier(r2);
        return;
    }

    public static byte[] getBytesUtf8(String r1) {
        return r1.getBytes(EffectRequest.DEFAULT_PARAMS_ENCODING);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String getLocale(InputMethodSubtype r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.getLocale(r2);
    L7:
        return r2.getLocale();
    }

    public static List<Integer> getTargetableDisplayIds(Activity r2) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return ApisQ.getTargetableDisplayIds(r2);
    L7:
        return new ArrayList();
    }

    public static boolean isInMultiWindowMode(Activity r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return ApisN.isInMultiWindowMode(r2);
    }

    public static <T> T requireNonNull(T r0) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw null;
    }

    public static void setPasswordEditTextContentDescription(EditText r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return;
    L6:
        if (isPasswordInputType(r2.getInputType()) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2.getHint()) == true) goto L12;
        r2.setContentDescription(r2.getHint());
        return;
    }

    public static Bitmap getBitmapByUri(ContentResolver r2, Uri r3) throws IOException {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApisP.getBitmapByUri(r2, r3);
    L7:
        return MediaStore.Images.Media.getBitmap(r2, r3);
    }

    public static int getColor(Resources r0, int r1) throws Resources.NotFoundException {
        return r0.getColor(r1);
    }

    public static Drawable getDrawable(Resources r1, int r2) throws Resources.NotFoundException {
        return getDrawableForDensity(r1, r2, 0);
    }

    public static <T> T requireNonNull(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(r1);
    }

    public static void setAccessibilityTraversalBefore(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        ApisLmr1.setAccessibilityTraversalBefore(r2, r3);
        return;
    }

    public static void setImageTintList(ImageView r3, ColorStateList r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 21) goto L8;
        if (r4 == null) goto L8;
        if (r3.getImageTintMode() != null) goto L8;
        r3.setImageTintMode(PorterDuff.Mode.SRC_IN);
    L8:
        ImageViewCompat.setImageTintList(r3, r4);
        if (r0 != 21) goto L13;
        if (r4 != null) goto L14;
        r3.refreshDrawableState();
        return;
    L14:
        return;
    }

    public static void setStatusBarColor(Window r3, int r4) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
    L9:
        r3.addFlags(IntCompanionObject.MIN_VALUE);
    L10:
        r3.setStatusBarColor(r4);
        return;
    L5:
        if (r4 != (-16777216)) goto L9;
        if (r3.getNavigationBarColor() != (-16777216)) goto L9;
        r3.clearFlags(IntCompanionObject.MIN_VALUE);
        goto L10
    }

    public static void setStatusBarIconColor(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        ApisM.setStatusBarIconColor(r2, r3);
        return;
    }

    public static void setTextAppearance(TextView r1, int r2) {
        r1.setTextAppearance(r1.getContext(), r2);
    }

    public static String toHtml(Spanned r2, int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.toHtml(r2, r3);
    L7:
        return Html.toHtml(r2);
    }

    public static Drawable getDrawableForDensity(Resources r2, int r3, int r4) {
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskReads();
        if (r4 != 0) goto L7;
        Drawable r5 = r2.getDrawable(r3, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r0);
        return r5;
    L7:
        Drawable r6 = r2.getDrawableForDensity(r3, r4, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r0);
        return r6;
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }

    public static int checkPermission(Context r0, String r1, int r2, int r3) {
        return com_ttnet_org_chromium_base_ApiCompatibilityUtils_android_content_Context_checkPermission(r0, r1, r2, r3);
    L4:
        return -1;
    }

    private static int com_ttnet_org_chromium_base_ApiCompatibilityUtils_android_content_Context_checkPermission(Context r18, String r19, int r20, int r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, Integer.valueOf(r20), Integer.valueOf(r21)};
        b r11 = new b("auto_cert_com_ttnet_org_chromium_base_ApiCompatibilityUtils_android_content_Context_checkPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102607);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102607, "android/content/Context", "checkPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkPermission(r19, r20, r21);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
