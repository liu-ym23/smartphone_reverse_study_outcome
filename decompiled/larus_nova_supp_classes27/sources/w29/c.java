package w29;

import com.larus.bmhome.actionbar.model.z0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Map r3 = r2.H;
        if (r3 == null) goto L10;
        String r4 = (String) r3.get("context_window_total_percent_tenths");
        if (r4 == null) goto L11;
        Integer r5 = StringsKt.toIntOrNull(r4);
        if (r5 != null) goto L9;
        return 0;
    L9:
        return RangesKt.coerceIn(r5.intValue(), 0, 1000);
    L11:
        return 0;
    L10:
        return 0;
    }
}
