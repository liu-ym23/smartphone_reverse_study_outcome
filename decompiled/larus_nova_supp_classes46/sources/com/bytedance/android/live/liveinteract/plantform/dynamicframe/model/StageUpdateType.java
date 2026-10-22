package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/StageUpdateType;", "", "INSERT", "REMOVE", "UPDATE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum StageUpdateType extends Enum<StageUpdateType> {
    public static final StageUpdateType INSERT = null;
    public static final StageUpdateType REMOVE = null;
    public static final StageUpdateType UPDATE = null;
    public static final /* synthetic */ StageUpdateType[] a = null;

    static {
        StageUpdateType r1 = new StageUpdateType("INSERT", 0);
        INSERT = r1;
        StageUpdateType r2 = new StageUpdateType("REMOVE", 1);
        REMOVE = r2;
        StageUpdateType r3 = new StageUpdateType("UPDATE", 2);
        UPDATE = r3;
        a = new StageUpdateType[]{r1, r2, r3};
    }

    public static StageUpdateType valueOf(String r1) {
        return (StageUpdateType) a.a(StageUpdateType.class, r1);
    }

    public static StageUpdateType[] values() {
        return (StageUpdateType[]) a.clone();
    }

    public StageUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
