package com.bytedance.android.livesdk.interactivity.medialink.widget.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.message.model.gf;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import com.bytedance.common.utility.Logger;
import gm2.i;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends n<IMediaMultiLinkAudienceView> implements l {
    public Room e;
    public final MediaMultiAnchorLinkContext f;

    public c(MediaMultiAnchorLinkContext r1) {
        this.f = r1;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IMediaMultiLinkAudienceView) r1);
    }

    public final void g0(IMediaMultiLinkAudienceView r2) {
        super.c0(r2);
        this.e = (Room) ((n) this).c.get("data_room");
        d r3 = ((n) this).d;
        r3.addMessageListener(MessageType.LINKER.getIntType(), this);
        r3.addMessageListener(MessageType.LINK_MIC_SIGNAL.getIntType(), this);
    }

    public final void onMessage(tlc.d r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if ((r7 instanceof if) == false) goto L36;
        if r0 = (if) r7;
        int r2 = r0.mScene;
        if (r2 == 7) goto L10;
        if (r2 == 2) goto L10;
        return;
    L10:
        int r3 = r0.getMType();
        if (r3 == 2) goto L31;
        if (r3 == 6) goto L27;
        if (r3 != 7) goto L36;
        LinkerLeaveContent r1 = r0.mLeave;
        if (r1 == null) goto L36;
        String r4 = r1.getUserIdStr();
        Room r5 = this.e;
        if (r5 == null) goto L21;
        String r6 = r5.getOwnerUserIdString();
    L23:
        if (Intrinsics.areEqual(r4, r6) == false) goto L36;
        IMediaMultiLinkAudienceView r8 = ((q46.b) this).a;
        if (r8 == null) goto L36;
        r8.pA("receive_link_message_7", false);
        goto L36
    L21:
        r6 = null;
        goto L23
    L27:
        ALogger.w("MediaLinkTracer", "audience reset channelId " + r0.getLinkerId());
        MediaMultiAnchorLinkContext r9 = this.f;
        if (r9 == null) goto L36;
        r9.setChannelId(r0.getLinkerId());
        goto L36
    L31:
        if (r0.getLinkerId() != MediaMultiAnchorLinkContext.Companion.a()) goto L36;
        IMediaMultiLinkAudienceView r10 = ((q46.b) this).a;
        if (r10 == null) goto L36;
        r10.pA("receive_link_message_2", false);
    L36:
        if ((r7 instanceof gf) == false) goto L58;
        i r11 = ((gf) r7).getLinkMicSignal();
        if (r11 != null) goto L57;
        return;
    L57:
        String r13 = r11.senderInteractIdStr;     // Catch: NumberFormatException -> L54
        if (r13 != null) goto L43;
        r13 = r11.senderInteractId;     // Catch: NumberFormatException -> L54
    L43:
        int r14 = r11.type;     // Catch: NumberFormatException -> L54
        if (r14 != 100101) goto L49;
        IMediaMultiLinkAudienceView r15 = ((q46.b) this).a;     // Catch: NumberFormatException -> L54
        if (r15 == null) goto L59;
        r15.R6(r13, true);     // Catch: NumberFormatException -> L54
        return;
    L59:
        return;
    L49:
        if (r14 != 100102) goto L61;
        IMediaMultiLinkAudienceView r16 = ((q46.b) this).a;     // Catch: NumberFormatException -> L54
        if (r16 == null) goto L62;
        r16.R6(r13, false);     // Catch: NumberFormatException -> L54
        return;
    L62:
        return;
    L61:
        return;
    L54:
        e = move-exception;
        Logger.e(e.toString());
        return;
    }
}
