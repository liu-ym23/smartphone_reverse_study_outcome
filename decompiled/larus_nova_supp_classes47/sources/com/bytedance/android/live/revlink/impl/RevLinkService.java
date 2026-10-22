package com.bytedance.android.live.revlink.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.audience.LinkCheckLoadUtils;
import com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget;
import com.bytedance.android.live.revlink.impl.control.u;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.MultiAnchorFeedView;
import com.bytedance.android.live.revlink.impl.multianchor.pk.team.TeamStatus;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataWidget;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.widget.MultiLinkAnchorControlService;
import com.bytedance.android.live.revlink.impl.multianchor.widget.RevLinkAnchorWidget;
import com.bytedance.android.live.revlink.impl.multianchor.widget.RevLinkAudienceWidget;
import com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.WindowClickImpl;
import com.bytedance.android.live.revlink.impl.perf.LinkPerfManager;
import com.bytedance.android.live.revlink.impl.pk.feedview.RevPkFullFeedView;
import com.bytedance.android.live.revlink.impl.service.f;
import com.bytedance.android.live.revlink.impl.service.g;
import com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceFacade;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdk.link.model.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import e33.l;
import fr2.g0;
import fr2.j1;
import fr2.p;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kc0.q;
import kc0.r;
import kc0.s;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J3\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J \u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J,\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0016J\u0012\u0010/\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020\u00132\u0006\u00102\u001a\u00020$H\u0016J\u0010\u00104\u001a\u00020\f2\u0006\u00102\u001a\u00020$H\u0016J\u0010\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0013H\u0016J\b\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u00109\u001a\u000208H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0013H\u0016J\u0010\u0010=\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0013H\u0016J\u0010\u0010?\u001a\u00020\f2\u0006\u0010>\u001a\u00020$H\u0016J\u0010\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u0013H\u0016J\u0010\u0010C\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u0013H\u0016J\u0010\u0010E\u001a\u00020\f2\u0006\u0010D\u001a\u00020\u0013H\u0016J\u0010\u0010G\u001a\u00020\f2\u0006\u0010F\u001a\u00020$H\u0016J\b\u0010H\u001a\u00020\fH\u0016J\n\u0010J\u001a\u0004\u0018\u00010IH\u0016J \u0010O\u001a\u00020\f2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020L0Kj\b\u0012\u0004\u0012\u00020L`MH\u0016J \u0010P\u001a\u00020\f2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020L0Kj\b\u0012\u0004\u0012\u00020L`MH\u0016J\n\u0010R\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010S\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0013H\u0016J\b\u0010T\u001a\u00020\fH\u0016J\u0010\u0010U\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0013H\u0016J\u0010\u0010V\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0013H\u0016J\u0010\u0010W\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0013H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\u0012\u0010Z\u001a\u00020\f2\b\u0010Y\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010_\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020$2\u0006\u0010]\u001a\u00020$2\u0006\u0010^\u001a\u000208H\u0016J\u001a\u0010a\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010`\u001a\u000208H\u0016J\u0010\u0010c\u001a\u00020\f2\u0006\u0010b\u001a\u000208H\u0016J\u0010\u0010d\u001a\u00020\f2\u0006\u0010b\u001a\u000208H\u0016J\u0010\u0010f\u001a\u00020\f2\u0006\u0010e\u001a\u000208H\u0016J\u0010\u0010h\u001a\u00020\f2\u0006\u0010g\u001a\u00020\u0013H\u0016J\u0018\u0010j\u001a\u00020\f2\u0006\u0010F\u001a\u00020$2\u0006\u0010i\u001a\u00020$H\u0016J\u0010\u0010l\u001a\u00020\f2\u0006\u0010k\u001a\u00020$H\u0016J\u0012\u0010m\u001a\u00020\f2\b\u0010Y\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010q\u001a\u00020\f2\n\u0010p\u001a\u00060nj\u0002`oH\u0016J\u001a\u0010s\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010r\u001a\u00020$H\u0016J\"\u0010u\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010i\u001a\u00020$2\u0006\u0010t\u001a\u00020$H\u0016J\u001a\u0010w\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010v\u001a\u00020$H\u0016J\u001a\u0010y\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010x\u001a\u00020$H\u0016J\u0012\u0010|\u001a\u0004\u0018\u00010\b2\u0006\u0010{\u001a\u00020zH\u0016J\u0012\u0010}\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010~\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010;\u001a\u00020\u0013H\u0016J\u0013\u0010\u0080\u0001\u001a\u00020\f2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\f2\u0007\u0010\u0081\u0001\u001a\u00020$H\u0016J\t\u0010\u0083\u0001\u001a\u00020\fH\u0016R \u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R \u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R \u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R \u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R \u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R \u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001R \u0010£\u0001\u001a\u00030¢\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001a\u0010ª\u0001\u001a\u0005\u0018\u00010§\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010®\u0001\u001a\u0005\u0018\u00010«\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R$\u0010²\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040¯\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b°\u0001\u0010±\u0001R\u0017\u0010µ\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010´\u0001R!\u0010º\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030·\u00010¶\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010¹\u0001R\u001f\u0010¿\u0001\u001a\n\u0012\u0005\u0012\u00030¼\u00010»\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b½\u0001\u0010¾\u0001R\u0017\u0010Á\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÀ\u0001\u0010´\u0001R!\u0010Ã\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030·\u00010¶\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010¹\u0001R\u001a\u0010Ç\u0001\u001a\u0005\u0018\u00010Ä\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u001a\u0010Ë\u0001\u001a\u0005\u0018\u00010È\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0019\u0010Í\u0001\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÌ\u0001\u0010´\u0001R\u0017\u0010Ð\u0001\u001a\u00020$8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0017\u0010Ó\u0001\u001a\u0002088VX\u0096\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0017\u0010Õ\u0001\u001a\u00020$8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÔ\u0001\u0010Ï\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/RevLinkService;", "Lcom/bytedance/android/live/revlink/api/ILinkService;", "Ldy0/c;", "Lcom/bytedance/android/scope/o;", "", "uid", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/team/TeamStatus;", "getTeamStatus", "Lcy0/a;", "livePlayScope", "Lcy0/c;", "getAudienceRevenueDataScope", "", "onStart", "onStop", "Lkc0/r$a;", "callback", "Landroid/view/ViewGroup;", "parentView", "", "continueRoomLinkMic", "loadInP0", "Lkc0/r;", "createRevMultiControlWidget", "(Lkc0/r$a;Landroid/view/ViewGroup;Ljava/lang/Boolean;Z)Lkc0/r;", "Lpc0/e;", "createRevRtcData", "", "videoCaptureFps", "streamFps", "previewFps", "updatePushStreamInfo", "Landroid/content/Context;", "context", "Lpc0/a;", "seiAppData", "", "showFrom", "Lkc0/d;", "feedRevenueContext", "Lqc0/f;", "getInteractFeedView", "Lorg/json/JSONObject;", "featureObj", "setFeatureParams", "Lcom/bytedance/android/livesdk/link/model/bridge/f0;", "chorusMessage", "receiveChorusMessage", "state", "onMultiAnchorStateChange", "id", "isSpatialAudioEnable", "notifyCleanModeChanged", "isCleanMode", "notifyIsCleanModeChanged", "notifyUserClose", "", Constants.OperatorKey.KEY_COST_TIME, "setEnterRoomTime", "flag", "setSkipRoomStatsSync", "updateStableMode", "status", "updateMicRoomAnchorStatus", "isHideInteractLayout", "updateInteractLayoutShow", "shown", "updateKeyboardStatus", "join", "notifyAudienceSelfJoin", "width", "notifyPkRenderWidth", "notifyAudienceEngineEvent", "Lgt1/b;", "getMultiAnchorStatus", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lgt1/d;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "observer", "registerPkStateChangeObserver", "unRegisterPkStateChangeObserver", "Lfr2/p;", "getLiveCore", "notifyPkAnchorSilenceStatus", "notifyPkAudienceUnload", "onAudienceJoinSelfLink", "onAudienceJoinGuestLink", "updateEnterRoomViewMock", "notifyAudienceSelfLeave", "sei", "updateFirstFrameSei", "currentInnerFeedLength", "feedRoomRevLinkScene", "feedRoomRevLinkPkState", "feedRoomBuildTs", "updateFeedParams", "playFragmentStartTs", "updateEnterParams", "timeMills", "updateLoad0Ts", "updateLoad1Ts", "total", "updateAudienceMemberCount", "isPortrait", "updatePortrait", "height", "notifyRenderSizeChanged", "action", "notifyPauseStatus", "notifyRtcData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveModeKt;", "liveMode", "updateLiveMode", "marginTop", "updateInteractMarginTop", "y", "updateVideoHeight", "pkMovedMarginTop", "updatePkMovedMarginTop", "leftMargin", "updatePkLeftMargin", "Lld/f;", "dataCenter", "enterLivePlay", "leaveLivePlay", "markAddPkBackground", "param", "updateInteractAnchorParam", Constants.OperatorKey.CODE, "notifyStopLive", "notifyStartAudioDiagnosis", "Lcom/bytedance/android/live/revlink/impl/service/f;", "pkService", "Lcom/bytedance/android/live/revlink/impl/service/f;", "getPkService", "()Lcom/bytedance/android/live/revlink/impl/service/f;", "Lcom/bytedance/android/live/revlink/impl/service/e;", "multiAnchorService", "Lcom/bytedance/android/live/revlink/impl/service/e;", "getMultiAnchorService", "()Lcom/bytedance/android/live/revlink/impl/service/e;", "Lcom/bytedance/android/live/revlink/impl/e;", "revenueLinkDataHolder", "Lcom/bytedance/android/live/revlink/impl/e;", "getRevenueLinkDataHolder", "()Lcom/bytedance/android/live/revlink/impl/e;", "Lcom/bytedance/android/live/revlink/impl/service/g;", "revLinkControlService", "Lcom/bytedance/android/live/revlink/impl/service/g;", "getRevLinkControlService", "()Lcom/bytedance/android/live/revlink/impl/service/g;", "Lcom/bytedance/android/live/revlink/impl/d;", "revLinkAudioDetectExternal", "Lcom/bytedance/android/live/revlink/impl/d;", "getRevLinkAudioDetectExternal", "()Lcom/bytedance/android/live/revlink/impl/d;", "Lcom/bytedance/android/live/revlink/impl/perf/LinkPerfManager;", "perfManager", "Lcom/bytedance/android/live/revlink/impl/perf/LinkPerfManager;", "getPerfManager", "()Lcom/bytedance/android/live/revlink/impl/perf/LinkPerfManager;", "Lu31/a;", "panelServiceExternal", "Lu31/a;", "getPanelServiceExternal", "()Lu31/a;", "Lp11/i;", "getLinkRegionService", "()Lp11/i;", "linkRegionService", "Lkc0/i;", "getLinkRegionServiceExternal", "()Lkc0/i;", "linkRegionServiceExternal", "", "getUidToStreamRegionKeyMap", "()Ljava/util/Map;", "uidToStreamRegionKeyMap", "getLinkAnchorCount", "()Ljava/lang/String;", "linkAnchorCount", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getProfitInteractionWidgetClass", "()Ljava/lang/Class;", "profitInteractionWidgetClass", "", "Lcom/bytedance/android/livesdkapi/service/RevImCacheUnit;", "getInteractFeedViewImCaches", "()Ljava/util/List;", "interactFeedViewImCaches", "getInviteModeStatus", "inviteModeStatus", "getAnchorTicketWidgetClass", "anchorTicketWidgetClass", "Lcom/bytedance/android/live/revenuelink/connect/f;", "getConnectService", "()Lcom/bytedance/android/live/revenuelink/connect/f;", "connectService", "Lcom/bytedance/android/live/revenuelink/rtc/f;", "getRtcService", "()Lcom/bytedance/android/live/revenuelink/rtc/f;", "rtcService", "getConnectionType", "connectionType", "getEnterRoomLinkmicScene", "()I", "enterRoomLinkmicScene", "getRevLinkControlLoadTs", "()J", "revLinkControlLoadTs", "getCurrentAudienceCount", "currentAudienceCount", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class RevLinkService implements ILinkService, dy0.c, o {
    private final com.bytedance.android.live.revlink.impl.service.e multiAnchorService;
    private final u31.a panelServiceExternal;
    private final LinkPerfManager perfManager;
    private final f pkService;
    private final d revLinkAudioDetectExternal;
    private final g revLinkControlService;
    private final e revenueLinkDataHolder;

    public static final class a implements r {
        public final /* synthetic */ LinkRevControlWidget a;

        public final LinkRevControlWidget getWidget() {
            return this.a;
        }

        public a(LinkRevControlWidget r1) {
            this.a = r1;
        }

        public final void b0(String r3) {
            LinkRevControlWidget r0 = this.a;
            RevLinkAudienceWidget r1 = r0.g;
            if (r1 == null) goto L12;
            RevLinkAudienceFacade r2 = r1.a;
            if (r2 == null) goto L12;
            h r4 = r2.a;
            if (r4 == null) goto L12;
            NextLiveData<String> r5 = r4.c;
            if (r5 == null) goto L12;
            r5.setValue(r3);
        L12:
            if (v.a(r0.j, 4) == false) goto L19;
            if (com.bytedance.android.live.revlink.impl.settings.live.c.D.a() == false) goto L19;
            RevLinkAudienceWidget r6 = r0.g;
            if (r6 == null) goto L19;
            r6.wq();
        L19:
            if (v.a(r0.j, 64) == true) goto L21;
            return;
        L21:
            if (com.bytedance.android.live.revlink.impl.settings.live.c.D.a() == false) goto L27;
            RevLinkAudienceWidget r7 = r0.g;
            if (r7 == null) goto L28;
            r7.wq();
            return;
        L28:
            return;
        }

        public final void onSei(String r2) {
            Intrinsics.checkNotNullParameter(r2, "sei");
            this.a.onSei(r2);
        }

        public final void p3(IRoom r12) {
            Intrinsics.checkNotNullParameter(r12, "room");
            LinkRevControlWidget r1 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r12, "room");
            r1.B = r12;
            com.bytedance.android.live.revlink.impl.control.e r2 = r1.k;
            if (r2 == null) goto L13;
            Intrinsics.checkNotNullParameter(r12, "room");
            if (r2.f == true) goto L13;
            ld.a r0 = r2.h;
            if (r0 == null) goto L13;
            NextLiveData r3 = r0.Sh();
            if (r3 == null) goto L13;
            r3.setValue(r12);
        L13:
            if (r1.E == false) goto L15;
            return;
        L15:
            if (r1.N == false) goto L65;
            u41.b r4 = u41.b.i;
            r4.getClass();
            boolean r5 = false;
            int r6 = ((Number) u41.b.b.getValue(r4, u41.b.a[0])).intValue();
            if (r6 != 1) goto L20;
        L22:
            LinkCheckLoadUtils r7 = r1.m;
            if (r7 == null) goto L25;
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            r7.o = r12;
        L25:
            IRoom r8 = r1.B;
            if (r8 != null) goto L29;
        L53:
            if (r5 == false) goto L55;
            return;
        L55:
            if (v.a(r1.j, 4) == false) goto L58;
            com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r1, 4, true, 4);
            return;
        L58:
            if (v.a(r1.j, 64) == false) goto L64;
            com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r1, 64, true, 4);
            return;
        L64:
            return;
        L29:
            if (v.a(r1.j, 4) == false) goto L42;
            u r9 = com.bytedance.android.live.revlink.impl.control.v.b(r8);
            if (r9 == null) goto L53;
            u r13 = com.bytedance.android.live.revlink.impl.control.v.b(r12);
            if (r13 == null) goto L53;
            if (r9.b != r13.b) goto L53;
            if ((!Intrinsics.areEqual(r9.a, r13.a)) == true) goto L53;
        L52:
            r5 = true;
            goto L53
        L42:
            if (v.a(r1.j, 64) == false) goto L53;
            com.bytedance.android.live.revlink.impl.control.r r10 = com.bytedance.android.live.revlink.impl.control.v.a(r8);
            if (r10 == null) goto L53;
            com.bytedance.android.live.revlink.impl.control.r r14 = com.bytedance.android.live.revlink.impl.control.v.a(r12);
            if (r14 == null) goto L53;
            if (r10.a == r14.a) goto L52;
        L20:
            if (r6 == 2) goto L22;
            return;
        }

        public final void q3(vc0.a r5) {
            Intrinsics.checkNotNullParameter(r5, "liveCoreVariable");
            LinkRevControlWidget r1 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "liveCoreVariable");
            MultiLinkAnchorControlService r2 = r1.d;
            if (r2 == null) goto L22;
            Intrinsics.checkNotNullParameter(r5, "liveCoreVariable");
            AnchorRtcConnectManager r3 = r2.f;
            if (r3 == null) goto L23;
            Intrinsics.checkNotNullParameter(r5, "liveCoreVariable");
            if (r3.i != null) goto L24;
            Object r0 = r5.b;
            fr2.v r4 = null;
            if ((r0 instanceof xh6.c) == true) goto L12;
            fr2.v r6 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.v.class), r5.a);
            if ((r6 instanceof fr2.v) == false) goto L19;
            r4 = r6;
        L19:
            fr2.v r7 = r4;
        L20:
            r3.i = r7;
            return;
        L12:
            if ((r0 instanceof fr2.v) == true) goto L14;
            r0 = null;
        L14:
            r7 = (fr2.v) r0;
            goto L20
        L24:
            return;
        L23:
            return;
        }

        public final void a(View r6, MotionEvent r7) {
            RevLinkAnchorWidget r0 = this.a.f;
            if (r0 == null) goto L29;
            com.bytedance.android.live.revlink.impl.multianchor.widget.g r1 = r0.c;
            if (r1 == null) goto L30;
            Iterator<T> r2 = r1.d.iterator();
        L8:
            if (r2.hasNext() == false) goto L12;
            Object r3 = r2.next();
            if (Intrinsics.areEqual(((WindowClickImpl) r3).b, r1.j) == false) goto L8;
        L13:
            WindowClickImpl r4 = (WindowClickImpl) r3;
            if (r4 == null) goto L31;
            if (r6 == null) goto L33;
            if (r7 == null) goto L34;
            View r8 = r4.a;
            if (r8 == null) goto L35;
            r8.getGlobalVisibleRect((Rect) r4.c.getValue());
            if (((Rect) r4.c.getValue()).contains((int) r7.getRawX(), (int) r7.getRawY()) == false) goto L32;
            ((GestureDetector) r4.d.getValue()).onTouchEvent(r7);
            return;
        L32:
            return;
        L35:
            return;
        L34:
            return;
        L33:
            return;
        L31:
            return;
        L12:
            r3 = null;
            goto L13
        L30:
            return;
        }
    }

    public static final class b implements com.bytedance.android.live.revlink.impl.b {
        public final /* synthetic */ r.a a;

        @Override // com.bytedance.android.live.revlink.impl.b
        public final fr2.v getLiveVideoClientFactory() {
            vc0.a r0 = this.a.getLiveVideoClientFactory();
            Object r1 = null;
            if (r0 == null) goto L17;
            Object r2 = r0.b;
            if ((r2 instanceof xh6.c) == true) goto L7;
            xh6.c r3 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.v.class), r0.a);
            if ((r3 instanceof fr2.v) == false) goto L16;
            r1 = r3;
        L16:
            return (fr2.v) r1;
        L7:
            if ((r2 instanceof fr2.v) == false) goto L18;
            r1 = r2;
        L18:
            return (fr2.v) r1;
        L17:
            return null;
        }

        public b(r.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.b
        public final void a(LiveWidget r2) {
            this.a.a(r2);
        }

        @Override // com.bytedance.android.live.revlink.impl.b
        public final void b(LiveWidget r2) {
            this.a.b(r2);
        }
    }

    public void onStart() {
    }

    public void onStop() {
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public String getConnectionType() {
        y11.e r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).Ym();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConnectionType();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public List<RevImCacheUnit> getInteractFeedViewImCaches() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        r1.add(new v21.a());
        r0.addAll(r1);
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public String getLinkAnchorCount() {
        y11.e r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).Ym();
        if (r0 == null) goto L6;
        String r1 = r0.getLinkAnchorCount();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public p getLiveCore() {
        com.bytedance.android.livesdk.revenue.room.a r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).x2();
        if (r0 == null) goto L10;
        j r1 = r0.getLiveStream();
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.revenue.pushstream.a r2 = (com.bytedance.android.livesdk.revenue.pushstream.a) r1.getValue();
        if (r2 == null) goto L10;
        j1 r3 = r2.j();
        if (r3 == null) goto L10;
        return r3;
    L10:
        com.bytedance.android.live.revenuelink.rtc.f r4 = com.bytedance.android.live.revlink.impl.global.b.d();
        Object r5 = null;
        if (r4 == null) goto L29;
        i r6 = r4.getRtcManager();
        if (r6 == null) goto L29;
        vc0.a r7 = r6.getLiveCore();
        if (r7 == null) goto L29;
        Object r8 = r7.b;
        if ((r8 instanceof xh6.c) == true) goto L19;
        xh6.c r9 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(p.class), r7.a);
        if ((r9 instanceof p) == false) goto L27;
        r5 = r9;
    L27:
        r5 = (p) r5;
        goto L29
    L19:
        if ((r8 instanceof p) == false) goto L22;
        r5 = r8;
    L22:
        r5 = (p) r5;
    L29:
        return r5;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyPkAudienceUnload() {
        gt1.d r0 = new gt1.d(1);
        ld.a r1 = ld.d.a();
        if (r1 == null) goto L7;
        NextLiveData r2 = r1.Pc();
        if (r2 == null) goto L7;
        r2.setValue(Unit.INSTANCE);
    L7:
        ld.a r3 = ld.d.a();
        if (r3 == null) goto L12;
        NextLiveData r4 = r3.Y1();
        if (r4 == null) goto L12;
        r4.setValue(r0);
    L12:
        wq2.f r5 = ma1.a.a();
        if (r5 == null) goto L16;
        r5.S1(r0);
        return;
    }

    public RevLinkService() {
        this.pkService = new f();
        this.multiAnchorService = new com.bytedance.android.live.revlink.impl.service.e();
        this.revenueLinkDataHolder = new e();
        this.revLinkControlService = new g();
        this.revLinkAudioDetectExternal = new d();
        this.perfManager = new LinkPerfManager();
        this.panelServiceExternal = new u31.a();
        l[] r0 = f03.a.a;
        m r1 = m.e;
        f03.a r2 = f03.a.b;
        r1.getClass();
        m.e(r2);
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public pc0.e createRevRtcData() {
        com.bytedance.android.live.revenuelink.rtc.f r0 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r0 == null) goto L9;
        i r1 = r0.getRtcManager();
        if (r1 == null) goto L11;
        pc0.e r2 = r1.createRtcData();
        if (r2 == null) goto L12;
        return r2;
    L12:
        return null;
    L11:
        return null;
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public com.bytedance.android.live.revenuelink.connect.f getConnectService() {
        return com.bytedance.android.live.revlink.impl.global.b.a();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public int getCurrentAudienceCount() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L9;
        NextLiveData r1 = r0.d0();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public int getEnterRoomLinkmicScene() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L9;
        NextLiveData r1 = r0.getEnterRoomLinkmicScene();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public String getInviteModeStatus() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentMode();
    L7:
        if (v.a(r1, 64) == false) goto L19;
        getMultiAnchorService().getClass();
        b0 r2 = com.bytedance.android.live.revlink.impl.global.b.L();
        if (r2 == null) goto L11;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r3 = r2.a();
    L12:
        if (r3 == null) goto L27;
        String r4 = r3.getInviteModeStatus();
        if (r4 != null) goto L17;
        return "";
    L17:
        return r4;
    L27:
        return "";
    L11:
        r3 = null;
        goto L12
    L19:
        if (v.a(r1, 4) == false) goto L29;
        getPkService().getClass();
        y11.c r5 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).V0();
        if (r5 == null) goto L30;
        String r6 = r5.getInviteModeStatus();
        if (r6 != null) goto L26;
        return "";
    L26:
        return r6;
    L30:
        return "";
    L29:
        return "";
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public p11.i getLinkRegionService() {
        return com.bytedance.android.live.revlink.impl.global.b.f0();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public kc0.i getLinkRegionServiceExternal() {
        return com.bytedance.android.live.revlink.impl.global.b.f0();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public /* bridge */ /* synthetic */ kc0.m getMultiAnchorService() {
        return getMultiAnchorService();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public gt1.b getMultiAnchorStatus() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.ho();
        if (r1 == null) goto L7;
        return (gt1.b) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public /* bridge */ /* synthetic */ kc0.g getPanelServiceExternal() {
        return getPanelServiceExternal();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public /* bridge */ /* synthetic */ kc0.h getPerfManager() {
        return getPerfManager();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public /* bridge */ /* synthetic */ q getPkService() {
        return getPkService();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public /* bridge */ /* synthetic */ s getRevLinkAudioDetectExternal() {
        return getRevLinkAudioDetectExternal();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public long getRevLinkControlLoadTs() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L9;
        NextLiveData r1 = r0.getRevLinkControlLoadTs();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public /* bridge */ /* synthetic */ kc0.e getRevLinkControlService() {
        return getRevLinkControlService();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public /* bridge */ /* synthetic */ kc0.o getRevenueLinkDataHolder() {
        return getRevenueLinkDataHolder();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public com.bytedance.android.live.revenuelink.rtc.f getRtcService() {
        return com.bytedance.android.live.revlink.impl.global.b.d();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public Map<String, String> getUidToStreamRegionKeyMap() {
        p11.i r0 = getLinkRegionService();
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.getUidToStreamRegionKeyMap();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyAudienceEngineEvent() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.c7();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyAudienceSelfLeave() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.y5();
        if (r1 == null) goto L9;
        r1.setValue(Unit.INSTANCE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyStartAudioDiagnosis() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.tb();
        if (r1 == null) goto L9;
        r1.setValue(Unit.INSTANCE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyUserClose() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.F1();
        if (r1 == null) goto L9;
        r1.setValue(Unit.INSTANCE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public Class<? extends Widget> getAnchorTicketWidgetClass() {
        return GiftAnchorTicketWidget.class;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public Class<? extends Widget> getProfitInteractionWidgetClass() {
        return ProfitInteractionDataWidget.class;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    /* JADX INFO: renamed from: getMultiAnchorService */
    public /* bridge */ /* synthetic */ p11.e mo468getMultiAnchorService() {
        return getMultiAnchorService();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public u31.a getPanelServiceExternal() {
        return this.panelServiceExternal;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    /* JADX INFO: renamed from: getPerfManager */
    public /* bridge */ /* synthetic */ p11.d mo469getPerfManager() {
        return getPerfManager();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    /* JADX INFO: renamed from: getPkService */
    public /* bridge */ /* synthetic */ p11.h mo470getPkService() {
        return getPkService();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public d getRevLinkAudioDetectExternal() {
        return this.revLinkAudioDetectExternal;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public g getRevLinkControlService() {
        return this.revLinkControlService;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    /* JADX INFO: renamed from: getRevenueLinkDataHolder */
    public /* bridge */ /* synthetic */ p11.j mo471getRevenueLinkDataHolder() {
        return getRevenueLinkDataHolder();
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public com.bytedance.android.live.revlink.impl.service.e getMultiAnchorService() {
        return this.multiAnchorService;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public LinkPerfManager getPerfManager() {
        return this.perfManager;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public f getPkService() {
        return this.pkService;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public e getRevenueLinkDataHolder() {
        return this.revenueLinkDataHolder;
    }

    private final cy0.c getAudienceRevenueDataScope(cy0.a r3) {
        if (r3 == null) goto L6;
        xq2.a r4 = (xq2.a) m.e.d(r3, xq2.a.class);
        if (r4 == null) goto L6;
        return r4.c0();
    L6:
        return null;
    }

    private final TeamStatus getTeamStatus(String r8) {
        k r0 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r0 == null) goto L34;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L34;
        IBaseUser r2 = r1.getOwner();
        if (r2 == null) goto L34;
        String r3 = r2.getIdString();
        if (r3 == null) goto L34;
        if (r8 != null) goto L13;
        return null;
    L13:
        b0 r4 = com.bytedance.android.live.revlink.impl.global.b.L();
        if (r4 == null) goto L16;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r5 = r4.a();
    L17:
        if (r5 == null) goto L34;
        Map<String, Long> r6 = r5.getUserIdToTeamId();
        if (r6 == null) goto L34;
        Long r7 = r6.get(r3);
        Long r9 = r6.get(r8);
        if (r7 == null) goto L34;
        if (r7.longValue() == 0) goto L34;
        if (r9 == null) goto L34;
        if (r9.longValue() == 0) goto L34;
        if (Intrinsics.areEqual(r9, r7) == false) goto L33;
        return TeamStatus.LEFT;
    L33:
        return TeamStatus.RIGHT;
    L16:
        r5 = null;
    L34:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public cy0.a enterLivePlay(ld.f r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        m.e.getClass();
        cy0.h r0 = new cy0.h(m.d);
        Intrinsics.checkNotNullParameter(r0, "scope");
        cy0.b r1 = new cy0.b();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.a = r4;
        Unit r5 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "value");
        r0.e = r1;
        if (r1 != e33.k.a) goto L5;
        String r6 = "livePlayScopeInstance";
    L6:
        if (r6 != null) goto L10;
        com.bytedance.android.scope.l.a(r0);
        return r0;
    L10:
        throw new UninitializedPropertyAccessException(r6);
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public boolean isSpatialAudioEnable(int r1) {
        com.bytedance.android.live.revlink.impl.global.c r2 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r2 == null) goto L7;
        r2.A7();
        return false;
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void leaveLivePlay(cy0.a r1) {
        if (r1 == null) goto L5;
        com.bytedance.android.scope.l.c(r1);
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyAudienceSelfJoin(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.cn();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyCleanModeChanged(int r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.getCleanMode();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyIsCleanModeChanged(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.isCleanMode();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyPauseStatus(int r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Dc();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyPkAnchorSilenceStatus(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Jb();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyPkRenderWidth(int r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.B3();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyRtcData(String r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.e();
        if (r1 == null) goto L9;
        r1.setValue(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyStopLive(int r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.wh();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void onAudienceJoinGuestLink(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.z9();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void onAudienceJoinSelfLink(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Fc();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void onMultiAnchorStateChange(int r2) {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L6;
        r0.onMultiAnchorStateChange(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void receiveChorusMessage(f0 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L7;
        int r1 = r0.getCurrentMode();
    L9:
        if (v.a(r1, 4) == false) goto L14;
        com.bytedance.android.live.revlink.impl.pk.service.h r2 = com.bytedance.android.live.revlink.impl.global.b.U();
        if (r2 == null) goto L14;
        r2.receiveChorusMessage(r3);
    L14:
        if (v.a(r1, 64) == false) goto L18;
        com.bytedance.android.live.revlink.impl.multianchor.service.b r4 = com.bytedance.android.live.revlink.impl.global.b.w();
        if (r4 == null) goto L18;
        r4.receiveChorusMessage(r3);
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r5 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r5 == null) goto L22;
        r5.Ul(r3.getMsgType());
        return;
    L22:
        return;
    L7:
        r1 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void registerPkStateChangeObserver(Observer<gt1.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Y1();
        if (r1 == null) goto L9;
        r1.observeForever(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void setEnterRoomTime(long r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.getEnterRoomTime();
        if (r1 == null) goto L9;
        r1.setValue(Long.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void setFeatureParams(JSONObject r19) {
        Intrinsics.checkNotNullParameter(r19, "featureObj");
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = com.bytedance.android.live.revlink.impl.global.b.n();     // Catch: Exception -> L203
        if (r2 == null) goto L6;
        int r3 = r2.getCurrentMode();     // Catch: Exception -> L203
    L7:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4 = com.bytedance.android.live.revlink.impl.global.b.R();     // Catch: Exception -> L203
        com.bytedance.android.live.revlink.impl.pk.utils.q r5 = com.bytedance.android.live.revlink.impl.global.b.W();     // Catch: Exception -> L203
        if (r5 == null) goto L10;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r6 = r5.g();     // Catch: Exception -> L203
    L11:
        com.bytedance.android.live.revlink.impl.global.c r7 = com.bytedance.android.live.revlink.impl.global.b.k();     // Catch: Exception -> L203
        if (r7 == null) goto L14;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r8 = r7.Q1();     // Catch: Exception -> L203
    L17:
        if (v.a(r3, 64) == false) goto L118;
        if (r4 == null) goto L118;
        PkBaseStateMachine.c r9 = r4.getCurPKBaseState();     // Catch: Exception -> L203
        if (r9 == null) goto L118;
        if ((r9 instanceof PkBaseStateMachine.c.C0130c) != true) goto L118;
        d60.b.a(r19, "link_ver", 2);     // Catch: Exception -> L203
        d60.b.a(r19, "is_in_pk", 1);     // Catch: Exception -> L203
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L203
        LiveData<Long> r12 = r4.getBaseTimeLeft();     // Catch: Exception -> L203
        if (r12 == null) goto L27;
        long r13 = (Long) r12.getValue();     // Catch: Exception -> L203
        if (r13 == null) goto L27;
    L28:
        d60.b.a(r10, "left_time", r13);     // Catch: Exception -> L203
        if (r8 == null) goto L110;
        LiveData<List<af2.b>> r14 = r8.getScoreState();     // Catch: Exception -> L203
        if (r14 == null) goto L110;
        List r15 = (List) r14.getValue();     // Catch: Exception -> L203
        if (r15 == null) goto L110;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r16 = com.bytedance.android.live.revlink.impl.global.b.R();     // Catch: Exception -> L203
        ArrayList r17 = new ArrayList();     // Catch: Exception -> L203
        if (r16 == null) goto L39;
        LiveData<PlayMode> r18 = r16.getTeamMode();     // Catch: Exception -> L203
        if (r18 == null) goto L39;
        PlayMode r20 = (PlayMode) r18.getValue();     // Catch: Exception -> L203
    L41:
        if (r20 != PlayMode.TEAM_PK) goto L68;
        Iterator r22 = r15.iterator();     // Catch: Exception -> L203
    L44:
        if (r22.hasNext() == false) goto L51;
        Object r23 = r22.next();     // Catch: Exception -> L203
        if (getTeamStatus(af2.c.a((af2.b) r23)) != TeamStatus.LEFT) goto L48;
        boolean r24 = true;
    L49:
        if (r24 == false) goto L44;
    L52:
        af2.b r25 = (af2.b) r23;     // Catch: Exception -> L203
        if (r25 == null) goto L55;
        r19.put("host_score", (int) af2.c.b(r25));     // Catch: Exception -> L203
    L55:
        Iterator r26 = r15.iterator();     // Catch: Exception -> L203
    L57:
        if (r26.hasNext() == false) goto L64;
        Object r27 = r26.next();     // Catch: Exception -> L203
        if (getTeamStatus(af2.c.a((af2.b) r27)) != TeamStatus.RIGHT) goto L61;
        boolean r28 = true;
    L62:
        if (r28 == false) goto L57;
        Object r110 = r27;
    L65:
        af2.b r111 = (af2.b) r110;     // Catch: Exception -> L203
        if (r111 == null) goto L102;
        r17.add(Integer.valueOf((int) r111.getMultiPkTeamScore()));     // Catch: Exception -> L203
    L102:
        if (r19.isNull("host_score") == false) goto L104;
        int r29 = 0;
        r19.put("host_score", 0);     // Catch: Exception -> L203
    L106:
        if (r17.isEmpty() == false) goto L108;
        r17.add(Integer.valueOf(r29));     // Catch: Exception -> L203
    L108:
        d60.b.a(r19, "guest_score", r17);     // Catch: Exception -> L203
        goto L110
    L104:
        r29 = 0;
        goto L106
    L61:
        r28 = false;
        goto L62
    L64:
        r110 = null;
        goto L65
    L48:
        r24 = false;
        goto L49
    L51:
        r23 = null;
        goto L52
    L68:
        Iterator r30 = r15.iterator();     // Catch: Exception -> L203
    L70:
        if (r30.hasNext() == false) goto L83;
        Object r32 = r30.next();     // Catch: Exception -> L203
        String r33 = String.valueOf(af2.c.a((af2.b) r32));     // Catch: Exception -> L203
        k r34 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);     // Catch: Exception -> L203
        if (r34 == null) goto L78;
        IRoom r35 = r34.getRoom();     // Catch: Exception -> L203
        if (r35 == null) goto L78;
        IBaseUser r36 = r35.getOwner();     // Catch: Exception -> L203
        if (r36 == null) goto L78;
        String r37 = r36.getIdString();     // Catch: Exception -> L203
    L80:
        if (Intrinsics.areEqual(r33, r37) == false) goto L70;
    L84:
        af2.b r38 = (af2.b) r32;     // Catch: Exception -> L203
        if (r38 == null) goto L87;
        r19.put("host_score", (int) af2.c.b(r38));     // Catch: Exception -> L203
    L87:
        Iterator r39 = r15.iterator();     // Catch: Exception -> L203
    L89:
        if (r39.hasNext() == false) goto L102;
        af2.b r40 = (af2.b) r39.next();     // Catch: Exception -> L203
        String r42 = String.valueOf(af2.c.a(r40));     // Catch: Exception -> L203
        k r43 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);     // Catch: Exception -> L203
        if (r43 == null) goto L97;
        IRoom r44 = r43.getRoom();     // Catch: Exception -> L203
        if (r44 == null) goto L97;
        IBaseUser r45 = r44.getOwner();     // Catch: Exception -> L203
        if (r45 == null) goto L97;
        String r46 = r45.getIdString();     // Catch: Exception -> L203
    L99:
        if ((!Intrinsics.areEqual(r42, r46)) == false) goto L89;
        r17.add(Integer.valueOf((int) af2.c.b(r40)));     // Catch: Exception -> L203
    L97:
        r46 = null;
    L78:
        r37 = null;
        goto L80
    L83:
        r32 = null;
    L39:
        r20 = null;
    L110:
        if (r4.isInVote() != true) goto L113;
        int r47 = 3;
    L116:
        d60.b.a(r10, "mode", Integer.valueOf(r47));     // Catch: Exception -> L203
        r19.put("link_data", r10);     // Catch: Exception -> L203
        return;
    L113:
        if (r4.isCustomizePkPlay() != true) goto L115;
        r47 = 2;
        goto L116
    L115:
        r47 = 0;
    L27:
        r13 = 0L;     // Catch: Exception -> L203
    L118:
        if (v.a(r3, 4) == false) goto L201;
        if (r4 == null) goto L201;
        PkBaseStateMachine.c r48 = r4.getCurPKBaseState();     // Catch: Exception -> L203
        if (r48 == null) goto L201;
        if ((r48 instanceof PkBaseStateMachine.c.C0130c) != true) goto L201;
        d60.b.a(r19, "is_in_pk", 1);     // Catch: Exception -> L203
        d60.b.a(r19, "link_ver", 1);     // Catch: Exception -> L203
        JSONObject r49 = new JSONObject();     // Catch: Exception -> L203
        LiveData<Long> r50 = r4.getBaseTimeLeft();     // Catch: Exception -> L203
        if (r50 == null) goto L130;
        long r52 = (Long) r50.getValue();     // Catch: Exception -> L203
        if (r52 == null) goto L130;
    L131:
        d60.b.a(r49, "left_time", r52);     // Catch: Exception -> L203
        ArrayList r53 = new ArrayList();     // Catch: Exception -> L203
        List r54 = (List) r4.getBaseScoreState().getValue();     // Catch: Exception -> L203
        if (r54 == null) goto L150;
        Iterator r55 = r54.iterator();     // Catch: Exception -> L203
    L135:
        if (r55.hasNext() == false) goto L150;
        cf2.a r56 = (cf2.a) r55.next();     // Catch: Exception -> L203
        String r112 = String.valueOf(r56.c);     // Catch: Exception -> L203
        k r57 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);     // Catch: Exception -> L203
        if (r57 == null) goto L143;
        IRoom r58 = r57.getRoom();     // Catch: Exception -> L203
        if (r58 == null) goto L143;
        IBaseUser r59 = r58.getOwner();     // Catch: Exception -> L203
        if (r59 == null) goto L143;
        String r60 = r59.getIdString();     // Catch: Exception -> L203
    L145:
        if (Intrinsics.areEqual(r112, r60) == false) goto L147;
        r19.put("host_score", (int) r56.a);     // Catch: Exception -> L203
        goto L135
    L147:
        r53.add(Integer.valueOf((int) r56.a));     // Catch: Exception -> L203
    L143:
        r60 = null;
    L150:
        if (r19.isNull("host_score") == false) goto L152;
        int r62 = 0;
        r19.put("host_score", 0);     // Catch: Exception -> L203
    L154:
        if (r53.isEmpty() == false) goto L156;
        r53.add(Integer.valueOf(r62));     // Catch: Exception -> L203
    L156:
        d60.b.a(r19, "guest_score", r53);     // Catch: Exception -> L203
        Long[] r63 = new Long[2];     // Catch: Exception -> L203
        Map<String, IBattleUserInfo> r64 = r4.getUserInfoMap();     // Catch: Exception -> L203
        if (r64 == null) goto L171;
        k r65 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);     // Catch: Exception -> L203
        if (r65 == null) goto L165;
        IRoom r66 = r65.getRoom();     // Catch: Exception -> L203
        if (r66 == null) goto L165;
        IBaseUser r67 = r66.getOwner();     // Catch: Exception -> L203
        if (r67 == null) goto L165;
        String r68 = iz.a.a(r67);     // Catch: Exception -> L203
    L166:
        IBattleUserInfo r69 = r64.get(r68);     // Catch: Exception -> L203
        if (r69 == null) goto L171;
        x0 r70 = r69.getBattleConsecutiveRecordInfo();     // Catch: Exception -> L203
        if (r70 == null) goto L171;
        long r72 = r70.getConsecutiveCount();     // Catch: Exception -> L203
    L172:
        r63[0] = Long.valueOf(r72);     // Catch: Exception -> L203
        Map<String, IBattleUserInfo> r73 = r4.getUserInfoMap();     // Catch: Exception -> L203
        if (r73 == null) goto L183;
        w31.c r74 = com.bytedance.android.live.revlink.impl.global.b.T();     // Catch: Exception -> L203
        if (r74 == null) goto L177;
        String r75 = r74.c();     // Catch: Exception -> L203
    L178:
        IBattleUserInfo r76 = r73.get(r75);     // Catch: Exception -> L203
        if (r76 == null) goto L183;
        x0 r77 = r76.getBattleConsecutiveRecordInfo();     // Catch: Exception -> L203
        if (r77 == null) goto L183;
        long r78 = r77.getConsecutiveCount();     // Catch: Exception -> L203
    L184:
        r63[1] = Long.valueOf(r78);     // Catch: Exception -> L203
        d60.b.a(r49, "consecutive_count", CollectionsKt.listOf(r63));     // Catch: Exception -> L203
        if (r6 == null) goto L187;
        boolean r79 = r6.isInContributor();     // Catch: Exception -> L203
    L188:
        d60.b.a(r49, "is_in_contributor", Boolean.valueOf(r79));     // Catch: Exception -> L203
        d60.b.a(r49, "is_in_linkmic", Boolean.valueOf(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Sl()));     // Catch: Exception -> L203
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r80 = com.bytedance.android.live.revlink.impl.global.b.m();     // Catch: Exception -> L203
        if (r80 != null) goto L191;
    L193:
        boolean r82 = false;
    L194:
        if (r82 == false) goto L197;
        int r83 = 1;
    L200:
        d60.b.a(r49, "mode", Integer.valueOf(r83));     // Catch: Exception -> L203
        r19.put("link_data", r49);     // Catch: Exception -> L203
        return;
    L197:
        if (r4.isCustomizePkPlay() != true) goto L199;
        r83 = 2;
        goto L200
    L199:
        r83 = 0;
        goto L200
    L191:
        if (r80.i() != true) goto L193;
        r82 = true;
        goto L194
    L187:
        r79 = false;
        goto L188
    L177:
        r75 = null;
    L183:
        r78 = 0;
    L165:
        r68 = null;
    L171:
        r72 = 0;
        goto L172
    L152:
        r62 = 0;
    L130:
        r52 = 0L;     // Catch: Exception -> L203
    L201:
        d60.b.a(r19, "link_ver", 0);     // Catch: Exception -> L203
        d60.b.a(r19, "is_in_pk", 0);     // Catch: Exception -> L203
        return;
    L14:
        r8 = null;
        goto L17
    L10:
        r6 = null;
        goto L11
    L6:
        r3 = 0;
    L203:
        e = move-exception;
        jy0.b.a("RevLinkService", "setFeatureParams Exception = " + e);
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void setSkipRoomStatsSync(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.v1();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void unRegisterPkStateChangeObserver(Observer<gt1.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Y1();
        if (r1 == null) goto L9;
        r1.removeObserver(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateAudienceMemberCount(long r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.d0();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf((int) r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateEnterRoomViewMock(boolean r3) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.Cb();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.valueOf(r3));
    L7:
        wq2.f r2 = ma1.a.a();
        if (r2 == null) goto L11;
        r2.bj(r3);
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateFirstFrameSei(String r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.h4();
        if (r1 == null) goto L9;
        r1.setValue(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateInteractAnchorParam(String r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.B5();
        if (r1 == null) goto L9;
        r1.setValue(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateInteractLayoutShow(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.qe();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateKeyboardStatus(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Am();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateLiveMode(LiveMode r2) {
        Intrinsics.checkNotNullParameter(r2, "liveMode");
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.getLiveMode();
        if (r1 == null) goto L9;
        r1.setValue(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateLoad0Ts(long r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Md();
        if (r1 == null) goto L9;
        r1.setValue(Long.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateLoad1Ts(long r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.u3();
        if (r1 == null) goto L9;
        r1.setValue(Long.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateMicRoomAnchorStatus(int r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Ze();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updatePortrait(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.isPortrait();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateStableMode(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Un();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void markAddPkBackground(cy0.a r4, boolean r5) {
        cy0.c r6 = getAudienceRevenueDataScope(r4);
        wq2.f r0 = null;
        if (r6 == null) goto L5;
        ld.a r1 = (ld.a) m.e.d(r6, ld.a.class);
    L6:
        if (r6 == null) goto L8;
        r0 = (wq2.f) m.e.d(r6, wq2.f.class);
    L8:
        if (r1 == null) goto L12;
        NextLiveData r7 = r1.O1();
        if (r7 == null) goto L12;
        r7.setValue(Boolean.valueOf(r5));
    L12:
        if (r0 == null) goto L15;
        r0.Zn(r5);
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void notifyRenderSizeChanged(int r2, int r3) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Ii();
        if (r1 == null) goto L9;
        r1.setValue(TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r3)));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateEnterParams(cy0.a r3, long r4) {
        cy0.c r5 = getAudienceRevenueDataScope(r3);
        if (r5 == null) goto L5;
        ld.a r6 = (ld.a) m.e.d(r5, ld.a.class);
    L6:
        if (r6 == null) goto L11;
        NextLiveData r7 = r6.Cn();
        if (r7 == null) goto L12;
        r7.setValue(Long.valueOf(r4));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateInteractMarginTop(cy0.a r3, int r4) {
        cy0.c r5 = getAudienceRevenueDataScope(r3);
        if (r5 == null) goto L5;
        ld.a r6 = (ld.a) m.e.d(r5, ld.a.class);
    L6:
        if (r6 == null) goto L11;
        NextLiveData r7 = r6.f8();
        if (r7 == null) goto L12;
        r7.setValue(Integer.valueOf(r4));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updatePkLeftMargin(cy0.a r4, int r5) {
        cy0.c r6 = getAudienceRevenueDataScope(r4);
        wq2.f r0 = null;
        if (r6 == null) goto L5;
        ld.a r1 = (ld.a) m.e.d(r6, ld.a.class);
    L6:
        if (r6 == null) goto L8;
        r0 = (wq2.f) m.e.d(r6, wq2.f.class);
    L8:
        if (r1 == null) goto L12;
        NextLiveData r7 = r1.a2();
        if (r7 == null) goto L12;
        r7.setValue(Integer.valueOf(r5));
    L12:
        if (r0 == null) goto L15;
        r0.nj(r5);
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updatePkMovedMarginTop(cy0.a r3, int r4) {
        cy0.c r5 = getAudienceRevenueDataScope(r3);
        if (r5 == null) goto L5;
        ld.a r6 = (ld.a) m.e.d(r5, ld.a.class);
    L6:
        if (r6 == null) goto L11;
        NextLiveData r7 = r6.Gc();
        if (r7 == null) goto L12;
        r7.setValue(Integer.valueOf(r4));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updatePushStreamInfo(double r9, double r12, double r13) {
        com.bytedance.android.live.revlink.impl.rtc.a.G0.getClass();
        com.bytedance.android.live.revlink.impl.rtc.a r1 = com.bytedance.android.live.revlink.impl.rtc.a.C0196a.a();
        if (r1 == null) goto L6;
        r1.updatePushStreamInfo(r9, r12, r13);
        return;
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateVideoHeight(cy0.a r1, int r2, int r3) {
        cy0.c r4 = getAudienceRevenueDataScope(r1);
        if (r4 == null) goto L5;
        ld.a r5 = (ld.a) m.e.d(r4, ld.a.class);
    L6:
        if (r5 == null) goto L11;
        NextLiveData r6 = r5.getVideoHeight();
        if (r6 == null) goto L12;
        r6.setValue(new ld.g());
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public r createRevMultiControlWidget(r.a r2, ViewGroup r3, Boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        b r0 = new b(r2);
        if (r4 == null) goto L6;
        r4.booleanValue();
    L6:
        return new a(new LinkRevControlWidget(r0, r3, r5));
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public qc0.f getInteractFeedView(Context r4, pc0.a r5, int r6, kc0.d r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "seiAppData");
        int r8 = r5.getVersion();
        if (r8 != 6) goto L13;
        t41.a r9 = t41.a.m;
        r9.getClass();
        if (((Boolean) t41.a.i.getValue(r9, t41.a.a[7])).booleanValue() == true) goto L11;
        if (vh6.c.b(vr2.b.class).xd(r6) == true) goto L11;
        return new MultiAnchorFeedView(r4, r6);
    L11:
        return new com.bytedance.android.live.revlink.impl.multianchor.feed.c(r4, r6, r7);
    L13:
        if (r8 == 2) goto L15;
        return null;
    L15:
        if (t41.a.m.b() == true) goto L17;
        return null;
    L17:
        return new RevPkFullFeedView(r4, r6, r7);
    }

    @Override // com.bytedance.android.live.revlink.api.ILinkService
    public void updateFeedParams(cy0.a r3, int r4, int r5, int r6, long r7) {
        cy0.c r8 = getAudienceRevenueDataScope(r3);
        if (r8 == null) goto L5;
        ld.a r9 = (ld.a) m.e.d(r8, ld.a.class);
    L6:
        if (r9 == null) goto L10;
        NextLiveData r0 = r9.Q2();
        if (r0 == null) goto L10;
        r0.setValue(Integer.valueOf(r4));
    L10:
        if (r9 == null) goto L14;
        NextLiveData r10 = r9.i2();
        if (r10 == null) goto L14;
        r10.setValue(Integer.valueOf(r5));
    L14:
        if (r9 == null) goto L18;
        NextLiveData r12 = r9.Qk();
        if (r12 == null) goto L18;
        r12.setValue(Integer.valueOf(r6));
    L18:
        if (r9 == null) goto L23;
        NextLiveData r13 = r9.jm();
        if (r13 == null) goto L24;
        r13.setValue(Long.valueOf(r7));
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r9 = null;
        goto L6
    }
}
