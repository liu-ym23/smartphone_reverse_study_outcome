package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nPersistableBundle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,155:1\n13579#2,2:156\n*S KotlinDebug\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n*L\n35#1:156,2\n*E\n"})
public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }

    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        PersistableBundle r11 = PersistableBundleApi21ImplKt.createPersistableBundle(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Pair<String, ? extends Object> r14 = r10[r13];
        PersistableBundleApi21ImplKt.putValue(r11, r14.component1(), r14.component2());
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @RequiresApi(21)
    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        PersistableBundle r11 = PersistableBundleApi21ImplKt.createPersistableBundle(r10.size());
        Iterator<Map.Entry<String, ? extends Object>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r13 = r12.next();
        PersistableBundleApi21ImplKt.putValue(r11, r13.getKey(), r13.getValue());
        goto L4
    L6:
        return r11;
    }
}
