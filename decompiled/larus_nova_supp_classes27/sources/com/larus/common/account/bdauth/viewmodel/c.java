package com.larus.common.account.bdauth.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class c {

    public static final class a extends c {
        public final com.larus.common.account.bdauth.viewmodel.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Account(item=" + this.a + ')';
        }

        public a(com.larus.common.account.bdauth.viewmodel.a r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }

    public static final class b extends c {
        public final boolean a;

        public b() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "AddAccount(enabled=" + this.a + ')';
        }

        public b(int r1) {
            this.a = true;
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.c$c, reason: collision with other inner class name */
    public static final class C0008c extends c {
        public final com.larus.common.account.bdauth.viewmodel.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0008c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0008c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SingleAccount(item=" + this.a + ')';
        }

        public C0008c(com.larus.common.account.bdauth.viewmodel.a r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }

    public c() {
    }
}
