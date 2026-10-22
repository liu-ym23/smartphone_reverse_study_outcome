package tga;

import com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static String a() {
        IObricPrivacyAndPermissionUiService r0 = (IObricPrivacyAndPermissionUiService) a.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.a();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
