package teb;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements UIFeedCard.DataObserver {
    public static final Object d = null;
    public final ConcurrentHashMap<String, Object> a;
    public final WeakReference<FeedListAdapter> b;
    public final Handler c;

    static {
        d = new Object();
    }

    public f(FeedListAdapter r2) {
        this.a = new ConcurrentHashMap();
        this.b = new WeakReference(r2);
        this.c = new Handler(Looper.getMainLooper());
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard.DataObserver
    public final void onChanged(String r3) {
        this.a.put(r3, d);
        Iterator<String> r4 = this.a.keySet().iterator();
        HashSet r0 = new HashSet();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(r4.next());
        r4.remove();
        goto L4
    L6:
        this.c.post(new e(this, r0));
    }
}
