package com.bytedance.android.live.room;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.j0;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.end.EndingPageGuideCardInfo;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J=\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&J,\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\b\u0010\"\u001a\u00020!H&J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H&J\u0010\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0014H&J\n\u0010*\u001a\u0004\u0018\u00010)H&J\u0010\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0014H&J\b\u0010-\u001a\u00020\rH&J\u0012\u00100\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010/0.H&J\u0014\u00102\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000101\u0018\u00010.H&J\n\u00103\u001a\u0004\u0018\u00010\u0006H&J\b\u00104\u001a\u00020\u0014H&J\n\u00106\u001a\u0004\u0018\u000105H&J\u0010\u00108\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0014H&J\b\u0010:\u001a\u000209H&J\u0012\u0010=\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010;H&J\u0012\u0010>\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010;H&J\n\u0010@\u001a\u0004\u0018\u00010?H&J\b\u0010A\u001a\u00020\u0014H&J\u001a\u0010D\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010C\u001a\u00020BH&J\n\u0010F\u001a\u0004\u0018\u00010EH&J\b\u0010G\u001a\u00020\u0014H&J\u0012\u0010H\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010;H&J\b\u0010I\u001a\u00020\rH&J$\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0N0M2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u0006H&J,\u0010W\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020B2\b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010V\u001a\u0004\u0018\u00010UH&J\b\u0010X\u001a\u00020\rH&J\b\u0010Z\u001a\u00020YH&R\u001c\u0010[\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\\R\u001c\u0010`\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010^R\u0014\u0010b\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\\R\u0014\u0010c\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\\¨\u0006d"}, d2 = {"Lcom/bytedance/android/live/room/IMiddlewareRoomService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseLiveActionHandler;", "actionHandler", "Lcom/bytedance/android/live/room/k;", "roomCacheManager", "", "userIds", "scenes", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "filterReason", "", "callBack", "checkUerLiveFilterReason", "Lcom/bytedance/android/livesdk/chatroom/j;", "backToRoomDataUtil", "Lvt2/b;", "followTeaAndTraceMonitor", "", "isPad", "Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "info", "Lcom/bytedance/android/livesdk/end/LiveEndPageData;", "getDynamicComponentFromHost", "", Constants.Keys.DATA, "", "tags", "Landroid/os/Bundle;", "bundle", "configRoomParamsProducer", "Lcom/bytedance/android/live/room/q;", "roomInteractService", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/RoomBaseSession;", "session", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getMiddlewareRoomContextFromRoomSession", "isOpenCropImage", "setIsOpenCropImagePage", "Lcom/bytedance/android/live/core/utils/j0;", "getFontManager", "isShow", "updateMultiLinkNotificationStatus", "stopMultiLinkNotification", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getToolbarWidgetClass", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getVSRoomRankWidget", "getIntentRecognition", "checkOrLoadAudioResource", "Lcom/bytedance/android/livesdk/share/a;", "share", "isJump", "setIsOnNeedMuteAudioFullPage", "Lcom/bytedance/android/livesdkapi/ILiveOntologyInfoManager;", "getLiveOntologyRecord", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "isNewFeedStyle", "isNewStyleForTTLite", "Lcom/bytedance/android/live/room/f;", "getEnterConfigManager", "isSlideUpTipShowing", "", "action", "shouldFeedbackInterceptLeaveRoom", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService;", "getMiddlewareRecordService", "isClearScreenDisableGuide", "doOnToolbarViewModelInit", "showRecordTipDialog", "", "roomId", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoomInfoByScene", "x", "y", "Landroid/view/View;", "target", "Landroid/view/MotionEvent;", "event", "judgeTargetOnClearScreenForSingleView", "userInfoAutoAntiDeterioration", "Lz81/a;", "getPadFoldDeviceSendFilter", "isOnNeedMuteAudioFullPage", "()Z", "setOnNeedMuteAudioFullPage", "(Z)V", "isOpenCropImagePage", "isOpenImagePickerForCustomEmoji", "setOpenImagePickerForCustomEmoji", "isRecording", "isClearRecord", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareRoomService extends IService {
    IBaseLiveActionHandler actionHandler();

    com.bytedance.android.livesdk.chatroom.j backToRoomDataUtil();

    boolean checkOrLoadAudioResource();

    void checkUerLiveFilterReason(String r1, String r2, Function1<? super String, Unit> r3);

    Object configRoomParamsProducer(Object r1, Set<?> r2, Bundle r3);

    void doOnToolbarViewModelInit(DataCenter r1);

    vt2.b followTeaAndTraceMonitor();

    LiveEndPageData getDynamicComponentFromHost(boolean r1, EndingPageGuideCardInfo r2);

    f getEnterConfigManager();

    j0 getFontManager();

    String getIntentRecognition();

    ILiveOntologyInfoManager getLiveOntologyRecord();

    ILiveRecordService getMiddlewareRecordService();

    MiddlewareRoomContext getMiddlewareRoomContextFromRoomSession(RoomBaseSession r1);

    z81.a getPadFoldDeviceSendFilter();

    Observable<Response<Room>> getRoomInfoByScene(long r1, String r3);

    Class<? extends Widget> getToolbarWidgetClass();

    Class<? extends LiveRecyclableWidget> getVSRoomRankWidget();

    boolean isClearRecord();

    boolean isClearScreenDisableGuide();

    boolean isNewFeedStyle(DataCenter r1);

    boolean isNewStyleForTTLite(DataCenter r1);

    boolean isOnNeedMuteAudioFullPage();

    boolean isOpenCropImagePage();

    boolean isOpenImagePickerForCustomEmoji();

    boolean isRecording();

    boolean isSlideUpTipShowing();

    boolean judgeTargetOnClearScreenForSingleView(int r1, int r2, View r3, MotionEvent r4);

    k roomCacheManager();

    q roomInteractService();

    void setIsOnNeedMuteAudioFullPage(boolean r1);

    void setIsOpenCropImagePage(boolean r1);

    void setOnNeedMuteAudioFullPage(boolean r1);

    void setOpenImagePickerForCustomEmoji(boolean r1);

    com.bytedance.android.livesdk.share.a share();

    boolean shouldFeedbackInterceptLeaveRoom(DataCenter r1, int r2);

    void showRecordTipDialog();

    void stopMultiLinkNotification();

    void updateMultiLinkNotificationStatus(boolean r1);

    void userInfoAutoAntiDeterioration();
}
