package com.obric.aiagent.assistant.idl.bean;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/ObricStateConst$AudioPlayType;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PLAY_STATE_STOPPED", "PLAY_STATE_PREPARE", "PLAY_STATE_PAUSED", "PLAY_STATE_PLAYING", "PLAY_STATE_FAIL", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricStateConst$AudioPlayType extends Enum<ObricStateConst$AudioPlayType> {
    public static final ObricStateConst$AudioPlayType PLAY_STATE_FAIL = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_PAUSED = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_PLAYING = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_PREPARE = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_STOPPED = null;
    public static final /* synthetic */ ObricStateConst$AudioPlayType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ObricStateConst$AudioPlayType> getEntries() {
        return b;
    }

    static {
        ObricStateConst$AudioPlayType r0 = new ObricStateConst$AudioPlayType("PLAY_STATE_STOPPED", 0, 1);
        PLAY_STATE_STOPPED = r0;
        ObricStateConst$AudioPlayType r1 = new ObricStateConst$AudioPlayType("PLAY_STATE_PREPARE", 1, 2);
        PLAY_STATE_PREPARE = r1;
        ObricStateConst$AudioPlayType r4 = new ObricStateConst$AudioPlayType("PLAY_STATE_PAUSED", 2, 3);
        PLAY_STATE_PAUSED = r4;
        ObricStateConst$AudioPlayType r6 = new ObricStateConst$AudioPlayType("PLAY_STATE_PLAYING", 3, 4);
        PLAY_STATE_PLAYING = r6;
        ObricStateConst$AudioPlayType r8 = new ObricStateConst$AudioPlayType("PLAY_STATE_FAIL", 4, 5);
        PLAY_STATE_FAIL = r8;
        ObricStateConst$AudioPlayType[] r10 = {r0, r1, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static ObricStateConst$AudioPlayType[] values() {
        return (ObricStateConst$AudioPlayType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricStateConst$AudioPlayType valueOf(String r1) {
        return (ObricStateConst$AudioPlayType) a.a(ObricStateConst$AudioPlayType.class, r1);
    }

    public ObricStateConst$AudioPlayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
