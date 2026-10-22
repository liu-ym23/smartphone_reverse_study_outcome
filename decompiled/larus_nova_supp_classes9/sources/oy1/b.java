package oy1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements a {
    public b() {
    }

    @Override // oy1.a
    public final boolean a(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "gift");
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene() != 10) goto L6;
        int r3 = ToastUtil.a;
        ToastUtil.b(s1.B(2131911883), 0);
        return false;
    L6:
        return true;
    }
}
