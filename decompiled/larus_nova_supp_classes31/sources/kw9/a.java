package kw9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;

    /* JADX INFO: renamed from: kw9.a$a, reason: collision with other inner class name */
    public static final class C0064a {
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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f;
    }

    public final String toString() {
        return "DoubaoForwardTarget(id=" + this.a + ", name=" + this.b + ", avatarKey=" + this.c + ", threadId=" + this.d + ", p2pChatId=" + this.e + ", targetType=" + this.f + ')';
    }

    public static a a(a r7) {
        String r1 = r7.a;
        String r2 = r7.b;
        String r3 = r7.c;
        String r4 = r7.d;
        String r5 = r7.e;
        Intrinsics.checkNotNullParameter(r1, "id");
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        Intrinsics.checkNotNullParameter(r4, "threadId");
        Intrinsics.checkNotNullParameter(r5, "p2pChatId");
        return new a(r1, r2, r3, r4, r5, 1);
    }

    public a(String r2, String r3, String r4, String r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "avatarKey");
        Intrinsics.checkNotNullParameter(r5, "threadId");
        Intrinsics.checkNotNullParameter(r6, "p2pChatId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
