package com.bytedance.android.ec.core.imagex.common;

import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements k {
    public static final /* synthetic */ int e = 0;
    public final long a;
    public final Object b;
    public final ImageRequest[] c;
    public final ImageRequest d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final Object getCallerContext() {
        throw null;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest a() {
        return this.d;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest[] g() {
        return this.c;
    }

    public c(Object r1, ImageRequest[] r10, ImageRequest r11) {
        this.b = r1;
        this.c = r10;
        this.d = r11;
        this.a = System.nanoTime();
    }
}
