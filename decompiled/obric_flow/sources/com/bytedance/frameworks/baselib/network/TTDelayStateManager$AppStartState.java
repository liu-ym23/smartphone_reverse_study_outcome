package com.bytedance.frameworks.baselib.network;

/* JADX INFO: loaded from: classes2.dex */
public final enum TTDelayStateManager$AppStartState extends Enum<TTDelayStateManager$AppStartState> {
    public static final TTDelayStateManager$AppStartState ColdStart = null;
    public static final TTDelayStateManager$AppStartState HotStart = null;
    public static final TTDelayStateManager$AppStartState NormalStart = null;
    public static final TTDelayStateManager$AppStartState WarmStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTDelayStateManager$AppStartState[] f4659a = null;
    final int state;

    static {
        TTDelayStateManager$AppStartState r5 = new TTDelayStateManager$AppStartState("NormalStart", 0, -1);
        NormalStart = r5;
        TTDelayStateManager$AppStartState r10 = new TTDelayStateManager$AppStartState("ColdStart", 1, 0);
        ColdStart = r10;
        TTDelayStateManager$AppStartState r11 = new TTDelayStateManager$AppStartState("HotStart", 2, 1);
        HotStart = r11;
        TTDelayStateManager$AppStartState r12 = new TTDelayStateManager$AppStartState("WarmStart", 3, 2);
        WarmStart = r12;
        f4659a = new TTDelayStateManager$AppStartState[]{r5, r10, r11, r12};
    }

    public TTDelayStateManager$AppStartState(String r5, int r10, int r11) {
        super(r5, r10);
        this.state = r11;
    }

    public static TTDelayStateManager$AppStartState valueOf(String r5) {
        return (TTDelayStateManager$AppStartState) Enum.valueOf(TTDelayStateManager$AppStartState.class, r5);
    }

    public static TTDelayStateManager$AppStartState[] values() {
        return (TTDelayStateManager$AppStartState[]) f4659a.clone();
    }

    public int getValue() {
        return this.state;
    }
}
