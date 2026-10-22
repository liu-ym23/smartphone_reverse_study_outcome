package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class InputPanelListView$view$1$2 extends FunctionReferenceImpl implements Function1<ViewGroup, TextView> {
    public InputPanelListView$view$1$2(Object r8) {
        super(1, r8, InputPanelListView.class, "createHeader", "createHeader(Landroid/view/ViewGroup;)Landroid/widget/TextView;", 0);
    }

    public final TextView invoke(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        InputPanelListView r0 = (InputPanelListView) ((CallableReference) this).receiver;
        int r1 = InputPanelListView.h;
        return r0.c(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ViewGroup) r1);
    }
}
