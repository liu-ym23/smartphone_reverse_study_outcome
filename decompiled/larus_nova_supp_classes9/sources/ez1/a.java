package ez1;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import dq2.g;
import dq2.u;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends l {
    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, k r8, k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r7, "showInfo");
        return false;
    }

    public a(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, boolean r7, n r8, k r9, k r10, l1 r11, com.bytedance.android.livesdk.gift.model.n r13, String r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r8, "showInfo");
        if (r1 != null) goto L6;
        return false;
    L6:
        if (j0.c(r1) == false) goto L43;
        DataCenter r17 = this.b;
        if (r17 == null) goto L12;
        Boolean r18 = (Boolean) r17.get("data_is_portrait", Boolean.TRUE);
        if (r18 == null) goto L12;
        boolean r19 = r18.booleanValue();
    L13:
        if (r19 == true) goto L15;
        xs2.b.a().post(new HorizontalPlayEvent(1, "source_for_live_recharge"));
    L15:
        Context r20 = getContext();
        Object r21 = r1.h;
        List r23 = null;
        if ((r21 instanceof h1) == true) goto L18;
        r21 = null;
    L18:
        h1 r24 = (h1) r21;
        if (r24 == null) goto L41;
        String r25 = (String) b.b.getValue(null, b.a[0]);
        LinkedHashMap r26 = new LinkedHashMap();
        if (r24.getGiftMsgBoard() == null) goto L24;
        r26.put("gift_id", String.valueOf(r24.getId()));
    L24:
        r26.put("live_type", c.b(d.class).getLiveTypeForLog());
        r26.put("to_user_id", r4.getIdString());
        r26.put("function_type", c.b(d.class).getCurrentFunctionType());
        yz0.k r27 = f.d(j.C0.a(), yz0.k.class);
        if (r27 == null) goto L31;
        g r28 = r27.getVideoTalkRoomSubScene();
        if (r28 == null) goto L31;
        u r29 = r28.t();
        if (r29 == null) goto L31;
        r23 = r29.a.b;
    L31:
        d r30 = c.b(d.class);
        if (r23 != null) goto L35;
        r26.put("seat_fit_status", "off");
    L38:
        String r31 = com.bytedance.android.live.revenue.common.u.b(r25, r26);
        if (r20 == null) goto L41;
        f.a(zz0.g.class).S2(r20, r31);
        goto L41
    L35:
        if (r30.Dk(r23) == false) goto L37;
        r26.put("seat_fit_status", "on");
        goto L38
    L37:
        r26.put("seat_fit_status", "off");
    L41:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 6));
        return true;
    L12:
        r19 = true;
        goto L13
    L43:
        return false;
    }
}
