package com.larus.bmhome.chat.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.search.MoreInfo;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "position", "", "item", "Lcom/larus/bmhome/chat/search/MoreInfo;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchCardMoreViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static SearchCardMoreViewHolder a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r4 = LayoutInflater.from(r3.getContext()).inflate(2131562637, r3, false);
            Intrinsics.checkNotNull(r4);
            return new SearchCardMoreViewHolder(r4);
        }
    }

    static {
    }

    public SearchCardMoreViewHolder() {
        throw null;
    }

    public SearchCardMoreViewHolder(View r1) {
        super(r1);
    }

    public static void T3(MoreInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        FLogger.a.d("SearchListBox_More", "search more holder bind, item_id: " + r3.getId());
    }
}
