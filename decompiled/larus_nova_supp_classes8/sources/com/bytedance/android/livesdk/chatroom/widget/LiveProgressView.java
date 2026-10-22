package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveProgressView extends FrameLayout {
    public HSImageView a;
    public HSImageView b;

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567818, this, true);
        this.a = r0.findViewById(2131362936);
        this.b = r0.findViewById(2131362939);
        AbstractDraweeController r1 = Fresco.newDraweeControllerBuilder().setUri("asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_center.webp").setAutoPlayAnimations(true).build();
        this.a.setController(r1);
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri("asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_point.webp").setAutoPlayAnimations(true).build();
        this.b.setController(r2);
    }

    public LiveProgressView(Context r1) {
        super(r1);
        a();
    }

    public LiveProgressView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public LiveProgressView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
