package com.bytedance.android.ec.core.imagex.opt;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class t0 {
    public static final /* synthetic */ int d = 0;
    public List<? extends Uri> a;
    public ImageRequestBuilder b;
    public final AtomicBoolean c;

    public static final class a {
    }

    public static final class b {
        public final ImageRequestBuilder a;
        public final ImageRequest[] b;
        public final Uri[] c;
        public final ImageRequest d;

        public b(ImageRequestBuilder r10, ImageRequest[] r11, Uri[] r12, ImageRequest r13) {
            Intrinsics.checkNotNullParameter(r10, "builder");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public static final class c {
        public ImageRequest[] a;
        public ImageRequest b;
        public Uri[] c;

        public c(ImageRequest[] r1, ImageRequest r10) {
            this.a = r1;
            this.b = r10;
            this.c = null;
        }
    }

    public final class d {
        public b a;
        public final ImageRequest[] b;
        public final /* synthetic */ t0 c;

        public d(com.bytedance.android.ec.core.imagex.a0 r1, ImageRequest[] r10) {
            this.c = r1;
            this.b = r10;
        }
    }

    static {
    }

    public abstract void b(ImageRequestBuilder r1);

    public abstract List<Uri> c();

    public abstract void d(c r1);

    public abstract void e();

    public abstract void f(ImageRequestBuilder r1);

    public abstract ImageRequest g(ImageRequest r1);

    public abstract CloseableStaticBitmap h(CacheKey r1);

    public final ImageRequestBuilder a() {
        ImageRequestBuilder r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        List<? extends Uri> r1 = this.a;
        if (r1 == null) goto L12;
        Uri r10 = (Uri) CollectionsKt.firstOrNull(r1);
        if (r10 == null) goto L14;
        ImageRequestBuilder r11 = ImageRequestBuilder.newBuilderWithSource(r10);
        f(r11);
        this.b = r11;
        return r11;
    L14:
        return null;
    L12:
        return null;
    }

    public t0(List<? extends Uri> r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        r10 = null;
    L11:
        this.a = r10;
        this.c = new AtomicBoolean(true);
        return;
    L5:
        if (r10.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
