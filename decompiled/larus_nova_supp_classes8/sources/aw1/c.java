package aw1;

import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleListDrawFragment;
import com.bytedance.android.livesdk.viewmodel.i;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ SingleListDrawFragment a;

    public c(SingleListDrawFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        i r6 = (i) r5;
        if (r6 == null) goto L6;
        SingleListDrawFragment r0 = this.a;
        long r1 = r6.a;
        boolean r7 = r6.b;
        int r3 = SingleListDrawFragment.H;
        r0.U90(r1, r7);
        return;
    }
}
