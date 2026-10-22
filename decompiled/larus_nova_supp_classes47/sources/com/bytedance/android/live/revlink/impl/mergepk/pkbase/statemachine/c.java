package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PKBizType;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final PKBizType a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkBizType");
        IBaseBattleSetting r2 = r1.a;
        if (r2 == null) goto L7;
        PKBizType r3 = b(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return PKBizType.ClassicDouble;
    }

    public static final PKBizType b(IBaseBattleSetting r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$pkBizType");
        int r3 = r2.getBattleType();
        PKBizType r0 = PKBizType.ClassicMulti;
        if (r3 != r0.ordinal()) goto L6;
        return r0;
    L6:
        return PKBizType.ClassicDouble;
    }
}
