package kp0;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.d;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T, R> implements Function {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object apply(Object r13) {
        e r14 = (e) r13;
        Intrinsics.checkNotNullParameter(r14, "it");
        List<MiniAppEntranceCell> r15 = ((d) r14.data).entranceList;
        if (r15 == null) goto L9;
        List<MiniAppEntranceCell> r16 = r15;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L6:
        if (r17.hasNext() == false) goto L11;
        MiniAppEntranceCell r1 = (MiniAppEntranceCell) r17.next();
        r0.add(new MiniAppEntranceCell(r1.title, r1.desc, r1.icon, -1, r1.appId, r1.schema, r1.serverScenes, r1.extendExtra));
        goto L6
    L11:
        return r0;
    L9:
        return CollectionsKt.emptyList();
    }
}
