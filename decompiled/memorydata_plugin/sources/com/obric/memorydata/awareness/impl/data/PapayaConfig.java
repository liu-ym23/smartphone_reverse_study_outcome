package com.obric.memorydata.awareness.impl.data;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010&\u001a\u00020'J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0013HÆ\u0003J«\u0001\u00102\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00068"}, d2 = {"Lcom/obric/memorydata/awareness/impl/data/PapayaConfig;", "", "triggerEvents", "", "", "taskDispatchEvents", "featureDurationTriggeredList", "Lcom/obric/memorydata/awareness/impl/data/FeatureDurationTriggeredConfig;", "timerConfig", "Lcom/obric/memorydata/awareness/impl/data/TimerConfig;", "timerConfigs", "cronList", "Lcom/obric/memorydata/awareness/impl/data/CronConfig;", "taskConfig", "Lcom/obric/memorydata/awareness/impl/data/TaskConfig;", "awarenessEventTriggers", "Lcom/obric/memorydata/awareness/impl/data/AwarenessEventTriggerConfig;", "featureEventPolicies", "autoTriggerFeatureSwitches", "Lcom/google/gson/JsonElement;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/obric/memorydata/awareness/impl/data/TimerConfig;Ljava/util/List;Ljava/util/List;Lcom/obric/memorydata/awareness/impl/data/TaskConfig;Ljava/util/List;Ljava/util/List;Lcom/google/gson/JsonElement;)V", "getTriggerEvents", "()Ljava/util/List;", "getTaskDispatchEvents", "getFeatureDurationTriggeredList", "getTimerConfig$annotations", "()V", "getTimerConfig", "()Lcom/obric/memorydata/awareness/impl/data/TimerConfig;", "getTimerConfigs", "getCronList", "getTaskConfig", "()Lcom/obric/memorydata/awareness/impl/data/TaskConfig;", "getAwarenessEventTriggers", "getFeatureEventPolicies", "getAutoTriggerFeatureSwitches", "()Lcom/google/gson/JsonElement;", "hasValidTimer", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PapayaConfig {

    @SerializedName("auto_trigger_feature_switches")
    private final JsonElement autoTriggerFeatureSwitches;

    @SerializedName("awareness_event_triggers")
    private final List<AwarenessEventTriggerConfig> awarenessEventTriggers;

    @SerializedName("cron_list")
    private final List<CronConfig> cronList;

    @SerializedName("feature_duration_triggered_list")
    private final List<FeatureDurationTriggeredConfig> featureDurationTriggeredList;

    @SerializedName("feature_event_policies")
    private final List<String> featureEventPolicies;

    @SerializedName("task_config")
    private final TaskConfig taskConfig;

    @SerializedName("task_dispatch_events")
    private final List<String> taskDispatchEvents;

    @SerializedName(CommonConsts.TIMER_TYPE)
    private final TimerConfig timerConfig;

    @SerializedName("timers")
    private final List<TimerConfig> timerConfigs;

    @SerializedName("trigger_events")
    private final List<String> triggerEvents;

    public PapayaConfig(List<String> r3, List<String> r4, List<FeatureDurationTriggeredConfig> r5, TimerConfig r6, List<TimerConfig> r7, List<CronConfig> r8, TaskConfig r9, List<AwarenessEventTriggerConfig> r10, List<String> r11, JsonElement r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<FeatureDurationTriggeredConfig> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<TimerConfig> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<CronConfig> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<AwarenessEventTriggerConfig> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<String> r19 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        this.triggerEvents = r13;
        this.taskDispatchEvents = r14;
        this.featureDurationTriggeredList = r15;
        this.timerConfig = r6;
        this.timerConfigs = r16;
        this.cronList = r17;
        this.taskConfig = r9;
        this.awarenessEventTriggers = r18;
        this.featureEventPolicies = r19;
        this.autoTriggerFeatureSwitches = r12;
    }

    public /* synthetic */ PapayaConfig(List r15, List r16, List r17, TimerConfig r18, List r19, List r20, TaskConfig r21, List r22, List r23, JsonElement r24, int r25, DefaultConstructorMarker r26) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        if ((r25 & 128) == 0) goto L5;
        List r11 = null;
    L7:
        if ((r25 & 256) == 0) goto L9;
        List r12 = null;
    L11:
        if ((r25 & 512) == 0) goto L13;
        JsonElement r13 = null;
    L14:
        this(r4, r5, r6, r18, r8, r9, r21, r11, r12, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r12 = r2;
        goto L11
    L5:
        r11 = r1;
        goto L7
    }

    public static /* synthetic */ PapayaConfig copy$default(PapayaConfig r12, List r13, List r14, List r15, TimerConfig r16, List r17, List r18, TaskConfig r19, List r20, List r21, JsonElement r22, int r23, Object r24) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List<FeatureDurationTriggeredConfig> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        List<TimerConfig> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List<CronConfig> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        List<AwarenessEventTriggerConfig> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        if ((r23 & 1) == 0) goto L6;
        r2 = r12.triggerEvents;
    L6:
        if ((r23 & 2) == 0) goto L9;
        r4 = r12.taskDispatchEvents;
    L9:
        if ((r23 & 4) == 0) goto L12;
        r5 = r12.featureDurationTriggeredList;
    L12:
        if ((r23 & 8) == 0) goto L14;
        TimerConfig r9 = r12.timerConfig;
    L16:
        if ((r23 & 16) == 0) goto L19;
        r6 = r12.timerConfigs;
    L19:
        if ((r23 & 32) == 0) goto L22;
        r7 = r12.cronList;
    L22:
        if ((r23 & 64) == 0) goto L24;
        TaskConfig r10 = r12.taskConfig;
    L26:
        if ((r23 & 128) == 0) goto L29;
        r8 = r12.awarenessEventTriggers;
    L29:
        if ((r23 & 256) == 0) goto L32;
        r3 = r12.featureEventPolicies;
    L32:
        if ((r23 & 512) == 0) goto L34;
        JsonElement r1 = r12.autoTriggerFeatureSwitches;
    L36:
        return r12.copy(r2, r4, r5, r9, r6, r7, r10, r8, r3, r1);
    L34:
        r1 = r22;
        goto L36
    L24:
        r10 = r19;
        goto L26
    L14:
        r9 = r16;
        goto L16
    }

    @Deprecated(message = "兼容老算法包，先保留")
    public static /* synthetic */ void getTimerConfig$annotations() {
    }

    public final List<String> component1() {
        return this.triggerEvents;
    }

    public final JsonElement component10() {
        return this.autoTriggerFeatureSwitches;
    }

    public final List<String> component2() {
        return this.taskDispatchEvents;
    }

    public final List<FeatureDurationTriggeredConfig> component3() {
        return this.featureDurationTriggeredList;
    }

    public final TimerConfig component4() {
        return this.timerConfig;
    }

    public final List<TimerConfig> component5() {
        return this.timerConfigs;
    }

    public final List<CronConfig> component6() {
        return this.cronList;
    }

    public final TaskConfig component7() {
        return this.taskConfig;
    }

    public final List<AwarenessEventTriggerConfig> component8() {
        return this.awarenessEventTriggers;
    }

    public final List<String> component9() {
        return this.featureEventPolicies;
    }

    public final PapayaConfig copy(List<String> r14, List<String> r15, List<FeatureDurationTriggeredConfig> r16, TimerConfig r17, List<TimerConfig> r18, List<CronConfig> r19, TaskConfig r20, List<AwarenessEventTriggerConfig> r21, List<String> r22, JsonElement r23) {
        return new PapayaConfig((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin"), r17, (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin"), r20, (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin"), r23);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PapayaConfig.class) == true) goto L8;
        return false;
    L8:
        PapayaConfig r6 = (PapayaConfig) ZeusTransformUtils.preCheckCast(r5, PapayaConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.triggerEvents, r6.triggerEvents) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskDispatchEvents, r6.taskDispatchEvents) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.featureDurationTriggeredList, r6.featureDurationTriggeredList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timerConfig, r6.timerConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.timerConfigs, r6.timerConfigs) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cronList, r6.cronList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.taskConfig, r6.taskConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.awarenessEventTriggers, r6.awarenessEventTriggers) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.featureEventPolicies, r6.featureEventPolicies) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.autoTriggerFeatureSwitches, r6.autoTriggerFeatureSwitches) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final JsonElement getAutoTriggerFeatureSwitches() {
        return this.autoTriggerFeatureSwitches;
    }

    public final List<AwarenessEventTriggerConfig> getAwarenessEventTriggers() {
        return this.awarenessEventTriggers;
    }

    public final List<CronConfig> getCronList() {
        return this.cronList;
    }

    public final List<FeatureDurationTriggeredConfig> getFeatureDurationTriggeredList() {
        return this.featureDurationTriggeredList;
    }

    public final List<String> getFeatureEventPolicies() {
        return this.featureEventPolicies;
    }

    public final TaskConfig getTaskConfig() {
        return this.taskConfig;
    }

    public final List<String> getTaskDispatchEvents() {
        return this.taskDispatchEvents;
    }

    public final TimerConfig getTimerConfig() {
        return this.timerConfig;
    }

    public final List<TimerConfig> getTimerConfigs() {
        return this.timerConfigs;
    }

    public final List<String> getTriggerEvents() {
        return this.triggerEvents;
    }

    public final boolean hasValidTimer() {
        TimerConfig r0 = this.timerConfig;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L32;
        List<TimerConfig> r5 = this.timerConfigs;
        if (r5 == null) goto L24;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L14;
    L16:
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L15;
        if (((TimerConfig) ZeusTransformUtils.preCheckCast(r7.next(), TimerConfig.class, "com.obric.memorydata.plugin")).validTimer() == false) goto L18;
        boolean r8 = true;
    L22:
        if (r8 != true) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L28;
        return true;
    L28:
        return false;
    L15:
        r8 = false;
        goto L22
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L24:
        r9 = false;
        goto L25
    L32:
        return true;
    L5:
        if (r0.validTimer() != true) goto L7;
        r1 = true;
        goto L8
    }

    public int hashCode() {
        List<String> r0 = this.triggerEvents;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.taskDispatchEvents;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<FeatureDurationTriggeredConfig> r7 = this.featureDurationTriggeredList;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        TimerConfig r10 = this.timerConfig;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<TimerConfig> r13 = this.timerConfigs;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<CronConfig> r16 = this.cronList;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        TaskConfig r19 = this.taskConfig;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<AwarenessEventTriggerConfig> r22 = this.awarenessEventTriggers;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.featureEventPolicies;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        JsonElement r28 = this.autoTriggerFeatureSwitches;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PapayaConfig(triggerEvents=" + this.triggerEvents + ", taskDispatchEvents=" + this.taskDispatchEvents + ", featureDurationTriggeredList=" + this.featureDurationTriggeredList + ", timerConfig=" + this.timerConfig + ", timerConfigs=" + this.timerConfigs + ", cronList=" + this.cronList + ", taskConfig=" + this.taskConfig + ", awarenessEventTriggers=" + this.awarenessEventTriggers + ", featureEventPolicies=" + this.featureEventPolicies + ", autoTriggerFeatureSwitches=" + this.autoTriggerFeatureSwitches + ')';
    }
}
