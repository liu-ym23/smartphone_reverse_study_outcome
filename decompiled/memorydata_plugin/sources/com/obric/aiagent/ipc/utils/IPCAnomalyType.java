package com.obric.aiagent.ipc.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyType;", "", "eventValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventValue", "()Ljava/lang/String;", "FAILURE", "SLOW", "FREQUENT", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum IPCAnomalyType extends Enum<IPCAnomalyType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IPCAnomalyType[] $VALUES = null;
    public static final IPCAnomalyType FAILURE = null;
    public static final IPCAnomalyType FREQUENT = null;
    public static final IPCAnomalyType SLOW = null;
    private final String eventValue;

    private static final /* synthetic */ IPCAnomalyType[] $values() {
        return new IPCAnomalyType[]{FAILURE, SLOW, FREQUENT};
    }

    static {
        FAILURE = new IPCAnomalyType("FAILURE", 0, "failure");
        SLOW = new IPCAnomalyType("SLOW", 1, "slow");
        FREQUENT = new IPCAnomalyType("FREQUENT", 2, "frequent");
        IPCAnomalyType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private IPCAnomalyType(String r1, int r2, String r3) {
        super(r1, r2);
        this.eventValue = r3;
    }

    public static EnumEntries<IPCAnomalyType> getEntries() {
        return $ENTRIES;
    }

    public static IPCAnomalyType valueOf(String r2) {
        return (IPCAnomalyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(IPCAnomalyType.class, r2), IPCAnomalyType.class, "com.obric.memorydata.plugin");
    }

    public static IPCAnomalyType[] values() {
        return (IPCAnomalyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IPCAnomalyType[].class, "com.obric.memorydata.plugin");
    }

    public final String getEventValue() {
        return this.eventValue;
    }
}
