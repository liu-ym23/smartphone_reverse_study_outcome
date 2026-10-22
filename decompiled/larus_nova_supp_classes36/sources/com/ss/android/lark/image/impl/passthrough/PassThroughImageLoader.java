package com.ss.android.lark.image.impl.passthrough;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.PassThroughImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PassThroughImageLoader implements d<PassThroughImage, InputStream> {

    public static class Factory implements e<PassThroughImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<PassThroughImage, InputStream> build(MultiModelLoaderFactory r1) {
            return new PassThroughImageLoader();
        }
    }

    public PassThroughImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(PassThroughImage r1, int r2, int r3) {
        return getResourceFetcher2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(PassThroughImage r1, int r2, int r3) {
        return new PassThroughImageDataFetcher(r1);
    }
}
