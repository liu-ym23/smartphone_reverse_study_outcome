package w98;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public final Map<Long, a> a;
    public int b;

    public static final class a {
        public final List<tf9.a> a;
        public final List<we9.e> b;

        public a() {
            this(null);
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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "TimestampBucket(videoFrames=" + this.a + ", ocrModels=" + this.b + ')';
        }

        public a(Object r3) {
            ArrayList r4 = new ArrayList();
            ArrayList r0 = new ArrayList();
            Intrinsics.checkNotNullParameter(r4, "videoFrames");
            Intrinsics.checkNotNullParameter(r0, "ocrModels");
            this.a = r4;
            this.b = r0;
        }
    }

    public final List<c> a() {
        if (this.a.isEmpty() == true) goto L5;
        List r0 = CollectionsKt.createListBuilder();
        Iterator r1 = CollectionsKt.sorted(((LinkedHashMap) this.a).keySet()).iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        long r2 = ((Number) r1.next()).longValue();
        a r3 = (a) MapsKt.getValue(this.a, Long.valueOf(r2));
        Iterator<T> r4 = r3.a.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r0.add(new c.b((tf9.a) r4.next()));
        goto L11
    L13:
        Iterator<T> r5 = r3.b.iterator();
    L15:
        if (r5.hasNext() == false) goto L8;
        r0.add(new c.a((we9.e) r5.next()));
        goto L15
    L17:
        List<c> r6 = CollectionsKt.build(r0);
        ((LinkedHashMap) this.a).clear();
        this.b = 0;
        return r6;
    L5:
        return CollectionsKt.emptyList();
    }

    public e() {
        this.a = new LinkedHashMap();
    }
}
