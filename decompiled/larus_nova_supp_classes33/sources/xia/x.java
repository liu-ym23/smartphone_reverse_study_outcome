package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x implements c {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof CloudDocumentEntity) == false) goto L7;
        CloudDocumentEntity r3 = (CloudDocumentEntity) r2;
        return ((r3.getTitle().hashCode() + 0) * 31) + r3.getUrl().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
