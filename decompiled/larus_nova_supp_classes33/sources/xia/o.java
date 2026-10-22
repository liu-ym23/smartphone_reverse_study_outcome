package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.SimCardEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o implements c {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof SimCardEntity) == false) goto L15;
        SimCardEntity r4 = (SimCardEntity) r3;
        int r0 = r4.getSimSlot().hashCode() + 0;
        String r1 = r4.getSimCarrier();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        String r2 = r4.getPhoneNumber();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.hashCode();
    L10:
        String r5 = r4.getAnonymizedPhoneNumber();
        if (r5 != null) goto L13;
        return r0;
    L13:
        return (r0 * 31) + r5.hashCode();
    L15:
        throw new IllegalStateException("Check failed.".toString());
    }
}
