package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.list.FriendsInviteListBinder;
import com.bytedance.android.live.liveinteract.common.ui.OnlineFriendsCircleContainer;
import com.bytedance.android.live.liveinteract.common.ui.StickHeaderDecoration;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.list.FriendsItemBinder;
import com.bytedance.android.live.liveinteract.linkpanel.list.InviteMoreItemBinder;
import com.bytedance.android.live.liveinteract.linkpanel.list.ListSpaceItemBinder;
import com.bytedance.android.live.liveinteract.linkpanel.list.ListTitleItemBinder;
import com.bytedance.android.live.liveinteract.linkpanel.list.RoomInviteAllItemBinder;
import com.bytedance.android.live.liveinteract.linkpanel.list.RoomInviteMoreItemBinder;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.f1;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/LinkInviteListWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkInviteListWidgetContract$View;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkInviteListWidget extends BaseTalkInviteListWidgetContract$View {
    public static final /* synthetic */ int R = 0;
    public final List<com.bytedance.android.live.liveinteract.linkpanel.list.f> A;
    public final List<ILinkPlayerInfoBridge> B;
    public final Map<String, String> C;
    public int D;
    public boolean E;
    public BannerWidget F;
    public WidgetManager G;
    public final Lazy H;
    public boolean I;
    public final Function1<String, Boolean> J;
    public DataCenter K;
    public int L;
    public Disposable M;
    public final CompositeDisposable N;
    public final b O;
    public LinkInviteListWidget$mInviteCallback$1 P;
    public final c Q;
    public final Lazy c;
    public ViewGroup d;
    public ViewGroup e;
    public TextView f;
    public RecyclerView g;
    public MultiTypeAdapter h;
    public LinearLayout i;
    public LinearLayout j;
    public final LinkedList<Object> k;
    public final LinkedList<Object> l;
    public IRoom m;
    public boolean n;
    public boolean o;
    public final boolean p;
    public final StickHeaderDecoration q;
    public String r;
    public boolean s;
    public boolean t;
    public View u;
    public TextView v;
    public TextView w;
    public View x;
    public OnlineFriendsCircleContainer y;
    public final List<ILinkPlayerInfoBridge> z;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.liveinteract.linkpanel.list.o {
        public final /* synthetic */ LinkInviteListWidget a;

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
        public final void hw(ILinkPlayerInfoBridge r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "linkPlayerInfo");
        }

        public b(LinkInviteListWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
        public final void Ys(ILinkPlayerInfoBridge r4) {
            Intrinsics.checkNotNullParameter(r4, "linkPlayerInfo");
            LinkInviteListWidget.Iq(this.a, r4, false, 6);
        }
    }

    public static final class c implements com.bytedance.android.live.liveinteract.linkpanel.list.v {
        public final /* synthetic */ LinkInviteListWidget a;

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.v
        public final void a() {
            DataCenter r0 = this.a.K;
            if (r0 == null) goto L6;
            r0.put("data_audio_talk_show_invite_list_or_search", Boolean.TRUE);
            return;
        }

        public c(LinkInviteListWidget r1) {
            this.a = r1;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ LinkInviteListWidget a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            RecyclerView r0 = this.a.g;
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnGlobalLayoutListener(this);
        L7:
            Map<String, cm2.a> r2 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
            com.bytedance.android.live.liveinteract.linkpanel.util.p.e("invite_panel");
        }

        public d(LinkInviteListWidget r1) {
            this.a = r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LinkInviteListWidget a;

        public e(LinkInviteListWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((com.bytedance.android.live.liveinteract.d) r2).a != 3) goto L8;
            MultiTypeAdapter r3 = this.a.h;
            if (r3 == null) goto L9;
            r3.notifyDataSetChanged();
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ LinkInviteListWidget a;

        public f(LinkInviteListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Pair r3 = (Pair) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.getFirst() != null) goto L10;
            if (r3.getSecond() != null) goto L10;
            return;
        L10:
            if (r3.getSecond() == null) goto L12;
            LinkInviteListWidget r0 = this.a;
            Object r4 = r3.getSecond();
            Intrinsics.checkNotNull(r4);
            r0.wq((Throwable) r4);
            return;
        L12:
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r3.getFirst();
            if (r5 != null) goto L15;
            return;
        L15:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.t(this.a.n) == false) goto L17;
            this.a.Aq((a1) r5.data);
            return;
        L17:
            LinkInviteListWidget r1 = this.a;
            List<ILinkPlayerInfoBridge> r6 = ((a1) r5.data).getPlayerInfo();
            if (r6 != null) goto L20;
            r6 = CollectionsKt.emptyList();
        L20:
            r1.xq(r6);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ LinkInviteListWidget a;

        public g(LinkInviteListWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            HashMap r6 = new HashMap();
            IRoom r0 = this.a.m;
            if (r0 != null) goto L5;
        L7:
            String r1 = "video_live";
        L8:
            r6.put("live_type", r1);
            IRoom r2 = this.a.m;
            if (r2 == null) goto L14;
            IBaseUser r3 = r2.getOwner();
            if (r3 == null) goto L14;
            String r4 = r3.getIdString();
            if (r4 == null) goto L14;
        L15:
            r6.put("anchor_id", r4);
            IRoom r7 = this.a.m;
            if (r7 == null) goto L18;
            Long r8 = Long.valueOf(r7.getId());
        L19:
            r6.put("room_id", String.valueOf(r8));
            r6.put("request_page", "invite");
            com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r6, null, 6);
            j0.l().sendLog("livesdk_anchor_invite_user_button_click", r6, new Object[0]);
            LinkInviteListWidget r9 = this.a;
            yf0.c r10 = (yf0.c) r9.b;
            Context r11 = ((Widget) r9).context;
            if (r11 == null) goto L24;
            r10.h((Activity) r11);
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

    static {
    }

    public final int getLayoutId() {
        return 2131565513;
    }

    public final void Eq() {
        if (this.s == true) goto L5;
        return;
    L5:
        if (this.t == false) goto L28;
        String r0 = this.r;
        if (r0 == null) goto L20;
        int r3 = r0.hashCode();
        if (r3 != 3046160) goto L12;
        String r4 = "card";
        if (r0.equals("card") == false) goto L20;
    L21:
        DataCenter r1 = this.K;
        if (r1 == null) goto L24;
        String r2 = (String) r1.get("data_task_name_when_open_invite_panel", "");
    L25:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.k(false, "invite", r4, r2, 0, ((ArrayList) this.z).size(), ((ArrayList) this.A).size());
        return;
    L24:
        r2 = null;
        goto L25
    L12:
        if (r3 != 3526149) goto L20;
        r4 = "seat";
        if (r0.equals("seat") == true) goto L21;
    L20:
        r4 = "icon";
        goto L21
    }

    public final void Gq() {
        Map<String, cm2.a> r0 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.p.a("invite_panel") == true) goto L17;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.i("invite_panel");
        RecyclerView r1 = this.g;
        if (r1 == null) goto L11;
        RecyclerView.Adapter r2 = r1.getAdapter();
        if (r2 == null) goto L11;
        if (r2.getItemCount() != 0) goto L11;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.e("invite_panel");
        return;
    L11:
        RecyclerView r3 = this.g;
        if (r3 == null) goto L19;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L20;
        r4.addOnGlobalLayoutListener(new d(this));
        return;
    L20:
        return;
    L19:
        return;
    }

    public LinkInviteListWidget() {
        this.c = LazyKt.lazy(LinkInviteListWidget$adminInviteAndApplyViewModel$2.INSTANCE);
        this.k = new LinkedList();
        this.l = new LinkedList();
        this.p = jc1.k.n(IMiddlewareUserService.class).user().c();
        this.q = new StickHeaderDecoration();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new LinkedHashMap();
        this.H = LazyKt.lazy(LinkInviteListWidget$userCenter$2.INSTANCE);
        this.I = true;
        this.J = new LinkInviteListWidget$userListFilterAction$1(this);
        this.L = -1;
        this.N = new CompositeDisposable();
        this.O = new b(this);
        this.P = new LinkInviteListWidget$mInviteCallback$1(this);
        this.Q = new c(this);
    }

    public final void onCreate() {
        super.onCreate();
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        this.m = r0;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.I = r1;
        StickHeaderDecoration r2 = this.q;
        IRoom r3 = this.m;
        r2.d = r3;
        IRoom r4 = null;
        if (r3 == null) goto L11;
        String r5 = r3.getOwnerUserIdString();
    L12:
        this.n = Intrinsics.areEqual(r5, jc1.k.n(IMiddlewareUserService.class).user().n());
        final View r6 = ((Widget) this).contentView;
        this.g = r6.findViewById(2131384731);
        this.i = (LinearLayout) r6.findViewById(2131371744);
        this.j = (LinearLayout) r6.findViewById(2131371557);
        this.h = new MultiTypeAdapter();
        RecyclerView r7 = this.g;
        if (r7 == null) goto L15;
        r7.setLayoutManager(new LinearLayoutManager(r7.getContext()));
        r7.setAdapter(this.h);
    L15:
        MultiTypeAdapter r8 = this.h;
        if (r8 == null) goto L18;
        r8.a = this.k;
        r8.z2(com.bytedance.android.live.liveinteract.linkpanel.list.l.class, new InviteMoreItemBinder(com.bytedance.android.live.liveinteract.linkpanel.util.o.c(), this.I, new LinkInviteListWidget$onViewCreated$$inlined$apply$lambda$1(this, r6)));
        r8.z2(com.bytedance.android.live.liveinteract.linkpanel.list.q.class, new ListTitleItemBinder());
        r8.z2(com.bytedance.android.live.liveinteract.linkpanel.list.p.class, new ListSpaceItemBinder());
        r8.z2(com.bytedance.android.live.liveinteract.chatroom.chatroom.list.e.class, new FriendsInviteListBinder(this.I, this.m, this.n, this.p, new LinkInviteListWidget$onViewCreated$$inlined$apply$lambda$2(this, r6), new LinkInviteListWidget$onViewCreated$$inlined$apply$lambda$3(this, r6)));
        r8.z2(zf0.c.a.class, new zf0.c());
        r8.z2(com.bytedance.android.live.liveinteract.linkpanel.list.f.class, new FriendsItemBinder(this.I, new LinkInviteListWidget$onViewCreated$$inlined$apply$lambda$4(this, r6)));
        r8.z2(com.bytedance.android.live.liveinteract.linkpanel.list.t.class, new RoomInviteMoreItemBinder(new LinkInviteListWidget$onViewCreated$$inlined$apply$lambda$5(this, r6)));
        r8.z2(com.bytedance.android.live.liveinteract.linkpanel.list.r.class, new RoomInviteAllItemBinder(new LinkInviteListWidget$onViewCreated$$inlined$apply$lambda$6(this, r6)));
    L18:
        r6.findViewById(2131384133).setOnClickListener(new n(this));
        this.u = r6.findViewById(2131392077);
        TextView r9 = (TextView) r6.findViewById(2131375618);
        if (this.n == false) goto L21;
    L23:
        r9.setText(s1.B(2131917667));
        r9.setBackground(ContextCompat.getDrawable(r9.getContext(), 2131249992));
        Unit r10 = Unit.INSTANCE;
        this.v = r9;
        TextView r11 = (TextView) r6.findViewById(2131390740);
        r11.setText(s1.B(2131918025));
        this.w = r11;
        this.x = r6.findViewById(2131371586);
        this.y = (OnlineFriendsCircleContainer) r6.findViewById(2131373315);
        if (this.E == false) goto L46;
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L28;
        r4 = (IRoom) r12.getValue();
    L28:
        this.F = new BannerWidget(r4, 22, "invite_connection_panel", null, new o(this));
        FragmentActivity r13 = getContext();
        if (r13 == null) goto L45;
        this.G = WidgetManager.of(r13, r6);
        t61 r14 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r14 != null) goto L33;
    L41:
        WidgetManager r15 = this.G;
        if (r15 == null) goto L46;
        r15.load(2131372686, this.F);
        goto L46
    L33:
        if (u61.a(r14) != true) goto L41;
        View r16 = ((Widget) this).contentView;
        if (r16 == null) goto L46;
        p r17 = new p(this);
        t61 r18 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r18 == null) goto L39;
        long r19 = r18.a3();
    L40:
        r16.postDelayed(r17, r19);
        goto L46
    L39:
        r19 = 1000;
        goto L40
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L46:
        ViewGroup r20 = (ViewGroup) r6.findViewById(2131366894);
        this.d = r20;
        if (r20 == null) goto L49;
        UtilityKotlinExtentionsKt.w(r20);
        r20.setOnClickListener(new m(this));
    L49:
        this.e = (ViewGroup) r6.findViewById(2131375603);
        this.f = (TextView) r6.findViewById(2131375605);
        String r21 = com.bytedance.android.live.liveinteract.linkpanel.util.o.g();
        if (r21 != null) goto L52;
    L59:
        com.bytedance.android.live.liveinteract.linkpanel.presenter.h r22 = new com.bytedance.android.live.liveinteract.linkpanel.presenter.h(this.m, this);
        this.b = r22;
        ((com.bytedance.android.livesdk.common.c) r22).a = this;
        MultiTypeAdapter r23 = this.h;
        if (r23 == null) goto L62;
        r23.z2(com.bytedance.android.live.liveinteract.linkpanel.list.w.class, new com.bytedance.android.live.liveinteract.linkpanel.list.d(this.Q));
    L62:
        MultiTypeAdapter r24 = this.h;
        if (r24 == null) goto L66;
        r24.z2(ILinkPlayerInfoBridge.class, new zf0.h(this.I, this.O, 1));
    L66:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.B() == false) goto L71;
        if (this.L > 0) goto L71;
        this.M = xs2.b.a().b(com.bytedance.android.live.liveinteract.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
    L71:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L87;
        LinkInviteListWidget$mInviteCallback$1 r25 = this.P;
        rj0.k.m2.getClass();
        rj0.k r26 = rj0.k.a.a();
        if (r26 == null) goto L75;
        r26.setInviteCallback(r25);
    L78:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        IVoiceChatAdminService r27 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r27 != null) goto L83;
        IVoiceChatAdminService.Companion.getClass();
        r27 = IVoiceChatAdminService.a.a();
        if (r27 != null) goto L83;
    L84:
        IKtvService r28 = jc1.k.f(IKtvService.class);
        if (r28 == null) goto L87;
        r28.setInviteCallback(r25);
    L83:
        r27.setInviteCallback(r25);
        goto L84
    L75:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r29 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r29 == null) goto L78;
        r29.setInviteCallback(r25);
    L87:
        t61 r30 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r30 != null) goto L90;
        return;
    L90:
        if (u61.a(r30) != true) goto L98;
        AdminInviteAndApplyViewModel r31 = (AdminInviteAndApplyViewModel) this.c.getValue();
        if (r31 == null) goto L99;
        MutableLiveData<Pair<com.bytedance.android.live.network.response.e<a1>, Throwable>> r32 = r31.getInviteListResponse();
        if (r32 == null) goto L100;
        r32.observe(this, new f(this));
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L52:
        if (r2.a(r21) != true) goto L59;
        ViewGroup r33 = this.e;
        if (r33 == null) goto L56;
        r33.setVisibility(0);
    L56:
        TextView r34 = this.f;
        if (r34 == null) goto L59;
        r34.setText(r21);
        goto L59
    L21:
        if (this.p == false) goto L23;
        r9.setVisibility(8);
        goto L23
    L11:
        r5 = null;
        goto L12
    L5:
        if (r0.isLiveTypeAudio() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void onDestroy() {
        super.onDestroy();
        yf0.c r0 = (yf0.c) this.b;
        if (r0 == null) goto L5;
        ((com.bytedance.android.livesdk.common.c) r0).a = null;
    L5:
        Disposable r1 = this.M;
        if (r1 != null) goto L8;
    L10:
        this.N.clear();
        t61 r2 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r2 != null) goto L13;
        return;
    L13:
        if (u61.c(r2) != true) goto L28;
        AdminInviteAndApplyViewModel r3 = (AdminInviteAndApplyViewModel) this.c.getValue();
        if (r3 == null) goto L19;
        MutableLiveData<Pair<com.bytedance.android.live.network.response.e<a1>, Throwable>> r4 = r3.getInviteListResponse();
        if (r4 == null) goto L19;
        r4.setValue(null);
    L19:
        WidgetManager r5 = this.G;
        if (r5 == null) goto L22;
        r5.unload(this.F);
    L22:
        WidgetManager r6 = this.G;
        if (r6 == null) goto L25;
        r6.contentView = null;
    L25:
        this.F = null;
        this.a = null;
        ((Widget) this).contentView = null;
        ((Widget) this).containerView = null;
        this.P = null;
        return;
    L28:
        return;
    L8:
        if (r1.isDisposed() == true) goto L10;
        r1.dispose();
        goto L10
    }

    public final void onResume() {
        super.onResume();
        Map<String, cm2.a> r0 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.c("invite_panel");
        t61 r1 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        boolean r2 = true;
        if (r1 == null) goto L7;
        if (u61.a(r1) != true) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.t(this.n) == false) goto L15;
        yf0.c r3 = (yf0.c) this.b;
        if (this.n == false) goto L11;
    L14:
        r3.d(r2);
        return;
    L11:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.I() == true) goto L14;
        r2 = false;
        goto L14
    L15:
        ((yf0.c) this.b).e();
    }

    public static final boolean Bq(LinkInviteListWidget r2) {
        r2.getClass();
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        com.bytedance.android.live.liveinteract.plantform.base.i r3 = (com.bytedance.android.live.liveinteract.plantform.base.i) r2.H.getValue();
        if (r3 == null) goto L21;
        List r4 = r3.getOnlineUserList();
        if (r4 == null) goto L21;
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L9;
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L21;
        IBaseUser r1 = ((ILinkPlayerInfoBridge) r6.next()).getUser();
        if (r1 == null) goto L17;
        String r7 = r1.getIdString();
    L19:
        if (Intrinsics.areEqual(r7, r0) == false) goto L13;
        return true;
    L17:
        r7 = null;
        goto L19
    L9:
        if (r5.isEmpty() == false) goto L11;
    L21:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View
    public final void Aq(a1 r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        if (((Widget) this).contentView != null) goto L5;
        return;
    L5:
        this.t = true;
        List<ILinkPlayerInfoBridge> r1 = r9.getPlayerInfo();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L41;
        List<ILinkPlayerInfoBridge> r3 = r9.getFriends();
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L41;
        List<ILinkPlayerInfoBridge> r5 = r9.getAiGuests();
        if (r5 != null) goto L25;
    L28:
        boolean r6 = true;
    L29:
        if (r6 == false) goto L41;
        Gq();
        LinearLayout r10 = this.j;
        if (r10 == null) goto L33;
        r10.setVisibility(0);
    L33:
        LinearLayout r11 = this.i;
        if (r11 == null) goto L36;
        r11.setVisibility(8);
    L36:
        RecyclerView r12 = this.g;
        if (r12 == null) goto L39;
        r12.setVisibility(8);
    L39:
        Eq();
        return;
    L25:
        if (r5.isEmpty() == true) goto L28;
        r6 = false;
        goto L29
    L17:
        if (r3.isEmpty() == true) goto L20;
        r4 = false;
    L41:
        List<ILinkPlayerInfoBridge> r7 = r9.getPlayerInfo();
        List<ILinkPlayerInfoBridge> r8 = r9.getFriends();
        if (r7 != null) goto L44;
    L49:
        boolean r13 = false;
    L50:
        if (r13 == false) goto L60;
        List<ILinkPlayerInfoBridge> r14 = r9.getAiGuests();
        if (r14 != null) goto L54;
    L57:
        boolean r15 = true;
    L58:
        if (r15 == false) goto L60;
        return;
    L54:
        if (r14.isEmpty() == true) goto L57;
        r15 = false;
    L60:
        LinearLayout r16 = this.j;
        if (r16 == null) goto L63;
        r16.setVisibility(8);
    L63:
        LinearLayout r17 = this.i;
        if (r17 == null) goto L66;
        r17.setVisibility(8);
    L66:
        RecyclerView r18 = this.g;
        if (r18 == null) goto L69;
        r18.setVisibility(0);
    L69:
        ((ArrayList) this.z).clear();
        ((ArrayList) this.A).clear();
        ((ArrayList) this.B).clear();
        this.D = 0;
        List<ILinkPlayerInfoBridge> r19 = r9.getPlayerInfo();
        if (r19 != null) goto L72;
        r19 = CollectionsKt.emptyList();
    L72:
        Iterator<T> r20 = r19.iterator();
    L74:
        if (r20.hasNext() == false) goto L76;
        ((ArrayList) this.z).add((ILinkPlayerInfoBridge) r20.next());
        goto L74
    L76:
        List<ILinkPlayerInfoBridge> r21 = r9.getFriends();
        if (r21 != null) goto L79;
        r21 = CollectionsKt.emptyList();
    L79:
        Iterator<T> r22 = r21.iterator();
    L81:
        if (r22.hasNext() == false) goto L83;
        ILinkPlayerInfoBridge r23 = (ILinkPlayerInfoBridge) r22.next();
        ((ArrayList) this.A).add(new com.bytedance.android.live.liveinteract.linkpanel.list.f(r23));
        goto L81
    L83:
        List<ILinkPlayerInfoBridge> r24 = r9.getAiGuests();
        if (r24 != null) goto L86;
        r24 = CollectionsKt.emptyList();
    L86:
        Iterator<T> r25 = r24.iterator();
    L88:
        if (r25.hasNext() == false) goto L90;
        ((ArrayList) this.B).add((ILinkPlayerInfoBridge) r25.next());
        goto L88
    L90:
        IInteractService r26 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r26 == null) goto L99;
        ih0.b r27 = r26.dynamicService(((Widget) this).dataCenter);
        if (r27 == null) goto L99;
        JsonObject r28 = new JsonObject();
        if ((!((ArrayList) this.B).isEmpty()) == false) goto L97;
        String r29 = "1";
    L98:
        r28.addProperty("enable", r29);
        Unit r30 = Unit.INSTANCE;
        r27.Dk("ai_guests", "ai_guest_status", r28, false);
        goto L99
    L97:
        r29 = "0";
    L99:
        Eq();
        String r31 = null;
        if (vm2.d.p0() == true) goto L102;
    L109:
        LinkedList<Object> r32 = this.k;
        r32.clear();
        r32.add(new com.bytedance.android.live.liveinteract.linkpanel.list.p(0));
        this.D++;
        if ((!((ArrayList) this.z).isEmpty()) == true) goto L116;
        if ((!((ArrayList) this.A).isEmpty()) == true) goto L116;
        if ((!((ArrayList) this.B).isEmpty()) == true) goto L116;
    L142:
        if (this.n == true) goto L149;
        if (this.p == true) goto L149;
        if ((true ^ ((ArrayList) this.A).isEmpty()) == false) goto L149;
        r32.addAll(this.A);
    L149:
        if (this.n == true) goto L154;
        if (this.p == true) goto L154;
        r32.add(com.bytedance.android.live.liveinteract.linkpanel.list.l.a);
        r32.add(new com.bytedance.android.live.liveinteract.linkpanel.list.p(UtilityKotlinExtentionsKt.i(20)));
    L154:
        if (this.n == false) goto L156;
    L157:
        RecyclerView r33 = this.g;
        if (r33 == null) goto L160;
        r33.removeItemDecoration(this.q);
    L160:
        RecyclerView r34 = this.g;
        if (r34 == null) goto L163;
        r34.addItemDecoration(this.q);
    L163:
        r3.a(this.g, s1.B(2131918160));
    L164:
        LinkedList<Object> r35 = this.l;
        r35.clear();
        r35.addAll(this.A);
        if (r35.size() <= 0) goto L167;
        r35.add(com.bytedance.android.live.liveinteract.linkpanel.list.l.a);
    L167:
        MultiTypeAdapter r36 = this.h;
        if (r36 == null) goto L170;
        r36.notifyDataSetChanged();
    L170:
        Gq();
        boolean r37 = this.I;
        DataCenter r0 = this.K;
        if (r0 == null) goto L174;
        r31 = (String) r0.get("data_task_name_when_open_invite_panel", "");
    L174:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.m.h() == true) goto L187;
        HashMap r38 = new HashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r38, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.H(r38, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        if (r37 == false) goto L178;
        String r39 = "voice_live";
    L179:
        r38.put("live_type", r39);
        r38.put("enter_from", "live_detail");
        r38.put("user_type", "link_user");
        if (TextUtils.isEmpty(r31) == true) goto L182;
        r38.put("is_task", "1");
        Intrinsics.checkNotNull(r31);
        r38.put("activity_name", r31);
    L182:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.L("livesdk_anchor_connection_invite_show", r38, new Object[0]);
        return;
    L178:
        r39 = "video_live";
        goto L179
    L187:
        return;
    L156:
        if (this.p == false) goto L164;
    L116:
        if (this.n == true) goto L120;
        if (this.p == true) goto L120;
    L127:
        List<ILinkPlayerInfoBridge> r40 = this.z;
        if (r40 != null) goto L130;
    L133:
        boolean r41 = true;
    L134:
        if (r41 == true) goto L136;
    L140:
        r32.addAll(this.z);
        this.D += ((ArrayList) this.z).size();
        goto L142
    L136:
        if (this.p == false) goto L138;
    L139:
        r32.add(new zf0.c.a());
        goto L142
    L138:
        if (this.n == false) goto L140;
    L130:
        if (((ArrayList) r40).isEmpty() == true) goto L133;
        r41 = false;
    L120:
        if (((ArrayList) this.A).size() <= 0) goto L122;
    L123:
        LinkedList<Object> r42 = this.l;
        r42.clear();
        r42.addAll(this.A);
        if (r42.size() <= 0) goto L126;
        r42.add(com.bytedance.android.live.liveinteract.linkpanel.list.l.a);
    L126:
        r32.add(new com.bytedance.android.live.liveinteract.chatroom.chatroom.list.e(this.l, this.B));
        goto L127
    L122:
        if (((ArrayList) this.B).size() <= 0) goto L127;
    L102:
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(this.m, null) == false) goto L109;
        LinkedList<Object> r43 = this.k;
        r43.clear();
        r43.add(new com.bytedance.android.live.liveinteract.linkpanel.list.p(0));
        r43.add(new com.bytedance.android.live.liveinteract.linkpanel.list.q((byte) 8));
        r43.add(new com.bytedance.android.live.liveinteract.chatroom.chatroom.list.e(new LinkedList(), this.B));
        if ((!((ArrayList) this.z).isEmpty()) == false) goto L106;
    L107:
        r43.add(new com.bytedance.android.live.liveinteract.linkpanel.list.q((byte) 4));
    L108:
        r43.addAll(this.z);
        r43.addAll(this.A);
        goto L167
    L106:
        if ((true ^ ((ArrayList) this.A).isEmpty()) == false) goto L108;
    L44:
        if (r7.size() != ((ArrayList) this.z).size()) goto L49;
        if (r8 == null) goto L49;
        if (r8.size() != ((ArrayList) this.A).size()) goto L49;
        r13 = true;
        goto L50
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L13
    }

    public final int Fq(int r5) {
        int r0 = com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurUILayout();
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L8;
        if (yg0.h.i(r1) != true) goto L8;
        return r5;
    L8:
        if (r0 == 8) goto L17;
        if (r0 == 5) goto L13;
        return r5;
    L13:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom()) == false) goto L15;
        return r5;
    L15:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.F(r1) == true) goto L17;
        return r5;
    L17:
        return r5 + 1;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View
    public final void wq(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "throwable");
        if (((Widget) this).contentView != null) goto L6;
        Map<String, cm2.a> r6 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.f("invite_panel", null, -40001, "contentView is null", 2);
        return;
    L6:
        com.bytedance.android.live.liveinteract.linkpanel.util.p.f("invite_panel", r5, null, null, 12);
        r5.printStackTrace();
        LinearLayout r7 = this.j;
        if (r7 == null) goto L9;
        r7.setVisibility(8);
    L9:
        RecyclerView r8 = this.g;
        if (r8 == null) goto L12;
        r8.setVisibility(8);
    L12:
        LinearLayout r9 = this.i;
        if (r9 == null) goto L15;
        r9.setVisibility(0);
    L15:
        this.t = true;
        Eq();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View
    public final void xq(List<? extends ILinkPlayerInfoBridge> r5) {
        Intrinsics.checkNotNullParameter(r5, "linkPlayerInfos");
        if (((Widget) this).contentView != null) goto L5;
        return;
    L5:
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        ArrayList r1 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Object r2 = r6.next();
        IBaseUser r3 = ((ILinkPlayerInfoBridge) r2).getUser();
        if (r3 == null) goto L11;
        String r4 = r3.getIdString();
    L13:
        if ((!Intrinsics.areEqual(r4, r0)) == false) goto L7;
        r1.add(r2);
        goto L7
    L11:
        r4 = null;
        goto L13
    L16:
        if (Lists.isEmpty(r1) == false) goto L18;
        ((yf0.c) this.b).f();
        return;
    L18:
        this.k.clear();
        com.bytedance.android.live.liveinteract.linkpanel.list.w r7 = new com.bytedance.android.live.liveinteract.linkpanel.list.w();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.c() == 4) goto L21;
        this.k.add(r7);
    L21:
        this.k.addAll(r1);
        MultiTypeAdapter r8 = this.h;
        if (r8 == null) goto L24;
        r8.notifyDataSetChanged();
    L24:
        RecyclerView r9 = this.g;
        if (r9 == null) goto L27;
        r9.setVisibility(0);
    L27:
        LinearLayout r10 = this.j;
        if (r10 == null) goto L30;
        r10.setVisibility(8);
    L30:
        LinearLayout r11 = this.i;
        if (r11 == null) goto L40;
        r11.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View
    public final void yq(com.bytedance.android.live.liveinteract.linkpanel.model.a r5) {
        Intrinsics.checkNotNullParameter(r5, "body");
        LinearLayout r0 = this.j;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        LinearLayout r1 = this.i;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        RecyclerView r2 = this.g;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        IRoom r3 = this.m;
        if (r3 == null) goto L18;
        IBaseUser r4 = r3.getOwner();
        if (r4 == null) goto L18;
        if (r4.getSecret() != 1) goto L18;
    L21:
        View r6 = this.x;
        if (r6 == null) goto L24;
        r6.setVisibility(0);
    L24:
        OnlineFriendsCircleContainer r7 = this.y;
        if (r7 == null) goto L57;
        r7.setVisibility(8);
        return;
    L57:
        return;
    L18:
        if (this.n == true) goto L29;
        if (this.p == true) goto L21;
    L29:
        if (Lists.isEmpty(r5.b()) == false) goto L33;
        View r8 = this.x;
        if (r8 == null) goto L42;
        r8.setVisibility(0);
    L42:
        TextView r9 = this.w;
        if (r9 == null) goto L46;
        r9.setText(r5.a());
    L46:
        if (this.n == false) goto L50;
        TextView r10 = this.v;
        if (r10 == null) goto L50;
        r10.setVisibility(0);
    L50:
        TextView r11 = this.v;
        if (r11 == null) goto L53;
        r11.setText(s1.B(2131917671));
    L53:
        TextView r12 = this.v;
        if (r12 == null) goto L58;
        r12.setOnClickListener(new g(this));
        return;
    L58:
        return;
    L33:
        View r13 = this.x;
        if (r13 == null) goto L36;
        r13.setVisibility(8);
    L36:
        OnlineFriendsCircleContainer r14 = this.y;
        if (r14 == null) goto L39;
        r14.a(r5.b());
    L39:
        OnlineFriendsCircleContainer r15 = this.y;
        if (r15 == null) goto L42;
        r15.setVisibility(0);
        goto L42
    }

    public static final void Cq(final LinkInviteListWidget r7, View r8) {
        r7.getClass();
        int r0 = r8.getId();
        if (f1.a == r0) goto L5;
        f1.a = r0;
        f1.b = 0;
    L5:
        long r1 = System.currentTimeMillis();
        if ((r1 - f1.b) >= 1500) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        f1.b = r1;
    L11:
        if (r2 == true) goto L18;
        ALogger.i("LinkInviteListWidget", "showIMInvitePage: social service = " + jc1.k.f(IMiddlewareHostSocial.class));
        IMiddlewareHostSocial r3 = jc1.k.f(IMiddlewareHostSocial.class);
        if (r3 == null) goto L17;
        r3.showInviteFriendActivity(r8.getContext(), new LinkInviteListWidget$showIMInvitePage$1(r7));
        return;
    L17:
        return;
    L18:
        return;
    L8:
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View
    public final void zq(final List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r14, List<? extends e1> r15) {
        Intrinsics.checkNotNullParameter(r14, "invitedList");
        final Context r0 = ((Widget) this).context;
        if (r0 != null) goto L5;
        return;
    L5:
        final IRoom r8 = this.m;
        if (r8 != null) goto L9;
        return;
    L9:
        if (r15 == null) goto L28;
        Iterator<T> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L28;
        e1 r1 = (e1) r16.next();
        int r2 = com.bytedance.android.live.liveinteract.linkpanel.util.j.a;
        Intrinsics.checkNotNullParameter("panel_friends", "source");
        ALogger.i("InvitePageLogger", "logInviteByIM: source = ".concat("panel_friends"));
        Iterator<T> r3 = r14.iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((IMiddlewareHostSocial.InviteFriendsConfig.Friend) r4).getUid(), String.valueOf(r1.getUserId())) == false) goto L15;
    L20:
        IMiddlewareHostSocial.InviteFriendsConfig.Friend r5 = (IMiddlewareHostSocial.InviteFriendsConfig.Friend) r4;
        if (r5 == null) goto L12;
        ArrayList r10 = CollectionsKt.arrayListOf(new IMiddlewareHostSocial.InviteFriendsConfig.Friend[]{r5});
        final boolean r6 = r1.getNeedPush();
        String r7 = r1.getAction();
        if (r7 != null) goto L25;
        r7 = "";
    L25:
        final String r9 = r7;
        IMiddlewareHostSocial r11 = jc1.k.f(IMiddlewareHostSocial.class);
        if (r11 == null) goto L12;
        r11.inviteFriendsByIM(r0, r10, new LinkInviteListWidget$onInviteFriendsSuccess$$inlined$forEach$lambda$1(r6, r9, this, r14, r0, r8));
        goto L12
    L19:
        r4 = null;
    L28:
        Set r17 = SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r14), LinkInviteListWidget$onInviteFriendsSuccess$invitedIds$1.INSTANCE), LinkInviteListWidget$onInviteFriendsSuccess$invitedIds$2.INSTANCE));
        if (this.n == false) goto L31;
    L46:
        Sequence r18 = SequencesKt.filter(CollectionsKt.asSequence(this.l), LinkInviteListWidget$onInviteFriendsSuccess$$inlined$filterIsInstance$2.INSTANCE);
        if (r18 == null) goto L63;
        Iterator r19 = r18.iterator();
    L50:
        if (r19.hasNext() == false) goto L58;
        com.bytedance.android.live.liveinteract.linkpanel.list.f r12 = (com.bytedance.android.live.liveinteract.linkpanel.list.f) r19.next();
        Set r13 = r17;
        IBaseUser r20 = r12.a.getUser();
        if (r20 == null) goto L54;
        String r21 = r20.getIdString();
    L56:
        if (CollectionsKt.contains(r13, r21) == false) goto L50;
        r12.a.setLastInvitedTimeMillis(p6.b());
        goto L50
    L54:
        r21 = null;
    L58:
        MultiTypeAdapter r110 = this.h;
        if (r110 == null) goto L84;
        r110.notifyDataSetChanged();
        return;
    L84:
        return;
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L31:
        if (this.p == true) goto L46;
        Sequence r111 = SequencesKt.filter(CollectionsKt.asSequence(this.k), LinkInviteListWidget$onInviteFriendsSuccess$$inlined$filterIsInstance$1.INSTANCE);
        if (r111 == null) goto L45;
        Iterator r112 = r111.iterator();
    L36:
        if (r112.hasNext() == false) goto L58;
        com.bytedance.android.live.liveinteract.linkpanel.list.f r22 = (com.bytedance.android.live.liveinteract.linkpanel.list.f) r112.next();
        Set r23 = r17;
        IBaseUser r24 = r22.a.getUser();
        if (r24 == null) goto L40;
        String r25 = r24.getIdString();
    L42:
        if (CollectionsKt.contains(r23, r25) == false) goto L36;
        r22.a.setLastInvitedTimeMillis(p6.b());
        goto L36
    L40:
        r25 = null;
        goto L42
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    public static void Iq(LinkInviteListWidget r5, ILinkPlayerInfoBridge r6, boolean r7, int r8) {
        if ((r8 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r8 & 4) == 0) goto L10;
        r7 = false;
    L10:
        if (((Widget) r5).isViewValid == true) goto L13;
        return;
    L13:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.B() == true) goto L17;
        MultiTypeAdapter r9 = r5.h;
        if (r9 == null) goto L17;
        r9.notifyDataSetChanged();
    L17:
        IBaseUser r10 = r6.getUser();
        if (r10 == null) goto L50;
        if (r0 == true) goto L22;
    L30:
        IRoom r11 = r5.m;
        if (r11 == null) goto L48;
        r11.getId();
        int r12 = r5.Fq(r5.L);
        Room r1 = r5.m;
        if (r1 != null) goto L35;
        r1 = new Room();
    L35:
        gd0.m r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r3 == null) goto L42;
        com.bytedance.android.live.liveinteract.videolink.a r4 = new com.bytedance.android.live.liveinteract.videolink.a((IRoomBase) r1, r10, r12);
        r4.f = r0;
        r4.c = true;
        if (r7 == false) goto L40;
        r4.b = -1;
    L40:
        Unit r13 = Unit.INSTANCE;
        ((LinkPanelTransitService) r3).g(r4);
    L42:
        if (r5.n == false) goto L44;
        String r14 = "anchor";
    L45:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.g(r14, r10.getIdString(), "list", r12);
        return;
    L44:
        r14 = "administrator";
        goto L45
    L48:
        return;
    L22:
        if (r5.n == true) goto L30;
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L30;
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L28;
        f2.b(2131914522, 0);
    L29:
        com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.INVITE);
        return;
    L28:
        f2.b(2131917298, 0);
        goto L29
    L50:
        return;
    L5:
        r0 = false;
        goto L7
    }
}
