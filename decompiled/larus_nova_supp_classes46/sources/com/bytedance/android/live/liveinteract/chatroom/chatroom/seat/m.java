package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends d {
    public final DynamicEmojiView b;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ HSImageView a;

        public a(HSImageView r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == false) goto L8;
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            r5.setAnimationListener(new l(this));
            AnimationBackend r6 = r5.getAnimationBackend();
            if (r6 == null) goto L9;
            r5.setAnimationBackend(new k(r6));
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof n) == false) goto L16;
        DynamicEmojiView r0 = this.b;
        if (r0 == null) goto L20;
        HSImageView r1 = r0.getRandomEmojiView();
        if (r1 == null) goto L21;
        String r5 = ((n) r4).a.i();
        if (r5 != null) goto L11;
        return;
    L11:
        if ((!TextUtils.isEmpty(r5)) == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L23;
        r1.setVisibility(0);
        r1.setController(Fresco.newDraweeControllerBuilder().setUri(r5).setAutoPlayAnimations(true).setControllerListener(new a(r1)).build());
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    L16:
        d r2 = this.a;
        if (r2 == null) goto L25;
        r2.b(r4);
        return;
    }

    public m(f r2, DynamicEmojiView r3) {
        Intrinsics.checkNotNullParameter(r2, "taskStateListener");
        this.b = r3;
    }
}
