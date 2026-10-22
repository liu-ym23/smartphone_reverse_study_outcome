package fg;

import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import gg.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import of.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IECUserTrackerService {
    public a() {
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final of.a getMarketingService() {
        return c.f;
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void enterPage(b r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ConcurrentHashMap<String, Map<String, hg.a>> r1 = c.a;
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void leavePage(b r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        c.f.leavePage(r10);
    }
}
