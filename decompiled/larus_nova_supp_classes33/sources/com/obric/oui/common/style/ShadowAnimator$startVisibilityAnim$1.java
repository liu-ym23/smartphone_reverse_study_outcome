package com.obric.oui.common.style;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "velocity", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ShadowAnimator$startVisibilityAnim$1 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ List<q> $newShadow;
    final /* synthetic */ List<q> $oldShadow;
    final /* synthetic */ l $ouiLayout;

    public ShadowAnimator$startVisibilityAnim$1(List<q> r1, List<q> r2, l r3) {
        this.$oldShadow = r1;
        this.$newShadow = r2;
        this.$ouiLayout = r3;
        super(3);
    }

    public final void invoke(String r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, "value");
        Intrinsics.checkNotNullParameter(r4, "velocity");
        float r5 = ((Float) r3).floatValue();
        q r6 = q.h;
        List<q> r7 = q.a.b(r5, this.$oldShadow, this.$newShadow);
        if (r7 == null) goto L7;
        this.$ouiLayout.C1(r7);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, r2, r3);
        return Unit.INSTANCE;
    }
}
