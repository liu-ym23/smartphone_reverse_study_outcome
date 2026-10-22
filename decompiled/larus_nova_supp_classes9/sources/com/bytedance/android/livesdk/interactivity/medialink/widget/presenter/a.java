package com.bytedance.android.livesdk.interactivity.medialink.widget.presenter;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.message.linker.LinkerCloseContent;
import com.bytedance.android.livesdk.message.model.CrossRoomRTCInfoContent;
import com.bytedance.android.livesdk.message.model.gf;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.common.utility.Logger;
import e92.m;
import gm2.i;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends n<IMediaMultiLinkAnchorView> implements l {
    public final MediaMultiAnchorLinkContext e;

    public a(MediaMultiAnchorLinkContext r1) {
        this.e = r1;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IMediaMultiLinkAnchorView) r1);
    }

    public final void g0(IMediaMultiLinkAnchorView r2) {
        super.c0(r2);
        Room r3 = (Room) ((n) this).c.get("data_room");
        ((n) this).d.addMessageListener(MessageType.LINKER.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.LINK_MIC_SIGNAL.getIntType(), this);
    }

    public final void onMessage(d r8) {
        if ((r8 instanceof if) == false) goto L46;
        if r9 = (if) r8;
        if (r9.mScene == 17) goto L7;
        return;
    L7:
        int r0 = r9.getMType();
        if (r0 == 2) goto L32;
        if (r0 == 13) goto L25;
        if (r0 != 49) goto L84;
        MediaMultiAnchorLinkContext r1 = this.e;
        if (r1 == null) goto L21;
        CrossRoomRTCInfoContent r10 = r9.crossRoomRTCInfoContent;
        if (r10 == null) goto L19;
        MultiChannelInfo r11 = r10.getMultiChannelInfo();
    L20:
        MediaMultiAnchorLinkContext.setMultiChannelInfo$default(r1, r11, false, 2, null);
        goto L21
    L19:
        r11 = null;
    L21:
        IMediaMultiLinkAnchorView r13 = ((q46.b) this).a;
        if (r13 == null) goto L70;
        r13.ZU();
        return;
    L70:
        return;
    L84:
        return;
    L25:
        if (r9.mScene == 17) goto L27;
        return;
    L27:
        if (r9.getLinkerId() != MediaMultiAnchorLinkContext.Companion.a()) goto L73;
        IMediaMultiLinkAnchorView r14 = ((q46.b) this).a;
        if (r14 == null) goto L74;
        r14.Yu("receive_link_message_13", false);
        return;
    L74:
        return;
    L73:
        return;
    L32:
        if (r9.mScene == 17) goto L34;
        return;
    L34:
        if (r9.getLinkerId() != MediaMultiAnchorLinkContext.Companion.a()) goto L77;
        LinkerCloseContent r15 = r9.mClose;
        if (r15 == null) goto L40;
        if (r15.getSource() != 1) goto L40;
        return;
    L40:
        if (m.e() == true) goto L42;
        f2.b(2131920239, 0);
    L42:
        IMediaMultiLinkAnchorView r16 = ((q46.b) this).a;
        if (r16 == null) goto L79;
        r16.Yu("receive_link_message_2", false);
        return;
    L79:
        return;
    L77:
        return;
    L46:
        if ((r8 instanceof gf) == false) goto L81;
        gf r17 = (gf) r8;
        if (r17.getLinkMicSignal() != null) goto L50;
        return;
    L50:
        i r18 = r17.getLinkMicSignal();
        int r2 = r18.type;     // Catch: NumberFormatException -> L66
        if (r2 != 100102) goto L59;
        String r3 = r18.senderInteractIdStr;     // Catch: NumberFormatException -> L66
        if (r3 != null) goto L57;
        r3 = r18.senderInteractId;     // Catch: NumberFormatException -> L66
    L57:
        ((q46.b) this).a.R6(r3, true);     // Catch: NumberFormatException -> L66
        return;
    L59:
        if (r2 != 100101) goto L83;
        String r4 = r18.senderInteractIdStr;     // Catch: NumberFormatException -> L66
        if (r4 != null) goto L64;
        r4 = r18.senderInteractId;     // Catch: NumberFormatException -> L66
    L64:
        ((q46.b) this).a.R6(r4, false);     // Catch: NumberFormatException -> L66
        return;
    L83:
        return;
    L66:
        e = move-exception;
        Logger.e(e.toString());
        return;
    }
}
