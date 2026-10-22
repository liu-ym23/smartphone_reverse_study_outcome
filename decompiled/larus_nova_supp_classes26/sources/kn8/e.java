package kn8;

import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.r;
import jn8.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final a a;
    public boolean b;
    public d c;

    public static final class a implements t {
        public final /* synthetic */ e a;

        @Override // jn8.t
        public final void a() {
            this.a.getClass();
        }

        @Override // jn8.t
        public final void b() {
            this.a.getClass();
        }

        public final void c() {
            e r0 = this.a;
            d r1 = r0.c;
            if (r1 == null) goto L12;
            SearchReferenceData r2 = r1.d;
            if (r2 == null) goto L12;
            if (r.b(r2) == false) goto L12;
            if (r0.b == true) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L16;
            r0.b = true;
            return;
        L16:
            return;
        L12:
            r3 = false;
            goto L13
        }

        public a(e r1) {
            this.a = r1;
        }
    }

    public e() {
        this.a = new a(this);
    }
}
