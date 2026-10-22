package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/anchorimpl/AlertBizType;", "", "Default", "BattleInvite", "KickOut", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AlertBizType extends Enum<AlertBizType> {
    public static final AlertBizType BattleInvite = null;
    public static final AlertBizType Default = null;
    public static final AlertBizType KickOut = null;
    public static final /* synthetic */ AlertBizType[] a = null;

    static {
        AlertBizType r1 = new AlertBizType("Default", 0);
        Default = r1;
        AlertBizType r2 = new AlertBizType("BattleInvite", 1);
        BattleInvite = r2;
        AlertBizType r3 = new AlertBizType("KickOut", 2);
        KickOut = r3;
        a = new AlertBizType[]{r1, r2, r3};
    }

    public static AlertBizType valueOf(String r1) {
        return (AlertBizType) r27.a.a(AlertBizType.class, r1);
    }

    public static AlertBizType[] values() {
        return (AlertBizType[]) a.clone();
    }

    public AlertBizType(String r1, int r2) {
        super(r1, r2);
    }
}
