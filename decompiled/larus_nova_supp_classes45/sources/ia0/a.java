package ia0;

import ca0.n;
import com.bytedance.android.debug.f;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.pushstream.mock.LiveAnchorPushStreamMockManager;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import dy0.c;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a extends c, IAssetsManager, n {
    void A5(String r1, LiveAnchorPushStreamMockManager.Companion.a r2);

    Observable<h1> B2(long r1);

    String Nk(String r1);

    void Rg(h1 r1, long r2);

    void Tf(String r1, f r2);

    boolean a7(String r1);

    e kd(String r1);
}
