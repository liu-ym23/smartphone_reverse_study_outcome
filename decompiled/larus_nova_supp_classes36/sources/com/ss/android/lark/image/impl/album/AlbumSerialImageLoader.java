package com.ss.android.lark.image.impl.album;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.AlbumSerialImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AlbumSerialImageLoader implements d<AlbumSerialImage, InputStream> {

    public static class Factory implements e<AlbumSerialImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<AlbumSerialImage, InputStream> build(MultiModelLoaderFactory r1) {
            return new AlbumSerialImageLoader();
        }
    }

    public AlbumSerialImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(AlbumSerialImage r1, int r2, int r3) {
        return getResourceFetcher2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(AlbumSerialImage r2, int r3, int r4) {
        return new AlbumSerialImageDataFetcher(r2, r3, r4);
    }
}
