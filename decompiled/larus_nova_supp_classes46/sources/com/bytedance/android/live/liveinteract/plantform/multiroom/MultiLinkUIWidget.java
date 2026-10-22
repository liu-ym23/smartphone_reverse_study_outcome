package com.bytedance.android.live.liveinteract.plantform.multiroom;

import am2.x;
import android.os.Handler;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.SupportUpdatePlayMode;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.CommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.ui.ClipFrameLayout;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.k;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdk.config.ra1;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.model.MultiLinkMatchScreenConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.multilink.MultiLinkMsgPreloadBizListener;
import com.bytedance.android.livesdkapi.multilink.RoomLinkMicSyncDataPreloadBizListener;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006B\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/multiroom/MultiLinkUIWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvg0/a;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/l;", "Lcom/bytedance/android/livesdkapi/multilink/RoomLinkMicSyncDataPreloadBizListener;", "Lcom/bytedance/android/livesdkapi/multilink/MultiLinkMsgPreloadBizListener;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkUIWidget extends MiddlewareRoomWidget implements vg0.a, l, RoomLinkMicSyncDataPreloadBizListener, MultiLinkMsgPreloadBizListener, Observer<KVData> {
    public zj0.d a;
    public final List<Long> b;
    public boolean c;
    public l d;
    public m e;
    public final BehaviorSubject<m> f;
    public final CompositeDisposable g;
    public boolean h;
    public Long i;
    public Disposable j;
    public Disposable k;
    public long l;
    public ConstraintLayout m;
    public int n;

    public static final class a implements Runnable {
        public final /* synthetic */ MultiLinkUIWidget a;
        public final /* synthetic */ boolean b;

        public a(MultiLinkUIWidget r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            MultiLinkUIWidget r0 = this.a;
            boolean r1 = this.b;
            if (r0.h == true) goto L71;
            r0.Jq("MultiLinkUIWidget#_onRoomVisible", r0.hashCode(), "isVisible=true");
            r0.h = true;
            r0.i = Long.valueOf(System.currentTimeMillis());
            Disposable r3 = r0.j;
            if (r3 == null) goto L7;
            r3.dispose();
        L7:
            Lazy r4 = MultiLinkWRDSPreloadManager.i;
            MultiLinkWRDSPreloadManager r5 = MultiLinkWRDSPreloadManager.a.a();
            DataCenter r6 = ((Widget) r0).dataCenter;
            long r7 = 0;
            if (r6 == null) goto L12;
            IRoom r8 = a0.o(r6);
            if (r8 == null) goto L12;
            long r9 = r8.getId();
        L13:
            r5.removeRoomLinkMicSyncDataBizListener("inner_feed", r9, r0);
            MultiLinkWRDSPreloadManager r10 = MultiLinkWRDSPreloadManager.a.a();
            DataCenter r11 = ((Widget) r0).dataCenter;
            if (r11 == null) goto L18;
            IRoom r12 = a0.o(r11);
            if (r12 == null) goto L18;
            long r13 = r12.getId();
        L19:
            r10.removeLinkMicMsgBizListener("inner_feed", r13, r0);
            if (MultiLinkLoadWidgetUtils.e() == true) goto L25;
            if (r1 == false) goto L23;
            String r14 = "not_preload";
        L24:
            r0.Fq(r14);
            goto L25
        L23:
            r14 = "preload_enter";
        L25:
            if (r1 == true) goto L27;
        L59:
            if (r1 == true) goto L72;
            int r2 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r15 = ((Widget) r0).dataCenter;
            o r16 = z51.a.h(r15, 2);
            if (r16 == null) goto L67;
            com.bytedance.live.datacontext.m r17 = r16.getRoom();
            if (r17 == null) goto L67;
            IRoom r18 = (IRoom) r17.getValue();
            if (r18 == null) goto L67;
            r7 = r18.getId();
        L67:
            MultiSceneEnterRoomStatisticsUtils r19 = MultiSceneEnterRoomStatisticsUtils.a.a(r15, Long.valueOf(r7));
            if (r19 == null) goto L73;
            r19.m = true;
            return;
        L73:
            return;
        L72:
            return;
        L27:
            if (MultiLinkLoadWidgetUtils.i() == false) goto L59;
            if (vm2.d.q0().isOpenSmoothViewMock() == false) goto L59;
            DataCenter r20 = ((Widget) r0).dataCenter;
            View r21 = null;
            if (r20 == null) goto L33;
            ViewGroup r22 = (ViewGroup) r20.get("data_multi_link_feed_mock_view_parent");
        L35:
            if ((r22 instanceof ViewGroup) == true) goto L37;
            r22 = null;
        L37:
            DataCenter r23 = ((Widget) r0).dataCenter;
            if (r23 == null) goto L40;
            View r24 = (View) r23.get("data_multi_link_feed_mock_view");
        L42:
            if ((r24 instanceof View) == false) goto L45;
            r21 = r24;
        L45:
            if (r21 == null) goto L55;
            if (r22 == null) goto L48;
            int r25 = r22.getChildCount();
        L49:
            if (r25 <= 0) goto L55;
            r0.Jq("MultiLinkUIWidget#_onRoomVisible", r0.hashCode(), "进房时visile，且有mockView，seatWindowView先隐藏");
            l r26 = r0.d;
            if (r26 == null) goto L55;
            ViewGroup r27 = r26.td();
            if (r27 == null) goto L55;
            Handler r28 = UtilityKotlinExtentionsKt.a;
            Intrinsics.checkNotNullParameter(r27, "$this$setVisibilityInVisibleAlpha");
            r27.setAlpha(0.0f);
            goto L55
        L48:
            r25 = 0;
        L55:
            Disposable r29 = r0.k;
            if (r29 == null) goto L58;
            r29.dispose();
        L58:
            r0.k = Observable.timer(vm2.d.q0().getRemoveViewMockTimeOut(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r0));
            goto L59
        L40:
            r24 = null;
            goto L42
        L33:
            r22 = null;
        L18:
            r13 = 0;
        L12:
            r9 = 0;
            goto L13
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

    public static final class b implements g {
        public final /* synthetic */ MultiLinkUIWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ zj0.c c;
        public final /* synthetic */ int d;
        public final /* synthetic */ List e;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(h r6) {
            Intrinsics.checkNotNullParameter(r6, "request");
            Lazy r7 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.m(((Widget) this.a).dataCenter, "MultiLinkUIWidget#trySwitchLayout", "load LayoutConfig failed, switchType = " + this.c + ", spend time = " + (System.currentTimeMillis() - this.b));
            f2.g();
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(h r18, i r19) {
            Intrinsics.checkNotNullParameter(r18, "request");
            Intrinsics.checkNotNullParameter(r19, "response");
            boolean r3 = gh0.b.a;
            int r5 = 0;
            gh0.b.a("SceneOrUiLayoutChange", "switch_layout spend time: " + (System.currentTimeMillis() - this.b), false);
            this.a.Jq("MultiLinkUIWidget#trySwitchLayout", hashCode(), "load LayoutConfig success, switchType = " + this.c + ", spend time = " + (System.currentTimeMillis() - this.b));
            int r4 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r6 = ((Widget) this.a).dataCenter;
            o r7 = z51.a.h(r6, 2);
            if (r7 == null) goto L9;
            com.bytedance.live.datacontext.m r8 = r7.getRoom();
            if (r8 == null) goto L9;
            IRoom r9 = (IRoom) r8.getValue();
            if (r9 == null) goto L9;
            long r10 = r9.getId();
        L10:
            MultiSceneEnterRoomStatisticsUtils r11 = MultiSceneEnterRoomStatisticsUtils.a.a(r6, Long.valueOf(r10));
            if (r11 == null) goto L13;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r11, "native_receive_layout_config", 0, 2, null);
        L13:
            zj0.d.b r12 = new zj0.d.b(this.d, r19.a.getUiLayout(), r19.a.m(), 0, r19.a.f(), 8);
            MultiLinkUIWidget r13 = this.a;
            zj0.c r14 = this.c;
            List r15 = this.e;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r14, "switchType");
            Intrinsics.checkNotNullParameter(r19, "response");
            gh0.b.a("SceneOrUiLayoutChange", "do switchLayout from: " + r13.a + ", to: " + r12 + " by " + r14, false);
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            String r16 = String.valueOf(r12);
            zj0.d r17 = r13.a;
            if (r17 == null) goto L16;
            String r110 = r17.toString();
        L17:
            String r111 = r14.toString() + "#MultiLinkUIWidget";
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.B0(r16, r110, r111);
            zj0.d r20 = r13.a;
            Class<? extends tf0.o> r21 = r12.f;
            if (r20 == null) goto L20;
            Class<? extends tf0.o> r22 = r20.f;
        L21:
            Intrinsics.areEqual(r21, r22);
            zj0.d r23 = r13.a;
            boolean r24 = r23 instanceof zj0.d.b;
            if (r24 == true) goto L24;
        L28:
            boolean r112 = false;
        L30:
            if (r112 == false) goto L32;
            Lazy r1 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.m(((Widget) r13).dataCenter, "MultiLinkUIWidget#realSwitchLayout", "switchLayout failed: already same layout, " + r14 + " current:" + r13.a);
        L70:
            MultiLinkUIWidget r25 = this.a;
            m r26 = r25.e;
            if (r26 == null) goto L175;
            int r27 = r25.xq();
            int r28 = this.a.wq();
            MultiLinkUIWidget r29 = this.a;
            Pair<Integer, Integer> r30 = r29.Cq(r27, r28);
            int r31 = ((Number) r30.getFirst()).intValue();
            int r32 = ((Number) r30.getSecond()).intValue();
            r29.Nq(r26, r27, r28);
            r29.Pq(r26, r31, r32);
            if (je0.d.E(((Widget) r29).dataCenter) == true) goto L167;
            MiddlewareRoomContext r33 = o3.c(((Widget) r29).dataCenter);
            if (r33 == null) goto L79;
            n r34 = r33.isRoomVisible();
            if (r34 == null) goto L79;
            Boolean r35 = (Boolean) r34.getValue();
        L81:
            if (Intrinsics.areEqual(r35, Boolean.FALSE) == false) goto L167;
            if (MultiLinkLoadWidgetUtils.h() == false) goto L167;
            if (r29.Eq() == false) goto L134;
            m r36 = r29.e;
            if (r36 != null) goto L89;
        L112:
            MultiLinkFrequencyOptConfig r37 = f.a;
            m r38 = r29.e;
            if (r38 == null) goto L115;
            Integer r39 = Integer.valueOf(r38.m());
        L116:
            m r40 = r29.e;
            if (r40 == null) goto L119;
            Integer r113 = Integer.valueOf(r40.getUiLayout());
        L121:
            if (f.n(r39, r113) == false) goto L167;
            m r41 = r29.e;
            if (r41 == null) goto L133;
            pn0.f r42 = r41.d;
            if (r42 == null) goto L131;
            InteractionWidgetsPosContext r43 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) r29).dataCenter, 0, 2);
            if (r43 == null) goto L131;
            com.bytedance.live.datacontext.m r44 = r43.getAudioTalkBottomPos();
            if (r44 == null) goto L131;
            pn0.f.b r45 = r42.c;
            r44.setValue(Integer.valueOf(r45.b + r45.d));
        L131:
            ((Widget) r29).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
            goto L167
        L133:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkWindowLayoutConfig");
        L119:
            r113 = null;
            goto L121
        L115:
            r39 = null;
            goto L116
        L89:
            if (r36.getUiLayout() != 30) goto L112;
            Integer r46 = (Integer) ((Widget) r29).dataCenter.get("data_enlarge_stage_bottom_pos", 0);
            if (r46 != null) goto L94;
        L95:
            InteractionWidgetsPosContext r47 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) r29).dataCenter, 0, 2);
            if (r47 == null) goto L109;
            com.bytedance.live.datacontext.m r48 = r47.getAudioTalkBottomPos();
            if (r48 == null) goto L109;
            r48.setValue(((Widget) r29).dataCenter.get("data_enlarge_stage_bottom_pos", 0));
        L109:
            ((Widget) r29).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
            goto L167
        L94:
            if (r46.intValue() != 0) goto L95;
            m r49 = r29.e;
            if (r49 == null) goto L111;
            pn0.f r50 = r49.d;
            if (r50 == null) goto L109;
            InteractionWidgetsPosContext r51 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) r29).dataCenter, 0, 2);
            if (r51 == null) goto L109;
            com.bytedance.live.datacontext.m r52 = r51.getAudioTalkBottomPos();
            if (r52 == null) goto L109;
            r52.setValue(Integer.valueOf((((r50.c.b + ((pn0.f.c) ListProtector.get(r50.d, 0)).d) + ((pn0.f.c) ListProtector.get(r50.d, 0)).f) + s1.f(30.0f)) + s1.f(62.0f)));
            goto L109
        L111:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkWindowLayoutConfig");
        L134:
            MultiLinkFrequencyOptConfig r53 = f.a;
            m r54 = r29.e;
            if (r54 == null) goto L137;
            Integer r55 = Integer.valueOf(r54.m());
        L138:
            m r56 = r29.e;
            if (r56 == null) goto L141;
            Integer r114 = Integer.valueOf(r56.getUiLayout());
        L143:
            if (f.f(r55, r114) == true) goto L167;
            m r57 = r29.e;
            if (r57 == null) goto L166;
            pn0.f r58 = r57.d;
            if (r58 == null) goto L167;
            InteractionWidgetsPosContext.a r59 = InteractionWidgetsPosContext.Companion;
            InteractionWidgetsPosContext r60 = InteractionWidgetsPosContext.a.c(r59, ((Widget) r29).dataCenter, 0, 2);
            if (r60 == null) goto L153;
            com.bytedance.live.datacontext.m r61 = r60.getVideoEqualTalkBottomPos();
            if (r61 == null) goto L153;
            pn0.f.b r62 = r58.c;
            r61.setValue(Integer.valueOf(r62.b + r62.d));
        L153:
            m r63 = r29.e;
            if (r63 == null) goto L167;
            if (r63.getUiLayout() != 43) goto L167;
            if ((!r58.d.isEmpty()) == false) goto L160;
            r5 = ((pn0.f.c) ListProtector.get(r58.d, 0)).f;
        L160:
            int r65 = s1.f(30.0f);
            InteractionWidgetsPosContext r66 = InteractionWidgetsPosContext.a.c(r59, ((Widget) r29).dataCenter, 0, 2);
            if (r66 == null) goto L167;
            com.bytedance.live.datacontext.m r67 = r66.getVideoTalkTop2V4V4GiftHeightTrayPos();
            if (r67 == null) goto L167;
            r67.setValue(Integer.valueOf((r58.c.d - r5) + r65));
            goto L167
        L166:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkWindowLayoutConfig");
        L141:
            r114 = null;
            goto L143
        L137:
            r55 = null;
        L79:
            r35 = null;
        L167:
            com.bytedance.android.live.liveinteract.plantform.multiroom.a r68 = r29.Bq();
            if (r68 == null) goto L176;
            BehaviorSubject<List<tf0.e>> r69 = r68.el();
            if (r69 == null) goto L177;
            List<? extends tf0.e> r70 = (List) r69.getValue();
            if (r70 == null) goto L178;
            r29.Kq(r70);
            return;
        L178:
            return;
        L177:
            return;
        L176:
            return;
        L175:
            return;
        L32:
            List<Long> r115 = r13.b;
            if (r24 == true) goto L35;
        L43:
            boolean r71 = false;
        L45:
            if (r71 == false) goto L47;
            Lazy r72 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.m(((Widget) r13).dataCenter, "MultiLinkUIWidget#realSwitchLayout", "dynamicEqualUILayoutChange, from:" + r13.a + " to:" + r12 + " by " + r14);
            r13.a = r12;
            goto L70
        L47:
            r13.Jq("MultiLinkUIWidget#realSwitchLayout", r13.hashCode(), "do switchLayout from:" + r13.a + " to:" + r12 + " by " + r14);
            j r73 = com.bytedance.android.live.liveinteract.api.utils.m.e(r13).getVideoTalkRoomSubScene();
            if (r73 == null) goto L59;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r74 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r73.getValue();
            if (r74 == null) goto L59;
            zj0.d r75 = r13.a;
            if (r75 == null) goto L54;
            int r116 = r75.a;
        L55:
            if (r75 == null) goto L57;
            int r76 = r75.b;
        L58:
            r74.f(new k(r116, r76, false, 4));
            goto L59
        L57:
            r76 = 0;
            goto L58
        L54:
            r116 = 0;
        L59:
            r13.a = r12;
            if (r15 != null) goto L62;
        L64:
            m r77 = r19.a;
            r13.e = r77;
            BehaviorSubject<m> r78 = r13.f;
            Intrinsics.checkNotNull(r77);
            r78.onNext(r77);
            com.bytedance.android.live.liveinteract.plantform.multiroom.a r79 = r13.Bq();
            if (r79 == null) goto L67;
            r79.qd(r13.e);
        L67:
            int r80 = r13.xq();
            int r81 = r13.wq();
            Pair<Integer, Integer> r82 = r13.Cq(r80, r81);
            int r83 = ((Number) r82.getFirst()).intValue();
            int r84 = ((Number) r82.getSecond()).intValue();
            m r85 = r13.e;
            Intrinsics.checkNotNull(r85);
            r13.Nq(r85, r80, r81);
            m r86 = r13.e;
            Intrinsics.checkNotNull(r86);
            r13.Pq(r86, r83, r84);
            int r87 = e.a;
            com.bytedance.android.live.liveinteract.bgComponent.platform.a r88 = e.c(((Widget) r13).dataCenter);
            if (r88 == null) goto L70;
            r88.Hp(r13.e, r83, r84);
            goto L70
        L62:
            if ((!Intrinsics.areEqual(r13.b, r15)) == false) goto L64;
            ((ArrayList) r13.b).clear();
            ((ArrayList) r13.b).addAll(r15);
            goto L64
        L35:
            if (e0.a(r12.b) == false) goto L43;
            if (e0.a(r23.b) == false) goto L43;
            if (d0.f(r15) == false) goto L43;
            if (d0.f(r115) == false) goto L43;
            r71 = true;
            goto L45
        L24:
            if (r12.b != r23.b) goto L28;
            if (r12.g != r23.g) goto L28;
            r112 = true;
            goto L30
        L20:
            r22 = null;
            goto L21
        L16:
            r110 = null;
        L9:
            r10 = 0;
            goto L10
        }

        public b(MultiLinkUIWidget r1, long r2, zj0.c r4, u r5, int r6, List r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final ConstraintLayout.LayoutParams getCurRvLayoutParams() {
        return null;
    }

    public final int getLayoutId() {
        return 2131567022;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final fg0.a getMultiAdapterWrapper() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final LinkMicRecyclerView getRecyclerView() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void setMFirstVHShadowViewChange(CommonLinkSeatWindowView.a r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void setUIViewValid(boolean r1) {
    }

    public final com.bytedance.android.live.liveinteract.plantform.multiroom.a Bq() {
        int r0 = e.a;
        return e.a(((Widget) this).dataCenter);
    }

    public final boolean Eq() {
        o r0 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.isLiveTypeAudio() != true) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final boolean Gi() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.Gi();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Ma() {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.Ma();
        return;
    }

    @Override // vg0.a
    public final void S4() {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.S4();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void T8() {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.T8();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.a
    public final se0.c getAudioFeedLayerUIConfig() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAudioFeedLayerUIConfig();
    }

    public final int getCurrentScene() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        IRoom r1 = null;
        if (r0 == null) goto L7;
        n r2 = r0.isRoomVisible();
        if (r2 == null) goto L7;
        Boolean r3 = (Boolean) r2.getValue();
    L9:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L20;
        j r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r4 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 == null) goto L20;
        int r7 = r6.a;
        if (r7 <= 0) goto L20;
        return r7;
    L20:
        if (MultiLinkLoadWidgetUtils.a() == false) goto L32;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L24;
        IRoom r9 = a0.o(r8);
    L25:
        Lazy r10 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r11 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", r9, false, 4, null);
        if (r11 == null) goto L32;
        LinkerBaseInfo r12 = r11.linkerBaseInfo;
        if (r12 == null) goto L32;
        int r13 = r12.getScene();
        if (r13 <= 0) goto L32;
        return r13;
    L24:
        r9 = null;
    L32:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L35;
        r1 = a0.o(r14);
    L35:
        if (r1 == null) goto L41;
        Map r15 = r1.getLinkMap();
        if (r15 != null) goto L40;
        return 0;
    L40:
        return je0.d.m(r15, r1.isLiveTypeAudio());
    L41:
        return 0;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public final int getCurrentWindowCount() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentWindowCount();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final List<tf0.e> getDataList() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDataList();
    }

    @Override // xg0.a
    public final int getFeedType() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getFeedType();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final ClipFrameLayout getFirstSeatVHShadowContainer() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFirstSeatVHShadowContainer();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final ClipFrameLayout getFirstSeatVHShadowFloatContainer() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFirstSeatVHShadowFloatContainer();
    }

    @Override // hg0.a
    public final Integer getLastSubUILayout() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLastSubUILayout();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final BaseLinkSeatWindowView getLinkSeatWindowView() {
        if (this.d != null) goto L15;
        o r0 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L13;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L13;
        if (r2.isLiveTypeAudio() != true) goto L13;
        l r3 = (l) ((Widget) this).containerView.findViewById(2131378014);
    L14:
        this.d = r3;
    L13:
        r3 = (l) ((Widget) this).containerView.findViewById(2131378013);
    L15:
        l r4 = this.d;
        if ((r4 instanceof BaseLinkSeatWindowView) == true) goto L19;
        r4 = null;
    L19:
        return (BaseLinkSeatWindowView) r4;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.a
    public final m getLinkWindowLayoutConfig() {
        l r0 = this.d;
        if (r0 == null) goto L8;
        m r1 = r0.getLinkWindowLayoutConfig();
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new IllegalStateException("customLinkSeatWindowView is null");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final JsonObject getLinkmicAreaFrameInfo() {
        l r0 = this.d;
        if (r0 == null) goto L6;
        m r1 = r0.getCurrentLayoutConfig();
        if (r1 == null) goto L6;
    L9:
        if (r1 != null) goto L11;
        return null;
    L11:
        Pair<Integer, Integer> r2 = Cq(xq(), wq());
        int r3 = ((Number) r2.getFirst()).intValue();
        int r4 = ((Number) r2.getSecond()).intValue();
        int r5 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        sf0.b r6 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a(r1, r3, r4);
        r6.c.a = r1.b;
        List<Integer> r7 = r1.e;
        if (r7 == null) goto L15;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.b = r7;
    L15:
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r6);
    L6:
        r1 = this.e;
        if ((r1 instanceof m) == true) goto L9;
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final JsonObject getLinkmicSeatListInfo() {
        l r0 = this.d;
        if (r0 == null) goto L5;
        List<tf0.e> r1 = r0.getDataList();
    L7:
        return new nh0.f("seat", null, r1, null, null, null, false, 246).b();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final RecyclerView getMicSeatRecyclerView() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMicSeatRecyclerView();
    }

    @Override // xg0.a
    public final IRoom getRoom() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoom();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final ug0.a getRvLayoutManager() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRvLayoutManager();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final boolean gg() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.gg();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void jf() {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.jf();
        return;
    }

    public final void onCreate() {
        super.onCreate();
        int r1 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r2 = ((Widget) this).dataCenter;
        o r3 = z51.a.h(r2, 2);
        if (r3 == null) goto L9;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L9;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L9;
        long r6 = r5.getId();
    L10:
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r2, Long.valueOf(r6));
        if (r7 == null) goto L13;
        r7.recordSubElementShow("preload_widget_load", System.currentTimeMillis());
    L13:
        this.l = System.currentTimeMillis();
        int r8 = e.a;
        DataCenter r9 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        Intrinsics.checkNotNullParameter(this, "service");
        r9.put("data_multi_link_ui_service", this);
        o r10 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r10 == null) goto L26;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L26;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L26;
        if (r12.isLiveTypeAudio() != true) goto L26;
        BaseLinkSeatWindowView r13 = (BaseLinkSeatWindowView) ((Widget) this).containerView.findViewById(2131378014);
        if (r13 == null) goto L31;
        this.d = r13;
        ConstraintLayout r14 = (BaseLinkSeatWindowView) ((Widget) this).containerView.findViewById(2131378013);
        if (r14 == null) goto L31;
        UtilityKotlinExtentionsKt.q(r14);
    L31:
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r15 = e.c(((Widget) this).dataCenter);
        if (r15 == null) goto L48;
        ViewGroup r16 = r15.Pn();
        if (r16 == null) goto L48;
        Jq("MultiLinkUIWidget#adjustPreloadViewsLayer", hashCode(), "themeService=" + r15.hashCode() + ", themeBgViewContainer=" + r16);
        l r17 = this.d;
        if (r17 == null) goto L40;
        ViewGroup r18 = r17.td();
        if (r18 == null) goto L40;
        FrameLayout r19 = (FrameLayout) r18.findViewById(2131388550);
    L41:
        if (r19 == null) goto L43;
        r19.removeAllViews();
    L43:
        ViewGroup r20 = UtilityKotlinExtentionsKt.p(r16);
        if (r20 == null) goto L46;
        r20.removeView(r16);
    L46:
        if (r19 == null) goto L48;
        r19.addView(r16, new FrameLayout.LayoutParams(-1, -1));
    L40:
        r19 = null;
    L48:
        IInteractService r21 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r21 == null) goto L53;
        ih0.b r22 = r21.dynamicService(((Widget) this).dataCenter);
        if (r22 == null) goto L53;
        ih0.c r23 = r22.Z9();
    L54:
        boolean r24 = false;
        if (r23 == null) goto L68;
        View r25 = r23.S0();
        if (r25 == null) goto L68;
        ViewGroup r26 = UtilityKotlinExtentionsKt.p(r25);
        if (r26 == null) goto L61;
        r26.removeView(r25);
    L61:
        l r27 = this.d;
        if (r27 == null) goto L68;
        ViewGroup r28 = r27.td();
        if (r28 == null) goto L68;
        FrameLayout r29 = (FrameLayout) r28.findViewById(2131380433);
        if (r29 == null) goto L68;
        r29.removeAllViews();
        r29.addView(r25, 0);
    L68:
        IRoom r30 = je0.d.e(((Widget) this).dataCenter);
        if (r30 == null) goto L157;
        Map r31 = r30.getLinkMap();
        if (r31 == null) goto L157;
        z5 r32 = r30.getLinkerDetail();
        if (r32 == null) goto L157;
        int r110 = je0.d.m(r31, r30.isLiveTypeAudio());
        int r111 = r32.getUiLayout();
        List<Long> r112 = r32.getPlayModes();
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r33 = Bq();
        if (r33 == null) goto L86;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r34 = r33.md();
        if (r34 == null) goto L86;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r35 = r34.N0();
        if (r35 == null) goto L86;
        List r36 = (List) r35.getValue();
        if (r36 == null) goto L86;
        Integer r113 = Integer.valueOf(r36.size());
    L87:
        Jq("MultiLinkUIWidget#initViewOnPreload", hashCode(), "initViewOnPreload, scene=" + r110 + ", uiLayout=" + r111 + ", playModes=" + r112 + ", windowCount=" + r113);
        ClientUIInfo r114 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(r32.getClientUiInfo());
        if (MultiLinkLoadWidgetUtils.a() == false) goto L126;
        Lazy r37 = MultiLinkWRDSPreloadManager.i;
        String r38 = "MultiLinkUIWidget#initViewOnPreload";
        Integer r115 = r113;
        RoomLinkMicSyncData r39 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", r30, false, 4, null);
        if (r39 == null) goto L120;
        LinkerBaseInfo r40 = r39.linkerBaseInfo;
        if (r40 == null) goto L94;
        r110 = r40.getScene();
    L94:
        if (r40 == null) goto L96;
        r111 = r40.getUiLayout();
    L96:
        if (r40 == null) goto L100;
        r112 = r40.getPlayModes();
        if (r112 == null) goto L100;
    L101:
        List r41 = r39.mLinkUsers;
        if (r41 == null) goto L104;
        Integer r42 = Integer.valueOf(r41.size());
    L105:
        ClientUIInfo r43 = r39.clientUIInfo;
        if (r43 == null) goto L108;
        r114 = r43;
    L108:
        DataCenter r44 = ((Widget) this).dataCenter;
        o r116 = z51.a.h(r44, 2);
        if (r116 == null) goto L115;
        com.bytedance.live.datacontext.m r117 = r116.getRoom();
        if (r117 == null) goto L115;
        IRoom r118 = (IRoom) r117.getValue();
        if (r118 == null) goto L115;
        long r119 = r118.getId();
    L116:
        MultiSceneEnterRoomStatisticsUtils r45 = MultiSceneEnterRoomStatisticsUtils.a.a(r44, Long.valueOf(r119));
        if (r45 == null) goto L119;
        r45.recordSubElementShow("bytelink_data_receive", System.currentTimeMillis());
    L119:
        Gq();
        r113 = r42;
    L121:
        int r46 = hashCode();
        StringBuilder r47 = new StringBuilder("addRoomLinkMicSyncDataBizListener room?.id ");
        r47.append(Long.valueOf(r30.getId()).longValue());
        r47.append(' ');
        IBaseUser r120 = r30.getOwner();
        if (r120 == null) goto L124;
        String r121 = r120.getNickName();
    L125:
        r47.append(r121);
        Jq(r38, r46, r47.toString());
        MultiLinkWRDSPreloadManager.a.a().addRoomLinkMicSyncDataBizListener("inner_feed", Long.valueOf(r30.getId()).longValue(), this);
        MultiLinkWRDSPreloadManager.a.a().addLinkMicMsgBizListener("inner_feed", Long.valueOf(r30.getId()).longValue(), this);
    L127:
        ClientUIInfo r48 = r114;
        MiddlewareRoomContext r49 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r49 == null) goto L132;
        n r50 = r49.isRoomVisible();
        if (r50 == null) goto L132;
        Boolean r51 = (Boolean) r50.getValue();
    L134:
        if (Intrinsics.areEqual(r51, Boolean.TRUE) == false) goto L149;
        j r52 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r52 == null) goto L148;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r53 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r52.getValue();
        if (r53 == null) goto L148;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r54 = r53.t();
        if (r54 == null) goto L148;
        int r55 = r54.a;
        if (r55 <= 0) goto L144;
        r110 = r55;
    L144:
        int r56 = r54.b;
        if (r56 <= 0) goto L147;
        r111 = r56;
    L147:
        zj0.c r57 = new zj0.c.b(r110, r111);
    L150:
        int r58 = hashCode();
        StringBuilder r59 = new StringBuilder("switchType = ");
        r59.append(r57);
        r59.append(", finalScene = ");
        r59.append(r110);
        r59.append(", finalUILayout = ");
        r59.append(r111);
        r59.append(", room.linkerDetail = ");
        r59.append(r30.getLinkerDetail());
        r59.append(", clentUiInfo = ");
        if (r48 == null) goto L153;
        String r60 = r48.toString();
    L154:
        r59.append(r60);
        Jq(r38, r58, r59.toString());
        if (r111 == 0) goto L157;
        Iq(r110, r111);
        Mq(r57, r112, r113, r48);
        goto L157
    L153:
        r60 = null;
    L148:
        r57 = new zj0.c.b(r110, r111);
        goto L150
    L149:
        r57 = new zj0.c.C0300c(r110, r111);
    L132:
        r51 = null;
        goto L134
    L124:
        r121 = null;
    L115:
        r119 = 0;
        goto L116
    L104:
        r42 = null;
    L100:
        r112 = r112;
        goto L101
    L120:
        r113 = r115;
        r112 = r112;
        goto L121
    L126:
        r38 = "MultiLinkUIWidget#initViewOnPreload";
    L86:
        r113 = null;
    L157:
        int r61 = hashCode();
        StringBuilder r62 = new StringBuilder("registerWindowListObservable MultiLinkUIWidget#");
        r62.append(hashCode());
        r62.append(", micSeatDataService=");
        r62.append(Bq());
        r62.append(", windowListObservable=");
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r63 = Bq();
        if (r63 == null) goto L160;
        BehaviorSubject<List<tf0.e>> r65 = r63.el();
    L161:
        r62.append(r65);
        r62.append('}');
        Jq("MultiLinkUIWidget#registerWindowListObservable", r61, r62.toString());
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r66 = Bq();
        if (r66 == null) goto L168;
        BehaviorSubject<List<tf0.e>> r67 = r66.el();
        if (r67 == null) goto L168;
        Disposable r68 = r67.subscribe(new d(this));
        if (r68 == null) goto L168;
        RxUtilKt.c(r68, this.g);
        Disposable r69 = r68;
    L169:
        this.j = r69;
        ((Widget) this).dataCenter.observe("cmd_multi_enter_room_remove_view_mock", this, true);
        ((Widget) this).dataCenter.observe("cmd_multi_enter_room_lynx_micseat_remove_view_mock", this, true);
        MiddlewareRoomContext r70 = o3.c(((Widget) this).dataCenter);
        if (r70 == null) goto L176;
        n r71 = r70.isRoomVisible();
        if (r71 == null) goto L176;
        Boolean r72 = (Boolean) r71.getValue();
        if (r72 == null) goto L176;
        r24 = r72.booleanValue();
    L176:
        runWithRoomVisible(new a(this, r24));
        if (MultiLinkLoadWidgetUtils.e() == false) goto L183;
        if (r24 == false) goto L180;
        Fq("not_preload_on_create");
        goto L183
    L180:
        DataCenter r73 = ((Widget) this).dataCenter;
        if (r73 == null) goto L183;
        r73.observe("data_on_page_selected", this, true);
    L183:
        Jq("MultiLinkUIWidget#onCreate", hashCode(), "createFinish");
        return;
    L168:
        r69 = null;
        goto L169
    L160:
        r65 = null;
    L53:
        r23 = null;
    L26:
        ConstraintLayout r74 = (BaseLinkSeatWindowView) ((Widget) this).containerView.findViewById(2131378013);
        if (r74 == null) goto L31;
        this.d = r74;
        this.m = r74.findViewById(2131387772);
        ConstraintLayout r75 = (BaseLinkSeatWindowView) ((Widget) this).containerView.findViewById(2131378014);
        if (r75 == null) goto L31;
        UtilityKotlinExtentionsKt.q(r75);
    L9:
        r6 = 0;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void release() {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final ViewGroup td() {
        Object r0 = this.d;
        if ((r0 instanceof ViewGroup) == true) goto L6;
        r0 = null;
    L6:
        return (ViewGroup) r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final View vb() {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.vb();
    }

    public final int wq() {
        View r0 = hs0.a.b.getCurrentLivePlayerParent();
        Integer r1 = null;
        boolean r2 = true;
        if (r0 == null) goto L12;
        Integer r3 = Integer.valueOf(r0.getHeight());
        if (r3.intValue() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L12;
    L17:
        r1 = r3;
    L18:
        if (r1 == null) goto L21;
        return r1.intValue();
    L21:
        return s1.w();
    L7:
        r4 = false;
    L12:
        r3 = Integer.valueOf(((Widget) this).containerView.getHeight());
        if (r3.intValue() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void x8() {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.x8();
        return;
    }

    public final int xq() {
        View r0 = hs0.a.b.getCurrentLivePlayerParent();
        Integer r1 = null;
        boolean r2 = true;
        if (r0 == null) goto L12;
        Integer r3 = Integer.valueOf(r0.getWidth());
        if (r3.intValue() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L12;
    L17:
        r1 = r3;
    L18:
        if (r1 == null) goto L21;
        return r1.intValue();
    L21:
        return s1.y();
    L7:
        r4 = false;
    L12:
        r3 = Integer.valueOf(((Widget) this).containerView.getWidth());
        if (r3.intValue() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        goto L17
    }

    public final List<Integer> yq() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        ArrayList r1 = null;
        if (r0 == null) goto L7;
        n r2 = r0.isRoomVisible();
        if (r2 == null) goto L7;
        Boolean r3 = (Boolean) r2.getValue();
    L9:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L19;
        j r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 == null) goto L19;
        return r6.c;
    L19:
        if (MultiLinkLoadWidgetUtils.a() == false) goto L35;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L23;
        IRoom r8 = a0.o(r7);
    L24:
        Lazy r9 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r10 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", r8, false, 4, null);
        if (r10 == null) goto L35;
        LinkerBaseInfo r11 = r10.linkerBaseInfo;
        if (r11 == null) goto L35;
        List<Long> r12 = r11.getPlayModes();
        if (r12 == null) goto L35;
        List<Long> r13 = r12;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L32:
        if (r15.hasNext() == false) goto L34;
        r14.add(Integer.valueOf((int) ((Number) r15.next()).longValue()));
        goto L32
    L34:
        return r14;
    L23:
        r8 = null;
    L35:
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L38;
        IRoom r17 = a0.o(r16);
    L39:
        if (r17 == null) goto L43;
        z5 r18 = r17.getLinkerDetail();
        if (r18 == null) goto L43;
        List r19 = r18.getPlayModes();
    L44:
        if (r19 == null) goto L49;
        List r20 = r19;
        r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r21 = r20.iterator();
    L47:
        if (r21.hasNext() == false) goto L49;
        r1.add(Integer.valueOf((int) ((Number) r21.next()).longValue()));
    L49:
        return r1;
    L43:
        r19 = null;
        goto L44
    L38:
        r17 = null;
    L7:
        r3 = null;
        goto L9
    }

    public final int zq() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        IRoom r1 = null;
        if (r0 == null) goto L7;
        n r2 = r0.isRoomVisible();
        if (r2 == null) goto L7;
        Boolean r3 = (Boolean) r2.getValue();
    L9:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L20;
        j r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r4 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 == null) goto L20;
        int r7 = r6.b;
        if (r7 <= 0) goto L20;
        return r7;
    L20:
        if (MultiLinkLoadWidgetUtils.a() == false) goto L32;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L24;
        IRoom r9 = a0.o(r8);
    L25:
        Lazy r10 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r11 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", r9, false, 4, null);
        if (r11 == null) goto L32;
        LinkerBaseInfo r12 = r11.linkerBaseInfo;
        if (r12 == null) goto L32;
        int r13 = r12.getUiLayout();
        if (r13 <= 0) goto L32;
        return r13;
    L24:
        r9 = null;
    L32:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L35;
        r1 = a0.o(r14);
    L35:
        if (r1 == null) goto L39;
        z5 r15 = r1.getLinkerDetail();
        if (r15 == null) goto L39;
        return r15.getUiLayout();
    L39:
        return 0;
    L7:
        r3 = null;
        goto L9
    }

    public MultiLinkUIWidget() {
        this.b = new ArrayList();
        this.f = BehaviorSubject.createDefault(new m());
        this.g = new CompositeDisposable();
    }

    public final int Aq() {
        if (FoldScreenUtils.e() == false) goto L5;
    L8:
        int r0 = 256;
    L9:
        ra1 r1 = ra1.a;
        MultiLinkMatchScreenConfig r2 = (MultiLinkMatchScreenConfig) r1.getValue();
        if (r2 != null) goto L12;
        return r0;
    L12:
        if (r2.enable != true) goto L39;
        pn0.f r4 = null;
        if (r.j(null, 0, 7) == false) goto L21;
        l r3 = this.d;
        if (r3 == null) goto L26;
        m r6 = this.e;
        if (r6 == null) goto L20;
        r4 = r6.d;
    L20:
        r4 = r3.vn(1, r4);
    L26:
        int[] r5 = new int[2];
        l r7 = this.d;
        if (r7 == null) goto L31;
        RecyclerView r8 = r7.getRecyclerView();
        if (r8 == null) goto L31;
        r8.getLocationInWindow(r5);
    L31:
        if (r4 == null) goto L40;
        MultiLinkMatchScreenConfig r9 = (MultiLinkMatchScreenConfig) r1.getValue();
        if (r9 == null) goto L35;
        int r10 = r9.rightMargin;
    L37:
        return r10 + ((int) s1.G((s1.y() - ((Number) r4.getFirst()).intValue()) - r5[0]));
    L35:
        r10 = 12;
        goto L37
    L40:
        return r0;
    L21:
        l r11 = this.d;
        if (r11 == null) goto L26;
        ug0.a r12 = r11.getRvLayoutManager();
        if (r12 == null) goto L26;
        r4 = r12.c(1);
        goto L26
    L39:
        return r0;
    L5:
        if (PadConfigUtils.c() == true) goto L8;
        r0 = 128;
        goto L9
    }

    public final void Gq() {
        long r0 = System.currentTimeMillis() - this.l;
        if (r0 <= 2000) goto L14;
        int r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (MultiLinkLoadWidgetUtils.g() == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L15;
        MultiLinkLoadWidgetUtils.n(r3, "FallBackLogHelper#logWrdsPreloadDuration", "gapTime=" + r0);
        LiveTracingMonitor.a("FallBackLogHelper", new Throwable("FallBackLogHelper"), "FallBackLogHelper#gapTime=" + r0);
        return;
    L15:
        return;
    L7:
        if (vm2.h.W().wrdsPreloadDurationLog() == false) goto L9;
        r4 = true;
        goto L10
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        Lazy r0 = MultiLinkWRDSPreloadManager.i;
        MultiLinkWRDSPreloadManager r1 = MultiLinkWRDSPreloadManager.a.a();
        DataCenter r2 = ((Widget) this).dataCenter;
        long r3 = 0;
        if (r2 == null) goto L7;
        IRoom r4 = a0.o(r2);
        if (r4 == null) goto L7;
        long r5 = r4.getId();
    L8:
        r1.removeRoomLinkMicSyncDataBizListener("inner_feed", r5, this);
        MultiLinkWRDSPreloadManager r6 = MultiLinkWRDSPreloadManager.a.a();
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L13;
        IRoom r8 = a0.o(r7);
        if (r8 == null) goto L13;
        r3 = r8.getId();
    L13:
        r6.removeLinkMicMsgBizListener("inner_feed", r3, this);
        int r9 = e.a;
        DataCenter r10 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        r10.put("data_multi_link_ui_service", null);
        this.g.clear();
        Disposable r11 = this.j;
        if (r11 == null) goto L16;
        r11.dispose();
    L16:
        Disposable r12 = this.k;
        if (r12 == null) goto L19;
        r12.dispose();
    L19:
        ((Widget) this).dataCenter.removeObserver("cmd_multi_enter_room_remove_view_mock", this);
        ((Widget) this).dataCenter.removeObserver("cmd_multi_enter_room_lynx_micseat_remove_view_mock", this);
        if (MultiLinkLoadWidgetUtils.e() == false) goto L25;
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L25;
        r13.removeObserver("data_on_page_selected", this);
    L25:
        if (MultiLinkLoadWidgetUtils.d() == false) goto L30;
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L31;
        r14.put("data_multi_link_log_enter", null);
        return;
    L31:
        return;
    L30:
        return;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final m getCurrentLayoutConfig() {
        return this.e;
    }

    @Override // xg0.a
    public final DataCenter getDataCenter() {
        return ((Widget) this).dataCenter;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final Long getEnterRoomTime() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final ConstraintLayout getSingleSurfaceViewContainer() {
        return this.m;
    }

    @Override // vg0.a
    public final void E5(ch0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.E5(r2);
        return;
    }

    public final void Fq(String r21) {
        Intrinsics.checkNotNullParameter(r21, "source");
        if (je0.d.E(((Widget) this).dataCenter) == true) goto L146;
        Jq("MultiLinkUIWidget#logEnterRoomLog", hashCode(), "source=".concat(r21));
        LinkedHashMap r2 = new LinkedHashMap();
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L7;
        IRoom r4 = a0.o(r3);
    L8:
        if (r4 == null) goto L10;
        Long r5 = Long.valueOf(r4.getId());
    L11:
        r2.put("room_id", String.valueOf(r5));
        if (r4 == null) goto L14;
        String r6 = r4.getAnchorId();
    L15:
        r2.put("anchor_id", String.valueOf(r6));
        if (r4 == null) goto L18;
        LiveMode r7 = r4.getStreamType();
    L19:
        int r8 = h1.a;
        r2.put("live_type", i1.a(r7));
        List<Integer> r9 = yq();
        if (r9 == null) goto L23;
        r2.put("play_mode", u0.e(r9));
    L23:
        if (r4 != null) goto L25;
    L77:
        r2.put("live_type", "video_live");
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L80;
        IRoom r11 = a0.o(r10);
    L81:
        if (r11 == null) goto L85;
        z5 r12 = r11.getLinkerDetail();
        if (r12 == null) goto L85;
        r2.put("enlarge_open_from", String.valueOf(r12.getEnlargeGuestTurnOnSource()));
    L85:
        int r13 = getCurrentScene();
        int r14 = zq();
        i0 r15 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.y0(r2, false);
        String r16 = TalkRoomLogUtils.p(Integer.valueOf(r13), Integer.valueOf(r14), null);
        if (r16 == null) goto L88;
        r2.put("function_type", r16);
    L88:
        if (r16 == null) goto L91;
        r2.put("function_type2", r16);
    L91:
        if (r13 != 8) goto L96;
        if (r14 != 7) goto L96;
        r2.put("function_type", "new_audience");
        r2.put("function_type2", "new_audience");
    L96:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L99;
        r2.put("function_type2", "new_audience");
    L99:
        if (us1.e.a == false) goto L101;
        r2.put("is_from_audience", "0");
    L101:
        TalkRoomLogUtils.V0(r2);
        TalkRoomLogUtils.Q0(r2);
        if (r11 == null) goto L108;
        ICircleInfo r17 = r11.getCircleInfo();
        if (r17 == null) goto L108;
        String r18 = r17.getCircleName();
        if (r18 == null) goto L108;
        r2.put("circle_name", r18);
    L108:
        TalkRoomLogUtils.w0(r2);
        TalkRoomLogUtils.d1(r2, ((Widget) this).dataCenter);
        TalkRoomLogUtils.T0(r2, true);
        t r19 = j0.l().c(x.class);
        if (r19.getMap().get("enter_method") != null) goto L111;
    L113:
        if (r11 == null) goto L115;
        List r20 = r11.getRoomStamps();
    L117:
        if (ListUtils.isEmpty(r20) == true) goto L123;
        if (r11 == null) goto L123;
        List r22 = r11.getRoomStamps();
        if (r22 == null) goto L123;
        RoomStampInfo r23 = (RoomStampInfo) ListProtector.get(r22, 0);
    L124:
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r2, r23);
        TalkRoomLogUtils.O0(r2);
        if ((r19 instanceof t) == false) goto L139;
        t r24 = r19;
        String r25 = r24.getRoomTag();
        if (r25 == null) goto L139;
        if (r25.length() <= 0) goto L131;
        boolean r26 = true;
    L133:
        if (r26 != true) goto L139;
        String r27 = r24.getRoomTag();
        if (r27 != null) goto L137;
        String r110 = "";
    L138:
        r2.put("room_tag", r110);
        goto L139
    L137:
        r110 = r27;
        goto L138
    L131:
        r26 = false;
    L139:
        r2.put("ui_widget_source", r21);
        j0.l().sendLog("livesdk_audience_voice_room_show", r2, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        int r28 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.c(((Widget) this).dataCenter, (String) r2.get("function_type2"), "MultiLinkUIWidget#".concat(r21));
    L141:
        if (MultiLinkLoadWidgetUtils.d() == false) goto L147;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L148;
        r1.put("data_multi_link_log_enter", Boolean.TRUE);
        return;
    L148:
        return;
    L147:
        return;
    L123:
        r23 = null;
        goto L124
    L115:
        r20 = null;
        goto L117
    L111:
        if ("convenient_match_ktv".equals(r19.getMap().get("enter_method")) == false) goto L113;
        r2.put("play_mode", "[ktv]");
        goto L113
    L80:
        r11 = null;
        goto L81
    L25:
        if (r4.isLiveTypeAudio() != true) goto L77;
        int r29 = getCurrentScene();
        int r30 = zq();
        Jq("MultiLinkUIWidget#logAudienceChatRoomShow", hashCode(), "scene = " + r29 + ", uiLayout = " + r30);
        String r31 = TalkRoomLogUtils.p(Integer.valueOf(r29), Integer.valueOf(r30), null);
        i0 r32 = TalkRoomLogUtils.a;
        if (r31 == null) goto L29;
        r2.put("function_type", r31);
    L29:
        if (r31 == null) goto L31;
        r2.put("function_type2", r31);
    L31:
        TalkRoomLogUtils.y0(r2, false);
        TalkRoomLogUtils.Q0(r2);
        if (((Boolean) ((Widget) this).dataCenter.get("data_enter_room_is_quick_invite", Boolean.FALSE)).booleanValue() == false) goto L34;
        String r33 = "1";
    L35:
        r2.put("is_quick_invite", r33);
        TalkRoomLogUtils.T0(r2, true);
        t r34 = j0.l().c(x.class);
        if ((r34 instanceof t) == false) goto L50;
        t r35 = r34;
        String r36 = r35.getRoomTag();
        if (r36 == null) goto L50;
        if (r36.length() <= 0) goto L42;
        boolean r37 = true;
    L44:
        if (r37 != true) goto L50;
        String r38 = r35.getRoomTag();
        if (r38 != null) goto L48;
        String r111 = "";
    L49:
        r2.put("room_tag", r111);
        goto L50
    L48:
        r111 = r38;
        goto L49
    L42:
        r37 = false;
    L50:
        IRoom r39 = je0.d.e(null);
        String r40 = "avatar";
        if (r39 == null) goto L69;
        z5 r41 = r39.getLinkerDetail();
        if (r41 == null) goto L69;
        List r42 = r41.getPlayModes();
        if (r42 == null) goto L69;
        if (r42.contains(Long.valueOf(19)) != true) goto L69;
        IRoom r43 = je0.d.e(null);
        if (r43 == null) goto L67;
        z5 r44 = r43.getLinkerDetail();
        if (r44 == null) goto L67;
        List r45 = r44.getFeatureList();
        if (r45 == null) goto L67;
        if (r45.contains(1L) != true) goto L67;
        Object r46 = "avatar";
    L68:
        r2.put("play_layout", r46);
    L67:
        r46 = "classic";
    L69:
        r2.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        List<Integer> r47 = yq();
        if (r47 == null) goto L73;
        r2.put("play_mode", u0.e(r47));
    L73:
        if (r30 == 28) goto L76;
        r40 = "classic";
    L76:
        r2.put("play_layout", r40);
        r2.put("ui_widget_source", r21);
        j0.l().sendLog("livesdk_audience_voice_room_show", r2, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        int r48 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.c(((Widget) this).dataCenter, (String) r2.get("function_type2"), "MultiLinkUIWidget#".concat(r21));
        goto L141
    L34:
        r33 = "0";
        goto L35
    L18:
        r7 = null;
        goto L19
    L14:
        r6 = null;
        goto L15
    L10:
        r5 = null;
        goto L11
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void K1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.K1(r2);
        return;
    }

    public final void Kq(List<? extends tf0.e> r10) {
        Intrinsics.checkNotNullParameter(r10, "list");
        if (je0.d.E(((Widget) this).dataCenter) == true) goto L108;
        MiddlewareRoomContext r0 = o3.c(((Widget) this).dataCenter);
        if (r0 == null) goto L9;
        n r1 = r0.isRoomVisible();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
    L11:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == true) goto L13;
        return;
    L13:
        if (MultiLinkLoadWidgetUtils.h() == true) goto L15;
        return;
    L15:
        if (Eq() == false) goto L51;
        m r3 = this.e;
        if (r3 == null) goto L19;
        Integer r4 = Integer.valueOf(r3.getUiLayout());
    L20:
        int r6 = c1.a;
        m r7 = this.e;
        if (r7 == null) goto L23;
        Integer r8 = Integer.valueOf(r7.m());
    L25:
        if (c1.a(r8, r4) == false) goto L31;
        if (r10.size() < 2) goto L29;
        Lq(this, Aq(), 2);
        return;
    L29:
        Lq(this, 0, 3);
        return;
    L31:
        if (f.e(null, r4) == false) goto L33;
    L50:
        Lq(this, Aq(), 2);
        return;
    L33:
        if (f.m(null, r4) == true) goto L50;
        if (f.g(null, r4) == true) goto L50;
        if (f.c(null, r4) == false) goto L47;
        int r5 = Aq();
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L42;
        Lq(this, r5, 2);
        return;
    L42:
        if (r10.size() <= 1) goto L44;
        Lq(this, r5, 2);
        return;
    L44:
        Lq(this, 0, 3);
        return;
    L47:
        if (f.h(null, r4) == false) goto L49;
        Lq(this, Aq(), 2);
        return;
    L49:
        Lq(this, 0, 3);
        return;
    L23:
        r8 = null;
        goto L25
    L19:
        r4 = null;
        goto L20
    L51:
        m r9 = this.e;
        if (r9 == null) goto L54;
        Integer r11 = Integer.valueOf(r9.getUiLayout());
    L55:
        int r12 = c1.a;
        m r13 = this.e;
        if (r13 == null) goto L58;
        Integer r14 = Integer.valueOf(r13.m());
    L59:
        int r15 = 128;
        if (c1.a(r14, r11) == false) goto L66;
        if (r10.size() < 2) goto L64;
        Lq(this, 128, 2);
        return;
    L64:
        Lq(this, 0, 3);
        return;
    L66:
        if (f.e(null, r11) == false) goto L74;
        if (FoldScreenUtils.e() == false) goto L70;
    L71:
        r15 = 256;
    L72:
        Lq(this, r15, 2);
        return;
    L70:
        if (PadConfigUtils.c() == false) goto L72;
    L74:
        if (f.c(null, r11) == false) goto L88;
        if (FoldScreenUtils.e() == false) goto L78;
    L79:
        r15 = 256;
    L81:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L83;
        Lq(this, r15, 2);
        return;
    L83:
        if (r10.size() <= 1) goto L85;
        Lq(this, r15, 2);
        return;
    L85:
        Lq(this, 0, 3);
        return;
    L78:
        if (PadConfigUtils.c() == false) goto L81;
    L88:
        if (f.b(r11) == false) goto L96;
        if (FoldScreenUtils.e() == false) goto L92;
    L93:
        r15 = 256;
    L94:
        Lq(this, r15, 2);
        return;
    L92:
        if (PadConfigUtils.c() == false) goto L94;
    L96:
        if (f.h(null, r11) == false) goto L98;
    L106:
        Lq(this, Aq(), 2);
        return;
    L98:
        if (f.i(null, r11) == true) goto L106;
        if (r11 != null) goto L103;
    L105:
        Lq(this, 0, 3);
        return;
    L103:
        if (r11.intValue() != 30) goto L105;
        Lq(this, Aq(), 2);
        return;
    L58:
        r14 = null;
        goto L59
    L54:
        r11 = null;
    L9:
        r2 = null;
        goto L11
    }

    @Override // vg0.a
    public final void N0(w8 r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiMessage");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.N0(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void O7(List<? extends tf0.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.O7(r2);
        return;
    }

    @Override // hg0.a
    public final ig0.b P6(int r2) {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.P6(r2);
    }

    @Override // vg0.a
    public final void Q3(MultiLinkSpecialViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.Q3(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final int S0(String r2) {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.S0(r2);
    }

    @Override // vg0.a
    public final void V3(MultiLinkPreOnlineViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.V3(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Xl(com.bytedance.android.live.liveinteract.plantform.datamerge.a r2) {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.Xl(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Ye(View r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.Ye(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void a6(tf0.o.a r2) {
        Intrinsics.checkNotNullParameter(r2, "_callBack");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.a6(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void b7(@SupportUpdatePlayMode int r2) {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.b7(r2);
        return;
    }

    @Override // vg0.a
    public final void d2(MultiLinkNormalEmptyViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.d2(r2);
        return;
    }

    @Override // vg0.a
    public final void e4(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.e4(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void le(SurfaceView r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.le(r2);
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        Intrinsics.checkNotNullParameter(r5, "value");
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-2111884430)) goto L24;
        if (r1 == (-784823845)) goto L21;
        if (r1 == 1618369504) goto L10;
        return;
    L10:
        if (r0.equals("data_on_page_selected") == false) goto L31;
        Object r6 = r5.getData();
        if ((r6 instanceof Boolean) == true) goto L14;
        r6 = null;
    L14:
        Boolean r7 = (Boolean) r6;
        if (r7 == null) goto L17;
        boolean r8 = r7.booleanValue();
    L18:
        if (r8 == false) goto L32;
        Fq("preload_enter_page_select");
        return;
    L32:
        return;
    L17:
        r8 = false;
        goto L18
    L31:
        return;
    L21:
        if (r0.equals("cmd_multi_enter_room_remove_view_mock") == false) goto L34;
    L25:
        Jq("MultiLinkUIWidget#onChanged", hashCode(), "收到消息" + r5.getKey() + "，恢复seatWindowView显示");
        l r9 = this.d;
        if (r9 == null) goto L36;
        ViewGroup r10 = r9.td();
        if (r10 == null) goto L37;
        UtilityKotlinExtentionsKt.x(r10);
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    L24:
        if (r0.equals("cmd_multi_enter_room_lynx_micseat_remove_view_mock") == true) goto L25;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void pd(View r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.pd(r2);
        return;
    }

    @Override // hg0.a
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g ph(int r2) {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ph(r2);
    }

    public final void receiveMsg(o0 r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if ((r4 instanceof xe) == true) goto L5;
        r4 = null;
    L5:
        xe r5 = (xe) r4;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.getMType() != 4) goto L25;
        Room r6 = je0.d.e(((Widget) this).dataCenter);
        Lazy r0 = MultiLinkWRDSPreloadManager.i;
        MultiLinkWRDSPreloadManager.a.a().removeRoomLinkMicSyncData("inner_feed", je0.d.e(((Widget) this).dataCenter));
        if (r6 == null) goto L14;
        Map r1 = r6.getLinkMap();
        if (r1 == null) goto L14;
        r1.remove(String.valueOf(5));
        r1.remove(String.valueOf(8));
        r1.remove(String.valueOf(12));
        Long r2 = (Long) r1.remove(String.valueOf(16));
    L14:
        if (r6 == null) goto L18;
        z5 r7 = r6.getLinkerDetail();
        if (r7 == null) goto L18;
        r7.setUiLayout(0);
    L18:
        h70.b r8 = getComponentContext();
        if (r8 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r9 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.a(r8);
        if (r9 == null) goto L27;
        r9.Uj(this);
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void receiveWrds(RoomLinkMicSyncData r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r1 = ((Widget) this).dataCenter;
        o r2 = z51.a.h(r1, 2);
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L9;
        long r5 = r4.getId();
    L10:
        MultiSceneEnterRoomStatisticsUtils r6 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, Long.valueOf(r5));
        if (r6 == null) goto L13;
        r6.recordSubElementShow("bytelink_data_receive", System.currentTimeMillis());
    L13:
        Gq();
        LinkerBaseInfo r7 = r9.linkerBaseInfo;
        int r8 = 0;
        if (r7 == null) goto L16;
        int r10 = r7.getScene();
    L17:
        LinkerBaseInfo r11 = r9.linkerBaseInfo;
        if (r11 == null) goto L20;
        r8 = r11.getUiLayout();
    L20:
        LinkerBaseInfo r12 = r9.linkerBaseInfo;
        Integer r13 = null;
        if (r12 == null) goto L23;
        List<Long> r14 = r12.getPlayModes();
    L24:
        List r15 = r9.mLinkUsers;
        if (r15 == null) goto L27;
        r13 = Integer.valueOf(r15.size());
    L27:
        ClientUIInfo r16 = r9.clientUIInfo;
        zj0.c.C0300c r17 = new zj0.c.C0300c(r10, r8);
        Jq("MultiLinkUIWidget#receiveWrds#", hashCode(), "wrds scene = " + r10 + ", uiLayout = " + r8);
        Iq(r10, r8);
        Mq(r17, r14, r13, r16);
        return;
    L23:
        r14 = null;
        goto L24
    L16:
        r10 = 0;
    L9:
        r5 = 0;
        goto L10
    }

    @Override // vg0.a
    public final void w0(boolean r2) {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.w0(r2);
        return;
    }

    @Override // vg0.a
    public final void w1(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.w1(r2);
        return;
    }

    public final Pair<Integer, Integer> Cq(int r3, int r4) {
        int r0 = ug0.b.a;
        m r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.m();
    L6:
        m r5 = this.e;
        if (r5 == null) goto L9;
        int r6 = r5.getUiLayout();
    L11:
        return ug0.b.b(r2, r6, r3, r4);
    L9:
        r6 = 0;
        goto L11
    L5:
        r2 = 1;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Ha(m r2, boolean r3) {
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.Ha(r2, r3);
        return;
    }

    public final void Iq(int r14, int r15) {
        nh0.f r16 = new nh0.f("linkmic", new nh0.e(r14, r15, null, 0, 0, null, null, null, 252), null, null, null, null, false, 224);
        int r17 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r18 = ((Widget) this).dataCenter;
        o r0 = z51.a.h(r18, 2);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        long r3 = r2.getId();
    L10:
        MultiSceneEnterRoomStatisticsUtils r19 = MultiSceneEnterRoomStatisticsUtils.a.a(r18, Long.valueOf(r3));
        if (r19 == null) goto L13;
        r19.c();
    L13:
        System.currentTimeMillis();
        DataCenter r110 = ((Widget) this).dataCenter;
        if (r110 == null) goto L17;
        r110.put("data_multi_lick_dynamic_event_change", r16);
        return;
    L17:
        return;
    L9:
        r3 = 0;
        goto L10
    }

    @Override // vg0.a
    public final void K3(MultiLinkNormalEmptyViewBinder.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.K3(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final Pair<Integer, Integer> Yl(int r2, pn0.f r3) {
        l r0 = this.d;
        if (r0 == null) goto L7;
        Pair<Integer, Integer> r4 = r0.Yl(r2, r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new Pair(0, 0);
    }

    @Override // hg0.a
    public final View Za(int r2, int r3) {
        l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Za(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void m3(MultiLinkGuestViewBinder.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.m3(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final Pair<Integer, Integer> vn(int r2, pn0.f r3) {
        l r0 = this.d;
        if (r0 == null) goto L7;
        Pair<Integer, Integer> r4 = r0.vn(r2, r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new Pair(0, 0);
    }

    public static void Lq(MultiLinkUIWidget r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r3 = 12;
    L6:
        if (r2.n == r3) goto L12;
        DataCenter r5 = ((Widget) r2).dataCenter;
        if (r5 == null) goto L10;
        r5.put("data_common_talk_room_match_screen", Integer.valueOf(r3));
    L10:
        r2.n = r3;
        return;
    }

    public final void Jq(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "subTag");
        Intrinsics.checkNotNullParameter(r5, "content");
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, r3 + '#' + r4, r5);
    }

    public final void Nq(m r3, int r4, int r5) {
        int r0 = ug0.b.a;
        Pair r6 = ug0.b.b(r3.m(), r3.getUiLayout(), r4, r5);
        Triple r7 = new Triple(r6.getFirst(), r6.getSecond(), "MultiLinkUIWidget#initLayoutConfigResultIfNeed");
        ln0.a r8 = yg0.h.a;
        r3.d = yg0.h.a(r3, r7, new Pair(0, 0));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Pj(String r2, View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.Pj(r2, r3, r4);
        return;
    }

    public final void Pq(m r16, int r17, int r18) {
        Intrinsics.checkNotNullParameter(r16, "config");
        if (this.c == false) goto L5;
    L24:
        l r0 = this.d;
        if (r0 == null) goto L28;
        r0.Yd(r16, r17, r18);
        return;
    L28:
        return;
    L5:
        if (this.e == null) goto L23;
        Object r1 = this.d;
        if ((r1 instanceof View) == true) goto L10;
        r1 = null;
    L10:
        View r2 = (View) r1;
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r2);
    L13:
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r3 = Bq();
        if ((r3 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.d) == true) goto L16;
        r3 = null;
    L16:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r11 = (com.bytedance.android.live.liveinteract.plantform.datamerge.d) r3;
        l r4 = this.d;
        if (r4 == null) goto L23;
        com.bytedance.live.datacontext.m r5 = com.bytedance.android.live.liveinteract.api.utils.m.n(((Widget) this).dataCenter, null, 2).getRoom();
        if (r5 == null) goto L21;
        IRoom r6 = (IRoom) r5.getValue();
    L22:
        DataCenter r7 = ((Widget) this).dataCenter;
        m r8 = this.e;
        Intrinsics.checkNotNull(r8);
        l.a.b(r4, r6, r7, r8, null, this, null, r17, r18, 0, null, r11, 768);
        goto L23
    L21:
        r6 = null;
    L23:
        this.c = true;
        goto L24
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Sp(m r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfig");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.Sp(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void U3(m r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfig");
        if (MultiLinkLoadWidgetUtils.h() == false) goto L5;
        this.e = r2;
    L5:
        l r0 = this.d;
        if (r0 == null) goto L9;
        r0.U3(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Yd(m r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        if (MultiLinkLoadWidgetUtils.h() == false) goto L5;
        this.e = r2;
    L5:
        l r0 = this.d;
        if (r0 == null) goto L9;
        r0.Yd(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void zk(String r2, View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.zk(r2, r3, r4);
        return;
    }

    public final void Mq(zj0.c r25, List<Long> r26, Integer r27, ClientUIInfo r28) {
        Intrinsics.checkNotNullParameter(r25, "switchType");
        ln0.a r0 = yg0.h.a;
        Pair r1 = yg0.h.c(r25);
        int r6 = ((Number) r1.getFirst()).intValue();
        int r10 = ((Number) r1.getSecond()).intValue();
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L14;
        o r2 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r2 == null) goto L7;
        Boolean r3 = r2.isAnchor();
    L9:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L14;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L19;
        boolean r13 = false;
    L20:
        long r14 = System.currentTimeMillis();
        tf0.m r4 = b0.b();
        if ((r4 instanceof u) == true) goto L23;
        r4 = null;
    L23:
        u r5 = (u) r4;
        if (r5 == null) goto L26;
        r5.d = r14;
    L26:
        if (r5 == null) goto L28;
        r5.a = false;
    L28:
        int r11 = yg0.h.h(false, 0, r10);
        if (r27 == null) goto L31;
        int r7 = r27.intValue();
    L32:
        boolean r8 = gh0.a.d();
        Triple r12 = new Triple(0, 0, "VideoTalkLayoutSwitcher#trySwitchLayout, with switchType = " + r25);
        if (r28 == null) goto L35;
        List r18 = r28.getUiFeatureList();
    L36:
        yg0.h.k(new h(r10, r11, null, r13, r7, r8, null, r12, r18, null, ((Widget) this).dataCenter, 580), new b(this, r14, r25, r5, r6, r26), null);
        return;
    L35:
        r18 = null;
        goto L36
    L31:
        r7 = 0;
    L19:
        r13 = true;
        goto L20
    L7:
        r3 = null;
    L14:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L19;
        Boolean r15 = (Boolean) r9.get("status_bar_is_visible", Boolean.TRUE);
        if (r15 == null) goto L19;
        r13 = r15.booleanValue();
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void hi(String r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        l r6 = this.d;
        if (r6 == null) goto L6;
        r6.hi(r2, true, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Sm(IRoom r14, DataCenter r15, m r16, BaseEqualGridItemDecoration r17, vg0.a r18, SeatAnimEngineWrapper r19, int r20, int r21, int r22, se0.c r23, com.bytedance.android.live.liveinteract.plantform.datamerge.d r24) {
        Intrinsics.checkNotNullParameter(r16, "config");
        if (MultiLinkLoadWidgetUtils.h() == false) goto L5;
        this.e = r16;
    L5:
        l r1 = this.d;
        if (r1 == null) goto L9;
        r1.Sm(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    }
}
