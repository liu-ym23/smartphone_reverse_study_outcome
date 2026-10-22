package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class u implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.util.g<Class<?>, byte[]> f813b = null;
    private final com.bumptech.glide.load.engine.bitmap_recycle.b c;
    private final com.bumptech.glide.load.c d;
    private final com.bumptech.glide.load.c e;
    private final int f;
    private final int g;
    private final Class<?> h;
    private final com.bumptech.glide.load.e i;
    private final com.bumptech.glide.load.h<?> j;

    static {
        f813b = new com.bumptech.glide.util.g(50);
    }

    u(com.bumptech.glide.load.engine.bitmap_recycle.b r3, com.bumptech.glide.load.c r4, com.bumptech.glide.load.c r5, int r6, int r7, com.bumptech.glide.load.h<?> r8, Class<?> r9, com.bumptech.glide.load.e r10) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r11 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r12 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r13 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.h<?> r14 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r8, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r6;
        this.g = r7;
        this.j = r14;
        this.h = r9;
        this.i = r10;
    }

    private byte[] a() {
        com.bumptech.glide.util.g<Class<?>, byte[]> r0 = f813b;
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(r0.b(this.h), byte[].class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        byte[] r2 = this.h.getName().getBytes(f667a);
        r0.b(this.h, r2);
        return r2;
    L6:
        return r1;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r4) {
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(this.c.b(8, byte[].class), byte[].class, "com.obric.memorydata.plugin");
        ByteBuffer.wrap(r0).putInt(this.f).putInt(this.g).array();
        this.e.a(r4);
        this.d.a(r4);
        r4.update(r0);
        com.bumptech.glide.load.h<?> r1 = this.j;
        if (r1 == null) goto L5;
        r1.a(r4);
    L5:
        this.i.a(r4);
        r4.update(a());
        this.c.a(r0);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L20;
        u r5 = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.memorydata.plugin");
        if (this.g == r5.g) goto L7;
        return false;
    L7:
        if (this.f == r5.f) goto L9;
        return false;
    L9:
        if (com.bumptech.glide.util.k.a(this.j, r5.j) == true) goto L11;
        return false;
    L11:
        if (this.h.equals(r5.h) == true) goto L13;
        return false;
    L13:
        if (this.d.equals(r5.d) == true) goto L15;
        return false;
    L15:
        if (this.e.equals(r5.e) == true) goto L17;
        return false;
    L17:
        if (this.i.equals(r5.i) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        int r0 = (((((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g;
        com.bumptech.glide.load.h<?> r1 = this.j;
        if (r1 == null) goto L6;
        r0 = (r0 * 31) + r1.hashCode();
    L6:
        return (((r0 * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.d + ", signature=" + this.e + ", width=" + this.f + ", height=" + this.g + ", decodedResourceClass=" + this.h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
