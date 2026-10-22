package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.android.material.tabs.TabLayout;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractAudienceContainerFragment extends InteractDialogFragmentBaseContract$View<yf0.e> {
    public static final /* synthetic */ int s = 0;
    public ViewPager g;
    public ViewGroup h;
    public a i;
    public IRoom j;
    public View k;
    public boolean l;
    public int m;
    public DataCenter n;
    public InteractAudienceInviteFragment o;
    public InteractAudienceApplyFragment p;
    public TextView q;
    public final c r;

    public class a extends FragmentPagerAdapter {
        public final /* synthetic */ InteractAudienceContainerFragment a;

        public final int getCount() {
            return 2;
        }

        public final Fragment getItem(int r1) {
            if (r1 != 0) goto L6;
            return this.a.p;
        L6:
            return this.a.o;
        }

        public a(InteractAudienceContainerFragment r1, FragmentManager r2) {
            this.a = r1;
            super(r2);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ InteractAudienceContainerFragment a;

        public final void onPageScrollStateChanged(int r1) {
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public b(InteractAudienceContainerFragment r1) {
            this.a = r1;
        }

        public final void onPageSelected(int r2) {
            if (r2 != 0) goto L4;
            this.a.p.ca0();     // Catch: Exception -> L8
        L9:
            return;
        L4:
            InteractAudienceInviteFragment r3 = this.a.o;     // Catch: Exception -> L8
            if ((r3 instanceof InteractAudienceInviteFragment) == false) goto L9;
            r3.ca0();     // Catch: Exception -> L8
        }
    }

    public class c implements Observer<Integer> {
        public final /* synthetic */ InteractAudienceContainerFragment a;

        public c(InteractAudienceContainerFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            InteractAudienceContainerFragment r0 = this.a;
            int r4 = ((Integer) r3).intValue();
            int r1 = InteractAudienceContainerFragment.s;
            r0.ba0(r4);
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    public InteractAudienceContainerFragment() {
        this.r = new c(this);
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        hd0.c.f().e(this.r);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        return this.h;
    }

    public final void ba0(int r2) {
        if (r2 != 0) goto L4;
        this.q.setText(2131919228);
        return;
    L4:
        if (r2 != 1) goto L6;
        this.q.setText(2131917526);
        return;
    L6:
        if (r2 != 2) goto L14;
        this.q.setText(2131919271);
        return;
    }

    public static InteractAudienceContainerFragment aa0(yf0.g r2, DataCenter r3) {
        InteractAudienceContainerFragment r0 = new InteractAudienceContainerFragment();
        r0.d = r2;
        r0.n = r3;
        r0.m = 0;
        r0.l = ((Boolean) r3.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        return r0;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() == null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().getLinkUserCenter().X4();
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a() == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.c.a.a().getLinkUserCenter().X4();
    L8:
        ((ObservableSubscribeProxy) Observable.timer(300, TimeUnit.MILLISECONDS).as(S90())).subscribe(new com.bytedance.android.live.liveinteract.interact.audience.fragment.b(this));
    }

    public final View onCreateView(LayoutInflater r19, ViewGroup r20, Bundle r21) {
        View r1 = r19.inflate(2131565496, r20, false);
        this.k = r1;
        this.g = r1.findViewById(2131392847);
        yf0.g r2 = this.d;
        DataCenter r3 = this.n;
        InteractAudienceInviteFragment r4 = new InteractAudienceInviteFragment();
        r4.d = r2;
        Boolean r5 = Boolean.FALSE;
        r4.l = ((Boolean) r3.get("data_is_anchor", r5)).booleanValue();
        this.o = r4;
        yf0.g r6 = this.d;
        DataCenter r7 = this.n;
        int r8 = InteractAudienceApplyFragment.m;
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        InteractAudienceApplyFragment r9 = new InteractAudienceApplyFragment();
        r9.f = new kf0.a(r9);
        r9.d = r6;
        r9.h = (IRoom) r7.get("data_room");
        r9.i = ((Boolean) r7.get("data_is_anchor", r5)).booleanValue();
        this.p = r9;
        this.i = new a(this, getChildFragmentManager());
        this.g.addOnPageChangeListener(new b(this));
        this.g.setAdapter(this.i);
        this.g.setCurrentItem(this.m);
        this.j = (IRoom) this.n.get("data_room");
        ViewGroup r10 = (ViewGroup) LayoutInflater.from(getContext()).inflate(2131565497, null);
        this.h = r10;
        TabLayout r11 = r10.findViewById(2131387986);
        r11.addTab(r11.newTab());
        r11.addTab(r11.newTab());
        r11.setupWithViewPager(this.g);
        r11.getTabAt(0).setText(s1.B(2131918066));
        r11.getTabAt(0).setTag(s1.B(2131918066));
        r11.getTabAt(1).setText(s1.B(2131918073));
        r11.getTabAt(1).setTag(s1.B(2131918073));
        ((TextView) this.h.findViewById(2131385953)).setOnClickListener(new g(this));
        ((TextView) this.h.findViewById(2131366972)).setOnClickListener(new h(this));
        View r12 = this.h.findViewById(2131362589);
        this.q = (TextView) this.h.findViewById(2131362297);
        if (this.l == false) goto L5;
        r12.setVisibility(0);
        this.q.setVisibility(8);
    L7:
        if (this.j == null) goto L13;
        if (vm2.d.k() == false) goto L11;
        final long r13 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkWaitingList(this.j.getId(), 50, "").as(S90())).subscribe(new com.bytedance.android.live.liveinteract.interact.audience.fragment.c(this, r13), new d(r13));
        goto L13
    L11:
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getPageList(this.j.getId(), d5.c(this.j.getOwner().getIdString()), this.j.getOwner().getIdString(), 1, 0, 0, false, "", 0, "", "InteractAudienceFragmentStart").as(S90())).subscribe(new e(this), new f());
    L13:
        return this.k;
    L5:
        r12.setVisibility(8);
        this.q.setVisibility(0);
        ba0(((Integer) ((ge1.a) hd0.c.f()).b).intValue());
        this.q.setOnClickListener(new com.bytedance.android.live.liveinteract.interact.audience.fragment.a(this));
        hd0.c.f().c(this.r);
        goto L7
    }
}
