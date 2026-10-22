package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f5834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f5835c = null;

    static {
        f5833a = new a();
        f5834b = new ConcurrentHashMap();
        f5835c = new ConcurrentHashMap();
    }

    public static String b(a r5, Uri r10) {
        r5.getClass();
        String r11 = io.reactivex.exceptions.a.b(r10, "default_bid");
        String r12 = io.reactivex.exceptions.a.h(r10, "prefetch_channel");
        String r13 = io.reactivex.exceptions.a.h(r10, "prefetch_bundle");
        if (r12 != null) goto L5;
    L10:
        r12 = io.reactivex.exceptions.a.h(r10, LynxMonitorService.KEY_CHANNEL);
        r13 = io.reactivex.exceptions.a.h(r10, "bundle");
    L11:
        String r14 = io.reactivex.exceptions.a.h(r10, "prefetch_ak");
        StringBuilder r15 = new StringBuilder();
        String r16 = null;
        if (r11 == null) goto L14;
        String r17 = c.e(r11);
    L15:
        r15.append(r17);
        r15.append('_');
        r15.append(r12);
        r15.append('_');
        if (r13 == null) goto L21;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r16 = "prefetch.json";
        Intrinsics.checkNotNullParameter("prefetch.json", "suffix");
        if (StringsKt.g(r13, "/") == false) goto L21;
        r16 = c.e(r13);
    L21:
        r15.append(r16);
        r15.append('_');
        r15.append(r14);
        return r15.toString();
    L14:
        r17 = null;
        goto L15
    L5:
        if (r12.length() == 0) goto L10;
        if (r13 == null) goto L10;
        if (r13.length() != 0) goto L11;
        goto L10
    }

    public final f a(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        String r10 = b(this, r5);
        f r11 = (f) f5834b.get(r10);
        c.h("Get config cache by schema uri: " + r5 + ", configKey: " + r10 + ", config: " + r11);
        return r11;
    }
}
