package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import am2.x;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.util.w;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.AddPriceSteps;
import com.bytedance.android.live.liveinteract.plantform.model.GetInfoBeforeAddPriceResponse;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.CoinConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import j40.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ IncreasePriceApplyDialog a;

    public b(IncreasePriceApplyDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r12) {
        GetInfoBeforeAddPriceResponse r13 = (GetInfoBeforeAddPriceResponse) r12;
        if (r13 == null) goto L70;
        ((TextView) this.a.findViewById(2131391058)).setVisibility(0);
        int r0 = r3.a;
        ImageLoader.load(((CoinConfig) m.a.getValue()).getIcCoin()).a(this.a.findViewById(2131376297));
        ((TextView) this.a.findViewById(2131391058)).setText(IncreasePriceApplyDialog.M0(this.a) + r3.b());
        IncreasePriceApplyDialog r1 = this.a;
        if (r1.e != 3) goto L7;
        int r2 = 2131921196;
    L8:
        String r3 = s1.B(r2);
        SpannableStringBuilder r4 = new SpannableStringBuilder(r3);
        r4.setSpan(new AbsoluteSizeSpan(17, true), 0, r3.length(), 33);
        r4.setSpan(new StyleSpan(0), 0, r3.length(), 33);
        GuestApplyViewModel r5 = r1.f;
        if (r5 == null) goto L11;
        int r6 = r5.getRankAfterIncreasePrice();
    L12:
        r4.append(String.valueOf(r6));
        r4.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), r3.length(), r4.length(), 33);
        r4.setSpan(new AbsoluteSizeSpan(17, true), r3.length(), r4.length(), 33);
        r4.setSpan(new StyleSpan(0), r3.length(), r4.length(), 33);
        ((TextView) r1.findViewById(2131391606)).setText(r4);
        ImageView r7 = (ImageView) this.a.findViewById(2131382496);
        long r8 = IncreasePriceApplyDialog.M0(this.a);
        GuestApplyViewModel r9 = this.a.f;
        long r10 = 0;
        if (r9 == null) goto L19;
        LiveData<GetInfoBeforeAddPriceResponse> r11 = r9.getAfterIncreasePriceData();
        if (r11 == null) goto L19;
        GetInfoBeforeAddPriceResponse r14 = (GetInfoBeforeAddPriceResponse) r11.getValue();
        if (r14 == null) goto L19;
        long r15 = r14.getMaxAddPriceValue();
    L21:
        if (r8 >= r15) goto L23;
        boolean r16 = true;
    L24:
        r7.setEnabled(r16);
        ImageView r17 = (ImageView) this.a.findViewById(2131380160);
        long r18 = IncreasePriceApplyDialog.M0(this.a);
        this.a.getClass();
        List<AddPriceSteps> r19 = r13.getAddPriceSteps();
        if (r19 == null) goto L33;
        Iterator<T> r110 = r19.iterator();
    L28:
        if (r110.hasNext() == false) goto L33;
        AddPriceSteps r20 = (AddPriceSteps) r110.next();
        if (r20.getLeftClosedInterval() == 0) goto L28;
        r10 = r20.getLeftClosedInterval();
    L33:
        if (r18 <= r10) goto L35;
        boolean r111 = true;
    L36:
        r17.setEnabled(r111);
        IncreasePriceApplyDialog r112 = this.a;
        if (r112.d == true) goto L71;
        GuestApplyViewModel r113 = r112.f;
        if (r113 != null) goto L41;
    L65:
        this.a.d = true;
        return;
    L41:
        if (r113.getLineUp() == null) goto L65;
        IRoom r114 = this.a.b;
        if (r114 == null) goto L46;
        String r115 = r114.getOwnerUserIdString();
        if (r115 == null) goto L46;
    L47:
        IRoom r21 = this.a.b;
        if (r21 == null) goto L50;
        Long r22 = Long.valueOf(r21.getId());
    L51:
        String r23 = String.valueOf(r22);
        GuestApplyViewModel r24 = this.a.f;
        if (r24 == null) goto L54;
        Integer r25 = Integer.valueOf(r24.getPaidCount());
    L55:
        String r26 = String.valueOf(r25.intValue());
        GuestApplyViewModel r27 = this.a.f;
        if (r27 == null) goto L58;
        Integer r28 = Integer.valueOf(r27.getRankAfterIncreasePrice());
    L59:
        String r29 = String.valueOf(r28.intValue());
        Intrinsics.checkNotNullParameter(r115, "anchorId");
        Intrinsics.checkNotNullParameter(r23, "roomId");
        Intrinsics.checkNotNullParameter(r26, "addPrice");
        Intrinsics.checkNotNullParameter(r29, "expectedLineUp");
        LinkedHashMap r30 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r30);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r30, null, 6);
        l0.e(r30);
        r30.put("anchor_id", r115);
        r30.put("room_id", r23);
        r30.put("play_mode", w.c());
        r30.put("time", String.valueOf(w.b()));
        r30.put("recharge_price", String.valueOf(w.a()));
        n0 r116 = tc0.c.h().P;
        if (r116 == null) goto L63;
        String r117 = String.valueOf(r116.getOffset());
        if (r117 == null) goto L63;
    L64:
        r30.put("line_up", r117);
        r30.put("add_price", r26);
        r30.put("expected_line_up", r29);
        j0.l().sendLog("livesdk_guest_connection_rechargeble_premium_show", r30, new Object[]{IRoom.class, x.class});
    L63:
        r117 = "0";
        goto L64
    L58:
        r28 = null;
        goto L59
    L54:
        r25 = null;
        goto L55
    L50:
        r22 = null;
    L46:
        r115 = "";
        goto L47
    L71:
        return;
    L35:
        r111 = false;
        goto L36
    L23:
        r16 = false;
    L19:
        r15 = 0;
        goto L21
    L11:
        r6 = 0;
        goto L12
    L7:
        r2 = 2131897353;
        goto L8
    }
}
