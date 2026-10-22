package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiMicPanelIcon;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/PkAnchorMicDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkAnchorMicDialog extends CommonBottomDialog implements q46.a {
    public static final /* synthetic */ int j = 0;
    public m21.h a;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.p b;
    public final d21.b c;
    public final String d;
    public final String e;
    public final IRoom f;
    public final int g;
    public final Function1<Boolean, Unit> h;
    public final w i;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567009;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m21.h r0 = this.a;
        if (r0 == null) goto L6;
        r0.detachView();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r14) {
        super.onCreate(r14);
        com.bytedance.android.live.revlink.impl.multianchor.service.d r15 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r15 == null) goto L7;
        i11.b r16 = r15.getLinkUserCenter();
        if (r16 == null) goto L7;
        com.bytedance.android.livesdk.link.model.p r17 = r16.getGuestInfo(this.d, null);
    L8:
        d21.b r1 = this.c;
        if (r17 == null) goto L14;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L14;
        String r19 = r18.getNickName();
        if (r19 == null) goto L14;
    L15:
        r1.getClass();
        final String r110 = d21.b.a(r19);
        TextView r2 = (TextView) findViewById(2131389658);
        final boolean r3 = true;
        if (r2 == null) goto L18;
        r2.setText(getContext().getString(2131920560, new Object[]{r110}));
    L18:
        w r4 = this.i;
        if (r4 != null) goto L21;
    L23:
        final boolean r5 = false;
    L24:
        w31.c r6 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r6 != null) goto L27;
    L33:
        boolean r7 = false;
    L34:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r8 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r8 != null) goto L37;
    L39:
        final boolean r9 = false;
    L41:
        if (r7 == false) goto L53;
        LinearLayout r10 = (LinearLayout) findViewById(2131389657);
        if (r10 == null) goto L53;
        MultiMicPanelIcon r12 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        if (r5 == false) goto L47;
        int r13 = 2131920535;
    L48:
        r12.setDesc(s1.B(r13));
        if (r5 == false) goto L51;
        int r111 = 2131252428;
    L52:
        r12.setIcon(r111);
        r12.setOnClick(new PkAnchorMicDialog$onCreate$$inlined$apply$lambda$1(this, r5));
        Unit r112 = Unit.INSTANCE;
        r10.addView(r12);
        goto L53
    L51:
        r111 = 2131252430;
        goto L52
    L47:
        r13 = 2131920538;
    L53:
        com.bytedance.android.livesdk.revenue.service.room.c r20 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r20 == null) goto L62;
        com.bytedance.android.livesdk.revenue.room.a r22 = r20.getRoomContext();
        if (r22 == null) goto L62;
        com.bytedance.live.datacontext.m r23 = r22.getRoom();
        if (r23 == null) goto L62;
        IRoom r24 = (IRoom) r23.getValue();
        if (r24 == null) goto L62;
        boolean r25 = r24.isLiveTypeAudio();
    L63:
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r113 = com.bytedance.android.live.revlink.impl.global.b.c();
        if (r113 != null) goto L66;
    L67:
        if (r25 == true) goto L71;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r26 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r26 == null) goto L71;
        r26.isInCloudCollaborate();
    L71:
        com.bytedance.android.live.revenuelink.rtc.f r27 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r27 == null) goto L74;
        com.bytedance.android.live.revenuelink.rtc.i r28 = r27.getRtcManager();
    L75:
        if (r28 == null) goto L83;
        com.bytedance.android.live.revenuelink.rtc.p r29 = r28.L();
        if (r29 == null) goto L83;
        com.bytedance.android.live.revenuelink.rtc.o r30 = r29.k(this.e);
        if (r30 == null) goto L83;
        if (r30.g != true) goto L83;
        final boolean r32 = true;
    L84:
        int r114 = this.g;
        int r115 = s11.a.b;
        if (r114 != 0) goto L87;
    L101:
        LinearLayout r33 = (LinearLayout) findViewById(2131389657);
        if (r33 == null) goto L114;
        MultiMicPanelIcon r116 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        if (r32 == false) goto L106;
        String r117 = s1.B(2131920565);
    L107:
        r116.setDesc(r117);
        if (r9 == false) goto L110;
        int r118 = 2131252435;
    L113:
        r116.setIcon(r118);
        r116.setOnClick(new PkAnchorMicDialog$onCreate$$inlined$apply$lambda$4(this, r32, r9, r110));
        Unit r119 = Unit.INSTANCE;
        r33.addView(r116);
        goto L114
    L110:
        if (r32 == false) goto L112;
        r118 = 2131252438;
        goto L113
    L112:
        r118 = 2131252433;
        goto L113
    L106:
        r117 = s1.B(2131920557);
    L114:
        LinearLayout r120 = (LinearLayout) findViewById(2131389657);
        if (r120 == null) goto L117;
        MultiMicPanelIcon r34 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        r34.setDesc(s1.B(2131920566));
        r34.setIcon(2131252440);
        r34.setOnClick(new PkAnchorMicDialog$onCreate$$inlined$apply$lambda$5(this));
        Unit r0 = Unit.INSTANCE;
        r120.addView(r34);
    L117:
        m21.h r121 = new m21.h();
        this.a = r121;
        ((q46.b) r121).a = this;
        if (this.g != 0) goto L121;
        r121.c0(this.d, new PkAnchorMicDialog$tryQueryUser$1(this));
    L121:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r122 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r122 == null) goto L130;
        if (r7 == true) goto L125;
        String r35 = "";
    L128:
        r122.s(r35, this.d, "");
        return;
    L125:
        if (r5 == false) goto L127;
        r35 = "average";
        goto L128
    L127:
        r35 = "enlarge";
        goto L128
    L130:
        return;
    L87:
        if (r114 == 2) goto L90;
        r3 = false;
    L90:
        LinearLayout r123 = (LinearLayout) findViewById(2131389657);
        if (r123 == null) goto L101;
        MultiMicPanelIcon r124 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        if (r3 == false) goto L95;
        String r125 = s1.B(2131920562);
    L96:
        r124.setDesc(r125);
        if (r3 == false) goto L99;
        int r126 = 2131252436;
    L100:
        r124.setIcon(r126);
        r124.setOnClick(new PkAnchorMicDialog$onCreate$$inlined$apply$lambda$3(this, r3));
        Unit r36 = Unit.INSTANCE;
        r123.addView(r124);
        goto L101
    L99:
        r126 = 2131252431;
        goto L100
    L95:
        r125 = s1.B(2131920552);
    L83:
        r32 = false;
        goto L84
    L74:
        r28 = null;
        goto L75
    L66:
        if (r113.a() == true) goto L71;
    L62:
        r25 = false;
        goto L63
    L37:
        if (r8.isInAudioPunish(this.e) != true) goto L39;
        r9 = true;
        goto L41
    L27:
        if (r6.e() != true) goto L33;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r37 = com.bytedance.android.live.revlink.impl.global.b.c();
        if (r37 == null) goto L33;
        if (r37.a() != true) goto L33;
        r7 = true;
        goto L34
    L21:
        if (r4.x5(this.d) != true) goto L23;
        r5 = true;
    L14:
        r19 = "";
    L7:
        r17 = null;
        goto L8
    }

    public PkAnchorMicDialog(Context r2, String r3, String r4, IRoom r5, int r6, Function1 r7, c0 r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "linkerID");
        Intrinsics.checkNotNullParameter(r7, "setMute");
        super(r2);
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.b = new com.bytedance.android.live.revlink.impl.multianchor.ui.p(r2);
        this.c = new d21.b();
    }
}
