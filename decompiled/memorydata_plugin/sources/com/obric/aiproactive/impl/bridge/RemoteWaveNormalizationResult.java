package com.obric.aiproactive.impl.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizationResult;", "", "<init>", "(Ljava/lang/String;I)V", "VALID", "INVALID", "IO_FAILURE", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RemoteWaveNormalizationResult extends Enum<RemoteWaveNormalizationResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RemoteWaveNormalizationResult[] $VALUES = null;
    public static final RemoteWaveNormalizationResult INVALID = null;
    public static final RemoteWaveNormalizationResult IO_FAILURE = null;
    public static final RemoteWaveNormalizationResult VALID = null;

    private static final /* synthetic */ RemoteWaveNormalizationResult[] $values() {
        return new RemoteWaveNormalizationResult[]{VALID, INVALID, IO_FAILURE};
    }

    static {
        VALID = new RemoteWaveNormalizationResult("VALID", 0);
        INVALID = new RemoteWaveNormalizationResult("INVALID", 1);
        IO_FAILURE = new RemoteWaveNormalizationResult("IO_FAILURE", 2);
        RemoteWaveNormalizationResult[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private RemoteWaveNormalizationResult(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<RemoteWaveNormalizationResult> getEntries() {
        return $ENTRIES;
    }

    public static RemoteWaveNormalizationResult valueOf(String r2) {
        return (RemoteWaveNormalizationResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(RemoteWaveNormalizationResult.class, r2), RemoteWaveNormalizationResult.class, "com.obric.memorydata.plugin");
    }

    public static RemoteWaveNormalizationResult[] values() {
        return (RemoteWaveNormalizationResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RemoteWaveNormalizationResult[].class, "com.obric.memorydata.plugin");
    }
}
