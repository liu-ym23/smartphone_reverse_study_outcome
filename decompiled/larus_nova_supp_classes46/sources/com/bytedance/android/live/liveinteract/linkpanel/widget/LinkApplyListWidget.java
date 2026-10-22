package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.common.ui.OnlineFriendsCircleContainer;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.m0;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/LinkApplyListWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkApplyListWidgetContract$View;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkApplyListWidget extends BaseTalkApplyListWidgetContract$View {
    public static final /* synthetic */ int O = 0;
    public String A;
    public int B;
    public boolean C;
    public final CompositeDisposable D;
    public boolean E;
    public boolean F;
    public boolean G;
    public IRoom H;
    public boolean I;
    public final Handler J;
    public final boolean K;
    public BannerWidget L;
    public final CompositeDisposable M;
    public final b N;
    public final Lazy c;
    public com.bytedance.android.live.liveinteract.component.a<Integer> d;
    public WidgetManager e;
    public ViewGroup f;
    public int g;
    public BaseRefreshLayout h;
    public final LinkedList<Object> i;
    public final LinkedList<ILinkPlayerInfoBridge> j;
    public ILinkPlayerInfoBridge k;
    public boolean l;
    public View m;
    public RecyclerView n;
    public LinearLayout o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public ImageView s;
    public TextView t;
    public OnlineFriendsCircleContainer u;
    public MultiTypeAdapter v;
    public ViewGroup w;
    public ViewGroup x;
    public TextView y;
    public View z;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.liveinteract.linkpanel.list.o {
        public final /* synthetic */ LinkApplyListWidget a;

        public static final class a implements uf0.d {
            public final /* synthetic */ b a;

            @Override // uf0.d
            public final void a() {
            }

            public a(b r1) {
                this.a = r1;
            }

            @Override // uf0.d
            public final void onPermitSuccess(String r8) {
                int r1 = -1;
                int r3 = 0;
                if (((Boolean) vm2.d.j2.getValue(null, vm2.d.a[163(0xa3, float:2.28E-43)])).booleanValue() == false) goto L23;
                LinkApplyListWidget r0 = this.a.a;
                int r4 = r0.i.size();
            L5:
                if (r3 >= r4) goto L16;
                Object r5 = r0.i.get(r3);
                if ((r5 instanceof ILinkPlayerInfoBridge) == false) goto L15;
                IBaseUser r6 = ((ILinkPlayerInfoBridge) r5).getUser();
                if (r6 == null) goto L11;
                String r7 = r6.getIdString();
            L13:
                if (Intrinsics.areEqual(r7, r8) == false) goto L15;
                r1 = r3;
                goto L16
            L11:
                r7 = null;
            L15:
                r3 = r3 + 1;
            L16:
                if (r1 >= 0) goto L18;
                return;
            L18:
                if (r1 >= r0.i.size()) goto L59;
                r0.i.remove(r1);
                MultiTypeAdapter r9 = r0.v;
                if (r9 == null) goto L55;
                r9.notifyItemRemoved(r1);
                return;
            L55:
                return;
            L59:
                return;
            L23:
                LinkApplyListWidget r2 = this.a.a;
                int r10 = r2.i.size();
            L24:
                if (r3 >= r10) goto L35;
                Object r11 = r2.i.get(r3);
                if ((r11 instanceof ILinkPlayerInfoBridge) == false) goto L34;
                IBaseUser r12 = ((ILinkPlayerInfoBridge) r11).getUser();
                if (r12 == null) goto L30;
                String r13 = r12.getIdString();
            L32:
                if (Intrinsics.areEqual(r13, r8) == false) goto L34;
                r1 = r3;
                goto L35
            L30:
                r13 = null;
            L34:
                r3 = r3 + 1;
            L35:
                if (r1 >= 0) goto L37;
                return;
            L37:
                if (r1 >= r2.i.size()) goto L60;
                Object r14 = r2.i.get(r1);
                if ((r14 instanceof ILinkPlayerInfoBridge) == false) goto L42;
                ((ILinkPlayerInfoBridge) r14).setHasApplied(true);
            L42:
                MultiTypeAdapter r15 = r2.v;
                if (r15 == null) goto L58;
                r15.notifyItemChanged(r1);
                return;
            L58:
                return;
            }
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
        public final void Ys(ILinkPlayerInfoBridge r2) {
            Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        }

        public b(LinkApplyListWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
        public final void hw(ILinkPlayerInfoBridge r19, int r20) {
            Intrinsics.checkNotNullParameter(r19, "linkPlayerInfo");
            LinkApplyListWidget r2 = this.a;
            if (((Widget) r2).isViewValid == true) goto L5;
            return;
        L5:
            r2.k = r19;
            IBaseUser r3 = r19.getUser();
            if (r3 != null) goto L9;
            return;
        L9:
            if (this.a.I == false) goto L11;
        L18:
            gd0.m r4 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r4 == null) goto L21;
            ((LinkPanelTransitService) r4).i(r3, new a(this));
        L21:
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("position", String.valueOf(r20));
            r19.getPaidAmount();
            r5.put("paid_amount", String.valueOf(r19.getPaidAmount()));
            boolean r16 = Intrinsics.areEqual(r19.getButtonText(), s1.B(2131919207));
            String r6 = r3.getIdString();
            if (this.a.I == false) goto L24;
            String r7 = "anchor";
        L25:
            String r8 = r7;
            List<KtvMusic> r9 = r19.getSongList();
            o0 r10 = r19.getWaitingListUserInfo();
            if (r10 == null) goto L28;
            String r11 = r10.getApplyReason();
        L29:
            boolean r12 = !TextUtils.isEmpty(r11);
            String r13 = r19.getFuzzyFanTicket();
            if (r13 != null) goto L32;
            String r14 = "";
        L33:
            String r15 = com.bytedance.android.live.liveinteract.plantform.model.n.c(r19);
            Intrinsics.checkNotNullParameter(r19, "$this$relationship");
            if (r19.getUser() == null) goto L36;
            IBaseUser r17 = r19.getUser();
            Intrinsics.checkNotNull(r17);
            String r18 = r17.getRelationship();
        L37:
            String r110 = r18;
            IBaseUser r21 = r19.getUser();
            if (r21 == null) goto L45;
            py.d r22 = r21.getUserHonor();
            if (r22 == null) goto L45;
            String r23 = String.valueOf(r22.getLevel());
            if (r23 == null) goto L45;
            String r111 = r23;
        L46:
            IBaseUser r24 = r19.getUser();
            Intrinsics.checkNotNull(r24);
            com.bytedance.android.live.liveinteract.linkpanel.util.m.y(r6, r8, r9, "list", r12, r14, r110, r15, r111, r24.isSubscriber(), Long.valueOf(com.bytedance.android.live.liveinteract.plantform.model.n.b(r19)), r16, r5);
            return;
        L45:
            r111 = "";
            goto L46
        L36:
            r18 = "null";
            goto L37
        L32:
            r14 = r13;
            goto L33
        L28:
            r11 = null;
            goto L29
        L24:
            r7 = "administrator";
            goto L25
        L11:
            if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L18;
            if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L15;
            f2.b(2131914522, 0);
        L16:
            com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.PERMIT);
            return;
        L15:
            f2.b(2131917298, 0);
            goto L16
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkApplyListWidget a;

        public c(LinkApplyListWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LinkApplyListWidget r0 = this.a;     // Catch: Throwable -> L8
            if (((Widget) r0).contentView == null) goto L11;
            WidgetManager r1 = r0.e;     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.load(2131372686, r0.L);     // Catch: Throwable -> L8
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

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LinkApplyListWidget a;

        public d(LinkApplyListWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            jd0.n r5 = (jd0.n) r4;
            LinkApplyListWidget r6 = this.a;
            LinearLayout r0 = r6.p;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            MultiTypeAdapter r3 = this.a.v;
            if (r3 == null) goto L13;
            List r7 = r3.a;
            if (r7 == null) goto L13;
            r1 = r7.isEmpty();
        L13:
            r6.Jq(r2, r1);
            MultiTypeAdapter r8 = this.a.v;
            if (r8 == null) goto L17;
            r8.notifyDataSetChanged();
            return;
        L17:
            return;
        L5:
            if (r0.getVisibility() != 0) goto L7;
            r2 = true;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ LinkApplyListWidget a;

        public f(LinkApplyListWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.bytedance.android.live.liveinteract.component.a<Integer> r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.run(1);
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ LinkApplyListWidget a;

        public g(LinkApplyListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Pair r6 = (Pair) r5;
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.getFirst() != null) goto L10;
            if (r6.getSecond() != null) goto L10;
            return;
        L10:
            if (r6.getSecond() == null) goto L12;
            LinkApplyListWidget r0 = this.a;
            Object r7 = r6.getSecond();
            Intrinsics.checkNotNull(r7);
            r0.Aq((Throwable) r7);
            this.a.getClass();
            return;
        L12:
            com.bytedance.android.live.network.response.e<m0> r8 = (com.bytedance.android.live.network.response.e) r6.getFirst();
            if (r8 == null) goto L23;
            LinkApplyListWidget r1 = this.a;
            int r2 = LinkApplyListWidget.O;
            yf0.a r3 = (yf0.a) r1.b;
            if ((r3 instanceof com.bytedance.android.live.liveinteract.linkpanel.list.a) == true) goto L17;
            r3 = null;
        L17:
            com.bytedance.android.live.liveinteract.linkpanel.list.a r4 = (com.bytedance.android.live.liveinteract.linkpanel.list.a) r3;
            if (r4 == null) goto L24;
            r4.m(true, r8, "onCheckApplySuccessListNotEmpty", false);
            return;
        L24:
            return;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ LinkApplyListWidget a;

        public h(LinkApplyListWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            LinkApplyListWidget.Eq(this.a);
        }
    }

    public static final class i implements BaseRefreshLayout.c {
        public final /* synthetic */ LinkApplyListWidget a;

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void onFinish() {
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void y0() {
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void onRefresh() {
            LinkApplyListWidget.Eq(this.a);
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void z1() {
            View r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.setVisibility(0);
            return;
        }

        public i(LinkApplyListWidget r1) {
            this.a = r1;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ LinkApplyListWidget a;

        public j(LinkApplyListWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            LinkApplyListWidget r4 = this.a;
            yf0.g r0 = r4.a;
            if (r0 == null) goto L6;
            r0.dismiss();
        L6:
            if (fj0.c.a() == false) goto L17;
            cj0.b r1 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
            if (r1 != null) goto L10;
            return;
        L10:
            if (r1.needIntercepted() == true) goto L19;
            IInteractService r2 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r2 == null) goto L20;
            qd0.a r5 = r2.getAudioTalkService();
            if (r5 == null) goto L21;
            r5.c(((Widget) r4).context, "apply_panel");
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ LinkApplyListWidget a;

        public k(LinkApplyListWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LinkApplyListWidget r5 = this.a;
            ViewGroup r0 = r5.x;
            if (r0 == null) goto L5;
            r0.setVisibility(8);
        L5:
            IRoom r1 = r5.H;
            if (r1 == null) goto L12;
            yf0.a r6 = (yf0.a) r5.b;
            if (r6 == null) goto L10;
            r6.f(r1.getRoomId());
        L10:
            long r2 = r1.getRoomId();
            int r7 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            LinkedHashMap r8 = new LinkedHashMap();
            r8.put("room_id", Long.valueOf(r2));
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("apply_panel_close_paid_link_guide", r8);
            return;
        }
    }

    public static final class l implements BannerWidget.a {
        public final /* synthetic */ LinkApplyListWidget a;

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final void b(boolean r1, Map<String, String> r2) {
        }

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final boolean a() {
            LinkApplyListWidget r0 = this.a;
            int r1 = LinkApplyListWidget.O;
            r0.getClass();
            return false;
        }

        public l(LinkApplyListWidget r1) {
            this.a = r1;
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ BaseRefreshLayout a;

        public m(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.A.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ LinkApplyListWidget a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            RecyclerView r0 = this.a.n;
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnGlobalLayoutListener(this);
        L7:
            Map<String, cm2.a> r2 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
            com.bytedance.android.live.liveinteract.linkpanel.util.p.e("apply_panel");
        }

        public n(LinkApplyListWidget r1) {
            this.a = r1;
        }
    }

    public static final class o implements View.OnClickListener {
        public final /* synthetic */ LinkApplyListWidget a;

        public o(LinkApplyListWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            HashMap r6 = new HashMap();
            IRoom r0 = this.a.H;
            if (r0 != null) goto L5;
        L7:
            String r1 = "video_live";
        L8:
            r6.put("live_type", r1);
            IRoom r2 = this.a.H;
            if (r2 == null) goto L14;
            IBaseUser r3 = r2.getOwner();
            if (r3 == null) goto L14;
            String r4 = r3.getIdString();
            if (r4 == null) goto L14;
        L15:
            r6.put("anchor_id", r4);
            IRoom r7 = this.a.H;
            if (r7 == null) goto L18;
            Long r8 = Long.valueOf(r7.getId());
        L19:
            r6.put("room_id", String.valueOf(r8));
            r6.put("request_page", "apply");
            com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r6, null, 6);
            j0.l().sendLog("livesdk_anchor_invite_user_button_click", r6, new Object[0]);
            LinkApplyListWidget r9 = this.a;
            yf0.a r10 = (yf0.a) r9.b;
            Context r11 = ((Widget) r9).context;
            if (r11 == null) goto L24;
            r10.k((Activity) r11);
            this.a.a.dismiss();
            return;
        L24:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        L18:
            r8 = null;
        L14:
            r4 = "";
            goto L15
        L5:
            if (r0.isLiveTypeAudio() != true) goto L7;
            r1 = "voice_live";
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.widget.LinkApplyListWidget$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass2(LinkApplyListWidget r8) {
            super(1, r8, LinkApplyListWidget.class, "paidQueueTabChanged", "paidQueueTabChanged(I)V", 0);
        }

        public final void invoke(int r12) {
            LinkApplyListWidget r0 = (LinkApplyListWidget) ((CallableReference) this).receiver;
            int r1 = r0.B;
            r0.B = r12;
            yf0.a r3 = (yf0.a) r0.b;
            if (r3 == null) goto L5;
            r3.g(true, "audienceIncreasePriceApplySuccess", 50, "", r12, true);
        L5:
            ALogger.d("BaseTalkApplyListFragment", "tabIndex: " + r12);
            if (r1 == r0.B) goto L9;
            r0.Iq();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.widget.LinkApplyListWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass3(LinkApplyListWidget r8) {
            super(1, r8, LinkApplyListWidget.class, "sortCommonQueue", "sortCommonQueue(I)V", 0);
        }

        public final void invoke(int r4) {
            final LinkApplyListWidget r0 = (LinkApplyListWidget) ((CallableReference) this).receiver;
            int r1 = LinkApplyListWidget.O;
            r0.getClass();
            Integer r2 = (Integer) b6.B.getValue();
            if (r2 != null) goto L6;
        L8:
            yf0.a r3 = (yf0.a) r0.b;
            if (r3 == null) goto L13;
            r3.l(r4, new LinkApplyListWidget$sortCommonQueue$1(r0));
            return;
        L13:
            return;
        L6:
            if (r4 != r2.intValue()) goto L8;
            ALogger.i("BaseTalkApplyListFragment", "sortCommonQueue same order:" + r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565511;
    }

    public final void Fq() {
        if (this.E == true) goto L5;
        return;
    L5:
        if (this.F == false) goto L13;
        boolean r1 = com.bytedance.android.live.liveinteract.linkpanel.util.o.m();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L9;
        String r2 = (String) r0.get("data_task_name_when_open_invite_panel", "");
    L10:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.k(r1, "apply", "icon", r2, this.j.size(), 0, 0);
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void Iq() {
        HashMap r0 = new HashMap();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        r0.put("apply_list_num", String.valueOf(r2));
        r0.put("refresh_type", "click_icon");
        r0.put("play_mode", com.bytedance.android.live.liveinteract.linkpanel.util.m.c());
        SimpleDateFormat r3 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r4 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 == null) goto L13;
        Integer r7 = Integer.valueOf(r6.a);
    L14:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r0, r7, 4);
        j0.l().sendLog("livesdk_anchor_audience_apply_panel_show", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L13:
        r7 = null;
        goto L14
    L5:
        r2 = r1.a().size();
        goto L6
    }

    public LinkApplyListWidget() {
        this.c = LazyKt.lazy(LinkApplyListWidget$adminInviteAndApplyViewModel$2.INSTANCE);
        this.g = -1;
        this.i = new LinkedList();
        this.j = new LinkedList();
        this.l = true;
        this.A = "";
        this.B = WaitingListType.UNKNOWN.ordinal();
        this.D = new CompositeDisposable();
        this.J = new Handler();
        this.K = jc1.k.n(IMiddlewareUserService.class).user().c();
        this.M = new CompositeDisposable();
        this.N = new b(this);
    }

    public final void onCreate() {
        super.onCreate();
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        this.H = r0;
        com.bytedance.android.live.liveinteract.linkpanel.presenter.a r1 = new com.bytedance.android.live.liveinteract.linkpanel.presenter.a(r0, this);
        this.b = r1;
        ((com.bytedance.android.livesdk.common.c) r1).a = this;
        IRoom r2 = this.H;
        IRoom r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getOwnerUserIdString();
    L6:
        this.I = Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n());
        this.h = (BaseRefreshLayout) ((Widget) this).contentView.findViewById(2131392080);
        this.n = ((Widget) this).contentView.findViewById(2131384731);
        this.m = ((Widget) this).contentView.findViewById(2131392077);
        this.o = (LinearLayout) ((Widget) this).contentView.findViewById(2131371557);
        TextView r5 = (TextView) ((Widget) this).contentView.findViewById(2131384133);
        if (r5 == null) goto L9;
        r5.setOnClickListener(new h(this));
    L9:
        this.p = (LinearLayout) ((Widget) this).contentView.findViewById(2131371744);
        this.q = (TextView) ((Widget) this).contentView.findViewById(2131375618);
        this.r = (TextView) ((Widget) this).contentView.findViewById(2131375606);
        this.s = (ImageView) ((Widget) this).contentView.findViewById(2131371586);
        this.t = (TextView) ((Widget) this).contentView.findViewById(2131390161);
        this.u = (OnlineFriendsCircleContainer) ((Widget) this).contentView.findViewById(2131373315);
        MultiTypeAdapter r6 = new MultiTypeAdapter();
        this.v = r6;
        RecyclerView r7 = this.n;
        if (r7 == null) goto L12;
        r7.setAdapter(r6);
    L12:
        RecyclerView r8 = this.n;
        if (r8 == null) goto L15;
        r8.setLayoutManager(new LinearLayoutManager(((Widget) this).context));
    L15:
        MultiTypeAdapter r9 = this.v;
        if (r9 == null) goto L18;
        r9.z2(zf0.b.a.class, new zf0.b());
    L18:
        MultiTypeAdapter r10 = this.v;
        if (r10 == null) goto L24;
        Object r11 = this.b;
        if ((r11 instanceof com.bytedance.android.live.liveinteract.linkpanel.list.a) == true) goto L23;
        r11 = null;
    L23:
        r10.z2(zf0.m.a.class, new zf0.m((com.bytedance.android.live.liveinteract.linkpanel.list.a) r11, this.i));
    L24:
        MultiTypeAdapter r12 = this.v;
        if (r12 == null) goto L27;
        r12.z2(zf0.f.a.class, new zf0.f(new AnonymousClass2(this), new AnonymousClass3(this), 2));
    L27:
        MultiTypeAdapter r13 = this.v;
        if (r13 == null) goto L30;
        r13.z2(zf0.d.class, new zf0.k());
    L30:
        MultiTypeAdapter r14 = this.v;
        if (r14 == null) goto L34;
        r14.a = this.i;
    L34:
        if (this.I == false) goto L36;
    L40:
        TextView r15 = this.q;
        if (r15 == null) goto L43;
        r15.setText(s1.B(2131917667));
    L43:
        Context r16 = ((Widget) this).context;
        if (r16 == null) goto L48;
        TextView r17 = this.q;
        if (r17 == null) goto L48;
        r17.setBackground(ContextCompat.getDrawable(r16, 2131249992));
    L48:
        BaseRefreshLayout r18 = this.h;
        if (r18 == null) goto L51;
        r18.setmIsDisable(false);
    L51:
        BaseRefreshLayout r19 = this.h;
        if (r19 == null) goto L54;
        r19.setOnRefreshListener(new i(this));
    L54:
        RecyclerView r20 = this.n;
        if (r20 == null) goto L57;
        r20.addOnScrollListener(new AnonymousClass6(this));
    L57:
        cj0.a r21 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicContext();
        if (r21 == null) goto L66;
        com.bytedance.live.datacontext.m<Boolean> r22 = r21.getRefreshWaitingUserList();
        if (r22 == null) goto L66;
        Observable r23 = r22.a();
        if (r23 == null) goto L66;
        Disposable r24 = r23.subscribe(new com.bytedance.android.live.liveinteract.linkpanel.widget.l(this));
        if (r24 == null) goto L66;
        RxUtilKt.c(r24, this.D);
    L66:
        TextView r25 = (TextView) ((Widget) this).contentView.findViewById(2131364776);
        ImageView r26 = (ImageView) ((Widget) this).contentView.findViewById(2131364681);
        this.w = (ViewGroup) ((Widget) this).contentView.findViewById(2131363189);
        this.x = (ViewGroup) ((Widget) this).contentView.findViewById(2131381824);
        this.y = (TextView) ((Widget) this).contentView.findViewById(2131381823);
        this.z = ((Widget) this).contentView.findViewById(2131381822);
        TextView r27 = this.y;
        if (r27 == null) goto L69;
        r27.setOnClickListener(new j(this));
    L69:
        View r28 = this.z;
        if (r28 == null) goto L72;
        r28.setOnClickListener(new k(this));
    L72:
        com.bytedance.live.datacontext.m r29 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r29 == null) goto L75;
        r3 = (IRoom) r29.getValue();
    L75:
        this.L = new BannerWidget(r3, 21, "apply_message_panel", null, new l(this));
        FragmentActivity r30 = getContext();
        if (r30 == null) goto L124;
        this.e = WidgetManager.of(r30, ((Widget) this).contentView);
        t61 r31 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r31 != null) goto L80;
    L88:
        WidgetManager r32 = this.e;
        if (r32 == null) goto L91;
        r32.load(2131372686, this.L);
    L91:
        this.M.add(xs2.b.a().b(jd0.n.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), e.a));
        MultiTypeAdapter r33 = this.v;
        if (r33 == null) goto L101;
        IRoom r34 = this.H;
        if (r34 != null) goto L96;
    L98:
        boolean r35 = false;
    L99:
        r33.z2(ILinkPlayerInfoBridge.class, new zf0.h(r35, this.N, 0));
        goto L101
    L96:
        if (r34.isLiveTypeAudio() != true) goto L98;
        r35 = true;
    L101:
        if (this.I == false) goto L103;
    L104:
        TextView r36 = this.q;
        if (r36 == null) goto L107;
        r36.setVisibility(0);
    L107:
        TextView r37 = this.q;
        if (r37 == null) goto L110;
        r37.setOnClickListener(new f(this));
    L110:
        Jq(false, true);
        t61 r38 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r38 != null) goto L113;
    L119:
        ViewGroup r39 = (ViewGroup) ((Widget) this).contentView.findViewById(2131366894);
        this.f = r39;
        if (r39 == null) goto L125;
        UtilityKotlinExtentionsKt.w(r39);
        r39.setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.widget.k(this));
        return;
    L125:
        return;
    L113:
        if (u61.a(r38) != true) goto L119;
        AdminInviteAndApplyViewModel r40 = (AdminInviteAndApplyViewModel) this.c.getValue();
        if (r40 == null) goto L119;
        MutableLiveData<Pair<com.bytedance.android.live.network.response.e<m0>, Throwable>> r41 = r40.getWaitingListResponse();
        if (r41 == null) goto L119;
        r41.observe(this, new g(this));
        goto L119
    L103:
        if (this.K == false) goto L107;
    L80:
        if (u61.a(r31) != true) goto L88;
        View r42 = ((Widget) this).contentView;
        if (r42 == null) goto L91;
        c r43 = new c(this);
        t61 r44 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r44 == null) goto L86;
        long r45 = r44.a3();
    L87:
        r42.postDelayed(r43, r45);
        goto L91
    L86:
        r45 = 1000;
        goto L87
    L124:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L36:
        if (this.K == false) goto L40;
        TextView r46 = this.q;
        if (r46 == null) goto L40;
        r46.setVisibility(8);
        goto L40
    L5:
        r4 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        this.J.removeCallbacksAndMessages(null);
        this.i.clear();
        this.j.clear();
        this.l = true;
        this.C = false;
        this.M.clear();
        yf0.a r2 = (yf0.a) this.b;
        if (r2 == null) goto L5;
        ((com.bytedance.android.livesdk.common.c) r2).a = null;
    L5:
        ILinkPanelService r3 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r3 == null) goto L8;
        r3.removePermitCallback();
    L8:
        t61 r4 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r4 != null) goto L11;
        return;
    L11:
        if (u61.c(r4) != true) goto L26;
        AdminInviteAndApplyViewModel r0 = (AdminInviteAndApplyViewModel) this.c.getValue();
        if (r0 == null) goto L17;
        MutableLiveData<Pair<com.bytedance.android.live.network.response.e<m0>, Throwable>> r1 = r0.getWaitingListResponse();
        if (r1 == null) goto L17;
        r1.setValue(null);
    L17:
        this.a = null;
        this.d = null;
        WidgetManager r5 = this.e;
        if (r5 == null) goto L20;
        r5.unload(this.L);
    L20:
        WidgetManager r6 = this.e;
        if (r6 == null) goto L23;
        r6.contentView = null;
    L23:
        this.e = null;
        this.L = null;
        ((Widget) this).contentView = null;
        ((Widget) this).containerView = null;
        return;
    }

    public final void onResume() {
        super.onResume();
        Map<String, cm2.a> r0 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.c("apply_panel");
        t61 r1 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r1 != null) goto L5;
    L6:
        ((yf0.a) this.b).d();
        return;
    L5:
        if (u61.a(r1) != true) goto L6;
    }

    public static final void Eq(LinkApplyListWidget r9) {
        r9.i.clear();
        yf0.a.h((yf0.a) r9.b, true, "linkListDownRefresh", 0, null, r9.B, 44);
        HashMap r10 = new HashMap();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        r10.put("apply_list_num", String.valueOf(r1));
        r10.put("refresh_type", "draw");
        SimpleDateFormat r2 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r10, null, 6);
        j0.l().sendLog("livesdk_anchor_audience_apply_panel_show", r10, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r1 = r0.a().size();
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View
    public final void Aq(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "throwable");
        if (((Widget) this).contentView != null) goto L6;
        Map<String, cm2.a> r6 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.f("apply_panel", null, -40001, "contentView is null", 2);
        return;
    L6:
        com.bytedance.android.live.liveinteract.linkpanel.util.p.f("apply_panel", r5, null, null, 12);
        r5.printStackTrace();
        this.G = false;
        RecyclerView r0 = this.n;
        if (r0 == null) goto L9;
        r0.setVisibility(8);
    L9:
        LinearLayout r1 = this.o;
        if (r1 == null) goto L12;
        r1.setVisibility(8);
    L12:
        LinearLayout r2 = this.p;
        if (r2 == null) goto L15;
        r2.setVisibility(0);
    L15:
        Jq(true, false);
        this.F = true;
        Fq();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View
    public final void Cq(com.bytedance.android.live.liveinteract.linkpanel.model.a r5) {
        Intrinsics.checkNotNullParameter(r5, "body");
        LinearLayout r0 = this.o;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        LinearLayout r1 = this.p;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        RecyclerView r2 = this.n;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        Jq(false, true);
        IRoom r3 = this.H;
        if (r3 == null) goto L18;
        IBaseUser r4 = r3.getOwner();
        if (r4 == null) goto L18;
        if (r4.getSecret() != 1) goto L18;
    L21:
        ImageView r6 = this.s;
        if (r6 == null) goto L24;
        r6.setVisibility(0);
    L24:
        OnlineFriendsCircleContainer r7 = this.u;
        if (r7 == null) goto L58;
        r7.setVisibility(8);
        return;
    L58:
        return;
    L18:
        if (this.I == false) goto L20;
    L28:
        this.G = true;
        if (Lists.isEmpty(r5.b()) == false) goto L36;
        ImageView r8 = this.s;
        if (r8 == null) goto L33;
        r8.setVisibility(0);
    L33:
        TextView r9 = this.q;
        if (r9 == null) goto L48;
        r9.setText(s1.B(2131917667));
    L48:
        TextView r10 = this.r;
        if (r10 == null) goto L51;
        r10.setText(r5.a());
    L51:
        TextView r11 = this.q;
        if (r11 == null) goto L54;
        r11.setText(s1.B(2131917671));
    L54:
        TextView r12 = this.q;
        if (r12 == null) goto L59;
        r12.setOnClickListener(new o(this));
        return;
    L59:
        return;
    L36:
        ImageView r13 = this.s;
        if (r13 == null) goto L39;
        r13.setVisibility(8);
    L39:
        OnlineFriendsCircleContainer r14 = this.u;
        if (r14 == null) goto L42;
        r14.a(r5.b());
    L42:
        OnlineFriendsCircleContainer r15 = this.u;
        if (r15 == null) goto L45;
        r15.setVisibility(0);
    L45:
        TextView r16 = this.q;
        if (r16 == null) goto L48;
        r16.setText(s1.B(2131917671));
        goto L48
    L20:
        if (this.K == false) goto L28;
        goto L21
    }

    public final List<String> Gq(List<? extends ILinkPlayerInfoBridge> r3) {
        ArrayList r0 = new ArrayList();
        if (r3 == null) goto L13;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L13;
        IBaseUser r1 = ((ILinkPlayerInfoBridge) r4.next()).getUser();
        if (r1 == null) goto L11;
        String r2 = r1.getIdString();
        if (r2 == null) goto L11;
    L12:
        r0.add(r2);
    L11:
        r2 = "";
    L13:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View
    public final void wq(boolean r2) {
        TextView r0 = this.t;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        String r3 = s1.B(2131918110);
    L7:
        r0.setText(r3);
        return;
    L6:
        r3 = s1.B(2131918109);
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View
    public final void xq(boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (this.i.isEmpty() == true) goto L10;
        LinkedList<Object> r3 = this.i;
        if ((ListProtector.get(r3, r3.size() - 1) instanceof zf0.b.a) == false) goto L11;
        this.i.removeLast();
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View
    public final void yq(List<? extends ILinkPlayerInfoBridge> r9) {
        Intrinsics.checkNotNullParameter(r9, "linkPlayerInfos");
        if (Lists.isEmpty(r9) == false) goto L5;
        SimpleDateFormat r10 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        ((yf0.a) this.b).e();
        return;
    L5:
        yf0.a.h((yf0.a) this.b, true, "onCheckApplySuccessListNotEmpty", 0, null, this.B, 44);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View
    public final void zq(List<? extends ILinkPlayerInfoBridge> r4) {
        Intrinsics.checkNotNullParameter(r4, "linkPlayerInfos");
        if (Lists.isEmpty(r4) == false) goto L5;
        ((yf0.a) this.b).i();
    L21:
        SimpleDateFormat r5 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        if (this.C == true) goto L25;
        this.C = true;
        Iq();
        return;
    L25:
        return;
    L5:
        this.G = false;
        LinearLayout r1 = this.o;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        RecyclerView r2 = this.n;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        LinearLayout r3 = this.p;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        TextView r6 = this.q;
        if (r6 == null) goto L17;
        r6.setText(s1.B(2131917670));
    L17:
        TextView r7 = this.r;
        if (r7 == null) goto L20;
        r7.setText(s1.B(2131917669));
    L20:
        Jq(false, true);
        goto L21
    }

    public final void Jq(boolean r6, boolean r7) {
        IRoom r0 = this.H;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L9:
        boolean r2 = false;
    L10:
        IRoom r3 = this.H;
        if (r3 == null) goto L18;
        if (r3.isLiveTypeAudio() == true) goto L18;
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue(), Boolean.FALSE) == false) goto L18;
        r1 = true;
    L18:
        if (r6 == true) goto L25;
        if (r7 == true) goto L25;
        if (r2 == true) goto L22;
        if (r1 == false) goto L25;
    L22:
        View r8 = ((Widget) this).contentView.findViewById(2131363188);
        if (r8 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r8);
        return;
    L29:
        return;
    L25:
        View r9 = ((Widget) this).contentView.findViewById(2131363188);
        if (r9 == null) goto L31;
        UtilityKotlinExtentionsKt.t(r9);
        return;
    L31:
        return;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L9;
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue(), Boolean.FALSE) == false) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View
    public final void Bq(List<? extends ILinkPlayerInfoBridge> r4, long r5, boolean r7, String r8, String r9, boolean r10, int r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r4, "linkPlayerInfos");
        Intrinsics.checkNotNullParameter(r8, "nextCursor");
        Intrinsics.checkNotNullParameter(r9, "reqSource");
        if (((Widget) this).contentView != null) goto L6;
        return;
    L6:
        if (this.B != WaitingListType.UNKNOWN.ordinal()) goto L8;
        this.B = r11;
    L8:
        BaseRefreshLayout r14 = this.h;
        if (r14 != null) goto L11;
    L13:
        this.G = false;
        if (Intrinsics.areEqual(r9, "anchorChangeSortType") == false) goto L16;
        this.i.clear();
    L16:
        boolean r15 = this.l;
        if (r5 <= r4.size()) goto L27;
        if (r15 == false) goto L27;
        if (r13 == true) goto L27;
        if (ListUtils.isEmpty(this.j) == false) goto L23;
    L28:
        this.j.addAll(r4);
        if (this.F == true) goto L31;
        this.F = true;
        Fq();
    L31:
        MultiTypeAdapter r6 = this.v;
        if (r6 == null) goto L78;
        LinkedList<ILinkPlayerInfoBridge> r16 = this.j;
        if (Lists.isEmpty(r16) == false) goto L46;
        if (r12 == true) goto L37;
    L45:
        LinkedList<Object> r17 = this.i;
    L77:
        r6.a = r17;
        goto L78
    L37:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.z() == true) goto L45;
        this.i.clear();
        this.i.add(new zf0.f.a(this.B, ApplyTitlePanelType.ANCHOR_APPLY, ((yf0.a) this.b).j()));
        if (this.B != WaitingListType.PAID.ordinal()) goto L43;
        this.i.add(new zf0.d(3));
        goto L45
    L43:
        if (this.B != WaitingListType.NORMAL.ordinal()) goto L45;
        this.i.add(new zf0.d(5));
        goto L45
    L46:
        zf0.b.a r18 = new zf0.b.a();
        this.i.clear();
        this.i.addAll(r16);
        Iterator<T> r19 = this.i.iterator();
        int r110 = 0;
    L48:
        if (r19.hasNext() == false) goto L55;
        Object r111 = r19.next();
        if ((r111 instanceof ILinkPlayerInfoBridge) == false) goto L48;
        if (((ILinkPlayerInfoBridge) r111).isAddPrice() == false) goto L48;
        r110 = r110 + 1;
        goto L48
    L55:
        if (r110 > 0) goto L57;
    L61:
        SimpleDateFormat r112 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        if (r12 == false) goto L67;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == true) goto L67;
        this.i.add(0, new zf0.f.a(this.B, ApplyTitlePanelType.ANCHOR_APPLY, ((yf0.a) this.b).j()));
    L69:
        if (r7 == true) goto L71;
        r18.a = 1;
    L73:
        if ((this.i.getLast() instanceof zf0.b.a) == true) goto L75;
        this.i.add(r18);
    L76:
        this.l = r7;
        r17 = this.i;
        goto L77
    L75:
        this.i.removeLast();
        this.i.add(r18);
        goto L76
    L71:
        r18.a = 0;
    L67:
        if (this.i.size() <= 0) goto L69;
        this.i.add(0, new zf0.m.a(false, 2, ApplyTitlePanelType.ANCHOR_APPLY));
        goto L69
    L57:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == false) goto L61;
        LinkedList<Object> r113 = this.i;
        ApplyTitlePanelType r0 = ApplyTitlePanelType.ANCHOR_APPLY;
        r113.add(0, new zf0.m.a(true, 1, r0));
        int r114 = r110 + 1;
        if (this.i.size() <= r114) goto L69;
        this.i.add(r114, new zf0.m.a(true, 2, r0));
    L78:
        MultiTypeAdapter r20 = this.v;
        if (r20 == null) goto L81;
        r20.notifyDataSetChanged();
    L81:
        Map<String, cm2.a> r21 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.p.a("apply_panel") == true) goto L96;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.i("apply_panel");
        RecyclerView r22 = this.n;
        if (r22 == null) goto L90;
        RecyclerView.Adapter r23 = r22.getAdapter();
        if (r23 == null) goto L90;
        if (r23.getItemCount() != 0) goto L90;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.e("apply_panel");
    L90:
        RecyclerView r24 = this.n;
        if (r24 == null) goto L96;
        ViewTreeObserver r25 = r24.getViewTreeObserver();
        if (r25 == null) goto L96;
        r25.addOnGlobalLayoutListener(new n(this));
    L96:
        if (Lists.isEmpty(this.i) == false) goto L106;
        RecyclerView r26 = this.n;
        if (r26 == null) goto L100;
        r26.setVisibility(8);
    L100:
        LinearLayout r27 = this.o;
        if (r27 == null) goto L103;
        r27.setVisibility(0);
    L103:
        LinearLayout r28 = this.p;
        if (r28 == null) goto L115;
        r28.setVisibility(8);
    L115:
        Jq(false, Lists.isEmpty(this.i));
        this.A = r8;
        if (this.C == true) goto L126;
        this.C = true;
        Iq();
        return;
    L126:
        return;
    L106:
        RecyclerView r29 = this.n;
        if (r29 == null) goto L109;
        r29.setVisibility(0);
    L109:
        LinearLayout r30 = this.o;
        if (r30 == null) goto L112;
        r30.setVisibility(8);
    L112:
        LinearLayout r31 = this.p;
        if (r31 == null) goto L115;
        r31.setVisibility(8);
        goto L115
    L23:
        if (ListUtils.isEmpty(r4) == true) goto L28;
        ArrayList r32 = (ArrayList) Gq(this.j);
        r32.retainAll(Gq(r4));
        if (r32.size() <= 0) goto L28;
        this.j.clear();
    L27:
        this.j.clear();
        goto L28
    L11:
        if (r14.e == false) goto L13;
        this.J.postDelayed(new m(r14), 1000);
        goto L13
    }
}
