package com.ttnet.org.chromium.base.compat;

import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.LinkProperties;
import android.os.LocaleList;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
public final class ApiHelperForP {
    private ApiHelperForP() {
    }

    public static TextSelection.Request build(TextSelection.Request.Builder r10) {
        return r10.build();
    }

    public static void clearPrimaryClip(ClipboardManager r10) {
        r10.clearPrimaryClip();
    }

    public static long getLongVersionCode(PackageInfo r10) {
        return r10.getLongVersionCode();
    }

    public static String getPrivateDnsServerName(LinkProperties r10) {
        return r10.getPrivateDnsServerName();
    }

    public static SignalStrength getSignalStrength(TelephonyManager r10) {
        return r10.getSignalStrength();
    }

    public static boolean hasSigningCertificate(PackageManager r10, String r11, byte[] r12, int r13) {
        return r10.hasSigningCertificate(r11, r12, r13);
    }

    public static boolean isLocationEnabled(LocationManager r10) {
        return r10.isLocationEnabled();
    }

    public static boolean isPrivateDnsActive(LinkProperties r10) {
        return r10.isPrivateDnsActive();
    }

    public static TextSelection.Request.Builder newTextSelectionRequestBuilder(CharSequence r10, int r11, int r12) {
        return new TextSelection.Request.Builder(r10, r11, r12);
    }

    public static TextSelection.Request.Builder setDefaultLocales(TextSelection.Request.Builder r10, LocaleList r11) {
        return r10.setDefaultLocales(r11);
    }

    public static TextSelection suggestSelection(TextClassifier r10, TextSelection.Request r11) {
        return r10.suggestSelection(r11);
    }
}
