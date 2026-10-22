package com.bytedance.android.anniex.scene.next.strategy;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends wa.c {
    public final String b;

    public d() {
        this.b = "RepeatThresholdStrategy";
    }

    @Override // wa.b
    public final String getName() {
        return this.b;
    }

    @Override // wa.b
    public final List<xa.b<Boolean>> a(com.bytedance.android.anniex.scene.next.a r10) {
        com.bytedance.android.anniex.scene.next.f r11 = (com.bytedance.android.anniex.scene.next.f) r10;
        Intrinsics.checkNotNullParameter(r11, "input");
        float r0 = ((Number) SwitchCenter.b0.getValue()).floatValue();
        Double r12 = r11.d;
        if (r12 == null) goto L9;
        double r1 = r12.doubleValue();
        if (r1 <= r0) goto L11;
        return CollectionsKt.listOf(new xa.b(PredictElementType.SceneRepeat, Boolean.TRUE, r1));
    L11:
        return CollectionsKt.listOf(new xa.b(PredictElementType.SceneRepeat, Boolean.FALSE, r1));
    L9:
        return CollectionsKt.emptyList();
    }
}
