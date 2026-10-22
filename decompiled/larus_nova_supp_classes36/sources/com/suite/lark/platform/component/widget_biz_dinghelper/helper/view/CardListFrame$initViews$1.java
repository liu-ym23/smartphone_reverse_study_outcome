package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public /* synthetic */ class CardListFrame$initViews$1 extends FunctionReferenceImpl implements Function2<Integer, View, Unit> {
    public CardListFrame$initViews$1(Object r8) {
        super(2, r8, CardListFrame.class, "onCardViewClicked", "onCardViewClicked(ILandroid/view/View;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), (View) r2);
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        CardListFrame.a((CardListFrame) ((CallableReference) this).receiver, r2);
    }
}
