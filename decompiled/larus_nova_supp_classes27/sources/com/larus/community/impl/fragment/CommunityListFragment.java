package com.larus.community.impl.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.z;
import com.larus.community.api.ICommunityService;
import com.larus.community.api.spi.ICommunityFeedRequestSourceFactory;
import com.larus.community.impl.cache.CreationListCacheDataSource;
import com.larus.community.impl.databinding.LarusCommunityCreateFragmentLayoutBinding;
import com.larus.community.impl.repository.CommunityCreationRecommendRepository;
import com.larus.community.impl.view.CommunityCreateButton;
import com.larus.community.impl.viewmodel.CommunityListViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;
import zp9.f;
import zp9.g;
import zp9.l;
import zp9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001VB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020/2\b\u00103\u001a\u0004\u0018\u00010\u0017H\u0002J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u0002052\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u0010<\u001a\u00020/2\b\u0010=\u001a\u0004\u0018\u000101H\u0016J\b\u0010>\u001a\u00020\u001fH\u0002J\b\u0010?\u001a\u00020/H\u0002J\b\u0010@\u001a\u00020/H\u0016J\n\u0010A\u001a\u0004\u0018\u00010BH\u0002J\b\u0010C\u001a\u00020/H\u0016J\b\u0010D\u001a\u00020\u0017H\u0002J\b\u0010E\u001a\u00020\u001dH\u0016J\u0012\u0010F\u001a\u00020/2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010G\u001a\u00020/H\u0016J \u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020\u001f2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010KH\u0016J\u0012\u0010L\u001a\u00020/2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020\u0017H\u0002J\u0010\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020)H\u0016J\u0010\u0010S\u001a\u00020/2\u0006\u0010T\u001a\u00020\u0017H\u0016J\u0006\u0010U\u001a\u00020/R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/larus/community/impl/fragment/CommunityListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "Lcom/larus/platform/api/creation/ICreationListener;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setSharedPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreateFragmentLayoutBinding;", "viewModel", "Lcom/larus/community/impl/viewmodel/CommunityListViewModel;", "getViewModel", "()Lcom/larus/community/impl/viewmodel/CommunityListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "previousPage", "", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "dp_130", "", "isChatMultiTab", "", "enableShowHeader", "enableShowBottomButton", "currentTabPosition", "currentTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "recommendType", "trackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "insertFirstUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "repository", "Lcom/larus/community/impl/repository/CommunityCreationRecommendRepository;", "initRecommendation", "initRecommendCreationId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateTrackParams", "enterMethod", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onNewIntent", "bundle", "isCurrentRecommendTab", "initView", "onResume", "updateCommunityCreateButton", "", "onDestroyView", "getCurrentPageName", "tabIndex", "onEnterTab", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "handleMsg", "msg", "Landroid/os/Message;", "handleInsertFirstCreation", "scene", "onSetReferenceImagePublic", "userCreation", "onRemoveUserCreation", "creationId", "scrollToTopAndRefresh", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommunityListFragment extends Fragment implements WeakHandler.IHandler, s19.a, z, r {
    public static final /* synthetic */ int s = 0;
    public RecyclerView.RecycledViewPool d;
    public LarusCommunityCreateFragmentLayoutBinding e;
    public final Lazy f;
    public String g;
    public final int h;
    public boolean i;
    public boolean j;
    public int k;
    public TabItemInfo l;
    public int m;
    public g n;
    public UserCreation o;
    public CommunityCreationRecommendRepository p;
    public String q;
    public String r;

    public static final class a {
    }

    static {
    }

    public final void handleMsg(Message r1) {
    }

    public final void pp(String r1) {
    }

    @Override // s19.a
    public final void t1() {
    }

    public final boolean U90() {
        TabItemInfo r0 = this.l;
        if (r0 == null) goto L22;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getId();
    L9:
        if (Intrinsics.areEqual(r2, "") == true) goto L22;
        TabItemInfo r3 = this.l;
        if (r3 == null) goto L13;
        String r4 = r3.getId();
    L14:
        if (r4 == null) goto L22;
        TabItemInfo r5 = this.l;
        if (r5 == null) goto L19;
        r1 = r5.getId();
    L19:
        if (Intrinsics.areEqual(r1, "0") == true) goto L22;
        return false;
    L13:
        r4 = null;
        goto L14
    L7:
        r2 = null;
    L22:
        return true;
    }

    public final Object V90() {
        final LarusCommunityCreateFragmentLayoutBinding r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (this.j == true) goto L7;
        e1.o(r0.b);
        return Unit.INSTANCE;
    L7:
        if (ICommunityService.a.f1().k() == false) goto L14;
        e1.x(r0.b);
        r0.b.b();
        r0.b.setAlpha(1.0f);
        return Unit.INSTANCE;
    L14:
        return Boolean.valueOf(r0.b.post(new com.larus.community.impl.fragment.a(this, r0)));
    }

    public final void onDestroyView() {
        Set<r> r0 = f29.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        f29.a.a.remove(this);
        super.onDestroyView();
        this.e = null;
    }

    public CommunityListFragment() {
        final Function0<Fragment> r0 = new CommunityListFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CommunityListViewModel.class), new CommunityListFragment$special$$inlined$viewModels$default$2(r0), new CommunityListFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = i5.d() + i5.O();
        this.m = 1;
    }

    public final l S90() {
        return s1a.a.g(this).getAbility(l.class);
    }

    public final void onResume() {
        super.onResume();
        T90("onResume");
        V90();
    }

    @Override // s19.a
    public final int sb() {
        return this.k;
    }

    public final void T90(String r2) {
        if (this.o == null) goto L11;
        boolean r0 = m29.a.a;
        m29.a.c("CommunityListFragment", "handlePublishSuccess:".concat(r2));
        UserCreation r3 = this.o;
        if (r3 == null) goto L9;
        l r1 = S90();
        if (r1 == null) goto L9;
        r1.xc(r3);
    L9:
        this.o = null;
        return;
    }

    public final void X0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "creationId");
        if (U90() == false) goto L8;
        l r0 = S90();
        if (r0 == null) goto L9;
        r0.deleteUserCreation(r3, false);
        return;
    L9:
        return;
    }

    @Override // s19.a
    public final void a2(Bundle r9) {
        UserCreation r0 = null;
        if (r9 == null) goto L5;
        String r1 = r9.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    L6:
        g r2 = this.n;
        if (r2 == null) goto L15;
        if (r1 == null) goto L10;
    L13:
        r2.i = r1;
        goto L15
    L10:
        if (this.i == false) goto L12;
        r1 = "create_feed_top_tab";
        goto L13
    L12:
        r1 = "create_feed";
    L15:
        if (U90() == false) goto L37;
        if (r9 == null) goto L18;
        String r3 = r9.getString("related_recommendation");
    L19:
        if (r9 == null) goto L21;
        String r4 = r9.getString("related_creation_id");
    L22:
        boolean r5 = m29.a.a;
        m29.a.c("CommunityListFragment", "onNewIntent recommend tab, relatedRecommendation:" + r3 + " relatedCreationId:" + r4);
        if (o0.d(r3) == false) goto L25;
    L30:
        CommunityCreationRecommendRepository r10 = this.p;
        if (r10 == null) goto L33;
        r10.f = r3;
        r10.g = r4;
        m29.a.c("CommunityCreationRecommendRepository", " updateRelatedRecommendation relatedRecommendation:" + r3 + " relatedCreationId:" + r4);
    L33:
        l r6 = S90();
        if (r6 == null) goto L39;
        l.a.a(r6, false, false, null, false, false, 31);
        return;
    L39:
        return;
    L25:
        if (o0.d(r4) == true) goto L30;
        if (r9 == null) goto L29;
        r0 = (UserCreation) r9.getParcelable("creation");
    L29:
        this.o = r0;
        T90("onPublishSuccess");
        return;
    L21:
        r4 = null;
        goto L22
    L18:
        r3 = null;
        goto L19
    L37:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void bZ(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void onCreate(Bundle r210) {
        super.onCreate(r210);
        m29.a.a("CommunityListFragment", new c(this));
        Bundle r1 = getArguments();
        String r3 = null;
        if (r1 == null) goto L5;
        UserCreation r2 = (UserCreation) r1.getParcelable("creation");
    L6:
        this.o = r2;
        Bundle r4 = getArguments();
        if (r4 == null) goto L9;
        r4.getBoolean("key_enable_show_header");
    L9:
        Bundle r5 = getArguments();
        int r6 = 0;
        if (r5 == null) goto L12;
        boolean r7 = r5.getBoolean("key_show_bottom_button");
    L13:
        this.j = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L16;
        r6 = r8.getInt("position");
    L16:
        this.k = r6;
        Bundle r9 = getArguments();
        if (r9 == null) goto L19;
        String r10 = r9.getString("related_recommendation");
    L20:
        this.q = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L23;
        r3 = r11.getString("related_creation_id");
    L23:
        this.r = r3;
        m29.a.c("CommunityListFragment", "initRecommendation:" + this.q + " initRecommendCreationId:" + this.r);
        boolean r12 = ci8.e.b(this);
        this.i = r12;
        if (r12 == false) goto L26;
        this.m = 6;
    L26:
        String r13 = "create_feed_top_tab";
        if (r12 == false) goto L29;
        String r14 = "create_feed_top_tab";
    L30:
        String r15 = this.g;
        if (r12 == true) goto L34;
        r13 = "ai_generate";
    L34:
        String r16 = r13;
        Bundle r17 = getArguments();
        if (r17 == null) goto L40;
        String r18 = r17.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
        if (r18 == null) goto L40;
        String r110 = r18;
    L41:
        this.n = new g(r16, r14, null, null, null, null, r14, r15, r110, r14, null, null, null, null, null, null, null, null, null, null, null, null, 4193340);
        return;
    L40:
        r110 = r14;
        goto L41
    L29:
        r14 = "create_feed";
        goto L30
    L19:
        r10 = null;
        goto L20
    L12:
        r7 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // s19.a
    public final void y2(String r2) {
        this.g = r2;
        g r0 = this.n;
        if (r0 == null) goto L6;
        r0.h = r2;
        return;
    }

    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        if (U90() == false) goto L8;
        l r0 = S90();
        if (r0 == null) goto L9;
        r0.CO(r2);
        return;
    L9:
        return;
    }

    @Override // s19.a
    public final void KC(boolean r8, Function0<Unit> r9) {
        l r0 = S90();
        if (r0 == null) goto L6;
        l.a.a(r0, false, false, null, false, false, 31);
        return;
    }

    public final void onViewCreated(View r47, Bundle r48) {
        Intrinsics.checkNotNullParameter(r47, "view");
        super.onViewCreated(r47, r48);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        TabItemInfo r2 = (TabItemInfo) r1.getParcelable("key_tab_item_info");
    L6:
        this.l = r2;
        k1a.b.a(this, new b(this));
        int r4 = this.m;
        TabItemInfo r5 = this.l;
        if (U90() == false) goto L9;
        CreationFeedCacheEntity r7 = CreationListCacheDataSource.c(CreationListCacheDataSource.a, String.valueOf(this.m), false, false, 2);
    L11:
        if (U90() == false) goto L13;
        String r9 = this.q;
    L14:
        ICommunityFeedRequestSourceFactory.a r3 = ICommunityFeedRequestSourceFactory.a;
        Bundle r6 = getArguments();
        r3.getClass();
        CommunityCreationRecommendRepository r8 = new CommunityCreationRecommendRepository(r4, r5, null, r7, null, r9, null, ICommunityFeedRequestSourceFactory.a.a(r6), 80);
        l r10 = S90();
        if (r10 == null) goto L33;
        StringBuilder r11 = new StringBuilder("List_CommunityCreate_");
        TabItemInfo r12 = this.l;
        if (r12 == null) goto L19;
        String r13 = r12.getName();
    L20:
        r11.append(r13);
        r11.append('_');
        TabItemInfo r14 = this.l;
        if (r14 == null) goto L23;
        String r15 = r14.getId();
    L24:
        r11.append(r15);
        String r17 = r11.toString();
        g r16 = this.n;
        Intrinsics.checkNotNull(r16);
        int r18 = i5.s0();
        TabItemInfo r20 = this.l;
        boolean r30 = ICommunityService.a.f1().g();
        if (U90() == false) goto L27;
        String r31 = String.valueOf(this.m);
    L28:
        boolean r32 = !this.i;
        if (U90() == false) goto L31;
        boolean r110 = o0.d(this.q);
    L32:
        r10.nh(new f(r110, false, r17, false, r16, 4, Integer.valueOf(r18), null, false, r20, null, false, null, null, null, r30, r31, r32, null, null, true, false, null, null, null, Boolean.TRUE, "ugc_video", "message_card", "ugc_video", "immersive_preview", 32275850), new zp9.e(r8, null, null, this.d, 6));
        goto L33
    L31:
        r110 = false;
        goto L32
    L27:
        r31 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
    L33:
        this.p = r8;
        if (e29.d.a(this).a == false) goto L40;
        LarusCommunityCreateFragmentLayoutBinding r21 = this.e;
        if (r21 == null) goto L45;
        NovaTitleBarEx r22 = r21.d;
        if (r22 == null) goto L45;
        e1.o(r22);
    L45:
        LarusCommunityCreateFragmentLayoutBinding r23 = this.e;
        if (r23 == null) goto L50;
        CommunityCreateButton r24 = r23.b;
        if (r24 == null) goto L50;
        e1.d(r24, new d(this));
    L50:
        l r25 = S90();
        if (r25 == null) goto L53;
        r25.addOnScrollListener(new CommunityListFragment$initView$2(this));
    L53:
        Context r26 = getContext();
        if (r26 == null) goto L59;
        l r27 = S90();
        if (r27 == null) goto L60;
        Intrinsics.checkNotNullParameter(r26, "context");
        r27.X20(new r29.g(r26));
        return;
    L60:
        return;
    L59:
        return;
    L40:
        LarusCommunityCreateFragmentLayoutBinding r28 = this.e;
        if (r28 == null) goto L45;
        NovaTitleBarEx r33 = r28.d;
        if (r33 == null) goto L45;
        NovaTitleBarEx.Y5(r33, getString(2131897499), null, null, 6);
        goto L45
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Set<r> r7 = f29.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        f29.a.a.add(this);
        ConstraintLayout r8 = getLayoutInflater().inflate(2131561923, r5, false);
        int r9 = 2131367588;
        CommunityCreateButton r10 = (CommunityCreateButton) ViewBindings.findChildViewById(r8, 2131367588);
        if (r10 == null) goto L13;
        ConstraintLayout r11 = r8;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r8, 2131372253);
        if (r1 == null) goto L11;
        NovaTitleBarEx r2 = ViewBindings.findChildViewById(r8, 2131388807);
        if (r2 == null) goto L10;
        this.e = new LarusCommunityCreateFragmentLayoutBinding(r11, r10, r1, r2);
        return r11;
    L10:
        r9 = 2131388807;
        goto L13
    L11:
        r9 = 2131372253;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        r.a.a(r1, r6);
    }
}
