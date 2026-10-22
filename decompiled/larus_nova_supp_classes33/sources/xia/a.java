package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements c {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof ICSProtocolEntity) == false) goto L9;
        ICSProtocolEntity r3 = (ICSProtocolEntity) r2;
        int r0 = r3.getDoubaoUid().hashCode() + 0;
        String r4 = r3.getICal();
        if (r4 != null) goto L7;
        return r0;
    L7:
        return (r0 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
