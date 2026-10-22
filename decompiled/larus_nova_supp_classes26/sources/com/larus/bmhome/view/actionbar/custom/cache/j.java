package com.larus.bmhome.view.actionbar.custom.cache;

import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements k {
    public static final LruCache<String, g> f = null;
    public static final Object g = null;
    public static final Lazy<Set<IActionBarRedDotChecker>> h = null;
    public final CopyOnWriteArraySet<String> a;
    public final Map<Long, z0> b;
    public final Lazy c;
    public final int d;
    public final boolean e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/view/actionbar/custom/cache/ActionBarRedDotCacheHelper$getRedDotFromLocalCache$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/view/actionbar/custom/cache/ActionBarRedDotCacheEntity;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<g> {
        public b() {
        }
    }

    static {
        f = new LruCache(128);
        g = new Object();
        h = LazyKt.lazy(new i());
    }

    public j() {
        this.a = new CopyOnWriteArraySet();
        this.b = new LinkedHashMap();
        this.c = LazyKt.lazy(new h());
        z2 r0 = z2.a;
        this.d = r0.getActionBarEntryConfig().e;
        this.e = r0.getActionBarEntryConfig().c;
    }

    public static String d(String r1, String r2) {
        return r1 + '-' + r2 + '-';
    }

    @Override // com.larus.bmhome.view.actionbar.custom.cache.k
    public final boolean a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "itemId");
        Set r1 = (Set) h.getValue();
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        if (((IActionBarRedDotChecker) r2.next()).a() == false) goto L9;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return true;
    L16:
        String r4 = d(r12, r11);
        g r13 = g.a(c(r11, r12), null, 0, 99999999, 3);
        this.a.remove(r12);
        String r14 = HttpExtKt.f.toJson(r13);     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L19
        f(r4, r13, r14);     // Catch: Exception -> L19
        FLogger.a.i("ActionBarRedDotCacheHelper", "setItemHasClicked save cache newEntityString=" + r14);     // Catch: Exception -> L19
    L21:
        return false;
    L19:
        e = move-exception;
        FLogger.a.e("ActionBarRedDotCacheHelper", "setItemHasClicked save cache error=" + e.getMessage());
    L13:
        r3 = false;
        goto L14
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.larus.bmhome.view.actionbar.custom.cache.k
    public final void b(List<z0> r21, String r22) {
        Intrinsics.checkNotNullParameter(r22, "botId");
        if (r21 == null) goto L51;
        Iterator r3 = r21.iterator();
    L6:
        if (r3.hasNext() == false) goto L57;
        z0 r0 = (z0) r3.next();
        Long r4 = r0.a;
        if (r4 == null) goto L49;
        long r5 = r4.longValue();
        Long r6 = r0.t;
        if (r6 == null) goto L12;
        long r13 = r6.longValue();
    L13:
        g r11 = c(r22, String.valueOf(r5));
        if (this.e == true) goto L16;
    L37:
        Iterator r17 = r3;
        long r18 = r13;
    L38:
        String r1 = d(String.valueOf(r5), r22);
        if (r18 == r11.c()) goto L45;
        g r7 = g.a(r11, null, r18, 0, 1);
        String r8 = HttpExtKt.f.toJson(r7);     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L43
        f(r1, r7, r8);     // Catch: Exception -> L43
        FLogger.a.i("ActionBarRedDotCacheHelper", "checkAndUpdateHasRedDot save cache newEntityString=" + r8);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        FLogger.a.e("ActionBarRedDotCacheHelper", "checkAndUpdateHasRedDot save cache error=" + e.getMessage());
    L45:
        Iterator r2 = ((Set) h.getValue()).iterator();
    L47:
        if (r2.hasNext() == false) goto L50;
        ((IActionBarRedDotChecker) r2.next()).b();
    L50:
        r3 = r17;
        goto L6
    L16:
        if (r13 <= 0) goto L37;
        if (r11.c() >= r13) goto L20;
    L25:
        boolean r9 = true;
    L26:
        r0.y = r9;
        if (r9 == false) goto L31;
        r17 = r3;
        r18 = r13;
        FLogger.a.i("ActionBarRedDotCacheHelper", "cache itemId=" + r5 + ", itemVersion=" + r11.c() + ", redDotVersion=" + r0.t + ", hasRedDot=" + r0.y + ",maxExposureTimes:" + this.d + ",itemRedEntity.exposureTimes:" + r11.b() + ' ');
        Long r10 = r0.a;
        if (r10 == null) goto L33;
        this.b.put(Long.valueOf(r10.longValue()), r0);
    L33:
        if (r0.y == true) goto L38;
        if (this.a.contains(String.valueOf(r5)) == false) goto L38;
        FLogger.a.i("ActionBarRedDotCacheHelper", "has show before in this lifecycle, so need show again, itemId=" + r5 + ", itemVersion=" + r11.c() + ", redDotVersion=" + r0.t + ", hasRedDot=" + r0.y + ",maxExposureTimes:" + this.d + ",itemRedEntity.exposureTimes:" + r11.b() + ' ');
        r0.y = true;
        goto L38
    L31:
        r17 = r3;
        r18 = r13;
        goto L33
    L20:
        if (r11.c() == r13) goto L22;
    L24:
        r9 = false;
        goto L26
    L22:
        if (r11.b() >= this.d) goto L24;
    L12:
        r13 = 0;
        goto L13
    L49:
        r17 = r3;
        goto L50
    L57:
        return;
    }

    public final g c(String r5, String r6) {
        if (com.larus.platform.exp.a.f == false) goto L5;
        String r0 = d(r6, r5);
        Object r1 = g;
        monitor-enter(r1);
        LruCache<String, g> r2 = f;     // Catch: Throwable -> L25
        g r3 = r2.get(r0);     // Catch: Throwable -> L25
        if (r3 == null) goto L12;
        monitor-exit(r1);
        return r3;
    L12:
        monitor-exit(r1);
        g r7 = e(r5, r6);
        monitor-enter(r1);
        g r8 = r2.get(r0);     // Catch: Throwable -> L22
        if (r8 != null) goto L19;
        r2.put(r0, r7);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r1);
        return r7;
    L19:
        r7 = r8;
    L22:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;
    L5:
        return e(r5, r6);
    }

    public final g e(String r5, String r6) {
        g r7 = (g) HttpExtKt.f.fromJson(((Keva) this.c.getValue()).getString(d(r6, r5), "{}"), new b().getType());     // Catch: Exception -> L7
        if (r7 != null) goto L12;
        return new g(r6, 6);
    L12:
        return r7;
    L7:
        e = move-exception;
        FLogger.a.e("ActionBarRedDotCacheHelper", "save cache error=" + e.getMessage());
        return new g(r6, 6);
    }

    public final void f(String r3, g r4, String r5) {
        if (com.larus.platform.exp.a.f == false) goto L12;
        Object r0 = g;
        monitor-enter(r0);
        ((Keva) this.c.getValue()).storeString(r3, r5);     // Catch: Throwable -> L9
        g r6 = f.put(r3, r4);     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        ((Keva) this.c.getValue()).storeString(r3, r5);
    }
}
