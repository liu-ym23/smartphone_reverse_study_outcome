package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/MusicOperateResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "REJECT", "CANCEL", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum MusicOperateResult extends Enum<MusicOperateResult> {
    public static final MusicOperateResult CANCEL = null;
    public static final MusicOperateResult REJECT = null;
    public static final MusicOperateResult SUCCESS = null;
    public static final /* synthetic */ MusicOperateResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MusicOperateResult> getEntries() {
        return b;
    }

    static {
        MusicOperateResult r0 = new MusicOperateResult("SUCCESS", 0);
        SUCCESS = r0;
        MusicOperateResult r1 = new MusicOperateResult("REJECT", 1);
        REJECT = r1;
        MusicOperateResult r3 = new MusicOperateResult("CANCEL", 2);
        CANCEL = r3;
        MusicOperateResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MusicOperateResult[] values() {
        return (MusicOperateResult[]) a.clone();
    }

    public static MusicOperateResult valueOf(String r1) {
        return (MusicOperateResult) r27.a.a(MusicOperateResult.class, r1);
    }

    public MusicOperateResult(String r1, int r2) {
        super(r1, r2);
    }
}
