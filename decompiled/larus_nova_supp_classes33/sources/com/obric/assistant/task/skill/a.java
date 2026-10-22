package com.obric.assistant.task.skill;

import com.obric.assistant.network.api.bean.ObricOmniModel;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final List<ObricOmniModel> a(ObricOmniModelConfig r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List r2 = r1.getModels();
        if (r2 != null) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        return CollectionsKt.filterNotNull(r2);
    }
}
