package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.WebsiteEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u implements c {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof WebsiteEntity) == false) goto L9;
        WebsiteEntity r3 = (WebsiteEntity) r2;
        int r0 = r3.getWebUrl().hashCode() + 0;
        String r4 = r3.getTitle();
        if (r4 != null) goto L7;
        return r0;
    L7:
        return (r0 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
