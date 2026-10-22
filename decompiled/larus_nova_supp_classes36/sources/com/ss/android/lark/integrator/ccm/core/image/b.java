package com.ss.android.lark.integrator.ccm.core.image;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.DocImage;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d<DocImage, InputStream> {

    public static final class a implements e<DocImage, InputStream> {
        public a() {
        }

        @Override // rkb.e
        public final void teardown() {
        }

        @Override // rkb.e
        public final d<DocImage, InputStream> build(MultiModelLoaderFactory r2) {
            Intrinsics.checkNotNullParameter(r2, "multiModelLoaderFactory");
            return new b();
        }
    }

    public b() {
    }

    @Override // rkb.d
    public final rkb.a<InputStream> getResourceFetcher(DocImage r1, int r2, int r3) {
        return new com.ss.android.lark.integrator.ccm.core.image.a(r1);
    }
}
