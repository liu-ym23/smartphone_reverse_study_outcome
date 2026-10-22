package com.bytedance.android.livesdk.interactivity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.j4;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdk.config.ck1;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.api.RoomChannelRetrofitApi;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.IPSOperatePanelService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdk.viewmodel.DrawCleanScreenViewModel;
import com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig;
import com.bytedance.android.livesdkapi.depend.model.live.MatchData;
import com.bytedance.android.livesdkapi.depend.model.live.MatchRoomData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature;
import com.bytedance.android.openlive.realtime.signal.CommentRealtimeSignal;
import com.bytedance.android.openlive.realtime.source.UserRealtimeSignalSources;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J,\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u001b\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u001c\u0010\u001f\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0002H\u0016J\n\u0010&\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0012\u0010-\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J&\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\"\u001a\u00020!2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\r0/H\u0016J\u0010\u00105\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\f\u00109\u001a\u0006\u0012\u0002\b\u000308H\u0016J\b\u0010:\u001a\u00020\rH\u0016J\b\u0010;\u001a\u00020\rH\u0016J(\u0010=\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0016J\u0012\u0010?\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010@\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010A\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u001dH\u0016J(\u0010F\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001dH\u0016J(\u0010G\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001dH\u0016J$\u0010I\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020H2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J \u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010K\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010L\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH\u0016J \u0010Q\u001a\u00020P2\u0006\u0010M\u001a\u00020'2\u0006\u0010O\u001a\u00020N2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010S\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010'2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010R\u0012\u0004\u0012\u00020\r0/H\u0016JT\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\\0[2\u0006\u0010\"\u001a\u00020!2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u001d2\u0006\u0010Z\u001a\u00020\u001dH\u0016J\u0018\u0010a\u001a\u00020`2\u0006\u0010T\u001a\u00020!2\u0006\u0010_\u001a\u00020]H\u0016J \u0010b\u001a\u00020`2\u0006\u0010T\u001a\u00020!2\u0006\u0010W\u001a\u00020!2\u0006\u0010_\u001a\u00020]H\u0016J\u0012\u0010c\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J2\u0010g\u001a\u00020\r2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020!2\u0006\u0010d\u001a\u00020\u001d2\b\u0010f\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010h\u001a\u00020\u00022\b\u0010M\u001a\u0004\u0018\u00010'H\u0016J\"\u0010m\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010j\u001a\u00020i2\u0006\u0010l\u001a\u00020kH\u0016J\u0014\u0010n\u001a\u0004\u0018\u00010'2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010o\u001a\u00020\u0002H\u0016J\u0012\u0010p\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010s\u001a\u00020\r2\u0006\u0010r\u001a\u00020qH\u0016J\u0014\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020q0tH\u0016J@\u0010y\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001d2&\u0010x\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010vj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u0001`wH\u0016J\u0018\u0010|\u001a\u00020!2\u0006\u0010z\u001a\u00020\u001d2\u0006\u0010{\u001a\u00020\u001dH\u0016J\b\u0010}\u001a\u00020!H\u0016J\b\u0010\u007f\u001a\u00020~H\u0016J\u001f\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0t2\u0006\u0010T\u001a\u00020!H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020\u00022\u0006\u0010T\u001a\u00020!H\u0016J\u001c\u0010\u0085\u0001\u001a\u00020\r2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0002H\u0016J\u001c\u0010\u0087\u0001\u001a\u00020\r2\u0007\u0010\u0086\u0001\u001a\u00020\u00142\b\u0010f\u001a\u0004\u0018\u00010eH\u0016J\u001b\u0010\u008a\u0001\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!2\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0016J4\u0010\u008e\u0001\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0007\u0010\u008b\u0001\u001a\u00020\u001d2\u0007\u0010\u008c\u0001\u001a\u00020\u001d2\u0007\u0010\u008d\u0001\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0016J\u0014\u0010\u0090\u0001\u001a\u00020\r2\t\u0010l\u001a\u0005\u0018\u00010\u008f\u0001H\u0016¨\u0006\u0093\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/InteractivityInjectService;", "Lcom/bytedance/android/livesdk/interactivity/api/IInteractivityInjectService;", BuildConfig.FLAVOR, "isUserEnterMessage", "currentInSubMatchCamera", "Lcom/bytedance/android/live/base/model/message/t;", "message", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/s;", "messageModel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/r;", "callBack", BuildConfig.FLAVOR, "openPSOperatePanel", "isAnchor", BuildConfig.FLAVOR, "getScore", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "getVideoTalkRoomSubScene", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)Ljava/lang/Integer;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lcom/bytedance/android/livesdk/interactivity/api/s;", "callback", "subscribeVideoTalkRoomSubScene", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "extra", "appendCastSDKLogCommonParams", "canShowCastDanmakuBtn", BuildConfig.FLAVOR, "roomId", "isShadow", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "currentPlayer", "currentClient", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "Lcom/bytedance/live/datacontext/m;", "getLandscapeDialogState", "Lcom/bytedance/android/livesdk/reddot/a;", "audienceRoomBarrageSetting", "isInVrLandscape", "isShowWebAnim", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/chatroom/z0;", "Lio/reactivex/disposables/Disposable;", "subscribeSEITimePair", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "messageBoardInfo", "sendMessageBoardPin", "getMatchAgainstLeftName", "getMatchAgainstRightName", "Ljava/lang/Class;", "getBackendModelClass", "muteLivePlayerClient", "unmuteLivePlayerClient", "map", "buildVsRoomLog", "schema", "openMiniAppToShare", "preloadMiniAPPForInteractivityShare", "openMiniAppFromPublicScreen", "requestPage", "toUserId", "toUserType", "liveType", "logHighScoreSongLabelClick", "logHighScoreSongLabelShow", "Lcom/bytedance/android/live/base/model/message/m1;", "checkThenDoInjectMiniAppParams", "getLiveAnchorChooseButtonReportParam", "preloadMiniApp", "onShowMiniAppItem", "roomContext", "Ly22/d;", "sender", "Ly22/e;", "getChatChannelCommentFlowPlugin", "Ls22/c;", "getChannelGreetingManager", "channelId", "content", "type", "emojiId", "imEmojiDisplayName", "rtfContent", "pasteMethod", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/b;", "channelChat", "response", "Ltlc/d;", "mockChatTextMessageWithResponse", "mockChatEmojiMessageWithResponse", "dataChannelMonitorLink", "emojiName", BuildConfig.FLAVOR, "error", "traceChatFailed", "isInMultiTabMode", "Landroid/view/View;", "containerView", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "changeDrawCleanScreen", "getLiveVisibilityControlContext", "enableToolbarFastGiftOptimize", "getVrMachineLogStr", "Lorg/json/JSONObject;", "adExtra", "handleLiveAdExtraData", "Lkotlin/Pair;", "createSamiTokenParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraParams", "showLiveFloatWindow", "currentUserId", "guestUserId", "hasSecretChatChannel", "getCurrentChatChannelId", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/utils/a$a;", "getCurrentChannelTrackInfo", "getChannelValidStatus", "trySwitchToChannel", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "roomChannelInfo", "addFirst", "createChatChannel", "statusCode", "reportSecretChatSend", "Lvlc/d;", "messageManager", "initKmpRoomMessageCenter", "event", "lable", "anchorId", "reportAdEvent", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "onMessageSendSuccess", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractivityInjectService implements IInteractivityInjectService {

    public static final class a implements com.bytedance.android.live.platformplayer.utils.h {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(ILivePlayerClient r2) {
            Intrinsics.checkNotNullParameter(r2, "client");
            r2.mute("InteractivityInjectService.muteLivePlayerClient");
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((z0) r2);
        }
    }

    public static final class c implements com.bytedance.android.live.platformplayer.utils.h {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void a(ILivePlayerClient r2) {
            Intrinsics.checkNotNullParameter(r2, "client");
            r2.unmute("InteractivityInjectService.unmuteLivePlayerClient");
        }
    }

    public InteractivityInjectService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.C0090a getCurrentChannelTrackInfo() {
        s22.e r0 = ChatChannelUtils.b(null);
        if (r0 == null) goto L18;
        com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> r1 = r0.getCurrentChannel();
        if (r1 == null) goto L18;
        sh6.b r2 = (sh6.b) r1.getValue();
        if (r2 == null) goto L18;
        s22.a r3 = (s22.a) sh6.c.b(r2);
        if (r3 == null) goto L18;
        String r4 = String.valueOf(r3.y());
        boolean r5 = ((Boolean) r3.v().a).booleanValue();
        FansChannelCreateInfo r6 = r3.C();
        if (r6 == null) goto L14;
        String r7 = String.valueOf(r6.getFansChannelType());
        if (r7 == null) goto L14;
    L16:
        return new com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.C0090a(r4, r5, r7, String.valueOf(r3.getChannelId()), String.valueOf(r3.f()), r3.s(), r3.x());
    L14:
        r7 = "0";
    L18:
        return new com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.C0090a(0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public long getCurrentChatChannelId() {
        return ChatChannelUtils.d(null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public Pair<String, JSONObject> createSamiTokenParams() {
        final JSONObject r0 = new JSONObject();
        kjc.c r1 = new kjc.c();
        com.bytedance.android.livesdk.paas.a.a(r1, new InteractivityInjectService$createSamiTokenParams$$inlined$call$lambda$1(r0));
        if (r1.b == true) goto L73;
        kjc.b r2 = r1.a;
        IHostWebView r3 = jc1.k.f(IHostWebView.class);
        String r4 = null;
        boolean r5 = false;
        if (r3 == null) goto L58;
        Map r6 = r3.getHeaderMap("https://" + jc1.k.n(IMiddlewareHostNetwork.class).getHostDomain());
        if (r6 == null) goto L58;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r6.entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L31;
        Map.Entry r9 = (Map.Entry) r8.next();
        CharSequence r10 = (CharSequence) r9.getKey();
        if (r10 != null) goto L14;
    L17:
        boolean r11 = true;
    L18:
        if (r11 == true) goto L28;
        CharSequence r13 = (CharSequence) r9.getValue();
        if (r13 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == true) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L10;
        r7.put(r9.getKey(), r9.getValue());
        goto L10
    L22:
        if (r13.length() == 0) goto L25;
        r14 = false;
    L28:
        r15 = false;
        goto L29
    L14:
        if (r10.length() == 0) goto L17;
        r11 = false;
        goto L18
    L31:
        Iterator r16 = r7.keySet().iterator();
    L33:
        if (r16.hasNext() == false) goto L37;
        Object r17 = r16.next();
        if (StringsKt.equals((String) r17, "X-Tt-Token", true) == false) goto L33;
    L38:
        String r18 = (String) r17;
        String r19 = BuildConfig.FLAVOR;
        if (r18 == null) goto L44;
        String r20 = (String) r7.get(r18);
        if (r20 != null) goto L43;
        r20 = BuildConfig.FLAVOR;
    L43:
        r0.put("x-tt-token", r20);
    L44:
        Iterator r21 = r7.keySet().iterator();
    L46:
        if (r21.hasNext() == false) goto L50;
        Object r23 = r21.next();
        if (StringsKt.equals((String) r23, "sdk-version", true) == false) goto L46;
    L51:
        String r24 = (String) r23;
        if (r24 == null) goto L58;
        String r25 = (String) r7.get(r24);
        if (r25 == null) goto L57;
        r19 = r25;
    L57:
        r0.put("sdk-version", r19);
        goto L58
    L50:
        r23 = null;
        goto L51
    L37:
        r17 = null;
    L58:
        IMiddlewareUserService r26 = jc1.k.f(IMiddlewareUserService.class);
        if (r26 == null) goto L71;
        com.bytedance.android.livesdk.user.e r27 = r26.user();
        if (r27 == null) goto L71;
        String r28 = r27.getSessionKey();
        if (r28 == null) goto L71;
        if (r28.length() <= 0) goto L67;
        r5 = true;
    L67:
        if (r5 == false) goto L69;
        r4 = r28;
    L69:
        if (r4 == null) goto L71;
        r0.put("cookie", "sessionid=".concat(r4));
    L71:
        r0.put("passport-auth", "session");
        r2.a = new Pair("KHBEDXeGDw", r0);
    L73:
        return (Pair) r1.a.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean isShowWebAnim() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n r1 = r0.getDataCenter();
        if (r1 == null) goto L11;
        DataCenter r2 = (DataCenter) r1.getValue();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.get("cmd_notify_web_dialog_status", Boolean.FALSE);
        if (r3 == null) goto L11;
        return r3.booleanValue();
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean isUserEnterMessage() {
        return ((ck1) qy0.a.getValue()).i();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void muteLivePlayerClient() {
        LivePlatformPlayerManager.j(a.a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void unmuteLivePlayerClient() {
        LivePlatformPlayerManager.j(c.a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public ILivePlayerClient currentClient() {
        return LivePlatformPlayerManager.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean currentInSubMatchCamera() {
        nm1.m r0 = pm1.f.l();
        if (r0 == null) goto L18;
        RoomContext.a r1 = RoomContext.Companion;
        Long r2 = null;
        RoomContext r6 = RoomContext.a.c(r1, null, 0, 3);
        if (r6 == null) goto L9;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L9;
        Room r8 = (Room) r7.getValue();
    L10:
        RoomContext r3 = RoomContext.a.c(r1, null, 0, 3);
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.m r4 = r3.getCameraId();
        if (r4 == null) goto L16;
        r2 = (Long) r4.getValue();
    L16:
        if (r0.I(r8, r2) != true) goto L18;
        return true;
    L9:
        r8 = null;
    L18:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean enableToolbarFastGiftOptimize() {
        return j4.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public com.bytedance.android.livesdk.reddot.a audienceRoomBarrageSetting() {
        return up2.a.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public Class<?> getBackendModelClass() {
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.api.q.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void appendCastSDKLogCommonParams(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        if (jc1.k.f(ILiveByteCastService.class) == null) goto L6;
        jc1.k.n(ILiveByteCastService.class).appendCastSDKLogCommonParams(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean canShowCastDanmakuBtn(DataCenter r2) {
        ILiveByteCastService r0 = ILiveByteCastService.Companion.getInst();
        if (r0 == null) goto L8;
        if (r2 == null) goto L6;
        Room r3 = z.o(r2);
    L10:
        return r0.canShowCastDanmakuBtn(r3);
    L6:
        r3 = null;
        goto L10
    L8:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void dataChannelMonitorLink(DataCenter r7) {
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r7, 0, 2);
        if (r8 != null) goto L5;
        return;
    L5:
        Object r9 = r8.getRoom().getValue();
        String r1 = null;
        if ((r9 instanceof Room) == true) goto L8;
        r9 = null;
    L8:
        Room r10 = (Room) r9;
        if (r10 != null) goto L11;
        return;
    L11:
        IRoomGameData r0 = r10.roomGameData;
        if (r0 != null) goto L14;
        return;
    L14:
        IRoomGameDataChannelConfig r2 = r0.getRoomGameDataChannelConfig();
        if (r2 != null) goto L17;
        return;
    L17:
        String r3 = r2.getGameId();
        String r4 = r2.getFusionTagId();
        boolean r5 = true;
        if (r3 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == true) goto L57;
        if (r4 != null) goto L27;
    L30:
        boolean r11 = true;
    L31:
        if (r11 == true) goto L59;
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("game_id", r3);
        r13.put("action_type", "comment");
        String r14 = am2.n.f().c();
        if (r14 != null) goto L36;
    L41:
        String r15 = "0";
    L42:
        r13.put("is_ads", r15);
        User r16 = r10.getOwner();
        if (r16 == null) goto L45;
        r1 = r16.getIdString();
    L45:
        if (r1 == null) goto L48;
        r13.put("host_id", r16.getIdString());
    L48:
        if (r10.getIdStr() == null) goto L50;
        r13.put("content_id", r10.getIdStr());
    L50:
        r13.put("scene", "0");
        if (r10.getRequestId() == null) goto L53;
        r13.put("req_id", r10.getRequestId());
    L53:
        IHostGameCP r17 = jc1.k.f(IHostGameCP.class);
        if (r17 == null) goto L58;
        r17.dataChannelLinkEvent("douyin_game_content_consume_click_monitor", r13);
        return;
    L58:
        return;
    L36:
        if (r14.length() == 0) goto L39;
        r5 = false;
    L39:
        if (r5 == true) goto L41;
        r15 = "1";
        goto L42
    L59:
        return;
    L27:
        if (r4.length() == 0) goto L30;
        r11 = false;
        goto L31
    L57:
        return;
    L20:
        if (r3.length() == 0) goto L23;
        r6 = false;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public Pair<Boolean, String> getChannelValidStatus(long r4) {
        String r0 = null;
        s22.e r1 = ChatChannelUtils.b(null);
        if (r1 == null) goto L9;
        s22.a r2 = r1.getChannel(r4);
        if (r2 == null) goto L9;
        boolean r3 = true;
        if (r2.s() != true) goto L9;
    L10:
        s22.e r5 = ChatChannelUtils.b(null);
        if (r5 == null) goto L18;
        s22.a r6 = r5.getChannel(r4);
        if (r6 == null) goto L18;
        PropertyOwner<String> r7 = r6.r();
        if (r7 == null) goto L18;
        r0 = (String) r7.a;
    L18:
        return new Pair(Boolean.valueOf(r3), r0);
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public com.bytedance.live.datacontext.m<Boolean> getLandscapeDialogState(DataContext r2) {
        if ((r2 instanceof RoomContext) == true) goto L6;
        r2 = null;
    L6:
        return ChatChannelUtils.e((RoomContext) r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public Map<String, String> getLiveAnchorChooseButtonReportParam(String r8) {
        int r0 = p.a;
        Pair r9 = p.b(r8, "solid_entrance", "live_take_page", "comment_share", "comment_share", LaunchParamConstant.Scene.a);
        if (r9 != null) goto L7;
        return null;
    L7:
        return (Map) r9.getSecond();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public DataContext getLiveVisibilityControlContext(DataCenter r2) {
        IVisibilityControlBrickService r0 = jc1.k.f(IVisibilityControlBrickService.class);
        if (r0 == null) goto L7;
        IVisibilityControlService r3 = r0.provideVisibilityControlService(r2);
        if (r3 == null) goto L7;
        return r3.provideContext();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public String getMatchAgainstLeftName(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Room r3 = z.o(r2);
        if (r3 == null) goto L12;
        MatchRoomData r4 = r3.matchRoomData;
        if (r4 == null) goto L12;
        MatchData r5 = r4.getMatch();
        if (r5 == null) goto L12;
        IAgainst r6 = r5.getAgainst();
        if (r6 == null) goto L12;
        String r7 = r6.getLeftName();
        if (r7 == null) goto L12;
        return r7;
    L12:
        return BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public String getMatchAgainstRightName(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Room r3 = z.o(r2);
        if (r3 == null) goto L12;
        MatchRoomData r4 = r3.matchRoomData;
        if (r4 == null) goto L12;
        MatchData r5 = r4.getMatch();
        if (r5 == null) goto L12;
        IAgainst r6 = r5.getAgainst();
        if (r6 == null) goto L12;
        String r7 = r6.getRightName();
        if (r7 == null) goto L12;
        return r7;
    L12:
        return BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public float getScore(boolean r1) {
        return com.bytedance.android.livesdk.utils.z0.b(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public Integer getVideoTalkRoomSubScene(DataCenter r5) {
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r6 == null) goto L11;
        com.bytedance.live.datacontext.j r7 = r6.getVideoTalkRoomSubScene();
        if (r7 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r8 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r9 = r8.t();
        if (r9 == null) goto L11;
        return Integer.valueOf(r9.a);
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public String getVrMachineLogStr(DataCenter r1) {
        return VrUtils.o(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void handleLiveAdExtraData(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "adExtra");
        g4.h(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean isInMultiTabMode(DataContext r3) {
        ContainerType r1 = null;
        if ((r3 instanceof RoomContext) == true) goto L5;
        r3 = null;
    L5:
        s22.e r4 = ChatChannelUtils.b((RoomContext) r3);
        if (r4 == null) goto L11;
        s22.e.b r5 = r4.getConfig();
        if (r5 == null) goto L11;
        r1 = r5.a;
    L11:
        if (r1 != ContainerType.MultiTab) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean isInVrLandscape(DataCenter r2) {
        return VrUtils.t(r2, false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void onMessageSendSuccess(Room r8) {
        IUserRealtimeSignalFeature r0 = jc1.k.f(IUserRealtimeSignalFeature.class);
        if (r8 == null) goto L8;
        if (r0 == null) goto L8;
        r0.getCenter().handle(new CommentRealtimeSignal(r8.id, System.currentTimeMillis(), UserRealtimeSignalSources.ROOM));
        return;
    L8:
        ALogger.w("RealtimeSignal", "sendCommentRealtimeSignal() >>> failed due to room=" + r8 + "\tliveService=" + r0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void onShowMiniAppItem(String r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L11;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L11;
        r2.booleanValue();
    L11:
        Pair<String, Map<String, String>> r10 = p.a(r9, "solid_entrance", "live_take_page", "comment_share", "comment_share", LaunchParamConstant.Scene.a, true);
        if (r10 != null) goto L14;
        return;
    L14:
        com.bytedance.android.livesdk.log.u.l().h("mp_show", (Map) r10.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().preloadMiniApp((String) r10.getFirst());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void openMiniAppFromPublicScreen(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        com.bytedance.android.livesdk.interactivity.utils.s.d(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void openMiniAppToShare(String r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L11;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L11;
        boolean r3 = r2.booleanValue();
    L12:
        Pair<String, Map<String, String>> r14 = p.a(r13, "solid_entrance", "live_take_page", "comment_share", "comment_share", LaunchParamConstant.Scene.a, true);
        if (r14 != null) goto L15;
        return;
    L15:
        com.bytedance.android.livesdk.log.u.l().h("mp_click", (Map) r14.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().openMiniApp((String) r14.getFirst(), null);
        if (r3 == false) goto L19;
        ((Boolean) j40.g.a.getValue()).booleanValue();
        return;
    L19:
        return;
    L11:
        r3 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void preloadMiniAPPForInteractivityShare(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.interactivity.api.f r0 = com.bytedance.android.livesdk.interactivity.api.o.b();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j<i42.b> r1 = r0.getMiniAppPreloader();
        if (r1 == null) goto L11;
        i42.b r2 = (i42.b) r1.getValue();
        if (r2 == null) goto L11;
        r2.a(r8);
    L11:
        Pair r9 = p.b(r8, "live_other", g4.d(), "comment_card", "comment_card", LaunchParamConstant.Scene.c);
        if (r9 != null) goto L14;
        return;
    L14:
        j0.l().h("mp_show", (Map) r9.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().preloadMiniApp((String) r9.getFirst());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void preloadMiniApp(String r2) {
        com.bytedance.android.livesdk.interactivity.api.f r0 = com.bytedance.android.livesdk.interactivity.api.o.b();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j<i42.b> r1 = r0.getMiniAppPreloader();
        if (r1 == null) goto L11;
        i42.b r3 = (i42.b) r1.getValue();
        if (r3 == null) goto L12;
        r3.a(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void sendMessageBoardPin(IMessageBoardInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "messageBoardInfo");
        CommentPinContent r0 = new CommentPinContent();
        r0.setContent(f0.a(r4));
        r0.setCommentMsgId(r4.getId());
        Intrinsics.checkNotNullParameter(r4, "$this$getSenderNickName");
        IBaseUser r1 = r4.getSender();
        if (r1 == null) goto L6;
        String r2 = r1.getNickName();
        if (r2 == null) goto L6;
    L7:
        r0.setNickName(r2);
        Intrinsics.checkNotNullParameter(r4, "$this$getSenderId");
        IBaseUser r5 = r4.getSender();
        if (r5 == null) goto L11;
        String r6 = r5.getIdString();
        if (r6 == null) goto L11;
    L12:
        r0.setCommenterId(r6);
        r0.setScene("gift_msg_board");
        r0.setContentType("gift_word");
        k42.b.a(new e42.a(r0));
        return;
    L11:
        r6 = "0";
    L6:
        r2 = BuildConfig.FLAVOR;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public boolean trySwitchToChannel(long r3) {
        s22.e r0 = ChatChannelUtils.b(null);
        if (r0 == null) goto L6;
        r0.trySwitchToChannelPage(r3, PublicScreenAreaPageChangeSource.SecretChat);
        return r0.changeCurrentChannel(r3);
    L6:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void buildVsRoomLog(DataCenter r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "map");
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r7 == null) goto L10;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L11;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L12;
        int r0 = ju2.f.M;
        r6.putAll(ju2.f.a.a(r9).b());
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void checkThenDoInjectMiniAppParams(m1 r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "map");
        com.bytedance.android.live.base.model.data.m r0 = r4.getItemStyle();
        if (r0 == null) goto L5;
        String r1 = r0.itemType;
    L7:
        if (Intrinsics.areEqual(r1, "micro_app") == false) goto L36;
        com.bytedance.android.live.base.model.data.m r2 = r4.getItemStyle();
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L12;
        String r6 = r2.itemId;
        if (r6 == null) goto L12;
    L13:
        r5.put("mp_id", r6);
        com.bytedance.android.live.base.model.data.m r7 = r4.getItemStyle();
        if (r7 == null) goto L37;
        String r8 = r7.schema;
        if (r8 == null) goto L38;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L30
        SchemaInfo.s.getClass();     // Catch: Throwable -> L30
        SchemaInfo r10 = SchemaInfo.b.b(r8);     // Catch: Throwable -> L30
        if (r10 == null) goto L21;
        String r11 = r10.f();     // Catch: Throwable -> L30
        if (r11 == null) goto L21;
    L22:
        r5.put("path", r11);     // Catch: Throwable -> L30
        if (r10 == null) goto L28;
        String r13 = r10.g();     // Catch: Throwable -> L30
        if (r13 == null) goto L28;
        r3 = r13;
    L28:
        r5.put("query", r3);     // Catch: Throwable -> L30
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        Result.box-impl(r14);
        return;
    L21:
        r11 = BuildConfig.FLAVOR;
    L30:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L38:
        return;
    L37:
        return;
    L12:
        r6 = BuildConfig.FLAVOR;
        goto L13
    L36:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void createChatChannel(RoomChannelInfo r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "roomChannelInfo");
        s22.e r3 = ChatChannelUtils.b(null);
        if (r3 == null) goto L6;
        r3.createChannel(r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public ILivePlayerClient currentPlayer(long r1, boolean r3) {
        return LivePlatformPlayerManager.a(r1, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void getChannelGreetingManager(DataContext r2, final Function1<? super s22.c, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        if ((r2 instanceof RoomContext) == true) goto L5;
        r2 = null;
    L5:
        com.bytedance.live.datacontext.j<s22.e> r4 = ChatChannelUtils.n((RoomContext) r2);
        if (r4 == null) goto L9;
        r4.c(new AnonymousClass1(r3));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public long hasSecretChatChannel(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "currentUserId");
        Intrinsics.checkNotNullParameter(r14, "guestUserId");
        Object r0 = null;
        s22.e r1 = ChatChannelUtils.b(null);
        if (r1 == null) goto L33;
        List<s22.a> r2 = r1.getAllChannel();
        if (r2 == null) goto L33;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L30;
        Object r4 = r3.next();
        s22.a r5 = (s22.a) r4;
        String[] r6 = new String[2];
        SecretChatInfo r7 = r5.n();
        if (r7 == null) goto L12;
        Long r8 = Long.valueOf(r7.getGuestUid());
    L13:
        boolean r9 = false;
        r6[0] = String.valueOf(r8);
        SecretChatInfo r10 = r5.n();
        if (r10 == null) goto L16;
        Long r11 = Long.valueOf(r10.getOwnerUid());
    L17:
        r6[1] = String.valueOf(r11);
        if (r5.y() != 1) goto L28;
        SecretChatInfo r15 = r5.n();
        if (r15 == null) goto L28;
        if (r15.getStatus() != 1) goto L28;
        if (ArraysKt.contains(r6, r13) == false) goto L28;
        if (ArraysKt.contains(r6, r14) == false) goto L28;
        r9 = true;
    L28:
        if (r9 == false) goto L8;
        r0 = r4;
        goto L30
    L16:
        r11 = null;
        goto L17
    L12:
        r8 = null;
    L30:
        s22.a r16 = (s22.a) r0;
        if (r16 == null) goto L33;
        return r16.getChannelId();
    L33:
        return -1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void initKmpRoomMessageCenter(long r1, vlc.d r3) {
        Intrinsics.checkNotNullParameter(r3, "messageManager");
        int r2 = ib6.a.a;
        Intrinsics.checkNotNullParameter(r3, "messageManager");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public tlc.d mockChatTextMessageWithResponse(long r5, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.d.a;
        Intrinsics.checkNotNullParameter(r7, "response");
        Intrinsics.checkNotNullParameter(r7, "response");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d r0 = new com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d();
        CommonMessageData r2 = new CommonMessageData();
        r2.messageId = r7.e();
        r2.channelId = r5;
        a5 r6 = r7.b();
        a5 r3 = null;
        if ((r6 instanceof Text) == true) goto L5;
        r6 = null;
    L5:
        r2.setDisplayText((Text) r6);
        Unit r8 = Unit.INSTANCE;
        ((BaseMessage) r0).baseMessage = r2;
        r0.H(r7.f());
        IBaseUser r9 = r7.h();
        if ((r9 instanceof User) == true) goto L8;
        r9 = null;
    L8:
        r0.setUser((User) r9);
        r0.setContent(r7.a());
        a5 r10 = r7.g();
        if ((r10 instanceof Text) == false) goto L12;
        r3 = r10;
    L12:
        r0.P((Text) r3);
        r0.b = true;
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void reportSecretChatSend(int r9, Throwable r10) {
        int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        LinkedHashMap r6 = new LinkedHashMap();
        if (r10 == null) goto L6;
        String r11 = r10.toString();
        if (r11 == null) goto L6;
    L7:
        r6.put("error", r11);
        Unit r13 = Unit.INSTANCE;
        new com.bytedance.android.livesdk.interactivity.api.monitor.c(r9, null, 0, r6, 6).b(InteractivityTraceMonitor.Event.ChatChannelSecretMessageSend);
        return;
    L6:
        r11 = BuildConfig.FLAVOR;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public Disposable subscribeSEITimePair(long r4, Function1<? super z0, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, r4, 1);
        if (r5 == null) goto L10;
        com.bytedance.live.datacontext.m r7 = r5.getSeiTimePair();
        if (r7 == null) goto L11;
        Observable r8 = r7.a();
        if (r8 != null) goto L9;
        return null;
    L9:
        return r8.subscribe(new b(r6));
    L11:
        return null;
    L10:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void changeDrawCleanScreen(DataCenter r5, View r6, IRoom r7) {
        Intrinsics.checkNotNullParameter(r6, "containerView");
        Intrinsics.checkNotNullParameter(r7, "room");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.n r1 = r0.getDrawCleanScreenViewModel();
        if (r1 == null) goto L14;
        DrawCleanScreenViewModel r2 = (DrawCleanScreenViewModel) r1.getValue();
        if (r2 != null) goto L9;
        return;
    L9:
        if ((r7 instanceof Room) == true) goto L11;
        r7 = null;
    L11:
        r2.changeRoomViewVisiable(r5, r6, (Room) r7);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public y22.e getChatChannelCommentFlowPlugin(DataContext r2, y22.d r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "sender");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        return new m62.a((RoomContext) r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public tlc.d mockChatEmojiMessageWithResponse(long r8, long r10, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b r13) {
        Intrinsics.checkNotNullParameter(r13, "response");
        int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.d.a;
        Intrinsics.checkNotNullParameter(r13, "response");
        long r0 = r13.e();
        IBaseUser r2 = r13.h();
        Text r4 = null;
        if ((r2 instanceof User) == true) goto L5;
        r2 = null;
    L5:
        User r3 = (User) r2;
        a5 r5 = r13.c();
        if ((r5 instanceof Text) == true) goto L8;
        r5 = null;
    L8:
        Text r6 = (Text) r5;
        String r7 = r13.a();
        Text r14 = r13.b();
        if ((r14 instanceof Text) == false) goto L12;
        r4 = r14;
    L12:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g r15 = new com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g();
        CommonMessageData r9 = new CommonMessageData();
        r9.messageId = r0;
        r9.channelId = r8;
        r9.setDisplayText(r4);
        Unit r11 = Unit.INSTANCE;
        ((BaseMessage) r15).baseMessage = r9;
        r15.setUser(r3);
        r15.H(r10);
        r15.G(r6);
        r15.setDefaultContent(r7);
        r15.b = true;
        return r15;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void showLiveFloatWindow(Context r3, String r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Activity r6 = ContextUtil.contextToActivity(r3);
        if (r6 != null) goto L5;
        return;
    L5:
        ILiveVideoFloatWindowService r0 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L13;
        InnerContextEntity.InnerFloatExtra r1 = new InnerContextEntity.InnerFloatExtra();
        r1.setRequestPage(r4);
        r1.setExtParams(r5);
        if (r5 == null) goto L10;
        boolean r7 = true;
    L11:
        r1.setEnableExtParams(r7);
        Unit r8 = Unit.INSTANCE;
        r0.startShowFloatInNextLifecycle(r6, r1);
        return;
    L10:
        r7 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void subscribeVideoTalkRoomSubScene(DataCenter r5, final CompositeDisposable r6, final com.bytedance.android.livesdk.interactivity.api.s r7) {
        Intrinsics.checkNotNullParameter(r6, "cd");
        Intrinsics.checkNotNullParameter(r7, "callback");
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r8 == null) goto L8;
        com.bytedance.live.datacontext.j r9 = r8.getVideoTalkRoomSubScene();
        if (r9 == null) goto L9;
        r9.c(new C03041(r7, r6));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void logHighScoreSongLabelClick(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "toUserType");
        Intrinsics.checkNotNullParameter(r5, "liveType");
        IKtvService r0 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r0 == null) goto L6;
        r0.logHighScoreSongLabelClick(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void logHighScoreSongLabelShow(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "toUserType");
        Intrinsics.checkNotNullParameter(r5, "liveType");
        IKtvService r0 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r0 == null) goto L6;
        r0.logHighScoreSongLabelClick(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void openPSOperatePanel(com.bytedance.android.live.base.model.message.t r2, Context r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.s r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.r r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "context");
        IPSOperatePanelService r0 = (IPSOperatePanelService) jc1.k.f(IPSOperatePanelService.class);
        if (r0 == null) goto L6;
        r0.openOperatePanel(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void reportAdEvent(DataCenter r4, String r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "lable");
        Intrinsics.checkNotNullParameter(r7, "anchorId");
        com.bytedance.android.live.core.feed.a.a r0 = com.bytedance.android.live.core.feed.a.d;
        if (r0.a().c(Long.valueOf(r8)) == false) goto L5;
    L6:
        com.bytedance.android.livesdk.log.d.b(r4, r5, r6, r7, String.valueOf(r8));
        return;
    L5:
        if (r0.a().b(Long.valueOf(r8)) == true) goto L6;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public void traceChatFailed(long r2, String r4, long r5, String r7, Throwable r8) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r7, "emojiName");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.c(r2, r4, r5, r7, r8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService
    public Observable<Response<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b>> channelChat(long r14, long r16, String r18, int r19, long r20, String r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r18, "content");
        Intrinsics.checkNotNullParameter(r23, "imEmojiDisplayName");
        Intrinsics.checkNotNullParameter(r24, "rtfContent");
        Intrinsics.checkNotNullParameter(r25, "pasteMethod");
        return ((RoomChannelRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomChannelRetrofitApi.class)).channelChat(r14, r16, r18, r19, r20, r23, r24, r25);
    }
}
