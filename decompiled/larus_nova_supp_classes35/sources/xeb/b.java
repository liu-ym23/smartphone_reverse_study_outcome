package xeb;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements a.InterfaceC0320a {
    public final /* synthetic */ LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, UIFeedCard> a;

    @Override // xeb.a.InterfaceC0320a
    public final int getSize() {
        LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, UIFeedCard> r0 = this.a;
        if (r0 == null) goto L7;
        List r1 = r0.getItems();
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    public b(LarkFeedInBoxListAdapter r1) {
        this.a = r1;
    }

    @Override // xeb.a.InterfaceC0320a
    public final UIFeedCard getItem(int r2) {
        LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, UIFeedCard> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (UIFeedCard) r0.getItem(r2);
    }
}
