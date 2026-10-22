package com.ss.android.lark.passportc.api;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class u implements p {
    @Inject
    public u() {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }
}
