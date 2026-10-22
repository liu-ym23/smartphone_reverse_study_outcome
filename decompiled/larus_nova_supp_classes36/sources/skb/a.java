package skb;

import com.larksuite.framework.utils.d;
import com.ss.android.lark.log.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    public static void a(String r1) {
        if (r1 == null) goto L5;
        Log.i("LarkBitmapFactory", r1);
        return;
    }

    @JvmStatic
    public static final byte[] b(InputStream r8) {
        byte[] r1 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r3 = new byte[8192];
    L20:
        th = move-exception;
        a("readStream failed:" + th);     // Catch: Throwable -> L31
    L27:
        th = th;
        StringBuilder r4 = new StringBuilder("reset or close error:");
    L29:
        r4.append(th);
        a(r4.toString());
    L30:
        return r1;
    L23:
        if (r8.markSupported() == false) goto L25;
        r8.reset();     // Catch: Throwable -> L27
    L25:
        d.b(new Closeable[]{r2});     // Catch: Throwable -> L27
    L31:
        th = move-exception;
    L37:
        th = move-exception;
        a("reset or close error:" + th);
    L39:
        throw th;
    L33:
        if (r8.markSupported() == false) goto L35;
        r8.reset();     // Catch: Throwable -> L37
    L35:
        d.b(new Closeable[]{r2});     // Catch: Throwable -> L37
        goto L39
    L7:
        if (r8.markSupported() == false) goto L9;
        r8.mark(r8.available());     // Catch: Throwable -> L20
    L9:
        int r6 = r8.read(r3);     // Catch: Throwable -> L20
        if (r6 == (-1)) goto L12;
        r2.write(r3, 0, r6);     // Catch: Throwable -> L20
        goto L9
    L12:
        r1 = r2.toByteArray();     // Catch: Throwable -> L20
    L18:
        th = th;
        r4 = new StringBuilder("reset or close error:");
        goto L29
    L14:
        if (r8.markSupported() == false) goto L16;
        r8.reset();     // Catch: Throwable -> L18
    L16:
        d.b(new Closeable[]{r2});     // Catch: Throwable -> L18
        goto L30
    }
}
