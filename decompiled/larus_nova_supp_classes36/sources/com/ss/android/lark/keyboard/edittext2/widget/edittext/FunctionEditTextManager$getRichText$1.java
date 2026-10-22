package com.ss.android.lark.keyboard.edittext2.widget.edittext;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/edittext2/edittors/richText/RichTextGenerator;", "it", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FunctionEditTextManager$getRichText$1 extends Lambda implements Function2<d, d, Unit> {
    public static final FunctionEditTextManager$getRichText$1 INSTANCE = null;

    static {
        INSTANCE = new FunctionEditTextManager$getRichText$1();
    }

    public FunctionEditTextManager$getRichText$1() {
        super(2);
    }

    public final void invoke(d r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$copy");
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.a = true;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((d) r1, (d) r2);
        return Unit.INSTANCE;
    }
}
