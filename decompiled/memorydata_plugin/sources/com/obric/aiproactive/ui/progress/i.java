package com.obric.aiproactive.ui.progress;

import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a.\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0005*\u00020\u0011H\u0002\u001a\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0010*\u00020\rH\u0002\u001a\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002\u001a\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002\u001a\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0000\u001a\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0000\u001a \u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0010H\u0000\u001a\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0002\u001a(\u00103\u001a\u0002042\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00102\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0000\u001a$\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\u0006\u00107\u001a\u00020\u0005H\u0000\u001a*\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\"H\u0000\u001a\u0010\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0001H\u0000\u001a\u0018\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u00020\u0001H\u0000\u001a*\u0010?\u001a\u00020\u00012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020C0BH\u0000\u001a*\u0010D\u001a\u00020\u00012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020C0BH\u0000\u001a\u0018\u0010F\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0010H\u0000\u001a\u0018\u0010H\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020I2\u0006\u0010G\u001a\u00020\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"DETAIL_TOP_MARGIN_DP", "", "TITLE_CHEVRON_SIZE_DP", "TITLE_CHEVRON_GAP_DP", "MOBILE_USE_NAVIGATION_ARROW", "", "buildAgentRunPrimaryMarkdown", "title", "linkUrl", "buildAgentRunDirectMarkdown", "sourceMarkdown", "groups", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;", "overrideMarkdown", "usesOrderedList", "", "Lcom/obric/aiproactive/ui/progress/RenderedAgentRunGroup;", "toListMarkdown", "buildAgentRunItemMarkdown", "group", "item", "Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", "isTaskGroup", "normalizeAgentRunHttpUrl", "normalizeAgentRunStructuredText", EventBody.KEY_VALUE, "markdownLink", AnnotatedPrivateKey.LABEL, "destination", "escapeMarkdownPlainText", "escapeMarkdownLabel", "escapeMarkdownDestination", "MARKDOWN_PLAIN_TEXT_META_CHARACTERS", "", "", "ACCESSIBILITY_MARKDOWN_IMAGE", "Lkotlin/text/Regex;", "ACCESSIBILITY_MARKDOWN_LINK", "ACCESSIBILITY_URL", "ACCESSIBILITY_MARKDOWN_PUNCTUATION", "normalizeAgentRunAccessibilityText", "shouldEnableAgentRunHeaderToggle", "hasExpandableDetails", "buildAgentRunStepContentDescription", "step", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "expanded", "agentRunStateDescription", "state", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "buildAgentRunStepSecondaryContent", "Lcom/obric/aiproactive/ui/progress/AgentRunStepSecondaryContent;", "toggleExpandedStep", "expandedStepIds", "stepId", "retainExistingExpandedSteps", "existingStepIds", "buildMobileUseOrdinalLabel", "ordinal", "buildAgentRunActivityMarkerLabel", "listStyle", "Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "calculateAgentRunMarkerColumnWidth", "labels", "measureText", "Lkotlin/Function1;", "", "calculateMobileUseOrdinalColumnWidth", "ordinals", "buildMobileUseRowText", "navigationEnabled", "buildMobileUseItemContentDescription", "Lcom/obric/aiproactive/ui/progress/AgentRunActivityUiItem;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Character> f6821a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f6822b = null;
    private static final Regex c = null;
    private static final Regex d = null;
    private static final Set<Character> e = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6823a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6824b = null;

        static {
            int[] r0 = new int[AgentRunSecondaryListStyle.values().length];
            r0[AgentRunSecondaryListStyle.ORDERED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r0[AgentRunSecondaryListStyle.UNORDERED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L47:
            r0[AgentRunSecondaryListStyle.PLAIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[AgentRunSecondaryListStyle.KEY_VALUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L10:
            f6823a = r0;
            int[] r1 = new int[AgentRunUiState.values().length];
            r1[AgentRunUiState.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L41:
            r1[AgentRunUiState.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L29:
            r1[AgentRunUiState.PENDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L39:
            r1[AgentRunUiState.CANCELLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L33:
            r1[AgentRunUiState.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L43:
            r1[AgentRunUiState.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L17:
            f6824b = r1;
        }
    }

    static {
        Character r17 = Character.valueOf(Typography.less);
        Character r19 = Character.valueOf(Typography.greater);
        f6821a = SetsKt.setOf(new Character[]{'\\', '`', '*', '_', '{', '}', '[', ']', r17, r19, '(', ')', '#', '!', '|', '~'});
        f6822b = new Regex("!\\[([^]]*)]\\([^)]*\\)");
        c = new Regex("\\[([^]]*)]\\([^)]*\\)");
        d = new Regex("(?i)(?:https?://|www\\.)\\S+");
        e = SetsKt.setOf(new Character[]{'\\', '`', '*', '_', '{', '}', '[', ']', r17, r19, '(', ')', '#', '|', '~'});
    }

    public static final int a(List<String> r4, Function1<? super String, Float> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "labels");
        Intrinsics.checkNotNullParameter(r7, "measureText");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == true) goto L5;
        Float r9 = null;
    L10:
        if (r9 == null) goto L12;
        double r10 = r9.floatValue();
    L14:
        return (int) Math.ceil(r10);
    L12:
        r10 = 0.0d;
        goto L14
    L5:
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue();
    L7:
        if (r8.hasNext() == false) goto L9;
        r0 = Math.max(r0, ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L7
    L9:
        r9 = Float.valueOf(r0);
        goto L10
    }

    public static final j a(n r5, boolean r6, List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "step");
        Intrinsics.checkNotNullParameter(r8, "overrideMarkdown");
        String r9 = a(r5.f(), r5.e(), r8);
        boolean r0 = false;
        if (r6 == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r5.g() == false) goto L14;
        if (r10 == true) goto L14;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L14;
        r0 = true;
    L14:
        if (r0 == true) goto L17;
        r3 = null;
    L17:
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        if (r10 == false) goto L22;
        String r1 = r9;
    L24:
        return new j(r9, r1, r10, !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")));
    L22:
        r1 = r3;
        goto L24
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        r10 = true;
        goto L8
    }

    private static final CharSequence a(boolean r3, ab r4) {
        Intrinsics.checkNotNullParameter(r4, "renderedGroup");
        String r0 = b(r4);
        String r5 = b(r4.a().b());
        boolean r1 = true;
        if (r3 == true) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L15;
        String r6 = "**" + d(r5) + "**\n" + r0;
        if (r6 == null) goto L15;
        Object r7 = ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
    L17:
        return (CharSequence) r7;
    L15:
        r7 = ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        goto L17
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        goto L7
    }

    public static final String a(int r2) {
        return new StringBuilder().append(RangesKt.coerceAtLeast(r2, 1)).append('.').toString();
    }

    public static final String a(AgentRunSecondaryListStyle r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "listStyle");
        int r3 = a.f6823a[r1.ordinal()];
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L7;
        return "•";
    L7:
        if (r3 != 3) goto L9;
    L13:
        return "";
    L9:
        if (r3 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    L16:
        return a(r2);
    }

    private static final String a(AgentRunUiState r1) {
        switch(a.f6824b[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "状态未知";
    L7:
        return "执行失败";
    L8:
        return "已停止";
    L9:
        return "等待中";
    L10:
        return "进行中";
    L11:
        return "已完成";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static final String a(com.obric.aiproactive.ui.progress.a r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "item");
        List r0 = CollectionsKt.createListBuilder();
        r0.add(new StringBuilder().append(31532).append(RangesKt.coerceAtLeast(r10.b(), 1)).append(27493).toString());
        r0.add(c(r10.c()));
        if (r10.e() == false) goto L8;
        if (r10.d() != AgentRunUiState.RUNNING) goto L8;
        String r12 = "进行中，当前步骤";
    L25:
        r0.add(r12);
        if (r11 == false) goto L28;
        r0.add("可进入虚拟屏");
    L28:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L30:
        if (r15.hasNext() == false) goto L35;
        Object r1 = r15.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L30;
        r14.add(r1);
        goto L30
    L35:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("，", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L8:
        if (r10.e() == false) goto L13;
        if (r10.d() != AgentRunUiState.COMPLETED) goto L13;
        r12 = "已完成，当前步骤";
    L13:
        if (r10.d() != AgentRunUiState.COMPLETED) goto L16;
        r12 = "已完成";
        goto L25
    L16:
        if (r10.d() != AgentRunUiState.CANCELLED) goto L19;
        r12 = "已停止";
        goto L25
    L19:
        if (r10.d() != AgentRunUiState.FAILED) goto L22;
        r12 = "执行失败";
        goto L25
    L22:
        if (r10.d() != AgentRunUiState.PENDING) goto L24;
        r12 = "等待中";
        goto L25
    L24:
        r12 = "状态未知";
        goto L25
    }

    private static final String a(k r7, l r8) {
        if (r8.d() == null) goto L6;
        return "";
    L6:
        if (a(r8.c()) == null) goto L8;
        boolean r0 = true;
    L9:
        String r3 = a(r8.a(), r8.c());
        String r9 = b(r8.b());
        String r6 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        r9 = null;
    L13:
        if (r9 == null) goto L15;
        r6 = d(r9);
    L15:
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        if (r0 == false) goto L22;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L22;
    L42:
        return r3;
    L22:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L30;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L30;
        if (a(r7) == false) goto L30;
        StringBuilder r10 = new StringBuilder().append(r3).append(" · ");
    L41:
        return r10.append(r6).toString();
    L30:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L35;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L35;
        r10 = new StringBuilder().append(r3).append(65306);
    L35:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L42;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L40;
        return "";
    L40:
        return r6;
    L8:
        r0 = false;
        goto L9
    }

    public static final String a(n r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "step");
        List r0 = CollectionsKt.createListBuilder();
        String r1 = c(r13.b());
        boolean r4 = true;
        String r5 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        r0.add(r1);
    L8:
        r0.add(a(r13.d()));
        String r2 = c(r13.c());
        if (r13.g() == true) goto L11;
    L13:
        r4 = false;
    L14:
        if (r4 == false) goto L16;
        r5 = r2;
    L16:
        if (r5 == null) goto L18;
        r0.add(r5);
    L18:
        if (r14 == false) goto L24;
        if (r15 == false) goto L21;
        String r16 = "已展开，点击收起";
    L22:
        r0.add(r16);
        goto L24
    L21:
        r16 = "已收起，点击展开";
    L24:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r0), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("，", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
        goto L13
    }

    public static final String a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "linkUrl");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L23;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        int r3 = 0;
    L6:
        if (r3 >= r0.length()) goto L11;
        if (CharsKt.isWhitespace(r0.charAt(r3)) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L23;
        if (StringsKt.startsWith(r7, ReportConsts.HTTPS, true) == false) goto L17;
    L18:
        r1 = true;
    L19:
        if (r1 == false) goto L22;
        return r7;
    L22:
        return null;
    L17:
        if (StringsKt.startsWith(r7, "http://", true) == false) goto L19;
    L11:
        r2 = false;
    L23:
        return null;
    }

    public static final String a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "linkUrl");
        String r4 = b(r2);
        String r1 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L14;
        String r5 = a(r3);
        if (r5 == null) goto L13;
        String r6 = b(r4, r5);
        if (r6 == null) goto L13;
        r1 = r6;
    L13:
        r1 = d(r4);
    L14:
        if (r1 != null) goto L17;
        return "";
    L17:
        return r1;
    }

    public static final String a(String r13, List<k> r14, List<String> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "sourceMarkdown");
        Intrinsics.checkNotNullParameter(r16, "groups");
        Intrinsics.checkNotNullParameter(r17, "overrideMarkdown");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r18.iterator();
    L4:
        if (r19.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r110.iterator();
    L7:
        final boolean r3 = true;
        if (r111.hasNext() == false) goto L12;
        Object r2 = r111.next();
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        r1.add(r2);
        goto L7
    L12:
        String r112 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L15;
        return r112;
    L15:
        String r113 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r113, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L19;
        r113 = null;
    L19:
        if (r113 == null) goto L21;
        return r113;
    L21:
        Iterable r114 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r115 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r116 = r114.iterator();
    L23:
        if (r116.hasNext() == false) goto L47;
        k r117 = (k) ZeusTransformUtils.preCheckCast(r116.next(), k.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r117.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L26:
        if (r8.hasNext() == false) goto L41;
        l r9 = (l) ZeusTransformUtils.preCheckCast(r8.next(), l.class, "com.obric.memorydata.plugin");
        String r10 = a(r117, r9);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == true) goto L36;
        r10 = null;
    L36:
        if (r10 == null) goto L38;
        Pair r12 = TuplesKt.to(r9, r10);
    L39:
        if (r12 == null) goto L26;
        r7.add(r12);
        goto L26
    L38:
        r12 = null;
        goto L39
    L30:
        if (r5.add(r10) == false) goto L32;
        r11 = true;
        goto L33
    L41:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L44;
        ab r20 = null;
    L45:
        if (r20 == null) goto L23;
        r115.add(r20);
        goto L23
    L44:
        r20 = new ab(r117, r4);
        goto L45
    L47:
        List r118 = (List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.memorydata.plugin");
        if (r118.size() == 1) goto L50;
    L55:
        Iterable r119 = (Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r119, Collection.class) == true) goto L58;
    L60:
        Iterator r120 = r119.iterator();
    L62:
        if (r120.hasNext() == false) goto L59;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((ab) ZeusTransformUtils.preCheckCast(r120.next(), ab.class, "com.obric.memorydata.plugin")).a().b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L62;
        boolean r121 = false;
    L66:
        if (r121 == false) goto L70;
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$i$tMvirMG18A2QimRQAGFPepI5d0M.INSTANCE, 30, null);
    L70:
        if (r118.size() > 1) goto L74;
        r3 = false;
    L74:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$i$uyi7jFhitdY02Q3nQDdOy4kFmXw(r3), 30, null);
    L59:
        r121 = true;
        goto L66
    L58:
        if (((Collection) ZeusTransformUtils.preCheckCast(r119, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L60;
    L50:
        if (((ab) ZeusTransformUtils.preCheckCast(CollectionsKt.single(r118), ab.class, "com.obric.memorydata.plugin")).b().size() != 1) goto L55;
        if (a((ab) ZeusTransformUtils.preCheckCast(CollectionsKt.single(r118), ab.class, "com.obric.memorydata.plugin")) == true) goto L55;
        return (String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(CollectionsKt.single(((ab) ZeusTransformUtils.preCheckCast(CollectionsKt.single(r118), ab.class, "com.obric.memorydata.plugin")).b()), Pair.class, "com.obric.memorydata.plugin")).getSecond(), String.class, "com.obric.memorydata.plugin");
    }

    public static final String a(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "title");
        StringBuilder r3 = new StringBuilder().append(r1);
        if (r2 == false) goto L5;
        String r4 = " →";
    L7:
        return r3.append(r4).toString();
    L5:
        r4 = "";
        goto L7
    }

    public static final Set<String> a(Set<String> r2, String r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "expandedStepIds");
        Intrinsics.checkNotNullParameter(r3, "stepId");
        if (r4.contains(r3) == false) goto L6;
        return SetsKt.minus(r4, r3);
    L6:
        return SetsKt.plus(r4, r3);
    }

    public static final Set<String> a(Set<String> r2, Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "expandedStepIds");
        Intrinsics.checkNotNullParameter(r5, "existingStepIds");
        return CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final boolean a(ab r1) {
        if (r1.a().d() != AgentRunSecondaryListStyle.ORDERED) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(k r5) {
        if (Intrinsics.areEqual(r5.a(), "task") == false) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.endsWith$default(r5.a(), "-task", false, 2, null) == true) goto L8;
        if (Intrinsics.areEqual(r5.b(), "关注事项") == true) goto L8;
        return false;
    }

    public static final boolean a(boolean r0) {
        return r0;
    }

    private static final String b(ab r12) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L24;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r6 = (String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r4, Pair.class, "com.obric.memorydata.plugin")).component2(), String.class, "com.obric.memorydata.plugin");
        AgentRunSecondaryListStyle r7 = r12.a().d();
        int r8 = a.f6823a[r7.ordinal()];
        if (r8 != 1) goto L11;
        StringBuilder r9 = new StringBuilder().append(r5);
        String r10 = ". ";
    L21:
        r6 = r9.append(r10).append(r6).toString();
    L22:
        r1.add(r6);
        r3 = r5;
        goto L4
    L11:
        if (r8 != 2) goto L13;
        r9 = new StringBuilder();
        r10 = "- ";
        goto L21
    L13:
        if (r8 == 3) goto L22;
        if (r8 == 4) goto L22;
        throw new NoWhenBranchMatchedException();
    L24:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public static final String b(String r7) {
        Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
        StringBuilder r1 = new StringBuilder(r7.length());
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r8.length()) goto L18;
        char r5 = r8.charAt(r3);
        if (CharsKt.isWhitespace(r5) == true) goto L15;
        if (Character.isISOControl(r5) == true) goto L15;
        if (r4 == false) goto L12;
        r1.append(' ');
    L12:
        r1.append(r5);
    L13:
        r4 = false;
    L17:
        r3 = r3 + 1;
    L15:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L13;
        r4 = true;
        goto L17
    L18:
        String r9 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private static final String b(String r2, String r3) {
        return '[' + e(r2) + "](" + f(r3) + ')';
    }

    private static final CharSequence c(ab r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(b(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final String c(String r6) {
        Intrinsics.checkNotNullParameter(r6, EventBody.KEY_VALUE);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(f6822b.replace(r7, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(c.replace(r8, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(b(d.replace(r9, "")), CharSequence.class, "com.obric.memorydata.plugin");
        Appendable r0 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L4:
        if (r2 >= r10.length()) goto L9;
        char r3 = r10.charAt(r2);
        if (e.contains(Character.valueOf(r3)) == true) goto L8;
        r0.append(r3);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        String r11 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r0, StringBuilder.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(new Regex("\\s+").replace(r12, " "), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private static final String d(String r12) {
        StringBuilder r1 = new StringBuilder(r12.length());
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= r0.length()) goto L40;
        char r6 = r0.charAt(r4);
        int r7 = r5 + 1;
        boolean r8 = true;
        if (r5 == 0) goto L8;
    L12:
        boolean r9 = false;
    L14:
        if (r6 != '.') goto L33;
        if (r5 <= 0) goto L33;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.take(r12, r5), CharSequence.class, "com.obric.memorydata.plugin");
        int r11 = 0;
    L18:
        if (r11 >= r10.length()) goto L23;
        if (Character.isDigit(r10.charAt(r11)) == false) goto L21;
        r11 = r11 + 1;
        goto L18
    L21:
        boolean r13 = false;
    L24:
        if (r13 == false) goto L33;
        Character r14 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), r7);
        if (r14 != null) goto L28;
    L30:
        boolean r15 = false;
    L31:
        if (r15 == false) goto L33;
    L35:
        if (f6821a.contains(Character.valueOf(r6)) == true) goto L38;
        if (r9 == true) goto L38;
        if (r8 == true) goto L38;
    L39:
        r1.append(r6);
        r4 = r4 + 1;
        r5 = r7;
    L38:
        r1.append('\\');
        goto L39
    L28:
        if (CharsKt.isWhitespace(r14.charValue()) != true) goto L30;
        r15 = true;
        goto L31
    L23:
        r13 = true;
    L33:
        r8 = false;
        goto L35
    L8:
        if (r6 != '+') goto L10;
    L11:
        r9 = true;
        goto L14
    L10:
        if (r6 != '-') goto L12;
    L40:
        String r16 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        return r16;
    }

    private static final String e(String r5) {
        StringBuilder r1 = new StringBuilder(r5.length());
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r6.length()) goto L9;
        char r2 = r6.charAt(r0);
        if (f6821a.contains(Character.valueOf(r2)) == false) goto L8;
        r1.append('\\');
    L8:
        r1.append(r2);
        r0 = r0 + 1;
        goto L4
    L9:
        String r7 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private static final String f(String r12) {
        return StringsKt.replace$default(StringsKt.replace$default(r12, "(", "%28", false, 4, null), ")", "%29", false, 4, null);
    }

    public static /* synthetic */ CharSequence lambda$tMvirMG18A2QimRQAGFPepI5d0M(ab r0) {
        return c(r0);
    }

    public static /* synthetic */ CharSequence lambda$uyi7jFhitdY02Q3nQDdOy4kFmXw(boolean r0, ab r1) {
        return a(r0, r1);
    }
}
