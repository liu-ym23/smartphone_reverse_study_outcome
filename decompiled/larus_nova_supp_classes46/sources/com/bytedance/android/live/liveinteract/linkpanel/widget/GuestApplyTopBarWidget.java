package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/GuestApplyTopBarWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestApplyTopBarWidget extends LiveWidget {
    public TextView a;
    public TextView b;
    public final a c;
    public final GuestApplyViewModel d;
    public final IRoom e;
    public final int f;

    public static final class a<T> implements Observer {
        public final /* synthetic */ GuestApplyTopBarWidget a;

        public a(GuestApplyTopBarWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.intValue() != 0) goto L11;
            TextView r4 = this.a.b;
            if (r4 == null) goto L9;
            r4.setText(s1.B(2131917501));
        L9:
            this.a.wq(null);
            return;
        L11:
            if (r3.intValue() != 1) goto L18;
            TextView r5 = this.a.b;
            if (r5 == null) goto L19;
            r5.setText(s1.B(2131917484));
            return;
        L19:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GuestApplyTopBarWidget a;

        public b(GuestApplyTopBarWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r14) {
            Integer r15 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r15 != null) goto L6;
        L13:
            gd0.m r16 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r16 == null) goto L16;
            ((LinkPanelTransitService) r16).e();
        L16:
            GuestApplyTopBarWidget r17 = this.a;
            GuestApplyViewModel r2 = r17.d;
            if (r2 == null) goto L80;
            LiveData<n0> r3 = r2.getUserWaitingData();
            if (r3 == null) goto L81;
            n0 r4 = (n0) r3.getValue();
            if (r4 == null) goto L82;
            HashMap r5 = new HashMap();
            LiveData<Integer> r6 = r17.d.getSortTypeLiveData();
            if (r6 == null) goto L25;
            Integer r7 = (Integer) r6.getValue();
        L26:
            if (r7 != null) goto L29;
        L31:
            if (r7 != null) goto L34;
        L36:
            String r8 = "time_first";
        L37:
            r5.put("ordering_mode", r8);
            String r9 = r4.getFanTicket();
            String r10 = "0";
            if (r9 != null) goto L40;
            r9 = "0";
        L40:
            r5.put("money", r9);
            long r11 = r4.getRank();
            if (r11 != 1) goto L44;
            String r12 = "top1";
        L50:
            r5.put("top_r", r12);
            IBaseUser r13 = r4.getUserFlex();
            if (r13 == null) goto L53;
            String r18 = r13.getRelationship();
        L54:
            r5.put("relationship", String.valueOf(r18));
            IBaseUser r19 = r4.getUserFlex();
            if (r19 == null) goto L57;
            Integer r20 = Integer.valueOf(r19.getLevel());
        L58:
            r5.put("contribution_level", String.valueOf(r20));
            long r110 = 1000;
            long r21 = (System.currentTimeMillis() - (r4.getModifyTime() * r110)) / r110;
            if (r21 >= 0) goto L61;
            r21 = 0;
        L61:
            r5.put("waiting_duration", String.valueOf(r21));
            GuestApplyViewModel r111 = r17.d;
            if (r111 == null) goto L64;
            Long r112 = Long.valueOf(r111.getApplyWaitingCount());
        L65:
            r5.put("waiting_people", String.valueOf(r112.longValue()));
            r5.put("order", String.valueOf(r4.getOffset()));
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == false) goto L68;
        L70:
            Object r113 = "0";
        L71:
            r5.put("is_priority_queue", r113);
            r5.put("pay_amt", String.valueOf(r4.getPaidAmount()));
            r5.put("present_order", String.valueOf(r4.getOffset()));
            r5.put("request_page", "live_link_apply_page");
            IKtvService r114 = jc1.k.f(IKtvService.class);
            if (r114 != null) goto L74;
        L76:
            r5.put("is_live_song", r10);
            com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r5, null, 6);
            j0.l().sendLog("livesdk_guest_apply_withdraw", r5, new Object[]{IRoom.class, am2.x.class});
            return;
        L74:
            if (r114.hasSelfPrivateSong() != true) goto L76;
            r10 = "1";
            goto L76
        L68:
            if (r4.getPaidAmount() <= 0) goto L70;
            r113 = "1";
            goto L71
        L64:
            r112 = null;
            goto L65
        L57:
            r20 = null;
            goto L58
        L53:
            r18 = null;
            goto L54
        L44:
            if (r11 != 2) goto L47;
            r12 = "top2";
            goto L50
        L47:
            if (r11 != 3) goto L49;
            r12 = "top3";
            goto L50
        L49:
            r12 = "null";
            goto L50
        L34:
            if (r7.intValue() != 42) goto L36;
            r8 = "complex_value";
            goto L37
        L29:
            if (r7.intValue() != 41) goto L31;
            r8 = "money_first";
            goto L37
        L25:
            r7 = null;
            goto L26
        L82:
            return;
        L81:
            return;
        L80:
            return;
        L6:
            if (r15.intValue() != 0) goto L13;
            gd0.m r115 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r115 == null) goto L10;
            ((LinkPanelTransitService) r115).b("", "", this.a.f);
        L10:
            GuestApplyViewModel r116 = this.a.d;
            if (r116 == null) goto L78;
            r116.setApplyWaitingCount(0);
            return;
        }
    }

    public static final class c<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ GuestApplyTopBarWidget a;

        public c(GuestApplyTopBarWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            GuestApplyTopBarWidget r0 = this.a;
            r0.wq((a5) r2);
        }
    }

    public final int getLayoutId() {
        return 2131565483;
    }

    public final void onCreate() {
        super.onCreate();
        this.a = (TextView) ((Widget) this).contentView.findViewById(2131391606);
        this.b = (TextView) ((Widget) this).contentView.findViewById(2131390275);
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L6;
    L7:
        hd0.c.f().c(this.c);
    L8:
        TextView r1 = this.b;
        if (r1 == null) goto L11;
        r1.setOnClickListener(new b(this));
    L11:
        GuestApplyViewModel r2 = this.d;
        if (r2 == null) goto L17;
        LiveData<a5> r3 = r2.getWaitingTitleData();
        if (r3 == null) goto L18;
        r3.observe(this, new c(this));
        return;
    L18:
        return;
    L17:
        return;
    L6:
        if (r0.intValue() == 2) goto L8;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        GuestApplyViewModel r0 = this.d;
        if (r0 == null) goto L7;
        LiveData<a5> r1 = r0.getWaitingTitleData();
        if (r1 == null) goto L7;
        r1.removeObservers(this);
    L7:
        hd0.c.f().e(this.c);
    }

    public final void wq(a5 r4) {
        if (r4 == null) goto L4;
        TextView r0 = this.a;
        if (r0 == null) goto L15;
        r0.setText(sb2.a.h(r4, "", false));
        return;
    L15:
        return;
    L4:
        if (hd0.c.f().g() == false) goto L12;
        TextView r5 = this.a;
        if (r5 == null) goto L13;
        r5.setText(s1.B(2131917503));
        return;
    L13:
        return;
    }

    public GuestApplyTopBarWidget(GuestApplyViewModel r1, IRoom r2, int r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.c = new a(this);
    }
}
