package com.larus.community.impl.template;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.databinding.LarusCommunityTemplateCreationFragmentLayoutBinding;
import com.larus.community.impl.widget.CreationLoadingAndRetryView;
import com.larus.platform.api.creation.DisplayExtra;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import zp9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010 J\u0012\u00100\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00109\u001a\u00020.2\u0006\u0010:\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0014\u0010;\u001a\u0004\u0018\u00010\u000b2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020.H\u0002J\u0016\u0010?\u001a\u00020.2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020&0)H\u0002J\f\u0010A\u001a\u00020.*\u00020BH\u0002J\u0018\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u000fH\u0002J\u0016\u0010F\u001a\u00020.2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020&0)H\u0002J\b\u0010G\u001a\u00020.H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020&0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+¨\u0006I"}, d2 = {"Lcom/larus/community/impl/template/TemplateCreationFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "sharedPool$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityTemplateCreationFragmentLayoutBinding;", "tabListView", "Lcom/larus/platform/api/creation/ITabListLayout;", "lastSelectedIndex", "", "pageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "viewModel", "Lcom/larus/community/impl/template/TemplateCreateViewModel;", "getViewModel", "()Lcom/larus/community/impl/template/TemplateCreateViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "adapter", "Lcom/larus/community/impl/template/TemplateCreationAdapter;", "isMultiTab", "", "multiTabTitleName", "", "defaultLandingTabId", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "isClickedTab", "botId", "currentPageName", "templatePageType", "lastTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "communityRecommendType", "mTabList", "", "isShowAvatar", "()Z", "isShowAvatar$delegate", "setCreationDoSameInterceptor", "", "interceptor", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "hostUiPolicy", "Lcom/larus/community/api/spi/CommunityHostUiPolicy;", "handleProfileOverview", "handleTabList", "tabList", "debounceSlip", "Landroidx/viewpager2/widget/ViewPager2;", "reportEnterAIGenerateTab", "enterMethod", "position", "setupTabListView", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreationFragment extends Fragment {
    public static final /* synthetic */ int w = 0;
    public final Lazy d;
    public LarusCommunityTemplateCreationFragmentLayoutBinding e;
    public zp9.u f;
    public int g;
    public TemplateCreationFragment$initView$1$1 h;
    public final com.larus.ui.arch.vm.internal.l i;
    public TemplateCreationAdapter j;
    public boolean k;
    public String l;
    public String m;
    public zp9.m n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public TabItemInfo s;
    public int t;
    public List<TabItemInfo> u;
    public final Lazy v;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(m r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class c implements Function0<LifecycleOwner> {
        public final /* synthetic */ Fragment a;

        public c(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ Fragment a;

        public d(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelProvider.Factory> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final TemplateCreateViewModel T90() {
        return (TemplateCreateViewModel) this.i.getValue();
    }

    public final boolean V90() {
        return ((Boolean) this.v.getValue()).booleanValue();
    }

    public final void onDestroyView() {
        LarusCommunityTemplateCreationFragmentLayoutBinding r0 = this.e;
        if (r0 == null) goto L10;
        ViewPager2 r1 = r0.i;
        if (r1 == null) goto L10;
        TemplateCreationFragment$initView$1$1 r2 = this.h;
        if (r2 == null) goto L9;
        r1.unregisterOnPageChangeCallback(r2);
    L9:
        r1.setAdapter(null);
    L10:
        this.h = null;
        this.j = null;
        this.f = null;
        this.e = null;
        super.onDestroyView();
    }

    public TemplateCreationFragment() {
        this.d = LazyKt.lazy(new h());
        this.g = -1;
        this.i = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(TemplateCreateViewModel.class), Reflection.getOrCreateKotlinClass(TemplateCreateState.class), new c(this), new d(this), e.a);
        this.l = "";
        this.q = "";
        this.t = 2;
        this.u = new ArrayList();
        this.v = LazyKt.lazy(new i());
    }

    public final void S90(ViewPager2 r4) {
        Field r0 = ViewPager2.class.getDeclaredField("mRecyclerView");
        r0.setAccessible(true);
        Object r5 = r0.get(r4);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r6 = (RecyclerView) r5;
        Field r1 = RecyclerView.class.getDeclaredField("mTouchSlop");
        r1.setAccessible(true);
        Object r2 = r1.get(r6);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        r1.set(r6, Integer.valueOf(((Integer) r2).intValue() * 2));
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.larus.community.impl.template.j] */
    public final void U90(final List<TabItemInfo> r18) {
        TemplateCreationAdapter r2 = this.j;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullParameter(r18, "tabList");
        if (Intrinsics.areEqual(r18, r2.d) == true) goto L8;
        r2.d = r18;
        r2.notifyDataSetChanged();
    L8:
        final int r3 = 0;
        if (r18.size() <= 1) goto L96;
        if (this.f == null) goto L13;
        m29.a.b("TemplateCreationFragment", "has setupTabListView");
        goto L96
    L13:
        LarusCommunityTemplateCreationFragmentLayoutBinding r4 = this.e;
        if (r4 == null) goto L18;
        TextView r5 = r4.h;
        if (r5 == null) goto L18;
        e1.o(r5);
    L18:
        Context r6 = getContext();
        if (r6 == null) goto L96;
        m3 r7 = m3.a;
        View r8 = r7.p(r6);
        if (r8 != null) goto L24;
        r8 = new r29.j(r6);
    L24:
        this.f = r8;
        boolean r9 = r8 instanceof View;
        if (r9 == false) goto L27;
        View r10 = r8;
    L28:
        if (r10 != null) goto L30;
        boolean r11 = m29.a.a;
        m29.a.b("TemplateCreationFragment", "tab list view is not view: " + this.f);
        goto L96
    L30:
        if (r9 == false) goto L32;
        View r12 = r8;
    L33:
        if (r12 == null) goto L86;
        e29.e r13 = e29.d.a(this);
        if (r13.a(V90()) == false) goto L46;
        LarusCommunityTemplateCreationFragmentLayoutBinding r14 = this.e;
        if (r14 == null) goto L41;
        FrameLayout r15 = r14.e;
        if (r15 == null) goto L41;
        e1.x(r15);
    L41:
        LarusCommunityTemplateCreationFragmentLayoutBinding r16 = this.e;
        if (r16 == null) goto L73;
        ConstraintLayout r17 = r16.f;
        if (r17 == null) goto L73;
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(0, -2);
        r20.startToEnd = 2131363788;
        r20.endToStart = 2131383223;
        r20.bottomToBottom = 0;
        Unit r110 = Unit.INSTANCE;
        r17.addView(r12, 0, r20);
    L73:
        r12.setId(2131377235);
        Integer r21 = Integer.valueOf(r7.r());
        if (r21.intValue() == 0) goto L76;
        boolean r22 = true;
    L77:
        if (r22 == true) goto L80;
        r21 = null;
    L80:
        if (r21 == null) goto L86;
        int r23 = r21.intValue();
        LarusCommunityTemplateCreationFragmentLayoutBinding r24 = this.e;
        if (r24 == null) goto L86;
        AppCompatImageView r25 = r24.g;
        if (r25 == null) goto L86;
        r25.setImageResource(r23);
        goto L86
    L76:
        r22 = false;
        goto L77
    L46:
        LarusCommunityTemplateCreationFragmentLayoutBinding r26 = this.e;
        if (r26 == null) goto L52;
        FrameLayout r27 = r26.e;
        if (r27 == null) goto L52;
        e1.o(r27);
    L52:
        if (r13.a == false) goto L58;
        LarusCommunityTemplateCreationFragmentLayoutBinding r28 = this.e;
        if (r28 == null) goto L58;
        AppCompatImageView r30 = r28.g;
        if (r30 == null) goto L58;
        e1.o(r30);
    L58:
        LarusCommunityTemplateCreationFragmentLayoutBinding r31 = this.e;
        if (r31 == null) goto L73;
        ConstraintLayout r32 = r31.f;
        if (r32 == null) goto L73;
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(0, -2);
        boolean r112 = V90();
        if (r13.a == true) goto L65;
    L68:
        boolean r113 = true;
    L69:
        if (r113 == false) goto L71;
        r111.startToEnd = 2131363788;
    L72:
        r111.endToEnd = 0;
        r111.setMarginEnd(r13.b);
        r111.bottomToBottom = 0;
        Unit r33 = Unit.INSTANCE;
        r32.addView(r12, 0, r111);
        goto L73
    L71:
        r111.startToStart = 0;
        goto L72
    L65:
        if (r13.a(r112) == true) goto L68;
        r113 = false;
    L86:
        zp9.u r34 = this.f;
        if (r34 == null) goto L89;
        r34.setCurrent(this.g);
    L89:
        zp9.u r35 = this.f;
        if (r35 == null) goto L92;
        r35.a(new o(this, r18));
    L92:
        zp9.u r36 = this.f;
        if (r36 == null) goto L96;
        r36.c(new p());
        goto L96
    L32:
        r12 = null;
        goto L33
    L27:
        r10 = null;
    L96:
        if (this.k == false) goto L158;
        ArrayList r37 = new ArrayList();
        Iterator<T> r38 = r18.iterator();
    L99:
        if (r38.hasNext() == false) goto L126;
        TabItemInfo r40 = (TabItemInfo) r38.next();
        String r41 = r40.getId();
        if (r41 == null) goto L105;
        Long r42 = StringsKt.toLongOrNull(r41);
        if (r42 == null) goto L105;
        long r43 = r42.longValue();
    L106:
        long r114 = r43;
        String r44 = r40.getName();
        if (r44 != null) goto L109;
        r44 = "";
    L109:
        String r115 = r44;
        DisplayExtra r45 = r40.a();
        if (r45 == null) goto L112;
        String r116 = r45.c();
    L113:
        DisplayExtra r46 = r40.a();
        if (r46 == null) goto L116;
        String r117 = r46.a();
    L117:
        DisplayExtra r47 = r40.a();
        if (r47 == null) goto L120;
        String r118 = r47.d();
    L121:
        DisplayExtra r48 = r40.a();
        if (r48 == null) goto L124;
        String r50 = r48.b();
    L125:
        r37.add(new w(r114, r115, r116, r117, r118, r50));
        goto L99
    L124:
        r50 = null;
        goto L125
    L120:
        r118 = null;
        goto L121
    L116:
        r117 = null;
        goto L117
    L112:
        r116 = null;
    L105:
        r43 = 0;
        goto L106
    L126:
        zp9.u r51 = this.f;
        if (r51 == null) goto L130;
        r51.d(r37);
    L130:
        if ((!r18.isEmpty()) == false) goto L134;
        zp9.m r52 = this.n;
        if (r52 == null) goto L134;
        r52.c((TabItemInfo) ListProtector.get(r18, 0));
    L134:
        String r53 = this.m;
        if (r53 == null) goto L158;
        if (r53.length() <= 0) goto L139;
        boolean r54 = true;
    L140:
        if (r54 == true) goto L143;
        r53 = null;
    L143:
        if (r53 == null) goto L158;
        Iterator<TabItemInfo> r55 = r18.iterator();
    L146:
        if (r55.hasNext() == false) goto L151;
        if (Intrinsics.areEqual(r55.next().getId(), r53) == true) goto L152;
        r3 = r3 + 1;
    L152:
        if (r3 < 0) goto L158;
        final ?? r56 = new j(this, r3, r18);
        boolean r57 = m29.a.a;
        m29.a.c("TemplateCreationFragment", "default landing to tab: " + this.m + ", index: " + r3);
        r56.invoke();
        if (z2.a.getCreationFeedLandingTabOptConfig() == false) goto L156;
        SafeExtKt.c(this, new k(this, r3, r56), 500);
    L156:
        this.m = null;
        goto L158
    L151:
        r3 = -1;
        goto L152
    L139:
        r54 = false;
    L158:
        if ((!r18.isEmpty()) == false) goto L164;
        LarusCommunityTemplateCreationFragmentLayoutBinding r1 = this.e;
        if (r1 == null) goto L175;
        ViewPager2 r58 = r1.i;
        if (r58 == null) goto L176;
        e1.x(r58);
        return;
    L176:
        return;
    L175:
        return;
    L164:
        LarusCommunityTemplateCreationFragmentLayoutBinding r60 = this.e;
        if (r60 == null) goto L178;
        ViewPager2 r61 = r60.i;
        if (r61 == null) goto L179;
        e1.o(r61);
        return;
    L179:
        return;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        boolean r0 = false;
        if (r7 == null) goto L5;
        boolean r8 = r7.getBoolean("key_is_multi_tab", false);
    L6:
        this.k = r8;
        Bundle r9 = getArguments();
        String r1 = "";
        if (r9 == null) goto L10;
        String r10 = r9.getString("key_multi_tab_title_name");
        if (r10 == null) goto L10;
    L11:
        this.l = r10;
        Bundle r11 = getArguments();
        int r2 = 2;
        if (r11 == null) goto L14;
        r2 = r11.getInt("key_creation_recommend_type", 2);
    L14:
        this.t = r2;
        Bundle r12 = getArguments();
        if (r12 == null) goto L18;
        String r13 = r12.getString("argBotId");
        if (r13 == null) goto L18;
    L19:
        this.p = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L23;
        String r15 = r14.getString("key_current_page_name");
        if (r15 == null) goto L23;
    L24:
        this.q = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L30;
        String r17 = r16.getString("template_page_type");
        if (r17 == null) goto L30;
        r1 = r17;
    L30:
        this.r = r1;
        String r3 = null;
        if (e29.d.a(this).a == false) goto L38;
        Bundle r18 = getArguments();
        ICommunityHostBehaviorProvider r4 = e29.d.c();
        if (r4 == null) goto L35;
        UserCreation r20 = r4.o(r18);
    L36:
        if (r20 == null) goto L38;
        boolean r21 = true;
    L40:
        if (r21 == false) goto L46;
        Bundle r22 = getArguments();
        if (r22 == null) goto L45;
        r3 = r22.getString("feed_landing_tab");
        if (r3 == null) goto L45;
    L55:
        this.m = r3;
        boolean r23 = m29.a.a;
        m29.a.c("TemplateCreationFragment", "onCreate isMultiTab:" + this.k + ",defaultLandingTabId:" + this.m);
        TemplateCreateViewModel r24 = T90();
        boolean r5 = this.k;
        int r25 = this.t;
        String r26 = this.m;
        if (r26 != null) goto L58;
    L59:
        r0 = true;
    L60:
        r24.fetchTabList(r5, r25, r0, DowngradeSource.ENTER_PAGE.getValue());
        if (e29.d.a(this).a(V90()) == false) goto L64;
        T90().fetchAvatarInfo(AccountService.a.getUserId());
        return;
    L64:
        return;
    L58:
        if (r26.length() != 0) goto L60;
    L45:
        r3 = "0";
        goto L55
    L46:
        HashMap<Integer, String> r27 = com.larus.community.impl.cache.d.a;
        int r28 = this.t;
        if (z2.a.f1().i() == true) goto L49;
        String r30 = null;
    L50:
        if (r30 != null) goto L54;
        Bundle r31 = getArguments();
        if (r31 == null) goto L55;
        r3 = r31.getString("feed_landing_tab");
        goto L55
    L54:
        r3 = r30;
        goto L55
    L49:
        r30 = com.larus.community.impl.cache.d.a.get(Integer.valueOf(r28));
        goto L50
    L35:
        r20 = null;
    L38:
        r21 = false;
    L23:
        r15 = "";
    L18:
        r13 = "";
    L10:
        r10 = "";
        goto L11
    L5:
        r8 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v40, types: [com.larus.community.impl.template.TemplateCreationFragment$initView$1$1] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.larus.community.impl.template.m] */
    public final void onViewCreated(View r110, Bundle r20) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r20);
        Bundle r1 = getArguments();
        int r2 = -1;
        if (r1 == null) goto L5;
        r2 = r1.getInt("key_template_list_top_padding", -1);
    L5:
        if (r2 < 0) goto L17;
        LarusCommunityTemplateCreationFragmentLayoutBinding r3 = this.e;
        if (r3 == null) goto L11;
        ConstraintLayout r4 = r3.a;
        if (r4 == null) goto L11;
        r4.setPadding(r4.getPaddingLeft(), r2, r4.getPaddingRight(), r4.getPaddingBottom());
    L11:
        LarusCommunityTemplateCreationFragmentLayoutBinding r5 = this.e;
        if (r5 == null) goto L26;
        ConstraintLayout r6 = r5.f;
        if (r6 == null) goto L26;
        e1.o(r6);
    L26:
        if (this.e == null) goto L103;
        TemplateCreationAdapter r7 = new TemplateCreationAdapter(this, this.n, (RecyclerView.RecycledViewPool) this.d.getValue());
        this.j = r7;
        LarusCommunityTemplateCreationFragmentLayoutBinding r8 = this.e;
        if (r8 == null) goto L32;
        ViewPager2 r9 = r8.i;
        if (r9 == null) goto L32;
        r9.setAdapter(r7);
    L32:
        LarusCommunityTemplateCreationFragmentLayoutBinding r10 = this.e;
        if (r10 == null) goto L38;
        ViewPager2 r11 = r10.i;
        if (r11 == null) goto L38;
        r11.setOffscreenPageLimit(1);
    L38:
        if (this.h != null) goto L40;
        this.h = new TemplateCreationFragment$initView$1$1(this);
    L40:
        TemplateCreationFragment$initView$1$1 r12 = this.h;
        if (r12 == null) goto L47;
        LarusCommunityTemplateCreationFragmentLayoutBinding r13 = this.e;
        if (r13 == null) goto L47;
        ViewPager2 r14 = r13.i;
        if (r14 == null) goto L47;
        r14.registerOnPageChangeCallback(r12);
    L47:
        e29.e r15 = e29.d.a(this);
        boolean r16 = this.k;
        if (r16 == true) goto L50;
    L52:
        boolean r17 = false;
    L53:
        if (r17 == false) goto L69;
        LarusCommunityTemplateCreationFragmentLayoutBinding r18 = this.e;
        if (r18 == null) goto L59;
        TextView r21 = r18.h;
        if (r21 == null) goto L59;
        e1.x(r21);
    L59:
        LarusCommunityTemplateCreationFragmentLayoutBinding r22 = this.e;
        if (r22 == null) goto L64;
        TextView r23 = r22.h;
        if (r23 == null) goto L64;
        r23.setText(this.l);
    L64:
        LarusCommunityTemplateCreationFragmentLayoutBinding r24 = this.e;
        if (r24 == null) goto L80;
        ViewPager2 r25 = r24.i;
        if (r25 == null) goto L80;
        S90(r25);
    L80:
        TemplateCreateState r26 = (TemplateCreateState) T90().getState();
        List<TabItemInfo> r27 = r26.getTabList();
        if ((true ^ r27.isEmpty()) == true) goto L84;
        r27 = null;
    L84:
        if (r27 == null) goto L86;
        boolean r28 = m29.a.a;
        m29.a.c("TemplateCreationFragment", "use cache tabList，size:" + r27.size());
        this.u = r27;
        U90(r27);
    L86:
        LarusCommunityTemplateCreationFragmentLayoutBinding r30 = this.e;
        if (r30 == null) goto L91;
        CreationLoadingAndRetryView r31 = r30.c;
        if (r31 == null) goto L91;
        r31.R5(r26.getPageState());
    L91:
        ComponentViewModel.onEach$default(T90(), TemplateCreationFragment$initView$1$4.INSTANCE, null, new TemplateCreationFragment$initView$1$5(this, null), 2, null);
        ComponentViewModel.onEach$default(T90(), TemplateCreationFragment$initView$1$6.INSTANCE, null, new TemplateCreationFragment$initView$1$7(this, null), 2, null);
        LarusCommunityTemplateCreationFragmentLayoutBinding r32 = this.e;
        if (r32 == null) goto L97;
        CreationLoadingAndRetryView r33 = r32.c;
        if (r33 == null) goto L97;
        r33.setOnRetryClickListener(new l(this));
    L97:
        if (e29.d.a(this).a(V90()) == false) goto L103;
        T90().getUserInfoState().observe(getViewLifecycleOwner(), new b(new m(this)));
        LarusCommunityTemplateCreationFragmentLayoutBinding r34 = this.e;
        if (r34 == null) goto L103;
        FrameLayout r35 = r34.e;
        if (r35 == null) goto L103;
        e1.d(r35, new n(this));
        goto L103
    L69:
        if (r16 == false) goto L80;
        LarusCommunityTemplateCreationFragmentLayoutBinding r36 = this.e;
        if (r36 == null) goto L75;
        TextView r37 = r36.h;
        if (r37 == null) goto L75;
        e1.o(r37);
    L75:
        LarusCommunityTemplateCreationFragmentLayoutBinding r38 = this.e;
        if (r38 == null) goto L80;
        ViewPager2 r40 = r38.i;
        if (r40 == null) goto L80;
        S90(r40);
        goto L80
    L50:
        if (r15.a == true) goto L52;
        r17 = true;
    L103:
        FLogger.a.d("TemplateCreationFragment", "initView");
        return;
    L17:
        if (this.k == true) goto L26;
        if (e29.d.a(this).a == false) goto L26;
        LarusCommunityTemplateCreationFragmentLayoutBinding r41 = this.e;
        if (r41 == null) goto L26;
        ConstraintLayout r42 = r41.f;
        if (r42 == null) goto L26;
        e1.o(r42);
        goto L26
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = getLayoutInflater().inflate(2131561980, r12, false);
        int r15 = 2131363788;
        View r2 = ViewBindings.findChildViewById(r14, 2131363788);
        if (r2 == null) goto L28;
        ConstraintLayout r16 = r14;
        CreationLoadingAndRetryView r3 = (CreationLoadingAndRetryView) ViewBindings.findChildViewById(r14, 2131378996);
        if (r3 == null) goto L26;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r14, 2131383222);
        if (r4 == null) goto L25;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131383223);
        if (r5 == null) goto L24;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r14, 2131388109);
        if (r6 == null) goto L23;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r14, 2131388115);
        if (r7 == null) goto L22;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131388924);
        if (r8 == null) goto L21;
        ViewPager2 r9 = ViewBindings.findChildViewById(r14, 2131392568);
        if (r9 == null) goto L20;
        this.e = new LarusCommunityTemplateCreationFragmentLayoutBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L20:
        r15 = 2131392568;
        goto L28
    L21:
        r15 = 2131388924;
        goto L28
    L22:
        r15 = 2131388115;
        goto L28
    L23:
        r15 = 2131388109;
        goto L28
    L24:
        r15 = 2131383223;
        goto L28
    L25:
        r15 = 2131383222;
        goto L28
    L26:
        r15 = 2131378996;
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
