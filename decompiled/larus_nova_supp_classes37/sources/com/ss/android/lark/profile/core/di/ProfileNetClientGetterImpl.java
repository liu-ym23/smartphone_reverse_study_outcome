package com.ss.android.lark.profile.core.di;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class ProfileNetClientGetterImpl implements a {
    public final l a;
    public final b38.b b;
    public final Lazy c;

    @Override // com.ss.android.lark.profile.core.di.a
    public final b38.b Q4() {
        return this.b;
    }

    @Inject
    public ProfileNetClientGetterImpl(l r2, b38.b r3) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "scopedRucket");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(ProfileNetClientGetterImpl$_userScopeData$2.INSTANCE);
    }
}
