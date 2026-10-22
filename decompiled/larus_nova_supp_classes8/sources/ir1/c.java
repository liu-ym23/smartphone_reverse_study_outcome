package ir1;

import kotlin.jvm.internal.Intrinsics;
import mq1.d0;
import mq1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class c {
    public d0 a;
    public final a b;

    public static final class a implements f0 {
        public final /* synthetic */ c a;

        @Override // mq1.f0
        public final void wg() {
            this.a.n();
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public void n() {
    }

    public final boolean a() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r0.j(16, this);
    }

    public final boolean b() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r0.j(4, this);
    }

    public final boolean c() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r0.j(4, this);
    }

    public final boolean d() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r0.j(8, this);
    }

    public final boolean f() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r0.j(1, this);
    }

    public final boolean g() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r0.j(2, this);
    }

    public final boolean h() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r0.j(2, this);
    }

    public final boolean i() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r0.j(8, this);
    }

    public final boolean l() {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r0.j(1, this);
    }

    public c() {
        this.b = new a(this);
    }

    public final boolean e() {
        if (d() == true) goto L5;
    L7:
        return false;
    L5:
        if (b() == false) goto L7;
        return true;
    }

    public final boolean j() {
        if (i() == true) goto L5;
    L7:
        return false;
    L5:
        if (b() == false) goto L7;
        return true;
    }

    public final boolean k() {
        if (i() == true) goto L5;
    L7:
        return false;
    L5:
        if (c() == false) goto L7;
        return true;
    }

    public final boolean m(int r3) {
        d0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r0.j(r3, this);
    }
}
