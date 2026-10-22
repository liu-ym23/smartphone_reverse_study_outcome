package com.larus.bmhome.chat.markdown.reference;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MarkdownReferenceWidget$initReferenceList$1$2 extends FunctionReferenceImpl implements Function2<Integer, RecyclerView.ViewHolder, Boolean> {
    public MarkdownReferenceWidget$initReferenceList$1$2(Object r8) {
        super(2, r8, MarkdownReferenceWidget.class, "itemShowFilter", "itemShowFilter(ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", 0);
    }

    public final Boolean invoke(int r1, RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return Boolean.valueOf(!((MarkdownReferenceWidget) ((CallableReference) this).receiver).e.isEmpty());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (RecyclerView.ViewHolder) r2);
    }
}
