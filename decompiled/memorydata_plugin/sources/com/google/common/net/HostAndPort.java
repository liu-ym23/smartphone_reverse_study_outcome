package com.google.common.net;

import com.google.common.base.b;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String r1, int r2, boolean r3) {
        this.host = r1;
        this.port = r2;
        this.hasBracketlessColons = r3;
    }

    public static HostAndPort fromHost(String r3) {
        HostAndPort r0 = fromString(r3);
        n.a(!r0.hasPort(), "Host has a port: %s", r3);
        return r0;
    }

    public static HostAndPort fromParts(String r3, int r4) {
        n.a(isValidPort(r4), "Port out of range: %s", r4);
        HostAndPort r0 = fromString(r3);
        n.a(!r0.hasPort(), "Host has a port: %s", r3);
        return new HostAndPort(r0.host, r4, r0.hasBracketlessColons);
    }

    public static HostAndPort fromString(String r8) {
        n.a(r8);
        int r1 = -1;
        boolean r2 = true;
        if (r8.startsWith("[") == false) goto L6;
        String[] r0 = getHostAndPortFromBracketedHost(r8);
        String r4 = r0[0];
        String r3 = r0[1];
    L5:
        String r5 = r4;
        boolean r6 = false;
    L16:
        if (q.b(r3) == true) goto L29;
        if (r3.startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L20;
    L22:
        r2 = false;
    L23:
        n.a(r2, "Unparseable port number: %s", r8);
        r1 = Integer.parseInt(r3);     // Catch: NumberFormatException -> L26
        n.a(isValidPort(r1), "Port number out of range: %s", r8);
    L27:
        throw new IllegalArgumentException("Unparseable port number: " + r8);
    L20:
        if (b.a().a(r3) == false) goto L22;
    L29:
        return new HostAndPort(r5, r1, r6);
    L6:
        int r7 = r8.indexOf(58);
        if (r7 < 0) goto L11;
        int r9 = r7 + 1;
        if (r8.indexOf(58, r9) != (-1)) goto L11;
        r4 = r8.substring(0, r7);
        r3 = r8.substring(r9);
    L11:
        if (r7 < 0) goto L13;
        boolean r10 = true;
    L14:
        r5 = r8;
        r6 = r10;
        r3 = null;
        goto L16
    L13:
        r10 = false;
        goto L14
    }

    private static String[] getHostAndPortFromBracketedHost(String r8) {
        if (r8.charAt(0) != '[') goto L5;
        boolean r1 = true;
    L6:
        n.a(r1, "Bracketed host-port string must start with a bracket: %s", r8);
        int r3 = r8.indexOf(58);
        int r4 = r8.lastIndexOf(93);
        if (r3 <= (-1)) goto L10;
        if (r4 <= r3) goto L10;
        boolean r5 = true;
    L11:
        n.a(r5, "Invalid bracketed host/port: %s", r8);
        String r6 = r8.substring(1, r4);
        int r7 = r4 + 1;
        if (r7 != r8.length()) goto L16;
        return new String[]{r6, ""};
    L16:
        if (r8.charAt(r7) != ':') goto L18;
        boolean r2 = true;
    L19:
        n.a(r2, "Only a colon may follow a close bracket: %s", r8);
        int r9 = r4 + 2;
        int r10 = r9;
    L21:
        if (r10 >= r8.length()) goto L24;
        n.a(Character.isDigit(r8.charAt(r10)), "Port must be numeric: %s", r8);
        r10 = r10 + 1;
        goto L21
    L24:
        return new String[]{r6, r8.substring(r9)};
    L18:
        r2 = false;
    L10:
        r5 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private static boolean isValidPort(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 65535) goto L6;
        return true;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HostAndPort.class) == false) goto L14;
        HostAndPort r6 = (HostAndPort) ZeusTransformUtils.preCheckCast(r5, HostAndPort.class, "com.obric.memorydata.plugin");
        if (k.a(this.host, r6.host) == false) goto L13;
        if (this.port != r6.port) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        n.b(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int r2) {
        if (hasPort() == true) goto L5;
        return r2;
    L5:
        return this.port;
    }

    public boolean hasPort() {
        if (this.port < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return k.a(new Object[]{this.host, Integer.valueOf(this.port)});
    }

    public HostAndPort requireBracketsForIPv6() {
        n.a(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) < 0) goto L5;
        r0.append('[').append(this.host).append(']');
    L7:
        if (hasPort() == false) goto L10;
        r0.append(':').append(this.port);
    L10:
        return r0.toString();
    L5:
        r0.append(this.host);
        goto L7
    }

    public HostAndPort withDefaultPort(int r3) {
        n.a(isValidPort(r3));
        if (hasPort() == false) goto L6;
        return this;
    L6:
        return new HostAndPort(this.host, r3, this.hasBracketlessColons);
    }
}
