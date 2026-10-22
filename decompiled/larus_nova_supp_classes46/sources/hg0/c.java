package hg0;

import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.MultiLinkCommonEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty.MultiLinkAudioCommonEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import jg0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static g e(ViewGroup r1, MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.b r0 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.b(r2, r3);
        g r4 = new g(r1);
        r4.b(r0);
        r4.a(r1.getContext());
        return r4;
    }

    public static g g(ViewGroup r4, MicSeatScene r5, xg0.a r6) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, "linkSeatAbilityProvider");
        MultiLinkCommonGuestMicSeatBasicLayer r0 = new MultiLinkCommonGuestMicSeatBasicLayer(r5, r6);
        pg0.b r1 = new pg0.b(r5, r6);
        g r2 = new g(r4);
        r2.b(r0);
        r2.b(new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.b(r0, r5, r6));
        r2.b(r1);
        boolean r3 = tb1.d.a;
        r2.b(new og0.a(r0, r6));
        r2.b(new lg0.a(r5, r1, r0, r6));
        r2.a(r4.getContext());
        return r2;
    }

    public static g h(ViewGroup r1, MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.d r0 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.d(r2, r3);
        g r4 = new g(r1);
        r4.b(r0);
        r4.a(r1.getContext());
        return r4;
    }

    public static g d(ViewGroup r1, MicSeatScene r2, m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.a r0 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.a(r2, r3, r4);
        g r5 = new g(r1);
        r5.b(r0);
        r5.a(r1.getContext());
        return r5;
    }

    public static g f(ViewGroup r1, MicSeatScene r2, m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        MultiLinkCommonEmptyMicSeatBasicLayer r0 = new MultiLinkCommonEmptyMicSeatBasicLayer(r2, r3, r4);
        g r5 = new g(r1);
        r5.b(r0);
        r5.a(r1.getContext());
        return r5;
    }

    public static g a(ViewGroup r1, MicSeatScene r2, a r3, SeatAnimEngineWrapper r4, xg0.a r5) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layerGetter");
        Intrinsics.checkNotNullParameter(r5, "linkSeatAbilityProvider");
        qg0.b r0 = new qg0.b(r3, r4, r2, r5);
        g r6 = new g(r1);
        r6.b(r0);
        r6.a(r1.getContext());
        return r6;
    }

    public static g b(ViewGroup r1, MicSeatScene r2, se0.c r3, m r4, xg0.a r5) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        Intrinsics.checkNotNullParameter(r5, "linkSeatAbilityProvider");
        MultiLinkAudioCommonEmptyMicSeatBasicLayer r0 = new MultiLinkAudioCommonEmptyMicSeatBasicLayer(r2, r4, r5);
        r0.d = r3;
        g r6 = new g(r1);
        r6.b(r0);
        r6.a(r1.getContext());
        return r6;
    }

    public static g c(ViewGroup r2, MicSeatScene r3, m r4, se0.c r5, xg0.a r6) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "linkSeatAbilityProvider");
        MultiLinkAudioCommonGuestMicSeatBasicLayer r0 = new MultiLinkAudioCommonGuestMicSeatBasicLayer(r3, r4, r6);
        r0.d = r5;
        sg0.b r7 = new sg0.b(r3, r4, r6);
        g r8 = new g(r2);
        r8.b(r0);
        r8.b(new tg0.a(r0, r3, r6));
        MicSeatScene r1 = MicSeatScene.AUDIO_LINK_HAMLET_AVATAR;
        if (r3 == r1) goto L5;
        r8.b(r7);
    L5:
        if (r3 != r1) goto L7;
    L10:
        r8.b(new rg0.b(r3, r0, r6));
    L11:
        r8.a(r2.getContext());
        return r8;
    L7:
        if (r3 == MicSeatScene.AUDIO_LINK_STAGE_ENLARGE) goto L10;
        r8.b(new rg0.a(r3, r7, r0, r6));
        goto L11
    }
}
