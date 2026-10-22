package zz1;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftGroupCardDataStore;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oc6.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements p, com.bytedance.android.scope.o {
    public final GiftGroupCardDataStore a;
    public final u1 b;
    public final GiftDialogStateDataStore c;
    public final e1 d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void sendLog(String r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "eventName");
        Intrinsics.checkNotNullParameter(r14, "params");
        u1 r1 = this.b;
        h1 r2 = this.c.q();
        if (r2 == null) goto L5;
        long r3 = r2.getId();
    L6:
        int r4 = this.c.w();
        Iterator r5 = ((LinkedHashMap) this.d.c).keySet().iterator();
    L7:
        boolean r8 = false;
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        int r9 = ((Number) r6).intValue();
        Map<Integer, Integer> r10 = this.d.c;
        LinkedHashMap r11 = (LinkedHashMap) r10;
        Integer r15 = (Integer) r11.get(Integer.valueOf(r9));
        int r16 = this.c.w();
        if (r15 != null) goto L13;
    L15:
        boolean r17 = false;
    L16:
        if (r17 == false) goto L7;
    L19:
        Integer r7 = (Integer) r6;
        if (r7 == null) goto L22;
        int r18 = r7.intValue();
    L23:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, "eventName");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r14 == null) goto L26;
        r0.putAll(r14);
    L26:
        r0.put("gift_id", String.valueOf(r3));
        GiftContext r19 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r19 == null) goto L32;
        com.bytedance.live.datacontext.m<String> r110 = r19.getGiftListResultLogId();
        if (r110 == null) goto L32;
        String r111 = (String) r110.getValue();
        if (r111 == null) goto L32;
    L33:
        r0.put("gift_dialog_request_id", r111);
        r0.put("tab_location", String.valueOf(r18 + 1));
        GiftContext r112 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r112 == null) goto L40;
        com.bytedance.live.datacontext.n<Integer> r113 = r112.getCurrentSelectedGiftPosition();
        if (r113 == null) goto L40;
        Integer r114 = (Integer) r113.getValue();
        if (r114 == null) goto L40;
        int r115 = r114.intValue();
    L41:
        int r20 = 8;
        int r116 = (r115 + 1) % 8;
        if (r116 == 0) goto L45;
        r8 = true;
    L45:
        int[] r21 = r1.e;
        if (r8 == false) goto L49;
        r20 = r116;
    L49:
        r0.put("gift_location", String.valueOf(r21[r20]));
        r0.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r4));
        r1.p1(r13, r0, true);
        return;
    L40:
        r115 = 0;
    L32:
        r111 = BuildConfig.FLAVOR;
        goto L33
    L22:
        r18 = -1;
        goto L23
    L13:
        if (r15.intValue() != r16) goto L15;
        r17 = true;
        goto L16
    L18:
        r6 = null;
        goto L19
    L5:
        r3 = 0;
        goto L6
    }

    public final void selectGroupCard(int r3, String r4, long r5) {
        GiftGroupCardDataStore r0 = this.a;
        oc6.g r1 = new oc6.g();
        r1.c(r3);
        r1.d(r4);
        r1.e(r5);
        Unit r6 = Unit.INSTANCE;
        r0.o(r1);
    }

    public g(GiftGroupCardDataStore r2, u1 r3, GiftDialogStateDataStore r4, e1 r5) {
        Intrinsics.checkNotNullParameter(r2, "groupCardDataStore");
        Intrinsics.checkNotNullParameter(r3, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftListService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
