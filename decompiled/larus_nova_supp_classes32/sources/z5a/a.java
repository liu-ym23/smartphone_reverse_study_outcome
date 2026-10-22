package z5a;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final String a;
    public final b b;

    public final void c() {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString("event", "onEnd");
        JavaOnlyArray r1 = new JavaOnlyArray();
        r1.pushMap(r0);
        this.b.a(this.a, r1);
    }

    public final void a(InputStream r11) throws IOException {
        BufferedInputStream r0 = new BufferedInputStream(r11);
        StringBuilder r12 = new StringBuilder();
    L3:
        int r1 = r0.read();
        if (r1 == (-1)) goto L9;
        if (r1 == 13) goto L9;
        r12.append((char) r1);
    L9:
        if (r1 == 13) goto L11;
    L14:
        d("errorStreamingMalformedResponse");
        int r2 = -1;
    L15:
        if (r2 <= 0) goto L31;
        byte[] r7 = new byte[r2];
        int r8 = 0;
    L18:
        if (r8 >= r2) goto L23;
        int r9 = r0.read(r7, r8, r2 - r8);
        if (r9 == (-1)) goto L23;
        r8 = r8 + r9;
    L23:
        if (r8 == r2) goto L25;
    L28:
        d("errorStreamingMalformedResponse");
        r7 = new byte[0];
    L30:
        if (r7.length == 0) goto L31;
        b(r7);
        goto L3
    L25:
        if (r0.read() != 13) goto L28;
        if (r0.read() == 10) goto L30;
    L31:
        r0.close();
        return;
    L11:
        if (r0.read() != 10) goto L14;
        String r3 = r12.toString();
        r12.setLength(0);
        r2 = CastIntegerProtector.parseInt(r3, 16);
        goto L15
    }

    public final void b(byte[] r4) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString("event", "onData");
        r0.putByteArray(LynxResourceModule.DATA_KEY, r4);
        JavaOnlyArray r5 = new JavaOnlyArray();
        r5.pushMap(r0);
        this.b.a(this.a, r5);
    }

    public final void d(String r4) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString("event", "onError");
        r0.putString("error", r4);
        JavaOnlyArray r5 = new JavaOnlyArray();
        r5.pushMap(r0);
        this.b.a(this.a, r5);
    }

    public final void e(InputStream r5) throws IOException {
        BufferedInputStream r0 = new BufferedInputStream(r5);
        byte[] r6 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r1 = r0.read(r6);     // Catch: Throwable -> L10
        if (r1 == (-1)) goto L8;
        byte[] r2 = new byte[r1];     // Catch: Throwable -> L10
        System.arraycopy(r6, 0, r2, 0, r1);     // Catch: Throwable -> L10
        b(r2);     // Catch: Throwable -> L10
        goto L4
    L8:
        r0.close();
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public final void f(InputStream r7) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
    L3:
        int r2 = -1;
    L4:
        boolean r3 = false;
    L5:
        int r4 = r7.read();
        if (r4 == (-1)) goto L17;
        r0.write(r4);
        if (r4 != 13) goto L13;
        if (r3 == false) goto L10;
        r2 = -1;
        goto L5
    L10:
        r3 = true;
        goto L5
    L13:
        if (r2 != 10) goto L16;
        if (r4 != 10) goto L16;
        b(r0.toByteArray());
        r0.reset();
    L16:
        r2 = r4;
        goto L4
    }

    public a(String r1, b r2) {
        this.a = r1;
        this.b = r2;
    }
}
