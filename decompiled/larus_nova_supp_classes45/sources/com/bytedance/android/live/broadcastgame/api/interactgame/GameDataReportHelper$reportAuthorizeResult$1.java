package com.bytedance.android.live.broadcastgame.api.interactgame;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"convertAuthResult", "", "authResult", "invoke"}, k = 3, mv = {1, 4, 3})
public final class GameDataReportHelper$reportAuthorizeResult$1 extends Lambda implements Function1<String, String> {
    public static final GameDataReportHelper$reportAuthorizeResult$1 INSTANCE = null;

    static {
        INSTANCE = new GameDataReportHelper$reportAuthorizeResult$1();
    }

    public GameDataReportHelper$reportAuthorizeResult$1() {
        super(1);
    }

    public final String invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "authResult");
        int r0 = r3.hashCode();
        if (r0 == (-1738800519)) goto L16;
        if (r0 == (-266960777)) goto L13;
        if (r0 == 3548) goto L10;
        return r3;
    L10:
        if (r3.equals("ok") == false) goto L19;
        return "success";
    L19:
        return r3;
    L13:
        if (r3.equals("userDeny") == false) goto L21;
        return "user_decline";
    L21:
        return r3;
    L16:
        if (r3.equals("sysDeny") == false) goto L23;
        return "system_decline";
    L23:
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
