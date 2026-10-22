package dz7;

import com.larksuite.component.card.protocol.context.BizContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final String b;
    public final BizContext c;

    /* JADX INFO: renamed from: dz7.a$a, reason: collision with other inner class name */
    public static final class C0100a {

        /* JADX INFO: renamed from: dz7.a$a$a, reason: collision with other inner class name */
        public static final class C0101a {
            public String a;
            public String b;
            public BizContext c;

            public final a a() {
                String r1 = this.a;
                BizContext r2 = null;
                if (r1 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("elementTag");
                r1 = null;
            L5:
                String r3 = this.b;
                BizContext r4 = this.c;
                if (r4 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("bizContext");
            L10:
                return new a(r1, r3, r2);
            L8:
                r2 = r4;
                goto L10
            }

            public C0101a() {
                this.b = "";
            }
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CardActionContext(elementTag=" + this.a + ", elementID=" + this.b + ", bizContext=" + this.c + ')';
    }

    public a(String r2, String r3, BizContext r4) {
        Intrinsics.checkNotNullParameter(r2, "elementTag");
        Intrinsics.checkNotNullParameter(r4, "bizContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
