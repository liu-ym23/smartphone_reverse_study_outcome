package xia;

import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n implements c {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof AlbumEntity) == false) goto L9;
        AlbumEntity r3 = (AlbumEntity) r2;
        int r0 = r3.getName().hashCode() + 0;
        FileEntity r4 = r3.getCover();
        if (r4 != null) goto L7;
        return r0;
    L7:
        return (r0 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
