package com.larus.avlink.impl;

import com.larus.avlink.gallery.business.b;
import com.larus.dora.o.impl.album.ODoraAlbumCardView;
import com.larus.utils.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements com.larus.avlink.gallery.business.c {
    public final /* synthetic */ DoraAVLinkServiceImpl a;
    public final /* synthetic */ w88.f b;

    public /* synthetic */ f(DoraAVLinkServiceImpl r1, ODoraAlbumCardView.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.avlink.gallery.business.c
    public final void a(b.a r4) {
        DoraAVLinkServiceImpl r0 = this.a;
        w88.f r1 = this.b;
        int r2 = DoraAVLinkServiceImpl.n;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.getClass();
        y.c(new h(r0, r1));
    }
}
