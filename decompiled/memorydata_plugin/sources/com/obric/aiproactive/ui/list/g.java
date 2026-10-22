package com.obric.aiproactive.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"recommendationRankAt", "", "items", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "position", "(Ljava/util/List;I)Ljava/lang/Integer;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {
    public static final Integer a(List<? extends com.obric.aiproactive.ui.model.j> r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "items");
        int r2 = 0;
        if (r6 >= 0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        return null;
    L10:
        if (ZeusTransformUtils.instanceOf(r7.get(r6), com.obric.aiproactive.ui.model.j.f.class) == false) goto L36;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), r6 + 1), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L15;
    L17:
        Iterator r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L26;
        if (ZeusTransformUtils.instanceOf((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.j.f.class) == false) goto L19;
        r2 = r2 + 1;
        if (r2 >= 0) goto L19;
        CollectionsKt.throwCountOverflow();
    L26:
        return Integer.valueOf(r2);
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
    L36:
        return null;
    L5:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r3 = true;
        goto L8
    }
}
