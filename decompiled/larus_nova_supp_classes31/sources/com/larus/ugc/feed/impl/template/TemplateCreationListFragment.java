package com.larus.ugc.feed.impl.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.api.ICommunityService;
import com.larus.community.api.spi.ICommunityFeedRequestSourceFactory;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zp9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fJ\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020\u001eH\u0002J\b\u00100\u001a\u00020\u0014H\u0002J'\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u001eH\u0002J\u0010\u0010;\u001a\u00020\u001e2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010>\u001a\u00020\u001eH\u0016J\b\u0010?\u001a\u00020\u001eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006A"}, d2 = {"Lcom/larus/ugc/feed/impl/template/TemplateCreationListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/creation/ICreationFeedFragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setSharedPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "currentTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "communityRecommendType", "", "scene", "", "useCache", "", "relatedRecommendation", "relatedCreationId", "pendingAICreationAppletPublishId", "creationDoSameLandingType", "getCreationDoSameLandingType", "()I", "creationDoSameLandingType$delegate", "Lkotlin/Lazy;", "setCreationDoSameInterceptor", "", "interceptor", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initializeAbility", "isCurrentRecommendTab", "scrollToTopAndRefresh", "notScrollToTop", "notRefresh", "smoothScrollDuration", "", "(ZZLjava/lang/Long;)V", "insertFirstUserCreation", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "insertPendingAICreationAppletPublishIfNeeded", "pushPendingPublishNotify", "consumePendingAICreationAppletPublishIfMatched", "creationId", "onDestroyView", "onDestroy", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TemplateCreationListFragment extends Fragment implements o {
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
        if (r0 == null) goto L5;
        String r1 = r0.getId();
    L7:
        if (this.f != null) goto L9;
        return true;
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        return true;
    L17:
        if (Intrinsics.areEqual(r1, "0") == true) goto L23;
        return false;
    L23:
        return true;
    L11:
        if (r1.length() == 0) goto L14;
        r3 = false;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    public TemplateCreationListFragment() {
        this.g = 2;
        this.m = LazyKt.lazy(new h());
    }

    public final zp9.l T90() {
        return (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
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
        UserCreation r0 = cy9.e.a;
        UserCreation r1 = cy9.e.b(getArguments());
        if (r1 != null) goto L5;
        return;
    L5:
        String r2 = r1.a;
        if (r8 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
    L16:
        boolean r9 = w0a.a.a;
        w0a.a.c("TemplateCreationListFragment[Kmp]", "consumePendingAICreationAppletPublish:" + r2);
        cy9.e.a(getArguments());
        this.l = null;
        zp9.l r4 = T90();
        if (r4 == null) goto L20;
        zp9.l.a.a(r4, false, true, null, false, false, 29);
        return;
    L20:
        return;
    L14:
        if (Intrinsics.areEqual(r2, r8) == true) goto L16;
        return;
    L8:
        if (r8.length() == 0) goto L11;
        r3 = false;
        goto L12
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
        if (U90() == false) goto L32;
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
        boolean r15 = w0a.a.a;
        w0a.a.c("TemplateCreationListFragment[Kmp]", "relatedRecommendation=" + this.j + " relatedCreationId=" + this.k);
        if (o0.d(this.j) == false) goto L29;
    L30:
        this.i = false;
        return;
    L29:
        if (o0.d(this.k) == true) goto L30;
        return;
    L22:
        r13 = null;
        goto L23
    L32:
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

    public final void onViewCreated(View r49, Bundle r50) {
        Intrinsics.checkNotNullParameter(r49, "view");
        super.onViewCreated(r49, r50);
        k1a.b.a(this, new i(this));
        zp9.l r2 = T90();
        if (r2 != null) goto L5;
        w0a.a.b("TemplateCreationListFragment[Kmp]", "ICreationFeedAbility not bound, skip initialize");
    L112:
        r49.post(new j(this));
        this.j = null;
        this.k = null;
        return;
    L5:
        Bundle r4 = getArguments();
        if (r4 == null) goto L8;
        String r5 = r4.getString("argBotId");
    L10:
        if (r5 != null) goto L12;
        String r9 = "";
    L14:
        if (U90() == true) goto L16;
    L26:
        CreationFeedCacheEntity r6 = null;
    L27:
        String r32 = "List_TemplateCreationList_Kmp_" + this.g;
        Bundle r7 = getArguments();
        if (r7 == null) goto L30;
        String r8 = r7.getString("recommend_from");
    L31:
        Bundle r10 = getArguments();
        if (r10 == null) goto L34;
        String r11 = r10.getString("argConversationId");
    L35:
        if (r11 != null) goto L37;
        String r12 = "";
    L38:
        Bundle r13 = getArguments();
        if (r13 == null) goto L41;
        Integer r14 = Integer.valueOf(r13.getInt("action_bar_template_id"));
    L42:
        Bundle r15 = getArguments();
        if (r15 == null) goto L45;
        String r16 = r15.getString("arg_chat_type");
    L46:
        if (r16 != null) goto L48;
        String r17 = "";
    L49:
        Bundle r18 = getArguments();
        if (r18 == null) goto L52;
        String r19 = r18.getString("enter_from");
    L53:
        Bundle r20 = getArguments();
        if (r20 == null) goto L56;
        String r21 = r20.getString("previous_page");
    L57:
        Bundle r22 = getArguments();
        if (r22 == null) goto L61;
        String r23 = r22.getString("enter_method");
        if (r23 == null) goto L61;
    L62:
        String r110 = r23;
        Bundle r24 = getArguments();
        if (r24 == null) goto L65;
        boolean r3 = r24.getBoolean("key_is_chat_double_page", false);
    L66:
        Boolean r111 = Boolean.valueOf(r3);
        Bundle r25 = getArguments();
        if (r25 == null) goto L69;
        String r112 = r25.getString("template_page_type");
    L70:
        zp9.g r33 = new zp9.g("template_page", r8, r9, r12, r14, r17, r19, r21, r110, "action_bar_template", r111, null, r112, null, null, null, null, null, null, null, null, null, 4188160);
        Bundle r26 = getArguments();
        if (r26 == null) goto L73;
        boolean r34 = r26.getBoolean("open_new_chat_page_on_send", false);
    L74:
        TabItemInfo r27 = this.f;
        Bundle r28 = getArguments();
        if (r28 == null) goto L77;
        int r113 = r28.getInt("key_template_list_bottom_padding");
    L78:
        Bundle r29 = getArguments();
        if (r29 == null) goto L81;
        boolean r30 = r29.getBoolean("key_show_user_info");
    L83:
        if (U90() == true) goto L85;
    L95:
        String r31 = null;
    L97:
        if (o0.d(this.j) == true) goto L99;
    L101:
        boolean r114 = false;
    L103:
        if (U90() == false) goto L110;
        Bundle r35 = getArguments();
        if (r35 == null) goto L107;
        boolean r36 = r35.getBoolean("key_disable_initial_auto_refresh_once", false);
    L108:
        if (r36 == false) goto L110;
        boolean r115 = true;
    L111:
        boolean r37 = r30;
        String r38 = r31;
        zp9.f r39 = new zp9.f(r114, r115, r32, false, r33, null, Integer.valueOf(r113), null, true, r27, null, false, null, null, null, r37, r38, r34, null, null, z2.a.creationFeedVideoAutoPlay(), false, null, null, Integer.valueOf(((Number) this.m.getValue()).intValue()), Boolean.TRUE, null, null, null, null, 1022131368);
        ICommunityService.Companion r116 = ICommunityService.a;
        int r40 = this.g;
        TabItemInfo r41 = this.f;
        String r42 = this.h;
        String r43 = this.j;
        String r117 = this.k;
        ICommunityFeedRequestSourceFactory.a r118 = ICommunityFeedRequestSourceFactory.a;
        Bundle r119 = getArguments();
        r118.getClass();
        r2.nh(r39, new zp9.e(r116.v1(r40, r41, r42, r43, r6, r117, false, ICommunityFeedRequestSourceFactory.a.a(r119)), this.e, null, this.d, 4));
        goto L112
    L107:
        r36 = false;
    L110:
        r115 = false;
        goto L111
    L99:
        if (o0.d(this.k) == false) goto L101;
        r114 = true;
        goto L103
    L85:
        if (this.i == false) goto L95;
        String r44 = this.h;
        if (r44 != null) goto L89;
    L92:
        boolean r120 = true;
    L93:
        if (r120 == false) goto L95;
        r31 = String.valueOf(this.g);
        goto L97
    L89:
        if (r44.length() == 0) goto L92;
        r120 = false;
        goto L93
    L81:
        r30 = false;
        goto L83
    L77:
        r113 = 0;
        goto L78
    L73:
        r34 = false;
        goto L74
    L69:
        r112 = null;
        goto L70
    L65:
        r3 = false;
    L61:
        r23 = "chat_action_bar";
        goto L62
    L56:
        r21 = null;
        goto L57
    L52:
        r19 = null;
        goto L53
    L48:
        r17 = r16;
        goto L49
    L45:
        r16 = null;
        goto L46
    L41:
        r14 = null;
        goto L42
    L37:
        r12 = r11;
        goto L38
    L34:
        r11 = null;
        goto L35
    L30:
        r8 = null;
        goto L31
    L16:
        if (this.i == false) goto L26;
        String r45 = this.h;
        if (r45 != null) goto L20;
    L23:
        boolean r46 = true;
    L24:
        if (r46 == false) goto L26;
        r6 = ICommunityService.a.b1(String.valueOf(this.g), true);
        goto L27
    L20:
        if (r45.length() == 0) goto L23;
        r46 = false;
        goto L24
    L12:
        r9 = r5;
        goto L14
    L8:
        r5 = null;
        goto L10
    }

    @Override // zp9.o
    public final void V60(boolean r8, boolean r9, Long r10) {
        zp9.l r0 = T90();
        if (r0 == null) goto L6;
        zp9.l.a.a(r0, r8, r9, r10, false, false, 24);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131563158, r3, false);
    }
}
