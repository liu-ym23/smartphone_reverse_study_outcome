package com.ss.android.lark.conditional.access.plugin;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.security.v1.GetUnifiedGrantTokenRequest;
import com.bytedance.lark.pb.security.v1.GetUnifiedGrantTokenResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.s;
import com.ss.android.lark.active.user.bridge.e;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a implements e<Unit, Observable<s<com.bytedance.lark.sdk.refactor.b, GetUnifiedGrantTokenResponse>>> {
    public final l a;

    public final Object a() {
        return this.a.h(new d(new GetUnifiedGrantTokenRequest.Builder(), GetUnifiedGrantTokenResponse.ADAPTER, Command.POLICY_CENTER_GET_UNIFIED_GRANT_TOKEN, null, null, null, null, 248)).a();
    }

    @Inject
    public a(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }
}
