package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.l2;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkbase.SupportUpdatePlayMode;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.MultiLinkThemedCompetitionBusinessLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.MultiLinkCommonItemDecoration;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.LinkRoomFightItemDecoration;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionViewManager;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.liveinteract.videotalk.ui.theme.VideoLiveThemeReporter;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.MultiLinkRevenueEnterRoomOptConfig;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdk.config.ra1;
import com.bytedance.android.livesdk.config.sp;
import com.bytedance.android.livesdk.config.vb1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.n7;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.model.y0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.MultiLinkMatchScreenConfig;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import sh0.i0;
import sh0.j0;
import sh0.v;
import sh0.w;
import sh0.x;
import uf2.d0;
import zg1.a0;
import zg1.l3;
import zg1.p2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001\rR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/BaseMultiLinkWindowManager;", "Ltf0/o;", "Lvg0/a;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lkk0/a$a;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "x", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseMultiLinkWindowManager implements tf0.o, vg0.a, LifecycleOwnerCompat, kk0.a.InterfaceC0227a, Observer<KVData> {
    public static final /* synthetic */ int H = 0;
    public final zj0.c A;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d B;
    public final DataCenter C;
    public final tf0.o.a D;
    public final LifecycleOwner E;
    public final com.bytedance.android.live.pushstream.d F;
    public final j1 G;
    public com.bytedance.android.live.ui.c a;
    public com.bytedance.android.live.liveinteract.videotalk.utils.c b;
    public FrameLayout c;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.l d;
    public final CompositeDisposable e;
    public Disposable f;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.s g;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.a h;
    public hg0.d i;
    public wg0.e j;
    public ThemedCompetitionViewManager k;
    public SeatAnimEngineWrapper l;
    public com.bytedance.android.live.ui.q m;
    public final boolean n;
    public boolean o;
    public int p;
    public final ViewGroup q;
    public final HSImageView r;
    public Pair<Integer, Integer> s;
    public Pair<Integer, Integer> t;
    public boolean u;
    public BaseEqualGridItemDecoration v;
    public final e w;
    public final Context x;
    public final ConstraintLayout y;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m z;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.ui.a {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public b(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void Ek(IVoiceLiveTheme r3) {
            Intrinsics.checkNotNullParameter(r3, "theme");
            int r4 = t0.a;
            StringBuilder r5 = new StringBuilder("[ThemePreLoad] initTheme, roomId=");
            com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r0 == null) goto L7;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L7;
            Long r2 = Long.valueOf(r1.getId());
        L8:
            r5.append(r2);
            r5.append(", BaseMultiLinkWindowManager background load onStart");
            t0.a("BaseMultiLinkWindowManager", r5.toString());
            return;
        L7:
            r2 = null;
            goto L8
        }

        public final void W9(boolean r7, IVoiceLiveTheme r8) {
            Intrinsics.checkNotNullParameter(r8, "theme");
            if (r7 == false) goto L22;
            int r9 = t0.a;
            StringBuilder r10 = new StringBuilder("[ThemePreLoad] initTheme, roomId=");
            com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r11 == null) goto L9;
            IRoom r12 = (IRoom) r11.getValue();
            if (r12 == null) goto L9;
            Long r13 = Long.valueOf(r12.getId());
        L10:
            r10.append(r13);
            r10.append(", BaseMultiLinkWindowManager background load success");
            t0.a("BaseMultiLinkWindowManager", r10.toString());
            int r14 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r15 = this.a.C;
            com.bytedance.android.livesdk.chatroom.o r16 = com.bytedance.android.live.liveinteract.api.utils.m.n(r15, null, 2);
            if (r16 == null) goto L17;
            com.bytedance.live.datacontext.m r17 = r16.getRoom();
            if (r17 == null) goto L17;
            IRoom r18 = (IRoom) r17.getValue();
            if (r18 == null) goto L17;
            long r0 = r18.getId();
        L18:
            MultiSceneEnterRoomStatisticsUtils r1 = MultiSceneEnterRoomStatisticsUtils.a.a(r15, Long.valueOf(r0));
            if (r1 == null) goto L23;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r1, "background_Load", 0, 2, null);
            return;
        L23:
            return;
        L17:
            r0 = 0;
        L9:
            r13 = null;
            goto L10
        }
    }

    public static final class c implements com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public c(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a
        public final void a(n7 r4) {
            Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
            ALogger.d("BaseMultiLinkWindowManager", "onGiftIconFlashMessage: " + r4);
            i0 r0 = j0.e(this.a.C);
            if (r0 == null) goto L6;
            r0.d0(sh0.u.b, new v(r4));
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a
        public final int b(QuickInteractTask r7) {
            Intrinsics.checkNotNullParameter(r7, "task");
            com.bytedance.android.live.liveinteract.plantform.datamerge.a r1 = this.a.h;
            if (r1 == null) goto L5;
            int r2 = r1.f(r7.a);
        L6:
            if (r2 < 0) goto L40;
            hg0.d r3 = this.a.i;
            if (r3 == null) goto L41;
            Intrinsics.checkNotNullParameter(r7, "task");
            RecyclerView r4 = r3.a;
            Integer r5 = null;
            if (r4 == null) goto L12;
            RecyclerView.ViewHolder r6 = r4.findViewHolderForAdapterPosition(r2);
        L14:
            if ((r6 instanceof hg0.b) == false) goto L42;
            jg0.g r8 = ((hg0.b) r6).l();
            r8.getClass();
            Intrinsics.checkNotNullParameter(r7, "task");
            int r9 = r7.getType();
            if (r9 != 0) goto L18;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r10 = r8.h();
            if (r10 == null) goto L37;
            Intrinsics.checkNotNullParameter(r7, "task");
            MultiLinkMicSeatGiftIconElement r11 = r10.m;
            if (r11 == null) goto L35;
            LinkMicQuickInteractView r12 = r11.c;
            if (r12 == null) goto L33;
            r5 = Integer.valueOf(r12.getState());
        L33:
            if (r5 == null) goto L35;
            int r13 = r5.intValue();
        L36:
            r5 = Integer.valueOf(r13);
        L35:
            r13 = -1;
        L37:
            if (r5 != null) goto L39;
            return -1;
        L39:
            return r5.intValue();
        L18:
            if (r9 == 4) goto L20;
            r5 = -1;
            goto L37
        L20:
            MultiLinkThemedCompetitionBusinessLayer r14 = r8.u();
            if (r14 == null) goto L37;
            Intrinsics.checkNotNullParameter(r7, "task");
            ThemedCompetitionQuickInteractView r15 = r14.f;
            if (r15 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
        L25:
            r5 = Integer.valueOf(r15.getState());
            goto L37
        L42:
            return -1;
        L12:
            r6 = null;
            goto L14
        L41:
            return -1;
        L40:
            return -1;
        L5:
            r2 = -1;
            goto L6
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a
        public final void c(QuickInteractTask r5) {
            Intrinsics.checkNotNullParameter(r5, "task");
            ALogger.d("BaseMultiLinkWindowManager", "onReceiveInteractTask: " + r5);
            if (aj0.b.c(this.a.z.getUiLayout()) == false) goto L21;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = this.a.d;
            if (r1 == null) goto L20;
            fg0.a r2 = r1.getMultiAdapterWrapper();
            if (r2 == null) goto L25;
            RecyclerView.ViewHolder r3 = null;
            int r4 = r2.a(r5.a, null);
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.a.d;
            if (r6 == null) goto L14;
            LinkMicRecyclerView r7 = r6.getRecyclerView();
            if (r7 == null) goto L14;
            r3 = r7.findViewHolderForAdapterPosition(r4);
        L14:
            if ((r3 instanceof hg0.b) == false) goto L26;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r8 = ((hg0.b) r3).l().h();
            if (r8 == null) goto L27;
            Intrinsics.checkNotNullParameter(r5, "task");
            ALogger.d("MultiLinkGuestMicSeatBasicLayer", "onReceiveInteractTask");
            MultiLinkMicSeatGiftIconElement r0 = r8.m;
            if (r0 == null) goto L28;
            r0.a(r5);
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L20:
            return;
        L21:
            i0 r9 = j0.a(this.a.C);
            if (r9 == null) goto L30;
            r9.d0(w.b, new x(r5));
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BaseMultiLinkWindowManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public d(BaseMultiLinkWindowManager r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseMultiLinkWindowManager.T(this.a);     // Catch: Throwable -> L4
            this.a.l0(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public e(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            IVoiceLiveTheme r4 = (IVoiceLiveTheme) r3;
            if (r4 == null) goto L8;
            int r0 = t0.a;
            t0.a("BaseMultiLinkWindowManager", "[ThemePreLoad] themeObserver, changeTheme, theme=" + r4 + ", url=" + ImageUtil.getImageUrl(r4.getStaticBackground()));
            com.bytedance.android.live.ui.q r1 = this.a.m;
            if (r1 == null) goto L9;
            r1.a(r4);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BaseMultiLinkWindowManager a;
        public final /* synthetic */ IBaseUser b;
        public final /* synthetic */ IRoom c;

        public f(BaseMultiLinkWindowManager r1, IBaseUser r2, IRoom r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            IMiddlewareHostSocial r6 = jc1.k.f(IMiddlewareHostSocial.class);
            if (r6 == null) goto L6;
            r6.inviteFriendByIM(this.a.getContext(), this.b, new BaseMultiLinkWindowManager$onFastInviteButtonClick$1$1(this));
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.l a;
        public final /* synthetic */ BaseMultiLinkWindowManager b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ViewGroup r0 = this.a.td();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.getHeight();
        L6:
            if (r2 <= 0) goto L20;
            ViewGroup r3 = this.a.td();
            if (r3 == null) goto L10;
            r1 = r3.getChildCount();
        L10:
            if (r1 <= 0) goto L21;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r4 = this.b.d;
            if (r4 == null) goto L18;
            ViewGroup r5 = r4.td();
            if (r5 == null) goto L18;
            ViewTreeObserver r6 = r5.getViewTreeObserver();
            if (r6 == null) goto L18;
            r6.removeOnGlobalLayoutListener(this);
        L18:
            this.b.C.put("cmd_multi_link_micseat_render_complete", Boolean.TRUE);
            return;
        L21:
            return;
        L20:
            return;
        L5:
            r2 = 0;
            goto L6
        }

        public h(com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1, BaseMultiLinkWindowManager r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public i(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r18) {
            List<? extends tf0.e> r0 = (List) r18;
            final BaseMultiLinkWindowManager r2 = this.a;
            int r3 = BaseMultiLinkWindowManager.H;
            r2.getClass();
            ALogger.d("BaseMultiLinkWindowManager", "windowListObservable change");
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r4 = r2.d;
            if (r4 == null) goto L5;
            r4.O7(r0);
        L5:
            long r8 = 0;
            if (vm2.d.q0().isOpenSmoothViewMock() == false) goto L124;
            Iterator<T> r5 = r0.iterator();
        L9:
            if (r5.hasNext() == false) goto L30;
            T r11 = r5.next();
            tf0.e r12 = (tf0.e) r11;
            if ((r12 instanceof MultiLinkGuestViewBinder.a) == true) goto L13;
            r12 = null;
        L13:
            MultiLinkGuestViewBinder.a r13 = (MultiLinkGuestViewBinder.a) r12;
            if (r13 == null) goto L27;
            ch0.e r14 = r13.k;
            if (r14 == null) goto L27;
            ILinkPlayerInfoBridge r15 = r14.a;
            if (r15 == null) goto L27;
            String r16 = r15.getInteractId();
            if (r16 == null) goto L27;
            if (r16.length() <= 0) goto L24;
            boolean r17 = true;
        L25:
            if (r17 != true) goto L27;
            boolean r19 = true;
        L28:
            if (r19 == false) goto L9;
        L31:
            tf0.e r110 = r11;
            Lazy r6 = MultiLinkLoadWidgetUtils.a;
            DataCenter r7 = r2.C;
            StringBuilder r111 = new StringBuilder("trySmoothViewOpt, height = ");
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r112 = r2.d;
            if (r112 == null) goto L36;
            ViewGroup r113 = r112.td();
            if (r113 == null) goto L36;
            Integer r114 = Integer.valueOf(r113.getHeight());
        L37:
            r111.append(r114);
            r111.append(", vaildGuestItemData = ");
            r111.append(r110);
            MultiLinkLoadWidgetUtils.n(r7, "BaseWindowManager", r111.toString());
            if (r110 == null) goto L123;
            ALogger.d("BaseMultiLinkWindowManager", "[smoothEnterRoom] observe window draw when onOnlineListChanged");
            if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L42;
        L134:
            rj0.l.n2.getClass();
            rj0.l r9 = rj0.l.a.a();
            if (r9 == null) goto L137;
            boolean r10 = r9.isEngineOn();
        L140:
            Boolean r20 = Boolean.valueOf(r10);
        L142:
            r2.u(r20);
            r2.H0(r0);
            boolean r21 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
            if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(Integer.valueOf(r2.z.getUiLayout()), 0, 6) == false) goto L153;
            Iterator<T> r1 = r0.iterator();
        L146:
            if (r1.hasNext() == false) goto L153;
            tf0.e r22 = (tf0.e) r1.next();
            if ((r22 instanceof MultiLinkGuestViewBinder.a) == false) goto L146;
            MultiLinkFrequencyOptConfig r23 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
            MultiLinkGuestViewBinder.a r24 = (MultiLinkGuestViewBinder.a) r22;
            boolean r25 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r24.k, null);
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r26 = r2.d;
            if (r26 == null) goto L146;
            r26.m3(r24, r25);
        L153:
            if (r2.u == true) goto L178;
            ALogger.e("MultiLinkDynamicWidget", "BaseWindowManager#windowListObservable real change, send DATA_MULTI_LINK_DYNAMIC_EVENT_CHANGE, EventType_Seat");
            int r27 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r28 = r2.C;
            com.bytedance.android.livesdk.chatroom.o r29 = com.bytedance.android.live.liveinteract.api.utils.m.n(r28, null, 2);
            if (r29 == null) goto L161;
            com.bytedance.live.datacontext.m r30 = r29.getRoom();
            if (r30 == null) goto L161;
            IRoom r31 = (IRoom) r30.getValue();
            if (r31 == null) goto L161;
            r8 = r31.getId();
        L161:
            MultiSceneEnterRoomStatisticsUtils r32 = MultiSceneEnterRoomStatisticsUtils.a.a(r28, Long.valueOf(r8));
            if (r32 == null) goto L164;
            r32.c();
        L164:
            System.currentTimeMillis();
            r2.u = true;
            return;
        L178:
            return;
        L137:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r33 = IVoiceChatGuestService.a.a();
            if (r33 == null) goto L141;
            r10 = r33.isEngineOn();
            goto L140
        L141:
            r20 = null;
            goto L142
        L42:
            if (vm2.h.S().c() == false) goto L83;
            MultiLinkLoadWidgetUtils.n(r2.C, "BaseMultiLinkWindowManager", "observeWindowDrawDisablePost");
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r34 = r2.d;
            if (r34 == null) goto L48;
            ViewGroup r35 = r34.td();
            if (r35 == null) goto L48;
            int r36 = r35.getHeight();
        L49:
            if (r36 <= 0) goto L76;
            UtilityKotlinExtentionsKt.x(r2.y);
            r2.Q0();
            Disposable r37 = r2.f;
            if (r37 == null) goto L53;
            r37.dispose();
        L53:
            ALogger.d("BaseMultiLinkWindowManager", "[smoothEnterRoom] dismiss mock view cause height > 0");
            int r38 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r39 = r2.C;
            com.bytedance.android.livesdk.chatroom.o r40 = com.bytedance.android.live.liveinteract.api.utils.m.n(r39, null, 2);
            if (r40 == null) goto L60;
            com.bytedance.live.datacontext.m r41 = r40.getRoom();
            if (r41 == null) goto L60;
            IRoom r42 = (IRoom) r41.getValue();
            if (r42 == null) goto L60;
            long r115 = r42.getId();
        L61:
            MultiSceneEnterRoomStatisticsUtils r116 = MultiSceneEnterRoomStatisticsUtils.a.a(r39, Long.valueOf(r115));
            if (r116 == null) goto L64;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r116, "guest_seat_load", 0, 2, null);
        L64:
            DataCenter r43 = r2.C;
            com.bytedance.android.livesdk.chatroom.o r44 = com.bytedance.android.live.liveinteract.api.utils.m.n(r43, null, 2);
            if (r44 == null) goto L71;
            com.bytedance.live.datacontext.m r45 = r44.getRoom();
            if (r45 == null) goto L71;
            IRoom r46 = (IRoom) r45.getValue();
            if (r46 == null) goto L71;
            long r117 = r46.getId();
        L72:
            MultiSceneEnterRoomStatisticsUtils r47 = MultiSceneEnterRoomStatisticsUtils.a.a(r43, Long.valueOf(r117));
            if (r47 == null) goto L75;
            r47.c();
        L75:
            System.currentTimeMillis();
        L71:
            r117 = 0;
        L60:
            r115 = 0;
            goto L61
        L76:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r48 = r2.d;
            if (r48 == null) goto L134;
            ViewGroup r49 = r48.td();
            if (r49 == null) goto L134;
            ViewTreeObserver r50 = r49.getViewTreeObserver();
            if (r50 == null) goto L134;
            r50.addOnGlobalLayoutListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.c(r2));
        L48:
            r36 = 0;
            goto L49
        L83:
            MultiLinkLoadWidgetUtils.n(r2.C, "BaseMultiLinkWindowManager", "observeWindowDraw");
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r51 = r2.d;
            if (r51 == null) goto L88;
            ViewGroup r52 = r51.td();
            if (r52 == null) goto L88;
            int r53 = r52.getHeight();
        L89:
            if (r53 <= 0) goto L116;
            UtilityKotlinExtentionsKt.x(r2.y);
            r2.Q0();
            Disposable r54 = r2.f;
            if (r54 == null) goto L93;
            r54.dispose();
        L93:
            ALogger.d("BaseMultiLinkWindowManager", "[smoothEnterRoom] dismiss mock view cause height > 0");
            int r55 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r56 = r2.C;
            com.bytedance.android.livesdk.chatroom.o r57 = com.bytedance.android.live.liveinteract.api.utils.m.n(r56, null, 2);
            if (r57 == null) goto L100;
            com.bytedance.live.datacontext.m r58 = r57.getRoom();
            if (r58 == null) goto L100;
            IRoom r59 = (IRoom) r58.getValue();
            if (r59 == null) goto L100;
            long r118 = r59.getId();
        L101:
            MultiSceneEnterRoomStatisticsUtils r119 = MultiSceneEnterRoomStatisticsUtils.a.a(r56, Long.valueOf(r118));
            if (r119 == null) goto L104;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r119, "guest_seat_load", 0, 2, null);
        L104:
            DataCenter r60 = r2.C;
            com.bytedance.android.livesdk.chatroom.o r61 = com.bytedance.android.live.liveinteract.api.utils.m.n(r60, null, 2);
            if (r61 == null) goto L111;
            com.bytedance.live.datacontext.m r62 = r61.getRoom();
            if (r62 == null) goto L111;
            IRoom r63 = (IRoom) r62.getValue();
            if (r63 == null) goto L111;
            long r120 = r63.getId();
        L112:
            MultiSceneEnterRoomStatisticsUtils r65 = MultiSceneEnterRoomStatisticsUtils.a.a(r60, Long.valueOf(r120));
            if (r65 == null) goto L115;
            r65.c();
        L115:
            System.currentTimeMillis();
        L111:
            r120 = 0;
        L100:
            r118 = 0;
            goto L101
        L116:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r66 = r2.d;
            if (r66 == null) goto L134;
            ViewGroup r67 = r66.td();
            if (r67 == null) goto L134;
            ViewTreeObserver r68 = r67.getViewTreeObserver();
            if (r68 == null) goto L134;
            r68.addOnGlobalLayoutListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.b(r2));
        L88:
            r53 = 0;
            goto L89
        L123:
            ALogger.d("BaseMultiLinkWindowManager", "[smoothEnterRoom] not observe window draw cause windowList empty");
        L36:
            r114 = null;
            goto L37
        L24:
            r17 = false;
        L27:
            r19 = false;
            goto L28
        L30:
            r11 = (T) null;
            goto L31
        L124:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r69 = r2.d;
            if (r69 == null) goto L134;
            ViewGroup r70 = r69.td();
            if (r70 == null) goto L134;
            Function0<Unit> r71 = new BaseMultiLinkWindowManager$trySmoothViewOpt$1(r2);
            Intrinsics.checkNotNullParameter(r70, "$this$observeNextLayout");
            Intrinsics.checkNotNullParameter(r71, "callback");
            if (r70.getHeight() <= 0) goto L131;
            r71.invoke();
            goto L134
        L131:
            ViewTreeObserver r121 = r70.getViewTreeObserver();
            if (r121 == null) goto L134;
            r121.addOnGlobalLayoutListener(new je0.c(r70, 0, r71));
            goto L134
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public j(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            BaseMultiLinkWindowManager r4 = this.a;
            if (r4.n == false) goto L10;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r5 = r4.d;
            if (r5 == null) goto L11;
            ViewGroup r6 = r5.td();
            if (r6 == null) goto L12;
            r6.post(new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.d(this));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class k implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public k(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3) {
            Intrinsics.checkNotNullParameter(r3, "request");
            ALogger.e("BaseMultiLinkWindowManager", "reloadLinkWindowLayoutConfigByLynx, loadLayoutConfig failed, " + r3.c.a);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r5, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r6) {
            Intrinsics.checkNotNullParameter(r5, "request");
            Intrinsics.checkNotNullParameter(r6, "response");
            List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r7 = r6.a.h();
            if (r7 == null) goto L5;
            int r8 = r7.size();
        L6:
            List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r1 = r6.a.k();
            if (r1 == null) goto L9;
            int r2 = r1.size();
        L10:
            com.bytedance.android.live.liveinteract.plantform.datamerge.k r3 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r8 + r2);
            BaseMultiLinkWindowManager r9 = this.a;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4 = r6.a;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r9.z = r4;
            com.bytedance.android.live.liveinteract.plantform.datamerge.a r10 = this.a.h;
            if (r10 == null) goto L13;
            r10.w(r3, r6.a);
        L13:
            this.a.k0();
            BaseMultiLinkWindowManager r11 = this.a;
            r11.V(r11.d0(), this.a.c0(), false);
            BaseMultiLinkWindowManager r12 = this.a;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = r12.d;
            if (r0 == null) goto L16;
            r0.U3(r6.a, r12.d0(), this.a.c0());
        L16:
            ALogger.e("BaseMultiLinkWindowManager", "updateLinkWindowLayoutConfig for reloadLinkWindowLayoutConfigByLynx");
            this.a.C.put("cmd_audio_chat_stage_position_update", Boolean.TRUE);
            BaseMultiLinkWindowManager r13 = this.a;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r14 = r6.a;
            r13.getClass();
            pn0.f r15 = r14.d;
            if (r15 == null) goto L19;
            pn0.f.b r16 = r15.c;
        L20:
            if (r16 == null) goto L25;
            int r17 = r16.c;
            int r18 = r16.d;
            ALogger.d("MultiLinkEffect.Widget", "notify DATA_MULTI_LINK_SURFACE_VIEW_SIZE. " + r17 + ", " + r18 + ", config:" + r14);
            if (r17 <= 0) goto L25;
            if (r18 <= 0) goto L25;
            r13.C.put("data_multi_link_surface_view_size", TuplesKt.to(Integer.valueOf(r17), Integer.valueOf(r18)));
        L25:
            r13.C.put("cmd_link_window_layout_config_changed", r14);
            return;
        L19:
            r16 = null;
            goto L20
        L9:
            r2 = 0;
            goto L10
        L5:
            r8 = 0;
            goto L6
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseMultiLinkWindowManager b;

        public l(View r1, BaseMultiLinkWindowManager r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup r0 = UtilityKotlinExtentionsKt.p(this.a);     // Catch: Throwable -> L15
            int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
            if (r1 < 29) goto L6;
            if (r0 == null) goto L6;
            r0.suppressLayout(true);     // Catch: Throwable -> L15
        L6:
            if (r0 == null) goto L8;
            r0.removeView(this.a);     // Catch: Throwable -> L15
        L8:
            FrameLayout r3 = (FrameLayout) this.b.y.findViewById(2131380433);     // Catch: Throwable -> L15
            if (r3 == null) goto L18;
            r3.addView(this.a, 0);     // Catch: Throwable -> L15
            if (r1 < 29) goto L22;
            if (r0 == null) goto L23;
            r0.suppressLayout(false);     // Catch: Throwable -> L15
            return;
        L23:
            return;
        L22:
            return;
        L18:
            return;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public m(BaseMultiLinkWindowManager r1, long r2) {
            this.a = r1;
        }

        public final void a() {
            System.currentTimeMillis();
            int r0 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r1 = this.a.C;
            Integer r2 = null;
            com.bytedance.android.livesdk.chatroom.o r3 = com.bytedance.android.live.liveinteract.api.utils.m.n(r1, null, 2);
            if (r3 == null) goto L9;
            com.bytedance.live.datacontext.m r4 = r3.getRoom();
            if (r4 == null) goto L9;
            IRoom r5 = (IRoom) r4.getValue();
            if (r5 == null) goto L9;
            long r6 = r5.getId();
        L10:
            MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, Long.valueOf(r6));
            if (r7 == null) goto L13;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r7, "data_listener", 0, 2, null);
        L13:
            Lazy r8 = MultiLinkLoadWidgetUtils.a;
            DataCenter r9 = this.a.C;
            StringBuilder r10 = new StringBuilder("containerView post when start, containerHeight = ");
            r10.append(this.a.y.getHeight());
            r10.append(", SeatViewHeight = ");
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r11 = this.a.d;
            if (r11 == null) goto L18;
            ViewGroup r12 = r11.td();
            if (r12 == null) goto L18;
            r2 = Integer.valueOf(r12.getHeight());
        L18:
            r10.append(r2);
            MultiLinkLoadWidgetUtils.n(r9, "BaseWindowManager", r10.toString());
            this.a.M0();
            return;
        L9:
            r6 = 0;
            goto L10
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

    public static final class n implements Runnable {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public n(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.a.d0();     // Catch: Throwable -> L4
            int r1 = this.a.c0();     // Catch: Throwable -> L4
            this.a.V(r0, r1, false);     // Catch: Throwable -> L4
            this.a.E0(true, r0, r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class o implements Runnable {
        public final /* synthetic */ BaseMultiLinkWindowManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public o(BaseMultiLinkWindowManager r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.l0(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class p {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public p(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final int a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            return this.a.k(r2);
        }
    }

    public static final class q implements Runnable {
        public final /* synthetic */ BaseMultiLinkWindowManager a;

        public q(BaseMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseMultiLinkWindowManager r0 = this.a;     // Catch: Throwable -> L6
            int r1 = BaseMultiLinkWindowManager.H;     // Catch: Throwable -> L6
            int r2 = r0.d0();     // Catch: Throwable -> L6
            int r3 = r0.c0();     // Catch: Throwable -> L6
            r0.V(r2, r3, true);     // Catch: Throwable -> L6
            r0.E0(true, r2, r3);     // Catch: Throwable -> L6
            BaseMultiLinkWindowManager r4 = this.a;     // Catch: Throwable -> L6
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r5 = r4.d;     // Catch: Throwable -> L6
            if (r5 == null) goto L9;
            r5.U3(r4.z, r4.d0(), this.a.c0());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // tf0.o
    public /* synthetic */ FrameLayout D() {
        return null;
    }

    public int D0(List<ti6.f> r1, Map<String, Integer> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "list");
        Intrinsics.checkNotNullParameter(r2, "posMap");
        return 0;
    }

    @Override // tf0.o
    public final /* synthetic */ void F() {
    }

    public abstract void F0();

    @Override // tf0.o
    public final /* synthetic */ void G() {
    }

    @Override // tf0.o
    public /* synthetic */ List H(boolean r1) {
        return null;
    }

    public abstract void H0(List<? extends tf0.e> r1);

    public abstract void I0(List<? extends tf0.e> r1);

    @Override // tf0.o
    @Deprecated(message = "should be deprecated", replaceWith = @ReplaceWith(expression = "false", imports = {}))
    public final boolean J() {
        return false;
    }

    @Override // tf0.o
    public final /* synthetic */ void K() {
    }

    public void K3(MultiLinkNormalEmptyViewBinder.a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "itemData");
    }

    @Override // tf0.o
    public void L() {
    }

    @Override // tf0.o
    public /* synthetic */ void M(boolean r1, String r2, int r3) {
    }

    @Override // tf0.o
    public final void N() {
    }

    @Override // tf0.o
    public void O() {
        this.o = false;
    }

    public abstract void O0();

    @Override // tf0.o
    public /* synthetic */ void P() {
    }

    public void Q3(MultiLinkSpecialViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
    }

    @Override // tf0.o
    @Deprecated(message = "should be deprecated")
    public final void R() {
    }

    @Override // tf0.o
    public /* synthetic */ void S(String r1, int r2, int r3) {
    }

    public void S4() {
    }

    public void V3(MultiLinkPreOnlineViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
    }

    @Override // tf0.o
    public /* synthetic */ void a(View r1, MotionEvent r2) {
    }

    public void d2(MultiLinkNormalEmptyViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
    }

    @Override // tf0.o
    public final void exitRoom() {
    }

    @Override // tf0.o
    @Deprecated(message = "should be deprecated")
    public final void f() {
    }

    @Override // tf0.o
    public /* synthetic */ void g(d0 r1) {
    }

    public abstract zj0.d g0();

    @Override // tf0.o
    public /* synthetic */ List getHeadPointList() {
        return null;
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // tf0.o
    public /* synthetic */ RecyclerView getMicSeatRecyclerView() {
        return null;
    }

    @Override // tf0.o
    public /* synthetic */ sf0.c getTopLeftSeatFrameInfo() {
        return null;
    }

    @Override // tf0.o
    public /* synthetic */ int getUserCount() {
        return 0;
    }

    @Override // tf0.o
    @Deprecated(message = "should replace by LinkUserDataMergeCenter")
    public final void i() {
    }

    @Override // tf0.o
    public /* synthetic */ boolean isDynamicAnimating() {
        return false;
    }

    public abstract int j0();

    public abstract void k0();

    @Override // tf0.o
    @Deprecated(message = "should be deprecated, pipMode already useless.", replaceWith = @ReplaceWith(expression = "null", imports = {}))
    public final void o0() {
    }

    @Override // tf0.o
    public final void onResume() {
    }

    @Override // tf0.o
    @Deprecated(message = "replace by LinkUserDataMergeCenter")
    public final void onTalkStateUpdated(String[] r1, boolean[] r2) {
    }

    @Override // tf0.o
    public final /* synthetic */ void p() {
    }

    @Override // tf0.o
    @Deprecated(message = "should be deprecated")
    public final void s() {
    }

    @Override // tf0.o
    public /* synthetic */ void setDynamicAnimatorListener(Function0 r1) {
    }

    public abstract boolean u0();

    @Override // tf0.o
    public /* synthetic */ FrameLayout v() {
        return null;
    }

    @Override // tf0.o
    @Deprecated(message = "should be deprecated")
    public final void v3(Map<String, Long> r1) {
    }

    @Override // vg0.a
    public void w0(boolean r1) {
    }

    public void w1(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
    }

    public abstract boolean y0();

    @Override // tf0.o
    public final /* synthetic */ void z() {
    }

    @Override // tf0.o
    public /* synthetic */ void z0(boolean r1, String r2) {
    }

    public static String R0() {
        return jc1.k.n(IMiddlewareUserService.class).user().n();
    }

    @Override // tf0.o
    public final void A() {
        ALogger.i("BaseMultiLinkWindowManager", "updateCurrentLinkWindowLayoutConfig");
        W0(this.z, false);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L5;
        r0.setUIViewValid(true);
    L5:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = this.d;
        if (r1 == null) goto L9;
        r1.Sp(this.z, d0(), c0());
        return;
    }

    public boolean A0() {
        if (((Boolean) vm2.d.k2.getValue(null, vm2.d.a[164(0xa4, float:2.3E-43)])).booleanValue() == true) goto L5;
    L14:
        return true;
    L5:
        if (this.z.getUiLayout() != 7) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        int r1 = c1.a;
        if (c1.a(Integer.valueOf(this.z.m()), Integer.valueOf(this.z.getUiLayout())) == false) goto L14;
        if (this.z.e() != 1) goto L14;
    L13:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    @Override // tf0.o
    public final int C0() {
        return this.z.n();
    }

    public void J0() {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.f(Integer.valueOf(this.z.m()), Integer.valueOf(this.z.getUiLayout())) == true) goto L25;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.z;
        if (r1 == null) goto L24;
        pn0.f r2 = r1.d;
        if (r2 == null) goto L26;
        InteractionWidgetsPosContext.a r3 = InteractionWidgetsPosContext.Companion;
        InteractionWidgetsPosContext r4 = InteractionWidgetsPosContext.a.c(r3, this.C, 0, 2);
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.m r5 = r4.getVideoEqualTalkBottomPos();
        if (r5 == null) goto L14;
        pn0.f.b r6 = r2.c;
        r5.setValue(Integer.valueOf(r6.b + r6.d));
    L14:
        if (this.z.getUiLayout() != 43) goto L27;
        int r7 = 0;
        if ((!r2.d.isEmpty()) == false) goto L18;
        r7 = ((pn0.f.c) ListProtector.get(r2.d, 0)).f;
    L18:
        int r8 = s1.f(30.0f);
        InteractionWidgetsPosContext r9 = InteractionWidgetsPosContext.a.c(r3, this.C, 0, 2);
        if (r9 == null) goto L28;
        com.bytedance.live.datacontext.m r10 = r9.getVideoTalkTop2V4V4GiftHeightTrayPos();
        if (r10 == null) goto L29;
        r10.setValue(Integer.valueOf((r2.c.d - r7) + r8));
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkWindowLayoutConfig");
    }

    public final void Q0() {
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == true) goto L6;
        this.C.put("cmd_multi_enter_room_remove_view_mock", Boolean.TRUE);
        this.C.put("cmd_voice_chat_room_show_background", new p2("observeWindowDraw_immediately"));
        return;
    }

    public void T0() {
        wg0.e r0 = this.j;
        if (r0 == null) goto L15;
        r0.f.d0(sh0.m.b, null);
        i0 r1 = j0.a(r0.a);
        if (r1 == null) goto L7;
        r1.e(sh0.s.b);
    L7:
        i0 r2 = j0.a(r0.a);
        if (r2 == null) goto L10;
        r2.e(sh0.b.b);
    L10:
        i0 r3 = j0.a(r0.a);
        if (r3 == null) goto L13;
        r3.e(sh0.d.b);
    L13:
        r0.b.removeAllViews();
        r0.c.removeAllViews();
        return;
    }

    public final void Y0() {
        this.y.post(new q(this));
    }

    public BaseEqualGridItemDecoration a0() {
        if (aj0.b.c(this.z.getUiLayout()) == true) goto L7;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.z;
        int r2 = com.bytedance.android.live.liveinteract.plantform.commonwindow.n.a;
        return new MultiLinkCommonItemDecoration(r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.n.a(r1.getUiLayout()), new ColorDrawable(s1.h(2131108427)));
    L7:
        return new LinkRoomFightItemDecoration(this.z.getUiLayout(), new ColorDrawable(s1.h(2131107750)));
    }

    public com.bytedance.android.live.liveinteract.plantform.datamerge.a a1() {
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r0 = this.z.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r3 = this.z.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r7 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r2 + r1);
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L14:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.l(r5, this.C, this.n, this.z, r7, this.B);
    L12:
        r5 = null;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    public void b0() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        IVoiceLiveTheme r1 = null;
        if (r0 == null) goto L5;
        x00.a r2 = r0.getThemeManager(je0.d.D(), this.C);
    L7:
        if (r2 == null) goto L9;
        r2.f(this.w, 3);
    L9:
        com.bytedance.android.live.ui.q r3 = this.m;
        if (r3 == null) goto L15;
        if (r2 == null) goto L13;
        r1 = r2.q(3);
    L13:
        r3.d(r1);
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public com.bytedance.android.live.liveinteract.plantform.datamerge.a b1() {
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r0 = this.z.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r3 = this.z.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r7 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r2 + r1);
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L14:
        return new WindowListHelperV2(r5, this.C, this.n, this.z, r7, this.B, 0);
    L12:
        r5 = null;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    public final int c0() {
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
        r3 = Integer.valueOf(this.y.getHeight());
        if (r3.intValue() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        goto L17
    }

    public final int d0() {
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
        r3 = Integer.valueOf(this.y.getWidth());
        if (r3.intValue() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        goto L17
    }

    @Override // tf0.o
    public final List<tf0.e> e() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L8;
        fg0.a r1 = r0.getMultiAdapterWrapper();
        if (r1 == null) goto L8;
        List r2 = r1.a;
        if (r2 == null) goto L8;
        return r2;
    L8:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r3 = this.h;
        if (r3 == null) goto L15;
        BehaviorSubject<List<tf0.e>> r4 = r3.b;
        if (r4 == null) goto L15;
        List<tf0.e> r5 = (List) r4.getValue();
        if (r5 == null) goto L15;
        return r5;
    L15:
        return CollectionsKt.emptyList();
    }

    @Override // tf0.o
    public final ViewGroup getFirstSeatVHShadowContainer() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFirstSeatVHShadowContainer();
    }

    @Override // tf0.o
    public final ViewGroup getFirstSeatVHShadowFloatContainer() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFirstSeatVHShadowFloatContainer();
    }

    public final Lifecycle getLifecycleCompat() {
        return this.E.getLifecycle();
    }

    @Override // tf0.o
    public sf0.b getLinkmicAreaFrameInfo() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L10;
        LinkMicRecyclerView r1 = r0.getRecyclerView();
        if (r1 == null) goto L10;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        sf0.b r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.d(r1);
        sf0.c r4 = r3.c;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = this.z;
        r4.a = r5.b;
        List<Integer> r6 = r5.e;
        if (r6 == null) goto L9;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.b = r6;
    L9:
        return r3;
    L10:
        boolean r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        sf0.b r8 = null;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == false) goto L20;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r9 = this.z;
        if ((r9 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == true) goto L15;
        r9 = null;
    L15:
        if (r9 != null) goto L17;
        return null;
    L17:
        Pair<Integer, Integer> r10 = i0(d0(), c0());
        r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a(r9, ((Number) r10.getFirst()).intValue(), ((Number) r10.getSecond()).intValue());
        r8.c.a = r9.b;
        List<Integer> r11 = r9.e;
        if (r11 == null) goto L20;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r8.b = r11;
    L20:
        return r8;
    }

    public final void p0() {
        c r0 = new c(this);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r1 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r1 == null) goto L6;
        r1.C9(r0);
        return;
    }

    @Override // tf0.o
    public void w() {
        ALogger.i("BaseMultiLinkWindowManager", "sendPlayViewActionAfterUpdateFullMode playModeViewManager=" + this.j);
        if (MultiLinkLoadWidgetUtils.f() == false) goto L18;
        p0();
        wg0.e r0 = this.j;
        if (r0 == null) goto L19;
        ALogger.i("PlayModeViewManager", "sendPlayViewActionAfterUpdateFullMode");
        tf0.o.a r1 = r0.f;
        if ((r1 instanceof rj0.l) == true) goto L9;
        boolean r2 = r1 instanceof rj0.k;
    L9:
        StringBuilder r3 = new StringBuilder("callBack:");
        r3.append(r0.f);
        r3.append(", isVideoWidget:");
        tf0.o.a r4 = r0.f;
        if ((r4 instanceof rj0.l) == false) goto L12;
    L15:
        boolean r5 = true;
    L16:
        r3.append(r5);
        ALogger.i("PlayModeViewManager", r3.toString());
        r0.f.d0(sh0.k.b, new sh0.l(r0.b, r0.c, r0.e));
        return;
    L12:
        if ((r4 instanceof rj0.k) == true) goto L15;
        r5 = false;
        goto L16
    L19:
        return;
    }

    private final void s0() {
        IVoiceLiveTheme r1 = null;
        if (A0() == true) goto L16;
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r2 = this.C;
        com.bytedance.android.livesdk.chatroom.o r3 = com.bytedance.android.live.liveinteract.api.utils.m.n(r2, null, 2);
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L11;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L11;
        long r6 = r5.getId();
    L12:
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r2, Long.valueOf(r6));
        if (r7 == null) goto L40;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r7, "background_Load", 0, 2, null);
        return;
    L40:
        return;
    L11:
        r6 = 0;
        goto L12
    L16:
        int r8 = t0.a;
        StringBuilder r9 = new StringBuilder("[ThemePreLoad] initTheme, roomId=");
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L21;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L21;
        Long r12 = Long.valueOf(r11.getId());
    L22:
        r9.append(r12);
        r9.append(", BaseMultiLinkWindowManager#initTheme begin load background");
        t0.a("BaseMultiLinkWindowManager", r9.toString());
        this.a = m0();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L25;
        return;
    L25:
        com.bytedance.android.live.ui.c r13 = this.a;
        if (r13 == null) goto L28;
        com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a r14 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
        com.bytedance.android.live.ui.q.a.c(r14, r13);
        VideoLiveThemeReporter.a r15 = VideoLiveThemeReporter.g;
        boolean r16 = this.n;
        r15.getClass();
        Lazy r17 = VideoLiveThemeReporter.f;
        ((VideoLiveThemeReporter) r17.getValue()).d = r16;
        VideoLiveThemeReporter r18 = (VideoLiveThemeReporter) r17.getValue();
        Intrinsics.checkNotNullParameter(r18, "callback");
        ((com.bytedance.android.live.ui.q.a) r14).c = r18;
        this.m = r14.a();
    L28:
        IInteractService r19 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r19 == null) goto L31;
        x00.a r20 = r19.getThemeManager(je0.d.D(), this.C);
    L32:
        if (r20 == null) goto L34;
        r1 = r20.q(j0());
    L34:
        com.bytedance.android.live.ui.q r21 = this.m;
        if (r21 == null) goto L37;
        r21.c(r1);
    L37:
        if (r20 == null) goto L41;
        r20.j(this, this.w, j0());
        return;
    L41:
        return;
    L31:
        r20 = null;
    L21:
        r12 = null;
        goto L22
    }

    @Override // tf0.o
    public final hh1.t0 C() {
        return g0();
    }

    public final void M0() {
        Disposable r1 = null;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L14;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(this.C);
        if (r2 == null) goto L7;
        this.z.getClass();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r3 = r2.N7();
    L8:
        if (r3 == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r4 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(this.C);
        if (r4 == null) goto L12;
        this.z.getClass();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r5 = r4.N7();
    L17:
        this.h = r5;
        if (r5 == null) goto L20;
        r5.b();
    L20:
        this.C.put("data_multi_link_window_list_helper_init", Integer.valueOf(this.z.getUiLayout()));
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r6 = this.h;
        if (r6 == null) goto L25;
        BehaviorSubject<List<tf0.e>> r7 = r6.b;
        if (r7 == null) goto L25;
        r1 = r7.subscribe(new i(this));
    L25:
        if (r1 == null) goto L27;
        this.e.add(r1);
    L27:
        Disposable r8 = RxUtilKt.h(this.B.f()).subscribe(new j(this));
        if (r8 == null) goto L30;
        RxUtilKt.c(r8, this.e);
    L30:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r9 = this.d;
        if (r9 == null) goto L37;
        ViewGroup r10 = r9.td();
        if (r10 == null) goto L37;
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        if (r11 == null) goto L37;
        r11.addOnGlobalLayoutListener(new h(r9, this));
    L37:
        O0();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r12 = this.d;
        if (r12 == null) goto L41;
        r12.Xl(this.h);
        return;
    L41:
        return;
    L12:
        r5 = null;
        goto L17
    L7:
        r3 = null;
    L14:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L16;
        r5 = b1();
        goto L17
    L16:
        r5 = a1();
        goto L17
    }

    @Override // tf0.o
    public void end() {
        T0();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r0 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r0 == null) goto L5;
        r0.C9(null);
    L5:
        E0(false, 0, 0);
        if (this.k == null) goto L10;
        pj0.b r1 = ThemedCompetitionContext.Companion.c();
        if (r1 == null) goto L10;
        r1.ee(null);
    L10:
        this.C.put("data_themed_competition_view_manager", null);
        DataCenter r2 = this.C;
        if (r2 == null) goto L13;
        r2.put("data_common_talk_room_match_screen", -1);
    L13:
        this.p = -1;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.s r3 = this.g;
        if (r3 == null) goto L16;
        r3.a.clear();
    L16:
        SeatAnimEngineWrapper r4 = this.l;
        if (r4 == null) goto L19;
        r4.b();
    L19:
        this.C.put("cmd_equal_talkroom_state_change", new a0(1));
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r5 = this.h;
        if (r5 == null) goto L22;
        r5.d();
    L22:
        this.e.clear();
        Disposable r6 = this.f;
        if (r6 == null) goto L25;
        r6.dispose();
    L25:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.d;
        if (r7 == null) goto L28;
        r7.release();
    L28:
        b0();
    }

    public final int f0() {
        if (FoldScreenUtils.e() == false) goto L5;
    L8:
        int r0 = 256;
    L9:
        ra1 r1 = ra1.a;
        MultiLinkMatchScreenConfig r2 = (MultiLinkMatchScreenConfig) r1.getValue();
        if (r2 != null) goto L12;
        return r0;
    L12:
        if (r2.enable != true) goto L36;
        Pair<Integer, Integer> r4 = null;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L18;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r3 = this.d;
        if (r3 == null) goto L23;
        r4 = r3.vn(1, this.z.d);
    L23:
        int[] r5 = new int[2];
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.d;
        if (r6 == null) goto L28;
        RecyclerView r7 = r6.getRecyclerView();
        if (r7 == null) goto L28;
        r7.getLocationInWindow(r5);
    L28:
        if (r4 == null) goto L37;
        MultiLinkMatchScreenConfig r8 = (MultiLinkMatchScreenConfig) r1.getValue();
        if (r8 == null) goto L32;
        int r9 = r8.rightMargin;
    L34:
        return r9 + ((int) s1.G((s1.y() - ((Number) r4.getFirst()).intValue()) - r5[0]));
    L32:
        r9 = 12;
        goto L34
    L37:
        return r0;
    L18:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r10 = this.d;
        if (r10 == null) goto L23;
        ug0.a r11 = r10.getRvLayoutManager();
        if (r11 == null) goto L23;
        r4 = r11.c(1);
        goto L23
    L36:
        return r0;
    L5:
        if (PadConfigUtils.c() == true) goto L8;
        r0 = 128;
        goto L9
    }

    public com.bytedance.android.live.ui.c m0() {
        boolean r0 = MultiLinkLoadWidgetUtils.g();
        int r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(this.C);
        if (r0 == false) goto L23;
        if (r2 == null) goto L23;
        ViewGroup r3 = r2.Pn();
        if (r3 == null) goto L21;
        MultiLinkLoadWidgetUtils.p(this.C, "BaseMultiLinkWindowManager#initLiveBackground", "themeService=" + r2.hashCode() + ", themeBgViewContainer=" + r3);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r4 = this.d;
        if (r4 == null) goto L12;
        ViewGroup r5 = r4.td();
        if (r5 == null) goto L12;
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131388550);
    L13:
        if (r6 == null) goto L15;
        r6.removeAllViews();
    L15:
        ViewGroup r7 = UtilityKotlinExtentionsKt.p(r3);
        if (r7 == null) goto L18;
        r7.removeView(r3);
    L18:
        if (r6 == null) goto L21;
        r6.addView(r3, new FrameLayout.LayoutParams(-1, -1));
    L12:
        r6 = null;
    L21:
        return r2.kb();
    L23:
        return new com.bytedance.android.live.liveinteract.videotalk.ui.theme.a(this.n, this.y.findViewById(2131388551), this.y.findViewById(2131370471), new b(this));
    }

    @Override // tf0.o
    public final int o() {
        return c0();
    }

    @Override // tf0.o
    public final tf0.j E() {
        return this.z;
    }

    public final Context getContext() {
        return this.x;
    }

    @Override // tf0.o
    public final tf0.j getLinkWindowLayoutConfig() {
        return this.z;
    }

    public static void B0(MultiLinkGuestViewBinder.a r4) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        IBaseUser r0 = r4.k.a.getUser();
        if (r0 == null) goto L17;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L18;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L19;
        boolean r3 = Intrinsics.areEqual(r0.getIdString(), r2.getOwnerUserIdString());
        if (Intrinsics.areEqual(r0.getIdString(), jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L12;
        String r5 = "oneself";
    L15:
        TalkRoomLogUtils.d(r0.getIdString(), r5, com.bytedance.android.live.liveinteract.plantform.model.n.b(r4.k.a));
        return;
    L12:
        if (r3 == false) goto L14;
        r5 = "anchor";
        goto L15
    L14:
        r5 = "audience";
        goto L15
    L19:
        return;
    L18:
        return;
    }

    public static final /* synthetic */ void T(BaseMultiLinkWindowManager r0) {
        r0.s0();
    }

    public static hg6.g h0(boolean r0) {
        if (r0 == false) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r1 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r1 != null) goto L11;
    L9:
        return null;
    L11:
        return r1.R1();
    L6:
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r2 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r2 == null) goto L9;
        return r2.P2();
    }

    public static boolean t0(ih0.c r3) {
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L7;
        if (r3 == null) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    @Override // tf0.o
    public final void B(l2 r7) {
        Intrinsics.checkNotNullParameter(r7, "content");
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r1 = this.h;
        if (r1 == null) goto L5;
        int r2 = r1.f(r7.getToUserIdStr());
    L6:
        hg0.d r3 = this.i;
        if (r3 == null) goto L35;
        Intrinsics.checkNotNullParameter(r7, "content");
        RecyclerView r4 = r3.a;
        if (r4 == null) goto L11;
        RecyclerView.ViewHolder r5 = r4.findViewHolderForAdapterPosition(r2);
    L13:
        if ((r5 instanceof hg0.b) == false) goto L36;
        jg0.g r6 = ((hg0.b) r5).l();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "content");
        og0.a r8 = r6.r();
        if (r8 == null) goto L37;
        Intrinsics.checkNotNullParameter(r7, "content");
        StringBuilder r9 = new StringBuilder("onReceiveLikeMessage holder= ");
        r9.append(r8.hashCode());
        r9.append(" up=");
        MultiLinkGuestViewBinder.a r0 = r8.d;
        if (r0 == null) goto L23;
        ch0.e r10 = r0.k;
        if (r10 == null) goto L23;
        ILinkPlayerInfoBridge r11 = r10.a;
        if (r11 == null) goto L23;
        Integer r12 = Integer.valueOf(r11.getUserPosition());
    L24:
        r9.append(r12);
        ALogger.d("MultiLinkMicSelfDisciplineLayer", r9.toString());
        if (r8.g() == true) goto L38;
        HSImageView r13 = r8.e;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L30:
        UtilityKotlinExtentionsKt.w(r13);
        AbstractDraweeController r14 = Fresco.newDraweeControllerBuilder().setUri((String) vm2.d.q3.getValue(null, vm2.d.a[222(0xde, float:3.11E-43)])).setAutoPlayAnimations(true).setControllerListener(new og0.d(r8)).build();
        HSImageView r15 = r8.e;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L33:
        r15.setController(r14);
        return;
    L38:
        return;
    L23:
        r12 = null;
        goto L24
    L37:
        return;
    L36:
        return;
    L11:
        r5 = null;
        goto L13
    L35:
        return;
    L5:
        r2 = -1;
        goto L6
    }

    @Override // vg0.a
    public final void E5(ch0.b r11) {
        Intrinsics.checkNotNullParameter(r11, "itemData");
        Objects.toString(r11.a);
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        Objects.toString(r1);
        IBaseUser r2 = r11.a;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r11.b == false) goto L12;
        this.C.put("cmd_video_talk_invite", r2);
        return;
    L12:
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L20;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L21;
        ArrayList r3 = new ArrayList();
        r3.add(r2.getIdString());
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).inviteFriends(r13.getId(), new JSONArray(r3).toString(), 1, 0).as(AutoDispose.bind(this.E))).subscribe(new f(this, r2, r13), g.a);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void G0(KVData r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        String r4 = r3.getKey();
        if (r4.hashCode() == (-2111884430)) goto L6;
        return;
    L6:
        if (r4.equals("cmd_multi_enter_room_lynx_micseat_remove_view_mock") == false) goto L15;
        UtilityKotlinExtentionsKt.x(this.y);
        if (MultiLinkLoadWidgetUtils.i() == false) goto L16;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r5 = this.d;
        if (r5 == null) goto L17;
        ViewGroup r6 = r5.td();
        if (r6 == null) goto L18;
        UtilityKotlinExtentionsKt.x(r6);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // vg0.a
    public final void N0(w8 r3) {
        Intrinsics.checkNotNullParameter(r3, "emojiMessage");
        this.C.put("cmd_show_dynamic_emoji_in_comment", r3);
    }

    public final void X0(long r20) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.s r7 = this.g;
        if (r7 == null) goto L13;
        int r1 = g0().a;
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L13;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L13;
        if (r7.b == true) goto L13;
        r7.b = true;
        long r8 = System.currentTimeMillis();
        r7.a.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateLinkerPosition(r3.getId(), r3.getId(), r20, r1).subscribeOn(Schedulers.io()).flatMap(com.bytedance.android.live.liveinteract.plantform.commonwindow.p.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.plantform.commonwindow.q(r7, r20, r8), new com.bytedance.android.live.liveinteract.plantform.commonwindow.r(r7, r20, r8)));
    L13:
        ILinkPlayerInfoBridge r4 = this.B.X0(jc1.k.n(IMiddlewareUserService.class).user().n());
        if (r4 == null) goto L16;
        int r5 = r4.getUserPosition();
    L17:
        S0(r5, (int) r20);
        return;
    L16:
        r5 = -1;
        goto L17
    }

    @Override // tf0.o
    @Deprecated(message = "replace by LinkUserDataMergeCenter")
    public final void b(String r4) {
        if (((Boolean) vm2.d.E3.getValue(null, vm2.d.a[236(0xec, float:3.31E-43)])).booleanValue() == false) goto L6;
        this.D.Y7().put(r4, Boolean.FALSE);
        return;
    L6:
        if (this.D.Y7().containsKey(r4) == true) goto L10;
        this.D.Y7().put(r4, Boolean.FALSE);
        return;
    }

    @Override // vg0.a
    public void e4(MultiLinkGuestViewBinder.a r8) {
        Intrinsics.checkNotNullParameter(r8, "itemData");
        if (u0() == false) goto L5;
    L24:
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L42;
        IRoom r5 = (IRoom) r0.getValue();
        if (r5 == null) goto L47;
        ILinkPlayerInfoBridge r4 = r8.k.a;
        if (r5.getOwner() == null) goto L43;
        if (r4 != null) goto L33;
        return;
    L33:
        if (r4.getUser() == null) goto L48;
        IBaseUser r9 = r4.getUser();
        Intrinsics.checkNotNull(r9);
        TalkRoomLogUtils.c(r9.getIdString());
        ThemedCompetitionContext.a r10 = ThemedCompetitionContext.Companion;
        if (r10.g() == false) goto L40;
        pj0.b r11 = r10.c();
        if (r11 == null) goto L45;
        IBaseUser r1 = r4.getUser();
        Intrinsics.checkNotNull(r1);
        String r2 = r1.getIdString();
        IBaseUser r3 = r4.getUser();
        Intrinsics.checkNotNull(r3);
        r11.Qp(r2, r3.getNickName());
        return;
    L45:
        return;
    L40:
        hi0.a r12 = hi0.a.a;
        Context r6 = this.x;
        DataCenter r7 = this.C;
        hi0.a.a.b(r6, r7, r4, r5, false);
        return;
    L48:
        return;
    L43:
        return;
    L47:
        return;
    L42:
        return;
    L5:
        if (vm2.e.h() == false) goto L24;
        com.bytedance.android.livesdk.chatroom.o r13 = com.bytedance.android.live.liveinteract.api.utils.m.l(this.C, 0L);
        if (r13 == null) goto L24;
        com.bytedance.live.datacontext.m r14 = r13.getCleanMode();
        if (r14 == null) goto L24;
        Integer r15 = (Integer) r14.getValue();
        if (r15 == null) goto L24;
        int r16 = r15.intValue();
        if (r16 != 2) goto L15;
    L20:
        boolean r17 = true;
    L21:
        if (r17 != true) goto L24;
        ALogger.w("BaseMultiLinkWindowManager", "rejected guest rank click for new clean mode");
        return;
    L15:
        if (r16 == 3) goto L20;
        if (r16 == 13) goto L20;
        r17 = false;
        goto L21
    }

    @Override // tf0.o
    public final int h(String r2) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.S0(r2);
    }

    @Override // tf0.o
    public final int k(String r8) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        ih0.b r1 = r0.dynamicService(this.C);
        if (r1 == null) goto L7;
        ih0.c r2 = r1.Z9();
    L8:
        int r3 = -1;
        if (t0(r2) == false) goto L35;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r4 = this.h;
        if (r4 == null) goto L15;
        BehaviorSubject<List<tf0.e>> r5 = r4.b;
        if (r5 == null) goto L15;
        List r6 = (List) r5.getValue();
    L16:
        if (r6 == null) goto L34;
        int r7 = r6.size();
        int r9 = 0;
    L18:
        if (r9 >= r7) goto L34;
        Object r10 = ListProtector.get(r6, r9);
        if ((r10 instanceof MultiLinkGuestViewBinder.a) == true) goto L22;
        r10 = null;
    L22:
        MultiLinkGuestViewBinder.a r11 = (MultiLinkGuestViewBinder.a) r10;
        if (r11 == null) goto L33;
        if (r2.a(r8) == false) goto L33;
        IBaseUser r12 = r11.k.a.getUser();
        if (r12 == null) goto L29;
        String r13 = r12.getIdString();
    L31:
        if (Intrinsics.areEqual(r13, r8) == false) goto L33;
        r3 = r9;
        goto L33
    L29:
        r13 = null;
    L33:
        r9 = r9 + 1;
    L34:
        return r3;
    L15:
        r6 = null;
        goto L16
    L35:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r14 = this.d;
        if (r14 == null) goto L49;
        fg0.a r15 = r14.getMultiAdapterWrapper();
        if (r15 == null) goto L50;
        int r16 = r15.a(r8, "");
        if (r16 >= 0) goto L43;
        return -1;
    L43:
        return r16;
    L50:
        return -1;
    L49:
        return -1;
    L7:
        r2 = null;
        goto L8
    }

    @Override // tf0.o
    public final void m(@SupportUpdatePlayMode int r2) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L6;
        r0.b7(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        G0((KVData) r1);
    }

    @Override // tf0.o
    @Deprecated(message = "replace by LinkUserDataMergeCenter")
    public void onSeiUpdated(SeiAppData r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.o == true) goto L10;
        this.o = true;
        wg0.e r4 = this.j;
        if (r4 == null) goto L11;
        r4.f.d0(sh0.j.b, null);
        return;
    L11:
        return;
    }

    @Override // tf0.o
    @Deprecated(message = "should replace by LinkUserDataMergeCenter")
    public final void t(String r2) {
        this.D.Y7().remove(r2);
    }

    @Override // tf0.o
    public final void u(Boolean r19) {
        hg6.g r1 = h0(this.n);
        if (r1 == null) goto L5;
        ei6.a r2 = r1.V0();
    L6:
        List r3 = (List) this.B.f().getValue();
        boolean r4 = this.n;
        List<ILinkPlayerInfoBridge> r5 = com.bytedance.android.live.liveinteract.spatial.b.b(r3);
        int r6 = C0();
        p r7 = new p(this);
        int r8 = com.bytedance.android.live.liveinteract.spatial.a.a;
        Intrinsics.checkNotNullParameter(r7, "postionInfoProvider");
        Intrinsics.checkNotNullParameter("BaseMultiLinkWindowManager", "tag");
        if (com.bytedance.android.live.liveinteract.spatial.a.e(r6) == false) goto L96;
        ArrayList r9 = (ArrayList) r5;
        if (r9.isEmpty() == false) goto L12;
        com.bytedance.android.live.liveinteract.spatial.b.a("BaseMultiLinkWindowManager", "updateSpatialAudioPosition onlineList is null or empty");
        return;
    L12:
        if (r2 != null) goto L14;
        com.bytedance.android.live.liveinteract.spatial.b.a("BaseMultiLinkWindowManager", "updateSpatialAudioPosition client is null");
        return;
    L14:
        int r10 = r9.size();
        IMiddlewareUserService r11 = jc1.k.f(IMiddlewareUserService.class);
        if (r11 == null) goto L19;
        com.bytedance.android.livesdk.user.e r12 = r11.user();
        if (r12 == null) goto L19;
        IBaseUser r13 = r12.b();
    L20:
        String r14 = jc1.k.n(IKtvService.class).getKtvRoomCurrentSingerIdStr();
        InteractiveSongContext r15 = InteractiveSongContext.Companion.getContext();
        if (r15 == null) goto L26;
        com.bytedance.live.datacontext.m<String> r16 = r15.getSingingGuestId();
        if (r16 == null) goto L26;
        String r17 = (String) r16.getValue();
        if (r17 == null) goto L26;
    L27:
        com.bytedance.android.live.liveinteract.spatial.b.a("BaseMultiLinkWindowManager", "updateSpatialAudioPosition singerId " + r14.toString() + "  orderSingerId " + r17);
        if (r4 == false) goto L30;
    L33:
        SpatialAudioStrategyManager.a r18 = SpatialAudioStrategyManager.c;
        y0 r20 = r18.a().c(r6);
        Intrinsics.checkNotNullParameter(r20, "$this$toRtcPosition");
        String r110 = "";
        boolean r111 = r4;
        aj6.a r112 = new aj6.a(new aj6.d(r20.a(), r20.b(), r20.c()), r18.a().a(r6));
        com.bytedance.android.live.liveinteract.spatial.b.a("BaseMultiLinkWindowManager", "updateSelfPosition " + r112.toString() + ' ');
        SpatialAudioManager r0 = r2.m();
        if (r0 == null) goto L36;
        r0.g(bj6.a.b(r2), r112);
    L36:
        Iterator r21 = r9.iterator();
    L38:
        if (r21.hasNext() == false) goto L81;
        ILinkPlayerInfoBridge r22 = (ILinkPlayerInfoBridge) r21.next();
        IBaseUser r23 = r22.getUser();
        if (r23 == null) goto L42;
        String r24 = r23.getIdString();
    L43:
        if (r24 == null) goto L79;
        IBaseUser r25 = r22.getUser();
        if (r25 == null) goto L47;
        String r26 = r25.getIdString();
    L48:
        if (r13 == null) goto L50;
        String r27 = r13.getIdString();
    L52:
        if (Intrinsics.areEqual(r26, r27) == true) goto L38;
        IBaseUser r28 = r22.getUser();
        if (r28 == null) goto L57;
        String r29 = r28.getIdString();
    L59:
        if (Intrinsics.areEqual(r29, r14) == true) goto L75;
        IBaseUser r30 = r22.getUser();
        if (r30 == null) goto L63;
        String r31 = r30.getIdString();
    L65:
        if (Intrinsics.areEqual(r31, r17) == true) goto L75;
        IBaseUser r32 = r22.getUser();
        if (r32 == null) goto L71;
        String r33 = r32.getIdString();
        if (r33 == null) goto L71;
    L72:
        int r34 = r7.a(r33);
        SpatialAudioStrategyManager.a r113 = SpatialAudioStrategyManager.c;
        y0 r35 = r113.a().b(r6, r34, r10, null);
        Intrinsics.checkNotNullParameter(r35, "$this$toRtcPosition");
        Iterator r114 = r21;
        aj6.a r36 = new aj6.a(new aj6.d(r35.a(), r35.b(), r35.c()), r113.a().a(r6));
        com.bytedance.android.live.liveinteract.spatial.b.a("BaseMultiLinkWindowManager", " updateRemotePosition " + r22.getInteractId() + "  postion : " + r36);
        SpatialAudioManager r37 = r2.m();
        if (r37 == null) goto L80;
        r37.f(bj6.a.b(r2), String.valueOf(r22.getInteractId()), r36);
    L80:
        r21 = r114;
    L71:
        r33 = r110;
        goto L72
    L63:
        r31 = null;
    L75:
        r114 = r21;
        SpatialAudioManager r38 = r2.m();
        if (r38 == null) goto L78;
        r38.e(bj6.a.b(r2), String.valueOf(r22.getInteractId()));
    L78:
        com.bytedance.android.live.liveinteract.spatial.b.a("BaseMultiLinkWindowManager", " removeRemotePosition " + r14 + " cause he is singing ");
        goto L80
    L57:
        r29 = null;
        goto L59
    L50:
        r27 = null;
        goto L52
    L47:
        r26 = null;
        goto L48
    L79:
        r114 = r21;
        goto L80
    L42:
        r24 = null;
        goto L43
    L81:
        if (r111 == false) goto L94;
        vi6.a r39 = r2.v();
        if (r39 == null) goto L95;
        r39.f();
        return;
    L95:
        return;
    L94:
        return;
    L30:
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == true) goto L33;
        r111 = r4;
        r110 = "";
    L26:
        r17 = "";
    L19:
        r13 = null;
        goto L20
    L96:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean v0(IBaseUser r2) {
        if (r2 == null) goto L4;
        String r3 = r2.getIdString();
    L6:
        if (Intrinsics.areEqual(r3, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L9;
        return true;
    L9:
        return false;
    L4:
        r3 = null;
        goto L6
    }

    @Override // kk0.a.InterfaceC0227a
    public final PointF x(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L7;
        fg0.a r1 = r0.getMultiAdapterWrapper();
        if (r1 == null) goto L7;
        int r6 = r1.a(r5, null);
    L8:
        if (r6 < 0) goto L37;
        int[] r2 = new int[2];
        ViewGroup r3 = this.q;
        if (r3 == null) goto L12;
        r3.getLocationOnScreen(r2);
    L12:
        hg0.d r4 = this.i;
        if (r4 == null) goto L23;
        RecyclerView r7 = r4.a;
        if (r7 == null) goto L17;
        RecyclerView.ViewHolder r8 = r7.findViewHolderForAdapterPosition(r6);
    L19:
        if ((r8 instanceof hg0.b) == false) goto L21;
        PointF r9 = ((hg0.b) r8).l().c();
    L22:
        if (r9 == null) goto L23;
    L33:
        if (r9 != null) goto L35;
        return null;
    L35:
        PointF r10 = new PointF();
        r10.x = r9.x;
        r10.y = r9.y - r2[1];
        return r10;
    L21:
        r9 = null;
        goto L22
    L17:
        r8 = null;
    L23:
        hg0.d r11 = this.i;
        if (r11 == null) goto L32;
        RecyclerView r12 = r11.a;
        if (r12 == null) goto L28;
        RecyclerView.ViewHolder r13 = r12.findViewHolderForAdapterPosition(r6);
    L30:
        if ((r13 instanceof hg0.b) == false) goto L32;
        r9 = ((hg0.b) r13).l().t();
        goto L33
    L28:
        r13 = null;
    L32:
        r9 = null;
        goto L33
    L37:
        return null;
    L7:
        r6 = -1;
        goto L8
    }

    public final void P0(int r26, ClientUIInfo r27) {
        ALogger.i("BaseMultiLinkWindowManager", "reloadLinkWindowLayoutConfigByLynx");
        ln0.a r2 = yg0.h.a;
        int r16 = yg0.h.h(false, 0, r26);
        boolean r17 = true;
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L5;
    L10:
        Boolean r3 = (Boolean) this.C.get("status_bar_is_visible", Boolean.TRUE);
        if (r3 == null) goto L13;
        boolean r18 = r3.booleanValue();
    L14:
        int r19 = je0.d.S();
        if (r26 != 2) goto L19;
        if (r19 != 0) goto L19;
        ALogger.e("BaseMultiLinkWindowManager", "intercept reload layout from lynx, current windowCount is zero and uiLayout is dynamicWindow");
        return;
    L19:
        boolean r20 = gh0.a.d();
        Triple r13 = new Triple(Integer.valueOf(d0()), Integer.valueOf(c0()), "BaseWindowManager#reloadLinkWindowLayoutConfigByLynx");
        if (r27 == null) goto L22;
        List r11 = r27.getUiFeatureList();
    L23:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.h r21 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r26, r16, null, r18, r19, r20, null, r13, r11, null, this.C, 580);
        i0 r4 = j0.a(this.C);
        if (r4 == null) goto L28;
        ne0.g r5 = r4.b;
        if (r5 == null) goto L28;
        nh0.s r12 = (nh0.s) r5.a("dynamicLayoutConfig");
    L30:
        if (r12 != null) goto L32;
    L37:
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r6 == null) goto L40;
        IRoom r14 = (IRoom) r6.getValue();
    L41:
        Intrinsics.checkNotNullParameter("BaseMultiLinkWindowManager", "logTag");
        if (r14 == null) goto L46;
        z5 r0 = r14.getLinkerDetail();
        if (r0 == null) goto L46;
        String r15 = r0.getClientUiInfo();
    L48:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L67;
        ArrayList r7 = new ArrayList();
        if (r15 != null) goto L96;
    L57:
        boolean r110 = true;
    L58:
        if (r110 == true) goto L66;
        ALogger.i("ClientUIUtil", "clientUiInfo = " + r15);     // Catch: Exception -> L55
        JSONArray r1 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r15), "ui_feature_list");     // Catch: Exception -> L55
        int r8 = r1.length();     // Catch: Exception -> L55
        if (r8 < 0) goto L66;
        int r111 = 0;
    L62:
        r7.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r1, r111)));     // Catch: Exception -> L55
        if (r111 == r8) goto L66;
        r111 = r111 + 1;
    L55:
        e = move-exception;
        ALogger.e("ClientUIUtil", "parse ui_feature_list error!", e);
    L66:
        r17 = r7.contains(4);
        List r112 = null;
    L85:
        if (r17 == false) goto L94;
    L86:
        boolean r9 = je0.d.d().contains(7);
        ArrayList r10 = new ArrayList();
        r10.addAll(je0.d.d());
        if (r9 == true) goto L90;
        r10.add(7);
    L90:
        if (r27 == null) goto L92;
        List r113 = r27.getUiFeatureList();
    L93:
        r21 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.t(r26, r10, r16, r18, r19, r20, null, r13, r113, this.C, 136);
        goto L94
    L92:
        r113 = r112;
    L94:
        ln0.a r22 = yg0.h.a;
        yg0.h.k(r21, new k(this), r112);
        return;
    L96:
        if (r15.length() == 0) goto L57;
        r110 = false;
        goto L58
    L67:
        r112 = null;
        if (((vb1) vm2.h.f6.getValue(null, vm2.h.a[368(0x170, float:5.16E-43)])).a() == true) goto L70;
    L84:
        r17 = false;
        goto L85
    L70:
        if (je0.d.D() == true) goto L84;
        if (r15 != null) goto L98;
    L78:
        boolean r23 = true;
    L79:
        if (r23 == true) goto L84;
        if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r15), "ui_translation"), "vertical") != 10000) goto L84;
    L98:
        if (r15.length() == 0) goto L78;
        r23 = false;
    L46:
        r15 = null;
        goto L48
    L40:
        r14 = null;
        goto L41
    L32:
        if (r12.b != 21) goto L37;
        if (r12.c != 7) goto L37;
        r112 = null;
    L28:
        r12 = null;
        goto L30
    L22:
        r11 = null;
    L13:
        r18 = true;
        goto L14
    L5:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.FALSE) == false) goto L10;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L13;
        r18 = false;
        goto L14
    }

    public void S0(int r2, int r3) {
        TalkRoomLogUtils.p1(r2 + 1, r3 + 1, null, null);
    }

    public void U0(int r3, int r4) {
        if (MultiLinkLoadWidgetUtils.f() == false) goto L5;
        l0(r3, r4);
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L12;
        ViewGroup r1 = r0.td();
        if (r1 == null) goto L13;
        r1.post(new o(this, r3, r4));
        return;
    L13:
        return;
    }

    public void W0(tf0.j r5, boolean r6) {
        Objects.toString(g0());
        if (r5 == null) goto L5;
        r5.a();
    L5:
        f2.g();
        if (r5 != null) goto L8;
        return;
    L8:
        if ((r5 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == false) goto L32;
        ALogger.e("BaseMultiLinkWindowManager", "updateLinkWindowLayoutConfig, config ui_layout=" + r5.getUiLayout());
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L13;
        r0.x8();
    L13:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m) r5;
        this.z = r1;
        V0(r1, d0(), c0());
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r2 = r1.h();
        int r3 = 0;
        if (r2 == null) goto L16;
        int r4 = r2.size();
    L17:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r7 = r1.k();
        if (r7 == null) goto L20;
        r3 = r7.size();
    L20:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r8 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r4 + r3);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r9 = this.h;
        if (r9 == null) goto L23;
        r9.w(r8, r1);
    L23:
        k0();
        this.y.post(new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.h(this, r5, r6));
        Y0();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r10 = this.d;
        if (r10 == null) goto L30;
        ViewGroup r11 = r10.td();
        if (r11 == null) goto L31;
        r11.post(new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.i(this, r5));
        return;
    L31:
        return;
    L30:
        return;
    L16:
        r4 = 0;
        goto L17
    }

    public com.bytedance.android.live.liveinteract.videotalk.utils.h Z(int r5, int r6) {
        float r0 = this.z.q(r6);
        float r1 = this.z.s(r5, r6);
        boolean r2 = gh0.b.a;
        gh0.b.a("ScreenAdjust", "createImageViewStrategy, containerWidth = " + r5 + ", containerHeight = " + r6 + ", sx = 0.0, sy = " + r0 + ", windowWidth = " + r5 + ", windowHeight = " + r1, false);
        int r3 = com.bytedance.android.live.liveinteract.videotalk.utils.d.a;
        return com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r5, r6, this.z);
    }

    @Override // tf0.o
    @Deprecated(message = "replace by LinkUserDataMergeCenter")
    public final void c(String r2, boolean r3) {
        this.D.Y7().put(r2, Boolean.valueOf(r3));
    }

    public final Pair<Integer, Integer> i0(int r3, int r4) {
        int r0 = ug0.b.a;
        return ug0.b.b(this.z.m(), this.z.getUiLayout(), r3, r4);
    }

    @Override // tf0.o
    public final void j(int r10, int r11) {
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        Pair<Integer, Integer> r1 = this.s;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "currlivePlayerVideoSize");
        JSONObject r4 = new JSONObject();
        r4.put("new_live_player_video_size", r10 + " x " + r11);
        r4.put("curr_live_player_video_size", ((Number) r1.getFirst()).intValue() + " x " + ((Number) r1.getSecond()).intValue());
        if (((Number) r1.getFirst()).intValue() == r10) goto L5;
    L7:
        int r5 = -1;
    L8:
        nd0.c.o(nd0.c.a, LinkMonitorData.LivePlayerVideoSizeChanged, r4, r5, null, true, 8);
        if (vm2.d.P0() == true) goto L12;
        return;
    L12:
        if (((Number) this.s.getFirst()).intValue() == r10) goto L14;
    L16:
        ALogger.e("ttlive_link", "BaseMultiLinkWindowManager call onLivePlayerVideoSizeChanged, oldLivePlayerVideoSize[" + ((Number) this.s.getFirst()).intValue() + ", " + ((Number) this.s.getSecond()).intValue() + "], newLivePlayerVideoSize[" + r10 + ", " + r11 + ']');
        this.s = new Pair(Integer.valueOf(r10), Integer.valueOf(r11));
        Y0();
        return;
    L14:
        if (((Number) this.s.getSecond()).intValue() != r11) goto L16;
        return;
    L5:
        if (((Number) r1.getSecond()).intValue() != r11) goto L7;
        r5 = 0;
        goto L8
    }

    public final void l0(int r1, int r2) {
        this.b = Z(r1, r2);
    }

    public void n0(boolean r12, boolean r13) {
        FrameLayout r4 = (FrameLayout) this.y.findViewById(2131372815);
        FrameLayout r5 = (FrameLayout) this.y.findViewById(2131372816);
        if (r5 != null) goto L5;
        return;
    L5:
        Context r2 = this.x;
        DataCenter r3 = this.C;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.d;
        if (r6 == null) goto L8;
        fg0.a r1 = r6.getMultiAdapterWrapper();
    L9:
        hg0.d r8 = this.i;
        Intrinsics.checkNotNull(r8);
        wg0.e r0 = new wg0.e(r2, r3, r4, r5, r6, r1, r8, this.D, this);
        this.j = r0;
        r0.b.removeAllViews();
        r0.c.removeAllViews();
        i0 r7 = j0.a(r0.a);
        if (r7 == null) goto L12;
        r7.d(sh0.s.b, new wg0.b(r0));
    L12:
        i0 r9 = j0.a(r0.a);
        if (r9 == null) goto L15;
        r9.d(sh0.b.b, new wg0.c(r0));
    L15:
        i0 r10 = j0.a(r0.a);
        if (r10 == null) goto L18;
        r10.d(sh0.d.b, new wg0.d(r0));
    L18:
        StringBuilder r11 = new StringBuilder("attach isFromFastMode=");
        r11.append(r12);
        r11.append(" context:");
        TeamFightContext.a r14 = TeamFightContext.Companion;
        r11.append(r14.getContext());
        ALogger.i("PlayModeViewManager", r11.toString());
        if (r13 == false) goto L36;
        if (r12 == false) goto L24;
        if (r12 == true) goto L23;
        return;
    L23:
        if (r14.getContext() != null) goto L24;
        return;
    L24:
        tf0.o.a r15 = r0.f;
        if ((r15 instanceof rj0.l) == true) goto L27;
        boolean r16 = r15 instanceof rj0.k;
    L27:
        StringBuilder r17 = new StringBuilder("callBack:");
        r17.append(r0.f);
        r17.append(", isVideoWidget:");
        tf0.o.a r18 = r0.f;
        if ((r18 instanceof rj0.l) == false) goto L30;
    L33:
        boolean r19 = true;
    L34:
        r17.append(r19);
        ALogger.i("PlayModeViewManager", r17.toString());
        r0.f.d0(sh0.k.b, new sh0.l(r0.b, r0.c, r0.e));
        return;
    L30:
        if ((r18 instanceof rj0.k) == true) goto L33;
        r19 = false;
        goto L34
    L36:
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // tf0.o
    public final int q0(List<ti6.f> r2, Map<String, Integer> r3) {
        if (r2 == null) goto L6;
        if (r3 != null) goto L5;
        return 0;
    L5:
        return D0(r2, r3, null);
    L6:
        return 0;
    }

    @Override // tf0.o
    public /* bridge */ /* synthetic */ void r(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1, Boolean r2) {
        W0(r1, r2.booleanValue());
    }

    public void r0(int r4, int r5) {
        if (MultiLinkLoadWidgetUtils.f() == false) goto L6;
        s0();
        l0(r4, r5);
        return;
    L6:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L8;
        s0();
        l0(r4, r5);
        return;
    L8:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L16;
        RecyclerView r1 = r0.getRecyclerView();
        if (r1 == null) goto L17;
        r1.post(new d(this, r4, r5));
        return;
    L17:
        return;
    }

    @Override // tf0.o
    public final void y(int r10, int r11) {
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        Pair<Integer, Integer> r1 = this.t;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "containerLayoutSize");
        JSONObject r4 = new JSONObject();
        r4.put("live_player_layout_size", r10 + " x " + r11);
        r4.put("container_layout_size", ((Number) r1.getFirst()).intValue() + " x " + ((Number) r1.getSecond()).intValue());
        if (((Number) r1.getFirst()).intValue() == r10) goto L5;
    L7:
        int r5 = -1;
    L8:
        nd0.c.o(nd0.c.a, LinkMonitorData.LivePlayerLayoutSizeChanged, r4, r5, null, true, 8);
        if (vm2.d.O0() == true) goto L12;
        return;
    L12:
        if (((Number) this.t.getFirst()).intValue() == r10) goto L14;
    L16:
        ALogger.e("ttlive_link", "BaseMultiLinkWindowManager call onLivePlayerLayoutSizeChanged, containerLayoutSize[" + ((Number) this.t.getFirst()).intValue() + ", " + ((Number) this.t.getSecond()).intValue() + "], livePlayerLayoutSize[" + r10 + ", " + r11 + ']');
        Y0();
        return;
    L14:
        if (((Number) this.t.getSecond()).intValue() != r11) goto L16;
        return;
    L5:
        if (((Number) r1.getSecond()).intValue() != r11) goto L7;
        r5 = 0;
        goto L8
    }

    public static void L0(BaseMultiLinkWindowManager r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r3 = 12;
    L6:
        if (r2.p == r3) goto L12;
        DataCenter r5 = r2.C;
        if (r5 == null) goto L10;
        r5.put("data_common_talk_room_match_screen", Integer.valueOf(r3));
    L10:
        r2.p = r3;
        return;
    }

    private final void V0(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Pair<Integer, Integer> r6 = i0(r4, r5);
        Triple r7 = new Triple(r6.getFirst(), r6.getSecond(), "BaseMultiLinkWindowManager#initLayoutConfigResultIfNeed");
        ln0.a r8 = yg0.h.a;
        r3.d = yg0.h.a(r3, r7, this.s);
    }

    public final void E0(boolean r13, int r14, int r15) {
        boolean r0 = true;
        if (r13 == true) goto L5;
        this.C.put("cmd_video_talkroom_state_change", new l3(1));
        return;
    L5:
        DataCenter r16 = this.C;
        float r17 = this.z.s(r14, r15);
        int r2 = this.z.o(r15);
        int r3 = this.z.p(r15);
        int r4 = this.z.q(r15);
        MultiLinkFrequencyOptConfig r5 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        int r6 = 7;
        int r8 = 0;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.c(Integer.valueOf(this.z.m()), Integer.valueOf(this.z.getUiLayout())) == true) goto L187;
        Integer r7 = je0.d.h();
        if (r7 == null) goto L14;
        if (r7.intValue() == 29) goto L187;
    L14:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.e(Integer.valueOf(this.z.m()), Integer.valueOf(this.z.getUiLayout())) == false) goto L16;
    L150:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r18 = this.d;
        if (r18 == null) goto L159;
        ug0.a r19 = r18.getRvLayoutManager();
        if (r19 == null) goto L159;
        Pair<Integer, Integer> r110 = r19.a(1);
        if (r110 == null) goto L159;
        Integer r111 = (Integer) r110.getFirst();
        if (r111 == null) goto L159;
    L165:
        int r112 = r111.intValue();
    L167:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r113 = this.d;
        if (r113 == null) goto L176;
        ug0.a r114 = r113.getRvLayoutManager();
        if (r114 == null) goto L176;
        Pair<Integer, Integer> r115 = r114.a(1);
        if (r115 == null) goto L176;
        Integer r116 = (Integer) r115.getSecond();
        if (r116 == null) goto L176;
    L182:
        int r117 = r116.intValue();
    L184:
        l3 r1 = new l3(0);
        int r118 = (int) (s1.G(r3 + r112) + 4);
        r1.b = r118;
        r1.d = r118;
        r1.c = (int) (s1.G(r117 + r2) - 8);
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.b(Integer.valueOf(this.z.getUiLayout())) == false) goto L212;
        r1.e = 60;
    L212:
        r16.put("cmd_video_talkroom_state_change", r1);
        return;
    L176:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r119 = this.d;
        if (r119 == null) goto L183;
        Pair r120 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r119);
        if (r120 == null) goto L183;
        r116 = (Integer) r120.getSecond();
        if (r116 != null) goto L182;
    L183:
        r117 = 0;
    L159:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r121 = this.d;
        if (r121 == null) goto L166;
        Pair r122 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r121);
        if (r122 == null) goto L166;
        r111 = (Integer) r122.getFirst();
        if (r111 != null) goto L165;
    L166:
        r112 = 0;
        goto L167
    L16:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.b(Integer.valueOf(this.z.getUiLayout())) == true) goto L150;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.k(Integer.valueOf(this.z.m()), Integer.valueOf(this.z.getUiLayout())) == false) goto L49;
        l3 r123 = new l3(3);
        if (this.z.getUiLayout() == 110) goto L24;
        r6 = 9;
    L24:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r9 = this.d;
        if (r9 == null) goto L33;
        ug0.a r10 = r9.getRvLayoutManager();
        if (r10 == null) goto L33;
        Pair<Integer, Integer> r11 = r10.a(1);
        if (r11 == null) goto L33;
        Integer r12 = (Integer) r11.getFirst();
        if (r12 == null) goto L33;
    L39:
        int r20 = r12.intValue();
    L41:
        int r21 = (int) (s1.G(r3 + r20) + 4);
        List r22 = (List) this.B.f().getValue();
        if (r22 == null) goto L44;
        int r23 = r22.size();
    L45:
        if (r23 < r6) goto L47;
        r8 = r21;
    L47:
        r123.b = r8;
        r123.d = r21;
        r123.c = (int) (s1.G(((int) r17) + r2) - 8);
    L211:
        r1 = r123;
        goto L212
    L44:
        r23 = 0;
    L33:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r24 = this.d;
        if (r24 == null) goto L40;
        Pair r25 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r24);
        if (r25 == null) goto L40;
        r12 = (Integer) r25.getFirst();
        if (r12 != null) goto L39;
    L40:
        r20 = 0;
        goto L41
    L49:
        if (this.z.getUiLayout() != 112) goto L86;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r124 = this.d;
        if (r124 == null) goto L59;
        ug0.a r125 = r124.getRvLayoutManager();
        if (r125 == null) goto L59;
        Pair<Integer, Integer> r126 = r125.a(1);
        if (r126 == null) goto L59;
        Integer r127 = (Integer) r126.getFirst();
        if (r127 == null) goto L59;
    L65:
        int r128 = r127.intValue();
    L67:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r129 = this.d;
        if (r129 == null) goto L76;
        ug0.a r130 = r129.getRvLayoutManager();
        if (r130 == null) goto L76;
        Pair<Integer, Integer> r131 = r130.a(1);
        if (r131 == null) goto L76;
        Integer r132 = (Integer) r131.getSecond();
        if (r132 == null) goto L76;
    L82:
        int r133 = r132.intValue();
    L84:
        r1 = new l3(0);
        int r134 = (int) (s1.G(r3 + r128) + 4);
        r1.b = r134;
        r1.d = r134;
        r1.c = (int) (s1.G(r133 + r2) - 8);
    L76:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r135 = this.d;
        if (r135 == null) goto L83;
        Pair r136 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r135);
        if (r136 == null) goto L83;
        r132 = (Integer) r136.getSecond();
        if (r132 != null) goto L82;
    L83:
        r133 = 0;
    L59:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r137 = this.d;
        if (r137 == null) goto L66;
        Pair r138 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r137);
        if (r138 == null) goto L66;
        r127 = (Integer) r138.getFirst();
        if (r127 != null) goto L65;
    L66:
        r128 = 0;
        goto L67
    L86:
        if (this.z.getUiLayout() != 15) goto L88;
    L149:
        r1 = new l3(0);
        goto L212
    L88:
        if (this.z.getUiLayout() == 65) goto L149;
        if (this.z.getUiLayout() != 16) goto L128;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r139 = this.d;
        if (r139 == null) goto L101;
        ug0.a r140 = r139.getRvLayoutManager();
        if (r140 == null) goto L101;
        Pair<Integer, Integer> r141 = r140.a(1);
        if (r141 == null) goto L101;
        Integer r142 = (Integer) r141.getFirst();
        if (r142 == null) goto L101;
    L107:
        int r143 = r142.intValue();
    L109:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r144 = this.d;
        if (r144 == null) goto L118;
        ug0.a r145 = r144.getRvLayoutManager();
        if (r145 == null) goto L118;
        Pair<Integer, Integer> r146 = r145.a(1);
        if (r146 == null) goto L118;
        Integer r147 = (Integer) r146.getSecond();
        if (r147 == null) goto L118;
    L124:
        int r148 = r147.intValue();
    L126:
        r1 = new l3(0);
        int r149 = (int) (s1.G(r3 + r143) + 4);
        r1.b = r149;
        r1.d = r149;
        r1.c = (int) (s1.G(r148 + r2) - 8);
    L118:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r150 = this.d;
        if (r150 == null) goto L125;
        Pair r151 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r150);
        if (r151 == null) goto L125;
        r147 = (Integer) r151.getSecond();
        if (r147 != null) goto L124;
    L125:
        r148 = 0;
    L101:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r152 = this.d;
        if (r152 == null) goto L108;
        Pair r153 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r152);
        if (r153 == null) goto L108;
        r142 = (Integer) r153.getFirst();
        if (r142 != null) goto L107;
    L108:
        r143 = 0;
        goto L109
    L128:
        if (this.d != null) goto L130;
        r1 = null;
        goto L212
    L130:
        if (vm2.d.q0().isOpenSmoothEnterRoom() == true) goto L132;
    L136:
        r0 = false;
    L137:
        if (r0 == true) goto L147;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r154 = this.d;
        if (r154 == null) goto L146;
        ViewGroup r155 = r154.td();
        if (r155 == null) goto L146;
        ViewGroup.LayoutParams r156 = r155.getLayoutParams();
        if (r156 == null) goto L146;
        r8 = r156.height;
    L146:
        r4 = r4 + r8;
    L147:
        r1 = new l3(6);
        r1.c = (int) s1.G(r15 - r4);
        goto L212
    L132:
        if (FoldScreenUtils.f() == true) goto L136;
        if (PadConfigUtils.a() == true) goto L136;
    L187:
        r123 = new l3(3);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r26 = this.d;
        if (r26 == null) goto L196;
        ug0.a r27 = r26.getRvLayoutManager();
        if (r27 == null) goto L196;
        Pair<Integer, Integer> r28 = r27.a(1);
        if (r28 == null) goto L196;
        Integer r29 = (Integer) r28.getFirst();
        if (r29 == null) goto L196;
    L202:
        int r30 = r29.intValue();
    L204:
        int r31 = (int) (s1.G(r3 + r30) + 4);
        List r32 = (List) this.B.f().getValue();
        if (r32 == null) goto L207;
        int r33 = r32.size();
    L208:
        if (r33 < 7) goto L210;
        r8 = r31;
    L210:
        r123.b = r8;
        r123.d = r31;
        r123.c = (int) (s1.G(((int) r17) + r2) - 8);
        goto L211
    L207:
        r33 = 0;
    L196:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r34 = this.d;
        if (r34 == null) goto L203;
        Pair r35 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r34);
        if (r35 == null) goto L203;
        r29 = (Integer) r35.getFirst();
        if (r29 != null) goto L202;
    L203:
        r30 = 0;
        goto L204
    }

    public final void V(int r4, int r5, boolean r6) {
        this.t = new Pair(Integer.valueOf(r4), Integer.valueOf(r5));
        Pair<Integer, Integer> r0 = i0(r4, r5);
        int r1 = ((Number) r0.getFirst()).intValue();
        int r2 = ((Number) r0.getSecond()).intValue();
        V0(this.z, r4, r5);
        Z0(this.z, r1, r2);
        if (r6 == false) goto L9;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.d;
        if (r7 == null) goto L9;
        ViewGroup r8 = r7.td();
        if (r8 == null) goto L9;
        r8.requestLayout();
    L9:
        U0(r1, r2);
        J0();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r9 = this.h;
        if (r9 == null) goto L17;
        BehaviorSubject<List<tf0.e>> r10 = r9.b;
        if (r10 == null) goto L18;
        List<? extends tf0.e> r11 = (List) r10.getValue();
        if (r11 == null) goto L19;
        I0(r11);
        return;
    L19:
        return;
    L18:
        return;
    }

    public void Z0(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L5;
        r0.Yd(r2, r3, r4);
    L5:
        FrameLayout r5 = this.c;
        if (r5 == null) goto L8;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L9:
        if (r6 == null) goto L11;
        r6.width = r3;
        r6.height = r4;
    L11:
        FrameLayout r7 = this.c;
        if (r7 == null) goto L15;
        r7.setLayoutParams(r6);
        return;
    L15:
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // tf0.o
    public void l(boolean r29, Pair<Integer, Integer> r30, Pair<Integer, Integer> r31) {
        Intrinsics.checkNotNullParameter(r30, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r31, "livePlayerLayoutSize");
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L12;
        int r5 = com.bytedance.android.live.liveinteract.videotalk.ui.b.a;
        Disposable r6 = com.bytedance.android.live.liveinteract.videotalk.ui.b.b(this.y, this.C);
        if (r6 == null) goto L12;
        RxUtilKt.c(r6, this.e);
    L12:
        int r7 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r8 = this.C;
        com.bytedance.android.livesdk.chatroom.o r9 = com.bytedance.android.live.liveinteract.api.utils.m.n(r8, null, 2);
        long r16 = 0;
        if (r9 == null) goto L19;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L19;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L19;
        long r12 = r11.getId();
    L20:
        MultiSceneEnterRoomStatisticsUtils r13 = MultiSceneEnterRoomStatisticsUtils.a.a(r8, Long.valueOf(r12));
        if (r13 == null) goto L23;
        long r14 = r13.c();
    L24:
        ALogger.e("livesdk_audience_loading_statistics", "WindowManager Start isFromFastMode: " + r29 + " use: " + (System.currentTimeMillis() - r14));
        ALogger.i("BaseMultiLinkWindowManager", "布局配置化WM, livePlayerVideoSize = " + r30 + ", livePlayerLayoutSize = " + r31 + ", VideoTalkLayoutConfig: " + g0() + ", LinkWindowLayoutConfig: " + this.z.a() + ", \n layoutConfig = " + this.z + ", \n");
        System.currentTimeMillis();
        DataCenter r15 = this.C;
        com.bytedance.android.livesdk.chatroom.o r17 = com.bytedance.android.live.liveinteract.api.utils.m.n(r15, null, 2);
        if (r17 == null) goto L31;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L31;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L31;
        long r20 = r19.getId();
    L32:
        MultiSceneEnterRoomStatisticsUtils r110 = MultiSceneEnterRoomStatisticsUtils.a.a(r15, Long.valueOf(r20));
        if (r110 == null) goto L35;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r110, "window_manager_load", 0, 2, null);
    L35:
        this.C.observe("cmd_multi_enter_room_lynx_micseat_remove_view_mock", this);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r30, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r31, "livePlayerLayoutSize");
        JSONObject r2 = new JSONObject();
        r2.put("live_player_video_size", ((Number) r30.getFirst()).intValue() + " x " + ((Number) r30.getSecond()).intValue());
        r2.put("live_player_layout_size", ((Number) r31.getFirst()).intValue() + " x " + ((Number) r31.getSecond()).intValue());
        nd0.c.o(nd0.c.a, LinkMonitorData.LivePlayerLayoutSizeChanged, r2, 0, null, true, 12);
        this.s = r30;
        this.t = r31;
        this.g = new com.bytedance.android.live.liveinteract.plantform.commonwindow.s();
        SeatAnimEngineWrapper r0 = new SeatAnimEngineWrapper(g0().a, this.C, this.x, this.F);
        this.l = r0;
        r0.a();
        Pair<Integer, Integer> r111 = i0(d0(), c0());
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.z;
        if (r1.d != null) goto L39;
        Pair<Integer, Integer> r3 = i0(d0(), c0());
        Triple r21 = new Triple(r3.getFirst(), r3.getSecond(), "BaseMultiLinkWindowManager#initLayoutConfigResultIfNeed");
        ln0.a r22 = yg0.h.a;
        r1.d = yg0.h.a(r1, r21, this.s);
    L39:
        int r23 = ((Number) r111.getFirst()).intValue();
        int r24 = ((Number) r111.getSecond()).intValue();
        this.c = (FrameLayout) this.y.findViewById(2131378012);
        if (MultiLinkLoadWidgetUtils.g() == false) goto L42;
        int r25 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r26 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(this.C);
    L43:
        this.d = r26;
        if (r26 == null) goto L48;
        ViewGroup r27 = r26.td();
        if (r27 == null) goto L48;
        UtilityKotlinExtentionsKt.w(r27);
    L48:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r28 = this.d;
        if (r28 == null) goto L53;
        ViewGroup r32 = r28.td();
        if (r32 == null) goto L53;
        int r33 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r32, new BaseMultiLinkWindowManager$initLinkSeatWindowView$1(this));
    L53:
        this.v = a0();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r34 = this.d;
        if (r34 == null) goto L60;
        com.bytedance.live.datacontext.m r35 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r35 == null) goto L58;
        IRoom r36 = (IRoom) r35.getValue();
    L59:
        int r37 = r24;
        int r38 = r23;
        String r210 = "livesdk_audience_loading_statistics";
        RecyclerView r112 = null;
        int r113 = 0;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.b(r34, r36, this.C, this.z, this.v, this, this.l, r38, r37, 0, null, this.B, 768);
    L62:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(r112, r113, 7) == true) goto L87;
        DataCenter r39 = this.C;
        com.bytedance.android.livesdk.chatroom.o r40 = com.bytedance.android.live.liveinteract.api.utils.m.n(r39, r112, 2);
        if (r40 == null) goto L70;
        com.bytedance.live.datacontext.m r41 = r40.getRoom();
        if (r41 == null) goto L70;
        IRoom r42 = (IRoom) r41.getValue();
        if (r42 == null) goto L70;
        long r43 = r42.getId();
    L71:
        MultiSceneEnterRoomStatisticsUtils r44 = MultiSceneEnterRoomStatisticsUtils.a.a(r39, Long.valueOf(r43));
        if (r44 == null) goto L74;
        long r45 = r44.c();
    L75:
        ALogger.e(r210, "Native麦位收到LayoutConfig耗时 use: " + (System.currentTimeMillis() - r45));
        DataCenter r46 = this.C;
        com.bytedance.android.livesdk.chatroom.o r47 = com.bytedance.android.live.liveinteract.api.utils.m.n(r46, r112, 2);
        if (r47 == null) goto L82;
        com.bytedance.live.datacontext.m r48 = r47.getRoom();
        if (r48 == null) goto L82;
        IRoom r49 = (IRoom) r48.getValue();
        if (r49 == null) goto L82;
        long r50 = r49.getId();
    L83:
        MultiSceneEnterRoomStatisticsUtils r51 = MultiSceneEnterRoomStatisticsUtils.a.a(r46, Long.valueOf(r50));
        if (r51 == null) goto L102;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r51, "native_micseat_receive_layout_config", 0, 2, null);
    L102:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r52 = this.d;
        if (r52 == null) goto L105;
        r52.a6(this.D);
    L105:
        k0();
        F0();
        r0(((Number) r111.getFirst()).intValue(), ((Number) r111.getSecond()).intValue());
        System.currentTimeMillis();
        if (vm2.h.S().c() == false) goto L124;
        System.currentTimeMillis();
        DataCenter r53 = this.C;
        com.bytedance.android.livesdk.chatroom.o r54 = com.bytedance.android.live.liveinteract.api.utils.m.n(r53, r112, 2);
        if (r54 == null) goto L114;
        com.bytedance.live.datacontext.m r55 = r54.getRoom();
        if (r55 == null) goto L114;
        IRoom r56 = (IRoom) r55.getValue();
        if (r56 == null) goto L114;
        r16 = r56.getId();
    L114:
        MultiSceneEnterRoomStatisticsUtils r57 = MultiSceneEnterRoomStatisticsUtils.a.a(r53, Long.valueOf(r16));
        if (r57 == null) goto L117;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r57, "data_listener", 0, 2, null);
    L117:
        DataCenter r58 = this.C;
        StringBuilder r59 = new StringBuilder("containerView post when start, containerHeight = ");
        r59.append(this.y.getHeight());
        r59.append(", SeatViewHeight = ");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r60 = this.d;
        if (r60 == null) goto L122;
        ViewGroup r61 = r60.td();
        if (r61 == null) goto L122;
        RecyclerView r114 = Integer.valueOf(r61.getHeight());
    L123:
        r59.append(r114);
        MultiLinkLoadWidgetUtils.n(r58, "BaseWindowManager", r59.toString());
        M0();
    L125:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r62 = this.d;
        if (r62 == null) goto L128;
        RecyclerView r115 = r62.getRecyclerView();
    L129:
        this.i = new hg0.d(r115);
        n0(r29, true);
        p0();
        if (this.k != null) goto L136;
        ViewGroup r63 = UtilityKotlinExtentionsKt.p(this.y);
        SeatAnimEngineWrapper r65 = this.l;
        if (r65 == null) goto L134;
        RecyclerView r116 = r65.a;
    L135:
        ThemedCompetitionViewManager r66 = new ThemedCompetitionViewManager(r63, r116);
        this.k = r66;
        this.C.put("data_themed_competition_view_manager", r66);
        goto L136
    L134:
        r116 = r112;
    L136:
        this.o = false;
        if (vm2.d.q0().isOpenSmoothViewMock() == true) goto L139;
    L155:
        this.y.post(new n(this));
        if (PadConfigUtils.c() == false) goto L158;
        RxUtilKt.c(xs2.b.a().b(m81.a.class).subscribe(new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.f(this), com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.g.a), this.e);
    L158:
        kk0.a r67 = new kk0.a(this.x, this.C, this.q, this.r, this);
        i0 r68 = j0.a(r67.b);
        if (r68 == null) goto L161;
        r68.d(sh0.q.b, new kk0.d(r67));
    L161:
        System.currentTimeMillis();
        IInteractService r69 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r69 == null) goto L166;
        ih0.b r70 = r69.dynamicService(this.C);
        if (r70 == null) goto L166;
        RecyclerView r117 = r70.Z9();
    L167:
        if (r117 == null) goto L172;
        View r71 = r117.S0();
        if (r71 == null) goto L173;
        AndroidSchedulers.mainThread().scheduleDirect(new l(r71, this), ((MultiLinkRevenueEnterRoomOptConfig) sp.a.getValue()).adjustLayerDelay(), TimeUnit.MILLISECONDS);
        return;
    L173:
        return;
    L172:
        return;
    L166:
        r117 = r112;
        goto L167
    L139:
        if (this.z.getUiLayout() == 24) goto L155;
        if (y0() == false) goto L155;
        zj0.c r72 = this.A;
        if ((r72 instanceof zj0.c.b) == true) goto L147;
        if ((r72 instanceof zj0.c.C0300c) == false) goto L155;
    L147:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L150;
        ConstraintLayout r73 = this.y;
        Handler r74 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r73, "$this$setVisibilityInVisibleAlpha");
        r73.setAlpha(0.0f);
    L150:
        if (((Boolean) vm2.h.L4.getValue(r112, vm2.h.a[296(0x128, float:4.15E-43)])).booleanValue() == false) goto L155;
        Disposable r75 = this.f;
        if (r75 == null) goto L154;
        r75.dispose();
    L154:
        this.f = Observable.timer(vm2.d.q0().getRemoveViewMockTimeOut(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.a(this));
        goto L155
    L128:
        r115 = r112;
    L122:
        r114 = r112;
        goto L123
    L124:
        this.y.post(new m(this, r14));
    L82:
        r50 = 0;
        goto L83
    L74:
        r45 = 0;
    L70:
        r43 = 0;
        goto L71
    L87:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L102;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r76 = this.d;
        if (r76 == null) goto L91;
        int r77 = r37;
        int r78 = r38;
        r76.Yd(this.z, r78, r77);
    L92:
        FrameLayout r79 = this.c;
        if (r79 == null) goto L102;
        if (r79 == null) goto L96;
        RecyclerView r118 = r79.getLayoutParams();
    L97:
        if (r118 == null) goto L99;
        ((ViewGroup.LayoutParams) r118).width = r78;
        ((ViewGroup.LayoutParams) r118).height = r77;
    L99:
        FrameLayout r80 = this.c;
        if (r80 == null) goto L102;
        r80.setLayoutParams(r118);
        goto L102
    L96:
        r118 = r112;
        goto L97
    L91:
        r77 = r37;
        r78 = r38;
        goto L92
    L58:
        r36 = null;
        goto L59
    L60:
        r37 = r24;
        r38 = r23;
        r210 = "livesdk_audience_loading_statistics";
        r112 = null;
        r113 = 0;
        goto L62
    L42:
        r26 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.l) this.y.findViewById(2131378011);
    L31:
        r20 = 0;
        goto L32
    L23:
        r14 = 0;
    L19:
        r12 = 0;
        goto L20
    L5:
        if (vm2.h.W().smoothLeave() == false) goto L7;
        r4 = true;
        goto L8
    }

    public BaseMultiLinkWindowManager(Context r2, ConstraintLayout r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4, zj0.c r5, com.bytedance.android.live.liveinteract.plantform.datamerge.d r6, DataCenter r7, tf0.o.a r8, LifecycleOwner r9, com.bytedance.android.live.pushstream.d r10, j1 r11) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        this.x = r2;
        this.y = r3;
        this.z = r4;
        this.A = r5;
        this.B = r6;
        this.C = r7;
        this.D = r8;
        this.E = r9;
        this.F = r10;
        this.G = r11;
        this.e = new CompositeDisposable();
        int r12 = je0.i.a;
        HSImageView r13 = null;
        IRoom r14 = je0.d.e(null);
        if (r14 == null) goto L7;
        IStreamUrlExtra r15 = r14.getStreamUrlExtraSafely();
        if (r15 == null) goto L7;
        long r16 = IStreamUrlExtraKt.getWidthFlex(r15);
    L8:
        IRoom r17 = je0.d.e(null);
        if (r17 == null) goto L13;
        IStreamUrlExtra r18 = r17.getStreamUrlExtraSafely();
        if (r18 == null) goto L13;
        long r19 = IStreamUrlExtraKt.getWidthFlex(r18);
    L14:
        int r20 = s1.z();
        int r21 = s1.x();
        if (FoldScreenUtils.e() == true) goto L19;
        if (PadConfigUtils.c() == true) goto L19;
    L25:
        float r22 = r16;
        float r23 = r19;
        float r110 = ((r20 * 1.0f) / (r22 * 1.0f)) * r23;
        float r24 = r21;
        if (r110 <= r24) goto L28;
        r20 = (int) (r22 * ((r24 * 1.0f) / (r23 * 1.0f)));
    L29:
        TuplesKt.to(Integer.valueOf(r20), Integer.valueOf(r21));
        this.n = Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
        new LinkedHashMap();
        ViewParent r25 = r3.getParent();
        if ((r25 instanceof ViewGroup) == true) goto L32;
        r25 = null;
    L32:
        ViewGroup r26 = (ViewGroup) r25;
        if (r26 == null) goto L35;
        ViewGroup r27 = (ViewGroup) r26.findViewById(2131374057);
    L36:
        this.q = r27;
        ViewParent r28 = r3.getParent();
        if ((r28 instanceof ViewGroup) == true) goto L39;
        r28 = null;
    L39:
        ViewGroup r29 = (ViewGroup) r28;
        if (r29 == null) goto L42;
        r13 = (HSImageView) r29.findViewById(2131374056);
    L42:
        this.r = r13;
        this.s = new Pair(0, 0);
        this.t = new Pair(0, 0);
        this.v = a0();
        this.w = new e(this);
        return;
    L35:
        r27 = null;
        goto L36
    L28:
        r21 = (int) r110;
    L19:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L25;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L25;
        if (StatusBarUtil.isStatusBarTransparent() == true) goto L25;
        r21 = s1.x() - s1.A();
    L13:
        r19 = 640;
    L7:
        r16 = 360;
        goto L8
    }
}
