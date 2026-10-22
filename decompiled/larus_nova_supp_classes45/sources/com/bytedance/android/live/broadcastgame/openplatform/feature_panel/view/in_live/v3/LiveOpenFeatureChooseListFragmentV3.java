package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.api.model.n0;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureTabPageAdapterV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.AbsLiveOpenFeatureChooseFragment;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.TabSelectorView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureChooseListFragmentV3;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/AbsLiveOpenFeatureChooseFragment;", "<init>", "()V", "a", "b", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseListFragmentV3 extends AbsLiveOpenFeatureChooseFragment {
    public static final /* synthetic */ int F = 0;
    public TextView A;
    public final b B;
    public final HashMap<Integer, b> C;
    public int D;
    public AbsOpenFeaturePanelViewModel E;
    public int d;
    public OpenFeatureTabPageAdapterV3 e;
    public ViewPager f;
    public View g;
    public LivePagerSlidingTabStrip h;
    public TabSelectorView i;
    public MultiTypeAdapter j;
    public RecyclerView k;
    public boolean l;
    public AppBarLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public LivePagerSlidingTabStrip p;
    public RecyclerView q;
    public ViewPager r;
    public HSImageView s;
    public LiveDoubleColorBallAnimationView t;
    public LinearLayout u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public ImageView z;

    public static final class a {
    }

    public static final class b {
        public int a;
        public int b;

        public b() {
            this(-1, -1);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "ItemVisibleBound(leftBound=" + this.a + ", rightBound=" + this.b + ")";
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.LiveOpenFeatureChooseListFragmentV3$c$c, reason: collision with other inner class name */
        public static final class C0093c extends c {
            public static final C0093c a = null;

            static {
                a = new C0093c();
            }

            public C0093c() {
            }
        }

        public c() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.AbsLiveOpenFeatureChooseFragment
    public final void S90() {
        this.l = true;
    }

    public final void X90() {
        z30.b r0 = jc1.k.n(IInteractService.class).getCloudGroupLiveService();
        if (r0 == null) goto L5;
        CloudGroupLivePipelineStatus r1 = r0.b();
    L7:
        if (r1 == CloudGroupLivePipelineStatus.END) goto L12;
        ImageView r2 = this.z;
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r2);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void Z90() {
        MultiTypeAdapter r0 = this.j;
        if (r0 == null) goto L5;
        r0.a = new ArrayList();
    L5:
        MultiTypeAdapter r1 = this.j;
        if (r1 == null) goto L9;
        r1.notifyDataSetChanged();
        return;
    }

    public LiveOpenFeatureChooseListFragmentV3() {
        SharedPrefHelper.b(s1.getContext());
        jc1.k.n(IHostContext.class).getServerDeviceId();
        jc1.k.n(IUserService.class).user().n();
        jc1.k.n(IHostContext.class).getServerDeviceId();
        this.l = true;
        this.B = new b(-1, -1);
        this.C = new HashMap();
        this.D = -1;
    }

    public final void aa0(boolean r5) {
        LinearLayout r0 = this.u;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r5 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        LiveDoubleColorBallAnimationView r2 = this.t;
        if (r2 == null) goto L15;
        if (r5 == true) goto L13;
        r1 = 8;
    L13:
        r2.setVisibility(r1);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.E = AbsOpenFeaturePanelViewModel.a.a(true, this);
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L6;
        r3.updateSwitchSceneSource("interaction_button");
        return;
    }

    public static final void U90(LiveOpenFeatureChooseListFragmentV3 r0, boolean r1) {
        if (r1 == true) goto L14;
        OpenFeatureTabPageAdapterV3 r2 = r0.e;
        if (r2 == null) goto L16;
        ArrayList<c20.d> r3 = r2.b;
        if (r3 == null) goto L17;
        ViewPager r4 = r0.f;
        if (r4 == null) goto L10;
        int r5 = r4.getCurrentItem();
    L11:
        c20.d r6 = (c20.d) ListProtector.get(r3, r5);
        if (r6 == null) goto L18;
        int r7 = d20.a.a;
        d20.a.d(r6.b);
        return;
    L18:
        return;
    L10:
        r5 = 0;
        goto L11
    L17:
        return;
    L16:
        return;
    L14:
        r0.getClass();
    }

    public static final void W90(LiveOpenFeatureChooseListFragmentV3 r2, boolean r3) {
        LinearLayout r0 = r2.n;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewParent r4 = r0.getParent();
    L7:
        if ((r4 instanceof AppBarLayout) == false) goto L23;
        LinearLayout r5 = r2.n;
        if (r5 == null) goto L11;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L13:
        if ((r6 instanceof AppBarLayout.LayoutParams) == false) goto L16;
        r1 = r6;
    L16:
        AppBarLayout.LayoutParams r7 = (AppBarLayout.LayoutParams) r1;
        if (r3 == false) goto L20;
        if (r7 == null) goto L24;
        r7.setScrollFlags(1);
        return;
    L24:
        return;
    L20:
        if (r7 == null) goto L26;
        r7.setScrollFlags(0);
        return;
    L26:
        return;
    L11:
        r6 = null;
        goto L13
    L23:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void da0(View r4, int r5) {
        ViewGroup.LayoutParams r0 = null;
        if (r4 == null) goto L5;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
    L7:
        if ((r1 instanceof LinearLayout.LayoutParams) == false) goto L10;
        r0 = r1;
    L10:
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r0;
        if (r2 == null) goto L13;
        r2.width = (int) UtilityKotlinExtentionsKt.h(180);
    L13:
        if (r5 == 0) goto L16;
        if (r2 == null) goto L16;
        r2.height = (int) UtilityKotlinExtentionsKt.h(r5);
    L16:
        if (r2 == null) goto L19;
        r4.setLayoutParams(r2);
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        this.D = -1;
        this.l = true;
        this.m = r12.findViewById(2131363115);
        this.n = (LinearLayout) r12.findViewById(2131363116);
        this.o = (LinearLayout) r12.findViewById(2131371747);
        this.p = r12.findViewById(2131372179);
        this.q = r12.findViewById(2131372184);
        this.r = r12.findViewById(2131372190);
        this.s = (HSImageView) r12.findViewById(2131375171);
        this.t = r12.findViewById(2131378998);
        this.u = (LinearLayout) r12.findViewById(2131379095);
        this.v = (TextView) r12.findViewById(2131380673);
        this.w = (TextView) r12.findViewById(2131384465);
        this.x = (TextView) r12.findViewById(2131391752);
        this.y = (ImageView) r12.findViewById(2131375130);
        this.z = (ImageView) r12.findViewById(2131385343);
        this.A = (TextView) r12.findViewById(2131391753);
        ImageView r3 = this.y;
        if (r3 == null) goto L5;
        UtilityKotlinExtentionsKt.v(r3, false);
    L5:
        ImageView r4 = this.z;
        if (r4 == null) goto L8;
        UtilityKotlinExtentionsKt.v(r4, true);
    L8:
        ImageView r5 = this.z;
        if (r5 == null) goto L11;
        r5.setOnClickListener(new k(this));
    L11:
        TextView r6 = this.A;
        if (r6 == null) goto L14;
        r6.setText(2131920959);
    L14:
        RecyclerView r1 = r12.findViewById(2131372184);
        this.k = r1;
        if (r1 == null) goto L17;
        r1.setOverScrollMode(2);
    L17:
        final SSGridLayoutManager r2 = new SSGridLayoutManager(getContext(), 5);
        RecyclerView r7 = this.k;
        if (r7 == null) goto L20;
        r7.setLayoutManager(r2);
    L20:
        r2.setSpanSizeLookup(new LiveOpenFeatureChooseListFragmentV3$initGroupListView$1(this));
        MultiTypeAdapter r8 = new MultiTypeAdapter();
        this.j = r8;
        AbsOpenFeaturePanelViewModel r9 = this.E;
        a20.d r11 = null;
        if (r9 == null) goto L23;
        a20.d r14 = r9.getFeatureIconBehaviorController();
    L25:
        if ((r14 instanceof a20.e) == true) goto L27;
        r14 = null;
    L27:
        r8.z2(f10.f.class, new z10.a(r14));
        MultiTypeAdapter r15 = this.j;
        if (r15 == null) goto L37;
        AbsOpenFeaturePanelViewModel r16 = this.E;
        if (r16 == null) goto L32;
        a20.d r17 = r16.getFeatureIconBehaviorController();
    L34:
        if ((r17 instanceof a20.e) == true) goto L36;
        r17 = null;
    L36:
        r15.z2(f10.d.class, new z10.d(r17));
        goto L37
    L32:
        r17 = null;
    L37:
        MultiTypeAdapter r18 = this.j;
        if (r18 == null) goto L40;
        r18.z2(f10.b.class, new f10.c());
    L40:
        RecyclerView r19 = this.k;
        if (r19 == null) goto L43;
        r19.setAdapter(this.j);
    L43:
        RecyclerView r21 = this.k;
        if (r21 == null) goto L46;
        UtilityKotlinExtentionsKt.v(r21, true);
    L46:
        RecyclerView r22 = this.k;
        if (r22 == null) goto L49;
        r22.addItemDecoration(new LiveOpenFeatureChooseListFragmentV3$initGroupListView$$inlined$let$lambda$1(this));
        r22.addOnScrollListener(new LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1(LiveOpenFeatureChooseListFragmentV3$initGroupListView$2$2.INSTANCE, new LiveOpenFeatureChooseListFragmentV3$initGroupListView$$inlined$let$lambda$2(this, r2)));
    L49:
        this.g = r12.findViewById(2131372191);
        this.f = r12.findViewById(2131372190);
        this.h = r12.findViewById(2131372179);
        this.i = (TabSelectorView) r12.findViewById(2131388050);
        LivePagerSlidingTabStrip r110 = this.h;
        if (r110 == null) goto L52;
        r110.setTextSelectedStyle(1);
    L52:
        LivePagerSlidingTabStrip r111 = this.h;
        if (r111 == null) goto L55;
        r111.A = null;
        r111.B = 1;
        r111.d();
    L55:
        LivePagerSlidingTabStrip r112 = this.h;
        if (r112 == null) goto L58;
        r112.setTextSize(s1.f(15.0f));
    L58:
        List r113 = CollectionsKt.listOf(new b20.e[]{new b20.d(), new b20.b()});
        AbsOpenFeaturePanelViewModel r23 = this.E;
        if (r23 == null) goto L61;
        a20.d r24 = r23.getFeatureIconBehaviorController();
    L63:
        if ((r24 instanceof a20.e) == false) goto L66;
        r11 = r24;
    L66:
        OpenFeatureTabPageAdapterV3 r0 = new OpenFeatureTabPageAdapterV3(r11, this.h, this.f, r113);
        this.e = r0;
        ViewPager r114 = this.f;
        if (r114 == null) goto L69;
        r114.setAdapter(r0);
    L69:
        LivePagerSlidingTabStrip r115 = this.h;
        if (r115 == null) goto L72;
        r115.setTabClickListener(new j(this));
    L72:
        LivePagerSlidingTabStrip r116 = this.h;
        if (r116 == null) goto L75;
        r116.setOnPageChangeListener(new LiveOpenFeatureChooseListFragmentV3$initOnTabPageListener$2(this));
    L75:
        OpenFeatureTabPageAdapterV3 r117 = this.e;
        if (r117 == null) goto L78;
        Function3<RecyclerView, LinearLayoutManager, Integer, Unit> r25 = new LiveOpenFeatureChooseListFragmentV3$initTabListView$2(this);
        Intrinsics.checkNotNullParameter(r25, "cb");
        r117.d = r25;
    L78:
        AppBarLayout r118 = this.m;
        if (r118 == null) goto L81;
        r118.addOnOffsetChangedListener(new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.a(this));
    L81:
        AbsOpenFeaturePanelViewModel r119 = this.E;
        if (r119 == null) goto L86;
        LiveData<Boolean> r120 = r119.getNoOpenFeatureGroupListData();
        if (r120 == null) goto L86;
        r120.observe(this, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.c(this));
    L86:
        AbsOpenFeaturePanelViewModel r121 = this.E;
        if (r121 == null) goto L91;
        LiveData<Boolean> r122 = r121.getNoOpenFeatureTabListData();
        if (r122 == null) goto L91;
        r122.observe(this, new d(this));
    L91:
        AbsOpenFeaturePanelViewModel r123 = this.E;
        if (r123 == null) goto L96;
        LiveData<List<Object>> r124 = r123.getOpenFeatureGroupListData();
        if (r124 == null) goto L96;
        r124.observe(this, new e(this));
    L96:
        AbsOpenFeaturePanelViewModel r125 = this.E;
        if (r125 == null) goto L101;
        LiveData<Boolean> r126 = r125.getOpenFeatureListLoadingState();
        if (r126 == null) goto L101;
        r126.observe(this, new f(this));
    L101:
        AbsOpenFeaturePanelViewModel r127 = this.E;
        if (r127 == null) goto L106;
        LiveData<c20.c> r128 = r127.getOpenFeatureTabListData();
        if (r128 == null) goto L106;
        r128.observe(this, new g(this));
    L106:
        AbsOpenFeaturePanelViewModel r129 = this.E;
        if (r129 == null) goto L111;
        LiveData<Boolean> r130 = r129.getNoOpenFeatureListData();
        if (r130 == null) goto L111;
        r130.observe(this, new h(this));
    L111:
        AbsOpenFeaturePanelViewModel r131 = this.E;
        if (r131 == null) goto L116;
        LiveData<Boolean> r132 = r131.getRequestOpenFeatureListDataError();
        if (r132 == null) goto L116;
        r132.observe(this, new i(this));
    L116:
        AbsOpenFeaturePanelViewModel r133 = this.E;
        if (r133 == null) goto L121;
        a20.i r134 = r133.getFeatureListHandler();
        if (r134 == null) goto L121;
        r134.d();
    L121:
        Room r135 = jc1.k.n(IRoomService.class).getCurrentRoom();
        if (r135 != null) goto L124;
    L128:
        X90();
        return;
    L124:
        if (r135.isVirtualLive != true) goto L128;
        ImageView r136 = this.z;
        if (r136 == null) goto L128;
        UtilityKotlinExtentionsKt.t(r136);
        goto L128
    L61:
        r24 = null;
        goto L63
    L23:
        r14 = null;
        goto L25
    }

    public static final void T90(LiveOpenFeatureChooseListFragmentV3 r3, c20.d r4, int r5) {
        r3.getClass();
        n0 r0 = r4.c;
        if (r0 == null) goto L13;
        TabSelectorView r1 = r3.i;
        if (r1 == null) goto L7;
        r1.b(r0, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.b(r3, r5, r4));
    L7:
        TabSelectorView r6 = r3.i;
        if (r6 == null) goto L10;
        UtilityKotlinExtentionsKt.v(r6, true);
    L10:
        OpenFeatureTabPageAdapterV3 r7 = r3.e;
        if (r7 == null) goto L20;
        r7.f(r5);
        Unit r8 = Unit.INSTANCE;
        return;
    L20:
        return;
    L13:
        TabSelectorView r9 = r3.i;
        if (r9 == null) goto L16;
        r9.b(null, null);
    L16:
        TabSelectorView r11 = r3.i;
        if (r11 == null) goto L22;
        UtilityKotlinExtentionsKt.v(r11, false);
        Unit r12 = Unit.INSTANCE;
        return;
    }

    public static final void V90(final LiveOpenFeatureChooseListFragmentV3 r3, final LinearLayoutManager r4, final int r5) {
        if (r3.C.size() != 0) goto L5;
        return;
    L5:
        if (r5 >= r3.C.size()) goto L18;
        if (r5 < 0) goto L21;
        final b r0 = r3.C.get(Integer.valueOf(r5));
        if (r0 == null) goto L19;
        ViewPager r1 = r3.f;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.getCurrentItem() != r5) goto L22;
        Y90(r4, r0, new LiveOpenFeatureChooseListFragmentV3$processTabListVisibleScroll$$inlined$let$lambda$1(r0, r3, r5, r4), new LiveOpenFeatureChooseListFragmentV3$processTabListVisibleScroll$$inlined$let$lambda$2(r3, r5, r4));
        r3.D = r5;
        return;
    L22:
        return;
    L19:
        return;
    L21:
        return;
    }

    public static b ba0(int r2, int r3, LinearLayoutManager r4) {
    L2:
        if (r2 >= r3) goto L7;
        int r0 = f10.g.a;
        if (f10.g.a(r4.findViewByPosition(r2), r4.getOrientation()) == true) goto L7;
        r2 = r2 + 1;
    L7:
        if (r3 <= r2) goto L13;
        int r1 = f10.g.a;
        if (f10.g.a(r4.findViewByPosition(r3), r4.getOrientation()) == true) goto L13;
        r3 = r3 - 1;
    L13:
        return new b(r2, r3);
    }

    public final void ca0(View r4, int r5, int r6) {
        ViewGroup.LayoutParams r0 = null;
        if (r4 == null) goto L5;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
    L7:
        if ((r1 instanceof LinearLayout.LayoutParams) == true) goto L9;
        r1 = null;
    L9:
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
        if (r4 == null) goto L13;
        r0 = r4.getLayoutParams();
    L13:
        if ((r0 instanceof LinearLayout.LayoutParams) == true) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.utils.i.c("OpenFeatureChooseListFragment中当前view不在LinearLayout中，会引起布局UI不对");
    L15:
        if (r2 == null) goto L17;
        r2.topMargin = (int) UtilityKotlinExtentionsKt.h(r5);
    L17:
        if (r6 <= 0) goto L20;
        if (r2 == null) goto L20;
        r2.bottomMargin = (int) UtilityKotlinExtentionsKt.h(r6);
    L20:
        if (r2 == null) goto L23;
        r4.setLayoutParams(r2);
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567073, r3, false);
    }

    public static void Y90(LinearLayoutManager r9, b r11, Function1 r12, Function2 r13) {
        b r0 = ba0(r9.findFirstVisibleItemPosition(), r9.findLastVisibleItemPosition(), r9);
        int r1 = r11.a;
        if (r1 == (-1)) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        int r14 = r0.a;
        int r2 = r0.b;
    L26:
        if (r14 < 0) goto L30;
        if (r2 < 0) goto L30;
        if (r14 > r2) goto L30;
        b r15 = ba0(r14, r2, r9);
        r13.invoke(Integer.valueOf(r15.a), Integer.valueOf(r15.b));
    L30:
        r12.invoke(r0);
        return;
    L10:
        int r4 = r0.a;
        int r5 = r0.b;
        int r6 = (r4 + r5) / 2;
        int r7 = r11.b;
        if (r6 <= ((r1 + r7) / 2)) goto L14;
        Object r8 = c.C0093c.a;
    L18:
        if (Intrinsics.areEqual(r8, c.a.a) == false) goto L21;
        int r16 = r0.a;
        r2 = Math.min(r0.b, r11.a - 1);
        r14 = r16;
        goto L26
    L21:
        if (Intrinsics.areEqual(r8, c.C0093c.a) == false) goto L24;
        r14 = Math.max(r11.b + 1, r0.a);
        r2 = r0.b;
        goto L26
    L24:
        if (Intrinsics.areEqual(r8, c.b.a) == false) goto L33;
        r14 = r0.a;
        r2 = r0.b;
        goto L26
    L33:
        throw new NoWhenBranchMatchedException();
    L14:
        if (((r4 + r5) / 2) >= ((r1 + r7) / 2)) goto L16;
        r8 = c.a.a;
        goto L18
    L16:
        r8 = c.b.a;
        goto L18
    L5:
        if (r11.b != (-1)) goto L7;
        r3 = true;
        goto L8
    }
}
