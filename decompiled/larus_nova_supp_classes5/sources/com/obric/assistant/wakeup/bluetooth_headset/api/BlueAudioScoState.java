package com.obric.assistant.wakeup.bluetooth_headset.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueAudioScoState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "ERROR", "CONNECTED", "CONNECTING", "DISCONNECTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueAudioScoState extends Enum<BlueAudioScoState> {
    public static final BlueAudioScoState CONNECTED = null;
    public static final BlueAudioScoState CONNECTING = null;
    public static final BlueAudioScoState DISCONNECTED = null;
    public static final BlueAudioScoState ERROR = null;
    public static final BlueAudioScoState NA = null;
    public static final /* synthetic */ BlueAudioScoState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BlueAudioScoState> getEntries() {
        return b;
    }

    static {
        BlueAudioScoState r0 = new BlueAudioScoState("NA", 0);
        NA = r0;
        BlueAudioScoState r1 = new BlueAudioScoState("ERROR", 1);
        ERROR = r1;
        BlueAudioScoState r3 = new BlueAudioScoState("CONNECTED", 2);
        CONNECTED = r3;
        BlueAudioScoState r5 = new BlueAudioScoState("CONNECTING", 3);
        CONNECTING = r5;
        BlueAudioScoState r7 = new BlueAudioScoState("DISCONNECTED", 4);
        DISCONNECTED = r7;
        BlueAudioScoState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static BlueAudioScoState[] values() {
        return (BlueAudioScoState[]) a.clone();
    }

    public static BlueAudioScoState valueOf(String r1) {
        return (BlueAudioScoState) a.a(BlueAudioScoState.class, r1);
    }

    public BlueAudioScoState(String r1, int r2) {
        super(r1, r2);
    }
}
