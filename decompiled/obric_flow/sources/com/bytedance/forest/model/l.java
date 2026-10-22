package com.bytedance.forest.model;

import android.content.Context;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f4384i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f4385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4387c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4388h;

    static {
        f4384i = LazyKt.lazy(GeckoConfig$Companion$configByRegistry$2.f4320a);
    }

    public l(String r5, String r10, long r11, String r12, String r13, String r14, boolean r15) {
        this.f4386b = r5;
        this.f4387c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f4388h = r15;
    }

    public final File a(Context r5) {
        boolean r10 = this.f4388h;
        String r11 = this.f4387c;
        if (r10 == true) goto L7;
        return new File(r11);
    L7:
        if (this.f4385a != null) goto L15;
        this.f4385a = r5.getFilesDir();
    L15:
        File r12 = new File(this.f4385a, r11);     // Catch: Exception -> L13
        if (r12.exists() == true) goto L12;
        r12.mkdirs();     // Catch: Exception -> L13
    L12:
        return r12;
    L14:
        return new File(r11);
    }
}
