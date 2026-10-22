package com.larus.bmhome.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/data/ExitClickSpeakerType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ASR_END", "TIMEOUT", "MANUAL", "RESTART", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExitClickSpeakerType extends Enum<ExitClickSpeakerType> {
    public static final ExitClickSpeakerType ASR_END = null;
    public static final ExitClickSpeakerType MANUAL = null;
    public static final ExitClickSpeakerType RESTART = null;
    public static final ExitClickSpeakerType TIMEOUT = null;
    public static final /* synthetic */ ExitClickSpeakerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExitClickSpeakerType> getEntries() {
        return b;
    }

    static {
        ExitClickSpeakerType r0 = new ExitClickSpeakerType("ASR_END", 0);
        ASR_END = r0;
        ExitClickSpeakerType r1 = new ExitClickSpeakerType("TIMEOUT", 1);
        TIMEOUT = r1;
        ExitClickSpeakerType r3 = new ExitClickSpeakerType("MANUAL", 2);
        MANUAL = r3;
        ExitClickSpeakerType r5 = new ExitClickSpeakerType("RESTART", 3);
        RESTART = r5;
        ExitClickSpeakerType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ExitClickSpeakerType[] values() {
        return (ExitClickSpeakerType[]) a.clone();
    }

    public static ExitClickSpeakerType valueOf(String r1) {
        return (ExitClickSpeakerType) a.a(ExitClickSpeakerType.class, r1);
    }

    public ExitClickSpeakerType(String r1, int r2) {
        super(r1, r2);
    }
}
