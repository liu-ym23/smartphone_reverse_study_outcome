package com.bytedance.ies.bullet.kit.resourceloader;

import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.service.base.a0;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f5457a = null;

    static {
        Pattern.compile("^/obj/[^/]+/[^/]+/gecko/resource");
        f5457a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static WebResourceResponse a(AssetManager r5, String r10) {
        if (r5 == null) goto L9;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length() == 0) goto L12;
        String r11 = f(r10);
        return b(r5.open(r10), r11);
    L12:
        return null;
    L9:
        return null;
    }

    public static WebResourceResponse b(InputStream r10, String r11) {
        if (r10 == null) goto L16;
        HashMap r5 = new HashMap();     // Catch: Exception -> L8
        r5.put("Access-Control-Allow-Origin", XPath.WILDCARD);     // Catch: Exception -> L8
        if (Intrinsics.areEqual("font/ttf", r11) == true) goto L7;
        WebResourceResponse r12 = new WebResourceResponse(r11, "", r10);     // Catch: Exception -> L8
        r12.setResponseHeaders(r5);     // Catch: Exception -> L8
        return r12;
    L7:
        return new WebResourceResponse(r11, "", 200, "OK", r5, r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return null;
    }

    public static String c(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        if (Intrinsics.areEqual(r5.getScheme(), "http") == true) goto L15;
        if (Intrinsics.areEqual(r5.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L15;
        String r10 = d(r5, "a_surl");
        if (r10 != null) goto L13;
        r10 = d(r5, "surl");
        if (r10 != null) goto L13;
        return d(r5, "url");
    L13:
        return r10;
    L15:
        return r5.toString();
    }

    public static String d(Uri r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return r5.getQueryParameter(r10);
    L5:
        return null;
    }

    public static String e(a0 r5, wc.g r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "config");
        if (StringsKt.P(r10.g, "/") == false) goto L9;
        String r11 = r10.g;
        if (r11 == null) goto L8;
        String r12 = r11.substring(1);
    L11:
        return r10.f22836a + '_' + r10.f + '_' + r12;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        r12 = r10.g;
        goto L11
    }

    public static String f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (StringsKt.k(r5, ".js") == false) goto L7;
        return "application/x-javascript";
    L7:
        if (StringsKt.k(r5, ".json") == false) goto L11;
        return "application/json";
    L11:
        if (StringsKt.k(r5, ".css") == false) goto L15;
        return "text/css";
    L15:
        if (StringsKt.k(r5, ".html") == false) goto L19;
        return "text/html";
    L19:
        if (StringsKt.k(r5, ".ico") == false) goto L23;
        return "image/x-icon";
    L23:
        if (StringsKt.k(r5, ".jpeg") == false) goto L25;
        return "image/jpeg";
    L25:
        if (StringsKt.k(r5, ".jpg") == false) goto L28;
        return "image/jpeg";
    L28:
        if (StringsKt.k(r5, ".png") == false) goto L32;
        return "image/png";
    L32:
        if (StringsKt.k(r5, ".gif") == false) goto L36;
        return "image/gif";
    L36:
        if (StringsKt.k(r5, ".woff") == false) goto L40;
        return "font/woff";
    L40:
        if (StringsKt.k(r5, ".svg") == false) goto L44;
        return "image/svg+xml";
    L44:
        if (StringsKt.k(r5, ".ttf") == false) goto L47;
        return "font/ttf";
    L47:
        return "";
    }

    public static String g(byte[] r10) {
        if (r10 == null) goto L13;
        int r5 = r10.length;
        if (r5 > r10.length) goto L11;
        int r11 = r5 * 2;
        char[] r12 = new char[r11];
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r5) goto L9;
        byte r15 = r10[r13];
        int r16 = r14 + 1;
        int r17 = (r15 & UByte.MAX_VALUE) >> 4;
        char[] r18 = f5457a;
        r12[r14] = r18[r17];
        r14 = r14 + 2;
        r12[r16] = r18[r15 & 15];
        r13 = r13 + 1;
        goto L6
    L9:
        return new String(r12, 0, r11);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }

    public static WebResourceResponse h(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        if (r5 == null) goto L16;
        File r11 = new File(r5);     // Catch: Throwable -> L10
        if (r11.exists() == true) goto L8;
    L12:
        r11 = null;
    L13:
        if (r11 == null) goto L16;
        return b(new FileInputStream(r11), f(r5));
    L8:
        if (r11.isDirectory() == true) goto L12;
    L16:
        Result.m124constructorimpl(null);     // Catch: Throwable -> L10
    L19:
        return null;
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
