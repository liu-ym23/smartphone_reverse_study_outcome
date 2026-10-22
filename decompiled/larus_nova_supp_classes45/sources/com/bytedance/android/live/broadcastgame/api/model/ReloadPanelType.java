package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/ReloadPanelType;", "", "FROM_CAHCE", "FROM_SEVER", "NOT_RELOAD", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReloadPanelType extends Enum<ReloadPanelType> {
    public static final ReloadPanelType FROM_CAHCE = null;
    public static final ReloadPanelType FROM_SEVER = null;
    public static final ReloadPanelType NOT_RELOAD = null;
    public static final /* synthetic */ ReloadPanelType[] a = null;

    static {
        ReloadPanelType r1 = new ReloadPanelType("FROM_CAHCE", 0);
        FROM_CAHCE = r1;
        ReloadPanelType r2 = new ReloadPanelType("FROM_SEVER", 1);
        FROM_SEVER = r2;
        ReloadPanelType r3 = new ReloadPanelType("NOT_RELOAD", 2);
        NOT_RELOAD = r3;
        a = new ReloadPanelType[]{r1, r2, r3};
    }

    public static ReloadPanelType valueOf(String r1) {
        return (ReloadPanelType) r27.a.a(ReloadPanelType.class, r1);
    }

    public static ReloadPanelType[] values() {
        return (ReloadPanelType[]) a.clone();
    }

    public ReloadPanelType(String r1, int r2) {
        super(r1, r2);
    }
}
