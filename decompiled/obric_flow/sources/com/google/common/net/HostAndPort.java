package com.google.common.net;

import com.bytedance.sdk.xbridge.cn.auth.g;
import com.google.common.base.b;
import com.google.common.base.b0;
import com.google.common.base.y;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class HostAndPort implements Serializable {
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    public HostAndPort(String r5, int r10, boolean r11) {
        this.host = r5;
        this.port = r10;
        this.hasBracketlessColons = r11;
    }

    public static HostAndPort fromHost(String r5) {
        HostAndPort r10 = fromString(r5);
        b0.h("Host has a port: %s", !r10.hasPort(), r5);
        return r10;
    }

    public static HostAndPort fromParts(String r5, int r10) {
        if (r10 >= 0) goto L5;
    L7:
        boolean r11 = false;
    L8:
        b0.d(r10, "Port out of range: %s", r11);
        HostAndPort r12 = fromString(r5);
        b0.h("Host has a port: %s", true ^ r12.hasPort(), r5);
        return new HostAndPort(r12.host, r10, r12.hasBracketlessColons);
    L5:
        if (r10 > 65535) goto L7;
        r11 = true;
        goto L8
    }

    public static HostAndPort fromString(String r10) {
        int r5 = -1;
        boolean r11 = true;
        r10.getClass();
        if (r10.startsWith("[") == true) goto L5;
        int r12 = r10.indexOf(58);
        if (r12 < 0) goto L32;
        int r13 = r12 + 1;
        if (r10.indexOf(58, r13) != (-1)) goto L32;
        String r14 = r10.substring(0, r12);
        String r15 = r10.substring(r13);
    L26:
        String r16 = r14;
        boolean r17 = false;
    L36:
        g r18 = y.f8677a;
        if (r15 == null) goto L66;
        if (r15.isEmpty() == true) goto L66;
        if (r15.startsWith("+") == true) goto L50;
        b r19 = b.f8648a;
        r19.getClass();
        int r20 = r15.length() - 1;
    L44:
        if (r20 < 0) goto L49;
        if (r19.b(r15.charAt(r20)) == false) goto L50;
        r20 = r20 - 1;
        goto L44
    L49:
        boolean r21 = true;
    L51:
        b0.h("Unparseable port number: %s", r21, r10);
        r5 = Integer.parseInt(r15);     // Catch: NumberFormatException -> L59
        if (r5 >= 0) goto L55;
    L57:
        r11 = false;
    L58:
        b0.h("Port number out of range: %s", r11, r10);
        goto L66
    L55:
        if (r5 > 65535) goto L57;
    L60:
        if (r10.length() == 0) goto L62;
        String r110 = "Unparseable port number: ".concat(r10);
    L64:
        throw new IllegalArgumentException(r110);
    L62:
        r110 = new String("Unparseable port number: ");
    L50:
        r21 = false;
    L66:
        return new HostAndPort(r16, r5, r17);
    L32:
        if (r12 < 0) goto L34;
        boolean r22 = true;
    L35:
        r16 = r10;
        r17 = r22;
        r15 = null;
        goto L36
    L34:
        r22 = false;
        goto L35
    L5:
        if (r10.charAt(0) != '[') goto L7;
        boolean r23 = true;
    L8:
        b0.h("Bracketed host-port string must start with a bracket: %s", r23, r10);
        int r24 = r10.indexOf(58);
        int r25 = r10.lastIndexOf(93);
        if (r24 <= (-1)) goto L12;
        if (r25 <= r24) goto L12;
        boolean r26 = true;
    L13:
        b0.h("Invalid bracketed host/port: %s", r26, r10);
        String r27 = r10.substring(1, r25);
        int r28 = r25 + 1;
        if (r28 != r10.length()) goto L17;
        String[] r29 = {r27, ""};
    L25:
        r14 = r29[0];
        r15 = r29[1];
        goto L26
    L17:
        if (r10.charAt(r28) != ':') goto L19;
        boolean r30 = true;
    L20:
        b0.h("Only a colon may follow a close bracket: %s", r30, r10);
        int r31 = r25 + 2;
        int r32 = r31;
    L22:
        if (r32 >= r10.length()) goto L24;
        b0.h("Port must be numeric: %s", Character.isDigit(r10.charAt(r32)), r10);
        r32 = r32 + 1;
        goto L22
    L24:
        r29 = new String[]{r27, r10.substring(r31)};
        goto L25
    L19:
        r30 = false;
    L12:
        r26 = false;
        goto L13
    L7:
        r23 = false;
        goto L8
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HostAndPort) == false) goto L14;
        HostAndPort r10 = (HostAndPort) r5;
        if (b0.w(this.host, r10.host) == false) goto L13;
        if (this.port != r10.port) goto L13;
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
        b0.t(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int r5) {
        if (hasPort() == true) goto L5;
        return r5;
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
        return Arrays.hashCode(new Object[]{this.host, Integer.valueOf(this.port)});
    }

    public HostAndPort requireBracketsForIPv6() {
        b0.h("Possible bracketless IPv6 literal: %s", !this.hasBracketlessColons, this.host);
        return this;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) < 0) goto L5;
        r5.append('[');
        r5.append(this.host);
        r5.append(']');
    L7:
        if (hasPort() == false) goto L10;
        r5.append(':');
        r5.append(this.port);
    L10:
        return r5.toString();
    L5:
        r5.append(this.host);
        goto L7
    }

    public HostAndPort withDefaultPort(int r5) {
        if (r5 >= 0) goto L4;
    L6:
        boolean r10 = false;
    L7:
        b0.i(r10);
        if (hasPort() == false) goto L11;
        return this;
    L11:
        return new HostAndPort(this.host, r5, this.hasBracketlessColons);
    L4:
        if (r5 > 65535) goto L6;
        r10 = true;
        goto L7
    }
}
