package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends ig0.b {
    public int l;
    public int m;
    public boolean n;

    public static final class a {
    }

    public static final class b implements e6 {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        public final void c(d6 r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof d6.a) == false) goto L8;
            o r4 = this.a;
            if (r4.n == false) goto L9;
            r4.v(r4.l, r4.m);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // ig0.b, jg0.c
    public final int o() {
        return 2131566590;
    }

    @Override // ig0.b, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkHamletMainUserAnimLayer.name();
    }

    @Override // ig0.b, jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        Guideline r3 = q().findViewById(2131393364);
        Guideline r4 = q().findViewById(2131393404);
        int r5 = UtilityKotlinExtentionsKt.i(32);
        v(r5, r5);
        t().setEmojiCallback(new b(this));
    }

    public final void v(int r12, int r13) {
        if (this.l != r12) goto L5;
        return;
    L5:
        DynamicEmojiView r0 = t().e;
        if (r0 == null) goto L8;
        boolean r1 = !(r0.b.a instanceof wj0.c.b);
    L9:
        SeatAnimationView r3 = t();
        r3.o = r12;
        r3.p = r13;
        SeatAnimationView.f(r3.e, r12, r13);
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L14;
        r5.t();
    L14:
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L19;
        r7.t();
    L19:
        Boolean r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r8 == null) goto L22;
        boolean r9 = r8.booleanValue();
    L24:
        if (this.b != MicSeatScene.AUDIO_LINK_LARGE) goto L26;
        boolean r10 = true;
    L27:
        t().c(je0.d.f(), this.b, r10, r9, r12, r13);
        if (r1 == false) goto L31;
        this.n = true;
        this.l = r12;
        this.m = r12;
        return;
    L31:
        this.n = false;
        SeatAnimationView r2 = t();
        ViewGroup.LayoutParams r11 = t().getLayoutParams();
        if (r11 == null) goto L34;
        r11.width = r12;
        r11.height = r13;
        Unit r14 = Unit.INSTANCE;
    L35:
        r2.setLayoutParams(r11);
        this.l = r12;
        this.m = r12;
        return;
    L34:
        r11 = null;
        goto L35
    L26:
        r10 = false;
        goto L27
    L22:
        r9 = false;
        goto L24
    L8:
        r1 = false;
        goto L9
    }

    @Override // ig0.b, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        u((MultiLinkGuestViewBinder.a) r1, r2, r3);
    }

    @Override // ig0.b
    public final void u(MultiLinkGuestViewBinder.a r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        super.u(r2, r3, r4);
    }

    public o(hg0.a r7, SeatAnimEngineWrapper r8, MicSeatScene r9, xg0.a r10) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r10, "linkSeatAbilityProvider");
        super(r7, 5, r8, r9, r10);
    }
}
