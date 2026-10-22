package com.bytedance.android.livesdk.feed.drawerfeed.singledraw;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.live.ui.FadingEdgeRecyclerview;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdkapi.feed.LiveDrawerUrlHelper;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.keva.Keva;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/SingleListDrawFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleListDrawFragment extends BaseFragment {
    public static final /* synthetic */ int H = 0;
    public final MultiTypeAdapter A;
    public SingleDrawFeedAdapter B;
    public ViewGroup C;
    public TextView D;
    public final CompositeDisposable E;
    public Disposable F;
    public final e G;
    public final String d;
    public View e;
    public TabListModel f;
    public final cw1.b g;
    public SingleDrawViewModel h;
    public ViewGroup i;
    public DoubleBallSwipeRefreshLayout j;
    public View k;
    public View l;
    public TextView m;
    public View n;
    public View o;
    public ViewGroup p;
    public FadingEdgeRecyclerview q;
    public FadingEdgeRecyclerview r;
    public CenterScrollLayoutManager s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public View y;
    public final Keva z;

    public static final class a {
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "res");
            if (r3.isLogOut() == false) goto L5;
        L8:
            return true;
        L5:
            if (r3.isLogin() == true) goto L8;
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SingleListDrawFragment a;
        public final /* synthetic */ long b;

        public c(SingleListDrawFragment r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            UserEvent r5 = (UserEvent) r4;
            r5.isLogin();
            if (r5.isLogin() == false) goto L9;
            ViewGroup r6 = this.a.C;
            if (r6 == null) goto L7;
            r6.setVisibility(8);
        L7:
            this.a.U90(this.b, false);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SingleListDrawFragment a;

        public d(SingleListDrawFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.user.f r5 = jc1.k.n(IUserService.class).user();
            FragmentActivity r0 = this.a.getActivity();
            l.a r1 = new l.a();
            r1.c = -1;
            r5.login(r0, new l(r1)).subscribe(this.a.G);
        }
    }

    public static final class e extends com.bytedance.android.livesdk.user.h<IBaseUser> {
        public final /* synthetic */ SingleListDrawFragment a;

        public e(SingleListDrawFragment r1) {
            this.a = r1;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.E.add(r2);
        }
    }

    public static final class f implements SwipeRefreshLayout.f {
        public final /* synthetic */ SingleListDrawFragment a;

        public f(SingleListDrawFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout.f
        public final void onRefresh() {
            SingleDrawViewModel r0 = this.a.h;
            if (r0 == null) goto L16;
            NextLiveData r1 = r0.getTabRefresh();
            if (r1 == null) goto L17;
            TabListModel r2 = this.a.f;
            if (r2 == null) goto L13;
            bw1.e r3 = r2.getCurrentTabModel();
            if (r3 == null) goto L13;
            com.bytedance.android.livesdk.feed.feed.e r4 = r3.f;
            if (r4 == null) goto L13;
            long r5 = r4.f();
        L14:
            r1.setValue(Long.valueOf(r5));
            return;
        L13:
            r5 = -1;
            goto L14
        L17:
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ SingleListDrawFragment a;

        public g(SingleListDrawFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            SingleListDrawFragment.T90(this.a);
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ SingleListDrawFragment a;

        public h(SingleListDrawFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            SingleListDrawFragment.S90(this.a);
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ SingleListDrawFragment a;

        public i(SingleListDrawFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            SingleListDrawFragment.T90(this.a);
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ SingleListDrawFragment a;

        public j(SingleListDrawFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            SingleListDrawFragment.S90(this.a);
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ SingleListDrawFragment a;

        public k(SingleListDrawFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            ViewGroup r6 = this.a.p;
            if (r6 != null) goto L5;
        L16:
            SingleListDrawFragment r7 = this.a;
            SingleListDrawFragment.W90(CollectionsKt.mutableListOf(new View[]{r7.p, r7.i, r7.n, r7.o}));
            return;
        L5:
            if (r6.getVisibility() != 8) goto L16;
            int r8 = aw1.a.a;
            TabListModel r9 = this.a.f;
            if (r9 == null) goto L14;
            bw1.e r10 = r9.getCurrentTabModel();
            if (r10 == null) goto L14;
            com.bytedance.android.livesdk.feed.feed.e r11 = r10.f;
            if (r11 == null) goto L14;
            String r12 = r11.i();
            if (r12 == null) goto L14;
        L15:
            Intrinsics.checkNotNullParameter(r12, "tabName");
            Map r1 = aw1.a.a();
            r1.put("tab_name", r12);
            u.l().sendLog("livesdk_drawer_tab_show", r1, new Object[0]);
        L14:
            r12 = "";
            goto L15
        }
    }

    static {
    }

    public SingleListDrawFragment() {
        this.d = "yellow_keva";
        this.g = new cw1.b();
        this.z = Keva.getRepo("draw_history", 0);
        this.A = new MultiTypeAdapter();
        this.E = new CompositeDisposable();
        this.G = new e(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        TabListModel r0 = this.f;
        if (r0 == null) goto L5;
        r0.onDialogClose();
    L5:
        SingleDrawViewModel r1 = this.h;
        if (r1 == null) goto L8;
        r1.clear(this);
    L8:
        CompositeDisposable r2 = this.E;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        CompositeDisposable r3 = this.E;
        if (r3 == null) goto L15;
        r3.dispose();
        return;
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
    }

    public static final void S90(SingleListDrawFragment r4) {
        r4.z.storeBoolean(r4.d, true);
        View r0 = r4.y;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r1 = r4.v;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        IRoomService r2 = jc1.k.n(IRoomService.class);
        FragmentActivity r5 = r4.getActivity();
        Bundle r3 = new Bundle();
        r3.putBoolean("LIVE_DRAW_DIALOG_OPEN_HISTORY", true);
        Unit r6 = Unit.INSTANCE;
        r2.openDrawer(r5, true, r3, null);
    }

    public static final void T90(SingleListDrawFragment r4) {
        r4.getClass();
        IRoomService r0 = jc1.k.n(IRoomService.class);
        FragmentActivity r5 = r4.getActivity();
        Bundle r1 = new Bundle();
        r1.putBoolean("LIVE_DRAW_DIALOG_OPEN_SEARCH", true);
        Unit r2 = Unit.INSTANCE;
        r0.openDrawer(r5, true, r1, null);
    }

    public static void W90(List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        View r0 = (View) r4.next();
        if (r0 == null) goto L4;
        int r2 = 8;
        if (r0.getVisibility() != 8) goto L10;
        r2 = 0;
    L10:
        r0.setVisibility(r2);
        goto L4
    }

    public final void V90(long r9) {
        MultiTypeAdapter r0 = this.A;
        Items r1 = new Items();
        TabListModel r2 = this.f;
        if (r2 == null) goto L16;
        List<com.bytedance.android.livesdk.feed.feed.e> r3 = r2.getTabList();
        if (r3 == null) goto L16;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r6).f() == r9) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
        r4.add(r6);
        goto L8
    L12:
        r7 = false;
        goto L13
    L15:
        r1.addAll(r4);
    L16:
        Unit r10 = Unit.INSTANCE;
        r0.a = r1;
        this.A.notifyDataSetChanged();
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L5;
        this.h = ViewModelProviders.of(r4).get(SingleDrawViewModel.class);
        this.f = (TabListModel) ViewModelProviders.of(r4).get(TabListModel.class);
    L5:
        SingleDrawViewModel r5 = this.h;
        if (r5 == null) goto L10;
        NextLiveData r6 = r5.getItemsUpdate();
        if (r6 == null) goto L10;
        r6.observe(this, new aw1.b(this));
    L10:
        SingleDrawViewModel r7 = this.h;
        if (r7 == null) goto L16;
        NextLiveData r8 = r7.getShowLoading();
        if (r8 == null) goto L17;
        r8.observe(this, new aw1.c(this));
        return;
    L17:
        return;
    }

    public final void U90(long r11, boolean r13) {
        TabListModel r0 = this.f;
        String r3 = null;
        if (r0 == null) goto L19;
        ArrayList<bw1.e> r4 = r0.getTabItemModelList();
        if (r4 == null) goto L17;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        if (((bw1.e) r6).g() != r11) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
    L16:
        bw1.e r8 = (bw1.e) r6;
    L18:
        r0.setCurrentTabModel(r8);
        goto L19
    L12:
        r7 = false;
        goto L13
    L15:
        r6 = null;
        goto L16
    L17:
        r8 = null;
    L19:
        SingleDrawFeedAdapter r1 = this.B;
        if (r1 == null) goto L25;
        LinkedList<FeedItem> r2 = r1.a;
        if (r2 == null) goto L25;
        r2.clear();
    L25:
        if (r13 == false) goto L79;
        int r14 = aw1.a.a;
        TabListModel r15 = this.f;
        String r9 = "";
        if (r15 == null) goto L34;
        bw1.e r16 = r15.getCurrentTabModel();
        if (r16 == null) goto L34;
        com.bytedance.android.livesdk.feed.feed.e r17 = r16.f;
        if (r17 == null) goto L34;
        String r18 = r17.i();
        if (r18 == null) goto L34;
    L35:
        TabListModel r10 = this.f;
        if (r10 == null) goto L55;
        List<com.bytedance.android.livesdk.feed.feed.e> r12 = r10.getTabList();
        if (r12 == null) goto L55;
        Iterator<T> r19 = r12.iterator();
    L41:
        if (r19.hasNext() == false) goto L48;
        Object r20 = r19.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r20).f() != r11) goto L45;
        boolean r21 = true;
    L46:
        if (r21 == false) goto L41;
    L49:
        com.bytedance.android.livesdk.feed.feed.e r22 = (com.bytedance.android.livesdk.feed.feed.e) r20;
        if (r22 == null) goto L55;
        String r23 = r22.i();
        if (r23 == null) goto L55;
        r9 = r23;
        goto L55
    L45:
        r21 = false;
        goto L46
    L48:
        r20 = null;
    L55:
        aw1.a.b(r18, r9);
        W90(CollectionsKt.mutableListOf(new View[]{this.p, this.i, this.n, this.o}));
        TextView r110 = this.m;
        if (r110 == null) goto L75;
        TabListModel r24 = this.f;
        if (r24 == null) goto L74;
        List<com.bytedance.android.livesdk.feed.feed.e> r25 = r24.getTabList();
        if (r25 == null) goto L74;
        Iterator<T> r26 = r25.iterator();
    L63:
        if (r26.hasNext() == false) goto L70;
        Object r27 = r26.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r27).f() != r11) goto L67;
        boolean r28 = true;
    L68:
        if (r28 == false) goto L63;
    L71:
        com.bytedance.android.livesdk.feed.feed.e r29 = (com.bytedance.android.livesdk.feed.feed.e) r27;
        if (r29 == null) goto L74;
        r3 = r29.i();
        goto L74
    L67:
        r28 = false;
        goto L68
    L70:
        r27 = null;
    L74:
        r110.setText(r3);
    L75:
        V90(r11);
        ViewGroup r111 = this.C;
        if (r111 == null) goto L79;
        r111.setVisibility(8);
    L34:
        r18 = "";
    L79:
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L100;
        TabListModel r112 = this.f;
        if (r112 == null) goto L100;
        bw1.e r113 = r112.getCurrentTabModel();
        if (r113 == null) goto L100;
        com.bytedance.android.livesdk.feed.feed.e r114 = r113.f;
        if (r114 == null) goto L100;
        if (r114.getType() != 2) goto L100;
        ViewGroup r115 = this.C;
        if (r115 == null) goto L91;
        r115.setVisibility(0);
    L91:
        Disposable r116 = this.F;
        if (r116 == null) goto L94;
        r116.dispose();
    L94:
        Disposable r117 = jc1.k.n(IUserService.class).user().m().filter(b.a).subscribe(new c(this, r11));
        this.F = r117;
        if (r117 == null) goto L97;
        this.E.add(r117);
    L97:
        TextView r118 = this.D;
        if (r118 == null) goto L110;
        r118.setOnClickListener(new d(this));
    L110:
        SingleDrawFeedAdapter r119 = this.B;
        if (r119 == null) goto L129;
        r119.notifyDataSetChanged();
        return;
    L129:
        return;
    L100:
        SingleDrawFeedAdapter r120 = this.B;
        if (r120 == null) goto L105;
        LinkedList<FeedItem> r121 = r120.a;
        if (r121 == null) goto L105;
        FeedItem r30 = new FeedItem();
        SingleDrawFeedAdapter.h.getClass();
        r30.type = SingleDrawFeedAdapter.g;
        Unit r31 = Unit.INSTANCE;
        r121.add(r30);
    L105:
        SingleDrawViewModel r122 = this.h;
        if (r122 == null) goto L110;
        NextLiveData r123 = r122.getChangeTab();
        if (r123 == null) goto L110;
        r123.setValue(Long.valueOf(r11));
        goto L110
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        Context r12 = getContext();
        if (r12 == null) goto L13;
        FadingEdgeRecyclerview r7 = this.r;
        if (r7 == null) goto L13;
        final CenterScrollLayoutManager r8 = new CenterScrollLayoutManager(r12);
        r8.setOrientation(1);
        this.B = new SingleDrawFeedAdapter(r7, r8, this.h, this, this.f);
        TabListModel r13 = this.f;
        if (r13 == null) goto L11;
        com.bytedance.android.livesdk.feed.feed.e r14 = r13.getDefaultTab();
        if (r14 == null) goto L11;
        long r1 = r14.f();
    L12:
        U90(r1, false);
        this.s = r8;
        r7.setLayoutManager(r8);
        r7.setAdapter(this.B);
        r7.addOnScrollListener(new SingleListDrawFragment$onViewCreated$$inlined$let$lambda$1(r8, this));
    L11:
        r1 = 0;
    L13:
        DoubleBallSwipeRefreshLayout r15 = this.j;
        if (r15 == null) goto L17;
        r15.setOnRefreshListener(new f(this));
    L17:
        if (this.z.getBoolean(this.d, false) == false) goto L24;
        View r16 = this.v;
        if (r16 == null) goto L21;
        r16.setVisibility(8);
    L21:
        View r17 = this.y;
        if (r17 == null) goto L24;
        r17.setVisibility(8);
    L24:
        TabListModel r18 = this.f;
        if (r18 != null) goto L27;
    L61:
        View r19 = this.k;
        if (r19 == null) goto L64;
        r19.setVisibility(8);
    L64:
        View r110 = this.l;
        if (r110 == null) goto L67;
        r110.setVisibility(0);
    L67:
        ViewGroup r111 = this.p;
        if (r111 == null) goto L70;
        r111.setVisibility(8);
    L70:
        View r112 = this.t;
        if (r112 == null) goto L73;
        r112.setOnClickListener(new g(this));
    L73:
        View r113 = this.u;
        if (r113 == null) goto L76;
        r113.setOnClickListener(new h(this));
    L76:
        View r114 = this.w;
        if (r114 == null) goto L79;
        r114.setOnClickListener(new i(this));
    L79:
        View r115 = this.x;
        if (r115 == null) goto L82;
        r115.setOnClickListener(new j(this));
    L82:
        View r116 = this.k;
        if (r116 == null) goto L86;
        r116.setOnClickListener(new k(this));
        return;
    L86:
        return;
    L27:
        if (r18.isMultiTab() != true) goto L61;
        View r117 = this.e;
        String r2 = null;
        if (r117 == null) goto L31;
        FadingEdgeRecyclerview r118 = (FadingEdgeRecyclerview) r117.findViewById(2131386640);
    L32:
        this.q = r118;
        View r119 = this.k;
        if (r119 == null) goto L35;
        r119.setVisibility(0);
    L35:
        View r120 = this.l;
        if (r120 == null) goto L38;
        r120.setVisibility(8);
    L38:
        TextView r121 = this.m;
        if (r121 == null) goto L46;
        TabListModel r3 = this.f;
        if (r3 == null) goto L45;
        com.bytedance.android.livesdk.feed.feed.e r4 = r3.getDefaultTab();
        if (r4 == null) goto L45;
        r2 = r4.i();
    L45:
        r121.setText(r2);
    L46:
        View r122 = this.n;
        if (r122 == null) goto L49;
        r122.setVisibility(8);
    L49:
        View r123 = this.o;
        if (r123 == null) goto L52;
        r123.setVisibility(0);
    L52:
        FadingEdgeRecyclerview r124 = this.q;
        if (r124 == null) goto L67;
        r124.setLayoutManager(new LinearLayoutManager(r124.getContext(), 1, false));
        this.A.z2(com.bytedance.android.livesdk.feed.feed.e.class, new dw1.c(this.h));
        TabListModel r0 = this.f;
        if (r0 == null) goto L59;
        com.bytedance.android.livesdk.feed.feed.e r5 = r0.getDefaultTab();
        if (r5 == null) goto L59;
        long r6 = r5.f();
    L60:
        V90(r6);
        r124.setAdapter(this.A);
        r124.c = true;
        r124.b = true;
    L59:
        r6 = -1;
        goto L60
    L31:
        r118 = null;
        goto L32
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        View r15 = r12.inflate(2131566001, r13, false);
        this.e = r15;
        Object r16 = null;
        if (r15 == null) goto L5;
        FadingEdgeRecyclerview r17 = (FadingEdgeRecyclerview) r15.findViewById(2131386639);
    L6:
        this.r = r17;
        View r18 = this.e;
        if (r18 == null) goto L9;
        ViewGroup r19 = (ViewGroup) r18.findViewById(2131386641);
    L10:
        this.p = r19;
        View r110 = this.e;
        if (r110 == null) goto L13;
        ViewGroup r111 = (ViewGroup) r110.findViewById(2131386620);
    L14:
        this.C = r111;
        View r112 = this.e;
        if (r112 == null) goto L17;
        TextView r113 = (TextView) r112.findViewById(2131386619);
    L18:
        this.D = r113;
        View r114 = this.e;
        if (r114 == null) goto L21;
        ViewGroup r115 = (ViewGroup) r114.findViewById(2131386637);
    L22:
        this.i = r115;
        View r116 = this.e;
        if (r116 == null) goto L25;
        DoubleBallSwipeRefreshLayout r117 = (DoubleBallSwipeRefreshLayout) r116.findViewById(2131386638);
    L26:
        this.j = r117;
        View r118 = this.e;
        if (r118 == null) goto L29;
        View r119 = r118.findViewById(2131386647);
    L30:
        this.k = r119;
        View r120 = this.e;
        if (r120 == null) goto L33;
        TextView r121 = (TextView) r120.findViewById(2131386644);
    L34:
        this.m = r121;
        View r122 = this.e;
        if (r122 == null) goto L37;
        View r123 = r122.findViewById(2131386649);
    L38:
        this.l = r123;
        View r124 = this.e;
        if (r124 == null) goto L41;
        View r125 = r124.findViewById(2131386646);
    L42:
        this.n = r125;
        View r126 = this.e;
        if (r126 == null) goto L45;
        View r127 = r126.findViewById(2131386645);
    L46:
        this.o = r127;
        View r128 = this.e;
        if (r128 == null) goto L49;
        View r129 = r128.findViewById(2131386642);
    L50:
        this.t = r129;
        View r130 = this.e;
        if (r130 == null) goto L53;
        View r131 = r130.findViewById(2131386624);
    L54:
        this.u = r131;
        View r132 = this.e;
        if (r132 == null) goto L57;
        View r133 = r132.findViewById(2131386652);
    L58:
        this.v = r133;
        View r134 = this.e;
        if (r134 == null) goto L61;
        View r135 = r134.findViewById(2131386643);
    L62:
        this.w = r135;
        View r136 = this.e;
        if (r136 == null) goto L65;
        View r137 = r136.findViewById(2131386625);
    L66:
        this.x = r137;
        View r138 = this.e;
        if (r138 == null) goto L69;
        View r139 = r138.findViewById(2131386653);
    L70:
        this.y = r139;
        TabListModel r140 = this.f;
        if (r140 == null) goto L89;
        r140.init(this.h);
        cw1.b r141 = this.g;
        if (r141 == null) goto L89;
        SingleDrawViewModel r1 = this.h;
        Intrinsics.checkNotNullParameter(r140, "listModel");
        Intrinsics.checkNotNullParameter(this, "owner");
        r141.a = r1;
        r141.b = r140;
        r141.c = this;
        if (r1 == null) goto L79;
        NextLiveData r142 = r1.getTabRefresh();
        if (r142 == null) goto L79;
        r142.observe(this, new bw1.a(r141));
    L79:
        SingleDrawViewModel r143 = r141.a;
        if (r143 == null) goto L84;
        NextLiveData r144 = r143.getChangeTab();
        if (r144 == null) goto L84;
        r144.observe(this, new bw1.b(r141));
    L84:
        SingleDrawViewModel r145 = r141.a;
        if (r145 == null) goto L89;
        NextLiveData r146 = r145.getLoadMore();
        if (r146 == null) goto L89;
        r146.observe(this, new bw1.c(r141));
    L89:
        o r147 = u.l().c(x.class);
        String r2 = "";
        if (r147.getMap().containsKey("enter_from_merge") == false) goto L92;
        String r148 = (String) r147.getMap().get("enter_from_merge");
    L93:
        if (r148 != null) goto L96;
        r148 = "";
    L96:
        if (r147.getMap().containsKey("enter_method") == false) goto L98;
        String r149 = (String) r147.getMap().get("enter_method");
    L99:
        if (r149 == null) goto L102;
        r2 = r149;
    L102:
        TabListModel r150 = this.f;
        int r3 = 1;
        if (r150 == null) goto L134;
        List<com.bytedance.android.livesdk.feed.feed.e> r151 = r150.getTabList();
        if (r151 == null) goto L134;
        ArrayList r4 = new ArrayList();
        Iterator<T> r152 = r151.iterator();
    L108:
        if (r152.hasNext() == false) goto L135;
        Object r5 = r152.next();
        com.bytedance.android.livesdk.feed.feed.e r6 = (com.bytedance.android.livesdk.feed.feed.e) r5;
        List<String> r7 = r6.b();
        if (r7 != null) goto L112;
    L115:
        boolean r8 = true;
    L116:
        if (r8 == false) goto L118;
    L119:
        List<String> r9 = r6.d();
        if (r9 != null) goto L122;
    L125:
        boolean r10 = true;
    L126:
        if (r10 == false) goto L128;
    L131:
        boolean r11 = true;
    L132:
        if (r11 == false) goto L108;
        r4.add(r5);
        goto L108
    L128:
        if (LiveDrawerUrlHelper.isParamInList(r148, r2, r6.d()) == true) goto L131;
    L130:
        r11 = false;
        goto L132
    L122:
        if (r9.isEmpty() == true) goto L125;
        r10 = false;
        goto L126
    L118:
        if (LiveDrawerUrlHelper.isParamInList(r148, r2, r6.b()) == true) goto L130;
    L112:
        if (r7.isEmpty() == true) goto L115;
        r8 = false;
    L135:
        Bundle r153 = getArguments();
        if (r153 == null) goto L147;
        boolean r20 = r153.getBoolean("switch_follow", false);
        long r21 = r153.getLong("default_tab_type", -1);
        TabListModel r22 = this.f;
        if (r22 == null) goto L140;
        r22.setTagId(r153.getLong("tag_id", -1));
    L140:
        TabListModel r154 = this.f;
        if (r154 == null) goto L149;
        Bundle r23 = getArguments();
        if (r23 == null) goto L145;
        long r24 = r23.getLong("tab_type");
    L146:
        r154.setTabType(r24);
        goto L149
    L145:
        r24 = -1;
    L149:
        if (bx1.a.b(r148) == true) goto L191;
        if (r20 == true) goto L191;
        if (bx1.a.a(r148) == true) goto L155;
    L170:
        List<String> r155 = bx1.a.a;
        if (TextUtils.isEmpty(r148) == false) goto L173;
    L175:
        boolean r156 = false;
    L176:
        if (r156 == true) goto L178;
    L192:
        if (r4 == null) goto L201;
        Iterator r157 = r4.iterator();
    L195:
        if (r157.hasNext() == false) goto L201;
        com.bytedance.android.livesdk.feed.feed.e r158 = (com.bytedance.android.livesdk.feed.feed.e) r157.next();
        if (r158.getType() != r3) goto L195;
        TabListModel r159 = this.f;
        if (r159 == null) goto L195;
        r159.setDefaultTab(r158);
    L201:
        if (r4 == null) goto L215;
        Iterator r160 = r4.iterator();
    L204:
        if (r160.hasNext() == false) goto L215;
        com.bytedance.android.livesdk.feed.feed.e r161 = (com.bytedance.android.livesdk.feed.feed.e) r160.next();
        long r0 = r161.f();
        TabListModel r162 = this.f;
        if (r162 == null) goto L204;
        bw1.e r163 = r162.getCurrentTabModel();
        if (r163 == null) goto L204;
        if (r0 != r163.g()) goto L204;
        TabListModel r164 = this.f;
        if (r164 == null) goto L204;
        r164.setDefaultTab(r161);
    L215:
        if (r21 == (-1)) goto L226;
        if (r4 == null) goto L226;
        Iterator r165 = r4.iterator();
    L219:
        if (r165.hasNext() == false) goto L226;
        com.bytedance.android.livesdk.feed.feed.e r166 = (com.bytedance.android.livesdk.feed.feed.e) r165.next();
        if (r166.getType() != ((int) r21)) goto L219;
        TabListModel r167 = this.f;
        if (r167 == null) goto L219;
        r167.setDefaultTab(r166);
    L226:
        return this.e;
    L178:
        if (r4 == null) goto L189;
        Iterator r168 = r4.iterator();
    L181:
        if (r168.hasNext() == false) goto L188;
        Object r25 = r168.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r25).getType() != 4) goto L185;
        boolean r26 = true;
    L186:
        if (r26 == false) goto L181;
        r16 = r25;
        goto L188
    L185:
        r26 = false;
    L188:
        r16 = (com.bytedance.android.livesdk.feed.feed.e) r16;
    L189:
        if (r16 == null) goto L192;
        r3 = 4;
        goto L192
    L173:
        if (CollectionsKt.contains(bx1.a.c, r148) == false) goto L175;
        r156 = true;
        goto L176
    L155:
        if (r4 == null) goto L167;
        Iterator r27 = r4.iterator();
    L158:
        if (r27.hasNext() == false) goto L165;
        Object r28 = r27.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r28).getType() != 3) goto L162;
        boolean r29 = true;
    L163:
        if (r29 == false) goto L158;
    L166:
        com.bytedance.android.livesdk.feed.feed.e r30 = (com.bytedance.android.livesdk.feed.feed.e) r28;
    L168:
        if (r30 == null) goto L170;
        r3 = 3;
        goto L192
    L162:
        r29 = false;
        goto L163
    L165:
        r28 = null;
        goto L166
    L167:
        r30 = null;
    L191:
        r3 = 2;
        goto L192
    L147:
        r21 = -1;
        r20 = false;
    L134:
        r4 = null;
        goto L135
    L98:
        r149 = "";
        goto L99
    L92:
        r148 = "";
        goto L93
    L69:
        r139 = null;
        goto L70
    L65:
        r137 = null;
        goto L66
    L61:
        r135 = null;
        goto L62
    L57:
        r133 = null;
        goto L58
    L53:
        r131 = null;
        goto L54
    L49:
        r129 = null;
        goto L50
    L45:
        r127 = null;
        goto L46
    L41:
        r125 = null;
        goto L42
    L37:
        r123 = null;
        goto L38
    L33:
        r121 = null;
        goto L34
    L29:
        r119 = null;
        goto L30
    L25:
        r117 = null;
        goto L26
    L21:
        r115 = null;
        goto L22
    L17:
        r113 = null;
        goto L18
    L13:
        r111 = null;
        goto L14
    L9:
        r19 = null;
        goto L10
    L5:
        r17 = null;
        goto L6
    }
}
