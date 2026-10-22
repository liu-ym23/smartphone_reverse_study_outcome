package com.bytedance.android.ec.core.imagex;

import android.util.LruCache;
import com.bytedance.android.ec.core.imagex.opt.ECImageRequestBuilderCacheForSlc;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z0 implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ List b;
    public final /* synthetic */ ResizeOptions c;
    public final /* synthetic */ String d;
    public final /* synthetic */ q e;
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.widget.fresco.e f;
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a g;

    public z0(u r1, List r10, ResizeOptions r11, String r12, y0 r13, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r14, SlcImageFetchManager.a r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    public final void a() {
        r r1 = this.a;
        Pair r10 = null;
        if ((r1 instanceof u) == true) goto L5;
        r1 = null;
    L5:
        u r11 = (u) r1;
        if (r11 == null) goto L8;
        r11.v = System.nanoTime();
    L8:
        List r13 = n0.a(ImageExtensionsKt.l(), this.b, null, this.a, null, false, 56);
        SlcImageLoaderHookImpl r12 = SlcImageLoaderHookImpl.d;
        r r14 = this.a;
        ResizeOptions r15 = this.c;
        String r16 = this.d;
        r12.getClass();
        Pair r17 = ImageExtensionsKt.I(r13, r14, r15, null, null, null, null, 128);
        if (r17 == null) goto L21;
        ImageRequest[] r18 = (ImageRequest[]) r17.component1();
        ImageRequest r19 = (ImageRequest) r17.component2();
        if (r16 == null) goto L19;
        if (r18 == null) goto L19;
        Lazy r20 = ECImageRequestBuilderCacheForSlc.a;
        List r21 = ArraysKt.toList(r18);
        Intrinsics.checkNotNullParameter(r16, "key");
        Intrinsics.checkNotNullParameter(r21, "cache");
        if (r14 == null) goto L17;
        com.bytedance.android.shopping.api.image.q r22 = com.bytedance.android.ec.core.imagex.opt.s.c(r14);
    L18:
        Intrinsics.checkNotNullParameter(r16, "key");
        Intrinsics.checkNotNullParameter(r21, "cache");
        ((LruCache) ECImageRequestBuilderCacheForSlc.a.getValue()).put(r16, new SoftReference(new Triple(r22, r21, null)));
        goto L19
    L17:
        r22 = null;
    L19:
        if (r18 == null) goto L21;
        r10 = new Pair(r18, r19);
    L21:
        if (r10 != null) goto L23;
        return;
    L23:
        SlcImageLoaderHookImpl.e((ImageRequest[]) r10.component1(), (ImageRequest) r10.component2(), this.e, this.a, this.f, new SlcImageLoaderHookImpl.a(this.g, this.a), this.g, true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
