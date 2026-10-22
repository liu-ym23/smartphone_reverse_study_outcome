package mp9;

import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final Map<MediaTab, Integer> b(List<c> r7, List<? extends MediaTab> r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "allTabs");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L18;
        MediaTab r1 = (MediaTab) r9.next();
        if (r1 == MediaTab.ALL) goto L7;
        MediaType r2 = r1.toMediaType();
        ArrayList r4 = new ArrayList();
        Iterator<T> r3 = r7.iterator();
    L10:
        if (r3.hasNext() == false) goto L17;
        Object r5 = r3.next();
        if (((c) r5).getType() != r2) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L10;
        r4.add(r5);
        goto L10
    L14:
        r6 = false;
        goto L15
    L17:
        r0.put(r1, Integer.valueOf(r4.size()));
        goto L4
    L7:
        r0.put(r1, Integer.valueOf(r7.size()));
        goto L4
    L18:
        return r0;
    }

    public static final Map<MediaTab, List<c>> a(List<c> r8, List<? extends MediaTab> r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "allTabs");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        MediaTab r1 = (MediaTab) r11.next();
        if (r1 == MediaTab.ALL) goto L7;
        MediaType r2 = r1.toMediaType();
        ArrayList r5 = new ArrayList();
        Iterator<T> r4 = r8.iterator();
    L10:
        if (r4.hasNext() == false) goto L17;
        Object r6 = r4.next();
        if (((c) r6).getType() != r2) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L10;
        r5.add(r6);
        goto L10
    L14:
        r7 = false;
        goto L15
    L17:
        r0.put(r1, r5.subList(0, Math.min(r5.size(), r10)));
        goto L4
    L7:
        r0.put(r1, r8.subList(0, Math.min(r8.size(), r10)));
        goto L4
    L18:
        return r0;
    }
}
