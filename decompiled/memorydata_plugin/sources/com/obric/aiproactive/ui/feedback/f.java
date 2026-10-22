package com.obric.aiproactive.ui.feedback;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a \u0010\u000b\u001a\u0004\u0018\u00010\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\u001a\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001e\u0010\u001a\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u001b\u001a\u00020\u0001H\u0000\u001a,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0010H\u0000\u001a$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u001e\u001a\u00020\u0001H\u0000\u001a\u001c\u0010!\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0000\u001a\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0001H\u0000\u001a\n\u0010'\u001a\u0004\u0018\u00010$H\u0002\u001a\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020)2\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0012\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020,H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"TAG", "", "resolveFeedbackInitialInput", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackInitialInput;", "feedbackReason", "feedbackText", "userFeedback", "mode", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackSheet$Mode;", "feedbackAction", "parseLegacyUserFeedback", "collectPrefixedMultilineValue", "lines", "", "key", "isLegacyFeedbackKeyLine", "", "line", "filterReasonForMode", InfoRequestQPSOptTraceLogger.REASON, "parseFeedbackReasons", "encodeFeedbackReasons", "selectedReasons", "isFeedbackActionMismatch", "isActionMarkerLegacyFeedback", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "isFeedbackSubmitEnabled", MemoryListActivity.JUMP_FROM_DETAIL, "nextSelectedReasons", "currentReasons", "clickedReason", "isChecked", "toggleSelectedReason", "buildFeedbackContentSpec", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackContentSpec;", "feedbackConfig", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackSettingsConfig;", "parseProactiveFeedbackSettings", "raw", "loadProactiveFeedbackSettingsConfig", "optStringList", "Lorg/json/JSONObject;", ActivityLifecycle.NAME, "toStringList", "Lorg/json/JSONArray;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6656a = null;

        static {
            int[] r0 = new int[ProactiveFeedbackSheet.Mode.values().length];
            r0[ProactiveFeedbackSheet.Mode.LIKE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ProactiveFeedbackSheet.Mode.DISLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ProactiveFeedbackSheet.Mode.GENERIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f6656a = r0;
        }
    }

    public static final b a(ProactiveFeedbackSheet.Mode r19, e r20) {
        Intrinsics.checkNotNullParameter(r19, "mode");
        int r0 = a.f6656a[r19.ordinal()];
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L8;
        return new b(ZeusTransformUtils.mapRes(R.string.proactive_feedback_title, TypedValues.Custom.S_STRING, "proactive_feedback_title"), ZeusTransformUtils.mapRes(R.string.proactive_feedback_generic_detail_hint, TypedValues.Custom.S_STRING, "proactive_feedback_generic_detail_hint"), CollectionsKt.listOf(new Integer[]{Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_more_missing, TypedValues.Custom.S_STRING, "proactive_feedback_option_more_missing")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_more_frequency, TypedValues.Custom.S_STRING, "proactive_feedback_option_more_frequency")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_more_low_value, TypedValues.Custom.S_STRING, "proactive_feedback_option_more_low_value")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_more_other, TypedValues.Custom.S_STRING, "proactive_feedback_option_more_other"))}), null, null, false, 24, null);
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        int r12 = ZeusTransformUtils.mapRes(R.string.proactive_feedback_dislike_title, TypedValues.Custom.S_STRING, "proactive_feedback_dislike_title");
        int r13 = ZeusTransformUtils.mapRes(R.string.proactive_feedback_dislike_detail_hint, TypedValues.Custom.S_STRING, "proactive_feedback_dislike_detail_hint");
        List r14 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_dislike_wrong_time, TypedValues.Custom.S_STRING, "proactive_feedback_option_dislike_wrong_time")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_dislike_unimportant, TypedValues.Custom.S_STRING, "proactive_feedback_option_dislike_unimportant")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_dislike_similar, TypedValues.Custom.S_STRING, "proactive_feedback_option_dislike_similar")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_dislike_unreasonable, TypedValues.Custom.S_STRING, "proactive_feedback_option_dislike_unreasonable")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_dislike_ineffective, TypedValues.Custom.S_STRING, "proactive_feedback_option_dislike_ineffective")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_dislike_other, TypedValues.Custom.S_STRING, "proactive_feedback_option_dislike_other"))});
        if (r20 == null) goto L12;
        List<String> r1 = r20.b();
    L13:
        if (r1 != null) goto L15;
        r1 = CollectionsKt.emptyList();
    L15:
        List<String> r15 = r1;
        if (r20 == null) goto L22;
        String r2 = r20.c();
        if (r2 == null) goto L22;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L22;
        String r16 = r2;
    L41:
        return new b(r12, r13, r14, r15, r16, true);
    L22:
        r16 = null;
        goto L41
    L12:
        r1 = null;
        goto L13
    L24:
        int r17 = ZeusTransformUtils.mapRes(R.string.proactive_feedback_like_title, TypedValues.Custom.S_STRING, "proactive_feedback_like_title");
        int r18 = ZeusTransformUtils.mapRes(R.string.proactive_feedback_like_detail_hint, TypedValues.Custom.S_STRING, "proactive_feedback_like_detail_hint");
        List r110 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_like_timely, TypedValues.Custom.S_STRING, "proactive_feedback_option_like_timely")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_like_preference, TypedValues.Custom.S_STRING, "proactive_feedback_option_like_preference")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_like_reasonable, TypedValues.Custom.S_STRING, "proactive_feedback_option_like_reasonable")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_like_effective, TypedValues.Custom.S_STRING, "proactive_feedback_option_like_effective")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_feedback_option_like_other, TypedValues.Custom.S_STRING, "proactive_feedback_option_like_other"))});
        if (r20 == null) goto L27;
        List<String> r3 = r20.a();
    L28:
        if (r3 != null) goto L30;
        r3 = CollectionsKt.emptyList();
    L30:
        List<String> r111 = r3;
        if (r20 == null) goto L37;
        String r4 = r20.c();
        if (r4 == null) goto L37;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L37;
        String r112 = r4;
    L39:
        return new b(r17, r18, r110, r111, r112, true);
    L37:
        r112 = null;
        goto L39
    L27:
        r3 = null;
        goto L28
    }

    public static final c a(String r3, String r4, String r5, ProactiveFeedbackSheet.Mode r6, String r7) {
        String r0 = null;
        if (a(r6, r7) == true) goto L5;
        List<String> r8 = a(r3, r6);
        if (r4 == null) goto L19;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r9 == null) goto L19;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L19;
        r0 = r9;
        goto L19
    L13:
        if (c(r9) == true) goto L15;
        r2 = true;
    L19:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L25;
        if (r0 != null) goto L25;
        return b(r5, r6);
    L25:
        if (r0 != null) goto L28;
        r0 = "";
    L28:
        return new c(r8, r0);
    L5:
        return new c(null, null, 3, null);
    }

    public static final /* synthetic */ e a() {
        return b();
    }

    public static final e a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "raw");
        JSONObject r0 = new JSONObject(r4);
        List<String> r5 = a(r0, "like_reasons");
        List<String> r1 = a(r0, "dislike_reasons");
        String r2 = r0.optString("feedback_placeholder");
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r3 = null;
    L7:
        return new e(r5, r1, r3);
    }

    public static final String a(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "selectedReasons");
        if (r4.isEmpty() == false) goto L7;
        return null;
    L7:
        return new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final List<String> a(String r4, ProactiveFeedbackSheet.Mode r5) {
        List<String> r0 = null;
        if (r4 == null) goto L5;
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L11;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r3 = Result.m1421constructorimpl(new JSONArray(r6));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r3) == false) goto L19;
        r3 = null;
    L19:
        JSONArray r7 = (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L29;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(a(r7), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L23:
        if (r9.hasNext() == false) goto L28;
        String r10 = c((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"), r5);
        if (r10 == null) goto L23;
        r1.add(r10);
        goto L23
    L28:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L29:
        String r11 = c(r6, r5);
        if (r11 == null) goto L32;
        r0 = CollectionsKt.listOf(r11);
    L32:
        if (r0 == null) goto L34;
        return r0;
    L34:
        return CollectionsKt.emptyList();
    L14:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L11:
        return CollectionsKt.emptyList();
    L5:
        r6 = null;
        goto L6
    }

    private static final List<String> a(JSONArray r6) {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = r6.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r6.optString(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        r0.add(r5);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return r0;
    }

    private static final List<String> a(JSONObject r0, String r1) {
        JSONArray r2 = r0.optJSONArray(r1);
        if (r2 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a(r2);
    }

    private static final boolean a(ProactiveFeedbackSheet.Mode r4, String r5) {
        if (r5 == null) goto L29;
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r6 == null) goto L29;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L29;
        if (r4 != null) goto L15;
        int r7 = -1;
    L16:
        if (r7 == (-1)) goto L29;
        if (r7 != 1) goto L19;
        String r8 = "LIKE";
    L28:
        return !StringsKt.equals(r6, r8, true);
    L19:
        if (r7 != 2) goto L21;
        r8 = "DISLIKE";
        goto L28
    L21:
        if (r7 != 3) goto L24;
        r8 = "OVERALL";
        goto L28
    L24:
        throw new NoWhenBranchMatchedException();
    L15:
        r7 = a.f6656a[r4.ordinal()];
    L29:
        return false;
    }

    public static final boolean a(List<String> r2, String r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "selectedReasons");
        Intrinsics.checkNotNullParameter(r3, MemoryListActivity.JUMP_FROM_DETAIL);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        return false;
    L10:
        return true;
    }

    private static final c b(String r11, ProactiveFeedbackSheet.Mode r12) {
        List r1 = null;
        if (r11 == null) goto L11;
        Sequence<String> r13 = StringsKt.lineSequence((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r13 == null) goto L11;
        Sequence r14 = SequencesKt.map(r13, $$Lambda$f$vweCOiaJBxcjehSlwBlTwadOY4k.INSTANCE);
        if (r14 == null) goto L11;
        Sequence r15 = SequencesKt.filter(r14, $$Lambda$f$KYeOx50zQTbcOpscDHd6LGSWpOo.INSTANCE);
        if (r15 == null) goto L11;
        List r16 = SequencesKt.toList(r15);
    L12:
        if (r16 != null) goto L15;
        r16 = CollectionsKt.emptyList();
    L15:
        if (r16.isEmpty() == true) goto L17;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r2.hasNext() == false) goto L24;
        Object r3 = r2.next();
        if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), "reasons=", false, 2, null) == false) goto L20;
    L25:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L34;
        String r5 = StringsKt.substringAfter$default(r4, "reasons=", null, 2, null);
        if (r5 == null) goto L34;
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r6 == null) goto L34;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L34;
    L35:
        String r7 = c(r16, "detail=");
        List<String> r8 = a(r6, r12);
        String r9 = "";
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L59;
        if (r7 != null) goto L59;
        if (r16.size() != 1) goto L51;
        Object r17 = CollectionsKt.first(r16);
        if (c((String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin")) == false) goto L45;
        r17 = null;
    L45:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L50;
        r9 = r18;
    L50:
        return new c(null, r9, 1, null);
    L51:
        String r19 = c((String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r16), String.class, "com.obric.memorydata.plugin"), r12);
        if (r19 == null) goto L54;
        r1 = CollectionsKt.listOf(r19);
    L54:
        if (r1 != null) goto L57;
        r1 = CollectionsKt.emptyList();
    L57:
        return new c(r1, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), 1), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L59:
        if (r7 != null) goto L62;
        r7 = "";
    L62:
        return new c(r8, r7);
    L34:
        r6 = null;
        goto L35
    L24:
        r3 = null;
        goto L25
    L17:
        return new c(null, null, 3, null);
    L11:
        r16 = null;
        goto L12
    }

    private static final e b() {
        String r0 = SettingsManager.INSTANCE.getSettingsStr(SettingsManager.KEY_AI_PROACTIVE_FEEDBACK_SETTINGS);
        Object r1 = null;
        if (r0 != null) goto L5;
    L19:
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L19;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.m1421constructorimpl(a(r0));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 != null) goto L16;
        r1 = r3;
    L18:
        return (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.memorydata.plugin");
    L16:
        RunLog.INSTANCE.error("ProactiveUI", "[FeedbackSheet] parse ai proactive feedback settings failed", r4);
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final List<String> b(List<String> r4, String r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "currentReasons");
        Intrinsics.checkNotNullParameter(r5, "clickedReason");
        if (r6.contains(r5) == false) goto L12;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L18;
        Object r2 = r8.next();
        if (Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), r5) == true) goto L6;
        r0.add(r2);
        goto L6
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L12:
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"), r5);
    }

    private static final boolean b(String r8) {
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), '=', 0, false, 6, null);
        if (r0 > 0) goto L5;
        return false;
    L5:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.take(r8, r0), CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L6:
        boolean r3 = true;
        if (r1 >= r9.length()) goto L18;
        char r2 = r9.charAt(r1);
        if (r2 != '_') goto L11;
    L14:
        if (r3 == false) goto L21;
        r1 = r1 + 1;
        goto L6
    L21:
        return false;
    L11:
        if (Character.isLetterOrDigit(r2) == true) goto L14;
        r3 = false;
        goto L14
    L18:
        return true;
    }

    private static final String c(String r3, ProactiveFeedbackSheet.Mode r4) {
        if (r3 == null) goto L26;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r5 == null) goto L26;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L26;
        if (r4 != null) goto L15;
        int r6 = -1;
    L16:
        if (r6 == (-1)) goto L25;
        if (r6 == 1) goto L25;
        if (r6 == 2) goto L25;
        if (r6 == 3) goto L25;
        throw new NoWhenBranchMatchedException();
    L25:
        return r5;
    L15:
        r6 = a.f6656a[r4.ordinal()];
    L26:
        return null;
    }

    private static final String c(List<String> r18, String r19) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L9;
        if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"), r19, false, 2, null) == true) goto L10;
        r5 = r5 + 1;
    L10:
        if (r5 >= 0) goto L12;
        return null;
    L12:
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringAfter$default((String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.memorydata.plugin"), r19, null, 2, null), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L18;
        r4.add(r0);
    L18:
        int r6 = r5 + 1;
        int r2 = r1.size();
    L19:
        if (r6 >= r2) goto L23;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r1.get(r6), String.class, "com.obric.memorydata.plugin");
        if (b(r7) == true) goto L23;
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(r7);
        r6 = r6 + 1;
    L23:
        String r8 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
        return null;
    L26:
        return r8;
    L9:
        r5 = -1;
        goto L10
    }

    private static final boolean c(String r2) {
        if (r2 == null) goto L6;
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r3 == null) goto L6;
        String r4 = r3.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
    L7:
        if (r4 == null) goto L24;
        int r0 = r4.hashCode();
        if (r0 == (-1319569547)) goto L22;
        if (r0 == (-1190396462)) goto L19;
        if (r0 != 102204227) goto L24;
        if (r4.equals("known") == false) goto L24;
    L23:
        return true;
    L19:
        if (r4.equals("ignore") == true) goto L23;
    L22:
        if (r4.equals("execute") == true) goto L23;
    L24:
        return false;
    L6:
        r4 = null;
        goto L7
    }

    private static final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private static final boolean e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ boolean lambda$KYeOx50zQTbcOpscDHd6LGSWpOo(String r0) {
        return e(r0);
    }

    public static /* synthetic */ String lambda$vweCOiaJBxcjehSlwBlTwadOY4k(String r0) {
        return d(r0);
    }
}
