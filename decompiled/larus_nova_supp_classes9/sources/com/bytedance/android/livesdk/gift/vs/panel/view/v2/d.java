package com.bytedance.android.livesdk.gift.vs.panel.view.v2;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.manager.PropManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ LiveGiftBottomWidgetKt a;

    public d(LiveGiftBottomWidgetKt r1) {
        this.a = r1;
    }

    public final void onChanged(Object r18) {
        GiftStateMachineConfig.g r0 = (GiftStateMachineConfig.g) r18;
        LiveGiftBottomWidgetKt r2 = this.a;
        int r3 = LiveGiftBottomWidgetKt.t;
        r2.getClass();
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r0 instanceof GiftStateMachineConfig.e.b) == false) goto L8;
    L9:
        r2.yq();
        GiftStateMachineConfig.e r4 = (GiftStateMachineConfig.e) r0;
        if ((r4 instanceof GiftStateMachineConfig.e.b) == false) goto L17;
        GiftStateMachineConfig.c r5 = ((GiftStateMachineConfig.e.b) r4).a;
        if (r5 == null) goto L14;
        List<pz1.e> r6 = r5.c;
    L15:
        if (r6 == null) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L20;
    L69:
        if ((r0 instanceof GiftStateMachineConfig.h.a) == false) goto L72;
        r2.yq();
    L72:
        if ((r0 instanceof GiftStateMachineConfig.a) == false) goto L93;
        r2.zq();
        return;
    L93:
        return;
    L20:
        if (r2.m == true) goto L69;
        r2.m = true;
        int r8 = ((Number) y12.b.d.getValue(null, y12.b.a[2])).intValue();
        if (r8 != 0) goto L38;
        PropManager r9 = PropManager.b();
        r9.getClass();
        if (((System.currentTimeMillis() / 86400000) - (((Number) ay1.b.X.getValue(null, ay1.b.a[61])).longValue() / 86400000)) < 1) goto L35;
        Iterator r10 = ((ArrayList) r9.a).iterator();
    L29:
        if (r10.hasNext() == false) goto L35;
        l2 r11 = (l2) r10.next();
        if (r11.getNextExpire() <= 0) goto L29;
        if ((r11.getNextExpire() - ((System.currentTimeMillis() / 1000) + r11.getNowTimeDiff())) >= PropManager.d) goto L29;
        ay1.b.X.setValue(null, ay1.b.a[61], Long.valueOf(System.currentTimeMillis()));
        boolean r13 = true;
    L36:
        if (r13 == false) goto L52;
        ToastUtil.a(2131919789, 0);
    L52:
        PropManager r14 = PropManager.b();
        r14.getClass();
        HashSet<Long> r15 = ay1.b.t();
        Iterator r16 = ((ArrayList) r14.a).iterator();
    L54:
        if (r16.hasNext() == false) goto L60;
        l2 r17 = (l2) r16.next();
        if (r17.getReddotTip() == false) goto L54;
        if (r15.contains(Long.valueOf(r17.getId())) == true) goto L54;
        boolean r19 = true;
    L61:
        if (r19 == false) goto L69;
        Iterator r20 = ((ArrayList) r2.j).iterator();
    L64:
        if (r20.hasNext() == false) goto L69;
        LiveGiftBottomWidgetKt.b r21 = (LiveGiftBottomWidgetKt.b) r20.next();
        if (r21.b != 5) goto L64;
        r21.c = true;
        r2.l = true;
        goto L69
    L60:
        r19 = ay1.b.v();
    L35:
        r13 = false;
        goto L36
    L38:
        if (r8 == 1) goto L42;
        if (r8 != 4) goto L52;
    L42:
        if (PropManager.b().a(PropManager.ExpirePropShowType.TOAST) == false) goto L45;
        String r23 = rm3.c.a;
        rm3.c.f(((Widget) r2).context, 2131919790, false, 16);
    L45:
        if (PropManager.b().a(PropManager.ExpirePropShowType.RED_DOT) == false) goto L52;
        Iterator r24 = ((ArrayList) r2.j).iterator();
    L48:
        if (r24.hasNext() == false) goto L52;
        LiveGiftBottomWidgetKt.b r25 = (LiveGiftBottomWidgetKt.b) r24.next();
        if (r25.b != 5) goto L48;
        r25.c = true;
        r2.l = true;
        goto L69
    L14:
        r6 = null;
    L17:
        r7 = false;
        goto L18
    L8:
        if ((r0 instanceof GiftStateMachineConfig.e.c) == false) goto L69;
        goto L9
    }
}
