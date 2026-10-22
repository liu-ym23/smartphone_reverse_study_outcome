package com.larus.chat.gallery.impl.preview.provider;

import com.larus.chat.gallery.providers.input.GalleryInputFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final GalleryInputFragment a;
    public final Function0<Unit> b;

    public c(GalleryInputFragment r2, m0 r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "onModeChanged");
        this.a = r2;
        this.b = r3;
    }
}
