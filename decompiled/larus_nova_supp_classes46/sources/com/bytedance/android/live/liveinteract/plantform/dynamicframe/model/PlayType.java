package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", "", "UNKNOWN", "PLAY_TYPE_NONE", "PLAY_TYPE_SEAT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayType extends Enum<PlayType> {
    public static final PlayType PLAY_TYPE_NONE = null;
    public static final PlayType PLAY_TYPE_SEAT = null;
    public static final PlayType UNKNOWN = null;
    public static final /* synthetic */ PlayType[] a = null;

    static {
        PlayType r1 = new PlayType("UNKNOWN", 0);
        UNKNOWN = r1;
        PlayType r2 = new PlayType("PLAY_TYPE_NONE", 1);
        PLAY_TYPE_NONE = r2;
        PlayType r3 = new PlayType("PLAY_TYPE_SEAT", 2);
        PLAY_TYPE_SEAT = r3;
        a = new PlayType[]{r1, r2, r3};
    }

    public static PlayType valueOf(String r1) {
        return (PlayType) a.a(PlayType.class, r1);
    }

    public static PlayType[] values() {
        return (PlayType[]) a.clone();
    }

    public PlayType(String r1, int r2) {
        super(r1, r2);
    }
}
