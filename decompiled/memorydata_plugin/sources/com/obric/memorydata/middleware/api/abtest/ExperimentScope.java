package com.obric.memorydata.middleware.api.abtest;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/abtest/ExperimentScope;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$middleware_api_obricRelease", "()Ljava/lang/String;", "DID", "UID", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ExperimentScope extends Enum<ExperimentScope> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ExperimentScope[] $VALUES = null;
    public static final ExperimentScope DID = null;
    public static final ExperimentScope UID = null;
    private final String value;

    private static final /* synthetic */ ExperimentScope[] $values() {
        return new ExperimentScope[]{DID, UID};
    }

    static {
        DID = new ExperimentScope("DID", 0, "did");
        UID = new ExperimentScope("UID", 1, "uid");
        ExperimentScope[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ExperimentScope(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<ExperimentScope> getEntries() {
        return $ENTRIES;
    }

    public static ExperimentScope valueOf(String r2) {
        return (ExperimentScope) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExperimentScope.class, r2), ExperimentScope.class, "com.obric.memorydata.plugin");
    }

    public static ExperimentScope[] values() {
        return (ExperimentScope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExperimentScope[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue$middleware_api_obricRelease() {
        return this.value;
    }
}
