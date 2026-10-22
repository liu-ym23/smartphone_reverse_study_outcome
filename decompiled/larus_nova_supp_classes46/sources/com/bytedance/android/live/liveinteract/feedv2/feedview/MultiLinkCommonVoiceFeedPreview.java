package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.e2;
import com.bytedance.android.live.core.setting.s2;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVContext;
import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVManager;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.panel.InteractiveSongMvManager;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.VoiceCommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.MultiLinkCommonItemDecoration;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.radio.RadioDarkMaskView;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleUIWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.SubtitleRecyclerView;
import com.bytedance.android.live.ui.ClipImageView;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.jb0;
import com.bytedance.android.livesdk.config.kb0;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.LinkmicRoomSongMessage;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.l9;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingInfoV2;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.IUserMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.IKtvComponentFeedViewManager;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import zg1.v1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001uJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tH\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\n\u0010%\u001a\u0004\u0018\u00010#H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J(\u0010+\u001a\"\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)\u0018\u00010(j\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)\u0018\u0001`*H\u0016R&\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020-0,8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010A\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010H\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010L\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010C\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010GR$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010l\u001a\u0004\u0018\u00010e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010t\u001a\u00020m8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010s¨\u0006v"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVoiceFeedPreview;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/liveinteract/feedv2/feedview/a;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/b;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/c;", "Lpn0/i;", "getLayoutConfigRequestExtra", "", "", "getPlayModes", "Ltf0/e;", "data", "", "setRadioStageVisible", "Lkotlin/Pair;", "", "getLivePlayerVideoSize", "getContainerWidth", "getContainerHeight", "", "getCurrentFrameLightValue", "()Ljava/lang/Float;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLinkmicSubtitleRootContainer", "Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/SubtitleRecyclerView;", "getLinkmicSubtitleRecyclerView", "getDragContainerStubHeight", "getLinkmicSubtitleHeight", "", "getFeedViewName", "getMicSeatRvViewId", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getLinkmicSeatListInfo", "Landroid/view/View;", "getViewCompat", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getChatRoomEnterRoomExtraParam", "", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "e", "Ljava/util/Map;", "getOriginLayoutConfigMap", "()Ljava/util/Map;", "originLayoutConfigMap", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "g", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "getBaseWindowView", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "setBaseWindowView", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;)V", "baseWindowView", "h", "Landroid/widget/FrameLayout;", "getBaseWindowViewContainer", "()Landroid/widget/FrameLayout;", "setBaseWindowViewContainer", "(Landroid/widget/FrameLayout;)V", "baseWindowViewContainer", "j", "Landroid/view/View;", "getRecyclerView", "()Landroid/view/View;", "setRecyclerView", "(Landroid/view/View;)V", "recyclerView", "k", "getAnimRecyclerView", "setAnimRecyclerView", "animRecyclerView", "Landroidx/lifecycle/ViewModelStore;", "C", "Landroidx/lifecycle/ViewModelStore;", "getMViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setMViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "mViewModelStore", "Landroidx/lifecycle/ViewModelProvider;", "D", "Landroidx/lifecycle/ViewModelProvider;", "getViewModelProvider", "()Landroidx/lifecycle/ViewModelProvider;", "setViewModelProvider", "(Landroidx/lifecycle/ViewModelProvider;)V", "viewModelProvider", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "E", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getFeedDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setFeedDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "feedDataCenter", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "F", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "getDynamicWidget", "()Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "setDynamicWidget", "(Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;)V", "dynamicWidget", "", "N", "Z", "getSubtitleIsOpen", "()Z", "setSubtitleIsOpen", "(Z)V", "subtitleIsOpen", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkCommonVoiceFeedPreview extends FrameLayout implements com.bytedance.android.live.liveinteract.feedv2.feedview.a, LifecycleOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b, ViewModelStoreOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.c {
    public static final int h2 = 0;
    public Widget A;
    public ng0.e B;
    public ViewModelStore C;
    public ViewModelProvider D;
    public DataCenter E;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.a F;
    public IRoom G;
    public String G1;
    public com.bytedance.android.live.liveinteract.plantform.model.q H;
    public Boolean H0;
    public int H1;
    public com.bytedance.android.live.liveinteract.voicechat.subtitle.u I;
    public boolean J;
    public boolean K;
    public q2 L;
    public boolean L0;
    public final boolean L1;
    public final j M;
    public int M1;
    public boolean N;
    public boolean O;
    public HybridCard P;
    public Boolean P0;
    public List<Integer> P1;
    public int Q;
    public ArrayList<Integer> Q1;
    public final i R;
    public final Function1<IOrderSingMVInfo, Unit> S;
    public final MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 S1;
    public final CompositeDisposable T;
    public LifecycleRegistry T1;
    public Disposable U;
    public boolean V;
    public Boolean V0;
    public int V1;
    public boolean W;
    public Map<Integer, View> a;
    public IPreviewMultiLinkOuterConfigProvider b;
    public boolean b1;
    public int b2;
    public te0.a c;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m d;
    public final Map<Integer, com.bytedance.android.live.liveinteract.plantform.commonwindow.m> e;
    public IRenderView f;
    public BaseLinkSeatWindowView g;
    public Boolean g1;
    public final Integer g2;
    public FrameLayout h;
    public boolean h1;
    public View i;
    public View j;
    public View k;
    public boolean k0;
    public com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g k1;
    public IOrderSingSyncData l;
    public qb m;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.a n;
    public FrameLayout o;
    public InteractiveSongMvManager p;
    public boolean p0;
    public com.bytedance.android.live.liveinteract.widget.widget.v p1;
    public RadioDarkMaskView q;
    public com.bytedance.android.live.liveinteract.videotalk.utils.c r;
    public com.bytedance.android.live.ui.q s;
    public com.bytedance.android.live.liveinteract.feed.d0 t;
    public final JSONObject u;
    public int v;
    public boolean v1;
    public int w;
    public ClientUIInfo x;
    public com.bytedance.android.live.liveinteract.voicechat.radio.k x1;
    public boolean y;
    public LiveLinkmicAIMVManager y1;
    public WidgetManager z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.m b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public b(MultiLinkCommonVoiceFeedPreview r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkCommonVoiceFeedPreview r0 = this.a;     // Catch: Throwable -> L4
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.b;     // Catch: Throwable -> L4
            int r2 = this.c;     // Catch: Throwable -> L4
            int r3 = this.d;     // Catch: Throwable -> L4
            int r4 = MultiLinkCommonVoiceFeedPreview.h2;     // Catch: Throwable -> L4
            r0.r = r0.K(r1, r2, r3);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

        public c(MultiLinkCommonVoiceFeedPreview r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkCommonVoiceFeedPreview r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MultiLinkCommonVoiceFeedPreview.h2;     // Catch: Throwable -> L4
            r0.m0(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

        public d(MultiLinkCommonVoiceFeedPreview r1) {
            this.a = r1;
        }

        public final void a() {
            DataCenter r0 = this.a.getFeedDataCenter();
            if (r0 != null) goto L5;
            return;
        L5:
            FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.a.getContext());
            if (r1 == null) goto L10;
            MultiLinkCommonVoiceFeedPreview r2 = this.a;
            r2.z = WidgetManager.of(r1, r2);
            WidgetManager r3 = this.a.z;
            if (r3 == null) goto L10;
            r3.setDataCenter(r0);
        L10:
            MultiLinkCommonVoiceFeedPreview r4 = this.a;
            if (r4.A != null) goto L37;
            IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
            Widget r6 = null;
            if (r5 == null) goto L16;
            MiddlewareRoomWidget r7 = r5.createMultiLinkBgManager();
        L17:
            WidgetManager r8 = r4.z;
            if (r8 == null) goto L20;
            r8.load(r7, false);
        L20:
            IInteractService r9 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r9 == null) goto L32;
            IPreviewMultiLinkOuterConfigProvider r10 = r4.b;
            if (r10 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L25:
            String r11 = r10.getEnterFromMerge();
            IPreviewMultiLinkOuterConfigProvider r12 = r4.b;
            if (r12 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L28:
            IRoom r13 = r12.getRoom();
            Integer r14 = Integer.valueOf(r4.V1);
            te0.a r15 = r4.c;
            if (r15 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
        L31:
            r6 = r9.createLiveThemeBgUIWidget(true, r11, r13, null, 5, r14, r15.g());
        L32:
            r4.A = r6;
            WidgetManager r16 = r4.z;
            if (r16 == null) goto L36;
            r16.load(2131388549, r6, false);
            return;
        L36:
            return;
        L16:
            r7 = null;
            goto L17
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

    public static final class e implements com.bytedance.android.live.liveinteract.widget.widget.v.a {
        public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.v.a
        public final View c() {
            BaseLinkSeatWindowView r0 = this.a.getBaseWindowView();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getDynamicBgContainer();
        }

        public e(MultiLinkCommonVoiceFeedPreview r1) {
            this.a = r1;
        }
    }

    public static final class f<T> implements Comparator<T> {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((Number) r1).intValue()), Integer.valueOf(((Number) r2).intValue()));
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

        public g(MultiLinkCommonVoiceFeedPreview r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkCommonVoiceFeedPreview r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MultiLinkCommonVoiceFeedPreview.h2;     // Catch: Throwable -> L4
            r0.C();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVoiceFeedPreview$h", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class h extends TypeToken<ClientUIInfo> {
        public h() {
        }
    }

    public static final class i implements vlc.l {
        public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

        public i(MultiLinkCommonVoiceFeedPreview r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            if ((r2 instanceof l9) == false) goto L6;
            MultiLinkCommonVoiceFeedPreview.w(this.a, (l9) r2);
            return;
        L6:
            if ((r2 instanceof LinkmicRoomSongMessage) == false) goto L12;
            LinkmicRoomSongMessage r3 = (LinkmicRoomSongMessage) r2;
            LiveLinkmicAIMVManager r0 = this.a.y1;
            if (r0 == null) goto L13;
            r0.c(r3);
            return;
        L13:
            return;
        }
    }

    public static final class j implements OnWRDSDataUpdateListener {
        public ylc.c a;
        public final /* synthetic */ MultiLinkCommonVoiceFeedPreview b;

        public final ylc.c getDataSyncListener() {
            return this.a;
        }

        public j(MultiLinkCommonVoiceFeedPreview r1) {
            this.b = r1;
        }

        public final void setDataSyncListener(ylc.c r1) {
            this.a = r1;
        }

        public final void onWRDSDataUpdate(String r9, Object r10) {
            Intrinsics.checkNotNullParameter(r9, "syncKey");
            IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(MultiLinkCommonVoiceFeedPreview.x(this.b), "MultiLinkCommonVoiceFeedPreview", this.b.hashCode(), "onWRDSDataUpdate  " + r9, false, 8, null);
            List r1 = null;
            if (Intrinsics.areEqual(r9, MultiPreviewSyncDataType.ORDER_SING_SYNC_DATA.getSyncKey()) == false) goto L13;
            MultiLinkCommonVoiceFeedPreview r11 = this.b;
            boolean r0 = r10 instanceof IOrderSingSyncData;
            if (r0 == true) goto L7;
            Object r2 = null;
        L8:
            r11.l = (IOrderSingSyncData) r2;
            if (r0 == true) goto L11;
            r10 = null;
        L11:
            r11.J((IOrderSingSyncData) r10);
            return;
        L7:
            r2 = r10;
            goto L8
        L13:
            if (Intrinsics.areEqual(r9, MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA.getSyncKey()) == false) goto L59;
            MultiLinkCommonVoiceFeedPreview r12 = this.b;
            boolean r3 = r10 instanceof RoomLinkMicSyncData;
            if (r3 == true) goto L17;
            Object r4 = null;
        L18:
            RoomLinkMicSyncData r5 = (RoomLinkMicSyncData) r4;
            if (r5 == null) goto L21;
            ClientUIInfo r6 = r5.clientUIInfo;
        L22:
            r12.l0(r6, false, null);
            MultiLinkCommonVoiceFeedPreview r13 = this.b;
            if (r3 == true) goto L25;
            Object r7 = null;
        L26:
            RoomLinkMicSyncData r8 = (RoomLinkMicSyncData) r7;
            if (r8 == null) goto L31;
            ClientUIInfo r14 = r8.clientUIInfo;
            if (r14 == null) goto L31;
            List r15 = r14.getUiFeatureList();
        L32:
            r13.Q1 = (ArrayList) r15;
            MultiLinkCommonVoiceFeedPreview r16 = this.b;
            if (r16.O == false) goto L39;
            ArrayList<Integer> r17 = r16.Q1;
            if (r17 == null) goto L39;
            if (r17.contains(8) != true) goto L39;
            this.b.O = false;
        L48:
            StringBuilder r18 = new StringBuilder("onWRDSDataUpdate, clientUIInfo update, data: ");
            if (r3 == true) goto L51;
            r10 = null;
        L51:
            RoomLinkMicSyncData r19 = (RoomLinkMicSyncData) r10;
            if (r19 == null) goto L56;
            ClientUIInfo r110 = r19.clientUIInfo;
            if (r110 == null) goto L56;
            r1 = r110.getUiFeatureList();
        L56:
            r18.append(r1);
            ALogger.d("MultiLinkCommonVoiceFeedPreview", r18.toString());
            return;
        L39:
            MultiLinkCommonVoiceFeedPreview r20 = this.b;
            if (r20.O == true) goto L48;
            ArrayList<Integer> r21 = r20.Q1;
            if (r21 == null) goto L48;
            if (r21.contains(8) == true) goto L48;
            MultiLinkCommonVoiceFeedPreview r22 = this.b;
            IRoom r23 = r22.G;
            if (r23 == null) goto L48;
            r22.O = r22.V(r23);
        L31:
            r15 = null;
            goto L32
        L25:
            r7 = r10;
            goto L26
        L21:
            r6 = null;
            goto L22
        L17:
            r4 = r10;
            goto L18
        }
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "seiString");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public String getFeedViewName() {
        return "MultiLinkCommonVoiceFeedPreview";
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public int getMicSeatRvViewId() {
        return 2131378009;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public View getViewCompat() {
        return this;
    }

    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void l() {
        this.L0 = false;
        m0(-1);
        E();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void s() {
    }

    static {
        h2 = UtilityKotlinExtentionsKt.i(12);
    }

    private final int getContainerHeight() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewPlayerContainerAbility r1 = r0.getPlayerContainerAbility();
        Integer r2 = null;
        if (r1 == null) goto L19;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L19;
        Integer r4 = Integer.valueOf(r3.height);
        if (r4.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L19;
        r2 = r4;
    L25:
        if (r2 == null) goto L28;
        return r2.intValue();
    L28:
        return s1.w();
    L12:
        r5 = false;
    L19:
        IPreviewMultiLinkOuterConfigProvider r6 = this.b;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        IPreviewPlayerContainerAbility r7 = r6.getPlayerContainerAbility();
        if (r7 == null) goto L25;
        r2 = r7.getHeight();
        goto L25
    }

    private final int getContainerWidth() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewPlayerContainerAbility r1 = r0.getPlayerContainerAbility();
        Integer r2 = null;
        if (r1 == null) goto L19;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L19;
        Integer r4 = Integer.valueOf(r3.width);
        if (r4.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L19;
        r2 = r4;
    L25:
        if (r2 == null) goto L28;
        return r2.intValue();
    L28:
        return s1.y();
    L12:
        r5 = false;
    L19:
        IPreviewMultiLinkOuterConfigProvider r6 = this.b;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        IPreviewPlayerContainerAbility r7 = r6.getPlayerContainerAbility();
        if (r7 == null) goto L25;
        r2 = r7.getWidth();
        goto L25
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
        return UtilityKotlinExtentionsKt.i(326);
    }

    private final pn0.i getLayoutConfigRequestExtra() {
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        r1.getShowFrom();
        return new pn0.i(false);
    }

    private final int getLinkmicSubtitleHeight() {
        int r0 = LinkmicSubtitleUIWidget.r;
        return LinkmicSubtitleUIWidget.u;
    }

    private final Pair<Integer, Integer> getLivePlayerVideoSize() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        LivePlayerView r1 = r0.getLivePlayerView();
        if (r1 == null) goto L18;
        ILivePlayerClient r2 = r1.getClient();
        if (r2 == null) goto L18;
        IRoomEventHub r3 = r2.getEventHub();
        if (r3 == null) goto L18;
        MutableLiveData r4 = r3.getVideoSizeChanged();
        if (r4 == null) goto L18;
        Pair r5 = (Pair) r4.getValue();
        if (r5 == null) goto L18;
        return new Pair(r5.getFirst(), r5.getSecond());
    L18:
        return new Pair(0, 0);
    }

    private final List<Long> getPlayModes() {
        com.bytedance.android.live.liveinteract.plantform.model.q r0 = this.H;
        if (r0 == null) goto L6;
        List<Long> r1 = r0.getPlayModes();
        if (r1 == null) goto L6;
    L12:
        if (r1 == null) goto L14;
        return r1;
    L14:
        return CollectionsKt.emptyList();
    L6:
        IRoom r2 = this.G;
        if (r2 == null) goto L11;
        z5 r3 = r2.getLinkerDetail();
        if (r3 == null) goto L11;
        r1 = r3.getPlayModes();
    L11:
        r1 = null;
        goto L12
    }

    public final void C() {
        if (MultiLinkLoadWidgetUtils.a() == false) goto L10;
        te0.a r1 = this.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L8:
        if (r1.shouldUseNewLivePlayerLayout() == false) goto L10;
        return;
    L10:
        IPreviewMultiLinkOuterConfigProvider r2 = this.b;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r2.getShowFrom()) == false) goto L31;
        IPreviewMultiLinkOuterConfigProvider r3 = this.b;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L18:
        IPreviewPlayerContainerAbility r4 = r3.getPlayerContainerAbility();
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L21:
        com.bytedance.android.live.liveinteract.utils.h.a(r4, r5.getContext(), this.G);
        IRenderView r6 = this.f;
        te0.a r7 = this.c;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L24:
        IInteractPlayView r8 = r7.n();
        int r9 = this.b2;
        int r10 = this.V1;
        JSONObject r11 = this.u;
        IPreviewMultiLinkOuterConfigProvider r12 = this.b;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L27:
        int r13 = r12.getShowFrom();
        IPreviewMultiLinkOuterConfigProvider r14 = this.b;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L30:
        com.bytedance.android.live.liveinteract.utils.h.i(r6, r8, r9, r10, r11, r13, r14.getContext(), this.G, null);
        return;
    L31:
        IPreviewMultiLinkOuterConfigProvider r15 = this.b;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L34:
        com.bytedance.android.live.liveinteract.utils.h.b(r15.getPlayerContainerAbility());
        int r16 = getContainerWidth();
        int r17 = getContainerHeight();
        IPreviewMultiLinkOuterConfigProvider r18 = this.b;
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L37:
        int r19 = r18.getShowFrom();
        int r20 = this.b2;
        int r21 = this.V1;
        IPreviewMultiLinkOuterConfigProvider r22 = this.b;
        if (r22 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L40:
        Context r23 = r22.getContext();
        IRenderView r110 = this.f;
        te0.a r24 = this.c;
        if (r24 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L43:
        com.bytedance.android.live.liveinteract.utils.h.k(r16, r17, r19, r20, r21, r23, r110, r24.n(), this.G, this.u, null, this.x, 1024);
    }

    public final void E() {
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L13;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r1.getShowFrom()) == false) goto L13;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L13;
        boolean r6 = false;
    L14:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = this.d;
        if (r2 == null) goto L28;
        int r3 = r2.m();
        int r4 = r2.getUiLayout();
        te0.a r5 = this.c;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L19:
        int r7 = r5.getContainerWidth();
        te0.a r8 = this.c;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L22:
        Triple<Integer, Integer, Float> r9 = M(r3, r4, r7, r8.l());
        int r10 = ((Number) r9.component1()).intValue();
        int r11 = ((Number) r9.component2()).intValue();
        int r12 = r2.getUiLayout();
        pn0.i r13 = getLayoutConfigRequestExtra();
        Triple r14 = new Triple(Integer.valueOf(r10), Integer.valueOf(r11), "");
        ClientUIInfo r15 = this.x;
        if (r15 == null) goto L25;
        List r16 = r15.getUiFeatureList();
    L26:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.h r17 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r12, 0, null, r6, 0, false, r13, r14, r16, null, this.E, 566);
        ln0.a r18 = yg0.h.a;
        yg0.h.k(r17, new com.bytedance.android.live.liveinteract.feedv2.feedview.j(this), null);
        return;
    L25:
        r16 = null;
        goto L26
    L28:
        return;
    L13:
        r6 = true;
        goto L14
    }

    public final boolean L() {
        LinkFeedTypeConstant.Companion r0 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r0.isDouyinFullScreen(r1.getShowFrom()) == true) goto L8;
        return false;
    L8:
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(false) == true) goto L10;
        return false;
    L10:
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.b(Integer.valueOf(this.V1)) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public final void P() {
        if (this.V1 != 16) goto L17;
        H();
        if (Intrinsics.areEqual(this.H0, Boolean.TRUE) == false) goto L13;
        Path r0 = new Path();
        com.bytedance.android.live.liveinteract.videotalk.utils.c r2 = this.r;
        if (r2 == null) goto L9;
        Path r1 = r2.a(qi0.e.a(16), 0.0f, 0.0f);
    L10:
        r0.addPath(r1);
        com.bytedance.android.live.liveinteract.feed.d0 r3 = this.t;
        if (r3 == null) goto L18;
        r3.o(r0);
        return;
    L18:
        return;
    L9:
        r1 = new Path();
        goto L10
    L13:
        com.bytedance.android.live.liveinteract.feed.d0 r4 = this.t;
        if (r4 == null) goto L20;
        r4.o(new Path());
        return;
    L20:
        return;
    }

    public final void R() {
        boolean r13 = true;
        if (((Boolean) jb0.a.getValue()).booleanValue() == true) goto L5;
    L6:
        Context r2 = getContext();
        DataCenter r3 = this.E;
        Intrinsics.checkNotNull(r3);
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L9:
        int r6 = r0.getShowFrom();
        te0.a r1 = this.c;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L12:
        ue0.c r7 = r1.f();
        te0.a r4 = this.c;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L15:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r8 = r4.c();
        te0.a r5 = this.c;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L18:
        eh0.b r9 = r5.p5();
        te0.a r10 = this.c;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L21:
        eh0.b r11 = r10.Y3();
        IPreviewMultiLinkOuterConfigProvider r12 = this.b;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L24:
        MultiLinkFeedDynamicWidgetNew r15 = new MultiLinkFeedDynamicWidgetNew(this, r2, r3, this, this, r6, r7, r8, r9, r11, r12.getEnterFromMerge());
        this.F = r15;
        te0.a r14 = this.c;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L27:
        r15.b(r14.g());
        if (MultiLinkLoadWidgetUtils.j() == false) goto L32;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r16 = this.F;
        if (r16 == null) goto L32;
        r16.bh(true);
    L32:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r17 = this.F;
        if (r17 == null) goto L35;
        r17.fd(this.n);
    L35:
        IRoom r18 = this.G;
        if (r18 == null) goto L41;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r19 = this.F;
        if (r19 == null) goto L40;
        r19.updateRoom(r18);
    L40:
        f0(r18);
    L41:
        LinkedHashMap r20 = new LinkedHashMap();
        IPreviewMultiLinkOuterConfigProvider r21 = this.b;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L44:
        IBaseUser r22 = r21.getRoom().getOwner();
        if (r22 == null) goto L52;
        py.k r23 = r22.getAvatarMedium();
        if (r23 == null) goto L52;
        List r24 = r23.getUrls();
        if (r24 == null) goto L52;
        String r25 = (String) CollectionsKt.getOrNull(r24, 0);
        if (r25 == null) goto L52;
    L53:
        r20.put("anchor_avatar_url", r25);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r26 = this.d;
        if (r26 == null) goto L57;
        String r27 = String.valueOf(r26.j());
        if (r27 == null) goto L57;
    L58:
        r20.put("scene", r27);
        IPreviewMultiLinkOuterConfigProvider r28 = this.b;
        if (r28 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L61:
        IRoomBasisData r29 = r28.getRoom().getBasisRoomData();
        if (r29 == null) goto L64;
        Boolean r30 = r29.isCustomizeAudioRoom();
    L65:
        r20.put("is_customize_audio", String.valueOf(Intrinsics.areEqual(r30, Boolean.TRUE)));
        IPreviewMultiLinkOuterConfigProvider r31 = this.b;
        if (r31 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L68:
        r20.put("is_live_audio", String.valueOf(r31.getRoom().isLiveTypeAudio()));
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r32 = this.F;
        if (r32 == null) goto L73;
        ih0.c r33 = r32.tb();
        if (r33 == null) goto L73;
        r33.updateData(r20);
    L73:
        int r34 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.b(Integer.valueOf(this.v)) == false) goto L84;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r35 = this.x1;
        if (r35 != null) goto L78;
    L80:
        r13 = false;
    L81:
        ALogger.i("RadioStageContainerWidget", "[sendRadioStageStateToLynx] state:" + r13);
        JsonObject r36 = new JsonObject();
        r36.addProperty("state", Boolean.valueOf(r13));
        nh0.f r37 = new nh0.f("radio_stage_state", null, null, null, r36, null, false, 222);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r38 = this.F;
        if (r38 == null) goto L84;
        r38.fg(r37);
        goto L84
    L78:
        if (r35.b() != true) goto L80;
    L84:
        IPreviewMultiLinkOuterConfigProvider r39 = this.b;
        if (r39 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L87:
        r39.onMultiLinkDynamicInitialComplete(this.E);
        return;
    L64:
        r30 = null;
    L57:
        r27 = "-1";
    L52:
        r25 = "";
        goto L53
    L5:
        if (this.F != null) goto L32;
        goto L6
    }

    public final void T() {
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiLinkCommonVoiceFeedPreview$initOrderSongContext$pair$1.INSTANCE);
        InteractiveSongContext r1 = (InteractiveSongContext) r0.getFirst();
        com.bytedance.live.datacontext.i<Boolean> r2 = r1.isFeed();
        Boolean r3 = Boolean.TRUE;
        r2.d(r3);
        com.bytedance.live.datacontext.b.a(r1, InteractiveSongContext.TAG_FOR_FEED);
        this.U = (Disposable) r0.getSecond();
        int r4 = com.bytedance.android.live.liveinteract.aimv.b.a;
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        boolean r6 = com.bytedance.android.live.liveinteract.aimv.b.b(r5.getRoom());
        Boolean r7 = this.P0;
        Boolean r8 = null;
        if (r7 != null) goto L8;
    L13:
        DataCenter r9 = this.E;
        if (r9 == null) goto L16;
        r8 = (Boolean) r9.get("data_order_sing_stage_is_inert", Boolean.FALSE);
    L16:
        this.V0 = r8;
        DataCenter r10 = this.E;
        if (r10 == null) goto L19;
        r10.put("data_inner_interactive_song_context_init", r3);
    L19:
        Boolean r11 = this.V0;
        if (r11 == null) goto L22;
        r1.getShowOrderSingStage().setValue(Boolean.valueOf(r11.booleanValue()));
    L22:
        Boolean r12 = this.H0;
        if (r12 == null) goto L30;
        boolean r13 = r12.booleanValue();
        InteractiveSongContext r14 = InteractiveSongContext.Companion.getContext();
        if (r14 == null) goto L30;
        com.bytedance.live.datacontext.m<Boolean> r15 = r14.isShowPlayer();
        if (r15 == null) goto L30;
        r15.setValue(Boolean.valueOf(r13));
    L30:
        if (this.b1 == true) goto L49;
        this.b1 = true;
        InteractiveSongContext.a r16 = InteractiveSongContext.Companion;
        InteractiveSongContext r17 = r16.getContext();
        if (r17 == null) goto L40;
        com.bytedance.live.datacontext.m<Boolean> r18 = r17.getShowOrderSingStage();
        if (r18 == null) goto L40;
        Observable r19 = r18.a();
        if (r19 == null) goto L40;
        Disposable r20 = r19.subscribe(new y(this));
        if (r20 == null) goto L40;
        RxUtilKt.c(r20, this.T);
    L40:
        InteractiveSongContext r21 = r16.getContext();
        if (r21 == null) goto L49;
        com.bytedance.live.datacontext.m<Boolean> r22 = r21.m130isOpenInteractiveSong();
        if (r22 == null) goto L49;
        Observable r23 = r22.a();
        if (r23 == null) goto L49;
        Disposable r24 = r23.subscribe(new z(this));
        if (r24 == null) goto L49;
        RxUtilKt.c(r24, this.T);
    L49:
        O();
        P();
        return;
    L8:
        if (r7.booleanValue() == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L13;
        r7.booleanValue();
        InteractiveSongContext.Companion.g(true, true, r6, String.valueOf(19));
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final Integer a() {
        return Integer.valueOf(N(this.V1, this.b2));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean c() {
        Boolean r0 = this.g1;
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
        if (this.O == false) goto L22;
        if (s0.g(this.G) == true) goto L9;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L22;
        r0.put("is_subtitle_stage_showing", Boolean.valueOf(this.O));
        goto L22
    L9:
        if (this.v != 27) goto L19;
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

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public FrameLayout.LayoutParams getKtvComponentLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public Lifecycle getLifecycleCompat() {
        LifecycleRegistry r0 = this.T1;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LifecycleRegistry(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicAreaFrameInfo() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.d;
        if (r0 == null) goto L17;
        boolean r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        IPreviewMultiLinkOuterConfigProvider r3 = this.b;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L7:
        int r4 = r3.getShowFrom();
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L10:
        r5.getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r4) == false) goto L17;
        Triple<Integer, Integer, Float> r6 = M(r0.m(), r0.getUiLayout(), getContainerWidth(), getContainerHeight());
        int r7 = ((Number) r6.component1()).intValue();
        int r8 = ((Number) r6.component2()).intValue();
        int r9 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        sf0.b r10 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a(r0, r7, r8);
        List<Integer> r1 = r0.e;
        if (r1 == null) goto L16;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r10.b = r1;
    L16:
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r10);
    L17:
        BaseLinkSeatWindowView r11 = this.g;
        if (r11 == null) goto L35;
        LinkMicRecyclerView r12 = r11.getRecyclerView();
        if (r12 == null) goto L37;
        int r13 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        int r14 = 0;
        if (r0 == null) goto L24;
        int r15 = r0.getUiLayout();
    L25:
        sf0.b r16 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.e(r12, r15);
        sf0.c r17 = r16.c;
        if (r0 == null) goto L28;
        r14 = r0.b;
    L28:
        r17.a = r14;
        if (r0 == null) goto L34;
        List<Integer> r18 = r0.e;
        if (r18 == null) goto L34;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.b = r18;
    L34:
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r16);
    L24:
        r15 = 0;
        goto L25
    L37:
        return null;
    L35:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicSeatListInfo() {
        BaseLinkSeatWindowView r0 = this.g;
        if (r0 == null) goto L6;
        List<tf0.e> r1 = r0.getDataList();
        if (r1 == null) goto L6;
    L8:
        return new nh0.f("seat", null, r1, null, null, null, false, 246).b();
    L6:
        r1 = CollectionsKt.emptyList();
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final int i() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.j();
    }

    public final void i0() {
        if (this.V1 == 24) goto L7;
        if (vm2.d.R0() == true) goto L7;
        return;
    L7:
        if (this.T1 != null) goto L10;
        this.T1 = new LifecycleRegistry(this);
    L10:
        if (this.C != null) goto L13;
        this.C = new ViewModelStore();
    L13:
        if (this.D != null) goto L16;
        this.D = new ViewModelProvider(this);
    L16:
        if (this.E != null) goto L32;
        this.E = DataCenter.create(this.D, this);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        if (vm2.h.W().feedLogRoom() == false) goto L33;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L34;
        DataCenter r3 = this.E;
        if (r3 == null) goto L27;
        r3.put("data_room", r2);
    L27:
        DataCenter r4 = this.E;
        if (r4 == null) goto L35;
        r4.put("data_is_feed", Boolean.TRUE);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }

    public final void j0() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        MessageHub r1 = r0.getMessageHub();
        if (r1 == null) goto L8;
        r1.removeMessageListener(MessageType.LINK_MIC_PLAYMODE.getIntType(), this.R);
    L8:
        IPreviewMultiLinkOuterConfigProvider r2 = this.b;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        MessageHub r3 = r2.getMessageHub();
        if (r3 == null) goto L14;
        r3.removeWRDSListener(MultiPreviewSyncDataType.ORDER_SING_SYNC_DATA, this.M);
    L14:
        IPreviewMultiLinkOuterConfigProvider r4 = this.b;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        MessageHub r5 = r4.getMessageHub();
        if (r5 == null) goto L21;
        r5.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this.M);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onLivePlayerVideoSizeChanged() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.d;
        if (r0 == null) goto L12;
        int r1 = r0.m();
        int r2 = r0.getUiLayout();
        te0.a r3 = this.c;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L7:
        int r4 = r3.getContainerWidth();
        te0.a r5 = this.c;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L10:
        Triple<Integer, Integer, Float> r6 = M(r1, r2, r4, r5.l());
        F(r0, ((Number) r6.component1()).intValue(), ((Number) r6.component2()).intValue(), ((Number) r6.component3()).floatValue());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderPause() {
        if (this.V1 != 24) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.F;
        if (r0 == null) goto L11;
        r0.onPause();
        return;
    L11:
        return;
    L5:
        if (vm2.d.R0() == true) goto L6;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderResume() {
        if (this.V1 != 24) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.F;
        if (r0 == null) goto L9;
        r0.Kk();
    L9:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.F;
        if (r1 == null) goto L12;
        r1.initDataContext();
    L12:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r2 = this.F;
        if (r2 == null) goto L16;
        r2.onResume();
    L16:
        if (InteractiveSongContext.Companion.getContext() != null) goto L21;
        this.b1 = false;
        T();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r3 = this.n;
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

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderSelected() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "MultiLinkCommonVoiceFeedPreview", hashCode(), "onViewHolderSelected", false, 8, null);
        if (this.V1 != 24) goto L8;
    L9:
        i0();
        BaseLinkSeatWindowView r1 = this.g;
        if (r1 == null) goto L16;
        DataCenter r2 = this.E;
        if (r2 == null) goto L16;
        r1.s = r2;
    L16:
        if (((Boolean) kb0.a.getValue()).booleanValue() == true) goto L27;
        R();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = this.d;
        if (r3 == null) goto L20;
        g0(null, r3);
    L20:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r4 = this.F;
        if (r4 == null) goto L23;
        r4.onViewHolderSelected();
    L23:
        LifecycleRegistry r5 = this.T1;
        if (r5 == null) goto L27;
        r5.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    L27:
        if (this.V == false) goto L29;
    L33:
        boolean r6 = false;
    L34:
        if (r6 == false) goto L37;
        this.V = true;
        LinkApi r7 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r8 = this.G;
        Intrinsics.checkNotNull(r8);
        Disposable r9 = r7.fetchPlayModeInfo(r8.getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this), new p(this));
        this.T.add(r9);
    L37:
        LinkApi r10 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r11 = this.G;
        Intrinsics.checkNotNull(r11);
        Disposable r12 = r10.getAudienceSingEnableSetting(r11.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(this), n.a);
        if (r12 == null) goto L40;
        this.T.add(r12);
    L40:
        this.p0 = true;
        o0(this.d);
        if (MultiLinkLoadWidgetUtils.j() == false) goto L46;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r13 = this.F;
        if (r13 == null) goto L47;
        r13.bh(false);
        return;
    L47:
        return;
    L46:
        return;
    L29:
        if (Z() == false) goto L31;
    L32:
        r6 = true;
        goto L34
    L31:
        if (W() == false) goto L33;
    L8:
        if (vm2.d.R0() == false) goto L27;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderUnSelected() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "MultiLinkCommonVoiceFeedPreview", hashCode(), "onViewHolderUnSelected", false, 8, null);
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        IPreviewPlayerContainerAbility r2 = r1.getPlayerContainerAbility();
        if (r2 == null) goto L11;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L13:
        if ((r3 instanceof FrameLayout.LayoutParams) == true) goto L15;
        ViewGroup.LayoutParams r4 = null;
    L16:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r4;
        if (r5 == null) goto L20;
        r5.topMargin = 0;
    L20:
        if ((r3 instanceof ConstraintLayout.LayoutParams) == true) goto L22;
        ViewGroup.LayoutParams r6 = null;
    L23:
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        if (r7 == null) goto L27;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = 0;
    L27:
        if ((r3 instanceof RelativeLayout.LayoutParams) == true) goto L29;
        r3 = null;
    L29:
        RelativeLayout.LayoutParams r8 = (RelativeLayout.LayoutParams) r3;
        if (r8 == null) goto L33;
        r8.topMargin = 0;
    L33:
        if (this.V1 != 24) goto L35;
    L36:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r9 = this.F;
        if (r9 == null) goto L40;
        r9.jc("audiochat_stage");
    L40:
        if (((Boolean) jb0.a.getValue()).booleanValue() == true) goto L57;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r10 = this.F;
        if (r10 == null) goto L44;
        r10.onDestroy();
    L44:
        LifecycleRegistry r11 = this.T1;
        if (r11 == null) goto L53;
        Lifecycle.State r12 = r11.getCurrentState();
        if (r12 == null) goto L53;
        if (r12.isAtLeast(Lifecycle.State.CREATED) != true) goto L53;
        LifecycleRegistry r13 = this.T1;
        if (r13 == null) goto L53;
        r13.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L53:
        this.T1 = null;
        ViewModelStore r14 = this.C;
        if (r14 == null) goto L56;
        r14.clear();
    L56:
        this.C = null;
        this.D = null;
        this.E = null;
    L57:
        this.p0 = false;
        return;
    L35:
        if (vm2.d.R0() == false) goto L57;
    L22:
        r6 = r3;
        goto L23
    L15:
        r4 = r3;
        goto L16
    L11:
        r3 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final MessageHub p() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r0.getMessageHub();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final IRoom r() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r0.getRoom();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void release() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        r0.printALogger("MultiLinkCommonVoiceFeedPreview", hashCode(), "call release", true);
        Disposable r1 = this.U;
        if (r1 != null) goto L8;
    L10:
        this.T.clear();
        j0();
        UtilityKotlinExtentionsKt.t(getLinkmicSubtitleRootContainer());
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r2 = this.I;
        if (r2 == null) goto L13;
        r2.a();
    L13:
        HybridCard r3 = this.P;
        if (r3 == null) goto L19;
        r3.release();
        ConstraintLayout r4 = t(2131378052);
        if (r4 == null) goto L18;
        r4.removeView(this.P);
    L18:
        this.P = null;
    L19:
        com.bytedance.android.live.liveinteract.voicechat.radio.k r5 = this.x1;
        if (r5 == null) goto L22;
        r5.d = false;
        r5.e = false;
        r5.i("destroy");
    L22:
        UtilityKotlinExtentionsKt.t(getLinkmicSubtitleRootContainer());
        this.t = null;
        if (this.p0 == false) goto L26;
        onViewHolderUnSelected();
    L26:
        if (((Boolean) jb0.a.getValue()).booleanValue() == false) goto L43;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r6 = this.F;
        if (r6 == null) goto L30;
        r6.onDestroy();
    L30:
        this.F = null;
        LifecycleRegistry r7 = this.T1;
        if (r7 == null) goto L39;
        Lifecycle.State r8 = r7.getCurrentState();
        if (r8 == null) goto L39;
        if (r8.isAtLeast(Lifecycle.State.CREATED) != true) goto L39;
        LifecycleRegistry r9 = this.T1;
        if (r9 == null) goto L39;
        r9.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L39:
        this.T1 = null;
        ViewModelStore r10 = this.C;
        if (r10 == null) goto L42;
        r10.clear();
    L42:
        this.C = null;
        this.D = null;
        this.E = null;
    L43:
        LiveLinkmicAIMVManager r11 = this.y1;
        if (r11 == null) goto L47;
        r11.d();
    L47:
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV5() == false) goto L53;
        Iterator<com.bytedance.android.live.liveinteract.api.fulllink.revenue.f> r12 = this.S1.iterator();
    L50:
        if (r12.hasNext() == false) goto L52;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f r13 = r12.next();
        getViewTreeObserver().removeOnDrawListener(r13);
        goto L50
    L52:
        this.S1.clear();
    L53:
        Widget r14 = this.A;
        WidgetManager r15 = this.z;
        if (r14 == null) goto L59;
        if (r15 == null) goto L60;
        r15.unload(r14);
        this.A = null;
        return;
    L60:
        return;
    L59:
        return;
    L8:
        if (r1.isDisposed() == true) goto L10;
        r1.dispose();
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void removeEffectView() {
        ConstraintLayout r0 = this.g;
        if (r0 == null) goto L5;
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131371496);
    L6:
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        if (r1 == null) goto L11;
        r1.setVisibility(8);
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final ViewModelStore tf() {
        ViewModelStore r0 = this.C;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ViewModelStore();
    }

    private final SubtitleRecyclerView getLinkmicSubtitleRecyclerView() {
        return (SubtitleRecyclerView) t(2131378056);
    }

    private final ConstraintLayout getLinkmicSubtitleRootContainer() {
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L6;
        return t(2131378052);
    L6:
        return t(2131378054);
    }

    public final void H() {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
        return;
    L5:
        if (this.t != null) goto L33;
        DataCenter r0 = this.E;
        if (r0 == null) goto L34;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r0);
        com.bytedance.android.live.ui.c r2 = null;
        if (r1 == null) goto L23;
        ViewGroup r3 = r1.Pn();
        if (r3 == null) goto L23;
        MultiLinkLoadWidgetUtils.p(this.E, "VoiceFeedPreview#initTheme", "themeService=" + r1.hashCode() + ", themeBgViewContainer=" + r3);
        ConstraintLayout r4 = this.g;
        if (r4 == null) goto L15;
        FrameLayout r5 = (FrameLayout) r4.findViewById(2131388550);
    L16:
        if (r5 == null) goto L18;
        r5.removeAllViews();
    L18:
        ViewGroup r6 = UtilityKotlinExtentionsKt.p(r3);
        if (r6 == null) goto L21;
        r6.removeView(r3);
    L21:
        if (r5 == null) goto L23;
        r5.addView(r3, new FrameLayout.LayoutParams(-1, -1));
        goto L23
    L15:
        r5 = null;
    L23:
        if (r1 == null) goto L25;
        com.bytedance.android.live.ui.c r7 = r1.kb();
    L27:
        if ((r7 instanceof com.bytedance.android.live.liveinteract.feed.d0) == false) goto L30;
        r2 = r7;
    L30:
        this.t = (com.bytedance.android.live.liveinteract.feed.d0) r2;
        return;
    L25:
        r7 = null;
        goto L27
    L34:
        return;
    }

    public final void O() {
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
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r4 = this.n;
        ch0.e r5 = null;
        if (r4 == null) goto L15;
        BehaviorSubject<List<tf0.e>> r6 = r4.b;
        if (r6 == null) goto L15;
        List r7 = (List) r6.getValue();
    L16:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8 = this.d;
        if (r8 != null) goto L19;
    L29:
        if (r7 == null) goto L31;
        tf0.e r9 = (tf0.e) CollectionsKt.firstOrNull(r7);
    L33:
        if ((r9 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == true) goto L35;
        r9 = null;
    L35:
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r10 = (MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) r9;
        if (r10 == null) goto L40;
        ch0.e r11 = r10.q;
    L38:
        r5 = r11;
    L40:
        if (r0.e(this.G, Integer.valueOf(this.V1)) == true) goto L42;
    L44:
        boolean r12 = false;
    L45:
        if (r12 == true) goto L47;
    L55:
        if (r12 == false) goto L57;
        return;
    L57:
        if (this.L0 == false) goto L64;
        this.L0 = false;
        m0(-1);
        return;
    L64:
        return;
    L47:
        if (this.L0 == true) goto L55;
        if (this.r == null) goto L55;
        this.L0 = true;
        BaseLinkSeatWindowView r13 = this.g;
        if (r13 == null) goto L60;
        RecyclerView r14 = r13.getRecyclerView();
        if (r14 == null) goto L61;
        r14.post(new c(this));
        return;
    L61:
        return;
    L60:
        return;
    L42:
        if (InteractiveSongContext.a.d(r0, r5, this.V1, false, 4) == false) goto L44;
        r12 = true;
        goto L45
    L31:
        r9 = null;
        goto L33
    L19:
        if (r8.getUiLayout() != 30) goto L29;
        if (r7 == null) goto L22;
        tf0.e r15 = (tf0.e) CollectionsKt.firstOrNull(r7);
    L24:
        if ((r15 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L26;
        r15 = null;
    L26:
        MultiLinkAudioFirstUserViewBinder.a r16 = (MultiLinkAudioFirstUserViewBinder.a) r15;
        if (r16 == null) goto L40;
        r11 = r16.q;
        goto L38
    L22:
        r15 = null;
    L15:
        r7 = null;
        goto L16
    }

    public final boolean W() {
        return getPlayModes().contains(Long.valueOf(7));
    }

    public final boolean Z() {
        return getPlayModes().contains(Long.valueOf(19));
    }

    public final void n0() {
        if (vm2.c.b().getDismissKtvComponentLyricsAndMidiOnStageSubtitle() == true) goto L5;
        return;
    L5:
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L9:
        if (r0 == null) goto L13;
        IKtvComponentFeedViewManager r1 = r0.getKtvComponentFeedViewManager();
        if (r1 == null) goto L13;
        boolean r2 = r1.getKtvComponentLyricsViewShowStatus();
    L14:
        boolean r4 = false;
        if (this.N == false) goto L17;
        int r3 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        boolean r5 = true;
    L18:
        boolean r6 = this.k1.e();
        if (r5 == true) goto L21;
    L24:
        boolean r7 = true ^ r4;
        if (r2 == r7) goto L34;
        IPreviewMultiLinkOuterConfigProvider r8 = this.b;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L29:
        if (r8 == null) goto L35;
        IKtvComponentFeedViewManager r9 = r8.getKtvComponentFeedViewManager();
        if (r9 == null) goto L36;
        r9.updateKtvComponentLyricsViewShowStatus(r7);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L21:
        if (this.O == false) goto L24;
        if (r6 == false) goto L24;
        r4 = true;
        goto L24
    L17:
        r5 = false;
    L13:
        r2 = true;
        goto L14
    }

    public final View getAnimRecyclerView() {
        return this.k;
    }

    public final BaseLinkSeatWindowView getBaseWindowView() {
        return this.g;
    }

    public final FrameLayout getBaseWindowViewContainer() {
        return this.h;
    }

    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.a getDynamicWidget() {
        return this.F;
    }

    public final DataCenter getFeedDataCenter() {
        return this.E;
    }

    public final ViewModelStore getMViewModelStore() {
        return this.C;
    }

    public final Map<Integer, com.bytedance.android.live.liveinteract.plantform.commonwindow.m> getOriginLayoutConfigMap() {
        return this.e;
    }

    public final View getRecyclerView() {
        return this.j;
    }

    public final boolean getSubtitleIsOpen() {
        return this.N;
    }

    public final ViewModelProvider getViewModelProvider() {
        return this.D;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean k() {
        return this.N;
    }

    private final void setRadioStageVisible(List<? extends tf0.e> r3) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUiLayout() != 29) goto L28;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.isEmpty() == true) goto L30;
        tf0.e r4 = (tf0.e) ListProtector.get(r3, 0);
        if ((r4 instanceof MultiLinkFirstUserViewBinder.a) == true) goto L12;
        r4 = null;
    L12:
        MultiLinkFirstUserViewBinder.a r5 = (MultiLinkFirstUserViewBinder.a) r4;
        if (r5 == null) goto L23;
        ch0.e r6 = r5.q;
        if (r6 == null) goto L23;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L23;
        if (r7.isBackground() != true) goto L23;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r8 = this.x1;
        if (r8 == null) goto L31;
        r8.c();
        return;
    L31:
        return;
    L23:
        com.bytedance.android.live.liveinteract.voicechat.radio.k r9 = this.x1;
        if (r9 == null) goto L33;
        r9.g();
        return;
    L33:
        return;
    L30:
        return;
    }

    public static final /* synthetic */ IPreviewMultiLinkOuterConfigProvider x(MultiLinkCommonVoiceFeedPreview r1) {
        IPreviewMultiLinkOuterConfigProvider r2 = r1.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        return r2;
    }

    public static final /* synthetic */ int y(MultiLinkCommonVoiceFeedPreview r0) {
        return r0.getDragContainerStubHeight();
    }

    public static final /* synthetic */ ConstraintLayout z(MultiLinkCommonVoiceFeedPreview r0) {
        return r0.getLinkmicSubtitleRootContainer();
    }

    public final void D(List<? extends tf0.e> r5) {
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        int r2 = r1.getShowFrom();
        IPreviewMultiLinkOuterConfigProvider r3 = this.b;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        r3.getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r2) == true) goto L11;
        return;
    L11:
        int r4 = com.bytedance.android.live.liveinteract.aimv.b.a;
        IPreviewMultiLinkOuterConfigProvider r6 = this.b;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        boolean r7 = com.bytedance.android.live.liveinteract.aimv.b.b(r6.getRoom());
        BaseLinkSeatWindowView r8 = null;
        if ((CollectionsKt.firstOrNull(r5) instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == false) goto L17;
    L31:
        BaseLinkSeatWindowView r9 = this.g;
        if ((r9 instanceof VoiceCommonLinkSeatWindowView) == false) goto L35;
        r8 = r9;
    L35:
        VoiceCommonLinkSeatWindowView r10 = (VoiceCommonLinkSeatWindowView) r8;
        if (r10 == null) goto L41;
        r10.Ha(this.d, r7);
        return;
    L41:
        return;
    L17:
        if (this.V1 == 30) goto L19;
    L20:
        if (r7 == true) goto L22;
    L24:
        BaseLinkSeatWindowView r11 = this.g;
        if ((r11 instanceof VoiceCommonLinkSeatWindowView) == false) goto L28;
        r8 = r11;
    L28:
        VoiceCommonLinkSeatWindowView r12 = (VoiceCommonLinkSeatWindowView) r8;
        if (r12 == null) goto L39;
        r12.jf();
        return;
    L39:
        return;
    L22:
        if (this.V1 != 26) goto L24;
    L19:
        if ((CollectionsKt.firstOrNull(r5) instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L31;
        goto L20
    }

    public final void G(List<? extends tf0.e> r4) {
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L23;
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
        IPreviewMultiLinkOuterConfigProvider r6 = this.b;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        IRoom r7 = r6.getRoom();
        if (r7 == null) goto L21;
        Object r8 = r7.getAnchorId();
        if (r8 == null) goto L21;
    L22:
        r3.put("EXT_KEY_ANCHOR_ID", r8);
    L21:
        r8 = 0L;
        goto L22
    }

    public final void J(IOrderSingSyncData r2) {
        if (r2 == null) goto L4;
        IOrderSingMVInfo r0 = r2.getMvInfo();
    L5:
        if (r0 == null) goto L13;
        h0(r2.getMvInfo(), false);
        IRoom r3 = this.G;
        if (r3 == null) goto L24;
        IVoiceLiveTheme r4 = r3.getVoiceLiveTheme();
        if (r4 == null) goto L25;
        this.h1 = false;
        com.bytedance.android.live.ui.q r1 = this.s;
        if (r1 == null) goto L26;
        r1.d(r4);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L13:
        IRoom r5 = this.G;
        if (r5 == null) goto L20;
        IVoiceLiveTheme r6 = r5.getVoiceLiveTheme();
        if (r6 == null) goto L20;
        this.h1 = true;
        com.bytedance.android.live.ui.q r7 = this.s;
        if (r7 == null) goto L20;
        r7.c(r6);
    L20:
        InteractiveSongMvManager r8 = this.p;
        if (r8 == null) goto L28;
        r8.c();
        return;
    L28:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void Q(qb r7) {
        ng0.e r0 = this.B;
        pn0.f.c r2 = null;
        if (r0 != null) goto L15;
        ConstraintLayout r3 = this.g;
        if (r3 == null) goto L7;
        RadioTextBoardView r4 = (RadioTextBoardView) r3.findViewById(2131383612);
    L9:
        if ((r4 instanceof RadioTextBoardView) == true) goto L11;
        r4 = null;
    L11:
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        r0 = new ng0.e(r4, r5.getFeedLiveType(), this.E);
        goto L15
    L7:
        r4 = null;
    L15:
        this.B = r0;
        if (r0.b() == true) goto L18;
        return;
    L18:
        if (this.B != null) goto L20;
    L89:
        ng0.e r1 = this.B;
        if (r1 == null) goto L100;
        r1.d(r7);
        return;
    L100:
        return;
    L20:
        if (ng0.e.c(r7) != true) goto L89;
        boolean r6 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        IPreviewMultiLinkOuterConfigProvider r8 = this.b;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L24:
        int r9 = r8.getShowFrom();
        IPreviewMultiLinkOuterConfigProvider r10 = this.b;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L27:
        r10.getRoom();
        int r11 = 0;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r9) == false) goto L69;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12 = this.d;
        if (r12 == null) goto L36;
        pn0.f r13 = r12.d;
        if (r13 == null) goto L36;
        List<pn0.f.c> r14 = r13.d;
        if (r14 == null) goto L36;
        int r15 = r14.size();
    L37:
        if (r15 <= 0) goto L96;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r16 = this.d;
        if (r16 == null) goto L45;
        pn0.f r17 = r16.d;
        if (r17 == null) goto L45;
        List<pn0.f.c> r18 = r17.d;
        if (r18 == null) goto L45;
        r2 = (pn0.f.c) CollectionsKt.firstOrNull(r18);
    L45:
        if (r2 == null) goto L47;
        int r19 = r2.c;
    L48:
        Integer r20 = Integer.valueOf(r19);
        if (r2 == null) goto L51;
        int r21 = r2.d;
    L52:
        Pair r22 = TuplesKt.to(r20, Integer.valueOf(r21));
        if (r2 == null) goto L55;
        int r23 = r2.e;
    L56:
        Integer r24 = Integer.valueOf(r23);
        if (r2 == null) goto L59;
        int r25 = r2.f;
    L60:
        Pair r26 = TuplesKt.to(r24, Integer.valueOf(r25));
        BaseLinkSeatWindowView r27 = this.g;
        if (r27 == null) goto L65;
        ConstraintLayout.LayoutParams r28 = r27.getCurRvLayoutParams();
        if (r28 == null) goto L65;
        r11 = ((ViewGroup.MarginLayoutParams) r28).topMargin;
    L65:
        ng0.e r29 = this.B;
        if (r29 == null) goto L93;
        r29.a((r11 + ((Number) r22.getSecond()).intValue()) + ((Number) r26.getSecond()).intValue(), r7);
        return;
    L93:
        return;
    L59:
        r25 = 0;
        goto L60
    L55:
        r23 = 0;
        goto L56
    L51:
        r21 = 0;
        goto L52
    L47:
        r19 = 0;
        goto L48
    L96:
        return;
    L36:
        r15 = 0;
        goto L37
    L69:
        BaseLinkSeatWindowView r30 = this.g;
        if (r30 == null) goto L74;
        RecyclerView r31 = r30.getRecyclerView();
        if (r31 == null) goto L74;
        int r32 = r31.getChildCount();
    L75:
        if (r32 <= 0) goto L97;
        BaseLinkSeatWindowView r33 = this.g;
        if (r33 == null) goto L98;
        ug0.a r34 = r33.getRvLayoutManager();
        if (r34 == null) goto L99;
        Pair<Integer, Integer> r35 = r34.c(0);
        Pair<Integer, Integer> r36 = r34.a(0);
        BaseLinkSeatWindowView r37 = this.g;
        if (r37 == null) goto L85;
        RecyclerView r38 = r37.getRecyclerView();
        if (r38 == null) goto L85;
        r11 = r38.getTop();
    L85:
        ng0.e r39 = this.B;
        if (r39 == null) goto L94;
        r39.a((r11 + ((Number) r35.getSecond()).intValue()) + ((Number) r36.getSecond()).intValue(), r7);
        return;
    L94:
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    L74:
        r32 = 0;
        goto L75
    }

    public final boolean V(IRoom r6) {
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.c(r6) == false) goto L29;
        z5 r7 = r6.getLinkerDetail();
        if (r7 == null) goto L7;
        Integer r8 = Integer.valueOf(r7.getUiLayout());
    L8:
        ArrayList<Integer> r1 = this.Q1;
        if (r1 != null) goto L11;
    L13:
        boolean r2 = false;
    L15:
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.a(r8, false, r2) == true) goto L17;
        return false;
    L17:
        if (getPlayModes().contains(Long.valueOf(32)) == false) goto L31;
        int r9 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        LinkFeedTypeConstant.Companion r10 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r3 = this.b;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        if (r10.isDouyinFullScreen(r3.getFeedLiveType()) == true) goto L24;
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
    L11:
        if (r1.contains(8) != true) goto L13;
        r2 = true;
        goto L15
    L7:
        r8 = null;
        goto L8
    L29:
        return false;
    }

    public final void a0(IRoom r4) {
        this.h1 = true;
        BaseLinkSeatWindowView r1 = this.g;
        if (r1 == null) goto L7;
        ClipImageView r2 = r1.getThemeBgView();
        if (r2 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r2);
    L7:
        BaseLinkSeatWindowView r3 = this.g;
        if (r3 == null) goto L12;
        ClipImageView r5 = r3.getDynamicClipBg();
        if (r5 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r5);
    L12:
        if (r4 == null) goto L14;
        IVoiceLiveTheme r6 = r4.getVoiceLiveTheme();
    L15:
        com.bytedance.android.live.ui.q r7 = this.s;
        if (r7 == null) goto L18;
        r7.c(r6);
    L18:
        f0(r4);
        if (vm2.d.s0() == false) goto L28;
        if (r4 == null) goto L28;
        IVoiceLiveTheme r8 = r4.getVoiceLiveTheme();
        if (r8 == null) goto L28;
        if (r8.isUgcImage() != true) goto L28;
        RadioDarkMaskView r9 = this.q;
        if (r9 == null) goto L32;
        UtilityKotlinExtentionsKt.w(r9);
        return;
    L32:
        return;
    L28:
        RadioDarkMaskView r10 = this.q;
        if (r10 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r10);
        return;
    L34:
        return;
    L14:
        r6 = null;
        goto L15
    }

    public final void b0(cj r3) {
        ALogger.i("RadioStageContainerWidget", "[voice_feed_view] wrds radioGiftMessageState:" + r3);
        Integer r0 = r3.msgType;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 1) goto L20;
        cj.f r4 = r3.metaContent;
        if (r4 == null) goto L10;
        Boolean r5 = r4.isActivate;
    L12:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L16;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r6 = this.x1;
        if (r6 == null) goto L21;
        r6.e = true;
        r6.h(MultiLinkOpenSource.MESSAGE);
        return;
    L21:
        return;
    L16:
        com.bytedance.android.live.liveinteract.voicechat.radio.k r7 = this.x1;
        if (r7 == null) goto L23;
        r7.e = false;
        r7.i(MultiLinkOpenSource.MESSAGE);
        return;
    L23:
        return;
    L10:
        r5 = null;
        goto L12
    }

    public final void c0(final qb r5) {
        LinkFeedTypeConstant.Companion r0 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r0.isDouyinFullScreen(r1.getShowFrom()) == false) goto L41;
        LinkMicRecyclerView r2 = null;
        if ((r5 instanceof o0) == true) goto L10;
        qb r3 = null;
    L11:
        o0 r4 = (o0) r3;
        if (r4 == null) goto L16;
        CommonMessageData r6 = ((BaseMessage) r4).baseMessage;
        if (r6 == null) goto L16;
        Long r7 = Long.valueOf(r6.roomId);
    L17:
        IRoom r8 = this.G;
        if (r8 == null) goto L20;
        Long r9 = Long.valueOf(r8.getId());
    L22:
        if (Intrinsics.areEqual(r7, r9) == false) goto L42;
        int r10 = ng0.e.f;
        BaseLinkSeatWindowView r11 = this.g;
        if (r11 == null) goto L27;
        r2 = r11.getRecyclerView();
    L27:
        if (ng0.e.a.a(r2) == false) goto L29;
        Q(r5);
        return;
    L29:
        BaseLinkSeatWindowView r12 = this.g;
        if (r12 == null) goto L34;
        RecyclerView r13 = r12.getRecyclerView();
        if (r13 == null) goto L34;
        int r14 = r13.getChildCount();
    L35:
        if (r14 <= 0) goto L39;
        ConstraintLayout r15 = this.g;
        if (r15 == null) goto L44;
        int r16 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        this.S1.add(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r15, new MultiLinkCommonVoiceFeedPreview$realConsumeRadioTextContainerMessage$1(this, r5)));
        return;
    L44:
        return;
    L39:
        this.m = r5;
        return;
    L34:
        r14 = 0;
        goto L35
    L42:
        return;
    L20:
        r9 = null;
    L16:
        r7 = null;
        goto L17
    L10:
        r3 = r5;
        goto L11
    }

    public final void d0(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r30) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.d;
        this.d = r30;
        Triple<Integer, Integer, Float> r3 = M(r30.m(), r30.getUiLayout(), getContainerWidth(), getContainerHeight());
        int r4 = ((Number) r3.component1()).intValue();
        int r15 = ((Number) r3.component2()).intValue();
        float r5 = ((Number) r3.component3()).floatValue();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6 = this.d;
        Intrinsics.checkNotNull(r6);
        r6.d = yg0.h.a(r6, new Triple(Integer.valueOf(r4), Integer.valueOf(r15), "MultiLinkCommonVoiceFeedPreview#updateLayoutConfigResultIfNeed"), getLivePlayerVideoSize());
        if (this.d != null) goto L5;
        return;
    L5:
        IPreviewMultiLinkOuterConfigProvider r7 = this.b;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        IRoom r8 = r7.getRoom();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r9 = this.d;
        Intrinsics.checkNotNull(r9);
        boolean r10 = MultiLinkLoadWidgetUtils.g();
        int r19 = 0;
        if (this.t != null) goto L11;
    L13:
        if (r10 == true) goto L45;
        BaseLinkSeatWindowView r11 = this.g;
        if (r11 == null) goto L17;
        HSImageView r22 = r11.getThemeBgView();
    L18:
        BaseLinkSeatWindowView r12 = this.g;
        if (r12 == null) goto L21;
        HSImageView r23 = r12.getDynamicClipBg();
    L22:
        this.t = new com.bytedance.android.live.liveinteract.feed.d0(false, r22, r23, null, new w(this), 56);
        ALogger.e("MultiLinkThemeBgUIWidget", "VOICE feedView, initTheme");
        com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a r13 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
        com.bytedance.android.live.liveinteract.feed.d0 r14 = this.t;
        Intrinsics.checkNotNull(r14);
        x r16 = new x(this, r8);
        Intrinsics.checkNotNullParameter(r14, "element");
        ((com.bytedance.android.live.ui.q.a) r13).a = r14;
        ((com.bytedance.android.live.ui.q.a) r13).d = r16;
        this.s = r13.a();
        int r17 = this.v;
        boolean r18 = true;
        if (r17 != 25) goto L25;
        boolean r20 = true;
    L26:
        if (r20 == false) goto L28;
    L35:
        k0(r8);
    L36:
        this.r = K(r9, r4, r15);
        if (r8 == null) goto L46;
        IRoomBasisData r21 = r8.getBasisRoomData();
        if (r21 == null) goto L41;
        Boolean r24 = r21.isCustomizeAudioRoom();
    L43:
        if (Intrinsics.areEqual(r24, Boolean.TRUE) == false) goto L46;
        k0(r8);
        goto L46
    L41:
        r24 = null;
    L46:
        O();
        IPreviewMultiLinkOuterConfigProvider r25 = this.b;
        if (r25 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L49:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r25, "MultiLinkCommonVoiceFeedPreview", hashCode(), "realInit " + this.E, false, 8, null);
        IPreviewMultiLinkOuterConfigProvider r26 = this.b;
        if (r26 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L52:
        IRoom r27 = r26.getRoom();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r110 = this.d;
        Intrinsics.checkNotNull(r110);
        MultiLinkCommonItemDecoration r28 = new MultiLinkCommonItemDecoration(r110, s1.f(2.0f), new ColorDrawable(s1.h(2131108427)));
        BaseLinkSeatWindowView r29 = this.g;
        if (r29 == null) goto L58;
        DataCenter r31 = this.E;
        IPreviewMultiLinkOuterConfigProvider r32 = this.b;
        if (r32 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L57:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.b(r29, r27, r31, r110, r28, null, null, r4, r15, r32.getShowFrom(), null, null, 1536);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r33 = r110;
        int r34 = r15;
    L59:
        F(r33, r4, r34, r5);
        ConstraintLayout r35 = this.g;
        if (r35 == null) goto L62;
        int r36 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        this.S1.add(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r35, new MultiLinkCommonVoiceFeedPreview$initLinkSeatView$1(this)));
    L62:
        int r37 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        IPreviewMultiLinkOuterConfigProvider r38 = this.b;
        if (r38 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L66:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r38.getShowFrom()) == false) goto L98;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r39 = this.d;
        Intrinsics.checkNotNull(r39);
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r40 = r39.h();
        if (r40 == null) goto L70;
        int r41 = r40.size();
    L71:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r42 = r39.k();
        if (r42 == null) goto L74;
        r19 = r42.size();
    L74:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r111 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r41 + r19);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r43 = this.n;
        if (r43 == null) goto L77;
        r43.d();
    L77:
        te0.a r44 = this.c;
        if (r44 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L80:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r112 = r44.c();
        if (r112 == null) goto L89;
        IPreviewMultiLinkOuterConfigProvider r45 = this.b;
        if (r45 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L85:
        IRoom r46 = r45.getRoom();
        DataCenter r47 = this.E;
        IPreviewMultiLinkOuterConfigProvider r48 = this.b;
        if (r48 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L88:
        this.n = new WindowListHelperV2(r46, r47, false, r39, r111, r112, r48.getShowFrom());
    L89:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r49 = this.n;
        if (r49 == null) goto L92;
        r49.b();
    L92:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r50 = this.F;
        if (r50 == null) goto L95;
        r50.fd(this.n);
    L95:
        BaseLinkSeatWindowView r51 = this.g;
        if (r51 == null) goto L135;
        r51.y = this.n;
    L135:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r52 = this.n;
        if (r52 == null) goto L142;
        BehaviorSubject<List<tf0.e>> r53 = r52.b;
        if (r53 == null) goto L142;
        Observable r54 = RxUtilKt.h(r53);
        if (r54 == null) goto L142;
        Disposable r113 = r54.subscribe(new b0(this));
    L143:
        if (r113 == null) goto L145;
        this.T.add(r113);
    L145:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r55 = this.n;
        if (r55 == null) goto L156;
        BehaviorSubject<List<tf0.e>> r56 = r55.b;
        if (r56 == null) goto L156;
        List<? extends tf0.e> r57 = (List) r56.getValue();
        if (r57 == null) goto L156;
        G(r57);
        BaseLinkSeatWindowView r58 = this.g;
        if (r58 == null) goto L154;
        r58.O7(r57);
    L154:
        D(r57);
    L156:
        if (this.p != null) goto L166;
        boolean r59 = MultiLinkLoadWidgetUtils.g();
        InteractiveSongMvManager r60 = new InteractiveSongMvManager(getContext(), this.E);
        this.p = r60;
        if (r59 == true) goto L163;
        FrameLayout r61 = this.o;
        if (r61 == null) goto L166;
        r60.h(r61);
        goto L166
    L163:
        FrameLayout r62 = new FrameLayout(getContext());
        zd0.c r63 = new zd0.c(r62);
        int r65 = vd0.a.g;
        vd0.a.C0284a.a(this.E).b(3000, 3001, r63);
        InteractiveSongMvManager r66 = this.p;
        if (r66 == null) goto L166;
        r66.h(r62);
    L166:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r67 = this.d;
        Intrinsics.checkNotNull(r67);
        if (r1 != null) goto L169;
    L173:
        g0(r1, r67);
    L175:
        if (this.l != null) goto L177;
    L179:
        o0(r30);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = this.d;
        if (r2 == null) goto L183;
        g0(null, r2);
        return;
    L183:
        return;
    L177:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L179;
        J(this.l);
        goto L179
    L169:
        if (r1.j() != r67.j()) goto L173;
        if (r1.getUiLayout() != r67.getUiLayout()) goto L173;
    L142:
        r113 = null;
        goto L143
    L70:
        r41 = 0;
        goto L71
    L98:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r68 = this.d;
        Intrinsics.checkNotNull(r68);
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r69 = r68.h();
        if (r69 == null) goto L101;
        int r70 = r69.size();
    L102:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r71 = r68.k();
        if (r71 == null) goto L105;
        r19 = r71.size();
    L105:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r72 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r70 + r19);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r73 = this.n;
        if (r73 == null) goto L108;
        r73.d();
    L108:
        te0.a r74 = this.c;
        if (r74 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L111:
        ue0.c r114 = r74.f();
        if (r114 == null) goto L120;
        IPreviewMultiLinkOuterConfigProvider r75 = this.b;
        if (r75 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L116:
        IRoom r76 = r75.getRoom();
        DataCenter r77 = this.E;
        IPreviewMultiLinkOuterConfigProvider r78 = this.b;
        if (r78 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L119:
        this.n = new com.bytedance.android.live.liveinteract.feed.datamerge.i(r76, r77, r68, r72, r114, r78.getShowFrom());
    L120:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r115 = this.n;
        if ((r115 instanceof com.bytedance.android.live.liveinteract.feed.datamerge.i) == true) goto L123;
        r115 = null;
    L123:
        com.bytedance.android.live.liveinteract.feed.datamerge.i r116 = (com.bytedance.android.live.liveinteract.feed.datamerge.i) r115;
        if (r116 == null) goto L129;
        IPreviewMultiLinkOuterConfigProvider r79 = this.b;
        if (r79 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L128:
        r116.x(r79.getRoom());
    L129:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r80 = this.F;
        if (r80 == null) goto L132;
        r80.fd(this.n);
    L132:
        BaseLinkSeatWindowView r81 = this.g;
        if (r81 == null) goto L135;
        r81.y = this.n;
        goto L135
    L101:
        r70 = 0;
        goto L102
    L58:
        r33 = r110;
        r34 = r15;
        goto L59
    L28:
        if (Intrinsics.areEqual(this.H0, Boolean.TRUE) == true) goto L30;
    L32:
        r18 = false;
    L33:
        if (r18 == true) goto L35;
        a0(r8);
        goto L36
    L30:
        if (r17 != 28) goto L32;
    L25:
        r20 = false;
        goto L26
    L21:
        r23 = null;
        goto L22
    L17:
        r22 = null;
        goto L18
    L45:
        this.r = K(r9, r4, r15);
        H();
        goto L46
    L11:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L13;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void f(qb r1) {
        if (r1 == null) goto L5;
        c0(r1);
        return;
    }

    public final void f0(IRoom r5) {
        if (r5 == null) goto L7;
        IVoiceLiveTheme r6 = r5.getVoiceLiveTheme();
        if (r6 == null) goto L7;
        JsonObject r7 = GsonProtectorUtils.toJsonTree(GsonHelper.get(), r6).getAsJsonObject();
        if (r7 == null) goto L7;
    L8:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.F;
        if (r0 == null) goto L12;
        r0.Dk("seat", "bg_theme", r7, false);
        return;
    L12:
        return;
    L7:
        r7 = new JsonObject();
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.c
    public final void g(boolean r2) {
        this.O = r2;
        if (r2 == false) goto L15;
        HybridCard r3 = this.P;
        if (r3 == null) goto L12;
        if (r3 == null) goto L8;
        r3.release();
    L8:
        ConstraintLayout r4 = t(2131378052);
        if (r4 == null) goto L11;
        r4.removeView(this.P);
    L11:
        this.P = null;
    L12:
        UtilityKotlinExtentionsKt.t(getLinkmicSubtitleRootContainer());
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r5 = this.I;
        if (r5 == null) goto L15;
        r5.a();
    L15:
        n0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.widget.FrameLayout, com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void h(SeiAppData r12) {
        Intrinsics.checkNotNullParameter(r12, "seiAppData");
        if (Lists.isEmpty(r12.getGrids()) == false) goto L5;
        return;
    L5:
        BaseLinkSeatWindowView r0 = this.g;
        if (r0 == null) goto L8;
        r0.x = Integer.valueOf(r12.getSubUILayout());
    L8:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.F;
        if (r1 == null) goto L11;
        r1.Wf(Integer.valueOf(r12.getSubUILayout()));
    L11:
        Boolean r2 = this.H0;
        String r3 = r12.getShowPlayer();
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        Boolean r5 = Boolean.valueOf(r4);
        this.H0 = r5;
        if ((!Intrinsics.areEqual(r2, r5)) == false) goto L20;
        P();
    L20:
        DataCenter r6 = this.E;
        if (r6 == null) goto L27;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r7 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r6);
        if (r7 == null) goto L25;
        r7.Aj(this.V1);
    L25:
        if (r7 == null) goto L27;
        r7.fo(Intrinsics.areEqual(this.H0, Boolean.TRUE));
    L27:
        IPreviewMultiLinkOuterConfigProvider r8 = this.b;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L30:
        IRoom r9 = r8.getRoom();
        List r10 = null;
        if (Intrinsics.areEqual(this.H0, Boolean.FALSE) == false) goto L40;
        if (this.h1 == true) goto L35;
    L38:
        a0(r9);
    L68:
        Boolean r11 = this.H0;
        InteractiveSongContext.a r13 = InteractiveSongContext.Companion;
        InteractiveSongContext r14 = r13.getContext();
        if (r14 == null) goto L73;
        com.bytedance.live.datacontext.m<Boolean> r15 = r14.isShowPlayer();
        if (r15 == null) goto L73;
        Boolean r16 = (Boolean) r15.getValue();
    L75:
        if ((!Intrinsics.areEqual(r11, r16)) == false) goto L86;
        Boolean r17 = this.H0;
        if (r17 == null) goto L86;
        boolean r18 = r17.booleanValue();
        InteractiveSongContext r19 = r13.getContext();
        if (r19 == null) goto L83;
        com.bytedance.live.datacontext.m<Boolean> r20 = r19.isShowPlayer();
        if (r20 == null) goto L83;
        r20.setValue(Boolean.valueOf(r18));
    L83:
        DataCenter r21 = this.E;
        if (r21 == null) goto L86;
        r21.put("data_interactive_song_show_player_status_change", Boolean.valueOf(r18));
    L86:
        JSONObject r22 = this.u;
        SeiCanvas r23 = r12.getCanvas();
        if (r23 == null) goto L89;
        Integer r24 = Integer.valueOf(r23.getWidth());
    L90:
        r22.put("width", r24);
        JSONObject r25 = this.u;
        SeiCanvas r26 = r12.getCanvas();
        if (r26 == null) goto L93;
        Integer r27 = Integer.valueOf(r26.getHeight());
    L94:
        r25.put("height", r27);
        this.v = r12.getUiLayout();
        this.M1 = r12.getHideAudioBg();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L102;
        int r28 = vd0.a.g;
        vd0.a r29 = vd0.a.C0284a.a(this.E);
        if (this.M1 != 2) goto L99;
        boolean r30 = true;
    L100:
        r29.d(r30);
        goto L102
    L99:
        r30 = false;
    L102:
        if (vm2.d.S0() == false) goto L136;
        JSONArray r31 = r12.getUiFeatureList();
        if (r31 == null) goto L109;
        int r32 = r31.length();
        ArrayList r33 = new ArrayList(r32);
        int r34 = 0;
    L106:
        if (r34 >= r32) goto L108;
        r33.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r31, r34)));
        r34 = r34 + 1;
        goto L106
    L108:
        r10 = r33;
    L110:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r10.iterator();
    L112:
        if (r36.hasNext() == false) goto L119;
        Object r37 = r36.next();
        if (((Number) r37).intValue() != 8) goto L116;
        boolean r38 = true;
    L117:
        if (r38 == false) goto L112;
        r35.add(r37);
        goto L112
    L116:
        r38 = false;
        goto L117
    L119:
        ClientUIInfo r39 = this.x;
        if (r39 == null) goto L132;
        List r40 = r39.getUiFeatureList();
        if (r40 == null) goto L132;
        ?? r41 = new ArrayList();
        Iterator r42 = r40.iterator();
    L125:
        if (r42.hasNext() == false) goto L133;
        Object r43 = r42.next();
        if (((Number) r43).intValue() == 8) goto L129;
        boolean r110 = true;
    L130:
        if (r110 == false) goto L125;
        r41.add(r43);
        goto L125
    L129:
        r110 = false;
    L133:
        List<Integer> r44 = CollectionsKt.sortedWith(CollectionsKt.plus(r35, (Iterable) r41), new f());
        boolean r45 = true ^ Intrinsics.areEqual(r44, this.P1);
        if (r45 == false) goto L138;
        this.P1 = r44;
    L138:
        if (this.x == null) goto L140;
    L141:
        if (r45 == true) goto L143;
    L149:
        te0.a r111 = this.c;
        if (r111 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L153:
        if (r111.shouldUseNewLivePlayerLayout() == false) goto L159;
        IPreviewMultiLinkOuterConfigProvider r112 = this.b;
        if (r112 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L158:
        if (r112.getFeedLiveType() == 5) goto L159;
        return;
    L159:
        post(new g(this));
        return;
    L143:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L149;
        this.y = false;
        JSONArray r113 = r12.getUiFeatureList();
        JSONObject r46 = new JSONObject();     // Catch: Exception -> L147
        r46.put("ui_feature_list", r113);     // Catch: Exception -> L147
        ClientUIInfo r47 = (ClientUIInfo) GsonHelper.get().fromJson(r46.toString(), new h().getType());     // Catch: Exception -> L147
        ALogger.d("MultiLinkCommonVoiceFeedPreview", "onSeiAppDataUpdated, use sei ui_feature_list data: " + r113 + ", " + r45);     // Catch: Exception -> L147
        l0(r47, r45, r10);     // Catch: Exception -> L147
    L147:
        e = move-exception;
        ALogger.e("CommonVideoFeedPreview", "parse ui_feature_list error, ", e);
        goto L149
    L140:
        if (this.y == true) goto L143;
    L132:
        r41 = CollectionsKt.emptyList();
        goto L133
    L109:
        r10 = CollectionsKt.emptyList();
        goto L110
    L136:
        r45 = false;
        goto L138
    L93:
        r27 = null;
        goto L94
    L89:
        r24 = null;
    L73:
        r16 = null;
        goto L75
    L35:
        if (this.M1 == r12.getHideAudioBg()) goto L68;
        if (r12.getHideAudioBg() != 1) goto L68;
    L40:
        if (r12.getHideAudioBg() != 2) goto L56;
        if (r9 == null) goto L43;
        IVoiceLiveTheme r48 = r9.getVoiceLiveTheme();
    L44:
        if (r48 != null) goto L46;
    L47:
        if (r48 != null) goto L49;
    L51:
        r48 = com.bytedance.android.livesdk.model.k.a();
    L52:
        this.h1 = false;
        com.bytedance.android.live.ui.q r49 = this.s;
        if (r49 == null) goto L56;
        r49.d(r48);
        goto L56
    L49:
        if (5 != r48.getBgType()) goto L51;
    L46:
        if (2 == r48.getBgType()) goto L52;
    L43:
        r48 = null;
    L56:
        if (r12.getUiLayout() != 25) goto L58;
        boolean r50 = true;
    L59:
        if (r50 == true) goto L67;
        int r51 = r12.getUiLayout();
        if (Intrinsics.areEqual(this.H0, Boolean.TRUE) == true) goto L63;
    L65:
        boolean r52 = false;
    L66:
        if (r52 == false) goto L68;
    L63:
        if (r51 != 28) goto L65;
        r52 = true;
    L67:
        k0(r9);
        goto L68
    L58:
        r50 = false;
        goto L59
    L14:
        if (r3.equals("true") != true) goto L16;
        r4 = true;
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void j(cj r1) {
        if (r1 == null) goto L5;
        b0(r1);
        return;
    }

    public final void k0(IRoom r4) {
        this.h1 = false;
        if (r4 == null) goto L5;
        IVoiceLiveTheme r5 = r4.getVoiceLiveTheme();
    L6:
        if (r5 != null) goto L8;
    L9:
        if (r5 != null) goto L11;
    L13:
        r5 = com.bytedance.android.livesdk.model.k.a();
    L14:
        com.bytedance.android.live.ui.q r1 = this.s;
        if (r1 == null) goto L17;
        r1.d(r5);
    L17:
        RadioDarkMaskView r6 = this.q;
        if (r6 == null) goto L20;
        UtilityKotlinExtentionsKt.t(r6);
    L20:
        BaseLinkSeatWindowView r7 = this.g;
        if (r7 == null) goto L25;
        ClipImageView r8 = r7.getThemeBgView();
        if (r8 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r8);
    L25:
        BaseLinkSeatWindowView r9 = this.g;
        if (r9 == null) goto L30;
        ClipImageView r10 = r9.getDynamicClipBg();
        if (r10 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r10);
    L30:
        this.t = null;
        this.s = null;
        return;
    L11:
        if (5 != r5.getBgType()) goto L13;
    L8:
        if (2 == r5.getBgType()) goto L14;
    L5:
        r5 = null;
        goto L6
    }

    public final void m0(int r5) {
        H();
        Path r0 = new Path();
        if (((Boolean) s2.a.getValue()).booleanValue() == false) goto L13;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.d;
        if (r1 != null) goto L7;
    L8:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = this.d;
        if (r2 == null) goto L13;
        if (r2.getUiLayout() != 30) goto L13;
    L12:
        float r3 = s1.f(8.0f);
        float r4 = s1.f(8.0f);
    L14:
        com.bytedance.android.live.liveinteract.videotalk.utils.c r6 = this.r;
        if (r6 == null) goto L17;
        Path r7 = r6.a(r5, r3, r4);
    L18:
        r0.addPath(r7);
        if (vm2.h.h0().f() == false) goto L27;
        if (r5 < 0) goto L24;
        com.bytedance.android.live.liveinteract.feed.d0 r8 = this.t;
        if (r8 == null) goto L27;
        r8.k();
        goto L27
    L24:
        com.bytedance.android.live.liveinteract.feed.d0 r9 = this.t;
        if (r9 == null) goto L27;
        r9.n();
    L27:
        com.bytedance.android.live.liveinteract.feed.d0 r10 = this.t;
        if (r10 == null) goto L31;
        r10.o(r0);
        return;
    L31:
        return;
    L17:
        r7 = new Path();
        goto L18
    L7:
        if (r1.getUiLayout() == 27) goto L12;
    L13:
        r3 = 0.0f;
        r4 = 0.0f;
        goto L14
    }

    public final void o0(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        boolean r4 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L7:
        int r6 = r5.getShowFrom();
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L10:
        r1.getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r6) == false) goto L18;
        View r7 = this.j;
        if (r7 == null) goto L15;
        UtilityKotlinExtentionsKt.u(r7);
    L15:
        View r8 = this.k;
        if (r8 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r8);
        return;
    L25:
        return;
    L18:
        View r9 = this.j;
        if (r9 == null) goto L21;
        UtilityKotlinExtentionsKt.w(r9);
    L21:
        View r10 = this.k;
        if (r10 == null) goto L27;
        UtilityKotlinExtentionsKt.w(r10);
        return;
    }

    public final void setAnimRecyclerView(View r1) {
        this.k = r1;
    }

    public final void setBaseWindowView(BaseLinkSeatWindowView r1) {
        this.g = r1;
    }

    public final void setBaseWindowViewContainer(FrameLayout r1) {
        this.h = r1;
    }

    public final void setDynamicWidget(com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1) {
        this.F = r1;
    }

    public final void setFeedDataCenter(DataCenter r1) {
        this.E = r1;
    }

    public final void setMViewModelStore(ViewModelStore r1) {
        this.C = r1;
    }

    public final void setRecyclerView(View r1) {
        this.j = r1;
    }

    public final void setSubtitleIsOpen(boolean r1) {
        this.N = r1;
    }

    public final void setViewModelProvider(ViewModelProvider r1) {
        this.D = r1;
    }

    public final View t(int r3) {
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

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateMvControllerSei(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sei");
        Object r3 = null;
        if (StringsKt.contains$default(r5, "audio_mv_sei", false, 2, null) == false) goto L19;
        Object r6 = new JSONObject(r5).get("audio_mv_sei");
        if ((r6 instanceof JSONObject) == false) goto L8;
        r3 = r6;
    L8:
        JSONObject r4 = (JSONObject) r3;
        if (r4 != null) goto L11;
        return;
    L11:
        InteractiveSongMvManager r7 = this.p;
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.g(r4, this.S) != true) goto L21;
        InteractiveSongMvManager r8 = this.p;
        if (r8 == null) goto L22;
        r8.d(true, false);
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "wrds");
        Intrinsics.checkNotNullParameter(r2, "wrds");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioTextSei(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "sei");
        LinkFeedTypeConstant.Companion r0 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r0.isDouyinFullScreen(r1.getShowFrom()) == false) goto L15;
        ng0.e r2 = this.B;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.a == false) goto L17;
        RadioTextBoardView r3 = r2.c;
        if (r3 == null) goto L18;
        r3.R5(r4);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
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
        this.G1 = r4;
        this.H1 = r9;
        if ((!Intrinsics.areEqual(this.g1, Boolean.valueOf(r3))) == false) goto L30;
        this.g1 = Boolean.valueOf(r3);
        JsonObject r10 = new JsonObject();
        r10.addProperty("type", Integer.valueOf(SubtitleEventType.SHOW_LYRICS.ordinal()));
        r10.addProperty("show_recognition_lyrics", Boolean.valueOf(r3));
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r5 = this.F;
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

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRhythmSei(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sei");
        if (vm2.c.g() == true) goto L5;
        return;
    L5:
        ALogger.i("MultiLinkCommonVoiceFeedPreview", "updateSpeechRhythmSei, sei: " + r8);
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
        r5.addProperty("emo", this.G1);
        r5.addProperty("refrain", Integer.valueOf(this.H1));
        Float r12 = getCurrentFrameLightValue();
        if (r12 == null) goto L14;
        r5.addProperty("light", Float.valueOf(r12.floatValue()));
    L14:
        InteractiveSongContext r13 = InteractiveSongContext.Companion.getContext();
        if (r13 == null) goto L17;
        r13.setRecordeLastSpeechRhythmBeats(r5);
    L17:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r14 = this.F;
        if (r14 == null) goto L22;
        r14.Dk("audiochat_stage", "speech_effect", r5, false);
        return;
    L22:
        return;
    L10:
        r11 = 0;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSubtitleSei(String r9) {
        Intrinsics.checkNotNullParameter(r9, "sei");
        List r1 = null;
        boolean r3 = true;
        if (L() == true) goto L5;
    L13:
        LinkFeedTypeConstant.Companion r0 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        if (r0.isDouyinFullScreen(r5.getShowFrom()) == true) goto L19;
    L23:
        boolean r2 = false;
    L24:
        if (r2 == true) goto L26;
    L51:
        if (StringsKt.contains$default(r9, "audio_subtitle", false, 2, null) == false) goto L127;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r9) == true) goto L55;
    L123:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r9);
        return;
    L55:
        if (vm2.d.u() == true) goto L57;
    L125:
        String r4 = JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r9), "audio_subtitle");     // Catch: Exception -> L122
        if (r4 == null) goto L128;
        String r6 = JSONObjectProtectorUtils.getString(new JSONObject(r4), "subtitles");     // Catch: Exception -> L122
        if (r6 == null) goto L129;
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L122
        int r8 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;     // Catch: Exception -> L122
        IPreviewMultiLinkOuterConfigProvider r10 = this.b;     // Catch: Exception -> L122
        if (r10 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");     // Catch: Exception -> L122
    L68:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r10.getShowFrom()) == false) goto L77;
        te0.a r11 = this.c;     // Catch: Exception -> L122
        if (r11 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");     // Catch: Exception -> L122
    L72:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r12 = r11.c();     // Catch: Exception -> L122
        if (r12 == null) goto L85;
        BehaviorSubject<List<ch0.e>> r13 = r12.b;     // Catch: Exception -> L122
        if (r13 == null) goto L85;
        r1 = (List) r13.getValue();     // Catch: Exception -> L122
    L85:
        if (r1 == null) goto L90;
        Iterator r14 = r1.iterator();     // Catch: Exception -> L122
    L88:
        if (r14.hasNext() == false) goto L90;
        r7.add(((ch0.e) r14.next()).a);     // Catch: Exception -> L122
    L90:
        List<nj0.g> r15 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.e(r6, r7);     // Catch: Exception -> L122
        if (((ArrayList) r15).isEmpty() == false) goto L93;
        return;
    L93:
        List<nj0.g> r16 = com.bytedance.android.live.liveinteract.voicechat.subtitle.r.b;     // Catch: Exception -> L122
        if (this.O == true) goto L100;
        if (this.v1 == true) goto L100;
        r3 = false;
    L100:
        if (com.bytedance.android.live.liveinteract.voicechat.subtitle.r.a(r3, r15) == false) goto L102;
        return;
    L102:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.r.b(r15);     // Catch: Exception -> L122
        if (this.O == false) goto L109;
        int r17 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;     // Catch: Exception -> L122
        JsonObject r18 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r15);     // Catch: Exception -> L122
        r18.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));     // Catch: Exception -> L122
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r19 = this.F;     // Catch: Exception -> L122
        if (r19 == null) goto L130;
        r19.Dk("audiochat_stage", "subtitle", r18, false);     // Catch: Exception -> L122
        return;
    L130:
        return;
    L109:
        if (this.v1 == false) goto L114;
        int r20 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;     // Catch: Exception -> L122
        JsonObject r21 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r15);     // Catch: Exception -> L122
        r21.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));     // Catch: Exception -> L122
        com.bytedance.android.live.liveinteract.voicechat.radio.k r22 = this.x1;     // Catch: Exception -> L122
        if (r22 == null) goto L132;
        Intrinsics.checkNotNullParameter(r21, "extraObject");     // Catch: Exception -> L122
        r22.f(r21);     // Catch: Exception -> L122
        return;
    L132:
        return;
    L114:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L118;
        int r23 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;     // Catch: Exception -> L122
        JsonObject r24 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r15);     // Catch: Exception -> L122
        r24.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));     // Catch: Exception -> L122
        r24.addProperty("biz_id", "audiochat_stage");     // Catch: Exception -> L122
        JsonObject r25 = new JsonObject();     // Catch: Exception -> L122
        r25.add("data", r24);     // Catch: Exception -> L122
        r25.addProperty("type", "subtitle");     // Catch: Exception -> L122
        HybridCard r26 = this.P;     // Catch: Exception -> L122
        if (r26 == null) goto L134;
        r26.sendJsEvent("onLinkmicStatusChange", r25);     // Catch: Exception -> L122
        return;
    L134:
        return;
    L118:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r27 = this.I;     // Catch: Exception -> L122
        if (r27 == null) goto L136;
        r27.b(r15);     // Catch: Exception -> L122
        return;
    L136:
        return;
    L77:
        te0.a r28 = this.c;     // Catch: Exception -> L122
        if (r28 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");     // Catch: Exception -> L122
    L80:
        ue0.c r29 = r28.f();     // Catch: Exception -> L122
        if (r29 == null) goto L85;
        BehaviorSubject<List<ch0.e>> r30 = r29.b;     // Catch: Exception -> L122
        if (r30 == null) goto L85;
        r1 = (List) r30.getValue();     // Catch: Exception -> L122
        goto L85
    L129:
        return;
    L128:
        return;
    L122:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r9);
        return;
    L57:
        if (com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.d(r9) == true) goto L125;
    L127:
        return;
    L26:
        if (this.N == false) goto L51;
        if (getLinkmicSubtitleRootContainer().getVisibility() != 8) goto L51;
        if (this.O == true) goto L51;
        UtilityKotlinExtentionsKt.w(getLinkmicSubtitleRootContainer());
        q2 r31 = this.L;
        if (r31 != null) goto L34;
        int r32 = LinkmicSubtitleUIWidget.x;
    L38:
        this.Q = r32;
        if (vm2.c.b().getSubtitlePatchLynxEnable() == true) goto L41;
        com.bytedance.android.live.liveinteract.voicechat.subtitle.u r33 = this.I;
        if (r33 == null) goto L51;
        r33.e.removeCallbacksAndMessages(null);
        r33.e.sendEmptyMessage(1);
        goto L51
    L41:
        if (this.P != null) goto L51;
        int r34 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        HybridCard r35 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.f(getContext(), this.Q);
        this.P = r35;
        if (r35 == null) goto L51;
        r35.setLayoutParams(new ConstraintLayout.LayoutParams(this.Q, LinkmicSubtitleUIWidget.u));
        ConstraintLayout r36 = t(2131378052);
        if (r36 == null) goto L51;
        r36.addView(r35);
        goto L51
    L34:
        if (r31.getSubtitleStyle() != LinkmicSubtitleStyle.LONG.ordinal()) goto L36;
        r32 = LinkmicSubtitleUIWidget.w;
        goto L38
    L36:
        r32 = LinkmicSubtitleUIWidget.x;
        goto L38
    L19:
        if (this.J == false) goto L23;
        if (vm2.c.b().getAudioSubtitleGuestEnable() != true) goto L23;
        int r37 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        r2 = true;
        goto L24
    L5:
        if (this.J == false) goto L13;
        if (this.N == false) goto L13;
        if (this.v1 == true) goto L51;
        this.v1 = true;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r38 = this.x1;
        if (r38 == null) goto L51;
        r38.d();
        goto L51
    }

    public static final void A(MultiLinkCommonVoiceFeedPreview r12, com.bytedance.android.live.network.response.e r13) {
        if (r12.Z() == false) goto L75;
        int r0 = com.bytedance.android.live.liveinteract.aimv.b.a;
        IPreviewMultiLinkOuterConfigProvider r1 = r12.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L7:
        InteractiveSongContext.Companion.g(true, true, com.bytedance.android.live.liveinteract.aimv.b.b(r1.getRoom()), String.valueOf(19));
        k1 r2 = (k1) r13.data;
        IOrderSingInfoV2 r3 = null;
        if (r2 == null) goto L49;
        p2 r4 = r2.getLinkmicPlayModeInfo();
        if (r4 == null) goto L49;
        IOrderSingInfoV2 r5 = r4.getOrderSingInfo();
        if (r5 == null) goto L49;
        List r6 = r5.getUserMicrophoneList();
        if (r6 == null) goto L49;
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L49;
        IUserMicrophoneItem r8 = (IUserMicrophoneItem) r7.next();
        IBaseUser r9 = r8.getOrderUser();
        if (r9 == null) goto L21;
        String r10 = r9.getIdString();
    L22:
        int r11 = dg0.a.a;
        IMicrophoneItem r14 = dg0.a.a(r8.getMicrophoneList());
        if (r14 == null) goto L25;
        int r15 = r14.getMicroPhoneNum();
    L26:
        pf0.a r16 = new pf0.a(r10, r15, null, null, null, 28);
        InteractiveSongContext.a r17 = InteractiveSongContext.Companion;
        InteractiveSongContext r18 = r17.getContext();
        String r19 = "";
        if (r18 == null) goto L37;
        ConcurrentHashMap<String, pf0.a> r20 = r18.getGuestListInteractiveSongInfo();
        if (r20 == null) goto L37;
        IBaseUser r21 = r8.getOrderUser();
        if (r21 == null) goto L34;
        String r22 = r21.getIdString();
        if (r22 == null) goto L34;
    L35:
        pf0.a r23 = r20.put(r22, r16);
    L34:
        r22 = "";
    L37:
        if (r8.isSinging() == false) goto L17;
        InteractiveSongContext r24 = r17.getContext();
        if (r24 == null) goto L17;
        com.bytedance.live.datacontext.m<String> r25 = r24.getSingingGuestId();
        if (r25 == null) goto L17;
        IBaseUser r26 = r8.getOrderUser();
        if (r26 == null) goto L48;
        String r27 = r26.getIdString();
        if (r27 == null) goto L48;
        r19 = r27;
    L48:
        r25.setValue(r19);
        goto L17
    L25:
        r15 = 0;
        goto L26
    L21:
        r10 = null;
    L49:
        k1 r28 = (k1) r13.data;
        if (r28 == null) goto L56;
        p2 r29 = r28.getLinkmicPlayModeInfo();
        if (r29 == null) goto L56;
        IOrderSingInfoV2 r30 = r29.getOrderSingInfo();
        if (r30 == null) goto L56;
        IOrderSingMVInfo r31 = r30.getMvInfo();
    L57:
        r12.h0(r31, false);
        LiveLinkmicAIMVManager r110 = r12.y1;
        if (r110 == null) goto L76;
        k1 r111 = (k1) r13.data;
        if (r111 == null) goto L64;
        p2 r112 = r111.getLinkmicPlayModeInfo();
        if (r112 == null) goto L64;
        r3 = r112.getOrderSingInfo();
    L64:
        r110.b(r3);
        return;
    L76:
        return;
    L56:
        r31 = null;
        goto L57
    }

    public static final /* synthetic */ void B(MultiLinkCommonVoiceFeedPreview r0, List r1) {
        r0.setRadioStageVisible(r1);
    }

    public static final void w(MultiLinkCommonVoiceFeedPreview r10, l9 r11) {
        IPreviewMultiLinkOuterConfigProvider r0 = r10.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "MultiLinkCommonVoiceFeedPreview", r10.hashCode(), "consumeLinkmicPlaymodeMessage", false, 8, null);
        ConstraintLayout.LayoutParams r4 = null;
        if (StringsKt.equals$default(r11.getWrdsSubKeyFlex(), "SubtitleStatusSubSyncKey", false, 2, null) == false) goto L41;
        q2 r1 = r11.getLinkmicSubtitleSettingStatus();
        if (r1 == null) goto L25;
        r10.L = r1;
        if (r10.J == true) goto L23;
        r10.J = true;
        if (r10.K == true) goto L23;
        if (r10.G == null) goto L23;
        r10.K = true;
        r10.getLinkmicSubtitleRootContainer().post(new c0(r10, r1));
        r10.I = new com.bytedance.android.live.liveinteract.voicechat.subtitle.u(r10.getContext(), r10.G, r10.getLinkmicSubtitleRecyclerView(), (TextView) r10.t(2131387064));
        ConstraintLayout.LayoutParams r3 = r10.t(2131387653).getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L19;
        r4 = r3;
    L19:
        ConstraintLayout.LayoutParams r5 = r4;
        if (r5 == null) goto L22;
        ((ViewGroup.MarginLayoutParams) r5).height = r10.getDragContainerStubHeight();
    L22:
        r10.I = new com.bytedance.android.live.liveinteract.voicechat.subtitle.u(r10.getContext(), r10.G, r10.getLinkmicSubtitleRecyclerView(), (TextView) r10.t(2131387064));
        int r6 = r10.getDragContainerStubHeight() - r10.getLinkmicSubtitleHeight();
        int r7 = UtilityKotlinExtentionsKt.i(12);
        ConstraintLayout r8 = r10.getLinkmicSubtitleRootContainer();
        r8.setTranslationX(r7);
        r8.setTranslationY(r6);
    L23:
        r10.getLinkmicSubtitleRootContainer().post(new c0(r10, r1));
    L25:
        if (r11.getLinkmicSubtitleSettingStatus() == null) goto L27;
        boolean r12 = true;
    L29:
        if (r12 == r10.N) goto L42;
        r10.N = r12;
        r10.n0();
        if (r10.L() == true) goto L33;
        return;
    L33:
        if (r10.N == false) goto L37;
        r10.v1 = true;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r13 = r10.x1;
        if (r13 == null) goto L44;
        r13.d();
        return;
    L44:
        return;
    L37:
        r10.v1 = false;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r14 = r10.x1;
        if (r14 == null) goto L46;
        r14.e();
        return;
    L46:
        return;
    L42:
        return;
    L27:
        r12 = false;
        goto L29
    }

    public final int N(int r4, int r5) {
        if (getPlayModes().contains(Long.valueOf(7)) == true) goto L5;
    L20:
        if (r4 <= 0) goto L22;
        return r4;
    L22:
        IRoom r6 = this.G;
        if (r6 == null) goto L31;
        z5 r7 = r6.getLinkerDetail();
        if (r7 == null) goto L31;
        List r8 = r7.getPlayModes();
        if (r8 == null) goto L31;
        if (r8.contains(Long.valueOf(24)) != true) goto L31;
        return 21;
    L31:
        IRoom r9 = this.G;
        if (r9 == null) goto L41;
        z5 r10 = r9.getLinkerDetail();
        if (r10 == null) goto L42;
        List r11 = r10.getPlayModes();
        if (r11 != null) goto L38;
        return 21;
    L38:
        if (r11.contains(Long.valueOf(26)) != true) goto L44;
        return 22;
    L44:
        return 21;
    L42:
        return 21;
    L41:
        return 21;
    L5:
        if (this.W == true) goto L20;
        IRoom r12 = this.G;
        if (r12 == null) goto L11;
        z5 r13 = r12.getLinkerDetail();
        if (r13 == null) goto L11;
        String r14 = r13.getClientUiInfo();
    L12:
        ClientUIInfo r15 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(r14);
        if (this.k0 == true) goto L19;
        if (r15 == null) goto L20;
        List r16 = r15.getUiFeatureList();
        if (r16 == null) goto L20;
        if (r16.contains(3) == true) goto L20;
    L19:
        return 21;
    L11:
        r14 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void b(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "syncKey");
        Intrinsics.checkNotNullParameter(r1, "syncKey");
    }

    public final void g0(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r13) {
        int r1 = r13.j();
        int r2 = r13.getUiLayout();
        List r3 = CollectionsKt.emptyList();
        if (r12 == null) goto L5;
        int r4 = r12.j();
    L6:
        if (r12 == null) goto L8;
        int r5 = r12.getUiLayout();
    L9:
        nh0.f r14 = new nh0.f("linkmic", new nh0.e(r1, r2, r3, r4, r5, CollectionsKt.emptyList(), null, null, 192), null, null, null, null, false, 224);
        DataCenter r15 = this.E;
        if (r15 == null) goto L13;
        r15.put("data_multi_lick_dynamic_event_change", r14);
        return;
    L13:
        return;
    L8:
        r5 = -1;
        goto L9
    L5:
        r4 = -1;
        goto L6
    }

    public final void h0(IOrderSingMVInfo r2, boolean r3) {
        InteractiveSongMvManager r0 = this.p;
        if (r0 == null) goto L6;
        InteractiveSongMvManager.j(r0, r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void insertEffectView(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ConstraintLayout r4 = this.g;
        if (r4 == null) goto L5;
        ViewGroup r5 = (ViewGroup) r4.findViewById(2131371496);
    L6:
        if (r5 == null) goto L8;
        r5.addView(r2);
    L8:
        if (r5 == null) goto L11;
        r5.setVisibility(0);
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void o(IPreviewMultiLinkOuterConfigProvider r14, te0.a r15) {
        Intrinsics.checkNotNullParameter(r14, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r15, "configInnerProvider");
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r14, "MultiLinkCommonVoiceFeedPreview", hashCode(), "init configOuterProvider=" + r14 + ", configInnerProvider=" + r15, false, 8, null);
        this.b = r14;
        this.c = r15;
        this.G = r14.getRoom();
        z5 r2 = r14.getRoom().getLinkerDetail();
        if (r2 == null) goto L5;
        String r3 = r2.getClientUiInfo();
    L6:
        this.x = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(r3);
        StringBuilder r4 = new StringBuilder("init, use room clientUiInfo#uiFeatureList data: ");
        ClientUIInfo r5 = this.x;
        if (r5 == null) goto L9;
        List r6 = r5.getUiFeatureList();
    L10:
        r4.append(r6);
        ALogger.d("MultiLinkCommonVoiceFeedPreview", r4.toString());
        xs2.b.a().post(new v1(r14.getRoom().getId(), this.V1, this.x));
        this.g = (BaseLinkSeatWindowView) findViewById(2131378011);
        this.h = (FrameLayout) findViewById(2131378012);
        this.i = findViewById(2131370478);
        ConstraintLayout r16 = this.g;
        if (r16 == null) goto L13;
        View r17 = r16.findViewById(2131378009);
    L14:
        this.j = r17;
        ConstraintLayout r18 = this.g;
        if (r18 == null) goto L17;
        View r19 = r18.findViewById(2131378008);
    L18:
        this.k = r19;
        this.o = (FrameLayout) findViewById(2131375554);
        this.q = (RadioDarkMaskView) findViewById(2131383598);
        this.v = this.V1;
        this.w = r15.a();
        BaseLinkSeatWindowView r110 = this.g;
        if (r110 == null) goto L21;
        r110.x = this.g2;
    L21:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r111 = this.F;
        if (r111 == null) goto L24;
        r111.Wf(this.g2);
    L24:
        i0();
        if (((Boolean) jb0.a.getValue()).booleanValue() == false) goto L30;
        LifecycleRegistry r112 = this.T1;
        if (r112 == null) goto L30;
        r112.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    L30:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L32;
        com.bytedance.android.live.core.utils.i0.c().post(new d(this));
    L32:
        ConstraintLayout r113 = this.g;
        if (r113 == null) goto L35;
        ViewGroup r114 = (ViewGroup) r113.findViewById(2131371496);
    L36:
        IPreviewMultiLinkOuterConfigProvider r115 = this.b;
        if (r115 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L39:
        r115.onMultiLinkFeedViewCreate(r114);
        T();
        IPreviewMultiLinkOuterConfigProvider r116 = this.b;
        if (r116 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L42:
        LivePlayerView r117 = r116.getLivePlayerView();
        if (r117 == null) goto L45;
        IRenderView r118 = r117.getRenderView();
    L46:
        this.f = r118;
        C();
        int r119 = c1.a;
        if (c1.a(0, Integer.valueOf(this.v)) == false) goto L62;
        IPreviewMultiLinkOuterConfigProvider r120 = this.b;
        if (r120 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L51:
        IPreviewPlayerContainerAbility r121 = r120.getPlayerContainerAbility();
        if (r121 == null) goto L62;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        if ((r122 instanceof FrameLayout.LayoutParams) == true) goto L56;
        r122 = null;
    L56:
        FrameLayout.LayoutParams r123 = (FrameLayout.LayoutParams) r122;
        if (r123 == null) goto L62;
        if (r123.topMargin == 0) goto L62;
        r123.topMargin = 0;
    L62:
        if (vm2.d.S0() == false) goto L66;
        ClientUIInfo r124 = this.x;
        if (r124 == null) goto L66;
        List r9 = r124.getUiFeatureList();
    L67:
        S(this, this.V1, this.b2, false, true, r9, 4);
        int r125 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        IPreviewMultiLinkOuterConfigProvider r126 = this.b;
        if (r126 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L71:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r126.getShowFrom()) == false) goto L78;
        te0.a r127 = this.c;
        if (r127 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L75:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r128 = r127.c();
        if (r128 == null) goto L84;
        BehaviorSubject<IRoomLinkMicSyncData> r129 = r128.v;
    L85:
        if (r129 == null) goto L91;
        Observable r130 = RxUtilKt.h(r129);
        if (r130 == null) goto L91;
        Disposable r131 = r130.subscribe(new t(this));
        if (r131 == null) goto L91;
        this.T.add(r131);
    L91:
        IPreviewMultiLinkOuterConfigProvider r132 = this.b;
        if (r132 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L95:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r132.getShowFrom()) == false) goto L102;
        te0.a r133 = this.c;
        if (r133 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L99:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r134 = r133.c();
        if (r134 == null) goto L108;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r135 = r134.c;
    L109:
        if (r135 == null) goto L113;
        Disposable r136 = r135.subscribe(new u(this));
        if (r136 == null) goto L113;
        this.T.add(r136);
    L113:
        LinkFeedTypeConstant.Companion r137 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r7 = this.b;
        if (r7 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L117:
        if (r137.isDouyinFullScreen(r7.getShowFrom()) == false) goto L121;
        int r138 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.b(Integer.valueOf(this.V1)) == false) goto L121;
        boolean r139 = true;
    L122:
        if (r139 == false) goto L132;
        ConstraintLayout r8 = t(2131384822);
        Context r10 = getContext();
        IRoom r11 = this.G;
        DataCenter r12 = this.E;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r13 = this.n;
        if (r13 == null) goto L130;
        BehaviorSubject<List<tf0.e>> r20 = r13.b;
        if (r20 == null) goto L130;
        List r21 = (List) r20.getValue();
        if (r21 == null) goto L130;
        int r140 = r21.size();
    L131:
        com.bytedance.android.live.liveinteract.voicechat.radio.k r141 = new com.bytedance.android.live.liveinteract.voicechat.radio.k(r10, r11, r12, r8, this, r140, null, 128);
        this.x1 = r141;
        v r142 = new v(this);
        Intrinsics.checkNotNullParameter(r142, "stateChangeCallback");
        r141.a = r142;
    L130:
        r140 = 0;
    L132:
        j0();
        IPreviewMultiLinkOuterConfigProvider r143 = this.b;
        if (r143 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L135:
        MessageHub r144 = r143.getMessageHub();
        if ((r144 instanceof xlc.a) == true) goto L138;
        r144 = null;
    L138:
        xlc.a r145 = (xlc.a) r144;
        if (r145 == null) goto L141;
        r145.D(MessageType.LINK_MIC_PLAYMODE.getIntType(), this.R, "SubtitleStatusSubSyncKey");
    L141:
        IPreviewMultiLinkOuterConfigProvider r146 = this.b;
        if (r146 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L144:
        MessageHub r22 = r146.getMessageHub();
        if (r22 == null) goto L147;
        MessageHub.DefaultImpls.addWRDSListener$default(r22, MultiPreviewSyncDataType.ORDER_SING_SYNC_DATA, this.M, false, 4, null);
    L147:
        IPreviewMultiLinkOuterConfigProvider r147 = this.b;
        if (r147 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L150:
        MessageHub r23 = r147.getMessageHub();
        if (r23 == null) goto L153;
        MessageHub.DefaultImpls.addWRDSListener$default(r23, MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this.M, false, 4, null);
    L153:
        IPreviewMultiLinkOuterConfigProvider r148 = this.b;
        if (r148 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L156:
        MessageHub r149 = r148.getMessageHub();
        if ((r149 instanceof xlc.a) == true) goto L159;
        r149 = null;
    L159:
        xlc.a r150 = (xlc.a) r149;
        if (r150 == null) goto L162;
        r150.D(MessageType.LINKMIC_ROOM_SONG_MESSAGE.getIntType(), this.R, "RoomSongSubSyncKey");
    L162:
        IRoom r151 = this.G;
        if (r151 == null) goto L165;
        this.O = V(r151);
    L165:
        this.p1 = new com.bytedance.android.live.liveinteract.widget.widget.v(getContext(), this.E, new e(this));
        FrameLayout r152 = (FrameLayout) findViewById(2131362410);
        LiveLinkmicAIMVManager r153 = new LiveLinkmicAIMVManager(getContext(), this.E, null);
        this.y1 = r153;
        r153.a(r152);
        LiveLinkmicAIMVContext r154 = LiveLinkmicAIMVContext.Companion.getContext();
        boolean r155 = MultiLinkLoadWidgetUtils.g();
        if (r154 == null) goto L169;
        if (r155 == true) goto L169;
        this.T.add(r154.isPlaying().a().subscribe(new r(this)));
    L169:
        te0.a r156 = this.c;
        if (r156 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L172:
        qb r157 = r156.e();
        if (r157 == null) goto L175;
        c0(r157);
    L175:
        int r158 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        te0.a r159 = this.c;
        if (r159 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L178:
        cj r160 = r159.b();
        if (r160 == null) goto L182;
        b0(r160);
        return;
    L182:
        return;
    L121:
        r139 = false;
    L108:
        r135 = null;
        goto L109
    L102:
        te0.a r161 = this.c;
        if (r161 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L105:
        ue0.c r162 = r161.f();
        if (r162 == null) goto L108;
        r135 = r162.c;
    L84:
        r129 = null;
        goto L85
    L78:
        te0.a r163 = this.c;
        if (r163 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L81:
        ue0.c r164 = r163.f();
        if (r164 == null) goto L84;
        r129 = r164.a;
    L66:
        r9 = null;
        goto L67
    L45:
        r118 = null;
        goto L46
    L35:
        r114 = null;
        goto L36
    L17:
        r19 = null;
        goto L18
    L13:
        r17 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final Pair v(MultiLinkCommonVoiceFeedPreview r4, float r5, float r6) {
        r4.getClass();
        int r0 = h2;
        float r1 = r0;
        if (r5 >= r1) goto L6;
        r5 = r1;
    L6:
        if (r5 <= ((s1.y() - r4.Q) - r0)) goto L9;
        r5 = (s1.y() - r4.Q) - r1;
    L9:
        if (r6 >= 0) goto L11;
        float r2 = 0.0f;
    L13:
        if (r6 <= (r4.getDragContainerStubHeight() - r4.getLinkmicSubtitleHeight())) goto L16;
        r2 = r4.getDragContainerStubHeight() - r4.getLinkmicSubtitleHeight();
    L16:
        return TuplesKt.to(Float.valueOf(r5), Float.valueOf(r2));
    L11:
        r2 = r6;
        goto L13
    }

    public final com.bytedance.android.live.liveinteract.videotalk.utils.h K(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        r3.q(r5);
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.o(r1.getShowFrom(), r4, r5) == false) goto L8;
        int r2 = (int) (r5 * 0.5625f);
    L9:
        r3.s(r2, r5);
        return com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r4, r5, r3);
    L8:
        r2 = r4;
        goto L9
    }

    public final void l0(ClientUIInfo r4, boolean r5, List<Integer> r6) {
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L5;
    L7:
        ALogger.i("MultiLinkCommonVoiceFeedPreview", "updateClientUIInfo, seiUiFeatureList: " + r6 + ", forceUpdate: " + r5);
        List r0 = null;
        if (r4 == null) goto L12;
        List r1 = r4.getUiFeatureList();
        if (r1 == null) goto L12;
        List r2 = CollectionsKt.sorted(r1);
    L13:
        ClientUIInfo r3 = this.x;
        if (r3 == null) goto L19;
        List r7 = r3.getUiFeatureList();
        if (r7 == null) goto L19;
        r0 = CollectionsKt.sorted(r7);
    L19:
        if ((!Intrinsics.areEqual(r2, r0)) == true) goto L21;
        if (r5 == true) goto L21;
        return;
    L21:
        this.x = r4;
        this.y = false;
        m(this.b2, this.V1, r6);
        E();
        xs2.b r8 = xs2.b.a();
        IPreviewMultiLinkOuterConfigProvider r9 = this.b;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L24:
        r8.post(new v1(r9.getRoom().getId(), this.V1, r4));
        return;
    L12:
        r2 = null;
        goto L13
    L5:
        if (vm2.h.g0().d() == true) goto L7;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void m(int r8, int r9, List<Integer> r10) {
        this.b2 = r8;
        this.V1 = r9;
        S(this, r9, r8, false, false, r10, 12);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        com.bytedance.android.live.liveinteract.widget.widget.v r0 = this.p1;
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4);
        return;
    }

    public static final boolean u(MultiLinkCommonVoiceFeedPreview r3, IVoiceLiveTheme r4, com.bytedance.android.live.ui.l r5, IRoom r6) {
        r3.getClass();
        if (MultiLinkLoadWidgetUtils.g() == true) goto L31;
        LiveLinkmicAIMVContext r0 = LiveLinkmicAIMVContext.Companion.getContext();
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L27;
        if (r4 != null) goto L14;
    L21:
        com.bytedance.android.live.liveinteract.feed.d0 r7 = r3.t;
        if (r7 == null) goto L24;
        r7.k();
    L24:
        if (r5 == null) goto L27;
        r5.a(com.bytedance.android.live.liveinteract.aimv.b.a());
        goto L27
    L14:
        if (r4.getImageType() == 3) goto L21;
        com.bytedance.android.live.ui.q r8 = r3.s;
        if (r8 == null) goto L28;
        if (r6 == null) goto L19;
        IVoiceLiveTheme r9 = r6.getVoiceLiveTheme();
    L20:
        r8.d(r9);
        goto L28
    L19:
        r9 = null;
    L28:
        return true;
    L27:
        if (r3.M1 == 2) goto L28;
        return false;
    L8:
        if (((Boolean) r0.isPlaying().getValue()).booleanValue() == false) goto L10;
        r1 = true;
        goto L11
    L31:
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void F(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8, int r9, int r10, float r11) {
        if (vm2.d.d0().i() == false) goto L10;
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        if (r0.getShowFrom() != 5) goto L10;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
    L21:
        ConstraintLayout r2 = this.g;
        if (r2 == null) goto L24;
        r2.setScaleX(1.0f);
        r2.setScaleY(1.0f);
        r2.setTranslationX(0.0f);
    L24:
        r8.d = yg0.h.a(r8, new Triple(Integer.valueOf(r9), Integer.valueOf(r10), "MultiLinkCommonVoiceFeedPreview#updateLayoutConfigResultIfNeed"), getLivePlayerVideoSize());
        BaseLinkSeatWindowView r3 = this.g;
        if (r3 == null) goto L27;
        r3.Yd(r8, r9, r10);
    L27:
        BaseLinkSeatWindowView r4 = this.g;
        if (r4 == null) goto L30;
        r4.Sp(r8, r9, r10);
    L30:
        if (r1 == true) goto L32;
    L43:
        FrameLayout r5 = this.h;
        if (r5 == null) goto L57;
        float r6 = r9;
        if (r11 <= 0.0f) goto L48;
        r6 = r6 / r11;
    L48:
        if (r11 <= 0.0f) goto L50;
        float r7 = r10 / r11;
    L51:
        int r12 = (int) r6;
        int r13 = (int) r7;
        ViewGroup.LayoutParams r14 = r5.getLayoutParams();
        if (r14 == null) goto L54;
        r14.width = r12;
        r14.height = r13;
    L54:
        FrameLayout r15 = this.h;
        if (r15 == null) goto L57;
        r15.setLayoutParams(r14);
        goto L57
    L50:
        r7 = r10;
    L57:
        BaseLinkSeatWindowView r16 = this.g;
        if (r16 == null) goto L63;
        RecyclerView r17 = r16.getRecyclerView();
        if (r17 == null) goto L64;
        r17.post(new b(this, r8, r9, r10));
        return;
    L64:
        return;
    L63:
        return;
    L32:
        if (r11 <= 0.0f) goto L43;
        View r18 = this.i;
        if (r18 == null) goto L40;
        ConstraintLayout.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L40;
        ((ViewGroup.LayoutParams) r19).width = r9;
        ((ViewGroup.LayoutParams) r19).height = r10;
        if ((r19 instanceof ConstraintLayout.LayoutParams) == false) goto L40;
        ConstraintLayout.LayoutParams r20 = r19;
        r20.topToTop = 0;
        r20.startToStart = 0;
        r20.endToEnd = 0;
    L40:
        View r21 = this.i;
        if (r21 == null) goto L43;
        r21.setLayoutParams(r21.getLayoutParams());
        goto L43
    L14:
        if (r11 <= 0.0f) goto L21;
        ConstraintLayout r22 = this.g;
        if (r22 == null) goto L18;
        r22.setPivotX(r9 / 2.0f);
        r22.setPivotY(0.0f);
        float r23 = 1 / r11;
        r22.setScaleX(r23);
        r22.setScaleY(r23);
        r22.setTranslationX(0.0f);
    L18:
        View r24 = this.i;
        if (r24 == null) goto L24;
        r24.setPivotX(r9 / 2.0f);
        r24.setPivotY(0.0f);
        float r25 = 1 / r11;
        r24.setScaleX(r25);
        r24.setScaleY(r25);
        r24.setTranslationX(0.0f);
    L10:
        r1 = false;
        goto L12
    }

    public final Triple<Integer, Integer, Float> M(int r8, int r9, int r10, int r11) {
        Pair r12 = ug0.b.b(r8, r9, r10, r11);
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "MultiLinkCommonVoiceFeedPreview", hashCode(), "getSizeForScreenAdjust, containerWH[" + r10 + ", " + r11 + "], adjustWH[" + ((Number) r12.getFirst()).intValue() + ", " + ((Number) r12.getSecond()).intValue() + ']', false, 8, null);
        if (vm2.d.d0().i() == false) goto L13;
        IPreviewMultiLinkOuterConfigProvider r13 = this.b;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        if (r13.getShowFrom() != 5) goto L13;
        boolean r14 = true;
    L14:
        int r15 = ((Number) r12.getFirst()).intValue();
        if (r14 == false) goto L18;
        if (r15 <= 0) goto L18;
        float r1 = s1.y() / r15;
    L19:
        if (r14 == false) goto L26;
        if (r1 <= 0.0f) goto L26;
        return new Triple(Integer.valueOf((int) (((Number) r12.getFirst()).floatValue() * r1)), Integer.valueOf((int) (((Number) r12.getSecond()).floatValue() * r1)), Float.valueOf(r1));
    L26:
        return new Triple(r12.getFirst(), r12.getSecond(), Float.valueOf(1.0f));
    L18:
        r1 = 1.0f;
    L13:
        r14 = false;
        goto L14
    }

    public MultiLinkCommonVoiceFeedPreview(Context r3, int r4, int r5, Boolean r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.V1 = r4;
        this.b2 = r5;
        this.g2 = r7;
        this.a = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.u = new JSONObject();
        this.y = true;
        this.M = new j(this);
        this.R = new i(this);
        this.S = new MultiLinkCommonVoiceFeedPreview$setMvInfoCallBack$1(this);
        this.T = new CompositeDisposable();
        this.H0 = r6;
        this.P0 = Boolean.FALSE;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g r8 = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g();
        r8.f();
        Unit r9 = Unit.INSTANCE;
        this.k1 = r8;
        this.G1 = "";
        this.L1 = ((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV5();
        this.P1 = CollectionsKt.emptyList();
        this.S1 = new MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1(this);
        com.bytedance.android.live.liveinteract.pre.a.c.a.a(hashCode(), this.b2);
        VerticalNitaInflate.a(VerticalNitaInflate.Tag.CommonMultiLinkFeedView_container.name(), 2131565260, r3, this, true);
    }

    public static void S(MultiLinkCommonVoiceFeedPreview r23, int r24, int r25, boolean r26, boolean r27, List r28, int r29) {
        if ((r29 & 4) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r29 & 8) == 0) goto L9;
        boolean r6 = false;
    L10:
        List r4 = null;
        if ((r29 & 16) == 0) goto L13;
        List r8 = null;
    L14:
        int r5 = r23.N(r24, r25);
        ArrayList r11 = new ArrayList();
        Iterator<T> r0 = r23.getPlayModes().iterator();
    L16:
        if (r0.hasNext() == false) goto L19;
        r11.add(Integer.valueOf((int) ((Number) r0.next()).longValue()));
        goto L16
    L19:
        if (r23.W == false) goto L21;
        r11.remove(7);
    L21:
        te0.a r1 = r23.c;
        if (r1 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L24:
        int r2 = r1.getContainerWidth();
        te0.a r9 = r23.c;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L27:
        Triple<Integer, Integer, Float> r7 = r23.M(r25, r5, r2, r9.l());
        Triple r15 = new Triple(Integer.valueOf(((Number) r7.component1()).intValue()), Integer.valueOf(((Number) r7.component2()).intValue()), "MultiLinkCommonVoiceFeedPreview#initLoadLayoutConfig");
        long r21 = System.currentTimeMillis();
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L38;
        IPreviewMultiLinkOuterConfigProvider r10 = r23.b;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L33:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r10.getShowFrom()) == false) goto L38;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L38;
        boolean r13 = false;
    L39:
        ln0.a r12 = yg0.h.a;
        int r14 = r23.w;
        pn0.i r16 = r23.getLayoutConfigRequestExtra();
        ClientUIInfo r17 = r23.x;
        if (r17 == null) goto L42;
        r4 = r17.getUiFeatureList();
    L42:
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.t(r5, r11, 0, r13, r14, false, r16, r15, r4, r23.E, 12), new s(r23, r3, r21, r5, r6, r24), r8);
        return;
    L38:
        r13 = true;
        goto L39
    L13:
        r8 = r28;
        goto L14
    L9:
        r6 = r27;
        goto L10
    L5:
        r3 = r26;
        goto L7
    }
}
