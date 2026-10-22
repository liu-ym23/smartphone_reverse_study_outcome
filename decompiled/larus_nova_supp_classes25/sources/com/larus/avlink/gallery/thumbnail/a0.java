package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function0<Unit> b;

    public final void confirm() {
        FLogger.a.i("GalleryThumbnailFragment", "User confirmed deletion of " + this.a + " thumbnails");
        Function0<Unit> r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public a0(int r1, s r2) {
        this.a = r1;
        this.b = r2;
    }
}
