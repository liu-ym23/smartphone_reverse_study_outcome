package com.obric.assistant.network.restrict;

import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import hm9.s;
import java.net.URL;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g implements NativeRequestInterceptor.b {
    public g() {
    }

    public final void a() {
    }

    public final NativeRequestInterceptor.c b(String r14) {
        if (r14 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L39;
        return null;
    L39:
        URL r4 = new URL(r14);     // Catch: Exception -> L38
        hm9.j r5 = hm9.j.a;     // Catch: Exception -> L38
        s r6 = hm9.j.h;     // Catch: Exception -> L38
        if (r6.y != 2) goto L22;
        if (r6.B == false) goto L37;
        String r7 = r4.getHost();     // Catch: Exception -> L38
        String r8 = r4.getPath();     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r7, "host");     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r8, DownloadConstants.PATH_KEY);     // Catch: Exception -> L38
        if (r6.a(r7, r8) != 3) goto L37;
        FLogger.a.i("ObricBackgroundNetworkRestrict", "onRequestInterceptorCallback obric native intercepted, url: " + r14);     // Catch: Exception -> L38
        NativeRequestInterceptor.c r15 = new NativeRequestInterceptor.c(NativeRequestInterceptor.RequestModified.BOTH_MODIFIED);     // Catch: Exception -> L38
        r15.b = MapsKt.mapOf(new Pair[]{TuplesKt.to("new", "headers"), TuplesKt.to("x-metasec-ttnet-native-drop", "1")});     // Catch: Exception -> L38
        return r15;
    L22:
        if (r6.B == false) goto L37;
        String r16 = r4.getPath();     // Catch: Exception -> L38
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L38
        if (StringsKt.startsWith$default(r16, "/ies/speed", false, 2, null) == false) goto L26;
    L33:
        boolean r17 = true;
    L34:
        if (r17 == false) goto L37;
        NativeRequestInterceptor.c r18 = new NativeRequestInterceptor.c(NativeRequestInterceptor.RequestModified.BOTH_MODIFIED);     // Catch: Exception -> L38
        r18.b = MapsKt.mapOf(new Pair[]{TuplesKt.to("new", "headers"), TuplesKt.to("x-metasec-ttnet-native-drop", "1")});     // Catch: Exception -> L38
        return r18;
    L26:
        if (StringsKt.startsWith$default(r16, "/resolve", false, 2, null) == true) goto L33;
        if (StringsKt.startsWith$default(r16, "/get_domains/v5", false, 2, null) == true) goto L33;
        if (StringsKt.startsWith$default(r16, "/passport/token/beat", false, 2, null) == true) goto L33;
        r17 = false;
    L37:
        return null;
    L5:
        if (r14.length() == 0) goto L8;
        r3 = false;
        goto L10
    }
}
