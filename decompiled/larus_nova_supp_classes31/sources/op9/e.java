package op9;

import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final String a(d r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r9 = MathKt.roundToInt((r8.a.i * 1.0f) / 1000);
        int r0 = r9 % 60;
        int r10 = r9 / 60;
        int r1 = r10 / 60;
        int r11 = r10 % 60;
        if (r1 != 0) goto L5;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r11), Integer.valueOf(r0)}, 2));
    L5:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r1), Integer.valueOf(r11), Integer.valueOf(r0)}, 3));
    }

    public static final c b(mp9.b r18, c r19, com.larus.photopicker.v2.impl.viewmodel.d r20) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<T> r4 = r18.f.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L52;
        Map.Entry r5 = (Map.Entry) r4.next();
        MediaTab r6 = (MediaTab) r5.getKey();
        List r7 = (List) r5.getValue();
        if (r19 == 0) goto L10;
        Map<MediaTab, List<d>> r8 = r19.c;
        if (r8 == null) goto L10;
        List<d> r9 = r8.get(r6);
    L12:
        if (r9 == null) goto L17;
        List<d> r10 = r9;
        Map r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16));
        Iterator r12 = r10.iterator();
    L15:
        if (r12.hasNext() == false) goto L18;
        Object r13 = r12.next();
        r11.put(Long.valueOf(((d) r13).a.a), r13);
    L18:
        List r14 = r7;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L20:
        if (r16.hasNext() == false) goto L50;
        mp9.c r17 = (mp9.c) r16.next();
        d r110 = (d) r11.get(Long.valueOf(r17.a));
        if (r110 == null) goto L24;
        d r21 = d.a(r110, r17, false, 0, false, 30);
    L49:
        r15.add(r21);
        r20 = r20;
        goto L20
    L24:
        if (r20 == null) goto L26;
        boolean r22 = r20.g(r17.a);
    L27:
        if (r20 == null) goto L47;
        long r111 = r17.a;
        Set r112 = (Set) r20.f.getValue();
        if (r112 != null) goto L31;
    L30:
        int r23 = -1;
    L48:
        r21 = c(r17, r22, r23);
        goto L49
    L31:
        Iterator r113 = r112.iterator();
        int r114 = 0;
    L33:
        if (r113.hasNext() == false) goto L44;
        Object r115 = r113.next();
        if (r114 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        if (((d) r115).a.a != r111) goto L40;
        boolean r1 = true;
    L41:
        if (r1 == true) goto L42;
        r114 = r114 + 1;
        goto L33
    L42:
        int r2 = r114;
    L45:
        if (r2 == (-1)) goto L30;
        r23 = r2 + 1;
        goto L48
    L40:
        r1 = false;
        goto L41
    L44:
        r2 = -1;
        goto L45
    L47:
        r23 = 0;
        goto L48
    L26:
        r22 = false;
        goto L27
    L50:
        r3.put(r6, r15);
        goto L4
    L17:
        r11 = MapsKt.emptyMap();
    L10:
        r9 = null;
        goto L12
    L52:
        return new c(r18.a, r18, r3);
    }

    public static final d c(mp9.c r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new d(r7, r8, r9, null, 24);
    }
}
