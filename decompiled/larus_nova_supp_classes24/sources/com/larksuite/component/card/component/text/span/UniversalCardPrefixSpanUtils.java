package com.larksuite.component.card.component.text.span;

import android.util.LruCache;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardPrefixSpanUtils {
    public static final UniversalCardPrefixSpanUtils a = null;
    public static final LruCache<String, String> b = null;
    public static final LruCache<String, Float> c = null;
    public static final LruCache<Integer, Float> d = null;
    public static final LruCache<String, Float> e = null;
    public static final LruCache<Integer, Float> f = null;
    public static final LruCache<String, Float> g = null;
    public static final Lazy h = null;

    public UniversalCardPrefixSpanUtils() {
    }

    static {
        a = new UniversalCardPrefixSpanUtils();
        b = new LruCache(5);
        c = new LruCache(5);
        d = new LruCache(5);
        e = new LruCache(5);
        f = new LruCache(5);
        g = new LruCache(5);
        h = LazyKt.lazy(UniversalCardPrefixSpanUtils$themeColor$2.INSTANCE);
    }
}
