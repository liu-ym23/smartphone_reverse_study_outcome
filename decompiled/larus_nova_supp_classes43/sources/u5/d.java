package u5;

import com.bytedance.ai.uiu.objects.UIOperationDef;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final Map<Character, UIOperationDef> a = null;

    static {
        Iterable r0 = StringsKt.withIndex("cligbnpt");
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        IndexedValue r11 = (IndexedValue) r1.next();
        int r12 = r11.component1();
        Character r13 = Character.valueOf(((Character) r11.component2()).charValue());
        switch(r12) {
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
        UIOperationDef r14 = UIOperationDef.SCROLL_TOP;
    L17:
        Pair r15 = TuplesKt.to(r13, r14);
        r10.put(r15.getFirst(), r15.getSecond());
        goto L4
    L10:
        r14 = UIOperationDef.SCROLL_PREVIOUS;
        goto L17
    L11:
        r14 = UIOperationDef.SCROLL_NEXT;
        goto L17
    L12:
        r14 = UIOperationDef.SCROLL_BOTTOM;
        goto L17
    L13:
        r14 = UIOperationDef.INPUT_GO;
        goto L17
    L14:
        r14 = UIOperationDef.INPUT;
        goto L17
    L15:
        r14 = UIOperationDef.LONG_CLICK;
        goto L17
    L16:
        r14 = UIOperationDef.CLICK;
        goto L17
    L8:
        throw new IllegalArgumentException("Invalid operation index: " + r12);
    L18:
        a = r10;
    }
}
