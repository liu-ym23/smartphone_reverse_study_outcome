package com.obric.aiproactive.ui.util;

import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bp;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b,\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0002JI\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2.\u0010\f\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0015JG\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0019H\u0000¢\u0006\u0002\b#JG\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u0019H\u0000¢\u0006\u0002\b'J1\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0000¢\u0006\u0002\b)J!\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0002\b+J)\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0002\b.JA\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010!\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0000¢\u0006\u0002\b4J&\u00105\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J/\u00106\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u00107J;\u00108\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u00109J\u001e\u0010:\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005J7\u0010<\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010=J2\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005J.\u0010B\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J\u0016\u0010C\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010D\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/aiproactive/ui/util/ProactiveEventTracker;", "", "<init>", "()V", "TAG", "", "report", "", "event", TrackerImpl.PARAMS, "", "paramsOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "buildEnterPageParams", "currentPage", "previousPage", "enterFrom", "enterMethod", "buildEnterPageParams$ai_proactive_ui_obricRelease", "buildLaunchParams", "launchPosition", "aiFollowupNum", "", "manualFollowupNum", "officialFollowupNum", "buildLaunchParams$ai_proactive_ui_obricRelease", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/util/Map;", "buildCardShowParams", "showPage", "showPosition", "recommandationId", "rank", "buildCardShowParams$ai_proactive_ui_obricRelease", "buildCardClickParams", "clickPosition", "buttonType", "buildCardClickParams$ai_proactive_ui_obricRelease", "buildPageClickParams", "buildPageClickParams$ai_proactive_ui_obricRelease", "buildPageScrollParams", "buildPageScrollParams$ai_proactive_ui_obricRelease", "buildInterviewSubmitParams", "interviewOptions", "buildInterviewSubmitParams$ai_proactive_ui_obricRelease", "buildValueRatingSubmitParams", "amount", "amountSource", "targetType", "submitType", "buildValueRatingSubmitParams$ai_proactive_ui_obricRelease", "enterPage", "cardShow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "cardClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "pageClick", "pageScroll", Constants.LAUNCH_TAG, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "feedbackSubmit", "feedbackType", "feedbackReason", "feedbackText", "valueRatingSubmit", "interviewSubmit", "addToDesktop", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6884a = null;

    static {
        f6884a = new h();
    }

    private h() {
    }

    private final Map<String, Object> a(Pair<String, ? extends Object>... r7) {
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Pair<String, ? extends Object> r3 = r7[r2];
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.component1(), String.class, "com.obric.memorydata.plugin");
        Object r5 = r3.component2();
        if (r5 == null) goto L7;
        Pair r8 = TuplesKt.to(r4, r5);
    L8:
        if (r8 == null) goto L10;
        r6.add(r8);
    L10:
        r2 = r2 + 1;
        goto L3
    L7:
        r8 = null;
        goto L8
    L12:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void a(h r1, String r2, String r3, String r4, String r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        r1.c(r2, r3, r4, r5);
    }

    private final void a(String r8, Map<String, ? extends Object> r9) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveEventTracker$report$1(r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final Map<String, Object> a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        if (n.j().contains(r4) == false) goto L7;
        return a(new Pair[]{TuplesKt.to("current_page", r4)});
    L7:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Map<String, Object> a(String r5, int r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "recommandationId");
        Intrinsics.checkNotNullParameter(r7, "amountSource");
        Intrinsics.checkNotNullParameter(r8, "targetType");
        Intrinsics.checkNotNullParameter(r9, "submitType");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L28;
        if (r6 >= 0) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L26;
        if (n.a().contains(r7) == false) goto L24;
        if (n.b().contains(r8) == false) goto L22;
        if (n.c().contains(r9) == false) goto L20;
        return a(new Pair[]{TuplesKt.to("recommandation_id", r5), TuplesKt.to("amount", Integer.valueOf(r6)), TuplesKt.to("currency", "CNY"), TuplesKt.to("amount_source", r7), TuplesKt.to("target_type", r8), TuplesKt.to("submit_type", r9)});
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        if (r6 >= 10000) goto L9;
        r3 = true;
        goto L10
    L28:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Map<String, Object> a(String r3, Integer r4, Integer r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r3, "launchPosition");
        return a(new Pair[]{TuplesKt.to("launch_position", r3), TuplesKt.to("ai_followup_num", r4), TuplesKt.to("manual_followup_num", r5), TuplesKt.to("official_followup_num", r6)});
    }

    public final Map<String, Object> a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        Intrinsics.checkNotNullParameter(r4, "interviewOptions");
        return a(new Pair[]{TuplesKt.to("enter_from", r3), TuplesKt.to("interview_options", r4)});
    }

    public final Map<String, Object> a(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        Intrinsics.checkNotNullParameter(r5, "clickPosition");
        Intrinsics.checkNotNullParameter(r6, "buttonType");
        if (n.h().contains(r4) == false) goto L11;
        if (n.i().contains(r6) == false) goto L9;
        return a(new Pair[]{TuplesKt.to("current_page", r4), TuplesKt.to("click_position", r5), TuplesKt.to("button_type", r6)});
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Map<String, Object> a(String r6, String r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "showPosition");
        Intrinsics.checkNotNullParameter(r8, "recommandationId");
        if (Intrinsics.areEqual(r7, "lock_screen") == false) goto L6;
        if (r6 != null) goto L6;
    L9:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L22;
        if (r9 <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L20;
        return a(new Pair[]{TuplesKt.to("show_page", r6), TuplesKt.to("show_position", r7), TuplesKt.to("recommandation_id", r8), TuplesKt.to("rank", Integer.valueOf(r9))});
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L15:
        r1 = false;
        goto L16
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L6:
        if (Intrinsics.areEqual(r7, "unlock_screen") == true) goto L8;
    L10:
        r0 = false;
        goto L12
    L8:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(n.d(), Iterable.class, "com.obric.memorydata.plugin"), r6) == false) goto L10;
        goto L9
    }

    public final Map<String, Object> a(String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "currentPage");
        Intrinsics.checkNotNullParameter(r7, "previousPage");
        Intrinsics.checkNotNullParameter(r8, "enterFrom");
        Intrinsics.checkNotNullParameter(r9, "enterMethod");
        if (n.g().contains(r6) == false) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L26;
        if (SetsKt.setOf(new String[]{"desktop_icon", "lockscreen_card"}).contains(r8) == false) goto L24;
        if (SetsKt.setOf(new String[]{"scroll", "click"}).contains(r9) == false) goto L22;
        return a(new Pair[]{TuplesKt.to("current_page", r6), TuplesKt.to("previous_page", r7), TuplesKt.to("enter_from", r8), TuplesKt.to("enter_method", r9)});
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        if (n.h().contains(r7) == true) goto L13;
        r1 = false;
        goto L14
    L7:
        r0 = false;
        goto L8
    L28:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Map<String, Object> a(String r6, String r7, String r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "clickPosition");
        Intrinsics.checkNotNullParameter(r8, "buttonType");
        if (Intrinsics.areEqual(r7, "lock_screen") == false) goto L6;
        if (r6 != null) goto L6;
    L9:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L26;
        if (n.f().contains(r8) == false) goto L24;
        if (r10 <= 0) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L22;
        return a(new Pair[]{TuplesKt.to("current_page", r6), TuplesKt.to("click_position", r7), TuplesKt.to("button_type", r8), TuplesKt.to("recommandation_id", r9), TuplesKt.to("rank", Integer.valueOf(r10))});
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        r1 = false;
        goto L18
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L6:
        if (Intrinsics.areEqual(r7, "unlock_screen") == true) goto L8;
    L10:
        r0 = false;
        goto L12
    L8:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(n.e(), Iterable.class, "com.obric.memorydata.plugin"), r6) == false) goto L10;
        goto L9
    }

    public final void a(String r7, String r8, String r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r8, "showPosition");
        Intrinsics.checkNotNullParameter(r9, "recommandationId");
        if (Intrinsics.areEqual(r8, "lock_screen") == false) goto L6;
        if (r7 != null) goto L6;
    L9:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L18;
        if (r10 == null) goto L18;
        if (r10.intValue() <= 0) goto L18;
        a("card_show", a(r7, r8, r9, r10.intValue()));
        return;
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveEventTracker", "skip invalid card_show showPage=" + r7 + " rank=" + r10, null, 4, null);
        return;
    L6:
        if (Intrinsics.areEqual(r8, "unlock_screen") == true) goto L8;
    L10:
        r0 = false;
        goto L11
    L8:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(n.d(), Iterable.class, "com.obric.memorydata.plugin"), r7) == false) goto L10;
        goto L9
    }

    public final void a(String r9, String r10, String r11, String r12, Integer r13) {
        Intrinsics.checkNotNullParameter(r10, "clickPosition");
        Intrinsics.checkNotNullParameter(r11, "buttonType");
        if (Intrinsics.areEqual(r10, "lock_screen") == false) goto L6;
        if (r9 != null) goto L6;
    L10:
        if (n.f().contains(r11) == false) goto L17;
        if (r13 == null) goto L17;
        if (r13.intValue() <= 0) goto L17;
        a("card_click", a(r9, r10, r11, r12, r13.intValue()));
        return;
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveEventTracker", "skip invalid card_click currentPage=" + r9 + " buttonType=" + r11 + " rank=" + r13, null, 4, null);
        return;
    L6:
        if (Intrinsics.areEqual(r10, "unlock_screen") == false) goto L17;
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(n.e(), Iterable.class, "com.obric.memorydata.plugin"), r9) == false) goto L17;
        goto L17
    }

    public final void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "currentPage");
        if (n.j().contains(r7) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveEventTracker", "skip invalid page_scroll currentPage=" + r7, null, 4, null);
        return;
    L6:
        a("page_scroll", a(r7));
    }

    public final void b(String r7, int r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r7, "recommandationId");
        Intrinsics.checkNotNullParameter(r9, "amountSource");
        Intrinsics.checkNotNullParameter(r10, "targetType");
        Intrinsics.checkNotNullParameter(r11, "submitType");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L19;
        boolean r0 = false;
        if (r8 >= 0) goto L7;
    L9:
        if (r0 == false) goto L19;
        if (n.a().contains(r9) == false) goto L19;
        if (n.b().contains(r10) == false) goto L19;
        if (n.c().contains(r11) == false) goto L19;
        a("value_rating_submit", a(r7, r8, r9, r10, r11));
        return;
    L7:
        if (r8 >= 10000) goto L9;
        r0 = true;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveEventTracker", "skip invalid value_rating_submit", null, 4, null);
    }

    public final void b(String r2, Integer r3, Integer r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "launchPosition");
        a(Constants.LAUNCH_TAG, a(r2, r3, r4, r5));
    }

    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "interviewOptions");
        a("interview_submit", a(r2, r3));
    }

    public final void b(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "currentPage");
        Intrinsics.checkNotNullParameter(r8, "clickPosition");
        Intrinsics.checkNotNullParameter(r9, "buttonType");
        if (n.h().contains(r7) == true) goto L5;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveEventTracker", "skip invalid page_click currentPage=" + r7 + " buttonType=" + r9, null, 4, null);
        return;
    L5:
        if (n.i().contains(r9) == false) goto L9;
        a("page_click", a(r7, r8, r9));
    }

    public final void b(String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "currentPage");
        Intrinsics.checkNotNullParameter(r8, "previousPage");
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        Intrinsics.checkNotNullParameter(r10, "enterMethod");
        if (n.g().contains(r7) == true) goto L5;
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveEventTracker", "skip invalid enter_page currentPage=" + r7 + " previousPage=" + r8, null, 4, null);
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        if (n.h().contains(r8) == false) goto L18;
    L12:
        if (SetsKt.setOf(new String[]{"desktop_icon", "lockscreen_card"}).contains(r9) == false) goto L18;
        if (SetsKt.setOf(new String[]{"scroll", "click"}).contains(r10) == false) goto L18;
        a("enter_page", a(r7, r8, r9, r10));
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void c(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "feedbackType");
        a("feedback_submit", a(new Pair[]{TuplesKt.to("feedback_type", r3), TuplesKt.to("feedback_reason", r4), TuplesKt.to("feedback_text", r5), TuplesKt.to("recommandation_id", r6)}));
    }
}
