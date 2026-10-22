package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/keyboard/edittext2/base/FunctionEditText;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class UrlInlineSpanHolder$schedulePrepareSpan$1 extends Lambda implements Function1<FunctionEditText, Unit> {
    final /* synthetic */ d this$0;

    public UrlInlineSpanHolder$schedulePrepareSpan$1(d r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(FunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.this$0.k(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((FunctionEditText) r1);
        return Unit.INSTANCE;
    }
}
