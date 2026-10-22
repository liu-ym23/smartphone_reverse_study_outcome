package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.ParticipateStatus;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r8) {
        if (((Boolean) vm2.d.W4.getValue(null, vm2.d.a[306(0x132, float:4.29E-43)])).booleanValue() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.live.profit.lottery.i r0 = yt0.c.f();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m r1 = r0.getCurCandidateState();
    L9:
        if (r1 == null) goto L81;
        com.bytedance.android.live.profit.lottery.i r2 = yt0.c.f();
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.m r3 = r2.getCurCandidateState();
        if (r3 == null) goto L15;
        ParticipateStatus r4 = (ParticipateStatus) r3.getValue();
    L16:
        if (r4 == null) goto L81;
        com.bytedance.android.live.profit.lottery.i r5 = yt0.c.f();
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.n r6 = r5.getCurrentLottery();
    L21:
        if (r6 == null) goto L81;
        com.bytedance.android.live.profit.lottery.i r7 = yt0.c.f();
        if (r7 == null) goto L27;
        com.bytedance.live.datacontext.n r9 = r7.getCurrentLottery();
        if (r9 == null) goto L27;
        com.bytedance.android.live.profit.lottery.g r10 = (com.bytedance.android.live.profit.lottery.g) r9.getValue();
    L28:
        if (r10 == null) goto L81;
        if (r8 != null) goto L32;
        return false;
    L32:
        com.bytedance.android.live.profit.lottery.i r11 = yt0.c.f();
        if (r11 == null) goto L81;
        com.bytedance.live.datacontext.n r12 = r11.getCurrentLottery();
        if (r12 == null) goto L81;
        com.bytedance.android.live.profit.lottery.g r13 = (com.bytedance.android.live.profit.lottery.g) r12.getValue();
        if (r13 == null) goto L81;
        LotteryState.g r14 = r13.getState();
        if (r14 == null) goto L81;
        if ((r14 instanceof LotteryState.g) == false) goto L45;
        com.bytedance.android.live.profit.lottery.t r15 = r14.a;
    L54:
        if (r15 == null) goto L81;
        List r16 = r15.g;
        if (r16 == null) goto L81;
        if (r16.contains(51) == true) goto L61;
        return false;
    L61:
        com.bytedance.android.live.profit.lottery.i r17 = yt0.c.f();
        Intrinsics.checkNotNull(r17);
        if (((ParticipateStatus) r17.getCurCandidateState().getValue()) != ParticipateStatus.PARTICIPATEINSUCCESS) goto L81;
        if (((Boolean) b6.a.getValue()).booleanValue() == false) goto L81;
        View r18 = LayoutInflater.from(r8).inflate(2131565761, null);
        LinearLayout r19 = (LinearLayout) r18.findViewById(2131383717);
        RadioButton r20 = (RadioButton) r18.findViewById(2131383716);
        Integer r21 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r21 != null) goto L70;
    L72:
        boolean r22 = false;
    L73:
        if (r22 == false) goto L75;
        int r23 = 2131921827;
    L76:
        TextView r24 = (TextView) r18.findViewById(2131388772);
        if (r24 == null) goto L79;
        r24.setText(r23);
    L79:
        r19.setOnClickListener(new u(r20));
        lm3.c r25 = new lm3.c();
        r25.b = s1.B(2131915442);
        r25.a = true;
        lm3.c r26 = new lm3.c();
        r26.b = s1.B(2131915913);
        r26.a = true;
        r26.c = new t(r20);
        lm3.d.a r27 = new lm3.d.a(r8);
        r27.d = r18;
        r27.e = CollectionsKt.listOf(new lm3.c[]{r25, r26});
        r27.i = true;
        r27.j = false;
        r27.k = 2131249915;
        r27.g = Float.valueOf(0.0f);
        r27.h = Float.valueOf(0.0f);
        r27.f = Float.valueOf(0.0f);
        r27.a();
        return true;
    L75:
        r23 = 2131921829;
        goto L76
    L70:
        if (r21.intValue() != 2) goto L72;
        r22 = true;
        goto L73
    L45:
        if ((r14 instanceof LotteryState.a) == false) goto L48;
        r15 = ((LotteryState.a) r14).a;
        goto L54
    L48:
        if ((r14 instanceof LotteryState.b) == false) goto L51;
        r15 = ((LotteryState.b) r14).a;
        goto L54
    L51:
        if ((r14 instanceof LotteryState.e) == false) goto L53;
        r15 = ((LotteryState.e) r14).b;
        goto L54
    L53:
        r15 = null;
    L27:
        r10 = null;
        goto L28
    L20:
        r6 = null;
    L15:
        r4 = null;
    L81:
        return false;
    L8:
        r1 = null;
        goto L9
    }
}
