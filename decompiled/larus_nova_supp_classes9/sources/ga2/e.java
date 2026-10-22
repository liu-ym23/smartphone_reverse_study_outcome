package ga2;

import com.bytedance.android.live.core.network.CustomApiServerException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final String a(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$prompt");
        if ((r3 instanceof CustomApiServerException) == false) goto L10;
        CustomApiServerException r4 = (CustomApiServerException) r3;
        String r0 = r4.getPrompt();
        if (r0 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r0)) == true) goto L9;
        return null;
    L9:
        return r4.getPrompt();
    L10:
        return null;
    }
}
