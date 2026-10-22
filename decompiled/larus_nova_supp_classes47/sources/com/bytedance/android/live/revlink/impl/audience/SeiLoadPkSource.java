package com.bytedance.android.live.revlink.impl.audience;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/audience/SeiLoadPkSource;", "", "NORMAL_SEI", "ENTER_ROOM", "UNLOAD_LINK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeiLoadPkSource extends Enum<SeiLoadPkSource> {
    public static final SeiLoadPkSource ENTER_ROOM = null;
    public static final SeiLoadPkSource NORMAL_SEI = null;
    public static final SeiLoadPkSource UNLOAD_LINK = null;
    public static final /* synthetic */ SeiLoadPkSource[] a = null;

    static {
        SeiLoadPkSource r1 = new SeiLoadPkSource("NORMAL_SEI", 0);
        NORMAL_SEI = r1;
        SeiLoadPkSource r2 = new SeiLoadPkSource("ENTER_ROOM", 1);
        ENTER_ROOM = r2;
        SeiLoadPkSource r3 = new SeiLoadPkSource("UNLOAD_LINK", 2);
        UNLOAD_LINK = r3;
        a = new SeiLoadPkSource[]{r1, r2, r3};
    }

    public static SeiLoadPkSource valueOf(String r1) {
        return (SeiLoadPkSource) r27.a.a(SeiLoadPkSource.class, r1);
    }

    public static SeiLoadPkSource[] values() {
        return (SeiLoadPkSource[]) a.clone();
    }

    public SeiLoadPkSource(String r1, int r2) {
        super(r1, r2);
    }
}
