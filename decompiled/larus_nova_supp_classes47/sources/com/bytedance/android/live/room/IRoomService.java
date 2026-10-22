package com.bytedance.android.live.room;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.j0;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.RoomService")
public interface IRoomService extends IMiddlewareRoomService, ILiveRoomService {

    /* JADX INFO: renamed from: com.bytedance.android.live.room.IRoomService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ IBaseLiveActionHandler $default$actionHandler(IRoomService r0) {
            return r0.m997actionHandler();
        }
    }

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    /* bridge */ /* synthetic */ IBaseLiveActionHandler actionHandler();

    /* JADX INFO: renamed from: actionHandler, reason: collision with other method in class */
    ILiveActionHandler m997actionHandler();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.u getAnimatedButtonController();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.u getAnimatedButtonController(long r1, long r3);

    Class<? extends AbsMergeWidget> getCardPlaceWidgetClass();

    AbsMergeWidget getCardPlaceWidgetInstance();

    a91.a getCrossRoomGift();

    Dialog getEnsureKickOutDialog(Context r1, long r2, String r4, String r5, String r6);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    j0 getFontManager();

    int getInteractionLayoutId();

    int getLiveCurType();

    com.bytedance.android.live.room.utils.a getLiveMultiTabHandler();

    String getLiveType(Room r1);

    Dialog getManageDialog(Context r1, Room r2, User r3, boolean r4, boolean r5, boolean r6, UserProfileEvent r7, Bundle r8, boolean r9);

    ILiveRecordService getRecordService();

    RoomContext getRoomDataContext(DataCenter r1);

    tlc.d getRoomPushMessage(long r1, ImageModel r3, String r4, int r5, String r6, String r7, String r8, String r9);

    IShortTermIndicatorManager getShortTermIndicatorManager(DataCenter r1);

    u getToolbarConfig();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    Class<? extends Widget> getToolbarWidgetClass();

    Class<? extends Widget> getTopRightBannerWidgetClass();

    LiveRecyclableWidget getUnionAnchorInfoWidget(boolean r1);

    HashMap<String, Class<? extends LiveRecyclableWidget>> getWidgetPool();

    void gotoLiveByProfile(Activity r1, DataCenter r2, String r3, String r4, long r5);

    Disposable inviteUserForGame(DataCenter r1, long r2);

    boolean isAudienceNewMorePanel(DataCenter r1);

    boolean isAudienceNewMorePanelLightTheme(DataCenter r1);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isClearRecord();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isClearScreenDisableGuide();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isNewFeedStyle(DataCenter r1);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isNewStyleForTTLite(DataCenter r1);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isOnNeedMuteAudioFullPage();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isOpenCropImagePage();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isOpenImagePickerForCustomEmoji();

    boolean isStopPlayingOnBg();

    boolean isVrCamera(DataCenter r1);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean judgeTargetOnClearScreenForSingleView(int r1, int r2, View r3, MotionEvent r4);

    n messageManagerHelper();

    boolean needHideShare(IUser r1);

    PermissionGrantStatus obtainPermissionGrantStatus();

    void openDrawer(Activity r1, boolean r2, Bundle r3, DataCenter r4);

    Spannable parsePatternAndGetSpannable(Text r1, String r2);

    Spannable parsePatternAndGetSpannable(String r1, Text r2);

    void preOpenLynxDrawer(Activity r1, boolean r2, Bundle r3, DataCenter r4);

    void registerActions();

    void savePermissionGrantStatus(PermissionGrantStatus r1);

    void setBroadcastActivityDirectlyShow(boolean r1);

    a91.a setCrossRoomGift(a91.a r1);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void setIsOpenCropImagePage(boolean r1);

    void setLiveCurType(int r1);

    void setLiveRoomDetail(DataCenter r1);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean shouldFeedbackInterceptLeaveRoom(DataCenter r1, int r2);

    Disposable silenceAnonymousUser(long r1, boolean r3, Consumer<Response<Object>> r4, Consumer<Throwable> r5);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void stopMultiLinkNotification();

    IToolbarManagerHelper toolbarManagerHelper();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void updateMultiLinkNotificationStatus(boolean r1);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void userInfoAutoAntiDeterioration();
}
