package com.bytedance.crash.util;

import java.io.File;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f4170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4172c;
    public int d;
    public int e;

    public a(File r5) {
        this.f4171b = 0;
        this.f4172c = 0;
        this.d = 0;
        this.e = 1;
        this.f4170a = r5;
        if (r5.exists() == false) goto L10;
        JSONArray r10 = cl.a.d(-1, r5);     // Catch: Throwable -> L7
        this.f4171b = Integer.parseInt(r10.optString(0));     // Catch: Throwable -> L7
        this.f4172c = Integer.parseInt(r10.optString(1));     // Catch: Throwable -> L7
        this.d = Integer.parseInt(r10.optString(2));     // Catch: Throwable -> L7
        this.e = Integer.parseInt(r10.optString(3));     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }
}
