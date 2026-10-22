package com.ss.android.common.applog.a;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes6.dex */
public class b extends a {
    public b(HashSet<String> r1, HashMap<String, HashSet<String>> r2) {
        super(r1, r2);
    }

    @Override // com.ss.android.common.applog.a.a
    public boolean a(String r1) {
        return this.f15045a.contains(r1);
    }

    @Override // com.ss.android.common.applog.a.a
    public boolean a(HashSet<String> r1, String r2) {
        return r1.contains(r2);
    }
}
