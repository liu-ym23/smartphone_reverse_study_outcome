package f84;

import android.media.MediaDrm;
import android.os.Build;
import com.bytedance.bdinstall.c1;
import java.util.UUID;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Callable<String> {
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public String call2() throws Exception {
        int r2 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L17 Exception -> L19
        MediaDrm r4 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));     // Catch: Throwable -> L17 Exception -> L19
        String r1 = c1.b(r4.getPropertyByteArray("deviceUniqueId"));     // Catch: Exception -> L15 Throwable -> L36
        if (r2 < 28) goto L62;
        r4.close();     // Catch: Exception -> L8
    L14:
        return r1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L62:
        r4.release();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        Exception e = e;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L36
        if (Build.VERSION.SDK_INT < 28) goto L29;
        if (r4 == null) goto L67;
        r4.close();     // Catch: Exception -> L27
        return "";
    L27:
        e = move-exception;
        e.printStackTrace();
        return "";
    L67:
        return "";
    L29:
        if (r4 == null) goto L69;
        r4.release();     // Catch: Exception -> L32
        return "";
    L32:
        e = move-exception;
        e.printStackTrace();
        return "";
    L69:
        return "";
    L36:
        Throwable th = th;
    L38:
        if (Build.VERSION.SDK_INT < 28) goto L44;
        if (r4 != null) goto L52;
    L49:
        throw th;
    L52:
        r4.close();     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L49
    L44:
        if (r4 == null) goto L49;
        r4.release();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        goto L49
    L19:
        e = move-exception;
        r4 = null;
        e = e;
    L17:
        th = move-exception;
        r4 = null;
        th = th;
        goto L38
    }

    public b() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ String call() throws Exception {
        return call2();
    }
}
