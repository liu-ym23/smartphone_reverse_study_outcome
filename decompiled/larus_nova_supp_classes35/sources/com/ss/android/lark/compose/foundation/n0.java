package com.ss.android.lark.compose.foundation;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n0 {
    public n0(a0 r2, s r3, h0 r4, v0 r5, l r6, x r7) {
        Intrinsics.checkNotNullParameter(r2, "primary");
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r4, ChameleonOpenTracker.OpenResult.SUCCESS);
        Intrinsics.checkNotNullParameter(r5, "warning");
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_ERROR);
        Intrinsics.checkNotNullParameter(r7, "neutral");
    }
}
