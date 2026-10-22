package com.bytedance.android.livesdk.chatroom.ui.framework;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/LoadState;", "", "", "value", "I", "getValue", "()I", "NONE", "FS_BEGIN", "FS_END", "P0_BEGIN", "P0_END", "P0_REAL_END", "P1_BEGIN", "P1_END", "P1_REAL_END", "P2_BEGIN", "P2_END", "P2_REAL_END", "P3_BEGIN", "P3_END", "P3_REAL_END", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState FS_BEGIN = null;
    public static final LoadState FS_END = null;
    public static final LoadState NONE = null;
    public static final LoadState P0_BEGIN = null;
    public static final LoadState P0_END = null;
    public static final LoadState P0_REAL_END = null;
    public static final LoadState P1_BEGIN = null;
    public static final LoadState P1_END = null;
    public static final LoadState P1_REAL_END = null;
    public static final LoadState P2_BEGIN = null;
    public static final LoadState P2_END = null;
    public static final LoadState P2_REAL_END = null;
    public static final LoadState P3_BEGIN = null;
    public static final LoadState P3_END = null;
    public static final LoadState P3_REAL_END = null;
    public static final /* synthetic */ LoadState[] a = null;
    private final int value;

    public static LoadState valueOf(String r1) {
        return (LoadState) r27.a.a(LoadState.class, r1);
    }

    public static LoadState[] values() {
        return (LoadState[]) a.clone();
    }

    static {
        LoadState r1 = new LoadState("NONE", 0, 0);
        NONE = r1;
        LoadState r2 = new LoadState("FS_BEGIN", 1, 1);
        FS_BEGIN = r2;
        LoadState r3 = new LoadState("FS_END", 2, 2);
        FS_END = r3;
        LoadState r4 = new LoadState("P0_BEGIN", 3, 3);
        P0_BEGIN = r4;
        LoadState r5 = new LoadState("P0_END", 4, 4);
        P0_END = r5;
        LoadState r6 = new LoadState("P0_REAL_END", 5, 5);
        P0_REAL_END = r6;
        LoadState r7 = new LoadState("P1_BEGIN", 6, 6);
        P1_BEGIN = r7;
        LoadState r8 = new LoadState("P1_END", 7, 7);
        P1_END = r8;
        LoadState r9 = new LoadState("P1_REAL_END", 8, 8);
        P1_REAL_END = r9;
        LoadState r10 = new LoadState("P2_BEGIN", 9, 9);
        P2_BEGIN = r10;
        LoadState r11 = new LoadState("P2_END", 10, 10);
        P2_END = r11;
        LoadState r12 = new LoadState("P2_REAL_END", 11, 11);
        P2_REAL_END = r12;
        LoadState r13 = new LoadState("P3_BEGIN", 12, 12);
        P3_BEGIN = r13;
        LoadState r14 = new LoadState("P3_END", 13, 13);
        P3_END = r14;
        LoadState r15 = new LoadState("P3_REAL_END", 14, 14);
        P3_REAL_END = r15;
        a = new LoadState[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15};
    }

    public final int getValue() {
        return this.value;
    }

    public LoadState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
