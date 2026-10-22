package com.bytedance.android.live.liveinteract.feed;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.e2;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.feed.datamerge.FeedViewAudioMVBackgroundDataHandler;
import com.bytedance.android.live.liveinteract.feed.datamerge.FeedViewInteractSongDataHandler;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.panel.InteractiveSongMvManager;
import com.bytedance.android.live.liveinteract.jsbridge.method.l0;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.MultiLinkCommonItemDecoration;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.radio.RadioDarkMaskView;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleUIWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.SubtitleRecyclerView;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.g0;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRecyclerView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingInfoV2;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.IUserMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IMultiFeedView;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u0095\u0001J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010.\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\n\u00100\u001a\u0004\u0018\u00010/H\u0016J\n\u00101\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J(\u00105\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$\u0018\u000103j\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$\u0018\u0001`4H\u0016R$\u0010=\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R&\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020?0>8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010X\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\u001e\u0010]\u001a\u0004\u0018\u00010!8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\"\u0010e\u001a\u00020^8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010m\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010u\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010}\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R*\u0010\u0085\u0001\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R)\u0010\u008c\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R)\u0010\u0090\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u0087\u0001\u001a\u0006\b\u008e\u0001\u0010\u0089\u0001\"\u0006\b\u008f\u0001\u0010\u008b\u0001R)\u0010\u0094\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0087\u0001\u001a\u0006\b\u0092\u0001\u0010\u0089\u0001\"\u0006\b\u0093\u0001\u0010\u008b\u0001¨\u0006\u0096\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feed/MultiLinkVoiceChatFeedView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "Lcom/bytedance/android/livesdkapi/feed/IKtvInteractFeedView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/b;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/c;", "Lkotlin/Pair;", "", "getLivePlayerVideoSize", "getContainerWidth", "getContainerHeight", "", "getCurrentFrameLightValue", "()Ljava/lang/Float;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLinkmicSubtitleRootContainer", "Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/SubtitleRecyclerView;", "getLinkmicSubtitleRecyclerView", "getDragContainerStubHeight", "getLinkmicSubtitleHeight", "getResourceLayout", "", "getFeedViewName", "Lcom/bytedance/android/livesdkapi/feed/data/FeedViewRoomInfoStore;", "getFeedViewRoomInfoStore", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "", "setLivePlayerView", "Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "interactPlayView", "setInteractPlayView", "", "getKtvSeiModelObject", "getCurrentSingUserId", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "getKtvComponentFeedView", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "playerContainerAbility", "setLivePlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "setLivePlayerClient", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getLinkmicSeatListInfo", "getCurrentSingUserIdString", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getChatRoomEnterRoomExtraParam", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "c", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setMRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "mRoom", "", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "k", "Ljava/util/Map;", "getOriginLayoutConfigMap", "()Ljava/util/Map;", "originLayoutConfigMap", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "y", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "getBaseWindowView", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "setBaseWindowView", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;)V", "baseWindowView", "Landroid/view/View;", "z", "Landroid/view/View;", "getRecyclerView", "()Landroid/view/View;", "setRecyclerView", "(Landroid/view/View;)V", "recyclerView", "A", "getAnimRecyclerView", "setAnimRecyclerView", "animRecyclerView", "T", "Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "getMInteractPlayView", "()Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "mInteractPlayView", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "V", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "getItemDecoration", "()Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "setItemDecoration", "(Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;)V", "itemDecoration", "Landroidx/lifecycle/ViewModelStore;", "k1", "Landroidx/lifecycle/ViewModelStore;", "getMViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setMViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "mViewModelStore", "Landroidx/lifecycle/ViewModelProvider;", "p1", "Landroidx/lifecycle/ViewModelProvider;", "getViewModelProvider", "()Landroidx/lifecycle/ViewModelProvider;", "setViewModelProvider", "(Landroidx/lifecycle/ViewModelProvider;)V", "viewModelProvider", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "v1", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getFeedDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setFeedDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "feedDataCenter", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "x1", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "getDynamicWidget", "()Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "setDynamicWidget", "(Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;)V", "dynamicWidget", "H1", "I", "getSeiVer", "()I", "setSeiVer", "(I)V", "seiVer", "L1", "getUiLayout", "setUiLayout", "uiLayout", "M1", "getShowFrom", "setShowFrom", "showFrom", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkVoiceChatFeedView extends FrameLayout implements IInteractFeedView, IKtvInteractFeedView, LifecycleOwnerCompat, ViewModelStoreOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b, com.bytedance.android.live.liveinteract.plantform.dynamicframe.c {
    public static final /* synthetic */ int P1 = 0;
    public View A;
    public FrameLayout B;
    public RadioDarkMaskView C;
    public com.bytedance.android.live.liveinteract.videotalk.utils.c D;
    public com.bytedance.android.live.ui.q E;
    public d0 F;
    public IPreviewPlayerContainerAbility G;
    public LifecycleRegistry G1;
    public ILivePlayerClient H;
    public boolean H0;
    public int H1;
    public final IKtvComponentFeedView I;
    public boolean J;
    public com.bytedance.android.live.liveinteract.voicechat.subtitle.u K;
    public boolean L;
    public boolean L0;
    public int L1;
    public boolean M;
    public int M1;
    public boolean N;
    public q2 O;
    public HybridCard P;
    public Boolean P0;
    public int Q;
    public boolean R;
    public final t S;
    public IInteractPlayView T;
    public final JSONObject U;
    public BaseEqualGridItemDecoration V;
    public com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g V0;
    public IMultiScenePreviewStatistics W;
    public Map<Integer, View> a;
    public Disposable b;
    public final HashMap<String, Boolean> b1;
    public IRoom c;
    public FeedViewRoomInfoStore d;
    public int e;
    public ng0.e f;
    public qb g;
    public String g1;
    public boolean h;
    public int h1;
    public boolean i;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m j;
    public final Map<Integer, com.bytedance.android.live.liveinteract.plantform.commonwindow.m> k;
    public boolean k0;
    public ViewModelStore k1;
    public int l;
    public MessageHub m;
    public com.bytedance.android.live.liveinteract.feed.datamerge.b n;
    public com.bytedance.android.live.liveinteract.feed.datamerge.h o;
    public com.bytedance.android.live.liveinteract.feed.datamerge.g p;
    public boolean p0;
    public ViewModelProvider p1;
    public FeedViewAudioMVBackgroundDataHandler q;
    public FeedViewInteractSongDataHandler r;
    public com.bytedance.android.live.liveinteract.feed.datamerge.c s;
    public com.bytedance.android.live.liveinteract.feed.datamerge.d t;
    public com.bytedance.android.live.liveinteract.feed.datamerge.i u;
    public final CompositeDisposable v;
    public DataCenter v1;
    public final CompositeDisposable w;
    public IRenderView x;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.a x1;
    public BaseLinkSeatWindowView y;
    public int y1;
    public View z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.m b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public b(MultiLinkVoiceChatFeedView r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkVoiceChatFeedView r0 = this.a;     // Catch: Throwable -> L8
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.b;     // Catch: Throwable -> L8
            int r2 = this.c;     // Catch: Throwable -> L8
            int r3 = this.d;     // Catch: Throwable -> L8
            int r4 = MultiLinkVoiceChatFeedView.P1;     // Catch: Throwable -> L8
            r0.D = r0.A(r1, r2, r3);     // Catch: Throwable -> L8
            com.bytedance.android.live.liveinteract.feed.datamerge.i r5 = this.a.u;     // Catch: Throwable -> L8
            if (r5 == null) goto L11;
            BehaviorSubject<List<tf0.e>> r6 = r5.b;     // Catch: Throwable -> L8
            if (r6 == null) goto L15;
            List r7 = (List) r6.getValue();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;

        public c(MultiLinkVoiceChatFeedView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkVoiceChatFeedView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MultiLinkVoiceChatFeedView.P1;     // Catch: Throwable -> L4
            r0.S(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements com.bytedance.android.live.ui.a {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;

        public d(MultiLinkVoiceChatFeedView r1) {
            this.a = r1;
        }

        public final void Ek(IVoiceLiveTheme r2) {
            Intrinsics.checkNotNullParameter(r2, "theme");
            Intrinsics.checkNotNullParameter(r2, "theme");
        }

        public final void W9(boolean r7, IVoiceLiveTheme r8) {
            Intrinsics.checkNotNullParameter(r8, "theme");
            MultiLinkVoiceChatFeedView r9 = this.a;
            r9.k0 = true;
            if (r9.getVisibility() != 0) goto L8;
            IMultiScenePreviewStatistics r0 = this.a.W;
            if (r0 == null) goto L9;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r0, "background_Load", 0, 2, null);
            return;
        L9:
            return;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;

        public e(MultiLinkVoiceChatFeedView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = MultiLinkVoiceChatFeedView.h(this.a);     // Catch: Throwable -> L4
            int r1 = MultiLinkVoiceChatFeedView.f(this.a);     // Catch: Throwable -> L4
            MultiLinkVoiceChatFeedView.t(this.a, r0, r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;

        public f(MultiLinkVoiceChatFeedView r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            Intrinsics.checkNotNullParameter(r12, "response");
            IMultiScenePreviewStatistics r1 = this.a.W;
            if (r1 == null) goto L5;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r1, "list_v2_time", 0, 2, null);
        L5:
            List<com.bytedance.android.livesdk.link.model.bridge.k> r0 = ((w0) r12.data).getMPlayerInfo();
            List r2 = null;
            if (r0 == null) goto L12;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r3 = r0;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator<T> r5 = r3.iterator();
        L9:
            if (r5.hasNext() == false) goto L11;
            r4.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r5.next(), true));
            goto L9
        L11:
            List<ILinkPlayerInfoBridge> r6 = CollectionsKt.toMutableList(r4);
        L13:
            FeedViewRoomInfoStore r7 = this.a.getFeedViewRoomInfoStore();
            if (r7 == null) goto L19;
            if (r6 != null) goto L17;
            List<ILinkPlayerInfoBridge> r8 = new ArrayList();
        L18:
            r7.setOnlineList(r8);
            goto L19
        L17:
            r8 = r6;
        L19:
            List<LinkmicPositionItem> r9 = ((w0) r12.data).getPositions();
            Map<Long, g2> r10 = ((w0) r12.data).getLinkerContentMap();
            if (r10 == null) goto L32;
            Map.Entry r13 = z0.a(r10);
            if (r13 == null) goto L32;
            g2 r14 = (g2) r13.getValue();
            if (r14 == null) goto L32;
            List r15 = r14.getLinkedUsers();
            if (r15 == null) goto L32;
            List r16 = r15;
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r18 = r16.iterator();
        L29:
            if (r18.hasNext() == false) goto L31;
            r17.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r18.next(), true));
            goto L29
        L31:
            r2 = CollectionsKt.toMutableList(r17);
        L32:
            if (r2 == null) goto L37;
            Iterator<T> r19 = r2.iterator();
        L35:
            if (r19.hasNext() == false) goto L37;
            ILinkPlayerInfoBridge r20 = (ILinkPlayerInfoBridge) r19.next();
            int r21 = tc0.e.a;
            tc0.e.b(r20, ((w0) r12.data).getLinkerContentMap());
        L37:
            MultiLinkVoiceChatFeedView r110 = this.a;
            com.bytedance.android.live.liveinteract.feed.datamerge.g r22 = r110.p;
            if (r22 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("onlineUserListHandler");
        L40:
            r22.f(r6);
            com.bytedance.android.live.liveinteract.feed.datamerge.g r111 = r110.p;
            if (r111 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("onlineUserListHandler");
        L43:
            r111.e(r9);
            if (vm2.d.L0() == true) goto L46;
        L57:
            ConstraintLayout r112 = this.a.getBaseWindowView();
            if (r112 == null) goto L60;
            int r23 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
            com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r112, new MultiLinkVoiceChatFeedView$onOnlineListChanged$$inlined$let$lambda$1$1(this));
        L60:
            MultiLinkVoiceChatFeedView r113 = this.a;
            if (r113.M() == false) goto L69;
            LinkApi r24 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
            IRoom r25 = r113.c;
            if (r25 == null) goto L65;
            long r26 = r25.getId();
        L66:
            Disposable r27 = r24.fetchPlayModeInfo(r26, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.feed.k(r113), l.a);
            if (r27 == null) goto L69;
            RxUtilKt.c(r27, r113.v);
            goto L69
        L65:
            r26 = 0;
        L69:
            this.a.w();
            return;
        L46:
            if (vm2.d.q0().isFeedViewDisplayWhenGuestListReady() == false) goto L57;
            com.bytedance.android.live.liveinteract.feed.datamerge.h r114 = this.a.o;
            if (r114 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
        L51:
            if (((ArrayList) r114.c).size() <= 0) goto L57;
            UtilityKotlinExtentionsKt.w(this.a);
            MultiLinkVoiceChatFeedView r115 = this.a;
            if (r115.k0 == false) goto L57;
            IMultiScenePreviewStatistics r28 = r115.W;
            if (r28 == null) goto L57;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r28, "background_Load", 0, 2, null);
            goto L57
        L12:
            r6 = null;
            goto L13
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;

        public h(MultiLinkVoiceChatFeedView r1) {
            this.a = r1;
        }

        public final void a() {
            MultiLinkVoiceChatFeedView.e(this.a);
            MultiLinkVoiceChatFeedView r0 = this.a;
            r0.getClass();
            IMiddlewareLiveService r1 = TTLiveServiceMiddleware.getLiveService();
            if (r1 == null) goto L13;
            boolean r3 = true;
            if (r1.shouldUseNewLivePlayerLayout() != true) goto L13;
            int r2 = r0.M1;
            if (r2 != 2) goto L9;
        L14:
            if (r3 == true) goto L28;
            int r4 = c1.a;
            if (c1.a(0, Integer.valueOf(r0.e)) == false) goto L28;
            IPreviewPlayerContainerAbility r5 = r0.G;
            if (r5 == null) goto L28;
            ViewGroup.LayoutParams r6 = r5.getLayoutParams();
            if ((r6 instanceof FrameLayout.LayoutParams) == true) goto L23;
            r6 = null;
        L23:
            FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
            if (r7 == null) goto L28;
            if (r7.topMargin == 0) goto L28;
            r7.topMargin = 0;
        L28:
            MultiLinkVoiceChatFeedView.h(this.a);
            MultiLinkVoiceChatFeedView r8 = this.a;
            ConstraintLayout r9 = r8.y;
            if (r9 == null) goto L31;
            r9.setVisibility(0);
        L31:
            r8.G();
            r8.W(r8.j);
            return;
        L9:
            if (r2 == 3) goto L14;
            if (r2 == 4) goto L14;
        L13:
            r3 = false;
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;

        public i(MultiLinkVoiceChatFeedView r1) {
            this.a = r1;
        }

        public final void a() {
            MultiLinkVoiceChatFeedView.e(this.a);
            if (this.a.L() == true) goto L5;
            MultiLinkVoiceChatFeedView.t(this.a, MultiLinkVoiceChatFeedView.h(this.a), MultiLinkVoiceChatFeedView.f(this.a));
        L5:
            this.a.onOnlineListChanged();
            MultiLinkVoiceChatFeedView r0 = this.a;
            IRoom r1 = r0.c;
            if (r1 == null) goto L41;
            z5 r2 = r1.getLinkerDetail();
            boolean r4 = true;
            if (r2 == null) goto L13;
            List r3 = r2.getPlayModes();
            if (r3 == null) goto L13;
            if (r3.contains(Long.valueOf(13)) != true) goto L13;
        L23:
            com.bytedance.android.live.liveinteract.feed.datamerge.c r5 = r0.s;
            if (r5 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("cPositionDataHandler");
        L26:
            r5.e(r4);
            z5 r6 = r1.getLinkerDetail();
            if (r6 == null) goto L41;
            List r7 = r6.getPlayModes();
            if (r7 == null) goto L41;
            ArrayList r8 = new ArrayList();
            Iterator r9 = r7.iterator();
        L32:
            if (r9.hasNext() == false) goto L34;
            r8.add(Integer.valueOf((int) ((Number) r9.next()).longValue()));
            goto L32
        L34:
            com.bytedance.android.live.liveinteract.feed.datamerge.b r10 = r0.n;
            if (r10 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
        L37:
            ch0.a r11 = ch0.a.a(r10.e(), 0, 0, r8, 3);
            com.bytedance.android.live.liveinteract.feed.datamerge.b r12 = r0.n;
            if (r12 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
        L40:
            r12.l(r11);
        L13:
            int r13 = r0.H1;
            if (r13 == 13) goto L23;
            if (r13 == 12) goto L23;
            if (r13 == 20) goto L23;
            if (r13 == 21) goto L23;
            r4 = false;
        L41:
            this.a.G();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;
        public final /* synthetic */ int b;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r4) {
            Intrinsics.checkNotNullParameter(r4, "request");
            f2.g();
            if (vm2.d.T0() == true) goto L5;
            return;
        L5:
            if (this.b == 21) goto L9;
            ALogger.i("VoiceChatFeedView", "loadLayoutConfigFailed try to load 1v8, uiLayout=" + r4.a + ", traceInfo=" + r4.c.a);
            this.a.updateSeiVerAndUiLayout(21, 3);
            return;
        }

        public j(MultiLinkVoiceChatFeedView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "response");
            MultiLinkVoiceChatFeedView.u(this.a, r3.a);
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ MultiLinkVoiceChatFeedView a;
        public final /* synthetic */ q2 b;

        public k(MultiLinkVoiceChatFeedView r1, q2 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.b.getSubtitleStyle() != LinkmicSubtitleStyle.LONG.ordinal()) goto L5;
            int r0 = LinkmicSubtitleUIWidget.w;
        L6:
            MultiLinkVoiceChatFeedView r1 = this.a;
            if (r1.Q == r0) goto L23;
            r1.Q = r0;
            ViewGroup.LayoutParams r2 = MultiLinkVoiceChatFeedView.m(r1).getLayoutParams();
            if ((r2 instanceof ConstraintLayout.LayoutParams) == true) goto L11;
            r2 = null;
        L11:
            ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2;
            if (r3 == null) goto L15;
            MultiLinkVoiceChatFeedView r4 = this.a;
            ((ViewGroup.MarginLayoutParams) r3).width = r4.Q;
            MultiLinkVoiceChatFeedView.m(r4).setLayoutParams(r3);
        L15:
            if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L23;
            HybridCard r5 = this.a.P;
            if (r5 == null) goto L23;
            r5.release();
            this.a.b(2131378052).removeView(this.a.P);
            MultiLinkVoiceChatFeedView r6 = this.a;
            int r7 = g0.a;
            r6.P = g0.f(r6.getContext(), this.a.Q);
            HybridCard r8 = this.a.P;
            if (r8 == null) goto L23;
            r8.setLayoutParams(new ConstraintLayout.LayoutParams(this.a.Q, LinkmicSubtitleUIWidget.u));
            ConstraintLayout r9 = this.a.b(2131378052);
            if (r9 == null) goto L23;
            r9.addView(r8);
        L23:
            double r10 = this.b.getX() * ((double) s1.y());
            double r11 = this.b.getY() * ((double) MultiLinkVoiceChatFeedView.j(this.a));
            ConstraintLayout r12 = MultiLinkVoiceChatFeedView.m(this.a);
            r12.setTranslationX((float) r10);
            r12.setTranslationY((float) r11);
            return;
        L5:
            r0 = LinkmicSubtitleUIWidget.x;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void H() {
        this.N = true;
        q2 r0 = this.O;
        if (r0 == null) goto L5;
        Z(r0);
    L5:
        this.K = new com.bytedance.android.live.liveinteract.voicechat.subtitle.u(getContext(), this.c, getLinkmicSubtitleRecyclerView(), (TextView) b(2131387064));
        ViewGroup.LayoutParams r1 = b(2131387653).getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == true) goto L8;
        r1 = null;
    L8:
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        if (r2 == null) goto L11;
        ((ViewGroup.MarginLayoutParams) r2).height = getDragContainerStubHeight();
    L11:
        this.K = new com.bytedance.android.live.liveinteract.voicechat.subtitle.u(getContext(), this.c, getLinkmicSubtitleRecyclerView(), (TextView) b(2131387064));
        int r3 = getDragContainerStubHeight() - getLinkmicSubtitleHeight();
        int r4 = UtilityKotlinExtentionsKt.i(12);
        ConstraintLayout r5 = getLinkmicSubtitleRootContainer();
        r5.setTranslationX(r4);
        r5.setTranslationY(r3);
    }

    public String getFeedViewName() {
        return "CommonMultiLinkFeedView";
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public int getResourceLayout() {
        return 2131565260;
    }

    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void l() {
    }

    public final void onSeiUpdated(JSONObject r1) {
    }

    public final void updateEnterFrom(String r1, String r2) {
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    private final int getContainerHeight() {
        IPreviewPlayerContainerAbility r0 = this.G;
        Integer r1 = null;
        if (r0 == null) goto L14;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L14;
        Integer r3 = Integer.valueOf(r2.height);
        if (r3.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L14;
    L18:
        if (r3 != null) goto L25;
        ViewParent r5 = getParent();
        if ((r5 instanceof FrameLayout) == true) goto L22;
        r5 = null;
    L22:
        FrameLayout r6 = (FrameLayout) r5;
        if (r6 == null) goto L26;
        r1 = Integer.valueOf(r6.getMeasuredHeight());
    L26:
        if (r1 == null) goto L29;
        return r1.intValue();
    L29:
        return s1.w();
    L25:
        r1 = r3;
        goto L26
    L9:
        r4 = false;
    L14:
        IPreviewPlayerContainerAbility r7 = this.G;
        if (r7 == null) goto L17;
        r3 = r7.getHeight();
        goto L18
    L17:
        r3 = null;
        goto L18
    }

    private final int getContainerWidth() {
        IPreviewPlayerContainerAbility r0 = this.G;
        Integer r1 = null;
        if (r0 == null) goto L14;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L14;
        Integer r3 = Integer.valueOf(r2.width);
        if (r3.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L14;
    L18:
        if (r3 != null) goto L25;
        ViewParent r5 = getParent();
        if ((r5 instanceof FrameLayout) == true) goto L22;
        r5 = null;
    L22:
        FrameLayout r6 = (FrameLayout) r5;
        if (r6 == null) goto L26;
        r1 = Integer.valueOf(r6.getMeasuredWidth());
    L26:
        if (r1 == null) goto L29;
        return r1.intValue();
    L29:
        return s1.y();
    L25:
        r1 = r3;
        goto L26
    L9:
        r4 = false;
    L14:
        IPreviewPlayerContainerAbility r7 = this.G;
        if (r7 == null) goto L17;
        r3 = r7.getWidth();
        goto L18
    L17:
        r3 = null;
        goto L18
    }

    private final Float getCurrentFrameLightValue() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvapi.model.mv.c> r1 = r0.getAiMVPlayService();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r2 = (com.bytedance.android.livesdk.ktvapi.model.mv.c) r1.getValue();
        if (r2 == null) goto L9;
        return r2.m();
    L9:
        return null;
    }

    private final int getDragContainerStubHeight() {
        int r0 = g0.a;
        if (g0.b(this.c) == false) goto L6;
        return UtilityKotlinExtentionsKt.i(326) + getLinkmicSubtitleHeight();
    L6:
        return UtilityKotlinExtentionsKt.i(326);
    }

    private final int getLinkmicSubtitleHeight() {
        int r0 = LinkmicSubtitleUIWidget.r;
        return LinkmicSubtitleUIWidget.u;
    }

    private final Pair<Integer, Integer> getLivePlayerVideoSize() {
        ILivePlayerClient r0 = this.H;
        if (r0 == null) goto L13;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L13;
        MutableLiveData r2 = r1.getVideoSizeChanged();
        if (r2 == null) goto L13;
        Pair r3 = (Pair) r2.getValue();
        if (r3 == null) goto L13;
        return new Pair(r3.getFirst(), r3.getSecond());
    L13:
        return new Pair(0, 0);
    }

    private final IInteractPlayView getMInteractPlayView() {
        if (this.T != null) goto L5;
    L8:
        IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
        if (r0 != null) goto L13;
        return null;
    L13:
        return r0.getInteractPlayView(getContext());
    L5:
        if (com.bytedance.android.live.liveinteract.utils.h.e(this.M1) == false) goto L8;
        return this.T;
    }

    public final boolean B() {
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.M1) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.L == false) goto L9;
        if (vm2.c.b().getAudioSubtitleGuestEnable() != true) goto L9;
        int r0 = g0.a;
        return true;
    }

    public final void G() {
        IRoom r0 = this.c;
        if (r0 == null) goto L29;
        IVoiceLiveTheme r1 = r0.getVoiceLiveTheme();
        if (r1 != null) goto L7;
        return;
    L7:
        if (2 == r1.getBgType()) goto L11;
        if (5 == r1.getBgType()) goto L11;
    L25:
        com.bytedance.android.live.ui.q r2 = this.E;
        if (r2 == null) goto L35;
        r2.a(com.bytedance.android.livesdk.model.k.a());
        return;
    L35:
        return;
    L11:
        if (r1.getPlayMode() == 16) goto L25;
        com.bytedance.android.live.ui.q r3 = this.E;
        if (r3 == null) goto L16;
        r3.a(r1);
    L16:
        if (vm2.d.s0() == true) goto L18;
    L22:
        RadioDarkMaskView r4 = this.C;
        if (r4 == null) goto L33;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L33:
        return;
    L18:
        if (r1.isUgcImage() == false) goto L22;
        RadioDarkMaskView r5 = this.C;
        if (r5 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r5);
        return;
    L31:
        return;
    }

    public final void J() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        Pair r1 = com.bytedance.live.datacontext.d.a(MultiLinkVoiceChatFeedView$initOrderSongContext$pair$1.INSTANCE);
        InteractiveSongContext r2 = (InteractiveSongContext) r1.getFirst();
        r2.isFeed().d(Boolean.TRUE);
        com.bytedance.live.datacontext.b.a(r2, InteractiveSongContext.TAG_FOR_FEED);
        this.b = (Disposable) r1.getSecond();
        FeedViewInteractSongDataHandler r3 = this.r;
        if (r3 == null) goto L22;
        List<IUserMicrophoneItem> r4 = r3.c;
        if (r4 == null) goto L22;
        Iterator<T> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L22;
        IUserMicrophoneItem r6 = (IUserMicrophoneItem) r5.next();
        if (r6.isSinging() == false) goto L13;
        com.bytedance.live.datacontext.m<String> r7 = r2.getSingingGuestId();
        IBaseUser r8 = r6.getOrderUser();
        if (r8 == null) goto L20;
        String r9 = r8.getIdString();
        if (r9 == null) goto L20;
    L21:
        r7.setValue(r9);
    L20:
        r9 = "";
    L22:
        int r10 = com.bytedance.android.live.liveinteract.aimv.b.a;
        boolean r11 = com.bytedance.android.live.liveinteract.aimv.b.b(this.c);
        FeedViewInteractSongDataHandler r12 = this.r;
        if (r12 == null) goto L30;
        Boolean r13 = Boolean.valueOf(r12.h);
        if (r13.booleanValue() == true) goto L28;
        r13 = null;
    L28:
        if (r13 == null) goto L30;
        r13.booleanValue();
        InteractiveSongContext.Companion.g(true, true, r11, String.valueOf(19));
    L30:
        FeedViewInteractSongDataHandler r14 = this.r;
        if (r14 == null) goto L35;
        Boolean r15 = r14.i;
        if (r15 == null) goto L35;
        boolean r16 = r15.booleanValue();
        r2.getShowOrderSingStage().setValue(Boolean.valueOf(r16));
    L35:
        InteractiveSongContext.a r17 = InteractiveSongContext.Companion;
        InteractiveSongContext r18 = r17.getContext();
        if (r18 == null) goto L41;
        com.bytedance.live.datacontext.m<Boolean> r19 = r18.isShowPlayer();
        if (r19 == null) goto L41;
        r19.setValue(Boolean.valueOf(this.J));
    L41:
        if (this.i == true) goto L54;
        this.i = true;
        InteractiveSongContext r20 = r17.getContext();
        if (r20 == null) goto L51;
        com.bytedance.live.datacontext.m<Boolean> r21 = r20.getShowOrderSingStage();
        if (r21 == null) goto L51;
        Observable r22 = r21.a();
        if (r22 == null) goto L51;
        Disposable r23 = r22.subscribe(new u(this));
        if (r23 == null) goto L51;
        RxUtilKt.c(r23, this.v);
    L51:
        FeedViewInteractSongDataHandler r24 = this.r;
        if (r24 == null) goto L54;
        r24.f(r17.f());
    L54:
        E();
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final boolean L() {
        IRoom r0 = this.c;
        if (r0 == null) goto L11;
        z5 r1 = r0.getLinkerDetail();
        if (r1 == null) goto L11;
        List r2 = r1.getPlayModes();
        if (r2 == null) goto L11;
        if (r2.contains(Long.valueOf(7)) != true) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean M() {
        IRoom r0 = this.c;
        if (r0 == null) goto L11;
        z5 r1 = r0.getLinkerDetail();
        if (r1 == null) goto L11;
        List r2 = r1.getPlayModes();
        if (r2 == null) goto L11;
        if (r2.contains(Long.valueOf(19)) != true) goto L11;
        return true;
    L11:
        return false;
    }

    public final void N() {
        if (this.J == true) goto L5;
    L7:
        ALogger.e("MultiLinkThemeBgUIWidget", "VOICE feedView 0, initTheme");
        this.F = new d0(false, b(2131388551), b(2131370471), null, new d(this), 56);
        com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a r0 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
        d0 r1 = this.F;
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.live.ui.q.a.c(r0, r1);
        com.bytedance.android.live.ui.q r2 = r0.a();
        this.E = r2;
        IRoom r3 = this.c;
        if (r3 == null) goto L10;
        IVoiceLiveTheme r4 = r3.getVoiceLiveTheme();
    L11:
        r2.c(r4);
        return;
    L10:
        r4 = null;
        goto L11
    L5:
        if (this.L1 != 28) goto L7;
    }

    public final void P() {
        IRoom r0 = this.c;
        if (r0 == null) goto L5;
        IVoiceLiveTheme r1 = r0.getVoiceLiveTheme();
    L6:
        if (r1 != null) goto L8;
    L9:
        if (r1 != null) goto L11;
    L13:
        r1 = com.bytedance.android.livesdk.model.k.a();
    L14:
        com.bytedance.android.live.ui.q r2 = this.E;
        if (r2 == null) goto L17;
        r2.d(r1);
    L17:
        this.F = null;
        this.E = null;
        return;
    L11:
        if (5 != r1.getBgType()) goto L13;
    L8:
        if (2 == r1.getBgType()) goto L14;
    L5:
        r1 = null;
        goto L6
    }

    public final void Q() {
        if (this.L1 == 24) goto L7;
        if (vm2.d.R0() == true) goto L7;
        return;
    L7:
        if (this.G1 != null) goto L10;
        this.G1 = new LifecycleRegistry(this);
    L10:
        if (this.k1 != null) goto L13;
        this.k1 = new ViewModelStore();
    L13:
        if (this.p1 != null) goto L16;
        this.p1 = new ViewModelProvider(this);
    L16:
        if (this.v1 != null) goto L20;
        this.v1 = DataCenter.create(this.p1, this);
        return;
    }

    public final void R() {
        MessageHub r0 = this.m;
        if (r0 == null) goto L5;
        r0.removeMessageListener(MessageType.LINK_MIC_PLAYMODE.getIntType(), this.S);
    L5:
        MessageHub r1 = this.m;
        if (r1 == null) goto L9;
        r1.removeMessageListener(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this.S);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final Integer a() {
        return Integer.valueOf(C(this.L1, this.H1));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean c() {
        Boolean r0 = this.P0;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        HashMap<String, Object> r0 = new HashMap();
        if (((Boolean) vm2.d.V6.getValue(null, vm2.d.a[409(0x199, float:5.73E-43)])).booleanValue() == true) goto L5;
    L22:
        return r0;
    L5:
        if (this.L0 == false) goto L22;
        if (s0.g(this.c) == true) goto L9;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L22;
        r0.put("is_subtitle_stage_showing", Boolean.valueOf(this.L0));
        goto L22
    L9:
        if (this.e != 27) goto L19;
        InteractiveSongContext.a r1 = InteractiveSongContext.Companion;
        if (r1.f() == false) goto L19;
        InteractiveSongContext r3 = r1.getContext();
        if (r3 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.getShowOrderSingStage();
        if (r4 == null) goto L19;
        r2 = true;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L19;
        goto L19
    }

    public String getCurrentSingUserId() {
        IKtvComponentFeedView r0 = this.I;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getCurrentSingUserIdString() {
        IKtvComponentFeedView r0 = this.I;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        if (this.d != null) goto L10;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        FeedViewRoomInfoStore r1 = r0.getFeedViewRoomInfoStore();
    L8:
        this.d = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.d;
    }

    public final BaseEqualGridItemDecoration getItemDecoration() {
        BaseEqualGridItemDecoration r0 = this.V;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
    L5:
        return r0;
    }

    public Object getKtvSeiModelObject() {
        IKtvComponentFeedView r0 = this.I;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvSeiModelObject();
    }

    public Lifecycle getLifecycleCompat() {
        LifecycleRegistry r0 = this.G1;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LifecycleRegistry(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicAreaFrameInfo() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.j;
        int r1 = 0;
        if (r0 == null) goto L11;
        boolean r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(Integer.valueOf(r0.getUiLayout()), 0, 6) == false) goto L11;
        Pair r2 = ug0.b.b(r0.m(), r0.getUiLayout(), getContainerWidth(), getContainerHeight());
        int r4 = ((Number) r2.getFirst()).intValue();
        int r5 = ((Number) r2.getSecond()).intValue();
        int r6 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        sf0.b r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a(r0, r4, r5);
        List<Integer> r8 = r0.e;
        if (r8 == null) goto L10;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.b = r8;
    L10:
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r7);
    L11:
        BaseLinkSeatWindowView r9 = this.y;
        if (r9 == null) goto L29;
        LinkMicRecyclerView r10 = r9.getRecyclerView();
        if (r10 == null) goto L31;
        int r11 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        if (r0 == null) goto L18;
        int r12 = r0.getUiLayout();
    L19:
        sf0.b r13 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.e(r10, r12);
        sf0.c r14 = r13.c;
        if (r0 == null) goto L22;
        r1 = r0.b;
    L22:
        r14.a = r1;
        if (r0 == null) goto L28;
        List<Integer> r15 = r0.e;
        if (r15 == null) goto L28;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r13.b = r15;
    L28:
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r13);
    L18:
        r12 = 0;
        goto L19
    L31:
        return null;
    L29:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicSeatListInfo() {
        BaseLinkSeatWindowView r0 = this.y;
        if (r0 == null) goto L8;
        fg0.a r1 = r0.getMultiAdapterWrapper();
        if (r1 == null) goto L8;
        List<? extends tf0.e> r2 = r1.a;
        if (r2 == null) goto L8;
    L10:
        return new nh0.f("seat", null, r2, null, null, null, false, 246).b();
    L8:
        r2 = CollectionsKt.emptyList();
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final int i() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.j;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.j();
    }

    public final void onOnlineListChanged() {
        IRoom r0 = this.c;
        if (r0 == null) goto L13;
        LinkAnchorApi r2 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r3 = r0.getId();
        long r5 = d5.c(r0.getAnchorId());
        String r1 = r0.getAnchorId();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        Disposable r4 = r2.getLinkListV2(r3, r5, r1, true, r0.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), g.a);
        if (r4 == null) goto L10;
        Boolean r6 = Boolean.valueOf(this.w.add(r4));
    L11:
        r6.booleanValue();
        return;
    L10:
        r6 = null;
        goto L11
    }

    public final void onViewHolderPause() {
        if (this.L1 != 24) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.x1;
        if (r0 == null) goto L11;
        r0.onPause();
        return;
    L11:
        return;
    L5:
        if (vm2.d.R0() == true) goto L6;
    }

    public final void onViewHolderResume() {
        if (this.L1 != 24) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.x1;
        if (r0 == null) goto L9;
        r0.Kk();
    L9:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.x1;
        if (r1 == null) goto L12;
        r1.initDataContext();
    L12:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r2 = this.x1;
        if (r2 == null) goto L16;
        r2.onResume();
    L16:
        if (InteractiveSongContext.Companion.getContext() != null) goto L21;
        this.i = false;
        J();
        com.bytedance.android.live.liveinteract.feed.datamerge.i r3 = this.u;
        if (r3 == null) goto L22;
        r3.u();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (vm2.d.R0() == false) goto L16;
        goto L6
    }

    public final void onViewHolderSelected() {
        if (this.L1 != 24) goto L5;
    L6:
        Q();
        if (com.bytedance.android.live.liveinteract.utils.h.e(this.M1) == false) goto L9;
        Context r3 = getContext();
        DataCenter r4 = this.v1;
        Intrinsics.checkNotNull(r4);
        MultiLinkFeedDynamicWidgetNew r0 = new MultiLinkFeedDynamicWidgetNew(this, r3, r4, this, this, this.M1, null, null, 1984);
    L10:
        this.x1 = r0;
        if (r0 == null) goto L13;
        r0.b(this.W);
    L13:
        IRoom r1 = this.c;
        if (r1 == null) goto L18;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r2 = this.x1;
        if (r2 == null) goto L18;
        r2.updateRoom(r1);
    L18:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = this.j;
        if (r5 == null) goto L23;
        nh0.f r10 = new nh0.f("linkmic", new nh0.e(r5.j(), r5.getUiLayout(), CollectionsKt.emptyList(), -1, -1, CollectionsKt.emptyList(), null, null, 192), null, null, null, null, false, 224);
        DataCenter r6 = this.v1;
        if (r6 == null) goto L23;
        r6.put("data_multi_lick_dynamic_event_change", r10);
    L23:
        LifecycleRegistry r7 = this.G1;
        if (r7 == null) goto L28;
        r7.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L28:
        return;
    L9:
        r0 = null;
        goto L10
    L5:
        if (vm2.d.R0() == true) goto L6;
    }

    public final void onViewHolderUnSelected() {
        if (this.L1 != 24) goto L5;
    L6:
        LifecycleRegistry r0 = this.G1;
        if (r0 == null) goto L10;
        r0.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L10:
        if (this.y1 <= 0) goto L12;
        this.y1 = 0;
    L12:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.x1;
        if (r1 == null) goto L15;
        r1.jc("audiochat_stage");
    L15:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r2 = this.x1;
        if (r2 == null) goto L18;
        r2.onDestroy();
    L18:
        ViewModelStore r3 = this.k1;
        if (r3 == null) goto L21;
        r3.clear();
    L21:
        this.G1 = null;
        this.k1 = null;
        this.p1 = null;
        this.v1 = null;
        return;
    L5:
        if (vm2.d.R0() == true) goto L6;
    }

    public final void reset() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r1 = this.n;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L10:
        Iterator<com.bytedance.android.live.liveinteract.feed.datamerge.j> r2 = r1.j.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r2.next().detach();
        goto L12
    L14:
        r1.j.clear();
        this.v.clear();
        com.bytedance.android.live.liveinteract.utils.h.h(this.x, this.G, this.M1);
        this.w.clear();
        IKtvComponentFeedView r3 = this.I;
        if (r3 == null) goto L17;
        r3.reset();
    L17:
        UtilityKotlinExtentionsKt.t(getLinkmicSubtitleRootContainer());
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r4 = this.K;
        if (r4 == null) goto L20;
        r4.a();
    L20:
        HybridCard r5 = this.P;
        if (r5 == null) goto L26;
        r5.release();
        ConstraintLayout r6 = b(2131378052);
        if (r6 == null) goto L25;
        r6.removeView(this.P);
    L25:
        this.P = null;
    L26:
        this.p0 = false;
        R();
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void resetKtvSeiModelObject() {
        IKtvComponentFeedView r0 = this.I;
        if (r0 == null) goto L6;
        r0.resetKtvSeiModelObject();
        return;
    }

    public final ViewModelStore tf() {
        ViewModelStore r0 = this.k1;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ViewModelStore();
    }

    public final void w() {
        com.bytedance.android.live.liveinteract.feed.datamerge.b r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L5:
        List r1 = (List) r0.a.getValue();
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-1, -2);
        int r3 = b(2131384822).getMeasuredHeight();
        int r4 = this.H1;
        int r7 = 0;
        if (r4 != 10) goto L8;
        BaseLinkSeatWindowView r5 = this.y;
        if (r5 == null) goto L41;
        ug0.a r6 = r5.getRvLayoutManager();
        if (r6 == null) goto L41;
        Pair<Integer, Integer> r8 = r6.a(1);
        if (r8 == null) goto L41;
        Integer r9 = (Integer) r8.getFirst();
        if (r9 == null) goto L41;
        int r10 = r9.intValue();
    L42:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11 = this.j;
        if (r11 == null) goto L45;
        int r12 = r11.p(r3);
    L46:
        int r13 = (r10 + r12) + s1.f(4.0f);
        r2.topToTop = 0;
        r2.rightToRight = 0;
        r2.constrainedWidth = true;
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = r13;
    L47:
        IKtvComponentFeedView r14 = this.I;
        if (r14 == null) goto L51;
        r14.updateKsongLayout(r2);
        return;
    L51:
        return;
    L45:
        r12 = 0;
    L41:
        r10 = 0;
        goto L42
    L8:
        if (r4 == 15) goto L10;
        com.bytedance.android.live.liveinteract.utils.h.c(r4, 2131384921);
        goto L47
    L10:
        BaseLinkSeatWindowView r15 = this.y;
        if (r15 == null) goto L19;
        ug0.a r16 = r15.getRvLayoutManager();
        if (r16 == null) goto L19;
        Pair<Integer, Integer> r17 = r16.a(1);
        if (r17 == null) goto L19;
        Integer r18 = (Integer) r17.getFirst();
        if (r18 == null) goto L19;
        int r19 = r18.intValue();
    L20:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r20 = this.j;
        if (r20 == null) goto L23;
        int r21 = r20.p(r3);
    L24:
        int r22 = (r19 + r21) + s1.f(4.0f);
        r2.topToTop = 0;
        r2.rightToRight = 0;
        r2.constrainedWidth = true;
        if (r1 == null) goto L27;
        int r23 = r1.size();
    L29:
        if (r23 < 7) goto L31;
        r7 = r22;
    L31:
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = r7;
        goto L47
    L27:
        r23 = 0;
        goto L29
    L23:
        r21 = 0;
    L19:
        r19 = 0;
        goto L20
    }

    private final SubtitleRecyclerView getLinkmicSubtitleRecyclerView() {
        return (SubtitleRecyclerView) b(2131378056);
    }

    private final ConstraintLayout getLinkmicSubtitleRootContainer() {
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L6;
        return b(2131378052);
    L6:
        return b(2131378054);
    }

    public final void E() {
        if (vm2.h.h0().d() == true) goto L5;
        return;
    L5:
        InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
        InteractiveSongContext r1 = r0.getContext();
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m<String> r2 = r1.getSingingGuestId();
        if (r2 == null) goto L10;
        String r3 = (String) r2.getValue();
    L10:
        com.bytedance.android.live.liveinteract.feed.datamerge.i r4 = this.u;
        ch0.e r5 = null;
        if (r4 == null) goto L15;
        BehaviorSubject<List<tf0.e>> r6 = r4.b;
        if (r6 == null) goto L15;
        List r7 = (List) r6.getValue();
    L16:
        if (r7 == null) goto L18;
        tf0.e r8 = (tf0.e) CollectionsKt.firstOrNull(r7);
    L20:
        if ((r8 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == true) goto L22;
        r8 = null;
    L22:
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r9 = (MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) r8;
        if (r9 == null) goto L26;
        r5 = r9.q;
    L26:
        if (r0.e(this.c, Integer.valueOf(this.L1)) == true) goto L28;
    L30:
        boolean r10 = false;
    L31:
        if (r10 == true) goto L33;
    L41:
        if (r10 == false) goto L43;
        return;
    L43:
        if (this.R == false) goto L50;
        this.R = false;
        S(-1);
        return;
    L50:
        return;
    L33:
        if (this.R == true) goto L41;
        if (this.D == null) goto L41;
        this.R = true;
        BaseLinkSeatWindowView r11 = this.y;
        if (r11 == null) goto L46;
        RecyclerView r12 = r11.getRecyclerView();
        if (r12 == null) goto L47;
        r12.post(new c(this));
        return;
    L47:
        return;
    L46:
        return;
    L28:
        if (InteractiveSongContext.a.d(r0, r5, this.L1, false, 4) == false) goto L30;
        r10 = true;
        goto L31
    L18:
        r8 = null;
    L15:
        r7 = null;
        goto L16
    }

    public final void T() {
        if (vm2.c.b().getDismissKtvComponentLyricsAndMidiOnStageSubtitle() == true) goto L5;
        return;
    L5:
        IKtvComponentFeedView r0 = this.I;
        if (r0 == null) goto L8;
        boolean r1 = r0.getKtvComponentLyricsViewShowStatus();
    L9:
        boolean r3 = false;
        if (this.M == false) goto L12;
        int r2 = g0.a;
        boolean r4 = true;
    L13:
        boolean r5 = this.V0.e();
        if (r4 == true) goto L16;
    L19:
        boolean r6 = true ^ r3;
        if (r1 == r6) goto L25;
        IKtvComponentFeedView r7 = this.I;
        if (r7 == null) goto L26;
        r7.updateKtvComponentLyricsViewShowStatus(r6);
        return;
    L26:
        return;
    L25:
        return;
    L16:
        if (this.L0 == false) goto L19;
        if (r5 == false) goto L19;
        r3 = true;
        goto L19
    L12:
        r4 = false;
        goto L13
    L8:
        r1 = true;
        goto L9
    }

    public IKtvInteractFeedView getIKtvInteractFeedView() {
        return IInteractFeedView.DefaultImpls.getIKtvInteractFeedView(this);
    }

    public IMultiFeedView getIMultiFeedView() {
        return IInteractFeedView.DefaultImpls.getIMultiFeedView(this);
    }

    public IPkFeedView getIPkFeedView() {
        return IInteractFeedView.DefaultImpls.getIPkFeedView(this);
    }

    public List<String> getImCacheTags() {
        return IInteractFeedView.DefaultImpls.getImCacheTags(this);
    }

    public List<ILinkPlayerInfoBridge> getOnlineList() {
        return IInteractFeedView.DefaultImpls.getOnlineList(this);
    }

    public View getViewCompat() {
        return IInteractFeedView.DefaultImpls.getViewCompat(this);
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        return IInteractFeedView.DefaultImpls.observeFeedViewExposeData(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IPreviewPlayerContainerAbility r0 = this.G;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L9;
        ViewGroup.LayoutParams r3 = null;
    L10:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        if (r4 == null) goto L14;
        r4.topMargin = 0;
    L14:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == true) goto L16;
        ViewGroup.LayoutParams r5 = null;
    L17:
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
        if (r6 == null) goto L21;
        ((ViewGroup.MarginLayoutParams) r6).topMargin = 0;
    L21:
        if ((r2 instanceof RelativeLayout.LayoutParams) == false) goto L24;
        r1 = r2;
    L24:
        RelativeLayout.LayoutParams r7 = (RelativeLayout.LayoutParams) r1;
        if (r7 == null) goto L28;
        r7.topMargin = 0;
        return;
    L28:
        return;
    L16:
        r5 = r2;
        goto L17
    L9:
        r3 = r2;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final View getAnimRecyclerView() {
        return this.A;
    }

    public final BaseLinkSeatWindowView getBaseWindowView() {
        return this.y;
    }

    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.a getDynamicWidget() {
        return this.x1;
    }

    public final DataCenter getFeedDataCenter() {
        return this.v1;
    }

    public IKtvComponentFeedView getKtvComponentFeedView() {
        return this.I;
    }

    public final IRoom getMRoom() {
        return this.c;
    }

    public final ViewModelStore getMViewModelStore() {
        return this.k1;
    }

    public final Map<Integer, com.bytedance.android.live.liveinteract.plantform.commonwindow.m> getOriginLayoutConfigMap() {
        return this.k;
    }

    public final View getRecyclerView() {
        return this.z;
    }

    public final int getSeiVer() {
        return this.H1;
    }

    public final int getShowFrom() {
        return this.M1;
    }

    public final int getUiLayout() {
        return this.L1;
    }

    public final ViewModelProvider getViewModelProvider() {
        return this.p1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean k() {
        return this.M;
    }

    public final void onViewHolderUnBind() {
        IInteractFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final MessageHub p() {
        return this.m;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final IRoom r() {
        return this.c;
    }

    public static final void e(MultiLinkVoiceChatFeedView r14) {
        r14.getClass();
        IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
        if (r0 == null) goto L13;
        boolean r1 = true;
        if (r0.shouldUseNewLivePlayerLayout() != true) goto L13;
        int r2 = r14.M1;
        if (r2 != 2) goto L9;
    L14:
        if (r1 == false) goto L17;
        return;
    L17:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r14.M1) == false) goto L19;
        com.bytedance.android.live.liveinteract.utils.h.a(r14.G, r14.getContext(), r14.c);
        com.bytedance.android.live.liveinteract.utils.h.i(r14.x, r14.getMInteractPlayView(), r14.H1, r14.L1, r14.U, r14.M1, r14.getContext(), r14.c, null);
        return;
    L19:
        com.bytedance.android.live.liveinteract.utils.h.b(r14.G);
        com.bytedance.android.live.liveinteract.utils.h.k(r14.getContainerWidth(), r14.getContainerHeight(), r14.M1, r14.H1, r14.L1, r14.getContext(), r14.x, r14.getMInteractPlayView(), r14.c, r14.U, null, null, 3072);
        return;
    L9:
        if (r2 == 3) goto L14;
        if (r2 == 4) goto L14;
    L13:
        r1 = false;
        goto L14
    }

    public static final /* synthetic */ int f(MultiLinkVoiceChatFeedView r0) {
        return r0.getContainerHeight();
    }

    public static final /* synthetic */ int h(MultiLinkVoiceChatFeedView r0) {
        return r0.getContainerWidth();
    }

    public static final /* synthetic */ int j(MultiLinkVoiceChatFeedView r0) {
        return r0.getDragContainerStubHeight();
    }

    public static final /* synthetic */ ConstraintLayout m(MultiLinkVoiceChatFeedView r0) {
        return r0.getLinkmicSubtitleRootContainer();
    }

    public final void F(qb r5) {
        ng0.e r0 = this.f;
        if (r0 != null) goto L13;
        ConstraintLayout r1 = this.y;
        RadioTextBoardView r2 = null;
        if (r1 == null) goto L7;
        RadioTextBoardView r3 = (RadioTextBoardView) r1.findViewById(2131383612);
    L9:
        if ((r3 instanceof RadioTextBoardView) == false) goto L12;
        r2 = r3;
    L12:
        r0 = new ng0.e(r2, this.M1, this.v1);
        goto L13
    L7:
        r3 = null;
    L13:
        this.f = r0;
        if (r0.b() == true) goto L16;
        return;
    L16:
        if (this.f != null) goto L18;
    L39:
        ng0.e r4 = this.f;
        if (r4 == null) goto L48;
        r4.d(r5);
        return;
    L48:
        return;
    L18:
        if (ng0.e.c(r5) != true) goto L39;
        BaseLinkSeatWindowView r6 = this.y;
        int r7 = 0;
        if (r6 == null) goto L24;
        RecyclerView r8 = r6.getRecyclerView();
        if (r8 == null) goto L24;
        int r9 = r8.getChildCount();
    L25:
        if (r9 <= 0) goto L45;
        BaseLinkSeatWindowView r10 = this.y;
        if (r10 == null) goto L46;
        ug0.a r11 = r10.getRvLayoutManager();
        if (r11 == null) goto L47;
        Pair<Integer, Integer> r12 = r11.c(0);
        Pair<Integer, Integer> r13 = r11.a(0);
        BaseLinkSeatWindowView r14 = this.y;
        if (r14 == null) goto L35;
        RecyclerView r15 = r14.getRecyclerView();
        if (r15 == null) goto L35;
        r7 = r15.getTop();
    L35:
        ng0.e r16 = this.f;
        if (r16 == null) goto L43;
        r16.a((r7 + ((Number) r12.getSecond()).intValue()) + ((Number) r13.getSecond()).intValue(), r5);
        return;
    L43:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L24:
        r9 = 0;
        goto L25
    }

    public final boolean K(IRoom r5) {
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.c(r5) == false) goto L29;
        z5 r6 = r5.getLinkerDetail();
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(r6.getUiLayout());
    L9:
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.a(r7, false, false) == false) goto L30;
        IRoom r8 = this.c;
        if (r8 == null) goto L19;
        z5 r9 = r8.getLinkerDetail();
        if (r9 == null) goto L19;
        List r10 = r9.getPlayModes();
        if (r10 == null) goto L19;
        if (r10.contains(Long.valueOf(32)) != true) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L31;
        int r12 = g0.a;
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.M1) == true) goto L24;
        return false;
    L24:
        if (PadConfigUtils.c() == false) goto L26;
        return false;
    L26:
        if (FoldScreenUtils.f() == true) goto L34;
        return true;
    L34:
        return false;
    L31:
        return false;
    L19:
        r11 = false;
        goto L20
    L30:
        return false;
    L7:
        r7 = null;
        goto L9
    L29:
        return false;
    }

    public final void S(int r4) {
        Path r0 = new Path();
        com.bytedance.android.live.liveinteract.videotalk.utils.c r1 = this.D;
        if (r1 == null) goto L5;
        Path r2 = r1.a(r4, 0.0f, 0.0f);
    L6:
        r0.addPath(r2);
        if (vm2.h.h0().f() == false) goto L15;
        if (r4 < 0) goto L12;
        d0 r5 = this.F;
        if (r5 == null) goto L15;
        r5.k();
        goto L15
    L12:
        d0 r6 = this.F;
        if (r6 == null) goto L15;
        r6.n();
    L15:
        d0 r7 = this.F;
        if (r7 == null) goto L19;
        r7.o(r0);
        return;
    L19:
        return;
    L5:
        r2 = new Path();
        goto L6
    }

    public final void W(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(Integer.valueOf(r3.getUiLayout()), 0, 6) == true) goto L7;
    L14:
        View r4 = this.z;
        if (r4 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r4);
    L17:
        View r5 = this.A;
        if (r5 == null) goto L23;
        UtilityKotlinExtentionsKt.w(r5);
        return;
    L23:
        return;
    L7:
        if (com.bytedance.android.live.liveinteract.utils.h.e(this.M1) == false) goto L14;
        View r6 = this.z;
        if (r6 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r6);
    L11:
        View r7 = this.A;
        if (r7 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r7);
        return;
    }

    public final void Z(q2 r3) {
        getLinkmicSubtitleRootContainer().post(new k(this, r3));
    }

    public final View b(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.c
    public final void g(boolean r2) {
        this.L0 = r2;
        if (r2 == false) goto L15;
        HybridCard r3 = this.P;
        if (r3 == null) goto L12;
        if (r3 == null) goto L8;
        r3.release();
    L8:
        ConstraintLayout r4 = b(2131378052);
        if (r4 == null) goto L11;
        r4.removeView(this.P);
    L11:
        this.P = null;
    L12:
        UtilityKotlinExtentionsKt.t(getLinkmicSubtitleRootContainer());
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r5 = this.K;
        if (r5 == null) goto L15;
        r5.a();
    L15:
        T();
    }

    public final void monitorLayouts(String r1) {
        IInteractFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        post(new e(this));
    }

    public final void onKtvRoomSeiModel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView r0 = this.I;
        if (r0 == null) goto L6;
        r0.onSeiUpdatedRaw(r2);
        return;
    }

    public final void onSeiUpdated(SeiAppData r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (Lists.isEmpty(r12.getGrids()) == true) goto L84;
        String r0 = r12.getShowPlayer();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        this.J = r1;
        InteractiveSongContext.a r2 = InteractiveSongContext.Companion;
        InteractiveSongContext r3 = r2.getContext();
        if (r3 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.isShowPlayer();
        if (r4 == null) goto L18;
        if (r1 != ((Boolean) r4.getValue()).booleanValue()) goto L18;
    L23:
        JSONObject r5 = this.U;
        SeiCanvas r6 = r12.getCanvas();
        ch0.e r7 = null;
        String r8 = null;
        if (r6 == null) goto L26;
        Integer r9 = Integer.valueOf(r6.getWidth());
    L27:
        r5.put("width", r9);
        JSONObject r10 = this.U;
        SeiCanvas r11 = r12.getCanvas();
        if (r11 == null) goto L30;
        Integer r13 = Integer.valueOf(r11.getHeight());
    L31:
        r10.put("height", r13);
        com.bytedance.android.live.liveinteract.feed.datamerge.h r14 = this.o;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L34:
        int r15 = r12.getSubScene();
        ch0.a r16 = ch0.a.a(r14.c().e(), r12.getUiLayout(), r15, null, 4);
        com.bytedance.android.live.liveinteract.feed.datamerge.k r17 = r14.a;
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L37:
        r17.l(r16);
        this.e = r12.getUiLayout();
        BaseLinkSeatWindowView r18 = this.y;
        if (r18 == null) goto L40;
        r18.x = Integer.valueOf(r12.getSubUILayout());
    L40:
        IRenderView r19 = this.x;
        if (r19 == null) goto L43;
        setLivePlayerView(r19);
    L43:
        com.bytedance.android.live.liveinteract.feed.datamerge.h r20 = this.o;
        if (r20 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L46:
        r20.e(r12);
        FeedViewInteractSongDataHandler r21 = this.r;
        if (r21 == null) goto L70;
        IRoom r22 = this.c;
        if (r22 == null) goto L51;
        Long r23 = Long.valueOf(r22.getRoomId());
    L52:
        Intrinsics.checkNotNullParameter(r12, "sei");
        String r24 = r12.getChannelId();
        if (r23 == null) goto L55;
        String r25 = String.valueOf(r23.longValue());
    L57:
        if ((!Intrinsics.areEqual(r24, r25)) == false) goto L62;
        StringBuilder r26 = new StringBuilder("sei channel id wrong ");
        r26.append(r12.getChannelId());
        r26.append(" room ");
        if (r23 == null) goto L61;
        r8 = String.valueOf(r23.longValue());
    L61:
        r26.append(r8);
        ALogger.d("FeedViewInteractSongDataHandler", r26.toString());
        goto L70
    L62:
        r21.e = Integer.valueOf(r12.getSubUILayout());
        List<ch0.e> r27 = r21.c().o();
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator<T> r29 = r27.iterator();
    L64:
        if (r29.hasNext() == false) goto L66;
        ch0.e r30 = (ch0.e) r29.next();
        HashMap r31 = new HashMap(r30.d);
        r31.put("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_SUB_UI_LAYOUT", Integer.valueOf(r12.getSubUILayout()));
        r7 = ch0.e.a(r30, null, null, null, r31, 7);
        r28.add(r7);
        goto L64
    L66:
        com.bytedance.android.live.liveinteract.feed.datamerge.j.a r32 = new com.bytedance.android.live.liveinteract.feed.datamerge.j.a(true, r28, r7);
        if (r32.a == false) goto L70;
        r21.c().t(r32);
        goto L70
    L55:
        r25 = null;
        goto L57
    L51:
        r23 = null;
    L70:
        if (this.J == false) goto L75;
        if (r12.getUiLayout() != 28) goto L75;
        P();
        return;
    L75:
        if (this.E != null) goto L77;
    L78:
        N();
        G();
        return;
    L77:
        if (this.F == null) goto L78;
        return;
    L30:
        r13 = null;
        goto L31
    L26:
        r9 = null;
    L18:
        InteractiveSongContext r33 = r2.getContext();
        if (r33 == null) goto L23;
        com.bytedance.live.datacontext.m<Boolean> r34 = r33.isShowPlayer();
        if (r34 == null) goto L23;
        r34.setValue(Boolean.valueOf(this.J));
        goto L23
    L9:
        if (r0.equals("true") != true) goto L11;
        r1 = true;
        goto L12
    }

    public final void onSeiUpdatedRaw(String r1) {
        IInteractFeedView.DefaultImpls.onSeiUpdatedRaw(this, r1);
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IInteractFeedView.DefaultImpls.putImCacheContent(this, r2);
    }

    public final void sendMessage(List<? extends tlc.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        IInteractFeedView.DefaultImpls.sendMessage(this, r2);
    }

    public final void setAnimRecyclerView(View r1) {
        this.A = r1;
    }

    public final void setBaseWindowView(BaseLinkSeatWindowView r1) {
        this.y = r1;
    }

    public final void setDynamicWidget(com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1) {
        this.x1 = r1;
    }

    public final void setFeedDataCenter(DataCenter r1) {
        this.v1 = r1;
    }

    public void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        this.T = r2;
    }

    public final void setItemDecoration(BaseEqualGridItemDecoration r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.V = r2;
    }

    public void setLivePlayerClient(ILivePlayerClient r1) {
        this.H = r1;
    }

    public void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
        this.G = r1;
    }

    public void setLivePlayerView(IRenderView r1) {
        this.x = r1;
        post(new h(this));
    }

    public final void setMRoom(IRoom r1) {
        this.c = r1;
    }

    public final void setMViewModelStore(ViewModelStore r1) {
        this.k1 = r1;
    }

    public final void setRecyclerView(View r1) {
        this.z = r1;
    }

    public final void setSeiVer(int r1) {
        this.H1 = r1;
    }

    public final void setShowFrom(int r1) {
        this.M1 = r1;
    }

    public final void setUiLayout(int r1) {
        this.L1 = r1;
    }

    public final void setViewModelProvider(ViewModelProvider r1) {
        this.p1 = r1;
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IInteractFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public final void updateMessageHub(MessageHub r5) {
        Intrinsics.checkNotNullParameter(r5, "hub");
        this.m = r5;
        if (r5 == null) goto L8;
        String r0 = MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getKey();
        com.bytedance.android.live.liveinteract.feed.datamerge.c r1 = this.s;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cPositionDataHandler");
    L7:
        r5.addMessageListener(r0, r1);
    L8:
        MessageHub r6 = this.m;
        if (r6 == null) goto L14;
        String r2 = MessageType.LINK_MIC.getKey();
        com.bytedance.android.live.liveinteract.feed.datamerge.d r3 = this.t;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicSeatDataHandler");
    L13:
        r6.addMessageListener(r2, r3);
    L14:
        R();
        MessageHub r7 = this.m;
        xlc.a r4 = null;
        if ((r7 instanceof xlc.a) == true) goto L17;
        r7 = null;
    L17:
        xlc.a r8 = (xlc.a) r7;
        if (r8 == null) goto L20;
        r8.D(MessageType.LINK_MIC_PLAYMODE.getIntType(), this.S, "SubtitleStatusSubSyncKey");
    L20:
        xlc.a r9 = this.m;
        if ((r9 instanceof xlc.a) == false) goto L24;
        r4 = r9;
    L24:
        xlc.a r10 = r4;
        if (r10 == null) goto L28;
        r10.y(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this.S);
        return;
    }

    public final void updateMvControllerSei(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sei");
        Object r4 = null;
        if (StringsKt.contains$default(r8, "audio_mv_sei", false, 2, null) == false) goto L24;
        FeedViewAudioMVBackgroundDataHandler r5 = this.q;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewAudioMVBackgroundDataHandler");
    L7:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r8, "sei");
        if (StringsKt.contains$default(r8, "audio_mv_sei", false, 2, null) == false) goto L25;
        LiveSeiUtil.i.getClass();
        Object r9 = LiveSeiUtil.c(r8).get("audio_mv_sei");
        if ((r9 instanceof JSONObject) == false) goto L13;
        r4 = r9;
    L13:
        JSONObject r6 = (JSONObject) r4;
        if (r6 == null) goto L29;
        InteractiveSongMvManager r10 = r5.b;
        if (r10 != null) goto L19;
        return;
    L19:
        if (r10.g(r6, r5.c) != true) goto L27;
        InteractiveSongMvManager r11 = r5.b;
        if (r11 == null) goto L28;
        r11.d(true, false);
        return;
    L28:
        return;
    L27:
        return;
    L29:
        return;
    L25:
        return;
    }

    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateRadioSei(this, r2);
    }

    public final void updateRadioTextSei(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "sei");
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.M1) == false) goto L13;
        ng0.e r0 = this.f;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.a == false) goto L15;
        if (r3 == null) goto L16;
        RadioTextBoardView r1 = r0.c;
        if (r1 == null) goto L17;
        r1.R5(r3);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void updateRoom(IRoom r9) {
        Intrinsics.checkNotNullParameter(r9, PbRequest.SwitchType.ROOM);
        this.c = r9;
        com.bytedance.android.live.liveinteract.pre.a.c.a.c(r9, true);
        post(new i(this));
        IKtvComponentFeedView r0 = this.I;
        if (r0 == null) goto L5;
        r0.updateRoom(r9);
    L5:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.x1;
        if (r1 == null) goto L9;
        r1.updateRoom(r9);
    L9:
        if (B() == false) goto L11;
        H();
    L11:
        Q();
        J();
        if (this.p0 == false) goto L14;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == false) goto L23;
        this.p0 = true;
        LinkApi r3 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r4 = this.c;
        Intrinsics.checkNotNull(r4);
        Disposable r5 = r3.fetchPlayModeInfo(r4.getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this), p.a);
        if (r5 == null) goto L23;
        this.v.add(r5);
    L23:
        LinkApi r6 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r7 = this.c;
        Intrinsics.checkNotNull(r7);
        Disposable r8 = r6.getAudienceSingEnableSetting(r7.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(this), n.a);
        if (r8 == null) goto L27;
        this.v.add(r8);
    L27:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L34;
        FrameLayout r10 = this.B;
        if (r10 == null) goto L38;
        FeedViewAudioMVBackgroundDataHandler r11 = this.q;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewAudioMVBackgroundDataHandler");
    L33:
        Context r12 = getContext();
        DataCenter r13 = this.v1;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r10, "mvBg");
        InteractiveSongMvManager r14 = new InteractiveSongMvManager(r12, r13);
        r11.b = r14;
        r14.h(r10);
    L38:
        this.L0 = K(r9);
        f2.g();
        return;
    L34:
        FrameLayout r15 = new FrameLayout(getContext());
        zd0.c r16 = new zd0.c(r15);
        int r17 = vd0.a.g;
        vd0.a.C0284a.a(this.v1).b(3000, 3001, r16);
        FeedViewAudioMVBackgroundDataHandler r18 = this.q;
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewAudioMVBackgroundDataHandler");
    L37:
        Context r19 = r15.getContext();
        DataCenter r20 = this.v1;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r15, "mvBg");
        InteractiveSongMvManager r21 = new InteractiveSongMvManager(r19, r20);
        r18.b = r21;
        r21.h(r15);
        Unit r22 = Unit.INSTANCE;
        this.B = r15;
        goto L38
    L14:
        if (M() == false) goto L16;
    L17:
        r2 = true;
        goto L19
    L16:
        if (L() == false) goto L18;
        goto L17
    }

    public final void updateRoomBeforeSelect(IRoom r1) {
        this.c = r1;
    }

    public final void updateSpeechRecognitionSei(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sei");
        if (((Boolean) e2.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<fd2.v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L12;
        fd2.v r2 = (fd2.v) r1.getValue();
        if (r2 == null) goto L12;
        r2.onSei(r7);
    L12:
        LiveSeiUtil.i.getClass();
        JSONObject r8 = LiveSeiUtil.c(r7).optJSONObject("music_recognition_result");
        if (r8.optInt("state") != 1) goto L15;
        boolean r3 = true;
    L17:
        if (r8.has("emo_tag") == false) goto L19;
        String r4 = r8.optString("emo_tag");
    L21:
        if (r8.has("refrain") == false) goto L23;
        int r9 = r8.optInt("refrain");
    L24:
        this.g1 = r4;
        this.h1 = r9;
        if ((!Intrinsics.areEqual(this.P0, Boolean.valueOf(r3))) == false) goto L30;
        this.P0 = Boolean.valueOf(r3);
        JsonObject r10 = new JsonObject();
        r10.addProperty("type", Integer.valueOf(SubtitleEventType.SHOW_LYRICS.ordinal()));
        r10.addProperty("show_recognition_lyrics", Boolean.valueOf(r3));
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r5 = this.x1;
        if (r5 == null) goto L31;
        r5.Dk("audiochat_stage", "subtitle", r10, false);
        return;
    L31:
        return;
    L30:
        return;
    L23:
        r9 = 0;
        goto L24
    L19:
        r4 = "";
        goto L21
    L15:
        r3 = false;
        goto L17
    }

    public final void updateSpeechRhythmSei(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sei");
        if (vm2.c.g() == true) goto L5;
        return;
    L5:
        ALogger.i("VoiceChatFeedView", "updateSpeechRhythmSei, sei: " + r8);
        LiveSeiUtil.i.getClass();
        JSONObject r9 = LiveSeiUtil.c(r8);
        if (r9.has("music_beat_result") == false) goto L21;
        JSONObject r10 = JSONObjectProtectorUtils.getJSONObject(r9, "music_beat_result");
        float r1 = (float) r10.optDouble("beat");
        int r3 = r10.optInt("aed");
        if (r10.has("type") == false) goto L10;
        int r11 = r10.optInt("type");
    L11:
        JsonObject r5 = new JsonObject();
        r5.addProperty("type", Integer.valueOf(r11));
        r5.addProperty("beat", Float.valueOf(r1));
        r5.addProperty("aed", Integer.valueOf(r3));
        r5.addProperty("emo", this.g1);
        r5.addProperty("refrain", Integer.valueOf(this.h1));
        Float r12 = getCurrentFrameLightValue();
        if (r12 == null) goto L14;
        r5.addProperty("light", Float.valueOf(r12.floatValue()));
    L14:
        InteractiveSongContext r13 = InteractiveSongContext.Companion.getContext();
        if (r13 == null) goto L17;
        r13.setRecordeLastSpeechRhythmBeats(r5);
    L17:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r14 = this.x1;
        if (r14 == null) goto L22;
        r14.Dk("audiochat_stage", "speech_effect", r5, false);
        return;
    L22:
        return;
    L10:
        r11 = 0;
        goto L11
    }

    public final void updateSubtitleSei(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sei");
        if (B() == false) goto L30;
        if (this.M == false) goto L30;
        if (getLinkmicSubtitleRootContainer().getVisibility() != 8) goto L30;
        if (this.L0 == true) goto L30;
        UtilityKotlinExtentionsKt.w(getLinkmicSubtitleRootContainer());
        q2 r0 = this.O;
        if (r0 != null) goto L13;
        int r1 = LinkmicSubtitleUIWidget.x;
    L17:
        this.Q = r1;
        if (vm2.c.b().getSubtitlePatchLynxEnable() == true) goto L20;
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r2 = this.K;
        if (r2 == null) goto L30;
        r2.e.removeCallbacksAndMessages(null);
        r2.e.sendEmptyMessage(1);
        goto L30
    L20:
        if (this.P != null) goto L30;
        int r3 = g0.a;
        HybridCard r4 = g0.f(getContext(), this.Q);
        this.P = r4;
        if (r4 == null) goto L30;
        r4.setLayoutParams(new ConstraintLayout.LayoutParams(this.Q, LinkmicSubtitleUIWidget.u));
        ConstraintLayout r5 = b(2131378052);
        if (r5 == null) goto L30;
        r5.addView(r4);
        goto L30
    L13:
        if (r0.getSubtitleStyle() != LinkmicSubtitleStyle.LONG.ordinal()) goto L15;
        r1 = LinkmicSubtitleUIWidget.w;
        goto L17
    L15:
        r1 = LinkmicSubtitleUIWidget.x;
    L30:
        if (StringsKt.contains$default(r7, "audio_subtitle", false, 2, null) == false) goto L77;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r7) == true) goto L34;
    L73:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r7);
        return;
    L34:
        if (vm2.d.u() == true) goto L36;
    L75:
        String r6 = JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r7), "audio_subtitle");     // Catch: Exception -> L72
        if (r6 == null) goto L78;
        String r8 = JSONObjectProtectorUtils.getString(new JSONObject(r6), "subtitles");     // Catch: Exception -> L72
        if (r8 == null) goto L79;
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L72
        com.bytedance.android.live.liveinteract.feed.datamerge.b r10 = this.n;     // Catch: Exception -> L72
        if (r10 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");     // Catch: Exception -> L72
    L45:
        List r11 = (List) r10.a.getValue();     // Catch: Exception -> L72
        if (r11 == null) goto L51;
        Iterator r12 = r11.iterator();     // Catch: Exception -> L72
    L49:
        if (r12.hasNext() == false) goto L51;
        r9.add(((ch0.e) r12.next()).a);     // Catch: Exception -> L72
    L51:
        List<nj0.g> r13 = g0.e(r8, r9);     // Catch: Exception -> L72
        if (((ArrayList) r13).isEmpty() == false) goto L54;
        return;
    L54:
        g0.g(r13);     // Catch: Exception -> L72
        List<nj0.g> r14 = com.bytedance.android.live.liveinteract.voicechat.subtitle.r.b;     // Catch: Exception -> L72
        if (com.bytedance.android.live.liveinteract.voicechat.subtitle.r.a(this.L0, r13) == false) goto L57;
        return;
    L57:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.r.b(r13);     // Catch: Exception -> L72
        if (this.L0 == false) goto L64;
        int r15 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;     // Catch: Exception -> L72
        JsonObject r16 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r13);     // Catch: Exception -> L72
        r16.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));     // Catch: Exception -> L72
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r17 = this.x1;     // Catch: Exception -> L72
        if (r17 == null) goto L80;
        r17.Dk("audiochat_stage", "subtitle", r16, false);     // Catch: Exception -> L72
        return;
    L80:
        return;
    L64:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L68;
        int r18 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;     // Catch: Exception -> L72
        JsonObject r19 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r13);     // Catch: Exception -> L72
        r19.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));     // Catch: Exception -> L72
        r19.addProperty("biz_id", "audiochat_stage");     // Catch: Exception -> L72
        JsonObject r20 = new JsonObject();     // Catch: Exception -> L72
        r20.add("data", r19);     // Catch: Exception -> L72
        r20.addProperty("type", "subtitle");     // Catch: Exception -> L72
        HybridCard r21 = this.P;     // Catch: Exception -> L72
        if (r21 == null) goto L82;
        r21.sendJsEvent("onLinkmicStatusChange", r20);     // Catch: Exception -> L72
        return;
    L82:
        return;
    L68:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r22 = this.K;     // Catch: Exception -> L72
        if (r22 == null) goto L84;
        r22.b(r13);     // Catch: Exception -> L72
        return;
    L84:
        return;
    L79:
        return;
    L78:
        return;
    L72:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r7);
        return;
    L36:
        if (g0.d(r7) == true) goto L75;
    }

    public final void z(List<? extends tf0.e> r4) {
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        tf0.e r0 = (tf0.e) r5.next();
        if ((r0 instanceof MultiLinkGuestViewBinder.a) == true) goto L8;
        r0 = null;
    L8:
        MultiLinkGuestViewBinder.a r1 = (MultiLinkGuestViewBinder.a) r0;
        if (r1 == null) goto L4;
        ch0.e r2 = r1.k;
        if (r2 == null) goto L4;
        Map<String, Object> r3 = r2.d;
        if (r3 == null) goto L4;
        IRoom r6 = this.c;
        if (r6 == null) goto L18;
        Object r7 = r6.getAnchorId();
        if (r7 == null) goto L18;
    L19:
        r3.put("EXT_KEY_ANCHOR_ID", r7);
    L18:
        r7 = 0L;
        goto L19
    }

    public static final void o(MultiLinkVoiceChatFeedView r12, com.bytedance.android.live.network.response.e r13) {
        if (r12.M() == false) goto L87;
        int r0 = com.bytedance.android.live.liveinteract.aimv.b.a;
        InteractiveSongContext.Companion.g(true, true, com.bytedance.android.live.liveinteract.aimv.b.b(r12.c), String.valueOf(19));
        FeedViewInteractSongDataHandler r1 = r12.r;
        if (r1 == null) goto L7;
        r1.h = true;
    L7:
        k1 r2 = (k1) r13.data;
        if (r2 == null) goto L22;
        p2 r3 = r2.getLinkmicPlayModeInfo();
        if (r3 == null) goto L22;
        IOrderSingInfoV2 r4 = r3.getOrderSingInfo();
        if (r4 == null) goto L22;
        List<IUserMicrophoneItem> r5 = r4.getUserMicrophoneList();
        if (r5 == null) goto L22;
        FeedViewInteractSongDataHandler r6 = r12.r;
        if (r6 == null) goto L22;
        Intrinsics.checkNotNullParameter(r5, "userMicrophoneList");
        if (r6.b == false) goto L22;
        r6.c = r5;
        com.bytedance.android.live.liveinteract.feed.datamerge.j.a r7 = r6.b(r6.c().o());
        if (r7.a == false) goto L22;
        r6.c().t(r7);
    L22:
        k1 r8 = (k1) r13.data;
        IOrderSingMVInfo r9 = null;
        if (r8 == null) goto L64;
        p2 r10 = r8.getLinkmicPlayModeInfo();
        if (r10 == null) goto L64;
        IOrderSingInfoV2 r11 = r10.getOrderSingInfo();
        if (r11 == null) goto L64;
        List r14 = r11.getUserMicrophoneList();
        if (r14 == null) goto L64;
        Iterator r15 = r14.iterator();
    L32:
        if (r15.hasNext() == false) goto L64;
        IUserMicrophoneItem r16 = (IUserMicrophoneItem) r15.next();
        IBaseUser r17 = r16.getOrderUser();
        if (r17 == null) goto L36;
        String r18 = r17.getIdString();
    L37:
        int r19 = dg0.a.a;
        IMicrophoneItem r20 = dg0.a.a(r16.getMicrophoneList());
        if (r20 == null) goto L40;
        int r21 = r20.getMicroPhoneNum();
    L41:
        pf0.a r110 = new pf0.a(r18, r21, null, null, null, 28);
        InteractiveSongContext.a r22 = InteractiveSongContext.Companion;
        InteractiveSongContext r23 = r22.getContext();
        String r24 = "";
        if (r23 == null) goto L52;
        ConcurrentHashMap<String, pf0.a> r25 = r23.getGuestListInteractiveSongInfo();
        if (r25 == null) goto L52;
        IBaseUser r26 = r16.getOrderUser();
        if (r26 == null) goto L49;
        String r27 = r26.getIdString();
        if (r27 == null) goto L49;
    L50:
        pf0.a r28 = r25.put(r27, r110);
    L49:
        r27 = "";
    L52:
        if (r16.isSinging() == false) goto L32;
        InteractiveSongContext r29 = r22.getContext();
        if (r29 == null) goto L32;
        com.bytedance.live.datacontext.m<String> r30 = r29.getSingingGuestId();
        if (r30 == null) goto L32;
        IBaseUser r31 = r16.getOrderUser();
        if (r31 == null) goto L63;
        String r32 = r31.getIdString();
        if (r32 == null) goto L63;
        r24 = r32;
    L63:
        r30.setValue(r24);
        goto L32
    L40:
        r21 = 0;
        goto L41
    L36:
        r18 = null;
    L64:
        FeedViewAudioMVBackgroundDataHandler r111 = r12.q;
        if (r111 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewAudioMVBackgroundDataHandler");
    L67:
        k1 r112 = (k1) r13.data;
        if (r112 == null) goto L74;
        p2 r113 = r112.getLinkmicPlayModeInfo();
        if (r113 == null) goto L74;
        IOrderSingInfoV2 r114 = r113.getOrderSingInfo();
        if (r114 == null) goto L74;
        r9 = r114.getMvInfo();
    L74:
        InteractiveSongMvManager r115 = r111.b;
        if (r115 == null) goto L88;
        InteractiveSongMvManager.j(r115, r9, false);
        return;
    L88:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [android.view.ViewGroup, com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRecyclerView] */
    public static final void s(MultiLinkVoiceChatFeedView r3, com.bytedance.android.live.liveinteract.multiscene.a r4) {
        r3.getClass();
        StringBuilder r0 = new StringBuilder("AudioFeedView handleLinkDetail ");
        IRoom r1 = r3.c;
        LinkMicRecyclerView r2 = null;
        if (r1 == null) goto L7;
        z5 r5 = r1.getLinkerDetail();
        if (r5 == null) goto L7;
        List r6 = r5.getPlayModes();
    L8:
        r0.append(r6);
        ALogger.i("VoiceChatFeedView", r0.toString());
        if (r3.L() == false) goto L51;
        boolean r7 = li0.d.g(r4);
        r3.H0 = r7;
        if (r7 == true) goto L13;
        r3.L0 = false;
    L13:
        r3.post(new q(r3));
        if (r3.C(r3.L1, r3.H1) == 21) goto L16;
    L28:
        BaseLinkSeatWindowView r8 = r3.y;
        if (r8 == null) goto L31;
        LinkMicRecyclerView r9 = r8.getRecyclerView();
    L33:
        if ((r9 instanceof VoiceChatRecyclerView) == false) goto L36;
        r2 = r9;
    L36:
        VoiceChatRecyclerView r10 = (VoiceChatRecyclerView) r2;
        if (r10 == null) goto L40;
        r10.t();
    L40:
        if (r3.H0 == true) goto L42;
        return;
    L42:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r3.M1) == false) goto L53;
        int r11 = vm2.h.V().a();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12 = r3.j;
        if (r12 == null) goto L54;
        int r13 = r3.getContainerWidth();
        int r14 = r3.getContainerHeight();
        if (r11 <= 0) goto L48;
        r3.y(r13, r14, r12);
    L49:
        r3.y1 = r11;
        return;
    L48:
        r3.y(r13, r14, r12);
        goto L49
    L54:
        return;
    L53:
        return;
    L31:
        r9 = null;
        goto L33
    L16:
        if (r3.H0 == true) goto L28;
        BaseLinkSeatWindowView r15 = r3.y;
        if (r15 == null) goto L20;
        LinkMicRecyclerView r16 = r15.getRecyclerView();
    L22:
        if ((r16 instanceof VoiceChatRecyclerView) == false) goto L25;
        r2 = r16;
    L25:
        ?? r17 = (VoiceChatRecyclerView) r2;
        if (r17 == 0) goto L40;
        r17.l = true;
        r17.m = true;
        r17.invalidate();
        goto L40
    L20:
        r16 = null;
        goto L22
    L51:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public static final void u(MultiLinkVoiceChatFeedView r6, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r7) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = r6.j;
        r6.j = r7;
        if (r7 == null) goto L24;
        Intrinsics.checkNotNull(r7);
        r6.V(r7, r6.getContainerWidth(), r6.getContainerHeight());
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = r6.j;
        Intrinsics.checkNotNull(r1);
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r2 = r1.h();
        if (r2 == null) goto L8;
        int r3 = r2.size();
    L9:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4 = r6.j;
        Intrinsics.checkNotNull(r4);
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r5 = r4.k();
        if (r5 == null) goto L12;
        int r8 = r5.size();
    L13:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r9 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r3 + r8);
        com.bytedance.android.live.liveinteract.feed.datamerge.i r10 = r6.u;
        if (r10 == null) goto L16;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11 = r6.j;
        Intrinsics.checkNotNull(r11);
        r10.A(r9, r11);
    L16:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12 = r6.j;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.m();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r14 = r6.j;
        Intrinsics.checkNotNull(r14);
        Pair r15 = ug0.b.b(r13, r14.getUiLayout(), r6.getContainerWidth(), r6.getContainerHeight());
        BaseLinkSeatWindowView r16 = r6.y;
        if (r16 == null) goto L19;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r17 = r6.j;
        Intrinsics.checkNotNull(r17);
        r16.U3(r17, ((Number) r15.getFirst()).intValue(), ((Number) r15.getSecond()).intValue());
    L19:
        BaseLinkSeatWindowView r18 = r6.y;
        if (r18 == null) goto L22;
        r18.b7(0);
    L22:
        int r19 = r6.getContainerWidth();
        int r20 = r6.getContainerHeight();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r21 = r6.j;
        Intrinsics.checkNotNull(r21);
        r6.D = r6.A(r21, r19, r20);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r22 = r6.j;
        Intrinsics.checkNotNull(r22);
        r6.O(r0, r22);
        r6.x(r7, r6.getContainerWidth(), r6.getContainerHeight());
        return;
    L12:
        r8 = 0;
        goto L13
    L8:
        r3 = 0;
        goto L9
    }

    public static final void v(MultiLinkVoiceChatFeedView r11, int r12) {
        r11.getClass();
        if (r11.l == r12) goto L18;
        if (r12 >= 0) goto L7;
        return;
    L7:
        if (r12 > 9) goto L19;
        r11.l = r12;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = r11.j;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.getUiLayout() != 2) goto L17;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = r11.j;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.m();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = r11.j;
        Intrinsics.checkNotNull(r3);
        Pair r4 = ug0.b.b(r2, r3.getUiLayout(), r11.getContainerWidth(), r11.getContainerHeight());
        ln0.a r5 = yg0.h.a;
        yg0.h.g(r12, new z(r11, r12), false, new pn0.i(false), new Triple(r4.getFirst(), r4.getSecond(), "MultiLinkVoiceChatFeedView#updateLinkWindowLayoutConfigForDynamicEqual, with windowCount = " + r12), r11.getLivePlayerVideoSize(), null, r11.v1, 196);
        return;
    L17:
        return;
    L19:
        return;
    }

    public final int C(int r5, int r6) {
        IRoom r7 = this.c;
        if (r7 == null) goto L13;
        z5 r8 = r7.getLinkerDetail();
        if (r8 == null) goto L13;
        List r9 = r8.getPlayModes();
        if (r9 == null) goto L13;
        if (r9.contains(Long.valueOf(7)) != true) goto L13;
        if (this.H0 == true) goto L13;
        return 21;
    L13:
        if (r5 <= 0) goto L15;
        return r5;
    L15:
        IRoom r10 = this.c;
        if (r10 == null) goto L24;
        z5 r11 = r10.getLinkerDetail();
        if (r11 == null) goto L24;
        List r12 = r11.getPlayModes();
        if (r12 == null) goto L24;
        if (r12.contains(Long.valueOf(24)) != true) goto L24;
        return 21;
    L24:
        IRoom r13 = this.c;
        if (r13 == null) goto L34;
        z5 r14 = r13.getLinkerDetail();
        if (r14 == null) goto L35;
        List r15 = r14.getPlayModes();
        if (r15 != null) goto L31;
        return 21;
    L31:
        if (r15.contains(Long.valueOf(26)) != true) goto L37;
        return 22;
    L37:
        return 21;
    L35:
        return 21;
    L34:
        return 21;
    }

    public final void O(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r13, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r14) {
        if (r13 != null) goto L4;
    L8:
        int r3 = r14.j();
        int r4 = r14.getUiLayout();
        List r5 = CollectionsKt.emptyList();
        if (r13 == null) goto L11;
        int r6 = r13.j();
    L12:
        if (r13 == null) goto L14;
        int r7 = r13.getUiLayout();
    L15:
        nh0.f r1 = new nh0.f("linkmic", new nh0.e(r3, r4, r5, r6, r7, CollectionsKt.emptyList(), null, null, 192), null, null, null, null, false, 224);
        DataCenter r15 = this.v1;
        if (r15 == null) goto L18;
        r15.put("data_multi_lick_dynamic_event_change", r1);
    L18:
        W(r14);
        return;
    L14:
        r7 = -1;
        goto L15
    L11:
        r6 = -1;
        goto L12
    L4:
        if (r13.j() != r14.j()) goto L8;
        if (r13.getUiLayout() != r14.getUiLayout()) goto L8;
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        this.W = r1;
    }

    public final void onScreenSizeChange(int r1, int r2) {
        IInteractFeedView.DefaultImpls.onScreenSizeChange(this, r1, r2);
    }

    public final void onWrdsDataUpdate(String r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "syncKey");
        FeedViewAudioMVBackgroundDataHandler r1 = this.q;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewAudioMVBackgroundDataHandler");
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "syncKey");
        IOrderSingMVInfo r5 = null;
        if (Intrinsics.areEqual(r8, "OrderSingSyncData") == true) goto L8;
    L22:
        FeedViewInteractSongDataHandler r2 = this.r;
        if (r2 == null) goto L55;
        Intrinsics.checkNotNullParameter(r8, "syncKey");
        if (Intrinsics.areEqual(r8, "OrderSingSyncData") == false) goto L35;
        if ((r9 instanceof IOrderSingSyncData) == true) goto L29;
        r9 = null;
    L29:
        IOrderSingSyncData r10 = (IOrderSingSyncData) r9;
        if (r10 == null) goto L32;
        r5 = r10.getMvInfo();
    L32:
        if (r5 == null) goto L56;
        r10.getMvInfo();
        return;
    L56:
        return;
    L35:
        if (Intrinsics.areEqual(r8, MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA.getSyncKey()) == true) goto L37;
        return;
    L37:
        if ((r9 instanceof IRoomLinkMicSyncData) == true) goto L39;
        r9 = null;
    L39:
        IRoomLinkMicSyncData r11 = (IRoomLinkMicSyncData) r9;
        if (r11 == null) goto L62;
        int r12 = com.bytedance.android.live.liveinteract.aimv.b.a;
        boolean r13 = com.bytedance.android.live.liveinteract.aimv.b.b((IRoom) r2.k.invoke());
        com.bytedance.android.live.liveinteract.plantform.model.q r0 = r11.getLinkerBaseInfo();
        if (r0 != null) goto L45;
        return;
    L45:
        if (r0.getScene() != 5) goto L60;
        com.bytedance.android.live.liveinteract.plantform.model.q r14 = r11.getLinkerBaseInfo();
        if (r14 == null) goto L53;
        List<Long> r15 = r14.getPlayModes();
        if (r15 == null) goto L53;
        if (r15.contains(Long.valueOf(19)) != true) goto L53;
        InteractiveSongContext.Companion.g(true, true, r13, String.valueOf(19));
        r2.h = true;
        return;
    L53:
        InteractiveSongContext.Companion.g(false, false, r13, "");
        r2.h = false;
        return;
    L60:
        return;
    L62:
        return;
    L55:
        return;
    L8:
        if ((r9 instanceof IOrderSingSyncData) == true) goto L10;
        Object r3 = null;
    L11:
        IOrderSingSyncData r4 = (IOrderSingSyncData) r3;
        if (r4 == null) goto L14;
        IOrderSingMVInfo r6 = r4.getMvInfo();
    L15:
        if (r6 == null) goto L19;
        IOrderSingMVInfo r7 = r4.getMvInfo();
        InteractiveSongMvManager r16 = r1.b;
        if (r16 == null) goto L22;
        InteractiveSongMvManager.j(r16, r7, false);
        goto L22
    L19:
        InteractiveSongMvManager r17 = r1.b;
        if (r17 == null) goto L22;
        r17.c();
        goto L22
    L14:
        r6 = null;
        goto L15
    L10:
        r3 = r9;
        goto L11
    }

    public final void refreshSeiCanvasAndSeiVersion(JSONObject r4, Integer r5) {
        JSONObject r6 = this.U;
        Integer r0 = null;
        if (r4 == null) goto L5;
        Integer r2 = Integer.valueOf(r4.optInt("width"));
    L6:
        r6.put("width", r2);
        JSONObject r7 = this.U;
        if (r4 == null) goto L9;
        r0 = Integer.valueOf(r4.optInt("height"));
    L9:
        r7.put("height", r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void updateSeiVerAndUiLayout(int r14, int r15) {
        this.H1 = r14;
        this.L1 = r15;
        int r1 = C(r15, r14);
        Pair r16 = ug0.b.b(r14, r1, getContainerWidth(), getContainerHeight());
        Triple r8 = new Triple(r16.getFirst(), r16.getSecond(), "MultiLinkVoiceChatFeedView#updateSeiVerAndUiLayout");
        ln0.a r17 = yg0.h.a;
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r1, 0, null, false, this.l, false, new pn0.i(false), r8, null, null, this.v1, 782), new j(this, r15), null);
        IRoom r18 = this.c;
        if (r18 == null) goto L6;
        this.L0 = K(r18);
        return;
    }

    public static final void t(MultiLinkVoiceChatFeedView r17, int r18, int r19) {
        if (r17.h == true) goto L21;
        r17.h = true;
        int r6 = r17.C(r17.L1, r17.H1);
        ArrayList r7 = new ArrayList();
        IRoom r3 = r17.c;
        if (r3 == null) goto L16;
        z5 r4 = r3.getLinkerDetail();
        if (r4 == null) goto L16;
        List r5 = r4.getPlayModes();
        if (r5 == null) goto L16;
        Iterator r8 = r5.iterator();
    L13:
        if (r8.hasNext() == false) goto L16;
        r7.add(Integer.valueOf((int) ((Number) r8.next()).longValue()));
    L16:
        if (r17.H0 == false) goto L18;
        r7.remove(7);
    L18:
        Pair r9 = ug0.b.b(r17.H1, r6, r18, r19);
        Triple r13 = new Triple(r9.getFirst(), r9.getSecond(), "MultiLinkVoiceChatFeedView#tryAdjustWindowUI");
        ln0.a r10 = yg0.h.a;
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.t(r6, r7, 0, false, r17.l, false, new pn0.i(false), r13, null, r17.v1, 540), new y(r17, r18, r19), null);
        return;
    }

    public final com.bytedance.android.live.liveinteract.videotalk.utils.h A(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        r3.q(r5);
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.o(this.M1, r4, r5) == false) goto L5;
        int r1 = (int) (r5 * 0.5625f);
    L6:
        r3.s(r1, r5);
        return com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r4, r5, r3);
    L5:
        r1 = r4;
        goto L6
    }

    public final void V(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Pair r6 = ug0.b.b(r3.m(), r3.getUiLayout(), r4, r5);
        Triple r7 = new Triple(r6.getFirst(), r6.getSecond(), "MultiLinkVoiceChatFeedView#updateLayoutConfigResultIfNeed");
        Pair<Integer, Integer> r8 = getLivePlayerVideoSize();
        ln0.a r0 = yg0.h.a;
        r3.d = yg0.h.a(r3, r7, r8);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b.a.a(r2, r3, (l0) r4);
    }

    public final void x(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Pair<Integer, Integer> r0 = D(r3.m(), r3.getUiLayout(), r4, r5);
        int r1 = ((Number) r0.getFirst()).intValue();
        int r2 = ((Number) r0.getSecond()).intValue();
        V(r3, r4, r5);
        BaseLinkSeatWindowView r6 = this.y;
        if (r6 == null) goto L5;
        r6.Yd(r3, r1, r2);
    L5:
        BaseLinkSeatWindowView r7 = this.y;
        if (r7 == null) goto L8;
        r7.Sp(r3, r1, r2);
    L8:
        BaseLinkSeatWindowView r8 = this.y;
        if (r8 == null) goto L14;
        RecyclerView r9 = r8.getRecyclerView();
        if (r9 == null) goto L15;
        r9.post(new b(this, r3, r1, r2));
        return;
    L15:
        return;
    }

    public final void y(int r43, int r44, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r45) {
        this.j = r45;
        if (r45 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r45);
        this.V = new MultiLinkCommonItemDecoration(r45, s1.f(2.0f), new ColorDrawable(s1.h(2131108427)));
        int r1 = re0.a.a;
        int r2 = this.M1;
        se0.c r11 = new se0.c();
        int r17 = se0.d.f;
        int r18 = se0.d.g;
        int r10 = se0.d.h;
        int r19 = se0.d.i;
        float r28 = se0.d.j;
        int r12 = se0.d.q;
        int r13 = se0.d.k;
        new se0.a(r17, r18, r10, r19, r28, r12, r13);
        int r30 = se0.d.l;
        int r31 = se0.d.m;
        int r3 = se0.d.n;
        int r32 = se0.d.o;
        float r41 = se0.d.p;
        int r39 = se0.d.r;
        new se0.a(r30, r31, r3, r32, r41, r39, r13);
        new se0.a(se0.d.a, se0.d.b, se0.d.c, se0.d.d, se0.d.e, r12, r13);
        if (1 != r2) goto L8;
    L15:
        UtilityKotlinExtentionsKt.i(19);
        UtilityKotlinExtentionsKt.h(1.5f);
        UtilityKotlinExtentionsKt.h(1.5f);
        UtilityKotlinExtentionsKt.h(0.5f);
        UtilityKotlinExtentionsKt.h(0.5f);
    L16:
        r11.a = new se0.b(r17, r18, r19, r10, r10, r10, r10, r10, r10, r12, r10, r28);
        r11.b = new se0.b(r30, r31, r32, r3, r3, r3, r3, r3, r3, r39, r3, r41);
        s1.y();
        IRoom r4 = this.c;
        Boolean r16 = null;
        if (r4 == null) goto L21;
        z5 r5 = r4.getLinkerDetail();
        if (r5 == null) goto L21;
        List r6 = r5.getPlayModes();
    L22:
        if (r6 != null) goto L24;
    L40:
        if (r6 != null) goto L42;
    L44:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r7 = this.j;
        Intrinsics.checkNotNull(r7);
        V(r7, r43, r44);
        BaseLinkSeatWindowView r8 = this.y;
        if (r8 == null) goto L50;
        IRoom r9 = this.c;
        DataCenter r14 = this.v1;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r15 = this.j;
        Intrinsics.checkNotNull(r15);
        BaseEqualGridItemDecoration r20 = this.V;
        if (r20 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
    L49:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.b(r8, r9, r14, r15, r20, null, null, r43, r44, this.M1, r11, null, 1024);
    L50:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r21 = this.j;
        Intrinsics.checkNotNull(r21);
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r22 = r21.h();
        int r23 = 0;
        if (r22 == null) goto L53;
        int r24 = r22.size();
    L54:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r25 = r21.k();
        if (r25 == null) goto L57;
        r23 = r25.size();
    L57:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r26 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r24 + r23);
        IRoom r27 = this.c;
        DataCenter r29 = this.v1;
        com.bytedance.android.live.liveinteract.feed.datamerge.b r33 = this.n;
        if (r33 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L60:
        com.bytedance.android.live.liveinteract.feed.datamerge.i r34 = new com.bytedance.android.live.liveinteract.feed.datamerge.i(r27, r29, r21, r26, r33, this.M1);
        this.u = r34;
        r34.x(this.c);
        com.bytedance.android.live.liveinteract.feed.datamerge.i r35 = this.u;
        if (r35 == null) goto L67;
        BehaviorSubject<List<tf0.e>> r36 = r35.b;
        if (r36 == null) goto L67;
        Observable r37 = RxUtilKt.h(r36);
        if (r37 == null) goto L67;
        Disposable r38 = r37.subscribe(new v(this));
    L68:
        if (r38 == null) goto L70;
        this.v.add(r38);
    L70:
        com.bytedance.android.live.liveinteract.feed.datamerge.i r40 = this.u;
        if (r40 == null) goto L79;
        BehaviorSubject<List<tf0.e>> r42 = r40.b;
        if (r42 == null) goto L79;
        Observable r46 = RxUtilKt.h(r42);
        if (r46 == null) goto L79;
        Disposable r47 = r46.subscribe(new x(this));
        if (r47 == null) goto L79;
        RxUtilKt.c(r47, this.v);
    L79:
        com.bytedance.android.live.liveinteract.feed.datamerge.i r48 = this.u;
        if (r48 == null) goto L88;
        BehaviorSubject<List<tf0.e>> r49 = r48.b;
        if (r49 == null) goto L88;
        List<? extends tf0.e> r50 = (List) r49.getValue();
        if (r50 == null) goto L88;
        z(r50);
        BaseLinkSeatWindowView r51 = this.y;
        if (r51 == null) goto L88;
        r51.O7(r50);
    L88:
        N();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r52 = this.j;
        Intrinsics.checkNotNull(r52);
        this.D = A(r52, r43, r44);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r53 = this.j;
        Intrinsics.checkNotNull(r53);
        x(r53, r43, r44);
        ConstraintLayout r54 = this.y;
        if (r54 == null) goto L91;
        int r55 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r54, new MultiLinkVoiceChatFeedView$adjustWindowUI$1(this));
    L91:
        w();
        IRoom r56 = this.c;
        if (r56 == null) goto L99;
        IRoomBasisData r57 = r56.getBasisRoomData();
        if (r57 == null) goto L97;
        r16 = r57.isCustomizeAudioRoom();
    L97:
        if (Intrinsics.areEqual(r16, Boolean.TRUE) == false) goto L99;
        P();
    L99:
        W(this.j);
        return;
    L67:
        r38 = null;
        goto L68
    L53:
        r24 = 0;
        goto L54
    L42:
        if (r6.contains(Long.valueOf(7)) != true) goto L44;
        Unit r58 = Unit.INSTANCE;
        goto L44
    L24:
        if (r6.contains(Long.valueOf(5)) != true) goto L40;
        se0.b r59 = r11.a;
        if (r59 == null) goto L28;
        r59.a = 2131251692;
    L28:
        if (r59 == null) goto L31;
        int r110 = r10 / 2;
    L31:
        if (r59 == null) goto L33;
        r59.b = getContext().getString(2131917241);
    L33:
        se0.b r60 = r11.b;
        if (r60 == null) goto L36;
        r60.a = 2131251692;
    L36:
        if (r60 == null) goto L38;
        int r61 = r3 / 2;
    L38:
        if (r60 == null) goto L40;
        r60.b = getContext().getString(2131917241);
    L21:
        r6 = null;
        goto L22
    L8:
        if (9 == r2) goto L15;
        if (LinkFeedTypeConstant.Companion.isHotsoonFollowAndCity(r2) == true) goto L15;
        if (5 != r2) goto L14;
        UtilityKotlinExtentionsKt.i(32);
        UtilityKotlinExtentionsKt.i(2);
        UtilityKotlinExtentionsKt.i(2);
        UtilityKotlinExtentionsKt.i(1);
        UtilityKotlinExtentionsKt.i(1);
        goto L16
    L14:
        UtilityKotlinExtentionsKt.i(42);
        UtilityKotlinExtentionsKt.i(3);
        UtilityKotlinExtentionsKt.i(3);
        UtilityKotlinExtentionsKt.i(2);
        UtilityKotlinExtentionsKt.i(2);
        goto L16
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [android.view.ViewGroup, com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView] */
    public MultiLinkVoiceChatFeedView(Context r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        View r0 = null;
        boolean r1 = false;
        super(r7, null, 0);
        this.H1 = r8;
        this.L1 = r9;
        this.M1 = r10;
        this.a = new LinkedHashMap();
        this.k = new LinkedHashMap();
        CompositeDisposable r11 = new CompositeDisposable();
        this.v = r11;
        this.w = new CompositeDisposable();
        this.S = new t(this);
        this.U = new JSONObject();
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g r12 = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g();
        r12.f();
        Unit r13 = Unit.INSTANCE;
        this.V0 = r12;
        this.b1 = new HashMap();
        this.g1 = "";
        com.bytedance.android.live.liveinteract.pre.a.c.a.a(hashCode(), this.H1);
        VerticalNitaInflate.a(VerticalNitaInflate.Tag.CommonMultiLinkFeedView_container.name(), getResourceLayout(), r7, this, true);
        this.h = false;
        ?? r14 = (BaseLinkSeatWindowView) findViewById(2131378011);
        this.y = r14;
        if (r14 == 0) goto L5;
        View r15 = r14.findViewById(2131378009);
    L6:
        this.z = r15;
        ConstraintLayout r16 = this.y;
        if (r16 == null) goto L9;
        r0 = r16.findViewById(2131378008);
    L9:
        this.A = r0;
        this.B = (FrameLayout) findViewById(2131375554);
        this.C = (RadioDarkMaskView) findViewById(2131383598);
        this.n = new com.bytedance.android.live.liveinteract.feed.datamerge.b(this.m, this.M1);
        this.o = new com.bytedance.android.live.liveinteract.feed.datamerge.h(new r(this));
        ArrayList r17 = new ArrayList();
        com.bytedance.android.live.liveinteract.feed.datamerge.h r2 = this.o;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L12:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r4 = this.n;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L15:
        r2.d(r4);
        r17.add(r2);
        this.p = new com.bytedance.android.live.liveinteract.feed.datamerge.g(r17);
        this.q = new FeedViewAudioMVBackgroundDataHandler();
        this.r = new FeedViewInteractSongDataHandler(new MultiLinkVoiceChatFeedView$initFeedViewDataMergeCenter$2(this), new MultiLinkVoiceChatFeedView$initFeedViewDataMergeCenter$3(this));
        FrameLayout r18 = (FrameLayout) findViewById(2131362410);
        FeedViewInteractSongDataHandler r3 = this.r;
        if (r3 == null) goto L18;
        r3.e(r18);
    L18:
        this.s = new com.bytedance.android.live.liveinteract.feed.datamerge.c();
        this.t = new com.bytedance.android.live.liveinteract.feed.datamerge.d();
        com.bytedance.android.live.liveinteract.feed.datamerge.b r19 = this.n;
        if (r19 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L21:
        com.bytedance.android.live.liveinteract.feed.datamerge.h r5 = this.o;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L24:
        r19.u(r5);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r110 = this.n;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L27:
        com.bytedance.android.live.liveinteract.feed.datamerge.g r6 = this.p;
        if (r6 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("onlineUserListHandler");
    L30:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r20 = this.n;
        if (r20 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L33:
        r6.d(r20);
        r110.u(r6);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r111 = this.n;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L36:
        FeedViewAudioMVBackgroundDataHandler r21 = this.q;
        if (r21 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewAudioMVBackgroundDataHandler");
    L39:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r22 = this.n;
        if (r22 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L42:
        r21.d(r22);
        r111.u(r21);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r112 = this.n;
        if (r112 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L45:
        FeedViewInteractSongDataHandler r23 = this.r;
        Intrinsics.checkNotNull(r23);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r24 = this.n;
        if (r24 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L48:
        r23.d(r24);
        r112.u(r23);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r113 = this.n;
        if (r113 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L51:
        com.bytedance.android.live.liveinteract.feed.datamerge.c r25 = this.s;
        if (r25 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("cPositionDataHandler");
    L54:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r26 = this.n;
        if (r26 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L57:
        r25.d(r26);
        r113.u(r25);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r114 = this.n;
        if (r114 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L60:
        com.bytedance.android.live.liveinteract.feed.datamerge.d r27 = this.t;
        if (r27 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicSeatDataHandler");
    L63:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r28 = this.n;
        if (r28 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L66:
        r27.d(r28);
        r114.u(r27);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r115 = this.n;
        if (r115 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L69:
        r11.add(r115.a.subscribe(new s(this)));
        IKtvComponentFeedView r29 = jc1.k.n(IKtvService.class).getKtvComponentFeedView(r7, false);
        this.I = r29;
        ConstraintLayout.LayoutParams r30 = com.bytedance.android.live.liveinteract.utils.h.c(this.H1, 2131378011);
        if (r29 == null) goto L73;
        r29.setAttachParent((ViewGroup) findViewById(2131384822), r30);
    L73:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L75;
    L77:
        if (r1 == false) goto L82;
        IInteractService r31 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r31 == null) goto L83;
        r31.preloadDynamicContainer(s1.getContext());
        return;
    L83:
        return;
    L82:
        return;
    L75:
        if (vm2.h.i().enablePreLoadDynamicContainerOnFeedView() == false) goto L77;
        r1 = true;
        goto L77
    L5:
        r15 = null;
        goto L6
    }

    public final Pair<Integer, Integer> D(int r1, int r2, int r3, int r4) {
        return ug0.b.b(r1, r2, r3, r4);
    }
}
