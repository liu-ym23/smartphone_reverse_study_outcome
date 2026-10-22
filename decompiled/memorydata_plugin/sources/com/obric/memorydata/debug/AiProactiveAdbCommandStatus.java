package com.obric.memorydata.debug;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/debug/AiProactiveAdbCommandStatus;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAILURE", "UNSUPPORTED", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AiProactiveAdbCommandStatus extends Enum<AiProactiveAdbCommandStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AiProactiveAdbCommandStatus[] $VALUES = null;
    public static final AiProactiveAdbCommandStatus FAILURE = null;
    public static final AiProactiveAdbCommandStatus SUCCESS = null;
    public static final AiProactiveAdbCommandStatus UNSUPPORTED = null;
    private final String value;

    private static final /* synthetic */ AiProactiveAdbCommandStatus[] $values() {
        return new AiProactiveAdbCommandStatus[]{SUCCESS, FAILURE, UNSUPPORTED};
    }

    static {
        SUCCESS = new AiProactiveAdbCommandStatus("SUCCESS", 0, "success");
        FAILURE = new AiProactiveAdbCommandStatus("FAILURE", 1, "failure");
        UNSUPPORTED = new AiProactiveAdbCommandStatus("UNSUPPORTED", 2, "unsupported");
        AiProactiveAdbCommandStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AiProactiveAdbCommandStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<AiProactiveAdbCommandStatus> getEntries() {
        return $ENTRIES;
    }

    public static AiProactiveAdbCommandStatus valueOf(String r2) {
        return (AiProactiveAdbCommandStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AiProactiveAdbCommandStatus.class, r2), AiProactiveAdbCommandStatus.class, "com.obric.memorydata.plugin");
    }

    public static AiProactiveAdbCommandStatus[] values() {
        return (AiProactiveAdbCommandStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AiProactiveAdbCommandStatus[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
