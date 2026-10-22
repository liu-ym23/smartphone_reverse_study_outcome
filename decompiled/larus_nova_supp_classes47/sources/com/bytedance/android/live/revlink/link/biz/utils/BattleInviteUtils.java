package com.bytedance.android.live.revlink.link.biz.utils;

import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.i;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BattleInviteUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r1, final ILinkMicBattleInviteMessage r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "inviteMessage");
        Function1<com.bytedance.android.live.revlink.link.biz.service.a, a> r0 = new BattleInviteUtils$parseBattleInviteTitle$1(r2);
        Intrinsics.checkNotNullParameter(r1, "$this$holderScope");
        Intrinsics.checkNotNullParameter(r0, "scope");
        return (a) r0.invoke(new i(r1));
    }
}
