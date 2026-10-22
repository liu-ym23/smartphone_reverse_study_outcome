package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 {
    public static final boolean a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$isRawIp");
        List r8 = StringsKt.split$default(r7, new String[]{"."}, false, 0, 6, null);
        if (r8.size() == 4) goto L5;
        return false;
    L5:
        Iterator r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L16;
        int r0 = CastIntegerProtector.parseInt((String) r9.next());     // Catch: NumberFormatException -> L18
        if (r0 < 0) goto L15;
        if (255 >= r0) goto L7;
    L15:
        return false;
    L16:
        return true;
    }
}
