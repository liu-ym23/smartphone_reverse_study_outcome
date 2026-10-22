package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p implements c {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // xia.c
    public final int a(AppEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "instance");
        int r0 = (r6.getId().hashCode() + 0) * 31;
        long r1 = r6.getCreateTime();
        int r2 = ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + r6.getType()) * 31) + r6.get_packageName().hashCode();
        String r7 = r6.getExtraData();
        if (r7 != null) goto L5;
        return r2;
    L5:
        return (r2 * 31) + r7.hashCode();
    }
}
