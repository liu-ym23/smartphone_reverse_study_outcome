package com.larus.bmhome.chat.deepresearch;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ne8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/DeepResearchDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/bmhome/chat/deepresearch/DeepResearchData;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepResearchDiffCallback extends DiffUtil.ItemCallback<m> {
    public DeepResearchDiffCallback() {
    }

    public final boolean areContentsTheSame(Object r2, Object r3) {
        m r4 = (m) r2;
        m r5 = (m) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        return Intrinsics.areEqual(r4, r5);
    }

    public final boolean areItemsTheSame(Object r2, Object r3) {
        m r4 = (m) r2;
        m r5 = (m) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        Block r6 = r4.c;
        String r0 = null;
        if (r6 == null) goto L5;
        String r7 = r6.getBlockId();
    L6:
        Block r8 = r5.c;
        if (r8 == null) goto L10;
        r0 = r8.getBlockId();
    L10:
        return Intrinsics.areEqual(r7, r0);
    L5:
        r7 = null;
        goto L6
    }
}
