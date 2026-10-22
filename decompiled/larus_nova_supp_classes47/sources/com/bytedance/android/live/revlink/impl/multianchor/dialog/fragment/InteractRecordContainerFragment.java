package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractLinkRecordFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordFragment;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.android.material.tabs.TabLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/InteractRecordContainerFragment;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/RevInteractDialogFragmentBaseContract$View;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/g;", "Lcom/bytedance/android/livesdk/widget/LinkNoScrollViewPager$a;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractRecordContainerFragment extends RevInteractDialogFragmentBaseContract$View<com.bytedance.android.live.revlink.impl.control.dialog.g<?>> implements LinkNoScrollViewPager.a {
    public static final /* synthetic */ int o = 0;
    public Map<Integer, View> g;
    public DataCenter h;
    public InteractPkRecordFragment i;
    public InteractLinkRecordFragment j;
    public final int k;
    public int l;
    public boolean m;
    public ViewGroup n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.InteractRecordContainerFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/InteractRecordContainerFragment$onViewCreated$1", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class AnonymousClass1 extends FragmentStatePagerAdapter {
        public final /* synthetic */ InteractRecordContainerFragment a;

        public final int getCount() {
            return this.a.k;
        }

        public final Fragment getItem(int r12) {
            if (r12 == 0) goto L5;
            boolean r13 = true;
        L6:
            String r3 = "pk_banner";
            Integer r7 = null;
            if (r13 == false) goto L30;
            InteractRecordContainerFragment r14 = this.a;
            InteractPkRecordFragment r8 = r14.i;
            if (r8 != null) goto L52;
            int r9 = InteractPkRecordFragment.E;
            com.bytedance.android.live.revlink.impl.control.dialog.r r10 = r14.d;
            DataCenter r15 = r14.h;
            Intrinsics.checkNotNull(r15);
            int r16 = this.a.l;
            Intrinsics.checkNotNullParameter(r15, "dataCenter");
            Intrinsics.checkNotNullParameter("", "activityName");
            Fragment r6 = new InteractPkRecordFragment();
            r6.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.o(r6);
            r6.d = r10;
            yz0.k r17 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r17 == null) goto L13;
            IRoom r18 = r17.getRoom();
        L14:
            r6.j = r18;
            r6.p = new com.bytedance.android.live.revlink.impl.pk.utils.m();
            r6.n = r16;
            r6.m = false;
            r6.t = false;
            r6.u = "";
            r6.v = null;
            r6.w = null;
            r6.B = true;
            r6.C = false;
            Function1<CharSequence, Unit> r19 = new InteractRecordContainerFragment$onViewCreated$1$getItem$1(this);
            Intrinsics.checkNotNullParameter(r19, "onFilterSelect");
            r6.y = r19;
            InteractRecordContainerFragment r110 = this.a;
            if (r110.m == true) goto L18;
            r3 = "link_banner";
        L18:
            r6.h = r3;
            LinkNoScrollViewPager r111 = r110.ba0(2131384040);
            if (r111 != null) goto L21;
        L28:
            this.a.i = r6;
        L53:
            return r6;
        L21:
            if (r111.getCurrentItem() != 1) goto L28;
            if (r6.D == true) goto L28;
            Function1<? super CharSequence, Unit> r112 = r6.y;
            if (r112 == null) goto L27;
            Unit r113 = (Unit) r112.invoke(r6.x);
        L27:
            r6.ha0();
            r6.D = true;
            goto L28
        L13:
            r18 = null;
            goto L14
        L52:
            return r8;
        L30:
            InteractRecordContainerFragment r114 = this.a;
            InteractLinkRecordFragment r20 = r114.j;
            if (r20 != null) goto L54;
            int r22 = InteractLinkRecordFragment.A;
            com.bytedance.android.live.revlink.impl.control.dialog.r r23 = r114.d;
            DataCenter r115 = r114.h;
            Intrinsics.checkNotNull(r115);
            int r24 = this.a.l;
            Intrinsics.checkNotNullParameter(r115, "dataCenter");
            r6 = new InteractLinkRecordFragment();
            r6.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.b(r6);
            r6.d = r23;
            r6.i = r115;
            yz0.k r116 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r116 == null) goto L35;
            IRoom r117 = r116.getRoom();
        L36:
            r6.j = r117;
            r6.o = new com.bytedance.android.live.revlink.impl.pk.utils.m();
            r6.m = r24;
            r6.s = false;
            r6.x = true;
            r6.y = false;
            Function1<CharSequence, Unit> r118 = new InteractRecordContainerFragment$onViewCreated$1$getItem$2(this);
            Intrinsics.checkNotNullParameter(r118, "onFilterSelect");
            r6.u = r118;
            InteractRecordContainerFragment r119 = this.a;
            if (r119.m == true) goto L40;
            r3 = "link_banner";
        L40:
            r6.h = r3;
            LinkNoScrollViewPager r120 = r119.ba0(2131384040);
            if (r120 == null) goto L44;
            r7 = Integer.valueOf(r120.getCurrentItem());
        L44:
            if (r7.intValue() == 0) goto L46;
        L51:
            this.a.j = r6;
            goto L53
        L46:
            if (r6.z == true) goto L51;
            Function1<? super CharSequence, Unit> r121 = r6.u;
            if (r121 == null) goto L50;
            Unit r122 = (Unit) r121.invoke(r6.t);
        L50:
            r6.ha0();
            r6.z = true;
            goto L51
        L35:
            r117 = null;
            goto L36
        L54:
            return r20;
        L5:
            r13 = false;
            goto L6
        }

        public AnonymousClass1(InteractRecordContainerFragment r1, FragmentManager r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    public final boolean rB() {
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        r11.p r0 = b51.b.c0.j();
        if (r0.getEnable() == true) goto L5;
        return 432.0f;
    L5:
        return t6.d(s1.getContext(), t6.b(s1.getContext()) * r11.q.a(r0)) - 48;
    }

    public InteractRecordContainerFragment() {
        this.g = new LinkedHashMap();
        this.k = 2;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.g).clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        return this.n;
    }

    public final View ba0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public static final void ca0(InteractRecordContainerFragment r2, int r3) {
        LinkNoScrollViewPager r1 = r2.ba0(2131384040);
        if (r1 != null) goto L5;
    L6:
        LinkNoScrollViewPager r4 = r2.ba0(2131384040);
        if (r4 == null) goto L11;
        r4.setCurrentItem(r3);
        return;
    L11:
        return;
    L5:
        if (r1.getCurrentItem() != r3) goto L6;
    }

    public final void da0(TabLayout.Tab r9, boolean r10) {
        if (r9 == null) goto L4;
        CharSequence r0 = r9.getText();
    L5:
        String r1 = String.valueOf(r0);
        int r2 = r1.length() - 1;
        int r4 = 0;
        boolean r5 = false;
    L6:
        if (r4 > r2) goto L21;
        if (r5 == true) goto L9;
        int r6 = r4;
    L11:
        if (Intrinsics.compare(r1.charAt(r6), 32) > 0) goto L13;
        boolean r7 = true;
    L14:
        if (r5 == false) goto L15;
        if (r7 == false) goto L21;
        r2 = r2 - 1;
        goto L6
    L15:
        if (r7 == false) goto L16;
        r4 = r4 + 1;
        goto L6
    L16:
        r5 = true;
        goto L6
    L13:
        r7 = false;
        goto L14
    L9:
        r6 = r2;
    L21:
        String r3 = r1.subSequence(r4, r2 + 1).toString();
        SpannableString r8 = new SpannableString(r3);
        r8.setSpan(new StyleSpan(r10 ? 1 : 0), 0, r3.length(), 17);
        if (r9 == null) goto L35;
        r9.setText(r8);
        return;
    L35:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        ba0(2131384040).setScrollEnable(this);
        ba0(2131384040).setOffscreenPageLimit(this.k);
        FragmentManager r12 = getFragmentManager();
        if (r12 == null) goto L5;
        ba0(2131384040).setAdapter(new AnonymousClass1(this, r12));
    L5:
        ba0(2131392542).setBackgroundColor(-1);
        ViewGroup r13 = (ViewGroup) LayoutInflater.from(getContext()).inflate(2131565538, null);
        this.n = r13;
        if (r13 == null) goto L56;
        TabLayout r5 = r13.findViewById(2131387986);
        int r6 = this.k;
    L9:
        int r7 = r6 - 1;
        if (r6 <= 0) goto L14;
        if (r5 == null) goto L13;
        r5.addTab(r5.newTab());
    L13:
        r6 = r7;
        goto L9
    L14:
        TabLayout r8 = r13.findViewById(2131387986);
        if (r8 == null) goto L17;
        r8.setupWithViewPager(ba0(2131384040));
    L17:
        TabLayout r14 = r13.findViewById(2131387986);
        if (r14 == null) goto L22;
        TabLayout.Tab r15 = r14.getTabAt(0);
        if (r15 == null) goto L22;
        r15.setText(s1.B(2131917706));
    L22:
        TabLayout r16 = r13.findViewById(2131387986);
        if (r16 == null) goto L27;
        TabLayout.Tab r17 = r16.getTabAt(1);
        if (r17 == null) goto L27;
        r17.setText(s1.B(2131917924));
    L27:
        TabLayout r18 = r13.findViewById(2131387986);
        if (r18 == null) goto L30;
        r18.addOnTabSelectedListener(new x(this));
    L30:
        TabLayout r19 = r13.findViewById(2131387986);
        if (r19 == null) goto L40;
        TabLayout.Tab r20 = r19.getTabAt(0);
        if (r20 == null) goto L40;
        Object r22 = JavaCalls.getField(r20, "view");
        if ((r22 instanceof View) == true) goto L37;
        r22 = null;
    L37:
        View r23 = (View) r22;
        if (r23 == null) goto L40;
        r23.setOnClickListener(new y(this, r13));
    L40:
        TabLayout r24 = r13.findViewById(2131387986);
        if (r24 == null) goto L50;
        TabLayout.Tab r25 = r24.getTabAt(1);
        if (r25 == null) goto L50;
        Object r0 = JavaCalls.getField(r25, "view");
        if ((r0 instanceof View) == true) goto L47;
        r0 = null;
    L47:
        View r1 = (View) r0;
        if (r1 == null) goto L50;
        r1.setOnClickListener(new z(this, r13));
    L50:
        TabLayout r2 = r13.findViewById(2131387986);
        if (r2 == null) goto L53;
        r2.setSelectedTabIndicatorColor(0);
    L53:
        TabLayout r110 = r13.findViewById(2131387986);
        if (r110 == null) goto L56;
        r110.setSelectedTabIndicatorHeight(0);
    L56:
        ViewGroup r111 = this.n;
        if (r111 == null) goto L59;
        View r112 = r111.findViewById(2131376031);
    L60:
        ImageView r113 = (ImageView) r112;
        if (r113 == null) goto L63;
        r113.setOnClickListener(new a0(this));
    L63:
        ViewGroup r114 = this.n;
        if (r114 == null) goto L66;
        View r115 = r114.findViewById(2131390628);
    L67:
        TextView r116 = (TextView) r115;
        if (r116 == null) goto L70;
        r116.setOnClickListener(new b0(this));
    L70:
        ba0(2131384040).addOnPageChangeListener(new AnonymousClass2(this));
        if (this.m == false) goto L73;
        ba0(2131384040).setCurrentItem(1);
    L74:
        int r117 = this.k;
        int r3 = 0;
    L75:
        if (r3 >= r117) goto L97;
        if (r3 != ba0(2131384040).getCurrentItem()) goto L87;
        ViewGroup r26 = this.n;
        if (r26 == null) goto L81;
        View r27 = r26.findViewById(2131387986);
    L82:
        TabLayout r28 = (TabLayout) r27;
        if (r28 == null) goto L85;
        TabLayout.Tab r29 = r28.getTabAt(r3);
    L86:
        da0(r29, true);
    L96:
        r3 = r3 + 1;
        goto L75
    L85:
        r29 = null;
        goto L86
    L81:
        r27 = null;
        goto L82
    L87:
        ViewGroup r30 = this.n;
        if (r30 == null) goto L90;
        View r32 = r30.findViewById(2131387986);
    L91:
        TabLayout r33 = (TabLayout) r32;
        if (r33 == null) goto L94;
        TabLayout.Tab r34 = r33.getTabAt(r3);
    L95:
        da0(r34, false);
        goto L96
    L94:
        r34 = null;
        goto L95
    L90:
        r32 = null;
        goto L91
    L97:
        p11.d r35 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r35 == null) goto L100;
        r35.b();
    L100:
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class).checkDegradeForNative("anchor_invite_panel");
        return;
    L73:
        ba0(2131384040).setCurrentItem(0);
        goto L74
    L66:
        r115 = null;
        goto L67
    L59:
        r112 = null;
        goto L60
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565537, r3, false);
    }
}
