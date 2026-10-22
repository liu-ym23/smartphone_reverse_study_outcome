package com.bytedance.forest.model;

import com.bytedance.forest.Forest;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f4402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Forest f4404c;
    public volatile com.bytedance.forest.chain.a d;
    public volatile Status e;

    public s(t r5, String r10, Forest r11, com.bytedance.forest.chain.a r12, Status r13) {
        this.f4402a = r5;
        this.f4403b = r10;
        this.f4404c = r11;
        this.d = r12;
        this.e = r13;
    }

    public w a() {
        if (this.e == Status.f4356a) goto L6;
        return null;
    L6:
        this.e = Status.f4357b;
        return this.f4404c.fetchSync$forest_release(this);
    }
}
