package f02;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.debug.AssetsInfoAdapter;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        List<? extends Pair<? extends e, Boolean>> r3 = (List) r2;
        AssetsInfoAdapter r0 = this.a.getAdapter();
        if (r0 == null) goto L6;
        r0.y2(r3);
        return;
    }
}
