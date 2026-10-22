package com.zte.miboard.cards;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.m;
import c.s0;
import com.zte.miboard.cards.travel.TravelSettingsAty;

/* JADX INFO: loaded from: classes3.dex */
public class AppCallbackUtils {
    public static final String TAG = "AppCallbackUtils";
    private static AppCallback sAppCallback;

    public interface AppCallback {
        boolean jumpToWebView(@NonNull Context r5, @NonNull String r10, @Nullable Bundle r11);

        boolean showDownloadAppDialog(@NonNull Context r5, @NonNull String r10, @Nullable Drawable r11, @NonNull String r12);
    }

    public AppCallbackUtils() {
    }

    public static boolean callAppJumpToWebView(Context r5, String r10) {
        StringBuilder r11 = new StringBuilder("callAppJumpToWebView sAppCallback=");
        if (sAppCallback == null) goto L5;
        boolean r12 = true;
    L6:
        r11.append(r12);
        m.i(TAG, r11.toString());
        AppCallback r13 = sAppCallback;
        if (r13 != null) goto L9;
        boolean r14 = s0.f1083a;
    L15:
        e = move-exception;
        m.j("Utils", "openWithBrowser error. ", e);
        Toast.makeText(r5, R.string.news_details_no_webview_install, 0).show();
        return false;
    L12:
        if (TextUtils.isEmpty(r10) == true) goto L22;
        Intent r15 = new Intent();     // Catch: Exception -> L15
        r15.setAction("android.intent.action.VIEW");     // Catch: Exception -> L15
        r15.setData(Uri.parse(r10));     // Catch: Exception -> L15
        r15.addFlags(268435456);     // Catch: Exception -> L15
        r5.startActivity(r15);     // Catch: Exception -> L15
    L22:
        return true;
    L9:
        return r13.jumpToWebView(r5, r10, new Bundle());
    L5:
        r12 = false;
        goto L6
    }

    public static boolean jumpToTravelSettingsAty(Context r5) {
        return TravelSettingsAty.a(r5);
    }

    public static void setAppCallback(AppCallback r5) {
        m.i(TAG, "setAppCallback appCallback=" + r5);
        sAppCallback = r5;
    }

    public static boolean showDownloadAppDialog(Context r5, String r10, Drawable r11, String r12) {
        StringBuilder r13 = new StringBuilder("showDownloadAppDialog sAppCallback=");
        if (sAppCallback == null) goto L5;
        boolean r14 = true;
    L6:
        r13.append(r14);
        r13.append(" appName=");
        r13.append(r12);
        r13.append(" pkgName=");
        r13.append(r10);
        m.i(TAG, r13.toString());
        AppCallback r15 = sAppCallback;
        if (r15 != null) goto L9;
        return false;
    L9:
        return r15.showDownloadAppDialog(r5, r10, r11, r12);
    L5:
        r14 = false;
        goto L6
    }
}
