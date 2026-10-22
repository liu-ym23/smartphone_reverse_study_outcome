package com.bytedance.android.live.liveinteract.feed;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.feed.datamerge.FeedViewInteractSongDataHandler;
import com.bytedance.android.live.liveinteract.jsbridge.method.l0;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.CommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.MultiLinkCommonItemDecoration;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.u0;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IMultiFeedView;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.feed.LivePreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.multilink.CommonMultiLinkLayoutEvent;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import me.drakeet.multitype.MultiTypeAdapter;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010'\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020\u0007H\u0004J\b\u0010*\u001a\u00020\u0007H\u0004R$\u00102\u001a\u0004\u0018\u00010+8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010B\u001a\u0004\u0018\u00010;8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010R\u001a\u0004\u0018\u00010K8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010Z\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010a\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010i\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010q\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010y\u001a\u0004\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR&\u0010\u0081\u0001\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R#\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001a8B@\u0002X\u0082\u000e¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R*\u0010\u008e\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R(\u0010\u0094\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u008f\u0001\u0010k\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R(\u0010\u0098\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0095\u0001\u0010k\u001a\u0006\b\u0096\u0001\u0010\u0091\u0001\"\u0006\b\u0097\u0001\u0010\u0093\u0001R(\u0010\u009c\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0099\u0001\u0010k\u001a\u0006\b\u009a\u0001\u0010\u0091\u0001\"\u0006\b\u009b\u0001\u0010\u0093\u0001¨\u0006\u009d\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feed/CommonMultiLinkFeedView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "Lcom/bytedance/android/livesdkapi/feed/IKtvInteractFeedView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/b;", "", "getResourceLayout", "Lkotlin/Pair;", "getLivePlayerVideoSize", "Lpn0/i;", "getLayoutConfigRequestExtra", "Lcom/bytedance/android/livesdkapi/feed/data/FeedViewRoomInfoStore;", "getFeedViewRoomInfoStore", "", "getFeedViewName", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getLinkmicSeatListInfo", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "", "setLivePlayerView", "Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "interactPlayView", "setInteractPlayView", "", "getKtvSeiModelObject", "getCurrentSingUserId", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "getKtvComponentFeedView", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "playerContainerAbility", "setLivePlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "setLivePlayerClient", "getCurrentSingUserIdString", "getContainerWidth", "getContainerHeight", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "d", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setMRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "mRoom", "", "f", "Z", "getHasAdjustWindowUI", "()Z", "setHasAdjustWindowUI", "(Z)V", "hasAdjustWindowUI", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "g", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "getLayoutConfig", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "setLayoutConfig", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;)V", "layoutConfig", "Lcom/bytedance/android/live/liveinteract/feed/datamerge/b;", "m", "Lcom/bytedance/android/live/liveinteract/feed/datamerge/b;", "getFeedViewDataMergeCenter", "()Lcom/bytedance/android/live/liveinteract/feed/datamerge/b;", "setFeedViewDataMergeCenter", "(Lcom/bytedance/android/live/liveinteract/feed/datamerge/b;)V", "feedViewDataMergeCenter", "Lcom/bytedance/android/live/liveinteract/feed/datamerge/i;", "u", "Lcom/bytedance/android/live/liveinteract/feed/datamerge/i;", "getWindowListHepler", "()Lcom/bytedance/android/live/liveinteract/feed/datamerge/i;", "setWindowListHepler", "(Lcom/bytedance/android/live/liveinteract/feed/datamerge/i;)V", "windowListHepler", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "z", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "getBaseWindowView", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "setBaseWindowView", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;)V", "baseWindowView", "A", "Landroid/widget/FrameLayout;", "getBaseWindowViewContainer", "()Landroid/widget/FrameLayout;", "setBaseWindowViewContainer", "(Landroid/widget/FrameLayout;)V", "baseWindowViewContainer", "Landroidx/lifecycle/ViewModelStore;", "H", "Landroidx/lifecycle/ViewModelStore;", "getMViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setMViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "mViewModelStore", "Landroidx/lifecycle/ViewModelProvider;", "I", "Landroidx/lifecycle/ViewModelProvider;", "getViewModelProvider", "()Landroidx/lifecycle/ViewModelProvider;", "setViewModelProvider", "(Landroidx/lifecycle/ViewModelProvider;)V", "viewModelProvider", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "J", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getFeedDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setFeedDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "feedDataCenter", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "K", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "getDynamicWidget", "()Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "setDynamicWidget", "(Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;)V", "dynamicWidget", "L", "Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "getMInteractPlayView", "()Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "mInteractPlayView", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "O", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "getItemDecoration", "()Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "setItemDecoration", "(Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;)V", "itemDecoration", "T", "getSeiVer", "()I", "setSeiVer", "(I)V", "seiVer", "U", "getUiLayout", "setUiLayout", "uiLayout", "V", "getShowFrom", "setShowFrom", "showFrom", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonMultiLinkFeedView extends FrameLayout implements IInteractFeedView, IKtvInteractFeedView, LifecycleOwnerCompat, ViewModelStoreOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b {
    public static final /* synthetic */ int W = 0;
    public FrameLayout A;
    public com.bytedance.android.live.liveinteract.videotalk.utils.c B;
    public com.bytedance.android.live.ui.q C;
    public d0 D;
    public IPreviewPlayerContainerAbility E;
    public ILivePlayerClient F;
    public final IKtvComponentFeedView G;
    public ViewModelStore H;
    public ViewModelProvider I;
    public DataCenter J;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.a K;
    public IInteractPlayView L;
    public final JSONObject M;
    public boolean N;
    public BaseEqualGridItemDecoration O;
    public IMultiScenePreviewStatistics P;
    public boolean Q;
    public FeedViewRoomInfoStore R;
    public LifecycleRegistry S;
    public int T;
    public int U;
    public int V;
    public Map<Integer, View> a;
    public int b;
    public int c;
    public IRoom d;
    public int e;
    public boolean f;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m g;
    public int h;
    public MessageHub i;
    public boolean j;
    public Disposable k;
    public final Map<String, Object> l;
    public com.bytedance.android.live.liveinteract.feed.datamerge.b m;
    public com.bytedance.android.live.liveinteract.feed.datamerge.h n;
    public com.bytedance.android.live.liveinteract.feed.datamerge.m o;
    public com.bytedance.android.live.liveinteract.feed.datamerge.g p;
    public com.bytedance.android.live.liveinteract.feed.datamerge.l q;
    public FeedViewInteractSongDataHandler r;
    public com.bytedance.android.live.liveinteract.feed.datamerge.c s;
    public com.bytedance.android.live.liveinteract.feed.datamerge.d t;
    public com.bytedance.android.live.liveinteract.feed.datamerge.i u;
    public final CompositeDisposable v;
    public SeiAppData w;
    public final CompositeDisposable x;
    public IRenderView y;
    public BaseLinkSeatWindowView z;

    public static final class a implements com.bytedance.android.live.liveinteract.plantform.commonwindow.k {
        public final /* synthetic */ CommonMultiLinkFeedView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.m d;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
        public final void onFailed() {
            CommonMultiLinkFeedView r0 = this.a;
            int r1 = this.b;
            int r2 = this.c;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = this.d;
            int r4 = CommonMultiLinkFeedView.W;
            r0.u(r1, r2, r3);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5) {
            Intrinsics.checkNotNullParameter(r5, "layoutConfigV1");
            CommonMultiLinkFeedView r0 = this.a;
            int r1 = this.b;
            int r2 = this.c;
            int r3 = CommonMultiLinkFeedView.W;
            r0.u(r1, r2, r5);
        }

        public a(CommonMultiLinkFeedView r1, int r2, int r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CommonMultiLinkFeedView a;

        public b(CommonMultiLinkFeedView r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            CommonMultiLinkFeedView r0 = this.a;
            int r1 = CommonMultiLinkFeedView.W;
            if (r0.v() == false) goto L5;
            this.a.j = false;
        L5:
            if (r5 == null) goto L30;
            this.a.getMRoom();
            k1 r6 = (k1) r5.data;
            if (r6 == null) goto L12;
            p2 r7 = r6.getLinkmicPlayModeInfo();
            if (r7 == null) goto L12;
            com.bytedance.android.live.liveinteract.multiscene.a r8 = r7.getTeamFightInfo();
        L14:
            if (li0.d.g(r8) == true) goto L16;
        L24:
            CommonMultiLinkFeedView r9 = this.a;
            r9.l.put("team_fight_flexible", Boolean.FALSE);
            if (r9.v() == false) goto L29;
            IInteractService.playModeParams.postValue(r9.l);
            return;
        L29:
            return;
        L16:
            if (com.bytedance.android.live.liveinteract.utils.h.e(this.a.getShowFrom()) == false) goto L24;
            if (vm2.h.V().b() < 0) goto L20;
            int r10 = com.bytedance.android.live.liveinteract.multiscene.i.a;
            vm2.h.V().b();
            int r11 = com.bytedance.android.live.liveinteract.multiscene.i.a;
        L20:
            CommonMultiLinkFeedView r12 = this.a;
            r12.l.put("team_fight_flexible", Boolean.TRUE);
            if (r12.v() == false) goto L23;
            IInteractService.playModeParams.postValue(r12.l);
        L23:
            CommonMultiLinkFeedView r13 = this.a;
            int r2 = com.bytedance.android.live.liveinteract.multiscene.i.a;
            CommonMultiLinkFeedView.e(r13);
            this.a.h();
            return;
        L12:
            r8 = null;
            goto L14
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CommonMultiLinkFeedView a;

        public c(CommonMultiLinkFeedView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            CommonMultiLinkFeedView r4 = this.a;
            int r0 = CommonMultiLinkFeedView.W;
            if (r4.v() == false) goto L6;
            this.a.j = false;
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CommonMultiLinkFeedView a;

        public d(CommonMultiLinkFeedView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.a.getContainerWidth();     // Catch: Throwable -> L4
            int r1 = this.a.getContainerHeight();     // Catch: Throwable -> L4
            this.a.w(r0, r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ CommonMultiLinkFeedView b;

        public e(IRoom r1, CommonMultiLinkFeedView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
            Intrinsics.checkNotNullParameter(r10, "response");
            u0 r0 = new u0(this.a.getId(), (w0) r10.data, this.b.w);
            IRoomModuleService r1 = jc1.k.f(IRoomModuleService.class);
            if (r1 == null) goto L7;
            hn1.b r2 = r1.getPreEnterRoomManager();
            if (r2 == null) goto L7;
            r2.f(this.a.getId(), r0, u0.class);
        L7:
            IMultiScenePreviewStatistics r3 = this.b.P;
            if (r3 == null) goto L10;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r3, "list_v2_time", 0, 2, null);
        L10:
            List<com.bytedance.android.livesdk.link.model.bridge.k> r4 = ((w0) r10.data).getMPlayerInfo();
            List<? extends LinkmicPositionItem> r5 = null;
            if (r4 == null) goto L17;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r6 = r4;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r8 = r6.iterator();
        L14:
            if (r8.hasNext() == false) goto L16;
            r7.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r8.next(), true));
            goto L14
        L16:
            List<ILinkPlayerInfoBridge> r11 = CollectionsKt.toMutableList(r7);
        L18:
            FeedViewRoomInfoStore r12 = this.b.getFeedViewRoomInfoStore();
            if (r12 == null) goto L24;
            if (r11 != null) goto L22;
            List<ILinkPlayerInfoBridge> r13 = new ArrayList();
        L23:
            r12.setOnlineList(r13);
            goto L24
        L22:
            r13 = r11;
        L24:
            List<LinkmicPositionItem> r14 = ((w0) r10.data).getPositions();
            Map<Long, g2> r15 = ((w0) r10.data).getLinkerContentMap();
            if (r15 == null) goto L27;
            int r16 = r15.size();
        L28:
            if (r16 <= 1) goto L47;
            Map<Long, g2> r17 = ((w0) r10.data).getLinkerContentMap();
            if (r17 == null) goto L40;
            Collection<g2> r18 = r17.values();
            if (r18 == null) goto L40;
            ArrayList r19 = new ArrayList();
            Iterator<T> r20 = r18.iterator();
        L35:
            if (r20.hasNext() == false) goto L41;
            List r21 = ((g2) r20.next()).getLinkedUsers();
            if (r21 != null) goto L39;
            r21 = CollectionsKt.emptyList();
        L39:
            CollectionsKt.addAll(r19, r21);
        L41:
            if (r19 == null) goto L60;
            ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator<T> r23 = r19.iterator();
        L44:
            if (r23.hasNext() == false) goto L46;
            r22.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r23.next(), true));
            goto L44
        L46:
            List r24 = CollectionsKt.toMutableList(r22);
        L61:
            if (r24 == null) goto L66;
            Iterator<T> r25 = r24.iterator();
        L64:
            if (r25.hasNext() == false) goto L66;
            ILinkPlayerInfoBridge r26 = (ILinkPlayerInfoBridge) r25.next();
            int r27 = tc0.e.a;
            tc0.e.b(r26, ((w0) r10.data).getLinkerContentMap());
        L66:
            CommonMultiLinkFeedView r28 = this.b;
            if (r14 == null) goto L69;
            r5 = CollectionsKt.toMutableList(r14);
        L69:
            com.bytedance.android.live.liveinteract.feed.datamerge.g r29 = r28.p;
            if (r29 != null) goto L72;
            Intrinsics.throwUninitializedPropertyAccessException("onlineUserListHandler");
        L72:
            r29.f(r11);
            com.bytedance.android.live.liveinteract.feed.datamerge.g r30 = r28.p;
            if (r30 != null) goto L75;
            Intrinsics.throwUninitializedPropertyAccessException("onlineUserListHandler");
        L75:
            r30.e(r5);
            com.bytedance.android.live.liveinteract.feed.datamerge.l r31 = r28.q;
            if (r31 == null) goto L96;
            if (r24 == null) goto L83;
            Iterator<T> r32 = r24.iterator();
        L80:
            if (r32.hasNext() == false) goto L83;
            ((ILinkPlayerInfoBridge) r32.next()).setLinkRoomUser(true);
        L83:
            if ((!gh0.a.f(r31.b, r24)) == false) goto L96;
            ((ArrayList) r31.b).clear();
            if (r24 == null) goto L87;
            ((ArrayList) r31.b).addAll(r24);
        L87:
            com.bytedance.android.live.liveinteract.feed.datamerge.j.a r33 = r31.a(r31.c().d());
            boolean r34 = r33.a;
            Iterator<com.bytedance.android.live.liveinteract.feed.datamerge.j> r35 = r31.c.iterator();
        L89:
            if (r35.hasNext() == false) goto L93;
            r33 = r35.next().a(r33.b);
            if (r33.a == false) goto L89;
            r34 = true;
            goto L89
        L93:
            if (r34 == false) goto L96;
            r33.a = true;
            r31.c().n(r33);
        L96:
            if (vm2.d.L0() == true) goto L98;
        L109:
            ConstraintLayout r36 = this.b.getBaseWindowView();
            if (r36 == null) goto L112;
            int r37 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
            com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r36, new CommonMultiLinkFeedView$onOnlineListChanged$$inlined$let$lambda$1$1(this));
        L112:
            CommonMultiLinkFeedView r38 = this.b;
            IRoom r39 = r38.d;
            if (r39 == null) goto L128;
            z5 r40 = r39.getLinkerDetail();
            if (r40 == null) goto L128;
            List r41 = r40.getPlayModes();
            if (r41 == null) goto L128;
            if (r41.contains(Long.valueOf(19)) != true) goto L128;
            FeedViewInteractSongDataHandler r42 = r38.r;
            if (r42 != null) goto L123;
            Intrinsics.throwUninitializedPropertyAccessException("feedViewInteractSongDataHandler");
        L123:
            IRoom r43 = r38.d;
            Intrinsics.checkNotNull(r43);
            int r44 = r38.V;
            r42.getClass();
            Intrinsics.checkNotNullParameter(r43, PbRequest.SwitchType.ROOM);
            Disposable r45 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).fetchPlayModeInfo(r43.getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.feed.datamerge.e(r42, r44), com.bytedance.android.live.liveinteract.feed.datamerge.f.a);
            if (r45 == null) goto L128;
            CompositeDisposable r46 = r42.d;
            if (r46 == null) goto L128;
            r46.add(r45);
        L128:
            this.b.g();
            return;
        L98:
            if (vm2.d.q0().isFeedViewDisplayWhenGuestListReady() == false) goto L109;
            com.bytedance.android.live.liveinteract.feed.datamerge.h r47 = this.b.n;
            if (r47 != null) goto L103;
            Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
        L103:
            if (((ArrayList) r47.c).size() <= 0) goto L109;
            UtilityKotlinExtentionsKt.w(this.b);
            CommonMultiLinkFeedView r48 = this.b;
            if (r48.Q == false) goto L109;
            IMultiScenePreviewStatistics r49 = r48.P;
            if (r49 == null) goto L109;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r49, "background_Load", 0, 2, null);
        L60:
            r24 = null;
        L40:
            r19 = null;
            goto L41
        L47:
            Map<Long, g2> r50 = ((w0) r10.data).getLinkerContentMap();
            if (r50 == null) goto L60;
            Map.Entry r51 = z0.a(r50);
            if (r51 == null) goto L60;
            g2 r52 = (g2) r51.getValue();
            if (r52 == null) goto L60;
            List r53 = r52.getLinkedUsers();
            if (r53 == null) goto L60;
            List r54 = r53;
            ArrayList r55 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r54, 10));
            Iterator<T> r56 = r54.iterator();
        L57:
            if (r56.hasNext() == false) goto L59;
            r55.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r56.next(), true));
            goto L57
        L59:
            r24 = CollectionsKt.toMutableList(r55);
            goto L61
        L27:
            r16 = 0;
            goto L28
        L17:
            r11 = null;
            goto L18
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ CommonMultiLinkFeedView a;

        public g(CommonMultiLinkFeedView r1) {
            this.a = r1;
        }

        public final void a() {
            CommonMultiLinkFeedView r0 = this.a;
            int r1 = CommonMultiLinkFeedView.W;
            r0.getClass();
            int r3 = 0;
            if (((IInteractService) jc1.k.n(IInteractService.class)).isFixFloatWindowLayout(r0.T, r0.U) == false) goto L5;
        L10:
            boolean r2 = true;
        L11:
            String r4 = null;
            if (r2 == false) goto L26;
            CommonLinkSeatWindowView r6 = (CommonLinkSeatWindowView) r0.b(2131378011);
            if (r6 == null) goto L18;
            ug0.a r7 = r6.getRvLayoutManager();
            if (r7 == null) goto L18;
            Pair<Integer, Integer> r5 = r7.c(1);
        L19:
            int[] r8 = new int[2];
            CommonLinkSeatWindowView r9 = (CommonLinkSeatWindowView) r0.b(2131378011);
            if (r9 == null) goto L24;
            RecyclerView r10 = r9.getRecyclerView();
            if (r10 == null) goto L24;
            r10.getLocationInWindow(r8);
        L24:
            if (r5 == null) goto L26;
            r3 = r8[0] + ((Number) r5.getFirst()).intValue();
        L18:
            r5 = null;
        L26:
            xs2.b r11 = xs2.b.a();
            IRoom r12 = r0.d;
            if (r12 == null) goto L29;
            r4 = r12.getIdStr();
        L29:
            r11.post(new CommonMultiLinkLayoutEvent(r4, r2, r3));
            ALogger.i("CommonMultiLinkFeedView", "updateCommonMultiLinkLayoutEvent, isFloatWindow=" + r2 + ", xPosition=" + r3);
            return;
        L5:
            if (r0.U == 7) goto L10;
            if (((IInteractService) jc1.k.n(IInteractService.class)).isVideoEqualCenterNewLayout(r0.T, r0.U) == true) goto L10;
            r2 = false;
            goto L11
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

    public static final class h implements Runnable {
        public final /* synthetic */ CommonMultiLinkFeedView a;

        public h(CommonMultiLinkFeedView r1) {
            this.a = r1;
        }

        public final void a() {
            CommonMultiLinkFeedView r0 = this.a;
            int r1 = CommonMultiLinkFeedView.W;
            r0.h();
            CommonMultiLinkFeedView r2 = this.a;
            ViewGroup.LayoutParams r3 = null;
            if (r2.E != null) goto L12;
            View r4 = r2.y;
            if (r4 == null) goto L12;
            if ((r4 instanceof View) == false) goto L12;
            ViewParent r5 = r4.getParent();
            if ((r5 instanceof ViewGroup) == true) goto L11;
            r5 = null;
        L11:
            r2.E = new LivePreviewPlayerContainerAbility((ViewGroup) r5);
            this.a.w(this.a.getContainerWidth(), this.a.getContainerHeight());
        L12:
            CommonMultiLinkFeedView r6 = this.a;
            if (r6.v() == true) goto L28;
            int r7 = c1.a;
            if (c1.a(0, Integer.valueOf(r6.e)) == false) goto L28;
            IPreviewPlayerContainerAbility r8 = r6.E;
            if (r8 == null) goto L28;
            ViewGroup.LayoutParams r9 = r8.getLayoutParams();
            if ((r9 instanceof FrameLayout.LayoutParams) == false) goto L23;
            r3 = r9;
        L23:
            FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r3;
            if (r10 == null) goto L28;
            if (r10.topMargin == 0) goto L28;
            r10.topMargin = 0;
        L28:
            this.a.getContainerWidth();
            CommonMultiLinkFeedView r11 = this.a;
            ConstraintLayout r12 = r11.z;
            if (r12 == null) goto L31;
            r12.setVisibility(0);
        L31:
            IRoom r13 = r11.d;
            if (r13 == null) goto L39;
            IVoiceLiveTheme r14 = r13.getVoiceLiveTheme();
            if (r14 == null) goto L40;
            com.bytedance.android.live.ui.q r15 = r11.C;
            if (r15 == null) goto L41;
            r15.a(r14);
            return;
        L41:
            return;
        L40:
            return;
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

    public static final class i implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ CommonMultiLinkFeedView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            f2.g();
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r4) {
            Intrinsics.checkNotNullParameter(r3, "request");
            Intrinsics.checkNotNullParameter(r4, "response");
            CommonMultiLinkFeedView r5 = this.a;
            r5.t(r5.getLayoutConfig(), r4.a);
            this.a.j(this.b, this.c, r4.a);
        }

        public i(CommonMultiLinkFeedView r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ CommonMultiLinkFeedView a;

        public j(CommonMultiLinkFeedView r1) {
            this.a = r1;
        }

        public final void a() {
            CommonMultiLinkFeedView r0 = this.a;
            int r1 = CommonMultiLinkFeedView.W;
            r0.h();
            this.a.w(this.a.getContainerWidth(), this.a.getContainerHeight());
            this.a.onOnlineListChanged();
            CommonMultiLinkFeedView r2 = this.a;
            IRoom r3 = r2.d;
            if (r3 == null) goto L38;
            z5 r4 = r3.getLinkerDetail();
            boolean r5 = true;
            if (r4 == null) goto L10;
            List r6 = r4.getPlayModes();
            if (r6 == null) goto L10;
            if (r6.contains(Long.valueOf(13)) != true) goto L10;
        L20:
            com.bytedance.android.live.liveinteract.feed.datamerge.c r7 = r2.s;
            if (r7 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("cPositionDataHandler");
        L23:
            r7.e(r5);
            z5 r8 = r3.getLinkerDetail();
            if (r8 == null) goto L38;
            List r9 = r8.getPlayModes();
            if (r9 == null) goto L38;
            ArrayList r10 = new ArrayList();
            Iterator r11 = r9.iterator();
        L29:
            if (r11.hasNext() == false) goto L31;
            r10.add(Integer.valueOf((int) ((Number) r11.next()).longValue()));
            goto L29
        L31:
            com.bytedance.android.live.liveinteract.feed.datamerge.b r12 = r2.m;
            if (r12 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
        L34:
            ch0.a r13 = ch0.a.a(r12.e(), 0, 0, r10, 3);
            com.bytedance.android.live.liveinteract.feed.datamerge.b r14 = r2.m;
            if (r14 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
        L37:
            r14.l(r13);
        L10:
            int r15 = r2.T;
            if (r15 == 13) goto L20;
            if (r15 == 12) goto L20;
            if (r15 == 20) goto L20;
            if (r15 == 21) goto L20;
            r5 = false;
        L38:
            CommonMultiLinkFeedView r16 = this.a;
            IRoom r17 = r16.d;
            if (r17 == null) goto L47;
            IVoiceLiveTheme r18 = r17.getVoiceLiveTheme();
            if (r18 == null) goto L48;
            com.bytedance.android.live.ui.q r19 = r16.C;
            if (r19 == null) goto L49;
            r19.a(r18);
            return;
        L49:
            return;
        L48:
            return;
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

    public static final class k implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ CommonMultiLinkFeedView a;

        public k(CommonMultiLinkFeedView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            f2.g();
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "response");
            this.a.y(r3.a);
        }
    }

    private final int getResourceLayout() {
        return 2131565261;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean c() {
        return false;
    }

    public String getFeedViewName() {
        return "CommonMultiLinkFeedView";
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean k() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void l() {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    public final void onSeiUpdated(JSONObject r1) {
    }

    public final void updateEnterFrom(String r1, String r2) {
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    private final pn0.i getLayoutConfigRequestExtra() {
        return new pn0.i(false);
    }

    private final Pair<Integer, Integer> getLivePlayerVideoSize() {
        ILivePlayerClient r0 = this.F;
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
        if (this.L != null) goto L5;
    L8:
        IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
        if (r0 != null) goto L13;
        return null;
    L13:
        return r0.getInteractPlayView(getContext());
    L5:
        if (com.bytedance.android.live.liveinteract.utils.h.e(this.V) == false) goto L8;
        return this.L;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final Integer a() {
        int r0 = this.U;
        int r1 = this.T;
        if (r0 > 0) goto L7;
        r0 = yg0.h.e(r1);
    L7:
        return Integer.valueOf(r0);
    }

    public final void g() {
        com.bytedance.android.live.liveinteract.feed.datamerge.b r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L5:
        List r1 = (List) r0.a.getValue();
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-1, -2);
        int r3 = b(2131384822).getMeasuredHeight();
        int r4 = this.T;
        int r7 = 0;
        if (r4 != 10) goto L8;
    L39:
        BaseLinkSeatWindowView r5 = this.z;
        if (r5 == null) goto L48;
        ug0.a r6 = r5.getRvLayoutManager();
        if (r6 == null) goto L48;
        Pair<Integer, Integer> r8 = r6.a(1);
        if (r8 == null) goto L48;
        Integer r9 = (Integer) r8.getFirst();
        if (r9 == null) goto L48;
        int r10 = r9.intValue();
    L49:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11 = this.g;
        if (r11 == null) goto L52;
        int r12 = r11.p(r3);
    L53:
        int r13 = (r10 + r12) + s1.f(4.0f);
        r2.topToTop = 0;
        r2.rightToRight = 0;
        r2.constrainedWidth = true;
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = r13;
    L54:
        IKtvComponentFeedView r14 = this.G;
        if (r14 == null) goto L58;
        r14.updateKsongLayout(r2);
        return;
    L58:
        return;
    L52:
        r12 = 0;
    L48:
        r10 = 0;
        goto L49
    L8:
        if (r4 == 15) goto L11;
        switch(r4) {
            case 25: goto L11;
            case 26: goto L11;
            case 27: goto L11;
            case 28: goto L39;
            default: goto L10;
        };
    L10:
        com.bytedance.android.live.liveinteract.utils.h.c(r4, 2131384921);
    L11:
        BaseLinkSeatWindowView r15 = this.z;
        if (r15 == null) goto L20;
        ug0.a r16 = r15.getRvLayoutManager();
        if (r16 == null) goto L20;
        Pair<Integer, Integer> r17 = r16.a(1);
        if (r17 == null) goto L20;
        Integer r18 = (Integer) r17.getFirst();
        if (r18 == null) goto L20;
        int r19 = r18.intValue();
    L21:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r20 = this.g;
        if (r20 == null) goto L24;
        int r21 = r20.p(r3);
    L25:
        int r22 = (r19 + r21) + s1.f(4.0f);
        int r23 = this.T;
        if (r23 != 25) goto L28;
    L31:
        int r24 = 9;
    L32:
        r2.topToTop = 0;
        r2.rightToRight = 0;
        r2.constrainedWidth = true;
        if (r1 == null) goto L35;
        int r25 = r1.size();
    L36:
        if (r25 < r24) goto L38;
        r7 = r22;
    L38:
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = r7;
        goto L54
    L35:
        r25 = 0;
        goto L36
    L28:
        if (r23 == 27) goto L31;
        r24 = 7;
        goto L32
    L24:
        r21 = 0;
    L20:
        r19 = 0;
        goto L21
    }

    public final int getContainerHeight() {
        IPreviewPlayerContainerAbility r0 = this.E;
        boolean r1 = true;
        Integer r3 = null;
        if (r0 == null) goto L14;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L14;
        Integer r4 = Integer.valueOf(r2.height);
        if (r4.intValue() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L14;
    L23:
        r3 = r4;
    L24:
        if (r3 == null) goto L27;
        return r3.intValue();
    L27:
        return s1.w();
    L9:
        r5 = false;
    L14:
        IPreviewPlayerContainerAbility r6 = this.E;
        if (r6 == null) goto L24;
        r4 = r6.getHeight();
        if (r4 == null) goto L24;
        if (r4.intValue() > 0) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        goto L23
    }

    public final int getContainerWidth() {
        IPreviewPlayerContainerAbility r0 = this.E;
        boolean r1 = true;
        Integer r3 = null;
        if (r0 == null) goto L14;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L14;
        Integer r4 = Integer.valueOf(r2.width);
        if (r4.intValue() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L14;
    L23:
        r3 = r4;
    L24:
        if (r3 == null) goto L27;
        return r3.intValue();
    L27:
        return s1.y();
    L9:
        r5 = false;
    L14:
        IPreviewPlayerContainerAbility r6 = this.E;
        if (r6 == null) goto L24;
        r4 = r6.getWidth();
        if (r4 == null) goto L24;
        if (r4.intValue() > 0) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        goto L23
    }

    public String getCurrentSingUserId() {
        IKtvComponentFeedView r0 = this.G;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getCurrentSingUserIdString() {
        IKtvComponentFeedView r0 = this.G;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final com.bytedance.android.live.liveinteract.feed.datamerge.b getFeedViewDataMergeCenter() {
        com.bytedance.android.live.liveinteract.feed.datamerge.b r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L5:
        return r0;
    }

    public FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        if (this.R != null) goto L10;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        FeedViewRoomInfoStore r1 = r0.getFeedViewRoomInfoStore();
    L8:
        this.R = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.R;
    }

    public final BaseEqualGridItemDecoration getItemDecoration() {
        BaseEqualGridItemDecoration r0 = this.O;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
    L5:
        return r0;
    }

    public Object getKtvSeiModelObject() {
        IKtvComponentFeedView r0 = this.G;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvSeiModelObject();
    }

    public Lifecycle getLifecycleCompat() {
        LifecycleRegistry r0 = this.S;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LifecycleRegistry(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicAreaFrameInfo() {
        BaseLinkSeatWindowView r0 = this.z;
        if (r0 == null) goto L17;
        LinkMicRecyclerView r1 = r0.getRecyclerView();
        if (r1 == null) goto L19;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        sf0.b r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.d(r1);
        sf0.c r4 = r3.c;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = this.g;
        if (r5 == null) goto L9;
        int r6 = r5.b;
    L10:
        r4.a = r6;
        if (r5 == null) goto L16;
        List<Integer> r7 = r5.e;
        if (r7 == null) goto L16;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.b = r7;
    L16:
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r3);
    L9:
        r6 = 0;
        goto L10
    L19:
        return null;
    L17:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicSeatListInfo() {
        BaseLinkSeatWindowView r0 = this.z;
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
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.j();
    }

    public final void onOnlineListChanged() {
        IRoom r0 = this.d;
        if (r0 == null) goto L13;
        LinkAnchorApi r2 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r3 = r0.getId();
        long r5 = d5.c(r0.getAnchorId());
        String r1 = r0.getAnchorId();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        Disposable r4 = r2.getLinkListV2(r3, r5, r1, true, r0.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r0, this), f.a);
        if (r4 == null) goto L10;
        Boolean r6 = Boolean.valueOf(this.x.add(r4));
    L11:
        r6.booleanValue();
        return;
    L10:
        r6 = null;
        goto L11
    }

    public final void onViewHolderUnSelected() {
        BaseLinkSeatWindowView r0 = this.z;
        if (r0 == null) goto L8;
        fg0.a r1 = r0.getMultiAdapterWrapper();
        if (r1 == null) goto L8;
        r1.a = new ArrayList();
    L8:
        if (vm2.d.Q0() == false) goto L20;
        LifecycleRegistry r2 = this.S;
        if (r2 == null) goto L12;
        r2.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L12:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r3 = this.K;
        if (r3 == null) goto L15;
        r3.onDestroy();
    L15:
        ViewModelStore r4 = this.H;
        if (r4 == null) goto L18;
        r4.clear();
    L18:
        this.S = null;
        this.H = null;
        this.I = null;
        this.J = null;
        return;
    }

    public final void reset() {
        com.bytedance.android.live.liveinteract.feed.datamerge.b r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L5:
        Iterator<com.bytedance.android.live.liveinteract.feed.datamerge.j> r1 = r0.j.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().detach();
        goto L7
    L9:
        r0.j.clear();
        this.v.clear();
        if (v() == true) goto L12;
        com.bytedance.android.live.liveinteract.utils.h.h(this.y, this.E, this.V);
    L12:
        this.x.clear();
        Disposable r2 = this.k;
        if (r2 != null) goto L15;
    L17:
        IKtvComponentFeedView r3 = this.G;
        if (r3 == null) goto L20;
        r3.reset();
    L20:
        this.y = null;
        this.j = false;
        ((LinkedHashMap) this.l).clear();
        if (v() == false) goto L25;
        IInteractService.playModeParams.postValue(this.l);
        return;
    L25:
        return;
    L15:
        if (r2.isDisposed() == true) goto L17;
        r2.dispose();
        goto L17
    }

    public final void resetKtvSeiModelObject() {
        IKtvComponentFeedView r0 = this.G;
        if (r0 == null) goto L6;
        r0.resetKtvSeiModelObject();
        return;
    }

    public final void s() {
        if (this.j == true) goto L13;
        IRoom r0 = this.d;
        if (r0 == null) goto L13;
        z5 r1 = r0.getLinkerDetail();
        if (r1 == null) goto L13;
        List r2 = r1.getPlayModes();
        if (r2 == null) goto L13;
        if (r2.contains(Long.valueOf(7)) != true) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L22;
        this.j = true;
        Disposable r4 = this.k;
        if (r4 != null) goto L18;
    L20:
        LinkApi r5 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r6 = this.d;
        Intrinsics.checkNotNull(r6);
        this.k = r5.fetchPlayModeInfo(r6.getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        return;
    L18:
        if (r4.isDisposed() == true) goto L20;
        r4.dispose();
        goto L20
    L22:
        return;
    L13:
        r3 = false;
        goto L14
    }

    public final ViewModelStore tf() {
        ViewModelStore r0 = this.H;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ViewModelStore();
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IInteractFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
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

    public final void h() {
        if (v() == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.liveinteract.utils.h.e(this.V) == false) goto L8;
        com.bytedance.android.live.liveinteract.utils.h.a(this.E, getContext(), this.d);
        com.bytedance.android.live.liveinteract.utils.h.i(this.y, getMInteractPlayView(), this.T, this.U, this.M, this.V, getContext(), this.d, this.l);
        return;
    L8:
        com.bytedance.android.live.liveinteract.utils.h.b(this.E);
        com.bytedance.android.live.liveinteract.utils.h.k(getContainerWidth(), getContainerHeight(), this.V, this.T, this.U, getContext(), this.y, getMInteractPlayView(), this.d, this.M, this.l, null, 2048);
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        return IInteractFeedView.DefaultImpls.observeFeedViewExposeData(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (v() == true) goto L30;
        IPreviewPlayerContainerAbility r0 = this.E;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L7;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L9:
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L11;
        ViewGroup.LayoutParams r3 = null;
    L12:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        if (r4 == null) goto L16;
        r4.topMargin = 0;
    L16:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == true) goto L18;
        ViewGroup.LayoutParams r5 = null;
    L19:
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
        if (r6 == null) goto L23;
        ((ViewGroup.MarginLayoutParams) r6).topMargin = 0;
    L23:
        if ((r2 instanceof RelativeLayout.LayoutParams) == false) goto L26;
        r1 = r2;
    L26:
        RelativeLayout.LayoutParams r7 = (RelativeLayout.LayoutParams) r1;
        if (r7 == null) goto L31;
        r7.topMargin = 0;
        return;
    L31:
        return;
    L18:
        r5 = r2;
        goto L19
    L11:
        r3 = r2;
        goto L12
    L7:
        r2 = null;
        goto L9
    }

    public final void onViewHolderResume() {
        if (vm2.d.Q0() == false) goto L16;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.K;
        if (r0 == null) goto L7;
        r0.Kk();
    L7:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.K;
        if (r1 == null) goto L11;
        r1.initDataContext();
    L11:
        if (com.bytedance.android.live.liveinteract.utils.h.e(this.V) == false) goto L17;
        h();
        if (v() == false) goto L18;
        IInteractService.playModeParams.postValue(this.l);
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void onViewHolderSelected() {
        if (vm2.d.Q0() == false) goto L32;
        if (com.bytedance.android.live.liveinteract.utils.h.e(this.V) == false) goto L32;
        if (this.S != null) goto L10;
        this.S = new LifecycleRegistry(this);
    L10:
        if (this.H != null) goto L13;
        this.H = new ViewModelStore();
    L13:
        if (this.I != null) goto L16;
        this.I = new ViewModelProvider(this);
    L16:
        if (this.J != null) goto L18;
        this.J = DataCenter.create(this.I, this);
    L18:
        Context r3 = getContext();
        DataCenter r4 = this.J;
        Intrinsics.checkNotNull(r4);
        MultiLinkFeedDynamicWidgetNew r0 = new MultiLinkFeedDynamicWidgetNew(this, r3, r4, this, null, this.V, null, null, 1984);
        this.K = r0;
        r0.b(this.P);
        IRoom r1 = this.d;
        if (r1 == null) goto L23;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r2 = this.K;
        if (r2 == null) goto L23;
        r2.updateRoom(r1);
    L23:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = this.g;
        if (r5 == null) goto L28;
        nh0.f r10 = new nh0.f("linkmic", new nh0.e(r5.j(), r5.getUiLayout(), CollectionsKt.emptyList(), -1, -1, CollectionsKt.emptyList(), null, null, 192), null, null, null, null, false, 224);
        DataCenter r6 = this.J;
        if (r6 == null) goto L28;
        r6.put("data_multi_lick_dynamic_event_change", r10);
    L28:
        LifecycleRegistry r7 = this.S;
        if (r7 == null) goto L32;
        r7.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    L32:
        if (v() == false) goto L34;
        IInteractService.playModeParams.postValue(new LinkedHashMap());
        s();
    L34:
        BaseLinkSeatWindowView r8 = this.z;
        if (r8 == null) goto L42;
        fg0.a r9 = r8.getMultiAdapterWrapper();
        if (r9 == null) goto L44;
        Iterator r11 = ((ArrayList) r9.b).iterator();
    L40:
        if (r11.hasNext() == false) goto L45;
        MultiTypeAdapter r12 = (MultiTypeAdapter) r11.next();
        r12.notifyDataSetChanged();
        r12.getItemCount();
        goto L40
    L45:
        return;
    L44:
        return;
    }

    public final boolean v() {
        IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.shouldUseNewLivePlayerLayout() != true) goto L13;
        int r1 = this.V;
        if (r1 != 2) goto L9;
        return true;
    L9:
        if (r1 != 3) goto L11;
        return true;
    L11:
        if (r1 != 4) goto L13;
        return true;
    }

    public final BaseLinkSeatWindowView getBaseWindowView() {
        return this.z;
    }

    public final FrameLayout getBaseWindowViewContainer() {
        return this.A;
    }

    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.a getDynamicWidget() {
        return this.K;
    }

    public final DataCenter getFeedDataCenter() {
        return this.J;
    }

    public final boolean getHasAdjustWindowUI() {
        return this.f;
    }

    public IKtvComponentFeedView getKtvComponentFeedView() {
        return this.G;
    }

    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.m getLayoutConfig() {
        return this.g;
    }

    public final IRoom getMRoom() {
        return this.d;
    }

    public final ViewModelStore getMViewModelStore() {
        return this.H;
    }

    public final int getSeiVer() {
        return this.T;
    }

    public final int getShowFrom() {
        return this.V;
    }

    public final int getUiLayout() {
        return this.U;
    }

    public final ViewModelProvider getViewModelProvider() {
        return this.I;
    }

    public final com.bytedance.android.live.liveinteract.feed.datamerge.i getWindowListHepler() {
        return this.u;
    }

    public final void onViewHolderPause() {
        IInteractFeedView.DefaultImpls.onViewHolderPause(this);
    }

    public final void onViewHolderUnBind() {
        IInteractFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final MessageHub p() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final IRoom r() {
        return this.d;
    }

    public static final void e(CommonMultiLinkFeedView r15) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = r15.g;
        if (r0 == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.h r14 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r0.getUiLayout(), 0, null, false, 0, false, r15.getLayoutConfigRequestExtra(), new Triple(Integer.valueOf(r15.getContainerWidth()), Integer.valueOf(r15.getContainerHeight()), ""), null, null, r15.J, 830);
        ln0.a r1 = yg0.h.a;
        yg0.h.k(r14, new com.bytedance.android.live.liveinteract.feed.d(r15), null);
        return;
    }

    public com.bytedance.android.live.liveinteract.feed.datamerge.i A(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r10) {
        Intrinsics.checkNotNullParameter(r10, "layoutConfig");
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r0 = r10.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r3 = r10.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r6 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r2 + r1);
        IRoom r4 = this.d;
        DataCenter r5 = this.J;
        com.bytedance.android.live.liveinteract.feed.datamerge.b r7 = this.m;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L13:
        return new com.bytedance.android.live.liveinteract.feed.datamerge.i(r4, r5, r10, r6, r7, this.V);
    L5:
        r2 = 0;
        goto L6
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

    public final void m(List<? extends tf0.e> r4) {
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
        IRoom r6 = this.d;
        if (r6 == null) goto L18;
        String r7 = r6.getOwnerUserIdString();
        if (r7 == null) goto L18;
    L19:
        r3.put("EXT_KEY_ANCHOR_ID", r7);
    L18:
        r7 = "";
        goto L19
    }

    public final void monitorLayouts(String r1) {
        IInteractFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        post(new d(this));
    }

    public final void onKtvRoomSeiModel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView r0 = this.G;
        if (r0 == null) goto L6;
        r0.onSeiUpdatedRaw(r2);
        return;
    }

    public void onSeiUpdated(SeiAppData r8) {
        if (r8 == null) goto L7;
        com.bytedance.android.live.liveinteract.feed.datamerge.b r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L6:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "seiAppData");
        r0.i.onNext(r8);
    L7:
        if (r8 != null) goto L9;
        return;
    L9:
        if (Lists.isEmpty(r8.getGrids()) == true) goto L43;
        JSONObject r1 = this.M;
        SeiCanvas r2 = r8.getCanvas();
        if (r2 == null) goto L14;
        Integer r3 = Integer.valueOf(r2.getWidth());
    L15:
        r1.put("width", r3);
        JSONObject r4 = this.M;
        SeiCanvas r5 = r8.getCanvas();
        if (r5 == null) goto L18;
        Integer r6 = Integer.valueOf(r5.getHeight());
    L19:
        r4.put("height", r6);
        com.bytedance.android.live.liveinteract.feed.datamerge.h r7 = this.n;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L22:
        int r9 = r8.getSubScene();
        ch0.a r10 = ch0.a.a(r7.c().e(), r8.getUiLayout(), r9, null, 4);
        com.bytedance.android.live.liveinteract.feed.datamerge.k r11 = r7.a;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L25:
        r11.l(r10);
        this.e = r8.getUiLayout();
        IRenderView r12 = this.y;
        if (r12 == null) goto L28;
        setLivePlayerView(r12);
    L28:
        this.w = r8;
        com.bytedance.android.live.liveinteract.feed.datamerge.h r13 = this.n;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L31:
        r13.e(r8);
        com.bytedance.android.live.liveinteract.feed.datamerge.m r14 = this.o;
        if (r14 == null) goto L35;
        r14.e(r8);
    L35:
        if ((!(this instanceof MultiLinkGameFeedView)) == true) goto L38;
        return;
    L38:
        if (this.N == true) goto L42;
        post(new com.bytedance.android.live.liveinteract.feed.c(this));
        return;
    L42:
        return;
    L18:
        r6 = null;
        goto L19
    L14:
        r3 = null;
        goto L15
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

    public final void setBaseWindowView(BaseLinkSeatWindowView r1) {
        this.z = r1;
    }

    public final void setBaseWindowViewContainer(FrameLayout r1) {
        this.A = r1;
    }

    public final void setDynamicWidget(com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1) {
        this.K = r1;
    }

    public final void setFeedDataCenter(DataCenter r1) {
        this.J = r1;
    }

    public final void setFeedViewDataMergeCenter(com.bytedance.android.live.liveinteract.feed.datamerge.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final void setHasAdjustWindowUI(boolean r1) {
        this.f = r1;
    }

    public void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        this.L = r2;
    }

    public final void setItemDecoration(BaseEqualGridItemDecoration r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.O = r2;
    }

    public final void setLayoutConfig(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1) {
        this.g = r1;
    }

    public void setLivePlayerClient(ILivePlayerClient r1) {
        this.F = r1;
    }

    public void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
        this.E = r1;
    }

    public void setLivePlayerView(IRenderView r4) {
        if (((Boolean) vm2.d.f8.getValue(null, vm2.d.a[470(0x1d6, float:6.59E-43)])).booleanValue() == true) goto L5;
    L8:
        this.y = r4;
        post(new h(this));
        return;
    L5:
        if (Intrinsics.areEqual(this.y, r4) == false) goto L8;
        if (r4 == null) goto L8;
    }

    public final void setMRoom(IRoom r1) {
        this.d = r1;
    }

    public final void setMViewModelStore(ViewModelStore r1) {
        this.H = r1;
    }

    public final void setSeiVer(int r1) {
        this.T = r1;
    }

    public final void setShowFrom(int r1) {
        this.V = r1;
    }

    public final void setUiLayout(int r1) {
        this.U = r1;
    }

    public final void setViewModelProvider(ViewModelProvider r1) {
        this.I = r1;
    }

    public final void setWindowListHepler(com.bytedance.android.live.liveinteract.feed.datamerge.i r1) {
        this.u = r1;
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IInteractFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public final void updateMessageHub(MessageHub r4) {
        Intrinsics.checkNotNullParameter(r4, "hub");
        this.i = r4;
        if (r4 == null) goto L8;
        String r0 = MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getKey();
        com.bytedance.android.live.liveinteract.feed.datamerge.c r1 = this.s;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cPositionDataHandler");
    L7:
        r4.addMessageListener(r0, r1);
    L8:
        MessageHub r5 = this.i;
        if (r5 == null) goto L15;
        String r2 = MessageType.LINK_MIC.getKey();
        com.bytedance.android.live.liveinteract.feed.datamerge.d r3 = this.t;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicSeatDataHandler");
    L13:
        r5.addMessageListener(r2, r3);
        return;
    }

    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateMvControllerSei(this, r2);
    }

    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateRadioSei(this, r2);
    }

    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateRadioTextSei(this, r2);
    }

    public final void updateRoom(IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        this.d = r4;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.K;
        if (r0 == null) goto L5;
        r0.updateRoom(r4);
    L5:
        com.bytedance.android.live.liveinteract.pre.a.c.a.c(this.d, true);
        post(new j(this));
        IKtvComponentFeedView r1 = this.G;
        if (r1 == null) goto L9;
        r1.updateRoom(r4);
    L9:
        if (vm2.d.L0() == true) goto L11;
    L13:
        f2.g();
        s();
        return;
    L11:
        if (vm2.d.q0().isFeedViewDisplayWhenGuestListReady() == false) goto L13;
        UtilityKotlinExtentionsKt.u(this);
        goto L13
    }

    public final void updateRoomBeforeSelect(IRoom r1) {
        this.d = r1;
    }

    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateSpeechRecognitionSei(this, r2);
    }

    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateSpeechRhythmSei(this, r2);
    }

    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateSubtitleSei(this, r2);
    }

    public final void x(List<? extends tf0.e> r5) {
        if ((!(this instanceof MultiLinkGameFeedView)) == true) goto L5;
        return;
    L5:
        Path r0 = new Path();
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L26;
        tf0.e r1 = (tf0.e) r6.next();
        if ((r1 instanceof MultiLinkGuestViewBinder.a) == true) goto L11;
        r1 = null;
    L11:
        MultiLinkGuestViewBinder.a r2 = (MultiLinkGuestViewBinder.a) r1;
        if (r2 == null) goto L7;
        ILinkPlayerInfoBridge r3 = r2.k.a;
        if (r3.getUser() == null) goto L7;
        if (je0.d.x(Integer.valueOf(r3.getLinkType())) == false) goto L7;
        BaseLinkSeatWindowView r4 = this.z;
        if (r4 == null) goto L20;
        int r7 = r4.S0(r3.getInteractId());
    L21:
        com.bytedance.android.live.liveinteract.videotalk.utils.c r8 = this.B;
        if (r8 == null) goto L24;
        Path r9 = r8.a(r7, 0.0f, 0.0f);
    L25:
        r0.addPath(r9);
        goto L7
    L24:
        r9 = new Path();
        goto L25
    L20:
        r7 = -1;
        goto L21
    L26:
        d0 r10 = this.D;
        if (r10 == null) goto L39;
        r10.o(r0);
        return;
    }

    public final void y(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6) {
        Intrinsics.checkNotNullParameter(r6, "newLayoutConfig");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.g;
        if (((IInteractService) jc1.k.n(IInteractService.class)).needAdjustBottomDpForSearchFeed(this.V, r6.m(), r6.getUiLayout()) == false) goto L8;
        int r1 = com.bytedance.android.live.liveinteract.plantform.commonwindow.n.a;
        Intrinsics.checkNotNullParameter(r6, "layoutConfig");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m.f r2 = r6.t();
        if (r2 == null) goto L7;
        r2.f(80);
    L7:
        this.g = r6;
    L9:
        BaseLinkSeatWindowView r3 = this.z;
        if (r3 == null) goto L12;
        r3.U3(r6, getContainerWidth(), getContainerHeight());
    L12:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r4 = r6.h();
        int r5 = 0;
        if (r4 == null) goto L15;
        int r7 = r4.size();
    L16:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r8 = r6.k();
        if (r8 == null) goto L19;
        r5 = r8.size();
    L19:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r9 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r7 + r5);
        com.bytedance.android.live.liveinteract.feed.datamerge.i r10 = this.u;
        if (r10 == null) goto L22;
        r10.A(r9, r6);
    L22:
        this.B = o(r6, getContainerWidth(), getContainerHeight());
        t(r0, r6);
        return;
    L15:
        r7 = 0;
        goto L16
    L8:
        this.g = r6;
        goto L9
    }

    public static final void f(CommonMultiLinkFeedView r11, int r12) {
        r11.getClass();
        if (r11.h == r12) goto L18;
        if (r12 >= 0) goto L7;
        return;
    L7:
        if (r12 > 9) goto L19;
        r11.h = r12;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = r11.g;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.getUiLayout() != 2) goto L17;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = r11.g;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.m();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = r11.g;
        Intrinsics.checkNotNull(r3);
        Pair r4 = ug0.b.b(r2, r3.getUiLayout(), r11.getContainerWidth(), r11.getContainerHeight());
        ln0.a r5 = yg0.h.a;
        yg0.h.g(r12, new com.bytedance.android.live.liveinteract.feed.j(r11, r12), false, r11.getLayoutConfigRequestExtra(), new Triple(r4.getFirst(), r4.getSecond(), "CommonMultiLinkFeedView#updateLinkWindowLayoutConfigForDynamicEqual, with windowCount = " + r12), r11.getLivePlayerVideoSize(), null, r11.J, 196);
        return;
    L17:
        return;
    L19:
        return;
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        this.P = r1;
    }

    public final void onScreenSizeChange(int r2, int r3) {
        if (this.c == r2) goto L5;
    L6:
        this.c = r2;
        this.b = r3;
        this.f = false;
        w(r2, r3);
        return;
    L5:
        if (this.b != r3) goto L6;
    }

    public final void onWrdsDataUpdate(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        IInteractFeedView.DefaultImpls.onWrdsDataUpdate(this, r2, r3);
    }

    public final void refreshSeiCanvasAndSeiVersion(JSONObject r4, Integer r5) {
        JSONObject r6 = this.M;
        Integer r0 = null;
        if (r4 == null) goto L5;
        Integer r2 = Integer.valueOf(r4.optInt("width"));
    L6:
        r6.put("width", r2);
        JSONObject r7 = this.M;
        if (r4 == null) goto L9;
        r0 = Integer.valueOf(r4.optInt("height"));
    L9:
        r7.put("height", r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void t(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r13, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r14) {
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
        nh0.f r15 = new nh0.f("linkmic", new nh0.e(r3, r4, r5, r6, r7, CollectionsKt.emptyList(), null, null, 192), null, null, null, null, false, 224);
        DataCenter r16 = this.J;
        if (r16 == null) goto L19;
        r16.put("data_multi_lick_dynamic_event_change", r15);
        return;
    L19:
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

    public final void updateSeiVerAndUiLayout(int r18, int r19) {
        this.T = r18;
        this.U = r19;
        if (r19 <= 0) goto L5;
        int r5 = r19;
    L6:
        Pair r3 = ug0.b.b(r18, r5, getContainerWidth(), getContainerHeight());
        Triple r12 = new Triple(r3.getFirst(), r3.getSecond(), "CommonMultiLinkFeedView#updateSeiVerAndUiLayout");
        ln0.a r4 = yg0.h.a;
        int r6 = yg0.h.h(true, r18, r19);
        pn0.i r11 = getLayoutConfigRequestExtra();
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r5, r6, null, false, this.h, false, r11, r12, null, null, this.J, 780), new k(this), null);
        return;
    L5:
        r5 = yg0.h.e(r18);
        goto L6
    }

    public void w(int r19, int r20) {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        int r4 = this.U;
        int r5 = this.T;
        if (r4 > 0) goto L9;
        r4 = yg0.h.e(r5);
    L9:
        int r6 = r4;
        Pair r7 = ug0.b.b(this.T, r6, r19, r20);
        Triple r13 = new Triple(r7.getFirst(), r7.getSecond(), "CommonMultiLinkFeedView#tryAdjustWindowUI");
        ln0.a r8 = yg0.h.a;
        int r9 = yg0.h.h(true, this.T, r6);
        pn0.i r12 = getLayoutConfigRequestExtra();
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r6, r9, null, false, this.h, false, r12, r13, null, null, this.J, 780), new i(this, r19, r20), null);
    }

    public final void j(int r12, int r13, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r14) {
        Intrinsics.checkNotNullParameter(r14, "realLayoutConfig");
        if (r14.getUiLayout() != 2) goto L8;
        if (this.h == 0) goto L8;
        Pair r0 = ug0.b.b(r14.m(), r14.getUiLayout(), r12, r13);
        ln0.a r1 = yg0.h.a;
        yg0.h.g(this.h, new a(this, r12, r13, r14), false, getLayoutConfigRequestExtra(), new Triple(r0.getFirst(), r0.getSecond(), "CommonMultiLinkFeedView#adjustWindowUI#getDynamicEqualLayoutConfig, with currWindowCount = " + this.h), getLivePlayerVideoSize(), null, this.J, 196);
        return;
    L8:
        if (((IInteractService) jc1.k.n(IInteractService.class)).needAdjustBottomDpForSearchFeed(this.V, r14.m(), r14.getUiLayout()) == false) goto L10;
        u(r12, r13, r14);
        return;
    L10:
        u(r12, r13, r14);
    }

    public com.bytedance.android.live.liveinteract.videotalk.utils.h o(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "config");
        if (aj0.a.c(r3.getUiLayout()) == false) goto L5;
        s1.f(14);
    L5:
        r3.q(r5);
        int r0 = ((Number) ug0.b.b(r3.m(), r3.getUiLayout(), r4, r5).getFirst()).intValue();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.g;
        if (r1 == null) goto L9;
        r1.s(r0, r5);
    L9:
        return com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r4, r5, r3);
    }

    public final void u(int r17, int r18, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r19) {
        this.g = r19;
        ALogger.i("CommonMultiLinkFeedView", "adjustWindowUI layoutConfig: " + this.g);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = this.g;
        Intrinsics.checkNotNull(r2);
        this.O = new MultiLinkCommonItemDecoration(r2, s1.f(2.0f), new ColorDrawable(s1.h(2131108427)));
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.g;
        Intrinsics.checkNotNull(r1);
        z(r1, r17, r18);
        BaseLinkSeatWindowView r3 = this.z;
        if (r3 == null) goto L8;
        IRoom r4 = this.d;
        DataCenter r5 = this.J;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6 = this.g;
        Intrinsics.checkNotNull(r6);
        BaseEqualGridItemDecoration r7 = this.O;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
    L7:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.b(r3, r4, r5, r6, r7, null, null, r17, r18, this.V, null, null, 1536);
    L8:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8 = this.g;
        Intrinsics.checkNotNull(r8);
        com.bytedance.android.live.liveinteract.feed.datamerge.i r9 = A(r8);
        this.u = r9;
        if (r9 == null) goto L11;
        r9.x(this.d);
    L11:
        com.bytedance.android.live.liveinteract.feed.datamerge.i r10 = this.u;
        IVoiceLiveTheme r11 = null;
        if (r10 == null) goto L18;
        BehaviorSubject<List<tf0.e>> r12 = r10.b;
        if (r12 == null) goto L18;
        Observable r13 = RxUtilKt.h(r12);
        if (r13 == null) goto L18;
        Disposable r14 = r13.subscribe(new com.bytedance.android.live.liveinteract.feed.i(this));
    L19:
        if (r14 == null) goto L21;
        this.v.add(r14);
    L21:
        ReadOnlyProperty r15 = vm2.d.k8;
        KProperty[] r16 = vm2.d.a;
        boolean r20 = true;
        if (((Boolean) r15.getValue(null, r16[475(0x1db, float:6.66E-43)])).booleanValue() != true) goto L33;
        com.bytedance.android.live.liveinteract.feed.datamerge.i r21 = this.u;
        if (r21 == null) goto L33;
        BehaviorSubject<List<tf0.e>> r22 = r21.b;
        if (r22 == null) goto L33;
        List<? extends tf0.e> r23 = (List) r22.getValue();
        if (r23 == null) goto L33;
        m(r23);
        BaseLinkSeatWindowView r24 = this.z;
        if (r24 == null) goto L32;
        r24.O7(r23);
    L32:
        x(r23);
    L33:
        BaseLinkSeatWindowView r25 = this.z;
        if (r25 == null) goto L37;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r26 = this.g;
        Intrinsics.checkNotNull(r26);
        r25.U3(r26, r17, r18);
    L37:
        if ((!(this instanceof MultiLinkGameFeedView)) == false) goto L63;
        this.D = new d0(false, b(2131388551), b(2131370471), null, new com.bytedance.android.live.liveinteract.feed.h(this), 56);
        if (((Boolean) vm2.d.i.getValue(null, r16[7])).booleanValue() == true) goto L42;
    L54:
        r20 = false;
    L55:
        if (r20 == true) goto L57;
        ALogger.e("MultiLinkThemeBgUIWidget", "CommonMultiLinkFeedView feedView, initTheme");
        com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a r27 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
        d0 r28 = this.D;
        Intrinsics.checkNotNull(r28);
        com.bytedance.android.live.ui.q.a.c(r27, r28);
        this.C = r27.a();
    L57:
        com.bytedance.android.live.ui.q r29 = this.C;
        if (r29 == null) goto L63;
        IRoom r30 = this.d;
        if (r30 == null) goto L62;
        r11 = r30.getVoiceLiveTheme();
    L62:
        r29.c(r11);
        goto L63
    L42:
        if (((Boolean) vm2.d.k3.getValue(null, r16[216(0xd8, float:3.03E-43)])).booleanValue() == true) goto L54;
        int r31 = c1.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r32 = this.g;
        if (r32 == null) goto L46;
        Integer r33 = Integer.valueOf(r32.m());
    L47:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r34 = this.g;
        if (r34 == null) goto L50;
        Integer r35 = Integer.valueOf(r34.getUiLayout());
    L52:
        if (c1.a(r33, r35) == false) goto L54;
    L50:
        r35 = null;
        goto L52
    L46:
        r33 = null;
    L63:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r36 = this.g;
        Intrinsics.checkNotNull(r36);
        this.B = o(r36, r17, r18);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r37 = this.g;
        Intrinsics.checkNotNull(r37);
        Pair r38 = ug0.b.b(r37.m(), r37.getUiLayout(), r17, r18);
        int r39 = ((Number) r38.getFirst()).intValue();
        int r40 = ((Number) r38.getSecond()).intValue();
        ALogger.i("ttlive_link", "CommonMultiLinkFeedView# call adjustUIForXScreen, layoutConfig[uiLayout = " + r37.getUiLayout() + ", seiVersion = " + r37.m() + "] containerSize[" + r17 + ", " + r18 + "], adjustSize[" + r39 + ", " + r40 + ']');
        z(r37, r17, r18);
        BaseLinkSeatWindowView r41 = this.z;
        if (r41 == null) goto L66;
        r41.Yd(r37, r39, r40);
    L66:
        BaseLinkSeatWindowView r42 = this.z;
        if (r42 == null) goto L69;
        r42.Sp(r37, r39, r40);
    L69:
        BaseLinkSeatWindowView r43 = this.z;
        if (r43 == null) goto L74;
        RecyclerView r44 = r43.getRecyclerView();
        if (r44 == null) goto L74;
        r44.post(new com.bytedance.android.live.liveinteract.feed.e(this, r37, r39, r40));
    L74:
        ConstraintLayout r45 = this.z;
        if (r45 == null) goto L77;
        int r46 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r45, new CommonMultiLinkFeedView$realAdjustWindowUI$1(this));
    L77:
        g();
        CommonLinkSeatWindowView r47 = (CommonLinkSeatWindowView) b(2131378011);
        if (r47 == null) goto L83;
        RecyclerView r48 = r47.getRecyclerView();
        if (r48 == null) goto L84;
        r48.post(new g(this));
        return;
    L84:
        return;
    L83:
        return;
    L18:
        r14 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b.a.a(r2, r3, (l0) r4);
    }

    public final void z(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Pair r6 = ug0.b.b(r3.m(), r3.getUiLayout(), r4, r5);
        Triple r7 = new Triple(r6.getFirst(), r6.getSecond(), "CommonMultiLinkFeedView#updateLayoutConfigResultIfNeed");
        Pair<Integer, Integer> r8 = getLivePlayerVideoSize();
        ln0.a r0 = yg0.h.a;
        r3.d = yg0.h.a(r3, r7, r8);
    }

    public CommonMultiLinkFeedView(Context r4, int r5, int r6, int r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r8, r9);
        this.T = r5;
        this.U = r6;
        this.V = r7;
        this.a = new LinkedHashMap();
        this.b = -1;
        this.c = -1;
        this.l = new LinkedHashMap();
        this.v = new CompositeDisposable();
        this.x = new CompositeDisposable();
        this.M = new JSONObject();
        com.bytedance.android.live.liveinteract.pre.a.c.a.a(hashCode(), this.T);
        boolean r10 = true;
        VerticalNitaInflate.a(VerticalNitaInflate.Tag.CommonMultiLinkFeedView_container.name(), getResourceLayout(), r4, this, true);
        int r11 = com.bytedance.android.live.liveinteract.utils.w0.a;
        AttributeSet r12 = null;
        int r13 = 0;
        if (((Boolean) vm2.h.h6.getValue(null, vm2.h.a[370(0x172, float:5.18E-43)])).booleanValue() == false) goto L9;
        CommonLinkSeatWindowView r14 = new CommonLinkSeatWindowView(getContext(), r12, 6, r13);
        r14.setId(2131378011);
        Unit r15 = Unit.INSTANCE;
        this.z = r14;
        this.A = (FrameLayout) findViewById(2131378012);
        ConstraintLayout r16 = this.z;
        if (r16 == null) goto L9;
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-1, -1);
        r17.gravity = 49;
        FrameLayout r18 = this.A;
        if (r18 == null) goto L9;
        r18.addView(r16, r17);
    L9:
        setImportantForAccessibility(4);
        this.f = false;
        this.z = (BaseLinkSeatWindowView) findViewById(2131378011);
        this.m = new com.bytedance.android.live.liveinteract.feed.datamerge.b(this.i, this.V);
        this.n = new com.bytedance.android.live.liveinteract.feed.datamerge.h(new com.bytedance.android.live.liveinteract.feed.f(this));
        ArrayList r19 = new ArrayList();
        com.bytedance.android.live.liveinteract.feed.datamerge.h r20 = this.n;
        if (r20 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L12:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r1 = this.m;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L15:
        r20.d(r1);
        r19.add(r20);
        this.p = new com.bytedance.android.live.liveinteract.feed.datamerge.g(r19);
        this.r = new FeedViewInteractSongDataHandler(new CommonMultiLinkFeedView$initFeedViewDataMergeCenter$2(this), new CommonMultiLinkFeedView$initFeedViewDataMergeCenter$3(this));
        FrameLayout r21 = (FrameLayout) findViewById(2131362410);
        FeedViewInteractSongDataHandler r22 = this.r;
        if (r22 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewInteractSongDataHandler");
    L18:
        r22.e(r21);
        this.s = new com.bytedance.android.live.liveinteract.feed.datamerge.c();
        this.t = new com.bytedance.android.live.liveinteract.feed.datamerge.d();
        com.bytedance.android.live.liveinteract.feed.datamerge.b r23 = this.m;
        if (r23 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L21:
        com.bytedance.android.live.liveinteract.feed.datamerge.h r24 = this.n;
        if (r24 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("seiDataHandler");
    L24:
        r23.u(r24);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r25 = this.m;
        if (r25 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L27:
        com.bytedance.android.live.liveinteract.feed.datamerge.g r26 = this.p;
        if (r26 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("onlineUserListHandler");
    L30:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r27 = this.m;
        if (r27 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L33:
        r26.d(r27);
        r25.u(r26);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r28 = this.m;
        if (r28 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L36:
        FeedViewInteractSongDataHandler r29 = this.r;
        if (r29 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewInteractSongDataHandler");
    L39:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r30 = this.m;
        if (r30 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L42:
        r29.d(r30);
        r28.u(r29);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r31 = this.m;
        if (r31 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L45:
        com.bytedance.android.live.liveinteract.feed.datamerge.c r32 = this.s;
        if (r32 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("cPositionDataHandler");
    L48:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r33 = this.m;
        if (r33 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L51:
        r32.d(r33);
        r31.u(r32);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r34 = this.m;
        if (r34 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L54:
        com.bytedance.android.live.liveinteract.feed.datamerge.d r35 = this.t;
        if (r35 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicSeatDataHandler");
    L57:
        com.bytedance.android.live.liveinteract.feed.datamerge.b r36 = this.m;
        if (r36 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L60:
        r35.d(r36);
        r34.u(r35);
        if ((this instanceof MultiLinkLinkRoomFightFeedView) == false) goto L63;
    L64:
        this.o = new com.bytedance.android.live.liveinteract.feed.datamerge.m(this.d, new com.bytedance.android.live.liveinteract.feed.g(this));
        ArrayList r37 = new ArrayList();
        com.bytedance.android.live.liveinteract.feed.datamerge.m r38 = this.o;
        Intrinsics.checkNotNull(r38);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r39 = this.m;
        if (r39 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L67:
        r38.d(r39);
        r37.add(r38);
        this.q = new com.bytedance.android.live.liveinteract.feed.datamerge.l(r37);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r40 = this.m;
        if (r40 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L70:
        com.bytedance.android.live.liveinteract.feed.datamerge.m r41 = this.o;
        Intrinsics.checkNotNull(r41);
        r40.u(r41);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r42 = this.m;
        if (r42 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L73:
        com.bytedance.android.live.liveinteract.feed.datamerge.l r43 = this.q;
        Intrinsics.checkNotNull(r43);
        com.bytedance.android.live.liveinteract.feed.datamerge.b r44 = this.m;
        if (r44 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewDataMergeCenter");
    L76:
        r43.d(r44);
        r42.u(r43);
    L77:
        IKtvComponentFeedView r45 = jc1.k.n(IKtvService.class).getKtvComponentFeedView(r4, false);
        this.G = r45;
        ConstraintLayout.LayoutParams r46 = com.bytedance.android.live.liveinteract.utils.h.c(this.T, 2131378011);
        if (r45 == null) goto L81;
        r45.setAttachParent((ViewGroup) findViewById(2131384822), r46);
    L81:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L83;
    L85:
        r10 = false;
    L86:
        if (r10 == false) goto L91;
        IInteractService r47 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r47 == null) goto L92;
        r47.preloadDynamicContainer(s1.getContext());
        return;
    L92:
        return;
    L91:
        return;
    L83:
        if (vm2.h.i().enablePreLoadDynamicContainerOnFeedView() == false) goto L85;
    L63:
        if ((this instanceof MultiLinkGameFeedView) == false) goto L77;
        goto L64
    }
}
