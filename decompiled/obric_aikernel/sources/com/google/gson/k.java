package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedTreeMap<String, i> f4274a;

    public k() {
        this.f4274a = new LinkedTreeMap(false);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof k) == true) goto L6;
    L8:
        return false;
    L6:
        if (((k) r10).f4274a.equals(this.f4274a) == false) goto L8;
        goto L8
    }

    public int hashCode() {
        return this.f4274a.hashCode();
    }

    public void m(String r10, i r11) {
        LinkedTreeMap<String, i> r12 = this.f4274a;
        if (r11 != null) goto L5;
        r11 = j.f4273a;
    L5:
        r12.put(r10, r11);
    }

    public void n(String r10, Boolean r11) {
        if (r11 != null) goto L4;
        i r12 = j.f4273a;
    L5:
        m(r10, r12);
        return;
    L4:
        r12 = new m(r11);
        goto L5
    }

    public void o(String r10, Number r11) {
        if (r11 != null) goto L4;
        i r12 = j.f4273a;
    L5:
        m(r10, r12);
        return;
    L4:
        r12 = new m(r11);
        goto L5
    }

    public void p(String r10, String r11) {
        if (r11 != null) goto L4;
        i r12 = j.f4273a;
    L5:
        m(r10, r12);
        return;
    L4:
        r12 = new m(r11);
        goto L5
    }

    public Map<String, i> q() {
        return this.f4274a;
    }

    public Set<Map.Entry<String, i>> r() {
        return this.f4274a.entrySet();
    }

    public i s(String r10) {
        return this.f4274a.get(r10);
    }

    public f t(String r10) {
        return (f) this.f4274a.get(r10);
    }

    public k u(String r10) {
        return (k) this.f4274a.get(r10);
    }

    public m v(String r10) {
        return (m) this.f4274a.get(r10);
    }

    public boolean w(String r10) {
        return this.f4274a.containsKey(r10);
    }

    public Set<String> x() {
        return this.f4274a.keySet();
    }
}
