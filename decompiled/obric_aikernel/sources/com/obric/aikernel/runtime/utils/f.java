package com.obric.aikernel.runtime.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f5423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g1<a> f5424b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g1<Boolean> f5425c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5428c;

        public a() {
            this(false, false, false, 7, null);
        }

        public a(boolean r10, boolean r11, boolean r12) {
            this.f5426a = r10;
            this.f5427b = r11;
            this.f5428c = r12;
        }

        public /* synthetic */ a(boolean r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = false;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = false;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = false;
        L11:
            this(r10, r11, r12);
        }

        public final boolean a() {
            return this.f5427b;
        }

        public final boolean b() {
            return this.f5428c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f5426a == r11.f5426a) goto L12;
            return false;
        L12:
            if (this.f5427b == r11.f5427b) goto L15;
            return false;
        L15:
            if (this.f5428c == r11.f5428c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            boolean r10 = this.f5426a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f5427b;
            ?? r15 = r14;
            if (r14 == false) goto L8;
            r15 = 1;
        L8:
            int r16 = (r13 + r15) * 31;
            boolean r17 = this.f5428c;
            if (r17 == true) goto L13;
            r11 = r17;
        L13:
            return r16 + r11;
        }

        public String toString() {
            return "Snapshot(hasInternet=" + this.f5426a + ", hasValidatedInternet=" + this.f5427b + ", isUnmetered=" + this.f5428c + ')';
        }
    }

    static {
        f5423a = new f();
        f5424b = q1.a(new a(false, false, false, 7, null));
        f5425c = q1.a(Boolean.FALSE);
    }

    private f() {
    }

    public final g1<a> a() {
        return f5424b;
    }

    public final void b(a r10) {
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        f5424b.setValue(r10);
        f5425c.setValue(Boolean.valueOf(r10.a()));
    }
}
