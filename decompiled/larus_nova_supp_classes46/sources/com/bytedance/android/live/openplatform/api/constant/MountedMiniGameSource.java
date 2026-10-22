package com.bytedance.android.live.openplatform.api.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniGameSource;", "", "Toolbar", "ExplainCard", "Detail", "GameLiveBtn", "Lottery", "InteractPanel", "LiveRoomBussiness", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MountedMiniGameSource extends Enum<MountedMiniGameSource> {
    public static final MountedMiniGameSource Detail = null;
    public static final MountedMiniGameSource ExplainCard = null;
    public static final MountedMiniGameSource GameLiveBtn = null;
    public static final MountedMiniGameSource InteractPanel = null;
    public static final MountedMiniGameSource LiveRoomBussiness = null;
    public static final MountedMiniGameSource Lottery = null;
    public static final MountedMiniGameSource Toolbar = null;
    public static final /* synthetic */ MountedMiniGameSource[] a = null;

    static {
        MountedMiniGameSource r1 = new MountedMiniGameSource("Toolbar", 0);
        Toolbar = r1;
        MountedMiniGameSource r2 = new MountedMiniGameSource("ExplainCard", 1);
        ExplainCard = r2;
        MountedMiniGameSource r3 = new MountedMiniGameSource("Detail", 2);
        Detail = r3;
        MountedMiniGameSource r4 = new MountedMiniGameSource("GameLiveBtn", 3);
        GameLiveBtn = r4;
        MountedMiniGameSource r5 = new MountedMiniGameSource("Lottery", 4);
        Lottery = r5;
        MountedMiniGameSource r6 = new MountedMiniGameSource("InteractPanel", 5);
        InteractPanel = r6;
        MountedMiniGameSource r7 = new MountedMiniGameSource("LiveRoomBussiness", 6);
        LiveRoomBussiness = r7;
        a = new MountedMiniGameSource[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static MountedMiniGameSource valueOf(String r1) {
        return (MountedMiniGameSource) a.a(MountedMiniGameSource.class, r1);
    }

    public static MountedMiniGameSource[] values() {
        return (MountedMiniGameSource[]) a.clone();
    }

    public MountedMiniGameSource(String r1, int r2) {
        super(r1, r2);
    }
}
