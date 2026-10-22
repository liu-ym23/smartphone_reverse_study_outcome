package t12;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import pz1.f;
import yz0.k;
import zg1.q2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends l {
    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final AbsPanel<?> f(h1 r3) {
        Intrinsics.checkNotNullParameter(r3, "gift");
        if (r3.getType() == 3) goto L5;
        super.f(r3);
        return null;
    L5:
        return new f(r3);
    }

    public c(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r24, SelectedStatus r25, Integer r26) {
        Intrinsics.checkNotNullParameter(r25, "selectedStatus");
        if (r24 != null) goto L5;
    L52:
        return false;
    L5:
        if (r24.a != 5) goto L52;
        if (u.p() == false) goto L10;
    L42:
        n r1 = new n();
        Map r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        String r3 = vh6.c.b(kr2.a.class).T1();
        Intrinsics.checkNotNullParameter("drawer_page", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r2.put("drawer_page", r3);
        m r4 = new m();
        r4.b(LogCommon.PAGE_SOURCE_LOG);
        r4.b(LogCommon.ROOM);
        ((ArrayList) r1.b).addAll(r4.a);
        e.a.getClass();
        j r5 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r6);
        ((f80.a) r6).w3("livesdk_redpackage_entrance_click", r1.a, r1.b);
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r7 == null) goto L49;
        com.bytedance.live.datacontext.m<GiftContext.a> r8 = r7.getLastSendGiftId();
        if (r8 == null) goto L49;
        GiftContext.a r9 = (GiftContext.a) r8.getValue();
        if (r9 == null) goto L49;
        long r10 = r9.a;
    L50:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.j(new LocateGiftInfo(0, r10, null, 0, false, 0, true, false, null, null, 0, null, 0, 8109, null)));
        return true;
    L49:
        r10 = 0;
        goto L50
    L10:
        if (r25 != SelectedStatus.LOCATE) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == true) goto L42;
        Boolean r13 = (Boolean) this.b.get("data_is_anchor", Boolean.FALSE);
        String r14 = null;
        IRoom r15 = (IRoom) this.b.get("data_room", null);
        com.bytedance.android.livesdk.revenue.service.microom.a r16 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.microom.a.class);
        if (r13.booleanValue() == false) goto L25;
        if (r16 == null) goto L25;
        if (r16.willNext(r15) != true) goto L25;
        k r17 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r17 == null) goto L23;
        long r18 = r17.getForbiddenBeforeEnd();
    L24:
        ToastUtil.b(s1.C(2131920349, new Object[]{Long.valueOf(r18 / ((long) 60))}), 0);
        goto L42
    L23:
        r18 = 300;
    L25:
        GiftContext r19 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r19 == null) goto L33;
        com.bytedance.live.datacontext.n<Bundle> r20 = r19.getGiftLogExtra();
        if (r20 == null) goto L33;
        Bundle r21 = (Bundle) r20.getValue();
        if (r21 == null) goto L33;
        r14 = r21.getString("gift_show_from");
    L33:
        if (TextUtils.equals("icon_feed", r14) == false) goto L41;
        nq2.a r23 = vh6.c.b(nq2.a.class);
        if (r23 == null) goto L41;
        if (r15 == null) goto L39;
        String r27 = r15.getIdStr();
        if (r27 == null) goto L39;
    L40:
        r23.showInteractionAndEnterRoom(r27);
    L39:
        r27 = BuildConfig.FLAVOR;
    L41:
        xs2.b.a().post(new q2(0));
        goto L42
    L12:
        r11 = false;
        goto L13
    }
}
