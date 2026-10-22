package com.larus.bmhome.actionbar.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 {
    public static final /* synthetic */ int a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.actionbar.model.v0$a$a, reason: collision with other inner class name */
        public static final class C0031a extends a {
            public static final C0031a a = null;

            static {
                a = new C0031a();
            }

            public C0031a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public final wa8.h1 a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Valid(rule=" + this.a + ')';
            }

            public c(wa8.h1 r2) {
                Intrinsics.checkNotNullParameter(r2, "rule");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    static {
    }
}
