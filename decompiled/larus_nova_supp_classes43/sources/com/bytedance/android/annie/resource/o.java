package com.bytedance.android.annie.resource;

import android.webkit.WebResourceResponse;
import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import java.io.InputStream;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o extends com.bytedance.android.annie.service.resource.i {
    public final Response i;
    public transient CloseableReference<CloseableBitmap> j;

    @Override // com.bytedance.android.annie.service.resource.i
    public final byte[] a() {
        return this.i.j();
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final CloseableReference<CloseableBitmap> b() {
        if (this.j != null) goto L6;
        this.j = this.i.f();
    L6:
        return this.j;
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final InputStream c() {
        return this.i.l();
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final Map<String, Long> d() {
        return this.i.c;
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final WebResourceResponse e() {
        return this.i.m();
    }

    public o(Response r10) {
        Intrinsics.checkNotNullParameter(r10, "realResponse");
        boolean r0 = r10.r;
        this.i = r10;
        this.e = r10.a;
        if (r10.r == true) goto L5;
        String r1 = r10.s.toString();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.b = r1;
    L5:
        this.a = r10.t;
        if (r10.k == false) goto L9;
        String r11 = "preloaded";
    L12:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        this.c = r11;
        if (Intrinsics.areEqual(r11, "preloaded") == false) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L21;
        ResourceFrom2 r13 = r10.v;
        if (r13 != ResourceFrom2.MEMORY) goto L20;
        String r14 = Response.h(r10.x);
    L22:
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.d = r14;
        this.f = r10.B;
        this.j = r10.f();
        ForestNetAPI.HttpResponse r15 = r10.e;
        Map<String, String> r16 = null;
        if (r15 == null) goto L25;
        Integer r17 = Integer.valueOf(r15.a);
    L26:
        this.g = r17;
        if (r15 == null) goto L29;
        r16 = r15.c;
    L29:
        this.h = r16;
        return;
    L25:
        r17 = null;
        goto L26
    L20:
        r14 = Response.h(r13);
        goto L22
    L21:
        r14 = Response.h(r10.v);
        goto L22
    L15:
        r12 = Intrinsics.areEqual(r11, "request_reuse");
        goto L16
    L9:
        if (r10.l == false) goto L11;
        r11 = "request_reuse";
        goto L12
    L11:
        r11 = Response.h(r10.v);
        goto L12
    }
}
