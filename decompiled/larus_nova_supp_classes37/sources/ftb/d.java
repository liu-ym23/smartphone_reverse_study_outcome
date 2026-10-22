package ftb;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements etb.b {
    public d() {
    }

    @Override // etb.b
    public final <T> T r(String r2, Class<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "tClass");
        etb.b r0 = (etb.b) OfficeSDKManager.getHostGlobalService(etb.b.class);
        if (r0 == null) goto L9;
        T r5 = (T) r0.r(r2, r3, r4);
        if (r5 != null) goto L8;
        return r4;
    L8:
        return r5;
    L9:
        return r4;
    }
}
