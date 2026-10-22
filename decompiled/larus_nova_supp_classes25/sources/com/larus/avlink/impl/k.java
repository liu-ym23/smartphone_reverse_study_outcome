package com.larus.avlink.impl;

import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.dora.o.impl.album.ODoraAlbumCardView;
import com.larus.utils.y;
import kotlin.jvm.internal.Intrinsics;
import r98.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements b {
    public final /* synthetic */ DoraAVLinkServiceImpl a;
    public final /* synthetic */ w88.f b;

    public k(DoraAVLinkServiceImpl r1, ODoraAlbumCardView.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // r98.b
    public final void a(String r2, MediaLifecycleState r3, String r4, MediaMetadata r5) {
        Intrinsics.checkNotNullParameter(r2, "mediaId");
        Intrinsics.checkNotNullParameter(r3, "failedAtState");
        Intrinsics.checkNotNullParameter(r4, "reason");
        Intrinsics.checkNotNullParameter(r5, "metadata");
        DoraAVLinkServiceImpl r6 = this.a;
        w88.f r7 = this.b;
        int r8 = DoraAVLinkServiceImpl.n;
        r6.getClass();
        y.c(new h(r6, r7));
    }

    @Override // r98.b
    public final void b(String r2, MediaLifecycleState r3, MediaLifecycleState r4, MediaMetadata r5) {
        Intrinsics.checkNotNullParameter(r2, "mediaId");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
        Intrinsics.checkNotNullParameter(r5, "metadata");
        DoraAVLinkServiceImpl r6 = this.a;
        w88.f r7 = this.b;
        int r8 = DoraAVLinkServiceImpl.n;
        r6.getClass();
        y.c(new h(r6, r7));
    }
}
