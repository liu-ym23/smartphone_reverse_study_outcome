package g3;

import com.bytedance.ai.uiu.objects.UIOperationDef;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f17028a = null;

    static {
        Iterable r5 = StringsKt.g0();
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r5)), 16));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        IndexedValue r12 = (IndexedValue) r11.next();
        int r13 = r12.component1();
        Character r14 = (Character) r12.component2();
        r14.getClass();
        switch(r13) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        UIOperationDef r15 = UIOperationDef.f2835i;
    L17:
        Pair r16 = TuplesKt.to(r14, r15);
        r10.put(r16.getFirst(), r16.getSecond());
        goto L4
    L10:
        r15 = UIOperationDef.f2834h;
        goto L17
    L11:
        r15 = UIOperationDef.g;
        goto L17
    L12:
        r15 = UIOperationDef.f;
        goto L17
    L13:
        r15 = UIOperationDef.e;
        goto L17
    L14:
        r15 = UIOperationDef.d;
        goto L17
    L15:
        r15 = UIOperationDef.f2833c;
        goto L17
    L16:
        r15 = UIOperationDef.f2832b;
        goto L17
    L8:
        throw new IllegalArgumentException(com.lynx.jsbridge.a.d(r13, "Invalid operation index: "));
    L18:
        f17028a = r10;
    }
}
