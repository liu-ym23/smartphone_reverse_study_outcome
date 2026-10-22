package com.obric.aiproactive.impl.livecard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/LockScreenDetachReason;", "", "<init>", "(Ljava/lang/String;I)V", "PROCESSED", "DETAIL_OPEN", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LockScreenDetachReason extends Enum<LockScreenDetachReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LockScreenDetachReason[] $VALUES = null;
    public static final LockScreenDetachReason DETAIL_OPEN = null;
    public static final LockScreenDetachReason PROCESSED = null;

    private static final /* synthetic */ LockScreenDetachReason[] $values() {
        return new LockScreenDetachReason[]{PROCESSED, DETAIL_OPEN};
    }

    static {
        PROCESSED = new LockScreenDetachReason("PROCESSED", 0);
        DETAIL_OPEN = new LockScreenDetachReason("DETAIL_OPEN", 1);
        LockScreenDetachReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private LockScreenDetachReason(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<LockScreenDetachReason> getEntries() {
        return $ENTRIES;
    }

    public static LockScreenDetachReason valueOf(String r2) {
        return (LockScreenDetachReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(LockScreenDetachReason.class, r2), LockScreenDetachReason.class, "com.obric.memorydata.plugin");
    }

    public static LockScreenDetachReason[] values() {
        return (LockScreenDetachReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LockScreenDetachReason[].class, "com.obric.memorydata.plugin");
    }
}
