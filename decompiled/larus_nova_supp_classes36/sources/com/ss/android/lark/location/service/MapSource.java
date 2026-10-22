package com.ss.android.lark.location.service;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/location/service/MapSource;", "", "<init>", "(Ljava/lang/String;I)V", "AMAP", "GOOGLE", "BING", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum MapSource extends Enum<MapSource> {
    public static final MapSource AMAP = null;
    public static final MapSource BING = null;
    public static final MapSource GOOGLE = null;
    public static final /* synthetic */ MapSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MapSource> getEntries() {
        return b;
    }

    static {
        MapSource r0 = new MapSource("AMAP", 0);
        AMAP = r0;
        MapSource r1 = new MapSource("GOOGLE", 1);
        GOOGLE = r1;
        MapSource r3 = new MapSource("BING", 2);
        BING = r3;
        MapSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MapSource[] values() {
        return (MapSource[]) a.clone();
    }

    public static MapSource valueOf(String r1) {
        return (MapSource) r27.a.a(MapSource.class, r1);
    }

    public MapSource(String r1, int r2) {
        super(r1, r2);
    }
}
