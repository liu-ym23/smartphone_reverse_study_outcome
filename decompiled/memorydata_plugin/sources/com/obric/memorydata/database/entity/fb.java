package com.obric.memorydata.database.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toProactiveSemanticRelevantData", "Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class fb {
    public static final fa a(RawMemoryEntity r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        if (r14.getMemoryType() == 10105) goto L7;
        return null;
    L7:
        return new fa(0, r14.getEntityId(), r14.getSourceQuery(), r14.getSourceText(), r14.getScreenshot(), r14.getSourceAppName(), r14.getSourcePackageName(), r14.getDetailStatus(), r14.getProductType(), 1, null);
    }
}
