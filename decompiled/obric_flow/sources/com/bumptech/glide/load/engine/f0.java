package com.bumptech.glide.load.engine;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements z.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.lynx.animax.player.e f1487j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f1488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z.c f1489c;
    public final z.c d;
    public final int e;
    public final int f;
    public final Class g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z.f f1490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z.i f1491i;

    static {
        f1487j = new com.lynx.animax.player.e(50);
    }

    public f0(com.bumptech.glide.load.engine.bitmap_recycle.f r5, z.c r10, z.c r11, int r12, int r13, z.i r14, Class r15, z.f r16) {
        this.f1488b = r5;
        this.f1489c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.f1491i = r14;
        this.g = r15;
        this.f1490h = r16;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // z.c
    public final void b(MessageDigest r10) {
        com.bumptech.glide.load.engine.bitmap_recycle.f r5 = this.f1488b;
        monitor-enter(r5);
        com.bumptech.glide.load.engine.bitmap_recycle.e r11 = (com.bumptech.glide.load.engine.bitmap_recycle.e) r5.d;     // Catch: Throwable -> L17
        com.bumptech.glide.load.engine.bitmap_recycle.h r12 = (com.bumptech.glide.load.engine.bitmap_recycle.h) ((ArrayDeque) r11.f22372b).poll();     // Catch: Throwable -> L17
        if (r12 != null) goto L7;
        r12 = r11.F();     // Catch: Throwable -> L17
    L7:
        com.bumptech.glide.load.engine.bitmap_recycle.d r13 = (com.bumptech.glide.load.engine.bitmap_recycle.d) r12;     // Catch: Throwable -> L17
        r13.f1451b = 8;     // Catch: Throwable -> L17
        r13.f1452c = byte[].class;     // Catch: Throwable -> L17
        Object r14 = r5.e(r13, byte[].class);     // Catch: Throwable -> L17
        monitor-exit(r5);
        byte[] r15 = (byte[]) r14;
        ByteBuffer.wrap(r15).putInt(this.e).putInt(this.f).array();
        this.d.b(r10);
        this.f1489c.b(r10);
        r10.update(r15);
        z.i r16 = this.f1491i;
        if (r16 == null) goto L12;
        r16.b(r10);
    L12:
        this.f1490h.b(r10);
        com.lynx.animax.player.e r17 = f1487j;
        Class r18 = this.g;
        byte[] r19 = (byte[]) r17.a(r18);
        if (r19 != null) goto L15;
        r19 = r18.getName().getBytes(z.c.f23353a);
        r17.e(r18, r19);
    L15:
        r10.update(r19);
        this.f1488b.h(r15);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof f0) == false) goto L20;
        f0 r10 = (f0) r5;
        int r11 = r10.f;
        if (this.f == r11) goto L7;
        return false;
    L7:
        if (this.e == r10.e) goto L9;
        return false;
    L9:
        if (q0.i.a(this.f1491i, r10.f1491i) == true) goto L11;
        return false;
    L11:
        if (this.g.equals(r10.g) == true) goto L13;
        return false;
    L13:
        if (this.f1489c.equals(r10.f1489c) == true) goto L15;
        return false;
    L15:
        if (this.d.equals(r10.d) == true) goto L17;
        return false;
    L17:
        if (this.f1490h.equals(r10.f1490h) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    @Override // z.c
    public final int hashCode() {
        int r5 = this.f1489c.hashCode() * 31;
        int r10 = ((((this.d.hashCode() + r5) * 31) + this.e) * 31) + this.f;
        z.i r11 = this.f1491i;
        if (r11 == null) goto L5;
        r10 = (r10 * 31) + r11.hashCode();
    L5:
        int r12 = this.g.hashCode();
        int r13 = this.f1490h.f23357b.hashCode();
        return r13 + ((r12 + (r10 * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f1489c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.f1491i + "', options=" + this.f1490h + '}';
    }
}
