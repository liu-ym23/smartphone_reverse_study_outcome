package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.chatroom.model.OpenPanelType;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractAudienceContainerFragmentV2 extends InteractDialogFragmentBaseContract$View<yf0.e> {
    public static final /* synthetic */ int r = 0;
    public DataCenter g;
    public com.bytedance.android.live.liveinteract.plantform.base.g h;
    public final CompositeDisposable i;
    public boolean j;
    public View k;
    public TextView l;
    public View m;
    public View n;
    public InteractAudienceOpenFragment o;
    public InteractAudienceListFragmentV2 p;
    public final a q;

    public class a implements Observer<Integer> {
        public final /* synthetic */ InteractAudienceContainerFragmentV2 a;

        public a(InteractAudienceContainerFragmentV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            InteractAudienceContainerFragmentV2 r0 = this.a;
            int r4 = ((Integer) r3).intValue();
            int r1 = InteractAudienceContainerFragmentV2.r;
            r0.ca0(r4);
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final View U90() {
        if (this.j == true) goto L6;
    L10:
        return null;
    L6:
        if (getFragmentManager().getBackStackEntryCount() == 1) goto L10;
        if (ba0() == true) goto L10;
        AutoRTLImageView r0 = new AutoRTLImageView(getContext());
        r0.setLayoutParams(new RelativeLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f)));
        r0.setImageDrawable(s1.m(2131251314));
        r0.setOnClickListener(new f(this));
        r3.c(r0, s1.B(2131918649), true);
        return r0;
    }

    public final boolean ba0() {
        if (jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().d() == RevPkState.DISABLE) goto L5;
        return true;
    L5:
        return false;
    }

    public InteractAudienceContainerFragmentV2() {
        this.i = new CompositeDisposable();
        this.q = new a(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return getString(2131919433);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.i.dispose();
        hd0.c.f().e(this.q);
    }

    public final void onResume() {
        super.onResume();
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        this.k.setVisibility(0);
        return;
    L10:
        this.k.setVisibility(4);
        return;
    L5:
        if (r0.k0(2) == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final View V90() {
        return this.k;
    }

    public final void ca0(int r2) {
        if (r2 != 0) goto L4;
        this.l.setText(2131919228);
        return;
    L4:
        if (r2 != 1) goto L6;
        this.l.setText(2131917526);
        return;
    L6:
        if (r2 != 2) goto L14;
        this.l.setText(2131919271);
        return;
    }

    public static InteractAudienceContainerFragmentV2 aa0(yf0.g r2, DataCenter r3) {
        InteractAudienceContainerFragmentV2 r0 = new InteractAudienceContainerFragmentV2();
        r0.d = r2;
        r0.g = r3;
        r0.h = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r3 == null) goto L5;
        r0.j = ((Boolean) r3.get("data_is_anchor", Boolean.TRUE)).booleanValue();
    L6:
        return r0;
    L5:
        r0.j = true;
        goto L6
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
        ((ObservableSubscribeProxy) Observable.timer(300, TimeUnit.MILLISECONDS).as(S90())).subscribe(new b(this));
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        if (this.d != null) goto L5;
        return null;
    L5:
        View r13 = r10.inflate(2131566052, r11, false);
        this.o = new InteractAudienceOpenFragment();
        yf0.g r14 = this.d;
        DataCenter r15 = this.g;
        int r2 = InteractAudienceListFragmentV2.n;
        this.p = InteractAudienceListFragmentV2.a.a(r14, r15);
        FragmentTransaction r16 = getChildFragmentManager().beginTransaction();
        InteractAudienceOpenFragment r17 = this.o;
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r17, r3, null, 2131373275) == true) goto L9;
        r16 = r16.add(2131373275, r17);
    L9:
        InteractAudienceListFragmentV2 r18 = this.p;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r18, r3, null, 2131373275) == true) goto L13;
        r16 = r16.add(2131373275, r18);
    L13:
        com.bytedance.android.live.liveinteract.plantform.base.g r19 = this.h;
        if (r19 != null) goto L16;
    L18:
        boolean r110 = false;
    L19:
        if (r110 == false) goto L21;
        r16.hide(this.o);
    L22:
        r16.commitAllowingStateLoss();
        View r111 = LayoutInflater.from(getContext()).inflate(2131567722, null);
        this.k = r111;
        r111.setVisibility(4);
        this.l = (TextView) this.k.findViewById(2131362297);
        this.m = this.k.findViewById(2131375534);
        this.n = this.k.findViewById(2131385981);
        this.m.setOnClickListener(new c(this));
        View r112 = this.k.findViewById(2131387909);
        ImageView r4 = (ImageView) this.k.findViewById(2131375539);
        if (this.j == true) goto L25;
    L33:
        r4.setVisibility(8);
        r112.setVisibility(8);
    L34:
        r4.setOnClickListener(new d(this));
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L37;
        boolean r113 = ((Boolean) com.bytedance.android.livesdk.sharedpref.c.x0.getValue()).booleanValue();
    L38:
        if (r113 == true) goto L45;
        if (fj0.e.h() == false) goto L45;
        if (this.j == false) goto L45;
        this.n.setVisibility(0);
    L45:
        if (this.j == true) goto L47;
        ca0(((Integer) ((ge1.a) hd0.c.f()).b).intValue());
        this.m.setVisibility(4);
        this.l.setVisibility(0);
        this.l.setOnClickListener(new g(this));
        hd0.c.f().c(this.q);
    L47:
        this.i.add(xs2.b.a().b(a1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)));
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L50;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Nf();
    L50:
        com.bytedance.android.livesdk.chatroom.u r114 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r114 != null) goto L53;
    L55:
        return r13;
    L53:
        if (((Integer) r114.c().getValue()).intValue() != OpenPanelType.PAID_LINK_SETTING_PANEL.getValue()) goto L55;
        yf0.g r115 = this.d;
        DataCenter r116 = this.g;
        InteractAudienceSettingFragmentV2 r0 = new InteractAudienceSettingFragmentV2();
        r0.d = r115;
        r0.g = (IRoom) r116.get("data_room");
        r0.K = true;
        r115.Rh(r0);
        this.n.setVisibility(8);
        goto L55
    L37:
        r113 = ((Boolean) com.bytedance.android.livesdk.sharedpref.c.z0.getValue()).booleanValue();
        goto L38
    L25:
        if (((Boolean) vm2.d.Q7.getValue(null, vm2.d.a[455(0x1c7, float:6.38E-43)])).booleanValue() == false) goto L33;
        if (ba0() == true) goto L33;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.H0;
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L31;
        com.bytedance.android.livesdk.sharedpref.f.d(r1, Boolean.FALSE);
        r112.setVisibility(0);
    L32:
        r4.setVisibility(0);
        HashMap r117 = new HashMap();
        r117.put("live_type", "video_live");
        r117.put("action_type", "show");
        r117.put("function_type", "live");
        r117.put("source", "apply_panel");
        TalkRoomLogUtils.H0(r117);
        j0.l().sendLog("livesdk_anchor_function_icon", r117, new Object[]{IRoom.class, am2.x.class});
        goto L34
    L31:
        r112.setVisibility(8);
        goto L32
    L21:
        r16.hide(this.p);
        goto L22
    L16:
        if (r19.k0(2) == false) goto L18;
        r110 = true;
        goto L19
    }
}
