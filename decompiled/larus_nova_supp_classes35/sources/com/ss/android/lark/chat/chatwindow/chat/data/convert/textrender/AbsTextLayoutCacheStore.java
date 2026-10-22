package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.text.Layout;
import android.view.View;
import androidx.collection.LruCache;
import androidx.core.util.Pools;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class AbsTextLayoutCacheStore implements z2b.a {
    public static final b d = null;
    public final LruCache<b, CharSequence> a;
    public final AbsTextLayoutCacheStore$layoutCache$1 b;
    public final ConcurrentHashMap<Integer, Pools.SynchronizedPool<View>> c;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore.KeyImpl");
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
            return false;
        L16:
            if (this.b == r6.b) goto L18;
            return false;
        L18:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public b(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            this.a = r2;
            this.b = r3;
        }
    }

    public abstract b f(TextLayoutRender.e r1);

    public abstract b g(TextLayoutRender.g r1);

    static {
        d = new b(BuildConfig.FLAVOR, 0);
    }

    @Override // z2b.a
    public final void clearCache() {
        evictAll();
        this.a.evictAll();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore$layoutCache$1] */
    public AbsTextLayoutCacheStore() {
        this.a = new LruCache(120);
        this.b = new AbsTextLayoutCacheStore$layoutCache$1(this);
        this.c = new ConcurrentHashMap(0);
    }

    @Override // z2b.a
    public final CharSequence b(z2b.b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "parseRequest");
        b r4 = f((TextLayoutRender.e) r3);
        if (Intrinsics.areEqual(r4, d) == false) goto L6;
        return null;
    L6:
        Log.d("TextLayoutCacheStore", "obtainCharSequence: " + r4.a + " , " + r4.b);
        return (CharSequence) this.a.get(r4);
    }

    @Override // z2b.a
    public final Layout c(z2b.b.InterfaceC0324b r3) {
        Intrinsics.checkNotNullParameter(r3, "renderRequest");
        b r4 = g((TextLayoutRender.g) r3);
        if (Intrinsics.areEqual(r4, d) == false) goto L6;
        return null;
    L6:
        Log.d("TextLayoutCacheStore", "obtainLayout: " + r4.a + " , " + r4.b);
        return (Layout) get(r4);
    }

    public final String e(Object r3) {
        return r3.getClass().getSimpleName() + '#' + r3.hashCode();
    }

    @Override // z2b.a
    public final void a(z2b.b.a r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "parseRequest");
        Intrinsics.checkNotNullParameter(r4, "charSequence");
        b r5 = f((TextLayoutRender.e) r3);
        if (Intrinsics.areEqual(r5, d) == false) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStore", "onCacheCharSequence: " + r5.a + " , " + r5.b);
        this.a.put(r5, r4);
    }

    @Override // z2b.a
    public final void d(z2b.b.InterfaceC0324b r3, Layout r4) {
        Intrinsics.checkNotNullParameter(r3, "renderRequest");
        Intrinsics.checkNotNullParameter(r4, "layout");
        b r5 = g((TextLayoutRender.g) r3);
        if (Intrinsics.areEqual(r5, d) == false) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStore", "onCacheLayout: " + r5.a + " , " + r5.b);
        put(r5, r4);
    }

    public final void h(final com.ss.android.lark.widget.light.viewstub.h r4, View r5) {
        Pools.SynchronizedPool<View> r0 = this.c.get(Integer.valueOf(new AbsTextLayoutCacheStore$recycleViewImplIfNeed$cachePool$1(r4).hashCode()));
        if (r0 != null) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStore", "recycle: span is " + e(r4) + " , view is " + e(r5));
        r0.release(r5);
    }
}
