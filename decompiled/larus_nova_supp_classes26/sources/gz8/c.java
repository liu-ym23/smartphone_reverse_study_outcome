package gz8;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.z1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final boolean a(b2 r2) {
        ModelItemIdentity r0 = r2.b();
        if (r0 == null) goto L5;
        String r1 = r0.getKey();
    L7:
        if (r1 == null) goto L15;
        z1 r3 = r2.n;
        if (r3 == null) goto L11;
        boolean r4 = Intrinsics.areEqual(r3.b, Boolean.TRUE);
    L12:
        if (r4 == true) goto L16;
        return true;
    L16:
        return false;
    L11:
        r4 = false;
        goto L12
    L15:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static final List<ModelItemIdentity> e(t0 r6) {
        List r0 = CollectionsKt.createListBuilder();
        o1 r1 = r6.m;
        if (r1 == null) goto L13;
        ModelItemIdentity r2 = r1.a();
        if (r2.getKey() == null) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        r0.add(r2);
        goto L13
    L7:
        r5 = false;
    L13:
        List r7 = r6.n;
        if (r7 != null) goto L16;
        r7 = CollectionsKt.emptyList();
    L16:
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L29;
        ModelItemIdentity r3 = ((o1) r8.next()).a();
        if (r3.getKey() == null) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == true) goto L26;
        r3 = null;
    L26:
        if (r3 == null) goto L18;
        r0.add(r3);
        goto L18
    L22:
        r9 = false;
        goto L23
    L29:
        return CollectionsKt.distinct(CollectionsKt.build(r0));
    }

    public static final boolean b(b2 r0, ModelItemIdentity r1) {
        ModelItemIdentity r2 = r0.b();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (d(r2, r1) != true) goto L7;
        return true;
    }

    public static final boolean c(t0 r1, ModelItemIdentity r2) {
        List<ModelItemIdentity> r3 = e(r1);
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if (d((ModelItemIdentity) r4.next(), r2) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        goto L7
    }

    public static final boolean d(ModelItemIdentity r4, ModelItemIdentity r5) {
        if (Intrinsics.areEqual(r4, r5) == false) goto L5;
        return true;
    L5:
        Integer r6 = Integer.valueOf(r4.getDeprecatedItemId());
        if (r6.intValue() == 0) goto L8;
        boolean r0 = true;
    L9:
        Integer r3 = null;
        if (r0 == true) goto L13;
        r6 = null;
    L13:
        Integer r7 = Integer.valueOf(r5.getDeprecatedItemId());
        if (r7.intValue() == 0) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == false) goto L19;
        r3 = r7;
    L19:
        if (r6 != null) goto L21;
    L23:
        return false;
    L21:
        if (Intrinsics.areEqual(r6, r3) == false) goto L23;
        return true;
    L16:
        r1 = false;
        goto L17
    L8:
        r0 = false;
        goto L9
    }
}
