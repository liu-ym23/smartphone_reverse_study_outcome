package com.bytedance.android.live.livepkaudience.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkInitResult;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.android.material.tabs.TabLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkAdminInviteFragment;", "Lcom/bytedance/android/live/livepkaudience/dialog/PkWithAudienceDialogContract$View;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAdminInviteFragment extends PkWithAudienceDialogContract$View {
    public static final /* synthetic */ int w = 0;
    public View g;
    public ViewGroup h;
    public LinkNoScrollViewPager i;
    public AnonymousClass1 j;
    public boolean k;
    public PkWithAudienceSettingDialog l;
    public PkAudienceListApplyDialogFragment m;
    public PkGuestInviteContainerFragment n;
    public DataCenter o;
    public int p;
    public String q;
    public int r;
    public Room s;
    public boolean t;
    public final c u;
    public final d v;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PkAdminInviteFragment a;

        public b(PkAdminInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r5 != null) goto L6;
        L22:
            if (r5 != null) goto L25;
        L29:
            if (r5 != null) goto L32;
            return;
        L32:
            if (r5.intValue() != 2) goto L49;
            this.a.d.dismiss();
            int r6 = PkWithAudienceFeedbackDialog.m;
            int r7 = dl0.n.a();
            PkAdminInviteFragment r0 = this.a;
            PkWithAudienceFeedbackDialog r8 = PkWithAudienceFeedbackDialog.a.a(r7, r0.k, r0.q);
            FragmentActivity r1 = this.a.getContext();
            if (r1 == null) goto L41;
            FragmentManager r2 = r1.getSupportFragmentManager();
            LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "PkWithAudienceFeedbackDialog", r3);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r8, r3) == true) goto L52;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
        L39:
            r8.show(r2, "PkWithAudienceFeedbackDialog");
            return;
        L52:
            return;
        L41:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L49:
            return;
        L25:
            if (r5.intValue() != 1) goto L29;
            PkAdminInviteFragment r9 = this.a;
            int r10 = PkAdminInviteFragment.w;
            r9.getClass();
            com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r11 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r11 == null) goto L47;
            r11.cancelApply();
            return;
        L47:
            return;
        L6:
            if (r5.intValue() != 0) goto L22;
            String r12 = this.a.q;
            int r13 = r12.hashCode();
            if (r13 == (-1383228885)) goto L16;
            if (r13 == 3526149) goto L13;
        L18:
            int r14 = bh0.a.a;
            int r15 = 100;
        L19:
            com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r16 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r16 == null) goto L42;
            com.bytedance.android.live.livepkaudience.service.d.b.a(r16, 2, r15, "audience_admin_operate_click");
            return;
        L42:
            return;
        L13:
            if (r12.equals("seat") == false) goto L18;
            int r17 = bh0.a.a;
            r15 = 101;
            goto L19
        L16:
            if (r12.equals("bottom") == false) goto L18;
            int r18 = bh0.a.a;
            r15 = 102;
            goto L19
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ PkAdminInviteFragment a;

        public c(PkAdminInviteFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (r6 != null) goto L6;
        L11:
            if (r6 != null) goto L14;
        L19:
            if (r6 != null) goto L22;
            return;
        L22:
            if (r6.intValue() != 2) goto L30;
            ViewGroup r7 = this.a.h;
            if (r7 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("mTopView");
        L26:
            ((TextView) r7.findViewById(2131362297)).setText(2131919271);
            return;
        L30:
            return;
        L14:
            if (r6.intValue() != 1) goto L19;
            ViewGroup r8 = this.a.h;
            if (r8 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("mTopView");
        L18:
            ((TextView) r8.findViewById(2131362297)).setText(2131917526);
            return;
        L6:
            if (r6.intValue() != 0) goto L11;
            ViewGroup r9 = this.a.h;
            if (r9 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mTopView");
        L10:
            ((TextView) r9.findViewById(2131362297)).setText(2131917504);
        }
    }

    public static final class d implements com.bytedance.android.live.livepkaudience.base.f<Integer> {
        public final /* synthetic */ PkAdminInviteFragment a;

        public d(PkAdminInviteFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.f
        public final void run(Integer r3) {
            Integer r4 = r3;
            if (r4 == null) goto L10;
            int r5 = r4.intValue();
            LinkNoScrollViewPager r0 = this.a.i;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        L7:
            if (r0 == null) goto L11;
            r0.setCurrentItem(r5);
            return;
        L11:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final float S90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final String T90() {
        return "";
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup U90() {
        ViewGroup r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public PkAdminInviteFragment() {
        this.q = "";
        this.r = -1;
        this.u = new c(this);
        this.v = new d(this);
    }

    public final void V90() {
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L6;
    L11:
        if (r0 != null) goto L14;
    L19:
        if (r0 != null) goto L22;
    L27:
        ViewGroup r1 = this.h;
        if (r1 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L30:
        ((TextView) r1.findViewById(2131362297)).setOnClickListener(new b(this));
        hd0.c.f().c(this.u);
        return;
    L22:
        if (r0.intValue() != 2) goto L27;
        ViewGroup r2 = this.h;
        if (r2 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L26:
        ((TextView) r2.findViewById(2131362297)).setText(2131919271);
        goto L27
    L14:
        if (r0.intValue() != 1) goto L19;
        ViewGroup r3 = this.h;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L18:
        ((TextView) r3.findViewById(2131362297)).setText(2131917526);
        goto L27
    L6:
        if (r0.intValue() != 0) goto L11;
        ViewGroup r4 = this.h;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L10:
        ((TextView) r4.findViewById(2131362297)).setText(2131917504);
        goto L27
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        hd0.c.f().e(this.u);
    }

    /* JADX WARN: Type inference failed for: r9v9, types: [com.bytedance.android.live.livepkaudience.dialog.PkAdminInviteFragment$onCreateView$1] */
    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131565536, r10, false);
        this.g = r12;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        this.i = r12.findViewById(2131392847);
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r13 == null) goto L10;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L10;
        Room r15 = (Room) r14.getValue();
    L10:
        k0 r16 = this.d;
        if (r16 != null) goto L13;
        return null;
    L13:
        int r1 = PkAudienceListApplyDialogFragment.S;
        d r2 = this.v;
        DataCenter r3 = this.o;
        int r4 = this.r;
        Intrinsics.checkNotNullParameter(r16, "view");
        PkAudienceListApplyDialogFragment r5 = new PkAudienceListApplyDialogFragment();
        r5.K = r2;
        r5.d = r16;
        r5.u = r3;
        r5.M = r4;
        this.m = r5;
        int r17 = PkGuestInviteContainerFragment.l;
        k0 r18 = this.d;
        DataCenter r6 = this.o;
        boolean r7 = this.t;
        Intrinsics.checkNotNullParameter(r18, "dialog");
        PkGuestInviteContainerFragment r8 = new PkGuestInviteContainerFragment();
        r8.i = r6;
        r8.d = r18;
        r8.k = r7;
        this.n = r8;
        final FragmentManager r19 = getChildFragmentManager();
        this.j = new AnonymousClass1(this, r19);
        LinkNoScrollViewPager r20 = this.i;
        if (r20 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L16:
        r20.addOnPageChangeListener(new AnonymousClass2(this));
        LinkNoScrollViewPager r21 = this.i;
        if (r21 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L19:
        AnonymousClass1 r22 = this.j;
        if (r22 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mPagerAdapter");
    L22:
        r21.setAdapter(r22);
        LinkNoScrollViewPager r23 = this.i;
        if (r23 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L25:
        r23.setCurrentItem(this.p);
        View r24 = LayoutInflater.from(getContext()).inflate(2131565530, null);
        if (r24 == null) goto L142;
        ViewGroup r25 = (ViewGroup) r24;
        this.h = r25;
        TabLayout r26 = r25.findViewById(2131387986);
        r26.addTab(r26.newTab());
        r26.addTab(r26.newTab());
        View r27 = this.g;
        if (r27 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L30:
        r26.setupWithViewPager(r27.findViewById(2131392847));
        TabLayout.Tab r110 = r26.getTabAt(0);
        if (r110 == null) goto L35;
        TabLayout.Tab r111 = r110.setText(s1.B(2131918066));
        if (r111 == null) goto L35;
        r111.setTag(s1.B(2131918066));
    L35:
        TabLayout.Tab r28 = r26.getTabAt(1);
        if (r28 == null) goto L40;
        TabLayout.Tab r29 = r28.setText(s1.B(2131918073));
        if (r29 == null) goto L40;
        r29.setTag(s1.B(2131918073));
    L40:
        ViewGroup r30 = this.h;
        if (r30 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L43:
        ((FrameLayout) r30.findViewById(2131385953)).setOnClickListener(new com.bytedance.android.live.livepkaudience.dialog.c(this));
        com.bytedance.android.livesdk.sharedpref.e r31 = com.bytedance.android.livesdk.sharedpref.b.O1;
        if (((Boolean) r31.getValue()).booleanValue() == true) goto L55;
        Room r32 = this.s;
        if (r32 == null) goto L55;
        LinkInitResult r33 = r32.linkInitResult;
        if (r33 == null) goto L55;
        if (r33.isFirstInit() != true) goto L55;
        ViewGroup r34 = this.h;
        if (r34 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L54:
        r34.findViewById(2131385981).setVisibility(0);
        com.bytedance.android.livesdk.sharedpref.f.d(r31, Boolean.TRUE);
    L55:
        ViewGroup r35 = this.h;
        if (r35 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L58:
        r35.findViewById(2131366972).setOnClickListener(new com.bytedance.android.live.livepkaudience.dialog.d(this));
        if (this.k == false) goto L70;
        ViewGroup r36 = this.h;
        if (r36 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L63:
        UtilityKotlinExtentionsKt.t(r36.findViewById(2131375165));
        ViewGroup r37 = this.h;
        if (r37 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L66:
        ((LinearLayout) r37.findViewById(2131362589)).setVisibility(0);
        ViewGroup r38 = this.h;
        if (r38 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L69:
        ((TextView) r38.findViewById(2131362297)).setVisibility(8);
    L98:
        DataCenter r39 = this.o;
        if (r39 == null) goto L102;
        r39.put("data_video_talk_dot_with_number_show", "");
    L102:
        if (this.k == false) goto L120;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r40 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r40 == null) goto L108;
        com.bytedance.android.live.livepkaudience.base.i r41 = r40.getLinkUserCenter();
        if (r41 == null) goto L108;
        r41.f.clear();
        r41.f.addAll(r41.e);
    L108:
        com.bytedance.android.live.livepkaudience.service.b r42 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r42 == null) goto L137;
        com.bytedance.android.live.livepkaudience.base.i r43 = r42.getLinkUserCenter();
        if (r43 == null) goto L137;
        CopyOnWriteArrayList<LinkPlayerInfo> r44 = r43.e;
        if (r44 == null) goto L137;
        if (r44.size() != 0) goto L137;
        LinkNoScrollViewPager r45 = this.i;
        if (r45 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L119:
        r45.setCurrentItem(1);
    L137:
        View r46 = this.g;
        if (r46 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L140:
        return r46;
    L120:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r47 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r47 == null) goto L125;
        com.bytedance.android.live.livepkaudience.base.i r48 = r47.getLinkUserCenter();
        if (r48 == null) goto L125;
        r48.f.clear();
        r48.f.addAll(r48.e);
    L125:
        com.bytedance.android.live.livepkaudience.service.a r49 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r49 == null) goto L137;
        com.bytedance.android.live.livepkaudience.base.i r50 = r49.getLinkUserCenter();
        if (r50 == null) goto L137;
        CopyOnWriteArrayList<LinkPlayerInfo> r51 = r50.e;
        if (r51 == null) goto L137;
        if (r51.size() != 0) goto L137;
        LinkNoScrollViewPager r52 = this.i;
        if (r52 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L136:
        r52.setCurrentItem(1);
        goto L137
    L70:
        ViewGroup r53 = this.h;
        if (r53 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L73:
        UtilityKotlinExtentionsKt.t(r53.findViewById(2131375165));
        ViewGroup r54 = this.h;
        if (r54 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L76:
        ((LinearLayout) r54.findViewById(2131362589)).setVisibility(8);
        if (HostEnv.b() == false) goto L89;
        if (this.r == (-1)) goto L84;
        ViewGroup r55 = this.h;
        if (r55 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L83:
        ((TextView) r55.findViewById(2131362297)).setVisibility(8);
        goto L98
    L84:
        ViewGroup r56 = this.h;
        if (r56 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L87:
        ((TextView) r56.findViewById(2131362297)).setVisibility(0);
        V90();
        goto L98
    L89:
        if (HostEnv.a() == true) goto L94;
        ViewGroup r57 = this.h;
        if (r57 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L93:
        ((TextView) r57.findViewById(2131362297)).setVisibility(0);
    L94:
        V90();
        ViewGroup r58 = this.h;
        if (r58 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L97:
        r58.findViewById(2131366972).setVisibility(0);
        goto L98
    L142:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
