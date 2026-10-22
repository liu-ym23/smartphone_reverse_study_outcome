package com.larus.avlink.gallery.thumbnail;

import com.larus.dora.api.model.AlbumNotify;
import com.larus.dora.api.model.MediaInfo;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 implements h49.f {
    public k0() {
    }

    public final void a(int r5, int r6, int r7, AlbumNotify r8) {
        Intrinsics.checkNotNullParameter(r8, "albumItem");
        Long r9 = r8.getNotifyType();
        if (r9 != null) goto L6;
    L15:
        FLogger.a.i("ThumbnailManager", "onAlbumNotifyArrived, count changed: " + r8.getCount());
        b49.a r10 = r8.getCount();
        if (r10 == null) goto L19;
        ThumbnailManager r11 = ThumbnailManager.a;
        ThumbnailManager.f(r10.a(), r10.b());
        return;
    L19:
        return;
    L6:
        if (r9.longValue() != 1) goto L15;
        FLogger r12 = FLogger.a;
        r12.i("ThumbnailManager", "onAlbumNotifyArrived, albumItem: " + r8);
        MediaInfo r0 = r8.getMedia();
        if (r0 == null) goto L15;
        ThumbnailManager r1 = ThumbnailManager.a;
        Intrinsics.checkNotNullParameter(r0, "albumItem");
        ConcurrentLinkedQueue<MediaInfo> r13 = ThumbnailManager.e;
        r13.offer(r0);
        if (ThumbnailManager.o(r0) == true) goto L12;
    L14:
        r12.i("ThumbnailManager", "appendAlbumItem mediaId: " + r0.getMediaId() + ", display queue size: " + r13.size() + ", upload queue size: " + ThumbnailManager.g.size());
        ThumbnailManager.s("AlbumNotify");
        goto L15
    L12:
        if (b98.b.b(2) == true) goto L14;
        ThumbnailManager.g.offer(r0);
        goto L14
    }
}
