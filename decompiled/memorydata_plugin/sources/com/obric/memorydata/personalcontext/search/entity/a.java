package com.obric.memorydata.personalcontext.search.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"findFirstByActionNameOrNull", "Lcom/obric/memorydata/personalcontext/search/entity/QuResultItem;", "", "actionName", "", "personal_context_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final QuResultItem a(List<QuResultItem> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r4, "actionName");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(((QuResultItem) ZeusTransformUtils.preCheckCast(r0, QuResultItem.class, "com.obric.memorydata.plugin")).getActionName(), r4) == false) goto L4;
    L10:
        return (QuResultItem) ZeusTransformUtils.preCheckCast(r0, QuResultItem.class, "com.obric.memorydata.plugin");
    L8:
        r0 = null;
        goto L10
    }
}
