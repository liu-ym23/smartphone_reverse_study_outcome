package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class d implements g {
    public e a;

    @Override // gbb.g
    public File c(String r1) throws IOException {
        return null;
    }

    @Override // gbb.g
    public final File b() {
        e r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.e();
    }

    @Override // gbb.g
    public void delete() throws IOException {
        e r0 = this.a;
        if (r0 == null) goto L6;
        r0.delete();
        return;
    }

    public d() {
    }

    @Override // gbb.g
    public PolarisFileWrapper a(String r3) throws IOException, DecryptException {
        e r0 = this.a;
        if (r0 == null) goto L8;
        e.C0226e r4 = r0.d(r3);
        if (r4 == null) goto L10;
        PolarisFileWrapper r1 = r4.b.a(0);
        r4.close();
        return r1;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // gbb.g
    public final void remove(String r2) throws IOException {
        e r0 = this.a;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    @Override // gbb.g
    public void d(String r3, g.a r4) throws IOException {
        e r0 = this.a;
        if (r0 != null) goto L6;
        Log.w("DiskCacheWrapperBase", "put mLruCache is null");
        return;
    L6:
        e.c r1 = r0.c(r3);
        if (r1 != null) goto L9;
        Log.e("DiskCacheWrapperBase", "editor is null, key:" + r3);
        return;
    L9:
        if (r4.write(r1.b()) == false) goto L11;
        e.a(r1.c, r1, true);
        return;
    L11:
        Log.e("DiskCacheWrapperBase", "write file failed");
    }
}
