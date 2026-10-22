package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/LinkChannelMessageType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "LinkmicGuestLink_Unknown", "LinkmicGuestLink_InvitationGuide", "LinkmicGuestLink_Invite", "LinkmicGuestLink_Reply", "LinkmicGuestLink_Matchmaking", "LinkmicGuestLink_ReplyMatchmaking", "LinkmicGuestLink_JoinLinkedChannel", "LinkmicGuestLink_Finish", "LinkmicGuestLink_ChannelFinish", "LinkmicGuestLink_ChannelInfoUpdate", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkChannelMessageType extends Enum<LinkChannelMessageType> {
    public static final LinkChannelMessageType LinkmicGuestLink_ChannelFinish = null;
    public static final LinkChannelMessageType LinkmicGuestLink_ChannelInfoUpdate = null;
    public static final LinkChannelMessageType LinkmicGuestLink_Finish = null;
    public static final LinkChannelMessageType LinkmicGuestLink_InvitationGuide = null;
    public static final LinkChannelMessageType LinkmicGuestLink_Invite = null;
    public static final LinkChannelMessageType LinkmicGuestLink_JoinLinkedChannel = null;
    public static final LinkChannelMessageType LinkmicGuestLink_Matchmaking = null;
    public static final LinkChannelMessageType LinkmicGuestLink_Reply = null;
    public static final LinkChannelMessageType LinkmicGuestLink_ReplyMatchmaking = null;
    public static final LinkChannelMessageType LinkmicGuestLink_Unknown = null;
    public static final /* synthetic */ LinkChannelMessageType[] a = null;
    private int value;

    public static LinkChannelMessageType valueOf(String r1) {
        return (LinkChannelMessageType) r27.a.a(LinkChannelMessageType.class, r1);
    }

    public static LinkChannelMessageType[] values() {
        return (LinkChannelMessageType[]) a.clone();
    }

    static {
        LinkChannelMessageType r1 = new LinkChannelMessageType("LinkmicGuestLink_Unknown", 0, 0);
        LinkmicGuestLink_Unknown = r1;
        LinkChannelMessageType r2 = new LinkChannelMessageType("LinkmicGuestLink_InvitationGuide", 1, 1);
        LinkmicGuestLink_InvitationGuide = r2;
        LinkChannelMessageType r3 = new LinkChannelMessageType("LinkmicGuestLink_Invite", 2, 2);
        LinkmicGuestLink_Invite = r3;
        LinkChannelMessageType r4 = new LinkChannelMessageType("LinkmicGuestLink_Reply", 3, 3);
        LinkmicGuestLink_Reply = r4;
        LinkChannelMessageType r5 = new LinkChannelMessageType("LinkmicGuestLink_Matchmaking", 4, 4);
        LinkmicGuestLink_Matchmaking = r5;
        LinkChannelMessageType r6 = new LinkChannelMessageType("LinkmicGuestLink_ReplyMatchmaking", 5, 6);
        LinkmicGuestLink_ReplyMatchmaking = r6;
        LinkChannelMessageType r7 = new LinkChannelMessageType("LinkmicGuestLink_JoinLinkedChannel", 6, 7);
        LinkmicGuestLink_JoinLinkedChannel = r7;
        LinkChannelMessageType r8 = new LinkChannelMessageType("LinkmicGuestLink_Finish", 7, 8);
        LinkmicGuestLink_Finish = r8;
        LinkChannelMessageType r9 = new LinkChannelMessageType("LinkmicGuestLink_ChannelFinish", 8, 101);
        LinkmicGuestLink_ChannelFinish = r9;
        LinkChannelMessageType r11 = new LinkChannelMessageType("LinkmicGuestLink_ChannelInfoUpdate", 9, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH);
        LinkmicGuestLink_ChannelInfoUpdate = r11;
        a = new LinkChannelMessageType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11};
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public LinkChannelMessageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
