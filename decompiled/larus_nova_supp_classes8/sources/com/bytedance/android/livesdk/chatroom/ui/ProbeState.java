package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/ProbeState;", "", "NONE", "START", "STOP", "ERROR", "SUCCESS", "RELEASE", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProbeState extends Enum<ProbeState> {
    public static final ProbeState ERROR = null;
    public static final ProbeState NONE = null;
    public static final ProbeState RELEASE = null;
    public static final ProbeState START = null;
    public static final ProbeState STOP = null;
    public static final ProbeState SUCCESS = null;
    public static final /* synthetic */ ProbeState[] a = null;

    static {
        ProbeState r1 = new ProbeState("NONE", 0);
        NONE = r1;
        ProbeState r2 = new ProbeState("START", 1);
        START = r2;
        ProbeState r3 = new ProbeState("STOP", 2);
        STOP = r3;
        ProbeState r4 = new ProbeState("ERROR", 3);
        ERROR = r4;
        ProbeState r5 = new ProbeState("SUCCESS", 4);
        SUCCESS = r5;
        ProbeState r6 = new ProbeState("RELEASE", 5);
        RELEASE = r6;
        a = new ProbeState[]{r1, r2, r3, r4, r5, r6};
    }

    public static ProbeState valueOf(String r1) {
        return (ProbeState) r27.a.a(ProbeState.class, r1);
    }

    public static ProbeState[] values() {
        return (ProbeState[]) a.clone();
    }

    public ProbeState(String r1, int r2) {
        super(r1, r2);
    }
}
