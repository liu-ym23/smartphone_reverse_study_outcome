package com.obric.oui.orecyclerview.widget;

import android.util.SparseArray;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray f13879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f13881c;

    public final o0 a(int r5) {
        SparseArray r10 = this.f13879a;
        o0 r11 = (o0) r10.get(r5);
        if (r11 != null) goto L6;
        o0 r12 = new o0();
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }
}
