package com.bytedance.ai.core.base;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class i {
    public final String a;
    public final SessionType b;
    public String c;
    public final HashMap<String, h> d;

    public boolean a() {
        if (this.d.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(Object r1) {
        return super.equals(r1);
    }

    public i(String r1, SessionType r10) {
        this.a = r1;
        this.b = r10;
        this.d = new HashMap();
    }
}
