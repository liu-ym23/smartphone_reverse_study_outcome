package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/TrackerUpdateType;", "", "ADD", "REMOVE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TrackerUpdateType extends Enum<TrackerUpdateType> {
    public static final TrackerUpdateType ADD = null;
    public static final TrackerUpdateType REMOVE = null;
    public static final /* synthetic */ TrackerUpdateType[] a = null;

    static {
        TrackerUpdateType r1 = new TrackerUpdateType("ADD", 0);
        ADD = r1;
        TrackerUpdateType r2 = new TrackerUpdateType("REMOVE", 1);
        REMOVE = r2;
        a = new TrackerUpdateType[]{r1, r2};
    }

    public static TrackerUpdateType valueOf(String r1) {
        return (TrackerUpdateType) a.a(TrackerUpdateType.class, r1);
    }

    public static TrackerUpdateType[] values() {
        return (TrackerUpdateType[]) a.clone();
    }

    public TrackerUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
