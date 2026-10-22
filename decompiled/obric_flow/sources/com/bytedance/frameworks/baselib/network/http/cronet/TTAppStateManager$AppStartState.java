package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes2.dex */
public final enum TTAppStateManager$AppStartState extends Enum<TTAppStateManager$AppStartState> {
    public static final TTAppStateManager$AppStartState ColdStart = null;
    public static final TTAppStateManager$AppStartState Default = null;
    public static final TTAppStateManager$AppStartState HotStart = null;
    public static final TTAppStateManager$AppStartState NormalStart = null;
    public static final TTAppStateManager$AppStartState WarmStart = null;
    public static final TTAppStateManager$AppStartState WeakNet = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTAppStateManager$AppStartState[] f4669a = null;
    final int state;

    static {
        TTAppStateManager$AppStartState r5 = new TTAppStateManager$AppStartState("NormalStart", 0, -1);
        NormalStart = r5;
        TTAppStateManager$AppStartState r10 = new TTAppStateManager$AppStartState("ColdStart", 1, 0);
        ColdStart = r10;
        TTAppStateManager$AppStartState r11 = new TTAppStateManager$AppStartState("HotStart", 2, 1);
        HotStart = r11;
        TTAppStateManager$AppStartState r12 = new TTAppStateManager$AppStartState("WarmStart", 3, 2);
        WarmStart = r12;
        TTAppStateManager$AppStartState r13 = new TTAppStateManager$AppStartState("WeakNet", 4, 3);
        WeakNet = r13;
        TTAppStateManager$AppStartState r14 = new TTAppStateManager$AppStartState("Default", 5, 4);
        Default = r14;
        f4669a = new TTAppStateManager$AppStartState[]{r5, r10, r11, r12, r13, r14};
    }

    public TTAppStateManager$AppStartState(String r5, int r10, int r11) {
        super(r5, r10);
        this.state = r11;
    }

    public static TTAppStateManager$AppStartState valueOf(String r5) {
        return (TTAppStateManager$AppStartState) Enum.valueOf(TTAppStateManager$AppStartState.class, r5);
    }

    public static TTAppStateManager$AppStartState[] values() {
        return (TTAppStateManager$AppStartState[]) f4669a.clone();
    }

    public int getValue() {
        return this.state;
    }
}
