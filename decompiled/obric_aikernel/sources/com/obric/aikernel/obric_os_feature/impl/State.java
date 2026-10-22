package com.obric.aikernel.obric_os_feature.impl;

/* JADX INFO: loaded from: classes2.dex */
public final enum State extends Enum<State> {
    private static final /* synthetic */ State[] $VALUES = null;
    public static final State BACKGROUND_IDLE = null;
    public static final State BACKGROUND_NORMAL = null;
    public static final State FOREGROUND_REALTIME = null;
    public static final State FOREGROUND_USER = null;

    private static final /* synthetic */ State[] $values() {
        return new State[]{FOREGROUND_REALTIME, FOREGROUND_USER, BACKGROUND_NORMAL, BACKGROUND_IDLE};
    }

    static {
        FOREGROUND_REALTIME = new State("FOREGROUND_REALTIME", 0);
        FOREGROUND_USER = new State("FOREGROUND_USER", 1);
        BACKGROUND_NORMAL = new State("BACKGROUND_NORMAL", 2);
        BACKGROUND_IDLE = new State("BACKGROUND_IDLE", 3);
        $VALUES = $values();
    }

    private State(String r10, int r11) {
        super(r10, r11);
    }

    public static State valueOf(String r10) {
        return (State) Enum.valueOf(State.class, r10);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }
}
