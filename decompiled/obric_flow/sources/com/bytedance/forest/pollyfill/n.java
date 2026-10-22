package com.bytedance.forest.pollyfill;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;
import com.bytedance.geckox.utils.MD5Utils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    public static c a(String r10, Request r11) {
        Object r5 = r11.getWebResourceRequest();
        if ((r5 instanceof WebResourceRequest) == false) goto L33;
        WebResourceRequest r12 = (WebResourceRequest) r5;
        String r13 = r12.getMethod();
        Locale r14 = Locale.ENGLISH;
        if (r13 == null) goto L32;
        if (Intrinsics.areEqual(r13.toLowerCase(r14), "get") == true) goto L9;
        c r15 = null;
    L40:
        if (r15 != null) goto L42;
        return null;
    L42:
        if (r11.isPreload() == false) goto L49;
        String r16 = r11.getPreloadFrom();
        if (r16 == null) goto L49;
        if (r16.length() == 0) goto L49;
        r15.f4524b.put("x-forest-preload", r16);
    L49:
        return r15;
    L9:
        Iterator<Map.Entry<String, String>> r17 = r11.getInjectedHttpHeaders().entrySet().iterator();
    L11:
        if (r17.hasNext() == false) goto L15;
        Map.Entry<String, String> r18 = r17.next();
        if (r12.getRequestHeaders().containsKey(r18.getKey()) == true) goto L11;
        r12.getRequestHeaders().put(r18.getKey(), r18.getValue());
        goto L11
    L15:
        q.d.getClass();
        if (r10 != null) goto L18;
    L23:
        Uri r19 = r12.getUrl();
        if (r19 == null) goto L26;
        r10 = r19.toString();
    L27:
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        String r20 = StringsKt.W(r10, '#');
        Map<String, String> r21 = r12.getRequestHeaders();
        r21.remove("If-Modified-Since");
        r21.remove("If-None-Match");
        r15 = new c(r20, r21);
        goto L40
    L26:
        r10 = null;
        goto L27
    L18:
        if (StringsKt.isBlank(r10) == false) goto L21;
        r10 = null;
    L21:
        if (r10 == null) goto L23;
    L32:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L33:
        LinkedHashMap r22 = new LinkedHashMap();
        if (com.lynx.tasm.behavior.utils.d.g(r11.getInjectedUserAgent()) == false) goto L39;
        String r23 = r11.getInjectedUserAgent();
        if (r23 != null) goto L38;
        Intrinsics.throwNpe();
    L38:
        r22.put("user-agent", r23);
    L39:
        r22.putAll(r11.getInjectedHttpHeaders());
        q.d.getClass();
        r15 = com.bytedance.ies.bullet.service.base.c.b(r10, r22);
        goto L40
    }

    public static d b(final w r11, k r12, com.bytedance.forest.utils.e r13) {
        final Ref.IntRef r5 = new Ref.IntRef();
        int r10 = RangesKt.coerceAtLeast(r11.f4441q.getLoadRetryTimes(), 1);
        r5.element = r10;
        if (r10 > 0) goto L5;
        com.bytedance.forest.utils.d.c(r13.g, 6, "TTNetDepender", null, null, new TTNetDepender$Companion$getHttpResponse$1(r11), 24);
    L5:
        ForestNetAPI$HttpResponse$Companion$ForestNetException th2 = null;
    L6:
        int r14 = r5.element;
        if (r14 <= 0) goto L20;
        r5.element = r14 - 1;
        q.d.getClass();     // Catch: Throwable -> L14 ForestNetAPI$HttpResponse$Companion$ForestNetException -> L16
        final d r15 = com.bytedance.ies.bullet.service.base.c.e(r12, r13);     // Catch: Throwable -> L14 ForestNetAPI$HttpResponse$Companion$ForestNetException -> L16
        if (l.f.contains(Integer.valueOf(r15.f4526a)) == false) goto L13;
        com.bytedance.forest.utils.d.c(r13.g, 5, "TTNetDepender", null, null, new TTNetDepender$Companion$getHttpResponse$2(r15, r5), 24);     // Catch: Throwable -> L14 ForestNetAPI$HttpResponse$Companion$ForestNetException -> L16
    L13:
        return r15;
    L16:
        e = move-exception;
        com.bytedance.forest.utils.d.b(r13.g, 6, "TTNetDepender", "Forest defined exception", true, e, null, 32);
        th2 = e;
    L14:
        th2 = th;
        com.bytedance.forest.utils.d.b(r13.g, 6, "TTNetDepender", "net error", true, th2, null, 32);
    L20:
        if (th2 != null) goto L22;
        return null;
    L22:
        throw th2;
    }

    public static boolean c(String r5, w r10, com.bytedance.forest.utils.e r11) {
        r11.b(new String[]{"cdn_downloader_build_cached_path_start"});
        String r12 = MD5Utils.stringToMd5(r5);
        String r13 = r10.f4441q.getUri$forest_release().getEncodedPath();
        if (r13 == null) goto L12;
        String r14 = FilesKt.getExtension(new File(r13));
        if (r14 == null) goto L12;
        if (TextUtils.isEmpty(r14) == false) goto L10;
        r14 = null;
    L10:
        if (r14 == null) goto L12;
    L13:
        File r15 = new File((File) b.f4507a.getValue(), androidx.constraintlayout.motion.widget.a.m(r12, '.', r14));
        r11.b(new String[]{"cdn_downloader_build_cached_path_finish", "cdn_downloader_load_cache_start"});
        if (r15.exists() == true) goto L16;
    L45:
        r11.b(new String[]{"cdn_downloader_load_cache_finish"});
        return false;
    L16:
        if (r15.isFile() == false) goto L45;
        DownloadInfo r16 = Downloader.b(Forest.Companion.getApp()).a(r5, r15.getParent());
        if (r16 == null) goto L47;
        char[] r17 = DownloadUtils.f16142a;
        if (DownloadUtils.a(r16, r16.f15828o, r16.C) == true) goto L22;
        boolean r18 = true;
    L23:
        if (r18 == true) goto L47;
        r10.f4442r = true;
        r10.f4446w = true;
        String r19 = r16.f15839u;
        if (r19 == null) goto L28;
        r10.g = StringsKt.X(r19, ";");
        r10.f4434j = StringsKt.X(StringsKt.Q(r19, "charset="), ";");
    L28:
        HashMap r20 = r16.f15807a1;
        if (r20 == null) goto L37;
        String r21 = (String) r20.get("x-gecko-proxy-pkgid");
        if (r21 == null) goto L35;
        Long r22 = StringsKt.toLongOrNull(r21);
        if (r22 == null) goto L35;
        long r23 = r22.longValue();
    L36:
        r10.f4449z = r23;
        r10.f4441q.getCustomParams().put("http_response_headers", r20.toString());
    L35:
        r23 = 0;
    L37:
        r10.f4443t = r15.getAbsolutePath();
        r10.d(r11.a(new f(r15, r11), r10.f4441q));
        r10.f4444u = ResourceFrom.f4340c;
        return true;
    L22:
        r18 = DownloadUtils.a(r16, false);
    L47:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L41
        Result.m124constructorimpl(Boolean.valueOf(r15.delete()));     // Catch: Throwable -> L41
    L43:
        r11.b(new String[]{"cdn_downloader_load_cache_finish"});
        return false;
    L41:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L12:
        r14 = "js";
        goto L13
    }
}
