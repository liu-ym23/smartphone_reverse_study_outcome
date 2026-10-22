package com.bytedance.forest.utils;

import android.app.Application;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.google.gson.Gson;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.ui.image.f0;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f4646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f4647b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f4648c = null;

    static {
        f4646a = CollectionsKt.listOf(new String[]{"no-store", "no-cache", "max-age=0", "max-age=0", "must-revalidate", "proxy-revalidate"});
        f4647b = new Gson();
        f4648c = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static WebResourceResponse a(String r11, String r12, InputStream r13, String r14, Map r15) {
        if (Intrinsics.areEqual(r11, "unknown") == false) goto L12;
        StringBuilder r16 = new StringBuilder();
        r16.append(r14);
        r16.append(", cannot resolve mimetype, ");
        r16.append(r14);
        r16.append(", headers: ");
        if (r15 == null) goto L9;
        Set r5 = r15.entrySet();
        if (r5 == null) goto L9;
        String r17 = CollectionsKt.q(r5, null, null, null, 0, null, OfflineUtil$generateWebResourceResponse$1.f4581a, 31);
    L10:
        r16.append(r17);
        f0.g(116, "header", r16.toString(), null);
        return null;
    L9:
        r17 = null;
        goto L10
    L12:
        if (r13 == null) goto L30;
        if (r15 == null) goto L31;
    L14:
        Map r10 = r15;
        if (r10.get("Access-Control-Allow-Origin") != null) goto L24;
        if (r10.get("access-control-allow-origin") != null) goto L24;
        r10.put("access-control-allow-origin", XPath.WILDCARD);     // Catch: Exception -> L21
    L24:
        if (Intrinsics.areEqual("font/ttf", r11) == true) goto L26;
        WebResourceResponse r18 = new WebResourceResponse(r11, r12, r13);     // Catch: Exception -> L21
        r18.setResponseHeaders(r10);     // Catch: Exception -> L21
        return r18;
    L26:
        return new WebResourceResponse(r11, r12, 200, "OK", r10, r13);
    L31:
        r15 = new HashMap();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L30:
        return null;
    }

    public static Long b(com.bytedance.forest.pollyfill.l r10) {
        Object r5 = null;
        if (r10 == null) goto L34;
        long r11 = f(r10);
        Map r12 = r10.f4528c;
        String r13 = (String) r12.get("cache-control");
        if (r13 == null) goto L20;
        String r14 = StringsKt.S(r13, "max-age=");
        if (r14 == null) goto L20;
        String r15 = StringsKt.W(r14, ',');
        if (r15 == null) goto L20;
        Integer r16 = StringsKt.toIntOrNull(r15);
        if (r16 == null) goto L20;
        int r17 = r16.intValue();
        String r18 = (String) r12.get("age");
        if (r18 == null) goto L17;
        Integer r19 = StringsKt.toIntOrNull(r18);
        if (r19 == null) goto L17;
        int r20 = r19.intValue();
    L19:
        return Long.valueOf((((long) (r17 - r20)) * 1000) + r11);
    L17:
        r20 = 0;
    L20:
        String r21 = (String) r12.get("expires");
        if (r21 == null) goto L35;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L24
        Object r23 = Result.m124constructorimpl(Long.valueOf(new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.ENGLISH).parse(r21).getTime()));     // Catch: Throwable -> L24
    L27:
        if (Result.m130isFailureimpl(r23) == true) goto L31;
        r5 = r23;
    L31:
        return (Long) r5;
    L24:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r23 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L27
    L35:
        return null;
    L34:
        return null;
    }

    public static String c(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        switch(r5.hashCode()) {
            case 3401: goto L60;
            case 98819: goto L56;
            case 102340: goto L52;
            case 104085: goto L48;
            case 105441: goto L44;
            case 111145: goto L40;
            case 114276: goto L36;
            case 115174: goto L32;
            case 3213227: goto L28;
            case 3268712: goto L25;
            case 3271912: goto L21;
            case 3645340: goto L17;
            case 3655064: goto L13;
            case 113307034: goto L9;
            default: goto L64;
        };
    L9:
        if (r5.equals("woff2") == false) goto L64;
        return "font/woff2";
    L13:
        if (r5.equals("woff") == false) goto L64;
        return "font/woff";
    L17:
        if (r5.equals("webp") == false) goto L64;
        return "image/webp";
    L21:
        if (r5.equals("json") == false) goto L64;
        return "application/json";
    L25:
        if (r5.equals("jpeg") == false) goto L64;
        return "image/jpeg";
    L28:
        if (r5.equals("html") == false) goto L64;
        return "text/html";
    L32:
        if (r5.equals("ttf") == false) goto L64;
        return "font/ttf";
    L36:
        if (r5.equals(SVGRenderEngine.SVG) == false) goto L64;
        return "image/svg+xml";
    L40:
        if (r5.equals("png") == false) goto L64;
        return "image/png";
    L44:
        if (r5.equals("jpg") == false) goto L64;
        return "image/jpeg";
    L48:
        if (r5.equals("ico") == false) goto L64;
        return "image/x-icon";
    L52:
        if (r5.equals("gif") == false) goto L64;
        return "image/gif";
    L56:
        if (r5.equals("css") == false) goto L64;
        return "text/css";
    L60:
        if (r5.equals("js") == false) goto L64;
        return "application/x-javascript";
    L64:
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(r5);
    }

    public static String d(String r5, boolean r10) {
        if (r10 == false) goto L18;
        String r11 = StringsKt.T(r5);
        Locale r12 = Locale.ENGLISH;
        if (r11 == null) goto L8;
        return r11.toLowerCase(r12);
    L8:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L18:
        String r13 = MimeTypeMap.getFileExtensionFromUrl(r5);     // Catch: Throwable -> L17
        if (r13 == null) goto L16;
        if (r13.length() == 0) goto L16;
        return r13;
    L16:
        return null;
    }

    public static void e(Application r5) {
        f4648c.set(true);
        if (com.bytedance.geckox.p.d() == false) goto L6;
        com.bytedance.gkfs.a.c(r5);
    L6:
        f0.h("GkFS", 60, "gkfs clean start", false);
        com.bytedance.geckox.p.b(OfflineUtil$cleanGkFS$1.f4580a);
    }

    public static long f(com.bytedance.forest.pollyfill.l r5) {
        Long r10 = null;
        if (r5 == null) goto L10;
        String r11 = (String) r5.f4528c.get("forest-append-on-request");
        if (r11 == null) goto L7;
        Long r12 = StringsKt.toLongOrNull(r11);
    L8:
        if (r12 == null) goto L10;
        r10 = r12;
    L12:
        if (r10 != null) goto L14;
        return 0;
    L14:
        return r10.longValue();
    L7:
        r12 = null;
    L10:
        if (r5 == null) goto L12;
        r10 = Long.valueOf(r5.e);
        goto L12
    }
}
