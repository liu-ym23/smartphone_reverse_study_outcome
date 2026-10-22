package teb;

import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends RecyclerView.ViewCacheExtension {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ d b;

    public c(d r1, RecyclerView r2) {
        this.b = r1;
        this.a = r2;
    }

    public final View getViewForPositionAndType(RecyclerView.Recycler r5, int r6, int r7) {
        UIFeedCard r8 = (UIFeedCard) this.b.a.getItem(r6);
        String r9 = r8.getId();
        long r0 = r8.getUpdateTime();
        Pair<Long, RecyclerView.ViewHolder> r10 = this.b.e.remove(r9);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (((Long) r10.first).longValue() != r0) goto L12;
        if (d.g == false) goto L10;
        Log.i("FeedPreBinder", "getViewForPositionAndType return=" + r10.second);
    L10:
        return ((RecyclerView.ViewHolder) r10.second).itemView;
    L12:
        if (d.g == false) goto L14;
        Log.e("FeedPreBinder", "getViewForPositionAndType updateTime not match.  cache.updateTime=" + r10.first + " item.updateTime=" + r0);
    L14:
        this.a.getRecycledViewPool().putRecycledView((RecyclerView.ViewHolder) r10.second);
        return null;
    }
}
