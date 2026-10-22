package r3;

import java.io.Serializable;
import java.net.ProtocolException;
import we.w;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Serializable f11423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f11424d;

    public e() {
        this.f11421a = 0;
        this.f11422b = -1;
    }

    public static e a(String r8) {
        if (r8.startsWith("HTTP/1.") == false) goto L19;
        int r10 = 9;
        if (r8.length() < 9) goto L17;
        if (r8.charAt(8) != ' ') goto L17;
        int r11 = r8.charAt(7) - '0';
        if (r11 != 0) goto L12;
        w r12 = w.f13319b;
    L21:
        int r13 = r10 + 3;
        if (r8.length() < r13) goto L37;
        int r14 = Integer.parseInt(r8.substring(r10, r13));     // Catch: NumberFormatException -> L34
        if (r8.length() > r13) goto L27;
        String r15 = "";
    L33:
        return new e(r12, r14, r15);
    L27:
        if (r8.charAt(r13) != ' ') goto L30;
        r15 = r8.substring(r10 + 4);
        goto L33
    L30:
        throw new ProtocolException("Unexpected status line: ".concat(r8));
    L35:
        throw new ProtocolException("Unexpected status line: ".concat(r8));
    L37:
        throw new ProtocolException("Unexpected status line: ".concat(r8));
    L12:
        if (r11 != 1) goto L15;
        r12 = w.f13320m;
        goto L21
    L15:
        throw new ProtocolException("Unexpected status line: ".concat(r8));
    L17:
        throw new ProtocolException("Unexpected status line: ".concat(r8));
    L19:
        if (r8.startsWith("ICY ") == false) goto L39;
        r12 = w.f13319b;
        r10 = 4;
        goto L21
    L39:
        throw new ProtocolException("Unexpected status line: ".concat(r8));
    }

    public final String toString() {
        switch(this.f11421a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r8 = new StringBuilder();
        if (((w) this.f11423c) != w.f13319b) goto L9;
        String r10 = "HTTP/1.0";
    L10:
        r8.append(r10);
        r8.append(' ');
        r8.append(this.f11422b);
        if (((String) this.f11424d) == null) goto L14;
        r8.append(' ');
        r8.append((String) this.f11424d);
    L14:
        return r8.toString();
    L9:
        r10 = "HTTP/1.1";
        goto L10
    L5:
        return super.toString();
    }

    public e(w r8, int r10, String r11) {
        this.f11421a = 1;
        this.f11423c = r8;
        this.f11422b = r10;
        this.f11424d = r11;
    }
}
