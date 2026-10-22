package com.lynx.tasm.ui.image;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f11074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o0 f11076c;

    public k0(o0 r5, n0 r10, Object r11) {
        this.f11076c = r5;
        this.f11074a = r10;
        this.f11075b = r11;
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        o0 r5 = this.f11076c;
        n0 r10 = this.f11074a;
        Object r11 = this.f11075b;
        r5.getClass();
        ImageRequest r12 = (ImageRequest) r11;
        ImagePipeline r13 = r5.f11086i;
        ImageRequest.RequestLevel r14 = ImageRequest.RequestLevel.f8431b;
        if (r10 == null) goto L13;
        monitor-enter(r10);
        u0 r15 = r10.f11085r;     // Catch: Throwable -> L10
        if (r15 == null) goto L12;
        ImageOriginRequestListener r16 = new ImageOriginRequestListener(r10.f11064o, r15);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
    L17:
        return r13.a(r12, null, r14, r16);
    L12:
        monitor-exit(r10);
    L10:
        th = move-exception;
        throw th;
    L13:
        r16 = null;
        goto L17
    }

    public final String toString() {
        return new Objects.ToStringHelper(k0.class.getSimpleName()).a("request", this.f11075b.toString()).toString();
    }
}
