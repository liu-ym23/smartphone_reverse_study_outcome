package pi;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import li.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n f21354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static n f21355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f21356c = null;
    public static Map d;
    public static Map e;
    public static final LinkedHashMap f = null;

    static {
        Intrinsics.checkNotNullParameter(CollectionsKt.emptyList(), "forceDegradeCodeList");
        f21354a = new n(false, 7);
        f21356c = new LinkedHashMap();
        List r5 = CollectionsKt.listOf(new String[]{"1128", "2329", "8663"});
        LinkedHashMap r10 = new LinkedHashMap(androidx.constraintlayout.motion.widget.a.e(r5, 16));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Object r12 = r11.next();
        String r13 = (String) r12;
        r10.put(r12, 1);
        goto L4
    L6:
        f = r10;
    }
}
