package com.larus.bmhome.chat.search.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.search.view.SearchUnavailableView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardUnavailableViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "boxView", "Lcom/larus/bmhome/chat/search/view/SearchUnavailableView;", "<init>", "(Lcom/larus/bmhome/chat/search/view/SearchUnavailableView;)V", "bind", "", ChatDraftItem.TYPE_TEXT, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchCardUnavailableViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int b = 0;
    public final SearchUnavailableView a;

    public static final class a {
        /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.FrameLayout, com.larus.bmhome.chat.search.view.SearchUnavailableView] */
        public static SearchCardUnavailableViewHolder a(ViewGroup r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            ?? r0 = new SearchUnavailableView(r4.getContext(), null, 6, 0);
            r0.setLayoutParams(new FrameLayout.LayoutParams(r5, r6));
            return new SearchCardUnavailableViewHolder(r0);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchCardUnavailableViewHolder(SearchUnavailableView r1) {
        super(r1);
        this.a = r1;
    }

    public final void bind(String r3) {
        Intrinsics.checkNotNullParameter(r3, ChatDraftItem.TYPE_TEXT);
        FLogger.a.e("SearchListBox_Unavailable", r3);
        if (AppHost.a.isDebug() == false) goto L6;
        this.a.setText(r3);
        return;
    }
}
