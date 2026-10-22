package com.bytedance.applog.filter;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    public b(com.bytedance.applog.b r1, HashSet<String> r2, HashMap<String, HashSet<String>> r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.applog.filter.e
    public boolean a() {
        return false;
    }

    @Override // com.bytedance.applog.filter.a
    public boolean a(String r1) {
        return !this.f1590a.contains(r1);
    }

    @Override // com.bytedance.applog.filter.a
    public boolean a(HashSet<String> r1, String r2) {
        return !r1.contains(r2);
    }
}
