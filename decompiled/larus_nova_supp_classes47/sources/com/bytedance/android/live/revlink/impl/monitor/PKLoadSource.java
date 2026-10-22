package com.bytedance.android.live.revlink.impl.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/monitor/PKLoadSource;", "", "UnKnown", "RoomEnter", "LinkerEnter", "SeiBackUp", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PKLoadSource extends Enum<PKLoadSource> {
    public static final PKLoadSource LinkerEnter = null;
    public static final PKLoadSource RoomEnter = null;
    public static final PKLoadSource SeiBackUp = null;
    public static final PKLoadSource UnKnown = null;
    public static final /* synthetic */ PKLoadSource[] a = null;

    static {
        PKLoadSource r1 = new PKLoadSource("UnKnown", 0);
        UnKnown = r1;
        PKLoadSource r2 = new PKLoadSource("RoomEnter", 1);
        RoomEnter = r2;
        PKLoadSource r3 = new PKLoadSource("LinkerEnter", 2);
        LinkerEnter = r3;
        PKLoadSource r4 = new PKLoadSource("SeiBackUp", 3);
        SeiBackUp = r4;
        a = new PKLoadSource[]{r1, r2, r3, r4};
    }

    public static PKLoadSource valueOf(String r1) {
        return (PKLoadSource) r27.a.a(PKLoadSource.class, r1);
    }

    public static PKLoadSource[] values() {
        return (PKLoadSource[]) a.clone();
    }

    public PKLoadSource(String r1, int r2) {
        super(r1, r2);
    }
}
