package ze;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import we.j;
import we.v;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f14368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14371d;

    public b(List<j> r8) {
        this.f14369b = 0;
        this.f14368a = r8;
    }

    public final j a(SSLSocket r13) {
        int r8 = this.f14369b;
        List<j> r10 = this.f14368a;
        int r11 = r10.size();
    L4:
        if (r8 >= r11) goto L9;
        j r12 = r10.get(r8);
        if (r12.a(r13) == true) goto L7;
        r8 = r8 + 1;
        goto L4
    L7:
        this.f14369b = r8 + 1;
    L10:
        if (r12 == null) goto L46;
        int r14 = this.f14369b;
    L13:
        if (r14 >= r10.size()) goto L18;
        if (r10.get(r14).a(r13) == true) goto L16;
        r14 = r14 + 1;
        goto L13
    L16:
        boolean r15 = true;
    L19:
        this.f14370c = r15;
        v.a r16 = xe.a.f13878a;
        boolean r17 = this.f14371d;
        r16.getClass();
        String[] r18 = r12.f13206c;
        if (r18 == null) goto L22;
        String[] r19 = xe.c.r(we.g.f13173b, r13.getEnabledCipherSuites(), r18);
    L23:
        String[] r20 = r12.f13207d;
        if (r20 == null) goto L26;
        String[] r21 = xe.c.r(xe.c.f13894o, r13.getEnabledProtocols(), r20);
    L27:
        String[] r22 = r13.getSupportedCipherSuites();
        we.g.a r23 = we.g.f13173b;
        byte[] r24 = xe.c.f13880a;
        int r25 = r22.length;
        int r26 = 0;
    L29:
        if (r26 >= r25) goto L34;
        if (r23.compare(r22[r26], "TLS_FALLBACK_SCSV") == 0) goto L35;
        r26 = r26 + 1;
    L35:
        if (r17 == false) goto L38;
        if (r26 == (-1)) goto L38;
        String r110 = r22[r26];
        int r27 = r19.length + 1;
        String[] r28 = new String[r27];
        System.arraycopy(r19, 0, r28, 0, r19.length);
        r28[r27 - 1] = r110;
        r19 = r28;
    L38:
        j.a r111 = new j.a(r12);
        r111.a(r19);
        r111.c(r21);
        j r29 = new j(r111);
        String[] r112 = r29.f13207d;
        if (r112 == null) goto L41;
        r13.setEnabledProtocols(r112);
    L41:
        String[] r113 = r29.f13206c;
        if (r113 == null) goto L44;
        r13.setEnabledCipherSuites(r113);
    L44:
        return r12;
    L34:
        r26 = -1;
        goto L35
    L26:
        r21 = r13.getEnabledProtocols();
        goto L27
    L22:
        r19 = r13.getEnabledCipherSuites();
        goto L23
    L18:
        r15 = false;
        goto L19
    L46:
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f14371d + ", modes=" + r10 + ", supported protocols=" + Arrays.toString(r13.getEnabledProtocols()));
    L9:
        r12 = null;
        goto L10
    }
}
