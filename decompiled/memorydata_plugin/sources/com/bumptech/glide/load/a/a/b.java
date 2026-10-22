package com.bumptech.glide.load.a.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.o;
import com.bumptech.glide.load.a.p;
import com.bumptech.glide.load.a.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b implements o<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f575a;

    public static class a implements p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f576a;

        public a(Context r3) {
            this.f576a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, InputStream> a(s r1) {
            return new b(this.f576a);
        }
    }

    public b(Context r3) {
        this.f575a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<InputStream> a2(Uri r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        if (com.bumptech.glide.load.data.a.b.a(r2, r3) == true) goto L5;
        return null;
    L5:
        return new o.a(new com.bumptech.glide.e.d(r1), com.bumptech.glide.load.data.a.c.a(this.f575a, r1));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a<InputStream> a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return com.bumptech.glide.load.data.a.b.d(r1);
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"));
    }
}
