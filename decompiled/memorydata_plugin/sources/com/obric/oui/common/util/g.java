package com.obric.oui.common.util;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"debugLog", "", NotificationCompat.CATEGORY_MESSAGE, "", "raiseIllegalArgumentException", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class g {
    public static final void a(String r2) {
        f r0 = f.f13501a;
        if (r2 != null) goto L5;
        r2 = "null";
    L5:
        r0.a("debugging", r2);
    }

    public static final void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, NotificationCompat.CATEGORY_MESSAGE);
        f.a(f.f13501a, "debugging", r7, null, 4, null);
        throw new IllegalArgumentException(r7);
    }
}
