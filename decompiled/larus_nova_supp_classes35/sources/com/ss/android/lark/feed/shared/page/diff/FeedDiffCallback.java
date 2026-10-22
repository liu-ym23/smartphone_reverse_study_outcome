package com.ss.android.lark.feed.shared.page.diff;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FeedDiffCallback extends DiffUtil.Callback {
    public final List<UIFeedCard> a;
    public final List<UIFeedCard> b;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public FeedDiffCallback(List<UIFeedCard> r1, List<UIFeedCard> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean areContentsTheSame(int r2, int r3) {
        return ((UIFeedCard) ListProtector.get(this.a, r2)).exactlyCompare((UIFeedCard) ListProtector.get(this.b, r3));
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        UIFeedCard r4 = (UIFeedCard) ListProtector.get(this.a, r2);
        UIFeedCard r5 = (UIFeedCard) ListProtector.get(this.b, r3);
        if (r4 == null) goto L8;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.getId().equals(r5.getId());
    L8:
        return false;
    }
}
