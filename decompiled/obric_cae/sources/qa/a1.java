package qa;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class a1 extends c1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f10203c;

    public a1(Context r8, x0 r10) {
        super(r10);
        this.f10203c = r8;
    }

    @Override // qa.c1
    public final byte[] b(byte[] r8) {
        Context r10 = this.f10203c;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[0];
        t4.f(r11, "1.2.13.6");     // Catch: Throwable -> L5
        t4.f(r11, LocationInfoConst.SYSTEM);     // Catch: Throwable -> L5
        t4.f(r11, "");     // Catch: Throwable -> L5
        t4.f(r11, "");     // Catch: Throwable -> L5
        t4.f(r11, k4.m(r10));     // Catch: Throwable -> L5
        t4.f(r11, Build.MANUFACTURER);     // Catch: Throwable -> L5
        t4.f(r11, Build.MODEL);     // Catch: Throwable -> L5
        t4.f(r11, Build.DEVICE);     // Catch: Throwable -> L5
        t4.f(r11, "");     // Catch: Throwable -> L5
        t4.f(r11, h4.d(r10));     // Catch: Throwable -> L5
        t4.f(r11, h4.e(r10));     // Catch: Throwable -> L5
        t4.f(r11, h4.g(r10));     // Catch: Throwable -> L5
        r11.write(new byte[]{0});     // Catch: Throwable -> L5
        r12 = r11.toByteArray();     // Catch: Throwable -> L5
    L19:
        r11.close();     // Catch: Throwable -> L9
    L11:
        byte[] r13 = new byte[r12.length + r8.length];
        System.arraycopy(r12, 0, r13, 0, r12.length);
        System.arraycopy(r8, 0, r13, r12.length, r8.length);
        return r13;
    L9:
        th = move-exception;
        th.printStackTrace();
    L5:
        th = move-exception;
        q.f("sm", "gh", th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
