package com.obric.memorydata.recommend.settings;

import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"withScreenObservationEnabled", "Lcom/obric/memorydata/recommend/settings/RecommendSettingsState;", "enabled", "", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class s {
    public static final k a(k r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r20.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(c.a((c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.memorydata.plugin"), null, null, r21, false, null, 0, 59, null));
        goto L4
    L6:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r20.d(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        i r8 = (i) ZeusTransformUtils.preCheckCast(r6.next(), i.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r8.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        r9.add(c.a((c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.memorydata.plugin"), null, null, r21, false, null, 0, 59, null));
        goto L11
    L13:
        r4.add(i.a(r8, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null));
        goto L8
    L15:
        return k.a(r20, r21, false, false, r5, 0, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), null, 0, Constants.UPLOAD_DISASTER_ESCAPE, null);
    }
}
