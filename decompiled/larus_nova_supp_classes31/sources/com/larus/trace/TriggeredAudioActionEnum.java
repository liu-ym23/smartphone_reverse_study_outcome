package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/trace/TriggeredAudioActionEnum;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PLAY_START", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TriggeredAudioActionEnum extends Enum<TriggeredAudioActionEnum> {
    public static final TriggeredAudioActionEnum PLAY_START = null;
    public static final /* synthetic */ TriggeredAudioActionEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<TriggeredAudioActionEnum> getEntries() {
        return b;
    }

    static {
        TriggeredAudioActionEnum r0 = new TriggeredAudioActionEnum();
        PLAY_START = r0;
        TriggeredAudioActionEnum[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public TriggeredAudioActionEnum() {
        super("PLAY_START", 0);
        this.value = "play_start";
    }

    public static TriggeredAudioActionEnum[] values() {
        return (TriggeredAudioActionEnum[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static TriggeredAudioActionEnum valueOf(String r1) {
        return (TriggeredAudioActionEnum) a.a(TriggeredAudioActionEnum.class, r1);
    }
}
