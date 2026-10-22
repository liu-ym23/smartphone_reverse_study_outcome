package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.ef0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/PaidLiveCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLiveCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public com.bytedance.android.livesdk.vscore_api.paidlive.l c;

    public final View c6() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c6();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        runWithRoomEntered(new AnonymousClass1(this));
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.observeForever("cmd_widget_loaded", this);
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.V9() == true) goto L10;
        return;
    L10:
        if (ef0.a.getValue().booleanValue() == false) goto L24;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r2 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter);
        PaidSceneContext r3 = r2.u1(PaidSceneEnum.PAID_ROOM);
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.m r4 = r3.getCurrentState();
        if (r4 == null) goto L16;
        wq((com.bytedance.android.livesdk.vscore_api.paidlive.l) r4.getValue());
        ((ObservableSubscribeProxy) r4.a().observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new k0(this));
    L16:
        PaidSceneContext r5 = r2.u1(PaidSceneEnum.SUBSCRIBE_ROOM);
        if (r5 == null) goto L25;
        com.bytedance.live.datacontext.m r6 = r5.getCurrentState();
        if (r6 == null) goto L26;
        wq((com.bytedance.android.livesdk.vscore_api.paidlive.l) r6.getValue());
        ((ObservableSubscribeProxy) r6.a().observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new l0(this));
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a = null;
        this.b = null;
    }

    public PaidLiveCompositeWidget() {
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L33;
        if (r5 == null) goto L9;
        String r1 = r5.getKey();
    L10:
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.hashCode() == (-1836833765)) goto L16;
        return;
    L16:
        if (r1.equals("cmd_widget_loaded") == true) goto L18;
        return;
    L18:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r5) == false) goto L30;
        int r6 = com.bytedance.android.livesdk.chatroom.paidlive.b.b;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L36;
        com.bytedance.android.live.profit.lottery.i r2 = yt0.c.f();
        if (r2 == null) goto L31;
        com.bytedance.android.live.profit.lottery.o r3 = r2.getLotteryPluginStore();
        if (r3 == null) goto L32;
        r3.a(new com.bytedance.android.livesdk.chatroom.paidlive.b(r7));
        return;
    L32:
        return;
    L31:
        return;
    L36:
        return;
    L30:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void wq(com.bytedance.android.livesdk.vscore_api.paidlive.l r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        View r3 = null;
        if ((r7 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.e) == false) goto L119;
        com.bytedance.android.livesdk.vscore_api.paidlive.l r0 = this.c;
        if (r0 != null) goto L9;
    L69:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L72;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r1);
    L74:
        if (r2 != null) goto L76;
    L100:
        View r4 = c6();
        if (r4 == null) goto L103;
        r4.setVisibility(8);
    L103:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r5 = this.b;
        if (r5 == null) goto L106;
        View r6 = r5.b6();
    L107:
        if (r6 == null) goto L109;
        r6.setVisibility(8);
    L109:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r8 = this.b;
        if (r8 == null) goto L112;
        r3 = r8.fp();
    L112:
        if (r3 == null) goto L114;
        r3.setVisibility(8);
    L114:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L117;
        r9.put("paid_live_hidden_link_multi_view", Boolean.TRUE);
    L117:
        this.c = r7;
        return;
    L106:
        r6 = null;
        goto L107
    L76:
        if (r2.isLiveTypeAudio() != true) goto L100;
        View r10 = c6();
        if (r10 == null) goto L80;
        r10.setVisibility(8);
    L80:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r11 = this.b;
        if (r11 == null) goto L83;
        View r12 = r11.Ia();
    L84:
        if (r12 == null) goto L86;
        r12.setVisibility(8);
    L86:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r13 = this.b;
        if (r13 == null) goto L89;
        View r14 = r13.Dj();
    L90:
        if (r14 == null) goto L92;
        r14.setVisibility(8);
    L92:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r15 = this.b;
        if (r15 == null) goto L95;
        r3 = r15.r7();
    L95:
        if (r3 == null) goto L97;
        r3.setVisibility(8);
    L97:
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L117;
        r16.put("paid_live_hidden_link_multi_view", Boolean.TRUE);
        goto L117
    L89:
        r14 = null;
        goto L90
    L83:
        r12 = null;
        goto L84
    L72:
        r2 = null;
        goto L74
    L9:
        if ((!Intrinsics.areEqual(r0.a, r7.a)) == true) goto L69;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L13;
        Room r18 = com.bytedance.android.live.core.utils.z.o(r17);
    L14:
        if (r18 != null) goto L16;
    L46:
        View r19 = c6();
        if (r19 != null) goto L49;
    L51:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r20 = this.b;
        if (r20 == null) goto L54;
        View r21 = r20.b6();
    L55:
        if (r21 != null) goto L57;
    L59:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r22 = this.b;
        if (r22 == null) goto L62;
        View r23 = r22.fp();
    L63:
        if (r23 != null) goto L65;
    L67:
        boolean r24 = true;
    L68:
        if (r24 == true) goto L119;
    L65:
        if (r23.getVisibility() != 0) goto L67;
    L66:
        r24 = false;
        goto L68
    L62:
        r23 = null;
        goto L63
    L57:
        if (r21.getVisibility() != 0) goto L59;
    L54:
        r21 = null;
        goto L55
    L49:
        if (r19.getVisibility() != 0) goto L51;
    L16:
        if (r18.isLiveTypeAudio() != true) goto L46;
        View r25 = c6();
        if (r25 != null) goto L20;
    L22:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r26 = this.b;
        if (r26 == null) goto L25;
        View r27 = r26.Ia();
    L26:
        if (r27 != null) goto L28;
    L30:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r28 = this.b;
        if (r28 == null) goto L33;
        View r29 = r28.Dj();
    L34:
        if (r29 != null) goto L36;
    L38:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r30 = this.b;
        if (r30 == null) goto L41;
        View r31 = r30.r7();
    L42:
        if (r31 == null) goto L67;
        if (r31.getVisibility() != 0) goto L67;
    L41:
        r31 = null;
        goto L42
    L36:
        if (r29.getVisibility() != 0) goto L38;
    L33:
        r29 = null;
        goto L34
    L28:
        if (r27.getVisibility() != 0) goto L30;
    L25:
        r27 = null;
        goto L26
    L20:
        if (r25.getVisibility() != 0) goto L22;
    L13:
        r18 = null;
    L119:
        if ((r7 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.a) == false) goto L170;
        DataCenter r32 = ((Widget) this).dataCenter;
        if (r32 == null) goto L123;
        Room r33 = com.bytedance.android.live.core.utils.z.o(r32);
    L124:
        if (r33 != null) goto L126;
    L150:
        View r34 = c6();
        if (r34 == null) goto L153;
        r34.setVisibility(0);
    L153:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r35 = this.b;
        if (r35 == null) goto L156;
        View r36 = r35.b6();
    L157:
        if (r36 == null) goto L159;
        r36.setVisibility(0);
    L159:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r37 = this.b;
        if (r37 == null) goto L162;
        r3 = r37.fp();
    L162:
        if (r3 == null) goto L164;
        r3.setVisibility(0);
    L164:
        DataCenter r38 = ((Widget) this).dataCenter;
        if (r38 == null) goto L167;
        r38.put("paid_live_hidden_link_multi_view", Boolean.FALSE);
    L167:
        this.c = r7;
        return;
    L156:
        r36 = null;
        goto L157
    L126:
        if (r33.isLiveTypeAudio() != true) goto L150;
        View r39 = c6();
        if (r39 == null) goto L130;
        r39.setVisibility(0);
    L130:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r40 = this.b;
        if (r40 == null) goto L133;
        View r41 = r40.Ia();
    L134:
        if (r41 == null) goto L136;
        r41.setVisibility(0);
    L136:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r42 = this.b;
        if (r42 == null) goto L139;
        View r43 = r42.Dj();
    L140:
        if (r43 == null) goto L142;
        r43.setVisibility(0);
    L142:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r44 = this.b;
        if (r44 == null) goto L145;
        r3 = r44.r7();
    L145:
        if (r3 == null) goto L147;
        r3.setVisibility(0);
    L147:
        DataCenter r45 = ((Widget) this).dataCenter;
        if (r45 == null) goto L167;
        r45.put("paid_live_hidden_link_multi_view", Boolean.FALSE);
        goto L167
    L139:
        r43 = null;
        goto L140
    L133:
        r41 = null;
        goto L134
    L123:
        r33 = null;
        goto L124
    }
}
