package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "", "NOT_PREPARED", "PREPARED", "STARTED", "PAUSED", "STOPPED", "RELEASE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerState extends Enum<PlayerState> {
    public static final PlayerState NOT_PREPARED = null;
    public static final PlayerState PAUSED = null;
    public static final PlayerState PREPARED = null;
    public static final PlayerState RELEASE = null;
    public static final PlayerState STARTED = null;
    public static final PlayerState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayerState[] f11352a = null;

    static {
        PlayerState r5 = new PlayerState("NOT_PREPARED", 0);
        NOT_PREPARED = r5;
        PlayerState r10 = new PlayerState("PREPARED", 1);
        PREPARED = r10;
        PlayerState r11 = new PlayerState("STARTED", 2);
        STARTED = r11;
        PlayerState r12 = new PlayerState("PAUSED", 3);
        PAUSED = r12;
        PlayerState r13 = new PlayerState("STOPPED", 4);
        STOPPED = r13;
        PlayerState r14 = new PlayerState("RELEASE", 5);
        RELEASE = r14;
        f11352a = new PlayerState[]{r5, r10, r11, r12, r13, r14};
    }

    public static PlayerState valueOf(String r5) {
        return (PlayerState) Enum.valueOf(PlayerState.class, r5);
    }

    public static PlayerState[] values() {
        return (PlayerState[]) f11352a.clone();
    }
}
