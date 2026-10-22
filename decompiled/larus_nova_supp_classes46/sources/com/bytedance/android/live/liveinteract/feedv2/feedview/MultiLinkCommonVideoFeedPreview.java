package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.CommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
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
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import zg1.v1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001oJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010N\u001a\u0004\u0018\u00010G8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010^\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010f\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010n\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006p"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVideoFeedPreview;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/liveinteract/feedv2/feedview/a;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/b;", "Lpn0/i;", "getLayoutConfigRequestExtra", "Lkotlin/Pair;", "", "getLivePlayerVideoSize", "", "", "getPlayModes", "", "getFeedViewName", "getMicSeatRvViewId", "Landroid/widget/FrameLayout$LayoutParams;", "getKtvComponentLayoutParams", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getLinkmicSeatListInfo", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", "b", "Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", "getConfigOuterProvider", "()Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", "setConfigOuterProvider", "(Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;)V", "configOuterProvider", "Lte0/a;", "c", "Lte0/a;", "getConfigInnerProvider", "()Lte0/a;", "setConfigInnerProvider", "(Lte0/a;)V", "configInnerProvider", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "e", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "getLayoutConfig", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "setLayoutConfig", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;)V", "layoutConfig", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;", "f", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;", "getWindowListHelper", "()Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;", "setWindowListHelper", "(Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;)V", "windowListHelper", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "g", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "getBaseWindowView", "()Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "setBaseWindowView", "(Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;)V", "baseWindowView", "h", "Landroid/widget/FrameLayout;", "getBaseWindowViewContainer", "()Landroid/widget/FrameLayout;", "setBaseWindowViewContainer", "(Landroid/widget/FrameLayout;)V", "baseWindowViewContainer", "Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "q", "Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "getMLastSeiAppData", "()Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "setMLastSeiAppData", "(Lcom/bytedance/android/livesdkapi/model/SeiAppData;)V", "mLastSeiAppData", "Landroidx/lifecycle/ViewModelStore;", "s", "Landroidx/lifecycle/ViewModelStore;", "getMViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setMViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "mViewModelStore", "Landroidx/lifecycle/ViewModelProvider;", "t", "Landroidx/lifecycle/ViewModelProvider;", "getViewModelProvider", "()Landroidx/lifecycle/ViewModelProvider;", "setViewModelProvider", "(Landroidx/lifecycle/ViewModelProvider;)V", "viewModelProvider", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "u", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getFeedDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setFeedDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "feedDataCenter", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "v", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "getDynamicWidget", "()Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "setDynamicWidget", "(Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;)V", "dynamicWidget", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkCommonVideoFeedPreview extends FrameLayout implements com.bytedance.android.live.liveinteract.feedv2.feedview.a, LifecycleOwnerCompat, ViewModelStoreOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b {
    public static final /* synthetic */ int H = 0;
    public ClientUIInfo A;
    public boolean B;
    public WidgetManager C;
    public Widget D;
    public int E;
    public int F;
    public final int G;
    public Map<Integer, View> a;
    public IPreviewMultiLinkOuterConfigProvider b;
    public te0.a c;
    public int d;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m e;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.a f;
    public BaseLinkSeatWindowView g;
    public FrameLayout h;
    public View i;
    public com.bytedance.android.live.liveinteract.videotalk.utils.h j;
    public com.bytedance.android.live.ui.q k;
    public com.bytedance.android.live.liveinteract.feed.d0 l;
    public final Map<String, Object> m;
    public final CompositeDisposable n;
    public int o;
    public final JSONObject p;
    public SeiAppData q;
    public com.bytedance.android.live.liveinteract.plantform.model.q r;
    public ViewModelStore s;
    public ViewModelProvider t;
    public DataCenter u;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.a v;
    public fd2.g w;
    public fd2.g x;
    public LifecycleRegistry y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.m b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public b(MultiLinkCommonVideoFeedPreview r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkCommonVideoFeedPreview r0 = this.a;     // Catch: Throwable -> L4
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.b;     // Catch: Throwable -> L4
            int r2 = this.c;     // Catch: Throwable -> L4
            int r3 = this.d;     // Catch: Throwable -> L4
            int r4 = MultiLinkCommonVideoFeedPreview.H;     // Catch: Throwable -> L4
            r0.z(r1, r2, r3);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.bytedance.android.live.liveinteract.plantform.commonwindow.k {
        public final /* synthetic */ Function1 a;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
        public final void onFailed() {
        }

        public c(Function1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2) {
            Intrinsics.checkNotNullParameter(r2, "layoutConfigV1");
            this.a.invoke(r2);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

        public d(MultiLinkCommonVideoFeedPreview r1) {
            this.a = r1;
        }

        public final void a() {
            DataCenter r0 = this.a.getFeedDataCenter();
            if (r0 != null) goto L5;
            return;
        L5:
            FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.a.getContext());
            if (r1 == null) goto L10;
            MultiLinkCommonVideoFeedPreview r2 = this.a;
            r2.C = WidgetManager.of(r1, r2);
            WidgetManager r3 = this.a.C;
            if (r3 == null) goto L10;
            r3.setDataCenter(r0);
        L10:
            MultiLinkCommonVideoFeedPreview r4 = this.a;
            if (r4.E() == true) goto L14;
            return;
        L14:
            if (r4.D != null) goto L51;
            IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
            Widget r6 = null;
            if (r5 == null) goto L19;
            MiddlewareRoomWidget r7 = r5.createMultiLinkBgManager();
        L20:
            WidgetManager r8 = r4.C;
            if (r8 == null) goto L23;
            r8.load(r7, false);
        L23:
            IPreviewMultiLinkOuterConfigProvider r9 = r4.b;
            if (r9 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L26:
            Map r10 = r9.getRoom().getLinkMap();
            int r11 = 16;
            if (r10.containsKey(String.valueOf(16)) == true) goto L33;
            r11 = 12;
            if (r10.containsKey(String.valueOf(12)) == true) goto L33;
            r11 = 8;
        L33:
            IInteractService r12 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r12 == null) goto L45;
            IPreviewMultiLinkOuterConfigProvider r13 = r4.b;
            if (r13 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L38:
            String r14 = r13.getEnterFromMerge();
            IPreviewMultiLinkOuterConfigProvider r15 = r4.b;
            if (r15 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L41:
            IRoom r16 = r15.getRoom();
            Integer r17 = Integer.valueOf(r11);
            Integer r18 = Integer.valueOf(r4.E);
            te0.a r19 = r4.c;
            if (r19 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
        L44:
            r6 = r12.createLiveThemeBgUIWidget(true, r14, r16, null, r17, r18, r19.g());
        L45:
            r4.D = r6;
            WidgetManager r20 = r4.C;
            if (r20 == null) goto L49;
            r20.load(2131388549, r6, false);
            return;
        L49:
            return;
        L19:
            r7 = null;
            goto L20
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

    public static final class e implements Runnable {
        public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

        public e(MultiLinkCommonVideoFeedPreview r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkCommonVideoFeedPreview r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MultiLinkCommonVideoFeedPreview.H;     // Catch: Throwable -> L4
            r0.g();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVideoFeedPreview$f", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f extends TypeToken<ClientUIInfo> {
        public f() {
        }
    }

    public static final class g implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

        public g(MultiLinkCommonVideoFeedPreview r1) {
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
            this.a.L(r3.a);
        }
    }

    static {
    }

    public /* synthetic */ MultiLinkCommonVideoFeedPreview() {
        throw null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void f(qb r1) {
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public String getFeedViewName() {
        return "CommonVideoFeedPreview";
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

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void j(cj r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean k() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderPause() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void removeEffectView() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public void s() {
    }

    private final pn0.i getLayoutConfigRequestExtra() {
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        r1.getShowFrom();
        return new pn0.i(false);
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
        com.bytedance.android.live.liveinteract.plantform.model.q r0 = this.r;
        if (r0 == null) goto L6;
        List<Long> r1 = r0.getPlayModes();
        if (r1 == null) goto L6;
    L16:
        if (r1 == null) goto L18;
        return r1;
    L18:
        return CollectionsKt.emptyList();
    L6:
        IPreviewMultiLinkOuterConfigProvider r2 = this.b;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L9:
        if (r2 == null) goto L15;
        IRoom r3 = r2.getRoom();
        if (r3 == null) goto L15;
        z5 r4 = r3.getLinkerDetail();
        if (r4 == null) goto L15;
        r1 = r4.getPlayModes();
    L15:
        r1 = null;
        goto L16
    }

    public boolean E() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.e;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.getUiLayout() != 7) goto L10;
        return false;
    L10:
        return true;
    }

    public final void H() {
        if (this.y != null) goto L6;
        this.y = new LifecycleRegistry(this);
    L6:
        if (this.s != null) goto L9;
        this.s = new ViewModelStore();
    L9:
        if (this.t != null) goto L12;
        this.t = new ViewModelProvider(this);
    L12:
        if (this.u != null) goto L27;
        this.u = DataCenter.create(this.t, this);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        if (vm2.h.W().feedLogRoom() == false) goto L28;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L18:
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L29;
        DataCenter r3 = this.u;
        if (r3 == null) goto L23;
        r3.put("data_room", r2);
    L23:
        DataCenter r4 = this.u;
        if (r4 == null) goto L30;
        r4.put("data_is_feed", Boolean.TRUE);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final Integer a() {
        int r0 = this.E;
        int r1 = this.F;
        if (r0 > 0) goto L7;
        ln0.a r2 = yg0.h.a;
        r0 = yg0.h.e(r1);
    L7:
        return Integer.valueOf(r0);
    }

    public final void g() {
        te0.a r1 = this.c;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L6:
        if (r1.shouldUseNewLivePlayerLayout() == false) goto L8;
        return;
    L8:
        IPreviewMultiLinkOuterConfigProvider r2 = this.b;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        IRenderView r4 = null;
        if (com.bytedance.android.live.liveinteract.utils.h.e(r2.getShowFrom()) == false) goto L38;
        IPreviewMultiLinkOuterConfigProvider r3 = this.b;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L16:
        IPreviewPlayerContainerAbility r5 = r3.getPlayerContainerAbility();
        IPreviewMultiLinkOuterConfigProvider r6 = this.b;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L19:
        Context r7 = r6.getContext();
        IPreviewMultiLinkOuterConfigProvider r8 = this.b;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        com.bytedance.android.live.liveinteract.utils.h.a(r5, r7, r8.getRoom());
        IPreviewMultiLinkOuterConfigProvider r9 = this.b;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L25:
        LivePlayerView r10 = r9.getLivePlayerView();
        if (r10 == null) goto L28;
        r4 = r10.getRenderView();
    L28:
        IRenderView r11 = r4;
        te0.a r12 = this.c;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L31:
        IInteractPlayView r13 = r12.n();
        int r14 = this.F;
        int r15 = this.E;
        JSONObject r16 = this.p;
        int r17 = this.d;
        IPreviewMultiLinkOuterConfigProvider r18 = this.b;
        if (r18 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L34:
        Context r19 = r18.getContext();
        IPreviewMultiLinkOuterConfigProvider r20 = this.b;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L37:
        com.bytedance.android.live.liveinteract.utils.h.i(r11, r13, r14, r15, r16, r17, r19, r20.getRoom(), this.m);
        return;
    L38:
        IPreviewMultiLinkOuterConfigProvider r21 = this.b;
        if (r21 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L41:
        com.bytedance.android.live.liveinteract.utils.h.b(r21.getPlayerContainerAbility());
        te0.a r22 = this.c;
        if (r22 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L44:
        int r23 = r22.getContainerWidth();
        te0.a r24 = this.c;
        if (r24 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L47:
        int r25 = r24.l();
        int r26 = this.d;
        int r27 = this.F;
        int r28 = this.E;
        IPreviewMultiLinkOuterConfigProvider r29 = this.b;
        if (r29 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L50:
        Context r110 = r29.getContext();
        IPreviewMultiLinkOuterConfigProvider r30 = this.b;
        if (r30 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L53:
        LivePlayerView r31 = r30.getLivePlayerView();
        if (r31 == null) goto L56;
        r4 = r31.getRenderView();
    L56:
        IRenderView r111 = r4;
        te0.a r32 = this.c;
        if (r32 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L59:
        IInteractPlayView r112 = r32.n();
        IPreviewMultiLinkOuterConfigProvider r33 = this.b;
        if (r33 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L62:
        com.bytedance.android.live.liveinteract.utils.h.j(r23, r25, r26, r27, r28, r110, r111, r112, r33.getRoom(), this.p, this.m, this.A);
    }

    public final te0.a getConfigInnerProvider() {
        te0.a r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L5:
        return r0;
    }

    public final IPreviewMultiLinkOuterConfigProvider getConfigOuterProvider() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public FrameLayout.LayoutParams getKtvComponentLayoutParams() {
        int r0 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        View r2 = null;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r1.getShowFrom()) == false) goto L15;
        te0.a r3 = this.c;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L10:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r4 = r3.c();
        if (r4 == null) goto L23;
        BehaviorSubject<List<ch0.e>> r5 = r4.b;
        if (r5 == null) goto L23;
        List r6 = (List) r5.getValue();
    L24:
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, -2);
        if (this.a != null) goto L27;
        this.a = new LinkedHashMap();
    L27:
        View r8 = (View) ((LinkedHashMap) this.a).get(2131384822);
        if (r8 != null) goto L32;
        r8 = findViewById(2131384822);
        if (r8 == null) goto L33;
        this.a.put(2131384822, r8);
    L33:
        int r9 = ((ConstraintLayout) r2).getMeasuredHeight();
        int r10 = this.F;
        int r11 = 0;
        if (r10 != 10) goto L36;
    L73:
        BaseLinkSeatWindowView r12 = this.g;
        if (r12 == null) goto L82;
        ug0.a r13 = r12.getRvLayoutManager();
        if (r13 == null) goto L82;
        Pair<Integer, Integer> r14 = r13.a(1);
        if (r14 == null) goto L82;
        Integer r15 = (Integer) r14.getFirst();
        if (r15 == null) goto L82;
        int r16 = r15.intValue();
    L90:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r17 = this.e;
        if (r17 == null) goto L93;
        r11 = r17.p(r9);
    L93:
        r7.rightMargin = (r16 + r11) + s1.f(4.0f);
    L94:
        return r7;
    L82:
        BaseLinkSeatWindowView r18 = this.g;
        if (r18 == null) goto L89;
        Pair r19 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r18);
        if (r19 == null) goto L89;
        Integer r20 = (Integer) r19.getFirst();
        if (r20 == null) goto L89;
        r16 = r20.intValue();
    L89:
        r16 = 0;
        goto L90
    L36:
        if (r10 == 15) goto L39;
        switch(r10) {
            case 25: goto L39;
            case 26: goto L39;
            case 27: goto L39;
            case 28: goto L73;
            default: goto L38;
        };
    L38:
        com.bytedance.android.live.liveinteract.utils.h.c(r10, 2131384921);
    L39:
        BaseLinkSeatWindowView r21 = this.g;
        if (r21 == null) goto L48;
        ug0.a r22 = r21.getRvLayoutManager();
        if (r22 == null) goto L48;
        Pair<Integer, Integer> r23 = r22.a(1);
        if (r23 == null) goto L48;
        Integer r24 = (Integer) r23.getFirst();
        if (r24 == null) goto L48;
        int r25 = r24.intValue();
    L56:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r26 = this.e;
        if (r26 == null) goto L59;
        int r27 = r26.p(r9);
    L60:
        int r28 = (r25 + r27) + s1.f(4.0f);
        int r29 = this.F;
        if (r29 != 25) goto L63;
    L66:
        int r30 = 9;
    L67:
        if (r6 == null) goto L69;
        int r31 = r6.size();
    L70:
        if (r31 < r30) goto L72;
        r11 = r28;
    L72:
        r7.rightMargin = r11;
        goto L94
    L69:
        r31 = 0;
        goto L70
    L63:
        if (r29 == 27) goto L66;
        r30 = 7;
        goto L67
    L59:
        r27 = 0;
    L48:
        BaseLinkSeatWindowView r32 = this.g;
        if (r32 == null) goto L55;
        Pair r33 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r32);
        if (r33 == null) goto L55;
        Integer r34 = (Integer) r33.getFirst();
        if (r34 == null) goto L55;
        r25 = r34.intValue();
    L55:
        r25 = 0;
    L32:
        r2 = r8;
    L23:
        r6 = null;
        goto L24
    L15:
        te0.a r35 = this.c;
        if (r35 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L18:
        ue0.c r36 = r35.f();
        if (r36 == null) goto L23;
        BehaviorSubject<List<ch0.e>> r37 = r36.b;
        if (r37 == null) goto L23;
        r6 = (List) r37.getValue();
        goto L24
    }

    public Lifecycle getLifecycleCompat() {
        LifecycleRegistry r0 = this.y;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LifecycleRegistry(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicAreaFrameInfo() {
        BaseLinkSeatWindowView r0 = this.g;
        if (r0 == null) goto L17;
        LinkMicRecyclerView r1 = r0.getRecyclerView();
        if (r1 == null) goto L19;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        sf0.b r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.d(r1);
        sf0.c r4 = r3.c;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = this.e;
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
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.e;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.j();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onLivePlayerVideoSizeChanged() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.e;
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
        Triple<Integer, Integer, Float> r6 = w(r1, r2, r4, r5.l());
        u(r0, ((Number) r6.component1()).intValue(), ((Number) r6.component2()).intValue(), ((Number) r6.component3()).floatValue());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderSelected() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "CommonVideoFeedPreview", hashCode(), "call onViewHolderSelected", false, 8, null);
        g();
        if (vm2.d.Q0() == false) goto L30;
        H();
        BaseLinkSeatWindowView r1 = this.g;
        if (r1 == null) goto L14;
        DataCenter r2 = this.u;
        if (r2 == null) goto L14;
        r1.s = r2;
    L14:
        if (((Boolean) vm2.h.w6.getValue(null, vm2.h.a[385(0x181, float:5.4E-43)])).booleanValue() == true) goto L24;
        A();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = this.e;
        if (r3 == null) goto L18;
        G(null, r3);
    L18:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r4 = this.v;
        if (r4 == null) goto L21;
        r4.onViewHolderSelected();
    L21:
        LifecycleRegistry r5 = this.y;
        if (r5 == null) goto L24;
        r5.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    L24:
        fd2.g r6 = this.w;
        if (r6 == null) goto L27;
        r6.onSelect();
    L27:
        fd2.g r7 = this.x;
        if (r7 == null) goto L30;
        r7.onSelect();
    L30:
        IInteractService.playModeParams.postValue(new LinkedHashMap());
        getPlayModes().contains(Long.valueOf(7));
        this.z = true;
        if (MultiLinkLoadWidgetUtils.j() == false) goto L36;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r8 = this.v;
        if (r8 == null) goto L37;
        r8.bh(false);
        return;
    L37:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderUnSelected() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "CommonVideoFeedPreview", hashCode(), "call onViewHolderUnSelected", false, 8, null);
        if (vm2.d.Q0() == false) goto L31;
        fd2.g r1 = this.w;
        if (r1 == null) goto L10;
        r1.b();
    L10:
        fd2.g r2 = this.x;
        if (r2 == null) goto L14;
        r2.b();
    L14:
        if (vm2.h.T() == true) goto L31;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r3 = this.v;
        if (r3 == null) goto L18;
        r3.onDestroy();
    L18:
        ViewModelStore r4 = this.s;
        if (r4 == null) goto L21;
        r4.clear();
    L21:
        this.s = null;
        LifecycleRegistry r5 = this.y;
        if (r5 == null) goto L30;
        Lifecycle.State r6 = r5.getCurrentState();
        if (r6 == null) goto L30;
        if (r6.isAtLeast(Lifecycle.State.CREATED) != true) goto L30;
        LifecycleRegistry r7 = this.y;
        if (r7 == null) goto L30;
        r7.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L30:
        this.y = null;
        this.t = null;
        this.u = null;
    L31:
        this.z = false;
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
    public void release() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        r0.printALogger("CommonVideoFeedPreview", hashCode(), "call release", true);
        this.n.clear();
        te0.a r1 = this.c;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L9:
        if (r1.shouldUseNewLivePlayerLayout() == true) goto L38;
        IPreviewMultiLinkOuterConfigProvider r2 = this.b;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        IPreviewPlayerContainerAbility r3 = r2.getPlayerContainerAbility();
        if (r3 == null) goto L17;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L19:
        if ((r4 instanceof FrameLayout.LayoutParams) == true) goto L21;
        ViewGroup.LayoutParams r5 = null;
    L22:
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5;
        if (r6 == null) goto L26;
        r6.topMargin = 0;
    L26:
        if ((r4 instanceof ConstraintLayout.LayoutParams) == true) goto L28;
        ViewGroup.LayoutParams r7 = null;
    L29:
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r7;
        if (r8 == null) goto L33;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = 0;
    L33:
        if ((r4 instanceof RelativeLayout.LayoutParams) == true) goto L35;
        r4 = null;
    L35:
        RelativeLayout.LayoutParams r9 = (RelativeLayout.LayoutParams) r4;
        if (r9 == null) goto L38;
        r9.topMargin = 0;
        goto L38
    L28:
        r7 = r4;
        goto L29
    L21:
        r5 = r4;
        goto L22
    L17:
        r4 = null;
    L38:
        ((LinkedHashMap) this.m).clear();
        this.l = null;
        te0.a r10 = this.c;
        if (r10 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L42:
        if (r10.shouldUseNewLivePlayerLayout() == false) goto L45;
        IInteractService.playModeParams.postValue(this.m);
    L45:
        if (this.z == false) goto L48;
        onViewHolderUnSelected();
    L48:
        if (vm2.h.T() == false) goto L65;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r11 = this.v;
        if (r11 == null) goto L52;
        r11.onDestroy();
    L52:
        this.v = null;
        ViewModelStore r12 = this.s;
        if (r12 == null) goto L55;
        r12.clear();
    L55:
        this.s = null;
        LifecycleRegistry r13 = this.y;
        if (r13 == null) goto L64;
        Lifecycle.State r14 = r13.getCurrentState();
        if (r14 == null) goto L64;
        if (r14.isAtLeast(Lifecycle.State.CREATED) != true) goto L64;
        LifecycleRegistry r15 = this.y;
        if (r15 == null) goto L64;
        r15.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L64:
        this.y = null;
        this.t = null;
        this.u = null;
    L65:
        fd2.g r16 = this.w;
        if (r16 == null) goto L68;
        r16.unload();
    L68:
        fd2.g r17 = this.x;
        if (r17 == null) goto L71;
        r17.unload();
    L71:
        Widget r18 = this.D;
        WidgetManager r19 = this.C;
        if (r18 == null) goto L76;
        if (r19 == null) goto L77;
        r19.unload(r18);
        this.D = null;
        return;
    L77:
        return;
    }

    public final void t() {
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L13;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r1.getShowFrom()) == false) goto L13;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L13;
        boolean r7 = false;
    L14:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = this.e;
        if (r2 == null) goto L31;
        int r3 = r2.m();
        int r4 = r2.getUiLayout();
        te0.a r5 = this.c;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L19:
        int r6 = r5.getContainerWidth();
        te0.a r8 = this.c;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L22:
        Triple<Integer, Integer, Float> r9 = w(r3, r4, r6, r8.l());
        int r10 = ((Number) r9.component1()).intValue();
        int r11 = ((Number) r9.component2()).intValue();
        int r12 = r2.getUiLayout();
        int r13 = y(this.E);
        pn0.i r14 = getLayoutConfigRequestExtra();
        Triple r15 = new Triple(Integer.valueOf(r10), Integer.valueOf(r11), "");
        ClientUIInfo r16 = this.A;
        if (r16 == null) goto L25;
        List r17 = r16.getUiFeatureList();
    L26:
        IPreviewMultiLinkOuterConfigProvider r18 = this.b;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L29:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.h r19 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r12, 0, null, r7, r13, false, r14, r15, r17, Long.valueOf(r18.getRoom().getRoomId()), this.u, 38);
        ln0.a r20 = yg0.h.a;
        yg0.h.k(r19, new com.bytedance.android.live.liveinteract.feedv2.feedview.c(this), null);
        return;
    L25:
        r17 = null;
        goto L26
    L31:
        return;
    L13:
        r7 = true;
        goto L14
    }

    public final ViewModelStore tf() {
        ViewModelStore r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ViewModelStore();
    }

    public final void A() {
        if (vm2.h.T() == true) goto L5;
    L6:
        Context r4 = getContext();
        DataCenter r5 = this.u;
        Intrinsics.checkNotNull(r5);
        int r8 = this.d;
        te0.a r2 = this.c;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L9:
        ue0.c r9 = r2.f();
        te0.a r3 = this.c;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L12:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r10 = r3.c();
        te0.a r6 = this.c;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L15:
        eh0.b r11 = r6.p5();
        te0.a r7 = this.c;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L18:
        eh0.b r12 = r7.Y3();
        IPreviewMultiLinkOuterConfigProvider r13 = this.b;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L21:
        MultiLinkFeedDynamicWidgetNew r0 = new MultiLinkFeedDynamicWidgetNew(this, r4, r5, this, null, r8, r9, r10, r11, r12, r13.getEnterFromMerge());
        this.v = r0;
        te0.a r14 = this.c;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L24:
        r0.b(r14.g());
        if (MultiLinkLoadWidgetUtils.j() == false) goto L29;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.v;
        if (r1 == null) goto L29;
        r1.bh(true);
    L29:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r15 = this.v;
        if (r15 == null) goto L32;
        r15.fd(this.f);
    L32:
        IPreviewMultiLinkOuterConfigProvider r16 = this.b;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L35:
        IRoom r17 = r16.getRoom();
        if (r17 == null) goto L49;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r18 = this.v;
        if (r18 == null) goto L40;
        r18.updateRoom(r17);
    L40:
        IVoiceLiveTheme r19 = r17.getVoiceLiveTheme();
        if (r19 == null) goto L44;
        JsonObject r20 = GsonProtectorUtils.toJsonTree(GsonHelper.get(), r19).getAsJsonObject();
        if (r20 == null) goto L44;
    L45:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r21 = this.v;
        if (r21 == null) goto L50;
        r21.Dk("seat", "bg_theme", r20, false);
        return;
    L50:
        return;
    L44:
        r20 = new JsonObject();
        goto L45
    L49:
        return;
    L5:
        if (this.v != null) goto L29;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void l() {
        t();
        g();
        te0.a r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L6:
        if (r0.shouldUseNewLivePlayerLayout() == false) goto L9;
        IInteractService.playModeParams.postValue(this.m);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderResume() {
        if (vm2.d.Q0() == false) goto L22;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.v;
        if (r0 == null) goto L7;
        r0.Kk();
    L7:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.v;
        if (r1 == null) goto L10;
        r1.initDataContext();
    L10:
        IPreviewMultiLinkOuterConfigProvider r2 = this.b;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r2.getShowFrom()) == false) goto L23;
        g();
        te0.a r3 = this.c;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L19:
        if (r3.shouldUseNewLivePlayerLayout() == false) goto L24;
        IInteractService.playModeParams.postValue(this.m);
        return;
    L24:
        return;
    L23:
        return;
    }

    public final BaseLinkSeatWindowView getBaseWindowView() {
        return this.g;
    }

    public final FrameLayout getBaseWindowViewContainer() {
        return this.h;
    }

    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.a getDynamicWidget() {
        return this.v;
    }

    public final DataCenter getFeedDataCenter() {
        return this.u;
    }

    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.m getLayoutConfig() {
        return this.e;
    }

    public final SeiAppData getMLastSeiAppData() {
        return this.q;
    }

    public final ViewModelStore getMViewModelStore() {
        return this.s;
    }

    public final ViewModelProvider getViewModelProvider() {
        return this.t;
    }

    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a getWindowListHelper() {
        return this.f;
    }

    public void C(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r10) {
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
        te0.a r4 = this.c;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L12:
        ue0.c r7 = r4.f();
        if (r7 == null) goto L21;
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        IRoom r8 = r5.getRoom();
        DataCenter r9 = this.u;
        IPreviewMultiLinkOuterConfigProvider r11 = this.b;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L20:
        this.f = new com.bytedance.android.live.liveinteract.feed.datamerge.i(r8, r9, r10, r6, r7, r11.getShowFrom());
    L21:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r12 = this.f;
        if ((r12 instanceof com.bytedance.android.live.liveinteract.feed.datamerge.i) == true) goto L24;
        r12 = null;
    L24:
        com.bytedance.android.live.liveinteract.feed.datamerge.i r13 = (com.bytedance.android.live.liveinteract.feed.datamerge.i) r12;
        if (r13 == null) goto L30;
        IPreviewMultiLinkOuterConfigProvider r14 = this.b;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L29:
        r13.x(r14.getRoom());
    L30:
        BaseLinkSeatWindowView r15 = this.g;
        if (r15 == null) goto L33;
        r15.y = this.f;
    L33:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r16 = this.v;
        if (r16 == null) goto L37;
        r16.fd(this.f);
        return;
    L37:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void D(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11) {
        Intrinsics.checkNotNullParameter(r11, "layoutConfig");
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r0 = r11.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r3 = r11.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r7 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r2 + r1);
        te0.a r4 = this.c;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L12:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r8 = r4.c();
        if (r8 == null) goto L21;
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        IRoom r6 = r5.getRoom();
        DataCenter r9 = this.u;
        IPreviewMultiLinkOuterConfigProvider r10 = this.b;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L20:
        this.f = new WindowListHelperV2(r6, r9, false, r11, r7, r8, r10.getShowFrom());
    L21:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r12 = this.f;
        if (r12 == null) goto L24;
        r12.b();
    L24:
        BaseLinkSeatWindowView r13 = this.g;
        if (r13 == null) goto L27;
        r13.y = this.f;
    L27:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r14 = this.v;
        if (r14 == null) goto L31;
        r14.fd(this.f);
        return;
    L31:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void F(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8) {
        Intrinsics.checkNotNullParameter(r8, "tempLayoutConfig");
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        int r2 = hashCode();
        StringBuilder r3 = new StringBuilder("call realInt, uiLayout = ");
        r3.append(this.E);
        r3.append(", layoutConfig#uiLayout = ");
        r3.append(r8.getUiLayout());
        r3.append(", seiStyle = ");
        te0.a r4 = this.c;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L8:
        r3.append(r4.a());
        boolean r6 = true;
        r0.printALogger("CommonVideoFeedPreview", r2, r3.toString(), true);
        te0.a r1 = this.c;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L12:
        if (r1.a() == 0) goto L14;
    L16:
        te0.a r5 = this.c;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L19:
        int r7 = r5.a();
    L20:
        this.o = r7;
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L31;
        IPreviewMultiLinkOuterConfigProvider r9 = this.b;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L26:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r9.getShowFrom()) == false) goto L31;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L31;
        r6 = false;
    L31:
        x(this.E, r6, r8, new MultiLinkCommonVideoFeedPreview$realInit$1(this));
        return;
    L14:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L16;
        r7 = y(this.E);
        goto L20
    }

    public final void J(ClientUIInfo r6) {
        if (((Boolean) h30.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (r6 == null) goto L10;
        List r1 = r6.getUiFeatureList();
        if (r1 == null) goto L10;
        List r2 = CollectionsKt.sorted(r1);
    L11:
        ClientUIInfo r3 = this.A;
        if (r3 == null) goto L16;
        List r4 = r3.getUiFeatureList();
        if (r4 == null) goto L16;
        List r5 = CollectionsKt.sorted(r4);
    L18:
        if ((!Intrinsics.areEqual(r2, r5)) == false) goto L24;
        this.A = r6;
        this.B = false;
        m(this.F, this.E, null);
        t();
        xs2.b r0 = xs2.b.a();
        IPreviewMultiLinkOuterConfigProvider r7 = this.b;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        r0.post(new v1(r7.getRoom().getId(), this.E, r6));
        return;
    L24:
        return;
    L16:
        r5 = null;
    L10:
        r2 = null;
        goto L11
    }

    public final void K(List<? extends tf0.e> r5) {
        if (E() == true) goto L5;
        return;
    L5:
        boolean r0 = MultiLinkLoadWidgetUtils.g();
        DataCenter r1 = this.u;
        if (r0 == false) goto L12;
        if (r1 == null) goto L12;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r1);
        if (r2 == null) goto L53;
        r2.Xe(r5);
        return;
    L53:
        return;
    L12:
        Path r3 = new Path();
        Iterator<T> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L34;
        tf0.e r4 = (tf0.e) r6.next();
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == true) goto L18;
        r4 = null;
    L18:
        MultiLinkGuestViewBinder.a r7 = (MultiLinkGuestViewBinder.a) r4;
        if (r7 == null) goto L14;
        ILinkPlayerInfoBridge r8 = r7.k.a;
        if (r8.getUser() == null) goto L14;
        if (je0.d.x(Integer.valueOf(r8.getLinkType())) == false) goto L14;
        BaseLinkSeatWindowView r9 = this.g;
        if (r9 == null) goto L27;
        int r10 = r9.S0(r8.getInteractId());
    L28:
        com.bytedance.android.live.liveinteract.videotalk.utils.h r11 = this.j;
        if (r11 == null) goto L31;
        Path r12 = r11.a(r10, 0.0f, 0.0f);
    L32:
        r3.addPath(r12);
        goto L14
    L31:
        r12 = new Path();
        goto L32
    L27:
        r10 = -1;
        goto L28
    L34:
        if (this.E != 16) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.utils.h r13 = this.j;
        if (r13 == null) goto L38;
        Path r14 = r13.a(qi0.e.a(16), 0.0f, 0.0f);
    L39:
        r3.addPath(r14);
        goto L40
    L38:
        r14 = new Path();
    L40:
        com.bytedance.android.live.liveinteract.feed.d0 r15 = this.l;
        if (r15 == null) goto L55;
        r15.o(r3);
        return;
    }

    public final void L(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r7) {
        Intrinsics.checkNotNullParameter(r7, "newLayoutConfig");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.e;
        int r1 = r7.m();
        int r2 = r7.getUiLayout();
        te0.a r3 = this.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L5:
        int r4 = r3.getContainerWidth();
        te0.a r5 = this.c;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L8:
        Triple<Integer, Integer, Float> r6 = w(r1, r2, r4, r5.l());
        int r8 = ((Number) r6.component1()).intValue();
        int r9 = ((Number) r6.component2()).intValue();
        BaseLinkSeatWindowView r10 = this.g;
        if (r10 == null) goto L11;
        r10.U3(r7, r8, r9);
    L11:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r11 = r7.h();
        int r12 = 0;
        if (r11 == null) goto L14;
        int r13 = r11.size();
    L15:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r14 = r7.k();
        if (r14 == null) goto L18;
        r12 = r14.size();
    L18:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r15 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r13 + r12);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r16 = this.f;
        if (r16 == null) goto L21;
        r16.w(r15, r7);
    L21:
        this.j = v(r7, r8, r9);
        if (r0 != null) goto L24;
    L28:
        G(r0, r7);
    L29:
        boolean r17 = MultiLinkLoadWidgetUtils.g();
        DataCenter r18 = this.u;
        if (r17 == false) goto L36;
        if (r18 == null) goto L37;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r19 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r18);
        if (r19 == null) goto L38;
        r19.Hp(r7, r8, r9);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L24:
        if (r0.j() != r7.j()) goto L28;
        if (r0.getUiLayout() != r7.getUiLayout()) goto L28;
    L14:
        r13 = 0;
        goto L15
    }

    public final void M(final int r5) {
        if (this.o != r5) goto L5;
        return;
    L5:
        if (r5 >= 0) goto L7;
        return;
    L7:
        if (r5 > 9) goto L29;
        this.o = r5;
        boolean r1 = true;
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L20;
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L15:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r0.getShowFrom()) == false) goto L20;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L20;
        r1 = false;
    L20:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = this.e;
        if (r2 != null) goto L23;
        return;
    L23:
        if (r2.getUiLayout() != 2) goto L28;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = this.e;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getUiLayout();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6 = this.e;
        Intrinsics.checkNotNull(r6);
        x(r4, r1, r6, new MultiLinkCommonVideoFeedPreview$updateLayoutConfigForDynamicEqual$1(this, r5));
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "seiString");
        fd2.g r0 = this.x;
        if ((r0 instanceof fd2.u) == true) goto L5;
        r0 = null;
    L5:
        fd2.u r1 = (fd2.u) r0;
        if (r1 == null) goto L9;
        r1.onSei(r4, null);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public void h(SeiAppData r7) {
        Intrinsics.checkNotNullParameter(r7, "seiAppData");
        if (Lists.isEmpty(r7.getGrids()) == false) goto L5;
        return;
    L5:
        JSONObject r2 = this.p;
        SeiCanvas r3 = r7.getCanvas();
        Integer r4 = null;
        if (r3 == null) goto L8;
        Integer r5 = Integer.valueOf(r3.getWidth());
    L9:
        r2.put("width", r5);
        JSONObject r6 = this.p;
        SeiCanvas r8 = r7.getCanvas();
        if (r8 == null) goto L12;
        r4 = Integer.valueOf(r8.getHeight());
    L12:
        r6.put("height", r4);
        this.q = r7;
        if (this.A == null) goto L15;
    L23:
        IPreviewMultiLinkOuterConfigProvider r9 = this.b;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L27:
        if (r9.getFeedLiveType() != 5) goto L32;
        post(new e(this));
        return;
    L32:
        return;
    L15:
        if (this.B == false) goto L23;
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L23;
        this.B = false;
        JSONArray r10 = r7.getUiFeatureList();
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L21
        r11.put("ui_feature_list", r10);     // Catch: Exception -> L21
        ClientUIInfo r12 = (ClientUIInfo) GsonHelper.get().fromJson(r11.toString(), new f().getType());     // Catch: Exception -> L21
        ALogger.d("CommonVideoFeedPreview", "onSeiAppDataUpdated, use sei ui_feature_list data: " + r10);     // Catch: Exception -> L21
        J(r12);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ALogger.e("CommonVideoFeedPreview", "parse ui_feature_list error, ", e);
        goto L23
    L8:
        r5 = null;
        goto L9
    }

    public final void setBaseWindowView(BaseLinkSeatWindowView r1) {
        this.g = r1;
    }

    public final void setBaseWindowViewContainer(FrameLayout r1) {
        this.h = r1;
    }

    public final void setConfigInnerProvider(te0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setConfigOuterProvider(IPreviewMultiLinkOuterConfigProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setDynamicWidget(com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1) {
        this.v = r1;
    }

    public final void setFeedDataCenter(DataCenter r1) {
        this.u = r1;
    }

    public final void setLayoutConfig(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1) {
        this.e = r1;
    }

    public final void setMLastSeiAppData(SeiAppData r1) {
        this.q = r1;
    }

    public final void setMViewModelStore(ViewModelStore r1) {
        this.s = r1;
    }

    public final void setViewModelProvider(ViewModelProvider r1) {
        this.t = r1;
    }

    public final void setWindowListHelper(com.bytedance.android.live.liveinteract.plantform.datamerge.a r1) {
        this.f = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "wrds");
        Intrinsics.checkNotNullParameter(r2, "wrds");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    public final int y(int r2) {
        if (r2 == 2) goto L5;
    L7:
        return 0;
    L5:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L7;
        return this.G;
    }

    public void B(int r23, int r24) {
        long r12 = System.currentTimeMillis();
        te0.a r2 = this.c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L5:
        int r3 = r2.getContainerWidth();
        te0.a r4 = this.c;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L8:
        Triple<Integer, Integer, Float> r5 = w(r23, r24, r3, r4.l());
        Triple r9 = new Triple(r5.getFirst(), r5.getSecond(), "MultiLinkCommonVideoFeedPreview#initLoadLayoutConfig");
        ln0.a r6 = yg0.h.a;
        int r7 = yg0.h.h(true, r23, r24);
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L19;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r1.getShowFrom()) == false) goto L19;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L19;
        boolean r8 = false;
    L20:
        int r10 = y(this.E);
        pn0.i r11 = getLayoutConfigRequestExtra();
        ClientUIInfo r13 = this.A;
        if (r13 == null) goto L23;
        List r16 = r13.getUiFeatureList();
    L24:
        IPreviewMultiLinkOuterConfigProvider r14 = this.b;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L27:
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r24, r7, null, r8, r10, false, r11, r9, r16, Long.valueOf(r14.getRoom().getRoomId()), this.u, 4), new com.bytedance.android.live.liveinteract.feedv2.feedview.f(this, r12, r24), null);
        return;
    L23:
        r16 = null;
    L19:
        r8 = true;
        goto L20
    }

    public final void G(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r13) {
        Intrinsics.checkNotNullParameter(r13, "toLayoutConfig");
        int r2 = r13.j();
        int r3 = r13.getUiLayout();
        List r4 = CollectionsKt.emptyList();
        if (r12 == null) goto L5;
        int r5 = r12.j();
    L6:
        if (r12 == null) goto L8;
        int r6 = r12.getUiLayout();
    L9:
        nh0.f r14 = new nh0.f("linkmic", new nh0.e(r2, r3, r4, r5, r6, CollectionsKt.emptyList(), null, null, 192), null, null, null, null, false, 224);
        DataCenter r15 = this.u;
        if (r15 == null) goto L13;
        r15.put("data_multi_lick_dynamic_event_change", r14);
        return;
    L13:
        return;
    L8:
        r6 = -1;
        goto L9
    L5:
        r5 = -1;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void b(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "syncKey");
        Intrinsics.checkNotNullParameter(r1, "syncKey");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void insertEffectView(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public void o(IPreviewMultiLinkOuterConfigProvider r8, te0.a r9) {
        Intrinsics.checkNotNullParameter(r8, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r9, "configInnerProvider");
        r8.printALogger("CommonVideoFeedPreview", hashCode(), "call init: uiLayout = " + this.E, true);
        this.b = r8;
        this.c = r9;
        this.d = r8.getShowFrom();
        z5 r10 = r8.getRoom().getLinkerDetail();
        BehaviorSubject<IRoomLinkMicSyncData> r2 = null;
        if (r10 == null) goto L5;
        String r11 = r10.getClientUiInfo();
    L6:
        this.A = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(r11);
        StringBuilder r12 = new StringBuilder("init, use room clientUiInfo#uiFeatureList data: ");
        ClientUIInfo r3 = this.A;
        if (r3 == null) goto L9;
        List r4 = r3.getUiFeatureList();
    L10:
        r12.append(r4);
        ALogger.d("CommonVideoFeedPreview", r12.toString());
        xs2.b.a().post(new v1(r8.getRoom().getRoomId(), this.E, this.A));
        if (vm2.d.Q0() == false) goto L14;
        H();
    L14:
        if (vm2.h.T() == false) goto L19;
        LifecycleRegistry r13 = this.y;
        if (r13 == null) goto L19;
        r13.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    L19:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L21;
        com.bytedance.android.live.core.utils.i0.c().post(new d(this));
    L21:
        B(this.F, this.E);
        int r14 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        IPreviewMultiLinkOuterConfigProvider r15 = this.b;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L25:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r15.getShowFrom()) == false) goto L32;
        te0.a r16 = this.c;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L29:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r17 = r16.c();
        if (r17 == null) goto L38;
        r2 = r17.v;
    L38:
        if (r2 == null) goto L45;
        Observable r18 = RxUtilKt.h(r2);
        if (r18 == null) goto L46;
        Disposable r19 = r18.subscribe(new com.bytedance.android.live.liveinteract.feedv2.feedview.g(this));
        if (r19 == null) goto L47;
        this.n.add(r19);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L32:
        te0.a r20 = this.c;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L35:
        ue0.c r21 = r20.f();
        if (r21 == null) goto L38;
        r2 = r21.a;
        goto L38
    L9:
        r4 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public final void N(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Triple r0 = new Triple(Integer.valueOf(r4), Integer.valueOf(r5), "MultiLinkCommonVideoFeedPreview#updateLayoutConfigResultIfNeed");
        Pair<Integer, Integer> r6 = getLivePlayerVideoSize();
        ln0.a r7 = yg0.h.a;
        r3.d = yg0.h.a(r3, r0, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void m(int r19, int r20, List<Integer> r21) {
        this.F = r19;
        this.E = r20;
        te0.a r3 = this.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L5:
        int r4 = r3.getContainerWidth();
        te0.a r5 = this.c;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L8:
        Triple<Integer, Integer, Float> r6 = w(r19, r20, r4, r5.l());
        Triple r9 = new Triple(Integer.valueOf(((Number) r6.component1()).intValue()), Integer.valueOf(((Number) r6.component2()).intValue()), "MultiLinkCommonVideoFeedPreview#updateSeiVerAndUILayout");
        ln0.a r7 = yg0.h.a;
        int r8 = yg0.h.h(true, r19, r20);
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L19;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r1.getShowFrom()) == false) goto L19;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L19;
        boolean r10 = false;
    L20:
        DataCenter r2 = this.u;
        if (r2 == null) goto L25;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r11 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r2);
        if (r11 == null) goto L25;
        r11.Aj(r20);
    L25:
        int r12 = y(r20);
        pn0.i r13 = getLayoutConfigRequestExtra();
        ClientUIInfo r14 = this.A;
        if (r14 == null) goto L28;
        List r15 = r14.getUiFeatureList();
    L29:
        IPreviewMultiLinkOuterConfigProvider r16 = this.b;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L32:
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r20, r8, null, r10, r12, false, r13, r9, r15, Long.valueOf(r16.getRoom().getRoomId()), this.u, 4), new g(this), null);
        return;
    L28:
        r15 = null;
    L19:
        r10 = true;
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b.a.a(r2, r3, (com.bytedance.android.live.liveinteract.jsbridge.method.l0) r4);
    }

    public final com.bytedance.android.live.liveinteract.videotalk.utils.h v(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        r3.q(r5);
        r3.s(((Number) ug0.b.b(r3.m(), r3.getUiLayout(), r4, r5).getFirst()).intValue(), r5);
        DataCenter r0 = this.u;
        if (r0 == null) goto L8;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r0);
        if (r1 == null) goto L8;
        r1.Hp(r3, r4, r5);
    L8:
        return com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r4, r5, r3);
    }

    public final void z(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        this.j = v(r3, r4, r5);
        boolean r0 = MultiLinkLoadWidgetUtils.g();
        DataCenter r1 = this.u;
        if (r0 == false) goto L8;
        if (r1 == null) goto L8;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r1);
        if (r2 == null) goto L8;
        r2.Hp(r3, r4, r5);
    L8:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r6 = this.f;
        if (r6 == null) goto L16;
        BehaviorSubject<List<tf0.e>> r7 = r6.b;
        if (r7 == null) goto L17;
        List<? extends tf0.e> r8 = (List) r7.getValue();
        if (r8 == null) goto L18;
        K(r8);
        return;
    L18:
        return;
    L17:
        return;
    }

    public MultiLinkCommonVideoFeedPreview(Context r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 0);
        this.E = r5;
        this.F = r6;
        this.G = r7;
        this.a = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = new CompositeDisposable();
        this.p = new JSONObject();
        this.B = true;
        com.bytedance.android.live.liveinteract.pre.a.c.a.a(hashCode(), this.F);
        VerticalNitaInflate.a(VerticalNitaInflate.Tag.CommonMultiLinkFeedView_container.name(), 2131565261, r4, this, true);
        Context r8 = getContext();
        int r9 = 6;
        CommonLinkSeatWindowView r10 = new CommonLinkSeatWindowView(r8, null, r9, 0);
        r10.setId(2131378011);
        Unit r11 = Unit.INSTANCE;
        this.g = r10;
        this.h = (FrameLayout) findViewById(2131378012);
        this.i = findViewById(2131370478);
        ConstraintLayout r12 = this.g;
        if (r12 == null) goto L8;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -1);
        r13.gravity = 49;
        FrameLayout r14 = this.h;
        if (r14 == null) goto L9;
        r14.addView(r12, r13);
        return;
    L9:
        return;
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
    public final void u(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8, int r9, int r10, float r11) {
        ALogger.i("ttlive_link", "CommonMultiLinkFeedView# call adjustUIForXScreen, layoutConfig[uiLayout = " + r8.getUiLayout() + ", seiVersion = " + r8.m() + "] containerSize[" + r9 + ", " + r10 + "], adjustSize[" + r9 + ", " + r10 + ']');
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
        N(r8, r9, r10);
        BaseLinkSeatWindowView r3 = this.g;
        if (r3 == null) goto L27;
        r3.Yd(r8, r9, r10);
    L27:
        if (r1 == true) goto L29;
    L40:
        FrameLayout r4 = this.h;
        if (r4 == null) goto L54;
        float r5 = r9;
        if (r11 <= 0.0f) goto L45;
        r5 = r5 / r11;
    L45:
        if (r11 <= 0.0f) goto L47;
        float r6 = r10 / r11;
    L48:
        int r12 = (int) r5;
        int r7 = (int) r6;
        ViewGroup.LayoutParams r13 = r4.getLayoutParams();
        if (r13 == null) goto L51;
        r13.width = r12;
        r13.height = r7;
    L51:
        FrameLayout r14 = this.h;
        if (r14 == null) goto L54;
        r14.setLayoutParams(r13);
        goto L54
    L47:
        r6 = r10;
    L54:
        BaseLinkSeatWindowView r15 = this.g;
        if (r15 == null) goto L57;
        r15.U3(r8, r9, r10);
    L57:
        BaseLinkSeatWindowView r16 = this.g;
        if (r16 == null) goto L62;
        RecyclerView r17 = r16.getRecyclerView();
        if (r17 == null) goto L62;
        r17.post(new b(this, r8, r9, r10));
    L63:
        fd2.g r18 = this.x;
        if (r18 == null) goto L67;
        r18.a();
        return;
    L67:
        return;
    L62:
        z(r8, r9, r10);
        goto L63
    L29:
        if (r11 <= 0.0f) goto L40;
        View r19 = this.i;
        if (r19 == null) goto L37;
        ConstraintLayout.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L37;
        ((ViewGroup.LayoutParams) r20).width = r9;
        ((ViewGroup.LayoutParams) r20).height = r10;
        if ((r20 instanceof ConstraintLayout.LayoutParams) == false) goto L37;
        ConstraintLayout.LayoutParams r21 = r20;
        r21.topToTop = 0;
        r21.startToStart = 0;
        r21.endToEnd = 0;
    L37:
        View r22 = this.i;
        if (r22 == null) goto L40;
        r22.setLayoutParams(r22.getLayoutParams());
        goto L40
    L14:
        if (r11 <= 0.0f) goto L21;
        ConstraintLayout r23 = this.g;
        if (r23 == null) goto L18;
        r23.setPivotX(r9 / 2.0f);
        r23.setPivotY(0.0f);
        float r24 = 1 / r11;
        r23.setScaleX(r24);
        r23.setScaleY(r24);
        r23.setTranslationX(0.0f);
    L18:
        View r25 = this.i;
        if (r25 == null) goto L24;
        r25.setPivotX(r9 / 2.0f);
        r25.setPivotY(0.0f);
        float r26 = 1 / r11;
        r25.setScaleX(r26);
        r25.setScaleY(r26);
        r25.setTranslationX(0.0f);
    L10:
        r1 = false;
        goto L12
    }

    public final Triple<Integer, Integer, Float> w(int r2, int r3, int r4, int r5) {
        Pair r6 = ug0.b.b(r2, r3, r4, r5);
        if (vm2.d.d0().i() == false) goto L10;
        IPreviewMultiLinkOuterConfigProvider r7 = this.b;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        if (r7.getShowFrom() != 5) goto L10;
        boolean r8 = true;
    L11:
        int r9 = ((Number) r6.getFirst()).intValue();
        if (r8 == false) goto L15;
        if (r9 <= 0) goto L15;
        float r0 = s1.y() / r9;
    L16:
        if (r8 == false) goto L23;
        if (r0 <= 0.0f) goto L23;
        return new Triple(Integer.valueOf((int) (((Number) r6.getFirst()).floatValue() * r0)), Integer.valueOf((int) (((Number) r6.getSecond()).floatValue() * r0)), Float.valueOf(r0));
    L23:
        return new Triple(r6.getFirst(), r6.getSecond(), Float.valueOf(1.0f));
    L15:
        r0 = 1.0f;
    L10:
        r8 = false;
        goto L11
    }

    public final void x(int r11, boolean r12, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r13, Function1<? super com.bytedance.android.live.liveinteract.plantform.commonwindow.m, Unit> r14) {
        if (r11 != 2) goto L14;
        int r15 = r13.m();
        int r16 = r13.getUiLayout();
        te0.a r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L7:
        int r1 = r0.getContainerWidth();
        te0.a r2 = this.c;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L10:
        Triple<Integer, Integer, Float> r17 = w(r15, r16, r1, r2.l());
        int r18 = ((Number) r17.component1()).intValue();
        int r19 = ((Number) r17.component2()).intValue();
        ln0.a r3 = yg0.h.a;
        int r4 = this.o;
        c r5 = new c(r14);
        pn0.i r6 = getLayoutConfigRequestExtra();
        Triple r7 = new Triple(Integer.valueOf(r18), Integer.valueOf(r19), "MultiLinkCommonVideoFeedPreview#getDynamicEqualLayoutConfig, with windowCount = " + this.o);
        Pair<Integer, Integer> r8 = getLivePlayerVideoSize();
        ClientUIInfo r9 = this.A;
        IPreviewMultiLinkOuterConfigProvider r110 = this.b;
        if (r110 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L13:
        yg0.h.f(r4, r5, r12, r6, r7, r8, r9, Long.valueOf(r110.getRoom().getRoomId()), this.u);
        return;
    L14:
        r14.invoke(r13);
    }
}
