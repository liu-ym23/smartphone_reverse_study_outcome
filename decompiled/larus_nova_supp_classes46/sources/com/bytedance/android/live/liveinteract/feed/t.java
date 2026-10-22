package com.bytedance.android.live.liveinteract.feed;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.message.model.l9;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements vlc.l {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public t(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r7) {
        LinkMicRecyclerView r1 = null;
        int r2 = 0;
        boolean r3 = false;
        r2 = 0;
        if ((r7 instanceof l9) == false) goto L23;
        MultiLinkVoiceChatFeedView r0 = this.a;
        l9 r8 = (l9) r7;
        int r4 = MultiLinkVoiceChatFeedView.P1;
        r0.getClass();
        if (StringsKt.equals$default(r8.getWrdsSubKeyFlex(), "SubtitleStatusSubSyncKey", false, 2, null) == false) goto L43;
        q2 r5 = r8.getLinkmicSubtitleSettingStatus();
        if (r5 == null) goto L17;
        r0.O = r5;
        if (r0.L == true) goto L15;
        r0.L = true;
        if (r0.N == true) goto L15;
        if (r0.c == null) goto L15;
        r0.H();
    L15:
        r0.Z(r5);
    L17:
        if (r8.getLinkmicSubtitleSettingStatus() == null) goto L20;
        r3 = true;
    L20:
        if (r0.M == r3) goto L44;
        r0.M = r3;
        r0.T();
        return;
    L44:
        return;
    L43:
        return;
    L23:
        if ((r7 instanceof qb) == false) goto L46;
        final MultiLinkVoiceChatFeedView r6 = this.a;
        final qb r9 = (qb) r7;
        int r10 = MultiLinkVoiceChatFeedView.P1;
        r6.getClass();
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(r6.M1) == false) goto L47;
        int r11 = ng0.e.f;
        BaseLinkSeatWindowView r12 = r6.y;
        if (r12 == null) goto L30;
        r1 = r12.getRecyclerView();
    L30:
        if (ng0.e.a.a(r1) == false) goto L32;
        r6.F(r9);
        return;
    L32:
        BaseLinkSeatWindowView r13 = r6.y;
        if (r13 == null) goto L37;
        RecyclerView r14 = r13.getRecyclerView();
        if (r14 == null) goto L37;
        r2 = r14.getChildCount();
    L37:
        if (r2 <= 0) goto L41;
        ConstraintLayout r15 = r6.y;
        if (r15 == null) goto L49;
        int r16 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r15, new MultiLinkVoiceChatFeedView$consumeRadioTextContainerMessage$1(r6, r9));
        return;
    L49:
        return;
    L41:
        r6.g = r9;
        return;
    L47:
        return;
    }
}
