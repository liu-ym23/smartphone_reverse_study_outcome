package com.bytedance.android.live.base.model.data;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.link.ILinkInviteRoomInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u000fR\u001a\u0010\"\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/base/model/data/h;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getInviter", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getInviter$annotations", "()V", "inviter", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfo;", "getInviterRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfo;", "getInviterRoomInfo$annotations", "inviterRoomInfo", "", "getInviteTips", "()Ljava/lang/String;", "getInviteTips$annotations", "inviteTips", "", "getInviterRoomJoinStatus", "()Ljava/lang/Integer;", "getInviterRoomJoinStatus$annotations", "inviterRoomJoinStatus", "Lcom/bytedance/android/live/liveinteract/multiscene/c;", "getRoomBattleMode", "()Lcom/bytedance/android/live/liveinteract/multiscene/c;", "getRoomBattleMode$annotations", "roomBattleMode", "getIntroContent", "getIntroContent$annotations", "introContent", "getCrossRoomKind", "()I", "getCrossRoomKind$annotations", "crossRoomKind", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.c<h> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "cross_room_kind")
    int getCrossRoomKind();

    @FieldName(name = "introduction_content")
    String getIntroContent();

    @FieldName(name = "invite_tips")
    String getInviteTips();

    @FieldName(name = "inviter")
    IBaseUser getInviter();

    @FieldName(name = "room_info")
    ILinkInviteRoomInfo getInviterRoomInfo();

    @FieldName(name = "inviter_room_join_status")
    Integer getInviterRoomJoinStatus();

    @FieldName(name = "room_battle_mode")
    com.bytedance.android.live.liveinteract.multiscene.c getRoomBattleMode();
}
