package q64;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final c b = null;
    public final List<C0256c> a;

    public static final class a {
        public final List<C0256c> a;

        public a() {
            this.a = new ArrayList();
        }

        public a(c r2) {
            Intrinsics.checkNotNullParameter(r2, "headers");
            this.a = new ArrayList(r2.a);
        }

        public final void a(Map r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            Iterator r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) r6.next();
            List<C0256c> r1 = this.a;
            ArrayList r2 = (ArrayList) r1;
            r2.add(new C0256c((String) r0.getKey(), (String) r0.getValue()));
            goto L4
        }

        public final void b(String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "key");
            Intrinsics.checkNotNullParameter(r7, "value");
            Intrinsics.checkNotNullParameter(r6, "key");
            Iterator r2 = ((ArrayList) this.a).iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            if (StringsKt.equals(((C0256c) r2.next()).a, r6, true) == false) goto L4;
            r2.remove();
            goto L4
        L8:
            Intrinsics.checkNotNullParameter(r6, "key");
            Intrinsics.checkNotNullParameter(r7, "value");
            List<C0256c> r0 = this.a;
            ArrayList r1 = (ArrayList) r0;
            r1.add(new C0256c(r6, r7));
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: q64.c$c, reason: collision with other inner class name */
    public static final class C0256c {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0256c) == true) goto L8;
            return false;
        L8:
            C0256c r6 = (C0256c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "{" + this.a + ": " + this.b + '}';
        }

        public C0256c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        b = new c(new ArrayList());
    }

    public final String toString() {
        return this.a.toString();
    }

    public c(List r1) {
        this.a = r1;
    }

    public final String a(String r14) {
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r14, "key");
        List<C0256c> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (StringsKt.equals(((C0256c) r3).a, r14, true) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r15 = r1.iterator();
    L10:
        if (r15.hasNext() == false) goto L13;
        r4.add(((C0256c) r15.next()).b);
        goto L10
    L13:
        return CollectionsKt.joinToString$default(r4, ";", null, null, 0, null, null, 62, null);
    }
}
