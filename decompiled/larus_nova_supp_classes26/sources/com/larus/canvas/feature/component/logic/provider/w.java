package com.larus.canvas.feature.component.logic.provider;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w extends com.larus.gallery.api.t<ky8.a> {
    public final j f;

    public w(j r2) {
        Intrinsics.checkNotNullParameter(r2, "canvasGalleryContext");
        this.f = r2;
    }

    public final void w(Object r1, int r2) {
        ky8.a r3 = (ky8.a) r1;
        Intrinsics.checkNotNullParameter(r3, "data");
        ((com.larus.gallery.api.t) this).d = r3;
        c0 r4 = this.f.d;
        if (r4 == null) goto L6;
        r4.a(r3);
        return;
    }
}
