package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c0 implements c {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    @Override // xia.c
    public final int a(AppEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "instance");
        if ((r6 instanceof FileEntity) == false) goto L9;
        FileEntity r7 = (FileEntity) r6;
        int r0 = (r7.getFileName().hashCode() + 0) * 31;
        long r1 = r7.getFileSize();
        int r2 = ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + r7.getContentUrl().hashCode()) * 31) + r7.getFileType().name().hashCode();
        String r8 = r7.getMimeType();
        if (r8 != null) goto L7;
        return r2;
    L7:
        return (r2 * 31) + r8.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
