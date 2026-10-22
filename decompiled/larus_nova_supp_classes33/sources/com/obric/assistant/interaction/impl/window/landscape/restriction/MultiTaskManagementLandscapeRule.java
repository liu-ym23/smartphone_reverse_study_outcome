package com.obric.assistant.interaction.impl.window.landscape.restriction;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/MultiTaskManagementLandscapeRule;", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionRule;", "<init>", "()V", "ruleId", "", "getRuleId", "()Ljava/lang/String;", "TAG", "matchesDialogFragmentShow", "", "tag", "operation", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "isDialogFragmentOperationAllowed", "isDialogOperationAllowed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskManagementLandscapeRule implements LandscapeRestrictionRule {
    public static final MultiTaskManagementLandscapeRule INSTANCE = null;
    private static final String TAG = "multi_task_management";
    private static final String ruleId = null;

    private MultiTaskManagementLandscapeRule() {
    }

    static {
        INSTANCE = new MultiTaskManagementLandscapeRule();
        ruleId = TAG;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public String getRuleId() {
        return ruleId;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean isDialogFragmentOperationAllowed(LandscapeRestrictionOperation r2) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        if (r2.isDialogFragmentShowOperation() == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD) goto L8;
        return false;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean isDialogOperationAllowed(LandscapeRestrictionOperation r2) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        if (r2 != LandscapeRestrictionOperation.DIALOG_SHOW) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean isFragmentOperationAllowed(LandscapeRestrictionOperation r1) {
        return LandscapeRestrictionRule.DefaultImpls.isFragmentOperationAllowed(this, r1);
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesDialogFragmentShow(String r2, LandscapeRestrictionOperation r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        if (r3.isDialogFragmentShowOperation() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2, TAG) == false) goto L7;
        return true;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesDialogFragmentShow(Fragment r1, String r2, LandscapeRestrictionOperation r3) {
        return LandscapeRestrictionRule.DefaultImpls.matchesDialogFragmentShow(this, r1, r2, r3);
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesFragmentTransaction(Fragment r1, String r2, int r3, LandscapeRestrictionOperation r4) {
        return LandscapeRestrictionRule.DefaultImpls.matchesFragmentTransaction(this, r1, r2, r3, r4);
    }
}
