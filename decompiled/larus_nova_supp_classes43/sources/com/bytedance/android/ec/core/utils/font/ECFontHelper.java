package com.bytedance.android.ec.core.utils.font;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.android.ec.core.utils.FontWeight;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECFontHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static boolean d;
    public static final ECFontHelper e = null;

    public ECFontHelper() {
    }

    private final Context getContext() {
        return (Context) b.getValue();
    }

    static {
        e = new ECFontHelper();
        a = LazyKt.lazy(ECFontHelper$executor$2.INSTANCE);
        b = LazyKt.lazy(ECFontHelper$context$2.INSTANCE);
        c = LazyKt.lazy(ECFontHelper$loaderMap$2.INSTANCE);
    }

    public final void a() {
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_ec_font_preload");
        b("DouyinNumberABC", FontWeight.WEIGHT_600, false);     // Catch: Throwable -> L5
        b("DouyinNumberABC", 500, false);     // Catch: Throwable -> L5
        b("DouyinNumberABC", 400, false);     // Catch: Throwable -> L5
        dm.a.a("ECFontHelper").i("ECFontHelper#doPreload method execution end");     // Catch: Throwable -> L5
        d = true;     // Catch: Throwable -> L5
        return;
    }

    public final Typeface b(String r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "fontFamily");
        Context r13 = getContext();
        if (r13 != null) goto L5;
        return null;
    L5:
        e r14 = (e) ((ConcurrentHashMap) c.getValue()).get(r10);
        if (r14 != null) goto L8;
        return null;
    L8:
        return r14.a(r13, r11);
    }
}
