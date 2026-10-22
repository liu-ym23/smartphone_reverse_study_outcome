package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class e implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap<d<?>, Object> f696b;

    public e() {
        this.f696b = new CachedHashCodeArrayMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(d<T> r0, Object r1, MessageDigest r2) {
        r0.update(r1, r2);
    }

    public e a(d<?> r2) {
        this.f696b.remove(r2);
        return this;
    }

    public <T> e a(d<T> r2, T r3) {
        this.f696b.put(r2, r3);
        return this;
    }

    public void a(e r1) {
        this.f696b.putAll(r1.f696b);
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f696b.size()) goto L6;
        a((d) ZeusTransformUtils.preCheckCast(this.f696b.keyAt(r0), d.class, "com.obric.memorydata.plugin"), this.f696b.valueAt(r0), r5);
        r0 = r0 + 1;
        goto L4
    }

    public <T> T b(d<T> r2) {
        if (this.f696b.containsKey(r2) == false) goto L6;
        return (T) this.f696b.get(r2);
    L6:
        return r2.a();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L6;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
        return this.f696b.equals(r4.f696b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f696b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f696b + '}';
    }
}
