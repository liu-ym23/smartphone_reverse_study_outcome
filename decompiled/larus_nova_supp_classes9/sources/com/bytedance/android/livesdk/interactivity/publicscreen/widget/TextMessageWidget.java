package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.j3;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.panel.PanelCoverListener;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.BaseHeaderLoader;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.LiveMessageRefreshLayout;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.config.aj0;
import com.bytedance.android.livesdk.config.d71;
import com.bytedance.android.livesdk.config.l61;
import com.bytedance.android.livesdk.config.zd1;
import com.bytedance.android.livesdk.f7;
import com.bytedance.android.livesdk.h7;
import com.bytedance.android.livesdk.interactivity.api.IPSTopContainerService;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatDescNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.PublicScreenTextMessageFrameLayout;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommonConfig;
import com.bytedance.android.livesdk.interactivity.api.settings.config.o0;
import com.bytedance.android.livesdk.interactivity.common.accessibility.MessageRvAccessibilityDelegate;
import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.bytedance.android.livesdk.interactivity.publicscreen.framework.PublicScreenBaseWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.framework.PublicScreenExtendsMessageAdapter;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.PSHighLightContainer;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.SelectedMsgViewManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.LiveMessageLoaderTip;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.PinnedMessageDecoration;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenTopLayout;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.RecyclerViewStackHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.RemoveMessageDecoration;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.RiskAdviseView;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.TextMessageLayoutManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.animator.OptScrollItemAnimator;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.TextMessageTimeRecorder;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ec2.c1;
import ec2.d1;
import ec2.e1;
import ec2.f1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r52.a2;
import r52.b2;
import r52.j2;
import r52.o3;
import zg1.i1;
import zg1.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class TextMessageWidget extends PublicScreenBaseWidget implements ITextMessageView, g52.c, Observer<KVData>, WeakHandler.IHandler, com.bytedance.android.livesdk.common.i {
    public static boolean V0;
    public boolean A;
    public boolean B;
    public boolean C;
    public final boolean D;
    public LayoutInflater E;
    public FrameLayout F;
    public ViewGroup G;
    public RiskAdviseView H;
    public int H0;
    public LiveMessageRefreshLayout I;
    public com.bytedance.android.livesdk.interactivity.publicscreen.ui.i J;
    public final TextMessageTimeRecorder K;
    public LiveMessageLoaderTip L;
    public final a L0;
    public ViewGroup M;
    public final boolean N;
    public boolean O;
    public boolean P;
    public boolean P0;
    public boolean Q;
    public OptScrollItemAnimator R;
    public boolean S;
    public boolean T;
    public long U;
    public final w V;
    public SelectedMsgViewManager W;
    public f52.b X;
    public PSHighLightContainer Y;
    public com.bytedance.android.livesdk.interactivity.publicscreen.utils.n Z;
    public final WeakHandler f;
    public Boolean g;
    public View h;
    public PublicScreenTopLayout i;
    public TextView j;
    public FrameLayout k;
    public final boolean k0;
    public com.bytedance.android.livesdk.interactivity.publicscreen.pin.c l;
    public PinnedMessageDecoration m;
    public ListScrollState n;
    public LiveMessageRecyclerView o;
    public MessageListAdapter p;
    public final int p0;
    public TextMessageLayoutManager q;
    public aa2.a r;
    public SpaceItemDecoration s;
    public aa2.b t;
    public r42.h u;
    public final RecyclerViewStackHelper v;
    public int w;
    public int x;
    public long y;
    public IRoom z;

    public static final enum ListScrollState extends Enum<ListScrollState> {
        public static final ListScrollState FOCUS = null;
        public static final ListScrollState NORMAL = null;
        public static final /* synthetic */ ListScrollState[] a = null;

        static {
            ListScrollState r0 = new ListScrollState("NORMAL", 0);
            NORMAL = r0;
            ListScrollState r1 = new ListScrollState("FOCUS", 1);
            FOCUS = r1;
            a = new ListScrollState[]{r0, r1};
        }

        public static ListScrollState[] values() {
            return (ListScrollState[]) a.clone();
        }

        public static ListScrollState valueOf(String r1) {
            return (ListScrollState) r27.a.a(ListScrollState.class, r1);
        }

        public ListScrollState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a extends PanelCoverListener {
        public final /* synthetic */ TextMessageWidget c;

        public final String getName() {
            return "TextMessageWidget";
        }

        public final View d() {
            long r0 = System.currentTimeMillis();
            if ((r0 - this.c.U) <= 500) goto L6;
            TextMessageWidget.zq("getViewForAction", false, "Unknown visibility");
            this.c.U = r0;
        L6:
            return ((Widget) this.c).contentView;
        }

        public final void f() {
            super.f();
            this.c.Br("visibility_panel_open_hide");
        }

        public final void g() {
            super.g();
            this.c.Br("visibility_panel_open_show");
        }

        public a(TextMessageWidget r1) {
            this.c = r1;
        }

        public final boolean e(com.bytedance.android.live.room.api.panel.e r11) {
            PanelName r0 = r11.a;
            if (r0 != PanelName.RightCard) goto L5;
        L70:
            return false;
        L5:
            if (r0 == PanelName.Predictor) goto L70;
            IRoom r1 = this.c.z;
            String r2 = r0.getPanelName();
            Intrinsics.checkNotNullParameter("TextMessageWidget", "panelCoverName");
            Intrinsics.checkNotNullParameter(r2, "panelName");
            d71 r4 = (d71) aj0.a.getValue();
            if (r1 != null) goto L9;
        L51:
            boolean r3 = true;
        L52:
            if (r3 == false) goto L70;
            aa2.a r5 = this.c.r;
            if (r5 != null) goto L56;
        L58:
            int r13 = r11.d;
            InteractionWidgetsPosContext r6 = InteractionWidgetsPosContext.getShared(((Widget) this.c).dataCenter, 0);
            if (r6 == null) goto L61;
            int r7 = ((Integer) r6.getPublicScreenHeight().getValue()).intValue();
        L62:
            ALogger.i("PanelCoverListener", "panelHeight = " + r13 + ", textWidgetHeight = " + r7);
            int r8 = ((Integer) b2.a.getValue()).intValue();
            float r9 = ((Float) a2.a.getValue()).floatValue();
            if (r8 == 2) goto L65;
        L67:
            if (r8 != 1) goto L70;
            if (r13 < r7) goto L70;
            return true;
        L65:
            if (r13 < (r7 * r9)) goto L67;
            return true;
        L61:
            r7 = 0;
            goto L62
        L56:
            if (r5.T() == false) goto L58;
        L9:
            if (r1.isGameRoom() != 1) goto L51;
            if (r4.a() == false) goto L51;
            if (r2.length() != 0) goto L15;
            boolean r10 = true;
        L16:
            if (r10 == true) goto L51;
            List r14 = r4.b();
            Object r15 = null;
            if (r14 == null) goto L31;
            ListIterator r16 = r14.listIterator(r14.size());
        L22:
            if (r16.hasPrevious() == false) goto L29;
            Object r17 = r16.previous();
            String r18 = ((zd1) r17).b();
            if (r18 != null) goto L27;
            r18 = BuildConfig.FLAVOR;
        L27:
            if (Intrinsics.areEqual(r18, "TextMessageWidget") == false) goto L22;
        L30:
            zd1 r19 = (zd1) r17;
        L32:
            if (r19 == null) goto L49;
            List r20 = r19.a();
            if (r20 == null) goto L49;
            Iterator r21 = r20.iterator();
        L37:
            if (r21.hasNext() == false) goto L41;
            Object r23 = r21.next();
            if (Intrinsics.areEqual((String) r23, r2) == false) goto L37;
            r15 = r23;
        L41:
            String r24 = (String) r15;
            if (r24 == null) goto L49;
            if (r24.length() <= 0) goto L46;
            boolean r25 = true;
        L47:
            if (r25 != true) goto L49;
            boolean r26 = true;
        L50:
            StringBuilder r27 = new StringBuilder("shouldHide ");
            r3 = !r26;
            r27.append(r3);
            r27.append(" coverName:TextMessageWidget panelName:");
            r27.append(r2);
            r27.append(", config:");
            r27.append(r4);
            ALogger.i("PanelCoverListener", r27.toString());
            goto L52
        L46:
            r25 = false;
        L49:
            r26 = false;
            goto L50
        L29:
            r17 = null;
            goto L30
        L31:
            r19 = null;
            goto L32
        L15:
            r10 = false;
            goto L16
        }
    }

    public class b implements no1.e {
        public final /* synthetic */ TextMessageWidget a;

        public b(TextMessageWidget r1) {
            this.a = r1;
        }
    }

    public class c implements v92.a {
        public final /* synthetic */ TextMessageWidget a;

        @Override // v92.a
        public final void preload() {
            ALogger.i("HistoryMessageDebug", "hasPullDown = " + this.a.O);
            TextMessageWidget r0 = this.a;
            if (r0.r != null) goto L5;
            return;
        L5:
            if (r0.O == false) goto L9;
            ALogger.i("HistoryMessageDebug", "用户手动下拉触发预加载");
            this.a.r.a();
            return;
        }

        public c(TextMessageWidget r1) {
            this.a = r1;
        }
    }

    public class d extends RecyclerView.OnScrollListener {
        public final /* synthetic */ TextMessageWidget a;

        public d(TextMessageWidget r1) {
            this.a = r1;
        }

        public final void onScrollStateChanged(RecyclerView r1, int r2) {
            super.onScrollStateChanged(r1, r2);
            if (r2 != 1) goto L5;
            this.a.A = false;
            return;
        L5:
            if (r2 != 0) goto L11;
            TextMessageWidget r3 = this.a;
            if (r3.A == false) goto L12;
            r3.Eq(ListScrollState.NORMAL);
            return;
        L12:
            return;
        }

        public final void onScrolled(RecyclerView r10, int r11, int r13) {
            super.onScrolled(r10, r11, r13);
            TextMessageWidget r14 = this.a;
            if (r14.P == false) goto L5;
        L7:
            final TextMessageWidget r15 = this.a;
            boolean r2 = false;
            if (r15.q == null) goto L38;
            if (r15.P0 == true) goto L38;
            if (r15.P == false) goto L38;
            LiveMessageRecyclerView r0 = r15.o;
            if (r0 == null) goto L38;
            if (r0.isComputingLayout() == true) goto L38;
            r15.P0 = true;
            r15.q.setStackFromEnd(true);     // Catch: IllegalStateException -> L35
            r15.S = true;
            r15.T = ((Boolean) PublicScreenABHelper.o.getValue()).booleanValue();
            r15.v.j();
            if (((Boolean) PublicScreenABHelper.n.getValue()).booleanValue() == false) goto L38;
            if (r15.R != null) goto L32;
            OptScrollItemAnimator r1 = new OptScrollItemAnimator();
            r15.R = r1;
            r1.setSupportsChangeAnimations(false);
            r15.R.setChangeDuration(0);
            r15.R.setRemoveDuration(0);
            r15.R.b = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q.e(gb2.a.a(((Widget) r15).dataCenter, false), r15.isScreenPortrait());
            float r3 = (r15.xq().n * 1.0f) / s1.v();
            OptScrollItemAnimator r5 = r15.R;
            if (r3 >= 0.0f) goto L27;
            r5.getClass();
            ALogger.e("BaseScrollItemAnimator", "scroll speed has negative value!!!");
        L28:
            OptScrollItemAnimator r4 = r15.R;
            long r6 = r15.xq().o;
            if (r6 >= 0) goto L31;
            r4.getClass();
            ALogger.e("BaseScrollItemAnimator", "max duration has negative value!!!");
            goto L32
        L31:
            r4.c = r6;
            goto L32
        L27:
            r5.a = r3;
        L32:
            r15.o.setItemAnimator(r15.R);
            r15.o.setOnCustomVisibleChangedListener(new com.bytedance.android.livesdk.interactivity.publicscreen.widget.f(r15));
            if (((Boolean) PublicScreenABHelper.r.getValue()).booleanValue() == false) goto L38;
            r15.o.setOnHeightChangeListener(new com.bytedance.android.livesdk.interactivity.publicscreen.widget.g(r15));
        L35:
            e = move-exception;
            SafetyGuard.a(null, e, "RecyclerView stackFromEnd Exception");
        L38:
            if (r13 >= (-10)) goto L40;
            this.a.B = true;
        L40:
            TextMessageWidget r16 = this.a;
            if (r13 <= 10) goto L43;
            r2 = true;
        L43:
            r16.C = r2;
            if (r10.canScrollVertically(1) == false) goto L51;
            TextMessageWidget r17 = this.a;
            if (r17.A == false) goto L48;
            return;
        L48:
            int r18 = r17.q.findLastVisibleItemPosition();
            TextMessageWidget r19 = this.a;
            int r110 = r19.x;
            if (r18 <= r110) goto L55;
            r19.Cq(r19.w - (r18 - r110));
            this.a.x = r18;
            return;
        L55:
            return;
        L51:
            this.a.Eq(ListScrollState.NORMAL);
            return;
        L5:
            if (r14.q.findFirstCompletelyVisibleItemPosition() <= 0) goto L7;
            this.a.P = true;
            goto L7
        }
    }

    public class e implements View.OnTouchListener {
        public double a;
        public final /* synthetic */ TextMessageWidget b;

        public e(TextMessageWidget r1) {
            this.b = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r9, MotionEvent r10) {
            if (r10.getAction() != 1) goto L31;
            if ((!this.b.o.canScrollVertically(1)) == false) goto L7;
            this.b.Eq(ListScrollState.NORMAL);
        L10:
            TextMessageWidget r11 = this.b;
            if (r11.B == false) goto L21;
            if (((Boolean) ec2.d.a.getValue()).booleanValue() == false) goto L19;
            HashMap r13 = new HashMap();
            int r6 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a;     // Catch: Exception -> L48
            String r14 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.b(((Widget) r11).dataCenter);     // Catch: Exception -> L48
            if (r14 == null) goto L18;
            r13.put("bind_component_type", r14);     // Catch: Exception -> L48
        L18:
            j0 r15 = j0.l();
            am2.x r7 = new am2.x();
            r7.b = "live_detail";
            r15.sendLog("livesdk_comment_slide_up", r13, new Object[]{r7, IRoom.class});
            goto L21
        L19:
            j0 r16 = j0.l();
            am2.x r8 = new am2.x();
            r8.b = "live_detail";
            r16.sendLog("livesdk_comment_slide_up", null, new Object[]{r8, IRoom.class});
        L21:
            if (((Boolean) ec2.e.a.getValue()).booleanValue() == false) goto L29;
            TextMessageWidget r17 = this.b;
            if (r17.C == false) goto L29;
            HashMap r18 = new HashMap();
            int r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a;     // Catch: Exception -> L49
            String r19 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.b(((Widget) r17).dataCenter);     // Catch: Exception -> L49
            if (r19 == null) goto L28;
            r18.put("bind_component_type", r19);     // Catch: Exception -> L49
        L28:
            j0 r20 = j0.l();
            am2.x r3 = new am2.x();
            r3.b = "live_detail";
            r20.sendLog("livesdk_comment_slide_down", r18, new Object[]{r3, IRoom.class});
        L29:
            TextMessageWidget r21 = this.b;
            r21.B = false;
            r21.C = false;
        L47:
            return false;
        L7:
            this.b.Eq(ListScrollState.FOCUS);
            int r23 = this.b.q.findLastVisibleItemPosition();
            TextMessageWidget r110 = this.b;
            int r4 = r110.x;
            if (r23 <= r4) goto L10;
            r110.Cq(r110.w - (r23 - r4));
            this.b.x = r23;
            goto L10
        L31:
            if (r10.getAction() != 3) goto L34;
            TextMessageWidget r24 = this.b;
            r24.B = false;
            r24.C = false;
            goto L47
        L34:
            if (r10.getAction() != 0) goto L37;
            this.a = r10.getRawY();
            goto L47
        L37:
            if (r10.getAction() != 2) goto L47;
            if ((((double) r10.getRawY()) - this.a) <= 10.0d) goto L47;
            TextMessageWidget r25 = this.b;
            if (r25.T == false) goto L47;
            ListScrollState r111 = r25.n;
            ListScrollState r0 = ListScrollState.FOCUS;
            if (r111 == r0) goto L47;
            r25.Eq(r0);
            int r26 = this.b.q.findLastVisibleItemPosition();
            TextMessageWidget r112 = this.b;
            int r1 = r112.x;
            if (r26 <= r1) goto L47;
            r112.Cq(r112.w - (r26 - r1));
            this.b.x = r26;
            goto L47
        }
    }

    public class f extends RecyclerView.OnFlingListener {
        public final /* synthetic */ TextMessageWidget a;

        public f(TextMessageWidget r1) {
            this.a = r1;
        }

        public final boolean onFling(int r3, int r4) {
            if (r4 == 0) goto L4;
            return false;
        L4:
            if ((!this.a.o.canScrollVertically(1)) == false) goto L6;
            this.a.Eq(ListScrollState.NORMAL);
            return false;
        L6:
            this.a.Eq(ListScrollState.FOCUS);
            int r5 = this.a.q.findLastVisibleItemPosition();
            TextMessageWidget r6 = this.a;
            int r0 = r6.x;
            if (r5 <= r0) goto L13;
            r6.Cq(r6.w - (r5 - r0));
            this.a.x = r5;
            return false;
        L13:
            return false;
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ TextMessageWidget a;

        public final void a() {
            final TextMessageWidget r0 = this.a;
            boolean r1 = TextMessageWidget.V0;
            r0.getClass();
            r0.L7(jd0.g.class, new com.bytedance.android.livesdk.interactivity.publicscreen.widget.h(r0));
            r0.L7(kd0.a.class, new i(r0));
            r0.L7(i1.class, new j(r0));
            r0.L7(u22.d.class, new k(r0));
            r0.L7(u22.e.class, new l(r0));
            r0.L7(com.bytedance.android.livesdk.interactivity.api.r.class, new n(r0));
            r0.L7(zg1.s.class, new o(r0));
            r0.L7(zg1.e0.class, new p(r0));
            RxBusAbility.INSTANCE.getRxBus(((Widget) r0).dataCenter).b(o42.b.class).compose(r0.getAutoUnbindTransformer()).subscribe(new q(r0));
            ((Widget) r0).dataCenter.observeForever("data_normal_gift_end_event", r0).observeForever("cmd_hide_in_douyin_commerce", r0).observe("data_media_introduction_showing", r0).observe("data_pre_show_keyboard", r0).observe("data_keyboard_status_douyin", r0).observe("data_keyboard_status", r0).observe("cmd_widget_loaded", r0).observeForever("cmd_show_dynamic_emoji_in_comment", r0).observe("cmd_scroll_public_screen_msg_to_last", r0).observe("data_room_comment_status", r0).observe("DATA_PUBLIC_SCREEN_OVERLAPPING_HEIGHT", r0);
            int r2 = com.bytedance.android.live.room.api.panel.d.a;
            com.bytedance.android.live.room.api.panel.c r3 = com.bytedance.android.live.room.api.panel.d.b(((Widget) r0).dataCenter, 0);
            if (r3 != null) goto L5;
            return;
        L5:
            if (r0.isScreenPortrait() == false) goto L9;
            r3.registerPanelListener(r0.L0);
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

        public g(TextMessageWidget r1) {
            this.a = r1;
        }
    }

    public class h extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ TextMessageWidget c;

        public final void run() {
            final TextMessageWidget r7 = this.c;
            boolean r1 = TextMessageWidget.V0;
            if (((Widget) r7).dataCenter != null) goto L5;
            boolean r2 = TextMessageTracer.a;
            TextMessageTracer.A("prepare view error, dataCenter is null");
        L121:
            b(true);
            return;
        L5:
            TextMessageTimeRecorder r3 = r7.K;
            LiveMessageRecyclerView r4 = r7.o;
            r3.a.clear();
            if (r4 == null) goto L8;
            r4.removeOnScrollListener(r3.c);
            r4.addOnScrollListener(r3.c);
            r4.setOnVisibilityChangedListener(r3);
            Unit r5 = Unit.INSTANCE;
        L9:
            r3.b = r4;
            Intrinsics.checkNotNullParameter(r7, "textMessageView");
            PublicScreenContext r6 = r7.a;
            if (r6 == null) goto L12;
            MessageListAdapter r8 = new PublicScreenExtendsMessageAdapter(r6, r7);
        L13:
            r7.p = r8;
            r8.i = ((Widget) r7).dataCenter;
            if (((o72.e) d1.a.getValue()).b() == false) goto L16;
            r7.p.c = new e0(r7);
        L16:
            DataCenter r9 = ((Widget) r7).dataCenter;
            boolean r10 = false;
            if (r9 != null) goto L19;
        L21:
            final boolean r11 = false;
        L22:
            q92.a r13 = r7.xq();
            r13.m = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q.a(r13, r7.isScreenPortrait(), r11);
            r7.o.setAdapter(r7.p);
            r7.o.setItemViewCacheSize(4);
            RecyclerViewStackHelper r14 = r7.v;
            LiveMessageRecyclerView r15 = r7.o;
            r14.getClass();
            Intrinsics.checkNotNullParameter(r15, "recyclerView");
            r14.a = r15;
            if (r15 == null) goto L26;
            r15.addOnScrollListener(r14);
        L26:
            if (((Widget) r7).dataCenter.get("data_room_id") == null) goto L121;
            if (r7.getRoomContext() != null) goto L32;
            ALogger.e("HISTORY_COMMENT_TAG", "getRoomContext failed in Widget");
        L46:
            aa2.a r16 = (aa2.a) ((Widget) r7).dataCenter.get("data_room_text_message_presenter", null);
            if (r16 != null) goto L49;
            r16 = r7.wq();
        L49:
            r7.r = r16;
            ((Widget) r7).dataCenter.put("data_room_text_message_presenter", r16);
            r7.E = LayoutInflater.from(((Widget) r7).context);
            if (((Widget) r7).dataCenter != null) goto L52;
        L65:
            int r17 = u42.f.a;
            Intrinsics.checkNotNullParameter("create PinManager failed.", "info");
            ALogger.i("PublicScreenPinContainer", "create PinManager failed.");
        L66:
            aa2.a r18 = r7.r;
            if (r18 == null) goto L69;
            r18.X(new f0(r7));
        L69:
            aa2.b r19 = new aa2.b(r7.xq().d);
            r7.t = r19;
            r19.A(r7);
            r7.p.a = r7.E;
            ALogger.i("PublicScreenFirstMessageProcessorV2", "prepareViewOnLoad，messageList size is :" + r7.r.getMessageList().size());
            r7.p.b = r7.r.getMessageList();
            MessageListAdapter r20 = r7.p;
            r20.g = r11;
            q92.a r21 = r7.xq();
            r20.e = r21;
            r20.f = r21.p;
            com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r23 = r7.Z;
            if (r23 == null) goto L72;
            r23.a(r7.p);
        L72:
            q92.a r24 = r7.xq();
            boolean r25 = r7.isScreenPortrait();
            Intrinsics.checkNotNullParameter(r24, "textConfig");
            if (r25 == false) goto L75;
        L77:
            n42.a r26 = r24.h();
        L78:
            r7.h.setMinimumHeight(r26.k);
            r7.h.setBackgroundResource(r26.l);
            r7.j.setTextColor(r26.j);
            r7.j.setTextSize(0, r26.i);
            if (((Boolean) ((Widget) r7).dataCenter.get("data_has_change_screen_orientation", Boolean.FALSE)).booleanValue() == false) goto L81;
            r7.q.scrollToPosition(r7.p.getItemCount() - 1);
        L81:
            r7.o.setScrollBehavior(1);
            r7.r.A(r7);
            r7.Cq(0);
            ((Widget) r7).dataCenter.put("text_msg_widget_ready", BuildConfig.FLAVOR);
            com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.a(r7, r7.z, r11, r7.isScreenPortrait(), r7.r.G());
            if (r7.isScreenPortrait() == false) goto L99;
            IPSTopContainerService r27 = (IPSTopContainerService) jc1.k.f(IPSTopContainerService.class);
            FrameLayout r28 = (FrameLayout) r7.findViewById(2131374541);
            r7.F = r28;
            if (r28 == null) goto L95;
            if (r27 == null) goto L95;
            com.bytedance.android.livesdk.interactivity.api.settings.config.g0.a.getClass();
            if (((com.bytedance.android.livesdk.interactivity.api.settings.config.g0) j2.a.getValue()).a() == false) goto L95;
            com.bytedance.android.livesdk.interactivity.api.h r29 = com.bytedance.android.livesdk.interactivity.api.i.a(r7.getRoomContext(), ((Widget) r7).dataCenter);
            if (r29 == null) goto L93;
            f52.b r30 = r27.createPSTopContainer(r7.F, ((Widget) r7).dataCenter);
            r7.X = r30;
            if (r30 == null) goto L95;
            r30.onCreate();
            r29.getPsTopContainer().setValue(r30);
            goto L95
        L93:
            boolean r31 = TextMessageTracer.a;
            TextMessageTracer.z(new com.bytedance.android.livesdk.interactivity.publicscreen.widget.c());
        L95:
            if (r7.isScreenPortrait() == false) goto L99;
            RiskAdviseView r33 = (RiskAdviseView) r7.findViewById(2131384650);
            r7.H = r33;
            if (r33 == null) goto L99;
            r33.a(((Widget) r7).dataCenter, r7.z);
        L99:
            ViewGroup r34 = (ViewGroup) r7.findViewById(2131374350);
            r7.G = r34;
            if (r34 == null) goto L118;
            DataCenter r35 = ((Widget) r7).dataCenter;
            com.bytedance.android.livesdk.interactivity.api.settings.config.z.a.getClass();
            if (com.bytedance.android.livesdk.interactivity.api.settings.config.z.a.a(r35) == true) goto L113;
            DataCenter r36 = ((Widget) r7).dataCenter;
            PSHighlightCommonConfig.b.getClass();
            if (r36 != null) goto L106;
        L107:
            if (r36 != null) goto L109;
        L111:
            r10 = ((PSHighlightCommonConfig) PSHighlightCommonConfig.a.getValue()).b();
        L112:
            if (r10 == false) goto L118;
        L109:
            if (com.bytedance.android.live.core.utils.a0.j(r36) != true) goto L111;
        L106:
            if (com.bytedance.android.live.core.utils.a0.k(r36) == true) goto L112;
        L113:
            com.bytedance.android.livesdk.interactivity.api.h r37 = com.bytedance.android.livesdk.interactivity.api.i.a(r7.getRoomContext(), ((Widget) r7).dataCenter);
            if (r37 == null) goto L118;
            r37.getHighlightContext().e(new com.bytedance.android.livesdk.interactivity.publicscreen.widget.d(r7));
            com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k r38 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k) r37.getHighlightContext().getValue();
            if (r38 == null) goto L118;
            PSHighLightContainer r39 = new PSHighLightContainer(r7.G, r38);
            r38.bindContainer(r39);
            r7.Y = r39;
            r39.c.mo774getLaunchManager().a();
        L118:
            r7.runWithRoomEntered(new com.bytedance.android.livesdk.interactivity.publicscreen.widget.e(r7, r11));
            DataCenter r40 = ((Widget) r7).dataCenter;
            if (r40 == null) goto L121;
            r40.put("cmd_text_message_widget_loaded", new Object());
            goto L121
        L75:
            if (r24.f() == false) goto L77;
            r26 = r24.d();
            goto L78
        L52:
            if (r7.k == null) goto L65;
            if (r7.r == null) goto L65;
            if (r7.p == null) goto L65;
            if (r7.q == null) goto L65;
            r7.l = new com.bytedance.android.livesdk.interactivity.publicscreen.pin.c(((Widget) r7).dataCenter, r7.k, r7.r, r7.p, r7.q);
            u42.f.a("onLoad");
            PublicScreenContext r41 = r7.a;
            if (r41 == null) goto L62;
            r41.getPinManager().d(r7.l);
        L62:
            PinnedMessageDecoration r43 = r7.m;
            if (r43 == null) goto L66;
            r43.a = r7.l;
            goto L66
        L32:
            if (com.bytedance.android.livesdk.interactivity.api.i.a(r7.getRoomContext(), ((Widget) r7).dataCenter) != null) goto L35;
            ALogger.e("HISTORY_COMMENT_TAG", "getInteractivityContext failed in Presenter");
            goto L46
        L35:
            if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L37;
        L38:
            r42.h r44 = (r42.h) com.bytedance.android.livesdk.interactivity.api.i.a(r7.getRoomContext(), ((Widget) r7).dataCenter).getHistoryDataManager().getValue();
            r7.u = r44;
            if (r44 != null) goto L46;
        L41:
            IRoom r45 = r7.z;
            if (r42.g.c() == false) goto L44;
            r42.i r46 = new r42.m(r45);
        L45:
            r7.u = new r42.h(r46);
            com.bytedance.android.livesdk.interactivity.api.i.a(r7.getRoomContext(), ((Widget) r7).dataCenter).getHistoryDataManager().d(r7.u);
            ALogger.i("HISTORY_COMMENT_TAG", "historyDataManager inited");
            goto L46
        L44:
            r46 = new r42.k(r45);
            goto L45
        L37:
            if (((Boolean) ((Widget) r7).dataCenter.get("data_longer_video_within_live_type", Boolean.FALSE)).booleanValue() == false) goto L41;
        L19:
            if (((Boolean) r9.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L21;
            r11 = true;
            goto L22
        L12:
            r8 = new MessageListAdapter(r7);
            goto L13
        L8:
            r4 = null;
            goto L9
        }

        public h(TextMessageWidget r1) {
            this.c = r1;
            super("live_text_message_widget_load");
        }
    }

    public final /* synthetic */ String Lg() {
        return com.bytedance.android.livesdk.common.h.b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void ZE() {
    }

    public final /* synthetic */ String cg() {
        return com.bytedance.android.livesdk.common.h.c(this);
    }

    public final int getLayoutId() {
        return 2131567401;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a149";
    }

    public final String nc() {
        return "TextMessageWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public void onEvent(u22.e r1) {
    }

    public final int supportClearScene() {
        return 309;
    }

    static {
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a r0 = com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a;
        r0.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r1 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.b;
        ea2.a r2 = new ea2.a();
        Intrinsics.checkNotNullParameter(r2, "extraSpansFactory");
        ((HashSet) com.bytedance.android.livesdk.interactivity.service.textrender.core.r.c).add(r2);
        r0.getClass();
        vb2.b r3 = new d0();
        Intrinsics.checkNotNullParameter(r3, "proxy");
        Intrinsics.checkNotNullParameter(vb2.b.class, "type");
        ((HashMap) com.bytedance.android.livesdk.interactivity.service.textrender.core.r.f.a).put(vb2.b.class, r3);
    }

    public final void Aq() {
        ListScrollState r0 = this.n;
        ListScrollState r1 = ListScrollState.FOCUS;
        if (r0 == r1) goto L6;
        Eq(r1);
        this.A = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void Ev() {
        LiveMessageRecyclerView r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getChildCount() <= 0) goto L9;
        pa(this.o.getChildCount());
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void a40() {
        if (this.L == null) goto L37;
        r42.h r0 = this.u;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r42.g.b() == true) goto L11;
    L28:
        boolean r1 = false;
    L29:
        if (r1 == true) goto L32;
        return;
    L32:
        if (this.L.getVisibility() != 8) goto L38;
        this.L.setVisibility(0);
        i0.c().postDelayed(this.V, 3000);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r2 = l42.a.a;
        Boolean r3 = Boolean.TRUE;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        if (this.z == null) goto L39;
        j0.l().sendLog("livesdk_history_comment_remind", new HashMap(), new Object[]{new am2.x(), IRoom.class});
        return;
    L39:
        return;
    L38:
        return;
    L11:
        if (((Boolean) l42.a.a.getValue()).booleanValue() == true) goto L28;
        IRoomContextService r4 = jc1.k.f(IRoomContextService.class);
        long r5 = 0;
        com.bytedance.android.livesdk.chatroom.o r6 = null;
        if (r4 == null) goto L16;
        r6 = IRoomContextService.a.a(r4, null, 0, 3);
    L16:
        if (r6 == null) goto L23;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L23;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L23;
        r5 = r8.getUserCount();
    L23:
        if (r5 < 0) goto L28;
        if (r5 > r0.a) goto L28;
        r1 = r0.b.a();
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.bytedance.android.livesdk.interactivity.publicscreen.highlight.PSHighLightContainer, f52.b] */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [aa2.b, com.bytedance.android.livesdk.interactivity.publicscreen.pin.c, java.lang.Object] */
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.framework.PublicScreenBaseWidget
    public final void onUnload() {
        ALogger.i("TextMessageWidget", "unload");
        super.onUnload();
        ALogger.i("TextMessaget_preload", "onUnload::::     dataCenter" + ((Widget) this).dataCenter.hashCode() + " widget : " + hashCode());
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r1 = this.Z;
        if (r1 == null) goto L5;
        r1.a.removeMessages(7);
    L5:
        this.P = false;
        this.Q = false;
        LiveMessageRecyclerView r2 = this.o;
        if (r2 == null) goto L8;
        r2.setItemAnimator(null);
        this.o.setOnCustomVisibleChangedListener(null);
        this.o.setOnHeightChangeListener(null);
    L8:
        SelectedMsgViewManager r3 = this.W;
        if (r3 == null) goto L23;
        r3.e = false;
        vlc.d r4 = (vlc.d) r3.i.get("data_message_manager");
        if (r4 == null) goto L13;
        r4.removeMessageListener(r3);
    L13:
        r3.d.clear();
        if (r3.c == false) goto L22;
        Object r5 = r3.d();
        if ((r5 instanceof View) == true) goto L18;
        r5 = null;
    L18:
        View r6 = (View) r5;
        if (r6 == null) goto L21;
        r3.j.removeView(r6);
    L21:
        r3.d().onClear();
    L22:
        this.W = null;
    L23:
        this.S = false;
        this.T = false;
        this.P0 = false;
        this.n = ListScrollState.NORMAL;
        Lazy r7 = PublicScreenABHelper.a;
        if (PublicScreenABHelper.i(this.z) == true) goto L28;
        TextMessageLayoutManager r8 = this.q;
        if (r8 == null) goto L28;
        r8.setStackFromEnd(false);
    L28:
        RecyclerViewStackHelper r9 = this.v;
        RecyclerView r10 = r9.a;
        if (r10 == null) goto L31;
        r10.removeOnScrollListener(r9);
    L31:
        r9.a = null;
        r9.b = true;
        TextMessageTimeRecorder r11 = this.K;
        Iterator<T> r13 = r11.a.iterator();
    L33:
        if (r13.hasNext() == false) goto L37;
        Object r14 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r13.next()).D().a;
        if (r14 == null) goto L33;
        ((DisplayTimeRecorder) r14).a(com.bytedance.android.livesdk.interactivity.api.entity.g.b.a);
        goto L33
    L37:
        r11.a.clear();
        LiveMessageRecyclerView r15 = r11.b;
        if (r15 == null) goto L40;
        r15.removeOnScrollListener(r11.c);
        r15.setOnVisibilityChangedListener(null);
    L40:
        r11.b = null;
        this.O = false;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r16 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.b;
        IRoom r17 = this.z;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a r18 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b;
        long r19 = r18.a;
        long r20 = 10;
        if (r19 <= r20) goto L50;
        float r21 = (r19 - r18.c) / r19;
        long r23 = r18.b / r19;
        if (r21 >= 0.0f) goto L45;
    L49:
        IRoom r24 = r17;
    L51:
        long r25 = r18.d;
        if (r25 <= r20) goto L60;
        float r26 = (r25 - r18.f) / r25;
        long r110 = r18.e / r25;
        if (r26 < 0.0f) goto L60;
        if (r26 > 1.0f) goto L60;
        if (r110 < 0) goto L60;
        LiveMonitor.a r27 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a("ttlive_text_render_engine_render_all", r24);
        r27.f("success_rate", r26);
        r27.g("latency", r110);
        r27.a().report();
    L60:
        long r28 = r18.d;
        if (r28 <= r20) goto L64;
        float r29 = ((r18.g + r18.h) + r18.i) / r28;
        LiveMonitor.a r30 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a("ttlive_text_render_engine_image_error", r24);
        r30.f("failed_rate", r29);
        r30.g("image_error_count_due_to_info", r18.g);
        r30.g("image_error_count_due_to_load", r18.h);
        r30.g("image_error_count_due_to_convert", r18.i);
        r30.a().report();
    L64:
        if (r18.j <= r20) goto L66;
        LiveMonitor.a r31 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a("ttlive_text_render_engine_gift_all", r24);
        r31.g("gift_giant_resource_count", r18.j);
        r31.a().report();
    L66:
        r18.a = 0;
        r18.b = 0;
        r18.c = 0;
        r18.d = 0;
        r18.e = 0;
        r18.f = 0;
        r18.g = 0;
        r18.h = 0;
        r18.i = 0;
        r18.j = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u r33 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b;
        IRoom r34 = this.z;
        aa2.a r35 = this.r;
        if (r35 != null) goto L69;
        int r36 = 0;
    L70:
        r33.s(this, r34, new s42.c.b(r36));
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
        UIUtils.setViewVisibility(this.F, 0);
        ((Widget) this).dataCenter.removeObserver(this);
        Boolean r37 = Boolean.FALSE;
        this.g = r37;
        aa2.a r38 = this.r;
        if (r38 == null) goto L73;
        r38.detachView();
    L73:
        aa2.b r39 = this.t;
        if (r39 == null) goto L76;
        r39.detachView();
        this.t = null;
    L76:
        LiveMessageRecyclerView r40 = this.o;
        MessageListAdapter r41 = this.p;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r43 = this.Z;
        if (r40 == null) goto L84;
        if (r41 == null) goto L84;
        r41.b = new ArrayList();
        if (r43 == null) goto L83;
        r43.a(r41);
    L83:
        ?? r44 = 0;
        r40.setItemAnimator(null);
    L85:
        aa2.b r45 = this.t;
        if (r45 == null) goto L88;
        r45.detachView();
        this.t = r44;
    L88:
        com.bytedance.android.livesdk.interactivity.publicscreen.pin.c r46 = this.l;
        if (r46 == null) goto L93;
        u42.f.a("onUnload");
        r46.c(true, r37);
        r46.b().removeCallbacksAndMessages(r44);
        this.l = r44;
        PinnedMessageDecoration r47 = this.m;
        if (r47 == null) goto L94;
        r47.a = r44;
    L94:
        aa2.a r48 = this.r;
        if (r48 == null) goto L97;
        r48.X(null);
    L97:
        com.bytedance.android.livesdk.interactivity.api.h r49 = com.bytedance.android.livesdk.interactivity.api.i.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r49 == null) goto L113;
        f52.b r50 = this.X;
        if (r49.isAlive() == false) goto L102;
        r49.getPsTopContainer().setValue(null);
    L102:
        if (r50 == null) goto L104;
        r50.onDestroy();
    L105:
        boolean r51 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.a;
        com.bytedance.android.livesdk.interactivity.api.h r53 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r53 == null) goto L112;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l> r54 = r53.getAudienceOperateManager();
        if (r54 == null) goto L112;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l r55 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l) r54.getValue();
        if (r55 == null) goto L112;
        r55.a();
    L112:
        ?? r56 = 0;
    L114:
        this.X = r56;
        PSHighLightContainer r57 = this.Y;
        if (r57 == null) goto L117;
        r57.e();
        this.Y = r56;
    L117:
        RiskAdviseView r58 = this.H;
        if (r58 == null) goto L135;
        DataCenter r59 = ((Widget) this).dataCenter;
        IRoom r60 = this.z;
        r58.a.setText(BuildConfig.FLAVOR);
        Disposable r61 = r58.b;
        if (r61 == null) goto L122;
        r61.dispose();
    L122:
        IRoomContextService r63 = jc1.k.f(IRoomContextService.class);
        if (r63 == null) goto L134;
        if (r60 == null) goto L126;
        long r64 = r60.getRoomId();
    L127:
        com.bytedance.android.livesdk.chatroom.o r65 = r63.getRoomDataContext(r59, r64);
        if (r65 == null) goto L134;
        com.bytedance.live.datacontext.j r66 = r65.getMessageManager();
        if (r66 == null) goto L134;
        vlc.d r67 = (vlc.d) r66.getValue();
        if (r67 == null) goto L134;
        r67.removeMessageListener("WebcastPlatformAdviseMessage", r58.e);
        goto L134
    L126:
        r64 = 0;
    L134:
        UtilityKotlinExtentionsKt.t(r58);
    L135:
        IPerformanceStrategyManager r68 = jc1.k.f(IPerformanceStrategyManager.class);
        if (r68 == null) goto L138;
        r68.unregisterPerformanceStrategyTask(210);
    L138:
        LiveMessageRefreshLayout r69 = this.I;
        if (r69 == null) goto L142;
        r69.setRefreshing(false);
    L142:
        if (this.V == null) goto L144;
        i0.c().removeCallbacks(this.V);
    L144:
        LiveMessageLoaderTip r70 = this.L;
        if (r70 != null) goto L147;
    L149:
        int r71 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r73 = com.bytedance.android.live.room.api.panel.d.b(((Widget) this).dataCenter, 0);
        if (r73 == null) goto L153;
        r73.unregisterPanelListener(this.L0);
    L153:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixPublicScreen() == true) goto L155;
        return;
    L155:
        if (((Boolean) h7.a.getValue()).booleanValue() == false) goto L168;
        ViewGroup r74 = ((Widget) this).containerView;
        if ((r74 instanceof PublicScreenTextMessageFrameLayout) == true) goto L159;
        return;
    L159:
        if (((PublicScreenTextMessageFrameLayout) r74).getPublicScreenTouchInterceptorCache() == null) goto L170;
        ((PublicScreenTextMessageFrameLayout) ((Widget) this).contentView.findViewById(2131378419)).setPublicScreenTouchInterceptor(null);
        return;
    L170:
        return;
    L168:
        return;
    L147:
        if (r70.getVisibility() != 0) goto L149;
        this.L.setVisibility(8);
        goto L149
    L104:
        boolean r75 = TextMessageTracer.a;
        TextMessageTracer.z(new c0());
        goto L105
    L113:
        r56 = 0;
        goto L114
    L93:
        this.k.removeAllViews();
        this.f.removeMessages(2);
        this.f.removeMessages(5);
    L84:
        r44 = 0;
        goto L85
    L69:
        r36 = r35.r();
        goto L70
    L45:
        if (r21 > 1.0f) goto L49;
        if (r23 < 0) goto L49;
        r24 = r17;
        LiveMonitor.a r76 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a("ttlive_text_render_engine_decode_all", r24);
        r76.f("success_rate", r21);
        r76.g("latency", r23);
        r76.a().report();
        goto L51
    L50:
        r24 = r17;
        goto L51
    }

    public final Boolean recylerViewIsBottom() {
        return Boolean.valueOf(!this.o.canScrollVertically(1));
    }

    public final void yq() {
        LiveMessageRecyclerView r0 = this.o;
        if (r0 == null) goto L13;
        MessageListAdapter r1 = this.p;
        if (r1 != null) goto L8;
        return;
    L8:
        if (V0 == false) goto L10;
        r0.scrollToPosition(r1.getItemCount() - 1);
    L11:
        this.x = this.p.getItemCount() - 1;
        return;
    L10:
        r0.smoothScrollToPosition(r1.getItemCount() - 1);
        goto L11
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.android.livesdk.interactivity.publicscreen.widget.w] */
    public TextMessageWidget() {
        this.f = new WeakHandler(Looper.getMainLooper(), this);
        this.g = Boolean.FALSE;
        this.n = ListScrollState.NORMAL;
        this.v = new RecyclerViewStackHelper();
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.K = new TextMessageTimeRecorder();
        this.N = ((Boolean) f1.a.getValue()).booleanValue();
        this.O = false;
        this.P = false;
        this.Q = false;
        this.S = false;
        this.T = false;
        this.U = 0;
        this.V = new w(this);
        o3 r1 = o3.a;
        this.k0 = ((o0) r1.getValue()).loopCheckComputingLayout;
        this.p0 = ((o0) r1.getValue()).loopMaxTimes;
        this.H0 = 0;
        this.L0 = new a(this);
        this.P0 = false;
    }

    public final View getContentView() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.U) <= 200) goto L6;
        zq("getContentView", false, "Unknown visibility");
        this.U = r0;
    L6:
        return ((Widget) this).contentView;
    }

    public final void onClear() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onClear();
        this.o.setAdapter(null);
        this.f.removeCallbacksAndMessages(null);
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        TextMessageTimeRecorder r0 = this.K;
        Iterator<T> r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r1.next()).D().a;
        if (r2 == null) goto L4;
        ((DisplayTimeRecorder) r2).a(com.bytedance.android.livesdk.interactivity.api.entity.g.b.a);
        goto L4
    L8:
        r0.a.clear();
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.K.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final boolean d() {
        return this.D;
    }

    public final void slideRecyclerListToEnd() {
        yq();
    }

    public final Boolean uk() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void Br(String r2) {
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.j(this, r2);
    }

    public final void Cq(int r13) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (ListScrollState.NORMAL == this.n) goto L37;
        if (r13 <= 0) goto L37;
        if (this.N == true) goto L11;
        boolean r0 = this.o.canScrollVertically(1);
    L26:
        if ((!r0) == true) goto L37;
        this.w = r13;
        if (r13 >= 100) goto L31;
        String r14 = String.valueOf(r13);
    L32:
        this.j.setText(((Widget) this).context.getResources().getString(2131915766, new Object[]{r14}));
        if (this.h.getVisibility() == 0) goto L35;
        TranslateAnimation r15 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r15.setDuration(100);
        this.h.startAnimation(r15);
    L35:
        this.h.setVisibility(0);
        return;
    L31:
        r14 = "99+";
        goto L32
    L11:
        if (this.Q == false) goto L13;
        r0 = true;
        goto L26
    L13:
        int r1 = this.q.getItemCount();
        int r3 = 0;
        int r4 = 0;
    L14:
        if (r3 >= r1) goto L20;
        View r5 = this.q.findViewByPosition(r3);
        if (r5 == null) goto L18;
        r4 = (r4 + r5.getHeight()) + this.s.a;
    L18:
        r3 = r3 + 1;
        goto L14
    L20:
        if (r4 < this.o.getHeight()) goto L22;
        r0 = true;
    L23:
        this.Q = r0;
        goto L26
    L22:
        r0 = false;
    L37:
        this.h.setVisibility(4);
        this.w = 0;
    }

    public final void Eq(ListScrollState r6) {
        if (this.n != r6) goto L5;
        return;
    L5:
        ListScrollState r0 = ListScrollState.NORMAL;
        boolean r1 = false;
        if (r6 != r0) goto L19;
        boolean r3 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.a;
        com.bytedance.android.livesdk.interactivity.api.h r4 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r4 == null) goto L16;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l> r5 = r4.getAudienceOperateManager();
        if (r5 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l r7 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l) r5.getValue();
        if (r7 == null) goto L16;
        if (r7.p() != true) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        return;
    L16:
        r8 = false;
    L19:
        this.n = r6;
        if (r0 != r6) goto L26;
        Cq(0);
        this.q.p(1.0f);
        if (V0 == false) goto L24;
        this.o.scrollToPosition(this.p.getItemCount() - 1);
    L25:
        this.x = this.p.getItemCount() - 1;
        goto L26
    L24:
        this.o.smoothScrollToPosition(this.p.getItemCount() - 1);
    L26:
        RecyclerViewStackHelper r9 = this.v;
        if (this.n != r0) goto L29;
        r1 = true;
    L29:
        r9.b = r1;
        r9.j();
    }

    public final void handleMsg(Message r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.what;
        if (5 != r0) goto L10;
        if (this.r == null) goto L10;
        u42.f.a("remove room notice from message list");
        this.r.Z();
        return;
    L10:
        if (r0 == 7) goto L12;
        return;
    L12:
        if (this.k0 == false) goto L19;
        if (this.H0 >= this.p0) goto L19;
        if (this.o.isComputingLayout() == false) goto L19;
        Message r1 = Message.obtain();
        r1.what = r3.what;
        r1.obj = r3.obj;
        this.f.sendMessage(r1);
        this.H0++;
        return;
    L19:
        if ((r3.obj instanceof Runnable) == true) goto L21;
        return;
    L21:
        if (this.H0 == 0) goto L23;
        SafetyGuard.a(null, null, "public screen update error, try update loop times:" + this.H0);
    L23:
        ((Runnable) r3.obj).run();
        this.H0 = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void lU(tlc.d r7) {
        if (xq().d == true) goto L6;
        return;
    L6:
        if ((r7 instanceof j3) == false) goto L12;
        final j3 r8 = (j3) r7;
        long r0 = (r8.getEndTimeStamp() - (com.bytedance.android.livesdk.utils.ntp.e.a() / 1000)) - 60;
        Logger.d("mic room: anchor delay = " + r0);
        if (r0 > 0) goto L10;
        return;
    L10:
        ((ObservableSubscribeProxy) Observable.timer(r0, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new r(this, r8), new s());
        return;
    }

    public final void onChanged(Object r10) {
        KVData r11 = (KVData) r10;
        if (r11 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11.getKey()) == false) goto L7;
        return;
    L7:
        if (r11.getData() == null) goto L125;
        String r0 = r11.getKey();
        r0.getClass();
        int r2 = 4;
        switch(r0.hashCode()) {
            case -1833053846: goto L45;
            case -1548871708: goto L41;
            case -1357019912: goto L37;
            case -923361185: goto L33;
            case 294674590: goto L29;
            case 309908432: goto L25;
            case 1060055221: goto L21;
            case 1165250971: goto L17;
            case 1734076626: goto L13;
            default: goto L48;
        };
    L48:
        byte r1 = -1;
    L49:
        String r3 = "hide";
        switch(r1) {
            case 0: goto L90;
            case 1: goto L81;
            case 2: goto L80;
            case 3: goto L76;
            case 4: goto L70;
            case 5: goto L57;
            case 6: goto L70;
            case 7: goto L53;
            case 8: goto L52;
            default: goto L126;
        };
    L52:
        slideRecyclerListToEnd();
        return;
    L53:
        aa2.a r4 = this.r;
        if (r4 == null) goto L108;
        r4.b((com.bytedance.android.live.base.model.message.t) r11.getData());
        return;
    L108:
        return;
    L70:
        boolean r13 = ((Boolean) r11.getData()).booleanValue();
        LiveMessageRecyclerView r5 = this.o;
        if (r5 == null) goto L114;
        if (r13 == false) goto L74;
        r5.setScrollBehavior(0);
        return;
    L74:
        r5.setScrollBehavior(1);
        return;
    L114:
        return;
    L80:
        this.o.clearFocus();
        return;
    L81:
        boolean r14 = ((Boolean) r11.getData()).booleanValue();
        if (r14 == false) goto L84;
        ((Widget) this).contentView.setVisibility(4);
    L85:
        zq("cmd_hide_in_douyin_commerce", !r14, null);
        if (r14 == true) goto L89;
        r3 = "show";
    L89:
        Br("visibility_in_douyin_commerce_event_".concat(r3));
        return;
    L84:
        ((Widget) this).contentView.setVisibility(0);
        goto L85
    L90:
        final x1 r15 = (x1) r11.getData();
        if (isViewValid() == false) goto L122;
        if (r15 == null) goto L127;
        PublicScreenTraceMonitor.n("receive NormalGiftEndEvent", new m(r15));
        IBaseUser r6 = r15.a;
        String r7 = r15.b;
        long r8 = r15.c;
        if (r7 == null) goto L123;
        if (r6 == null) goto L128;
        kc2.b r9 = new kc2.b();
        r9.a = r6;
        r9.c = r7;
        r9.b = r8;
        r9.d = r15.j;
        r9.i = ((Long) ((Widget) this).dataCenter.get("data_room_id")).longValue();
        r9.setBaseMessage(r15.k);
        m0 r16 = r15.k;
        if (r16 == null) goto L101;
        r16.setMethod("GiftGroupMessage");
    L101:
        r9.f = r15.e;
        r9.h = r15.i;
        r9.e = r15.d;
        r9.j = r15.l;
        r9.setTimestamp(r15.g);
        r9.setReceiveTime(r15.h);
        r9.g = r15.m;
        aa2.a r17 = this.r;
        if (r17 == null) goto L124;
        r17.b(r9);
        return;
    L124:
        return;
    L128:
        return;
    L123:
        return;
    L127:
        return;
    L122:
        return;
    L126:
        return;
    L57:
        if (this.z.isMediaRoom() == true) goto L59;
        return;
    L59:
        if (this.z.getRoomAuthStatus() != null) goto L61;
        return;
    L61:
        if (this.z.getRoomAuthStatus().getEnableChat() == false) goto L112;
        boolean r18 = ((Boolean) r11.getData()).booleanValue();
        View r19 = ((Widget) this).contentView;
        if (r18 == true) goto L66;
        r2 = 0;
    L66:
        UIUtils.setViewVisibility(r19, r2);
        zq("data_media_introduction_showing", !r18, null);
        if (r18 == false) goto L69;
        r3 = "show";
    L69:
        Br("media_introduction_showing_event".concat(r3));
        return;
    L112:
        return;
    L76:
        if ((r11.getData() instanceof Integer) == false) goto L117;
        PublicScreenTopLayout r20 = this.i;
        if (r20 == null) goto L118;
        r20.setTopMarginWhenShowing(((Integer) r11.getData()).intValue());
        return;
    L118:
        return;
    L117:
        return;
    L13:
        if (r0.equals("cmd_scroll_public_screen_msg_to_last") == false) goto L48;
        r1 = 8;
        goto L49
    L17:
        if (r0.equals("cmd_show_dynamic_emoji_in_comment") == false) goto L48;
        r1 = 7;
        goto L49
    L21:
        if (r0.equals("data_keyboard_status") == false) goto L48;
        r1 = 6;
        goto L49
    L25:
        if (r0.equals("data_media_introduction_showing") == false) goto L48;
        r1 = 5;
        goto L49
    L29:
        if (r0.equals("data_keyboard_status_douyin") == false) goto L48;
        r1 = 4;
        goto L49
    L33:
        if (r0.equals("DATA_PUBLIC_SCREEN_OVERLAPPING_HEIGHT") == false) goto L48;
        r1 = 3;
        goto L49
    L37:
        if (r0.equals("data_pre_show_keyboard") == false) goto L48;
        r1 = 2;
        goto L49
    L41:
        if (r0.equals("cmd_hide_in_douyin_commerce") == false) goto L48;
        r1 = 1;
        goto L49
    L45:
        if (r0.equals("data_normal_gift_end_event") == false) goto L48;
        r1 = 0;
        goto L49
    }

    public final void onEnterClear(int r3) {
        View r0 = ((Widget) this).contentView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 1) goto L7;
    L14:
        r0.setVisibility(8);
        zq("EnterClear", false, null);
        Br("visibility_in_clear_screen_hide");
        return;
    L7:
        if (r3 == 4) goto L14;
        if (r3 == 16) goto L14;
        if (r3 == 32) goto L14;
        if (r3 == 256) goto L14;
    }

    public void onEvent(com.bytedance.android.livesdk.interactivity.api.r r1) {
        r1.getClass();
        Eq(ListScrollState.NORMAL);
    }

    public final void onExitClear(int r4) {
        View r0 = ((Widget) this).contentView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 != 1) goto L7;
    L14:
        r0.setVisibility(0);
        zq("ExitClear", true, null);
        Br("visibility_in_clear_screen_show");
        return;
    L7:
        if (r4 == 4) goto L14;
        if (r4 == 16) goto L14;
        if (r4 == 32) goto L14;
        if (r4 == 256) goto L14;
    }

    public final void onInit(Object... r5) {
        LiveMessageRecyclerView r6 = ((Widget) this).contentView.findViewById(2131380030);
        this.o = r6;
        this.Z = new com.bytedance.android.livesdk.interactivity.publicscreen.utils.n(this.f, r6);
        if (((Boolean) e1.a.getValue()).booleanValue() == true) goto L5;
        this.o.setHorizontalFadingEdgeEnabled(false);
        this.o.setVerticalFadingEdgeEnabled(false);
    L5:
        this.I = findViewById(2131378418);
        this.L = (LiveMessageLoaderTip) ((Widget) this).contentView.findViewById(2131378966);
        this.M = (ViewGroup) findViewById(2131380928);
        this.J = new com.bytedance.android.livesdk.interactivity.publicscreen.ui.i(getContext(), this.M);
        this.I.setRefreshing(false);
        this.I.setEnableBottomOverscroll(((Boolean) f7.a.getValue()).booleanValue());
        this.I.setHeaderController(new b(this));
        this.I.setOnRefreshListener(new y(this));
        LiveMessageRefreshLayout r7 = this.I;
        BaseHeaderLoader r1 = this.J;
        if (r1 != null) goto L8;
        r7.getClass();
    L9:
        this.o.setCanScrollUp(true);
        if (((l61) LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue()).c() == false) goto L12;
        this.o.setHasFixedSize(true);
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_comment", "public comment measure opt enabled");
    L12:
        this.h = ((Widget) this).contentView.findViewById(2131380027);
        this.j = (TextView) ((Widget) this).contentView.findViewById(2131380028);
        this.i = (PublicScreenTopLayout) ((Widget) this).contentView.findViewById(2131388471);
        this.k = (FrameLayout) ((Widget) this).contentView.findViewById(2131380029);
        Intrinsics.checkNotNullParameter(this, "textMessageView");
        PublicScreenContext r8 = this.a;
        if (r8 == null) goto L15;
        MessageListAdapter r2 = new PublicScreenExtendsMessageAdapter(r8, this);
    L16:
        this.p = r2;
        if (((o72.e) d1.a.getValue()).b() == false) goto L19;
        this.p.c = new c(this);
    L19:
        TextMessageLayoutManager r9 = new TextMessageLayoutManager(((Widget) this).context);
        this.q = r9;
        r9.p(1.0f);
        this.q.setMeasurementCacheEnabled(true);
        this.o.setLayoutManager(this.q);
        SpaceItemDecoration r10 = new SpaceItemDecoration(1, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q.e(gb2.a.a(((Widget) this).dataCenter, false), isScreenPortrait()), false);
        this.s = r10;
        this.o.addItemDecoration(r10);
        ALogger.i("TextMessaget_preload", "onInit::::  mRecyclerView " + this.o.hashCode() + "   dataCenter" + ((Widget) this).dataCenter.hashCode() + " widget : " + hashCode());
        this.o.setAccessibilityDelegateCompat(new MessageRvAccessibilityDelegate(this.o));
        PinnedMessageDecoration r11 = new PinnedMessageDecoration();
        this.m = r11;
        this.o.addItemDecoration(r11);
        this.o.addItemDecoration(new RemoveMessageDecoration(new z(this)));
        this.o.setAdapter(this.p);
        this.o.setItemAnimator(null);
        this.o.addOnScrollListener(new d(this));
        this.o.setOnTouchListener(new e(this));
        this.o.setOnFlingListener(new f(this));
        this.h.setOnClickListener(new a0(this));
        TextView r13 = this.j;
        if (r13 == null) goto L23;
        int r0 = r3.a;
        r3.a r3 = new r3.a(r13);
        r3.e = Button.class.getName();
        ViewCompat.setAccessibilityDelegate(r13, r3);
    L23:
        if (((Boolean) h7.a.getValue()).booleanValue() == false) goto L30;
        ViewGroup r14 = ((Widget) this).containerView;
        if ((r14 instanceof PublicScreenTextMessageFrameLayout) == false) goto L31;
        LiveVerticalViewPager.l r15 = ((PublicScreenTextMessageFrameLayout) r14).getPublicScreenTouchInterceptorCache();
        if (r15 == null) goto L32;
        ((PublicScreenTextMessageFrameLayout) ((Widget) this).contentView.findViewById(2131378419)).setPublicScreenTouchInterceptor(r15);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L15:
        r2 = new MessageListAdapter(this);
        goto L16
    L8:
        r7.s = r1;
        r7.addView(r1);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.framework.PublicScreenBaseWidget
    public final void onLoad(Object... r7) {
        ALogger.i("TextMessageWidget", "loaded");
        super.onLoad(r7);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.z = (IRoom) ((Widget) this).dataCenter.get("data_room");
        this.y = 0;
        ALogger.i("TextMessaget_preload", "onLoad::::     dataCenter" + ((Widget) this).dataCenter.hashCode() + " widget : " + hashCode());
        Lazy r8 = PublicScreenABHelper.a;
        if (PublicScreenABHelper.i(this.z) == false) goto L10;
        TextMessageLayoutManager r9 = this.q;
        if (r9 == null) goto L10;
        r9.setStackFromEnd(true);     // Catch: IllegalStateException -> L8
        this.v.j();     // Catch: IllegalStateException -> L8
    L8:
        e = move-exception;
        SafetyGuard.a(null, e, "RecyclerView stackFromEnd Exception");
    L10:
        runWithRoomVisible(new g(this));
        final h r10 = new h(this);
        if (((Boolean) com.bytedance.android.live.core.setting.f0.a.getValue()).booleanValue() == false) goto L14;
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
    L19:
        if (((Boolean) c1.a.getValue()).booleanValue() == false) goto L23;
        r92.a r11 = new r92.a();
        IPerformanceStrategyManager r0 = jc1.k.f(IPerformanceStrategyManager.class);
        if (r0 == null) goto L23;
        r0.registerPerformanceStrategyTask(210, r11);
    L23:
        z32.f.a(PSRoomStatDescNode.PublicScreenShowStatus, "no_message");
        int r13 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.e.a;
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f.a().enable == false) goto L29;
        HashMap r14 = new HashMap();
        r14.put("screen_height", com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.e.b(z42.a.c.e()));
        r14.put("font_size", com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.e.a(y42.a.c.b()));
        String r1 = (String) ((HashMap) l42.a.b.getValue()).get("public_screen_operate_freq");
        if (r1 != null) goto L28;
        r1 = "0";
    L28:
        r14.put("screen_consume_layer", r1);
        j0.l().sendLog("livesdk_common_screen_launch", r14, new Object[]{IRoom.class, am2.x.class});
    L29:
        PublicScreenTopLayout r15 = this.i;
        if (r15 == null) goto L37;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L38;
        r15.setTopMarginWhenShowing(((Integer) r2.get("DATA_PUBLIC_SCREEN_OVERLAPPING_HEIGHT", 0)).intValue());
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (getRoomContextService() == null) goto L19;
        if (getRoomContextService().getRoomDataContext(((Widget) this).dataCenter, 0).B2() == null) goto L19;
        getRoomContextService().getRoomDataContext(((Widget) this).dataCenter, 0).B2().c(new com.bytedance.android.livesdk.interactivity.publicscreen.widget.b(this, r10));
        goto L19
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void pa(final int r4) {
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r0 = this.Z;
        if (r0 == null) goto L8;
        MessageListAdapter r1 = this.p;
        if (r1 == null) goto L8;
        r0.b(new com.bytedance.android.livesdk.interactivity.publicscreen.utils.r(r1, r4), "NotifyItemRangeRemoved");
    L8:
        boolean r2 = TextMessageTracer.a;
        TextMessageTracer.z(new x(r4));
    }

    public final void qo(Boolean r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void sU(int r2) {
        Cq(this.w + r2);
        if (this.w < 300) goto L10;
        this.n = ListScrollState.NORMAL;
        Cq(0);
        this.q.p(1.0f);
        if (V0 == false) goto L7;
        this.o.scrollToPosition(this.p.getItemCount() - 1);
    L8:
        this.x = this.p.getItemCount() - 1;
        return;
    L7:
        this.o.smoothScrollToPosition(this.p.getItemCount() - 1);
        goto L8
    }

    public void onEvent(jd0.g r1) {
        ListScrollState r2 = ListScrollState.NORMAL;
        this.n = r2;
        Eq(r2);
    }

    public void onEvent(kd0.a r1) {
        ListScrollState r2 = ListScrollState.NORMAL;
        this.n = r2;
        Eq(r2);
    }

    public void onEvent(u22.d r1) {
        f72.a.b("Receive AudioCommentPlayClickEvent mAudioPresenter NULL");
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        xs2.b.a().b(r2).compose(getAutoUnbindTransformer()).subscribe(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void V50(final int r5, boolean r6) {
        boolean r0 = TextMessageTracer.a;
        TextMessageTracer.z(new b0(r5));
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r1 = this.Z;
        if (r1 == null) goto L9;
        MessageListAdapter r2 = this.p;
        if (r2 == null) goto L9;
        r1.b(new com.bytedance.android.livesdk.interactivity.publicscreen.utils.s(r2, r5), "NotifyItemRemoved");
    L9:
        if (r5 == this.p.getItemCount()) goto L13;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r3 = this.Z;
        if (r3 == null) goto L13;
        MessageListAdapter r4 = this.p;
        r3.b(new com.bytedance.android.livesdk.interactivity.publicscreen.utils.p(r4, r5, r4.getItemCount() - r5), "NotifyItemRangeChanged");
    L13:
        if (r6 == false) goto L16;
        yq();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void VA(int r5, long r6) {
        xq().n = r5;
        xq().o = r6;
        OptScrollItemAnimator r0 = this.R;
        if (r0 == null) goto L13;
        float r7 = (r5 * 1.0f) / s1.v();
        if (r7 >= 0.0f) goto L7;
        ALogger.e("BaseScrollItemAnimator", "scroll speed has negative value!!!");
    L8:
        OptScrollItemAnimator r8 = this.R;
        if (r6 >= 0) goto L11;
        r8.getClass();
        ALogger.e("BaseScrollItemAnimator", "max duration has negative value!!!");
        return;
    L11:
        r8.c = r6;
        return;
    L7:
        r0.a = r7;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void XD(int r4, long r5) {
        this.q.p(xq().n);
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r0 = this.Z;
        if (r0 == null) goto L8;
        MessageListAdapter r1 = this.p;
        if (r1 == null) goto L8;
        r0.b(new com.bytedance.android.livesdk.interactivity.publicscreen.utils.o(r1, r4), "NotifyItemChanged");
    L8:
        Bq(0, 0, r5);
    }

    public static void zq(String r1, boolean r2, String r3) {
        PublicScreenTraceMonitor.i("TextMessageWidget", r1, r2, r3);
    }

    public final void Bq(int r4, int r5, long r6) {
        if (ListScrollState.NORMAL != this.n) goto L5;
    L6:
        this.A = true;
        int r1 = this.p.getItemCount() - 1;
        this.x = r1;
        if (this.S == false) goto L21;
        if ((r4 + r5) < this.p.getItemCount()) goto L11;
        boolean r7 = true;
    L13:
        if (r6 > 0) goto L15;
    L16:
        if (r7 == false) goto L18;
    L19:
        this.o.scrollToPosition(this.x);
        this.y = r6;
        return;
    L18:
        if (this.o.canScrollVertically(1) == true) goto L19;
        return;
    L15:
        if (r6 == this.y) goto L19;
    L11:
        r7 = false;
        goto L13
    L21:
        if (V0 == false) goto L23;
        this.o.scrollToPosition(r1);
        return;
    L23:
        this.o.smoothScrollToPosition(r1);
        return;
    L5:
        if (this.A == true) goto L6;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView
    public final void DD(int r4, int r5, long r6) {
        this.q.p(xq().n);
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r0 = this.Z;
        if (r0 == null) goto L8;
        MessageListAdapter r1 = this.p;
        if (r1 == null) goto L8;
        r0.b(new com.bytedance.android.livesdk.interactivity.publicscreen.utils.q(r1, r4, r5), "ItemRangeInsert");
    L8:
        Bq(r4, r5, r6);
    }
}
