package androidx.work;

import com.obric.cae.userAware.datacollection.UploadWorker;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class r extends w {

    public static final class a extends w.a<a, r> {
        public a(TimeUnit r15) {
            he.i.f(r15, "repeatIntervalTimeUnit");
            super(UploadWorker.class);
            r1.t r14 = this.f2964b;
            long r8 = r15.toMillis(1);
            r14.getClass();
            long r10 = 900000;
            String r11 = r1.t.f11337u;
            if (r8 >= 900000) goto L5;
            m.d().g(r11, "Interval duration lesser than minimum allowed value; Changed to 900000");
        L5:
            if (r8 >= 900000) goto L7;
            long r12 = 900000;
        L8:
            if (r8 >= 900000) goto L10;
            long r13 = 900000;
        L12:
            if (r12 >= 900000) goto L14;
            m.d().g(r11, "Interval duration lesser than minimum allowed value; Changed to 900000");
        L14:
            if (r12 < 900000) goto L17;
            r10 = r12;
        L17:
            r14.f11346h = r10;
            if (r13 >= 300000) goto L21;
            m.d().g(r11, "Flex duration lesser than minimum allowed value; Changed to 300000");
        L21:
            if (r13 <= r14.f11346h) goto L23;
            m.d().g(r11, "Flex duration greater than interval duration; Changed to " + r12);
        L23:
            r14.f11347i = l6.a.y(r13, 300000, r14.f11346h);
            return;
        L10:
            r13 = r8;
            goto L12
        L7:
            r12 = r8;
            goto L8
        }

        @Override // androidx.work.w.a
        public final w b() {
            if ((!this.f2964b.f11355q) == false) goto L7;
            return new r(this);
        L7:
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
        }

        @Override // androidx.work.w.a
        public final w.a c() {
            return this;
        }
    }

    public r(a r8) {
        he.i.f(r8, "builder");
        super(r8.f2963a, r8.f2964b, r8.f2965c);
    }
}
