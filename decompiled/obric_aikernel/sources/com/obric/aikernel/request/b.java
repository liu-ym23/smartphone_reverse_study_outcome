package com.obric.aikernel.request;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0112b f4839c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bundle f4840d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bundle f4841e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Bundle f4842f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Bundle f4843g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final com.obric.aikernel.b.a f4844h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f4846b;

    public static final class a extends com.obric.aikernel.b.a {
        a() {
        }

        @Override // com.obric.aikernel.b
        public void j2(Bundle r10) {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.request.b$b, reason: collision with other inner class name */
    public static final class C0112b {
        private C0112b() {
        }

        public /* synthetic */ C0112b(DefaultConstructorMarker r10) {
            this();
        }

        public final Bundle a() {
            return b.a();
        }

        public final Bundle b() {
            return b.b();
        }

        public final com.obric.aikernel.b.a c() {
            return b.c();
        }

        public final Bundle d() {
            return b.d();
        }

        public final Bundle e() {
            return b.e();
        }
    }

    static {
        f4839c = new C0112b(null);
        f4840d = new Bundle();
        Bundle r10 = e8.a.E(new Bundle(), 0, null, 3, null);
        f4841e = r10;
        f4842f = e8.a.B(new Bundle(), 0, null, false, 7, null);
        f4843g = e8.a.A(new Bundle(), 111, null, 2, null);
        new b(true, r10);
        f4844h = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public b(boolean r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r11, "ret");
        this.f4845a = r10;
        this.f4846b = r11;
    }

    public /* synthetic */ b(boolean r10, Bundle r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = f4840d;
    L8:
        this(r10, r11);
    }

    public static final /* synthetic */ Bundle a() {
        return f4840d;
    }

    public static final /* synthetic */ Bundle b() {
        return f4842f;
    }

    public static final /* synthetic */ com.obric.aikernel.b.a c() {
        return f4844h;
    }

    public static final /* synthetic */ Bundle d() {
        return f4843g;
    }

    public static final /* synthetic */ Bundle e() {
        return f4841e;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.f4845a == r11.f4845a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4846b, r11.f4846b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean f() {
        return this.f4845a;
    }

    public final Bundle g() {
        return this.f4846b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r10 = this.f4845a;
        ?? r11 = r10;
        if (r10 == false) goto L6;
        r11 = 1;
    L6:
        return (r11 * 31) + this.f4846b.hashCode();
    }

    public String toString() {
        return "Result(handled=" + this.f4845a + ", ret=" + this.f4846b + ')';
    }
}
