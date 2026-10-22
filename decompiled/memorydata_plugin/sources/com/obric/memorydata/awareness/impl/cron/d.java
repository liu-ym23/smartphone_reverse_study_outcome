package com.obric.memorydata.awareness.impl.cron;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiproactive.api.ProactiveRecommendationEnabledStore;
import com.obric.aiproactive.api.ae;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.awareness.impl.k;
import com.obric.memorydata.database.entity.er;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u000245B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0002J\u000e\u0010\"\u001a\u00020 H\u0082@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019H\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00192\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00192\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0002J\u0019\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u00103R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/awareness/impl/cron/EcaConditionManager;", "", "<init>", "()V", "TAG", "", "SCOPE", "TARGET_TASK", "FEATURE_DURATION_SOURCE_PREFIX", "KEY_TASK_TYPE", "TASK_TYPE_TRIGGER_ECA", "TASK_TYPE_REMOVE_ECA", "KEY_KEYS", "KEY_CRON_EXPR", "KEY_EVENT", "KEY_EXTRA", "KEY_CONDITION_ID", "EVENT_FEATURE_DURATION_TRIGGERED", "scope", "Lkotlinx/coroutines/CoroutineScope;", "observeJob", "Lkotlinx/coroutines/Job;", "enabledListener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "registeredEventPairs", "", "Lkotlin/Pair;", "Lcom/obric/memorydata/awareness/impl/cron/EcaConditionEventListener;", "lastConditionsById", "", "Lcom/obric/memorydata/database/entity/ProactiveEcaConditionEntity;", CommonConsts.APM_INNER_EVENT_COST_START, "", "ensureObserving", "stopObserving", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sync", "conditions", "parseEventList", "raw", "parseFeatureDurationList", "Lcom/obric/memorydata/awareness/impl/cron/EcaConditionManager$FeatureDurationEntry;", "parseCronList", "Lcom/obric/memorydata/awareness/impl/cron/EcaConditionManager$CronEntry;", "isExpired", "", "condition", "nowMillis", "", "parseDeadlineMillis", "deadline", "(Ljava/lang/String;)Ljava/lang/Long;", "FeatureDurationEntry", "CronEntry", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f8658b = null;
    private static bx c;
    private static ae d;
    private static List<Pair<String, c>> e;
    private static Map<String, er> f;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/awareness/impl/cron/EcaConditionManager$CronEntry;", "", CronJobRunnerTask.KEY_CRON, "", "triggerExactly", "", "<init>", "(Ljava/lang/String;Z)V", "getCron", "()Ljava/lang/String;", "getTriggerExactly", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8660b;

        public a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, CronJobRunnerTask.KEY_CRON);
            this.f8659a = r2;
            this.f8660b = r3;
        }

        public final String a() {
            return this.f8659a;
        }

        public final boolean b() {
            return this.f8660b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8659a, r6.f8659a) == true) goto L12;
            return false;
        L12:
            if (this.f8660b == r6.f8660b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8659a.hashCode() * 31) + Boolean.hashCode(this.f8660b);
        }

        public String toString() {
            return "CronEntry(cron=" + this.f8659a + ", triggerExactly=" + this.f8660b + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/impl/cron/EcaConditionManager$FeatureDurationEntry;", "", "featureName", "", "targetFeatureValue", "durationSec", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSec", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8662b;
        private final long c;

        public b(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "featureName");
            Intrinsics.checkNotNullParameter(r3, "targetFeatureValue");
            this.f8661a = r2;
            this.f8662b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f8661a;
        }

        public final String b() {
            return this.f8662b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8661a, r8.f8661a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8662b, r8.f8662b) == true) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f8661a.hashCode() * 31) + this.f8662b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "FeatureDurationEntry(featureName=" + this.f8661a + ", targetFeatureValue=" + this.f8662b + ", durationSec=" + this.c + ')';
        }
    }

    static {
        f8657a = new d();
        f8658b = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        e = CollectionsKt.emptyList();
        f = MapsKt.emptyMap();
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, EcaConditionManager$stopObserving$1.class) == false) goto L7;
        EcaConditionManager$stopObserving$1 r0 = (EcaConditionManager$stopObserving$1) ZeusTransformUtils.preCheckCast(r13, EcaConditionManager$stopObserving$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d this = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L24:
        c = null;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "stopObserving removeTask name=eca_code", false, 4, null);
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().a("eca_code");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "stopObserving sync empty", false, 4, null);
        this.a(CollectionsKt.emptyList());
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder().append("stopObserving begin jobActive=");
        bx r4 = c;
        boolean r6 = false;
        if (r4 != null) goto L17;
    L19:
        IRunLog.a.a(r5, "EcaConditionManager", r15.append(r6).toString(), false, 4, null);
        bx r16 = c;
        if (r16 == null) goto L24;
        r0.L$0 = this;
        r0.label = 1;
        if (ca.a(r16, r0) != r2) goto L24;
        return r2;
    L17:
        if (r4.a() != true) goto L19;
        r6 = true;
    L7:
        r0 = new EcaConditionManager$stopObserving$1(this, r13);
        goto L8
    }

    private final List<String> a(String r6) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L37
        if (StringsKt.startsWith$default(r5, "[", false, 2, null) == false) goto L20;
        JSONArray r7 = new JSONArray(r5);     // Catch: Throwable -> L37
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r7.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L37
    L10:
        if (r9.hasNext() == false) goto L17;
        String r3 = r7.optString(((IntIterator) ZeusTransformUtils.preCheckCast(r9, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L37
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L10;
        r1.add(r3);     // Catch: Throwable -> L37
        goto L10
    L17:
        Class<List> r10 = List.class;
    L50:
        return (List) ZeusTransformUtils.preCheckCast(r1, r10, "com.obric.memorydata.plugin");
    L20:
        if (StringsKt.startsWith$default(r5, "{", false, 2, null) == false) goto L51;
        JSONArray r11 = new JSONObject(r5).optJSONArray("events");     // Catch: Throwable -> L37
        if (r11 == null) goto L24;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r11.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L37
    L27:
        if (r13.hasNext() == false) goto L34;
        String r4 = r11.optString(((IntIterator) ZeusTransformUtils.preCheckCast(r13, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L37
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L32;
        r4 = null;
    L32:
        if (r4 == null) goto L27;
        r1.add(r4);     // Catch: Throwable -> L37
        goto L27
    L34:
        r10 = List.class;
        goto L50
    L24:
        return CollectionsKt.emptyList();
    L51:
        return CollectionsKt.emptyList();
    L38:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private static final Unit a(er r10, k.c r11) {
        Intrinsics.checkNotNullParameter(r11, "triggerInfo");
        JSONObject r0 = new JSONObject();
        r0.put("task_type", "trigger_eca");
        r0.put("condition_id", r10.a());
        r0.put("event", "feature_duration_triggered");
        JSONObject r1 = new JSONObject();
        r1.put("feature", r11.a());
        r1.put("current_feature_value", r11.d());
        r1.put("target_feature_value", r11.b());
        r1.put("duration_seconds", r11.c());
        Unit r2 = Unit.INSTANCE;
        r0.put(WsConstants.KEY_EXTRA, r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "trigger eca duration conditionId=" + r10.a() + ", feature=" + r11.a() + ", target=" + r11.b() + ", duration=" + r11.c(), false, 4, null);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("eca_code").setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(d r0) {
        r0.b();
    }

    public static final /* synthetic */ void a(d r2, List r3) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(List<er> r27) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "sync conditions=" + r0.size(), false, 4, null);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, er> r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Object r5 = r3.next();
        r4.put(((er) ZeusTransformUtils.preCheckCast(r5, er.class, "com.obric.memorydata.plugin")).a(), r5);
        goto L4
    L6:
        Set r6 = CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(f.keySet(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(f.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        Object r10 = r9.next();
        if (((er) ZeusTransformUtils.preCheckCast(r10, er.class, "com.obric.memorydata.plugin")).l() == false) goto L8;
        r8.add(r10);
        goto L8
    L12:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        r12.add(((er) ZeusTransformUtils.preCheckCast(r13.next(), er.class, "com.obric.memorydata.plugin")).a());
        goto L14
    L16:
        Set r14 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L18:
        if (r17.hasNext() == false) goto L22;
        Object r18 = r17.next();
        if (((er) ZeusTransformUtils.preCheckCast(r18, er.class, "com.obric.memorydata.plugin")).l() == false) goto L18;
        r16.add(r18);
        goto L18
    L22:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        r20.add(((er) ZeusTransformUtils.preCheckCast(r21.next(), er.class, "com.obric.memorydata.plugin")).a());
        goto L24
    L26:
        Set r22 = CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
        long r23 = System.currentTimeMillis();
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(f.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L28:
        if (r26.hasNext() == false) goto L32;
        Object r110 = r26.next();
        if (f8657a.a((er) ZeusTransformUtils.preCheckCast(r110, er.class, "com.obric.memorydata.plugin"), r23) == false) goto L28;
        r25.add(r110);
        goto L28
    L32:
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r30 = r28.iterator();
    L34:
        if (r30.hasNext() == false) goto L36;
        r29.add(((er) ZeusTransformUtils.preCheckCast(r30.next(), er.class, "com.obric.memorydata.plugin")).a());
        goto L34
    L36:
        Set r31 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r33 = r32.iterator();
    L38:
        if (r33.hasNext() == false) goto L42;
        Object r112 = r33.next();
        if (f8657a.a((er) ZeusTransformUtils.preCheckCast(r112, er.class, "com.obric.memorydata.plugin"), r23) == false) goto L38;
        r111.add(r112);
        goto L38
    L42:
        Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r35 = r34.iterator();
    L44:
        if (r35.hasNext() == false) goto L46;
        r113.add(((er) ZeusTransformUtils.preCheckCast(r35.next(), er.class, "com.obric.memorydata.plugin")).a());
        goto L44
    L46:
        Set r36 = CollectionsKt.union((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.union((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r31, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L53;
        JSONObject r37 = new JSONObject();
        r37.put("task_type", "remove_eca");
        JSONArray r114 = new JSONArray();
        Iterator r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L50:
        if (r115.hasNext() == false) goto L52;
        r114.put((String) ZeusTransformUtils.preCheckCast(r115.next(), String.class, "com.obric.memorydata.plugin"));
        goto L50
    L52:
        r37.put("keys", r114);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("eca_code").setInputParam(r37), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    L53:
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L55:
        if (r38.hasNext() == false) goto L57;
        k.f8704a.a("eca_condition:" + ((String) ZeusTransformUtils.preCheckCast(r38.next(), String.class, "com.obric.memorydata.plugin")));
        goto L55
    L57:
        f = r4;
        Iterator r39 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L59:
        if (r39.hasNext() == false) goto L61;
        Pair r40 = (Pair) ZeusTransformUtils.preCheckCast(r39.next(), Pair.class, "com.obric.memorydata.plugin");
        AwarenessManagerImpl.INSTANCE.unregisterAwarenessEvent((String) ZeusTransformUtils.preCheckCast(r40.component1(), String.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.preCheckCast(r40.component2(), c.class, "com.obric.memorydata.plugin"), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        goto L59
    L61:
        e = CollectionsKt.emptyList();
        ArrayList r41 = new ArrayList();
        ArrayList r42 = new ArrayList();
        LinkedHashSet r43 = new LinkedHashSet();
        LinkedHashSet r116 = new LinkedHashSet();
        HashMap r117 = new HashMap();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r118 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r44 = r1.iterator();
    L62:
        boolean r119 = false;
        if (r44.hasNext() == false) goto L72;
        Object r120 = r44.next();
        er r45 = (er) ZeusTransformUtils.preCheckCast(r120, er.class, "com.obric.memorydata.plugin");
        if (r45.l() == false) goto L67;
    L69:
        if (r119 == false) goto L62;
        r118.add(r120);
        goto L62
    L67:
        if (f8657a.a(r45, r23) == true) goto L69;
        r119 = true;
        goto L69
    L72:
        Iterator r46 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r118, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L74:
        if (r46.hasNext() == false) goto L102;
        final er r47 = (er) ZeusTransformUtils.preCheckCast(r46.next(), er.class, "com.obric.memorydata.plugin");
        Iterator r48 = ((Iterable) ZeusTransformUtils.preCheckCast(f8657a.a(r47.d()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L77:
        if (r48.hasNext() == false) goto L81;
        String r49 = (String) ZeusTransformUtils.preCheckCast(r48.next(), String.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r49, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L77;
        r43.add(r49);
        goto L77
    L81:
        String r50 = "eca_condition:" + r47.a();
        k r51 = k.f8704a;
        d r52 = f8657a;
        String r121 = r47.g();
        if (r121 != null) goto L84;
        r121 = "";
    L84:
        Iterable r53 = (Iterable) ZeusTransformUtils.preCheckCast(r52.b(r121), Iterable.class, "com.obric.memorydata.plugin");
        Iterator r210 = r46;
        Collection r54 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r55 = r53.iterator();
    L86:
        if (r55.hasNext() == false) goto L88;
        b r122 = (b) ZeusTransformUtils.preCheckCast(r55.next(), b.class, "com.obric.memorydata.plugin");
        r54.add(new k.b(r122.a(), r122.b(), r122.c(), r47.i(), new $$Lambda$d$HGMLJrSwoTLJ9116lLE60mT9bVc(r47)));
        goto L86
    L88:
        r51.a(r50, (List) ZeusTransformUtils.preCheckCast(r54, List.class, "com.obric.memorydata.plugin"));
        Iterator r56 = ((Iterable) ZeusTransformUtils.preCheckCast(f8657a.c(r47.e()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L90:
        if (r56.hasNext() == false) goto L101;
        a r57 = (a) ZeusTransformUtils.preCheckCast(r56.next(), a.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r57.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L90;
        String r58 = r57.a();
        r116.add(r58);
        Map r59 = (Map) ZeusTransformUtils.preCheckCast(r117, Map.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r117.get(r58), true) == false) goto L96;
    L99:
        boolean r123 = true;
    L100:
        r59.put(r58, Boolean.valueOf(r123));
        goto L90
    L96:
        if (r57.b() == true) goto L99;
        r123 = false;
        goto L100
    L101:
        r46 = r210;
        goto L74
    L102:
        Iterator r60 = ((Iterable) ZeusTransformUtils.preCheckCast(r43, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L104:
        if (r60.hasNext() == false) goto L106;
        String r61 = (String) ZeusTransformUtils.preCheckCast(r60.next(), String.class, "com.obric.memorydata.plugin");
        c r62 = new c("eca_code");
        AwarenessManagerImpl.INSTANCE.registerAwarenessEvent(r61, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r62, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        r41.add(TuplesKt.to(r61, r62));
        goto L104
    L106:
        Iterator r63 = ((Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L108:
        if (r63.hasNext() == false) goto L110;
        String r64 = (String) ZeusTransformUtils.preCheckCast(r63.next(), String.class, "com.obric.memorydata.plugin");
        JSONObject r65 = new JSONObject();
        r65.put("task_type", "trigger_eca");
        r65.put("cron_expr", r64);
        r42.add(new com.obric.memorydata.awareness.impl.cron.b.a("eca#" + r64, r64, Intrinsics.areEqual(r117.get(r64), true), "eca_code", r65, CollectionsKt.emptyList(), ExistingTaskPolicy.SINGLE_QUEUE.getValue(), false, null, 256, null));
        goto L108
    L110:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "sync events=" + r41.size() + " cronJobs=" + r42.size(), false, 4, null);
        e = (List) ZeusTransformUtils.preCheckCast(r41, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.cron.b.f8651a.a("eca_condition", (List) ZeusTransformUtils.preCheckCast(r42, List.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(boolean r15) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "ProactiveRecommendationEnabledListener onChanged enabled=" + r15, false, 4, null);
        i.a(f8658b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new EcaConditionManager$start$listener$1$1(r15, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean a(er r3, long r4) {
        Long r2 = d(r3.h());
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r4 <= r2.longValue()) goto L9;
        return true;
    L9:
        return false;
    }

    private final List<b> b(String r12) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L36
        int r3 = 0;
        if (StringsKt.startsWith$default(r11, "[", false, 2, null) == false) goto L10;
        JSONArray r13 = new JSONArray(r11);     // Catch: Throwable -> L36
    L15:
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L36
        int r1 = r13.length();     // Catch: Throwable -> L36
    L16:
        if (r3 >= r1) goto L34;
        JSONObject r2 = r13.optJSONObject(r3);     // Catch: Throwable -> L36
        if (r2 == null) goto L33;
        String r4 = r2.optString("feature_name");     // Catch: Throwable -> L36
        String r5 = r2.optString("target_feature_value");     // Catch: Throwable -> L36
        long r6 = r2.optLong("duration_seconds");     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L36
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L32;
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L36
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L32;
        if (r6 <= 0) goto L32;
        if (Intrinsics.areEqual(r4, "device_foreground_app") == false) goto L31;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        String r8 = "EcaConditionManager";
        StringBuilder r9 = new StringBuilder().append("ignore device_foreground_app eca feature duration config: ").append(r2);     // Catch: Throwable -> L36
    L30:
        IRunLog.a.a(r7, r8, r9.toString(), null, 4, null);     // Catch: Throwable -> L36
        goto L33
    L31:
        r14.add(new b(r4, r5, r6));     // Catch: Throwable -> L36
    L32:
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        r8 = "EcaConditionManager";
        r9 = new StringBuilder().append("ignore invalid eca feature duration config: ").append(r2);     // Catch: Throwable -> L36
    L33:
        r3 = r3 + 1;     // Catch: Throwable -> L36
        goto L16
    L34:
        return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L10:
        if (StringsKt.startsWith$default(r11, "{", false, 2, null) == false) goto L14;
        r13 = new JSONObject(r11).optJSONArray("feature_duration_triggered_list");     // Catch: Throwable -> L36
        if (r13 != null) goto L15;
        r13 = new JSONArray();     // Catch: Throwable -> L36
        goto L15
    L14:
        r13 = new JSONArray();     // Catch: Throwable -> L36
    L37:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private final void b() {
        bx r12 = c;
        boolean r0 = true;
        if (r12 != null) goto L5;
    L7:
        r0 = false;
    L9:
        if (r0 == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "ensureObserving ignored: observeJob already active", false, 4, null);
        return;
    L12:
        c = i.a(f8658b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new EcaConditionManager$ensureObserving$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (r12.a() != true) goto L7;
        goto L7
    }

    private final List<a> c(String r8) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L26
        if (StringsKt.startsWith$default(r7, "[", false, 2, null) == false) goto L10;
        JSONArray r9 = new JSONArray(r7);     // Catch: Throwable -> L26
    L15:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L26
        int r1 = r9.length();     // Catch: Throwable -> L26
        int r2 = 0;
    L16:
        if (r2 >= r1) goto L24;
        Object r4 = r9.opt(r2);     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L21;
        r10.add(new a((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), false));     // Catch: Throwable -> L26
    L23:
        r2 = r2 + 1;     // Catch: Throwable -> L26
        goto L16
    L21:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L23;
        String r5 = ((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin")).optString(CronJobRunnerTask.KEY_CRON);     // Catch: Throwable -> L26
        boolean r6 = ((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin")).optBoolean("triggerExactly", false);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L26
        r10.add(new a(r5, r6));     // Catch: Throwable -> L26
        goto L23
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    L10:
        if (StringsKt.startsWith$default(r7, "{", false, 2, null) == false) goto L14;
        r9 = new JSONObject(r7).optJSONArray("timers");     // Catch: Throwable -> L26
        if (r9 != null) goto L15;
        r9 = new JSONArray();     // Catch: Throwable -> L26
        goto L15
    L14:
        r9 = new JSONArray();     // Catch: Throwable -> L26
    L27:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [java.time.ZonedDateTime] */
    private final Long d(String r4) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L15;
        return null;
    L15:
        DateTimeFormatter r6 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");     // Catch: Throwable -> L14
        return Long.valueOf(LocalDateTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"), r6).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    L17:
        return null;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r5 = false;
        goto L10
    }

    public static /* synthetic */ Unit lambda$HGMLJrSwoTLJ9116lLE60mT9bVc(er r0, k.c r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$loTGywUdljSIGTfseS23Z0sSbyQ(boolean r0) {
        a(r0);
    }

    public final void a() {
        if (d == null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "start ignored: already started", false, 4, null);
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "start observe proactiveEcaConditionDao", false, 4, null);
        $$Lambda$d$loTGywUdljSIGTfseS23Z0sSbyQ r6 = $$Lambda$d$loTGywUdljSIGTfseS23Z0sSbyQ.INSTANCE;
        d = r6;
        ProactiveRecommendationEnabledStore.INSTANCE.registerListener(r6, true);
    }
}
