package com.airbnb.lottie.parser.moshi;

import ai.j0;
import java.io.Closeable;
import java.util.Arrays;
import ko.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Closeable {
    public static final String[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f1304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f1305c;
    public int[] d;

    static {
        e = new String[128];
        int r5 = 0;
    L4:
        if (r5 > 31) goto L6;
        e[r5] = String.format("\\u%04x", new Object[]{Integer.valueOf(r5)});
        r5 = r5 + 1;
        goto L4
    L6:
        String[] r10 = e;
        r10[34] = "\\\"";
        r10[92] = "\\\\";
        r10[9] = "\\t";
        r10[8] = "\\b";
        r10[10] = "\\n";
        r10[13] = "\\r";
        r10[12] = "\\f";
    }

    public abstract JsonReader$Token J();

    public final void K(int r5) {
        int r10 = this.f1303a;
        int[] r11 = this.f1304b;
        if (r10 == r11.length) goto L5;
    L9:
        int[] r12 = this.f1304b;
        int r13 = this.f1303a;
        this.f1303a = r13 + 1;
        r12[r13] = r5;
        return;
    L5:
        if (r10 == 256) goto L8;
        this.f1304b = Arrays.copyOf(r11, r11.length * 2);
        String[] r14 = this.f1305c;
        this.f1305c = (String[]) Arrays.copyOf(r14, r14.length * 2);
        int[] r15 = this.d;
        this.d = Arrays.copyOf(r15, r15.length * 2);
        goto L9
    L8:
        throw new JsonDataException("Nesting too deep at " + getPath());
    }

    public abstract int L(r r5);

    public abstract void M();

    public abstract void N();

    public final void O(String r5) {
        StringBuilder r10 = j0.w(r5, " at path ");
        r10.append(getPath());
        throw new JsonEncodingException(r10.toString());
    }

    public abstract void b();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract boolean g();

    public final String getPath() {
        int r5 = this.f1303a;
        int[] r10 = this.f1304b;
        String[] r11 = this.f1305c;
        int[] r12 = this.d;
        StringBuilder r13 = new StringBuilder("$");
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L21;
        int r15 = r10[r14];
        if (r15 != 1) goto L7;
    L18:
        r13.append('[');
        r13.append(r12[r14]);
        r13.append(']');
    L19:
        r14 = r14 + 1;
        goto L3
    L7:
        if (r15 == 2) goto L18;
        if (r15 != 3) goto L11;
    L15:
        r13.append('.');
        String r16 = r11[r14];
        if (r16 == null) goto L19;
        r13.append(r16);
        goto L19
    L11:
        if (r15 == 4) goto L15;
        if (r15 == 5) goto L15;
    L21:
        return r13.toString();
    }

    public abstract boolean m();

    public abstract double n();

    public abstract int p();

    public abstract String q();
}
