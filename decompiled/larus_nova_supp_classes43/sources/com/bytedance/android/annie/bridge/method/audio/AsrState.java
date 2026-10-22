package com.bytedance.android.annie.bridge.method.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/audio/AsrState;", "", "NONE", "STARTED", "STOPPING", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum AsrState extends Enum<AsrState> {
    public static final AsrState NONE = null;
    public static final AsrState STARTED = null;
    public static final AsrState STOPPING = null;
    public static final /* synthetic */ AsrState[] a = null;

    public static AsrState valueOf(String r1) {
        return (AsrState) r27.a.a(AsrState.class, r1);
    }

    public static AsrState[] values() {
        return (AsrState[]) a.clone();
    }

    static {
        AsrState r0 = new AsrState("NONE", 0);
        NONE = r0;
        AsrState r1 = new AsrState("STARTED", 1);
        STARTED = r1;
        AsrState r10 = new AsrState("STOPPING", 2);
        STOPPING = r10;
        a = new AsrState[]{r0, r1, r10};
    }

    public AsrState(String r1, int r10) {
        super(r1, r10);
    }
}
