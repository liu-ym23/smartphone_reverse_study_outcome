package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkbase.SupportUpdatePlayMode;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.adapter.LinkSeatMultiAdapterWrapper$updateDataListWithDiffCallback$2;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.diffutils.MultiLinkDiffCallback;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkAudioStageEnlargeRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkRecyclerLayoutManagerV2;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.PCLandscapeLinkSeatRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.ui.ClipFrameLayout;
import com.bytedance.android.live.ui.ClipImageView;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B.\b\u0007\u0012\b\u0010Ï\u0001\u001a\u00030Î\u0001\u0012\f\b\u0002\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u0001\u0012\t\b\u0002\u0010Ò\u0001\u001a\u00020\u0004¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\b\u0010\u0005\u001a\u00020\u0004H$J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010*\u001a\u00020\u00128\u0004X\u0084D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010B\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010F\u001a\u00020C8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010P\u001a\u0004\u0018\u00010\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010X\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010\\\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010-\u001a\u0004\bZ\u0010/\"\u0004\b[\u00101R$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010h\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR$\u0010p\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010x\u001a\u00020q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR%\u0010\u0080\u0001\u001a\u0004\u0018\u00010y8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR(\u0010\u0084\u0001\u001a\u0004\u0018\u00010y8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010{\u001a\u0005\b\u0082\u0001\u0010}\"\u0005\b\u0083\u0001\u0010\u007fR)\u0010\u008b\u0001\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R+\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R+\u0010¡\u0001\u001a\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R)\u0010¨\u0001\u001a\u00020\f8\u0004@\u0004X\u0084.¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R,\u0010°\u0001\u001a\u0005\u0018\u00010©\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R:\u0010º\u0001\u001a\u0013\u0012\u0005\u0012\u00030²\u0001\u0012\u0005\u0012\u00030³\u0001\u0018\u00010±\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R,\u0010Â\u0001\u001a\u0005\u0018\u00010»\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R&\u0010Æ\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÃ\u0001\u0010E\u001a\u0005\bÄ\u0001\u0010G\"\u0005\bÅ\u0001\u0010IR,\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001¨\u0006Õ\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lxg0/a;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/l;", "", "getLayoutId", "Lug0/a;", "getRvLayoutManager", "", "Ltf0/e;", "getDataList", "getCurrentWindowCount", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "getLinkWindowLayoutConfig", "Lse0/c;", "getAudioFeedLayerUIConfig", "getLastSubUILayout", "()Ljava/lang/Integer;", "", "getNitaTag", "getFeedType", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "Lcom/bytedance/android/live/ui/ClipFrameLayout;", "getFirstSeatVHShadowContainer", "getFirstSeatVHShadowFloatContainer", "Landroidx/recyclerview/widget/RecyclerView;", "getMicSeatRecyclerView", "Lvg0/a;", "a", "Lvg0/a;", "getItemListener", "()Lvg0/a;", "setItemListener", "(Lvg0/a;)V", "itemListener", "b", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;", "c", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;", "getRecyclerView", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;", "setRecyclerView", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;)V", "recyclerView", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "d", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "getCurRvLayoutParams", "()Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "setCurRvLayoutParams", "(Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;)V", "curRvLayoutParams", "Lfg0/a;", "e", "Lfg0/a;", "getMultiAdapterWrapper", "()Lfg0/a;", "setMultiAdapterWrapper", "(Lfg0/a;)V", "multiAdapterWrapper", "", "f", "Z", "isUIViewValid", "()Z", "setUIViewValid", "(Z)V", "g", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getSingleSurfaceViewContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setSingleSurfaceViewContainer", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "singleSurfaceViewContainer", "Landroid/view/ViewGroup;", "h", "Landroid/view/ViewGroup;", "getLynxViewContainer", "()Landroid/view/ViewGroup;", "setLynxViewContainer", "(Landroid/view/ViewGroup;)V", "lynxViewContainer", "i", "getAnimRecyclerView", "setAnimRecyclerView", "animRecyclerView", "Lcom/bytedance/android/live/ui/ClipImageView;", "j", "Lcom/bytedance/android/live/ui/ClipImageView;", "getThemeBgView", "()Lcom/bytedance/android/live/ui/ClipImageView;", "setThemeBgView", "(Lcom/bytedance/android/live/ui/ClipImageView;)V", "themeBgView", "k", "getDynamicClipBg", "setDynamicClipBg", "dynamicClipBg", "Landroid/view/View;", "l", "Landroid/view/View;", "getDynamicBgContainer", "()Landroid/view/View;", "setDynamicBgContainer", "(Landroid/view/View;)V", "dynamicBgContainer", "Lxg0/b;", "m", "Lxg0/b;", "getLinkSeatAbilityProvider", "()Lxg0/b;", "setLinkSeatAbilityProvider", "(Lxg0/b;)V", "linkSeatAbilityProvider", "Lme/drakeet/multitype/MultiTypeAdapter;", "n", "Lme/drakeet/multitype/MultiTypeAdapter;", "getBasicAdapter", "()Lme/drakeet/multitype/MultiTypeAdapter;", "setBasicAdapter", "(Lme/drakeet/multitype/MultiTypeAdapter;)V", "basicAdapter", "o", "getAnimAdapter", "setAnimAdapter", "animAdapter", "p", "I", "getMFeedType", "()I", "setMFeedType", "(I)V", "mFeedType", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/d;", "r", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/d;", "getLinkUserDataMergeCenter", "()Lcom/bytedance/android/live/liveinteract/plantform/datamerge/d;", "setLinkUserDataMergeCenter", "(Lcom/bytedance/android/live/liveinteract/plantform/datamerge/d;)V", "linkUserDataMergeCenter", "s", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getMDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setMDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "mDataCenter", "t", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setMRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "mRoom", "u", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "getLayoutConfig", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "setLayoutConfig", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;)V", "layoutConfig", "Ltf0/o$a;", "v", "Ltf0/o$a;", "getCallBack", "()Ltf0/o$a;", "setCallBack", "(Ltf0/o$a;)V", "callBack", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "", "w", "Lkotlin/jvm/functions/Function1;", "getMicSeatPositionListener", "()Lkotlin/jvm/functions/Function1;", "setMicSeatPositionListener", "(Lkotlin/jvm/functions/Function1;)V", "micSeatPositionListener", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;", "y", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;", "getWindowListHelper", "()Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;", "setWindowListHelper", "(Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;)V", "windowListHelper", "B", "getHasUploadGuest", "setHasUploadGuest", "hasUploadGuest", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/CommonLinkSeatWindowView$a;", "mFirstVHShadowViewChange", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/CommonLinkSeatWindowView$a;", "getMFirstVHShadowViewChange", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/CommonLinkSeatWindowView$a;", "setMFirstVHShadowViewChange", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/CommonLinkSeatWindowView$a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseLinkSeatWindowView extends ConstraintLayout implements xg0.a, l {
    public final ClipFrameLayout A;
    public boolean B;
    public vg0.a a;
    public final String b;
    public LinkMicRecyclerView c;
    public ConstraintLayout.LayoutParams d;
    public fg0.a e;
    public boolean f;
    public ConstraintLayout g;
    public ViewGroup h;
    public LinkMicRecyclerView i;
    public ClipImageView j;
    public ClipImageView k;
    public View l;
    public xg0.b m;
    public MultiTypeAdapter n;
    public MultiTypeAdapter o;
    public int p;
    public se0.c q;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d r;
    public DataCenter s;
    public IRoom t;
    public m u;
    public tf0.o.a v;
    public Function1<? super Rect, Unit> w;
    public Integer x;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.a y;
    public final ClipFrameLayout z;

    public static final class a implements Choreographer.FrameCallback {
        public final /* synthetic */ BaseLinkSeatWindowView a;

        public a(BaseLinkSeatWindowView r1, long r2) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r1) {
            System.currentTimeMillis();
            this.a.setHasUploadGuest(true);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView$getDataList$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass1 extends PropertyReference0Impl {
        public AnonymousClass1(BaseLinkSeatWindowView r7) {
            super(r7, BaseLinkSeatWindowView.class, "layoutConfig", "getLayoutConfig()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkWindowLayoutConfig;", 0);
        }

        public Object get() {
            return ((BaseLinkSeatWindowView) ((CallableReference) this).receiver).getLayoutConfig();
        }
    }

    public BaseLinkSeatWindowView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseLinkSeatWindowView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public boolean Gi() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void Ha(m r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder.b, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void K1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    public abstract void T5(MultiTypeAdapter r1, SeatAnimEngineWrapper r2);

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void T8() {
    }

    public abstract void U5(MultiTypeAdapter r1);

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder.b
    public void V3(MultiLinkPreOnlineViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public abstract /* synthetic */ m getCurrentLayoutConfig();

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public Long getEnterRoomTime() {
        return null;
    }

    public FrameLayout getInteractiveSongMvBg() {
        return null;
    }

    public abstract /* synthetic */ BehaviorSubject<m> getLayoutConfigObservable();

    public abstract int getLayoutId();

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public abstract /* synthetic */ BaseLinkSeatWindowView getLinkSeatWindowView();

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public JsonObject getLinkmicAreaFrameInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public JsonObject getLinkmicSeatListInfo() {
        return null;
    }

    public CommonLinkSeatWindowView.a getMFirstVHShadowViewChange() {
        return null;
    }

    public String getNitaTag() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void jf() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void m3(MultiLinkGuestViewBinder.a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "itemData");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void setMFirstVHShadowViewChange(CommonLinkSeatWindowView.a r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final ViewGroup td() {
        return this;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public View vb() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Ma() {
        ALogger.e("ttlive_link", "BaseLinkSeatWindowView [avatar-fresh] call adapterNotifyDataSetChange, stack = " + Log.getStackTraceString(new Exception()));
        fg0.a r0 = getMultiAdapterWrapper();
        if (r0 == null) goto L8;
        Iterator r1 = ((ArrayList) r0.b).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        MultiTypeAdapter r2 = (MultiTypeAdapter) r1.next();
        r2.notifyDataSetChanged();
        r2.getItemCount();
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public int getCurrentWindowCount() {
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        m r1 = this.u;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L5:
        r1.getUiLayout();
        int r2 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r2) == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r3 = this.y;
        if (r3 == null) goto L21;
        BehaviorSubject<List<tf0.e>> r4 = r3.b;
        if (r4 == null) goto L22;
        List r5 = (List) r4.getValue();
        if (r5 != null) goto L14;
        return 0;
    L14:
        return r5.size();
    L22:
        return 0;
    L21:
        return 0;
    L15:
        fg0.a r6 = getMultiAdapterWrapper();
        if (r6 == null) goto L24;
        List<? extends tf0.e> r7 = r6.a;
        if (r7 != null) goto L20;
        return 0;
    L20:
        return r7.size();
    L24:
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public List<tf0.e> getDataList() {
        if (this.u == null) goto L5;
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        int r1 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r1) == false) goto L14;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r2 = this.y;
        if (r2 == null) goto L18;
        BehaviorSubject<List<tf0.e>> r3 = r2.b;
        if (r3 != null) goto L13;
        return null;
    L13:
        return (List) r3.getValue();
    L18:
        return null;
    L14:
        fg0.a r4 = getMultiAdapterWrapper();
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4.a;
    L5:
        return CollectionsKt.emptyList();
    }

    public final m getLayoutConfig() {
        m r0 = this.u;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.a
    public m getLinkWindowLayoutConfig() {
        m r0 = this.u;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final boolean gg() {
        m r0 = this.u;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L6:
        if (r0.getUiLayout() != 24) goto L21;
        LinkMicRecyclerView r1 = getRecyclerView();
        RecyclerView.LayoutManager r2 = null;
        if (r1 == null) goto L10;
        RecyclerView.LayoutManager r3 = r1.getLayoutManager();
    L12:
        if ((r3 instanceof CommonDynamicIslandLayoutManager) == false) goto L15;
        r2 = r3;
    L15:
        CommonDynamicIslandLayoutManager r4 = (CommonDynamicIslandLayoutManager) r2;
        if (r4 != null) goto L18;
        return false;
    L18:
        if (r4.d != true) goto L23;
        return true;
    L23:
        return false;
    L10:
        r3 = null;
        goto L12
    L21:
        return false;
    }

    @Override // xg0.a, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public RecyclerView getMicSeatRecyclerView() {
        return getRecyclerView();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public ug0.a getRvLayoutManager() {
        LinkMicRecyclerView r0 = getRecyclerView();
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof ug0.a) == false) goto L11;
        r1 = r2;
    L11:
        return (ug0.a) r1;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void release() {
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        LinkMicRecyclerView r1 = getRecyclerView();
        if (r1 == null) goto L8;
        r1.setAdapter(null);
    L8:
        fg0.a r2 = getMultiAdapterWrapper();
        if (r2 == null) goto L11;
        ((ArrayList) r2.b).clear();
    L11:
        LinkMicRecyclerView r3 = getRecyclerView();
        if (r3 == null) goto L14;
        ((ArrayList) r3.d).clear();
    L14:
        RecyclerView r4 = this.i;
        if (r4 == null) goto L17;
        r4.removeAllViews();
    L17:
        LinkMicRecyclerView r5 = this.i;
        if (r5 == null) goto L20;
        r5.setAdapter(null);
    L20:
        x8();
        setUIViewValid(false);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void x8() {
        fg0.a r0 = getMultiAdapterWrapper();
        if (r0 == null) goto L6;
        r0.a = new ArrayList();
        return;
    }

    public MultiTypeAdapter getAnimAdapter() {
        return this.o;
    }

    public final LinkMicRecyclerView getAnimRecyclerView() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.a
    public se0.c getAudioFeedLayerUIConfig() {
        return this.q;
    }

    public MultiTypeAdapter getBasicAdapter() {
        return this.n;
    }

    public final tf0.o.a getCallBack() {
        return this.v;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public ConstraintLayout.LayoutParams getCurRvLayoutParams() {
        return this.d;
    }

    @Override // xg0.a
    public DataCenter getDataCenter() {
        return this.s;
    }

    public final View getDynamicBgContainer() {
        return this.l;
    }

    public final ClipImageView getDynamicClipBg() {
        return this.k;
    }

    @Override // xg0.a
    public int getFeedType() {
        return this.p;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public ClipFrameLayout getFirstSeatVHShadowContainer() {
        return this.z;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public ClipFrameLayout getFirstSeatVHShadowFloatContainer() {
        return this.A;
    }

    public final boolean getHasUploadGuest() {
        return this.B;
    }

    public final vg0.a getItemListener() {
        return this.a;
    }

    @Override // hg0.a
    public Integer getLastSubUILayout() {
        return this.x;
    }

    public final xg0.b getLinkSeatAbilityProvider() {
        return this.m;
    }

    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d getLinkUserDataMergeCenter() {
        return this.r;
    }

    public final ViewGroup getLynxViewContainer() {
        return this.h;
    }

    public final DataCenter getMDataCenter() {
        return this.s;
    }

    public final int getMFeedType() {
        return this.p;
    }

    public final IRoom getMRoom() {
        return this.t;
    }

    public final Function1<Rect, Unit> getMicSeatPositionListener() {
        return this.w;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public fg0.a getMultiAdapterWrapper() {
        return this.e;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public LinkMicRecyclerView getRecyclerView() {
        return this.c;
    }

    @Override // xg0.a
    public IRoom getRoom() {
        return this.t;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public ConstraintLayout getSingleSurfaceViewContainer() {
        return this.g;
    }

    public final String getTAG() {
        return this.b;
    }

    public final ClipImageView getThemeBgView() {
        return this.j;
    }

    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a getWindowListHelper() {
        return this.y;
    }

    public final void requestLayout() {
        super.requestLayout();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.b
    public final void E5(ch0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.E5(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public final void N0(w8 r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiMessage");
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.N0(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void O7(List<? extends tf0.e> r26) {
        Intrinsics.checkNotNullParameter(r26, "list");
        if (ListUtils.isEmpty(r26) == false) goto L5;
        return;
    L5:
        m r2 = this.u;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L9:
        if (r2.getUiLayout() == 7) goto L18;
        MultiLinkFrequencyOptConfig r3 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        m r4 = this.u;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L13:
        Integer r5 = Integer.valueOf(r4.m());
        m r6 = this.u;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L17:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.k(r5, Integer.valueOf(r6.getUiLayout())) == true) goto L18;
    L40:
        int r7 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r8 = this.s;
        IRoom r9 = this.t;
        if (r9 == null) goto L43;
        long r10 = r9.getId();
    L44:
        MultiSceneEnterRoomStatisticsUtils r11 = MultiSceneEnterRoomStatisticsUtils.a.a(r8, Long.valueOf(r10));
        if (r11 == null) goto L47;
        long r12 = r11.c();
    L48:
        System.currentTimeMillis();
        final fg0.a r13 = getMultiAdapterWrapper();
        if (r13 == null) goto L119;
        DataCenter r14 = this.s;
        Intrinsics.checkNotNullParameter(r26, "newDataList");
        int r15 = r26.size();
        int r16 = 0;
    L51:
        if (r16 >= r15) goto L54;
        ((tf0.e) ListProtector.get(r26, r16)).a = r16;
        r16 = r16 + 1;
        goto L51
    L54:
        if (vm2.l.a() == true) goto L56;
        long r17 = r12;
    L98:
        DiffUtil.DiffResult r18 = DiffUtil.calculateDiff(new MultiLinkDiffCallback(r13.a, r26));
        r13.a = r26;
        Iterator r19 = ((ArrayList) r13.b).iterator();
    L100:
        if (r19.hasNext() == false) goto L102;
        ((MultiTypeAdapter) r19.next()).A2(r26);
        goto L100
    L102:
        int r20 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r21 = MultiSceneEnterRoomStatisticsUtils.a.a(r14, 0L);
        if (r21 == null) goto L105;
        r21.c();
    L105:
        Iterator<T> r22 = r26.iterator();
    L107:
        if (r22.hasNext() == false) goto L111;
        Object r23 = r22.next();
        if ((!(((tf0.e) r23) instanceof MultiLinkNormalEmptyViewBinder.a)) == false) goto L107;
    L113:
        if (((tf0.e) r23) == null) goto L117;
        System.currentTimeMillis();
        int r24 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r110 = MultiSceneEnterRoomStatisticsUtils.a.a(r14, 0L);
        if (r110 == null) goto L118;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r110, "native_micseat_receive_guest_list", 0, 2, null);
    L118:
        r18.dispatchUpdatesTo(new LinkSeatMultiAdapterWrapper$updateDataListWithDiffCallback$2(r13));
    L121:
        if (this.B == true) goto L163;
        boolean r25 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        m r27 = this.u;
        if (r27 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L125:
        r27.getUiLayout();
        int r28 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r28) == true) goto L164;
        Iterator<T> r1 = r26.iterator();
    L129:
        if (r1.hasNext() == false) goto L133;
        Object r29 = r1.next();
        if ((!(((tf0.e) r29) instanceof MultiLinkNormalEmptyViewBinder.a)) == false) goto L129;
        Object r30 = r29;
    L134:
        if (r30 == null) goto L165;
        Choreographer.getInstance().postFrameCallback(new a(this, r17));
        return;
    L165:
        return;
    L133:
        r30 = null;
        goto L134
    L164:
        return;
    L163:
        return;
    L117:
        System.currentTimeMillis();
        goto L118
    L111:
        r23 = null;
        goto L113
    L56:
        StringBuilder r111 = new StringBuilder("\n");
        int r112 = r26.size();
        int r113 = 0;
    L57:
        if (r113 >= r112) goto L97;
        tf0.e r114 = (tf0.e) ListProtector.get(r26, r113);
        if ((r114 instanceof MultiLinkAudioFirstUserViewBinder.a) == false) goto L65;
        ch0.e r31 = ((MultiLinkAudioFirstUserViewBinder.a) r114).k;
        int r115 = r112;
        ILinkPlayerInfoBridge r116 = r31.a;
        boolean r32 = ch0.f.a(r31);
        long r117 = r12;
        StringBuilder r33 = new StringBuilder("uiPosition: ");
        r33.append(r114.a);
        r33.append(", AudioFirstUserItemData, nickName = ");
        IBaseUser r34 = r116.getUser();
        if (r34 == null) goto L63;
        String r35 = r34.getNickName();
    L64:
        r33.append(r35);
        r33.append(", isEnlarged = ");
        r33.append(r116.isEnlarged());
        r33.append(", isTalking = ");
        r33.append(r32);
        r33.append(", isBackground = ");
        r33.append(r116.isBackground());
        r33.append(", voiceAnchorGuideInfo = ");
        r33.append(((MultiLinkAudioFirstUserViewBinder.a) r114).s);
        r33.append('\n');
        r111.append(r33.toString());
    L96:
        r113 = r113 + 1;
        r112 = r115;
        r12 = r117;
        goto L57
    L63:
        r35 = null;
        goto L64
    L65:
        r117 = r12;
        r115 = r112;
        if ((r114 instanceof MultiLinkFirstUserViewBinder.a) == false) goto L73;
        ch0.e r36 = ((MultiLinkFirstUserViewBinder.a) r114).k;
        ILinkPlayerInfoBridge r37 = r36.a;
        boolean r38 = ch0.f.a(r36);
        StringBuilder r118 = new StringBuilder("uiPosition: ");
        r118.append(r114.a);
        r118.append(", FirstUserItemData, nickName = ");
        IBaseUser r39 = r37.getUser();
        if (r39 == null) goto L70;
        String r40 = r39.getNickName();
    L71:
        r118.append(r40);
        r118.append(", isEnlarged = ");
        r118.append(r37.isEnlarged());
        r118.append(", isTalking = ");
        r118.append(r38);
        r118.append(", isBackground = ");
        r118.append(r37.isBackground());
        r118.append('\n');
        r111.append(r118.toString());
        goto L96
    L70:
        r40 = null;
        goto L71
    L73:
        if ((r114 instanceof MultiLinkLastEmptyViewBinder.a) == false) goto L76;
        r111.append("uiPosition: " + r114.a + ", LastEmptyItemData\n");
        goto L96
    L76:
        if ((r114 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L79;
        r111.append("uiPosition: " + r114.a + ", EmptyItemData, positionNameItem = " + ((MultiLinkNormalEmptyViewBinder.a) r114).c() + '\n');
        goto L96
    L79:
        if ((r114 instanceof MultiLinkGuestViewBinder.a) == false) goto L96;
        ch0.e r41 = ((MultiLinkGuestViewBinder.a) r114).k;
        ILinkPlayerInfoBridge r42 = r41.a;
        boolean r43 = ch0.f.a(r41);
        StringBuilder r44 = new StringBuilder("uiPosition: ");
        r44.append(r114.a);
        r44.append(", GuestItemData, nickName = ");
        IBaseUser r45 = r42.getUser();
        if (r45 == null) goto L83;
        String r46 = r45.getNickName();
    L84:
        r44.append(r46);
        r44.append(", isSupportedGift = ");
        r44.append(r42.isOpenSendGift());
        r44.append("isEnlarged = ");
        r44.append(r42.isEnlarged());
        r44.append(", isAnchorLable = ");
        g0 r47 = r42.getMicPosTagInfo();
        if (r47 == null) goto L94;
        Intrinsics.checkNotNullParameter(r47, "$this$isAnchorLabel");
        if (r47.getTagType() != 3) goto L89;
    L92:
        boolean r48 = true;
    L93:
        Boolean r49 = Boolean.valueOf(r48);
    L95:
        r44.append(r49);
        r44.append(", isTalking = ");
        r44.append(r43);
        r44.append(", isBackground = ");
        r44.append(r42.isBackground());
        r44.append("linkTypeIsVideoOrAvatar = ");
        MultiLinkGuestViewBinder.a r119 = (MultiLinkGuestViewBinder.a) r114;
        r44.append(ch0.f.c(r119.k));
        r44.append(", mediaTypeIsVideoOrAvatar = ");
        r44.append(ch0.f.d(r119.k));
        r44.append('\n');
        r111.append(r44.toString());
        goto L96
    L89:
        if (r47.getTagTypeId() == 3) goto L92;
        r48 = false;
        goto L93
    L94:
        r49 = null;
        goto L95
    L83:
        r46 = null;
        goto L84
    L97:
        r17 = r12;
        String r50 = "step: , updateDataListWithDiffCallback: " + r111.toString();
        gh0.b.a("WindowListHelper", r50, false);
        int r51 = x8.a.a;
        x8.a.b("MultiLink", "LinkSeatMultiAdapterWrapper" + r50, false);
        goto L98
    L119:
        r17 = r12;
        goto L121
    L47:
        r12 = 0;
        goto L48
    L43:
        r10 = 0;
    L18:
        ArrayList r52 = new ArrayList();
        int r53 = r26.size();
    L19:
        r53 = r53 - 1;
        if (r53 < 0) goto L34;
        if ((ListProtector.get(r26, r53) instanceof MultiLinkFirstUserViewBinder.a) == true) goto L19;
        Object r54 = ListProtector.get(r26, r53);
        if ((r54 instanceof MultiLinkGuestViewBinder.a) == true) goto L27;
        r54 = null;
    L27:
        MultiLinkGuestViewBinder.a r55 = (MultiLinkGuestViewBinder.a) r54;
        if (r55 == null) goto L19;
        if (r55.k.a.getUser() == null) goto L19;
        if (je0.d.x(Integer.valueOf(r55.k.a.getLinkType())) == false) goto L19;
        r52.add(Integer.valueOf(r53));
        goto L19
    L34:
        Object r56 = ListProtector.get(r26, 0);
        if ((r56 instanceof MultiLinkFirstUserViewBinder.a) == true) goto L37;
        r56 = null;
    L37:
        MultiLinkFirstUserViewBinder.a r57 = (MultiLinkFirstUserViewBinder.a) r56;
        if (r57 == null) goto L40;
        r57.o = r52;
        goto L40
    }

    @Override // hg0.a
    public final ig0.b P6(int r3) {
        LinkMicRecyclerView r0 = this.i;
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r4 = r0.findViewHolderForAdapterPosition(r3);
    L7:
        if ((r4 instanceof hg0.b) == true) goto L9;
        return null;
    L9:
        return ((hg0.b) r4).l().n();
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder.b
    public final void Q3(MultiLinkSpecialViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.Q3(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final int S0(String r7) {
        if (this.u != null) goto L5;
        return -1;
    L5:
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        int r1 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r1) == false) goto L31;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r2 = this.y;
        if (r2 == null) goto L30;
        BehaviorSubject<List<tf0.e>> r3 = r2.b;
        if (r3 == null) goto L37;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L38;
        Iterator r5 = r4.iterator();
        int r6 = 0;
    L15:
        if (r5.hasNext() == false) goto L40;
        tf0.e r8 = (tf0.e) r5.next();
        String r9 = null;
        if ((r8 instanceof MultiLinkGuestViewBinder.a) == true) goto L19;
        r8 = null;
    L19:
        MultiLinkGuestViewBinder.a r10 = (MultiLinkGuestViewBinder.a) r8;
        if (r10 == null) goto L27;
        ch0.e r11 = r10.k;
        if (r11 == null) goto L27;
        ILinkPlayerInfoBridge r12 = r11.a;
        if (r12 == null) goto L27;
        r9 = r12.getInteractId();
    L27:
        if (Intrinsics.areEqual(r9, r7) == true) goto L39;
        r6 = r6 + 1;
        goto L15
    L39:
        return r6;
    L40:
        return -1;
    L38:
        return -1;
    L37:
        return -1;
    L30:
        return -1;
    L31:
        fg0.a r13 = getMultiAdapterWrapper();
        if (r13 != null) goto L34;
        return -1;
    L34:
        return r13.a("", r7);
    }

    public final int S5(String r7) {
        Intrinsics.checkNotNullParameter(r7, "interactId");
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.y;
        int r1 = -1;
        if (r0 == null) goto L20;
        BehaviorSubject<List<tf0.e>> r2 = r0.b;
        if (r2 == null) goto L20;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L20;
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L10:
        if (r4.hasNext() == false) goto L20;
        Object r6 = r4.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        tf0.e r9 = (tf0.e) r6;
        if ((r9 instanceof MultiLinkGuestViewBinder.a) == false) goto L19;
        if (Intrinsics.areEqual(((MultiLinkGuestViewBinder.a) r9).k.a.getInteractId(), r7) == false) goto L19;
        r1 = r5;
    L19:
        r5 = r8;
    L20:
        return r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Xl(com.bytedance.android.live.liveinteract.plantform.datamerge.a r1) {
        this.y = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void Ye(View r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void a6(tf0.o.a r2) {
        Intrinsics.checkNotNullParameter(r2, "_callBack");
        this.v = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void b7(@SupportUpdatePlayMode int r2) {
        ALogger.e("ttlive_link", "BaseLinkSeatWindowView [avatar-fresh] call updateRecyclerViewWhenPlayModeStatusChanged, stack = " + Log.getStackTraceString(new Exception()));
        MultiTypeAdapter r3 = getBasicAdapter();
        if (r3 == null) goto L8;
        LinkMicRecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L9;
        r0.setAdapter(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.b
    public final void d2(MultiLinkNormalEmptyViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.d2(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public final void e4(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.e4(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void le(SurfaceView r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void pd(View r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
    }

    @Override // hg0.a
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g ph(int r3) {
        LinkMicRecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r4 = r0.findViewHolderForAdapterPosition(r3);
    L7:
        if ((r4 instanceof hg0.b) == true) goto L9;
        return null;
    L9:
        return ((hg0.b) r4).l().h();
    L5:
        r4 = null;
        goto L7
    }

    public void setAnimAdapter(MultiTypeAdapter r1) {
        this.o = r1;
    }

    public final void setAnimRecyclerView(LinkMicRecyclerView r1) {
        this.i = r1;
    }

    public void setBasicAdapter(MultiTypeAdapter r1) {
        this.n = r1;
    }

    public final void setCallBack(tf0.o.a r1) {
        this.v = r1;
    }

    public void setCurRvLayoutParams(ConstraintLayout.LayoutParams r1) {
        this.d = r1;
    }

    public final void setDynamicBgContainer(View r1) {
        this.l = r1;
    }

    public final void setDynamicClipBg(ClipImageView r1) {
        this.k = r1;
    }

    public final void setHasUploadGuest(boolean r1) {
        this.B = r1;
    }

    public final void setItemListener(vg0.a r1) {
        this.a = r1;
    }

    public final void setLayoutConfig(m r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.u = r2;
    }

    public final void setLinkSeatAbilityProvider(xg0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final void setLinkUserDataMergeCenter(com.bytedance.android.live.liveinteract.plantform.datamerge.d r1) {
        this.r = r1;
    }

    public final void setLynxViewContainer(ViewGroup r1) {
        this.h = r1;
    }

    public final void setMDataCenter(DataCenter r1) {
        this.s = r1;
    }

    public final void setMFeedType(int r1) {
        this.p = r1;
    }

    public final void setMRoom(IRoom r1) {
        this.t = r1;
    }

    public final void setMicSeatPositionListener(Function1<? super Rect, Unit> r1) {
        this.w = r1;
    }

    public void setMultiAdapterWrapper(fg0.a r1) {
        this.e = r1;
    }

    public void setRecyclerView(LinkMicRecyclerView r1) {
        this.c = r1;
    }

    public void setSingleSurfaceViewContainer(ConstraintLayout r1) {
        this.g = r1;
    }

    public final void setThemeBgView(ClipImageView r1) {
        this.j = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void setUIViewValid(boolean r1) {
        this.f = r1;
    }

    public final void setWindowListHelper(com.bytedance.android.live.liveinteract.plantform.datamerge.a r1) {
        this.y = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder.b
    public final void w0(boolean r2) {
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.w0(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public final void w1(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.w1(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.b
    public final void K3(MultiLinkNormalEmptyViewBinder.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        vg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.K3(r2, r3);
        return;
    }

    public final RecyclerView.LayoutManager R5(m r3, boolean r4) {
        if (r3.getUiLayout() == 24) goto L14;
        int r5 = c1.a;
        if (c1.a(Integer.valueOf(r3.m()), Integer.valueOf(r3.getUiLayout())) == false) goto L9;
        return new PCLandscapeLinkSeatRecyclerLayoutManager(r3);
    L9:
        if (r3.getUiLayout() != 30) goto L11;
        pn0.f r6 = r3.d;
        Intrinsics.checkNotNull(r6);
        RecyclerView.LayoutManager r0 = new MultiLinkAudioStageEnlargeRecyclerLayoutManager(r3, r6);
    L13:
        return r0;
    L11:
        pn0.f r7 = r3.d;
        Intrinsics.checkNotNull(r7);
        r0 = new MultiLinkRecyclerLayoutManagerV2(r3, r7);
        goto L13
    L14:
        return new CommonDynamicIslandLayoutManager(this.s, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final Pair<Integer, Integer> Yl(int r11, pn0.f r12) {
        m r0 = this.u;
        if (r0 == null) goto L5;
        if (r12 != null) goto L8;
        r12 = r0.d;
    L8:
        Object r3 = null;
        if (r12 == null) goto L23;
        List<pn0.f.c> r13 = r12.d;
        if (r13 == null) goto L23;
        Iterator<T> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L21;
        Object r4 = r14.next();
        if (((pn0.f.c) r4).a != r11) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L14;
    L22:
        pn0.f.c r6 = (pn0.f.c) r4;
    L24:
        m r15 = this.u;
        if (r15 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L27:
        List<m.d> r16 = r15.h();
        if (r16 == null) goto L30;
        int r17 = r16.size();
    L31:
        ConstraintLayout.LayoutParams r7 = getCurRvLayoutParams();
        int r8 = c1.a;
        m r9 = this.u;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L34:
        Integer r10 = Integer.valueOf(r9.m());
        m r18 = this.u;
        if (r18 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L38:
        if (c1.a(r10, Integer.valueOf(r18.getUiLayout())) == false) goto L62;
        if (r11 < r17) goto L62;
        if (r7 == null) goto L62;
        int r19 = n.a;
        m r20 = this.u;
        if (r20 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L44:
        o r21 = n.b(r20, ((ViewGroup.MarginLayoutParams) r7).width, ((ViewGroup.MarginLayoutParams) r7).height);
        m r22 = this.u;
        if (r22 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L47:
        List<m.e> r23 = r22.k();
        if (r23 == null) goto L62;
        Iterator<T> r24 = r23.iterator();
    L51:
        if (r24.hasNext() == false) goto L58;
        Object r25 = r24.next();
        if (((m.e) r25).c() != (r11 - r17)) goto L55;
        boolean r26 = true;
    L56:
        if (r26 == false) goto L51;
        r3 = r25;
        goto L58
    L55:
        r26 = false;
    L58:
        m.e r27 = (m.e) r3;
        if (r27 == null) goto L62;
        int r110 = r21.c;
        int r111 = r21.d;
        return new Pair(Integer.valueOf((int) (((double) r110) * r27.d())), Integer.valueOf((int) (((double) r111) * r27.b())));
    L62:
        if (r6 != null) goto L66;
        return new Pair(0, 0);
    L66:
        return new Pair(Integer.valueOf(r6.e), Integer.valueOf(r6.f));
    L30:
        r17 = 0;
        goto L31
    L18:
        r5 = false;
        goto L19
    L21:
        r4 = null;
    L23:
        r6 = null;
        goto L24
    L5:
        return new Pair(0, 0);
    }

    @Override // hg0.a
    public final View Za(int r3, int r4) {
        LinkMicRecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r5 = r0.findViewHolderForAdapterPosition(r3);
    L7:
        if ((r5 instanceof hg0.b) == true) goto L9;
        return null;
    L9:
        return ((hg0.b) r5).l().m(r4);
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final Pair<Integer, Integer> vn(int r11, pn0.f r12) {
        m r0 = this.u;
        if (r0 == null) goto L5;
        if (r12 != null) goto L8;
        r12 = r0.d;
    L8:
        Object r3 = null;
        if (r12 == null) goto L23;
        List<pn0.f.c> r13 = r12.d;
        if (r13 == null) goto L23;
        Iterator<T> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L21;
        Object r4 = r14.next();
        if (((pn0.f.c) r4).a != r11) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L14;
    L22:
        pn0.f.c r6 = (pn0.f.c) r4;
    L24:
        m r15 = this.u;
        if (r15 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L27:
        List<m.d> r16 = r15.h();
        if (r16 == null) goto L30;
        int r17 = r16.size();
    L31:
        ConstraintLayout.LayoutParams r7 = getCurRvLayoutParams();
        int r8 = c1.a;
        m r9 = this.u;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L34:
        Integer r10 = Integer.valueOf(r9.m());
        m r18 = this.u;
        if (r18 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L38:
        if (c1.a(r10, Integer.valueOf(r18.getUiLayout())) == false) goto L62;
        if (r11 < r17) goto L62;
        if (r7 == null) goto L62;
        int r19 = n.a;
        m r20 = this.u;
        if (r20 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L44:
        o r21 = n.b(r20, ((ViewGroup.MarginLayoutParams) r7).width, ((ViewGroup.MarginLayoutParams) r7).height);
        m r22 = this.u;
        if (r22 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L47:
        List<m.e> r23 = r22.k();
        if (r23 == null) goto L62;
        Iterator<T> r24 = r23.iterator();
    L51:
        if (r24.hasNext() == false) goto L58;
        Object r25 = r24.next();
        if (((m.e) r25).c() != (r11 - r17)) goto L55;
        boolean r26 = true;
    L56:
        if (r26 == false) goto L51;
        r3 = r25;
        goto L58
    L55:
        r26 = false;
    L58:
        m.e r27 = (m.e) r3;
        if (r27 == null) goto L62;
        int r110 = r21.c;
        int r111 = r21.d;
        int r1 = r21.a;
        int r2 = r21.b;
        return new Pair(Integer.valueOf((int) ((((double) r110) * r27.e()) + ((double) r1))), Integer.valueOf((int) ((((double) r111) * r27.f()) + ((double) r2))));
    L62:
        if (r6 != null) goto L66;
        return new Pair(0, 0);
    L66:
        return new Pair(Integer.valueOf(r6.c), Integer.valueOf(r6.d));
    L30:
        r17 = 0;
        goto L31
    L18:
        r5 = false;
        goto L19
    L21:
        r4 = null;
    L23:
        r6 = null;
        goto L24
    L5:
        return new Pair(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseLinkSeatWindowView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = "BaseLinkSeatWindowView";
        this.m = new xg0.b();
        if (((Boolean) vm2.d.g.getValue(null, vm2.d.a[5])).booleanValue() == false) goto L5;
        VerticalNitaInflate.a(getNitaTag(), getLayoutId(), r2, this, true);
    L6:
        setRecyclerView((LinkMicRecyclerView) findViewById(2131378009));
        this.h = (ViewGroup) findViewById(2131380433);
        this.i = (LinkMicRecyclerView) findViewById(2131378008);
        this.j = findViewById(2131388551);
        this.k = findViewById(2131370471);
        this.l = findViewById(2131370469);
        this.z = findViewById(2131372729);
        this.A = findViewById(2131372730);
        return;
    L5:
        ViewGroup.inflate(r2, getLayoutId(), this);
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Sp(m r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layoutConfig");
        LinkMicRecyclerView r4 = getRecyclerView();
        if (r4 == null) goto L5;
        r4.setLayoutManager(R5(r1, false));
    L5:
        LinkMicRecyclerView r5 = this.i;
        if (r5 == null) goto L9;
        r5.setLayoutManager(R5(r1, true));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void U3(m r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        this.u = r4;
        LinkMicRecyclerView r0 = getRecyclerView();
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof ug0.a) == true) goto L9;
        r2 = null;
    L9:
        ug0.a r3 = (ug0.a) r2;
        if (r3 == null) goto L13;
        r3.U3(r4, r5, r6);
    L13:
        if (aj0.b.c(r4.getUiLayout()) == false) goto L19;
        LinkMicRecyclerView r7 = getRecyclerView();
        if (r7 == null) goto L22;
        RecyclerView.Adapter r8 = r7.getAdapter();
        if (r8 == null) goto L22;
        r8.notifyDataSetChanged();
    L22:
        LinkMicRecyclerView r9 = this.i;
        if (r9 == null) goto L25;
        RecyclerView.LayoutManager r10 = r9.getLayoutManager();
    L27:
        if ((r10 instanceof ug0.a) == false) goto L30;
        r1 = r10;
    L30:
        ug0.a r11 = (ug0.a) r1;
        if (r11 == null) goto L33;
        r11.U3(r4, r5, r6);
    L33:
        LinkMicRecyclerView r12 = this.i;
        if (r12 == null) goto L36;
        r12.requestLayout();
    L36:
        ConstraintLayout.LayoutParams r13 = getCurRvLayoutParams();
        if (r13 == null) goto L42;
        pn0.f r14 = r4.d;
        if (r14 == null) goto L43;
        V5(r13, r4, r14);
        return;
    L43:
        return;
    L42:
        return;
    L25:
        r10 = null;
        goto L27
    L19:
        LinkMicRecyclerView r15 = getRecyclerView();
        if (r15 == null) goto L22;
        r15.requestLayout();
        goto L22
    L5:
        r2 = null;
        goto L7
    }

    public final void V5(ConstraintLayout.LayoutParams r21, m r22, pn0.f r23) {
        setCurRvLayoutParams(r21);
        boolean r4 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        r22.getUiLayout();
        int r5 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r5) == false) goto L30;
        sf0.c r8 = new sf0.c(((ViewGroup.MarginLayoutParams) r21).leftMargin, ((ViewGroup.MarginLayoutParams) r21).topMargin, ((ViewGroup.MarginLayoutParams) r21).width, ((ViewGroup.MarginLayoutParams) r21).height);
        ArrayList r10 = new ArrayList(r23.d.size());
        Iterator<T> r3 = r23.d.iterator();
        int r12 = 0;
    L6:
        if (r3.hasNext() == false) goto L11;
        Object r6 = r3.next();
        int r7 = r12 + 1;
        if (r12 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        pn0.f.c r9 = (pn0.f.c) r6;
        r10.add(new sf0.d(r12, r9.c, r9.d, r9.e, r9.f, null));
        r12 = r7;
        goto L6
    L11:
        int r11 = c1.a;
        if (c1.a(Integer.valueOf(r22.m()), Integer.valueOf(r22.getUiLayout())) == false) goto L19;
        int r13 = n.a;
        o r1 = n.b(r22, ((ViewGroup.MarginLayoutParams) r21).width, ((ViewGroup.MarginLayoutParams) r21).height);
        int r14 = r10.size();
        List<m.e> r15 = r22.k();
        if (r15 == null) goto L19;
        Iterator<T> r16 = r15.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        m.e r17 = (m.e) r16.next();
        int r18 = r1.c;
        int r19 = r1.d;
        double r110 = r18;
        double r20 = r19;
        int r111 = r14;
        r10.add(new sf0.d(r111, (int) ((r110 * r17.e()) + ((double) r1.a)), (int) ((r20 * r17.f()) + ((double) r1.b)), (int) (r17.d() * r110), (int) (r17.b() * r20), null));
        r14 = r14 + 1;
        r1 = r1;
    L19:
        List<Integer> r0 = r22.e;
        if (r0 != null) goto L22;
        r0 = CollectionsKt.emptyList();
    L22:
        sf0.b r112 = new sf0.b(Integer.valueOf(r22.getUiLayout()), r0, r8, null, r10);
        Lazy r2 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.s, this.b, "tryUpdateLayoutInfoToLynx ui_layout=" + r22.getUiLayout());
        DataCenter r24 = this.s;
        if (r24 == null) goto L31;
        r24.put("data_multi_link_dynamic_layout_info_change", new nh0.f("layout_info", null, null, r112, null, null, false, 238));
        return;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Yd(m r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "config");
        this.u = r19;
        pn0.f r4 = r19.d;
        Intrinsics.checkNotNull(r4);
        ViewGroup.LayoutParams r5 = getLayoutParams();
        r5.width = r20;
        r5.height = r21;
        int r6 = c1.a;
        ConstraintLayout r7 = null;
        int r8 = 0;
        if (c1.a(Integer.valueOf(r19.m()), Integer.valueOf(r19.getUiLayout())) == true) goto L5;
        pn0.f.b r3 = r4.c;
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(r3.c, r3.d);
        r2.topToTop = 0;
        r2.leftToLeft = 0;
        pn0.f.b r9 = r4.c;
        int r10 = r9.b;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = r10;
        int r11 = r9.a;
        ((ViewGroup.MarginLayoutParams) r2).leftMargin = r11;
        if (r11 >= 0) goto L113;
        ((ViewGroup.MarginLayoutParams) r2).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r2).width = r9.c + r11;
    L113:
        if (r10 >= 0) goto L115;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r2).height = r9.d + r10;
    L115:
        m r12 = this.u;
        if (r12 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L118:
        V5(r2, r12, r4);
        RecyclerView r13 = getRecyclerView();
        if (r13 == null) goto L121;
        r13.setLayoutParams(r2);
    L121:
        ALogger.i(this.b, "updateFirstVHShadowView, uiLayout: " + r19.getUiLayout());
        IInteractService r14 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r14 == null) goto L126;
        boolean r15 = true;
        if (r14.isXplayFullScreenMode() != true) goto L126;
    L127:
        if (r15 == false) goto L139;
        ALogger.i(this.b, "updateFirstVHShadowViewForFullScreenMode, uiLayout: " + r19.getUiLayout());
        ClipFrameLayout r1 = this.z;
        if (r1 == null) goto L131;
        ConstraintLayout r16 = UtilityKotlinExtentionsKt.p(r1);
    L133:
        if ((r16 instanceof ConstraintLayout) == false) goto L136;
        r7 = r16;
    L136:
        ConstraintLayout r17 = r7;
        if (r17 == null) goto L207;
        ConstraintSet r18 = new ConstraintSet();
        r18.clone(r17);
        r18.connect(2131372729, 3, 0, 3, 0);
        r18.connect(2131372729, 4, 0, 4, 0);
        r18.connect(2131372729, 6, 0, 6, 0);
        r18.connect(2131372729, 7, 0, 7, 0);
        r18.applyTo(r17);
        return;
    L207:
        return;
    L131:
        r16 = null;
        goto L133
    L139:
        int r22 = qi0.e.a;
        m r23 = this.u;
        if (r23 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L142:
        int r24 = qi0.e.a(r23.getUiLayout());
        boolean r25 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        int r26 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r26) == false) goto L205;
        DataCenter r27 = this.s;
        if (r27 == null) goto L147;
        nh0.f r28 = (nh0.f) r27.get("data_multi_link_dynamic_layout_info_change", new nh0.f("layout_info", null, null, null, null, null, false, 238));
    L148:
        if (r28 == null) goto L154;
        sf0.b r29 = r28.e;
        if (r29 == null) goto L154;
        List<sf0.d> r30 = r29.e;
        if (r30 == null) goto L154;
        sf0.d r31 = (sf0.d) CollectionsKt.getOrNull(r30, r24);
    L155:
        ClipFrameLayout r32 = this.z;
        if (r32 == null) goto L158;
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
    L160:
        if ((r33 instanceof ConstraintLayout.LayoutParams) == true) goto L162;
        r33 = null;
    L162:
        ConstraintLayout.LayoutParams r34 = (ConstraintLayout.LayoutParams) r33;
        if (r34 == null) goto L180;
        if (r31 == null) goto L166;
        int r35 = r31.b;
    L167:
        ((ViewGroup.MarginLayoutParams) r34).leftMargin = r35;
        if (r31 == null) goto L170;
        int r36 = r31.c;
    L171:
        ((ViewGroup.MarginLayoutParams) r34).topMargin = r36;
        if (r31 == null) goto L174;
        int r37 = r31.d;
    L175:
        ((ViewGroup.MarginLayoutParams) r34).width = r37;
        if (r31 == null) goto L178;
        int r38 = r31.e;
    L179:
        ((ViewGroup.MarginLayoutParams) r34).height = r38;
        getMFirstVHShadowViewChange();
        goto L180
    L178:
        r38 = 0;
        goto L179
    L174:
        r37 = 0;
        goto L175
    L170:
        r36 = 0;
        goto L171
    L166:
        r35 = 0;
    L180:
        ClipFrameLayout r39 = this.A;
        if (r39 == null) goto L183;
        ConstraintLayout r40 = r39.getLayoutParams();
    L185:
        if ((r40 instanceof ConstraintLayout.LayoutParams) == false) goto L188;
        r7 = r40;
    L188:
        ConstraintLayout.LayoutParams r41 = (ConstraintLayout.LayoutParams) r7;
        if (r41 == null) goto L209;
        if (r31 == null) goto L192;
        int r42 = r31.b;
    L193:
        ((ViewGroup.MarginLayoutParams) r41).leftMargin = r42;
        if (r31 == null) goto L196;
        int r43 = r31.c;
    L197:
        ((ViewGroup.MarginLayoutParams) r41).topMargin = r43;
        if (r31 == null) goto L200;
        int r44 = r31.d;
    L201:
        ((ViewGroup.MarginLayoutParams) r41).width = r44;
        if (r31 == null) goto L204;
        r8 = r31.e;
    L204:
        ((ViewGroup.MarginLayoutParams) r41).height = r8;
        getMFirstVHShadowViewChange();
        return;
    L200:
        r44 = 0;
        goto L201
    L196:
        r43 = 0;
        goto L197
    L192:
        r42 = 0;
        goto L193
    L209:
        return;
    L183:
        r40 = null;
        goto L185
    L158:
        r33 = null;
    L154:
        r31 = null;
        goto L155
    L147:
        r28 = null;
        goto L148
    L205:
        post(new com.bytedance.android.live.liveinteract.plantform.commonwindow.a(this, r24));
        return;
    L126:
        r15 = false;
        goto L127
    L5:
        if (((Boolean) vm2.d.g2.getValue(null, vm2.d.a[160(0xa0, float:2.24E-43)])).booleanValue() == false) goto L10;
        m r45 = this.u;
        if (r45 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L9:
        int r46 = r45.r(r21);
    L14:
        m r47 = this.u;
        if (r47 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L17:
        r47.o(r21);
        m r48 = this.u;
        if (r48 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L21:
        if (r48.f() != 0) goto L37;
        RecyclerView r110 = getRecyclerView();
        if (r110 == null) goto L25;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
    L27:
        if ((r111 instanceof ConstraintLayout.LayoutParams) == true) goto L29;
        r111 = null;
    L29:
        ViewGroup.MarginLayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
        if (r112 == null) goto L32;
        r112.topMargin = r46;
        r112.width = r20;
        r112.height = r21 - r46;
    L33:
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(r20, r21 - r46);
        ((ViewGroup.MarginLayoutParams) r113).topMargin = r46;
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = 0;
        RecyclerView r49 = getRecyclerView();
        if (r49 == null) goto L101;
        r49.setLayoutParams(r112);
    L101:
        if (r4 == null) goto L103;
        V5(r113, r48, r4);
    L103:
        LinkMicRecyclerView r50 = getRecyclerView();
        if (r50 == null) goto L106;
        r50.requestLayout();
    L106:
        m r51 = this.u;
        if (r51 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L109:
        Sp(r51, r20, r21);
        goto L121
    L32:
        r112 = null;
        goto L33
    L25:
        r111 = null;
        goto L27
    L37:
        if (r48.getUiLayout() != 13) goto L39;
        float r114 = 1.7777778f;
    L41:
        if (FoldScreenUtils.e() == false) goto L43;
    L59:
        m.a r115 = r48.c();
        if (r115 != null) goto L62;
    L82:
        int r116 = (int) (r20 / r114);
        RecyclerView r117 = getRecyclerView();
        if (r117 == null) goto L85;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
    L87:
        if ((r118 instanceof ConstraintLayout.LayoutParams) == true) goto L89;
        r118 = null;
    L89:
        ViewGroup.MarginLayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        if (r119 == null) goto L92;
        r119.topMargin = ((r21 - r116) / 2) + r46;
        r119.width = r20;
        r119.height = r116;
    L93:
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(r20, r116);
        ((ViewGroup.MarginLayoutParams) r120).topMargin = r46 + ((r21 - r116) / 2);
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = 0;
        RecyclerView r52 = getRecyclerView();
        if (r52 == null) goto L96;
        r52.setLayoutParams(r119);
    L96:
        r113 = r120;
        if (((ViewGroup.MarginLayoutParams) r113).width <= 0) goto L101;
        int r53 = ((s1.A() + s1.y()) - ((ViewGroup.MarginLayoutParams) r113).width) / 2;
        if (r53 <= 0) goto L101;
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = r53;
        goto L101
    L92:
        r119 = null;
        goto L93
    L85:
        r118 = null;
        goto L87
    L62:
        if (r115.e() != 2) goto L82;
        RecyclerView r121 = getRecyclerView();
        if (r121 == null) goto L66;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L68:
        if ((r122 instanceof ConstraintLayout.LayoutParams) == true) goto L70;
        r122 = null;
    L70:
        ViewGroup.MarginLayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
        if (r123 == null) goto L73;
        r123.topMargin = r46;
        r123.width = (int) (r21 * r114);
        r123.height = r21;
    L74:
        r120 = new ConstraintLayout.LayoutParams((int) (r21 * r114), r21);
        ((ViewGroup.MarginLayoutParams) r120).topMargin = r46;
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = 0;
        RecyclerView r54 = getRecyclerView();
        if (r54 == null) goto L78;
        r54.setLayoutParams(r123);
    L78:
        if (((ViewGroup.MarginLayoutParams) r120).width <= 0) goto L96;
        int r55 = ((s1.A() + s1.y()) - ((ViewGroup.MarginLayoutParams) r120).width) / 2;
        if (r55 <= 0) goto L96;
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = r55;
        goto L96
    L73:
        r123 = null;
        goto L74
    L66:
        r122 = null;
        goto L68
    L43:
        if (PadConfigUtils.c() == true) goto L59;
        RecyclerView r124 = getRecyclerView();
        if (r124 == null) goto L48;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
    L50:
        if ((r125 instanceof ConstraintLayout.LayoutParams) == true) goto L52;
        r125 = null;
    L52:
        ViewGroup.MarginLayoutParams r126 = (ConstraintLayout.LayoutParams) r125;
        if (r126 == null) goto L55;
        r126.topMargin = r46;
        r126.width = (int) (r21 * r114);
        r126.height = r21;
    L56:
        r120 = new ConstraintLayout.LayoutParams((int) (r21 * r114), r21);
        ((ViewGroup.MarginLayoutParams) r120).topMargin = r46;
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = 0;
        RecyclerView r56 = getRecyclerView();
        if (r56 == null) goto L96;
        r56.setLayoutParams(r126);
        goto L96
    L55:
        r126 = null;
        goto L56
    L48:
        r125 = null;
        goto L50
    L39:
        r114 = 1.3333334f;
        goto L41
    L10:
        m r57 = this.u;
        if (r57 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L13:
        r46 = r57.q(r21);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void zk(String r2, View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
    }

    public /* synthetic */ BaseLinkSeatWindowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public void hi(String r1, boolean r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Sm(IRoom r2, DataCenter r3, m r4, BaseEqualGridItemDecoration r5, vg0.a r6, SeatAnimEngineWrapper r7, int r8, int r9, int r10, se0.c r11, com.bytedance.android.live.liveinteract.plantform.datamerge.d r12) {
        Intrinsics.checkNotNullParameter(r4, "config");
        setUIViewValid(true);
        this.t = r2;
        this.s = r3;
        this.a = r6;
        this.u = r4;
        boolean r13 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L5:
        r4.getUiLayout();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r10) == true) goto L8;
        setRecyclerView((LinkMicRecyclerView) findViewById(2131378009));
        this.i = (LinkMicRecyclerView) findViewById(2131378008);
        setMultiAdapterWrapper(new fg0.a());
        this.h = (ViewGroup) findViewById(2131380433);
    L8:
        this.p = r10;
        this.q = r11;
        this.r = r12;
        xg0.b r14 = this.m;
        r14.getClass();
        Intrinsics.checkNotNullParameter(this, "abilityProvider");
        r14.a = this;
        r14.a("updateRealAbilityProvider");
        m r15 = this.u;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L11:
        r15.getUiLayout();
        int r16 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r16) == true) goto L66;
        m r17 = this.u;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L17:
        Yd(r17, r8, r9);
        LinkMicRecyclerView r18 = getRecyclerView();
        if (r18 == null) goto L20;
        r18.setAdapter(null);
    L20:
        setBasicAdapter(new MultiTypeAdapter(new ArrayList()));
        MultiTypeAdapter r19 = getBasicAdapter();
        if (r19 == null) goto L37;
        m r20 = this.u;
        if (r20 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L26:
        if (r20.getUiLayout() != 24) goto L28;
        r19.setHasStableIds(true);
    L29:
        U5(r19);
        LinkMicRecyclerView r21 = getRecyclerView();
        if (r21 == null) goto L32;
        r21.setAdapter(r19);
    L32:
        fg0.a r22 = getMultiAdapterWrapper();
        if (r22 == null) goto L37;
        Intrinsics.checkNotNullParameter(r19, "adapter");
        if (((ArrayList) r22.b).contains(r19) == true) goto L37;
        ((ArrayList) r22.b).add(r19);
        goto L37
    L28:
        r19.setHasStableIds(false);
    L37:
        LinkMicRecyclerView r23 = getRecyclerView();
        if (r23 == null) goto L40;
        r23.setItemAnimator(null);
    L40:
        LinkMicRecyclerView r24 = getRecyclerView();
        if (r24 == null) goto L43;
        int r25 = r24.getItemDecorationCount();
    L44:
        if (r25 <= 0) goto L48;
        LinkMicRecyclerView r26 = getRecyclerView();
        if (r26 == null) goto L48;
        r26.removeItemDecorationAt(0);
    L48:
        if (r5 == null) goto L52;
        LinkMicRecyclerView r27 = getRecyclerView();
        if (r27 == null) goto L52;
        r27.addItemDecoration(r5);
    L52:
        LinkMicRecyclerView r28 = getRecyclerView();
        if (r28 == null) goto L58;
        m r29 = this.u;
        if (r29 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L57:
        r28.setLayoutManager(R5(r29, false));
    L58:
        LinkMicRecyclerView r30 = getRecyclerView();
        if (r30 == null) goto L62;
        r30.setNoTouch(true);
    L62:
        if (((Boolean) vm2.d.f2.getValue(null, vm2.d.a[159(0x9f, float:2.23E-43)])).booleanValue() == false) goto L66;
        LinkMicRecyclerView r31 = getRecyclerView();
        if (r31 == null) goto L66;
        r31.setHasFixedSize(true);
        goto L66
    L43:
        r25 = 0;
    L66:
        LinkMicRecyclerView r32 = getRecyclerView();
        if (r32 == null) goto L69;
        ((ArrayList) r32.d).clear();
    L69:
        this.w = new BaseLinkSeatWindowView$addRvPositionListener$1(this);
        ALogger.i(this.b, "监听rv麦位变化，dataCenter=" + this.s);
        LinkMicRecyclerView r33 = getRecyclerView();
        if (r33 == null) goto L72;
        Function1<? super Rect, Unit> r34 = this.w;
        Intrinsics.checkNotNull(r34);
        int r35 = LinkMicRecyclerView.e;
        Intrinsics.checkNotNullParameter(r34, "listener");
        ((ArrayList) r33.d).add(r34);
        r34.invoke(r33.b);
    L72:
        m r36 = this.u;
        if (r36 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L75:
        r36.getUiLayout();
        int r37 = this.p;
        getRoom();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.i(r37) == false) goto L83;
        LinkMicRecyclerView r38 = getRecyclerView();
        if (r38 == null) goto L80;
        r38.setNoTouch(true);
    L80:
        LinkMicRecyclerView r39 = this.i;
        if (r39 == null) goto L110;
        r39.setNoTouch(true);
    L110:
        int r40 = t0.a;
        t0.a(this.b, "BaseLinkSeatWindowView#init");
        return;
    L83:
        setAnimAdapter(new MultiTypeAdapter(new ArrayList()));
        MultiTypeAdapter r41 = getAnimAdapter();
        if (r41 == null) goto L93;
        T5(r41, r7);
        LinkMicRecyclerView r42 = this.i;
        if (r42 == null) goto L88;
        r42.setAdapter(r41);
    L88:
        fg0.a r43 = getMultiAdapterWrapper();
        if (r43 == null) goto L93;
        Intrinsics.checkNotNullParameter(r41, "adapter");
        if (((ArrayList) r43.b).contains(r41) == true) goto L93;
        ((ArrayList) r43.b).add(r41);
    L93:
        LinkMicRecyclerView r44 = this.i;
        if (r44 == null) goto L96;
        r44.setItemAnimator(null);
    L96:
        LinkMicRecyclerView r45 = this.i;
        if (r45 == null) goto L102;
        m r46 = this.u;
        if (r46 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("layoutConfig");
    L101:
        r45.setLayoutManager(R5(r46, true));
    L102:
        LinkMicRecyclerView r47 = this.i;
        if (r47 == null) goto L106;
        r47.setNoTouch(true);
    L106:
        if (((Boolean) vm2.d.f2.getValue(null, vm2.d.a[159(0x9f, float:2.23E-43)])).booleanValue() == false) goto L110;
        LinkMicRecyclerView r48 = this.i;
        if (r48 == null) goto L110;
        r48.setHasFixedSize(true);
        goto L110
    }
}
