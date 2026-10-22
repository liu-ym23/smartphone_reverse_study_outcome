package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.open.user_interact.EntranceVision")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/k;", "", "", "visionIcon", "Ljava/lang/String;", "", "giftType", "I", "", "isAnimationLoopPlay", "Z", "animationInterval", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    @SerializedName("animation_interval")
    public int animationInterval;

    @SerializedName("gift_type")
    public int giftType;

    @SerializedName("is_animation_loop_play")
    public boolean isAnimationLoopPlay;

    @SerializedName("vision_icon")
    public String visionIcon;

    public k() {
        this.visionIcon = "";
    }

    public k(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.visionIcon = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.giftType = r5.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.isAnimationLoopPlay = am3.h.a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.animationInterval = r5.i();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.visionIcon != null) goto L37;
        this.visionIcon = "";
        return;
    }
}
