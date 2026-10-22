package com.larus.avlink.gallery.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 implements AlbumSyncBanner.b {
    public final /* synthetic */ MediaAlbumViewHelper a;

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void TF() {
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void bj(Function1<? super Boolean, Unit> r1) {
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void ib() {
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "Sync requested from banner (openThumbDetailPage), navigating to album with auto_sync=true");
        this.a.d(true);
    }

    public l0(MediaAlbumViewHelper r1) {
        this.a = r1;
    }
}
