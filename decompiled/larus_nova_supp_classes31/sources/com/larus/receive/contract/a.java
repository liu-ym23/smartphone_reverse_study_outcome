package com.larus.receive.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.receive.contract.a$a, reason: collision with other inner class name */
    public static final class C0019a extends a {
        public final ReceiveTextDelivery a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0019a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0019a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Handle(delivery=" + this.a + ')';
        }

        public C0019a(ReceiveTextDelivery r2) {
            Intrinsics.checkNotNullParameter(r2, "delivery");
            this.a = r2;
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

    public a() {
    }
}
