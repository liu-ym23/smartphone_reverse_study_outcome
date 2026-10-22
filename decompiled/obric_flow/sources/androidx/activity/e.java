package androidx.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Parcel;
import android.provider.MediaStore;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebSettings;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.bytedance.ai.model.objects.PackageUseCountInfoWithIdentity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static /* bridge */ /* synthetic */ int a() {
        return MediaStore.getPickImagesMaxLimit();
    }

    public static /* bridge */ /* synthetic */ int b(DateFormat.HourCycle r5) {
        return r5.ordinal();
    }

    public static /* bridge */ /* synthetic */ ApplicationInfo c(PackageManager r5, String r10, PackageManager.ApplicationInfoFlags r11) {
        return r5.getApplicationInfo(r10, r11);
    }

    public static /* bridge */ /* synthetic */ PackageManager.ApplicationInfoFlags d() {
        return PackageManager.ApplicationInfoFlags.of(128);
    }

    public static /* synthetic */ AdaptiveIconDrawable e() {
        return new AdaptiveIconDrawable(null, null, null);
    }

    public static /* bridge */ /* synthetic */ DateFormat.HourCycle f() {
        return DateFormat.HourCycle.HOUR_CYCLE_11;
    }

    public static /* bridge */ /* synthetic */ Parcel g(IBinder r5) {
        return Parcel.obtain(r5);
    }

    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction h() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedCallback i(Object r5) {
        return (OnBackInvokedCallback) r5;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher j(Activity r5) {
        return r5.getOnBackInvokedDispatcher();
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher k(View r5) {
        return r5.findOnBackInvokedDispatcher();
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher l(ComponentDialog r5) {
        return r5.getOnBackInvokedDispatcher();
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher m(Object r5) {
        return (OnBackInvokedDispatcher) r5;
    }

    public static /* bridge */ /* synthetic */ Serializable n(Bundle r5) {
        return r5.getSerializable("travel_data_class", Class.class);
    }

    public static /* bridge */ /* synthetic */ Object o(Intent r5) {
        return r5.getParcelableExtra("extra_app_market_app_icon", Bitmap.class);
    }

    public static /* bridge */ /* synthetic */ ArrayList p(Bundle r5) {
        return r5.getParcelableArrayList("package_use_count_list", PackageUseCountInfoWithIdentity.class);
    }

    public static /* bridge */ /* synthetic */ void q(Parcel r5) {
        r5.enforceNoDataAvail();
    }

    public static /* bridge */ /* synthetic */ void r(WebSettings r5) {
        r5.setAlgorithmicDarkeningAllowed(true);
    }

    public static /* bridge */ /* synthetic */ void s(OnBackInvokedDispatcher r5, int r10, OnBackInvokedCallback r11) {
        r5.registerOnBackInvokedCallback(r10, r11);
    }

    public static /* bridge */ /* synthetic */ void t(OnBackInvokedDispatcher r5, OnBackInvokedCallback r10) {
        r5.unregisterOnBackInvokedCallback(r10);
    }

    public static /* bridge */ /* synthetic */ void u(OnBackInvokedDispatcher r5, androidx.appcompat.app.b r10) {
        r5.registerOnBackInvokedCallback(DurationKt.NANOS_IN_MILLIS, r10);
    }

    public static /* bridge */ /* synthetic */ boolean v(Locale r5, Locale r10) {
        return LocaleList.matchesLanguageAndScript(r5, r10);
    }

    public static /* bridge */ /* synthetic */ DateFormat.HourCycle[] w() {
        return DateFormat.HourCycle.values();
    }

    public static /* bridge */ /* synthetic */ DateFormat.HourCycle x() {
        return DateFormat.HourCycle.HOUR_CYCLE_12;
    }

    public static /* bridge */ /* synthetic */ DateFormat.HourCycle y() {
        return DateFormat.HourCycle.HOUR_CYCLE_23;
    }

    public static /* bridge */ /* synthetic */ DateFormat.HourCycle z() {
        return DateFormat.HourCycle.HOUR_CYCLE_24;
    }
}
