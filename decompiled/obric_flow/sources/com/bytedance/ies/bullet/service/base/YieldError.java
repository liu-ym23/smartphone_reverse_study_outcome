package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/YieldError;", "Ljava/lang/Error;", "Lkotlin/Error;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class YieldError extends Error {
    public YieldError() {
        Intrinsics.checkNotNullParameter("An operation is not implemented", "message");
        super("An operation is not implemented");
    }
}
