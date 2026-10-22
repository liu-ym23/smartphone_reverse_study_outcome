package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/trace/GlobalAudioErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SDK", "HOST", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum GlobalAudioErrorType extends Enum<GlobalAudioErrorType> {
    public static final GlobalAudioErrorType HOST = null;
    public static final GlobalAudioErrorType SDK = null;
    public static final /* synthetic */ GlobalAudioErrorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<GlobalAudioErrorType> getEntries() {
        return b;
    }

    static {
        GlobalAudioErrorType r0 = new GlobalAudioErrorType("SDK", 0, "sdk");
        SDK = r0;
        GlobalAudioErrorType r1 = new GlobalAudioErrorType("HOST", 1, "host");
        HOST = r1;
        GlobalAudioErrorType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static GlobalAudioErrorType[] values() {
        return (GlobalAudioErrorType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static GlobalAudioErrorType valueOf(String r1) {
        return (GlobalAudioErrorType) a.a(GlobalAudioErrorType.class, r1);
    }

    public GlobalAudioErrorType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
