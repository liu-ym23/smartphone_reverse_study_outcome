package com.bytedance.ai.applet.login;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static c a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "authLink");
        Uri r11 = UriProtector.parse(r10);
        return new c(r11.getScheme(), r11.getHost(), UriProtector.getQueryParameter(r11, "state"), UriProtector.getQueryParameter(r11, "client_key"), UriProtector.getQueryParameter(r11, "biz"), UriProtector.getQueryParameter(r11, "scope"));
    }
}
