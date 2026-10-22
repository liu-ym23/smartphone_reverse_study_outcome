package i41;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ExtraResponse<bf2.a, Extra> r3 = (ExtraResponse) r2;
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a.k;
        if (r0 == null) goto L5;
        v r1 = r0.getMultiLinkMonitor();
    L6:
        if (r1 == null) goto L8;
        r1.q(r3);
    L8:
        int r4 = com.bytedance.android.live.revlink.impl.utils.r.a;
        int r5 = w11.a.a;
        com.bytedance.android.live.revlink.impl.utils.r.a(r3);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
