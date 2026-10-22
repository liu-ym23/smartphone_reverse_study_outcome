package com.obric.memorydata.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryCollectionScheme;", "", "<init>", "(Ljava/lang/String;I)V", "IN_APP", "ACCESSIBILITY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AutoMemoryCollectionScheme extends Enum<AutoMemoryCollectionScheme> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AutoMemoryCollectionScheme[] $VALUES = null;
    public static final AutoMemoryCollectionScheme ACCESSIBILITY = null;
    public static final AutoMemoryCollectionScheme IN_APP = null;

    private static final /* synthetic */ AutoMemoryCollectionScheme[] $values() {
        return new AutoMemoryCollectionScheme[]{IN_APP, ACCESSIBILITY};
    }

    static {
        IN_APP = new AutoMemoryCollectionScheme("IN_APP", 0);
        ACCESSIBILITY = new AutoMemoryCollectionScheme("ACCESSIBILITY", 1);
        AutoMemoryCollectionScheme[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AutoMemoryCollectionScheme(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AutoMemoryCollectionScheme> getEntries() {
        return $ENTRIES;
    }

    public static AutoMemoryCollectionScheme valueOf(String r2) {
        return (AutoMemoryCollectionScheme) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutoMemoryCollectionScheme.class, r2), AutoMemoryCollectionScheme.class, "com.obric.memorydata.plugin");
    }

    public static AutoMemoryCollectionScheme[] values() {
        return (AutoMemoryCollectionScheme[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutoMemoryCollectionScheme[].class, "com.obric.memorydata.plugin");
    }
}
