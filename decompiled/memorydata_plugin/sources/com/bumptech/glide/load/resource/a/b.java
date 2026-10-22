package com.bumptech.glide.load.resource.a;

import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b implements s<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f824a;

    public b(byte[] r3) {
        this.f824a = (byte[]) ZeusTransformUtils.preCheckCast(j.a(r3), byte[].class, "com.obric.memorydata.plugin");
    }

    public byte[] a() {
        return this.f824a;
    }

    @Override // com.bumptech.glide.load.engine.s
    public Class<byte[]> c() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.s
    public /* synthetic */ byte[] d() {
        return a();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int e() {
        return this.f824a.length;
    }

    @Override // com.bumptech.glide.load.engine.s
    public void f() {
    }
}
