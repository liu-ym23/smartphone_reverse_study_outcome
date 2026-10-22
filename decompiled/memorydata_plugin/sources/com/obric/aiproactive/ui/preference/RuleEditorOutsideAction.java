package com.obric.aiproactive.ui.preference;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/preference/RuleEditorOutsideAction;", "", "<init>", "(Ljava/lang/String;I)V", "HideIme", "DelayDismiss", "ReloadDataAfterDismiss", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RuleEditorOutsideAction extends Enum<RuleEditorOutsideAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RuleEditorOutsideAction[] $VALUES = null;
    public static final RuleEditorOutsideAction DelayDismiss = null;
    public static final RuleEditorOutsideAction HideIme = null;
    public static final RuleEditorOutsideAction ReloadDataAfterDismiss = null;

    private static final /* synthetic */ RuleEditorOutsideAction[] $values() {
        return new RuleEditorOutsideAction[]{HideIme, DelayDismiss, ReloadDataAfterDismiss};
    }

    static {
        HideIme = new RuleEditorOutsideAction("HideIme", 0);
        DelayDismiss = new RuleEditorOutsideAction("DelayDismiss", 1);
        ReloadDataAfterDismiss = new RuleEditorOutsideAction("ReloadDataAfterDismiss", 2);
        RuleEditorOutsideAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private RuleEditorOutsideAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<RuleEditorOutsideAction> getEntries() {
        return $ENTRIES;
    }

    public static RuleEditorOutsideAction valueOf(String r2) {
        return (RuleEditorOutsideAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(RuleEditorOutsideAction.class, r2), RuleEditorOutsideAction.class, "com.obric.memorydata.plugin");
    }

    public static RuleEditorOutsideAction[] values() {
        return (RuleEditorOutsideAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RuleEditorOutsideAction[].class, "com.obric.memorydata.plugin");
    }
}
