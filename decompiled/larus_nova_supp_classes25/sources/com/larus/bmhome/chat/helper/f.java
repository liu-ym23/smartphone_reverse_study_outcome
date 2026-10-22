package com.larus.bmhome.chat.helper;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.SubConvFirstMet;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.utils.AppLocaleUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static boolean a;
    public static final Lazy b = null;

    static {
        b = LazyKt.lazy(new e());
    }

    public static final String b() {
        if (AppHost.a.isOversea() == false) goto L5;
        AppLocaleUtils.a.getClass();
        Locale r0 = AppLocaleUtils.c();
    L6:
        String r1 = com.larus.utils.b0.a;
        Intrinsics.checkNotNull(r0);
        String r2 = com.larus.utils.b0.c(r0);
        LaunchInfo r3 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r3 == null) goto L11;
        Map r4 = r3.F();
        if (r4 == null) goto L11;
        return (String) r4.get(r2);
    L11:
        return null;
    L5:
        r0 = Locale.CHINA;
        goto L6
    }

    public static final boolean a(wc9.e r2) {
        if (((Boolean) b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (c(r2) == true) goto L7;
        return false;
    L7:
        if (a == true) goto L21;
        LaunchInfo r3 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r3 == null) goto L15;
        SubConvFirstMet r4 = r3.h1();
        if (r4 == null) goto L15;
        List r5 = r4.b();
        if (r5 == null) goto L15;
        int r6 = r5.size();
    L16:
        if (r6 > 0) goto L22;
        return true;
    L22:
        return false;
    L15:
        r6 = 0;
        goto L16
    L21:
        return false;
    }

    public static final boolean c(wc9.e r2) {
        if (r2 == null) goto L11;
        Integer r3 = r2.v;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.intValue() != 3) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }
}
