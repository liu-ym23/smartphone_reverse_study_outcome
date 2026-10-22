package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r implements c {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof AppInfoEntity) == false) goto L19;
        AppInfoEntity r4 = (AppInfoEntity) r3;
        int r0 = (((((r4.getAppName().hashCode() + 0) * 31) + r4.getAppPackageName().hashCode()) * 31) + r4.getAppStatus()) * 31;
        if (r4.isExactMatch() == false) goto L7;
        int r1 = 1231;
    L8:
        int r2 = r0 + r1;
        String r5 = r4.getIcon();
        if (r5 == null) goto L11;
        r2 = (r2 * 31) + r5.hashCode();
    L11:
        String r6 = r4.getOpenStoreDetailDeeplink();
        if (r6 == null) goto L14;
        r2 = (r2 * 31) + r6.hashCode();
    L14:
        String r7 = r4.getPackageSize();
        if (r7 != null) goto L17;
        return r2;
    L17:
        return (r2 * 31) + r7.hashCode();
    L7:
        r1 = 1237;
        goto L8
    L19:
        throw new IllegalStateException("Check failed.".toString());
    }
}
