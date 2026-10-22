package com.larus.bmhome.chat.list.base;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter$Companion$diff$1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback;
import com.larus.bmhome.social.page.datasource.diff.ActionListDiffer;
import com.larus.bmhome.social.page.datasource.event.c;
import com.larus.list.arch.FlowListViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vr8.a;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/list/base/MessageCellPagingAdapter;", "Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapter;", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;", "Lcom/larus/bmhome/chat/list/base/MessageCellHolder;", "prefetchDistance", "", "diff", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "<init>", "(ILandroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;)V", "createDiff", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class MessageCellPagingAdapter extends PagingAdapter<b, c<b>, MessageCellHolder<b>> {
    public MessageCellPagingAdapter(MessageAdapter$Companion$diff$1 r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "diff");
        Intrinsics.checkNotNullParameter(r3, "loader");
        super(r2, r3);
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public ActionListDiffer E2(PagingAdapterListUpdateCallback r3, DiffUtil.ItemCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "updateCallback");
        Intrinsics.checkNotNullParameter(r4, "diff");
        return new ActionListDiffer(r3, r4, new com.larus.bmhome.social.page.datasource.diff.a());
    }

    @Override // com.larus.bmhome.chat.list.base.MessageCellAdapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        B2((FlowListViewHolder) r1, r2);
    }
}
