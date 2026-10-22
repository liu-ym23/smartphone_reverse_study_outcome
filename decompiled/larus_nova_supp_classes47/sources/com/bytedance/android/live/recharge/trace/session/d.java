package com.bytedance.android.live.recharge.trace.session;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final c a = null;
    public static final c b = null;
    public static final c c = null;
    public static final c d = null;
    public static final c e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;

    static {
        Intrinsics.checkNotNullParameter("panelLaunch", "groupName");
        a = new c("panelLaunch", "rechargePanelCreate");
        b = new c("panelLaunch", "rechargePanelShow");
        c = new c("panelLaunch", "rechargePanelContentLoad");
        Intrinsics.checkNotNullParameter("order", "groupName");
        d = new c("order", "rechargeOrderCreate");
        e = new c("order", "rechargeOrderSucceed");
        f = new c("order", "rechargeOrderFail");
        g = new c("order", "rechargeOrderCancel");
        Intrinsics.checkNotNullParameter("userInteraction", "groupName");
        h = new c("userInteraction", "clickRechargeButton");
        i = new c("userInteraction", "clickCustomRecharge");
        Intrinsics.checkNotNullParameter("cashier", "groupName");
        j = new c("cashier", "cashierShow");
    }
}
