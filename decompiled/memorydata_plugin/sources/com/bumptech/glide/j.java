package com.bumptech.glide;

import com.bumptech.glide.j;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.request.b.c<? super TranscodeType> f566a;

    public j() {
        this.f566a = com.bumptech.glide.request.b.a.a();
    }

    public final CHILD a() {
        return (CHILD) ZeusTransformUtils.preCheckCast(super.clone(), j.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    final com.bumptech.glide.request.b.c<? super TranscodeType> b() {
        return this.f566a;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, j.class) == false) goto L6;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin");
        return k.a(this.f566a, r4.f566a);
    L6:
        return false;
    }

    public int hashCode() {
        com.bumptech.glide.request.b.c<? super TranscodeType> r0 = this.f566a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }
}
