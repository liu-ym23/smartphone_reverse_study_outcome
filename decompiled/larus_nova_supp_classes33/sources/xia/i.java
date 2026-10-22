package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements c {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // xia.c
    public final int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof PhotoFaceEntity) == false) goto L9;
        PhotoFaceEntity r3 = (PhotoFaceEntity) r2;
        int r0 = r3.getName().hashCode() + 0;
        FileEntity r4 = r3.getAvatar();
        if (r4 != null) goto L7;
        return r0;
    L7:
        return (r0 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
