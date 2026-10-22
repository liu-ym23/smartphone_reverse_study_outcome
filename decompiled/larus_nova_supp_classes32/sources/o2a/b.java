package o2a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;
import l2a.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        String r3 = AppHost.a.getApplication().getFilesDir().getPath() + '/' + r2 + '/';
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
        boolean r1 = u.a;
        u.b("BmfVideoSRHelper", "file.mkdirs(): superRsSoPath" + r3);
    L5:
        return r3;
    }
}
