package oqb;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static double a(String r4) {
        if (r4 != null) goto L10;
        return 0.0d;
    L10:
        return CastDoubleProtector.parseDouble(r4);
    L7:
        e = move-exception;
        Log.e("NumberUtils", "failed to parse double, e:" + e);
        return 0.0d;
    }
}
