package com.ss.android.lark.image.impl.avatar;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.AvatarImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AvatarImageLoader implements d<AvatarImage, InputStream> {

    public static class Factory implements e<AvatarImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<AvatarImage, InputStream> build(MultiModelLoaderFactory r1) {
            return new AvatarImageLoader();
        }
    }

    public AvatarImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(AvatarImage r1, int r2, int r3) {
        return getResourceFetcher2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(AvatarImage r1, int r2, int r3) {
        return new AvatarImageDataFetcher(r1);
    }
}
