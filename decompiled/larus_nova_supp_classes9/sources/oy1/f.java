package oy1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.common.utility.NetworkUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements a {
    public f() {
    }

    @Override // oy1.a
    public final boolean a(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "gift");
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == true) goto L6;
        ToastUtil.a(2131916005, 0);
        return false;
    L6:
        return true;
    }
}
