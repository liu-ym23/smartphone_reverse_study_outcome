package d90;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final boolean a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isPortrait");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_portrait", Boolean.TRUE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return true;
    }
}
