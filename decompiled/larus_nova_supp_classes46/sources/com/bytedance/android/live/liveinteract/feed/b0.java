package com.bytedance.android.live.liveinteract.feed;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ok;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements vlc.l {
    public final /* synthetic */ c0 a;

    public b0(c0 r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r8) {
        if ((r8 instanceof qb) == false) goto L40;
        c0 r0 = this.a;
        qb r9 = (qb) r8;
        r0.getClass();
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(r0.getShowFrom()) == true) goto L7;
        return;
    L7:
        if (r0.q == true) goto L9;
        return;
    L9:
        if (r9.getPlaceholder() != 1) goto L33;
        ok r10 = r9.getTextBg();
        if (r10 == null) goto L43;
        ConstraintLayout r1 = (RadioTextBoardView) r0.d(2131383612);
        if (r1 == null) goto L15;
        r1.setVisibility(0);
    L15:
        RadioTextBoardView r2 = (RadioTextBoardView) r0.d(2131383612);
        if (r2 == null) goto L19;
        com.bytedance.android.live.liveinteract.view.c.f.getClass();
        r2.T5(com.bytedance.android.live.liveinteract.view.c.a.a(r10));
    L19:
        if (r0.r == true) goto L46;
        r0.r = true;
        HashMap r11 = new HashMap();
        r11.put("live_type", "voice_live");
        r11.put("function_type2", "live");
        r11.put("voice_mode", "head");
        r11.put("action_type", "show");
        IRoom r3 = r0.getMRoom$liveinteract_impl_saasRelease();
        String r4 = "0";
        if (r3 == null) goto L25;
        String r5 = r3.getAnchorId();
        if (r5 == null) goto L25;
    L26:
        r11.put("anchor_id", r5);
        IRoom r6 = r0.getMRoom$liveinteract_impl_saasRelease();
        if (r6 == null) goto L32;
        String r7 = r6.getIdStr();
        if (r7 == null) goto L32;
        r4 = r7;
    L32:
        r11.put("room_id", r4);
        j0.l().sendLog("livesdk_live_text_show_play", r11, new Object[0]);
        return;
    L25:
        r5 = "0";
        goto L26
    L46:
        return;
    L43:
        return;
    L33:
        RadioTextBoardView r12 = (RadioTextBoardView) r0.d(2131383612);
        if (r12 == null) goto L36;
        r12.S5();
        r12.g = null;
    L36:
        ConstraintLayout r13 = (RadioTextBoardView) r0.d(2131383612);
        if (r13 == null) goto L45;
        r13.setVisibility(8);
        return;
    L45:
        return;
    }
}
