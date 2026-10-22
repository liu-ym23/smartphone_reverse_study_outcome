package com.bytedance.android.live.liveinteract.plantform.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.live.liveinteract.plantform.base.f;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.v0;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import io.reactivex.Single;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import us1.g;
import yf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class AudienceTypeFragment extends InteractDialogFragmentBaseContract$View<e> implements Observer<KVData> {
    public static final /* synthetic */ int m = 0;
    public DataCenter g;
    public IRoom h;
    public boolean i;
    public boolean j;
    public final a k;
    public final b l;

    public class a implements com.bytedance.android.livesdk.app.dataholder.Observer<Integer> {
        public final /* synthetic */ AudienceTypeFragment a;

        public a(AudienceTypeFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((Integer) r3).intValue() != 0) goto L6;
            ALogger.e("ttlive_link", "close video interact and open video ktv");
            this.a.g.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this.a.k);
            this.a.ea0();
            return;
        }
    }

    public class b implements com.bytedance.android.livesdk.app.dataholder.Observer<Integer> {
        public final /* synthetic */ AudienceTypeFragment a;

        public b(AudienceTypeFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((Integer) r3).intValue() != 0) goto L6;
            ALogger.e("ttlive_link", "close video interact and open video talk");
            this.a.g.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this.a.l);
            AudienceTypeFragment r4 = this.a;
            int r0 = g.a;
            IRoom r1 = r4.h;
            r4.da0(false, null);
            return;
        }
    }

    public class c implements d {
        public c() {
        }
    }

    public interface d {
    }

    public final void ea0() {
        boolean r0 = k.f(IKtvService.class).isKtvComponentV2Enable();
        TalkRoomLogUtils.l0("ktv_tab");
        if (r0 == true) goto L5;
        this.g.put("cmd_open_ktv_component_with_link_check", new Pair(Boolean.TRUE, "ktv_tab"));
    L12:
        yf0.g r1 = this.d;
        if (r1 == null) goto L16;
        r1.dismiss();
        return;
    L16:
        return;
    L5:
        if (k.f(IKtvService.class) != null) goto L7;
    L9:
        i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("music");
    L10:
        int r3 = g.a;
        da0(false, new c());
        goto L12
    L7:
        if (k.f(IKtvService.class).isMultiChorusEnable() == false) goto L9;
        i0 r4 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("user_chorus");
        goto L10
    }

    public AudienceTypeFragment() {
        this.h = m.i().getCurrentRoom();
        this.k = new a(this);
        this.l = new b(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        if (je0.d.W() == false) goto L6;
        return 168.0f;
    L6:
        return 152.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        if (vm2.d.S() == false) goto L5;
        boolean r0 = tb1.d.a;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        return s1.B(2131919439);
    L10:
        return s1.B(2131919438);
    L5:
        r1 = false;
        goto L6
    }

    public final void ba0() {
        if (f.a() != null) goto L5;
    L7:
        int r0 = g.a;
        da0(false, null);
        return;
    L5:
        if (f.a().k0(2) == false) goto L7;
        this.g.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().k(2);
        hd0.c.f().c(this.l);
    }

    public final void ca0() {
        if (f.a() != null) goto L5;
    L7:
        ea0();
        return;
    L5:
        if (f.a().k0(2) == false) goto L7;
        this.g.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().k(2);
        hd0.c.f().c(this.k);
    }

    public final void onDestroy() {
        super.onDestroy();
        hd0.c.f().e(this.k);
        hd0.c.f().e(this.l);
        DataCenter r0 = this.g;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public static void aa0(View r3) {
        if (r3 == null) goto L9;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        float r1 = com.bytedance.android.livesdk.m.b();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r1 <= 1.0f) goto L11;
        r0.width = (int) (r0.width / r1);
        r3.setLayoutParams(r0);
        return;
    L11:
        return;
    }

    public static void fa0(View r3) {
        View r0 = r3.findViewById(2131392387);
        ImageView r1 = (ImageView) r3.findViewById(2131392390);
        TextView r4 = (TextView) r3.findViewById(2131391689);
        r0.setBackgroundResource(2131250046);
        r1.setImageResource(2131253281);
        r4.setText(2131921183);
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3.getKey(), "live_audience_type_dialog_dismiss") == false) goto L11;
        yf0.g r4 = this.d;
        if (r4 == null) goto L12;
        r4.dismiss();
        return;
    L12:
        return;
    }

    public final void da0(final boolean r28, final d r29) {
        final long r18 = System.currentTimeMillis();
        if (this.h != null) goto L11;
        DataCenter r0 = this.g;
        if (r0 == null) goto L8;
        this.h = (IRoom) r0.get("data_room", null);
    L8:
        if (this.h != null) goto L11;
        return;
    L11:
        if (k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() == 0) goto L15;
        f2.b(2131917544, 0);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.g0("during_pk");
        return;
    L15:
        if (this.j == false) goto L17;
        return;
    L17:
        this.j = true;
        int r1 = com.bytedance.android.live.liveinteract.plantform.utils.f.a;
        com.bytedance.android.live.liveinteract.plantform.utils.f.a((LiveMode) this.g.get("data_live_mode", LiveMode.UNDEFINED));
        final int r5 = ((Integer) com.bytedance.android.livesdk.sharedpref.c.r1.getValue()).intValue();
        wf0.b.i(r5);
        if (r28 == false) goto L20;
        Single<com.bytedance.android.live.network.response.e<j0>> r2 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(this.h.getId(), 4, 16, false, r5, "8,12", 0, 0, 1);
    L21:
        ((IInteractService) k.f(IInteractService.class)).setDynamicFromAudience(false);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.c0("click_bottom_bar_icon", r5, 0);
        InteractLinkFullLinkMonitor.i("8,12", r5, "click_bottom_bar_icon");
        ((SingleSubscribeProxy) r2.as(S90())).subscribe(new hh0.d(this, r18, r5, r29), new hh0.e(this, r28, r29, r18));
        return;
    L20:
        r2 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(this.h.getId(), 4, false, r5, "8,12");
        goto L21
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        if (this.g == null) goto L6;
        boolean r4 = us1.e.a;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        us1.e.e = "";
        this.g.put("data_video_talk_dot_with_number_show", "");
        this.g.observe("live_audience_type_dialog_dismiss", this);
        return;
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        r8.inflate(2131565502, r9, false);
        i0 r11 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("link_icon");
        boolean r12 = tb1.d.a;
        if (je0.d.W() == false) goto L15;
        View r13 = r8.inflate(2131565504, r9, false);
        TextView r14 = (TextView) r13.findViewById(2131390801);
        TextView r15 = (TextView) r13.findViewById(2131390802);
        if (vm2.e.j() == true) goto L9;
        int r16 = v0.a;
        if (v0.a(this.g) == false) goto L9;
        fa0(r13);
        View r17 = r13.findViewById(2131392320);
        ImageView r3 = (ImageView) r13.findViewById(2131392321);
        TextView r4 = (TextView) r13.findViewById(2131391686);
        r17.setBackgroundResource(2131250046);
        r3.setImageResource(2131252129);
        r4.setText(2131921183);
    L9:
        boolean r18 = us1.e.a;
        if (us1.e.a(this.h) == false) goto L27;
        if (us1.e.b(this.h) == false) goto L14;
        r15.setText(2131922906);
        goto L27
    L14:
        r15.setText(2131922905);
    L27:
        if (com.bytedance.android.livesdk.m.c() == false) goto L29;
        View r19 = r13.findViewById(2131370127);
        View r2 = r13.findViewById(2131392387);
        View r5 = r13.findViewById(2131392320);
        aa0(r19);
        aa0(r5);
        aa0(r2);
    L29:
        r13.findViewById(2131370127).setOnClickListener(new hh0.a(this));
        r13.findViewById(2131392387).setOnClickListener(new hh0.b(this));
        if (je0.d.W() == false) goto L32;
        r13.findViewById(2131392320).setOnClickListener(new hh0.c(this));
    L32:
        Intrinsics.checkNotNullParameter("ktv_tab", "source");
        com.bytedance.live.datacontext.m r1 = m.i().getRoom();
        if (r1 == null) goto L37;
        IRoom r6 = (IRoom) r1.getValue();
        if (r6 == null) goto L37;
        long r7 = r6.getRoomId();
    L38:
        com.bytedance.live.datacontext.m r20 = m.i().getRoom();
        if (r20 == null) goto L44;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L44;
        Object r22 = r21.getOwnerUserIdString();
        if (r22 == null) goto L44;
    L45:
        LinkedHashMap r23 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r23);
        TalkRoomLogUtils.B0(r23, null, null, 6);
        TalkRoomLogUtils.V0(r23);
        r23.put("source", "ktv_tab");
        r23.put("room_id", String.valueOf(r7));
        r23.put("anchor_id", r22.toString());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_music_icon_show", r23, new Object[]{IRoom.class});
        return r13;
    L44:
        r22 = 0L;
    L37:
        r7 = 0;
        goto L38
    L15:
        r13 = r8.inflate(2131565503, r9, false);
        TextView r24 = (TextView) r13.findViewById(2131390801);
        TextView r25 = (TextView) r13.findViewById(2131390802);
        boolean r110 = us1.e.a;
        if (us1.e.a(this.h) == true) goto L18;
    L21:
        ((TextView) r13.findViewById(2131391689)).setText(2131922907);
        if (vm2.e.j() == true) goto L27;
        int r26 = v0.a;
        if (v0.a(this.g) == false) goto L27;
        fa0(r13);
        goto L27
    L18:
        if (us1.e.b(this.h) == false) goto L20;
        r25.setText(2131922906);
        goto L21
    L20:
        r25.setText(2131922905);
        goto L21
    }
}
