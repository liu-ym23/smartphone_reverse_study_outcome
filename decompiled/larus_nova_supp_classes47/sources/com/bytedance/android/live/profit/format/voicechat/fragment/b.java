package com.bytedance.android.live.profit.format.voicechat.fragment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.format.voicechat.view.BlurBackgroundImageView;
import com.bytedance.android.live.profit.format.voicechat.view.VoiceChatAvatarView;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ FormatVoiceChatFragment.f a;

    public b(FormatVoiceChatFragment.f r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        BlurBackgroundImageView r0 = this.a.a.m;
        if (r0 == null) goto L5;
        r0.setBlurBackground(r5);
    L5:
        VoiceChatAvatarView r1 = this.a.a.i;
        if (r1 == null) goto L17;
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        ImageView r2 = r1.a;
        if (r2 == null) goto L10;
        r2.setImageBitmap(r5);
    L10:
        HSImageView r6 = r1.d;
        if (r6 == null) goto L13;
        r6.setController(Fresco.newDraweeControllerBuilder().setUri(VoiceChatAvatarView.h).setControllerListener(new com.bytedance.android.live.profit.format.voicechat.view.f()).build());
    L13:
        HSImageView r7 = r1.g;
        if (r7 == null) goto L18;
        r7.setController(Fresco.newDraweeControllerBuilder().setUri(VoiceChatAvatarView.i).setControllerListener(new com.bytedance.android.live.profit.format.voicechat.view.g()).build());
        return;
    L18:
        return;
    }
}
