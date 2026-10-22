package foc;

import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ICUUtils.FormatArgsBuilder r0 = new ICUUtils.FormatArgsBuilder();     // Catch: RuntimeException -> L6
        r0.b("APP_DISPLAY_NAME", UIHelper.getAppName());     // Catch: RuntimeException -> L6
        String r1 = ICUUtils.icuFormat(r3, r0.a);     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r1);     // Catch: RuntimeException -> L6
        return r1;
    L9:
        return r3;
    }
}
