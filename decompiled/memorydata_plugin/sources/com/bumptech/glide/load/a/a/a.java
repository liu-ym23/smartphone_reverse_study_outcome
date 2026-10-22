package com.bumptech.glide.load.a.a;

import com.bumptech.glide.load.a.h;
import com.bumptech.glide.load.a.n;
import com.bumptech.glide.load.a.o;
import com.bumptech.glide.load.a.p;
import com.bumptech.glide.load.a.s;
import com.bumptech.glide.load.data.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class a implements o<h, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Integer> f572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n<h, h> f573b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.a.a$a, reason: collision with other inner class name */
    public static class C0058a implements p<h, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n<h, h> f574a;

        public C0058a() {
            this.f574a = new n(500);
        }

        @Override // com.bumptech.glide.load.a.p
        public o<h, InputStream> a(s r1) {
            return new a(this.f574a);
        }
    }

    static {
        f572a = com.bumptech.glide.load.d.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    }

    public a() {
        this(null);
    }

    public a(n<h, h> r1) {
        this.f573b = r1;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<InputStream> a2(h r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        n<h, h> r7 = this.f573b;
        if (r7 == null) goto L9;
        h r8 = (h) ZeusTransformUtils.preCheckCast(r7.a(r3, 0, 0), h.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L7;
        this.f573b.a(r3, 0, 0, r3);
        goto L9
    L7:
        r3 = r8;
    L9:
        return new o.a(r3, new j(r3, ((Integer) ZeusTransformUtils.preCheckCast(r6.b(f572a), Integer.class, "com.obric.memorydata.plugin")).intValue()));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a<InputStream> a(h r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(h r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(h r3) {
        return a2((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"));
    }
}
