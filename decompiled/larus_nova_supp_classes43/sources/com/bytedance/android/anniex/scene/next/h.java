package com.bytedance.android.anniex.scene.next;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final PredictElementType a;
    public final List<xa.b<?>> b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "StrategyPredictionSet(elementType=" + this.a + ", predictions=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(PredictElementType r10, List<? extends xa.b<?>> r11) {
        Intrinsics.checkNotNullParameter(r10, "elementType");
        Intrinsics.checkNotNullParameter(r11, "predictions");
        this.a = r10;
        this.b = r11;
    }
}
