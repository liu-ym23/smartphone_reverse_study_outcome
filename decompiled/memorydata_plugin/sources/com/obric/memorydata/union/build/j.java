package com.obric.memorydata.union.build;

import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"normalizeSemanticTagPath", "", "semanticType", "tagPath", "memory_build_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class j {
    public static final String a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "semanticType");
        Intrinsics.checkNotNullParameter(r8, "tagPath");
        Object r1 = null;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringBefore$default(r8, ',', null, 2, null), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"偏好", "爱好", InfoCommonMemoryEntity.InfoKeyType.RELATIONSHIP}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r5 = false;
        if (r0.hasNext() == false) goto L8;
        Object r4 = r0.next();
        if (StringsKt.endsWith$default(r9, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L3;
        r1 = r4;
    L8:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        r9 = StringsKt.removeSuffix(r9, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    L13:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L15;
        r5 = true;
    L15:
        if (r5 == false) goto L18;
        return IRecommendSettings.ProfileTag.OTHER;
    L18:
        if (Intrinsics.areEqual(r7, "relationship") == true) goto L20;
        return r9;
    L20:
        if (Intrinsics.areEqual(r9, "同事") == false) goto L28;
        return "工作";
    L28:
        return r9;
    }
}
