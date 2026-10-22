package wc8;

import android.util.LruCache;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final b a = null;
    public static final LruCache<String, ConcurrentHashMap<String, a>> b = null;
    public static final LruCache<String, IMMetaInfo.InsertTextReference> c = null;
    public static final LruCache<String, RichMediaMeta> d = null;

    public b() {
    }

    static {
        a = new b();
        b = new LruCache(20);
        c = new LruCache(30);
        d = new LruCache(30);
    }

    public static RichMediaMeta e(String r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "parseCallback");
        if (r3 != null) goto L5;
        return null;
    L5:
        LruCache<String, RichMediaMeta> r1 = d;
        RichMediaMeta r2 = r1.get(r3);
        if (r2 != null) goto L11;
        RichMediaMeta r5 = (RichMediaMeta) r4.invoke(r3);
        if (r5 == null) goto L12;
        r1.put(r3, r5);
        return r5;
    L12:
        return null;
    L11:
        return r2;
    }

    public static IMMetaInfo.InsertTextReference f(String r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "parseCallback");
        if (r3 != null) goto L5;
        return null;
    L5:
        LruCache<String, IMMetaInfo.InsertTextReference> r1 = c;
        IMMetaInfo.InsertTextReference r2 = r1.get(r3);
        if (r2 != null) goto L11;
        IMMetaInfo.InsertTextReference r5 = (IMMetaInfo.InsertTextReference) r4.invoke(r3);
        if (r5 == null) goto L12;
        r1.put(r3, r5);
        return r5;
    L12:
        return null;
    L11:
        return r2;
    }

    public final synchronized String b(String r6, String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "valueId");     // Catch: Throwable -> L17
        Iterator<Map.Entry<String, ConcurrentHashMap<String, a>>> r0 = b.snapshot().entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        String r2 = null;
    L6:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<String, ConcurrentHashMap<String, a>> r3 = r0.next();     // Catch: Throwable -> L17
        if (r3.getValue().get(r6) == null) goto L6;
        a r4 = r3.getValue().get(r6);     // Catch: Throwable -> L17
        if (r4 == null) goto L4;
        r2 = r4.a;     // Catch: Throwable -> L17
        goto L6
    L12:
        if (r2 == null) goto L14;
        FLogger.a.d("TextContentCacheUtils", "getDataValue success✅✅ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return r2;
    L14:
        FLogger.a.d("TextContentCacheUtils", "getDataValue failed❌❌ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized a d(String r2, String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "messageId");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r3, "valueId");     // Catch: Throwable -> L10
        ConcurrentHashMap<String, a> r4 = b.get(r2);     // Catch: Throwable -> L10
        if (r4 == null) goto L7;
        a r5 = r4.get(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r5;
    L7:
        r5 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized RichMediaMeta g(String r6, String r7) {
        monitor-enter(this);
        Iterator<Map.Entry<String, ConcurrentHashMap<String, a>>> r0 = b.snapshot().entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        RichMediaMeta r1 = null;
    L6:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<String, ConcurrentHashMap<String, a>> r2 = r0.next();     // Catch: Throwable -> L17
        if (r2.getValue().get(r6) == null) goto L6;
        a r3 = r2.getValue().get(r6);     // Catch: Throwable -> L17
        if (r3 == null) goto L4;
        r1 = r3.c;     // Catch: Throwable -> L17
        goto L6
    L12:
        if (r1 == null) goto L14;
        FLogger.a.d("TextContentCacheUtils", "getRichMediaMeta success✅✅ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return r1;
    L14:
        FLogger.a.d("TextContentCacheUtils", "getRichMediaMeta failed❌❌ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r3, String r4, a r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "messageId");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r4, "valueId");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r5, "cache");     // Catch: Throwable -> L9
        LruCache<String, ConcurrentHashMap<String, a>> r0 = b;     // Catch: Throwable -> L9
        ConcurrentHashMap<String, a> r1 = r0.get(r3);     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.put(r4, r5);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        r0.put(r3, new ConcurrentHashMap(MapsKt.mapOf(TuplesKt.to(r4, r5))));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized String c(String r5, String r6, String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "valueId");     // Catch: Throwable -> L24
        if (r5 != null) goto L9;
        String r8 = b(r6, r7);     // Catch: Throwable -> L24
        monitor-exit(this);
        return r8;
    L9:
        ConcurrentHashMap<String, a> r9 = b.get(r5);     // Catch: Throwable -> L24
        if (r9 == null) goto L15;
        a r10 = r9.get(r6);     // Catch: Throwable -> L24
        if (r10 == null) goto L15;
        String r11 = r10.a;     // Catch: Throwable -> L24
    L16:
        if (r7 != null) goto L19;
        monitor-exit(this);
        return r11;
    L19:
        if (r11 == null) goto L21;
        FLogger.a.d("TextContentCacheUtils", "getDataValue success✅✅ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return r11;
    L21:
        FLogger.a.d("TextContentCacheUtils", "getDataValue failed❌❌ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L24
    L15:
        r11 = null;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized RichMediaMeta h(String r5, String r6, String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "valueId");     // Catch: Throwable -> L20
        if (r5 != null) goto L9;
        RichMediaMeta r8 = g(r6, r7);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r8;
    L9:
        ConcurrentHashMap<String, a> r9 = b.get(r5);     // Catch: Throwable -> L20
        if (r9 == null) goto L14;
        a r10 = r9.get(r6);     // Catch: Throwable -> L20
        if (r10 == null) goto L14;
        RichMediaMeta r11 = r10.c;     // Catch: Throwable -> L20
    L15:
        if (r11 == null) goto L17;
        FLogger.a.d("TextContentCacheUtils", "getRichMediaMeta success✅✅ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return r11;
    L17:
        FLogger.a.d("TextContentCacheUtils", "getRichMediaMeta failed❌❌ source:" + r7 + " valueId:" + r6);     // Catch: Throwable -> L20
    L14:
        r11 = null;
    L20:
        th = move-exception;
        throw th;
    }
}
