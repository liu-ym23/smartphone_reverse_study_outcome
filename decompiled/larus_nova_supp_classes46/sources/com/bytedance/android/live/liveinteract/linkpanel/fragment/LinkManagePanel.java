package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.contract.AudioTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.widget.LinkApplyListWidget;
import com.bytedance.android.live.liveinteract.linkpanel.widget.LinkInviteListWidget;
import com.bytedance.android.live.liveinteract.linkpanel.widget.LinkPanelTopBarWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.liveMultiAudioAdminPrivilegeConfig;
import com.bytedance.android.livesdk.config.sa0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.config.up;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.google.android.material.tabs.TabLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/LinkManagePanel;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/AudioTalkDialogContract$View;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkManagePanel extends AudioTalkDialogContract$View {
    public static final /* synthetic */ int w = 0;
    public View g;
    public LinkNoScrollViewPager h;
    public LinkManagePanel$switch2Link$1 i;
    public LinkApplyContainerFragment j;
    public LinkInviteContainerFragment k;
    public LinkPanelTopBarWidget l;
    public boolean m;
    public int n;
    public String o;
    public DataCenter p;
    public DataContext q;
    public int r;
    public final Lazy s;
    public final Function1<Integer, Unit> t;
    public final Function1<Integer, Unit> u;
    public final b v;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.liveinteract.component.a<Integer> {
        public final /* synthetic */ LinkManagePanel a;

        public b(LinkManagePanel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.component.a
        public final void run(Integer r3) {
            Integer r4 = r3;
            if (r4 == null) goto L9;
            int r5 = r4.intValue();
            LinkNoScrollViewPager r0 = this.a.h;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        L7:
            r0.setCurrentItem(r5);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        LinkPanelTopBarWidget r0 = this.l;
        if (r0 == null) goto L7;
        ViewGroup r1 = r0.b;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
        return r1;
    L9:
        return r1;
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final void Y90() {
        LinkApplyContainerFragment r0 = this.j;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        LinkInviteContainerFragment r1 = this.k;
        if (r1 == null) goto L9;
        r1.onResume();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final void Z90() {
        LinkApplyContainerFragment r0 = this.j;
        if (r0 == null) goto L5;
        r0.onPause();
    L5:
        LinkInviteContainerFragment r1 = this.k;
        if (r1 == null) goto L9;
        r1.onPause();
        return;
    }

    public LinkManagePanel() {
        this.o = "";
        this.r = -1;
        this.s = LazyKt.lazy(new LinkManagePanel$onPageChangeListener$2(this));
        this.t = new LinkManagePanel$voiceChatWaitingListListener$1(this);
        this.u = new LinkManagePanel$videoTalkWaitingListListener$1(this);
        this.v = new b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r0 == null) goto L5;
        r0.eq(this.t);
    L5:
        ILinkPanelService r1 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r1 == null) goto L8;
        r1.k50(this.u);
    L8:
        t61 r2 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r2 != null) goto L11;
        return;
    L11:
        if (u61.c(r2) != true) goto L21;
        LinkNoScrollViewPager r3 = this.h;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L15:
        r3.removeOnPageChangeListener((LinkManagePanel$onPageChangeListener$2.AnonymousClass1) this.s.getValue());
        LinkNoScrollViewPager r4 = this.h;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L18:
        r4.setAdapter(null);
        this.j = null;
        this.k = null;
        this.l = null;
        this.d = null;
        this.i = null;
        return;
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        LinkPanelTopBarWidget r0 = this.l;
        if (r0 == null) goto L6;
        hd0.c.f().e(r0.d);
        r0.i = null;
        return;
    }

    public final void onResume() {
        super.onResume();
        LinkPanelTopBarWidget r0 = this.l;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final void aa0(int r7) {
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        Map<String, cm2.a> r0 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.g("apply_panel", r7);
        com.bytedance.android.live.liveinteract.linkpanel.util.p.g("invite_panel", r7);
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        if (r7 != 0) goto L17;
        LinkApplyContainerFragment r8 = this.j;
        if (r8 != null) goto L7;
    L12:
        LinkInviteContainerFragment r9 = this.k;
        if (r9 == null) goto L32;
        r9.m = false;
        LinkInviteListWidget r10 = r9.g;
        if (r10 == null) goto L33;
        r10.s = false;
        r10.Eq();
        return;
    L33:
        return;
    L32:
        return;
    L7:
        if (r8.f != null) goto L9;
        int r2 = LinkApplyListWidget.O;
        yf0.g r3 = r8.e;
        int r4 = r8.h;
        com.bytedance.android.live.liveinteract.component.a<Integer> r5 = r8.d;
        LinkApplyListWidget r6 = new LinkApplyListWidget();
        r6.a = r3;
        r6.d = r5;
        r6.g = r4;
        r8.f = r6;
    L9:
        LinkApplyListWidget r11 = r8.f;
        if (r11 == null) goto L12;
        r11.E = true;
        r11.Fq();
        goto L12
    L17:
        if (r7 != 1) goto L35;
        LinkApplyContainerFragment r12 = this.j;
        if (r12 != null) goto L21;
    L26:
        LinkInviteContainerFragment r13 = this.k;
        if (r13 == null) goto L36;
        r13.m = true;
        LinkInviteListWidget r14 = r13.g;
        if (r14 == null) goto L37;
        r14.s = true;
        r14.Eq();
        return;
    L37:
        return;
    L36:
        return;
    L21:
        if (r12.f != null) goto L23;
        int r15 = LinkApplyListWidget.O;
        yf0.g r16 = r12.e;
        int r17 = r12.h;
        com.bytedance.android.live.liveinteract.component.a<Integer> r18 = r12.d;
        LinkApplyListWidget r19 = new LinkApplyListWidget();
        r19.a = r16;
        r19.d = r18;
        r19.g = r17;
        r12.f = r19;
    L23:
        LinkApplyListWidget r20 = r12.f;
        if (r20 == null) goto L26;
        r20.E = false;
        r20.Fq();
        goto L26
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.bytedance.android.live.liveinteract.linkpanel.fragment.LinkManagePanel$switch2Link$1] */
    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        boolean r3 = false;
        View r1 = r18.inflate(2131565505, r19, false);
        this.g = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        this.h = r1.findViewById(2131392847);
        Context r5 = requireContext();
        DataCenter r6 = this.p;
        DataContext r7 = this.q;
        LinkNoScrollViewPager r8 = this.h;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L8:
        this.l = new LinkPanelTopBarWidget(r5, r6, r7, r8, this.d, this.r, this.m, this.o);
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        int r2 = LinkApplyContainerFragment.i;
        yf0.g r4 = this.d;
        int r9 = this.r;
        b r10 = this.v;
        Intrinsics.checkNotNullParameter(r10, "callback");
        LinkApplyContainerFragment r11 = new LinkApplyContainerFragment();
        r11.e = r4;
        r11.d = r10;
        r11.h = r9;
        this.j = r11;
        int r12 = LinkInviteContainerFragment.n;
        yf0.g r13 = this.d;
        DataCenter r14 = this.p;
        int r15 = this.r;
        String r16 = this.o;
        LinkInviteContainerFragment r17 = new LinkInviteContainerFragment();
        r17.i = r14;
        r17.d = r13;
        r17.k = r15;
        r17.l = r16;
        this.k = r17;
        DataCenter r21 = this.p;
        if (r21 == null) goto L11;
        r21.put("data_audio_talk_dot_with_number_show", "");
    L11:
        DataCenter r22 = this.p;
        if (r22 == null) goto L14;
        r22.put("data_video_talk_dot_with_number_show", "");
    L14:
        final FragmentManager r23 = getChildFragmentManager();
        this.i = new LinkManagePanel$switch2Link$1(this, r23);
        LinkNoScrollViewPager r24 = this.h;
        if (r24 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L17:
        r24.addOnPageChangeListener((LinkManagePanel$onPageChangeListener$2.AnonymousClass1) this.s.getValue());
        LinkNoScrollViewPager r25 = this.h;
        if (r25 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L20:
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        r25.setOffscreenPageLimit(2);
        LinkNoScrollViewPager r26 = this.h;
        if (r26 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L23:
        r26.setAdapter(this.i);
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        LinkNoScrollViewPager r27 = this.h;
        if (r27 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L26:
        r27.setCurrentItem(this.n);
        aa0(this.n);
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == false) goto L62;
        ILinkPanelService r28 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r28 == null) goto L32;
        r28.X40(this.t);
    L32:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L99;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r29 = IVoiceChatAdminService.a.a();
        if (r29 == null) goto L38;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r30 = r29.getLinkUserInfoCenter();
        if (r30 == null) goto L38;
        r30.X4();
    L38:
        IVoiceChatAdminService r31 = IVoiceChatAdminService.a.a();
        if (r31 == null) goto L47;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r32 = r31.getLinkUserInfoCenter();
        if (r32 == null) goto L47;
        List<T> r33 = r32.a();
        if (r33 == 0) goto L47;
        ILinkPanelService r34 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r34 == null) goto L47;
        r34.NO(r33.size());
    L47:
        IKtvService r35 = jc1.k.f(IKtvService.class);
        if (r35 == null) goto L52;
        com.bytedance.android.live.liveinteract.plantform.base.i r36 = r35.getLinkUserInfoCenter();
        if (r36 == null) goto L52;
        r36.X4();
    L52:
        IKtvService r37 = jc1.k.f(IKtvService.class);
        if (r37 == null) goto L99;
        com.bytedance.android.live.liveinteract.plantform.base.i r38 = r37.getLinkUserInfoCenter();
        if (r38 == null) goto L99;
        List r39 = r38.a();
        if (r39 == null) goto L99;
        ILinkPanelService r40 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r40 == null) goto L99;
        r40.NO(r39.size());
    L99:
        LinkPanelTopBarWidget r41 = this.l;
        if (r41 == null) goto L404;
        com.bytedance.live.datacontext.m r42 = com.bytedance.android.live.liveinteract.api.utils.m.g(r41.g).I1();
        if (r42 == null) goto L106;
        Boolean r43 = (Boolean) r42.getValue();
        if (r43 == null) goto L106;
        boolean r44 = r43.booleanValue();
    L107:
        r41.a = r44;
        View r45 = LayoutInflater.from(r41.e).inflate(2131565508, null);
        if (r45 == null) goto L403;
        ViewGroup r46 = (ViewGroup) r45;
        r41.b = r46;
        TabLayout r47 = r46.findViewById(2131387986);
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        r47.addTab(r47.newTab());
        r47.addTab(r47.newTab());
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        r47.setupWithViewPager(r41.h);
        com.bytedance.android.live.liveinteract.linkpanel.util.o.n();
        TabLayout.Tab r48 = r47.getTabAt(0);
        if (r48 == null) goto L114;
        TabLayout.Tab r49 = r48.setText(com.bytedance.android.live.core.utils.s1.B(2131918066));
        if (r49 == null) goto L114;
        r49.setTag(com.bytedance.android.live.core.utils.s1.B(2131918066));
    L114:
        TabLayout.Tab r50 = r47.getTabAt(1);
        if (r50 == null) goto L120;
        TabLayout.Tab r51 = r50.setText(com.bytedance.android.live.core.utils.s1.B(2131918073));
        if (r51 == null) goto L120;
        r51.setTag(com.bytedance.android.live.core.utils.s1.B(2131918073));
    L120:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.B() == false) goto L126;
        TabLayout.Tab r52 = r47.getTabAt(2);
        if (r52 == null) goto L126;
        TabLayout.Tab r53 = r52.setText(com.bytedance.android.live.core.utils.s1.B(2131922790));
        if (r53 == null) goto L126;
        r53.setTag(com.bytedance.android.live.core.utils.s1.B(2131922790));
    L126:
        ViewGroup r54 = r41.b;
        if (r54 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L129:
        ((FrameLayout) r54.findViewById(2131363421)).setVisibility(0);
        ViewGroup r55 = r41.b;
        if (r55 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L132:
        r55.findViewById(2131385953).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.widget.t(r41));
        ViewGroup r56 = r41.b;
        if (r56 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L135:
        ((FrameLayout) r56.findViewById(2131377831)).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.widget.u(r41));
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == false) goto L158;
        if (vm2.d.D() == false) goto L150;
        if (r41.j < 0) goto L145;
        ViewGroup r57 = r41.b;
        if (r57 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L144:
        r57.findViewById(2131366972).setVisibility(8);
        goto L150
    L145:
        ViewGroup r58 = r41.b;
        if (r58 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L148:
        r58.findViewById(2131366972).setVisibility(0);
    L150:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L152;
    L237:
        ViewGroup r59 = r41.b;
        if (r59 != null) goto L240;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L240:
        r59.findViewById(2131366972).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.widget.v(r41));
        Ref.IntRef r60 = new Ref.IntRef();
        int r110 = r41.j;
        int r111 = com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
        int r112 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurUILayout();
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() != null) goto L243;
    L245:
        if (r111 != 8) goto L248;
    L255:
        r110 = r110 + 1;
    L256:
        r60.element = r110;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.D() == true) goto L259;
    L264:
        int r61 = r60.element + 1;
    L265:
        ViewGroup r113 = r41.b;
        if (r113 != null) goto L268;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L268:
        ((TextView) r113.findViewById(2131381002)).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.widget.w(r41, r60));
        if (r41.k == false) goto L302;
        ViewGroup r62 = r41.b;
        if (r62 != null) goto L273;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L273:
        ((LinearLayout) r62.findViewById(2131362589)).setVisibility(0);
        ViewGroup r63 = r41.b;
        if (r63 != null) goto L276;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L276:
        ((TextView) r63.findViewById(2131362297)).setVisibility(8);
        int r65 = r41.j;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 29) goto L279;
        boolean r114 = true;
    L281:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.l.a() == false) goto L377;
        if (r65 < 0) goto L377;
        if (r114 == true) goto L377;
        ViewGroup r66 = r41.b;
        if (r66 != null) goto L287;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L287:
        UtilityKotlinExtentionsKt.w(r66.findViewById(2131385956));
        ViewGroup r67 = r41.b;
        if (r67 != null) goto L290;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L290:
        UtilityKotlinExtentionsKt.w(r67.findViewById(2131371380));
        ViewGroup r68 = r41.b;
        if (r68 != null) goto L293;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L293:
        ((TextView) r68.findViewById(2131371380)).setText(com.bytedance.android.live.core.utils.s1.C(2131917607, new Object[]{Integer.valueOf(r61)}));
        ViewGroup r69 = r41.b;
        if (r69 != null) goto L296;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L296:
        ((TextView) r69.findViewById(2131371380)).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.widget.x(r41, r60));
        if (((IInteractService) jc1.k.n(IInteractService.class)).isVoiceMultiEnlargeSeat(com.bytedance.android.live.liveinteract.linkpanel.util.o.d(), r41.j) == false) goto L377;
        ViewGroup r70 = r41.b;
        if (r70 != null) goto L301;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L301:
        ((TextView) r70.findViewById(2131371380)).setText(com.bytedance.android.live.core.utils.s1.B(2131919004));
    L377:
        ViewGroup r71 = r41.b;
        if (r71 != null) goto L380;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L380:
        UtilityKotlinExtentionsKt.t(r71.findViewById(2131375165));
        ViewGroup r72 = r41.b;
        if (r72 != null) goto L383;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L383:
        UtilityKotlinExtentionsKt.t(r72.findViewById(2131375166));
        ViewGroup r73 = r41.b;
        if (r73 != null) goto L386;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L386:
        UtilityKotlinExtentionsKt.w(r73.findViewById(2131377831));
        ViewGroup r74 = r41.b;
        if (r74 != null) goto L389;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L389:
        UtilityKotlinExtentionsKt.t(r74.findViewById(2131385953));
        if (jc0.a.a() == false) goto L396;
        ViewGroup r75 = r41.b;
        if (r75 != null) goto L394;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L394:
        UtilityKotlinExtentionsKt.t(r75.findViewById(2131377831));
    L396:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 29) goto L404;
        LinkAudienceApi r76 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r77 = com.bytedance.android.live.liveinteract.linkpanel.util.o.b();
        if (r77 == null) goto L400;
        long r78 = r77.getId();
    L401:
        r41.c.add(r76.interactList(r78).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.linkpanel.widget.q(r41), com.bytedance.android.live.liveinteract.linkpanel.widget.r.a));
        goto L404
    L400:
        r78 = 0;
        goto L401
    L279:
        r114 = false;
        goto L281
    L302:
        ViewGroup r79 = r41.b;
        if (r79 != null) goto L305;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L305:
        ((LinearLayout) r79.findViewById(2131362589)).setVisibility(8);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.A0.getValue()).booleanValue() == true) goto L308;
    L310:
        boolean r80 = false;
    L312:
        if (r41.j == (-1)) goto L335;
        if (r80 == true) goto L335;
        ViewGroup r81 = r41.b;
        if (r81 != null) goto L317;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L317:
        ((TextView) r81.findViewById(2131362297)).setVisibility(8);
        ViewGroup r82 = r41.b;
        if (r82 != null) goto L320;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L320:
        ((TextView) r82.findViewById(2131381002)).setVisibility(0);
        ViewGroup r83 = r41.b;
        if (r83 != null) goto L323;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L323:
        ((TextView) r83.findViewById(2131381002)).setText(com.bytedance.android.live.core.utils.s1.C(2131918050, new Object[]{String.valueOf(r61)}));
        if (((IInteractService) jc1.k.n(IInteractService.class)).isVoiceMultiEnlargeSeat(com.bytedance.android.live.liveinteract.linkpanel.util.o.d(), r41.j) == false) goto L330;
        ViewGroup r84 = r41.b;
        if (r84 != null) goto L328;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L328:
        ((TextView) r84.findViewById(2131381002)).setVisibility(8);
    L330:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isVoiceRadioLink() == false) goto L336;
        ViewGroup r85 = r41.b;
        if (r85 != null) goto L334;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L334:
        ((TextView) r85.findViewById(2131381002)).setVisibility(8);
        r41.xq();
    L336:
        sa0 r86 = sa0.a;
        boolean r87 = ((liveMultiAudioAdminPrivilegeConfig) r86.getValue()).getOpen();
        List r88 = ((liveMultiAudioAdminPrivilegeConfig) r86.getValue()).getPrivileges();
        if (r88 == null) goto L358;
        List r89 = r88;
        if ((r89 instanceof Collection) == true) goto L341;
    L343:
        Iterator r90 = r89.iterator();
    L345:
        if (r90.hasNext() == false) goto L356;
        int r115 = ((Number) r90.next()).intValue();
        List r116 = jc1.k.n(IMiddlewareUserService.class).user().q().getAdminPrivileges();
        if (r116 == null) goto L353;
        Set r117 = CollectionsKt.toSet(r116);
        if (r117 == null) goto L353;
        if (r117.contains(Integer.valueOf(r115)) != true) goto L353;
        boolean r118 = true;
    L354:
        if (r118 == false) goto L345;
        boolean r91 = true;
    L357:
        Boolean r92 = Boolean.valueOf(r91);
    L359:
        if (r87 == false) goto L377;
        if (Intrinsics.areEqual(r92, Boolean.TRUE) == false) goto L377;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.c() == 5) goto L365;
    L367:
        if (r3 == false) goto L377;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.I() == false) goto L377;
        ViewGroup r93 = r41.b;
        if (r93 != null) goto L373;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L373:
        UtilityKotlinExtentionsKt.w(r93.findViewById(2131362302));
        ViewGroup r94 = r41.b;
        if (r94 != null) goto L376;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L376:
        ((FrameLayout) r94.findViewById(2131362302)).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.widget.s(r41));
        goto L377
    L365:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L367;
        r3 = true;
    L353:
        r118 = false;
    L356:
        r91 = false;
        goto L357
    L341:
        if (r89.isEmpty() == false) goto L343;
    L358:
        r92 = null;
    L335:
        r41.xq();
        goto L336
    L308:
        if (vm2.d.E0() == false) goto L310;
        r80 = true;
        goto L312
    L259:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.c() != 12) goto L261;
        boolean r95 = true;
    L262:
        if (r95 == true) goto L264;
        r61 = r60.element;
        goto L265
    L261:
        r95 = false;
        goto L262
    L248:
        if (r112 == 24) goto L256;
        if (r111 != 5) goto L256;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(com.bytedance.android.live.liveinteract.api.utils.m.j(r41).getCurrentRoom()) == true) goto L256;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.F(r112) == false) goto L256;
    L243:
        if (yg0.h.i(r112) != true) goto L245;
    L152:
        if (r41.k == false) goto L237;
        ViewGroup r96 = r41.b;
        if (r96 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L156:
        r96.findViewById(2131366972).setVisibility(0);
        goto L237
    L158:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L160;
        Boolean r97 = Boolean.valueOf(com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.d());
    L162:
        if (r41.j < 0) goto L226;
        com.bytedance.live.datacontext.j r119 = com.bytedance.android.live.liveinteract.api.utils.m.e(r41).getVideoTalkRoomSubScene();
        if (r119 == null) goto L226;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r120 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r119.getValue();
        if (r120 == null) goto L226;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r121 = r120.t();
        if (r121 == null) goto L226;
        if (r121.a != 12) goto L226;
        if (Intrinsics.areEqual(r97, Boolean.TRUE) == false) goto L194;
        if (((Boolean) up.a.getValue()).booleanValue() == false) goto L184;
        int r98 = com.bytedance.android.live.liveinteract.linkpanel.util.l.a;
        int r99 = com.bytedance.android.live.liveinteract.linkpanel.util.o.d();
        if (r99 == 11) goto L182;
        if (r99 == 12) goto L182;
        if (r99 == 3) goto L182;
        boolean r100 = false;
    L183:
        if (r100 == true) goto L194;
    L182:
        r100 = true;
    L184:
        ViewGroup r101 = r41.b;
        if (r101 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L187:
        r101.findViewById(2131366972).setVisibility(0);
        ViewGroup r102 = r41.b;
        if (r102 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L190:
        View r103 = r102.findViewById(2131391659);
        if (r103 == null) goto L237;
        r103.setVisibility(8);
    L194:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.l.a() == false) goto L199;
        ViewGroup r104 = r41.b;
        if (r104 != null) goto L198;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L198:
        r104.findViewById(2131366972).setVisibility(8);
        goto L237
    L199:
        rj0.k.m2.getClass();
        rj0.k r105 = rj0.k.a.a();
        if (r105 == null) goto L204;
        zj0.d r106 = r105.U1();
        if (r106 == null) goto L204;
        Integer r107 = Integer.valueOf(r106.b);
    L210:
        if (r107 != null) goto L213;
    L215:
        boolean r108 = false;
    L216:
        if (r108 == false) goto L221;
        ViewGroup r109 = r41.b;
        if (r109 != null) goto L220;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L220:
        r109.findViewById(2131366972).setVisibility(0);
        goto L237
    L221:
        ViewGroup r122 = r41.b;
        if (r122 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L224:
        r122.findViewById(2131366972).setVisibility(8);
        goto L237
    L213:
        if (r107.intValue() != 4) goto L215;
        r108 = true;
    L204:
        rj0.l.n2.getClass();
        rj0.l r123 = rj0.l.a.a();
        if (r123 == null) goto L209;
        zj0.d r124 = r123.U1();
        if (r124 == null) goto L209;
        r107 = Integer.valueOf(r124.b);
    L209:
        r107 = null;
    L226:
        if (r41.j >= 0) goto L228;
    L233:
        ViewGroup r125 = r41.b;
        if (r125 != null) goto L236;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L236:
        r125.findViewById(2131366972).setVisibility(0);
        goto L237
    L228:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.l.a() == false) goto L233;
        ViewGroup r126 = r41.b;
        if (r126 != null) goto L232;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L232:
        r126.findViewById(2131366972).setVisibility(8);
        goto L237
    L160:
        r97 = null;
        goto L162
    L403:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L106:
        r44 = false;
    L404:
        View r127 = this.g;
        if (r127 != null) goto L407;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L407:
        return r127;
    L62:
        if (gh0.a.d() == false) goto L80;
        rj0.k.m2.getClass();
        rj0.k r128 = rj0.k.a.a();
        if (r128 == null) goto L68;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r129 = r128.getLinkUserInfoCenter();
        if (r129 == null) goto L68;
        r129.X4();
    L68:
        rj0.k r130 = rj0.k.a.a();
        if (r130 == null) goto L99;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r131 = r130.getLinkUserInfoCenter();
        if (r131 == null) goto L99;
        List<T> r132 = r131.a();
        if (r132 == 0) goto L99;
        if (r132.size() != 0) goto L99;
        LinkNoScrollViewPager r133 = this.h;
        if (r133 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L79:
        r133.setCurrentItem(1);
        goto L99
    L80:
        ILinkPanelService r134 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r134 == null) goto L84;
        r134.Tp(this.u);
    L84:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L99;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r135 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r135 == null) goto L90;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r136 = r135.getLinkUserInfoCenter();
        if (r136 == null) goto L90;
        r136.X4();
    L90:
        com.bytedance.android.live.liveinteract.plantform.base.k r137 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r137 == null) goto L99;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r138 = r137.getLinkUserInfoCenter();
        if (r138 == null) goto L99;
        List<T> r139 = r138.a();
        if (r139 == 0) goto L99;
        ILinkPanelService r140 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r140 == null) goto L99;
        r140.T60(r139.size());
        goto L99
    }
}
