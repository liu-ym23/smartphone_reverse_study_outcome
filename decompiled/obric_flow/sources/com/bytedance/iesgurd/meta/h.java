package com.bytedance.iesgurd.meta;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6658c;
    public long d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap f6662k;

    public h() {
        this.f6662k = new HashMap();
    }

    public final g a(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "patch_";
    L5:
        HashMap r11 = this.f6662k;
        g r12 = (g) r11.get(r10);
        if (r12 != null) goto L9;
        g r13 = new g(r10);
        r11.put(r10, r13);
        return r13;
    L9:
        return r12;
    L4:
        r10 = "full_";
        goto L5
    }
}
