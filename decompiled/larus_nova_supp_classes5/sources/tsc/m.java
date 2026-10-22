package tsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class m implements l {
    public final String a;
    public final int b;
    public final Map<String, String> c;
    public int d;
    public String e;

    public static class a extends m implements l.a {
        public final a f;
        public List<a> g;

        @Override // tsc.l
        public final l.a a() {
            return this;
        }

        @Override // tsc.l
        public final boolean isBlock() {
            return true;
        }

        @Override // tsc.l.a
        public final List<l.a> children() {
            List<a> r0 = this.g;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return Collections.unmodifiableList(r0);
        }

        public final String toString() {
            StringBuilder r0 = new StringBuilder("BlockImpl{name='");
            r0.append(this.a);
            r0.append("', start=");
            r0.append(this.b);
            r0.append(", end=");
            r0.append(this.d);
            r0.append(", attributes=");
            r0.append(this.c);
            r0.append(", parent=");
            a r1 = this.f;
            if (r1 == null) goto L5;
            String r2 = r1.a;
        L6:
            r0.append(r2);
            r0.append(", children=");
            r0.append(this.g);
            r0.append('}');
            return r0.toString();
        L5:
            r2 = null;
            goto L6
        }

        @Override // tsc.m, tsc.l
        public final Map<String, String> b() {
            return this.c;
        }

        @Override // tsc.l.a
        public final a parent() {
            return this.f;
        }

        public final void c(int r3) {
            if (isClosed() == true) goto L10;
            this.d = r3;
            List<a> r0 = this.g;
            if (r0 == null) goto L12;
            Iterator r1 = ((ArrayList) r0).iterator();
        L8:
            if (r1.hasNext() == false) goto L13;
            ((a) r1.next()).c(r3);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public a(String r1, int r2, Map<String, String> r3, a r4) {
            super(r1, r2, r3);
            this.f = r4;
        }
    }

    @Override // tsc.l
    public final boolean isClosed() {
        if (this.d <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // tsc.l
    public Map<String, String> b() {
        return this.c;
    }

    @Override // tsc.l
    public final int end() {
        return this.d;
    }

    @Override // tsc.l
    public final String name() {
        return this.a;
    }

    @Override // tsc.l
    public final int start() {
        return this.b;
    }

    public m(String r2, int r3, Map<String, String> r4) {
        this.d = -1;
        this.e = "";
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
