package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.LifeLogEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements c {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof LifeLogEntity) == false) goto L7;
        LifeLogEntity r3 = (LifeLogEntity) r2;
        return ((r3.getTitle().hashCode() + 0) * 31) + r3.getContent().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
