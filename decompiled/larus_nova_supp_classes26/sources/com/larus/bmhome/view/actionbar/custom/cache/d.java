package com.larus.bmhome.view.actionbar.custom.cache;

import com.bytedance.keva.Keva;
import com.google.gson.reflect.TypeToken;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final Lazy a;
    public final int b;
    public final boolean c;
    public final Lazy d;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/view/actionbar/custom/cache/ActionBarMenuRedDotCacheHelper$getRedDotFromLocalCache$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/view/actionbar/custom/cache/ActionBarRedDotCacheEntity;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<g> {
        public b() {
        }
    }

    static {
    }

    public final Keva b() {
        return (Keva) this.a.getValue();
    }

    public d() {
        this.a = LazyKt.lazy(new com.larus.bmhome.view.actionbar.custom.cache.b());
        z2 r0 = z2.a;
        this.b = r0.getActionBarEntryConfig().e;
        this.c = r0.getActionBarEntryConfig().c;
        this.d = LazyKt.lazy(new c());
    }

    public final boolean a(g r4, long r5) {
        if (this.c == true) goto L5;
    L13:
        return false;
    L5:
        if (r5 <= 0) goto L13;
        if (r4.c() >= r5) goto L9;
    L12:
        return true;
    L9:
        if (r4.c() != r5) goto L13;
        if (r4.b() >= this.b) goto L13;
        goto L12
    }

    public static String c(String r2, String r3, String r4) {
        return "menuRedDot-" + r2 + '-' + r3 + '-' + r4;
    }

    public final g d(String r4, String r5, String r6) {
        g r7 = (g) HttpExtKt.f.fromJson(b().getString(c(r5, r6, r4), "{}"), new b().getType());     // Catch: Exception -> L7
        if (r7 != null) goto L12;
        return new g(r5, 6);
    L12:
        return r7;
    L7:
        e = move-exception;
        FLogger.a.e("ActionBarMenuRedDotCacheHelper", "save cache error=" + e.getMessage());
        return new g(r5, 6);
    }
}
