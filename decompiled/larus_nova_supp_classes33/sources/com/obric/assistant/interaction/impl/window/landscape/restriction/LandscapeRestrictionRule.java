package com.obric.assistant.interaction.impl.window.landscape.restriction;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\nH&J$\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J,\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionRule;", "", "ruleId", "", "getRuleId", "()Ljava/lang/String;", "matchesDialogFragmentShow", "", "tag", "operation", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "fragment", "Landroidx/fragment/app/Fragment;", "isDialogFragmentOperationAllowed", "matchesFragmentTransaction", "containerViewId", "", "isFragmentOperationAllowed", "isDialogOperationAllowed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LandscapeRestrictionRule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isDialogOperationAllowed(LandscapeRestrictionRule r0, LandscapeRestrictionOperation r1) {
            Intrinsics.checkNotNullParameter(r1, "operation");
            return false;
        }

        public static boolean isFragmentOperationAllowed(LandscapeRestrictionRule r0, LandscapeRestrictionOperation r1) {
            Intrinsics.checkNotNullParameter(r1, "operation");
            return false;
        }

        public static boolean matchesFragmentTransaction(LandscapeRestrictionRule r0, Fragment r1, String r2, int r3, LandscapeRestrictionOperation r4) {
            Intrinsics.checkNotNullParameter(r4, "operation");
            return false;
        }

        public static boolean matchesDialogFragmentShow(LandscapeRestrictionRule r0, Fragment r1, String r2, LandscapeRestrictionOperation r3) {
            Intrinsics.checkNotNullParameter(r3, "operation");
            return r0.matchesDialogFragmentShow(r2, r3);
        }
    }

    String getRuleId();

    boolean isDialogFragmentOperationAllowed(LandscapeRestrictionOperation r1);

    boolean isDialogOperationAllowed(LandscapeRestrictionOperation r1);

    boolean isFragmentOperationAllowed(LandscapeRestrictionOperation r1);

    boolean matchesDialogFragmentShow(Fragment r1, String r2, LandscapeRestrictionOperation r3);

    boolean matchesDialogFragmentShow(String r1, LandscapeRestrictionOperation r2);

    boolean matchesFragmentTransaction(Fragment r1, String r2, int r3, LandscapeRestrictionOperation r4);
}
