package com.bytedance.vmsdk.jsbridge;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f7556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7557c;

    public final String toString() {
        StringBuilder r5 = new StringBuilder("[");
        r5.append(this.f7556b.getSimpleName());
        r5.append(" - ");
        return j0.q(r5, this.f7555a, "]");
    }
}
