package com.obric.aiproactive.ui.preference;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u001a\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0012\u001a\u00020\u0001H\u0000\u001a.\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0001H\u0000¨\u0006\u0018"}, d2 = {"resolveNavigationInsetBottom", "", "navigationBarsBottom", "tappableElementBottom", "systemBarsBottom", "threeButtonFallbackBottom", "resolveNavigationInsetSpacerHeight", "navigationInset", "buildRuleEditorOutsideActions", "", "Lcom/obric/aiproactive/ui/preference/RuleEditorOutsideAction;", "inputText", "", "buildRuleEditorCancelActions", "buildRuleEditorConfirmActions", "shouldHandleRuleEditorOutsideTouchAction", "", "action", "buildRuleEditorSoftInputMode", "canSubmitRuleInput", "input", "initialContent", "requireContentChanged", XSDatatype.FACET_MAXLENGTH, "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final int a(int r1) {
        return RangesKt.coerceAtLeast(r1, 0);
    }

    public static final int a(int r2, int r3, int r4, int r5) {
        return RangesKt.coerceAtLeast(ComparisonsKt.maxOf(r2, new int[]{r3, r4, r5}), 0);
    }

    public static final List<RuleEditorOutsideAction> a() {
        return CollectionsKt.listOf(new RuleEditorOutsideAction[]{RuleEditorOutsideAction.HideIme, RuleEditorOutsideAction.DelayDismiss});
    }

    public static final List<RuleEditorOutsideAction> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "inputText");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        return CollectionsKt.listOf(new RuleEditorOutsideAction[]{RuleEditorOutsideAction.HideIme, RuleEditorOutsideAction.DelayDismiss});
    L9:
        return CollectionsKt.listOf(RuleEditorOutsideAction.HideIme);
    L5:
        r4 = false;
        goto L6
    }

    public static final boolean a(String r3, String r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "input");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 == null) goto L5;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
    L20:
        return false;
    L14:
        if (r7.length() > r6) goto L20;
        if (r5 == true) goto L19;
        return true;
    L19:
        return !Intrinsics.areEqual(r7, r8);
    L11:
        r0 = false;
        goto L12
    L5:
        r8 = null;
        goto L6
    }

    public static final List<RuleEditorOutsideAction> b() {
        return CollectionsKt.listOf(new RuleEditorOutsideAction[]{RuleEditorOutsideAction.HideIme, RuleEditorOutsideAction.DelayDismiss, RuleEditorOutsideAction.ReloadDataAfterDismiss});
    }

    public static final boolean b(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    public static final int c() {
        return 20;
    }
}
