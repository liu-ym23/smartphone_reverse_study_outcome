package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/utils/FormatSource;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TTS", "COPY", "REALTIME_CALL_SUBTITLE", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FormatSource extends Enum<FormatSource> {
    public static final FormatSource COPY = null;
    public static final FormatSource REALTIME_CALL_SUBTITLE = null;
    public static final FormatSource TTS = null;
    public static final FormatSource UNKNOWN = null;
    public static final /* synthetic */ FormatSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FormatSource> getEntries() {
        return b;
    }

    static {
        FormatSource r0 = new FormatSource("UNKNOWN", 0);
        UNKNOWN = r0;
        FormatSource r1 = new FormatSource("TTS", 1);
        TTS = r1;
        FormatSource r3 = new FormatSource("COPY", 2);
        COPY = r3;
        FormatSource r5 = new FormatSource("REALTIME_CALL_SUBTITLE", 3);
        REALTIME_CALL_SUBTITLE = r5;
        FormatSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static FormatSource[] values() {
        return (FormatSource[]) a.clone();
    }

    public static FormatSource valueOf(String r1) {
        return (FormatSource) r27.a.a(FormatSource.class, r1);
    }

    public FormatSource(String r1, int r2) {
        super(r1, r2);
    }
}
