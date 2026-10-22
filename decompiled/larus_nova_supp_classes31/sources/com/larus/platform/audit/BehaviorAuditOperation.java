package com.larus.platform.audit;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/audit/BehaviorAuditOperation;", "", "<init>", "(Ljava/lang/String;I)V", "COPY", "DOWNLOAD", "SHARE_TO_THIRD_PARTY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum BehaviorAuditOperation extends Enum<BehaviorAuditOperation> {
    public static final BehaviorAuditOperation COPY = null;
    public static final BehaviorAuditOperation DOWNLOAD = null;
    public static final BehaviorAuditOperation SHARE_TO_THIRD_PARTY = null;
    public static final /* synthetic */ BehaviorAuditOperation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BehaviorAuditOperation> getEntries() {
        return b;
    }

    static {
        BehaviorAuditOperation r0 = new BehaviorAuditOperation("COPY", 0);
        COPY = r0;
        BehaviorAuditOperation r1 = new BehaviorAuditOperation("DOWNLOAD", 1);
        DOWNLOAD = r1;
        BehaviorAuditOperation r3 = new BehaviorAuditOperation("SHARE_TO_THIRD_PARTY", 2);
        SHARE_TO_THIRD_PARTY = r3;
        BehaviorAuditOperation[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BehaviorAuditOperation[] values() {
        return (BehaviorAuditOperation[]) a.clone();
    }

    public static BehaviorAuditOperation valueOf(String r1) {
        return (BehaviorAuditOperation) r27.a.a(BehaviorAuditOperation.class, r1);
    }

    public BehaviorAuditOperation(String r1, int r2) {
        super(r1, r2);
    }
}
