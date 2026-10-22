package com.bytedance.ies.bullet.service.base;

import ai.j0;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f5932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceType f5934c;
    public final ResourceFrom d;
    public final boolean e;
    public final long f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InputStream f5935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fc.a f5936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f5937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f5938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f5939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f5941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f5942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f5944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f5945r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f5946t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f5947u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WebResourceResponse f5948v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ug.d f5949w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ug.d f5950x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final z f5951y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f5952z;

    public a0(Uri r5, String r10, ResourceType r11, ResourceFrom r12, boolean r13, long r14, InputStream r15, fc.a r16, String r17, long r18, int r19) {
        if ((r19 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r19 & 4) == 0) goto L9;
        r11 = null;
    L9:
        if ((r19 & 8) == 0) goto L12;
        r12 = null;
    L12:
        if ((r19 & 16) == 0) goto L15;
        r13 = false;
    L15:
        if ((r19 & 32) == 0) goto L18;
        r14 = 0;
    L18:
        if ((r19 & 128) == 0) goto L21;
        r15 = null;
    L21:
        if ((r19 & 256) == 0) goto L24;
        r16 = null;
    L24:
        if ((r19 & 512) == 0) goto L26;
        r17 = "";
    L26:
        Intrinsics.checkNotNullParameter(r5, "srcUri");
        Intrinsics.checkNotNullParameter(r17, "successLoader");
        this.f5932a = r5;
        this.f5933b = r10;
        this.f5934c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = true;
        this.f5935h = r15;
        this.f5936i = r16;
        this.f5937j = r18;
        this.f5941n = "";
        this.f5942o = "";
        this.f5944q = "";
        this.f5945r = "";
        this.s = "";
        this.f5946t = "";
        this.f5947u = "";
        this.f5949w = new ug.d("bdx_resourceloader_fetch");
        this.f5950x = new ug.d("bdx_resourceloader_performance");
        this.f5951y = new z();
        new ArrayList();
    }

    public final String a() {
        if (this.f5943p == false) goto L5;
        return "preload";
    L5:
        ResourceFrom r5 = this.d;
        if (r5 != null) goto L8;
        int r10 = -1;
    L9:
        boolean r11 = this.e;
        if (r10 != 1) goto L12;
        if (r11 == false) goto L36;
        return "gecko";
    L36:
        return "geckoUpdate";
    L12:
        if (r10 == 2) goto L29;
        if (r10 != 3) goto L16;
        if (r11 == false) goto L26;
        return "cdnCache";
    L26:
        return "cdn";
    L16:
        if (r10 != 4) goto L18;
        return "offline";
    L18:
        if (r10 == 5) goto L21;
        return "custom";
    L21:
        return "preload";
    L29:
        if (this.f5934c != ResourceType.f5929b) goto L32;
        return "buildIn";
    L32:
        return "offline";
    L8:
        r10 = y.f6028a[r5.ordinal()];
        goto L9
    }

    public byte[] b() {
        InputStream r5 = c();
        if (r5 != null) goto L5;
        return null;
    L5:
        return ByteStreamsKt.readBytes(r5);
    }

    public final InputStream c() {
        String r5 = this.f5933b;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        File r10 = new File(r5);
        InputStream r11 = this.f5935h;
        if (r11 == null) goto L9;
        return r11;
    L9:
        if (r10.exists() == true) goto L11;
        return null;
    L11:
        if (r10.isDirectory() == false) goto L13;
        return null;
    L13:
        return new FileInputStream(r10);
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("[srcUri=");
        r5.append(this.f5932a);
        r5.append(", filePath=");
        r5.append(this.f5933b);
        r5.append(", type=");
        r5.append(this.f5934c);
        r5.append(",from=");
        r5.append(this.d);
        r5.append(", fileStream=");
        r5.append(this.f5935h);
        r5.append(", model=");
        r5.append(this.f5936i);
        r5.append(", accessKey=");
        return j0.q(r5, this.f5947u, "}]");
    }
}
