package com.obric.aiproactive.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueSubmissionTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "USER_SUBMIT", "INITIALIZE", "RESTORE", "RESELECT", "CANCEL", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveValueSubmissionTrigger extends Enum<ProactiveValueSubmissionTrigger> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveValueSubmissionTrigger[] $VALUES = null;
    public static final ProactiveValueSubmissionTrigger CANCEL = null;
    public static final ProactiveValueSubmissionTrigger INITIALIZE = null;
    public static final ProactiveValueSubmissionTrigger RESELECT = null;
    public static final ProactiveValueSubmissionTrigger RESTORE = null;
    public static final ProactiveValueSubmissionTrigger USER_SUBMIT = null;

    private static final /* synthetic */ ProactiveValueSubmissionTrigger[] $values() {
        return new ProactiveValueSubmissionTrigger[]{USER_SUBMIT, INITIALIZE, RESTORE, RESELECT, CANCEL};
    }

    static {
        USER_SUBMIT = new ProactiveValueSubmissionTrigger("USER_SUBMIT", 0);
        INITIALIZE = new ProactiveValueSubmissionTrigger("INITIALIZE", 1);
        RESTORE = new ProactiveValueSubmissionTrigger("RESTORE", 2);
        RESELECT = new ProactiveValueSubmissionTrigger("RESELECT", 3);
        CANCEL = new ProactiveValueSubmissionTrigger("CANCEL", 4);
        ProactiveValueSubmissionTrigger[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveValueSubmissionTrigger(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProactiveValueSubmissionTrigger> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveValueSubmissionTrigger valueOf(String r2) {
        return (ProactiveValueSubmissionTrigger) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveValueSubmissionTrigger.class, r2), ProactiveValueSubmissionTrigger.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveValueSubmissionTrigger[] values() {
        return (ProactiveValueSubmissionTrigger[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveValueSubmissionTrigger[].class, "com.obric.memorydata.plugin");
    }
}
