package com.obric.memorydata.personalcontext.search.entity;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/CallMode;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SLM", "FUNCTION_CALL", "IN_APP", "UNKNOWN", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CallMode extends Enum<CallMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CallMode[] $VALUES = null;
    public static final CallMode FUNCTION_CALL = null;
    public static final CallMode IN_APP = null;
    public static final CallMode SLM = null;
    public static final CallMode UNKNOWN = null;
    private final String value;

    private static final /* synthetic */ CallMode[] $values() {
        return new CallMode[]{SLM, FUNCTION_CALL, IN_APP, UNKNOWN};
    }

    static {
        SLM = new CallMode("SLM", 0, "SLM");
        FUNCTION_CALL = new CallMode("FUNCTION_CALL", 1, "function_call");
        IN_APP = new CallMode("IN_APP", 2, "in_app");
        UNKNOWN = new CallMode("UNKNOWN", 3, "unknown");
        CallMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private CallMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<CallMode> getEntries() {
        return $ENTRIES;
    }

    public static CallMode valueOf(String r2) {
        return (CallMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(CallMode.class, r2), CallMode.class, "com.obric.memorydata.plugin");
    }

    public static CallMode[] values() {
        return (CallMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CallMode[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
