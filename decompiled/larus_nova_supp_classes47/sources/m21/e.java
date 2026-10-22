package m21;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkUserListContract$View;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ g a;

    public e(g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        AnchorLinkUserListContract$View r0 = (AnchorLinkUserListContract$View) this.a.c;
        if (r0 == null) goto L7;
        r0.ca0((IRivalRankRecommendResponse) r3.data);
        return;
    }
}
