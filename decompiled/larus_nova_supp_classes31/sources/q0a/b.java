package q0a;

import com.larus.media.focus.OScrollStateHelper;
import com.larus.ugc.feed.impl.viewholder.CreationVideoViewHolder;
import com.larus.ugc.feed.impl.viewholder.j0;
import com.larus.utils.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements OScrollStateHelper.b {
    public final /* synthetic */ c a;

    public final void onComplete() {
        f r0 = this.a.b;
        r0.getClass();
        if (f.a() == false) goto L10;
        Iterator<WeakReference<CreationVideoViewHolder>> r1 = r0.b.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        CreationVideoViewHolder r2 = r1.next().get();
        if (r2 == null) goto L6;
        y.c(new j0(r2));
    L10:
        r0.d();
    }

    public b(c r1) {
        this.a = r1;
    }
}
