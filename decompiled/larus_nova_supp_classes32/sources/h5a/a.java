package h5a;

import c5a.c;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.clay.embedding.engine.loader.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements d {
    public final /* synthetic */ com.lynx.clay.embedding.engine.plugins.audio.a a;

    public a(com.lynx.clay.embedding.engine.plugins.audio.a r1) {
        this.a = r1;
    }

    public final void a(String r3) {
        c.d(6, "AudioPlayerSPImpl", r3);
    }

    public final void b(String r9, InputStream r10) {
        PolarisFileOutputStreamWrapper r1 = null;
        if (r9 == null) goto L92;
        if (r9.isEmpty() == true) goto L92;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r9);     // Catch: Exception -> L16
        if (r2.exists() == false) goto L92;
        if (r10 != null) goto L98;
    L14:
        com.lynx.clay.embedding.engine.plugins.audio.a.g(this.a, r2.getPath());     // Catch: Exception -> L16
        return;
    L98:
        r10.close();     // Catch: IOException -> L11 Exception -> L16
    L13:
        r10 = null;
        goto L14
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    L92:
        if (r10 != null) goto L94;
        c.d(6, "AudioPlayerSPImpl", "Load audio resource failed");
        return;
    L94:
        File r3 = File.createTempFile("sound_pool_temp", null, this.a.a.getFlutterView().getContext().getCacheDir());     // Catch: Throwable -> L42 IOException -> L44
        PolarisFileOutputStreamWrapper r4 = new PolarisFileOutputStreamWrapper(r3);     // Catch: IOException -> L40 Throwable -> L42
    L86:
        byte[] r5 = new byte[4096];     // Catch: IOException -> L38 Throwable -> L64
    L26:
        int r6 = r10.read(r5);     // Catch: IOException -> L38 Throwable -> L64
        if (r6 == (-1)) goto L76;
        r4.write(r5, 0, r6);     // Catch: IOException -> L38 Throwable -> L64
        goto L26
    L76:
        r10.close();     // Catch: IOException -> L32
    L34:
        r4.close();     // Catch: IOException -> L36
    L91:
    L53:
        if (r3 != null) goto L55;
        return;
    L55:
        if (r3.exists() == false) goto L102;
        com.lynx.clay.embedding.engine.plugins.audio.a.g(this.a, r3.getPath());
    L61:
        e = move-exception;
        c.d(6, "AudioPlayerSPImpl", "failed to delete temp file");
        e.printStackTrace();
        return;
    L58:
        if (r3.delete() == true) goto L103;
        c.d(6, "AudioPlayerSPImpl", "failed to delete temp file");     // Catch: Exception -> L61
        return;
    L103:
        return;
    L102:
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
    L38:
        IOException e = e;
    L46:
        e.printStackTrace();     // Catch: Throwable -> L64
        r10.close();     // Catch: IOException -> L49
    L51:
        if (r4 == null) goto L53;
        r4.close();     // Catch: IOException -> L36
    L49:
        e = move-exception;
        e.printStackTrace();
    L64:
        th = th;
        r1 = r4;
    L96:
        r10.close();     // Catch: IOException -> L68
    L70:
        if (r1 == null) goto L105;
        r1.close();     // Catch: IOException -> L73
        throw th;
    L73:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L105:
        throw th;
    L68:
        e = move-exception;
        e.printStackTrace();
    L40:
        e = move-exception;
        r4 = null;
        e = e;
    L44:
        e = move-exception;
        r4 = null;
        e = e;
        r3 = null;
    L42:
        th = th;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L53
    }
}
