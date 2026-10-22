package yt8;

import android.view.View;
import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.viewholder.LifeViewHolder;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements l19.f {
    public final /* synthetic */ LifeViewHolder a;

    public final void onTransitionChanged(int r1, float r2) {
    }

    public e(LifeViewHolder r1) {
        this.a = r1;
    }

    public final void onTransitionBegin(int r1) {
        View r2 = this.a.d;
        if (r2 == null) goto L6;
        e1.o(r2);
        return;
    }

    public final void onTransitionEnd(int r2) {
        LifeViewHolder r3 = this.a;
        t1 r0 = r3.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.d() == false) goto L10;
        View r4 = r3.d;
        if (r4 == null) goto L14;
        e1.x(r4);
        return;
    L14:
        return;
    L10:
        View r5 = r3.d;
        if (r5 == null) goto L16;
        e1.o(r5);
        return;
    }
}
