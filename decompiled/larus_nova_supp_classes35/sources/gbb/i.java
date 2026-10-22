package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.framework.assembly.diskmange.DiskManageModuleDependencyInitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public final long a;
    public final int b;
    public final a c;

    public interface a {
    }

    public final c a() {
        h r0 = (h) this.c;
        r0.getClass();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0.a);
        if (r1.mkdirs() == true) goto L11;
        if (r1.exists() == true) goto L7;
    L9:
        return null;
    L7:
        if (r1.isDirectory() == false) goto L9;
    L11:
        return new c(r1, this.b, this.a);
    }

    public i(String r5, long r6) {
        h r0 = new h(r5);
        DiskManageModuleDependencyInitor.a r7 = dbb.a.b();
        boolean r1 = false;
        if (r7 == null) goto L5;
        r1 = eac.a.a().getBoolean("small_disk_on", false);
    L5:
        if (r1 == false) goto L7;
        r7.getClass();
        this.a = (long) (r6 * eac.a.a().getFloat("disk_factor", 1.0f));
    L8:
        this.b = 1;
        this.c = r0;
        return;
    L7:
        this.a = r6;
        goto L8
    }
}
