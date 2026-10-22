package com.bumptech.glide.load.a;

import android.net.Uri;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f608b;
    private final URL c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;
    private int h;

    public h(String r2) {
        this(r2, i.f610b);
    }

    public h(String r3, i r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        this.c = null;
        this.d = com.bumptech.glide.util.j.a(r3);
        this.f608b = (i) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r5), i.class, "com.obric.memorydata.plugin");
    }

    public h(URL r2) {
        this(r2, i.f610b);
    }

    public h(URL r3, i r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        this.c = (URL) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r3), URL.class, "com.obric.memorydata.plugin");
        this.d = null;
        this.f608b = (i) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r5), i.class, "com.obric.memorydata.plugin");
    }

    private URL d() {
        if (this.f != null) goto L6;
        this.f = new URL(e());
    L6:
        return this.f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.e) == false) goto L9;
        String r0 = this.d;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = ((URL) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(this.c), URL.class, "com.obric.memorydata.plugin")).toString();
    L7:
        this.e = Uri.encode(r0, "@#&=*+-_.,:!?()/~'%;$");
    L9:
        return this.e;
    }

    private byte[] f() {
        if (this.g != null) goto L6;
        this.g = c().getBytes(f667a);
    L6:
        return this.g;
    }

    public URL a() {
        return d();
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r1) {
        r1.update(f());
    }

    public Map<String, String> b() {
        return this.f608b.a();
    }

    public String c() {
        String r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ((URL) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(this.c), URL.class, "com.obric.memorydata.plugin")).toString();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, h.class) == false) goto L10;
        h r5 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin");
        if (c().equals(r5.c()) == true) goto L7;
        return false;
    L7:
        if (this.f608b.equals(r5.f608b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.h != 0) goto L6;
        int r0 = c().hashCode();
        this.h = r0;
        this.h = (r0 * 31) + this.f608b.hashCode();
    L6:
        return this.h;
    }

    public String toString() {
        return c();
    }
}
