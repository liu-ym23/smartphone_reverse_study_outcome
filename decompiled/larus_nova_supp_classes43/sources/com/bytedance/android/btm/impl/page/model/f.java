package com.bytedance.android.btm.impl.page.model;

import android.app.Activity;
import com.bytedance.android.btm.impl.page.PageWoods;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements d {
    public String a;
    public String b;
    public String c;
    public String d;
    public final com.bytedance.android.btm.impl.util.f<Object> e;
    public boolean f;
    public boolean g;

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final Object a() {
        return this.e.get();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final h b() {
        ConcurrentHashMap<com.bytedance.android.btm.impl.util.f<Activity>, h> r0 = PageWoods.a;
        String r1 = this.b;
        if (r1 != null) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (r10 == true) goto L22;
        Iterator<Map.Entry<com.bytedance.android.btm.impl.util.f<Activity>, h>> r11 = PageWoods.a.entrySet().iterator();
    L14:
        if (r11.hasNext() == false) goto L23;
        Map.Entry<com.bytedance.android.btm.impl.util.f<Activity>, h> r12 = r11.next();
        if (Intrinsics.areEqual(r12.getValue().a, r1) == false) goto L14;
        return r12.getValue();
    L23:
        return null;
    L22:
        return null;
    L5:
        if (r1.length() == 0) goto L8;
        r10 = false;
        goto L10
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d getParentNode() {
        String r0 = this.c;
        if (r0 == null) goto L9;
        h r1 = b();
        if (r1 == null) goto L9;
        ConcurrentHashMap<String, f> r10 = r1.b;
        if (r10 == null) goto L9;
        return r10.get(r0);
    L9:
        return null;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d j() {
        String r0 = this.d;
        if (r0 == null) goto L9;
        h r1 = b();
        if (r1 == null) goto L9;
        ConcurrentHashMap<String, f> r10 = r1.b;
        if (r10 == null) goto L9;
        return r10.get(r0);
    L9:
        return null;
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("is_page", this.f);     // Catch: Throwable -> L6
        r0.put("is_container", this.g);     // Catch: Throwable -> L6
        r0.put("node_id", this.a);     // Catch: Throwable -> L6
        r0.put("tree_id", this.b);     // Catch: Throwable -> L6
        r0.put("parent_node_id", this.c);     // Catch: Throwable -> L6
        r0.put("pre_node_id", this.d);     // Catch: Throwable -> L6
    L5:
        return r0.toString();
    }

    public final String save() {
        return toString();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String d() {
        return this.b;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String h() {
        return this.a;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean i() {
        return this.f;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean isContainer() {
        return this.g;
    }

    public f(Object r10) {
        this.a = com.bytedance.android.btm.impl.util.e.b();
        this.e = new com.bytedance.android.btm.impl.util.f(r10);
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void c(d r10) {
        String r0 = null;
        if (r10 == null) goto L5;
        String r1 = r10.h();
    L6:
        this.c = r1;
        if (r10 == null) goto L9;
        r0 = r10.d();
    L9:
        this.b = r0;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void f(String r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void g(d r1) {
        if (r1 == null) goto L4;
        String r10 = r1.h();
    L5:
        this.d = r10;
        return;
    L4:
        r10 = null;
        goto L5
    }

    public final Object parse(String r10) {
        JSONObject r0 = new JSONObject(r10);     // Catch: Exception -> L4
        this.f = r0.optBoolean("is_page");     // Catch: Exception -> L4
        this.g = r0.optBoolean("is_container");     // Catch: Exception -> L4
        this.a = r0.optString("node_id");     // Catch: Exception -> L4
        this.b = r0.optString("tree_id");     // Catch: Exception -> L4
        this.c = r0.optString("parent_node_id");     // Catch: Exception -> L4
        this.d = r0.optString("pre_node_id");     // Catch: Exception -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void e(boolean r1, boolean r10) {
        this.f = r1;
        this.g = r10;
    }
}
