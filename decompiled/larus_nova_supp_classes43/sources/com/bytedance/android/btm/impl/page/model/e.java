package com.bytedance.android.btm.impl.page.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "use NodeV2 instead.")
public final class e implements d {
    public String a;
    public h b;
    public final com.bytedance.android.btm.impl.util.f<Object> c;
    public int d;
    public boolean e;
    public boolean f;
    public e g;
    public final List<e> h;
    public e i;

    public final Object parse(String r1) {
        return this;
    }

    public final String save() {
        return "";
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final Object a() {
        return this.c.get();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String d() {
        h r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final List<e> k() {
        ArrayList r0 = new ArrayList();
        r0.add(this);
        Iterator<T> r1 = this.h.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(((e) r1.next()).k());
        goto L4
    L6:
        return r0;
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        Object r10 = this.c.get();     // Catch: Throwable -> L21
        String r11 = null;
        if (r10 == null) goto L6;
        String r12 = r10.getClass().getName();     // Catch: Throwable -> L21
    L7:
        r0.put("class_name", r12);     // Catch: Throwable -> L21
        r0.put("is_page", this.e);     // Catch: Throwable -> L21
        r0.put("is_container", this.f);     // Catch: Throwable -> L21
        r0.put("layer", this.d);     // Catch: Throwable -> L21
        r0.put("node_id", this.a);     // Catch: Throwable -> L21
        e r13 = this.g;     // Catch: Throwable -> L21
        if (r13 == null) goto L10;
        String r14 = r13.a;     // Catch: Throwable -> L21
    L11:
        r0.put("parent_node_id", r14);     // Catch: Throwable -> L21
        e r15 = this.i;     // Catch: Throwable -> L21
        if (r15 == null) goto L14;
        r11 = r15.a;     // Catch: Throwable -> L21
    L14:
        r0.put("pre_node_id", r11);     // Catch: Throwable -> L21
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r17 = ((ArrayList) this.h).iterator();     // Catch: Throwable -> L21
    L16:
        if (r17.hasNext() == false) goto L18;
        r16.put(((e) r17.next()).toString());     // Catch: Throwable -> L21
        goto L16
    L18:
        r0.put("children", r16);     // Catch: Throwable -> L21
        goto L20
    L10:
        r14 = null;
        goto L11
    L6:
        r12 = null;
    L20:
        return r0.toString();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final h b() {
        return this.b;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d getParentNode() {
        return this.g;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String h() {
        return this.a;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean i() {
        return this.e;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean isContainer() {
        return this.f;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d j() {
        return this.i;
    }

    public e(Object r10) {
        this.a = com.bytedance.android.btm.impl.util.e.b();
        this.c = new com.bytedance.android.btm.impl.util.f(r10);
        this.h = new ArrayList();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void c(d r10) {
        if ((r10 instanceof e) == true) goto L5;
        r10 = null;
    L5:
        e r11 = (e) r10;
        if (r11 == null) goto L9;
        ((ArrayList) r11.h).add(this);
        this.g = r11;
        this.d = r11.d + 1;
        this.b = r11.b;
        return;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void f(String r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void g(d r10) {
        if ((r10 instanceof e) == true) goto L5;
        r10 = null;
    L5:
        this.i = (e) r10;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void e(boolean r1, boolean r10) {
        this.e = r1;
        this.f = r10;
    }
}
