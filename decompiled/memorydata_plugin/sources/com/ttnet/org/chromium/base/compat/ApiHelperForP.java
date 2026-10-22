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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiHelperForP {
    private ApiHelperForP() {
    }

    public static TextSelection.Request build(TextSelection.Request.Builder r0) {
        return r0.build();
    }

    public static void clearPrimaryClip(ClipboardManager r0) {
    }

    public static long getLongVersionCode(PackageInfo r2) {
        return r2.getLongVersionCode();
    }

    public static String getPrivateDnsServerName(LinkProperties r0) {
        return r0.getPrivateDnsServerName();
    }

    public static SignalStrength getSignalStrength(TelephonyManager r0) {
        return r0.getSignalStrength();
    }

    public static boolean hasSigningCertificate(PackageManager r0, String r1, byte[] r2, int r3) {
        return r0.hasSigningCertificate(r1, r2, r3);
    }

    public static boolean isLocationEnabled(LocationManager r0) {
        return r0.isLocationEnabled();
    }

    public static boolean isPrivateDnsActive(LinkProperties r0) {
        return r0.isPrivateDnsActive();
    }

    public static TextSelection.Request.Builder newTextSelectionRequestBuilder(CharSequence r2, int r3, int r4) {
        return new TextSelection.Request.Builder((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static TextSelection.Request.Builder setDefaultLocales(TextSelection.Request.Builder r0, LocaleList r1) {
        return r0.setDefaultLocales(r1);
    }

    public static TextSelection suggestSelection(TextClassifier r2, TextSelection.Request r3) {
        return ((TextClassifier) ZeusTransformUtils.wrapperContextForParams(r2, TextClassifier.class, "com.obric.memorydata.plugin")).suggestSelection(r3);
    }
}
