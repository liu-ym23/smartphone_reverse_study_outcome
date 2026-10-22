package qi8;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.search.holder.SearchCardTextImageViewHolder;
import com.larus.common.apphost.AppHost;
import oi8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ SearchCardTextImageViewHolder a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.a.getLineCount() <= 0) goto L11;
        TextView r0 = this.a.b;
        LruCache<String, k> r1 = SearchListBox.E;
        if (AppHost.a.isOversea() == false) goto L7;
        int r2 = 8;
    L8:
        r0.setMaxLines(r2 - this.a.a.getLineCount());
        this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L7:
        r2 = 7;
        goto L8
    L11:
        return true;
    }

    public a(SearchCardTextImageViewHolder r1) {
        this.a = r1;
    }
}
