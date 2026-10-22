package com.larus.business.multitask_management.impl.sheet;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmConcatSpanSizeLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "concatAdapter", "Lcom/larus/common_ui/widget/concat_adapter/ConcatAdapter;", "spanCount", "", "<init>", "(Lcom/larus/common_ui/widget/concat_adapter/ConcatAdapter;I)V", "getSpanSize", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MtmConcatSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
    public final ConcatAdapter a;
    public final int b;

    public MtmConcatSpanSizeLookup(ConcatAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "concatAdapter");
        this.a = r2;
        this.b = 2;
    }

    public final int getSpanSize(int r4) {
        Iterator r0 = this.a.getAdapters().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        RecyclerView.Adapter r1 = (RecyclerView.Adapter) r0.next();
        int r2 = r1.getItemCount();
        if (r4 < r2) goto L8;
        r4 = r4 - r2;
        goto L4
    L8:
        if ((r1 instanceof MtmServiceSectionAdapter) == false) goto L13;
        int r5 = this.b;
        if (((MtmServiceSectionAdapter) r1).c.c < 2) goto L19;
        return 1;
    L19:
        return r5;
    L13:
        return this.b;
    L16:
        return this.b;
    }
}
