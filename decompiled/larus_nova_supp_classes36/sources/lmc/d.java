package lmc;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ugc.live.sdk.msg.data.SdkUplinkPacket;
import com.ss.ugc.live.sdk.msg.network.n;
import com.ss.ugc.live.sdk.msg.uplink.UplinkException;
import com.ss.ugc.live.sdk.msg.uplink.UplinkStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final boolean a;
    public com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> b;
    public com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> c;
    public SdkUplinkPacket d;
    public boolean e;
    public com.ss.ugc.live.sdk.msg.network.g f;
    public Exception g;
    public final f h;
    public Runnable i;
    public boolean j;
    public final long k;
    public final long l;
    public final long m;
    public final com.ss.ugc.live.sdk.msg.network.f n;
    public final com.ss.ugc.live.sdk.msg.network.e o;

    public final com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> a() {
        SdkUplinkPacket r0 = this.d;
        com.ss.ugc.live.sdk.msg.network.g r1 = this.f;
        Exception r2 = this.g;
        boolean r4 = false;
        if (r0 == null) goto L29;
        ByteString r3 = r0.payload;
        if (r3 == null) goto L9;
        byte[] r5 = r3.toByteArray();
        if (r5 == null) goto L9;
    L10:
        ArrayList r6 = new ArrayList();
        Map<String, String> r7 = r0.headers;
        if (r7 == null) goto L16;
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        Map.Entry<String, String> r9 = r8.next();
        r6.add(new com.ss.ugc.live.sdk.msg.network.d(r9.getKey(), r9.getValue()));
    L16:
        com.ss.ugc.live.sdk.msg.network.g r10 = new com.ss.ugc.live.sdk.msg.network.g();
        r10.a = r0.statusCode.intValue();
        r10.b = r0.statusMessage;
        r10.d = r5;
        r10.c = r6;
        com.ss.ugc.live.sdk.msg.network.f r11 = this.n;
        if (this.e == false) goto L19;
        int r12 = 1;
    L20:
        r10.f = r12;
        if (r5.length != 0) goto L24;
        r4 = true;
    L24:
        if ((!r4) == false) goto L28;
        n r13 = r11.j;
        if (r13 == null) goto L28;
        r10.e = r13.decode(r5);
    L28:
        int r14 = com.ss.ugc.live.sdk.msg.utils.g.a;
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r10);
    L19:
        r12 = 2;
    L9:
        r5 = new byte[0];
        goto L10
    L29:
        if (r1 == null) goto L43;
        byte[] r15 = r1.d;
        if (r15 != null) goto L34;
        r15 = new byte[0];
    L34:
        com.ss.ugc.live.sdk.msg.network.g r16 = new com.ss.ugc.live.sdk.msg.network.g();
        r16.a = r1.a;
        r16.b = r1.b;
        r16.d = r15;
        r16.c = r1.c;
        com.ss.ugc.live.sdk.msg.network.f r17 = this.n;
        r16.f = 0;
        if (r15.length != 0) goto L38;
        r4 = true;
    L38:
        if ((true ^ r4) == false) goto L42;
        n r18 = r17.j;
        if (r18 == null) goto L42;
        r16.e = r18.decode(r15);
    L42:
        int r19 = com.ss.ugc.live.sdk.msg.utils.g.a;
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r16);
    L43:
        if (r2 == null) goto L46;
        int r20 = com.ss.ugc.live.sdk.msg.utils.g.a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(r2);
    L46:
        if (this.j == true) goto L48;
    L50:
        int r21 = com.ss.ugc.live.sdk.msg.utils.g.a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new UplinkException(-3, "request not finish", null, null, 12, null));
    L48:
        if (this.a == false) goto L50;
        com.ss.ugc.live.sdk.msg.network.g r22 = new com.ss.ugc.live.sdk.msg.network.g();
        r22.a = 0;
        r22.b = "disable_response";
        r22.d = new byte[0];
        r22.c = new ArrayList();
        r22.f = 1;
        int r23 = com.ss.ugc.live.sdk.msg.utils.g.a;
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r22);
    }

    public final SdkUplinkPacket b() {
        Map<String, String> r0 = this.n.c;
        if (r0 != null) goto L6;
        r0 = new HashMap();
    L6:
        Map<String, String> r1 = this.n.d;
        if (r1 != null) goto L10;
        r1 = new HashMap();
    L10:
        byte[] r2 = this.n.a();
        String r3 = UriProtector.parse(this.n.b).getPath();     // Catch: Exception -> L16
        if (r3 != null) goto L18;
        r3 = this.n.b;     // Catch: Exception -> L16
    L18:
        return new SdkUplinkPacket.Builder().uniqueID(Long.valueOf(this.k)).serviceID(Long.valueOf(this.l)).uri(r3).queryParams(r1).headers(r0).payload(ByteString.of(Arrays.copyOf(r2, r2.length))).m1685build();
    L16:
        r3 = this.n.b;
        goto L18
    }

    public final boolean f() {
        String r0 = UriProtector.parse(this.n.b).getPath();     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L8;
    L10:
        return false;
    L8:
        if (TextUtils.equals("/", r0) == true) goto L10;
        return true;
    L4:
        r0 = null;
        goto L6
    }

    public final void d(com.ss.ugc.live.sdk.msg.network.g r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "httpResponse");
        Intrinsics.checkNotNullParameter(UplinkStrategy.ORIGIN_HTTP, "useUplinkStrategy");
        this.f = r6;
        f r1 = this.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "httpResponse");
        Intrinsics.checkNotNullParameter(UplinkStrategy.ORIGIN_HTTP, "uplinkStrategy");
        r1.f = System.currentTimeMillis();
        r1.b = UplinkStrategy.ORIGIN_HTTP;
        r1.d = r7;
        r1.g = true;
        r1.h = r6.a;
        r1.i = r6.b;
        r1.j = com.ss.ugc.live.sdk.msg.utils.c.c(r6);
    }

    public final void c(Exception r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        Intrinsics.checkNotNullParameter(r6, "useUplinkStrategy");
        this.g = r5;
        f r1 = this.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "exception");
        Intrinsics.checkNotNullParameter(r6, "uplinkStrategy");
        r1.f = System.currentTimeMillis();
        r1.b = r6;
        r1.d = r7;
        r1.g = false;
        if ((r5 instanceof UplinkException) == false) goto L5;
        int r8 = ((UplinkException) r5).getStatusCode();
    L6:
        r1.h = r8;
        String r9 = r5.getMessage();
        if (r9 != null) goto L10;
        r9 = "Unknown Exception";
    L10:
        r1.i = r9;
        if ((r5 instanceof UplinkException) == false) goto L13;
        String r10 = ((UplinkException) r5).getLogId();
    L14:
        r1.j = r10;
        return;
    L13:
        r10 = null;
        goto L14
    L5:
        r8 = -1;
        goto L6
    }

    public final void e(SdkUplinkPacket r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r4, "useUplinkStrategy");
        this.e = r6;
        this.d = r3;
        f r7 = this.h;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r4, "uplinkStrategy");
        r7.f = System.currentTimeMillis();
        r7.b = r4;
        r7.d = r5;
        r7.g = true;
        r7.h = r3.statusCode.intValue();
        r7.i = r3.statusMessage;
        r7.j = com.ss.ugc.live.sdk.msg.utils.h.b(r3);
    }

    public d(long r2, long r4, long r6, com.ss.ugc.live.sdk.msg.network.f r8, com.ss.ugc.live.sdk.msg.network.e r9) {
        Intrinsics.checkNotNullParameter(r8, "originHttpRequest");
        Intrinsics.checkNotNullParameter(r9, "httpCallback");
        this.k = r2;
        this.l = r4;
        this.m = r6;
        this.n = r8;
        this.o = r9;
        Map<String, String> r7 = r8.c;
        if (r7 == null) goto L7;
        String r10 = r7.get("BYTELINK-DISABLE-RESPONSE");
        if (r10 == null) goto L7;
        boolean r11 = Boolean.parseBoolean(r10);
    L8:
        this.a = r11;
        this.h = new f(r2, r4);
        return;
    L7:
        r11 = false;
        goto L8
    }
}
