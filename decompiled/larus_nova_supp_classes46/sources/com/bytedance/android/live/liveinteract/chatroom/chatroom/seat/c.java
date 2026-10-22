package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ GuestBattleSeatAnimTask a;
    public final /* synthetic */ Function0 b;

    public c(GuestBattleSeatAnimTask r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r2, Throwable r3) {
        super.onFailure(r2, r3);
        ALogger.e("GuestBattleSeatAnimTask", "playGuestBattleSeatAnimation.onFailure:", r3);
        Function0 r4 = this.b;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke();
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        je0.b.a((AnimatedDrawable2) r3, new GuestBattleSeatAnimTask$playGuestBattleSeatAnimation$1$onFinalImageSet$1(this));
        return;
    }
}
