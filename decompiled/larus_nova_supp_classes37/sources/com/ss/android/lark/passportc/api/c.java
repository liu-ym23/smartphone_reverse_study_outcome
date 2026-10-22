package com.ss.android.lark.passportc.api;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements f {
    @Inject
    public c() {
    }

    @Override // com.ss.android.lark.passportc.api.f
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    @Override // com.ss.android.lark.passportc.api.f
    public final Observable<Boolean> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return Observable.just(Boolean.FALSE);
    }
}
