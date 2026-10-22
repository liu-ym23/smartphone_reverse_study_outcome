package ee8;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public static final void a(Bundle r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != null) goto L5;
    L10:
        if (r4 != null) goto L12;
        return;
    L12:
        if ((!StringsKt.isBlank(r4)) == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L19;
        r2.putString("interaction_agent_type", r4);
        return;
    L19:
        return;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        r2.putString("interaction_display_type", r3);
        goto L10
    }
}
