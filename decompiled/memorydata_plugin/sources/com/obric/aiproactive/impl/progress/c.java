package com.obric.aiproactive.impl.progress;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiproactive.api.AiProactiveArtifactState;
import com.obric.aiproactive.api.AiProactiveArtifactType;
import com.obric.aiproactive.api.f;
import com.obric.aiproactive.api.g;
import com.obric.aiproactive.api.h;
import com.obric.aiproactive.api.i;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0005J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\u0015\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u0010H\u0000¢\u0006\u0002\b-J\u0017\u0010.\u001a\u0004\u0018\u00010\u00102\u0006\u0010/\u001a\u00020!H\u0000¢\u0006\u0002\b0J\u0011\u00101\u001a\u00020!*\u00020\u0010H\u0000¢\u0006\u0002\b2J\u0019\u00103\u001a\u0004\u0018\u00010\u00102\b\u0010/\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b4J\u0018\u00105\u001a\b\u0012\u0004\u0012\u000207062\b\u00108\u001a\u0004\u0018\u000109H\u0002J\u0014\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/aiproactive/impl/progress/AiProactiveAgentRunStore;", "", "<init>", "()V", "TAG", "", "STORE_REPO", "STORE_KEY_PREFIX", "MAX_STORED_RUNS", "", "lock", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/aiproactive/api/AiProactiveAgentRunListener;", "runs", "Ljava/util/LinkedHashMap;", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "Lkotlin/collections/LinkedHashMap;", "cancelledReceipts", "", "loadedStoreKey", CommonConsts.APM_INNER_EVENT_COST_START, "", "registerListener", "listener", "unregisterListener", "latest", "find", "executionId", "isCancellationRecorded", "", "reportProgress", "payload", "Lorg/json/JSONObject;", "markCancelledOrCreate", "ACTIVE_RUN_STATES", "", "trimLocked", "trimCancelledReceiptsLocked", "ensureAccountLocked", "buildStoreKey", "restoreLocked", "persistLocked", "encodeForTest", "run", "encodeForTest$ai_proactive_impl_obricRelease", "decodeForTest", "json", "decodeForTest$ai_proactive_impl_obricRelease", "toJson", "toJson$ai_proactive_impl_obricRelease", "parseRun", "parseRun$ai_proactive_impl_obricRelease", "parseDisplayItems", "", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDisplayItemDto;", "array", "Lorg/json/JSONArray;", "parseArtifactReference", "Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "item", "ARTIFACT_REFERENCE_ID_PATTERN", "Lkotlin/text/Regex;", "MAX_ARTIFACT_REFERENCE_DISPLAY_NAME_LENGTH", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f6500b = null;
    private static final CopyOnWriteArraySet<h> c = null;
    private static final LinkedHashMap<String, g> d = null;
    private static final LinkedHashMap<String, Long> e = null;
    private static String f;
    private static final Set<String> g = null;
    private static final Regex h = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            i r2 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin");
            if (r2.j() >= 3) goto L5;
        L7:
            int r5 = r2.h();
        L8:
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin");
            i r7 = (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.memorydata.plugin");
            if (r7.j() >= 3) goto L11;
        L13:
            int r8 = r7.h();
        L15:
            return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r8), Comparable.class, "com.obric.memorydata.plugin"));
        L11:
            if (r7.l() <= 0) goto L13;
            r8 = r7.l();
            goto L15
        L5:
            if (r2.l() <= 0) goto L7;
            r5 = r2.l();
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6501a;

        public b(Comparator r3) {
            this.f6501a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f6501a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.progress.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0288c<T> implements Comparator {
        public C0288c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f6499a = new c();
        f6500b = new Object();
        c = new CopyOnWriteArraySet();
        d = new LinkedHashMap();
        e = new LinkedHashMap();
        f = "";
        g = SetsKt.setOf(new String[]{"pending", "running", "waiting"});
        h = new Regex("[A-Za-z0-9._:-]{1,128}");
    }

    private c() {
    }

    private final List<f> a(JSONArray r24) {
        JSONArray r0 = r24;
        if (r0 == null) goto L5;
        List r1 = CollectionsKt.createListBuilder();
        int r2 = Math.min(r24.length(), 64);
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L16;
        JSONObject r4 = r0.optJSONObject(r3);
        if (r4 == null) goto L14;
        String r5 = r4.optString("title");
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L14;
        String r10 = r4.optString("group_key");
        Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
        String r11 = r4.optString("group_title");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        String r13 = r4.optString("description");
        Intrinsics.checkNotNullExpressionValue(r13, "optString(...)");
        long r14 = RangesKt.coerceAtLeast(r4.optLong("timestamp"), 0);
        String r7 = r4.optString("link_url");
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");
        com.obric.aiproactive.api.d r17 = f6499a.c(r4.optJSONObject("artifact_reference"));
        String r8 = r4.optString("item_id");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        int r19 = r4.optInt("ordinal");
        String r9 = r4.optString("state");
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        boolean r21 = r4.optBoolean("is_current");
        String r6 = r4.optString("action");
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");
        r1.add(new f(r10, r11, r12, r13, r14, r7, r17, r8, r19, r9, r21, r6));
    L14:
        r3 = r3 + 1;
        r0 = r24;
        goto L7
    L16:
        return CollectionsKt.build(r1);
    L5:
        return CollectionsKt.emptyList();
    }

    private static final JSONObject b(g r1) {
        Intrinsics.checkNotNullParameter(r1, "run");
        return f6499a.a(r1);
    }

    private final com.obric.aiproactive.api.d c(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r0 = r10.optString("artifact_id");
        Intrinsics.checkNotNullExpressionValue(r0, "optString(...)");
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        AiProactiveArtifactType.a r2 = AiProactiveArtifactType.Companion;
        String r4 = r10.optString("artifact_type");
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        AiProactiveArtifactType r3 = r2.a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r3 != null) goto L8;
        return null;
    L8:
        String r5 = r10.optString(Api.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        AiProactiveArtifactState.a r7 = AiProactiveArtifactState.Companion;
        String r11 = r10.optString("state");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        AiProactiveArtifactState r12 = r7.a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r12 != null) goto L12;
        return null;
    L12:
        if (h.matches((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L14;
        return null;
    L14:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
        return null;
    L16:
        if (r6.length() > 120) goto L43;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r9 = false;
        int r13 = 0;
    L19:
        if (r13 >= r8.length()) goto L35;
        char r14 = r8.charAt(r13);
        if (r14 != '/') goto L23;
    L31:
        boolean r15 = true;
    L32:
        if (r15 == true) goto L33;
        r13 = r13 + 1;
        goto L19
    L33:
        r9 = true;
        goto L35
    L23:
        if (r14 == '\\') goto L31;
        if (r14 == '\n') goto L31;
        if (r14 == '\r') goto L31;
        if (r14 == 0) goto L31;
        r15 = false;
    L35:
        if (r9 == false) goto L38;
        return null;
    L38:
        return new com.obric.aiproactive.api.d(r1, r3, r6, r12);
    L43:
        return null;
    }

    private final void c() {
        Collection<g> r4 = d.values();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-values>(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0288c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 5), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        HashSet r7 = (HashSet) ZeusTransformUtils.preCheckCast(r0, HashSet.class, "com.obric.memorydata.plugin");
        d.keySet().retainAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
    }

    private final void d() {
        com.obric.aiproactive.impl.progress.a.f6494a.a((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin"));
    }

    private final void e() {
        String r0 = f();
        if (Intrinsics.areEqual(f, r0) == false) goto L5;
        return;
    L5:
        d.clear();
        e.clear();
        f = r0;
        g();
    }

    private final String f() {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r2) == false) goto L6;
        r2 = "guest";
    L6:
        return "ai_proactive_agent_runs_v1_" + ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    }

    private final void g() {
        String r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(f, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        c r6 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        d r2 = com.obric.aiproactive.impl.progress.a.f6494a.a(r0, (Function1) ZeusTransformUtils.preCheckCast(new AiProactiveAgentRunStore$restoreLocked$1$restored$1(r6), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3.next(), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        ((Map) ZeusTransformUtils.preCheckCast(d, Map.class, "com.obric.memorydata.plugin")).put(r4.a(), r4);     // Catch: Throwable -> L9
        goto L5
    L7:
        e.putAll(r2.b());     // Catch: Throwable -> L9
        r6.c();     // Catch: Throwable -> L9
        r6.d();     // Catch: Throwable -> L9
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L18;
        d.clear();
        e.clear();
        RunLog.INSTANCE.error("AgentRunStore", "restore failed key=" + f, r8);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void h() {
        com.obric.aiproactive.impl.progress.a r0 = com.obric.aiproactive.impl.progress.a.f6494a;
        Collection<g> r1 = d.values();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-values>(...)");
        String r2 = r0.a(r1, (Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin"), $$Lambda$c$tci6oOEfSA0A4MzBzNyn61ap4Wc.INSTANCE);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(f, r2);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L13;
        RunLog.INSTANCE.error("AgentRunStore", "persist failed key=" + f, r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static /* synthetic */ JSONObject lambda$tci6oOEfSA0A4MzBzNyn61ap4Wc(g r0) {
        return b(r0);
    }

    public final g a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "executionId");
        Object r3 = f6500b;
        monitor-enter(r3);
        f6499a.e();     // Catch: Throwable -> L13
        g r0 = (g) ZeusTransformUtils.preCheckCast(d.get(r4), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r0 != null) goto L11;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(e.get(r4), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r1 == null) goto L10;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L13
        r0 = com.obric.aiproactive.impl.progress.a.f6494a.a(r4, r2);     // Catch: Throwable -> L13
        goto L11
    L10:
        r0 = null;
    L11:
        monitor-exit(r3);
        return r0;
    L13:
        th = move-exception;
        throw th;
    }

    public final JSONObject a(g r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        JSONObject r13 = new JSONObject();
        r13.put("execution_id", r14.a());
        r13.put("trace_id", r14.b());
        r13.put("state", r14.c());
        r13.put("started_at", r14.d());
        r13.put("updated_at", r14.e());
        r13.put("suggestion_count", r14.f());
        JSONArray r0 = new JSONArray();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.g(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L13;
        i r2 = (i) ZeusTransformUtils.preCheckCast(r15.next(), i.class, "com.obric.memorydata.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("step_id", r2.a());
        r4.put(EventBody.KEY_CATEGORY, r2.b());
        r4.put("event", r2.c());
        r4.put("state", r2.d());
        r4.put("summary", r2.e());
        r4.put("tool_name", r2.f());
        r4.put("round", r2.g());
        r4.put("sequence", r2.h());
        r4.put("timestamp", r2.i());
        r4.put("protocol_version", r2.j());
        r4.put("stage_id", r2.k());
        r4.put("stage_order", r2.l());
        r4.put("stage_type", r2.m());
        r4.put("operation", r2.n());
        r4.put("effect", r2.o());
        r4.put("requires_confirmation", r2.p());
        r4.put("tool_display_name", r2.q());
        r4.put("tool_type", r2.r());
        r4.put("display_title", r2.s());
        r4.put("display_subtitle", r2.t());
        r4.put("display_markdown", r2.u());
        r4.put("presentation_type", r2.v());
        r4.put("secondary_list_style", r2.w());
        r4.put("mobile_session_id", r2.x());
        JSONArray r5 = new JSONArray();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.y(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.memorydata.plugin");
        JSONObject r8 = new JSONObject();
        r8.put("group_key", r6.a());
        r8.put("group_title", r6.b());
        r8.put("title", r6.c());
        r8.put("description", r6.d());
        r8.put("timestamp", r6.e());
        r8.put("link_url", r6.f());
        com.obric.aiproactive.api.d r9 = r6.g();
        if (r9 == null) goto L11;
        JSONObject r10 = new JSONObject();
        r10.put("artifact_id", r9.a());
        r10.put("artifact_type", r9.b().getWireValue());
        r10.put(Api.KEY_DISPLAY_NAME, r9.c());
        r10.put("state", r9.d().getWireValue());
        Unit r11 = Unit.INSTANCE;
        r8.put("artifact_reference", r10);
    L11:
        r8.put("item_id", r6.h());
        r8.put("ordinal", r6.i());
        r8.put("state", r6.j());
        r8.put("is_current", r6.k());
        r8.put("action", r6.l());
        r5.put(r8);
        goto L7
    L12:
        Unit r7 = Unit.INSTANCE;
        r4.put("display_items", r5);
        r0.put(r4);
        goto L4
    L13:
        Unit r16 = Unit.INSTANCE;
        r13.put("steps", r0);
        return r13;
    }

    public final void a() {
        Object r1 = f6500b;
        monitor-enter(r1);
        f6499a.e();     // Catch: Throwable -> L7
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "listener");
        a();
        ((Collection) ZeusTransformUtils.preCheckCast(c, Collection.class, "com.obric.memorydata.plugin")).add(r5);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r5.onChanged(((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin")).b());     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r3);
        if (r6 == null) goto L13;
        RunLog.INSTANCE.error("AgentRunStore", "initial listener callback failed", r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean a(JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "payload");
        String r10 = r11.optString("execution_id");
        Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return false;
    L5:
        String r0 = null;
        if (com.obric.aiproactive.impl.progress.b.a(null, r12, r11) != null) goto L8;
        return false;
    L8:
        Object r2 = f6500b;
        monitor-enter(r2);
        c r3 = f6499a;     // Catch: Throwable -> L41
        r3.e();     // Catch: Throwable -> L41
        LinkedHashMap<String, g> r4 = d;     // Catch: Throwable -> L41
        g r5 = (g) ZeusTransformUtils.preCheckCast(r4.get(r12), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if (r5 == null) goto L14;
        r0 = r5.c();     // Catch: Throwable -> L41
    L14:
        if (Intrinsics.areEqual(r0, "cancelled") == false) goto L16;
    L39:
        monitor-exit(r2);
        return true;
    L16:
        if (com.obric.aiproactive.impl.progress.a.f6494a.a((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin"), r12) == true) goto L39;
        g r13 = com.obric.aiproactive.impl.progress.b.a(r5, r12, r11);     // Catch: Throwable -> L41
        if (r13 != null) goto L22;
        monitor-exit(r2);
        return false;
    L22:
        if (r13 != r5) goto L25;
        monitor-exit(r2);
        return true;
    L25:
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin")).put(r12, r13);     // Catch: Throwable -> L41
        r3.c();     // Catch: Throwable -> L41
        r3.h();     // Catch: Throwable -> L41
        monitor-exit(r2);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L29:
        if (r14.hasNext() == false) goto L38;
        h r1 = (h) ZeusTransformUtils.preCheckCast(r14.next(), h.class, "com.obric.memorydata.plugin");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L33
        r1.onChanged(r13);     // Catch: Throwable -> L33
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L29;
        RunLog.INSTANCE.error("AgentRunStore", "listener callback failed", r8);
    L33:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L35
    L38:
        return true;
    L41:
        th = move-exception;
        throw th;
    }

    public final g b() {
        Object r8 = f6500b;
        monitor-enter(r8);
        f6499a.e();     // Catch: Throwable -> L20
        Collection<g> r0 = d.values();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r0, "<get-values>(...)");     // Catch: Throwable -> L20
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L20
        if (r1.hasNext() == true) goto L7;
        Object r2 = null;
    L17:
        g r3 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        monitor-exit(r8);
        return r3;
    L7:
        Object r4 = r1.next();     // Catch: Throwable -> L20
        if (r1.hasNext() == true) goto L10;
    L9:
        r2 = r4;
        goto L17
    L10:
        long r5 = ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L20
    L11:
        Object r6 = r1.next();     // Catch: Throwable -> L20
        long r7 = ((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L20
        if (r5 >= r7) goto L15;
        r4 = r6;
        r5 = r7;
    L15:
        if (r1.hasNext() == true) goto L11;
    L20:
        th = move-exception;
        throw th;
    }

    public final g b(JSONObject r39) {
        if (r39 != null) goto L5;
        return null;
    L5:
        String r2 = r39.optString("execution_id");
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        return null;
    L8:
        JSONArray r1 = r39.optJSONArray("steps");
        if (r1 != null) goto L11;
        r1 = new JSONArray();
    L11:
        List r3 = CollectionsKt.createListBuilder();
        int r4 = r1.length();
        int r8 = 0;
    L13:
        if (r8 >= r4) goto L19;
        JSONObject r10 = r1.optJSONObject(r8);
        if (r10 == null) goto L18;
        String r13 = r10.optString("step_id");
        Intrinsics.checkNotNullExpressionValue(r13, "optString(...)");
        String r14 = r10.optString(EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullExpressionValue(r14, "optString(...)");
        String r15 = r10.optString("event");
        Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
        String r6 = r10.optString("state");
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");
        String r9 = r10.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        String r11 = r10.optString("tool_name");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        int r18 = r10.optInt("round");
        int r19 = r10.optInt("sequence");
        long r20 = r10.optLong("timestamp");
        int r22 = r10.optInt("protocol_version", 2);
        String r5 = r10.optString("stage_id");
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        int r24 = r10.optInt("stage_order");
        String r12 = r10.optString("stage_type");
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
        String r16 = r10.optString("operation");
        Intrinsics.checkNotNullExpressionValue(r16, "optString(...)");
        String r17 = r10.optString("effect");
        Intrinsics.checkNotNullExpressionValue(r17, "optString(...)");
        boolean r28 = r10.optBoolean("requires_confirmation");
        String r21 = r10.optString("tool_display_name");
        Intrinsics.checkNotNullExpressionValue(r21, "optString(...)");
        String r23 = r10.optString("tool_type");
        Intrinsics.checkNotNullExpressionValue(r23, "optString(...)");
        String r25 = r10.optString("display_title");
        Intrinsics.checkNotNullExpressionValue(r25, "optString(...)");
        String r26 = r10.optString("display_subtitle");
        Intrinsics.checkNotNullExpressionValue(r26, "optString(...)");
        String r27 = r10.optString("display_markdown");
        Intrinsics.checkNotNullExpressionValue(r27, "optString(...)");
        String r29 = r10.optString("presentation_type");
        Intrinsics.checkNotNullExpressionValue(r29, "optString(...)");
        String r30 = r10.optString("secondary_list_style");
        Intrinsics.checkNotNullExpressionValue(r30, "optString(...)");
        String r31 = r10.optString("mobile_session_id");
        Intrinsics.checkNotNullExpressionValue(r31, "optString(...)");
        r3.add(new i(r13, r14, r15, r6, r9, r11, r18, r19, r20, r22, r5, r24, r12, r16, r17, r28, r21, r23, r25, r26, r27, r29, r30, r31, f6499a.a(r10.optJSONArray("display_items"))));
    L18:
        r8 = r8 + 1;
        r1 = r1;
        goto L13
    L19:
        List r32 = CollectionsKt.build(r3);
        String r33 = r39.optString("trace_id");
        Intrinsics.checkNotNullExpressionValue(r33, "optString(...)");
        String r34 = r39.optString("state", "running");
        Intrinsics.checkNotNullExpressionValue(r34, "optString(...)");
        return new g(r7, r33, r34, r39.optLong("started_at"), r39.optLong("updated_at"), RangesKt.coerceAtLeast(r39.optInt("suggestion_count"), 0), CollectionsKt.takeLast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b((Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), 80));
    }

    public final void b(h r3) {
        h r2 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((Collection) ZeusTransformUtils.preCheckCast(c, Collection.class, "com.obric.memorydata.plugin")).remove(r2);
    }

    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "executionId");
        Object r4 = f6500b;
        monitor-enter(r4);
        f6499a.e();     // Catch: Throwable -> L7
        boolean r6 = com.obric.aiproactive.impl.progress.a.f6494a.a((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L7
        monitor-exit(r4);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean c(String r8) {
        Intrinsics.checkNotNullParameter(r8, "executionId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return false;
    L6:
        Object r7 = f6500b;
        monitor-enter(r7);
        c r0 = f6499a;     // Catch: Throwable -> L34
        r0.e();     // Catch: Throwable -> L34
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L34
        LinkedHashMap<String, g> r3 = d;     // Catch: Throwable -> L34
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3.get(r8), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r4 != null) goto L11;
    L18:
        g r5 = com.obric.aiproactive.impl.progress.a.f6494a.a(r8, r1);     // Catch: Throwable -> L34
    L19:
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r8, r5);     // Catch: Throwable -> L34
        Long r2 = Long.valueOf(r1);     // Catch: Throwable -> L34
        ((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin")).put(r8, r2);     // Catch: Throwable -> L34
        r0.c();     // Catch: Throwable -> L34
        r0.d();     // Catch: Throwable -> L34
        r0.h();     // Catch: Throwable -> L34
        monitor-exit(r7);
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r9.hasNext() == false) goto L32;
        h r10 = (h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.memorydata.plugin");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L27
        r10.onChanged(r5);     // Catch: Throwable -> L27
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L23;
        RunLog.INSTANCE.error("AgentRunStore", "listener callback failed", r12);
    L27:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L32:
        return true;
    L11:
        if (g.contains(r4.c()) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L18;
        r5 = com.obric.aiproactive.impl.progress.b.a(r4, r1);     // Catch: Throwable -> L34
        if (r5 == null) goto L18;
    L34:
        th = move-exception;
        throw th;
    }
}
