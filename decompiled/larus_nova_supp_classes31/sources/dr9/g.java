package dr9;

import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final g a = null;
    public static final ConcurrentHashMap<String, a<InputDraftSnapshot>> b = null;
    public static final ConcurrentHashMap<String, Long> c = null;

    public static final class a<T> {
        public final T a;
        public final long b;

        public a() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.b;
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "StoredEntry(value=" + this.a + ", createdAt=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(InputDraftSnapshot r3) {
            long r0 = System.currentTimeMillis();
            this.a = r3;
            this.b = r0;
        }
    }

    public g() {
    }

    static {
        a = new g();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static List c(List r24) {
        List r0 = r24;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        AttachmentSnapshot r3 = (AttachmentSnapshot) r2.next();
        r1.add(AttachmentSnapshot.copy$default(r3, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.toMap(r3.getExtra()), 65535, null));
        goto L4
    L6:
        return r1;
    }

    public static InputDraftSnapshot d(String r10) {
        ConcurrentHashMap<String, a<InputDraftSnapshot>> r0 = b;
        if (r10 == null) goto L14;
        a<InputDraftSnapshot> r2 = r0.get(r10);
        if (r2 == null) goto L14;
        if ((System.currentTimeMillis() - r2.b) <= 1800000) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        r0.remove(r10, r2);
        goto L14
    L15:
        InputDraftSnapshot r11 = r2.a;
    L16:
        InputDraftSnapshot r4 = r11;
        if (r4 != null) goto L20;
        return null;
    L20:
        return InputDraftSnapshot.copy$default(r4, null, c(r4.getAttachments()), null, 0, 13, null);
    L11:
        r3 = false;
    L14:
        r11 = null;
        goto L16
    }

    public static String e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "prefix");
        return r1 + '-' + UUID.randomUUID();
    }

    public static void f(String r1) {
        a<InputDraftSnapshot> r2 = b.remove(r1);
    }

    public static void g(g r5) {
        final long r0 = System.currentTimeMillis();
        r5.getClass();
        final long r3 = 1800000;
        CollectionsKt.removeAll(b.entrySet(), new e(r3, r0));
        CollectionsKt.removeAll(c.entrySet(), new f(r0, r3));
    }

    public final boolean a(String r4) {
        if (StringsKt.isBlank(r4) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        g(this);
        if (c.remove(r4) != null) goto L13;
        return false;
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final String b(InputDraftSnapshot r12) {
        Intrinsics.checkNotNullParameter(r12, "snapshot");
        String r1 = e("input");
        Intrinsics.checkNotNullParameter(r1, "snapshotId");
        Intrinsics.checkNotNullParameter(r12, "snapshot");
        g(this);
        b.put(r1, new a(InputDraftSnapshot.copy$default(r12, null, c(r12.getAttachments()), null, 0, 13, null)));
        return r1;
    }
}
