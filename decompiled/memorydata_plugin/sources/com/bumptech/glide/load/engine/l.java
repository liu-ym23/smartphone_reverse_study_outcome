package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class l implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f802b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final com.bumptech.glide.load.c g;
    private final Map<Class<?>, com.bumptech.glide.load.h<?>> h;
    private final com.bumptech.glide.load.e i;
    private int j;

    l(Object r3, com.bumptech.glide.load.c r4, int r5, int r6, Map<Class<?>, com.bumptech.glide.load.h<?>> r7, Class<?> r8, Class<?> r9, com.bumptech.glide.load.e r10) {
        com.bumptech.glide.load.c r11 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        this.f802b = com.bumptech.glide.util.j.a(r3);
        this.g = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r11, "Signature must not be null"), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = r6;
        this.h = (Map) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r12), Map.class, "com.obric.memorydata.plugin");
        this.e = (Class) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r8, "Resource class must not be null"), Class.class, "com.obric.memorydata.plugin");
        this.f = (Class) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r9, "Transcode class must not be null"), Class.class, "com.obric.memorydata.plugin");
        this.i = (com.bumptech.glide.load.e) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r10), com.bumptech.glide.load.e.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, l.class) == false) goto L22;
        l r5 = (l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.memorydata.plugin");
        if (this.f802b.equals(r5.f802b) == true) goto L7;
        return false;
    L7:
        if (this.g.equals(r5.g) == true) goto L9;
        return false;
    L9:
        if (this.d == r5.d) goto L11;
        return false;
    L11:
        if (this.c == r5.c) goto L13;
        return false;
    L13:
        if (this.h.equals(r5.h) == true) goto L15;
        return false;
    L15:
        if (this.e.equals(r5.e) == true) goto L17;
        return false;
    L17:
        if (this.f.equals(r5.f) == true) goto L19;
        return false;
    L19:
        if (this.i.equals(r5.i) == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.j != 0) goto L6;
        int r0 = this.f802b.hashCode();
        this.j = r0;
        int r1 = (r0 * 31) + this.g.hashCode();
        this.j = r1;
        int r2 = (r1 * 31) + this.c;
        this.j = r2;
        int r3 = (r2 * 31) + this.d;
        this.j = r3;
        int r4 = (r3 * 31) + this.h.hashCode();
        this.j = r4;
        int r5 = (r4 * 31) + this.e.hashCode();
        this.j = r5;
        int r6 = (r5 * 31) + this.f.hashCode();
        this.j = r6;
        this.j = (r6 * 31) + this.i.hashCode();
    L6:
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f802b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
