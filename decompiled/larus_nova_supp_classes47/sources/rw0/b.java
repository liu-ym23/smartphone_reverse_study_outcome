package rw0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.utils.p;
import com.bytedance.android.live.revlink.api.ILinkService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements a {
    public final boolean a;
    public final long b;

    public b() {
        this.a = p.a();
        Long r0 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService().J();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        this.b = r1;
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r3, com.bytedance.android.live.recharge.model.d r4) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r4, "entranceParams");
        ew0.e.a(r4, r3);
        if (this.a == false) goto L5;
        String r5 = DataType.TRUE;
    L6:
        r3.put("is_in_pk", r5);
        r3.put("pk_left_time", String.valueOf(this.b));
        return;
    L5:
        r5 = DataType.FALSE;
        goto L6
    }
}
