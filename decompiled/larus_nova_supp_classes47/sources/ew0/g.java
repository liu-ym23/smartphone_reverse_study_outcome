package ew0;

import com.bytedance.android.live.profile.monitor.DataType;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements dw0.a {
    public static final g a = null;

    public g() {
    }

    static {
        a = new g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dw0.a
    public final void a(String r4, Map<String, String> r5, Collection<? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "eventProperties");
        Intrinsics.checkNotNullParameter(r6, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r7 = com.bytedance.android.live.recharge.panel.g.a();
        if (r7 == null) goto L26;
        com.bytedance.android.live.revenue.common.reactive.c r8 = r7.d();
        if (r8 == null) goto L27;
        com.bytedance.android.live.recharge.deal.f r9 = (com.bytedance.android.live.recharge.deal.f) r8.b;
        if (r9 == null) goto L29;
        CharSequence r10 = (CharSequence) ((LinkedHashMap) r5).get("is_discount_package");
        boolean r1 = true;
        if (r10 != null) goto L12;
    L15:
        boolean r12 = true;
    L16:
        if (r12 == true) goto L18;
        return;
    L18:
        if (r9.h() > 0) goto L21;
        r1 = false;
    L21:
        if (r1 == false) goto L23;
        String r13 = DataType.TRUE;
    L24:
        r5.put("is_discount_package", r13);
        return;
    L23:
        r13 = DataType.FALSE;
        goto L24
    L12:
        if (r10.length() == 0) goto L15;
        r12 = false;
        goto L16
    L29:
        return;
    L27:
        return;
    }
}
