package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.DoubaoAccountEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 implements c {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof DoubaoAccountEntity) == false) goto L7;
        return ((DoubaoAccountEntity) r2).getDoubaoUid().hashCode() + 0;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
