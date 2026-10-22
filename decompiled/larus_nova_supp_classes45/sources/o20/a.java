package o20;

import com.bytedance.bdinstall.Level;
import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.c0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends e {
    public final String getName() {
        return "AnnieXWeb";
    }

    public a() {
    }

    public final boolean b(d r4) {
        Intrinsics.checkNotNullParameter(r4, "schemaData");
        Boolean r2 = null;
        Boolean r0 = (Boolean) ((i) new y36.a(r4, "append_common_params", null)).b;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.booleanValue() == false) goto L7;
        r2 = r0;
    L7:
        if (r2 == null) goto L15;
        r2.booleanValue();
        StringBuilder r1 = new StringBuilder(r4.c.toString());
        boolean r3 = AppLog.L;
        eta.b r5 = c0.a;
        c0.d(r1, false, Level.L0);
        String r6 = r1.toString();
        if (r6 == null) goto L12;
        r4.k(UriProtector.parse(StringsKt.trim(r6).toString()));
        return true;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L15:
        return true;
    }
}
