package ip0;

import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T, R> implements Function {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r6) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b r7 = (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r6;
        Intrinsics.checkNotNullParameter(r7, "response");
        LinkedHashMap r0 = new LinkedHashMap();
        List<MiniAppEntranceCell> r1 = r7.entranceList;
        if (r1 == null) goto L11;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        T r3 = r2.next();
        Long r4 = Long.valueOf(((MiniAppEntranceCell) r3).groupId);
        Object r5 = r0.get(r4);
        if (r5 != null) goto L10;
        r5 = new ArrayList();
        r0.put(r4, r5);
    L10:
        ((List) r5).add(r3);
    L11:
        int r8 = qo0.a.a;
        StringBuilder r9 = new StringBuilder("start update grouped list, entrance cell count: ");
        r9.append(r0.size());
        r9.append(", banner count: ");
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r10 = r7.a();
        if (r10 == null) goto L14;
        Integer r11 = Integer.valueOf(r10.size());
    L15:
        r9.append(String.valueOf(r11));
        qo0.a.c("choose_list", r9.toString());
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r12 = AnchorMiniAppDataContext.a.a();
        if (r12 == null) goto L24;
        m<Boolean> r13 = r12.getSupportComponentCoexist();
        if (r13 == null) goto L24;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L24;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r14 = r7.a();
        if (r14 != null) goto L25;
        r14 = CollectionsKt.emptyList();
    L25:
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c> r15 = r7.groupPropertyList;
        if (r15 != null) goto L29;
        r15 = CollectionsKt.emptyList();
    L29:
        return new b(r0, r14, r15);
    L24:
        r14 = CollectionsKt.emptyList();
        goto L25
    L14:
        r11 = null;
        goto L15
    }
}
