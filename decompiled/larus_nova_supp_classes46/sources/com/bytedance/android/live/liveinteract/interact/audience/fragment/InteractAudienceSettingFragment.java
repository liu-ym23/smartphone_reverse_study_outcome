package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.LinkInternalServiceContext;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.m1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.config.u01;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractAudienceSettingFragment extends CommonBottomDialog {
    public static final /* synthetic */ int o = 0;
    public final IRoom a;
    public Switch b;
    public Switch c;
    public Switch d;
    public Switch e;
    public View f;
    public View g;
    public View h;
    public View i;
    public TextView j;
    public View k;
    public final CompositeDisposable l;
    public final boolean m;
    public final u01 n;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ InteractAudienceSettingFragment a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.interact.audience.fragment.InteractAudienceSettingFragment$a$a, reason: collision with other inner class name */
        public class C0033a implements Consumer<com.bytedance.android.live.network.response.a> {
            public final /* synthetic */ boolean a;

            public C0033a(boolean r1) {
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

        public a(InteractAudienceSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            HashMap r7 = new HashMap();
            r7.put("scene", 2);
            r7.put(com.bytedance.android.livesdk.sharedpref.c.m1.getName(), Boolean.valueOf(r6));
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.K0;
            r7.put(r0.getName(), r0.getValue());
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.u0;
            r7.put(r1.getName(), r1.getValue());
            InteractAudienceSettingFragment r2 = this.a;
            if (r2.a == null) goto L6;
            r2.l.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.a.getId(), r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0033a(r6)));
            return;
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ InteractAudienceSettingFragment a;

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

        public b(InteractAudienceSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            HashMap r7 = new HashMap();
            r7.put("scene", 2);
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.m1;
            r7.put(r0.getName(), r0.getValue());
            r7.put(com.bytedance.android.livesdk.sharedpref.c.K0.getName(), Boolean.valueOf(r6));
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.u0;
            r7.put(r1.getName(), r1.getValue());
            InteractAudienceSettingFragment r2 = this.a;
            if (r2.a == null) goto L6;
            r2.l.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.a.getId(), r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6)));
            return;
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ InteractAudienceSettingFragment a;

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

        public c(InteractAudienceSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            HashMap r7 = new HashMap();
            r7.put("scene", 2);
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.m1;
            r7.put(r0.getName(), r0.getValue());
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.K0;
            r7.put(r1.getName(), r1.getValue());
            r7.put(com.bytedance.android.livesdk.sharedpref.c.u0.getName(), Boolean.valueOf(r6));
            InteractAudienceSettingFragment r2 = this.a;
            if (r2.a == null) goto L6;
            r2.l.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.a.getId(), r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6)));
            return;
        }
    }

    public final int getLayoutId() {
        return 2131565501;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getWindow() == null) goto L6;
        getWindow().addFlags(2);
        getWindow().setDimAmount(0.6f);
        return;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l.dispose();
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        this.b = (Switch) findViewById(2131387920);
        this.c = (Switch) findViewById(2131387922);
        this.d = (Switch) findViewById(2131387919);
        this.e = (Switch) findViewById(2131387937);
        this.f = findViewById(2131362534);
        this.g = findViewById(2131387742);
        this.h = findViewById(2131382033);
        this.i = findViewById(2131382034);
        this.j = (TextView) findViewById(2131382046);
        this.k = findViewById(2131382040);
        this.d.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.u0.getValue()).booleanValue());
        this.b.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.K0.getValue()).booleanValue());
        this.c.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.m1.getValue()).booleanValue());
        this.e.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.s0.getValue()).booleanValue());
        this.c.setOnCheckedChangeListener(new a(this));
        this.b.setOnCheckedChangeListener(new b(this));
        this.d.setOnCheckedChangeListener(new c(this));
        if (vm2.d.V0().allowSendGiftToLinker == true) goto L5;
    L17:
        this.f.setVisibility(8);
    L19:
        if (vm2.d.x0() == true) goto L21;
    L25:
        this.g.setVisibility(8);
    L27:
        if (fj0.e.h() == false) goto L36;
        this.h.setVisibility(0);
        if (fj0.e.i() == false) goto L31;
        String r10 = fj0.e.c();
    L33:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.v0.getValue()).booleanValue() == true) goto L35;
        this.i.setVisibility(0);
    L35:
        this.j.setText(r10);
        this.k.setOnClickListener(new r(this));
        com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.c.z0;
        Boolean r2 = Boolean.TRUE;
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r2);
        String r12 = this.a.getOwnerUserIdString();
        String r3 = String.valueOf(this.a.getId());
        fj0.a r4 = fj0.b.a;
        Intrinsics.checkNotNullParameter(r12, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        LinkedHashMap r5 = new LinkedHashMap();
        TalkRoomLogUtils.I0(r5, je0.d.f());
        r5.put("anchor_id", r12);
        r5.put("room_id", r3);
        TalkRoomLogUtils.B0(r5, Integer.valueOf(je0.d.f()), null, 4);
        j0.l().sendLog("livesdk_anchor_audience_connection_rechargeable_show", r5, new Object[]{IRoom.class});
        goto L36
    L31:
        r10 = s1.B(2131918650);
    L36:
        this.l.add(LinkInternalServiceContext.getContext().getPaidInteractAudienceConfig().a().observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this)));
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.c.z0;
        Boolean r0 = Boolean.TRUE;
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r0);
        return;
    L21:
        if (vm2.d.p() == false) goto L25;
        RoomPermissionContext.a r14 = RoomPermissionContext.Companion;
        long r6 = this.a.getRoomId();
        r14.getClass();
        if (RoomPermissionContext.a.a(r6) == true) goto L25;
        this.g.setVisibility(0);
        this.g.setOnClickListener(new q(this));
        goto L27
    L5:
        if (vm2.d.V0().intimateChatSwitch == false) goto L17;
        this.f.setVisibility(0);
        com.bytedance.android.livesdk.chatroom.o r15 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (vm2.d.u0() == false) goto L13;
        boolean r7 = tb1.d.a;
        if (r15 == null) goto L13;
        if (r15.isAnchor().booleanValue() == false) goto L13;
        boolean r16 = true;
    L14:
        if (r16 == false) goto L16;
        View r17 = findViewById(2131362535);
        r17.setVisibility(0);
        ((IInteractService) jc1.k.f(IInteractService.class)).getLinkMode();
        int r8 = m1.a;
        Intrinsics.checkNotNullParameter(PbRequest.SwitchType.GIFT, "requestPage");
        final LinkedHashMap r18 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r18, null, null, 6);
        TalkRoomLogUtils.J0(r18);
        r18.put("request_page", PbRequest.SwitchType.GIFT);
        j0.l().sendLog("livesdk_anchor_audience_connection_profit_info_show", r18, new Object[]{IRoom.class});
        r17.setOnClickListener(new o(this, r18));
    L16:
        this.e.setOnCheckedChangeListener(new p(this));
    L13:
        r16 = false;
        goto L14
    }

    public InteractAudienceSettingFragment(IRoom r1, Context r2) {
        super(r2);
        this.l = new CompositeDisposable();
        this.n = vm2.d.l();
        this.a = r1;
        this.m = true;
    }
}
