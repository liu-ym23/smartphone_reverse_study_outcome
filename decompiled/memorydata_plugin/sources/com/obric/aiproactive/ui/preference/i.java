package com.obric.aiproactive.ui.preference;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J&\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005J \u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u0005J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewLogic;", "", "<init>", "()V", "OTHER_INPUT_MAX_LENGTH", "", "canHandleUserNavigation", "", "isCompleting", "canProceedFromPage", "state", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewState;", "pageIndex", "primaryActionText", "", "pageCount", "isGeneratedRuleWriteSuccessful", "requestedRuleCount", "insertedRuleCount", "(ILjava/lang/Integer;)Z", "resolvePrimaryButtonBottomMargin", "navBottom", "imeBottom", "baseBottom", "resolveScrollableContentBottomPadding", "primaryButtonHeight", "primaryButtonBottomMargin", "safetyMargin", "resolveKeyboardContentLift", "focusedBottomWithoutLift", "keyboardTop", "maxLift", "validatePageInputs", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInputValidationResult;", XSDatatype.FACET_MAXLENGTH, "isOptionalGuidedInputValid", "input", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f6773a = null;

    static {
        f6773a = new i();
    }

    private i() {
    }

    public static /* synthetic */ e a(i r0, j r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 100;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final int a(int r1, int r2, int r3) {
        return r1 + r3;
    }

    public final int a(int r1, int r2, int r3, int r4) {
        return RangesKt.coerceIn((r1 + r3) - r2, 0, RangesKt.coerceAtLeast(r4, 0));
    }

    public final e a(j r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "state");
        o r6 = (o) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r7.a(), r8), o.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L19;
        m r3 = (m) ZeusTransformUtils.preCheckCast(r10.next(), m.class, "com.obric.memorydata.plugin");
        if (r7.c(r3.a()) == false) goto L8;
        if (r3.f() == false) goto L8;
        if (f6773a.a(r7.d(r3.a()), r9) == true) goto L8;
        return new e(false, r3.a());
    L19:
        return new e(true, null, 2, null);
    L5:
        return new e(false, null, 2, null);
    }

    public final String a(int r1, int r2) {
        if (r1 < (r2 - 1)) goto L5;
        return "完成";
    L5:
        return "下一页";
    }

    public final boolean a(int r1, Integer r2) {
        if (r1 == 0) goto L9;
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.intValue() != r1) goto L8;
    L9:
        return true;
    }

    public final boolean a(j r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "state");
        return a(this, r8, r9, 0, 4, null).a();
    }

    public final boolean a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L9;
        return true;
    L9:
        if (r3.length() <= r5) goto L11;
        return false;
    L11:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r8 = 0;
    L13:
        if (r8 >= r7.length()) goto L19;
        if (Character.isLetter(r7.charAt(r8)) == true) goto L22;
        r8 = r8 + 1;
        goto L13
    L22:
        return true;
    L19:
        return false;
    L5:
        r6 = false;
        goto L6
    }

    public final boolean a(boolean r1) {
        return !r1;
    }

    public final int b(int r1, int r2, int r3) {
        return (RangesKt.coerceAtLeast(r1, 0) + RangesKt.coerceAtLeast(r2, 0)) + RangesKt.coerceAtLeast(r3, 0);
    }
}
