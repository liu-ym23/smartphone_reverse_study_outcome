package y54;

import android.app.Application;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import j64.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static volatile Application a;

    static {
    }

    public static final Application a() {
        if (a != null) goto L5;
        int r0 = b.a;
        a = b.a(AoHostService.class).getHostApplication();
    L5:
        Application r1 = a;
        Intrinsics.checkNotNull(r1);
        return r1;
    }
}
