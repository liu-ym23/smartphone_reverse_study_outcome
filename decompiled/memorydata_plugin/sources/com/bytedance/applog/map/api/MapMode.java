package com.bytedance.applog.map.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/applog/map/api/MapMode;", "", "(Ljava/lang/String;I)V", "RealtimeSearch", "FullMap", "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum MapMode extends Enum<MapMode> {
    private static final /* synthetic */ MapMode[] $VALUES = null;
    public static final MapMode FullMap = null;
    public static final MapMode RealtimeSearch = null;

    private static final /* synthetic */ MapMode[] $values() {
        return new MapMode[]{RealtimeSearch, FullMap};
    }

    static {
        RealtimeSearch = new MapMode("RealtimeSearch", 0);
        FullMap = new MapMode("FullMap", 1);
        $VALUES = $values();
    }

    private MapMode(String r1, int r2) {
        super(r1, r2);
    }

    public static MapMode valueOf(String r2) {
        return (MapMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapMode.class, r2), MapMode.class, "com.obric.memorydata.plugin");
    }

    public static MapMode[] values() {
        return (MapMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapMode[].class, "com.obric.memorydata.plugin");
    }
}
