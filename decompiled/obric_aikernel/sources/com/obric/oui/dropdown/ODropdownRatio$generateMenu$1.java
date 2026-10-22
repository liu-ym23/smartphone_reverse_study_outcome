package com.obric.oui.dropdown;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"V", "Landroid/view/View;", "<anonymous parameter 0>", "", "index", "", "invoke", "(Landroid/view/View;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ODropdownRatio$generateMenu$1 extends Lambda implements Function2<View, Integer, Unit> {
    final /* synthetic */ ODropdownTrigger $caller;
    final /* synthetic */ b this$0;

    ODropdownRatio$generateMenu$1(b r10, ODropdownTrigger r11) {
        this.$caller = r11;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View r10, Integer r11) {
        invoke(r10, r11.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
        Object r12 = b.d(this.this$0).get(r11);
        b.e(this.this$0, r12);
        b.c(this.this$0).invoke(String.valueOf(b.d(this.this$0).get(r11)));
        if ((r12 instanceof a) == false) goto L5;
        this.$caller.getValue().setCompoundDrawablesRelativeWithIntrinsicBounds(((a) r12).a(), 0, 0, 0);
    L5:
        b.b(this.this$0).invoke();
    }
}
