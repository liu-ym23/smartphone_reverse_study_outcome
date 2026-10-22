package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toConfig", "Lcom/obric/oui/color/StrokeConfig;", "Lcom/obric/oui/color/StrokeConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class g {
    public static final e a(f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        float r1 = r4.a();
        int r2 = r4.b();
        BlendMode r5 = r4.c();
        Intrinsics.checkNotNullExpressionValue(r5, "blendMode");
        return new e(r1, r2, r5);
    }
}
