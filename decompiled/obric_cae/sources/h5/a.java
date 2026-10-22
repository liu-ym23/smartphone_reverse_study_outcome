package h5;

import android.media.MediaDrm;
import java.util.UUID;
import java.util.concurrent.Callable;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Callable<String> {
    @Override // java.util.concurrent.Callable
    public final String call() {
        MediaDrm r8 = null;
        MediaDrm r10 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));     // Catch: Throwable -> L11 Exception -> L13
        String r11 = x0.a(r10.getPropertyByteArray("deviceUniqueId"));     // Catch: Exception -> L9 Throwable -> L23
        r10.close();     // Catch: Exception -> L7
        return r11;
    L7:
        e = move-exception;
        e.printStackTrace();
        return r11;
    L9:
        Exception e10 = e;
    L15:
        e10.printStackTrace();     // Catch: Throwable -> L23
        if (r10 != null) goto L33;
    L21:
        return "";
    L33:
        r10.close();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L23:
        th = move-exception;
        th = th;
        r8 = r10;
    L25:
        if (r8 != null) goto L31;
    L30:
        throw th;
    L31:
        r8.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L13:
        e = move-exception;
        r10 = null;
        e10 = e;
    L11:
        th = th;
        goto L25
    }
}
