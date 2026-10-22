package com.bumptech.glide.e;

import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f552b;

    public d(Object r1) {
        this.f552b = j.a(r1);
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r2) {
        r2.update(this.f552b.toString().getBytes(f667a));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L6;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
        return this.f552b.equals(r4.f552b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f552b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f552b + '}';
    }
}
