package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/MatchType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ACCURATE_MATCH", "SYNONYM_MATCH", "HOMONYM_MATCH", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MatchType extends Enum<MatchType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MatchType[] $VALUES = null;
    public static final MatchType ACCURATE_MATCH = null;
    public static final MatchType HOMONYM_MATCH = null;
    public static final MatchType SYNONYM_MATCH = null;
    private final int value;

    private static final /* synthetic */ MatchType[] $values() {
        return new MatchType[]{ACCURATE_MATCH, SYNONYM_MATCH, HOMONYM_MATCH};
    }

    static {
        ACCURATE_MATCH = new MatchType("ACCURATE_MATCH", 0, 1);
        SYNONYM_MATCH = new MatchType("SYNONYM_MATCH", 1, 2);
        HOMONYM_MATCH = new MatchType("HOMONYM_MATCH", 2, 3);
        MatchType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MatchType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<MatchType> getEntries() {
        return $ENTRIES;
    }

    public static MatchType valueOf(String r2) {
        return (MatchType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MatchType.class, r2), MatchType.class, "com.obric.memorydata.plugin");
    }

    public static MatchType[] values() {
        return (MatchType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MatchType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
