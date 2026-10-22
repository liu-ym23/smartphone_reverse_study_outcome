package com.obric.aiproactive.ui.feedback;

import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueSubmitType;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "CREATE", "UPDATE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveValueSubmitType extends Enum<ProactiveValueSubmitType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveValueSubmitType[] $VALUES = null;
    public static final ProactiveValueSubmitType CREATE = null;
    public static final ProactiveValueSubmitType UPDATE = null;
    private final String wireValue;

    private static final /* synthetic */ ProactiveValueSubmitType[] $values() {
        return new ProactiveValueSubmitType[]{CREATE, UPDATE};
    }

    static {
        CREATE = new ProactiveValueSubmitType("CREATE", 0, "create");
        UPDATE = new ProactiveValueSubmitType("UPDATE", 1, BuildConfig.CHANNEL);
        ProactiveValueSubmitType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveValueSubmitType(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }

    public static EnumEntries<ProactiveValueSubmitType> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveValueSubmitType valueOf(String r2) {
        return (ProactiveValueSubmitType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveValueSubmitType.class, r2), ProactiveValueSubmitType.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveValueSubmitType[] values() {
        return (ProactiveValueSubmitType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveValueSubmitType[].class, "com.obric.memorydata.plugin");
    }

    public final String getWireValue() {
        return this.wireValue;
    }
}
