package com.bytedance.android.livesdk.feed.tab.repository;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class n implements q {
    public final Context a;
    public final xw1.c b;
    public List<com.bytedance.android.livesdk.feed.feed.e> c;
    public final com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> d;
    public final Gson e;
    public final Map<Long, com.bytedance.android.livesdk.feed.feed.e> f;
    public com.bytedance.android.livesdk.feed.feed.f g;
    public final xw1.b h;

    public class a extends TypeToken<List<com.bytedance.android.livesdk.feed.feed.e>> {
        public a() {
        }
    }

    public class b extends TypeToken<com.bytedance.android.livesdk.feed.feed.f> {
        public b() {
        }
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final void d() {
        this.c = null;
        Context r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.e == null) goto L9;
        SharedPreferences.Editor r1 = r0.getSharedPreferences("ttlive_tabs_cache", 0).edit();
        r1.putString(this.h.b(), GsonProtectorUtils.toJson(this.e, new ArrayList()));
        SharedPrefsEditorCompat.apply(r1);
        return;
    }

    public final synchronized void g() {
        monitor-enter(this);
        List<com.bytedance.android.livesdk.feed.feed.e> r0 = this.c;     // Catch: Throwable -> L22
        boolean r1 = true;
        if (r0 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L20;
        i((List) h(new a(), this.h.b()));     // Catch: Throwable -> L22
        List<com.bytedance.android.livesdk.feed.feed.e> r3 = this.c;     // Catch: Throwable -> L22
        if (r3 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == true) goto L18;
        i(this.b.a());     // Catch: Throwable -> L22
    L18:
        monitor-exit(this);
        return;
    L13:
        if (r3.isEmpty() == true) goto L15;
    L20:
        monitor-exit(this);
        return;
    L6:
        if (r0.isEmpty() == true) goto L8;
        r2 = true;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final Observable<List<com.bytedance.android.livesdk.feed.feed.e>> e() {
        return Observable.create(new m(this)).subscribeOn(Schedulers.io());
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final com.bytedance.android.livesdk.feed.feed.f getExtra() {
        com.bytedance.android.livesdk.feed.feed.f r0 = (com.bytedance.android.livesdk.feed.feed.f) h(new b(), this.h.a());
        this.g = r0;
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final List<com.bytedance.android.livesdk.feed.feed.e> b() {
        g();
        return new ArrayList(this.c);
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final synchronized boolean a(List<com.bytedance.android.livesdk.feed.feed.e> r5) {
        monitor-enter(this);
        if (r5 != null) goto L42;
    L40:
        monitor-exit(this);
        return false;
    L42:
    L37:
        th = move-exception;
        throw th;
    L6:
        if (r5.isEmpty() == true) goto L40;
        if (r5.isEmpty() == true) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L20;
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r2 = r5.iterator();     // Catch: Throwable -> L37
    L15:
        if (r2.hasNext() == false) goto L21;
        com.bytedance.android.livesdk.feed.feed.e r3 = r2.next();     // Catch: Throwable -> L37
        if (r3 == null) goto L20;
        if (r3.q() == true) goto L15;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L40;
        if (this.d.a(r5, this.c) == false) goto L28;
        monitor-exit(this);
        return false;
    L28:
        i(new ArrayList(r5));     // Catch: Throwable -> L37
        String r6 = GsonProtectorUtils.toJson(this.e, r5);     // Catch: JsonIOException -> L33 Throwable -> L37
        SharedPreferences.Editor r0 = this.a.getSharedPreferences("ttlive_tabs_cache", 0).edit();     // Catch: Throwable -> L37
        r0.putString(this.h.b(), r6);     // Catch: Throwable -> L37
        SharedPrefsEditorCompat.apply(r0);     // Catch: Throwable -> L37
        monitor-exit(this);
        return true;
    L33:
        e = move-exception;
        Logger.e("BaseLocalFeedTabDataSource", "saveFeedTab: ", e);     // Catch: Throwable -> L37
        return false;
    L20:
        r4 = false;
        goto L22
    L10:
        r1 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final boolean c(com.bytedance.android.livesdk.feed.feed.f r7) {
        if (r7 == null) goto L16;
        com.bytedance.android.livesdk.feed.feed.f r1 = this.g;
        if (r1 == null) goto L17;
        if (((Extra) r7).now >= ((Extra) r1).now) goto L17;
        return true;
    L17:
        String r2 = GsonProtectorUtils.toJson(this.e, r7);     // Catch: JsonIOException -> L13
        SharedPreferences.Editor r3 = this.a.getSharedPreferences("ttlive_tabs_cache", 0).edit();
        r3.putString(this.h.a(), r2);
        SharedPrefsEditorCompat.apply(r3);
        this.g = r7;
        return true;
    L13:
        e = move-exception;
        Logger.e("BaseLocalFeedTabDataSource", "saveFeedTabExtra: ", e);
        return false;
    L16:
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final com.bytedance.android.livesdk.feed.feed.e f(long r2) {
        g();
        Map<Long, com.bytedance.android.livesdk.feed.feed.e> r0 = this.f;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        return (com.bytedance.android.livesdk.feed.feed.e) r1.get(Long.valueOf(r2));
    }

    public final synchronized void i(List<com.bytedance.android.livesdk.feed.feed.e> r5) {
        monitor-enter(this);
        int r0 = o.a;     // Catch: Throwable -> L26
        if (r5 != null) goto L6;
        List<com.bytedance.android.livesdk.feed.feed.e> r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L26
    L14:
        this.c = r6;     // Catch: Throwable -> L26
        if (Lists.isEmpty(r6) == true) goto L24;
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r7 = r6.iterator();     // Catch: Throwable -> L26
    L18:
        if (r7.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.feed.feed.e r1 = r7.next();     // Catch: Throwable -> L26
        if (r1 == null) goto L18;
        Map<Long, com.bytedance.android.livesdk.feed.feed.e> r2 = this.f;     // Catch: Throwable -> L26
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;     // Catch: Throwable -> L26
        r3.put(Long.valueOf(r1.f()), r1);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L6:
        List<com.bytedance.android.livesdk.feed.feed.e> r8 = r5;     // Catch: Throwable -> L26
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));     // Catch: Throwable -> L26
        Iterator<T> r9 = r8.iterator();     // Catch: Throwable -> L26
    L8:
        if (r9.hasNext() == false) goto L13;
        com.bytedance.android.livesdk.feed.feed.e r10 = (com.bytedance.android.livesdk.feed.feed.e) r9.next();     // Catch: Throwable -> L26
        if (r10.getType() > 0) goto L12;
        r10.E(1);     // Catch: Throwable -> L26
    L12:
        r4.add(r10);     // Catch: Throwable -> L26
        goto L8
    L13:
        r6 = r4;
    L26:
        th = move-exception;
        throw th;
    }

    public final Object h(TypeToken r4, String r5) {
        String r6 = this.a.getSharedPreferences("ttlive_tabs_cache", 0).getString(r5, "");
        if (StringUtils.isEmpty(r6) == false) goto L10;
        return null;
    L10:
        return JsonUtil.parse(r6, r4.getType());
    L7:
        e = move-exception;
        Logger.throwException(e);
        return null;
    }

    public n(xw1.b r2, xw1.d r3, Context r4, com.bytedance.android.livesdk.feed.n r5) {
        this.f = new ConcurrentHashMap();
        this.g = null;
        this.h = r2;
        this.b = r3;
        this.a = r4;
        this.d = r5;
        int r6 = com.bytedance.android.livesdk.feed.services.d.a;
        this.e = (Gson) com.bytedance.android.livesdk.feed.services.c.b(Gson.class);
    }
}
