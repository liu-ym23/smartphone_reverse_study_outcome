package com.tom_roush.pdfbox.pdmodel;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class h implements com.tom_roush.pdfbox.pdmodel.common.c, Iterable<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f16281b;
    private final Set<com.tom_roush.pdfbox.a.d> c;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class a implements Iterator<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f16282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Queue<com.tom_roush.pdfbox.a.d> f16283b;
        private Set<com.tom_roush.pdfbox.a.d> c;

        private a(h r1, com.tom_roush.pdfbox.a.d r2) {
            this.f16282a = r1;
            this.f16283b = new ArrayDeque();
            this.c = new HashSet();
            a(r2);
            this.c = null;
        }

        /* synthetic */ a(h r1, com.tom_roush.pdfbox.a.d r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private void a(com.tom_roush.pdfbox.a.d r5) {
            if (h.a(this.f16282a, r5) == false) goto L15;
            Iterator r6 = h.b(this.f16282a, r5).iterator();
        L6:
            if (r6.hasNext() == false) goto L26;
            com.tom_roush.pdfbox.a.d r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6.next(), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
            if (this.c.contains(r0) == true) goto L9;
            if (r0.m(com.tom_roush.pdfbox.a.i.el) == false) goto L13;
            this.c.add(r0);
        L13:
            a(r0);
            goto L6
        L9:
            Log.e("PdfBox-Android", "This page tree node has already been visited");
            goto L6
        L26:
            return;
        L15:
            if (com.tom_roush.pdfbox.a.i.fW.equals(r5.b(com.tom_roush.pdfbox.a.i.iz)) == false) goto L17;
            this.f16283b.add(r5);
            return;
        L17:
            Log.e("PdfBox-Android", "Page skipped due to an invalid or missing type " + r5.b(com.tom_roush.pdfbox.a.i.iz));
        }

        public g a() {
            if (hasNext() == false) goto L11;
            com.tom_roush.pdfbox.a.d r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16283b.poll(), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
            h.a(r0);
            if (h.a(this.f16282a) == null) goto L7;
            k r3 = h.a(this.f16282a).e();
        L9:
            return new g(r0, r3);
        L7:
            r3 = null;
            goto L9
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f16283b.isEmpty();
        }

        @Override // java.util.Iterator
        public /* synthetic */ g next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.tom_roush.pdfbox.a.d f16284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16285b;
        private boolean c;

        private b(g r2) {
            this.f16285b = -1;
            this.f16284a = r2.d();
        }

        /* synthetic */ b(g r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int a(b r0) {
            return r0.f16285b;
        }

        private void a(com.tom_roush.pdfbox.a.d r3) {
            boolean r1 = true;
            this.f16285b++;
            if (this.f16284a == r3) goto L6;
            r1 = false;
        L6:
            this.c = r1;
        }

        static /* synthetic */ void a(b r0, com.tom_roush.pdfbox.a.d r1) {
            r0.a(r1);
        }

        static /* synthetic */ boolean b(b r0) {
            return r0.c;
        }
    }

    public h() {
        this.c = new HashSet();
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16280a = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.ga);
        r0.a(com.tom_roush.pdfbox.a.i.el, new com.tom_roush.pdfbox.a.a());
        r0.a(com.tom_roush.pdfbox.a.i.bk, com.tom_roush.pdfbox.a.h.f16054a);
        this.f16281b = null;
    }

    h(com.tom_roush.pdfbox.a.d r3, c r4) {
        this.c = new HashSet();
        if (r3 == null) goto L11;
        if (com.tom_roush.pdfbox.a.i.fW.equals(r3.b(com.tom_roush.pdfbox.a.i.iz)) == false) goto L7;
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        r0.a(r3);
        com.tom_roush.pdfbox.a.d r5 = new com.tom_roush.pdfbox.a.d();
        this.f16280a = r5;
        r5.a(com.tom_roush.pdfbox.a.i.el, r0);
        r5.a(com.tom_roush.pdfbox.a.i.bk, 1);
    L8:
        this.f16281b = r4;
        return;
    L7:
        this.f16280a = r3;
        goto L8
    L11:
        throw new IllegalArgumentException("page tree root cannot be null");
    }

    public static com.tom_roush.pdfbox.a.b a(com.tom_roush.pdfbox.a.d r2, com.tom_roush.pdfbox.a.i r3) {
        com.tom_roush.pdfbox.a.b r0 = r2.a(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.tom_roush.pdfbox.a.b r4 = r2.a(com.tom_roush.pdfbox.a.i.ge, com.tom_roush.pdfbox.a.i.fV);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.d.class) == false) goto L11;
        com.tom_roush.pdfbox.a.d r5 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (com.tom_roush.pdfbox.a.i.ga.equals(r5.a(com.tom_roush.pdfbox.a.i.iz)) == true) goto L10;
        return null;
    L10:
        return a(r5, r3);
    L11:
        return null;
    }

    private com.tom_roush.pdfbox.a.d a(int r6, com.tom_roush.pdfbox.a.d r7, int r8) {
        if (r6 < 1) goto L36;
        if (this.c.contains(r7) == true) goto L33;
        this.c.add(r7);
        if (d(r7) == true) goto L9;
        if (r8 != r6) goto L32;
        this.c.clear();
        return r7;
    L32:
        throw new IllegalStateException("1-based index not found: " + r6);
    L9:
        if (r6 > (r7.b(com.tom_roush.pdfbox.a.i.bk, 0) + r8)) goto L27;
        Iterator<com.tom_roush.pdfbox.a.d> r9 = b(r7).iterator();
    L12:
        if (r9.hasNext() == false) goto L25;
        com.tom_roush.pdfbox.a.d r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r9.next(), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (d(r0) == true) goto L15;
        r8 = r8 + 1;
        if (r6 != r8) goto L12;
        return a(r6, r0, r8);
    L15:
        int r3 = r0.b(com.tom_roush.pdfbox.a.i.bk, 0) + r8;
        if (r6 <= r3) goto L18;
        r8 = r3;
        goto L12
    L18:
        return a(r6, r0, r8);
    L25:
        throw new IllegalStateException("1-based index not found: " + r6);
    L27:
        throw new IndexOutOfBoundsException("1-based index out of bounds: " + r6);
    L33:
        this.c.clear();
        throw new IllegalStateException("Possible recursion found when searching for page " + r6);
    L36:
        throw new IndexOutOfBoundsException("Index out of bounds: " + r6);
    }

    static /* synthetic */ c a(h r0) {
        return r0.f16281b;
    }

    static /* synthetic */ void a(com.tom_roush.pdfbox.a.d r0) {
        c(r0);
    }

    private boolean a(b r4, com.tom_roush.pdfbox.a.d r5) {
        Iterator<com.tom_roush.pdfbox.a.d> r6 = b(r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        com.tom_roush.pdfbox.a.d r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6.next(), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (b.b(r4) == true) goto L13;
        if (d(r0) == true) goto L10;
        b.a(r4, r0);
        goto L4
    L10:
        a(r4, r0);
    L13:
        return b.b(r4);
    }

    static /* synthetic */ boolean a(h r0, com.tom_roush.pdfbox.a.d r1) {
        return r0.d(r1);
    }

    private List<com.tom_roush.pdfbox.a.d> b(com.tom_roush.pdfbox.a.d r6) {
        ArrayList r5 = new ArrayList();
        com.tom_roush.pdfbox.a.a r7 = r6.f(com.tom_roush.pdfbox.a.i.el);
        if (r7 != null) goto L5;
        return r5;
    L5:
        int r0 = 0;
        int r1 = r7.b();
    L6:
        if (r0 >= r1) goto L16;
        com.tom_roush.pdfbox.a.b r2 = r7.a(r0);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == false) goto L10;
        r5.add((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    L15:
        r0 = r0 + 1;
        goto L6
    L10:
        StringBuilder r3 = new StringBuilder().append("COSDictionary expected, but got ");
        if (r2 != null) goto L13;
        String r4 = "null";
    L14:
        Log.w("PdfBox-Android", r3.append(r4).toString());
        goto L15
    L13:
        r4 = r2.getClass().getSimpleName();
        goto L14
    L16:
        return r5;
    }

    static /* synthetic */ List b(h r0, com.tom_roush.pdfbox.a.d r1) {
        return r0.b(r1);
    }

    private static void c(com.tom_roush.pdfbox.a.d r3) {
        com.tom_roush.pdfbox.a.i r0 = r3.b(com.tom_roush.pdfbox.a.i.iz);
        if (r0 != null) goto L7;
        r3.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.fW);
        return;
    L7:
        if (com.tom_roush.pdfbox.a.i.fW.equals(r0) == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("Expected 'Page' but found " + r0);
    }

    private boolean d(com.tom_roush.pdfbox.a.d r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.b(com.tom_roush.pdfbox.a.i.iz) != com.tom_roush.pdfbox.a.i.ga) goto L6;
    L7:
        return true;
    L6:
        if (r2.m(com.tom_roush.pdfbox.a.i.el) == false) goto L8;
        goto L7
    }

    public int a() {
        return this.f16280a.b(com.tom_roush.pdfbox.a.i.bk, 0);
    }

    public int a(g r3) {
        b r0 = new b(r3, null);
        if (a(r0, this.f16280a) == true) goto L5;
        return -1;
    L5:
        return b.a(r0);
    }

    public g a(int r3) {
        com.tom_roush.pdfbox.a.d r4 = a(r3 + 1, this.f16280a, 0);
        c(r4);
        c r2 = this.f16281b;
        if (r2 == null) goto L5;
        k r5 = r2.e();
    L7:
        return new g(r4, r5);
    L5:
        r5 = null;
        goto L7
    }

    public com.tom_roush.pdfbox.a.d b() {
        return this.f16280a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return b();
    }

    @Override // java.lang.Iterable
    public Iterator<g> iterator() {
        return new a(this, this.f16280a, null);
    }
}
