package oy1;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements a {
    public g() {
    }

    @Override // oy1.a
    public final boolean a(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "gift");
        if (vh6.c.b(wh6.a.class).isNeedProtectUnderage() == false) goto L6;
        ToastUtil.a(2131919796, 0);
        return false;
    L6:
        return true;
    }
}
