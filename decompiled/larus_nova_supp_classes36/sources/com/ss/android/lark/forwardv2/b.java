package com.ss.android.lark.forwardv2;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardTargetFilter;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements hib.e {
    public b() {
    }

    @Override // hib.e
    public final void a(BusinessRecentVisitIncludeConfig r2, IGetDataCallback r3, ForwardTargetFilter r4) {
        Intrinsics.checkNotNullParameter(r2, "includeConfigs");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "filter");
        r3.onSuccess(CollectionsKt.emptyList());
    }
}
