package xv1;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static Map a() {
        LinkedHashMap r0 = new LinkedHashMap();
        IStrategyService r1 = k.f(IStrategyService.class);
        if (r1 == null) goto L11;
        LiveData r2 = IStrategyService.a.a(r1, "drawer_preview_autoplay", r0, true, 8);
        if (r2 == null) goto L12;
        Map r3 = (Map) r2.getValue();
        if (r3 != null) goto L10;
        return r0;
    L10:
        return r3;
    L12:
        return r0;
    L11:
        return r0;
    }

    static {
    }
}
