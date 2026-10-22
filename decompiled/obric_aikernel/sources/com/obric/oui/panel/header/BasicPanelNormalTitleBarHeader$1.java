package com.obric.oui.panel.header;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ImageView;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/obric/oui/titlebar/OTitleBar;", "", "invoke", "(Lcom/obric/oui/titlebar/OTitleBar;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class BasicPanelNormalTitleBarHeader$1 extends Lambda implements Function1<OTitleBar, Unit> {
    public static final BasicPanelNormalTitleBarHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelNormalTitleBarHeader$1();
    }

    BasicPanelNormalTitleBarHeader$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OTitleBar r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OTitleBar r10) {
        Intrinsics.checkNotNullParameter(r10, "$receiver");
        if ((r10 instanceof ONormalTitleBar) == false) goto L11;
        ONormalTitleBar r11 = (ONormalTitleBar) r10;
        ImageView r12 = r11.getStartBtn();
        if (r12 == null) goto L7;
        float r13 = 10;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        int r15 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r14.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        int r17 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r16.getDisplayMetrics()));
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        int r19 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r18.getDisplayMetrics()));
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        r12.setPadding(r15, r17, r19, MathKt.roundToInt(TypedValue.applyDimension(1, r13, r20.getDisplayMetrics())));
    L7:
        ImageView r21 = r11.getEndBtn();
        if (r21 == null) goto L12;
        float r22 = 10;
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        int r24 = MathKt.roundToInt(TypedValue.applyDimension(1, r22, r23.getDisplayMetrics()));
        Resources r25 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r25, "Resources.getSystem()");
        int r26 = MathKt.roundToInt(TypedValue.applyDimension(1, r22, r25.getDisplayMetrics()));
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        int r28 = MathKt.roundToInt(TypedValue.applyDimension(1, r22, r27.getDisplayMetrics()));
        Resources r29 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r29, "Resources.getSystem()");
        r21.setPadding(r24, r26, r28, MathKt.roundToInt(TypedValue.applyDimension(1, r22, r29.getDisplayMetrics())));
        return;
    L12:
        return;
    }
}
