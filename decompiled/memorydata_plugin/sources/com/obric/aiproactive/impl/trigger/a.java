package com.obric.aiproactive.impl.trigger;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiproactive.impl.aidb.AiProactiveDb;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.awareness.impl.k;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00192\u0006\u0010,\u001a\u00020\u0005H\u0002J\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d002\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/aiproactive/impl/trigger/AiProactiveEcaListeningManager;", "", "<init>", "()V", "TAG", "", "SCOPE", "SOURCE_KEY", "TARGET_TASK", "KEY_TASK_TYPE", "KEY_ECA_ID", "KEY_TRACE_ID", "TASK_TYPE_TRIGGER_ECA", "KEY_EVENT", "KEY_EXTRA", "KEY_CRON_EXPR", "EVENT_FEATURE_DURATION_TRIGGERED", "DEVICE_FOREGROUND_APP", "scope", "Lkotlinx/coroutines/CoroutineScope;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "observeJob", "Lkotlinx/coroutines/Job;", "registeredEventPairs", "", "Lkotlin/Pair;", "Lcom/obric/memorydata/awareness/impl/cron/EcaConditionEventListener;", CommonConsts.APM_INNER_EVENT_COST_START, "", "stop", "syncLatest", "", "row", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveEcaEntity;", "clearRegistrations", "syncEvents", "", "syncFeatureDuration", "syncCrons", "triggerAiProactiveEca", "triggerInfo", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$TriggerInfo;", "parseEventList", "raw", "parseFeatureDurationList", "Lcom/obric/aiproactive/impl/trigger/AiProactiveEcaListeningManager$FeatureDurationEntry;", "parseCronList", "", "FeatureDurationEntry", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f6522b = null;
    private static final CoroutineExceptionHandler c = null;
    private static bx d;
    private static List<Pair<String, com.obric.memorydata.awareness.impl.cron.c>> e;

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.trigger.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/impl/trigger/AiProactiveEcaListeningManager$FeatureDurationEntry;", "", "featureName", "", "targetFeatureValue", "durationSec", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSec", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0289a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6524b;
        private final long c;

        public C0289a(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "featureName");
            Intrinsics.checkNotNullParameter(r3, "targetFeatureValue");
            this.f6523a = r2;
            this.f6524b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f6523a;
        }

        public final String b() {
            return this.f6524b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, C0289a.class) == true) goto L8;
            return false;
        L8:
            C0289a r8 = (C0289a) ZeusTransformUtils.preCheckCast(r7, C0289a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6523a, r8.f6523a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6524b, r8.f6524b) == true) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f6523a.hashCode() * 31) + this.f6524b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "FeatureDurationEntry(featureName=" + this.f6523a + ", targetFeatureValue=" + this.f6524b + ", durationSec=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r2, Throwable r3) {
            CoroutineContext r1 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.error("AiProactiveEcaListeningManager", "listen latest ProactiveEca failed", r3);
        }
    }

    static {
        f6521a = new a();
        f6522b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = (CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new b(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin");
        e = CollectionsKt.emptyList();
    }

    private a() {
    }

    private final List<String> a(String r8) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: JSONException -> L27
        int r4 = 0;
        if (StringsKt.startsWith$default(r7, "[", false, 2, null) == false) goto L10;
        JSONArray r1 = new JSONArray(r7);     // Catch: JSONException -> L27
    L15:
        List r9 = CollectionsKt.createListBuilder();     // Catch: JSONException -> L27
        int r2 = r1.length();     // Catch: JSONException -> L27
    L16:
        if (r4 >= r2) goto L25;
        String r5 = r1.optString(r4);     // Catch: JSONException -> L27
        Intrinsics.checkNotNull(r5);     // Catch: JSONException -> L27
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L24;
        r9.add(r5);     // Catch: JSONException -> L27
    L24:
        r4 = r4 + 1;     // Catch: JSONException -> L27
        goto L16
    L25:
        return CollectionsKt.build(r9);
    L10:
        if (StringsKt.startsWith$default(r7, "{", false, 2, null) == false) goto L14;
        r1 = new JSONObject(r7).optJSONArray("events");     // Catch: JSONException -> L27
        if (r1 != null) goto L15;
        r1 = new JSONArray();     // Catch: JSONException -> L27
        goto L15
    L14:
        r1 = new JSONArray();     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        RunLog.INSTANCE.warn("AiProactiveEcaListeningManager", "parse events failed raw=" + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private final synchronized void a(com.obric.aiproactive.impl.aidb.a.b r11) {
        monitor-enter(this);
        if (r11 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveEcaListeningManager", "syncLatest empty", false, 4, null);     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveEcaListeningManager", "syncLatest id=" + r11.a() + " events=" + b(r11) + " featureDuration=" + c(r11) + " crons=" + d(r11), false, 4, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void a(com.obric.aiproactive.impl.aidb.a.b r9, k.c r10) {
        JSONObject r8 = new JSONObject();
        r8.put("task_type", "trigger_eca");
        r8.put("eca_id", r9.a());
        Long r0 = r9.g();
        if (r0 == null) goto L5;
        r8.put("trace_id", ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L5:
        r8.put("event", "feature_duration_triggered");
        JSONObject r1 = new JSONObject();
        r1.put("feature", r10.a());
        r1.put("current_feature_value", r10.d());
        r1.put("target_feature_value", r10.b());
        r1.put("duration_seconds", r10.c());
        Unit r2 = Unit.INSTANCE;
        r8.put(WsConstants.KEY_EXTRA, r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveEcaListeningManager", "trigger latest ProactiveEca id=" + r9.a() + " traceId=" + r9.g() + " feature=" + r10.a() + " duration=" + r10.c(), false, 4, null);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("ai_proactive_eca_trigger").setInputParam(r8), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public static final /* synthetic */ void a(a r0, com.obric.aiproactive.impl.aidb.a.b r1) {
        r0.a(r1);
    }

    private final int b(com.obric.aiproactive.impl.aidb.a.b r7) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.component1(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.c r2 = (com.obric.memorydata.awareness.impl.cron.c) ZeusTransformUtils.preCheckCast(r1.component2(), com.obric.memorydata.awareness.impl.cron.c.class, "com.obric.memorydata.plugin");
        AwarenessManagerImpl.INSTANCE.unregisterAwarenessEvent(r3, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        String r8 = r7.d();
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(a(r8), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r6.iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.c r5 = new com.obric.memorydata.awareness.impl.cron.c("ai_proactive_eca_trigger");
        AwarenessManagerImpl.INSTANCE.registerAwarenessEvent(r4, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        r9.add(TuplesKt.to(r4, r5));
        goto L11
    L13:
        List<Pair<String, com.obric.memorydata.awareness.impl.cron.c>> r11 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        e = r11;
        return r11.size();
    }

    private final List<C0289a> b(String r13) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: JSONException -> L36
        int r4 = 0;
        if (StringsKt.startsWith$default(r12, "[", false, 2, null) == false) goto L10;
        JSONArray r1 = new JSONArray(r12);     // Catch: JSONException -> L36
    L15:
        List r14 = CollectionsKt.createListBuilder();     // Catch: JSONException -> L36
        int r2 = r1.length();     // Catch: JSONException -> L36
    L16:
        if (r4 >= r2) goto L34;
        JSONObject r3 = r1.optJSONObject(r4);     // Catch: JSONException -> L36
        if (r3 == null) goto L33;
        String r5 = r3.optString("feature_name");     // Catch: JSONException -> L36
        String r6 = r3.optString("target_feature_value");     // Catch: JSONException -> L36
        long r7 = r3.optLong("duration_seconds");     // Catch: JSONException -> L36
        Intrinsics.checkNotNull(r5);     // Catch: JSONException -> L36
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L32;
        Intrinsics.checkNotNull(r6);     // Catch: JSONException -> L36
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L32;
        if (r7 <= 0) goto L32;
        if (Intrinsics.areEqual(r5, "device_foreground_app") == false) goto L31;
        IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L36
        String r9 = "AiProactiveEcaListeningManager";
        String r10 = "ignore device_foreground_app ai proactive eca config: " + r3;     // Catch: JSONException -> L36
    L30:
        IRunLog.a.a(r8, r9, r10, null, 4, null);     // Catch: JSONException -> L36
        goto L33
    L31:
        r14.add(new C0289a(r5, r6, r7));     // Catch: JSONException -> L36
    L32:
        r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L36
        r9 = "AiProactiveEcaListeningManager";
        r10 = "ignore invalid ai proactive eca feature duration config: " + r3;     // Catch: JSONException -> L36
    L33:
        r4 = r4 + 1;     // Catch: JSONException -> L36
        goto L16
    L34:
        return CollectionsKt.build(r14);
    L10:
        if (StringsKt.startsWith$default(r12, "{", false, 2, null) == false) goto L14;
        r1 = new JSONObject(r12).optJSONArray("feature_duration_triggered_list");     // Catch: JSONException -> L36
        if (r1 != null) goto L15;
        r1 = new JSONArray();     // Catch: JSONException -> L36
        goto L15
    L14:
        r1 = new JSONArray();     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        RunLog.INSTANCE.warn("AiProactiveEcaListeningManager", "parse feature_duration_triggered_list failed raw=" + r13, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private static final Unit b(com.obric.aiproactive.impl.aidb.a.b r1, k.c r2) {
        Intrinsics.checkNotNullParameter(r2, "triggerInfo");
        f6521a.a(r1, r2);
        return Unit.INSTANCE;
    }

    private final int c(final com.obric.aiproactive.impl.aidb.a.b r12) {
        String r0 = r12.e();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(b(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        C0289a r2 = (C0289a) ZeusTransformUtils.preCheckCast(r13.next(), C0289a.class, "com.obric.memorydata.plugin");
        r1.add(new k.b(r2.a(), r2.b(), r2.c(), false, new $$Lambda$a$Foo18OyfxRNAlg__pSZcJHP59jg(r12)));
        goto L7
    L9:
        List<k.b> r14 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L12;
        k.f8704a.a("ai_proactive_eca_latest");
    L14:
        return r14.size();
    L12:
        k.f8704a.a("ai_proactive_eca_latest", r14);
        goto L14
    }

    private final Map<String, Boolean> c(String r7) {
        return com.obric.aiproactive.impl.trigger.b.f6525a.a(r7);
    L4:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveEcaListeningManager", "parse timers failed code=invalid_timers_json", null, 4, null);
        return MapsKt.emptyMap();
    }

    private final void c() {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(r5.next(), Pair.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.component1(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.c r1 = (com.obric.memorydata.awareness.impl.cron.c) ZeusTransformUtils.preCheckCast(r0.component2(), com.obric.memorydata.awareness.impl.cron.c.class, "com.obric.memorydata.plugin");
        AwarenessManagerImpl.INSTANCE.unregisterAwarenessEvent(r2, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        e = CollectionsKt.emptyList();
        k.f8704a.a("ai_proactive_eca_latest");
        com.obric.memorydata.awareness.impl.cron.b.f8651a.a("ai_proactive_eca_latest");
    }

    private final int d(com.obric.aiproactive.impl.aidb.a.b r17) {
        Map<String, Boolean> r0 = c(r17.c());
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r0.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, Boolean>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        boolean r8 = ((Boolean) ZeusTransformUtils.preCheckCast(r3.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        JSONObject r10 = new JSONObject();
        r10.put("task_type", "trigger_eca");
        r10.put("eca_id", r17.a());
        Long r4 = r17.g();
        if (r4 == null) goto L8;
        r10.put("trace_id", ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());
    L8:
        r10.put("cron_expr", r7);
        r1.add(new com.obric.memorydata.awareness.impl.cron.b.a("ai_proactive_eca#" + r7, r7, r8, "ai_proactive_eca_trigger", r10, CollectionsKt.emptyList(), ExistingTaskPolicy.SINGLE_QUEUE.getValue(), false, "ai_proactive_eca#" + r17.a()));
        goto L4
    L9:
        List<com.obric.memorydata.awareness.impl.cron.b.a> r5 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.b.f8651a.a("ai_proactive_eca_latest", r5);
        return r5.size();
    }

    public static /* synthetic */ Unit lambda$Foo18OyfxRNAlg__pSZcJHP59jg(com.obric.aiproactive.impl.aidb.a.b r0, k.c r1) {
        return b(r0, r1);
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        bx r0 = d;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveEcaListeningManager", "start ignored: already listening", false, 4, null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveEcaListeningManager", CommonConsts.APM_INNER_EVENT_COST_START, false, 4, null);     // Catch: Throwable -> L21
        AiProactiveDb r2 = com.obric.aiproactive.impl.aidb.b.f6306a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        if (r2 != null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveEcaListeningManager", "start aborted: ai proactive db not ready", null, 4, null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L18:
        d = i.a(f6522b, (CoroutineContext) ZeusTransformUtils.preCheckCast(c, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveEcaListeningManager$start$1(r2, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L6:
        if (r0.a() != true) goto L8;
        r1 = true;
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean b() {
        monitor-enter(this);
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        StringBuilder r0 = new StringBuilder().append("stop active=");     // Catch: Throwable -> L14
        bx r3 = d;     // Catch: Throwable -> L14
        boolean r4 = false;
        if (r3 != null) goto L6;
    L8:
        IRunLog.a.a(r1, "AiProactiveEcaListeningManager", r0.append(r4).toString(), false, 4, null);     // Catch: Throwable -> L14
        bx r2 = d;     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        bx.a.a(r2, null, 1, null);     // Catch: Throwable -> L14
    L11:
        d = null;     // Catch: Throwable -> L14
        c();     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L6:
        if (r3.a() != true) goto L8;
        r4 = true;
    L14:
        th = move-exception;
        throw th;
    }
}
