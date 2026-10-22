package io.noties.markwon.html.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class b implements Cloneable, Iterable<a> {
    private static final String[] c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String[] f16577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String[] f16578b;
    private int d;

    static {
        c = new String[0];
    }

    public b() {
        this.d = 0;
        String[] r0 = c;
        this.f16577a = r0;
        this.f16578b = r0;
    }

    static /* synthetic */ int a(b r0) {
        return r0.d;
    }

    private void a(int r4) {
        if (r4 < this.d) goto L5;
        boolean r0 = true;
    L6:
        io.noties.markwon.html.jsoup.a.b.a(r0);
        String[] r1 = this.f16577a;
        int r2 = r1.length;
        if (r2 < r4) goto L9;
        return;
    L9:
        int r3 = 4;
        if (r2 < 4) goto L12;
        r3 = this.d * 2;
    L12:
        if (r4 > r3) goto L15;
        r4 = r3;
    L15:
        this.f16577a = a(r1, r4);
        this.f16578b = a(this.f16578b, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ void a(b r0, int r1) {
        r0.b(r1);
    }

    private static String[] a(String[] r2, int r3) {
        String[] r0 = new String[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    static String b(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    private void b(int r5) {
        if (r5 < this.d) goto L5;
        boolean r0 = true;
    L6:
        io.noties.markwon.html.jsoup.a.b.b(r0);
        int r1 = (this.d - r5) - 1;
        if (r1 <= 0) goto L9;
        String[] r2 = this.f16577a;
        int r3 = r5 + 1;
        System.arraycopy(r2, r3, r2, r5, r1);
        String[] r4 = this.f16578b;
        System.arraycopy(r4, r3, r4, r5, r1);
    L9:
        int r6 = this.d - 1;
        this.d = r6;
        this.f16577a[r6] = null;
        this.f16578b[r6] = null;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void b(String r3, String r4) {
        a(this.d + 1);
        String[] r0 = this.f16577a;
        int r1 = this.d;
        r0[r1] = r3;
        this.f16578b[r1] = r4;
        this.d = r1 + 1;
    }

    public int a() {
        return this.d;
    }

    int a(String r3) {
        io.noties.markwon.html.jsoup.a.b.a(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.d) goto L9;
        if (r3.equals(this.f16577a[r0]) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public b a(String r3, String r4) {
        int r0 = a(r3);
        if (r0 == (-1)) goto L5;
        this.f16578b[r0] = r4;
    L6:
        return this;
    L5:
        b(r3, r4);
        goto L6
    }

    public b b() {
        b r0 = (b) ZeusTransformUtils.preCheckCast(super.clone(), b.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L5
        r0.d = this.d;
        this.f16577a = a(this.f16577a, this.d);
        this.f16578b = a(this.f16578b, this.d);
        return r0;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public String c(String r2) {
        int r3 = a(r2);
        if (r3 != (-1)) goto L6;
        return "";
    L6:
        return b(this.f16578b[r3]);
    }

    public /* synthetic */ Object clone() {
        return b();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L18;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
        if (this.d == r5.d) goto L14;
        return false;
    L14:
        if (Arrays.equals(this.f16577a, r5.f16577a) == true) goto L17;
        return false;
    L17:
        return Arrays.equals(this.f16578b, r5.f16578b);
    }

    public int hashCode() {
        return (((this.d * 31) + Arrays.hashCode(this.f16577a)) * 31) + Arrays.hashCode(this.f16578b);
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return new AnonymousClass1(this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<a> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");
        r0.append(r1.a()).append("=\"").append(r1.b()).append("\" ");
        goto L4
    L7:
        return r0.toString();
    }
}
