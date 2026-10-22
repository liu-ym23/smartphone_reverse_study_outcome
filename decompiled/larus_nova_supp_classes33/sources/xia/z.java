package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z implements c {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    @Override // xia.c
    public final int a(AppEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "instance");
        if ((r5 instanceof CountdownEntity) == false) goto L12;
        CountdownEntity r6 = (CountdownEntity) r5;
        long r0 = r6.getCountdownSeconds();
        int r1 = ((int) (r0 ^ (r0 >>> 32))) + 0;
        String r2 = r6.getLabel();
        if (r2 == null) goto L7;
        r1 = (r1 * 31) + r2.hashCode();
    L7:
        CountdownStatusEnum r7 = r6.getStatus();
        if (r7 != null) goto L10;
        return r1;
    L10:
        return (r1 * 31) + r7.name().hashCode();
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
