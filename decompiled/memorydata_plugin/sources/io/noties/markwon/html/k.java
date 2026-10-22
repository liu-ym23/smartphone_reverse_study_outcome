package io.noties.markwon.html;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
abstract class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f16594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16595b;
    final Map<String, String> c;
    int d;
    String e;

    static class a extends k implements j.a {
        final a f;
        List<a> g;

        a(String r3, int r4, Map<String, String> r5, a r6) {
            super(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
            this.f = r6;
        }

        static a a(String r2, int r3, Map<String, String> r4, a r5) {
            return new a(r2, r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), r5);
        }

        static a l() {
            return new a("", 0, Collections.emptyMap(), null);
        }

        @Override // io.noties.markwon.html.k
        void a(int r4) {
            if (d() == true) goto L10;
            this.d = r4;
            List<a> r3 = this.g;
            if (r3 == null) goto L12;
            Iterator<a> r5 = r3.iterator();
        L8:
            if (r5.hasNext() == false) goto L13;
            ((a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin")).a(r4);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        @Override // io.noties.markwon.html.k, io.noties.markwon.html.j
        public Map<String, String> e() {
            return this.c;
        }

        @Override // io.noties.markwon.html.j
        public boolean g() {
            return true;
        }

        @Override // io.noties.markwon.html.j
        public j.a h() {
            return this;
        }

        @Override // io.noties.markwon.html.j.a
        public j.a i() {
            return this.f;
        }

        @Override // io.noties.markwon.html.j.a
        public List<j.a> j() {
            List<a> r0 = this.g;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return Collections.unmodifiableList(r0);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder().append("BlockImpl{name='").append(this.f16594a).append('\'').append(", start=").append(this.f16595b).append(", end=").append(this.d).append(", attributes=").append(this.c).append(", parent=");
            a r1 = this.f;
            if (r1 == null) goto L5;
            String r2 = r1.f16594a;
        L7:
            return r0.append(r2).append(", children=").append(this.g).append('}').toString();
        L5:
            r2 = null;
            goto L7
        }
    }

    static class b extends k implements j.b {
        b(String r3, int r4, Map<String, String> r5) {
            super(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.noties.markwon.html.k
        void a(int r2) {
            if (d() == true) goto L6;
            this.d = r2;
            return;
        }

        @Override // io.noties.markwon.html.j
        public boolean g() {
            return false;
        }

        @Override // io.noties.markwon.html.j
        public j.a h() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }

        public String toString() {
            return "InlineImpl{name='" + this.f16594a + "', start=" + this.f16595b + ", end=" + this.d + ", attributes=" + this.c + '}';
        }
    }

    public k(String r3, int r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.d = -1;
        this.e = "";
        this.f16594a = r3;
        this.f16595b = r4;
        this.c = r6;
    }

    @Override // io.noties.markwon.html.j
    public String a() {
        return this.f16594a;
    }

    abstract void a(int r1);

    void a(CharSequence r3) {
        this.e = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    @Override // io.noties.markwon.html.j
    public int b() {
        return this.f16595b;
    }

    @Override // io.noties.markwon.html.j
    public int c() {
        return this.d;
    }

    @Override // io.noties.markwon.html.j
    public boolean d() {
        if (this.d <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.noties.markwon.html.j
    public Map<String, String> e() {
        return this.c;
    }

    @Override // io.noties.markwon.html.j
    public String f() {
        return this.e;
    }

    public boolean k() {
        if (this.f16595b != this.d) goto L5;
        return true;
    L5:
        return false;
    }
}
