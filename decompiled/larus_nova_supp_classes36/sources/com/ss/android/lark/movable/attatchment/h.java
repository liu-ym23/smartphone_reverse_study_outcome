package com.ss.android.lark.movable.attatchment;

import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.image.ImageLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements p {
    public h() {
    }

    @Override // com.ss.android.lark.movable.attatchment.p
    public final boolean a() {
        return false;
    }

    @Override // com.ss.android.lark.movable.attatchment.p
    public final void b(String r2, LKUIRoundedImageView2 r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNullParameter(r6, "urlType");
        ImageLoader.with(r3.getContext()).override(r4, r5).load(r2).into(r3);
    }
}
