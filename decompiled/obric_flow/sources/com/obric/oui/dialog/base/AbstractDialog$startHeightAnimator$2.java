package com.obric.oui.dialog.base;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "<anonymous parameter 2>", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class AbstractDialog$startHeightAnimator$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ View $container;
    final /* synthetic */ d this$0;

    public AbstractDialog$startHeightAnimator$2(d r5, View r10) {
        this.this$0 = r5;
        this.$container = r10;
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
        float r12 = ((Float) r10).floatValue();
        this.this$0.getClass();
        View r13 = this.$container;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        r14.height = (int) r12;
        r13.setLayoutParams(r14);
    }
}
