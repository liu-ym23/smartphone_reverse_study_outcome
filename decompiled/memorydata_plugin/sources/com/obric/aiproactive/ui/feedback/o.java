package com.obric.aiproactive.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000\u001a\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0000\u001a`\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001b2\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e0\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e0\u001bH\u0000\u001a\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0014\u0010!\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"PROACTIVE_VALUE_PRESETS", "", "Lcom/obric/aiproactive/ui/feedback/ProactiveValuePreset;", "getPROACTIVE_VALUE_PRESETS", "()Ljava/util/List;", "parseCustomValueAmount", "", "raw", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "formatValueAmount", "amount", "sourceForValueAmount", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueAmountSource;", "isQuickValueAmount", "", "resolveValueQuickSelection", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueQuickSelection;", "rating", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRating;", "resolveValueSubmitType", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueSubmitType;", "existing", "submitValueRating", "trigger", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueSubmissionTrigger;", "persist", "Lkotlin/Function1;", "track", "Lkotlin/Function2;", "", "report", "encodeValueRating", "decodeValueRating", "CUSTOM_AMOUNT_REGEX", "Lkotlin/text/Regex;", "MIN_AMOUNT", "MIN_POSITIVE_CUSTOM_AMOUNT", "MAX_AMOUNT", "INVALID_AMOUNT", "KEY_AMOUNT", "KEY_AMOUNT_SOURCE", "KEY_TARGET_TYPE", "KEY_UPDATED_AT", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<i> f6674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f6675b = null;

    static {
        f6674a = CollectionsKt.listOf(new i[]{new i(0, "¥0"), new i(1, "¥1"), new i(5, "¥5"), new i(10, "¥10"), new i(20, "¥20")});
        f6675b = new Regex("[1-9]\\d{0,3}");
    }

    public static final ProactiveValueQuickSelection a(j r3) {
        Integer r0 = null;
        if (r3 == null) goto L5;
        ProactiveValueAmountSource r1 = r3.b();
    L7:
        if (r1 == ProactiveValueAmountSource.CUSTOM) goto L9;
        if (r3 == null) goto L12;
        r0 = Integer.valueOf(r3.a());
    L12:
        if (r0 != null) goto L15;
        return ProactiveValueQuickSelection.NONE;
    L15:
        if (r0.intValue() != 0) goto L18;
        return ProactiveValueQuickSelection.ZERO;
    L18:
        if (r0.intValue() != 1) goto L21;
        return ProactiveValueQuickSelection.ONE;
    L21:
        if (r0.intValue() != 5) goto L24;
        return ProactiveValueQuickSelection.FIVE;
    L24:
        if (r0.intValue() != 10) goto L27;
        return ProactiveValueQuickSelection.TEN;
    L27:
        if (r0.intValue() != 20) goto L30;
        return ProactiveValueQuickSelection.TWENTY;
    L30:
        return ProactiveValueQuickSelection.OTHER;
    L9:
        return ProactiveValueQuickSelection.OTHER;
    L5:
        r1 = null;
        goto L7
    }

    public static final ProactiveValueSubmitType a(ProactiveValueSubmissionTrigger r4, j r5, Function1<? super j, ? extends ProactiveValueSubmitType> r6, Function2<? super j, ? super ProactiveValueSubmitType, Unit> r7, Function1<? super j, Unit> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "trigger");
        Intrinsics.checkNotNullParameter(r9, "persist");
        Intrinsics.checkNotNullParameter(r10, "track");
        Intrinsics.checkNotNullParameter(r11, "report");
        if (r4 == ProactiveValueSubmissionTrigger.USER_SUBMIT) goto L5;
        return null;
    L5:
        if (r5 == null) goto L21;
        int r12 = r5.a();
        boolean r0 = false;
        if (r12 >= 0) goto L9;
    L11:
        if (r0 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L21;
        ProactiveValueSubmitType r13 = (ProactiveValueSubmitType) ZeusTransformUtils.preCheckCast(r9.invoke(r5), ProactiveValueSubmitType.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L19;
        return null;
    L19:
        r10.invoke(r5, r13);
        r11.invoke(r5);
        return r13;
    L9:
        if (r12 >= 10000) goto L11;
        r0 = true;
    L21:
        return null;
    }

    public static final Integer a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (f6675b.matches((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        return null;
    L5:
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L15;
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
        boolean r1 = false;
        if (1 <= r0) goto L10;
    L12:
        if (r1 == true) goto L14;
        return null;
    L14:
        return r7;
    L10:
        if (r0 >= 10000) goto L12;
        r1 = true;
        goto L12
    L15:
        return null;
    }

    public static final String a(int r0) {
        return String.valueOf(r0);
    }

    public static final ProactiveValueSubmitType b(j r0) {
        if (r0 != null) goto L5;
        return ProactiveValueSubmitType.CREATE;
    L5:
        return ProactiveValueSubmitType.UPDATE;
    }

    public static final j b(String r11) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L38;
        return null;
    L38:
        JSONObject r3 = new JSONObject(r11);     // Catch: JSONException -> L37
        int r6 = r3.optInt("amount", -1);     // Catch: JSONException -> L37
        if (r6 >= 0) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == true) goto L20;
        return null;
    L20:
        String r12 = r3.optString("amount_source");     // Catch: JSONException -> L37
        if (Intrinsics.areEqual(r12, ProactiveValueAmountSource.PRESET.getWireValue()) == false) goto L25;
        ProactiveValueAmountSource r13 = ProactiveValueAmountSource.PRESET;     // Catch: JSONException -> L37
    L23:
        ProactiveValueAmountSource r7 = r13;
        String r14 = r3.optString("target_type");     // Catch: JSONException -> L37
        if (Intrinsics.areEqual(r14, ProactiveValueTargetType.SUGGESTION.getWireValue()) == false) goto L32;
        ProactiveValueTargetType r15 = ProactiveValueTargetType.SUGGESTION;     // Catch: JSONException -> L37
    L34:
        return new j(r6, r7, r15, RangesKt.coerceAtLeast(r3.optLong("updated_at", 0), 0));
    L32:
        if (Intrinsics.areEqual(r14, ProactiveValueTargetType.ACTION_RESULT.getWireValue()) == false) goto L41;
        r15 = ProactiveValueTargetType.ACTION_RESULT;     // Catch: JSONException -> L37
        goto L34
    L41:
        return null;
    L25:
        if (Intrinsics.areEqual(r12, ProactiveValueAmountSource.CUSTOM.getWireValue()) == false) goto L40;
        r13 = ProactiveValueAmountSource.CUSTOM;     // Catch: JSONException -> L37
        goto L23
    L40:
        return null;
    L15:
        if (r6 >= 10000) goto L17;
    L42:
        return null;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L10
    }

    public static final String c(j r3) {
        Intrinsics.checkNotNullParameter(r3, "rating");
        String r4 = new JSONObject().put("amount", r3.a()).put("amount_source", r3.b().getWireValue()).put("target_type", r3.c().getWireValue()).put("updated_at", r3.d()).toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return r4;
    }
}
