package ev0;

import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Predicate {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final boolean test(Object r2) {
        PanelInfo.State r3 = (PanelInfo.State) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.isAtLeast(PanelInfo.State.SHOWING);
    }
}
