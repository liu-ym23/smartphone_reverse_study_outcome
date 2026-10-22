package com.bumptech.glide.load.a.a;

import com.bumptech.glide.load.a.h;
import com.bumptech.glide.load.a.o;
import com.bumptech.glide.load.a.p;
import com.bumptech.glide.load.a.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class e implements o<URL, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<h, InputStream> f585a;

    public static class a implements p<URL, InputStream> {
        public a() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<URL, InputStream> a(s r3) {
            return new e(r3.a(h.class, InputStream.class));
        }
    }

    public e(o<h, InputStream> r3) {
        this.f585a = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a<InputStream> a(URL r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((URL) ZeusTransformUtils.preCheckCast(r3, URL.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<InputStream> a2(URL r2, int r3, int r4, com.bumptech.glide.load.e r5) {
        return this.f585a.a(new h(r2), r3, r4, r5);
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(URL r3) {
        return a2((URL) ZeusTransformUtils.preCheckCast(r3, URL.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(URL r1) {
        return true;
    }
}
