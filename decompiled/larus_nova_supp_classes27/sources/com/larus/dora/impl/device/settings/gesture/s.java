package com.larus.dora.impl.device.settings.gesture;

import com.bytedance.dora.annotation.ProductNameType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s {
    public final List<LastSwitchSide> a;

    public s(Integer r5) {
        int r0 = ProductNameType.DORA_G2.id;
        if (r5 != null) goto L6;
    L8:
        List<LastSwitchSide> r6 = CollectionsKt.listOf(new LastSwitchSide[]{LastSwitchSide.LEFT, LastSwitchSide.BUTTON, LastSwitchSide.RIGHT});
    L9:
        this.a = r6;
        return;
    L6:
        if (r5.intValue() != r0) goto L8;
        r6 = CollectionsKt.listOf(new LastSwitchSide[]{LastSwitchSide.BUTTON, LastSwitchSide.RIGHT});
        goto L9
    }

    public final boolean a(LastSwitchSide r2) {
        Intrinsics.checkNotNullParameter(r2, "side");
        return this.a.contains(r2);
    }

    public final LastSwitchSide b(LastSwitchSide r2) {
        Intrinsics.checkNotNullParameter(r2, "side");
        if (a(r2) == false) goto L6;
        return r2;
    L6:
        return LastSwitchSide.BUTTON;
    }
}
