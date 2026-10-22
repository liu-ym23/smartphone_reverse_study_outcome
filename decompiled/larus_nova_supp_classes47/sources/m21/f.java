package m21;

import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkUserListContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.d(r3);
        AnchorLinkUserListContract$View r0 = (AnchorLinkUserListContract$View) this.a.c;
        if (r0 == null) goto L7;
        r0.ba0(r3);
        return;
    }
}
