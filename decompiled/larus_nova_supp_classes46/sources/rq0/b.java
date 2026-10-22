package rq0;

import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.e;
import com.bytedance.android.live.openplatform.api.model.shelf.f;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final List<ProductLabelInfo> a(ShelfCardInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        e r1 = null;
        if (r0 == null) goto L7;
        n<f> r2 = r0.getShelfCardSupplementInfoMap();
        if (r2 == null) goto L7;
        f r4 = (f) r2.getValue();
    L8:
        if (r4 == null) goto L13;
        Map<Long, e> r5 = r4.a();
        if (r5 == null) goto L13;
        r1 = r5.get(Long.valueOf(r3.getCardId()));
    L13:
        return b(r3, r1);
    L7:
        r4 = null;
        goto L8
    }

    public static final List<ProductLabelInfo> b(ShelfCardInfo r7, e r8) {
        Intrinsics.checkNotNullParameter(r7, "cardInfo");
        ProductInfo r9 = r7.getProductInfo();
        if (r9 == null) goto L6;
        List<ProductLabelInfo> r10 = r9.labelList;
        if (r10 == null) goto L6;
    L7:
        if (r8 == null) goto L10;
        List<ProductLabelInfo> r11 = r8.a();
        if (r11 == null) goto L10;
    L11:
        List<ProductLabelInfo> r12 = r11;
        if ((!r12.isEmpty()) == false) goto L50;
        ArrayList r0 = new ArrayList();
        com.bytedance.android.live.openplatform.api.utils.b r2 = com.bytedance.android.live.openplatform.api.utils.b.b;
        com.bytedance.android.live.openplatform.api.utils.b r3 = com.bytedance.android.live.openplatform.api.utils.b.b;
        if (r3.h() == true) goto L16;
    L18:
        r0.addAll(r12);
        ArrayList r13 = new ArrayList();
        List r14 = ((uc1) ee0.a.getValue()).q();
        if (r14 == null) goto L37;
        Iterator r15 = r14.iterator();
    L22:
        if (r15.hasNext() == false) goto L37;
        int r4 = ((Number) r15.next()).intValue();
        Iterator r5 = r0.iterator();
    L25:
        if (r5.hasNext() == false) goto L32;
        Object r6 = r5.next();
        if (((ProductLabelInfo) r6).labelType != r4) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L25;
    L33:
        ProductLabelInfo r17 = (ProductLabelInfo) r6;
        if (r17 == null) goto L22;
        r13.add(r17);
        goto L22
    L29:
        r16 = false;
        goto L30
    L32:
        r6 = null;
    L37:
        if (r13.size() > 3) goto L39;
        return r13;
    L39:
        return r13.subList(0, 3);
    L16:
        if (r3.j() == false) goto L18;
        r0.addAll(r10);
        goto L18
    L50:
        return r10;
    L10:
        r11 = CollectionsKt.emptyList();
    L6:
        r10 = CollectionsKt.emptyList();
        goto L7
    }
}
