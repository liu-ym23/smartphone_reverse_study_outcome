package ew0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.utils.n;
import com.bytedance.android.live.recharge.utils.p;
import com.bytedance.android.live.revlink.api.ILinkService;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements dw0.a {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    @Override // dw0.a
    public final void a(String r6, Map<String, String> r7, Collection<? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "eventProperties");
        Intrinsics.checkNotNullParameter(r8, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r9 = com.bytedance.android.live.recharge.panel.g.a();
        if (r9 == null) goto L7;
        com.bytedance.android.live.recharge.model.d r10 = r9.a();
        if (r10 == null) goto L7;
        e.a(r10, r7);
    L7:
        Boolean r12 = null;
        if (r9 == null) goto L12;
        com.bytedance.android.live.revenue.common.reactive.e<i> r13 = r9.g();
        if (r13 == null) goto L12;
        i r14 = r13.getValue();
    L13:
        if (r14 == null) goto L15;
        Boolean r0 = Boolean.valueOf(r14.m());
    L16:
        boolean r1 = false;
        if (r0 == null) goto L19;
        boolean r2 = r0.booleanValue();
    L20:
        String r3 = DataType.TRUE;
        if (r2 == false) goto L23;
        String r4 = DataType.TRUE;
    L24:
        r7.put("is_first_recharge", r4);
        if (r14 == null) goto L27;
        r12 = Boolean.valueOf(r14.isOneStep());
    L27:
        if (r12 == null) goto L29;
        r1 = r12.booleanValue();
    L29:
        if (r1 == false) goto L31;
        String r15 = DataType.TRUE;
    L32:
        r7.put("is_integration_recharge", r15);
        n.c(r7);
        n.b(r7);
        if (p.a() == true) goto L36;
        r3 = DataType.FALSE;
    L36:
        r7.put("is_in_pk", r3);
        Long r16 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService().J();
        if (r16 == null) goto L39;
        long r5 = r16.longValue();
    L40:
        r7.put("pk_left_time", String.valueOf(r5));
        return;
    L39:
        r5 = 0;
        goto L40
    L31:
        r15 = DataType.FALSE;
        goto L32
    L23:
        r4 = DataType.FALSE;
        goto L24
    L19:
        r2 = false;
        goto L20
    L15:
        r0 = null;
    L12:
        r14 = null;
        goto L13
    }
}
