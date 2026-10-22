package com.bytedance.android.live.core.privacy.av.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements com.bytedance.android.live.core.privacy.av.api.h {
    public h() {
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void b(String r1, Exception r2) {
        Intrinsics.checkNotNullParameter(r1, "msg");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void c(com.bytedance.android.live.core.privacy.av.api.i r2) {
        Intrinsics.checkNotNullParameter(r2, "remoteData");
    }
}
