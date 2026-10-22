package vj8;

import uj8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public vj8.a a;
    public b b;
    public final a c;

    public static final class a implements f {
        public final /* synthetic */ d a;

        @Override // uj8.f
        public final void a() {
            d r0 = this.a;
            vj8.a r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            b r2 = r0.b;
            if (r2 == null) goto L9;
            r2.a(r1);
            return;
        }

        @Override // uj8.f
        public final void b() {
            d r0 = this.a;
            vj8.a r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            b r2 = r0.b;
            if (r2 == null) goto L9;
            r2.c(r1);
            return;
        }

        public final boolean c() {
            d r0 = this.a;
            vj8.a r1 = r0.a;
            if (r1 != null) goto L5;
            return false;
        L5:
            b r2 = r0.b;
            if (r2 != null) goto L8;
            return false;
        L8:
            if (r2.b(r1) != true) goto L12;
            return true;
        L12:
            return false;
        }

        public a(d r1) {
            this.a = r1;
        }
    }

    public d() {
        this.c = new a(this);
    }
}
