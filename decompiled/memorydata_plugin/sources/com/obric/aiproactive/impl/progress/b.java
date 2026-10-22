package com.obric.aiproactive.impl.progress;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.aiproactive.api.AiProactiveArtifactState;
import com.obric.aiproactive.api.AiProactiveArtifactType;
import com.obric.aiproactive.api.f;
import com.obric.aiproactive.api.g;
import com.obric.aiproactive.api.i;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u001a$\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u000202H\u0000\u001a\u0018\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020 H\u0000\u001a\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807*\u0004\u0018\u00010.H\u0002\u001a\f\u00109\u001a\u00020\u0003*\u000208H\u0002\u001a\u0018\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=H\u0002\u001a\"\u0010>\u001a\b\u0012\u0004\u0012\u00020?072\b\u0010@\u001a\u0004\u0018\u00010A2\b\b\u0002\u0010B\u001a\u00020\u0003H\u0002\u001a\u0014\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u000102H\u0002\u001a0\u0010F\u001a\n\u0012\u0004\u0012\u00020?\u0018\u0001072\b\u0010@\u001a\u0004\u0018\u00010A2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020?072\u0006\u0010G\u001a\u00020HH\u0002\u001a\"\u0010I\u001a\n\u0012\u0004\u0012\u00020?\u0018\u0001072\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010G\u001a\u00020HH\u0002\u001a\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020?072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020?07H\u0002\u001a\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020?072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020?07H\u0002\u001a \u0010M\u001a\b\u0012\u0004\u0012\u00020?07*\b\u0012\u0004\u0012\u00020?072\u0006\u0010N\u001a\u00020\u0001H\u0002\u001a\u0018\u0010O\u001a\b\u0012\u0004\u0012\u00020?07*\b\u0012\u0004\u0012\u00020?07H\u0002\u001a\u0014\u0010P\u001a\u00020=*\u00020\u00012\u0006\u0010Q\u001a\u00020\u0003H\u0002\u001a\f\u0010R\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"AGENT_PROGRESS_PROTOCOL", "", "AGENT_PROGRESS_VERSION", "", "MIN_AGENT_PROGRESS_VERSION", "V3_PROGRESS_VERSION", "V4_PROGRESS_VERSION", "V5_PROGRESS_VERSION", "MAX_PROGRESS_STEPS", "MAX_SUMMARY_LENGTH", "MAX_DISPLAY_TITLE_LENGTH", "MAX_DISPLAY_SUBTITLE_LENGTH", "MAX_DISPLAY_MARKDOWN_LENGTH", "MAX_DISPLAY_DESCRIPTION_LENGTH", "MAX_RESULT_DESCRIPTION_LENGTH", "MAX_DISPLAY_GROUP_LENGTH", "MAX_DISPLAY_LINK_LENGTH", "MAX_DISPLAY_ITEMS", "MAX_ARTIFACT_ID_LENGTH", "MAX_TOOL_NAME_LENGTH", "MAX_TOOL_DISPLAY_NAME_LENGTH", "MAX_STAGE_TYPE_LENGTH", "MAX_OPERATION_LENGTH", "MAX_EFFECT_LENGTH", "MAX_TOOL_TYPE_LENGTH", "MAX_STEP_ID_LENGTH", "MAX_STAGE_ID_LENGTH", "MAX_ITEM_ID_LENGTH", "MAX_MOBILE_SESSION_ID_LENGTH", "MAX_MOBILE_ITEM_ORDINAL", "MAX_ROUND_COUNT", "MAX_FUTURE_CLOCK_SKEW_MILLIS", "", "V3_STAGE_TYPES", "", "MOBILE_ITEM_STATES", "ACTIVITY_ITEM_STATES", "MOBILE_PRESENTATION_TYPE", "ACTIVITY_PRESENTATION_TYPE", "OPEN_MOBILE_USE_PLAYER_ACTION", "ACTIVITY_LIST_STYLES", "V5_PRESENTATION_TYPES", "V3_TERMINAL_EVENTS", "V3_TERMINAL_STATES", "STATEFUL_ITEM_TERMINAL_STATES", "reduceAgentRunProgress", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "previous", "taskId", "payload", "Lorg/json/JSONObject;", "cancelAgentRun", "run", "cancelledAtMillis", "orEmptySteps", "", "Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "displayOrder", "normalizeProgressState", "rawState", "isV3", "", "parseDisplayItems", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDisplayItemDto;", "array", "Lorg/json/JSONArray;", "maxDescriptionLength", "parseArtifactReference", "Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "item", "parseAndMergeStatefulDisplayItems", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/aiproactive/impl/progress/StatefulPresentationKind;", "parseStatefulDisplayItems", "normalizeActivityDisplayItems", "merged", "normalizeMobileDisplayItems", "settleStatefulItems", "terminalState", "clearStatefulCurrent", "isBoundedOpaqueId", XSDatatype.FACET_MAXLENGTH, "toSafePublicUrl", "ARTIFACT_REFERENCE_ID_PATTERN", "Lkotlin/text/Regex;", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f6495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f6496b = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Set<String> e = null;
    private static final Set<String> f = null;
    private static final Set<String> g = null;
    private static final Set<String> h = null;
    private static final Regex i = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6497a = null;

        static {
            int[] r0 = new int[StatefulPresentationKind.values().length];
            r0[StatefulPresentationKind.MOBILE_USE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[StatefulPresentationKind.ACTIVITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f6497a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.progress.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0287b<T> implements Comparator {
        public C0287b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.memorydata.plugin")).i()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin")).i()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(b.a((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(b.a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6498a;

        public d(Comparator r3) {
            this.f6498a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f6498a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f6495a = SetsKt.setOf(new String[]{"observation", "action", "conclusion", "result"});
        Set<String> r0 = SetsKt.setOf(new String[]{"pending", "running", "succeeded", "failed", "cancelled", "timed_out"});
        f6496b = r0;
        c = SetsKt.plus(r0, (Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new String[]{"waiting", "accepted", "outcome_unknown"}), Iterable.class, "com.obric.memorydata.plugin"));
        d = SetsKt.setOf(new String[]{"plain", "ordered", "unordered", "key_value"});
        e = SetsKt.setOf(new String[]{"", "mobile_use", "activity"});
        f = SetsKt.setOf(new String[]{"run_succeeded", "run_failed"});
        Set<String> r1 = SetsKt.setOf(new String[]{"succeeded", "failed", "cancelled", "timed_out"});
        g = r1;
        h = SetsKt.plus(r1, "outcome_unknown");
        i = new Regex("[A-Za-z0-9._:-]{1,128}");
    }

    public static final /* synthetic */ int a(i r0) {
        return b(r0);
    }

    private static final com.obric.aiproactive.api.d a(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r1 = r10.optString("artifact_id");
        Intrinsics.checkNotNullExpressionValue(r1, "optString(...)");
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        AiProactiveArtifactType.a r3 = AiProactiveArtifactType.Companion;
        String r5 = r10.optString("artifact_type");
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        AiProactiveArtifactType r4 = r3.a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r4 != null) goto L8;
        return null;
    L8:
        String r6 = r10.optString(Api.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        AiProactiveArtifactState.a r8 = AiProactiveArtifactState.Companion;
        String r11 = r10.optString("state");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        AiProactiveArtifactState r12 = r8.a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r12 != null) goto L12;
        return null;
    L12:
        if (i.matches((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L14;
        return null;
    L14:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
        return null;
    L16:
        if (r7.length() > 120) goto L43;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r13 = false;
        int r14 = 0;
    L19:
        if (r14 >= r9.length()) goto L35;
        char r15 = r9.charAt(r14);
        if (r15 != '/') goto L23;
    L31:
        boolean r16 = true;
    L32:
        if (r16 == true) goto L33;
        r14 = r14 + 1;
        goto L19
    L33:
        r13 = true;
        goto L35
    L23:
        if (r15 == '\\') goto L31;
        if (r15 == '\n') goto L31;
        if (r15 == '\r') goto L31;
        if (r15 == 0) goto L31;
        r16 = false;
    L35:
        if (r13 == false) goto L38;
        return null;
    L38:
        return new com.obric.aiproactive.api.d(StringsKt.take(r2, 128), r4, r7, r12);
    L43:
        return null;
    }

    public static final g a(g r44, long r45) {
        Intrinsics.checkNotNullParameter(r44, "run");
        if (SetsKt.setOf(new String[]{"pending", "running", "waiting"}).contains(r44.c()) == true) goto L5;
        return r44;
    L5:
        long r8 = Math.max(r44.e(), r45);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r44.g(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L14;
        i r15 = (i) ZeusTransformUtils.preCheckCast(r13.next(), i.class, "com.obric.memorydata.plugin");
        if (SetsKt.setOf(new String[]{"pending", "running", "waiting"}).contains(r15.d()) == false) goto L11;
        String r20 = null;
        String r21 = null;
        int r22 = 0;
        int r23 = 0;
        long r24 = 0;
        int r26 = 0;
        String r27 = null;
        int r28 = 0;
        String r29 = null;
        String r30 = null;
        String r31 = null;
        boolean r32 = false;
        String r33 = null;
        String r34 = null;
        String r35 = null;
        String r36 = null;
        String r37 = null;
        String r38 = null;
        String r39 = null;
        String r40 = null;
        List<f> r41 = a(r15.y(), "cancelled");
        int r42 = 16777207;
        Object r43 = null;
        String r19 = "cancelled";
    L12:
        r12.add(i.a(r15, null, null, null, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43));
        goto L7
    L11:
        r19 = null;
        r20 = null;
        r21 = null;
        r22 = 0;
        r23 = 0;
        r24 = 0;
        r26 = 0;
        r27 = null;
        r28 = 0;
        r29 = null;
        r30 = null;
        r31 = null;
        r32 = false;
        r33 = null;
        r34 = null;
        r35 = null;
        r36 = null;
        r37 = null;
        r38 = null;
        r39 = null;
        r40 = null;
        r41 = c(r15.y());
        r42 = ViewCompat.MEASURED_SIZE_MASK;
        r43 = null;
        goto L12
    L14:
        return g.a(r44, null, null, "cancelled", 0, r8, 0, (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), 43, null);
    }

    public static final g a(g r76, String r77, JSONObject r78) {
        Intrinsics.checkNotNullParameter(r77, "taskId");
        Intrinsics.checkNotNullParameter(r78, "payload");
        int r14 = r78.optInt("version");
        if (Intrinsics.areEqual(r78.optString("protocol"), "ai_proactive_agent_progress") == true) goto L5;
    L391:
        return r76;
    L5:
        if (1 <= r14) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L391;
        String r4 = r78.optString("execution_id");
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r5) == false) goto L15;
        r5 = r77;
    L15:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L391;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r77, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L391;
        if (Intrinsics.areEqual(r11, r77) == false) goto L391;
        int r0 = r78.optInt("seq", -1);
        if (r0 > 0) goto L25;
        return r76;
    L25:
        if (r76 != null) goto L27;
    L29:
        g r30 = null;
    L30:
        if (r30 == null) goto L45;
        List<i> r6 = r30.g();
        if (r6 == null) goto L45;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r7.hasNext() == true) goto L36;
        Comparable r8 = null;
    L42:
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L45;
        int r10 = r9.intValue();
    L46:
        if (r0 > r10) goto L49;
        return r30;
    L49:
        if (r14 < 3) goto L51;
        boolean r12 = true;
    L52:
        long r13 = System.currentTimeMillis();
        Long r15 = Long.valueOf(r78.optLong("timestamp_ms", 0));
        long r16 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r16 > 0) goto L55;
    L57:
        boolean r17 = false;
    L58:
        if (r17 == true) goto L61;
        r15 = null;
    L61:
        if (r15 == null) goto L63;
        r13 = r15.longValue();
    L63:
        long r18 = r13;
        String r19 = r78.optString("event");
        Intrinsics.checkNotNullExpressionValue(r19, "optString(...)");
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r20) == false) goto L66;
        r20 = "progress";
    L66:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.memorydata.plugin");
        String r21 = r78.optString(EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullExpressionValue(r21, "optString(...)");
        String r22 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (SetsKt.setOf(new String[]{"run", "observation", "action", "outcome"}).contains(r22) == false) goto L69;
        String r23 = r22;
    L70:
        String r24 = r78.optString("state");
        Intrinsics.checkNotNullExpressionValue(r24, "optString(...)");
        String r111 = a(r24, r12);
        String r25 = r78.optString("stage_id");
        Intrinsics.checkNotNullExpressionValue(r25, "optString(...)");
        String r26 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 120);
        if (r30 == null) goto L88;
        List<i> r27 = r30.g();
        if (r27 == null) goto L88;
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L76:
        if (r28.hasNext() == false) goto L86;
        Object r29 = r28.next();
        long r210 = r18;
        i r31 = (i) ZeusTransformUtils.preCheckCast(r29, i.class, "com.obric.memorydata.plugin");
        if (r31.j() >= 3) goto L80;
    L82:
        boolean r32 = false;
    L83:
        if (r32 == true) goto L84;
        r18 = r210;
        goto L76
    L84:
        Object r33 = r29;
    L87:
        i r34 = (i) ZeusTransformUtils.preCheckCast(r33, i.class, "com.obric.memorydata.plugin");
    L89:
        if (r34 == null) goto L91;
        int r35 = r34.l();
    L92:
        int r112 = r35;
        String r36 = r78.optString("stage_type");
        Intrinsics.checkNotNullExpressionValue(r36, "optString(...)");
        CharSequence r37 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r36, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 24);
        if (r12 == true) goto L95;
    L98:
        boolean r38 = true;
    L99:
        if (r38 == true) goto L102;
        r37 = null;
    L102:
        String r39 = "";
        if (r37 != null) goto L105;
        r37 = "";
    L105:
        if (r34 == null) goto L107;
        String r40 = r34.m();
    L108:
        if (r40 != null) goto L110;
        r40 = "";
    L110:
        CharSequence r41 = (CharSequence) ZeusTransformUtils.preCheckCast(r40, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r41) == true) goto L114;
        r37 = r41;
    L114:
        String r42 = (String) ZeusTransformUtils.preCheckCast(r37, String.class, "com.obric.memorydata.plugin");
        if (r12 == true) goto L117;
    L122:
        String r43 = r78.optString("step_id");
        Intrinsics.checkNotNullExpressionValue(r43, "optString(...)");
        CharSequence r44 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r43, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 120), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r44) == false) goto L128;
        CharSequence r45 = (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r45) == false) goto L127;
        r45 = r110 + '-' + r0;
    L127:
        r44 = (String) ZeusTransformUtils.preCheckCast(r45, String.class, "com.obric.memorydata.plugin");
    L128:
        String r46 = (String) ZeusTransformUtils.preCheckCast(r44, String.class, "com.obric.memorydata.plugin");
        JSONObject r47 = r78.optJSONObject("presentation");
        if (r47 == null) goto L135;
        String r48 = r47.optString("presentation_type");
        boolean r211 = r12;
        if (r48 == null) goto L136;
        String r49 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r48, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r49 == null) goto L136;
        String r50 = StringsKt.take(r49, 24);
    L137:
        if (r50 != null) goto L140;
        r50 = "";
    L140:
        if (r14 < 5) goto L145;
        if (e.contains(r50) == true) goto L145;
        return r30;
    L145:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r50, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L148;
        r50 = null;
    L148:
        if (r50 != null) goto L154;
        if (r34 == null) goto L151;
        r50 = r34.v();
    L152:
        if (r50 != null) goto L154;
        String r51 = "";
    L156:
        if (r14 >= 4) goto L158;
    L162:
        boolean r52 = false;
    L164:
        if (r14 >= 5) goto L166;
    L170:
        boolean r2 = false;
    L171:
        if (r52 == false) goto L173;
        String r212 = r51;
        String r213 = "ordered";
    L200:
        if (r52 == false) goto L213;
        if (r47 == null) goto L212;
        String r53 = r47.optString("mobile_session_id");
        if (r53 == null) goto L212;
        String r54 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r53, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r54 == null) goto L212;
        if (a(r54, 128) == true) goto L210;
        r54 = null;
    L210:
        if (r54 == null) goto L212;
    L214:
        if (r52 == false) goto L227;
        if (r34 == null) goto L221;
        String r113 = r34.x();
        if (r113 == null) goto L221;
        int r310 = r14;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r113, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L223;
    L222:
        r113 = null;
    L223:
        if (r113 != null) goto L225;
    L228:
        if (r47 != null) goto L235;
        if (r34 == null) goto L231;
        List<f> r55 = r34.y();
    L232:
        if (r55 != null) goto L260;
        r55 = CollectionsKt.emptyList();
    L260:
        String r56 = r78.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r56, "optString(...)");
        String r311 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r56, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 160);
        String r57 = r78.optString("tool_name");
        Intrinsics.checkNotNullExpressionValue(r57, "optString(...)");
        String r312 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r57, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 80);
        int r114 = RangesKt.coerceIn(r78.optInt("round", 0), 0, 1000);
        String r58 = r78.optString("operation");
        Intrinsics.checkNotNullExpressionValue(r58, "optString(...)");
        String r313 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r58, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 16);
        String r59 = r78.optString("effect");
        Intrinsics.checkNotNullExpressionValue(r59, "optString(...)");
        String r314 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r59, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 24);
        boolean r410 = r78.optBoolean("requires_confirmation", false);
        String r60 = r78.optString("tool_display_name");
        Intrinsics.checkNotNullExpressionValue(r60, "optString(...)");
        String r315 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r60, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 80);
        String r61 = r78.optString("tool_type");
        Intrinsics.checkNotNullExpressionValue(r61, "optString(...)");
        String r214 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r61, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 24);
        if (r47 == null) goto L274;
        String r62 = r47.optString("title");
        if (r62 == null) goto L274;
        String r63 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r62, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r63 == null) goto L274;
        String r64 = StringsKt.take(r63, 120);
        if (r64 == null) goto L274;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r64, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L272;
        r64 = null;
    L272:
        if (r64 == null) goto L274;
    L279:
        String r411 = r64;
    L280:
        if (r47 == null) goto L293;
        String r65 = r47.optString("subtitle");
        if (r65 == null) goto L293;
        String r66 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r65, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r66 == null) goto L293;
        String r67 = StringsKt.take(r66, 160);
        if (r67 == null) goto L293;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r67, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L291;
        r67 = null;
    L291:
        if (r67 == null) goto L293;
    L298:
        String r316 = r67;
    L299:
        if (r47 == null) goto L312;
        String r68 = r47.optString("markdown");
        if (r68 == null) goto L312;
        String r69 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r68, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r69 == null) goto L312;
        String r70 = StringsKt.take(r69, 4000);
        if (r70 == null) goto L312;
        boolean r317 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r70, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L310;
        r70 = null;
    L310:
        if (r70 != null) goto L318;
    L313:
        if (r34 == null) goto L315;
        r70 = r34.u();
    L316:
        if (r70 != null) goto L318;
        String r412 = "";
    L319:
        CharSequence r71 = (CharSequence) ZeusTransformUtils.preCheckCast(r54, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r71) == false) goto L326;
        if (r34 == null) goto L323;
        r71 = r34.x();
    L324:
        if (r71 != null) goto L326;
        r71 = "";
        goto L326
    L323:
        r71 = null;
    L326:
        long r413 = r210;
        String r79 = r26;
        boolean r414 = r211;
        String r318 = r46;
        i r115 = new i(r46, r23, r110, r111, r311, r312, r114, r0, r413, r310, r79, r112, r42, r313, r314, r410, r315, r214, r411, r316, r412, r212, r213, (String) ZeusTransformUtils.preCheckCast(r71, String.class, "com.obric.memorydata.plugin"), r55);
        Iterable r72 = (Iterable) ZeusTransformUtils.preCheckCast(a(r30), Iterable.class, "com.obric.memorydata.plugin");
        Collection r73 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r74 = r72.iterator();
    L328:
        if (r74.hasNext() == false) goto L342;
        Object r75 = r74.next();
        i r80 = (i) ZeusTransformUtils.preCheckCast(r75, i.class, "com.obric.memorydata.plugin");
        if (r414 == true) goto L332;
        String r81 = r79;
        String r82 = r318;
        boolean r116 = Intrinsics.areEqual(r80.a(), r82);
    L339:
        if (r116 == true) goto L341;
        r73.add(r75);
    L341:
        r79 = r81;
        r318 = r82;
        goto L328
    L332:
        if (r80.j() < 3) goto L336;
        r81 = r79;
        if (Intrinsics.areEqual(r80.k(), r81) == false) goto L337;
        r116 = r317;
        r82 = r318;
    L337:
        r82 = r318;
        r116 = false;
        goto L339
    L336:
        r81 = r79;
        goto L337
    L342:
        List r1 = CollectionsKt.takeLast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r73, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), r115), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), 80);
        if (f.contains(r110) == true) goto L350;
        int r83 = 0;
        String r84 = null;
        if (StringsKt.startsWith$default(r110, "run_", false, 2, null) == false) goto L349;
        String r85 = r111;
        if (g.contains(r85) == false) goto L349;
    L352:
        if (g.contains(r85) == true) goto L354;
    L353:
        List r215 = r1;
        JSONObject r86 = r78.optJSONObject("details");
        if (r86 == null) goto L369;
        if (r30 == null) goto L367;
        int r117 = r30.f();
    L368:
        int r118 = RangesKt.coerceAtLeast(r86.optInt("suggestion_count", r117), r83);
    L371:
        int r216 = r118;
    L373:
        String r87 = r78.optString("trace_id");
        Intrinsics.checkNotNullExpressionValue(r87, "optString(...)");
        CharSequence r88 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r87, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r88) == false) goto L382;
        if (r30 == null) goto L377;
        String r119 = r30.b();
    L378:
        if (r119 == null) goto L381;
        r39 = r119;
    L381:
        r88 = r39;
        goto L382
    L377:
        r119 = r84;
    L382:
        String r120 = (String) ZeusTransformUtils.preCheckCast(r88, String.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L385;
        long r217 = r30.d();
    L386:
        if (r30 == null) goto L388;
        long r89 = r30.e();
    L390:
        return new g(r11, r120, r85, r217, Math.max(r89, r413), r216, r215);
    L388:
        r89 = 0;
        goto L390
    L385:
        r217 = r413;
        goto L386
    L367:
        r117 = r83;
        goto L368
    L369:
        if (r30 == null) goto L372;
        r118 = r30.f();
        goto L371
    L372:
        r216 = r83;
        goto L373
    L354:
        Iterable r90 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r91 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r90, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r92 = r90.iterator();
    L356:
        if (r92.hasNext() == false) goto L362;
        i r415 = (i) ZeusTransformUtils.preCheckCast(r92.next(), i.class, "com.obric.memorydata.plugin");
        if (SetsKt.setOf(new String[]{"pending", "running", "waiting"}).contains(r415.d()) == false) goto L360;
        String r510 = null;
        String r511 = null;
        int r512 = 0;
        int r513 = 0;
        long r514 = 0;
        int r515 = 0;
        String r516 = null;
        int r610 = 0;
        String r611 = null;
        String r612 = null;
        String r613 = null;
        boolean r614 = false;
        String r615 = null;
        String r616 = null;
        String r617 = null;
        String r618 = null;
        String r619 = null;
        String r710 = null;
        String r711 = null;
        String r712 = null;
        List<f> r713 = a(r415.y(), r85);
        int r714 = 16777207;
        Object r715 = null;
        String r517 = r85;
    L361:
        r91.add(i.a(r415, null, null, null, r517, r510, r511, r512, r513, r514, r515, r516, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715));
        goto L356
    L360:
        r517 = null;
        r510 = null;
        r511 = null;
        r512 = 0;
        r513 = 0;
        r514 = 0;
        r515 = 0;
        r516 = null;
        r610 = 0;
        r611 = null;
        r612 = null;
        r613 = null;
        r614 = false;
        r615 = null;
        r616 = null;
        r617 = null;
        r618 = null;
        r619 = null;
        r710 = null;
        r711 = null;
        r712 = null;
        r713 = c(r415.y());
        r714 = ViewCompat.MEASURED_SIZE_MASK;
        r715 = null;
        goto L361
    L362:
        r1 = (List) ZeusTransformUtils.preCheckCast(r91, List.class, "com.obric.memorydata.plugin");
    L349:
        r85 = "running";
        goto L352
    L350:
        r85 = r111;
        r83 = 0;
        r84 = null;
        goto L352
    L315:
        r70 = null;
    L318:
        r412 = r70;
    L312:
        r317 = true;
    L293:
        if (r34 == null) goto L295;
        r67 = r34.t();
    L296:
        if (r67 != null) goto L298;
        r316 = "";
        goto L299
    L295:
        r67 = null;
    L274:
        if (r34 == null) goto L276;
        r64 = r34.s();
    L277:
        if (r64 != null) goto L279;
        r411 = "";
        goto L280
    L276:
        r64 = null;
        goto L277
    L231:
        r55 = null;
        goto L232
    L235:
        if (r52 == false) goto L245;
        JSONArray r93 = r47.optJSONArray("items");
        if (r34 == null) goto L239;
        List<f> r94 = r34.y();
    L240:
        if (r94 != null) goto L242;
        r94 = CollectionsKt.emptyList();
    L242:
        r55 = a(r93, r94, StatefulPresentationKind.MOBILE_USE);
        if (r55 != null) goto L260;
        return r30;
    L239:
        r94 = null;
        goto L240
    L245:
        if (r2 == false) goto L255;
        JSONArray r95 = r47.optJSONArray("items");
        if (r34 == null) goto L249;
        List<f> r96 = r34.y();
    L250:
        if (r96 != null) goto L252;
        r96 = CollectionsKt.emptyList();
    L252:
        r55 = a(r95, r96, StatefulPresentationKind.ACTIVITY);
        if (r55 != null) goto L260;
        return r30;
    L249:
        r96 = null;
        goto L250
    L255:
        JSONArray r97 = r47.optJSONArray("items");
        if (Intrinsics.areEqual(r42, "result") == false) goto L258;
        int r98 = 4000;
    L259:
        r55 = a(r97, r98);
        goto L260
    L258:
        r98 = 240;
        goto L259
    L225:
        if (Intrinsics.areEqual(r34.x(), r54) == true) goto L228;
        return r30;
    L221:
        r310 = r14;
        goto L222
    L227:
        r310 = r14;
    L212:
        return r30;
    L213:
        r54 = "";
        goto L214
    L173:
        if (r2 == false) goto L181;
        if (r47 == null) goto L181;
        String r121 = r47.optString("list_style");
        Intrinsics.checkNotNullExpressionValue(r121, "optString(...)");
        r212 = r51;
        String r99 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r121, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (d.contains(r99) == true) goto L179;
        r99 = null;
    L179:
        if (r99 != null) goto L199;
        return r30;
    L199:
        r213 = r99;
    L181:
        r212 = r51;
        if (r2 == false) goto L194;
        if (r34 == null) goto L185;
        r99 = r34.w();
    L186:
        if (r99 != null) goto L189;
        r99 = "";
    L189:
        if (d.contains(r99) == true) goto L192;
        r99 = null;
    L192:
        if (r99 != null) goto L199;
        return r30;
    L185:
        r99 = null;
        goto L186
    L194:
        if (r34 == null) goto L196;
        r99 = r34.w();
    L197:
        if (r99 != null) goto L199;
        r213 = "";
        goto L200
    L196:
        r99 = null;
        goto L197
    L166:
        if (Intrinsics.areEqual(r42, "action") == false) goto L170;
        if (Intrinsics.areEqual(r51, "activity") == false) goto L170;
        r2 = true;
        goto L171
    L158:
        if (Intrinsics.areEqual(r42, "action") == false) goto L162;
        if (Intrinsics.areEqual(r51, "mobile_use") == false) goto L162;
        r52 = true;
        goto L164
    L151:
        r50 = null;
    L154:
        r51 = r50;
    L136:
        r50 = null;
        goto L137
    L135:
        r211 = r12;
        goto L136
    L117:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L121;
        if (r112 <= 0) goto L121;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r42, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L122;
    L121:
        return r30;
    L107:
        r40 = null;
        goto L108
    L95:
        if (f6495a.contains(r37) == true) goto L98;
        r38 = false;
        goto L99
    L91:
        r35 = RangesKt.coerceAtLeast(r78.optInt("stage_order", r0), 0);
        goto L92
    L80:
        if (Intrinsics.areEqual(r31.k(), r26) == false) goto L82;
        r32 = true;
        goto L83
    L86:
        r210 = r18;
        r33 = null;
    L88:
        r210 = r18;
        r34 = null;
        goto L89
    L69:
        r23 = "action";
        goto L70
    L55:
        if (r16 > (r13 + 300000)) goto L57;
        r17 = true;
        goto L58
    L51:
        r12 = false;
        goto L52
    L36:
        r8 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((i) ZeusTransformUtils.preCheckCast(r7.next(), i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin");
    L38:
        if (r7.hasNext() == false) goto L42;
        Comparable r100 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((i) ZeusTransformUtils.preCheckCast(r7.next(), i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin");
        if (r8.compareTo(r100) >= 0) goto L38;
        r8 = r100;
    L45:
        r10 = 0;
        goto L46
    L27:
        if (Intrinsics.areEqual(r76.a(), r11) == false) goto L29;
        r30 = r76;
        goto L30
    L7:
        if (r14 >= 6) goto L9;
        r3 = true;
        goto L10
    }

    private static final String a(String r5) {
        String r6 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 1024);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0.length()) goto L9;
        if (CharsKt.isWhitespace(r0.charAt(r2)) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        return "";
    L14:
        if (StringsKt.startsWith(r6, ReportConsts.HTTPS, true) == false) goto L16;
    L17:
        r1 = true;
    L18:
        if (r1 == true) goto L21;
        r6 = null;
    L21:
        if (r6 != null) goto L24;
        return "";
    L24:
        return r6;
    L16:
        if (StringsKt.startsWith(r6, "http://", true) == false) goto L18;
    L9:
        r3 = false;
        goto L11
    }

    private static final String a(String r9, boolean r10) {
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r10 == true) goto L13;
        if (Intrinsics.areEqual(r11, "succeeded") == false) goto L8;
        return "succeeded";
    L8:
        if (Intrinsics.areEqual(r11, "failed") == true) goto L19;
        return "running";
    L19:
        return "failed";
    L13:
        if (SetsKt.setOf(new String[]{"pending", "running", "waiting", "succeeded", "failed", "cancelled", "timed_out", "accepted", "outcome_unknown"}).contains(r11) == true) goto L16;
        r11 = null;
    L16:
        if (r11 != null) goto L21;
        return "unknown";
    L21:
        return r11;
    }

    private static final List<i> a(g r0) {
        if (r0 == null) goto L6;
        List<i> r1 = r0.g();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return CollectionsKt.emptyList();
    }

    private static final List<f> a(List<f> r20) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.memorydata.plugin");
        if (h.contains(r4.j()) == false) goto L8;
        int r18 = 1023;
    L9:
        r2.add(f.a(r4, null, null, null, null, 0, null, null, null, 0, null, false, "", r18, null));
        goto L4
    L8:
        r18 = 2047;
        goto L9
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    private static final List<f> a(List<f> r20, String r21) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.h(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L13;
        if (h.contains(r4.j()) == false) goto L11;
        String r15 = r4.j();
    L12:
        r4 = f.a(r4, null, null, null, null, 0, null, null, null, 0, r15, false, "", FrameMetricsAggregator.EVERY_DURATION, null);
        goto L13
    L11:
        r15 = r21;
    L13:
        r2.add(r4);
        goto L4
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    private static final List<f> a(JSONArray r25, int r26) {
        if (r25 == null) goto L5;
        List r1 = CollectionsKt.createListBuilder();
        int r2 = Math.min(r25.length(), 64);
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L16;
        JSONObject r4 = r25.optJSONObject(r3);
        if (r4 == null) goto L14;
        String r5 = r4.optString("title");
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        String r12 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 120);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L14;
        String r7 = r4.optString("group_key");
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");
        String r10 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 40);
        String r8 = r4.optString("group_title");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        String r11 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 40);
        String r9 = r4.optString("description");
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        String r13 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r26);
        long r14 = RangesKt.coerceAtLeast(r4.optLong("timestamp_ms", 0), 0);
        String r15 = r4.optString("link_url");
        Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
        r1.add(new f(r10, r11, r12, r13, r14, a(r15), a(r4.optJSONObject("artifact_reference")), null, 0, null, false, null, Utf8.MASK_2BYTES, null));
    L14:
        r3 = r3 + 1;
        goto L7
    L16:
        return CollectionsKt.build(r1);
    L5:
        return CollectionsKt.emptyList();
    }

    private static final List<f> a(JSONArray r29, StatefulPresentationKind r30) {
        JSONArray r0 = r29;
        List<f> r2 = null;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r29.length() <= 64) goto L8;
        return null;
    L8:
        List r3 = CollectionsKt.createListBuilder();
        int r4 = r29.length();
        boolean r5 = false;
        int r6 = 0;
    L10:
        if (r6 >= r4) goto L64;
        JSONObject r9 = r0.optJSONObject(r6);
        if (r9 == null) goto L13;
        String r10 = r9.optString("item_id");
        Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        int r15 = r9.optInt("ordinal", -1);
        String r12 = r9.optString("title");
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
        String r14 = StringsKt.take(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString(), 120);
        String r13 = r9.optString("state");
        Intrinsics.checkNotNullExpressionValue(r13, "optString(...)");
        String r16 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r17 = r9.optString("action");
        Intrinsics.checkNotNullExpressionValue(r17, "optString(...)");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r24 = r9.optBoolean("is_current", r5);
        int r18 = a.f6497a[r30.ordinal()];
        if (r18 == 1) goto L20;
        if (r18 != 2) goto L19;
        Set<String> r19 = c;
    L21:
        int r8 = a.f6497a[r30.ordinal()];
        int r28 = r4;
        if (r8 != 1) goto L24;
        Set r1 = SetsKt.setOf(new String[]{"pending", "running", "succeeded"});
    L29:
        int r20 = a.f6497a[r30.ordinal()];
        if (r20 != 1) goto L32;
        boolean r21 = SetsKt.setOf(new String[]{"", "open_mobile_use_player"}).contains(r7);
    L38:
        if (a(r11, 160) == false) goto L62;
        if (1 <= r15) goto L42;
    L44:
        boolean r22 = false;
    L45:
        if (r22 == false) goto L139;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L140;
        if (r19.contains(r16) == false) goto L141;
        if (r21 == false) goto L142;
        if (r30 != StatefulPresentationKind.ACTIVITY) goto L57;
        if (r24 == false) goto L57;
        if (r1.contains(r16) == true) goto L57;
        return null;
    L57:
        long r110 = RangesKt.coerceAtLeast(r9.optLong("timestamp_ms", 0), 0);
        if (r30 != StatefulPresentationKind.ACTIVITY) goto L60;
        String r23 = r9.optString("link_url");
        Intrinsics.checkNotNullExpressionValue(r23, "optString(...)");
        String r111 = a(r23);
    L61:
        r3.add(new f("", "", r14, "", r110, r111, null, r11, r15, r16, r24, r7, 64, null));
        r6 = r6 + 1;
        r0 = r29;
        r4 = r28;
        r2 = null;
        r5 = false;
        goto L10
    L60:
        r111 = "";
        goto L61
    L142:
        return null;
    L141:
        return null;
    L140:
        return null;
    L139:
        return null;
    L42:
        if (r15 >= 10001) goto L44;
        r22 = true;
        goto L45
    L62:
        return null;
    L32:
        if (r20 != 2) goto L35;
        r21 = StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L38
    L35:
        throw new NoWhenBranchMatchedException();
    L24:
        if (r8 != 2) goto L27;
        r1 = SetsKt.setOf(new String[]{"pending", "running", "waiting", "accepted"});
        goto L29
    L27:
        throw new NoWhenBranchMatchedException();
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        r19 = f6496b;
        goto L21
    L13:
        return r2;
    L64:
        List<f> r25 = CollectionsKt.build(r3);
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r26.iterator();
    L66:
        if (r31.hasNext() == false) goto L69;
        r27.add(((f) ZeusTransformUtils.preCheckCast(r31.next(), f.class, "com.obric.memorydata.plugin")).h());
        goto L66
    L69:
        if (CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).size() != r25.size()) goto L110;
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r34 = r32.iterator();
    L72:
        if (r34.hasNext() == false) goto L75;
        r33.add(Integer.valueOf(((f) ZeusTransformUtils.preCheckCast(r34.next(), f.class, "com.obric.memorydata.plugin")).i()));
        goto L72
    L75:
        if (CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r33, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).size() != r25.size()) goto L144;
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zipWithNext((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r35, Collection.class) == true) goto L79;
    L81:
        Iterator r36 = r35.iterator();
    L83:
        if (r36.hasNext() == false) goto L80;
        Pair r37 = (Pair) ZeusTransformUtils.preCheckCast(r36.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((f) ZeusTransformUtils.preCheckCast(r37.component1(), f.class, "com.obric.memorydata.plugin")).i() < ((f) ZeusTransformUtils.preCheckCast(r37.component2(), f.class, "com.obric.memorydata.plugin")).i()) goto L87;
        boolean r38 = true;
    L88:
        if (r38 == false) goto L83;
        boolean r39 = true;
    L90:
        if (r39 == false) goto L92;
        return null;
    L92:
        if (r30 != StatefulPresentationKind.ACTIVITY) goto L109;
        Iterable r40 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r40, Collection.class) == true) goto L96;
    L98:
        Iterator r41 = r40.iterator();
        int r42 = 0;
    L100:
        if (r41.hasNext() == false) goto L106;
        if (((f) ZeusTransformUtils.preCheckCast(r41.next(), f.class, "com.obric.memorydata.plugin")).k() == false) goto L100;
        r42 = r42 + 1;
        if (r42 >= 0) goto L100;
        CollectionsKt.throwCountOverflow();
        goto L100
    L106:
        int r43 = 1;
    L107:
        if (r42 <= r43) goto L109;
        return null;
    L96:
        if (((Collection) ZeusTransformUtils.preCheckCast(r40, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L98;
        r43 = 1;
        r42 = 0;
    L109:
        return r25;
    L87:
        r38 = false;
    L80:
        r39 = false;
        goto L90
    L79:
        if (((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L81;
    L144:
        return null;
    L110:
        return null;
    }

    private static final List<f> a(JSONArray r27, List<f> r28, StatefulPresentationKind r29) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L5;
    L7:
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.memorydata.plugin")).h(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        return null;
    L16:
        List<f> r6 = a(r27, r29);
        if (r6 != null) goto L19;
        return null;
    L19:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        Object r11 = r8.next();
        r9.put(((f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.memorydata.plugin")).h(), r11);
        goto L21
    L23:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == true) goto L26;
        Comparable r12 = null;
    L32:
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L35;
        r4 = r13.intValue();
    L35:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L37:
        if (r14.hasNext() == false) goto L49;
        f r15 = (f) ZeusTransformUtils.preCheckCast(r14.next(), f.class, "com.obric.memorydata.plugin");
        f r16 = (f) ZeusTransformUtils.preCheckCast(r9.get(r15.h()), f.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L41;
    L43:
        if (r16 != null) goto L37;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L37;
        if (r15.i() > r4) goto L37;
        return null;
    L41:
        if (r16.i() == r15.i()) goto L43;
        return null;
    L49:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L51:
        if (r19.hasNext() == false) goto L53;
        Object r110 = r19.next();
        r18.put(((f) ZeusTransformUtils.preCheckCast(r110, f.class, "com.obric.memorydata.plugin")).h(), r110);
        goto L51
    L53:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r1.iterator();
    L55:
        if (r21.hasNext() == false) goto L66;
        f r22 = (f) ZeusTransformUtils.preCheckCast(r21.next(), f.class, "com.obric.memorydata.plugin");
        f r111 = (f) ZeusTransformUtils.preCheckCast(r18.get(r22.h()), f.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L65;
        if (h.contains(r22.j()) == true) goto L62;
    L64:
        r22 = r111;
        goto L65
    L62:
        if (Intrinsics.areEqual(r111.j(), r22.j()) == true) goto L64;
        r22 = f.a(r111, null, null, null, null, 0, null, null, null, 0, r22.j(), false, "", FrameMetricsAggregator.EVERY_DURATION, null);
    L65:
        r20.add(r22);
        goto L55
    L66:
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L68:
        if (r26.hasNext() == false) goto L72;
        Object r30 = r26.next();
        if ((!r9.containsKey(((f) ZeusTransformUtils.preCheckCast(r30, f.class, "com.obric.memorydata.plugin")).h())) == false) goto L68;
        r25.add(r30);
        goto L68
    L72:
        List r31 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r23, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0287b(), Comparator.class, "com.obric.memorydata.plugin"));
        if (r31.size() <= 64) goto L75;
        return null;
    L75:
        int r32 = a.f6497a[r29.ordinal()];
        if (r32 == 1) goto L83;
        if (r32 != 2) goto L81;
        return a(r31);
    L81:
        throw new NoWhenBranchMatchedException();
    L83:
        return b(r31);
    L26:
        r12 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((f) ZeusTransformUtils.preCheckCast(r10.next(), f.class, "com.obric.memorydata.plugin")).i()), Comparable.class, "com.obric.memorydata.plugin");
    L28:
        if (r10.hasNext() == false) goto L32;
        Comparable r112 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((f) ZeusTransformUtils.preCheckCast(r10.next(), f.class, "com.obric.memorydata.plugin")).i()), Comparable.class, "com.obric.memorydata.plugin");
        if (r12.compareTo(r112) >= 0) goto L28;
        r12 = r112;
    L6:
        r5 = false;
        goto L14
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private static final boolean a(String r5, int r6) {
        int r0 = r5.length();
        if (1 > r0) goto L6;
        if (r0 > r6) goto L6;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L48;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r9 = 0;
    L10:
        if (r9 >= r8.length()) goto L44;
        char r1 = r8.charAt(r9);
        if ('a' <= r1) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L19;
    L40:
        boolean r2 = true;
    L41:
        if (r2 == false) goto L42;
        r9 = r9 + 1;
        goto L10
    L42:
        boolean r10 = false;
    L45:
        if (r10 == false) goto L48;
        return true;
    L19:
        if ('A' <= r1) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == true) goto L40;
        if ('0' > r1) goto L29;
        if (r1 >= ':') goto L29;
        boolean r11 = true;
    L30:
        if (r11 == true) goto L40;
        if (r1 == '-') goto L40;
        if (r1 == '_') goto L40;
        if (r1 == '.') goto L40;
        if (r1 == ':') goto L40;
        r2 = false;
    L29:
        r11 = false;
        goto L30
    L21:
        if (r1 >= '[') goto L23;
        r4 = true;
        goto L24
    L14:
        if (r1 >= '{') goto L16;
        r3 = true;
        goto L17
    L44:
        r10 = true;
    L48:
        return false;
    L6:
        r7 = false;
        goto L7
    }

    private static final int b(i r2) {
        if (r2.j() < 3) goto L8;
        if (r2.l() <= 0) goto L8;
        return r2.l();
    L8:
        return r2.h();
    }

    private static final List<f> b(List<f> r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (r6.k() == false) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        if (Intrinsics.areEqual(r6.j(), "running") == true) goto L11;
        r7 = false;
        goto L12
    L14:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == true) goto L17;
        Object r9 = null;
    L26:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r1.iterator();
    L28:
        if (r12.hasNext() == false) goto L52;
        f r13 = (f) ZeusTransformUtils.preCheckCast(r12.next(), f.class, "com.obric.memorydata.plugin");
        String r14 = r13.h();
        if (r10 == null) goto L32;
        String r15 = r10.h();
    L34:
        if (Intrinsics.areEqual(r14, r15) == true) goto L36;
    L45:
        String r16 = null;
        String r17 = null;
        String r18 = null;
        String r19 = null;
        long r110 = 0;
        String r111 = null;
        com.obric.aiproactive.api.d r112 = null;
        String r113 = null;
        int r114 = 0;
        if (g.contains(r13.j()) == false) goto L48;
        String r115 = null;
        boolean r116 = false;
        int r21 = 1023;
        Object r22 = null;
    L49:
        String r20 = "";
    L50:
        r11.add(f.a(r13, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r20, r21, r22));
        goto L28
    L48:
        r116 = false;
        r21 = FrameMetricsAggregator.EVERY_DURATION;
        r22 = null;
        r115 = "pending";
        goto L49
    L36:
        if (SetsKt.setOf(new String[]{"pending", "running", "succeeded"}).contains(r13.j()) == false) goto L45;
        r16 = null;
        r17 = null;
        r18 = null;
        r19 = null;
        r110 = 0;
        r111 = null;
        r112 = null;
        r113 = null;
        r114 = 0;
        r115 = null;
        r116 = true;
        String r24 = r13.l();
        if (Intrinsics.areEqual(r24, "open_mobile_use_player") == true) goto L41;
        r24 = null;
    L41:
        if (r24 != null) goto L43;
        r20 = "";
    L44:
        r21 = 1023;
        r22 = null;
        goto L50
    L43:
        r20 = r24;
        goto L44
    L32:
        r15 = null;
        goto L34
    L52:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
    L17:
        r9 = r8.next();
        if (r8.hasNext() == false) goto L26;
        int r25 = ((f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin")).i();
    L21:
        Object r26 = r8.next();
        int r27 = ((f) ZeusTransformUtils.preCheckCast(r26, f.class, "com.obric.memorydata.plugin")).i();
        if (r25 >= r27) goto L25;
        r9 = r26;
        r25 = r27;
    L25:
        if (r8.hasNext() == true) goto L21;
        goto L26
    }

    private static final List<f> c(List<f> r20) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.h(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L9;
        r4 = f.a(r4, null, null, null, null, 0, null, null, null, 0, null, false, "", 1023, null);
    L9:
        r2.add(r4);
        goto L4
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }
}
