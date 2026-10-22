package com.larus.chat.gallery.impl.preview.provider;

import androidx.fragment.app.Fragment;
import com.larus.chat.gallery.providers.input.GalleryInputFragment;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements r {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.larus.chat.gallery.impl.preview.provider.r
    public final Fragment c(GalleryInputFragment r2, Function1 r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "inputFragment");
        Intrinsics.checkNotNullParameter(r3, "onSelectedItemClick");
        Intrinsics.checkNotNullParameter(r4, "onSelectedItemRemove");
        return r2;
    }

    @Override // com.larus.chat.gallery.impl.preview.provider.r
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
    }

    @Override // com.larus.chat.gallery.impl.preview.provider.r
    public final void b(List<com.larus.chat.gallery.api.o> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
    }
}
