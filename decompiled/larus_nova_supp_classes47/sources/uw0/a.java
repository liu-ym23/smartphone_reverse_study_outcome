package uw0;

import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.panel.g;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tw0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b {
    public final i a;

    public a(i r2) {
        Intrinsics.checkNotNullParameter(r2, "option");
        this.a = r2;
    }

    @Override // uw0.b
    public final k a(k r6) {
        Intrinsics.checkNotNullParameter(r6, "orderOptions");
        j r0 = r6.a;
        Map<String, String> r1 = this.a.J8();
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        r0.putAll(r1);
        Map<String, String> r2 = r6.l;
        Map<String, String> r3 = this.a.G0();
        if (r3 != null) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        r2.putAll(r3);
        Map<String, String> r4 = r6.m;
        Map<String, String> r5 = this.a.I4();
        if (r5 != null) goto L11;
        r5 = MapsKt.emptyMap();
    L11:
        r4.putAll(r5);
        com.bytedance.android.live.recharge.panel.context.c r7 = g.a();
        if (r7 == null) goto L14;
        com.bytedance.android.live.recharge.model.d r8 = r7.a();
    L15:
        if (r8 == null) goto L22;
        Map<String, String> r9 = r8.m;
        if (r9 == null) goto L22;
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        Map.Entry<String, String> r12 = r10.next();
        d60.b.a(r6.j, r12.getKey(), r12.getValue());
    L22:
        if (r8 != null) goto L24;
    L34:
        Map<String, String> r13 = this.a.getBizExtra();
        if (r13 == null) goto L40;
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();
    L38:
        if (r14.hasNext() == false) goto L40;
        Map.Entry<String, String> r15 = r14.next();
        d60.b.a(r6.j, r15.getKey(), r15.getValue());
    L40:
        int r16 = com.bytedance.android.live.recharge.order.i.d;
        com.bytedance.android.live.recharge.order.i r17 = com.bytedance.android.live.recharge.order.i.a.a(r8);
        r6.l.put("recharge_channel", r17.a());
        return r6;
    L24:
        if (com.bytedance.android.live.recharge.nopassword.g.c(r8) == false) goto L26;
    L32:
        RechargeBizScene r18 = RechargeBizScene.SCENE_FANS_NOPASSWORD;
    L33:
        d60.b.a(r6.j, "biz_scene", String.valueOf(r18.getScene()));
        goto L34
    L26:
        if (com.bytedance.android.live.recharge.nopassword.g.a(r8) == true) goto L32;
        if (com.bytedance.android.live.recharge.nopassword.g.b() == false) goto L31;
        r18 = RechargeBizScene.SCENE_PK_NOPASSWORD;
        goto L33
    L31:
        r18 = RechargeBizScene.SCENE_NORMAL;
        goto L33
    L14:
        r8 = null;
        goto L15
    }
}
