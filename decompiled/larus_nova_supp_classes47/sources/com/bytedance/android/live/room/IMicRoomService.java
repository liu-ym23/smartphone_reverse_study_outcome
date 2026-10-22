package com.bytedance.android.live.room;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.microom.MicRoomService")
public interface IMicRoomService extends IMiddlewareMicRoomService {
    public static final String CAROUSEL_ANCHOR_CHANGE_AUTO = "carousel_anchor_change_auto";
    public static final String CAROUSEL_TO_NON_CAROUSEL_AUTO = "carousel_to_non_carousel_auto";
    public static final String LEAVE_CAROUSEL_ROOM = "leave_carousel_room";
    public static final String NON_CAROUSEL_TO_CAROUSEL_AUTO = "non_carousel_to_carousel_auto";

    boolean disableReEnterRoomForLinkGuest();

    String getChangeTypeForLog();

    Class<? extends LiveRecyclableWidget> getMicRoomAnchorGrabMicWidget();

    Class<? extends LiveRecyclableWidget> getMicRoomAnchorTimeControlWidget();

    Class<? extends LiveRecyclableWidget> getMicRoomAnchorWidget();

    Class<? extends LiveRecyclableWidget> getMicRoomAudienceControlWidget();

    Class<? extends LiveRecyclableWidget> getMicRoomBackUpRoomWidget();

    Class<? extends LiveRecyclableWidget> getMicRoomCenterCountDownWidget();

    Class<? extends LiveRecyclableWidget> getMicRoomCountDownWidget();

    Class<? extends LiveRecyclableWidget> getMicRoomEnterOfficialWidget();

    String getMicRoomJumpType();

    Class<? extends LiveRecyclableWidget> getMicRoomOfficialInfoWidget();

    Class<? extends LiveRecyclableWidget> getNormalRoomMicListWidget();

    Class<? extends LiveRecyclableWidget> getNormalRoomShowListWidget();

    boolean isPseudoLiving();

    void setAnchorDisable(boolean r1);

    void setAnchorMicRoomStatus(int r1);

    void setMicRoomJumpType(String r1);

    void setPseudoLiving(boolean r1);

    boolean willNext(IRoom r1);
}
