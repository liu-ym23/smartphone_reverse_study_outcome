package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.SerializationException;

/* JADX INFO: loaded from: classes7.dex */
public class b implements Cloneable, Iterable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String[] f18258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f18259b;
    private int c;

    public b() {
        this.c = 0;
        this.f18258a = new String[3];
        this.f18259b = new Object[3];
    }

    static String a(Object r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    }

    private void a(int r4) {
        if (r4 < this.c) goto L5;
        boolean r0 = true;
    L6:
        org.jsoup.helper.b.a(r0);
        String[] r1 = this.f18258a;
        int r2 = r1.length;
        if (r2 < r4) goto L9;
        return;
    L9:
        int r3 = 3;
        if (r2 < 3) goto L12;
        r3 = this.c * 2;
    L12:
        if (r4 > r3) goto L15;
        r4 = r3;
    L15:
        this.f18258a = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r4), String[].class, "com.obric.memorydata.plugin");
        this.f18259b = Arrays.copyOf(this.f18259b, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ void a(b r0, int r1) {
        r0.b(r1);
    }

    static /* synthetic */ boolean a(b r0, String r1) {
        return r0.k(r1);
    }

    static /* synthetic */ int b(b r0) {
        return r0.c;
    }

    private void b(int r5) {
        if (r5 < this.c) goto L5;
        boolean r0 = true;
    L6:
        org.jsoup.helper.b.b(r0);
        int r1 = (this.c - r5) - 1;
        if (r1 <= 0) goto L9;
        String[] r2 = this.f18258a;
        int r3 = r5 + 1;
        System.arraycopy(r2, r3, r2, r5, r1);
        Object[] r4 = this.f18259b;
        System.arraycopy(r4, r3, r4, r5, r1);
    L9:
        int r6 = this.c - 1;
        this.c = r6;
        this.f18258a[r6] = null;
        this.f18259b[r6] = null;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void b(String r3, Object r4) {
        a(this.c + 1);
        String[] r0 = this.f18258a;
        int r1 = this.c;
        r0[r1] = r3;
        this.f18259b[r1] = r4;
        this.c = r1 + 1;
    }

    static String i(String r2) {
        return '/' + r2;
    }

    private int j(String r3) {
        org.jsoup.helper.b.a(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.c) goto L9;
        if (r3.equalsIgnoreCase(this.f18258a[r0]) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private boolean k(String r3) {
        if (r3 == null) goto L10;
        if (r3.length() <= 1) goto L10;
        if (r3.charAt(0) != '/') goto L10;
        return true;
    L10:
        return false;
    }

    public int a() {
        return this.c;
    }

    int a(String r3) {
        org.jsoup.helper.b.a(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.c) goto L9;
        if (r3.equals(this.f18258a[r0]) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public int a(org.jsoup.parser.d r7) {
        int r1 = 0;
        if (b() == false) goto L5;
        return 0;
    L5:
        boolean r8 = r7.b();
        int r0 = 0;
    L7:
        if (r1 >= this.f18258a.length) goto L23;
        int r2 = r1 + 1;
        int r3 = r2;
    L9:
        Object[] r4 = this.f18258a;
        if (r3 >= r4.length) goto L22;
        if (r4[r3] == null) goto L22;
        if (r8 == true) goto L16;
    L17:
        if (r8 == true) goto L21;
        String[] r5 = this.f18258a;
        if (r5[r1].equalsIgnoreCase(r5[r3]) == false) goto L21;
    L20:
        r0 = r0 + 1;
        b(r3);
        r3 = r3 - 1;
    L21:
        r3 = r3 + 1;
        goto L9
    L16:
        if (r4[r1].equals(r4[r3]) == true) goto L20;
    L22:
        r1 = r2;
        goto L7
    L23:
        return r0;
    }

    b a(String r3, Object r4) {
        org.jsoup.helper.b.a(r3);
        if (k(r3) == true) goto L5;
        r3 = i(r3);
    L5:
        org.jsoup.helper.b.a(r4);
        int r0 = a(r3);
        if (r0 == (-1)) goto L8;
        this.f18259b[r0] = r4;
    L9:
        return this;
    L8:
        b(r3, r4);
        goto L9
    }

    public b a(String r1, String r2) {
        b(r1, r2);
        return this;
    }

    public b a(a r3) {
        org.jsoup.helper.b.a(r3);
        b(r3.a(), r3.b());
        r3.f18257a = this;
        return this;
    }

    final void a(Appendable r7, Document.OutputSettings r8) {
        Appendable r9 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r7, Appendable.class, "com.obric.memorydata.plugin");
        int r0 = this.c;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (k(this.f18258a[r2]) == true) goto L10;
        String r3 = a.a(this.f18258a[r2], r8.d());
        if (r3 == null) goto L10;
        a.b(r3, (String) ZeusTransformUtils.preCheckCast(this.f18259b[r2], String.class, "com.obric.memorydata.plugin"), r9.append(' '), r8);
    L10:
        r2 = r2 + 1;
        goto L3
    }

    public void a(b r5) {
        if (r5.a() != 0) goto L5;
        return;
    L5:
        a(this.c + r5.c);
        if (this.c == 0) goto L8;
        boolean r0 = true;
    L9:
        Iterator<a> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L16;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin");
        if (r0 == true) goto L14;
        a(r1.a(), r1.b());
        goto L11
    L14:
        a(r1);
        goto L11
    L16:
        return;
    L8:
        r0 = false;
        goto L9
    }

    public String b(String r2) {
        int r3 = a(r2);
        if (r3 != (-1)) goto L6;
        return "";
    L6:
        return a(this.f18259b[r3]);
    }

    public b b(String r3, String r4) {
        org.jsoup.helper.b.a(r3);
        int r0 = a(r3);
        if (r0 == (-1)) goto L5;
        this.f18259b[r0] = r4;
    L6:
        return this;
    L5:
        a(r3, r4);
        goto L6
    }

    public boolean b() {
        if (this.c != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String c(String r2) {
        int r3 = j(r2);
        if (r3 != (-1)) goto L6;
        return "";
    L6:
        return a(this.f18259b[r3]);
    }

    public List<a> c() {
        ArrayList r0 = new ArrayList(this.c);
        int r1 = 0;
    L4:
        if (r1 >= this.c) goto L11;
        if (k(this.f18258a[r1]) == true) goto L9;
        r0.add(new a(this.f18258a[r1], (String) ZeusTransformUtils.preCheckCast(this.f18259b[r1], String.class, "com.obric.memorydata.plugin"), this));
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return Collections.unmodifiableList(r0);
    }

    void c(String r3, String r4) {
        int r0 = j(r3);
        if (r0 == (-1)) goto L7;
        this.f18259b[r0] = r4;
        if (this.f18258a[r0].equals(r3) == true) goto L9;
        this.f18258a[r0] = r3;
        return;
    L9:
        return;
    L7:
        a(r3, r4);
    }

    public /* synthetic */ Object clone() {
        return e();
    }

    Object d(String r2) {
        org.jsoup.helper.b.a(r2);
        if (k(r2) == true) goto L5;
        r2 = i(r2);
    L5:
        int r3 = j(r2);
        if (r3 != (-1)) goto L9;
        return null;
    L9:
        return this.f18259b[r3];
    }

    public String d() {
        StringBuilder r0 = org.jsoup.a.b.a();
        a(r0, new Document("").j());     // Catch: IOException -> L6
        return org.jsoup.a.b.a(r0);
    L6:
        e = move-exception;
        throw new SerializationException(e);
    }

    public b e() {
        b r1 = (b) ZeusTransformUtils.preCheckCast(super.clone(), b.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L6
        r1.c = this.c;
        r1.f18258a = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.f18258a, this.c), String[].class, "com.obric.memorydata.plugin");
        r1.f18259b = Arrays.copyOf(this.f18259b, this.c);
        return r1;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void e(String r2) {
        int r3 = a(r2);
        if (r3 == (-1)) goto L6;
        b(r3);
        return;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L28:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L28;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        if (this.c == r8.c) goto L13;
        return false;
    L13:
        int r2 = 0;
    L15:
        if (r2 >= this.c) goto L27;
        int r3 = r8.a(this.f18258a[r2]);
        if (r3 == (-1)) goto L18;
        Object r4 = this.f18259b[r2];
        Object r5 = r8.f18259b[r3];
        if (r4 != null) goto L24;
        if (r5 == null) goto L26;
        return false;
    L26:
        r2 = r2 + 1;
        goto L15
    L24:
        if (r4.equals(r5) == true) goto L26;
        return false;
    L18:
        return false;
    L27:
        return true;
    }

    public void f() {
        int r0 = 0;
    L4:
        if (r0 >= this.c) goto L6;
        String[] r1 = this.f18258a;
        r1[r0] = org.jsoup.a.a.a(r1[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public void f(String r2) {
        int r3 = j(r2);
        if (r3 == (-1)) goto L6;
        b(r3);
        return;
    }

    public boolean g(String r1) {
        if (a(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h(String r1) {
        if (j(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return (((this.c * 31) + Arrays.hashCode(this.f18258a)) * 31) + Arrays.hashCode(this.f18259b);
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return new AnonymousClass1(this);
    }

    public String toString() {
        return d();
    }
}
