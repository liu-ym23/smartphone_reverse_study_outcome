package com.obric.aiproactive.impl.trigger;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiproactive.impl.aidb.AiProactiveDb;
import com.obric.aiproactive.impl.aidb.a.j;
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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u001e\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0*2\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00172\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/aiproactive/impl/trigger/SpellProactiveEcaListeningManager;", "", "<init>", "()V", "TAG", "", "SCOPE", "SOURCE_KEY", "TARGET_TASK", "KEY_TASK_TYPE", "TASK_TYPE_TRIGGER_ECA", "KEY_EVENT", "KEY_EXTRA", "KEY_CRON_EXPR", "EVENT_FEATURE_DURATION_TRIGGERED", "DEVICE_FOREGROUND_APP", "scope", "Lkotlinx/coroutines/CoroutineScope;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "observeJob", "Lkotlinx/coroutines/Job;", "registeredEventPairs", "", "Lkotlin/Pair;", "Lcom/obric/memorydata/awareness/impl/cron/EcaConditionEventListener;", CommonConsts.APM_INNER_EVENT_COST_START, "", "stop", "syncLatest", "", "row", "Lcom/obric/aiproactive/impl/aidb/entity/SpellProactiveEcaEntity;", "clearRegistrations", "syncEvents", "", "syncFeatureDuration", "syncCrons", "triggerSpellProactiveEca", "triggerInfo", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$TriggerInfo;", "parseCronList", "", "raw", "parseStringList", "parseFeatureDurationList", "Lcom/obric/aiproactive/impl/trigger/SpellProactiveEcaListeningManager$FeatureDurationEntry;", "FeatureDurationEntry", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f6528b = null;
    private static final CoroutineExceptionHandler c = null;
    private static bx d;
    private static List<Pair<String, com.obric.memorydata.awareness.impl.cron.c>> e;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/impl/trigger/SpellProactiveEcaListeningManager$FeatureDurationEntry;", "", "featureName", "", "targetFeatureValue", "durationSec", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSec", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6530b;
        private final long c;

        public a(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "featureName");
            Intrinsics.checkNotNullParameter(r3, "targetFeatureValue");
            this.f6529a = r2;
            this.f6530b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f6529a;
        }

        public final String b() {
            return this.f6530b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6529a, r8.f6529a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6530b, r8.f6530b) == true) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f6529a.hashCode() * 31) + this.f6530b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "FeatureDurationEntry(featureName=" + this.f6529a + ", targetFeatureValue=" + this.f6530b + ", durationSec=" + this.c + ')';
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
            RunLog.INSTANCE.error("SpellProactiveEcaListen", "listen failed", r3);
        }
    }

    static {
        f6527a = new c();
        f6528b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = (CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new b(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin");
        e = CollectionsKt.emptyList();
    }

    private c() {
    }

    private final Map<String, Boolean> a(String r7) {
        return com.obric.aiproactive.impl.trigger.b.f6525a.a(r7);
    L4:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveEcaListen", "parse timers failed code=invalid_timers_json", null, 4, null);
        return MapsKt.emptyMap();
    }

    private final synchronized void a(j r11) {
        monitor-enter(this);
        if (r11 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveEcaListen", "syncLatest empty", false, 4, null);     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveEcaListen", "syncLatest id=" + r11.a() + " events=" + b(r11) + " featureDuration=" + c(r11) + " crons=" + d(r11), false, 4, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void a(c r0, j r1) {
        r0.a(r1);
    }

    private final void a(k.c r10) {
        JSONObject r9 = new JSONObject();
        r9.put("task_type", "trigger_eca");
        r9.put("event", "feature_duration_triggered");
        JSONObject r0 = new JSONObject();
        r0.put("feature", r10.a());
        r0.put("current_feature_value", r10.d());
        r0.put("target_feature_value", r10.b());
        r0.put("duration_seconds", r10.c());
        Unit r1 = Unit.INSTANCE;
        r9.put(WsConstants.KEY_EXTRA, r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveEcaListen", "trigger latest SpellProactiveEca feature=" + r10.a() + " duration=" + r10.c(), false, 4, null);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("spell_proactive_eca_trigger").setInputParam(r9), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    private final int b(j r7) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.component1(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.c r2 = (com.obric.memorydata.awareness.impl.cron.c) ZeusTransformUtils.preCheckCast(r1.component2(), com.obric.memorydata.awareness.impl.cron.c.class, "com.obric.memorydata.plugin");
        AwarenessManagerImpl.INSTANCE.unregisterAwarenessEvent(r3, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(b(r7.d()), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.c r5 = new com.obric.memorydata.awareness.impl.cron.c("spell_proactive_eca_trigger");
        AwarenessManagerImpl.INSTANCE.registerAwarenessEvent(r4, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        r8.add(TuplesKt.to(r4, r5));
        goto L8
    L10:
        List<Pair<String, com.obric.memorydata.awareness.impl.cron.c>> r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        e = r10;
        return r10.size();
    }

    private final List<String> b(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (r6 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        JSONArray r9 = new JSONArray(r7);     // Catch: JSONException -> L23
        List r10 = CollectionsKt.createListBuilder();     // Catch: JSONException -> L23
        int r3 = r9.length();     // Catch: JSONException -> L23
    L13:
        if (r1 >= r3) goto L21;
        String r4 = r9.optString(r1);     // Catch: JSONException -> L23
        Intrinsics.checkNotNull(r4);     // Catch: JSONException -> L23
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L20;
        r10.add(r4);     // Catch: JSONException -> L23
    L20:
        r1 = r1 + 1;     // Catch: JSONException -> L23
        goto L13
    L21:
        return CollectionsKt.build(r10);
    L23:
        e = move-exception;
        RunLog.INSTANCE.warn("SpellProactiveEcaListen", "parse string list failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r8 = false;
        goto L9
    }

    private static final Unit b(k.c r1) {
        Intrinsics.checkNotNullParameter(r1, "triggerInfo");
        f6527a.a(r1);
        return Unit.INSTANCE;
    }

    private final int c(j r11) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(c(r11.e()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r13.next(), a.class, "com.obric.memorydata.plugin");
        r12.add(new k.b(r1.a(), r1.b(), r1.c(), false, $$Lambda$c$YXZkC_8mM77Ek0p0lrPIscSuzRw.INSTANCE));
        goto L4
    L6:
        List<k.b> r14 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L9;
        k.f8704a.a("spell_proactive_eca");
    L11:
        return r14.size();
    L9:
        k.f8704a.a("spell_proactive_eca", r14);
        goto L11
    }

    private final List<a> c(String r12) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L11;
        JSONArray r14 = new JSONArray(r12);     // Catch: JSONException -> L33
        List r15 = CollectionsKt.createListBuilder();     // Catch: JSONException -> L33
        int r2 = r14.length();     // Catch: JSONException -> L33
    L13:
        if (r1 >= r2) goto L31;
        JSONObject r3 = r14.optJSONObject(r1);     // Catch: JSONException -> L33
        if (r3 == null) goto L30;
        String r4 = r3.optString("feature_name");     // Catch: JSONException -> L33
        String r5 = r3.optString("target_feature_value");     // Catch: JSONException -> L33
        long r6 = r3.optLong("duration_seconds");     // Catch: JSONException -> L33
        Intrinsics.checkNotNull(r4);     // Catch: JSONException -> L33
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L29;
        Intrinsics.checkNotNull(r5);     // Catch: JSONException -> L33
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L29;
        if (r6 <= 0) goto L29;
        if (Intrinsics.areEqual(r4, "device_foreground_app") == false) goto L28;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L33
        String r8 = "SpellProactiveEcaListen";
        String r9 = "ignore device_foreground_app spell proactive eca config: " + r3;     // Catch: JSONException -> L33
    L27:
        IRunLog.a.a(r7, r8, r9, null, 4, null);     // Catch: JSONException -> L33
        goto L30
    L28:
        r15.add(new a(r4, r5, r6));     // Catch: JSONException -> L33
    L29:
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L33
        r8 = "SpellProactiveEcaListen";
        r9 = "ignore invalid spell proactive eca feature duration config: " + r3;     // Catch: JSONException -> L33
    L30:
        r1 = r1 + 1;     // Catch: JSONException -> L33
        goto L13
    L31:
        return CollectionsKt.build(r15);
    L33:
        e = move-exception;
        RunLog.INSTANCE.warn("SpellProactiveEcaListen", "parse feature_duration_triggered_list failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r13 = false;
        goto L9
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
        k.f8704a.a("spell_proactive_eca");
        com.obric.memorydata.awareness.impl.cron.b.f8651a.a("spell_proactive_eca");
    }

    private final int d(j r15) {
        Map<String, Boolean> r14 = a(r15.c());
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, Boolean>> r16 = r14.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        JSONObject r9 = new JSONObject();
        r9.put("task_type", "trigger_eca");
        r9.put("cron_expr", r6);
        Unit r2 = Unit.INSTANCE;
        r0.add(new com.obric.memorydata.awareness.impl.cron.b.a("spell_proactive_eca#" + r6, r6, r7, "spell_proactive_eca_trigger", r9, CollectionsKt.emptyList(), ExistingTaskPolicy.SINGLE_QUEUE.getValue(), false, "spell_proactive_eca#" + r15.a()));
        goto L4
    L6:
        List<com.obric.memorydata.awareness.impl.cron.b.a> r17 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.b.f8651a.a("spell_proactive_eca", r17);
        return r17.size();
    }

    public static /* synthetic */ Unit lambda$YXZkC_8mM77Ek0p0lrPIscSuzRw(k.c r0) {
        return b(r0);
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        bx r0 = d;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveEcaListen", "start ignored: already listening", false, 4, null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveEcaListen", CommonConsts.APM_INNER_EVENT_COST_START, false, 4, null);     // Catch: Throwable -> L21
        AiProactiveDb r2 = com.obric.aiproactive.impl.aidb.b.f6306a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        if (r2 != null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveEcaListen", "start aborted: db not ready", null, 4, null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L18:
        d = i.a(f6528b, (CoroutineContext) ZeusTransformUtils.preCheckCast(c, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new SpellProactiveEcaListeningManager$start$1(r2, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);     // Catch: Throwable -> L21
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
        IRunLog.a.a(r1, "SpellProactiveEcaListen", r0.append(r4).toString(), false, 4, null);     // Catch: Throwable -> L14
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
