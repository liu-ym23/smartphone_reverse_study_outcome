package i29;

import com.larus.community.impl.viewholder.CreationVideoViewHolder;
import com.larus.community.impl.viewholder.m0;
import com.larus.media.focus.OScrollStateHelper;
import com.larus.utils.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements OScrollStateHelper.b {
    public final /* synthetic */ c a;

    public final void onComplete() {
        f r0 = this.a.b;
        r0.getClass();
        if (f.a() == false) goto L10;
        Iterator<WeakReference<CreationVideoViewHolder>> r1 = r0.d.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        CreationVideoViewHolder r2 = r1.next().get();
        if (r2 == null) goto L6;
        y.c(new m0(r2));
    L10:
        r0.e();
    }

    public b(c r1) {
        this.a = r1;
    }
}
