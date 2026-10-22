package com.obric.oui.sheet.v2;

import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "<anonymous parameter 2>", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SheetAnimStyle$sheetPositionSmoothReset$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ float $currentDim;
    final /* synthetic */ View $dimView;
    final /* synthetic */ boolean $enableDimAnim;
    final /* synthetic */ float $endAnimValue;
    final /* synthetic */ float $startAnimValue;
    final /* synthetic */ float $targetDimAmount;
    final /* synthetic */ boolean $useWindowDim;
    final /* synthetic */ Window $window;

    public SheetAnimStyle$sheetPositionSmoothReset$2(boolean r5, boolean r10, Window r11, float r12, float r13, float r14, float r15, View r16) {
        this.$enableDimAnim = r5;
        this.$useWindowDim = r10;
        this.$window = r11;
        this.$startAnimValue = r12;
        this.$endAnimValue = r13;
        this.$currentDim = r14;
        this.$targetDimAmount = r15;
        this.$dimView = r16;
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
        Intrinsics.checkNotNullParameter(r11, "$noName_2");
        if (this.$enableDimAnim == true) goto L5;
        return;
    L5:
        if (this.$useWindowDim == false) goto L7;
        Window r12 = this.$window;
        Intrinsics.checkNotNull(r12);
        o.b(r12, ym.a.i(((Float) r10).floatValue(), this.$startAnimValue, this.$endAnimValue), this.$currentDim, this.$targetDimAmount);
        return;
    L7:
        View r13 = this.$dimView;
        Intrinsics.checkNotNull(r13);
        o.a(r13, ym.a.i(((Float) r10).floatValue(), this.$startAnimValue, this.$endAnimValue), this.$currentDim, this.$targetDimAmount);
    }
}
