package com.larus.avlink.gallery.thumbnail;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.viewmodel.ThumbnailViewModel;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 implements i0 {
    public final /* synthetic */ GalleryThumbnailFragment a;
    public final /* synthetic */ RecyclerView b;

    @Override // com.larus.avlink.gallery.thumbnail.i0
    public final void a(ThumbnailMetadata r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        ThumbnailViewModel r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.toggleSelection(r2);
        return;
    }

    @Override // com.larus.avlink.gallery.thumbnail.i0
    public final void b(ThumbnailMetadata r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        AppHost.Companion r0 = AppHost.a;
        if (r0.isDebug() == false) goto L5;
    L6:
        t19.s.j(t19.s.a, this.b.getContext(), "MediaId: " + r8.getImageUuid() + " CreateTime: " + r8.getCreateTime(), null, false, 28);
        return;
    L5:
        if (r0.isTestChannel() == true) goto L6;
    }

    public c0(GalleryThumbnailFragment r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }
}
