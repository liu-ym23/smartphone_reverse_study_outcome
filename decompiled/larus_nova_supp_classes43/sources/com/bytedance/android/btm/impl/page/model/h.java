package com.bytedance.android.btm.impl.page.model;

import android.app.Activity;
import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements xc.a<h> {
    public String a;
    public final ConcurrentHashMap<String, f> b;
    public final d c;
    public boolean d;
    public String e;
    public boolean f;
    public ActivityResumeOrigin g;
    public final a h;
    public final List<com.bytedance.android.btm.impl.util.f<Object>> i;
    public final List<com.bytedance.android.btm.impl.util.f<Object>> j;
    public final Map<com.bytedance.android.btm.impl.util.f<Object>, ResumeFuncOrigin> k;

    public final Collection<? extends d> n() {
        if (BtmSetting.d.c().d().q() == 1) goto L5;
        d r0 = this.c;
        if (r0 == null) goto L11;
        return ((e) r0).k();
    L11:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.btm.impl.page.model.Node");
    L5:
        return this.b.values();
    }

    public final String save() {
        JSONObject r0 = new JSONObject();
        r0.put("tree_id", this.a);     // Catch: Throwable -> L6
        r0.put("top_node_id", this.e);     // Catch: Throwable -> L6
        r0.put("root_node", this.c.save());     // Catch: Throwable -> L6
    L5:
        return r0.toString();
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("tree_id", this.a);     // Catch: Throwable -> L10
        r0.put("root_node_id", this.c.h());     // Catch: Throwable -> L10
        r0.put("top_node_id", this.e);     // Catch: Throwable -> L10
        r0.put("mResumed", this.d);     // Catch: Throwable -> L10
        r0.put("activityResumeOrigin", this.g);     // Catch: Throwable -> L10
        r0.put("activityResumeOriginV2", this.h);     // Catch: Throwable -> L10
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L10
        Iterator<Map.Entry<String, f>> r10 = this.b.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r10.hasNext() == false) goto L7;
        Map.Entry<String, f> r11 = r10.next();     // Catch: Throwable -> L10
        r1.put(r11.getKey(), r11.getValue().toString());     // Catch: Throwable -> L10
        goto L5
    L7:
        r0.put("nodes", r1);     // Catch: Throwable -> L10
    L9:
        return r0.toString();
    }

    public h(Activity r10) {
        AtomicLong r0 = com.bytedance.android.btm.impl.util.e.a;
        AtomicLong r1 = com.bytedance.android.btm.impl.util.e.b;
        long r11 = r1.incrementAndGet();
        if (r11 <= ServerInfo.ERROR_BIND_SERVICE) goto L5;
        r1.set(0);
    L5:
        this.a = "" + System.currentTimeMillis() + "_" + r11;
        ConcurrentHashMap<String, f> r12 = new ConcurrentHashMap();
        this.b = r12;
        if (BtmSetting.d.c().d().q() != 1) goto L8;
        f r13 = new f(r10);
        r13.b = this.a;
        r12.put(r13.a, r13);
        d r14 = r13;
    L9:
        this.c = r14;
        this.d = true;
        this.h = new a();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new LinkedHashMap();
        return;
    L8:
        e r15 = new e(r10);
        r15.b = this;
        r14 = r15;
        goto L9
    }

    public final d l(Object r10) {
        Iterator<T> r0 = n().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        d r1 = (d) r0.next();
        if (Intrinsics.areEqual(r1.a(), r10) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public final d m(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        if (BtmSetting.d.c().d().q() == 1) goto L15;
        Iterator<T> r0 = n().iterator();
    L18:
        if (r0.hasNext() == false) goto L22;
        d r11 = (d) r0.next();
        if (Intrinsics.areEqual(r11.h(), r10) == false) goto L18;
        return r11;
    L22:
        return null;
    L15:
        return this.b.get(r10);
    L5:
        if (r10.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final void k(d r10, d r11) {
        r10.c(r11);
        if (BtmSetting.d.c().d().q() == 1) goto L5;
        return;
    L5:
        if ((r10 instanceof f) == true) goto L7;
        r10 = null;
    L7:
        f r12 = (f) r10;
        if (r12 == null) goto L12;
        this.b.put(r12.a, r12);
        return;
    }
}
