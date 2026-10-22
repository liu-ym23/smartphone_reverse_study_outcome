package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.interactivity.api.IRoomChannelService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c {
    public final PublicScreenAreaPageType a;
    public FrameLayout b;
    public WidgetElement c;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e d;
    public Disposable e;
    public final String f;
    public final s22.a g;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void setHeight(int r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void l2() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e r0 = this.d;
        if (r0 == null) goto L6;
        r0.l2();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void z5() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e r0 = this.d;
        if (r0 == null) goto L6;
        r0.z5();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final String D5() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final PublicScreenAreaPageType getPageType() {
        return this.a;
    }

    public z(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "currentChatChannel");
        this.g = r2;
        this.a = PublicScreenAreaPageType.ChatChannel;
        this.f = "聊天频道";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void A5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r6) {
        Intrinsics.checkNotNullParameter(r6, "bridge");
        a(r6);
        if (PadConfigUtils.c() == false) goto L16;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r6.getDataCenter(), 0, 2);
        if (r0 != null) goto L9;
        return;
    L9:
        if (ChatChannelUtils.i(r0) == true) goto L11;
        return;
    L11:
        if (((PadOrientation) r0.getPadOrientation().getValue()) != PadOrientation.PORTRAIT) goto L15;
        this.e = r0.getPadOrientation().a().subscribe(new y(this, r6));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final View B5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r4) {
        Intrinsics.checkNotNullParameter(r4, "bridge");
        View r5 = LayoutInflater.from(r4.getActivity()).inflate(2131565304, null, false);
        this.b = (FrameLayout) r5.findViewById(2131365481);
        return r5;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void C5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        WidgetElement r1 = this.c;
        if (r1 == null) goto L8;
        r2.b().S(r1);
    L8:
        this.c = null;
        this.d = null;
    }

    public final void a(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r8) {
        FrameLayout r2 = this.b;
        if (r2 == null) goto L6;
        Class<? extends LiveWidget> r1 = ((IRoomChannelService) jc1.k.n(IRoomChannelService.class)).getChatChannelWidget();
        WidgetElement r9 = r8.b().P(r1, r2, false, new Object[]{Long.valueOf(this.g.getChannelId())}, true);
        this.c = r9;
        this.d = (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e) r9.f(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e.class);
        return;
    }
}
