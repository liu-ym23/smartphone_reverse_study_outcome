package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements a {
    public final /* synthetic */ GalleryThumbnailFragment a;

    public e0(GalleryThumbnailFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.avlink.gallery.thumbnail.a
    public final void a(final int r4, final int r5) {
        FLogger.a.i("GalleryThumbnailFragment", "Album state changed: images=" + r4 + ", videos=" + r5);
        final GalleryThumbnailFragment r0 = this.a;
        r0.m = r4;
        r0.n = r5;
        com.larus.utils.y.c(new d0(r0, r4, r5));
    }
}
