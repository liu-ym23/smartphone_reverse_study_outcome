package mv0;

import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends qs0.a<IHostLiveLocalLife> implements qs0.g {
    public i() {
        super(jc1.k.n(IHostLiveLocalLife.class));
    }

    @Override // qs0.g
    public final void d(Map r8) {
        Intrinsics.checkNotNullParameter("life_live_author_card_gold_business_info_show", "eventName");
        Intrinsics.checkNotNullParameter(r8, "params");
        ((IHostLiveLocalLife) this.a).sendPoiLog("life_live_author_card_gold_business_info_show", r8, null, null, null, null);
    }
}
