package com.bytedance.android.live.revenuelink.connect;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/ConnectAutoRejectType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "ERROR_IN_MESSAGE", "ERROR_IN_SYSTEM", "MOSAIC_STATUS", "IS_PLAYING_GAME", "MODE_VIDEO_TALK", "MODE_IN_ROOM_AUDIO_INTERACT", "IS_LINK_WITH_AUDIENCE", "PRECISION_MATCHING", "PK_NOTIFYING", "REJECT_IN_INVITING", "REJECT_IN_BE_INVITING", "REJECT_IN_APPLYING", "LINKING_NOT_MULTI_INVITE", "CHANNEL_ID_SAME", "MULTI_INVITE_NOT_LINKING", "MULTI_INVITE_PK_WITH_AUDIENCE", "MULTI_INVITE_LINK_ANCHOR_CNT", "REJECT_IN_MATCHING_INVITE", "revenue-link-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ConnectAutoRejectType extends Enum<ConnectAutoRejectType> {
    public static final ConnectAutoRejectType CHANNEL_ID_SAME = null;
    public static final ConnectAutoRejectType ERROR_IN_MESSAGE = null;
    public static final ConnectAutoRejectType ERROR_IN_SYSTEM = null;
    public static final ConnectAutoRejectType IS_LINK_WITH_AUDIENCE = null;
    public static final ConnectAutoRejectType IS_PLAYING_GAME = null;
    public static final ConnectAutoRejectType LINKING_NOT_MULTI_INVITE = null;
    public static final ConnectAutoRejectType MODE_IN_ROOM_AUDIO_INTERACT = null;
    public static final ConnectAutoRejectType MODE_VIDEO_TALK = null;
    public static final ConnectAutoRejectType MOSAIC_STATUS = null;
    public static final ConnectAutoRejectType MULTI_INVITE_LINK_ANCHOR_CNT = null;
    public static final ConnectAutoRejectType MULTI_INVITE_NOT_LINKING = null;
    public static final ConnectAutoRejectType MULTI_INVITE_PK_WITH_AUDIENCE = null;
    public static final ConnectAutoRejectType PK_NOTIFYING = null;
    public static final ConnectAutoRejectType PRECISION_MATCHING = null;
    public static final ConnectAutoRejectType REJECT_IN_APPLYING = null;
    public static final ConnectAutoRejectType REJECT_IN_BE_INVITING = null;
    public static final ConnectAutoRejectType REJECT_IN_INVITING = null;
    public static final ConnectAutoRejectType REJECT_IN_MATCHING_INVITE = null;
    public static final /* synthetic */ ConnectAutoRejectType[] a = null;
    private final String type;

    public static ConnectAutoRejectType valueOf(String r1) {
        return (ConnectAutoRejectType) r27.a.a(ConnectAutoRejectType.class, r1);
    }

    public static ConnectAutoRejectType[] values() {
        return (ConnectAutoRejectType[]) a.clone();
    }

    static {
        ConnectAutoRejectType r1 = new ConnectAutoRejectType("ERROR_IN_MESSAGE", 0, "error_in_message");
        ERROR_IN_MESSAGE = r1;
        ConnectAutoRejectType r2 = new ConnectAutoRejectType("ERROR_IN_SYSTEM", 1, "error_in_system");
        ERROR_IN_SYSTEM = r2;
        ConnectAutoRejectType r3 = new ConnectAutoRejectType("MOSAIC_STATUS", 2, "mosaic_status");
        MOSAIC_STATUS = r3;
        ConnectAutoRejectType r4 = new ConnectAutoRejectType("IS_PLAYING_GAME", 3, "isPlayingGame");
        IS_PLAYING_GAME = r4;
        ConnectAutoRejectType r5 = new ConnectAutoRejectType("MODE_VIDEO_TALK", 4, "mode_video_talk");
        MODE_VIDEO_TALK = r5;
        ConnectAutoRejectType r6 = new ConnectAutoRejectType("MODE_IN_ROOM_AUDIO_INTERACT", 5, "mode_in_room_audio_interact");
        MODE_IN_ROOM_AUDIO_INTERACT = r6;
        ConnectAutoRejectType r7 = new ConnectAutoRejectType("IS_LINK_WITH_AUDIENCE", 6, "is_link_with_audience");
        IS_LINK_WITH_AUDIENCE = r7;
        ConnectAutoRejectType r8 = new ConnectAutoRejectType("PRECISION_MATCHING", 7, "precision_match");
        PRECISION_MATCHING = r8;
        ConnectAutoRejectType r9 = new ConnectAutoRejectType("PK_NOTIFYING", 8, "pk_notifying");
        PK_NOTIFYING = r9;
        ConnectAutoRejectType r10 = new ConnectAutoRejectType("REJECT_IN_INVITING", 9, "reject_in_inviting");
        REJECT_IN_INVITING = r10;
        ConnectAutoRejectType r12 = new ConnectAutoRejectType("REJECT_IN_BE_INVITING", 10, "reject_in_be_inviting");
        REJECT_IN_BE_INVITING = r12;
        ConnectAutoRejectType r13 = new ConnectAutoRejectType("REJECT_IN_APPLYING", 11, "reject_in_applying");
        REJECT_IN_APPLYING = r13;
        ConnectAutoRejectType r14 = new ConnectAutoRejectType("LINKING_NOT_MULTI_INVITE", 12, "linking_not_multi_invite");
        LINKING_NOT_MULTI_INVITE = r14;
        ConnectAutoRejectType r15 = new ConnectAutoRejectType("CHANNEL_ID_SAME", 13, "channel_id_same");
        CHANNEL_ID_SAME = r15;
        ConnectAutoRejectType r16 = new ConnectAutoRejectType("MULTI_INVITE_NOT_LINKING", 14, "multi_invite_not_linking");
        MULTI_INVITE_NOT_LINKING = r16;
        ConnectAutoRejectType r17 = new ConnectAutoRejectType("MULTI_INVITE_PK_WITH_AUDIENCE", 15, "multi_invite_pk_with_audience");
        MULTI_INVITE_PK_WITH_AUDIENCE = r17;
        ConnectAutoRejectType r18 = new ConnectAutoRejectType("MULTI_INVITE_LINK_ANCHOR_CNT", 16, "multi_invite_link_anchor_cnt");
        MULTI_INVITE_LINK_ANCHOR_CNT = r18;
        ConnectAutoRejectType r19 = new ConnectAutoRejectType("REJECT_IN_MATCHING_INVITE", 17, "reject_in_match_invite");
        REJECT_IN_MATCHING_INVITE = r19;
        a = new ConnectAutoRejectType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    public final String getType() {
        return this.type;
    }

    public ConnectAutoRejectType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
