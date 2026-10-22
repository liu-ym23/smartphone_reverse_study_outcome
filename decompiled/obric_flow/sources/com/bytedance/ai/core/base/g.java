package com.bytedance.ai.core.base;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SessionType f2095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f2096c;

    public g(String r5, SessionType r10) {
        this.f2094a = r5;
        this.f2095b = r10;
        this.f2096c = new HashMap();
    }

    public boolean a() {
        if (this.f2096c.size() == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        return this.f2094a.hashCode();
    }
}
