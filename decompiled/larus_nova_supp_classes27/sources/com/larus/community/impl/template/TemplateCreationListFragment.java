package com.larus.community.impl.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.api.spi.ICommunityFeedRequestSourceFactory;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.cache.CreationListCacheDataSource;
import com.larus.community.impl.repository.CommunityCreationRecommendRepository;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00100\u001a\u00020\u0014H\u0002J\b\u00101\u001a\u00020\u0016H\u0002J'\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020 H\u0002J\u0012\u0010<\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010>\u001a\u00020 H\u0016J\b\u0010?\u001a\u00020 H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006A"}, d2 = {"Lcom/larus/community/impl/template/TemplateCreationListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/creation/ICreationFeedFragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setSharedPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityPageTemplateCreationListBinding;", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "currentTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "communityRecommendType", "", "scene", "", "useCache", "", "relatedRecommendation", "relatedCreationId", "pendingHostPublishedCreationId", "creationDoSameLandingType", "getCreationDoSameLandingType", "()I", "creationDoSameLandingType$delegate", "Lkotlin/Lazy;", "setCreationDoSameInterceptor", "", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "getRecommendType", "isCurrentRecommendTab", "scrollToTopAndRefresh", "notScrollToTop", "notRefresh", "smoothScrollDuration", "", "(ZZLjava/lang/Long;)V", "insertFirstUserCreation", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "insertPendingHostPublishedCreationIfNeeded", "consumePendingHostPublishedCreationIfMatched", "creationId", "onDestroyView", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreationListFragment extends Fragment implements zp9.o {
    public static final /* synthetic */ int n = 0;
    public RecyclerView.RecycledViewPool d;
    public zp9.m e;
    public TabItemInfo f;
    public int g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public final Lazy m;

    public static final class a {
    }

    static {
    }

    public final boolean U90() {
        TabItemInfo r0 = this.f;
        if (r0 == null) goto L22;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getId();
    L9:
        if (Intrinsics.areEqual(r2, "") == true) goto L22;
        TabItemInfo r3 = this.f;
        if (r3 == null) goto L13;
        String r4 = r3.getId();
    L14:
        if (r4 == null) goto L22;
        TabItemInfo r5 = this.f;
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

    public TemplateCreationListFragment() {
        this.g = 2;
        this.m = LazyKt.lazy(new r());
    }

    public final zp9.l T90() {
        return s1a.a.g(this).getAbility(zp9.l.class);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.e = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.l = null;
    }

    public final void S90(String r8) {
        int r0 = e29.d.a;
        Bundle r1 = getArguments();
        ICommunityHostBehaviorProvider r2 = e29.d.c();
        if (r2 == null) goto L7;
        boolean r9 = r2.j(r1, r8);
        boolean r3 = true;
        if (r9 != true) goto L7;
    L8:
        if (r3 == true) goto L10;
        return;
    L10:
        this.l = null;
        zp9.l r4 = T90();
        if (r4 == null) goto L14;
        zp9.l.a.a(r4, false, true, null, false, false, 29);
        return;
    L14:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        int r0 = 2;
        if (r5 == null) goto L5;
        r0 = r5.getInt("key_creation_recommend_type", 2);
    L5:
        this.g = r0;
        Bundle r6 = getArguments();
        if (r6 == null) goto L8;
        boolean r7 = r6.getBoolean("key_creation_use_cache", false);
    L9:
        this.i = r7;
        Bundle r8 = getArguments();
        String r1 = null;
        if (r8 == null) goto L12;
        String r9 = r8.getString("key_creation_scene");
    L13:
        this.h = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L16;
        TabItemInfo r11 = (TabItemInfo) r10.getParcelable("key_tab_item_info");
    L17:
        this.f = r11;
        if (U90() == false) goto L33;
        Bundle r12 = getArguments();
        if (r12 == null) goto L22;
        String r13 = r12.getString("related_recommendation");
    L23:
        this.j = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L26;
        r1 = r14.getString("related_creation_id");
    L26:
        this.k = r1;
        boolean r15 = m29.a.a;
        m29.a.c("TemplateCreationListFragment", "relatedRecommendation:" + this.j + " relatedCreationId:" + this.k);
        if (o0.d(this.j) == false) goto L29;
    L30:
        this.i = false;
    L31:
        m29.a.c("TemplateCreationListFragment", "relatedRecommendation:" + this.j);
        return;
    L29:
        if (o0.d(this.k) == false) goto L31;
    L22:
        r13 = null;
        goto L23
    L33:
        return;
    L16:
        r11 = null;
        goto L17
    L12:
        r9 = null;
        goto L13
    L8:
        r7 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.community.impl.template.u] */
    public final void onViewCreated(View r61, Bundle r62) {
        Intrinsics.checkNotNullParameter(r61, "view");
        super.onViewCreated(r61, r62);
        k1a.b.a(this, new s(this));
        Bundle r1 = getArguments();
        if (r1 == null) goto L8;
        String r2 = r1.getString("argBotId");
        if (r2 == null) goto L8;
        String r6 = r2;
    L9:
        zp9.l r3 = T90();
        boolean r27 = true;
        if (r3 == null) goto L110;
        String r31 = "List_TemplateCreationList_" + this.g;
        Bundle r4 = getArguments();
        if (r4 == null) goto L14;
        String r5 = r4.getString("recommend_from");
    L15:
        Bundle r7 = getArguments();
        if (r7 == null) goto L21;
        String r8 = r7.getString("argConversationId");
        if (r8 == null) goto L21;
        String r9 = r8;
    L22:
        Bundle r10 = getArguments();
        if (r10 == null) goto L25;
        Integer r11 = Integer.valueOf(r10.getInt("action_bar_template_id"));
    L26:
        Bundle r12 = getArguments();
        if (r12 == null) goto L32;
        String r13 = r12.getString("arg_chat_type");
        if (r13 == null) goto L32;
        String r14 = r13;
    L33:
        Bundle r15 = getArguments();
        if (r15 == null) goto L36;
        String r16 = r15.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM);
    L37:
        Bundle r17 = getArguments();
        if (r17 == null) goto L40;
        String r18 = r17.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
    L41:
        Bundle r20 = getArguments();
        if (r20 == null) goto L45;
        String r21 = r20.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
        if (r21 == null) goto L45;
    L46:
        String r110 = r21;
        Bundle r22 = getArguments();
        if (r22 == null) goto L49;
        Boolean r23 = Boolean.valueOf(r22.getBoolean("key_is_chat_double_page", false));
    L50:
        Bundle r24 = getArguments();
        if (r24 == null) goto L53;
        String r28 = r24.getString("template_page_type");
    L54:
        Boolean r111 = r23;
        String r25 = null;
        zp9.g r33 = new zp9.g("template_page", r5, r6, r9, r11, r14, r16, r18, r110, "action_bar_template", r111, null, r28, null, null, null, null, null, null, null, null, null, 4188160);
        Bundle r26 = getArguments();
        if (r26 == null) goto L57;
        boolean r46 = r26.getBoolean("open_new_chat_page_on_send", false);
    L58:
        TabItemInfo r30 = this.f;
        Bundle r32 = getArguments();
        if (r32 == null) goto L61;
        int r112 = r32.getInt("key_template_list_bottom_padding");
    L62:
        Bundle r34 = getArguments();
        if (r34 == null) goto L65;
        boolean r44 = r34.getBoolean("key_show_user_info");
    L67:
        if (U90() == true) goto L69;
    L79:
        String r45 = null;
    L81:
        if (o0.d(this.j) == true) goto L83;
    L85:
        boolean r210 = false;
    L87:
        if (U90() == false) goto L94;
        Bundle r35 = getArguments();
        if (r35 == null) goto L91;
        boolean r36 = r35.getBoolean("key_disable_initial_auto_refresh_once", false);
    L92:
        if (r36 == false) goto L94;
        boolean r37 = true;
    L95:
        zp9.f r38 = new zp9.f(r210, r37, r31, false, r33, null, Integer.valueOf(r112), null, true, r30, null, false, null, null, null, r44, r45, r46, null, null, z2.a.creationFeedVideoAutoPlay(), false, null, null, Integer.valueOf(((Number) this.m.getValue()).intValue()), Boolean.TRUE, null, null, null, null, 1022131368);
        int r40 = this.g;
        TabItemInfo r41 = this.f;
        String r42 = this.h;
        if (U90() == true) goto L98;
    L108:
        CreationFeedCacheEntity r113 = null;
    L109:
        String r114 = this.k;
        String r115 = this.j;
        ICommunityFeedRequestSourceFactory.a r43 = ICommunityFeedRequestSourceFactory.a;
        Bundle r47 = getArguments();
        r43.getClass();
        r3.nh(r38, new zp9.e(new CommunityCreationRecommendRepository(r40, r41, r42, r113, null, r115, r114, ICommunityFeedRequestSourceFactory.a.a(r47), 16), this.e, null, this.d, 4));
    L111:
        this.j = r25;
        this.k = r25;
        if (U90() == false) goto L150;
        int r48 = e29.d.a;
        Bundle r50 = getArguments();
        ICommunityHostBehaviorProvider r51 = e29.d.c();
        if (r51 == null) goto L117;
        String r116 = r51.o(r50);
    L118:
        if (r116 == null) goto L151;
        final String r52 = ((UserCreation) r116).a;
        if (r52 != null) goto L123;
    L126:
        if (r27 == false) goto L128;
    L130:
        this.l = r52;
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r116, "userCreation");
        ICommunityHostBehaviorProvider r53 = e29.d.c();
        if (r53 == null) goto L133;
        r53.i(this, r116);
    L133:
        Intrinsics.checkNotNullParameter(r116, "userCreation");
        zp9.l r54 = T90();
        if (r54 == null) goto L136;
        r54.fQ(r116);
    L136:
        zp9.l r55 = T90();
        if (r55 == null) goto L139;
        String r117 = r55.og();
    L140:
        if (r117 == null) goto L142;
        boolean r118 = Intrinsics.areEqual(r117.getValue(), Boolean.TRUE);
    L143:
        if (r118 == false) goto L145;
        S90(r52);
        return;
    L145:
        if (r117 == null) goto L149;
        r117.observe(getViewLifecycleOwner(), new v(new u(this, r52)));
        return;
    L149:
        return;
    L142:
        r118 = false;
        goto L143
    L139:
        r117 = r25;
        goto L140
    L128:
        if (Intrinsics.areEqual(this.l, r52) == false) goto L130;
        return;
    L123:
        if (r52.length() == 0) goto L126;
        r27 = false;
        goto L126
    L151:
        return;
    L117:
        r116 = r25;
        goto L118
    L150:
        return;
    L98:
        if (this.i == false) goto L108;
        String r56 = this.h;
        if (r56 != null) goto L102;
    L105:
        boolean r119 = true;
    L106:
        if (r119 == false) goto L108;
        r113 = CreationListCacheDataSource.c(CreationListCacheDataSource.a, String.valueOf(this.g), false, false, 2);
        goto L109
    L102:
        if (r56.length() == 0) goto L105;
        r119 = false;
        goto L106
    L91:
        r36 = false;
    L94:
        r37 = false;
        goto L95
    L83:
        if (o0.d(this.k) == false) goto L85;
        r210 = true;
        goto L87
    L69:
        if (this.i == false) goto L79;
        String r57 = this.h;
        if (r57 != null) goto L73;
    L76:
        boolean r58 = true;
    L77:
        if (r58 == false) goto L79;
        r45 = String.valueOf(this.g);
        goto L81
    L73:
        if (r57.length() == 0) goto L76;
        r58 = false;
        goto L77
    L65:
        r44 = false;
        goto L67
    L61:
        r112 = 0;
        goto L62
    L57:
        r46 = false;
        goto L58
    L53:
        r28 = null;
        goto L54
    L49:
        r23 = null;
    L45:
        r21 = "chat_action_bar";
        goto L46
    L40:
        r18 = null;
        goto L41
    L36:
        r16 = null;
    L32:
        r14 = "";
        goto L33
    L25:
        r11 = null;
    L21:
        r9 = "";
        goto L22
    L14:
        r5 = null;
        goto L15
    L110:
        r25 = null;
    L8:
        r6 = "";
        goto L9
    }

    public final void V60(boolean r8, boolean r9, Long r10) {
        zp9.l r0 = T90();
        if (r0 == null) goto L6;
        zp9.l.a.a(r0, r8, r9, r10, false, false, 24);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = getLayoutInflater().inflate(2131561975, r3, false);
        if (r5 == null) goto L7;
        return (FrameLayout) r5;
    L7:
        throw new NullPointerException("rootView");
    }
}
