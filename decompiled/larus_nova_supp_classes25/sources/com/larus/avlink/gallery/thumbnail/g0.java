package com.larus.avlink.gallery.thumbnail;

import com.larus.avlink.gallery.viewmodel.ThumbnailViewModel;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 implements b98.d {
    public final /* synthetic */ GalleryThumbnailFragment a;

    public g0(GalleryThumbnailFragment r1) {
        this.a = r1;
    }

    public final void a(int r1, int r2) {
        ThumbnailViewModel r3 = this.a.e;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        SoftReference r5 = com.larus.utils.y.a;
        final GalleryThumbnailFragment r6 = this.a;
        com.larus.utils.y.c(new f0(r6));
        return;
    L11:
        return;
    L5:
        if (r3.disableGainThumbnail() == true) goto L7;
        r4 = true;
        goto L8
    }
}
