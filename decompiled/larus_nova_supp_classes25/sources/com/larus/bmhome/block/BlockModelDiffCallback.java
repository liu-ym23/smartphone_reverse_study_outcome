package com.larus.bmhome.block;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import jc8.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/block/BlockModelDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "newItems", "forceRefreshAll", "", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "oldItemPosition", "newItemPosition", "areContentsTheSame", "block-kit-impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BlockModelDiffCallback extends DiffUtil.Callback {
    public final List<a> a;
    public final List<a> b;
    public final boolean c;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public final boolean areContentsTheSame(int r4, int r5) {
        if (this.c == false) goto L5;
        return false;
    L5:
        a r6 = (a) CollectionsKt.getOrNull(this.a, r4);
        a r7 = (a) CollectionsKt.getOrNull(this.b, r5);
        if (r6 == null) goto L16;
        if (r7 == null) goto L16;
        if (r6.m() != r7.m()) goto L16;
        if (r6.n() != r7.n()) goto L16;
        return r6.e(r7);
    L16:
        return false;
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        a r4 = (a) CollectionsKt.getOrNull(this.a, r2);
        a r5 = (a) CollectionsKt.getOrNull(this.b, r3);
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.f(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockModelDiffCallback(List<? extends a> r2, List<? extends a> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "oldItems");
        Intrinsics.checkNotNullParameter(r3, "newItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
