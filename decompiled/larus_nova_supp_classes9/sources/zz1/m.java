package zz1;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTabDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.TabChangeSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.q0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.n3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements j12.b, com.bytedance.android.scope.o {
    public final GiftTabDataStore a;
    public final n3 b;
    public final GiftTopicDataStore c;
    public final PropListService d;
    public final u1 e;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f f;
    public final yz0.k g;
    public final q0 h;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // j12.b
    public final void clickTab(int r18, int r19, Map<String, String> r20, int r21, long r23) {
        GiftTabDataStore r3 = this.a;
        vz1.j r4 = (vz1.j) r3.h.getValue(r3, GiftTabDataStore.p[2]);
        this.a.F(new vz1.j(r18, r19, TabChangeSource.Click), r20, r21);
        String r5 = null;
        if (r19 != 5) goto L17;
        n3 r8 = this.b;
        r8.getClass();
        com.bytedance.tools.kcp.spongepreference.runtime.a r10 = ay1.b.E;
        KProperty[] r11 = ay1.b.a;
        if (((Boolean) r10.getValue(null, r11[35])).booleanValue() == false) goto L7;
    L11:
        boolean r9 = false;
    L12:
        if (r9 == false) goto L15;
        ToastUtil.a(2131919970, 0);
    L15:
        this.d.d();
        goto L17
    L7:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(r8.b.a) == false) goto L11;
        if ((!((ArrayList) r8.c.a).isEmpty()) == false) goto L11;
        r10.setValue(null, r11[35], Boolean.TRUE);
        r9 = true;
    L17:
        if (r23 == (-1)) goto L19;
        GiftTopicDataStore r13 = this.c;
        r13.getClass();
        r13.u = new Pair(Long.valueOf(r19), Long.valueOf(r23));
    L19:
        if (r4 != null) goto L21;
    L23:
        if (r4 == null) goto L27;
        Map<Integer, Integer> r14 = tz1.a.a;
        if (tz1.a.d(r4.b) == false) goto L27;
        this.e.J0(r21, r19, r20);
    L27:
        u1 r1 = this.e;
        if (r4 == null) goto L30;
        int r6 = r4.b;
    L31:
        String r15 = this.f.a.getIdString();
        IRoom r16 = this.g.getRoom();
        if (r19 == 5) goto L34;
    L36:
        boolean r7 = false;
    L37:
        List<? extends o2> r17 = this.h.c;
        if (r17 == null) goto L52;
        Iterator<T> r110 = r17.iterator();
    L41:
        if (r110.hasNext() == false) goto L48;
        Object r111 = r110.next();
        if (((o2) r111).getRelatedTopicId() != r23) goto L45;
        boolean r112 = true;
    L46:
        if (r112 == false) goto L41;
    L49:
        o2 r113 = (o2) r111;
        if (r113 == null) goto L52;
        r5 = r113.getName();
        goto L52
    L45:
        r112 = false;
        goto L46
    L48:
        r111 = null;
    L52:
        r1.e1(r19, r6, "click", r15, r16, r7, r5, r20);
        return;
    L34:
        if ((!((ArrayList) this.d.a).isEmpty()) == false) goto L36;
        r7 = true;
        goto L37
    L30:
        r6 = 0;
        goto L31
    L21:
        if (r19 != r4.b) goto L23;
        this.c.s(r19);
        goto L23
    }

    public m(GiftTabDataStore r2, GiftDialogStateDataStore r3, n3 r4, GiftTopicDataStore r5, PropListService r6, u1 r7, DataCenter r8, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r9, yz0.k r10, q0 r11) {
        Intrinsics.checkNotNullParameter(r2, "tabDataStore");
        Intrinsics.checkNotNullParameter(r3, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r4, "propTipService");
        Intrinsics.checkNotNullParameter(r5, "giftTopicDataStore");
        Intrinsics.checkNotNullParameter(r6, "propListService");
        Intrinsics.checkNotNullParameter(r7, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "receiverService");
        Intrinsics.checkNotNullParameter(r10, "roomDataService");
        Intrinsics.checkNotNullParameter(r11, "topicRepo");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r11;
    }
}
