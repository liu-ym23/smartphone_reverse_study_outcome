package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.BrowserBookmarkEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v implements c {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof BrowserBookmarkEntity) == false) goto L7;
        BrowserBookmarkEntity r3 = (BrowserBookmarkEntity) r2;
        return ((r3.getTitle().hashCode() + 0) * 31) + r3.getWebUrl().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
