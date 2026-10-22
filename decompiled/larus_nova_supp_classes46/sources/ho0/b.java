package ho0;

import am3.g;
import am3.h;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class b {

    @SerializedName("body")
    public byte[] body;

    @SerializedName("header")
    public a header;

    public b() {
    }

    public static b a(g r9) throws IOException {
        b r0 = new b();
        long r1 = r9.c();
    L3:
        int r3 = r9.f();
        if (r3 == (-1)) goto L31;
        if (r3 != 1) goto L8;
        a r4 = new a();
        long r5 = r9.c();
    L12:
        int r7 = r9.f();
        if (r7 == (-1)) goto L22;
        switch(r7) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L15;
        };
    L16:
        r4.f = h.c(r9);
        goto L12
    L17:
        r4.e = r9.j();
        goto L12
    L18:
        r4.d = h.c(r9);
        goto L12
    L19:
        r4.c = h.c(r9);
        goto L12
    L20:
        r4.b = h.c(r9);
        goto L12
    L21:
        r4.a = (int) r9.j();
        goto L12
    L15:
        h.e(r9);
        goto L12
    L22:
        r9.d(r5);
        if (r4.a == (-1)) goto L30;
        if (r4.e == (-1)) goto L28;
        r0.header = r4;
        goto L3
    L28:
        throw new IOException("Invalid protobuf data: missing header.now!");
    L30:
        throw new IOException("Invalid protobuf data: missing header.statusCode!");
    L8:
        if (r3 != 2) goto L9;
        r0.body = h.b(r9);
        goto L3
    L9:
        h.e(r9);
        goto L3
    L31:
        r9.d(r1);
        if (r0.header != null) goto L34;
        a r10 = new a();
        r0.header = r10;
        r10.e = System.currentTimeMillis();
        r0.header.a = 0;
    L34:
        return r0;
    }
}
