package com.larus.bmhome.chat.cotdetail.list;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cotdetail.list.cellstate.base.ThreadMsgCellStateType;
import com.larus.bmhome.chat.cotdetail.list.viewholder.BotLoadingViewHolder;
import com.larus.bmhome.chat.cotdetail.list.viewholder.BotReplyViewHolder;
import com.larus.bmhome.chat.cotdetail.list.viewholder.EmptyViewHolder;
import com.larus.bmhome.chat.cotdetail.list.viewholder.UploadTextViewHolder;
import com.larus.bmhome.chat.cotdetail.list.viewholder.UserNestedFileViewHolder;
import com.larus.bmhome.chat.cotdetail.list.viewholder.base.BaseThreadMsgViewHolder;
import ie8.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/list/ThreadMsgAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/chat/cotdetail/list/cellstate/base/ThreadMsgCellState;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "onViewAttachedToWindow", "onViewDetachedFromWindow", "getItemViewType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ThreadMsgAdapter extends ListAdapter<a, RecyclerView.ViewHolder> {
    public RecyclerView a;

    public ThreadMsgAdapter() {
        super(new ThreadMsgCellStateDiffCallback());
    }

    public final int getItemViewType(int r1) {
        return ((a) getItem(r1)).a();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r2);
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(r2);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof BaseThreadMsgViewHolder) == false) goto L5;
        BaseThreadMsgViewHolder r4 = (BaseThreadMsgViewHolder) r3;
    L6:
        if (r4 == null) goto L9;
        r4.a.b();
        r4.b = null;
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        a r5 = (a) getItem(r4);
        if ((r3 instanceof BaseThreadMsgViewHolder) == false) goto L6;
        BaseThreadMsgViewHolder r6 = (BaseThreadMsgViewHolder) r3;
        r6.b = this.a;
        Intrinsics.checkNotNull(r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "state");
        r6.a.setRecyclerView(r6.b);
        r6.a.a(r5);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, @ThreadMsgCellStateType int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L23;
        if (r3 == 4) goto L22;
        if (r3 == 100) goto L21;
        if (r3 == 101) goto L20;
        return new EmptyViewHolder(r2.getContext());
    L20:
        return new BotLoadingViewHolder(r2.getContext());
    L21:
        return new BotReplyViewHolder(r2.getContext());
    L22:
        return new UserNestedFileViewHolder(r2.getContext());
    L23:
        return new EmptyViewHolder(r2.getContext());
    L18:
        return new UploadTextViewHolder(r2.getContext());
    }
}
