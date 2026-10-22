package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ RoomIntroDialogV2 a;
    public final /* synthetic */ u b;

    public t(RoomIntroDialogV2 r1, u r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        FrescoLoader.with(this.a.getContext()).load("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_broadcast_image_room_intro_demo.png").actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(new ImageLoader.e(null, this.b, false)).placeholder(2131250137).into(this.a.f);
    }
}
