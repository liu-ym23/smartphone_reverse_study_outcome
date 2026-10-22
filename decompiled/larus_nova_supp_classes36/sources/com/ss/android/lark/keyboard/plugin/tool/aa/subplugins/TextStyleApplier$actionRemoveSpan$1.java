package com.ss.android.lark.keyboard.plugin.tool.aa.subplugins;

import android.text.Editable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public /* synthetic */ class TextStyleApplier$actionRemoveSpan$1 extends FunctionReferenceImpl implements Function3<Editable, Integer, Integer, Unit> {
    public TextStyleApplier$actionRemoveSpan$1(Object r8) {
        super(3, r8, TextStyleApplier.class, "removeSpanInner", "removeSpanInner(Landroid/text/Editable;II)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Editable) r1, ((Number) r2).intValue(), ((Number) r3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Editable r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        TextStyleApplier r0 = (TextStyleApplier) ((CallableReference) this).receiver;
        int r1 = TextStyleApplier.m;
        r0.d(r3, r4, r5);
    }
}
