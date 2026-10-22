package com.larus.ugc.feed.impl.home;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.bmhome.z;
import com.larus.community.api.ICommunityService;
import com.larus.community.api.spi.ICommunityFeedRequestSourceFactory;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import zp9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001JB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020*2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u00020\u0012H\u0016J\u0012\u00103\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u00104\u001a\u00020$H\u0016J\u0012\u00105\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u00010&H\u0016J \u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00142\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020$2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u001dH\u0002J\u0010\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u001aH\u0016J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u001dH\u0016J'\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\b\u0010G\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0002\u0010IR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006K"}, d2 = {"Lcom/larus/ugc/feed/impl/home/CommunityListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "Lcom/larus/platform/api/creation/ICreationListener;", "Lcom/larus/platform/api/creation/ICreationFeedFragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setSharedPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "currentTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "currentTabPosition", "", "enableShowHeader", "", "enableShowBottomButton", "recommendType", "trackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "insertFirstUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "isChatMultiTab", "initRecommendation", "", "previousPage", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getCurrentPageName", "isCurrentRecommendTab", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initializeCreationFeedAbility", "tabIndex", "onEnterTab", "onLeaveTab", "onNewIntent", "bundle", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "handleMsg", "msg", "Landroid/os/Message;", "handleInsertFirstCreation", "scene", "onSetReferenceImagePublic", "userCreation", "onRemoveUserCreation", "creationId", "scrollToTopAndRefresh", "notScrollToTop", "notRefresh", "smoothScrollDuration", "", "(ZZLjava/lang/Long;)V", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommunityListFragment extends Fragment implements WeakHandler.IHandler, s19.a, z, r, zp9.o {
    public static final /* synthetic */ int m = 0;
    public RecyclerView.RecycledViewPool d;
    public TabItemInfo e;
    public int f;
    public int g;
    public zp9.g h;
    public UserCreation i;
    public boolean j;
    public String k;
    public String l;

    public static final class a {
    }

    static {
    }

    public final void handleMsg(Message r1) {
    }

    public final void pp(String r1) {
    }

    public final void t1() {
    }

    public final boolean U90() {
        TabItemInfo r0 = this.e;
        if (r0 == null) goto L5;
        String r1 = r0.getId();
    L7:
        if (this.e != null) goto L9;
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

    public CommunityListFragment() {
        this.g = 1;
    }

    public final zp9.l S90() {
        return (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
    }

    public final int sb() {
        return this.f;
    }

    public final void T90(String r3) {
        UserCreation r0 = this.i;
        if (r0 == null) goto L9;
        boolean r1 = w0a.a.a;
        w0a.a.c("CommunityListFragment[Kmp]", "handlePublishSuccess:".concat(r3));
        zp9.l r4 = S90();
        if (r4 == null) goto L7;
        r4.xc(r0);
    L7:
        this.i = null;
        return;
    }

    @Override // zp9.r
    public final void X0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "creationId");
        zp9.l r0 = S90();
        if (r0 == null) goto L6;
        r0.deleteUserCreation(r3, false);
        return;
    }

    public final void a2(Bundle r8) {
        zp9.g r0 = this.h;
        if (r0 == null) goto L13;
        if (r8 == null) goto L8;
        String r1 = r8.getString("enter_method");
        if (r1 == null) goto L8;
    L11:
        r0.i = r1;
    L8:
        if (this.j == false) goto L10;
        r1 = "create_feed_top_tab";
        goto L11
    L10:
        r1 = "create_feed";
    L13:
        if (U90() == false) goto L33;
        UserCreation r2 = null;
        if (r8 == null) goto L17;
        String r3 = r8.getString("related_recommendation");
    L18:
        if (r8 == null) goto L20;
        String r4 = r8.getString("related_creation_id");
    L22:
        if (o0.d(r3) == false) goto L24;
    L29:
        zp9.l r5 = S90();
        if (r5 == null) goto L35;
        zp9.l.a.a(r5, false, false, null, false, false, 31);
        return;
    L35:
        return;
    L24:
        if (o0.d(r4) == true) goto L29;
        if (r8 == null) goto L28;
        r2 = (UserCreation) r8.getParcelable("creation");
    L28:
        this.i = r2;
        T90("onPublishSuccess");
        return;
    L20:
        r4 = null;
        goto L22
    L17:
        r3 = null;
        goto L18
    }

    @Override // zp9.r
    public final void bZ(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void onCreate(Bundle r29) {
        super.onCreate(r29);
        w0a.a.a("CommunityListFragment[Kmp]", new o(this));
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        int r2 = r1.getInt("position");
    L6:
        this.f = r2;
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        r3.getBoolean("key_enable_show_header");
    L9:
        Bundle r4 = getArguments();
        if (r4 == null) goto L12;
        r4.getBoolean("key_show_bottom_button");
    L12:
        Bundle r5 = getArguments();
        String r6 = null;
        if (r5 == null) goto L15;
        UserCreation r7 = (UserCreation) r5.getParcelable("creation");
    L16:
        this.i = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L19;
        String r9 = r8.getString("related_recommendation");
    L20:
        this.k = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L23;
        r6 = r10.getString("previous_page");
    L23:
        this.l = r6;
        boolean r11 = ci8.e.b(this);
        this.j = r11;
        if (r11 == false) goto L26;
        this.g = 6;
    L26:
        String r12 = "create_feed_top_tab";
        if (r11 == false) goto L29;
        String r14 = "create_feed_top_tab";
    L30:
        String r13 = this.l;
        if (r11 == true) goto L34;
        r12 = "ai_generate";
    L34:
        String r15 = r12;
        Bundle r16 = getArguments();
        if (r16 == null) goto L40;
        String r17 = r16.getString("enter_method");
        if (r17 == null) goto L40;
        String r18 = r17;
    L41:
        this.h = new zp9.g(r15, r14, null, null, null, null, r14, r13, r18, r14, null, null, null, null, null, null, null, null, null, null, null, null, 4193340);
        return;
    L40:
        r18 = r14;
        goto L41
    L29:
        r14 = "create_feed";
        goto L30
    L19:
        r9 = null;
        goto L20
    L15:
        r7 = null;
        goto L16
    L5:
        r2 = 0;
        goto L6
    }

    public final void y2(String r2) {
        this.l = r2;
        zp9.g r0 = this.h;
        if (r0 == null) goto L6;
        r0.h = r2;
        return;
    }

    @Override // zp9.r
    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        zp9.l r0 = S90();
        if (r0 == null) goto L6;
        r0.CO(r2);
        return;
    }

    public final void KC(boolean r8, Function0<Unit> r9) {
        zp9.l r0 = S90();
        if (r0 == null) goto L6;
        zp9.l.a.a(r0, false, false, null, false, false, 31);
        return;
    }

    public final void onViewCreated(View r38, Bundle r39) {
        Intrinsics.checkNotNullParameter(r38, "view");
        super.onViewCreated(r38, r39);
        Bundle r1 = getArguments();
        String r2 = null;
        if (r1 == null) goto L5;
        TabItemInfo r3 = (TabItemInfo) r1.getParcelable("key_tab_item_info");
    L6:
        this.e = r3;
        k1a.b.a(this, new p(this));
        zp9.l r4 = S90();
        if (r4 != null) goto L9;
        w0a.a.b("CommunityListFragment[Kmp]", "ICreationFeedAbility not bound, skip initialize");
    L40:
        T90("init");
        return;
    L9:
        zp9.g r8 = this.h;
        if (r8 == null) goto L40;
        ICommunityService.Companion r5 = ICommunityService.a;
        int r10 = this.g;
        TabItemInfo r11 = this.e;
        if (U90() == false) goto L15;
        String r13 = this.k;
    L16:
        ICommunityFeedRequestSourceFactory.a r6 = ICommunityFeedRequestSourceFactory.a;
        Bundle r7 = getArguments();
        r6.getClass();
        zp9.n r35 = r5.v1(r10, r11, null, r13, null, null, true, ICommunityFeedRequestSourceFactory.a.a(r7));
        StringBuilder r9 = new StringBuilder("List_CommunityCreateKmp_");
        TabItemInfo r12 = this.e;
        if (r12 == null) goto L19;
        String r14 = r12.getName();
    L20:
        r9.append(r14);
        r9.append('_');
        TabItemInfo r15 = this.e;
        if (r15 == null) goto L23;
        String r16 = r15.getId();
    L24:
        r9.append(r16);
        String r17 = r9.toString();
        int r18 = i5.s0();
        TabItemInfo r19 = this.e;
        boolean r110 = r5.f1().g();
        if (U90() == false) goto L27;
        r2 = String.valueOf(this.g);
    L27:
        String r20 = r2;
        boolean r21 = false;
        if (U90() == false) goto L35;
        Bundle r22 = getArguments();
        if (r22 == null) goto L32;
        boolean r23 = r22.getBoolean("key_disable_initial_auto_refresh_once", false);
    L33:
        if (r23 == false) goto L35;
        boolean r24 = true;
    L36:
        boolean r25 = !this.j;
        if (U90() == false) goto L39;
        r21 = o0.d(this.k);
    L39:
        r4.nh(new zp9.f(r21, r24, r17, false, r8, 4, Integer.valueOf(r18), null, false, r19, null, false, null, null, null, r110, r20, r25, null, null, true, false, null, null, null, Boolean.TRUE, null, null, null, null, 1038908808), new zp9.e(r35, null, null, this.d, 6));
        goto L40
    L32:
        r23 = false;
    L35:
        r24 = false;
        goto L36
    L23:
        r16 = null;
        goto L24
    L19:
        r14 = null;
        goto L20
    L15:
        r13 = null;
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    @Override // zp9.o
    public final void V60(boolean r8, boolean r9, Long r10) {
        zp9.l r0 = S90();
        if (r0 == null) goto L6;
        zp9.l.a.a(r0, r8, r9, r10, false, false, 24);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561924, r3, false);
    }

    @Override // zp9.r
    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        r.a.a(r1, r6);
    }
}
