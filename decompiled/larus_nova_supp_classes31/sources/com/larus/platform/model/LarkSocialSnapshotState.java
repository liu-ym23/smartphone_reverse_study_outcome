package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/LarkSocialSnapshotState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "READY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum LarkSocialSnapshotState extends Enum<LarkSocialSnapshotState> {
    public static final LarkSocialSnapshotState READY = null;
    public static final LarkSocialSnapshotState UNKNOWN = null;
    public static final /* synthetic */ LarkSocialSnapshotState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LarkSocialSnapshotState> getEntries() {
        return b;
    }

    static {
        LarkSocialSnapshotState r0 = new LarkSocialSnapshotState("UNKNOWN", 0);
        UNKNOWN = r0;
        LarkSocialSnapshotState r1 = new LarkSocialSnapshotState("READY", 1);
        READY = r1;
        LarkSocialSnapshotState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static LarkSocialSnapshotState[] values() {
        return (LarkSocialSnapshotState[]) a.clone();
    }

    public static LarkSocialSnapshotState valueOf(String r1) {
        return (LarkSocialSnapshotState) a.a(LarkSocialSnapshotState.class, r1);
    }

    public LarkSocialSnapshotState(String r1, int r2) {
        super(r1, r2);
    }
}
