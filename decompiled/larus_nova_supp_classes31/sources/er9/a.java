package er9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final a e = null;
    public final b a;
    public final b b;
    public final int c;
    public final boolean d;

    /* JADX INFO: renamed from: er9.a$a, reason: collision with other inner class name */
    public static final class C0055a {
    }

    public a() {
        this(0);
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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        b r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        b r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((r3 + r1) * 31) + this.c) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProjectListDataSourceConfig(projectPagingConfig=" + this.a + ", projectConversationPagingConfig=" + this.b + ", projectListUpdateStrategy=" + this.c + ", enableAddLocalFolder=" + this.d + ')';
    }

    static {
        e = new a(0);
    }

    public /* synthetic */ a(int r3) {
        this(new b(0), new b(0), 0, false);
    }

    public a(b r1, b r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
