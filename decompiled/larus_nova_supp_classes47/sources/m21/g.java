package m21;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorLinkUserListFragment;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends i21.c {
    public g(AnchorLinkUserListFragment r1) {
        super(r1);
    }

    @Override // i21.c
    public final void e(int r9) {
        Observable r10 = r31.b.a(r31.a.a).c(4, false, r9, "", 3, 0);
        if (r10 == null) goto L8;
        ObservableSubscribeProxy r12 = (ObservableSubscribeProxy) r10.as(c());
        if (r12 == null) goto L9;
        r12.subscribe(new e(this), new f(this));
        return;
    L9:
        return;
    }
}
