package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.text.Layout;
import android.view.View;
import androidx.collection.LruCache;
import androidx.core.util.Pools;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextLayoutCacheStoreImpl2 implements z2b.a {
    public static final /* synthetic */ int e = 0;
    public final LruCache<String, j.a> a;
    public final LruCache<String, CharSequence> b;
    public final TextLayoutCacheStoreImpl2$layoutCache$1 c;
    public final ConcurrentHashMap<Integer, Pools.SynchronizedPool<View>> d;

    public static final class a {
    }

    static {
    }

    @Override // z2b.a
    public final void clearCache() {
        evictAll();
        this.b.evictAll();
        this.d.clear();
        this.a.evictAll();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2$layoutCache$1] */
    public TextLayoutCacheStoreImpl2() {
        this.a = new LruCache(512);
        this.b = new LruCache(120);
        this.c = new TextLayoutCacheStoreImpl2$layoutCache$1(this);
        this.d = new ConcurrentHashMap(0);
    }

    @Override // z2b.a
    public final CharSequence b(z2b.b.a r5) {
        Intrinsics.checkNotNullParameter(r5, "parseRequest");
        m r6 = (m) r5;
        j.a r0 = j.a;
        j.a r1 = j.a(r6.b);
        if (Intrinsics.areEqual(r1, j.a) == false) goto L6;
        return null;
    L6:
        CharSequence r2 = (CharSequence) this.b.get(r6.b.b + '-' + (r1.hashCode() + (r6.a.hashCode() * 31)));
        if (r2 != null) goto L9;
        e(r6.b, r1);
    L9:
        return r2;
    }

    @Override // z2b.a
    public final Layout c(z2b.b.InterfaceC0324b r5) {
        Intrinsics.checkNotNullParameter(r5, "renderRequest");
        p r6 = (p) r5;
        j.a r0 = j.a;
        j.a r1 = j.a(r6.b);
        if (Intrinsics.areEqual(r1, j.a) == false) goto L6;
        return null;
    L6:
        Layout r2 = (Layout) get(r6.b.b + '-' + (r1.hashCode() + (System.identityHashCode(r6.a) * 31)));
        if (r2 != null) goto L9;
        e(r6.b, r1);
    L9:
        return r2;
    }

    public final String f(Object r3) {
        return r3.getClass().getSimpleName() + '#' + r3.hashCode();
    }

    @Override // z2b.a
    public final void a(z2b.b.a r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(r4, "parseRequest");
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        m r6 = (m) r4;
        j.a r0 = j.a;
        j.a r1 = j.a(r6.b);
        if (Intrinsics.areEqual(r1, j.a) == false) goto L5;
        return;
    L5:
        String r2 = r6.b.b;
        int r3 = r1.hashCode() + (r6.a.hashCode() * 31);
        this.a.put(r2, r1);
        this.b.put(r2 + '-' + r3, r5);
    }

    @Override // z2b.a
    public final void d(z2b.b.InterfaceC0324b r4, Layout r5) {
        Intrinsics.checkNotNullParameter(r4, "renderRequest");
        Intrinsics.checkNotNullParameter(r5, "layout");
        p r6 = (p) r4;
        j.a r0 = j.a;
        j.a r1 = j.a(r6.b);
        if (Intrinsics.areEqual(r1, j.a) == false) goto L5;
        return;
    L5:
        String r2 = r6.b.b;
        int r3 = r1.hashCode() + (System.identityHashCode(r6.a) * 31);
        this.a.put(r2, r1);
        put(r2 + '-' + r3, r5);
    }

    public final void e(n r5, j.a r6) {
        String r7 = r5.b;
        j.a r0 = (j.a) this.a.get(r7);
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0, r6) == false) goto L8;
        return;
    L8:
        StringBuilder r1 = new StringBuilder();
        if (r0.a == r6.a) goto L12;
        r1.append(" contextHash changed");
    L12:
        if (r0.b == r6.b) goto L15;
        r1.append(" richTextNodeParseHash changed");
    L15:
        if (r0.c == r6.c) goto L18;
        r1.append(" themeParseHash changed");
    L18:
        if (r0.d == r6.d) goto L21;
        r1.append(" markdownPluginHash changed");
    L21:
        if (r0.e == r6.e) goto L23;
        r1.append(" parseListenersHash changed");
    L23:
        Log.i("TextLayoutCacheStoreImpl", "message " + r7 + ", obtain data not hit cache, because " + r1);
    }

    public final void g(final com.ss.android.lark.widget.light.viewstub.h r4, View r5) {
        Pools.SynchronizedPool<View> r0 = this.d.get(Integer.valueOf(new TextLayoutCacheStoreImpl2$recycleViewImplIfNeed$cachePool$1(r4).hashCode()));
        if (r0 != null) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStoreImpl", "recycle: span is " + f(r4) + " , view is " + f(r5));
        r0.release(r5);
    }
}
