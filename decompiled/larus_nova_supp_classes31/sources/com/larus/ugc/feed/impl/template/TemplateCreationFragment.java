package com.larus.ugc.feed.impl.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.im.FlowRuntime;
import com.larus.platform.service.AccountService;
import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import com.larus.ugc.feed.impl.home.CommunityCreateBridgeEmptyState;
import com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel;
import com.larus.ugc.feed.impl.spi.CommunityCreateNavigatorAndroidImpl;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zp9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010,J\u0012\u0010;\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010\u00112\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u000209H\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\u0019H\u0002J\b\u0010I\u001a\u000209H\u0016J\b\u0010J\u001a\u000209H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b1\u00102R\u0010\u00104\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\t\u001a\u0004\b5\u00106¨\u0006L"}, d2 = {"Lcom/larus/ugc/feed/impl/template/TemplateCreationFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "sharedPool$delegate", "Lkotlin/Lazy;", "bridgeVM", "Lcom/larus/ugc/feed/impl/home/CommunityCreateLegacyBridgeViewModel;", "getBridgeVM", "()Lcom/larus/ugc/feed/impl/home/CommunityCreateLegacyBridgeViewModel;", "bridgeVM$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "rootView", "Landroid/view/View;", "tagListContainer", "titleView", "Landroid/widget/TextView;", "profileImageContainer", "profileImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "tabMaskLeftIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "tabListView", "Lcom/larus/platform/api/creation/ITabListLayout;", "adapter", "Lcom/larus/ugc/feed/impl/template/TemplateMainAdapter;", "isMultiTab", "", "multiTabTitleName", "", "creationRecommendType", "", "botId", "currentPageName", "templatePageType", "defaultLandingTabId", "topPadding", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "isClickedTab", "lastSelectedIndex", "hostUiPolicy", "Lcom/larus/uaigc/applet/AICreationCommunityHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/uaigc/applet/AICreationCommunityHostUiPolicy;", "hostUiPolicy$delegate", "pendingLandingTabId", "isShowAvatar", "()Z", "isShowAvatar$delegate", "setCreationDoSameInterceptor", "", "interceptor", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupTabListView", "setupAvatar", "debounceSlip", "pager", "onResume", "onDestroyView", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TemplateCreationFragment extends Fragment {
    public static final /* synthetic */ int C = 0;
    public String A;
    public final Lazy B;
    public final Lazy d;
    public final com.larus.ui.arch.vm.internal.l e;
    public View f;
    public View g;
    public TextView h;
    public View i;
    public SimpleDraweeView j;
    public ViewPager2 k;
    public AppCompatImageView l;
    public u m;
    public TemplateMainAdapter n;
    public boolean o;
    public String p;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public int v;
    public zp9.m w;
    public boolean x;
    public int y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(com.larus.ugc.feed.impl.template.d r2) {
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

    public final cy9.f S90() {
        return (cy9.f) this.z.getValue();
    }

    public final void onDestroyView() {
        ViewPager2 r0 = this.k;
        if (r0 == null) goto L5;
        r0.setAdapter(null);
    L5:
        this.n = null;
        this.m = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        super.onDestroyView();
    }

    public TemplateCreationFragment() {
        this.d = LazyKt.lazy(new com.larus.ugc.feed.impl.template.a());
        this.e = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CommunityCreateLegacyBridgeViewModel.class), Reflection.getOrCreateKotlinClass(CommunityCreateBridgeEmptyState.class), new c(this), new d(this), e.a);
        this.p = "";
        this.q = 1;
        this.s = "";
        this.v = -1;
        this.y = -1;
        this.z = LazyKt.lazy(new com.larus.ugc.feed.impl.template.b(this));
        this.B = LazyKt.lazy(new com.larus.ugc.feed.impl.template.c());
    }

    public final void onResume() {
        super.onResume();
        g0a.f r0 = s1a.a.g(this).o(Reflection.getOrCreateKotlinClass(g0a.f.class));
        if (r0 == null) goto L6;
        r0.ev();
        return;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        boolean r0 = false;
        if (r6 == null) goto L5;
        r0 = r6.getBoolean("key_is_multi_tab", false);
    L5:
        this.o = r0;
        Bundle r7 = getArguments();
        String r1 = null;
        if (r7 == null) goto L8;
        String r8 = r7.getString("key_multi_tab_title_name");
    L9:
        String r2 = "";
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        this.p = r8;
        Bundle r9 = getArguments();
        int r3 = 1;
        if (r9 == null) goto L15;
        r3 = r9.getInt("key_creation_recommend_type", 1);
    L15:
        this.q = r3;
        Bundle r10 = getArguments();
        if (r10 == null) goto L18;
        String r11 = r10.getString("argBotId");
    L19:
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        this.r = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L24;
        String r13 = r12.getString("key_current_page_name");
    L25:
        if (r13 != null) goto L27;
        r13 = "";
    L27:
        this.s = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L30;
        String r15 = r14.getString("template_page_type");
    L31:
        if (r15 == null) goto L34;
        r2 = r15;
    L34:
        this.t = r2;
        Bundle r16 = getArguments();
        if (r16 == null) goto L37;
        r1 = r16.getString("feed_landing_tab");
    L37:
        this.u = r1;
        Bundle r17 = getArguments();
        int r4 = -1;
        if (r17 == null) goto L40;
        r4 = r17.getInt("key_template_list_top_padding", -1);
    L40:
        this.v = r4;
        this.A = this.u;
        boolean r18 = w0a.a.a;
        w0a.a.c("TemplateCreationFragment[Kmp]", "onCreate isMultiTab=" + this.o + " recommendType=" + this.q + " landingTabId=" + this.u + " templatePageType=" + this.t);
        return;
    L30:
        r15 = null;
        goto L31
    L24:
        r13 = null;
        goto L25
    L18:
        r11 = null;
        goto L19
    L8:
        r8 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [com.larus.ugc.feed.impl.template.d] */
    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        FLogger r1 = FLogger.a;
        r1.d("TemplateCreationFragment[Kmp]", "onViewCreated");
        int r3 = this.v;
        if (r3 < 0) goto L11;
        View r4 = this.f;
        if (r4 == null) goto L7;
        r4.setPadding(r4.getPaddingLeft(), r3, r4.getPaddingRight(), r4.getPaddingBottom());
    L7:
        View r5 = this.g;
        if (r5 == null) goto L17;
        e1.o(r5);
    L17:
        FragmentAttachExtKt.b(this, ContainerFilter.COMMUNITY_CREATE_KMP);
        final g0a.f r6 = s1a.a.g(this).o(Reflection.getOrCreateKotlinClass(g0a.f.class));
        if (r6 != null) goto L21;
        r1.e("TemplateCreationFragment[Kmp]", "IKMPCommunityCreateAbility not bound; fragment will render empty");
        return;
    L21:
        CommunityCreateLaunchModeKmp r7 = CommunityCreateLaunchModeKmp.STANDALONE;
        int r8 = this.q;
        boolean r9 = this.o;
        Bundle r2 = getArguments();
        if (r2 == null) goto L24;
        String r10 = r2.getString("enter_method");
    L25:
        if (r10 != null) goto L27;
        r10 = "";
    L27:
        String r11 = r10;
        String r12 = this.r;
        String r13 = this.s;
        if (r13.length() <= 0) goto L30;
        boolean r14 = true;
    L31:
        if (r14 == true) goto L34;
        r13 = null;
    L34:
        r6.yG(new m0a.e(r7, r8, r9, "", r11, r12, this.u, this.t, this.p, this.v, r13, 928), new m0a.d(new CommunityCreateNavigatorAndroidImpl(getActivity(), null), new com.larus.ugc.feed.impl.spi.c(this.r, this.t), new com.larus.ugc.feed.impl.spi.a(), new y0a.e(FlowRuntime.b().c())));
        ((CommunityCreateLegacyBridgeViewModel) this.e.getValue()).bind(r6);
        TemplateMainAdapter r15 = new TemplateMainAdapter(this, this.w, (RecyclerView.RecycledViewPool) this.d.getValue());
        this.n = r15;
        ViewPager2 r16 = this.k;
        if (r16 == null) goto L37;
        r16.setAdapter(r15);
    L37:
        ViewPager2 r17 = this.k;
        if (r17 == null) goto L40;
        r17.setOffscreenPageLimit(1);
    L40:
        ViewPager2 r18 = this.k;
        if (r18 == null) goto L43;
        r18.registerOnPageChangeCallback(new AnonymousClass2(this, r6));
    L43:
        cy9.f r19 = S90();
        if (this.o == true) goto L46;
        r19.getClass();
    L49:
        boolean r110 = false;
    L50:
        if (r110 == false) goto L65;
        TextView r22 = this.h;
        if (r22 == null) goto L54;
        e1.x(r22);
    L54:
        TextView r23 = this.h;
        if (r23 == null) goto L57;
        r23.setText(this.p);
    L57:
        ViewPager2 r24 = this.k;
        if (r24 == null) goto L68;
        RecyclerView r25 = r24.getChildAt(0);
        if ((r25 instanceof RecyclerView) == false) goto L62;
        RecyclerView r26 = r25;
    L63:
        if (r26 == null) goto L68;
        r26.setScrollingTouchSlop(1);
        goto L68
    L62:
        r26 = null;
    L68:
        ((CommunityCreateLegacyBridgeViewModel) this.e.getValue()).getTabListLiveData().observe(getViewLifecycleOwner(), new b(new com.larus.ugc.feed.impl.template.d(this, r6)));
        cy9.f r27 = S90();
        if (((Boolean) this.B.getValue()).booleanValue() == true) goto L71;
        r27.getClass();
    L74:
        boolean r111 = false;
    L75:
        if (r111 == false) goto L80;
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new TemplateCreationFragment$setupAvatar$1(this, AccountService.a.getUserId(), null));
        View r28 = this.i;
        if (r28 == null) goto L81;
        e1.d(r28, new com.larus.ugc.feed.impl.template.e(this));
        return;
    L81:
        return;
    L80:
        return;
    L71:
        if (r27.a == true) goto L74;
        r111 = true;
        goto L75
    L65:
        TextView r29 = this.h;
        if (r29 == null) goto L68;
        e1.o(r29);
        goto L68
    L46:
        if (r19.a == true) goto L49;
        r110 = true;
        goto L50
    L30:
        r14 = false;
        goto L31
    L24:
        r10 = null;
        goto L25
    L11:
        if (this.o == true) goto L17;
        if (S90().a == false) goto L17;
        View r30 = this.g;
        if (r30 == null) goto L17;
        e1.o(r30);
        goto L17
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131563157, r3, false);
        this.f = r5;
        this.g = r5.findViewById(2131388110);
        this.h = (TextView) r5.findViewById(2131388925);
        this.i = r5.findViewById(2131383225);
        this.j = r5.findViewById(2131383227);
        this.k = r5.findViewById(2131392570);
        this.l = r5.findViewById(2131388116);
        return r5;
    }
}
