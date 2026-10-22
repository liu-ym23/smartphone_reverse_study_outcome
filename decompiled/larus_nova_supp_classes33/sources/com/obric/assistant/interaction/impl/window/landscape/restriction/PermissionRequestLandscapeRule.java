package com.obric.assistant.interaction.impl.window.landscape.restriction;

import androidx.fragment.app.Fragment;
import com.larus.permission.api.IPermissionX;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/PermissionRequestLandscapeRule;", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionRule;", "<init>", "()V", "ruleId", "", "getRuleId", "()Ljava/lang/String;", "matchesDialogFragmentShow", "", "tag", "operation", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "fragment", "Landroidx/fragment/app/Fragment;", "isDialogFragmentOperationAllowed", "isDialogOperationAllowed", "isExplainRequestDialog", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionRequestLandscapeRule implements LandscapeRestrictionRule {
    public static final PermissionRequestLandscapeRule INSTANCE = null;
    private static final String ruleId = null;

    private PermissionRequestLandscapeRule() {
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesDialogFragmentShow(String r1, LandscapeRestrictionOperation r2) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        return false;
    }

    static {
        INSTANCE = new PermissionRequestLandscapeRule();
        ruleId = "permission_request";
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public String getRuleId() {
        return ruleId;
    }

    private final boolean isExplainRequestDialog(Fragment r3) {
        if (r3 != null) goto L14;
        return false;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Boolean.valueOf(IPermissionX.a.k(r3)));     // Catch: Throwable -> L7
    L9:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = r1;
    L13:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
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
    public boolean matchesDialogFragmentShow(Fragment r1, String r2, LandscapeRestrictionOperation r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        if (r3.isDialogFragmentShowOperation() == true) goto L5;
    L7:
        return false;
    L5:
        if (isExplainRequestDialog(r1) == false) goto L7;
        return true;
    }

    @Override // com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionRule
    public boolean matchesFragmentTransaction(Fragment r1, String r2, int r3, LandscapeRestrictionOperation r4) {
        return LandscapeRestrictionRule.DefaultImpls.matchesFragmentTransaction(this, r1, r2, r3, r4);
    }
}
