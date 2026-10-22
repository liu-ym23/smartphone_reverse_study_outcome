package oy1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements a {
    public c() {
    }

    @Override // oy1.a
    public final boolean a(h1 r7) {
        Intrinsics.checkNotNullParameter(r7, "gift");
        k0 r0 = r7.getGiftPreviewInfo();
        if (r0 != null) goto L5;
    L6:
        k0 r8 = r7.getGiftPreviewInfo();
        if (r8 != null) goto L9;
    L22:
        return true;
    L9:
        if (r8.getClientBlockUseSchemeUrl() == false) goto L22;
        if (r8.getBlockToast().length() <= 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L20;
        String r2 = UriProtector.parse(r8.getBlockSchemeUrl()).getHost();
        if (r2 != null) goto L18;
    L19:
        int r3 = ToastUtil.a;
        ToastUtil.b(r8.getBlockToast(), 0);
        goto L20
    L18:
        if (StringsKt.startsWith$default(r2, "webcast_inroom_toast", false, 2, null) != true) goto L19;
    L20:
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(s1.getContext(), r8.getBlockSchemeUrl());
        return false;
    L13:
        r1 = false;
        goto L14
    L5:
        if (r0.getLockStatus() == k0.UNLOCKED) goto L22;
        goto L6
    }
}
