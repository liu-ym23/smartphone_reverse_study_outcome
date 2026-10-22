package com.obric.oui.sheet.v2;

import android.view.View;
import android.view.Window;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "<anonymous parameter 0>", "", EventBody.KEY_VALUE, "<anonymous parameter 2>", "", "invoke", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SheetAnimStyle$sheetShow$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ View $dimView;
    final /* synthetic */ boolean $enableWindowDimAnim;
    final /* synthetic */ float $endAnimValue;
    final /* synthetic */ float $startAnimValue;
    final /* synthetic */ float $targetDimAmount;
    final /* synthetic */ boolean $useWindowDim;
    final /* synthetic */ Window $window;

    SheetAnimStyle$sheetShow$2(boolean r10, boolean r11, Window r12, float r13, float r14, float r15, View r16) {
        this.$useWindowDim = r10;
        this.$enableWindowDimAnim = r11;
        this.$window = r12;
        this.$startAnimValue = r13;
        this.$endAnimValue = r14;
        this.$targetDimAmount = r15;
        this.$dimView = r16;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r10, Object r11, Object r12) {
        invoke2(r10, r11, r12);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r10, Object r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r12, "<anonymous parameter 2>");
        if (this.$useWindowDim == true) goto L5;
        SheetAnimStyle r13 = SheetAnimStyle.f7431a;
        View r14 = this.$dimView;
        Intrinsics.checkNotNull(r14);
        SheetAnimStyle.a(r13, r14, da.b.f8519a.b(((Float) r11).floatValue(), this.$startAnimValue, this.$endAnimValue), 0.0f, this.$targetDimAmount);
        return;
    L5:
        if (this.$enableWindowDimAnim == false) goto L9;
        SheetAnimStyle r15 = SheetAnimStyle.f7431a;
        Window r16 = this.$window;
        Intrinsics.checkNotNull(r16);
        SheetAnimStyle.b(r15, r16, da.b.f8519a.b(((Float) r11).floatValue(), this.$startAnimValue, this.$endAnimValue), 0.0f, this.$targetDimAmount);
        return;
    }
}
