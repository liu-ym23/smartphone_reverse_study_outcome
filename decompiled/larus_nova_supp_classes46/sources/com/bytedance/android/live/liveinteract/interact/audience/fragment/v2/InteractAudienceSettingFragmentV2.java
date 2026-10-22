package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.OpenPanelType;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.LinkInternalServiceContext;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.m1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.config.u01;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractAudienceSettingFragmentV2 extends InteractDialogFragmentBaseContract$View<yf0.e> {
    public static final /* synthetic */ int M = 0;
    public View A;
    public View B;
    public View C;
    public TextView D;
    public LinearLayout E;
    public ConstraintLayout F;
    public TextView G;
    public View H;
    public View I;
    public final CompositeDisposable J;
    public boolean K;
    public final u01 L;
    public IRoom g;
    public ViewGroup h;
    public ViewGroup i;
    public Switch j;
    public Switch k;
    public Switch l;
    public Switch m;
    public Switch n;
    public View o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public View t;
    public View u;
    public Switch v;
    public View w;
    public TextView x;
    public View y;
    public View z;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ InteractAudienceSettingFragmentV2 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.InteractAudienceSettingFragmentV2$a$a, reason: collision with other inner class name */
        public class C0034a implements Consumer<com.bytedance.android.live.network.response.a> {
            public final /* synthetic */ boolean a;

            public C0034a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r2) throws Exception {
                com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
                com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.m1;
                Boolean r0 = Boolean.valueOf(this.a);
                r4.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            }
        }

        public a(InteractAudienceSettingFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, final boolean r6) {
            int r7 = jf0.b.a;
            jf0.b.h("fans_only", r6);
            HashMap r8 = new HashMap();
            r8.put("scene", 2);
            r8.put(com.bytedance.android.livesdk.sharedpref.c.m1.getName(), Boolean.valueOf(r6));
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.K0;
            r8.put(r0.getName(), r0.getValue());
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.u0;
            r8.put(r1.getName(), r1.getValue());
            InteractAudienceSettingFragmentV2 r2 = this.a;
            if (r2.g == null) goto L6;
            r2.J.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.g.getId(), r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0034a(r6), new y(this, r6)));
            return;
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ InteractAudienceSettingFragmentV2 a;

        public class a implements Consumer<com.bytedance.android.live.network.response.a> {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r2) throws Exception {
                com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
                com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.K0;
                Boolean r0 = Boolean.valueOf(this.a);
                r4.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            }
        }

        public b(InteractAudienceSettingFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, final boolean r6) {
            int r7 = jf0.b.a;
            jf0.b.h("connection_apply", r6);
            HashMap r8 = new HashMap();
            r8.put("scene", 2);
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.m1;
            r8.put(r0.getName(), r0.getValue());
            r8.put(com.bytedance.android.livesdk.sharedpref.c.K0.getName(), Boolean.valueOf(r6));
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.u0;
            r8.put(r1.getName(), r1.getValue());
            InteractAudienceSettingFragmentV2 r2 = this.a;
            if (r2.g == null) goto L6;
            r2.J.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.g.getId(), r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6), new z(this, r6)));
            return;
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ InteractAudienceSettingFragmentV2 a;

        public class a implements Consumer<com.bytedance.android.live.network.response.a> {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r2) throws Exception {
                com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
                com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.u0;
                Boolean r0 = Boolean.valueOf(this.a);
                r4.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            }
        }

        public c(InteractAudienceSettingFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, final boolean r6) {
            int r7 = jf0.b.a;
            jf0.b.h("invited_only", r6);
            HashMap r8 = new HashMap();
            r8.put("scene", 2);
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.m1;
            r8.put(r0.getName(), r0.getValue());
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.K0;
            r8.put(r1.getName(), r1.getValue());
            r8.put(com.bytedance.android.livesdk.sharedpref.c.u0.getName(), Boolean.valueOf(r6));
            InteractAudienceSettingFragmentV2 r2 = this.a;
            if (r2.g == null) goto L6;
            r2.J.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.g.getId(), r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6), new a0(this, r6)));
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final View U90() {
        AutoRTLImageView r0 = new AutoRTLImageView(getContext());
        r0.setLayoutParams(new RelativeLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f)));
        r0.setImageDrawable(s1.m(2131251983));
        r0.setOnClickListener(new i(this));
        r3.c(r0, s1.B(2131918649), true);
        return r0;
    }

    public final void aa0() {
        String r0 = this.L.paymentConfigSchema;
        if (TextUtils.isEmpty(r0) == true) goto L5;
        HashMap r1 = new HashMap();
        com.bytedance.android.live.liveinteract.api.data.a.C0017a r2 = com.bytedance.android.live.liveinteract.api.data.a.h;
        r2.getClass();
        r1.put("paid_count", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.d()));
        r2.getClass();
        r1.put("limit_time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.c()));
        r1.put("height", "483");
        String r3 = y0.b(r0, r1);
        ALogger.i("ttlive_link_paid", "setting panel handle=" + jc1.k.f(IBaseLiveActionHandler.class).handle(getContext(), r3) + " " + r3);
    L5:
        this.r.setVisibility(8);
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.v0;
        Boolean r5 = Boolean.TRUE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
    }

    public InteractAudienceSettingFragmentV2() {
        this.J = new CompositeDisposable();
        this.L = vm2.d.l();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return getString(2131917546);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.J.dispose();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Disposable r3 = xs2.b.a().b(a1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this));
        this.J.add(r3);
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        View r10 = r7.inflate(2131566053, r8, false);
        this.h = (ViewGroup) r10.findViewById(2131378015);
        this.E = (LinearLayout) r10.findViewById(2131378781);
        this.F = r10.findViewById(2131366881);
        this.G = (TextView) r10.findViewById(2131391061);
        this.H = r10.findViewById(2131378782);
        this.j = (Switch) r10.findViewById(2131363368);
        this.i = (ViewGroup) r10.findViewById(2131363369);
        this.k = (Switch) r10.findViewById(2131387920);
        this.l = (Switch) r10.findViewById(2131387922);
        this.m = (Switch) r10.findViewById(2131387919);
        this.n = (Switch) r10.findViewById(2131387937);
        this.o = r10.findViewById(2131362534);
        this.p = r10.findViewById(2131387742);
        this.q = r10.findViewById(2131382033);
        this.r = r10.findViewById(2131382034);
        this.s = (TextView) r10.findViewById(2131382046);
        this.t = r10.findViewById(2131382040);
        this.u = r10.findViewById(2131382047);
        this.v = (Switch) r10.findViewById(2131363374);
        this.w = r10.findViewById(2131382035);
        this.x = (TextView) r10.findViewById(2131382038);
        this.y = r10.findViewById(2131382036);
        this.I = r10.findViewById(2131382042);
        this.z = r10.findViewById(2131374388);
        this.A = r10.findViewById(2131377993);
        this.B = r10.findViewById(2131363173);
        this.D = (TextView) r10.findViewById(2131363175);
        this.C = r10.findViewById(2131363174);
        this.m.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.u0.getValue()).booleanValue());
        this.k.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.K0.getValue()).booleanValue());
        this.l.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.m1.getValue()).booleanValue());
        this.n.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.s0.getValue()).booleanValue());
        if (fj0.e.h() == true) goto L5;
        fj0.c.a();
    L5:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L15;
        this.F.setVisibility(8);
        this.E.setVisibility(8);
        TextView r11 = this.G;
        if (fj0.e.i() == false) goto L10;
        int r1 = 2131921172;
    L11:
        r11.setText(s1.B(r1));
        com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.c.x0;
        Boolean r2 = Boolean.TRUE;
        r12.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r12, r2);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.y0.getValue()).booleanValue() == true) goto L14;
        this.I.setVisibility(0);
    L14:
        this.H.setOnClickListener(new k(this));
    L31:
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.c.e1;
        Integer r3 = (Integer) r13.getValue();
        if (r3 != null) goto L35;
    L36:
        boolean r4 = true;
    L38:
        if (r4 == false) goto L49;
        View r5 = r10.findViewById(2131381838);
        final View r6 = r10.findViewById(2131381839);
        Switch r14 = (Switch) r10.findViewById(2131387928);
        r5.setVisibility(0);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.i1.getValue()).booleanValue() == false) goto L43;
        int r15 = 0;
    L44:
        r6.setVisibility(r15);
        if (((Integer) r13.getValue()).intValue() != 1) goto L47;
        boolean r16 = true;
    L48:
        r14.setChecked(r16);
        r14.setOnCheckedChangeListener(new j(this, r6));
        goto L49
    L47:
        r16 = false;
        goto L48
    L43:
        r15 = 8;
    L49:
        this.J.add(LinkInternalServiceContext.getContext().getPaidInteractAudienceConfig().a().observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this)));
        this.j.setClickable(false);
        this.i.setOnClickListener(new w0(new r(this), 1000));
        this.l.setOnCheckedChangeListener(new a(this));
        this.v.setOnCheckedChangeListener(new s(this));
        this.k.setOnCheckedChangeListener(new b(this));
        this.m.setOnCheckedChangeListener(new c(this));
        if (vm2.d.V0().allowSendGiftToLinker == true) goto L52;
    L63:
        this.o.setVisibility(8);
    L65:
        if (vm2.d.x0() == true) goto L67;
    L69:
        this.p.setVisibility(8);
    L70:
        int r17 = jf0.b.a;
        boolean r18 = this.j.isChecked();
        HashMap r19 = jf0.b.b();
        if (r18 == false) goto L73;
        String r20 = "1";
    L74:
        r19.put("connection_status", r20);
        j0.l().sendLog("livesdk_anchor_audience_connection_setup_banner_show", r19, new Object[]{IRoom.class});
        return r10;
    L73:
        r20 = "2";
        goto L74
    L67:
        if (vm2.d.p() == false) goto L69;
        this.p.setVisibility(0);
        this.p.setOnClickListener(new v(this));
        goto L70
    L52:
        if (vm2.d.V0().intimateChatSwitch == false) goto L63;
        this.o.setVisibility(0);
        com.bytedance.android.livesdk.chatroom.o r21 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (vm2.d.u0() == false) goto L59;
        if (r21 == null) goto L59;
        if (r21.isAnchor().booleanValue() == false) goto L59;
        boolean r22 = true;
    L60:
        if (r22 == false) goto L62;
        View r23 = r10.findViewById(2131362535);
        r23.setVisibility(0);
        ((IInteractService) jc1.k.f(IInteractService.class)).getLinkMode();
        int r24 = m1.a;
        Intrinsics.checkNotNullParameter(PbRequest.SwitchType.GIFT, "requestPage");
        final LinkedHashMap r25 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r25, null, null, 6);
        TalkRoomLogUtils.J0(r25);
        r25.put("request_page", PbRequest.SwitchType.GIFT);
        j0.l().sendLog("livesdk_anchor_audience_connection_profit_info_show", r25, new Object[]{IRoom.class});
        r23.setOnClickListener(new t(this, r25));
    L62:
        this.n.setOnCheckedChangeListener(new u(this));
    L59:
        r22 = false;
        goto L60
    L35:
        if (r3.intValue() != 0) goto L36;
        r4 = false;
        goto L38
    L10:
        r1 = 2131921171;
        goto L11
    L15:
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.q.setVisibility(0);
        if (fj0.e.i() == false) goto L18;
        String r26 = fj0.e.c();
    L20:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.v0.getValue()).booleanValue() == true) goto L22;
        this.r.setVisibility(0);
    L22:
        this.s.setText(r26);
        this.t.setOnClickListener(new o(this));
        com.bytedance.android.livesdk.chatroom.u r27 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r27 != null) goto L25;
    L30:
        com.bytedance.android.livesdk.sharedpref.e r28 = com.bytedance.android.livesdk.sharedpref.c.z0;
        Boolean r29 = Boolean.TRUE;
        r28.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r28, r29);
        this.B.setVisibility(0);
        this.D.setText(fj0.e.b());
        this.C.setOnClickListener(new n(this));
        goto L31
    L25:
        if (((Integer) r27.c().getValue()).intValue() == OpenPanelType.PAID_LINK_SETTING_PANEL.getValue()) goto L27;
    L29:
        r27.c().setValue(Integer.valueOf(OpenPanelType.NONE.getValue()));
        goto L30
    L27:
        if (fj0.e.i() == false) goto L29;
        aa0();
        goto L29
    L18:
        r26 = s1.B(2131918650);
        goto L20
    }
}
