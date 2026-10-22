package bw0;

import com.bytedance.android.live.profile.monitor.DataType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import wp2.d;
import wp2.i;
import wp2.k;
import wp2.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements i {
    public final /* synthetic */ a.d a;

    public b(a.d r1) {
        this.a = r1;
    }

    public final void a(d r9) {
        if ((r9 instanceof n) == true) goto L5;
        d r0 = null;
    L6:
        n r1 = (n) r0;
        jy0.b.d("Recharge/RechargeClientAiService", "Request completed:(isSuccess: " + Boolean.valueOf(((k) r9).a) + ", code: " + Integer.valueOf(((k) r9).b) + ", res; null)");
        a r2 = this.a.a;
        Pair[] r3 = new Pair[6];
        Boolean r10 = Boolean.valueOf(((k) r9).a);
        if (r10 == null) goto L9;
        boolean r12 = r10.booleanValue();
    L11:
        if (r12 == false) goto L13;
        String r13 = DataType.TRUE;
    L14:
        r3[0] = TuplesKt.to("success", r13);
        if (r1 == null) goto L17;
        String r14 = String.valueOf(((k) r1).b);
    L19:
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        r3[1] = TuplesKt.to("errorCode", r14);
        r3[2] = TuplesKt.to("errorDesc", "");
        r3[3] = TuplesKt.to("should_preorder", String.valueOf(0));
        r3[4] = TuplesKt.to("should_preload", DataType.FALSE);
        r3[5] = TuplesKt.to("predict_cost", String.valueOf(System.currentTimeMillis() - this.a.b));
        a.E1(r2, "livesdk_charge_preorder_runtask_result", MapsKt.mutableMapOf(r3), null);
        a.J1(this.a.a);
        return;
    L17:
        r14 = null;
        goto L19
    L13:
        r13 = DataType.FALSE;
        goto L14
    L9:
        r12 = false;
        goto L11
    L5:
        r0 = r9;
        goto L6
    }
}
