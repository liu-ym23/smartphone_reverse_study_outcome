package com.obric.oui.common.style;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "velocity", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ShadowAnimator$startVisibilityAnim$1 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ List<m> $newShadow;
    final /* synthetic */ List<m> $oldShadow;
    final /* synthetic */ i $ouiLayout;

    public ShadowAnimator$startVisibilityAnim$1(List<m> r5, List<m> r10, i r11) {
        this.$oldShadow = r5;
        this.$newShadow = r10;
        this.$ouiLayout = r11;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r5, Object r10, Object r11) {
        invoke2(r5, r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r5, Object r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "$noName_0");
        Intrinsics.checkNotNullParameter(r10, "value");
        Intrinsics.checkNotNullParameter(r11, "velocity");
        float r12 = ((Float) r10).floatValue();
        m r13 = m.f12515h;
        List r14 = n.b(r12, this.$oldShadow, this.$newShadow);
        if (r14 == null) goto L7;
        this.$ouiLayout.c(r14);
        return;
    }
}
