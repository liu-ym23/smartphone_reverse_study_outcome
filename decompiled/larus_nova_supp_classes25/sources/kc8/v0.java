package kc8;

import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 {
    public static final /* synthetic */ int p = 0;
    public final Boolean a;
    public final Integer b;
    public final boolean c;
    public final boolean d;
    public final Boolean e;
    public final Boolean f;
    public final RectF g;
    public final Function1<ow8.a, Unit> h;
    public final bc8.b i;
    public final Function1<ow8.a, Unit> j;
    public final Function1<ow8.a, Unit> k;
    public final jh8.b l;
    public final lw8.d m;
    public final Boolean n;
    public final jh8.a o;

    public static final class a {
        public Boolean a;
        public Integer b;
        public boolean c;
        public boolean d;
        public Boolean e;
        public Boolean f;
        public RectF g;
        public Function1<? super ow8.a, Unit> h;
        public bc8.b i;
        public Function1<? super ow8.a, Unit> j;
        public Function1<? super ow8.a, Unit> k;
        public jh8.a l;
        public lw8.d m;

        public a() {
        }

        public final v0 a() {
            Boolean r2 = this.a;
            Integer r3 = this.b;
            boolean r4 = this.c;
            boolean r5 = this.d;
            Boolean r6 = this.e;
            Boolean r7 = this.f;
            RectF r8 = this.g;
            Function1<? super ow8.a, Unit> r9 = this.h;
            bc8.b r10 = this.i;
            Function1<? super ow8.a, Unit> r11 = this.j;
            Function1<? super ow8.a, Unit> r12 = this.k;
            jh8.a r1 = this.l;
            return new v0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, null, this.m, null, r1, 32768);
        }
    }

    public static final class b {
    }

    static {
    }

    public v0(Boolean r19, Integer r20, boolean r21, boolean r22, Boolean r23, Boolean r24, RectF r25, Function1 r26, bc8.b r27, Function1 r28, Function1 r29, jh8.b r30, lw8.d r31, Boolean r32, jh8.a r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        Boolean r2 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Integer r4 = null;
    L10:
        boolean r6 = false;
        if ((r34 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r34 & 8) != 0) goto L19;
        r6 = r22;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Boolean r7 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Boolean r8 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        RectF r9 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Function1 r10 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        bc8.b r11 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Function1 r12 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        Function1 r13 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        jh8.b r14 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        lw8.d r15 = null;
    L55:
        if ((r34 & 32768) == 0) goto L57;
        Boolean r3 = null;
    L59:
        if ((r34 & 65536) == 0) goto L61;
        jh8.a r1 = null;
    L62:
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r3;
        this.o = r1;
        return;
    L61:
        r1 = r33;
        goto L62
    L57:
        r3 = r32;
        goto L59
    L53:
        r15 = r31;
        goto L55
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L10
    L5:
        r2 = r19;
        goto L7
    }
}
