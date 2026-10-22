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
final class SheetAnimStyle$sheetHide$animBuilder$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ View $dimView;
    final /* synthetic */ boolean $enableWindowDimAnim;
    final /* synthetic */ float $endAnimValue;
    final /* synthetic */ Runnable $endCallback;
    final /* synthetic */ float $endDim;
    final /* synthetic */ float $startAnimValue;
    final /* synthetic */ float $startDim;
    final /* synthetic */ View $this_sheetHide;
    final /* synthetic */ boolean $useWindowDim;
    final /* synthetic */ Window $window;

    SheetAnimStyle$sheetHide$animBuilder$2(View r10, boolean r11, boolean r12, Window r13, float r14, float r15, float r16, float r17, View r18, Runnable r19) {
        this.$this_sheetHide = r10;
        this.$useWindowDim = r11;
        this.$enableWindowDimAnim = r12;
        this.$window = r13;
        this.$startAnimValue = r14;
        this.$endAnimValue = r15;
        this.$startDim = r16;
        this.$endDim = r17;
        this.$dimView = r18;
        this.$endCallback = r19;
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
        SheetAnimStyle.a(r13, r14, da.b.f8519a.b(((Float) r11).floatValue(), this.$startAnimValue, this.$endAnimValue), this.$startDim, this.$endDim);
    L9:
        if (((Float) r11).floatValue() <= this.$this_sheetHide.getHeight()) goto L14;
        Runnable r15 = this.$endCallback;
        if (r15 == null) goto L15;
        r15.run();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (this.$enableWindowDimAnim == false) goto L9;
        SheetAnimStyle r16 = SheetAnimStyle.f7431a;
        Window r17 = this.$window;
        Intrinsics.checkNotNull(r17);
        SheetAnimStyle.b(r16, r17, da.b.f8519a.b(((Float) r11).floatValue(), this.$startAnimValue, this.$endAnimValue), this.$startDim, this.$endDim);
        goto L9
    }
}
