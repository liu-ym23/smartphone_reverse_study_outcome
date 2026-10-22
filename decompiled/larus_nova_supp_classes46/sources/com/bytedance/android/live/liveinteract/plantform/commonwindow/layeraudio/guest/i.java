package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public View z;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ i a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            View r0 = this.a.t;
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnGlobalLayoutListener(this);
        L7:
            View r2 = this.a.t;
            if (r2 == null) goto L13;
            int r3 = r2.getMeasuredWidth();
            View r4 = this.a.z;
            if (r4 == null) goto L14;
            r4.setTranslationY(r3 * (-0.1f));
            return;
        L14:
            return;
        }

        public a(i r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return 2131566592;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonFirstUserV2GuestMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.z = q().findViewById(2131389586);
        View r3 = this.t;
        if (r3 == null) goto L8;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L9;
        r4.addOnGlobalLayoutListener(new a(this));
        return;
    L9:
        return;
    }

    public i(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
    }
}
