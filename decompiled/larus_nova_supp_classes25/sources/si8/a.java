package si8;

import com.larus.im.bean.message.ImageDisplaySize;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.SearchImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.o;
import yc9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements pi8.a {
    public a() {
    }

    @Override // pi8.a
    public final o a(k r30, oi8.c r31) {
        Intrinsics.checkNotNullParameter(r30, "originData");
        ArrayList r0 = new ArrayList();
        com.larus.bmhome.chat.search.b r1 = r30.e();
        if (r1 == null) goto L7;
        com.larus.bmhome.chat.search.b.a r2 = r1.c();
        if (r2 == null) goto L7;
        List<SearchImageInfo> r3 = r2.a();
    L8:
        List<SearchImageInfo> r4 = r3;
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L19;
        return new o(r0, true);
    L19:
        if (r3.size() != 1) goto L22;
        SearchImageInfo r6 = (SearchImageInfo) CollectionsKt.first(r3);
        r6.setDisplaySetting(new s(ImageDisplaySize.medium, true, true, true, true));
        r6.setFoldImageInfoList(null);
        r0.add(r6);
        return new o(r0, true);
    L22:
        Iterator r7 = CollectionsKt.take(r3, 4).iterator();
        int r8 = 0;
    L24:
        if (r7.hasNext() == false) goto L37;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        SearchImageInfo r11 = (SearchImageInfo) r9;
        if (r10 == 4) goto L31;
        r11.setFoldImageInfoList(null);
    L35:
        r0.add(r11);
        r8 = r10;
        goto L24
    L31:
        if (Math.max(0, r3.size() - 4) <= 0) goto L33;
        r11.setFoldImageInfoList(r3.subList(4, r3.size()));
        goto L35
    L33:
        r11.setFoldImageInfoList(null);
        goto L35
    L37:
        if (r0.size() != 3) goto L39;
        SearchImageInfo r12 = new SearchImageInfo(-1L, "search_image_placeholder", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048572, null);
        r12.setPlaceHolder(true);
        r0.add(r12);
    L39:
        Iterator r13 = r0.iterator();
        int r14 = 0;
    L41:
        if (r13.hasNext() == false) goto L71;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        SearchImageInfo r17 = (ItemData) r15;
        if ((r17 instanceof SearchImageInfo) == false) goto L69;
        if (r14 != 0) goto L49;
        boolean r18 = true;
    L51:
        if (r16 < 2) goto L53;
    L54:
        if (r16 != 2) goto L56;
    L55:
        boolean r19 = true;
    L58:
        if ((((((r0.size() + 2) - 1) / 2) - 1) * 2) != r14) goto L60;
        boolean r110 = true;
    L62:
        if (r16 != r0.size()) goto L67;
        if (r16 >= 2) goto L65;
    L66:
        boolean r111 = true;
    L68:
        r17.setDisplaySetting(new s(ImageDisplaySize.small, r18, r19, r110, r111));
        goto L69
    L65:
        if ((r16 % 2) == 0) goto L66;
    L67:
        r111 = false;
        goto L68
    L60:
        r110 = false;
        goto L62
    L56:
        r19 = false;
        goto L58
    L53:
        if (r16 == r0.size()) goto L55;
    L49:
        r18 = false;
    L69:
        r14 = r16;
        goto L41
    L71:
        return new o(r0, true);
    L11:
        if (r4.isEmpty() == true) goto L14;
        r5 = false;
    L7:
        r3 = null;
        goto L8
    }
}
