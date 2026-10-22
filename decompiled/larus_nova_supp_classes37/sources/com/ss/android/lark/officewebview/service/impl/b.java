package com.ss.android.lark.officewebview.service.impl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements oxb.g {
    public boolean a;

    public b() {
    }

    @Override // oxb.g
    public final Bitmap C() {
        j.e("UrlQueryParameterHandleServiceImpl", "mHideVideoPoster = " + this.a);
        if (this.a == true) goto L5;
        return null;
    L5:
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }

    public final void P(Uri r4) {
        String r5 = UriProtector.getQueryParameter(r4, "lark_remove_video_overlay_icon");
        if (TextUtils.isEmpty(r5) == true) goto L5;
        j.e("UrlQueryParameterHandleServiceImpl", "hideVideoOverlayIcon = " + r5);
        this.a = Boolean.parseBoolean(r5);
        return;
    L5:
        j.e("UrlQueryParameterHandleServiceImpl", "hideVideoOverlayIcon is empty");
        this.a = false;
    }

    public static void O(Uri r5, OfficeWebView r6) {
        String r7 = UriProtector.getQueryParameter(r5, "lark_media_auto_play");
        if (TextUtils.isEmpty(r7) == true) goto L5;
        j.e("UrlQueryParameterHandleServiceImpl", "autoValue = " + r7);
        r6.getSettings().setMediaPlaybackRequiresUserGesture(Boolean.parseBoolean(r7) ^ true);
        return;
    L5:
        int r8 = com.ss.android.lark.officesdk.utils.di.g.a;
        boolean r9 = com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.webbrowser.autoplaynew");
        j.e("UrlQueryParameterHandleServiceImpl", "autoState = " + r6.getSettings().getMediaPlaybackRequiresUserGesture() + " ， autoPlayFg = " + r9);
        if (r9 == false) goto L9;
        j.e("UrlQueryParameterHandleServiceImpl", "new autoPlay and flag is null ,so do nothing ");
        return;
    L9:
        j.e("UrlQueryParameterHandleServiceImpl", "autoValue is empty");
        r6.getSettings().setMediaPlaybackRequiresUserGesture(true);
    }

    @Override // oxb.g
    public final void F(String r4, OfficeWebView r5) {
        if (TextUtils.isEmpty(r4) == true) goto L15;
        if (r5 == null) goto L15;
        Uri r6 = UriProtector.parse(r4);     // Catch: Exception -> L12
        if (r6 != null) goto L10;
        j.e("UrlQueryParameterHandleServiceImpl", "url is null");     // Catch: Exception -> L12
        return;
    L10:
        O(r6, r5);     // Catch: Exception -> L12
        P(r6);     // Catch: Exception -> L12
        String r7 = UriProtector.getQueryParameter(r6, "lark_web_title_bar_show");     // Catch: Exception -> L12
        j.e("UrlQueryParameterHandleServiceImpl", "titleBarShowValue = " + r7 + " , mTitleBarShowListener = null");     // Catch: Exception -> L12
        TextUtils.isEmpty(r7);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        j.c("UrlQueryParameterHandleServiceImpl", "handle url error", e);
        return;
    L15:
        j.e("UrlQueryParameterHandleServiceImpl", "url is " + r4 + ", webview is " + r5);
    }
}
