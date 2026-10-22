package op9;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final LongSparseArray<SparseArray<Integer>> a;
    public final LongSparseArray<SparseArray<LongSparseArray<Integer>>> b;

    public b() {
        this.a = new LongSparseArray();
        this.b = new LongSparseArray();
    }

    public final void a(long r9, MediaTab r11, List<mp9.c> r12) {
        Intrinsics.checkNotNullParameter(r11, "mediaTab");
        Intrinsics.checkNotNullParameter(r12, "newMediaList");
        SparseArray<Integer> r0 = this.a.get(r9, null);
        SparseArray<LongSparseArray<Integer>> r2 = this.b.get(r9, null);
        if (r0 == null) goto L24;
        if (r2 == null) goto L24;
        Integer r3 = r0.get(r11.getId(), -1);
        LongSparseArray<Integer> r1 = r2.get(r11.getId(), null);
        if (r3 != null) goto L10;
    L11:
        if (r1 == null) goto L22;
        Intrinsics.checkNotNull(r3);
        int r10 = r3.intValue();
        Iterator<T> r13 = r12.iterator();
        int r4 = 0;
    L15:
        if (r13.hasNext() == false) goto L20;
        Object r5 = r13.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        r1.put(((mp9.c) r5).a, Integer.valueOf(r4 + r10));
        r4 = r6;
        goto L15
    L20:
        r0.put(r11.getId(), Integer.valueOf(r3.intValue() + r12.size()));
        r12.size();
        return;
    L22:
        b(r9, r11, r12);
        return;
    L10:
        if (r3.intValue() == (-1)) goto L22;
    L24:
        b(r9, r11, r12);
    }

    public final void b(long r7, MediaTab r9, List<mp9.c> r10) {
        Intrinsics.checkNotNullParameter(r9, "mediaTab");
        Intrinsics.checkNotNullParameter(r10, "mediaList");
        SparseArray<Integer> r0 = this.a.get(r7, null);
        if (r0 != null) goto L5;
        r0 = new SparseArray();
        this.a.put(r7, r0);
    L5:
        SparseArray<LongSparseArray<Integer>> r1 = this.b.get(r7, null);
        if (r1 != null) goto L8;
        r1 = new SparseArray();
        this.b.put(r7, r1);
    L8:
        r0.put(r9.getId(), Integer.valueOf(r10.size()));
        LongSparseArray<Integer> r8 = new LongSparseArray();
        Iterator<T> r11 = r10.iterator();
        int r2 = 0;
    L10:
        if (r11.hasNext() == false) goto L15;
        Object r3 = r11.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r8.put(((mp9.c) r3).a, Integer.valueOf(r2));
        r2 = r4;
        goto L10
    L15:
        r1.put(r9.getId(), r8);
        r10.size();
    }
}
