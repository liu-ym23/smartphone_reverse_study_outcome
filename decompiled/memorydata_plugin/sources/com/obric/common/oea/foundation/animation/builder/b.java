package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"animator", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "Landroid/view/View;", "animationSpeed", "", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class b {
    public static final a.C0372a a(View r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$animator");
        return new a.C0372a(r1).a(r2, 90.0f);
    }

    public static /* synthetic */ a.C0372a a(View r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        return a(r0, r1);
    }
}
