package mc;

import androidx.core.internal.view.SupportMenu;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f11153b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public g() {
        this.f11153b = new int[10];
    }

    public final int a(int r10) {
        return this.f11153b[r10];
    }

    public final int b() {
        if ((this.f11152a & 2) != 0) goto L7;
        return -1;
    L7:
        return this.f11153b[1];
    }

    public final int c() {
        if ((this.f11152a & 128) != 0) goto L7;
        return SupportMenu.USER_MASK;
    L7:
        return this.f11153b[7];
    }

    public final int d() {
        if ((this.f11152a & 16) != 0) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return this.f11153b[4];
    }

    public final int e(int r10) {
        if ((this.f11152a & 32) != 0) goto L5;
        return r10;
    L5:
        return this.f11153b[5];
    }

    public final boolean f(int r10) {
        int r11 = this.f11152a;
        if ((r11 & (1 << r10)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void g(g r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = 0;
    L4:
        if (r11 >= 10) goto L9;
        if (r10.f(r11) == false) goto L8;
        h(r11, r10.a(r11));
    L8:
        r11 = r11 + 1;
        goto L4
    }

    public final g h(int r10, int r11) {
        if (r10 < 0) goto L7;
        int[] r12 = this.f11153b;
        if (r10 >= r12.length) goto L7;
        this.f11152a = (1 << r10) | this.f11152a;
        r12[r10] = r11;
    L7:
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f11152a);
    }
}
