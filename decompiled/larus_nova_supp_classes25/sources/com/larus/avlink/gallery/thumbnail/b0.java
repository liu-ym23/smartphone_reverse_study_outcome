package com.larus.avlink.gallery.thumbnail;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ GalleryThumbnailFragment a;

    public final void cancel() {
        FLogger r0 = FLogger.a;
        r0.i("GalleryThumbnailFragment", "User cancelled deletion");
        ConstraintLayout r1 = this.a.h;
        if (r1 == null) goto L5;
        r1.setEnabled(true);
    L5:
        r0.d("GalleryThumbnailFragment", "Delete button restored");
    }

    public b0(GalleryThumbnailFragment r1) {
        this.a = r1;
    }
}
