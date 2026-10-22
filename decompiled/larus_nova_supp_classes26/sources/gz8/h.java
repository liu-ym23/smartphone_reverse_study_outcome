package gz8;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final void a() {
        s r0 = s.a;
        Application r1 = AppHost.a.getApplication();
        String r2 = f.b("toast_fail_retry");
        r0.getClass();
        s.c(r1, r2);
    }

    public static final void b(IIMError r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getCode() != 710010702) goto L5;
        String r4 = f.b("toast_fail_retry");
    L18:
        s r0 = s.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        s.c(r1, r4);
        return;
    L5:
        String r5 = r3.getTips();
        if (r5 == null) goto L17;
        r4 = StringsKt.trim(r5).toString();
        if (r4 == null) goto L17;
        if (r4.length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        r4 = null;
    L16:
        if (r4 != null) goto L18;
    L12:
        r2 = false;
    L17:
        r4 = f.b("toast_fail_retry");
        goto L18
    }
}
