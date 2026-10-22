package n4a;

import android.content.Context;
import android.os.Build;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z0 extends b1 {
    public final Context c;

    public z0(Context r1, v0 r2) {
        super(r2);
        this.c = r1;
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r7) {
        Context r0 = this.c;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r4 = new byte[0];
        f5.g(r2, "1.2.13.6");     // Catch: Throwable -> L5
        f5.g(r2, "Android");     // Catch: Throwable -> L5
        f5.g(r2, NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L5
        f5.g(r2, NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L5
        f5.g(r2, x4.q(r0));     // Catch: Throwable -> L5
        f5.g(r2, Build.MANUFACTURER);     // Catch: Throwable -> L5
        f5.g(r2, Build.MODEL);     // Catch: Throwable -> L5
        f5.g(r2, Build.DEVICE);     // Catch: Throwable -> L5
        f5.g(r2, NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L5
        f5.g(r2, v4.d(r0));     // Catch: Throwable -> L5
        f5.g(r2, v4.e(r0));     // Catch: Throwable -> L5
        f5.g(r2, v4.g(r0));     // Catch: Throwable -> L5
        r2.write(new byte[]{0});     // Catch: Throwable -> L5
        r4 = r2.toByteArray();     // Catch: Throwable -> L5
    L19:
        r2.close();     // Catch: Throwable -> L9
    L11:
        byte[] r1 = new byte[r4.length + r7.length];
        System.arraycopy(r4, 0, r1, 0, r4.length);
        System.arraycopy(r7, 0, r1, r4.length, r7.length);
        return r1;
    L9:
        th = move-exception;
        th.printStackTrace();
    L5:
        th = move-exception;
        r.f(th, "sm", "gh");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
