package l9;

import ai.j0;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19572c;
    public final String d;
    public final String e;
    public final String f;

    public k(String r5, String r10, String r11, String r12) {
        long r13 = System.currentTimeMillis();
        this.f19570a = r13;
        this.f19572c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.f19571b = zm.p.o().format(new Date(r13));     // Catch: Throwable -> L5
    L7:
        if (this.f19570a >= 0) goto L10;
        this.f19570a = System.currentTimeMillis();
    L10:
        if (this.f19572c != null) goto L13;
        this.f19572c = "";
    L13:
        if (this.d != null) goto L16;
        this.d = "";
    L16:
        if (this.e != null) goto L19;
        this.e = "";
    L19:
        if (this.f != null) goto L22;
        this.f = "";
    L22:
        if (this.f19571b != null) goto L27;
        this.f19571b = "";
        return;
    L27:
        return;
    L5:
        this.f19571b = "";
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f19570a);
        r5.append("|");
        r5.append(this.f19571b);
        r5.append("|");
        r5.append(this.d);
        r5.append("|");
        r5.append(this.e);
        r5.append("|");
        r5.append(this.f19572c);
        r5.append("|");
        return j0.q(r5, this.f, "\n");
    }
}
