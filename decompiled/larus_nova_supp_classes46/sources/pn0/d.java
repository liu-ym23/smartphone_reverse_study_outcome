package pn0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class d {
    public final int a;
    public final int b;
    public final boolean c;
    public final List<Integer> d;
    public final boolean e;
    public final a f;
    public final boolean g;
    public final List<Integer> h;
    public final Long i;
    public final Object j;

    public static final class a {
        public final StringBuilder a;

        public a(StringBuilder r2) {
            Intrinsics.checkNotNullParameter(r2, "sb");
            this.a = r2;
        }
    }

    public String toString() {
        return "{uiLayout = " + g() + ", orientation = " + b() + ", isStatusBarVisible = " + i() + ", playMode = " + c() + ", uiFeatures = " + f() + ", isAnchor = " + h() + '}';
    }

    public boolean a() {
        return this.g;
    }

    public int b() {
        return this.b;
    }

    public List<Integer> c() {
        return this.d;
    }

    public Long d() {
        return this.i;
    }

    public a e() {
        return this.f;
    }

    public List<Integer> f() {
        return this.h;
    }

    public int g() {
        return this.a;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.c;
    }

    public d(int r4, int r5, boolean r6, List r7, boolean r8, a r9, boolean r10, List r11, Long r12, Object r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r6 = true;
    L9:
        if ((r14 & 8) == 0) goto L12;
        r7 = null;
    L12:
        if ((r14 & 16) == 0) goto L15;
        r8 = false;
    L15:
        if ((r14 & 64) == 0) goto L18;
        r9 = new a(new StringBuilder());
    L18:
        if ((r14 & 128) == 0) goto L21;
        r10 = false;
    L21:
        if ((r14 & 256) == 0) goto L24;
        r11 = null;
    L24:
        if ((r14 & 512) == 0) goto L26;
        r12 = null;
    L26:
        Intrinsics.checkNotNullParameter(r9, "traceInfo");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
    }
}
