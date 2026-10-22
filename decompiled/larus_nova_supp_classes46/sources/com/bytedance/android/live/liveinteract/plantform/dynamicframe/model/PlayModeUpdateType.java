package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayModeUpdateType;", "", "NONE", "ADD_PLAYMODE", "REMOVE_PLAYMODE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayModeUpdateType extends Enum<PlayModeUpdateType> {
    public static final PlayModeUpdateType ADD_PLAYMODE = null;
    public static final PlayModeUpdateType NONE = null;
    public static final PlayModeUpdateType REMOVE_PLAYMODE = null;
    public static final /* synthetic */ PlayModeUpdateType[] a = null;

    static {
        PlayModeUpdateType r1 = new PlayModeUpdateType("NONE", 0);
        NONE = r1;
        PlayModeUpdateType r2 = new PlayModeUpdateType("ADD_PLAYMODE", 1);
        ADD_PLAYMODE = r2;
        PlayModeUpdateType r3 = new PlayModeUpdateType("REMOVE_PLAYMODE", 2);
        REMOVE_PLAYMODE = r3;
        a = new PlayModeUpdateType[]{r1, r2, r3};
    }

    public static PlayModeUpdateType valueOf(String r1) {
        return (PlayModeUpdateType) a.a(PlayModeUpdateType.class, r1);
    }

    public static PlayModeUpdateType[] values() {
        return (PlayModeUpdateType[]) a.clone();
    }

    public PlayModeUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
