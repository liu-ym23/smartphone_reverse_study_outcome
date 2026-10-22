package com.larus.bmhome.chat.layout.item;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.view.TitleAvatarImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a3 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ TitleAvatarImageView a;

    public a3(TitleAvatarImageView r1) {
        this.a = r1;
    }

    public final void onFailure(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        this.a.setActualImageResource(2131240119);
    }
}
