package qa;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11112e;

    public t0(Context r8, String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r12) == true) goto L9;
        if (r12.length() > 256) goto L9;
        this.f11108a = r8.getApplicationContext();
        this.f11110c = r10;
        this.f11111d = r11;
        this.f11109b = r12;
        return;
    L9:
        throw new g4("无效的参数 - IllegalArgumentException");
    }

    public final void a(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L9;
        if (r8.length() > 65536) goto L9;
        this.f11112e = r8;
        return;
    L9:
        throw new g4("无效的参数 - IllegalArgumentException");
    }

    public final byte[] b() {
        byte[] r8 = new byte[0];
        ByteArrayOutputStream r10 = null;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L24
        t4.f(r11, this.f11110c);     // Catch: Throwable -> L22
        t4.f(r11, this.f11111d);     // Catch: Throwable -> L22
        t4.f(r11, this.f11109b);     // Catch: Throwable -> L22
        t4.f(r11, String.valueOf(k4.n(this.f11108a)));     // Catch: Throwable -> L22
        int r12 = (int) (System.currentTimeMillis() / 1000);
    L9:
        r11.write(new byte[]{(byte) ((r12 >> 24) & 255), (byte) ((r12 >> 16) & 255), (byte) ((r12 >> 8) & 255), (byte) (r12 & 255)});     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(this.f11112e) == false) goto L13;
        byte[] r13 = new byte[2];     // Catch: Throwable -> L22
    L12:
        r13 = {x00a6: FILL_ARRAY_DATA , data: [0, 0} // fill-array;     // Catch: Throwable -> L22
    L17:
        r11.write(r13);     // Catch: Throwable -> L22
        r11.write(t4.i(this.f11112e));     // Catch: Throwable -> L22
        r8 = r11.toByteArray();     // Catch: Throwable -> L22
        r11.close();     // Catch: Throwable -> L20
    L38:
    L28:
        return r8;
    L13:
        byte[] r14 = t4.i(this.f11112e);     // Catch: Throwable -> L22
        if (r14 != null) goto L16;
        r13 = new byte[2];     // Catch: Throwable -> L22
        goto L12
    L16:
        r13 = t4.h(r14.length);     // Catch: Throwable -> L22
    L7:
        r12 = 0;
    L22:
        th = th;
        r10 = r11;
    L43:
        q.f("se", "tds", th);     // Catch: Throwable -> L29
        if (r10 == null) goto L28;
        r10.close();     // Catch: Throwable -> L20
    L29:
        th = move-exception;
        if (r10 != null) goto L36;
    L35:
        throw th;
    L36:
        r10.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = th;
        goto L43
    }
}
