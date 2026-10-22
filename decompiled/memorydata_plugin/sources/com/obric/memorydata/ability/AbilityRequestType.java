package com.obric.memorydata.ability;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/AbilityRequestType;", "", "<init>", "(Ljava/lang/String;I)V", "QUERY", "SUBSCRIBE", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AbilityRequestType extends Enum<AbilityRequestType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AbilityRequestType[] $VALUES = null;
    public static final AbilityRequestType QUERY = null;
    public static final AbilityRequestType SUBSCRIBE = null;

    private static final /* synthetic */ AbilityRequestType[] $values() {
        return new AbilityRequestType[]{QUERY, SUBSCRIBE};
    }

    static {
        QUERY = new AbilityRequestType("QUERY", 0);
        SUBSCRIBE = new AbilityRequestType("SUBSCRIBE", 1);
        AbilityRequestType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AbilityRequestType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AbilityRequestType> getEntries() {
        return $ENTRIES;
    }

    public static AbilityRequestType valueOf(String r2) {
        return (AbilityRequestType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AbilityRequestType.class, r2), AbilityRequestType.class, "com.obric.memorydata.plugin");
    }

    public static AbilityRequestType[] values() {
        return (AbilityRequestType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AbilityRequestType[].class, "com.obric.memorydata.plugin");
    }
}
