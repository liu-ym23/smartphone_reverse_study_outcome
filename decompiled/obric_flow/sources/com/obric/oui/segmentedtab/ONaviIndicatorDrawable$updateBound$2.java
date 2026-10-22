package com.obric.oui.segmentedtab;

import ai.j0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "velocity", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ONaviIndicatorDrawable$updateBound$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ f this$0;

    public ONaviIndicatorDrawable$updateBound$2(f r5) {
        this.this$0 = r5;
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
        this.this$0.getClass();
        float r12 = ((Float) r10).floatValue();
        f r13 = this.this$0;
        r13.getClass();
        float r14 = r13.f14374k * 0.0f;
        float r15 = j0.b(0.0f, r14, r12, r14);
        if (r13.d == r15) goto L6;
        r13.d = r15;
        r13.invalidateSelf();
    L6:
        float r16 = r13.f14372i;
        float r17 = r13.f14375l * r16;
        float r18 = j0.b(r16, r17, r12, r17);
        if (r13.e == r18) goto L11;
        r13.e = r18;
        r13.invalidateSelf();
        return;
    }
}
