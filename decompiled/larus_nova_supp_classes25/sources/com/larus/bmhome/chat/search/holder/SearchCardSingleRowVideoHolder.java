package com.larus.bmhome.chat.search.holder;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.search.view.SearchVideoLargeCardViewV2;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardSingleRowVideoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "boxView", "Lcom/larus/bmhome/chat/search/view/SearchVideoLargeCardViewV2;", "extra", "", "", "<init>", "(Lcom/larus/bmhome/chat/search/view/SearchVideoLargeCardViewV2;Ljava/util/Map;)V", "bind", "", "position", "", "item", "Lcom/larus/bmhome/chat/search/VideoInfo;", "imgCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchImgCallback;", "updateLayoutParams", "mode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchCardSingleRowVideoHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final SearchVideoLargeCardViewV2 a;
    public final Map<String, String> b;

    public static final class a {
    }

    static {
    }

    public SearchCardSingleRowVideoHolder() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchCardSingleRowVideoHolder(SearchVideoLargeCardViewV2 r1, Map r2) {
        super(r1);
        this.a = r1;
        this.b = r2;
    }
}
