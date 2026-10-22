package ew0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.j;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements dw0.a {
    public static final f a = null;

    public f() {
    }

    static {
        a = new f();
    }

    @Override // dw0.a
    public final void a(String r4, Map<String, String> r5, Collection<? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "eventProperties");
        Intrinsics.checkNotNullParameter(r6, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r7 = com.bytedance.android.live.recharge.panel.g.a();
        if (r7 == null) goto L7;
        com.bytedance.android.live.revenue.common.reactive.e<i> r8 = r7.g();
        if (r8 == null) goto L7;
        i r9 = r8.getValue();
    L8:
        boolean r10 = j.b(r9);
        if (r10 == true) goto L11;
    L13:
        boolean r12 = false;
    L14:
        String r0 = DataType.TRUE;
        if (r10 == false) goto L17;
        String r13 = DataType.TRUE;
    L18:
        r5.put("is_fast_pay", r13);
        if (r12 == true) goto L22;
        r0 = DataType.FALSE;
    L22:
        r5.put("open_fast_pay_opt", r0);
        return;
    L17:
        r13 = DataType.FALSE;
        goto L18
    L11:
        if (com.bytedance.android.live.recharge.util.g.a().a() == false) goto L13;
        r12 = true;
    L7:
        r9 = null;
        goto L8
    }
}
