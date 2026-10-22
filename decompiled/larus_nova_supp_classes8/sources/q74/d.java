package q74;

import android.media.MediaDrm;
import android.os.Build;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends p74.a {
    public final String b() {
        return "d_m0";
    }

    public final String c() {
        int r2 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23 Exception -> L25
        MediaDrm r4 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));     // Catch: Throwable -> L23 Exception -> L25
        String r1 = y74.d.a(r4.getPropertyByteArray("deviceUniqueId"));     // Catch: Exception -> L21 Throwable -> L51
        if (r2 < 28) goto L83;
        r4.close();     // Catch: Exception -> L8
    L20:
        return r1;
    L8:
        e = move-exception;
        if (e.getCause() == null) goto L12;
        ((p74.a) this).b = e.getCause().getMessage();
        goto L20
    L12:
        ((p74.a) this).b = e.getMessage();
        goto L20
    L83:
        r4.release();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        if (e.getCause() == null) goto L19;
        ((p74.a) this).b = e.getCause().getMessage();
        goto L20
    L19:
        ((p74.a) this).b = e.getMessage();
    L21:
        Exception e = e;
    L28:
        if (e.getCause() == null) goto L30;
        ((p74.a) this).b = e.getCause().getMessage();     // Catch: Throwable -> L51
    L32:
        if (Build.VERSION.SDK_INT < 28) goto L41;
        if (r4 == null) goto L87;
        r4.close();     // Catch: Exception -> L36
        return "";
    L36:
        e = move-exception;
        if (e.getCause() == null) goto L40;
        ((p74.a) this).b = e.getCause().getMessage();
        return "";
    L40:
        ((p74.a) this).b = e.getMessage();
        return "";
    L87:
        return "";
    L41:
        if (r4 == null) goto L90;
        r4.release();     // Catch: Exception -> L44
        return "";
    L44:
        e = move-exception;
        if (e.getCause() == null) goto L48;
        ((p74.a) this).b = e.getCause().getMessage();
        return "";
    L48:
        ((p74.a) this).b = e.getMessage();
        return "";
    L90:
        return "";
    L30:
        ((p74.a) this).b = e.getMessage();     // Catch: Throwable -> L51
    L51:
        Throwable th = th;
    L53:
        if (Build.VERSION.SDK_INT < 28) goto L62;
        if (r4 != null) goto L73;
    L70:
        throw th;
    L73:
        r4.close();     // Catch: Exception -> L57
    L57:
        e = move-exception;
        if (e.getCause() == null) goto L61;
        ((p74.a) this).b = e.getCause().getMessage();
        goto L70
    L61:
        ((p74.a) this).b = e.getMessage();
        goto L70
    L62:
        if (r4 == null) goto L70;
        r4.release();     // Catch: Exception -> L65
    L65:
        e = move-exception;
        if (e.getCause() == null) goto L69;
        ((p74.a) this).b = e.getCause().getMessage();
        goto L70
    L69:
        ((p74.a) this).b = e.getMessage();
        goto L70
    L25:
        e = move-exception;
        r4 = null;
        e = e;
    L23:
        th = move-exception;
        r4 = null;
        th = th;
        goto L53
    }

    public d(JSONObject r1) {
        super(r1);
    }
}
