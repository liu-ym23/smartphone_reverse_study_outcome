package androidx.work;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f2960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r1.t f2961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f2962c;

    public static abstract class a<B extends a<B, ?>, W extends w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UUID f2963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r1.t f2964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedHashSet f2965c;

        public a(Class<? extends l> r33) {
            UUID r8 = UUID.randomUUID();
            he.i.e(r8, "randomUUID()");
            this.f2963a = r8;
            String r10 = this.f2963a.toString();
            he.i.e(r10, "id.toString()");
            this.f2964b = new r1.t(r10, null, r33.getName(), null, null, null, 0, 0, 0, null, 0, null, 0, 0, 0, 0, false, null, 0, 1048570, 0);
            String[] r11 = {r33.getName()};
            LinkedHashSet r12 = new LinkedHashSet(l6.a.n0(1));
            yd.e.v0(r12, r11);
            this.f2965c = r12;
        }

        public final W a() {
            W r8 = (W) b();
            d r10 = this.f2964b.f11348j;
            boolean r11 = true;
            if ((!r10.f2815h.isEmpty()) == false) goto L5;
        L12:
            boolean r12 = true;
        L13:
            r1.t r13 = this.f2964b;
            if (r13.f11355q == true) goto L16;
        L27:
            UUID r14 = UUID.randomUUID();
            he.i.e(r14, "randomUUID()");
            this.f2963a = r14;
            String r15 = r14.toString();
            he.i.e(r15, "id.toString()");
            r1.t r16 = this.f2964b;
            he.i.f(r16, "other");
            String r17 = r16.f11341c;
            u.a r18 = r16.f11340b;
            String r19 = r16.f11342d;
            e r110 = new e(r16.f11343e);
            e r111 = new e(r16.f11344f);
            long r112 = r16.f11345g;
            long r113 = r16.f11346h;
            long r20 = r16.f11347i;
            d r21 = r16.f11348j;
            he.i.f(r21, "other");
            boolean r22 = r21.f2809b;
            boolean r23 = r21.f2810c;
            this.f2964b = new r1.t(r15, r18, r17, r19, r110, r111, r112, r113, r20, new d(r21.f2808a, r22, r23, r21.f2811d, r21.f2812e, r21.f2813f, r21.f2814g, r21.f2815h), r16.f11349k, r16.f11350l, r16.f11351m, r16.f11352n, r16.f11353o, r16.f11354p, r16.f11355q, r16.f11356r, r16.f11357s, 524288, 0);
            c();
            return r8;
        L16:
            if ((!r12) == false) goto L26;
            if (r13.f11345g <= 0) goto L21;
            r11 = false;
        L21:
            if (r11 == true) goto L27;
            throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
        L26:
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
        L5:
            if (r10.f2811d == true) goto L12;
            if (r10.f2809b == true) goto L12;
            if (r10.f2810c == true) goto L12;
            r12 = false;
            goto L13
        }

        public abstract W b();

        public abstract B c();

        public final B d(long r8, TimeUnit r10) {
            he.i.f(r10, "timeUnit");
            r1.t r11 = this.f2964b;
            r11.f11345g = r10.toMillis(r8);
            if ((Long.MAX_VALUE - System.currentTimeMillis()) <= this.f2964b.f11345g) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L10;
            return (B) c();
        L10:
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        L5:
            r12 = false;
            goto L6
        }
    }

    public w(UUID r8, r1.t r10, LinkedHashSet r11) {
        he.i.f(r8, "id");
        he.i.f(r10, "workSpec");
        he.i.f(r11, "tags");
        this.f2960a = r8;
        this.f2961b = r10;
        this.f2962c = r11;
    }
}
