package rw0;

import com.bytedance.android.live.profile.monitor.DataType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements a {
    public final g a;

    public h(g r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedDealLog");
        this.a = r2;
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r2, com.bytedance.android.live.recharge.model.d r3) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        Intrinsics.checkNotNullParameter(r3, "entranceParams");
        String r0 = r2.get("is_discount_package");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (this.a.a.h() <= 0) goto L13;
        String r4 = DataType.TRUE;
    L14:
        r2.put("is_discount_package", r4);
        return;
    L13:
        r4 = DataType.FALSE;
        goto L14
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
