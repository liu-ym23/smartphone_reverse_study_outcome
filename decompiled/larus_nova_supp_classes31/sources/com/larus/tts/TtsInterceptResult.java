package com.larus.tts;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/tts/TtsInterceptResult;", "", "<init>", "(Ljava/lang/String;I)V", "Pass", "Deny", "ForcePlay", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TtsInterceptResult extends Enum<TtsInterceptResult> {
    public static final TtsInterceptResult Deny = null;
    public static final TtsInterceptResult ForcePlay = null;
    public static final TtsInterceptResult Pass = null;
    public static final /* synthetic */ TtsInterceptResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TtsInterceptResult> getEntries() {
        return b;
    }

    static {
        TtsInterceptResult r0 = new TtsInterceptResult("Pass", 0);
        Pass = r0;
        TtsInterceptResult r1 = new TtsInterceptResult("Deny", 1);
        Deny = r1;
        TtsInterceptResult r3 = new TtsInterceptResult("ForcePlay", 2);
        ForcePlay = r3;
        TtsInterceptResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TtsInterceptResult[] values() {
        return (TtsInterceptResult[]) a.clone();
    }

    public static TtsInterceptResult valueOf(String r1) {
        return (TtsInterceptResult) a.a(TtsInterceptResult.class, r1);
    }

    public TtsInterceptResult(String r1, int r2) {
        super(r1, r2);
    }
}
