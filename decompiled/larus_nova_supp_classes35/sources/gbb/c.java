package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends d {
    @Override // gbb.d, gbb.g
    public final PolarisFileWrapper a(String r5) throws IOException, DecryptException {
        e r0 = this.a;
        if (r0 == null) goto L14;
        e.C0226e r1 = r0.d(r5);
        if (r1 == null) goto L18;
        PolarisFileWrapper r2 = r1.b.a(0);
        r1.close();
        String r3 = f.b(r2);     // Catch: DecryptException -> L9
        PolarisFileWrapper r4 = CipherManager.e(r2, false);     // Catch: DecryptException -> L9
        e(r3, f.b(r2), r5, r2);     // Catch: DecryptException -> L9
        return r4;
    L9:
        e = move-exception;
        Log.e("CipherDiskCacheWrapper", "decrypt file failed! code: " + e.getErrorCode() + ", key: " + r5 + ", path: " + r2.getAbsolutePath());
        if (e.getErrorCode() != 20327) goto L13;
        this.a.l(r5);
        return null;
    L13:
        throw e;
    L18:
        return null;
    L14:
        return null;
    }

    @Override // gbb.d, gbb.g
    public final void d(String r4, g.a r5) throws IOException {
        e r0 = this.a;
        if (r0 != null) goto L6;
        Log.w("CipherDiskCacheWrapper", "put mLruCache is null");
        return;
    L6:
        e.c r1 = r0.c(r4);
        if (r1 == null) goto L12;
        PolarisFileWrapper r2 = r1.b();
        if (r5.write(r2) == false) goto L11;
        String r6 = f.b(r2);
        com.ss.android.lark.vfs.d.a().o(r2);
        e(r6, f.b(r2), r4, r2);
        e.a(r1.c, r1, true);
        return;
    L11:
        r1.a();
        Log.e("CipherDiskCacheWrapper", "write file failed, key:" + r4);
        return;
    L12:
        Log.e("CipherDiskCacheWrapper", "editor is null, key:" + r4);
    }

    public c(PolarisFileWrapper r1, int r2, long r3) {
        this.a = e.g(r1, r2, r3);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void e(String r2, String r3, String r4, PolarisFileWrapper r5) {
        if (r2.equals(r3) == true) goto L6;
        Log.i("CipherDiskCacheWrapper", "getFile header changed:" + r2 + "->" + r3 + ", key:" + r4 + ", file:" + r5.getAbsolutePath());
        return;
    }
}
