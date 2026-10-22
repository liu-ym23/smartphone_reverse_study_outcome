package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabPageAdapter;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureChooseListFragment;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/AbsLiveOpenFeatureChooseFragment;", "<init>", "()V", "a", "b", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseListFragment extends AbsLiveOpenFeatureChooseFragment {
    public static final /* synthetic */ int p = 0;
    public Map<Integer, View> d;
    public int e;
    public OpenFeatureTabPageAdapter f;
    public ViewPager g;
    public LivePagerSlidingTabStrip h;
    public MultiTypeAdapter i;
    public RecyclerView j;
    public boolean k;
    public final b l;
    public final HashMap<Integer, b> m;
    public int n;
    public AbsOpenFeaturePanelViewModel o;

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

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.LiveOpenFeatureChooseListFragment$c$c, reason: collision with other inner class name */
        public static final class C0092c extends c {
            public static final C0092c a = null;

            static {
                a = new C0092c();
            }

            public C0092c() {
            }
        }

        public c() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.AbsLiveOpenFeatureChooseFragment
    public final void S90() {
        this.k = true;
    }

    public final void X90() {
        MultiTypeAdapter r0 = this.i;
        if (r0 == null) goto L5;
        r0.a = new ArrayList();
    L5:
        MultiTypeAdapter r1 = this.i;
        if (r1 == null) goto L9;
        r1.notifyDataSetChanged();
        return;
    }

    public LiveOpenFeatureChooseListFragment() {
        this.d = new LinkedHashMap();
        SharedPrefHelper.b(s1.getContext());
        jc1.k.n(IHostContext.class).getServerDeviceId();
        jc1.k.n(IUserService.class).user().n();
        jc1.k.n(IHostContext.class).getServerDeviceId();
        this.k = true;
        this.l = new b(-1, -1);
        this.m = new HashMap();
        this.n = -1;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View T90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void Y90(boolean r5) {
        LinearLayout r0 = (LinearLayout) T90(2131379095);
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        LiveDoubleColorBallAnimationView r2 = T90(2131378998);
        if (r5 == true) goto L10;
        r1 = 8;
    L10:
        r2.setVisibility(r1);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.o = AbsOpenFeaturePanelViewModel.a.a(true, this);
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L6;
        r3.updateSwitchSceneSource("interaction_button");
        return;
    }

    public static final void V90(LiveOpenFeatureChooseListFragment r2, boolean r3) {
        if ((((LinearLayout) r2.T90(2131363116)).getParent() instanceof AppBarLayout) == false) goto L14;
        ViewGroup.LayoutParams r4 = ((LinearLayout) r2.T90(2131363116)).getLayoutParams();
        if ((r4 instanceof AppBarLayout.LayoutParams) == true) goto L7;
        r4 = null;
    L7:
        AppBarLayout.LayoutParams r5 = (AppBarLayout.LayoutParams) r4;
        if (r3 == false) goto L11;
        if (r5 == null) goto L15;
        r5.setScrollFlags(1);
        return;
    L15:
        return;
    L11:
        if (r5 == null) goto L17;
        r5.setScrollFlags(0);
        return;
    L17:
        return;
    }

    public final void ba0(View r3, int r4) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
        if (r1 == null) goto L8;
        r1.width = (int) UtilityKotlinExtentionsKt.h(180);
    L8:
        if (r4 == 0) goto L11;
        if (r1 == null) goto L11;
        r1.height = (int) UtilityKotlinExtentionsKt.h(r4);
    L11:
        if (r1 == null) goto L14;
        r3.setLayoutParams(r1);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        this.n = -1;
        this.k = true;
        ImageView r0 = (ImageView) T90(2131375130);
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.v(r0, false);
    L5:
        ImageView r2 = (ImageView) T90(2131385343);
        if (r2 == null) goto L8;
        UtilityKotlinExtentionsKt.v(r2, true);
    L8:
        ImageView r1 = (ImageView) T90(2131385343);
        if (r1 == null) goto L11;
        r1.setOnClickListener(new o(this));
    L11:
        TextView r3 = (TextView) T90(2131391753);
        if (r3 == null) goto L14;
        r3.setText(2131920959);
    L14:
        UtilityKotlinExtentionsKt.v(T90(2131385509), false);
        RecyclerView r4 = r11.findViewById(2131372184);
        this.j = r4;
        if (r4 == null) goto L17;
        r4.setOverScrollMode(2);
    L17:
        final SSGridLayoutManager r5 = new SSGridLayoutManager(getContext(), 5);
        RecyclerView r6 = this.j;
        if (r6 == null) goto L20;
        r6.setLayoutManager(r5);
    L20:
        r5.setSpanSizeLookup(new LiveOpenFeatureChooseListFragment$initGroupListView$1(this));
        MultiTypeAdapter r7 = new MultiTypeAdapter();
        this.i = r7;
        AbsOpenFeaturePanelViewModel r8 = this.o;
        a20.d r9 = null;
        if (r8 == null) goto L23;
        a20.d r13 = r8.getFeatureIconBehaviorController();
    L25:
        if ((r13 instanceof a20.e) == true) goto L27;
        r13 = null;
    L27:
        r7.z2(f10.f.class, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.a(r13));
        MultiTypeAdapter r14 = this.i;
        if (r14 == null) goto L37;
        AbsOpenFeaturePanelViewModel r15 = this.o;
        if (r15 == null) goto L32;
        a20.d r16 = r15.getFeatureIconBehaviorController();
    L34:
        if ((r16 instanceof a20.e) == true) goto L36;
        r16 = null;
    L36:
        r14.z2(f10.d.class, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.b(r16));
        goto L37
    L32:
        r16 = null;
    L37:
        MultiTypeAdapter r17 = this.i;
        if (r17 == null) goto L40;
        r17.z2(f10.b.class, new f10.c());
    L40:
        RecyclerView r18 = this.j;
        if (r18 == null) goto L43;
        r18.setAdapter(this.i);
    L43:
        RecyclerView r19 = this.j;
        if (r19 == null) goto L46;
        UtilityKotlinExtentionsKt.v(r19, true);
    L46:
        RecyclerView r21 = this.j;
        if (r21 == null) goto L49;
        r21.addOnScrollListener(new LiveOpenFeatureChooseListFragment$initRecyclerScrollListener$1(LiveOpenFeatureChooseListFragment$initGroupListView$2$1.INSTANCE, new LiveOpenFeatureChooseListFragment$initGroupListView$$inlined$let$lambda$1(this, r5)));
    L49:
        this.g = r11.findViewById(2131372190);
        LivePagerSlidingTabStrip r110 = r11.findViewById(2131372179);
        this.h = r110;
        if (r110 == null) goto L52;
        r110.setTextSelectedStyle(1);
    L52:
        LivePagerSlidingTabStrip r111 = this.h;
        if (r111 == null) goto L55;
        r111.A = null;
        r111.B = 0;
        r111.d();
    L55:
        List r112 = CollectionsKt.listOf(new b20.e[]{new b20.d(), new b20.b()});
        AbsOpenFeaturePanelViewModel r22 = this.o;
        if (r22 == null) goto L58;
        a20.d r23 = r22.getFeatureIconBehaviorController();
    L60:
        if ((r23 instanceof a20.e) == false) goto L63;
        r9 = r23;
    L63:
        OpenFeatureTabPageAdapter r113 = new OpenFeatureTabPageAdapter(r9, this.h, this.g, r112);
        this.f = r113;
        r113.e = new n(this);
        ViewPager r114 = this.g;
        if (r114 == null) goto L66;
        r114.setAdapter(r113);
    L66:
        LivePagerSlidingTabStrip r115 = this.h;
        if (r115 == null) goto L69;
        r115.setOnPageChangeListener(new LiveOpenFeatureChooseListFragment$initOnTabPageListener$1(this));
    L69:
        OpenFeatureTabPageAdapter r116 = this.f;
        if (r116 == null) goto L72;
        Function3<RecyclerView, LinearLayoutManager, Integer, Unit> r117 = new LiveOpenFeatureChooseListFragment$initTabListView$2(this);
        Intrinsics.checkNotNullParameter(r117, "cb");
        r116.d = r117;
    L72:
        T90(2131363115).addOnOffsetChangedListener(new f(this));
        AbsOpenFeaturePanelViewModel r118 = this.o;
        if (r118 == null) goto L77;
        LiveData<Boolean> r119 = r118.getNoOpenFeatureGroupListData();
        if (r119 == null) goto L77;
        r119.observe(this, new g(this));
    L77:
        AbsOpenFeaturePanelViewModel r120 = this.o;
        if (r120 == null) goto L82;
        LiveData<Boolean> r121 = r120.getNoOpenFeatureTabListData();
        if (r121 == null) goto L82;
        r121.observe(this, new h(this));
    L82:
        AbsOpenFeaturePanelViewModel r122 = this.o;
        if (r122 == null) goto L87;
        LiveData<List<Object>> r123 = r122.getOpenFeatureGroupListData();
        if (r123 == null) goto L87;
        r123.observe(this, new i(this));
    L87:
        AbsOpenFeaturePanelViewModel r124 = this.o;
        if (r124 == null) goto L92;
        LiveData<Boolean> r125 = r124.getOpenFeatureListLoadingState();
        if (r125 == null) goto L92;
        r125.observe(this, new j(this));
    L92:
        AbsOpenFeaturePanelViewModel r126 = this.o;
        if (r126 == null) goto L97;
        LiveData<c20.c> r127 = r126.getOpenFeatureTabListData();
        if (r127 == null) goto L97;
        r127.observe(this, new k(this));
    L97:
        AbsOpenFeaturePanelViewModel r128 = this.o;
        if (r128 == null) goto L102;
        LiveData<Boolean> r129 = r128.getNoOpenFeatureListData();
        if (r129 == null) goto L102;
        r129.observe(this, new l(this));
    L102:
        AbsOpenFeaturePanelViewModel r130 = this.o;
        if (r130 == null) goto L107;
        LiveData<Boolean> r131 = r130.getRequestOpenFeatureListDataError();
        if (r131 == null) goto L107;
        r131.observe(this, new m(this));
    L107:
        AbsOpenFeaturePanelViewModel r132 = this.o;
        if (r132 == null) goto L113;
        a20.i r133 = r132.getFeatureListHandler();
        if (r133 == null) goto L114;
        r133.d();
        return;
    L114:
        return;
    L113:
        return;
    L58:
        r23 = null;
        goto L60
    L23:
        r13 = null;
        goto L25
    }

    public static final void U90(final LiveOpenFeatureChooseListFragment r3, final LinearLayoutManager r4, final int r5) {
        if (r3.m.size() != 0) goto L5;
        return;
    L5:
        if (r5 >= r3.m.size()) goto L18;
        if (r5 < 0) goto L21;
        final b r0 = r3.m.get(Integer.valueOf(r5));
        if (r0 == null) goto L19;
        ViewPager r1 = r3.g;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.getCurrentItem() != r5) goto L22;
        W90(r4, r0, new LiveOpenFeatureChooseListFragment$processTabListVisibleScroll$$inlined$let$lambda$1(r0, r3, r5, r4), new LiveOpenFeatureChooseListFragment$processTabListVisibleScroll$$inlined$let$lambda$2(r3, r5, r4));
        r3.n = r5;
        return;
    L22:
        return;
    L19:
        return;
    L21:
        return;
    }

    public static b Z90(int r2, int r3, LinearLayoutManager r4) {
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

    public final void aa0(View r3, int r4, int r5) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
        if ((r3.getLayoutParams() instanceof LinearLayout.LayoutParams) == true) goto L8;
        com.bytedance.android.live.broadcastgame.opengame.utils.i.c("OpenFeatureChooseListFragment中当前view不在LinearLayout中，会引起布局UI不对");
    L8:
        if (r1 == null) goto L10;
        r1.topMargin = (int) UtilityKotlinExtentionsKt.h(r4);
    L10:
        if (r5 <= 0) goto L13;
        if (r1 == null) goto L13;
        r1.bottomMargin = (int) UtilityKotlinExtentionsKt.h(r5);
    L13:
        if (r1 == null) goto L16;
        r3.setLayoutParams(r1);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567072, r3, false);
    }

    public static void W90(LinearLayoutManager r9, b r11, Function1 r12, Function2 r13) {
        b r0 = Z90(r9.findFirstVisibleItemPosition(), r9.findLastVisibleItemPosition(), r9);
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
        b r15 = Z90(r14, r2, r9);
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
        Object r8 = c.C0092c.a;
    L18:
        if (Intrinsics.areEqual(r8, c.a.a) == false) goto L21;
        int r16 = r0.a;
        r2 = Math.min(r0.b, r11.a - 1);
        r14 = r16;
        goto L26
    L21:
        if (Intrinsics.areEqual(r8, c.C0092c.a) == false) goto L24;
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
