package com.ss.android.lark.message.lynxcard.monitor;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.SetUniversalCardRenderStatusRequest;
import com.bytedance.lark.pb.openplatform.v1.SetUniversalCardRenderStatusResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class LynxCardMonitorServiceImpl implements com.ss.android.lark.message.lynxcard.monitor.a {
    public final l a;

    public static final class a {
    }

    static {
    }

    @Inject
    public LynxCardMonitorServiceImpl(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // com.ss.android.lark.message.lynxcard.monitor.a
    public final void z6(String r10, String r11) {
        SetUniversalCardRenderStatusRequest.Builder r1 = new SetUniversalCardRenderStatusRequest.Builder().biz_id(r10).card_id(r11);
        l r12 = this.a;
        Intrinsics.checkNotNull(r1);
        t.g(r12.h(new com.bytedance.lark.rustclient.api.d(r1, SetUniversalCardRenderStatusResponse.ADAPTER, Command.SET_UNIVERSAL_CARD_RENDER_STATUS, null, null, null, null, 248)).a(), LynxCardMonitorServiceImpl$syncRenderStatusToSdk$d$1.INSTANCE, LynxCardMonitorServiceImpl$syncRenderStatusToSdk$d$2.INSTANCE);
    }
}
