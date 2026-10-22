package com.bytedance.forest.pollyfill;

import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile FetchTask$State f4519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f4520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4521c;
    public Object d;
    public final boolean e;
    public final boolean f;
    public final w g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.forest.utils.e f4522h;

    public j(w r5, com.bytedance.forest.utils.e r10) {
        this.g = r5;
        this.f4522h = r10;
        this.f4519a = FetchTask$State.f4459a;
        Request r11 = r5.f4441q;
        boolean r12 = true;
        if (r11.getOnlyLocal() == false) goto L5;
    L10:
        boolean r13 = true;
    L11:
        this.e = r13;
        if (r13 == true) goto L18;
        Request r14 = r5.f4441q;
        if (r14.getOnlyOnline() == false) goto L16;
    L19:
        this.f = r12;
        return;
    L16:
        if (r14.getEnableCDNCache() == false) goto L19;
    L18:
        r12 = false;
        goto L19
    L5:
        if (com.bytedance.forest.utils.q.b() == true) goto L7;
    L9:
        r13 = false;
        goto L11
    L7:
        if (r11.isASync() == true) goto L9;
        goto L9
    }

    public abstract void a();
}
