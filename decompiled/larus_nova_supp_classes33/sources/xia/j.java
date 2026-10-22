package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j implements c {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof ProactiveMemoryEntity) == false) goto L12;
        ProactiveMemoryEntity r4 = (ProactiveMemoryEntity) r3;
        int r0 = r4.getContent().hashCode() + 0;
        String r1 = r4.getTitle();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        Integer r5 = r4.getProductType();
        if (r5 == null) goto L13;
        int r2 = r0 * 31;
        return r2 + r5.intValue();
    L13:
        return r0;
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
