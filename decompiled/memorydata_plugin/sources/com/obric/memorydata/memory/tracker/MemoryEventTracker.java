package com.obric.memorydata.memory.tracker;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.k;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b4\bÆ\u0002\u0018\u00002\u00020\u0001:\u0018cdefghijklmnopqrstuvwxyzB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u001eH\u0002J\u0014\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u0013J\u007f\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00132\b\b\u0002\u00101\u001a\u00020\u00132\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00105J9\u0010#\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00132\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010:JP\u0010;\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005J'\u0010A\u001a\u00020\r2\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0C\"\u00020%2\u0006\u0010D\u001a\u00020\u0005¢\u0006\u0002\u0010EJ\u001c\u0010A\u001a\u00020\r2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050G2\u0006\u0010D\u001a\u00020\u0005J\u001e\u0010H\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0005J.\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0013J\f\u0010P\u001a\u00020\u0007*\u00020\u0013H\u0002JR\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\u00132\b\u0010S\u001a\u0004\u0018\u00010\u00052\b\u0010T\u001a\u0004\u0018\u00010\u00052\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00132\u0006\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020\u0005JP\u0010[\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020\u00052\b\b\u0002\u0010_\u001a\u00020\u0005J\u0018\u0010`\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006{"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker;", "", "<init>", "()V", "TAG", "", "BATCH_SIZE", "", "externalSourceTypes", "", "getExternalSourceTypes", "()Ljava/util/Set;", "trackMemoryEventWithParams", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "trackAutoMemoryRuleHit", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$AutoMemoryRuleHitParams;", "trackMemorySettingsSnapshot", "", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySettingsSnapshotParams;", "trackMemorySettingsSnapshot$memory_obricRelease", "toEventJson", "Lorg/json/JSONObject;", "toEventJson$memory_obricRelease", "confidenceScoreValue", "score", "", "(Ljava/lang/Float;)Ljava/lang/Integer;", "trackProcessedSemanticMemory", "Lcom/obric/memorydata/memory/api/ProcessedSemanticMemoryParams;", "processedSemanticParams", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$NewMemoryParams;", "processedSourcePackages", "sourcePackageName", "trackNewMemory", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "generateMethod", "batched", "trackNewProactiveMemoryFromUnion", Api.KEY_UUID, "sourceProductType", "type", LocationMonitorConst.TAG, "createTime", "", "modifyTime", "isNewEntity", "forceAddNew", "confidenceScore", "previousConfidenceScore", "memoryTag", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JJZZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "rawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Lcom/obric/memorydata/database/entity/RawMemoryEntity;Ljava/lang/String;ZLjava/lang/Float;)V", "trackPageShow", "enterFrom", "currentPage", "previousPage", "tabName", "tagName", "trackDeleteMemory", "appEntityArray", "", "deleteMethod", "([Lcom/obric/capabilitykit/entity/app/AppEntity;Ljava/lang/String;)V", "ids", "", "trackMemoryClick", "recation", "trackMemorySwitchSnapshot", "autoMemoryEnabled", "screenObservationEnabled", "auditoryMemoryEnabled", "keyShortcutEnabled", "gestureShortcutEnabled", "toSwitchState", "trackRuleEdit", "isEdit", "rawInput", "rewriteResult", "userEditResult", "activeStartMinute", "activeEndMinute", "autoCaptureEnabled", "isFromPreset", "appPackages", "trackRuleDailyReport", "ruleTitle", "ruleConfig", "isPaused", AILabCheckPermissionTask.KEY_SOURCE, "formatMemoryFrequency", "startMin", "endMin", "MemoryPage", "MemoryEventType", "RuleEditOperation", "ReactionType", "ResultType", "SourceType", "GenerateMethod", "DeleteMethod", "MemorySource", "TypeLevel1", "TypeLevel2", "Params", "MemorySettingsSnapshotParams", "MemorySwitchSnapshotParams", "NewMemoryParams", "MemoryDataUploadOnceParams", "BaseMemoryParams", "PageShowParams", "ClickCardItemParams", "EditCardItemParams", "DeleteCardItemParams", "AutoMemoryRuleHitParams", "RuleEditParams", "RuleDailyReportParams", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryEventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemoryEventTracker f10515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f10516b = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006,"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$AutoMemoryRuleHitParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "ruleId", "", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "version", "engineVersion", "templateVersion", "triggerChannel", "activityName", "eventType", "operation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRuleId", "()Ljava/lang/String;", "getAppName", "getPackageName", "getVersion", "getEngineVersion", "getTemplateVersion", "getTriggerChannel", "getActivityName", "getEventType", "getOperation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryRuleHitParams extends Params {

        @SerializedName("activity_name")
        private final String activityName;

        @SerializedName(Api.KEY_APP_NAME)
        private final String appName;

        @SerializedName("engine_version")
        private final String engineVersion;

        @SerializedName(Constants.EVENT_TYPE)
        private final String eventType;
        private final String operation;

        @SerializedName("package_name")
        private final String packageName;

        @SerializedName("rule_id")
        private final String ruleId;

        @SerializedName("template_version")
        private final String templateVersion;

        @SerializedName("trigger_channel")
        private final String triggerChannel;
        private final String version;

        public AutoMemoryRuleHitParams(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r2, "ruleId");
            Intrinsics.checkNotNullParameter(r3, "appName");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r5, "version");
            Intrinsics.checkNotNullParameter(r6, "engineVersion");
            Intrinsics.checkNotNullParameter(r7, "templateVersion");
            Intrinsics.checkNotNullParameter(r8, "triggerChannel");
            Intrinsics.checkNotNullParameter(r9, "activityName");
            Intrinsics.checkNotNullParameter(r10, "eventType");
            Intrinsics.checkNotNullParameter(r11, "operation");
            super(null);
            this.ruleId = r2;
            this.appName = r3;
            this.packageName = r4;
            this.version = r5;
            this.engineVersion = r6;
            this.templateVersion = r7;
            this.triggerChannel = r8;
            this.activityName = r9;
            this.eventType = r10;
            this.operation = r11;
        }

        public static /* synthetic */ AutoMemoryRuleHitParams copy$default(AutoMemoryRuleHitParams r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
            if ((r22 & 1) == 0) goto L5;
            String r2 = r11.ruleId;
        L7:
            if ((r22 & 2) == 0) goto L9;
            String r3 = r11.appName;
        L11:
            if ((r22 & 4) == 0) goto L13;
            String r4 = r11.packageName;
        L15:
            if ((r22 & 8) == 0) goto L17;
            String r5 = r11.version;
        L19:
            if ((r22 & 16) == 0) goto L21;
            String r6 = r11.engineVersion;
        L23:
            if ((r22 & 32) == 0) goto L25;
            String r7 = r11.templateVersion;
        L27:
            if ((r22 & 64) == 0) goto L29;
            String r8 = r11.triggerChannel;
        L31:
            if ((r22 & 128) == 0) goto L33;
            String r9 = r11.activityName;
        L35:
            if ((r22 & 256) == 0) goto L37;
            String r10 = r11.eventType;
        L39:
            if ((r22 & 512) == 0) goto L41;
            String r1 = r11.operation;
        L43:
            return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
        L41:
            r1 = r21;
            goto L43
        L37:
            r10 = r20;
            goto L39
        L33:
            r9 = r19;
            goto L35
        L29:
            r8 = r18;
            goto L31
        L25:
            r7 = r17;
            goto L27
        L21:
            r6 = r16;
            goto L23
        L17:
            r5 = r15;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r3 = r13;
            goto L11
        L5:
            r2 = r12;
            goto L7
        }

        public final String component1() {
            return this.ruleId;
        }

        public final String component10() {
            return this.operation;
        }

        public final String component2() {
            return this.appName;
        }

        public final String component3() {
            return this.packageName;
        }

        public final String component4() {
            return this.version;
        }

        public final String component5() {
            return this.engineVersion;
        }

        public final String component6() {
            return this.templateVersion;
        }

        public final String component7() {
            return this.triggerChannel;
        }

        public final String component8() {
            return this.activityName;
        }

        public final String component9() {
            return this.eventType;
        }

        public final AutoMemoryRuleHitParams copy(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
            Intrinsics.checkNotNullParameter(r13, "ruleId");
            Intrinsics.checkNotNullParameter(r14, "appName");
            Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r16, "version");
            Intrinsics.checkNotNullParameter(r17, "engineVersion");
            Intrinsics.checkNotNullParameter(r18, "templateVersion");
            Intrinsics.checkNotNullParameter(r19, "triggerChannel");
            Intrinsics.checkNotNullParameter(r20, "activityName");
            Intrinsics.checkNotNullParameter(r21, "eventType");
            Intrinsics.checkNotNullParameter(r22, "operation");
            return new AutoMemoryRuleHitParams(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryRuleHitParams.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryRuleHitParams r6 = (AutoMemoryRuleHitParams) ZeusTransformUtils.preCheckCast(r5, AutoMemoryRuleHitParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.ruleId, r6.ruleId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.version, r6.version) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.engineVersion, r6.engineVersion) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.templateVersion, r6.templateVersion) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.triggerChannel, r6.triggerChannel) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.activityName, r6.activityName) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.eventType, r6.eventType) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.operation, r6.operation) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getEngineVersion() {
            return this.engineVersion;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final String getOperation() {
            return this.operation;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getRuleId() {
            return this.ruleId;
        }

        public final String getTemplateVersion() {
            return this.templateVersion;
        }

        public final String getTriggerChannel() {
            return this.triggerChannel;
        }

        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return (((((((((((((((((this.ruleId.hashCode() * 31) + this.appName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.version.hashCode()) * 31) + this.engineVersion.hashCode()) * 31) + this.templateVersion.hashCode()) * 31) + this.triggerChannel.hashCode()) * 31) + this.activityName.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.operation.hashCode();
        }

        public String toString() {
            return "AutoMemoryRuleHitParams(ruleId=" + this.ruleId + ", appName=" + this.appName + ", packageName=" + this.packageName + ", version=" + this.version + ", engineVersion=" + this.engineVersion + ", templateVersion=" + this.templateVersion + ", triggerChannel=" + this.triggerChannel + ", activityName=" + this.activityName + ", eventType=" + this.eventType + ", operation=" + this.operation + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J \u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\bHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;", "", "memoryId", "", "generateMethod", AILabCheckPermissionTask.KEY_SOURCE, ObricMemoryConstants.KEY_PACKAGE_NAME, "state", "", "type", LocationMonitorConst.TAG, "startTime", "endTime", "createTime", "modifyTime", "auditoryDuration", "memoryTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getMemoryId", "()Ljava/lang/String;", "getGenerateMethod", "getSource", "getPackageName", "getState", "()I", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTag", "getStartTime", "getEndTime", "getCreateTime", "getModifyTime", "getAuditoryDuration", "getMemoryTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BaseMemoryParams {

        @SerializedName("auditory_duration")
        private final Integer auditoryDuration;

        @SerializedName("create_time")
        private final String createTime;

        @SerializedName("end_time")
        private final String endTime;

        @SerializedName("generate_method")
        private final String generateMethod;

        @SerializedName("memory_id")
        private final String memoryId;

        @SerializedName("memory_tag")
        private final String memoryTag;

        @SerializedName("modify_time")
        private final String modifyTime;

        @SerializedName("package_name")
        private final String packageName;
        private final String source;

        @SerializedName("start_time")
        private final String startTime;
        private final int state;

        @SerializedName(LocationMonitorConst.TAG)
        private final String tag;

        @SerializedName("type")
        private final Integer type;

        public BaseMemoryParams(String r2, String r3, String r4, String r5, int r6, Integer r7, String r8, String r9, String r10, String r11, String r12, Integer r13, String r14) {
            Intrinsics.checkNotNullParameter(r3, "generateMethod");
            Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkNotNullParameter(r11, "createTime");
            Intrinsics.checkNotNullParameter(r12, "modifyTime");
            this.memoryId = r2;
            this.generateMethod = r3;
            this.source = r4;
            this.packageName = r5;
            this.state = r6;
            this.type = r7;
            this.tag = r8;
            this.startTime = r9;
            this.endTime = r10;
            this.createTime = r11;
            this.modifyTime = r12;
            this.auditoryDuration = r13;
            this.memoryTag = r14;
        }

        public /* synthetic */ BaseMemoryParams(String r18, String r19, String r20, String r21, int r22, Integer r23, String r24, String r25, String r26, String r27, String r28, Integer r29, String r30, int r31, DefaultConstructorMarker r32) {
            if ((r31 & 1) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r31 & 8) == 0) goto L9;
            String r7 = null;
        L11:
            if ((r31 & 32) == 0) goto L13;
            Integer r9 = null;
        L15:
            if ((r31 & 64) == 0) goto L17;
            String r10 = null;
        L19:
            if ((r31 & 128) == 0) goto L21;
            String r11 = null;
        L23:
            if ((r31 & 256) == 0) goto L25;
            String r12 = null;
        L27:
            if ((r31 & 2048) == 0) goto L29;
            Integer r15 = null;
        L31:
            if ((r31 & 4096) == 0) goto L33;
            String r16 = null;
        L34:
            this(r4, r19, r20, r7, r22, r9, r10, r11, r12, r27, r28, r15, r16);
            return;
        L33:
            r16 = r30;
            goto L34
        L29:
            r15 = r29;
            goto L31
        L25:
            r12 = r26;
            goto L27
        L21:
            r11 = r25;
            goto L23
        L17:
            r10 = r24;
            goto L19
        L13:
            r9 = r23;
            goto L15
        L9:
            r7 = r21;
            goto L11
        L5:
            r4 = r18;
            goto L7
        }

        public static /* synthetic */ BaseMemoryParams copy$default(BaseMemoryParams r14, String r15, String r16, String r17, String r18, int r19, Integer r20, String r21, String r22, String r23, String r24, String r25, Integer r26, String r27, int r28, Object r29) {
            if ((r28 & 1) == 0) goto L5;
            String r2 = r14.memoryId;
        L7:
            if ((r28 & 2) == 0) goto L9;
            String r3 = r14.generateMethod;
        L11:
            if ((r28 & 4) == 0) goto L13;
            String r4 = r14.source;
        L15:
            if ((r28 & 8) == 0) goto L17;
            String r5 = r14.packageName;
        L19:
            if ((r28 & 16) == 0) goto L21;
            int r6 = r14.state;
        L23:
            if ((r28 & 32) == 0) goto L25;
            Integer r7 = r14.type;
        L27:
            if ((r28 & 64) == 0) goto L29;
            String r8 = r14.tag;
        L31:
            if ((r28 & 128) == 0) goto L33;
            String r9 = r14.startTime;
        L35:
            if ((r28 & 256) == 0) goto L37;
            String r10 = r14.endTime;
        L39:
            if ((r28 & 512) == 0) goto L41;
            String r11 = r14.createTime;
        L43:
            if ((r28 & 1024) == 0) goto L45;
            String r12 = r14.modifyTime;
        L47:
            if ((r28 & 2048) == 0) goto L49;
            Integer r13 = r14.auditoryDuration;
        L51:
            if ((r28 & 4096) == 0) goto L53;
            String r1 = r14.memoryTag;
        L55:
            return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
        L53:
            r1 = r27;
            goto L55
        L49:
            r13 = r26;
            goto L51
        L45:
            r12 = r25;
            goto L47
        L41:
            r11 = r24;
            goto L43
        L37:
            r10 = r23;
            goto L39
        L33:
            r9 = r22;
            goto L35
        L29:
            r8 = r21;
            goto L31
        L25:
            r7 = r20;
            goto L27
        L21:
            r6 = r19;
            goto L23
        L17:
            r5 = r18;
            goto L19
        L13:
            r4 = r17;
            goto L15
        L9:
            r3 = r16;
            goto L11
        L5:
            r2 = r15;
            goto L7
        }

        public final String component1() {
            return this.memoryId;
        }

        public final String component10() {
            return this.createTime;
        }

        public final String component11() {
            return this.modifyTime;
        }

        public final Integer component12() {
            return this.auditoryDuration;
        }

        public final String component13() {
            return this.memoryTag;
        }

        public final String component2() {
            return this.generateMethod;
        }

        public final String component3() {
            return this.source;
        }

        public final String component4() {
            return this.packageName;
        }

        public final int component5() {
            return this.state;
        }

        public final Integer component6() {
            return this.type;
        }

        public final String component7() {
            return this.tag;
        }

        public final String component8() {
            return this.startTime;
        }

        public final String component9() {
            return this.endTime;
        }

        public final BaseMemoryParams copy(String r16, String r17, String r18, String r19, int r20, Integer r21, String r22, String r23, String r24, String r25, String r26, Integer r27, String r28) {
            Intrinsics.checkNotNullParameter(r17, "generateMethod");
            Intrinsics.checkNotNullParameter(r18, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkNotNullParameter(r25, "createTime");
            Intrinsics.checkNotNullParameter(r26, "modifyTime");
            return new BaseMemoryParams(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, BaseMemoryParams.class) == true) goto L8;
            return false;
        L8:
            BaseMemoryParams r6 = (BaseMemoryParams) ZeusTransformUtils.preCheckCast(r5, BaseMemoryParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.memoryId, r6.memoryId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.generateMethod, r6.generateMethod) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.source, r6.source) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L21;
            return false;
        L21:
            if (this.state == r6.state) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.modifyTime, r6.modifyTime) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.auditoryDuration, r6.auditoryDuration) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.memoryTag, r6.memoryTag) == true) goto L47;
            return false;
        L47:
            return true;
        }

        public final Integer getAuditoryDuration() {
            return this.auditoryDuration;
        }

        public final String getCreateTime() {
            return this.createTime;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final String getGenerateMethod() {
            return this.generateMethod;
        }

        public final String getMemoryId() {
            return this.memoryId;
        }

        public final String getMemoryTag() {
            return this.memoryTag;
        }

        public final String getModifyTime() {
            return this.modifyTime;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final int getState() {
            return this.state;
        }

        public final String getTag() {
            return this.tag;
        }

        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            String r0 = this.memoryId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((r2 * 31) + this.generateMethod.hashCode()) * 31) + this.source.hashCode()) * 31;
            String r4 = this.packageName;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.state)) * 31;
            Integer r7 = this.type;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.tag;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.startTime;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.endTime;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (((((r15 + r17) * 31) + this.createTime.hashCode()) * 31) + this.modifyTime.hashCode()) * 31;
            Integer r19 = this.auditoryDuration;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.memoryTag;
            if (r22 == null) goto L35;
            r1 = r22.hashCode();
        L35:
            return r21 + r1;
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
            StringBuilder r0 = new StringBuilder();
            r0.append("BaseMemoryParams(memoryId=").append(this.memoryId).append(", generateMethod=").append(this.generateMethod).append(", source=").append(this.source).append(", packageName=").append(this.packageName).append(", state=").append(this.state).append(", type=").append(this.type).append(", tag=").append(this.tag).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", auditoryDuration=");
            r0.append(this.auditoryDuration).append(", memoryTag=").append(this.memoryTag).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JF\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$ClickCardItemParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "memoryId", "", "type", "", LocationMonitorConst.TAG, "reaction", "enterFrom", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;)V", "getMemoryId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTag", "getReaction", "()I", "getEnterFrom", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;)Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$ClickCardItemParams;", "equals", "", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ClickCardItemParams extends Params {

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("memory_id")
        private final String memoryId;
        private final int reaction;

        @SerializedName(LocationMonitorConst.TAG)
        private final String tag;

        @SerializedName("type")
        private final Integer type;

        public ClickCardItemParams(String r2, Integer r3, String r4, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "enterFrom");
            super(null);
            this.memoryId = r2;
            this.type = r3;
            this.tag = r4;
            this.reaction = r5;
            this.enterFrom = r6;
        }

        public /* synthetic */ ClickCardItemParams(String r8, Integer r9, String r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L5;
            String r2 = null;
        L7:
            if ((r13 & 2) == 0) goto L9;
            Integer r3 = null;
        L11:
            if ((r13 & 4) == 0) goto L13;
            String r4 = null;
        L14:
            this(r2, r3, r4, r11, r12);
            return;
        L13:
            r4 = r10;
            goto L14
        L9:
            r3 = r9;
            goto L11
        L5:
            r2 = r8;
            goto L7
        }

        public static /* synthetic */ ClickCardItemParams copy$default(ClickCardItemParams r3, String r4, Integer r5, String r6, int r7, String r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.memoryId;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.type;
        L8:
            Integer r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.tag;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.reaction;
        L14:
            int r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.enterFrom;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return this.memoryId;
        }

        public final Integer component2() {
            return this.type;
        }

        public final String component3() {
            return this.tag;
        }

        public final int component4() {
            return this.reaction;
        }

        public final String component5() {
            return this.enterFrom;
        }

        public final ClickCardItemParams copy(String r7, Integer r8, String r9, int r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "enterFrom");
            return new ClickCardItemParams(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ClickCardItemParams.class) == true) goto L8;
            return false;
        L8:
            ClickCardItemParams r6 = (ClickCardItemParams) ZeusTransformUtils.preCheckCast(r5, ClickCardItemParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.memoryId, r6.memoryId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L18;
            return false;
        L18:
            if (this.reaction == r6.reaction) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.enterFrom, r6.enterFrom) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final String getMemoryId() {
            return this.memoryId;
        }

        public final int getReaction() {
            return this.reaction;
        }

        public final String getTag() {
            return this.tag;
        }

        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            String r0 = this.memoryId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.type;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.tag;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return ((((r6 + r1) * 31) + Integer.hashCode(this.reaction)) * 31) + this.enterFrom.hashCode();
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ClickCardItemParams(memoryId=" + this.memoryId + ", type=" + this.type + ", tag=" + this.tag + ", reaction=" + this.reaction + ", enterFrom=" + this.enterFrom + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$DeleteCardItemParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "memoryId", "", "deleteMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMemoryId", "()Ljava/lang/String;", "getDeleteMethod", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DeleteCardItemParams extends Params {

        @SerializedName("delete_method")
        private final String deleteMethod;

        @SerializedName("memory_id")
        private final String memoryId;

        public DeleteCardItemParams(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "deleteMethod");
            super(null);
            this.memoryId = r2;
            this.deleteMethod = r3;
        }

        public /* synthetic */ DeleteCardItemParams(String r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1, r2);
        }

        public static /* synthetic */ DeleteCardItemParams copy$default(DeleteCardItemParams r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.memoryId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.deleteMethod;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.memoryId;
        }

        public final String component2() {
            return this.deleteMethod;
        }

        public final DeleteCardItemParams copy(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "deleteMethod");
            return new DeleteCardItemParams(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, DeleteCardItemParams.class) == true) goto L8;
            return false;
        L8:
            DeleteCardItemParams r6 = (DeleteCardItemParams) ZeusTransformUtils.preCheckCast(r5, DeleteCardItemParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.memoryId, r6.memoryId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.deleteMethod, r6.deleteMethod) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getDeleteMethod() {
            return this.deleteMethod;
        }

        public final String getMemoryId() {
            return this.memoryId;
        }

        public int hashCode() {
            String r0 = this.memoryId;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.deleteMethod.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "DeleteCardItemParams(memoryId=" + this.memoryId + ", deleteMethod=" + this.deleteMethod + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$DeleteMethod;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GUI_DELETE", "QUERY_DELETE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum DeleteMethod extends Enum<DeleteMethod> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DeleteMethod[] $VALUES = null;
        public static final DeleteMethod GUI_DELETE = null;
        public static final DeleteMethod QUERY_DELETE = null;
        private final String value;

        private static final /* synthetic */ DeleteMethod[] $values() {
            return new DeleteMethod[]{GUI_DELETE, QUERY_DELETE};
        }

        static {
            GUI_DELETE = new DeleteMethod("GUI_DELETE", 0, "gui");
            QUERY_DELETE = new DeleteMethod("QUERY_DELETE", 1, ChatMessage.TYPE_QUERY);
            DeleteMethod[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DeleteMethod(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<DeleteMethod> getEntries() {
            return $ENTRIES;
        }

        public static DeleteMethod valueOf(String r2) {
            return (DeleteMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(DeleteMethod.class, r2), DeleteMethod.class, "com.obric.memorydata.plugin");
        }

        public static DeleteMethod[] values() {
            return (DeleteMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DeleteMethod[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$EditCardItemParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "type", "", "<init>", "(I)V", "getType", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EditCardItemParams extends Params {
        private final int type;

        public EditCardItemParams(int r2) {
            super(null);
            this.type = r2;
        }

        public static /* synthetic */ EditCardItemParams copy$default(EditCardItemParams r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.type;
        }

        public final EditCardItemParams copy(int r1) {
            return new EditCardItemParams(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, EditCardItemParams.class) == true) goto L8;
            return false;
        L8:
            EditCardItemParams r6 = (EditCardItemParams) ZeusTransformUtils.preCheckCast(r5, EditCardItemParams.class, "com.obric.memorydata.plugin");
            if (this.type == r6.type) goto L11;
            return false;
        L11:
            return true;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return Integer.hashCode(this.type);
        }

        public String toString() {
            return "EditCardItemParams(type=" + this.type + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$GenerateMethod;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ADD_NEW", "UPDATE", "UPDATE_QUERY", "SEMANTIC_TIMESLOP_ADD_NEW", "SEMANTIC_TIMESLOP_UPDATE", "SEMANTIC_DAILY_ADD_NEW", "SEMANTIC_DAILY_UPDATE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum GenerateMethod extends Enum<GenerateMethod> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ GenerateMethod[] $VALUES = null;
        public static final GenerateMethod ADD_NEW = null;
        public static final GenerateMethod SEMANTIC_DAILY_ADD_NEW = null;
        public static final GenerateMethod SEMANTIC_DAILY_UPDATE = null;
        public static final GenerateMethod SEMANTIC_TIMESLOP_ADD_NEW = null;
        public static final GenerateMethod SEMANTIC_TIMESLOP_UPDATE = null;
        public static final GenerateMethod UPDATE = null;
        public static final GenerateMethod UPDATE_QUERY = null;
        private final String value;

        private static final /* synthetic */ GenerateMethod[] $values() {
            return new GenerateMethod[]{ADD_NEW, UPDATE, UPDATE_QUERY, SEMANTIC_TIMESLOP_ADD_NEW, SEMANTIC_TIMESLOP_UPDATE, SEMANTIC_DAILY_ADD_NEW, SEMANTIC_DAILY_UPDATE};
        }

        static {
            ADD_NEW = new GenerateMethod("ADD_NEW", 0, "add_new");
            UPDATE = new GenerateMethod("UPDATE", 1, BuildConfig.CHANNEL);
            UPDATE_QUERY = new GenerateMethod("UPDATE_QUERY", 2, "update_query");
            SEMANTIC_TIMESLOP_ADD_NEW = new GenerateMethod("SEMANTIC_TIMESLOP_ADD_NEW", 3, "semantic_timeslop_add_new");
            SEMANTIC_TIMESLOP_UPDATE = new GenerateMethod("SEMANTIC_TIMESLOP_UPDATE", 4, "semantic_timeslop_update");
            SEMANTIC_DAILY_ADD_NEW = new GenerateMethod("SEMANTIC_DAILY_ADD_NEW", 5, "semantic_daily_add_new");
            SEMANTIC_DAILY_UPDATE = new GenerateMethod("SEMANTIC_DAILY_UPDATE", 6, "semantic_daily_update");
            GenerateMethod[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private GenerateMethod(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<GenerateMethod> getEntries() {
            return $ENTRIES;
        }

        public static GenerateMethod valueOf(String r2) {
            return (GenerateMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(GenerateMethod.class, r2), GenerateMethod.class, "com.obric.memorydata.plugin");
        }

        public static GenerateMethod[] values() {
            return (GenerateMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GenerateMethod[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemoryDataUploadOnceParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "base", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;", "<init>", "(Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;)V", "getBase", "()Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MemoryDataUploadOnceParams extends Params {
        private final BaseMemoryParams base;

        public MemoryDataUploadOnceParams(BaseMemoryParams r2) {
            Intrinsics.checkNotNullParameter(r2, "base");
            super(null);
            this.base = r2;
        }

        public static /* synthetic */ MemoryDataUploadOnceParams copy$default(MemoryDataUploadOnceParams r0, BaseMemoryParams r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.base;
        L6:
            return r0.copy(r1);
        }

        public final BaseMemoryParams component1() {
            return this.base;
        }

        public final MemoryDataUploadOnceParams copy(BaseMemoryParams r1) {
            Intrinsics.checkNotNullParameter(r1, "base");
            return new MemoryDataUploadOnceParams(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MemoryDataUploadOnceParams.class) == true) goto L8;
            return false;
        L8:
            MemoryDataUploadOnceParams r6 = (MemoryDataUploadOnceParams) ZeusTransformUtils.preCheckCast(r5, MemoryDataUploadOnceParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.base, r6.base) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final BaseMemoryParams getBase() {
            return this.base;
        }

        public int hashCode() {
            return this.base.hashCode();
        }

        public String toString() {
            return "MemoryDataUploadOnceParams(base=" + this.base + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemoryEventType;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "MEMORY_SWITCH_SNAPSHOT", "MEMORY_SETTINGS_SNAPSHOT", "NEW_MEMORY", "PAGE_SHOW", "CLICK_CARD_ITEM", "EDIT_CARD_ITEM", "DELETE_CARD_ITEM", "MEMORY_DATA_UPLOAD_ONCE", "AUTO_MEMORY_RULE_HIT", "AUTO_MEMORY_PRO_RULE_EDIT", "AUTO_MEMORY_PRO_RULE_DAILY_REPORT", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum MemoryEventType extends Enum<MemoryEventType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MemoryEventType[] $VALUES = null;
        public static final MemoryEventType AUTO_MEMORY_PRO_RULE_DAILY_REPORT = null;
        public static final MemoryEventType AUTO_MEMORY_PRO_RULE_EDIT = null;
        public static final MemoryEventType AUTO_MEMORY_RULE_HIT = null;
        public static final MemoryEventType CLICK_CARD_ITEM = null;
        public static final MemoryEventType DELETE_CARD_ITEM = null;
        public static final MemoryEventType EDIT_CARD_ITEM = null;
        public static final MemoryEventType MEMORY_DATA_UPLOAD_ONCE = null;
        public static final MemoryEventType MEMORY_SETTINGS_SNAPSHOT = null;
        public static final MemoryEventType MEMORY_SWITCH_SNAPSHOT = null;
        public static final MemoryEventType NEW_MEMORY = null;
        public static final MemoryEventType PAGE_SHOW = null;
        private final String eventName;

        private static final /* synthetic */ MemoryEventType[] $values() {
            return new MemoryEventType[]{MEMORY_SWITCH_SNAPSHOT, MEMORY_SETTINGS_SNAPSHOT, NEW_MEMORY, PAGE_SHOW, CLICK_CARD_ITEM, EDIT_CARD_ITEM, DELETE_CARD_ITEM, MEMORY_DATA_UPLOAD_ONCE, AUTO_MEMORY_RULE_HIT, AUTO_MEMORY_PRO_RULE_EDIT, AUTO_MEMORY_PRO_RULE_DAILY_REPORT};
        }

        static {
            MEMORY_SWITCH_SNAPSHOT = new MemoryEventType("MEMORY_SWITCH_SNAPSHOT", 0, "memory_switch_snapshot");
            MEMORY_SETTINGS_SNAPSHOT = new MemoryEventType("MEMORY_SETTINGS_SNAPSHOT", 1, "memory_settings_snapshot");
            NEW_MEMORY = new MemoryEventType("NEW_MEMORY", 2, "memory_new_memory");
            PAGE_SHOW = new MemoryEventType("PAGE_SHOW", 3, "memory_page_show");
            CLICK_CARD_ITEM = new MemoryEventType("CLICK_CARD_ITEM", 4, "memory_click_card_item");
            EDIT_CARD_ITEM = new MemoryEventType("EDIT_CARD_ITEM", 5, "memory_edit_card_item");
            DELETE_CARD_ITEM = new MemoryEventType("DELETE_CARD_ITEM", 6, "memory_delete_card_item");
            MEMORY_DATA_UPLOAD_ONCE = new MemoryEventType("MEMORY_DATA_UPLOAD_ONCE", 7, "memory_data_upload_once");
            AUTO_MEMORY_RULE_HIT = new MemoryEventType("AUTO_MEMORY_RULE_HIT", 8, "auto_memory_rule_hit");
            AUTO_MEMORY_PRO_RULE_EDIT = new MemoryEventType("AUTO_MEMORY_PRO_RULE_EDIT", 9, "auto_memory_pro_rule_edit");
            AUTO_MEMORY_PRO_RULE_DAILY_REPORT = new MemoryEventType("AUTO_MEMORY_PRO_RULE_DAILY_REPORT", 10, "auto_memory_pro_rule_daily_report");
            MemoryEventType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private MemoryEventType(String r1, int r2, String r3) {
            super(r1, r2);
            this.eventName = r3;
        }

        public static EnumEntries<MemoryEventType> getEntries() {
            return $ENTRIES;
        }

        public static MemoryEventType valueOf(String r2) {
            return (MemoryEventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryEventType.class, r2), MemoryEventType.class, "com.obric.memorydata.plugin");
        }

        public static MemoryEventType[] values() {
            return (MemoryEventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryEventType[].class, "com.obric.memorydata.plugin");
        }

        public final String getEventName() {
            return this.eventName;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemoryPage;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MEMORY_LIST", "MEMORY_DETAIL", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum MemoryPage extends Enum<MemoryPage> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MemoryPage[] $VALUES = null;
        public static final MemoryPage MEMORY_DETAIL = null;
        public static final MemoryPage MEMORY_LIST = null;
        private final String value;

        private static final /* synthetic */ MemoryPage[] $values() {
            return new MemoryPage[]{MEMORY_LIST, MEMORY_DETAIL};
        }

        static {
            MEMORY_LIST = new MemoryPage("MEMORY_LIST", 0, "memory_list");
            MEMORY_DETAIL = new MemoryPage("MEMORY_DETAIL", 1, "memory_list_detail");
            MemoryPage[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private MemoryPage(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<MemoryPage> getEntries() {
            return $ENTRIES;
        }

        public static MemoryPage valueOf(String r2) {
            return (MemoryPage) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryPage.class, r2), MemoryPage.class, "com.obric.memorydata.plugin");
        }

        public static MemoryPage[] values() {
            return (MemoryPage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryPage[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\bI\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003Jý\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\u0003HÖ\u0001J\t\u0010V\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$¨\u0006W"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySettingsSnapshotParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "memManualHotkey", "", "memManualGesture", "memAuto", "memAutoOperate", "memAutoFav", "", "locAutoLearn", "locHomeSet", "locCompanySet", "percScreen", "percVoice", "percSysapp", "percNotification", "percDevice", "percLocationPoi", "percMotion", "glassesStatus", "blockRuleCount", "percCellularUpload", "privacyIdentityVerify", "privacyUxPlan", "addIconDesktop", "triggerType", "percVoiceStart", "percVoiceEnd", "<init>", "(IIIILjava/lang/String;IIIIILjava/lang/String;IIIIIIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMemManualHotkey", "()I", "getMemManualGesture", "getMemAuto", "getMemAutoOperate", "getMemAutoFav", "()Ljava/lang/String;", "getLocAutoLearn", "getLocHomeSet", "getLocCompanySet", "getPercScreen", "getPercVoice", "getPercSysapp", "getPercNotification", "getPercDevice", "getPercLocationPoi", "getPercMotion", "getGlassesStatus", "getBlockRuleCount", "getPercCellularUpload", "getPrivacyIdentityVerify", "getPrivacyUxPlan", "getAddIconDesktop", "getTriggerType", "getPercVoiceStart", "getPercVoiceEnd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MemorySettingsSnapshotParams extends Params {

        @SerializedName("add_icon_desktop")
        private final int addIconDesktop;

        @SerializedName("block_rule_count")
        private final int blockRuleCount;

        @SerializedName("glasses_status")
        private final int glassesStatus;

        @SerializedName("loc_auto_learn")
        private final int locAutoLearn;

        @SerializedName("loc_company_set")
        private final int locCompanySet;

        @SerializedName("loc_home_set")
        private final int locHomeSet;

        @SerializedName("mem_auto")
        private final int memAuto;

        @SerializedName("mem_auto_fav")
        private final String memAutoFav;

        @SerializedName("mem_auto_operate")
        private final int memAutoOperate;

        @SerializedName("mem_manual_gesture")
        private final int memManualGesture;

        @SerializedName("mem_manual_hotkey")
        private final int memManualHotkey;

        @SerializedName("perc_cellular_upload")
        private final int percCellularUpload;

        @SerializedName("perc_device")
        private final int percDevice;

        @SerializedName("perc_location_poi")
        private final int percLocationPoi;

        @SerializedName("perc_motion")
        private final int percMotion;

        @SerializedName("perc_notification")
        private final int percNotification;

        @SerializedName("perc_screen")
        private final int percScreen;

        @SerializedName("perc_sysapp")
        private final String percSysapp;

        @SerializedName("perc_voice")
        private final int percVoice;

        @SerializedName("perc_voice_end")
        private final String percVoiceEnd;

        @SerializedName("perc_voice_start")
        private final String percVoiceStart;

        @SerializedName("privacy_identity_verify")
        private final int privacyIdentityVerify;

        @SerializedName("privacy_ux_plan")
        private final int privacyUxPlan;

        @SerializedName("trigger_type")
        private final String triggerType;

        public MemorySettingsSnapshotParams(int r6, int r7, int r8, int r9, String r10, int r11, int r12, int r13, int r14, int r15, String r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, String r27, String r28, String r29) {
            Intrinsics.checkNotNullParameter(r10, "memAutoFav");
            Intrinsics.checkNotNullParameter(r16, "percSysapp");
            Intrinsics.checkNotNullParameter(r27, "triggerType");
            super(null);
            this.memManualHotkey = r6;
            this.memManualGesture = r7;
            this.memAuto = r8;
            this.memAutoOperate = r9;
            this.memAutoFav = r10;
            this.locAutoLearn = r11;
            this.locHomeSet = r12;
            this.locCompanySet = r13;
            this.percScreen = r14;
            this.percVoice = r15;
            this.percSysapp = r16;
            this.percNotification = r17;
            this.percDevice = r18;
            this.percLocationPoi = r19;
            this.percMotion = r20;
            this.glassesStatus = r21;
            this.blockRuleCount = r22;
            this.percCellularUpload = r23;
            this.privacyIdentityVerify = r24;
            this.privacyUxPlan = r25;
            this.addIconDesktop = r26;
            this.triggerType = r27;
            this.percVoiceStart = r28;
            this.percVoiceEnd = r29;
        }

        public /* synthetic */ MemorySettingsSnapshotParams(int r27, int r28, int r29, int r30, String r31, int r32, int r33, int r34, int r35, int r36, String r37, int r38, int r39, int r40, int r41, int r42, int r43, int r44, int r45, int r46, int r47, String r48, String r49, String r50, int r51, DefaultConstructorMarker r52) {
            if ((r51 & 2097152) == 0) goto L5;
            String r23 = "";
        L7:
            if ((r51 & 4194304) == 0) goto L9;
            String r24 = null;
        L11:
            if ((r51 & 8388608) == 0) goto L13;
            String r25 = null;
        L14:
            this(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r23, r24, r25);
            return;
        L13:
            r25 = r50;
            goto L14
        L9:
            r24 = r49;
            goto L11
        L5:
            r23 = r48;
            goto L7
        }

        public static /* synthetic */ MemorySettingsSnapshotParams copy$default(MemorySettingsSnapshotParams r17, int r18, int r19, int r20, int r21, String r22, int r23, int r24, int r25, int r26, int r27, String r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37, int r38, String r39, String r40, String r41, int r42, Object r43) {
            if ((r42 & 1) == 0) goto L5;
            int r2 = r17.memManualHotkey;
        L7:
            if ((r42 & 2) == 0) goto L9;
            int r3 = r17.memManualGesture;
        L11:
            if ((r42 & 4) == 0) goto L13;
            int r4 = r17.memAuto;
        L15:
            if ((r42 & 8) == 0) goto L17;
            int r5 = r17.memAutoOperate;
        L19:
            if ((r42 & 16) == 0) goto L21;
            String r6 = r17.memAutoFav;
        L23:
            if ((r42 & 32) == 0) goto L25;
            int r7 = r17.locAutoLearn;
        L27:
            if ((r42 & 64) == 0) goto L29;
            int r8 = r17.locHomeSet;
        L31:
            if ((r42 & 128) == 0) goto L33;
            int r9 = r17.locCompanySet;
        L35:
            if ((r42 & 256) == 0) goto L37;
            int r10 = r17.percScreen;
        L39:
            if ((r42 & 512) == 0) goto L41;
            int r11 = r17.percVoice;
        L43:
            if ((r42 & 1024) == 0) goto L45;
            String r12 = r17.percSysapp;
        L47:
            if ((r42 & 2048) == 0) goto L49;
            int r13 = r17.percNotification;
        L51:
            if ((r42 & 4096) == 0) goto L53;
            int r14 = r17.percDevice;
        L55:
            if ((r42 & 8192) == 0) goto L57;
            int r15 = r17.percLocationPoi;
        L58:
            int r310 = r15;
            if ((r42 & 16384) == 0) goto L61;
            int r16 = r17.percMotion;
        L62:
            int r311 = r16;
            if ((r42 & 32768) == 0) goto L65;
            int r110 = r17.glassesStatus;
        L66:
            int r312 = r110;
            if ((r42 & 65536) == 0) goto L69;
            int r111 = r17.blockRuleCount;
        L70:
            int r313 = r111;
            if ((r42 & 131072) == 0) goto L73;
            int r112 = r17.percCellularUpload;
        L74:
            int r314 = r112;
            if ((r42 & 262144) == 0) goto L77;
            int r113 = r17.privacyIdentityVerify;
        L78:
            int r315 = r113;
            if ((r42 & 524288) == 0) goto L81;
            int r114 = r17.privacyUxPlan;
        L82:
            int r316 = r114;
            if ((r42 & 1048576) == 0) goto L85;
            int r115 = r17.addIconDesktop;
        L86:
            int r317 = r115;
            if ((r42 & 2097152) == 0) goto L89;
            String r116 = r17.triggerType;
        L90:
            String r318 = r116;
            if ((r42 & 4194304) == 0) goto L93;
            String r117 = r17.percVoiceStart;
        L95:
            if ((r42 & 8388608) == 0) goto L97;
            String r1 = r17.percVoiceEnd;
        L99:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r117, r1);
        L97:
            r1 = r41;
            goto L99
        L93:
            r117 = r40;
            goto L95
        L89:
            r116 = r39;
            goto L90
        L85:
            r115 = r38;
            goto L86
        L81:
            r114 = r37;
            goto L82
        L77:
            r113 = r36;
            goto L78
        L73:
            r112 = r35;
            goto L74
        L69:
            r111 = r34;
            goto L70
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final int component1() {
            return this.memManualHotkey;
        }

        public final int component10() {
            return this.percVoice;
        }

        public final String component11() {
            return this.percSysapp;
        }

        public final int component12() {
            return this.percNotification;
        }

        public final int component13() {
            return this.percDevice;
        }

        public final int component14() {
            return this.percLocationPoi;
        }

        public final int component15() {
            return this.percMotion;
        }

        public final int component16() {
            return this.glassesStatus;
        }

        public final int component17() {
            return this.blockRuleCount;
        }

        public final int component18() {
            return this.percCellularUpload;
        }

        public final int component19() {
            return this.privacyIdentityVerify;
        }

        public final int component2() {
            return this.memManualGesture;
        }

        public final int component20() {
            return this.privacyUxPlan;
        }

        public final int component21() {
            return this.addIconDesktop;
        }

        public final String component22() {
            return this.triggerType;
        }

        public final String component23() {
            return this.percVoiceStart;
        }

        public final String component24() {
            return this.percVoiceEnd;
        }

        public final int component3() {
            return this.memAuto;
        }

        public final int component4() {
            return this.memAutoOperate;
        }

        public final String component5() {
            return this.memAutoFav;
        }

        public final int component6() {
            return this.locAutoLearn;
        }

        public final int component7() {
            return this.locHomeSet;
        }

        public final int component8() {
            return this.locCompanySet;
        }

        public final int component9() {
            return this.percScreen;
        }

        public final MemorySettingsSnapshotParams copy(int r27, int r28, int r29, int r30, String r31, int r32, int r33, int r34, int r35, int r36, String r37, int r38, int r39, int r40, int r41, int r42, int r43, int r44, int r45, int r46, int r47, String r48, String r49, String r50) {
            Intrinsics.checkNotNullParameter(r31, "memAutoFav");
            Intrinsics.checkNotNullParameter(r37, "percSysapp");
            Intrinsics.checkNotNullParameter(r48, "triggerType");
            return new MemorySettingsSnapshotParams(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MemorySettingsSnapshotParams.class) == true) goto L8;
            return false;
        L8:
            MemorySettingsSnapshotParams r6 = (MemorySettingsSnapshotParams) ZeusTransformUtils.preCheckCast(r5, MemorySettingsSnapshotParams.class, "com.obric.memorydata.plugin");
            if (this.memManualHotkey == r6.memManualHotkey) goto L12;
            return false;
        L12:
            if (this.memManualGesture == r6.memManualGesture) goto L15;
            return false;
        L15:
            if (this.memAuto == r6.memAuto) goto L18;
            return false;
        L18:
            if (this.memAutoOperate == r6.memAutoOperate) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.memAutoFav, r6.memAutoFav) == true) goto L24;
            return false;
        L24:
            if (this.locAutoLearn == r6.locAutoLearn) goto L27;
            return false;
        L27:
            if (this.locHomeSet == r6.locHomeSet) goto L30;
            return false;
        L30:
            if (this.locCompanySet == r6.locCompanySet) goto L33;
            return false;
        L33:
            if (this.percScreen == r6.percScreen) goto L36;
            return false;
        L36:
            if (this.percVoice == r6.percVoice) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.percSysapp, r6.percSysapp) == true) goto L42;
            return false;
        L42:
            if (this.percNotification == r6.percNotification) goto L45;
            return false;
        L45:
            if (this.percDevice == r6.percDevice) goto L48;
            return false;
        L48:
            if (this.percLocationPoi == r6.percLocationPoi) goto L51;
            return false;
        L51:
            if (this.percMotion == r6.percMotion) goto L54;
            return false;
        L54:
            if (this.glassesStatus == r6.glassesStatus) goto L57;
            return false;
        L57:
            if (this.blockRuleCount == r6.blockRuleCount) goto L60;
            return false;
        L60:
            if (this.percCellularUpload == r6.percCellularUpload) goto L63;
            return false;
        L63:
            if (this.privacyIdentityVerify == r6.privacyIdentityVerify) goto L66;
            return false;
        L66:
            if (this.privacyUxPlan == r6.privacyUxPlan) goto L69;
            return false;
        L69:
            if (this.addIconDesktop == r6.addIconDesktop) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.triggerType, r6.triggerType) == true) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.percVoiceStart, r6.percVoiceStart) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.percVoiceEnd, r6.percVoiceEnd) == true) goto L80;
            return false;
        L80:
            return true;
        }

        public final int getAddIconDesktop() {
            return this.addIconDesktop;
        }

        public final int getBlockRuleCount() {
            return this.blockRuleCount;
        }

        public final int getGlassesStatus() {
            return this.glassesStatus;
        }

        public final int getLocAutoLearn() {
            return this.locAutoLearn;
        }

        public final int getLocCompanySet() {
            return this.locCompanySet;
        }

        public final int getLocHomeSet() {
            return this.locHomeSet;
        }

        public final int getMemAuto() {
            return this.memAuto;
        }

        public final String getMemAutoFav() {
            return this.memAutoFav;
        }

        public final int getMemAutoOperate() {
            return this.memAutoOperate;
        }

        public final int getMemManualGesture() {
            return this.memManualGesture;
        }

        public final int getMemManualHotkey() {
            return this.memManualHotkey;
        }

        public final int getPercCellularUpload() {
            return this.percCellularUpload;
        }

        public final int getPercDevice() {
            return this.percDevice;
        }

        public final int getPercLocationPoi() {
            return this.percLocationPoi;
        }

        public final int getPercMotion() {
            return this.percMotion;
        }

        public final int getPercNotification() {
            return this.percNotification;
        }

        public final int getPercScreen() {
            return this.percScreen;
        }

        public final String getPercSysapp() {
            return this.percSysapp;
        }

        public final int getPercVoice() {
            return this.percVoice;
        }

        public final String getPercVoiceEnd() {
            return this.percVoiceEnd;
        }

        public final String getPercVoiceStart() {
            return this.percVoiceStart;
        }

        public final int getPrivacyIdentityVerify() {
            return this.privacyIdentityVerify;
        }

        public final int getPrivacyUxPlan() {
            return this.privacyUxPlan;
        }

        public final String getTriggerType() {
            return this.triggerType;
        }

        public int hashCode() {
            int r0 = ((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.memManualHotkey) * 31) + Integer.hashCode(this.memManualGesture)) * 31) + Integer.hashCode(this.memAuto)) * 31) + Integer.hashCode(this.memAutoOperate)) * 31) + this.memAutoFav.hashCode()) * 31) + Integer.hashCode(this.locAutoLearn)) * 31) + Integer.hashCode(this.locHomeSet)) * 31) + Integer.hashCode(this.locCompanySet)) * 31) + Integer.hashCode(this.percScreen)) * 31) + Integer.hashCode(this.percVoice)) * 31) + this.percSysapp.hashCode()) * 31) + Integer.hashCode(this.percNotification)) * 31) + Integer.hashCode(this.percDevice)) * 31) + Integer.hashCode(this.percLocationPoi)) * 31) + Integer.hashCode(this.percMotion)) * 31) + Integer.hashCode(this.glassesStatus)) * 31) + Integer.hashCode(this.blockRuleCount)) * 31) + Integer.hashCode(this.percCellularUpload)) * 31) + Integer.hashCode(this.privacyIdentityVerify)) * 31) + Integer.hashCode(this.privacyUxPlan)) * 31) + Integer.hashCode(this.addIconDesktop)) * 31) + this.triggerType.hashCode()) * 31;
            String r1 = this.percVoiceStart;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.percVoiceEnd;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("MemorySettingsSnapshotParams(memManualHotkey=").append(this.memManualHotkey).append(", memManualGesture=").append(this.memManualGesture).append(", memAuto=").append(this.memAuto).append(", memAutoOperate=").append(this.memAutoOperate).append(", memAutoFav=").append(this.memAutoFav).append(", locAutoLearn=").append(this.locAutoLearn).append(", locHomeSet=").append(this.locHomeSet).append(", locCompanySet=").append(this.locCompanySet).append(", percScreen=").append(this.percScreen).append(", percVoice=").append(this.percVoice).append(", percSysapp=").append(this.percSysapp).append(", percNotification=");
            r0.append(this.percNotification).append(", percDevice=").append(this.percDevice).append(", percLocationPoi=").append(this.percLocationPoi).append(", percMotion=").append(this.percMotion).append(", glassesStatus=").append(this.glassesStatus).append(", blockRuleCount=").append(this.blockRuleCount).append(", percCellularUpload=").append(this.percCellularUpload).append(", privacyIdentityVerify=").append(this.privacyIdentityVerify).append(", privacyUxPlan=").append(this.privacyUxPlan).append(", addIconDesktop=").append(this.addIconDesktop).append(", triggerType=").append(this.triggerType).append(", percVoiceStart=").append(this.percVoiceStart);
            r0.append(", percVoiceEnd=").append(this.percVoiceEnd).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0081\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySource;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TIMESLOP_SEMANTIC", "DAILY_SEMANTIC", "DIALOG_ACTIVE_MEMORY", "GLASSES_ACTIVE_MEMORY", "OMNI_ACTIVE_MEMORY", "DIALOG_AUTO_MEMORY", "THIRD_PARTY_AUTO_MEMORY", "FIRST_PARTY_AUTO_MEMORY", "TEXT_MENU_ACTIVE_MEMORY", "SCREENSHOT_ACTIVE_MEMORY", "THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY", "KEYBOARD_SHORTCUT_ACTIVE_MEMORY", "AI_ACTIVE_MEMORY", "AUDITORY_MEMORY", "AUDITORY_PERCEPTION", "OAUTO_MEMORY", "AUTO_MEMORY_PRO", "ENVIRONMENT_MEMORY", "SCREENSHOT_SCROLL_ACTIVE_MEMORY", "IMAGE_SHARE_ACTIVE_MEMORY", "GALLERY_SCREENSHOT_ACTIVE_MEMORY", "GALLERY_SINGLE_ACTIVE_MEMORY", "GALLERY_DOCUMENT_ACTIVE_MEMORY", "CAMERA_VIEWFINDER_ACTIVE_MEMORY", "CAMERA_POSTVIEW_ACTIVE_MEMORY", "UNKNOWN", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum MemorySource extends Enum<MemorySource> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MemorySource[] $VALUES = null;
        public static final MemorySource AI_ACTIVE_MEMORY = null;
        public static final MemorySource AUDITORY_MEMORY = null;
        public static final MemorySource AUDITORY_PERCEPTION = null;
        public static final MemorySource AUTO_MEMORY_PRO = null;
        public static final MemorySource CAMERA_POSTVIEW_ACTIVE_MEMORY = null;
        public static final MemorySource CAMERA_VIEWFINDER_ACTIVE_MEMORY = null;
        public static final a Companion = null;
        public static final MemorySource DAILY_SEMANTIC = null;
        public static final MemorySource DIALOG_ACTIVE_MEMORY = null;
        public static final MemorySource DIALOG_AUTO_MEMORY = null;
        public static final MemorySource ENVIRONMENT_MEMORY = null;
        public static final MemorySource FIRST_PARTY_AUTO_MEMORY = null;
        public static final MemorySource GALLERY_DOCUMENT_ACTIVE_MEMORY = null;
        public static final MemorySource GALLERY_SCREENSHOT_ACTIVE_MEMORY = null;
        public static final MemorySource GALLERY_SINGLE_ACTIVE_MEMORY = null;
        public static final MemorySource GLASSES_ACTIVE_MEMORY = null;
        public static final MemorySource IMAGE_SHARE_ACTIVE_MEMORY = null;
        public static final MemorySource KEYBOARD_SHORTCUT_ACTIVE_MEMORY = null;
        public static final MemorySource OAUTO_MEMORY = null;
        public static final MemorySource OMNI_ACTIVE_MEMORY = null;
        public static final MemorySource SCREENSHOT_ACTIVE_MEMORY = null;
        public static final MemorySource SCREENSHOT_SCROLL_ACTIVE_MEMORY = null;
        public static final MemorySource TEXT_MENU_ACTIVE_MEMORY = null;
        public static final MemorySource THIRD_PARTY_AUTO_MEMORY = null;
        public static final MemorySource THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY = null;
        public static final MemorySource TIMESLOP_SEMANTIC = null;
        public static final MemorySource UNKNOWN = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySource$Companion;", "", "<init>", "()V", "fromMemoryEntityProductType", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySource;", "productType", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final MemorySource a(int r1) {
                if (r1 == 1001) goto L47;
                if (r1 == 1002) goto L32;
                switch(r1) {
                    case 3: goto L55;
                    case 4: goto L54;
                    case 5: goto L53;
                    case 6: goto L52;
                    case 7: goto L51;
                    case 8: goto L50;
                    case 9: goto L49;
                    case 10: goto L48;
                    case 11: goto L47;
                    case 12: goto L46;
                    case 13: goto L45;
                    case 14: goto L44;
                    case 15: goto L43;
                    case 16: goto L42;
                    case 17: goto L41;
                    case 18: goto L40;
                    case 19: goto L39;
                    case 20: goto L38;
                    case 21: goto L37;
                    default: goto L7;
                };
            L7:
                switch(r1) {
                    case 1004: goto L36;
                    case 1005: goto L35;
                    case 1006: goto L34;
                    default: goto L33;
                };
            L33:
                return MemorySource.UNKNOWN;
            L34:
                return MemorySource.AUDITORY_PERCEPTION;
            L35:
                return MemorySource.ENVIRONMENT_MEMORY;
            L36:
                return MemorySource.AUTO_MEMORY_PRO;
            L37:
                return MemorySource.OMNI_ACTIVE_MEMORY;
            L38:
                return MemorySource.GLASSES_ACTIVE_MEMORY;
            L39:
                return MemorySource.GALLERY_SCREENSHOT_ACTIVE_MEMORY;
            L40:
                return MemorySource.CAMERA_POSTVIEW_ACTIVE_MEMORY;
            L41:
                return MemorySource.CAMERA_VIEWFINDER_ACTIVE_MEMORY;
            L42:
                return MemorySource.GALLERY_DOCUMENT_ACTIVE_MEMORY;
            L43:
                return MemorySource.GALLERY_SINGLE_ACTIVE_MEMORY;
            L44:
                return MemorySource.IMAGE_SHARE_ACTIVE_MEMORY;
            L45:
                return MemorySource.SCREENSHOT_SCROLL_ACTIVE_MEMORY;
            L46:
                return MemorySource.AUDITORY_MEMORY;
            L48:
                return MemorySource.KEYBOARD_SHORTCUT_ACTIVE_MEMORY;
            L49:
                return MemorySource.THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY;
            L50:
                return MemorySource.SCREENSHOT_ACTIVE_MEMORY;
            L51:
                return MemorySource.TEXT_MENU_ACTIVE_MEMORY;
            L52:
                return MemorySource.FIRST_PARTY_AUTO_MEMORY;
            L53:
                return MemorySource.THIRD_PARTY_AUTO_MEMORY;
            L54:
                return MemorySource.DIALOG_AUTO_MEMORY;
            L55:
                return MemorySource.DIALOG_ACTIVE_MEMORY;
            L32:
                return MemorySource.OAUTO_MEMORY;
            L47:
                return MemorySource.AI_ACTIVE_MEMORY;
            }
        }

        private static final /* synthetic */ MemorySource[] $values() {
            return new MemorySource[]{TIMESLOP_SEMANTIC, DAILY_SEMANTIC, DIALOG_ACTIVE_MEMORY, GLASSES_ACTIVE_MEMORY, OMNI_ACTIVE_MEMORY, DIALOG_AUTO_MEMORY, THIRD_PARTY_AUTO_MEMORY, FIRST_PARTY_AUTO_MEMORY, TEXT_MENU_ACTIVE_MEMORY, SCREENSHOT_ACTIVE_MEMORY, THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY, KEYBOARD_SHORTCUT_ACTIVE_MEMORY, AI_ACTIVE_MEMORY, AUDITORY_MEMORY, AUDITORY_PERCEPTION, OAUTO_MEMORY, AUTO_MEMORY_PRO, ENVIRONMENT_MEMORY, SCREENSHOT_SCROLL_ACTIVE_MEMORY, IMAGE_SHARE_ACTIVE_MEMORY, GALLERY_SCREENSHOT_ACTIVE_MEMORY, GALLERY_SINGLE_ACTIVE_MEMORY, GALLERY_DOCUMENT_ACTIVE_MEMORY, CAMERA_VIEWFINDER_ACTIVE_MEMORY, CAMERA_POSTVIEW_ACTIVE_MEMORY, UNKNOWN};
        }

        static {
            TIMESLOP_SEMANTIC = new MemorySource("TIMESLOP_SEMANTIC", 0, "timeslop_semantic");
            DAILY_SEMANTIC = new MemorySource("DAILY_SEMANTIC", 1, "daily_semantic");
            DIALOG_ACTIVE_MEMORY = new MemorySource("DIALOG_ACTIVE_MEMORY", 2, "dialog_active");
            GLASSES_ACTIVE_MEMORY = new MemorySource("GLASSES_ACTIVE_MEMORY", 3, "glasses_active");
            OMNI_ACTIVE_MEMORY = new MemorySource("OMNI_ACTIVE_MEMORY", 4, "omni_active");
            DIALOG_AUTO_MEMORY = new MemorySource("DIALOG_AUTO_MEMORY", 5, "dialog_auto");
            THIRD_PARTY_AUTO_MEMORY = new MemorySource("THIRD_PARTY_AUTO_MEMORY", 6, "third_party_auto");
            FIRST_PARTY_AUTO_MEMORY = new MemorySource("FIRST_PARTY_AUTO_MEMORY", 7, "first_party_auto");
            TEXT_MENU_ACTIVE_MEMORY = new MemorySource("TEXT_MENU_ACTIVE_MEMORY", 8, "text_menu_active");
            SCREENSHOT_ACTIVE_MEMORY = new MemorySource("SCREENSHOT_ACTIVE_MEMORY", 9, "screenshot_active");
            THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY = new MemorySource("THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY", 10, "gesture_active");
            KEYBOARD_SHORTCUT_ACTIVE_MEMORY = new MemorySource("KEYBOARD_SHORTCUT_ACTIVE_MEMORY", 11, "keyboard_active");
            AI_ACTIVE_MEMORY = new MemorySource("AI_ACTIVE_MEMORY", 12, "screen_obsv_perception");
            AUDITORY_MEMORY = new MemorySource("AUDITORY_MEMORY", 13, "auditory_perception");
            AUDITORY_PERCEPTION = new MemorySource("AUDITORY_PERCEPTION", 14, "auditory_perception");
            OAUTO_MEMORY = new MemorySource("OAUTO_MEMORY", 15, "oauto_memory");
            AUTO_MEMORY_PRO = new MemorySource("AUTO_MEMORY_PRO", 16, "auto_memory_pro");
            ENVIRONMENT_MEMORY = new MemorySource("ENVIRONMENT_MEMORY", 17, "environment_perception");
            SCREENSHOT_SCROLL_ACTIVE_MEMORY = new MemorySource("SCREENSHOT_SCROLL_ACTIVE_MEMORY", 18, "screenshot_scroll_active");
            IMAGE_SHARE_ACTIVE_MEMORY = new MemorySource("IMAGE_SHARE_ACTIVE_MEMORY", 19, "image_share_active");
            GALLERY_SCREENSHOT_ACTIVE_MEMORY = new MemorySource("GALLERY_SCREENSHOT_ACTIVE_MEMORY", 20, "gallery_screenshot_active");
            GALLERY_SINGLE_ACTIVE_MEMORY = new MemorySource("GALLERY_SINGLE_ACTIVE_MEMORY", 21, "gallery_single_active");
            GALLERY_DOCUMENT_ACTIVE_MEMORY = new MemorySource("GALLERY_DOCUMENT_ACTIVE_MEMORY", 22, "gallery_document_active");
            CAMERA_VIEWFINDER_ACTIVE_MEMORY = new MemorySource("CAMERA_VIEWFINDER_ACTIVE_MEMORY", 23, "camera_viewfinder_active");
            CAMERA_POSTVIEW_ACTIVE_MEMORY = new MemorySource("CAMERA_POSTVIEW_ACTIVE_MEMORY", 24, "camera_postview_active");
            UNKNOWN = new MemorySource("UNKNOWN", 25, "unknown");
            MemorySource[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private MemorySource(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<MemorySource> getEntries() {
            return $ENTRIES;
        }

        public static MemorySource valueOf(String r2) {
            return (MemorySource) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemorySource.class, r2), MemorySource.class, "com.obric.memorydata.plugin");
        }

        public static MemorySource[] values() {
            return (MemorySource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemorySource[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySwitchSnapshotParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "autoMemoryState", "", "screenObservationState", "auditoryMemoryState", "keyShortcutMemoryState", "gestureShortcutMemoryState", "<init>", "(IIIII)V", "getAutoMemoryState", "()I", "getScreenObservationState", "getAuditoryMemoryState", "getKeyShortcutMemoryState", "getGestureShortcutMemoryState", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MemorySwitchSnapshotParams extends Params {

        @SerializedName("auditory_memory_state")
        private final int auditoryMemoryState;

        @SerializedName("auto_memory_state")
        private final int autoMemoryState;

        @SerializedName("gesture_shortcut_memory_state")
        private final int gestureShortcutMemoryState;

        @SerializedName("key_shortcut_memory_state")
        private final int keyShortcutMemoryState;

        @SerializedName("screen_observation_state")
        private final int screenObservationState;

        public MemorySwitchSnapshotParams(int r2, int r3, int r4, int r5, int r6) {
            super(null);
            this.autoMemoryState = r2;
            this.screenObservationState = r3;
            this.auditoryMemoryState = r4;
            this.keyShortcutMemoryState = r5;
            this.gestureShortcutMemoryState = r6;
        }

        public static /* synthetic */ MemorySwitchSnapshotParams copy$default(MemorySwitchSnapshotParams r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.autoMemoryState;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.screenObservationState;
        L8:
            int r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.auditoryMemoryState;
        L11:
            int r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.keyShortcutMemoryState;
        L14:
            int r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.gestureShortcutMemoryState;
        L17:
            int r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final int component1() {
            return this.autoMemoryState;
        }

        public final int component2() {
            return this.screenObservationState;
        }

        public final int component3() {
            return this.auditoryMemoryState;
        }

        public final int component4() {
            return this.keyShortcutMemoryState;
        }

        public final int component5() {
            return this.gestureShortcutMemoryState;
        }

        public final MemorySwitchSnapshotParams copy(int r7, int r8, int r9, int r10, int r11) {
            return new MemorySwitchSnapshotParams(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MemorySwitchSnapshotParams.class) == true) goto L8;
            return false;
        L8:
            MemorySwitchSnapshotParams r6 = (MemorySwitchSnapshotParams) ZeusTransformUtils.preCheckCast(r5, MemorySwitchSnapshotParams.class, "com.obric.memorydata.plugin");
            if (this.autoMemoryState == r6.autoMemoryState) goto L12;
            return false;
        L12:
            if (this.screenObservationState == r6.screenObservationState) goto L15;
            return false;
        L15:
            if (this.auditoryMemoryState == r6.auditoryMemoryState) goto L18;
            return false;
        L18:
            if (this.keyShortcutMemoryState == r6.keyShortcutMemoryState) goto L21;
            return false;
        L21:
            if (this.gestureShortcutMemoryState == r6.gestureShortcutMemoryState) goto L23;
            return false;
        L23:
            return true;
        }

        public final int getAuditoryMemoryState() {
            return this.auditoryMemoryState;
        }

        public final int getAutoMemoryState() {
            return this.autoMemoryState;
        }

        public final int getGestureShortcutMemoryState() {
            return this.gestureShortcutMemoryState;
        }

        public final int getKeyShortcutMemoryState() {
            return this.keyShortcutMemoryState;
        }

        public final int getScreenObservationState() {
            return this.screenObservationState;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.autoMemoryState) * 31) + Integer.hashCode(this.screenObservationState)) * 31) + Integer.hashCode(this.auditoryMemoryState)) * 31) + Integer.hashCode(this.keyShortcutMemoryState)) * 31) + Integer.hashCode(this.gestureShortcutMemoryState);
        }

        public String toString() {
            return "MemorySwitchSnapshotParams(autoMemoryState=" + this.autoMemoryState + ", screenObservationState=" + this.screenObservationState + ", auditoryMemoryState=" + this.auditoryMemoryState + ", keyShortcutMemoryState=" + this.keyShortcutMemoryState + ", gestureShortcutMemoryState=" + this.gestureShortcutMemoryState + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$NewMemoryParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "base", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;", "confidenceScore", "", "previousConfidenceScore", "<init>", "(Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;Ljava/lang/Float;Ljava/lang/Float;)V", "getBase", "()Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;", "getConfidenceScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPreviousConfidenceScore", "component1", "component2", "component3", "copy", "(Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;Ljava/lang/Float;Ljava/lang/Float;)Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$NewMemoryParams;", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NewMemoryParams extends Params {
        private final BaseMemoryParams base;
        private final Float confidenceScore;
        private final Float previousConfidenceScore;

        public NewMemoryParams(BaseMemoryParams r2, Float r3, Float r4) {
            Intrinsics.checkNotNullParameter(r2, "base");
            super(null);
            this.base = r2;
            this.confidenceScore = r3;
            this.previousConfidenceScore = r4;
        }

        public /* synthetic */ NewMemoryParams(BaseMemoryParams r2, Float r3, Float r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r2, r3, r4);
        }

        public static /* synthetic */ NewMemoryParams copy$default(NewMemoryParams r0, BaseMemoryParams r1, Float r2, Float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.base;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.confidenceScore;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.previousConfidenceScore;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final BaseMemoryParams component1() {
            return this.base;
        }

        public final Float component2() {
            return this.confidenceScore;
        }

        public final Float component3() {
            return this.previousConfidenceScore;
        }

        public final NewMemoryParams copy(BaseMemoryParams r1, Float r2, Float r3) {
            Intrinsics.checkNotNullParameter(r1, "base");
            return new NewMemoryParams(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, NewMemoryParams.class) == true) goto L8;
            return false;
        L8:
            NewMemoryParams r6 = (NewMemoryParams) ZeusTransformUtils.preCheckCast(r5, NewMemoryParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.base, r6.base) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.confidenceScore, r6.confidenceScore) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.previousConfidenceScore, r6.previousConfidenceScore) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final BaseMemoryParams getBase() {
            return this.base;
        }

        public final Float getConfidenceScore() {
            return this.confidenceScore;
        }

        public final Float getPreviousConfidenceScore() {
            return this.previousConfidenceScore;
        }

        public int hashCode() {
            int r0 = this.base.hashCode() * 31;
            Float r1 = this.confidenceScore;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Float r5 = this.previousConfidenceScore;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "NewMemoryParams(base=" + this.base + ", confidenceScore=" + this.confidenceScore + ", previousConfidenceScore=" + this.previousConfidenceScore + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jj\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$PageShowParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "memoryId", "", "type", "", LocationMonitorConst.TAG, "tabName", "tagName", "currentPage", "previousPage", "enterFrom", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMemoryId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTag", "getTabName", "getTagName", "getCurrentPage", "getPreviousPage", "getEnterFrom", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$PageShowParams;", "equals", "", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PageShowParams extends Params {

        @SerializedName("current_page")
        private final String currentPage;

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("memory_id")
        private final String memoryId;

        @SerializedName("previous_page")
        private final String previousPage;

        @SerializedName("tab_name")
        private final String tabName;

        @SerializedName(LocationMonitorConst.TAG)
        private final String tag;

        @SerializedName("tag_name")
        private final String tagName;

        @SerializedName("type")
        private final Integer type;

        public PageShowParams(String r2, Integer r3, String r4, String r5, String r6, String r7, String r8, String r9) {
            Intrinsics.checkNotNullParameter(r7, "currentPage");
            Intrinsics.checkNotNullParameter(r9, "enterFrom");
            super(null);
            this.memoryId = r2;
            this.type = r3;
            this.tag = r4;
            this.tabName = r5;
            this.tagName = r6;
            this.currentPage = r7;
            this.previousPage = r8;
            this.enterFrom = r9;
        }

        public /* synthetic */ PageShowParams(String r12, Integer r13, String r14, String r15, String r16, String r17, String r18, String r19, int r20, DefaultConstructorMarker r21) {
            if ((r20 & 1) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r20 & 2) == 0) goto L9;
            Integer r4 = null;
        L11:
            if ((r20 & 4) == 0) goto L13;
            String r5 = null;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r6 = null;
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r7 = null;
        L23:
            if ((r20 & 64) == 0) goto L25;
            String r9 = null;
        L26:
            this(r3, r4, r5, r6, r7, r17, r9, r19);
            return;
        L25:
            r9 = r18;
            goto L26
        L21:
            r7 = r16;
            goto L23
        L17:
            r6 = r15;
            goto L19
        L13:
            r5 = r14;
            goto L15
        L9:
            r4 = r13;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }

        public static /* synthetic */ PageShowParams copy$default(PageShowParams r9, String r10, Integer r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            String r2 = r9.memoryId;
        L7:
            if ((r18 & 2) == 0) goto L9;
            Integer r3 = r9.type;
        L11:
            if ((r18 & 4) == 0) goto L13;
            String r4 = r9.tag;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r5 = r9.tabName;
        L19:
            if ((r18 & 16) == 0) goto L21;
            String r6 = r9.tagName;
        L23:
            if ((r18 & 32) == 0) goto L25;
            String r7 = r9.currentPage;
        L27:
            if ((r18 & 64) == 0) goto L29;
            String r8 = r9.previousPage;
        L31:
            if ((r18 & 128) == 0) goto L33;
            String r1 = r9.enterFrom;
        L35:
            return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
        L33:
            r1 = r17;
            goto L35
        L29:
            r8 = r16;
            goto L31
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final String component1() {
            return this.memoryId;
        }

        public final Integer component2() {
            return this.type;
        }

        public final String component3() {
            return this.tag;
        }

        public final String component4() {
            return this.tabName;
        }

        public final String component5() {
            return this.tagName;
        }

        public final String component6() {
            return this.currentPage;
        }

        public final String component7() {
            return this.previousPage;
        }

        public final String component8() {
            return this.enterFrom;
        }

        public final PageShowParams copy(String r11, Integer r12, String r13, String r14, String r15, String r16, String r17, String r18) {
            Intrinsics.checkNotNullParameter(r16, "currentPage");
            Intrinsics.checkNotNullParameter(r18, "enterFrom");
            return new PageShowParams(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, PageShowParams.class) == true) goto L8;
            return false;
        L8:
            PageShowParams r6 = (PageShowParams) ZeusTransformUtils.preCheckCast(r5, PageShowParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.memoryId, r6.memoryId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.tabName, r6.tabName) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.tagName, r6.tagName) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.currentPage, r6.currentPage) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.enterFrom, r6.enterFrom) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final String getCurrentPage() {
            return this.currentPage;
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final String getMemoryId() {
            return this.memoryId;
        }

        public final String getPreviousPage() {
            return this.previousPage;
        }

        public final String getTabName() {
            return this.tabName;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getTagName() {
            return this.tagName;
        }

        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            String r0 = this.memoryId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.type;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.tag;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.tabName;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.tagName;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (((r12 + r14) * 31) + this.currentPage.hashCode()) * 31;
            String r16 = this.previousPage;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return ((r15 + r1) * 31) + this.enterFrom.hashCode();
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
            return "PageShowParams(memoryId=" + this.memoryId + ", type=" + this.type + ", tag=" + this.tag + ", tabName=" + this.tabName + ", tagName=" + this.tagName + ", currentPage=" + this.currentPage + ", previousPage=" + this.previousPage + ", enterFrom=" + this.enterFrom + ')';
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "", "<init>", "()V", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$AutoMemoryRuleHitParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$ClickCardItemParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$DeleteCardItemParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$EditCardItemParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemoryDataUploadOnceParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySettingsSnapshotParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySwitchSnapshotParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$NewMemoryParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$PageShowParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$RuleDailyReportParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$RuleEditParams;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Params {
        private Params() {
        }

        public /* synthetic */ Params(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$ReactionType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DETAIL", "IMAGE", "ORIGIN_APP", "ORIGIN_PAGE", "MARKET", "NOTHING", "QUICK_ACTION", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ReactionType extends Enum<ReactionType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ReactionType[] $VALUES = null;
        public static final ReactionType DETAIL = null;
        public static final ReactionType IMAGE = null;
        public static final ReactionType MARKET = null;
        public static final ReactionType NOTHING = null;
        public static final ReactionType ORIGIN_APP = null;
        public static final ReactionType ORIGIN_PAGE = null;
        public static final ReactionType QUICK_ACTION = null;
        private final int value;

        private static final /* synthetic */ ReactionType[] $values() {
            return new ReactionType[]{DETAIL, IMAGE, ORIGIN_APP, ORIGIN_PAGE, MARKET, NOTHING, QUICK_ACTION};
        }

        static {
            DETAIL = new ReactionType("DETAIL", 0, 0);
            IMAGE = new ReactionType("IMAGE", 1, 1);
            ORIGIN_APP = new ReactionType("ORIGIN_APP", 2, 2);
            ORIGIN_PAGE = new ReactionType("ORIGIN_PAGE", 3, 3);
            MARKET = new ReactionType("MARKET", 4, 4);
            NOTHING = new ReactionType("NOTHING", 5, 5);
            QUICK_ACTION = new ReactionType("QUICK_ACTION", 6, 6);
            ReactionType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private ReactionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<ReactionType> getEntries() {
            return $ENTRIES;
        }

        public static ReactionType valueOf(String r2) {
            return (ReactionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReactionType.class, r2), ReactionType.class, "com.obric.memorydata.plugin");
        }

        public static ReactionType[] values() {
            return (ReactionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReactionType[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$ResultType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAILURE", "SUCCESS", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ResultType extends Enum<ResultType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ResultType[] $VALUES = null;
        public static final ResultType FAILURE = null;
        public static final ResultType SUCCESS = null;
        private final int value;

        private static final /* synthetic */ ResultType[] $values() {
            return new ResultType[]{FAILURE, SUCCESS};
        }

        static {
            FAILURE = new ResultType("FAILURE", 0, 0);
            SUCCESS = new ResultType("SUCCESS", 1, 1);
            ResultType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private ResultType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<ResultType> getEntries() {
            return $ENTRIES;
        }

        public static ResultType valueOf(String r2) {
            return (ResultType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResultType.class, r2), ResultType.class, "com.obric.memorydata.plugin");
        }

        public static ResultType[] values() {
            return (ResultType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResultType[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$RuleDailyReportParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "isFromPreset", "", "ruleTitle", "", "ruleConfig", "memoryFrequency", "autoCaptureEnabled", "isPaused", "appPackages", AILabCheckPermissionTask.KEY_SOURCE, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getRuleTitle", "()Ljava/lang/String;", "getRuleConfig", "getMemoryFrequency", "getAutoCaptureEnabled", "getAppPackages", "getSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RuleDailyReportParams extends Params {

        @SerializedName("app_packages")
        private final String appPackages;

        @SerializedName("auto_capture_enabled")
        private final boolean autoCaptureEnabled;

        @SerializedName("is_from_preset")
        private final boolean isFromPreset;

        @SerializedName("is_paused")
        private final boolean isPaused;

        @SerializedName("memory_frequency")
        private final String memoryFrequency;

        @SerializedName("rule_config")
        private final String ruleConfig;

        @SerializedName("rule_title")
        private final String ruleTitle;

        @SerializedName(AILabCheckPermissionTask.KEY_SOURCE)
        private final String source;

        public RuleDailyReportParams(boolean r2, String r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9) {
            Intrinsics.checkNotNullParameter(r3, "ruleTitle");
            Intrinsics.checkNotNullParameter(r4, "ruleConfig");
            Intrinsics.checkNotNullParameter(r5, "memoryFrequency");
            Intrinsics.checkNotNullParameter(r8, "appPackages");
            Intrinsics.checkNotNullParameter(r9, AILabCheckPermissionTask.KEY_SOURCE);
            super(null);
            this.isFromPreset = r2;
            this.ruleTitle = r3;
            this.ruleConfig = r4;
            this.memoryFrequency = r5;
            this.autoCaptureEnabled = r6;
            this.isPaused = r7;
            this.appPackages = r8;
            this.source = r9;
        }

        public static /* synthetic */ RuleDailyReportParams copy$default(RuleDailyReportParams r9, boolean r10, String r11, String r12, String r13, boolean r14, boolean r15, String r16, String r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            boolean r2 = r9.isFromPreset;
        L7:
            if ((r18 & 2) == 0) goto L9;
            String r3 = r9.ruleTitle;
        L11:
            if ((r18 & 4) == 0) goto L13;
            String r4 = r9.ruleConfig;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r5 = r9.memoryFrequency;
        L19:
            if ((r18 & 16) == 0) goto L21;
            boolean r6 = r9.autoCaptureEnabled;
        L23:
            if ((r18 & 32) == 0) goto L25;
            boolean r7 = r9.isPaused;
        L27:
            if ((r18 & 64) == 0) goto L29;
            String r8 = r9.appPackages;
        L31:
            if ((r18 & 128) == 0) goto L33;
            String r1 = r9.source;
        L35:
            return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
        L33:
            r1 = r17;
            goto L35
        L29:
            r8 = r16;
            goto L31
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final boolean component1() {
            return this.isFromPreset;
        }

        public final String component2() {
            return this.ruleTitle;
        }

        public final String component3() {
            return this.ruleConfig;
        }

        public final String component4() {
            return this.memoryFrequency;
        }

        public final boolean component5() {
            return this.autoCaptureEnabled;
        }

        public final boolean component6() {
            return this.isPaused;
        }

        public final String component7() {
            return this.appPackages;
        }

        public final String component8() {
            return this.source;
        }

        public final RuleDailyReportParams copy(boolean r11, String r12, String r13, String r14, boolean r15, boolean r16, String r17, String r18) {
            Intrinsics.checkNotNullParameter(r12, "ruleTitle");
            Intrinsics.checkNotNullParameter(r13, "ruleConfig");
            Intrinsics.checkNotNullParameter(r14, "memoryFrequency");
            Intrinsics.checkNotNullParameter(r17, "appPackages");
            Intrinsics.checkNotNullParameter(r18, AILabCheckPermissionTask.KEY_SOURCE);
            return new RuleDailyReportParams(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, RuleDailyReportParams.class) == true) goto L8;
            return false;
        L8:
            RuleDailyReportParams r6 = (RuleDailyReportParams) ZeusTransformUtils.preCheckCast(r5, RuleDailyReportParams.class, "com.obric.memorydata.plugin");
            if (this.isFromPreset == r6.isFromPreset) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ruleTitle, r6.ruleTitle) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.ruleConfig, r6.ruleConfig) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.memoryFrequency, r6.memoryFrequency) == true) goto L21;
            return false;
        L21:
            if (this.autoCaptureEnabled == r6.autoCaptureEnabled) goto L24;
            return false;
        L24:
            if (this.isPaused == r6.isPaused) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.appPackages, r6.appPackages) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.source, r6.source) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final String getAppPackages() {
            return this.appPackages;
        }

        public final boolean getAutoCaptureEnabled() {
            return this.autoCaptureEnabled;
        }

        public final String getMemoryFrequency() {
            return this.memoryFrequency;
        }

        public final String getRuleConfig() {
            return this.ruleConfig;
        }

        public final String getRuleTitle() {
            return this.ruleTitle;
        }

        public final String getSource() {
            return this.source;
        }

        public int hashCode() {
            return (((((((((((((Boolean.hashCode(this.isFromPreset) * 31) + this.ruleTitle.hashCode()) * 31) + this.ruleConfig.hashCode()) * 31) + this.memoryFrequency.hashCode()) * 31) + Boolean.hashCode(this.autoCaptureEnabled)) * 31) + Boolean.hashCode(this.isPaused)) * 31) + this.appPackages.hashCode()) * 31) + this.source.hashCode();
        }

        public final boolean isFromPreset() {
            return this.isFromPreset;
        }

        public final boolean isPaused() {
            return this.isPaused;
        }

        public String toString() {
            return "RuleDailyReportParams(isFromPreset=" + this.isFromPreset + ", ruleTitle=" + this.ruleTitle + ", ruleConfig=" + this.ruleConfig + ", memoryFrequency=" + this.memoryFrequency + ", autoCaptureEnabled=" + this.autoCaptureEnabled + ", isPaused=" + this.isPaused + ", appPackages=" + this.appPackages + ", source=" + this.source + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$RuleEditOperation;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ADD_NEW", "EDIT", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum RuleEditOperation extends Enum<RuleEditOperation> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ RuleEditOperation[] $VALUES = null;
        public static final RuleEditOperation ADD_NEW = null;
        public static final RuleEditOperation EDIT = null;
        private final String value;

        private static final /* synthetic */ RuleEditOperation[] $values() {
            return new RuleEditOperation[]{ADD_NEW, EDIT};
        }

        static {
            ADD_NEW = new RuleEditOperation("ADD_NEW", 0, "add_new");
            EDIT = new RuleEditOperation("EDIT", 1, "edit");
            RuleEditOperation[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private RuleEditOperation(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<RuleEditOperation> getEntries() {
            return $ENTRIES;
        }

        public static RuleEditOperation valueOf(String r2) {
            return (RuleEditOperation) ZeusTransformUtils.preCheckCast(Enum.valueOf(RuleEditOperation.class, r2), RuleEditOperation.class, "com.obric.memorydata.plugin");
        }

        public static RuleEditOperation[] values() {
            return (RuleEditOperation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RuleEditOperation[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J]\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$RuleEditParams;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$Params;", "operation", "", "rawInput", "rewriteResult", "userEditResult", "memoryFrequency", "autoCaptureEnabled", "", "isFromPreset", "appPackages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getOperation", "()Ljava/lang/String;", "getRawInput", "getRewriteResult", "getUserEditResult", "getMemoryFrequency", "getAutoCaptureEnabled", "()Z", "getAppPackages", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RuleEditParams extends Params {

        @SerializedName("app_packages")
        private final String appPackages;

        @SerializedName("auto_capture_enabled")
        private final boolean autoCaptureEnabled;

        @SerializedName("is_from_preset")
        private final boolean isFromPreset;

        @SerializedName("memory_frequency")
        private final String memoryFrequency;

        @SerializedName("operation")
        private final String operation;

        @SerializedName("raw_input")
        private final String rawInput;

        @SerializedName("rewrite_result")
        private final String rewriteResult;

        @SerializedName("user_edit_result")
        private final String userEditResult;

        public RuleEditParams(String r2, String r3, String r4, String r5, String r6, boolean r7, boolean r8, String r9) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            Intrinsics.checkNotNullParameter(r5, "userEditResult");
            Intrinsics.checkNotNullParameter(r6, "memoryFrequency");
            Intrinsics.checkNotNullParameter(r9, "appPackages");
            super(null);
            this.operation = r2;
            this.rawInput = r3;
            this.rewriteResult = r4;
            this.userEditResult = r5;
            this.memoryFrequency = r6;
            this.autoCaptureEnabled = r7;
            this.isFromPreset = r8;
            this.appPackages = r9;
        }

        public /* synthetic */ RuleEditParams(String r12, String r13, String r14, String r15, String r16, boolean r17, boolean r18, String r19, int r20, DefaultConstructorMarker r21) {
            if ((r20 & 2) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r20 & 4) == 0) goto L9;
            String r5 = null;
        L10:
            this(r12, r4, r5, r15, r16, r17, r18, r19);
            return;
        L9:
            r5 = r14;
            goto L10
        L5:
            r4 = r13;
            goto L7
        }

        public static /* synthetic */ RuleEditParams copy$default(RuleEditParams r9, String r10, String r11, String r12, String r13, String r14, boolean r15, boolean r16, String r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            String r2 = r9.operation;
        L7:
            if ((r18 & 2) == 0) goto L9;
            String r3 = r9.rawInput;
        L11:
            if ((r18 & 4) == 0) goto L13;
            String r4 = r9.rewriteResult;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r5 = r9.userEditResult;
        L19:
            if ((r18 & 16) == 0) goto L21;
            String r6 = r9.memoryFrequency;
        L23:
            if ((r18 & 32) == 0) goto L25;
            boolean r7 = r9.autoCaptureEnabled;
        L27:
            if ((r18 & 64) == 0) goto L29;
            boolean r8 = r9.isFromPreset;
        L31:
            if ((r18 & 128) == 0) goto L33;
            String r1 = r9.appPackages;
        L35:
            return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
        L33:
            r1 = r17;
            goto L35
        L29:
            r8 = r16;
            goto L31
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final String component1() {
            return this.operation;
        }

        public final String component2() {
            return this.rawInput;
        }

        public final String component3() {
            return this.rewriteResult;
        }

        public final String component4() {
            return this.userEditResult;
        }

        public final String component5() {
            return this.memoryFrequency;
        }

        public final boolean component6() {
            return this.autoCaptureEnabled;
        }

        public final boolean component7() {
            return this.isFromPreset;
        }

        public final String component8() {
            return this.appPackages;
        }

        public final RuleEditParams copy(String r11, String r12, String r13, String r14, String r15, boolean r16, boolean r17, String r18) {
            Intrinsics.checkNotNullParameter(r11, "operation");
            Intrinsics.checkNotNullParameter(r14, "userEditResult");
            Intrinsics.checkNotNullParameter(r15, "memoryFrequency");
            Intrinsics.checkNotNullParameter(r18, "appPackages");
            return new RuleEditParams(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, RuleEditParams.class) == true) goto L8;
            return false;
        L8:
            RuleEditParams r6 = (RuleEditParams) ZeusTransformUtils.preCheckCast(r5, RuleEditParams.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.operation, r6.operation) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.rawInput, r6.rawInput) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.rewriteResult, r6.rewriteResult) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.userEditResult, r6.userEditResult) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.memoryFrequency, r6.memoryFrequency) == true) goto L24;
            return false;
        L24:
            if (this.autoCaptureEnabled == r6.autoCaptureEnabled) goto L27;
            return false;
        L27:
            if (this.isFromPreset == r6.isFromPreset) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.appPackages, r6.appPackages) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final String getAppPackages() {
            return this.appPackages;
        }

        public final boolean getAutoCaptureEnabled() {
            return this.autoCaptureEnabled;
        }

        public final String getMemoryFrequency() {
            return this.memoryFrequency;
        }

        public final String getOperation() {
            return this.operation;
        }

        public final String getRawInput() {
            return this.rawInput;
        }

        public final String getRewriteResult() {
            return this.rewriteResult;
        }

        public final String getUserEditResult() {
            return this.userEditResult;
        }

        public int hashCode() {
            int r0 = this.operation.hashCode() * 31;
            String r1 = this.rawInput;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.rewriteResult;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((((((((r4 + r2) * 31) + this.userEditResult.hashCode()) * 31) + this.memoryFrequency.hashCode()) * 31) + Boolean.hashCode(this.autoCaptureEnabled)) * 31) + Boolean.hashCode(this.isFromPreset)) * 31) + this.appPackages.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final boolean isFromPreset() {
            return this.isFromPreset;
        }

        public String toString() {
            return "RuleEditParams(operation=" + this.operation + ", rawInput=" + this.rawInput + ", rewriteResult=" + this.rewriteResult + ", userEditResult=" + this.userEditResult + ", memoryFrequency=" + this.memoryFrequency + ", autoCaptureEnabled=" + this.autoCaptureEnabled + ", isFromPreset=" + this.isFromPreset + ", appPackages=" + this.appPackages + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$SourceType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DESKTOP_WIDGET", "WEARABLE_DEVICE", "SYSTEM_SETTINGS", "NOTIFICATION_CARD", "DYNAMIC_ISLAND", "ASSISTANT_AGENT", "DESKTOP_ICON", "MEMORY_LIST", "MEMORY_SEARCH", "MEMORY_RELATION", "CALENDAR_DETAIL", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum SourceType extends Enum<SourceType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final SourceType ASSISTANT_AGENT = null;
        public static final SourceType CALENDAR_DETAIL = null;
        public static final SourceType DESKTOP_ICON = null;
        public static final SourceType DESKTOP_WIDGET = null;
        public static final SourceType DYNAMIC_ISLAND = null;
        public static final SourceType MEMORY_LIST = null;
        public static final SourceType MEMORY_RELATION = null;
        public static final SourceType MEMORY_SEARCH = null;
        public static final SourceType NOTIFICATION_CARD = null;
        public static final SourceType SYSTEM_SETTINGS = null;
        public static final SourceType WEARABLE_DEVICE = null;
        private final String value;

        private static final /* synthetic */ SourceType[] $values() {
            return new SourceType[]{DESKTOP_WIDGET, WEARABLE_DEVICE, SYSTEM_SETTINGS, NOTIFICATION_CARD, DYNAMIC_ISLAND, ASSISTANT_AGENT, DESKTOP_ICON, MEMORY_LIST, MEMORY_SEARCH, MEMORY_RELATION, CALENDAR_DETAIL};
        }

        static {
            DESKTOP_WIDGET = new SourceType("DESKTOP_WIDGET", 0, "desktop_widget");
            WEARABLE_DEVICE = new SourceType("WEARABLE_DEVICE", 1, "wearable_device");
            SYSTEM_SETTINGS = new SourceType("SYSTEM_SETTINGS", 2, "system_settings");
            NOTIFICATION_CARD = new SourceType("NOTIFICATION_CARD", 3, "notification_card");
            DYNAMIC_ISLAND = new SourceType("DYNAMIC_ISLAND", 4, "dynamic_island");
            ASSISTANT_AGENT = new SourceType("ASSISTANT_AGENT", 5, "assistant_agent");
            DESKTOP_ICON = new SourceType("DESKTOP_ICON", 6, "desktop_icon");
            MEMORY_LIST = new SourceType("MEMORY_LIST", 7, "memory_list");
            MEMORY_SEARCH = new SourceType("MEMORY_SEARCH", 8, "memory_search");
            MEMORY_RELATION = new SourceType("MEMORY_RELATION", 9, "memory_relation");
            CALENDAR_DETAIL = new SourceType("CALENDAR_DETAIL", 10, "calendar_detail");
            SourceType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private SourceType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<SourceType> getEntries() {
            return $ENTRIES;
        }

        public static SourceType valueOf(String r2) {
            return (SourceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SourceType.class, r2), SourceType.class, "com.obric.memorydata.plugin");
        }

        public static SourceType[] values() {
            return (SourceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SourceType[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$TypeLevel1;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", PendingMemoryCalendar.TYPE_EVENT, "FAVORITES", "PERSONAL_INFORMATION", "SCREEN_OBSERVATION", "AUDITORY_MEMORY", "UNKNOWN", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum TypeLevel1 extends Enum<TypeLevel1> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TypeLevel1[] $VALUES = null;
        public static final TypeLevel1 AUDITORY_MEMORY = null;
        public static final a Companion = null;
        public static final TypeLevel1 EVENT = null;
        public static final TypeLevel1 FAVORITES = null;
        public static final TypeLevel1 PERSONAL_INFORMATION = null;
        public static final TypeLevel1 SCREEN_OBSERVATION = null;
        public static final TypeLevel1 UNKNOWN = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$TypeLevel1$Companion;", "", "<init>", "()V", "fromMemoryEntity", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$TypeLevel1;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }
        }

        private static final /* synthetic */ TypeLevel1[] $values() {
            return new TypeLevel1[]{EVENT, FAVORITES, PERSONAL_INFORMATION, SCREEN_OBSERVATION, AUDITORY_MEMORY, UNKNOWN};
        }

        static {
            EVENT = new TypeLevel1(PendingMemoryCalendar.TYPE_EVENT, 0, "event");
            FAVORITES = new TypeLevel1("FAVORITES", 1, "favorites");
            PERSONAL_INFORMATION = new TypeLevel1("PERSONAL_INFORMATION", 2, "personal_information");
            SCREEN_OBSERVATION = new TypeLevel1("SCREEN_OBSERVATION", 3, "screen_observation");
            AUDITORY_MEMORY = new TypeLevel1("AUDITORY_MEMORY", 4, "auditory_memory");
            UNKNOWN = new TypeLevel1("UNKNOWN", 5, "unknown");
            TypeLevel1[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private TypeLevel1(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<TypeLevel1> getEntries() {
            return $ENTRIES;
        }

        public static TypeLevel1 valueOf(String r2) {
            return (TypeLevel1) ZeusTransformUtils.preCheckCast(Enum.valueOf(TypeLevel1.class, r2), TypeLevel1.class, "com.obric.memorydata.plugin");
        }

        public static TypeLevel1[] values() {
            return (TypeLevel1[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TypeLevel1[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0081\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$TypeLevel2;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FLIGHT", "TRAIN", "MOVIE", "HOTEL", "TICKETING", "SCHEDULE", "TO_DO", "ARTICLE", "STORE", "GENERAL_FAVORITES", "ORDER", "IDENTIFICATION", "ADDRESS", "ANNIVERSARY", "RELATIONSHIP", "PERSONAL_INFO", "HABITS", "SELECTION_PREFERENCES", "HOBBIES_INTERESTS", "FAMILY_RELATIONSHIPS", "SOCIAL_RELATIONSHIPS", "MID_LONG_TERM_GOALS", "PAINS_BARRIERS", "OTHER", "UNKNOWN", "SCREEN_OBSERVATION", "AUDITORY_MEMORY", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum TypeLevel2 extends Enum<TypeLevel2> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TypeLevel2[] $VALUES = null;
        public static final TypeLevel2 ADDRESS = null;
        public static final TypeLevel2 ANNIVERSARY = null;
        public static final TypeLevel2 ARTICLE = null;
        public static final TypeLevel2 AUDITORY_MEMORY = null;
        public static final a Companion = null;
        public static final TypeLevel2 FAMILY_RELATIONSHIPS = null;
        public static final TypeLevel2 FLIGHT = null;
        public static final TypeLevel2 GENERAL_FAVORITES = null;
        public static final TypeLevel2 HABITS = null;
        public static final TypeLevel2 HOBBIES_INTERESTS = null;
        public static final TypeLevel2 HOTEL = null;
        public static final TypeLevel2 IDENTIFICATION = null;
        public static final TypeLevel2 MID_LONG_TERM_GOALS = null;
        public static final TypeLevel2 MOVIE = null;
        public static final TypeLevel2 ORDER = null;
        public static final TypeLevel2 OTHER = null;
        public static final TypeLevel2 PAINS_BARRIERS = null;
        public static final TypeLevel2 PERSONAL_INFO = null;
        public static final TypeLevel2 RELATIONSHIP = null;
        public static final TypeLevel2 SCHEDULE = null;
        public static final TypeLevel2 SCREEN_OBSERVATION = null;
        public static final TypeLevel2 SELECTION_PREFERENCES = null;
        public static final TypeLevel2 SOCIAL_RELATIONSHIPS = null;
        public static final TypeLevel2 STORE = null;
        public static final TypeLevel2 TICKETING = null;
        public static final TypeLevel2 TO_DO = null;
        public static final TypeLevel2 TRAIN = null;
        public static final TypeLevel2 UNKNOWN = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$TypeLevel2$Companion;", "", "<init>", "()V", "fromMemoryEntity", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$TypeLevel2;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }
        }

        private static final /* synthetic */ TypeLevel2[] $values() {
            return new TypeLevel2[]{FLIGHT, TRAIN, MOVIE, HOTEL, TICKETING, SCHEDULE, TO_DO, ARTICLE, STORE, GENERAL_FAVORITES, ORDER, IDENTIFICATION, ADDRESS, ANNIVERSARY, RELATIONSHIP, PERSONAL_INFO, HABITS, SELECTION_PREFERENCES, HOBBIES_INTERESTS, FAMILY_RELATIONSHIPS, SOCIAL_RELATIONSHIPS, MID_LONG_TERM_GOALS, PAINS_BARRIERS, OTHER, UNKNOWN, SCREEN_OBSERVATION, AUDITORY_MEMORY};
        }

        static {
            FLIGHT = new TypeLevel2("FLIGHT", 0, "flight");
            TRAIN = new TypeLevel2("TRAIN", 1, "train");
            MOVIE = new TypeLevel2("MOVIE", 2, "movie");
            HOTEL = new TypeLevel2("HOTEL", 3, "hotel");
            TICKETING = new TypeLevel2("TICKETING", 4, "ticketing");
            SCHEDULE = new TypeLevel2("SCHEDULE", 5, "schedule");
            TO_DO = new TypeLevel2("TO_DO", 6, "to_do");
            ARTICLE = new TypeLevel2("ARTICLE", 7, "article");
            STORE = new TypeLevel2("STORE", 8, "store");
            GENERAL_FAVORITES = new TypeLevel2("GENERAL_FAVORITES", 9, "general_favorites");
            ORDER = new TypeLevel2("ORDER", 10, "order");
            IDENTIFICATION = new TypeLevel2("IDENTIFICATION", 11, "identification");
            ADDRESS = new TypeLevel2("ADDRESS", 12, MemoryKeyInfoEntity.KEY_ADDRESS);
            ANNIVERSARY = new TypeLevel2("ANNIVERSARY", 13, "anniversary");
            RELATIONSHIP = new TypeLevel2("RELATIONSHIP", 14, "relationship");
            PERSONAL_INFO = new TypeLevel2("PERSONAL_INFO", 15, "personal_info");
            HABITS = new TypeLevel2("HABITS", 16, "habits");
            SELECTION_PREFERENCES = new TypeLevel2("SELECTION_PREFERENCES", 17, "selection_preferences");
            HOBBIES_INTERESTS = new TypeLevel2("HOBBIES_INTERESTS", 18, "hobbies_interests");
            FAMILY_RELATIONSHIPS = new TypeLevel2("FAMILY_RELATIONSHIPS", 19, "family_relationships");
            SOCIAL_RELATIONSHIPS = new TypeLevel2("SOCIAL_RELATIONSHIPS", 20, "social_relationships");
            MID_LONG_TERM_GOALS = new TypeLevel2("MID_LONG_TERM_GOALS", 21, "mid_long_term_goals");
            PAINS_BARRIERS = new TypeLevel2("PAINS_BARRIERS", 22, "pains_barriers");
            OTHER = new TypeLevel2("OTHER", 23, "other");
            UNKNOWN = new TypeLevel2("UNKNOWN", 24, "unknown");
            SCREEN_OBSERVATION = new TypeLevel2("SCREEN_OBSERVATION", 25, "screen_observation");
            AUDITORY_MEMORY = new TypeLevel2("AUDITORY_MEMORY", 26, "auditory_memory");
            TypeLevel2[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private TypeLevel2(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<TypeLevel2> getEntries() {
            return $ENTRIES;
        }

        public static TypeLevel2 valueOf(String r2) {
            return (TypeLevel2) ZeusTransformUtils.preCheckCast(Enum.valueOf(TypeLevel2.class, r2), TypeLevel2.class, "com.obric.memorydata.plugin");
        }

        public static TypeLevel2[] values() {
            return (TypeLevel2[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TypeLevel2[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    static {
        f10515a = new MemoryEventTracker();
        f10516b = SetsKt.setOf(new String[]{SourceType.ASSISTANT_AGENT.getValue(), SourceType.DYNAMIC_ISLAND.getValue(), SourceType.CALENDAR_DETAIL.getValue()});
    }

    private MemoryEventTracker() {
    }

    private final int a(boolean r1) {
        return r1 ? 1 : 0;
    }

    private final Integer a(Float r6) {
        if (r6 == null) goto L24;
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).floatValue();
        boolean r3 = true;
        if (1.0f <= r0) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L12;
    L17:
        r3 = false;
    L18:
        if (r3 == true) goto L21;
        r6 = null;
    L21:
        if (r6 != null) goto L23;
        return null;
    L23:
        return Integer.valueOf((int) r6.floatValue());
    L12:
        if ((r0 % 1.0f) != 0.0f) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
    L14:
        r1 = false;
        goto L15
    L7:
        if (r0 > 4.0f) goto L9;
        r2 = true;
        goto L10
    L24:
        return null;
    }

    private final String a(int r8, int r9) {
        if (r8 < 0) goto L11;
        if (r9 < 0) goto L13;
        int r10 = RangesKt.coerceIn(r8, 0, 1439);
        int r11 = RangesKt.coerceIn(r9, 0, 1439);
        String r1 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r10 / 60), Integer.valueOf(r10 % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(r1, "format(...)");
        String r7 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r11 / 60), Integer.valueOf(r11 % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(r7, "format(...)");
        if (r11 >= r10) goto L8;
        String r12 = "次日";
    L10:
        return r1 + '-' + r12 + r7;
    L8:
        r12 = "";
        goto L10
    L13:
        return "all_day";
    L11:
        return "all_day";
    }

    private final String a(String r12) {
        GsonUtil r1 = GsonUtil.INSTANCE;     // Catch: JsonParseException -> L22
        if (r12 != null) goto L6;
    L14:
        List r13 = null;
    L15:
        if (r13 == null) goto L26;
        String r14 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: JsonParseException -> L22
        if (r14 == null) goto L27;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L29;
        return null;
    L29:
        return r14;
    L27:
        return null;
    L26:
        return null;
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r12 = null;
    L12:
        if (r12 == null) goto L14;
        r13 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r12, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L22
        goto L15
    L8:
        r2 = false;
    L22:
        ((o) ZeusTransformUtils.preCheckCast(k.f11624a, o.class, "com.obric.memorydata.plugin")).a("tracking_invalid_source_packages", "生产埋点来源包名解析失败", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        return null;
    }

    public static /* synthetic */ void a(MemoryEventTracker r10, AppEntity r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r18 & 64) == 0) goto L17;
        String r9 = null;
    L18:
        r10.a(r11, r12, r13, r6, r7, r8, r9);
        return;
    L17:
        r9 = r17;
        goto L18
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public static /* synthetic */ void a(MemoryEventTracker r6, MemoryEntity r7, RawMemoryEntity r8, String r9, boolean r10, Float r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = false;
    L5:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = null;
    L8:
        r6.a(r7, r8, r9, r4, r11);
    }

    private final NewMemoryParams b(com.obric.memorydata.memory.api.c r20) {
        String r0 = r20.b();
        Float r2 = null;
        if (Intrinsics.areEqual(r0, "episodic_semantic") == false) goto L10;
        MemorySource r1 = MemorySource.TIMESLOP_SEMANTIC;
        if (r20.g() == false) goto L7;
        GenerateMethod r3 = GenerateMethod.SEMANTIC_TIMESLOP_ADD_NEW;
    L8:
        Pair r4 = TuplesKt.to(r1, r3);
        MemorySource r5 = (MemorySource) ZeusTransformUtils.preCheckCast(r4.component1(), MemorySource.class, "com.obric.memorydata.plugin");
        GenerateMethod r6 = (GenerateMethod) ZeusTransformUtils.preCheckCast(r4.component2(), GenerateMethod.class, "com.obric.memorydata.plugin");
        String r7 = r20.a();
        String r8 = r6.getValue();
        String r9 = r5.getValue();
        String r10 = a(r20.c());
        int r11 = ResultType.SUCCESS.getValue();
        String r12 = r20.d();
        String r16 = r20.j();
        String r13 = String.valueOf(r20.e());
        String r14 = String.valueOf(r20.f());
        BaseMemoryParams r15 = new BaseMemoryParams(r7, r8, r9, r10, r11, Integer.valueOf(EntityType.MEMORY_INFO_COMMON), r12, null, null, r13, r14, null, r16, 2432, null);
        Float r17 = Float.valueOf(r20.h());
        Float r18 = r20.i();
        if (r20.g() == true) goto L19;
        r2 = r18;
    L19:
        return new NewMemoryParams(r15, r17, r2);
    L7:
        r3 = GenerateMethod.SEMANTIC_TIMESLOP_UPDATE;
        goto L8
    L10:
        if (Intrinsics.areEqual(r0, "semantic_consolidation") == false) goto L20;
        r1 = MemorySource.DAILY_SEMANTIC;
        if (r20.g() == false) goto L14;
        r3 = GenerateMethod.SEMANTIC_DAILY_ADD_NEW;
        goto L8
    L14:
        r3 = GenerateMethod.SEMANTIC_DAILY_UPDATE;
        goto L8
    L20:
        return null;
    }

    public final Set<String> a() {
        return f10516b;
    }

    public final void a(AppEntity r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "appEntity");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        String r2 = r9.getUuid();
        Integer r3 = Integer.valueOf(r9.getType());
        if (ZeusTransformUtils.instanceOf(r9, InfoCommonMemoryEntity.class) == false) goto L5;
        String r12 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey();
    L6:
        a((Params) ZeusTransformUtils.preCheckCast(new ClickCardItemParams(r2, r3, r12, r10, r11), Params.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void a(AppEntity r13, String r14, String r15, String r16, String r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r14, "enterFrom");
        Intrinsics.checkNotNullParameter(r15, "currentPage");
        if (r13 == null) goto L5;
        String r3 = r13.getUuid();
    L7:
        if (ZeusTransformUtils.instanceOf(r13, ProactiveMemoryEntity.class) == false) goto L22;
        Integer r2 = ((ProactiveMemoryEntity) ZeusTransformUtils.preCheckCast(r13, ProactiveMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType();
        int r4 = 1006;
        if (r2 != null) goto L11;
    L20:
        r4 = 1001;
    L21:
        Integer r5 = Integer.valueOf(r4);
    L24:
        Integer r6 = r5;
    L26:
        if (r19 == null) goto L28;
        String r7 = r19;
    L32:
        a((Params) ZeusTransformUtils.preCheckCast(new PageShowParams(r3, r6, r7, r17, r18, r15, r16, r14), Params.class, "com.obric.memorydata.plugin"));
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r13, InfoCommonMemoryEntity.class) == false) goto L30;
        r7 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r13, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey();
        goto L32
    L30:
        r7 = null;
        goto L32
    L11:
        if (r2.intValue() == 1001) goto L20;
        if (r2.intValue() != 1005) goto L17;
        r4 = 1005;
        goto L21
    L17:
        if (r2.intValue() == 1006) goto L21;
        r4 = ((ProactiveMemoryEntity) ZeusTransformUtils.preCheckCast(r13, ProactiveMemoryEntity.class, "com.obric.memorydata.plugin")).getType();
        goto L21
    L22:
        if (r13 == null) goto L25;
        r5 = Integer.valueOf(r13.getType());
        goto L24
    L25:
        r6 = null;
        goto L26
    L5:
        r3 = null;
        goto L7
    }

    public final void a(AppEntity r20, String r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r20, "appEntity");
        Intrinsics.checkNotNullParameter(r21, "generateMethod");
        String r1 = String.valueOf(r20.getCreateTime());
        String r2 = String.valueOf(r20.getLastModifiedTime());
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L8:
        String r3 = r20.getUuid();
        MemorySource.a r4 = MemorySource.Companion;
        if (ZeusTransformUtils.instanceOf(r20, AuditoryRecordingEntity.class) == false) goto L12;
        int r5 = 12;
    L15:
        String r6 = r4.a(r5).getValue();
        String r7 = r20.get_packageName();
        int r8 = ResultType.SUCCESS.getValue();
        Integer r9 = Integer.valueOf(r20.getType());
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = String.valueOf(r20.getCreateTime());
        String r14 = String.valueOf(r20.getLastModifiedTime());
        if (ZeusTransformUtils.instanceOf(r20, AuditoryRecordingEntity.class) == false) goto L18;
        Integer r0 = Integer.valueOf(((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r20, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getDuration());
    L19:
        BaseMemoryParams r15 = new BaseMemoryParams(r3, r21, r6, r7, r8, r9, r10, r11, r12, r13, r14, r0, null, 4544, null);
        if (r22 == false) goto L22;
        Object r16 = new MemoryDataUploadOnceParams(r15);
        Class<Params> r17 = Params.class;
    L23:
        a((Params) ZeusTransformUtils.preCheckCast(r16, r17, "com.obric.memorydata.plugin"));
        return;
    L22:
        r16 = new NewMemoryParams(r15, null, null, 6, null);
        r17 = Params.class;
        goto L23
    L18:
        r0 = null;
        goto L19
    L12:
        if (ZeusTransformUtils.instanceOf(r20, ProactiveMemoryEntity.class) == false) goto L14;
        r5 = 11;
        goto L15
    L14:
        r5 = -1;
        goto L15
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEventTracker", "please check the createTime and modifyTime", null, 4, null);
    }

    public final void a(MemoryEntity r27, RawMemoryEntity r28, String r29, boolean r30, Float r31) {
        Intrinsics.checkNotNullParameter(r27, "memoryEntity");
        Intrinsics.checkNotNullParameter(r28, "rawMemoryEntity");
        Intrinsics.checkNotNullParameter(r29, "generateMethod");
        String r2 = r27.getUuid();
        if (r2 != null) goto L5;
        r2 = r28.getUuid();
    L5:
        String r4 = r2;
        String r6 = MemorySource.Companion.a(r27.getProductType()).getValue();
        String r7 = r27.getSourcePackageName();
        int r8 = ResultType.SUCCESS.getValue();
        int r3 = r27.getType();
        if (ZeusTransformUtils.instanceOf(r27, InfoCommonMemoryEntity.class) == false) goto L10;
        String r5 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r27, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey();
    L8:
        String r10 = r5;
    L14:
        if (ZeusTransformUtils.instanceOf(r27, CommonTextMemoryEntity.class) == false) goto L19;
        List<String> r0 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r27, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTagList();
        if (r0 == null) goto L22;
        String r1 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L21:
        String r16 = r1;
    L23:
        Long r9 = r28.getStartTime();
        if (r9 == null) goto L26;
        String r11 = r9.toString();
    L27:
        Long r12 = r28.getEndTime();
        if (r12 == null) goto L30;
        String r13 = r12.toString();
    L31:
        BaseMemoryParams r14 = new BaseMemoryParams(r4, r29, r6, r7, r8, Integer.valueOf(r3), r10, r11, r13, String.valueOf(r28.getCreateTime()), String.valueOf(r28.getModifyTime()), null, r16, 2048, null);
        if (r30 == false) goto L35;
        Object r15 = ZeusTransformUtils.preCheckCast(new MemoryDataUploadOnceParams(r14), Params.class, "com.obric.memorydata.plugin");
    L40:
        a((Params) r15);
        return;
    L35:
        ip r17 = iq.a(r28, 0, 1, null);
        if (r17 == null) goto L38;
        Float r18 = Float.valueOf(r17.l());
    L39:
        r15 = ZeusTransformUtils.preCheckCast(new NewMemoryParams(r14, r18, r31), Params.class, "com.obric.memorydata.plugin");
        goto L40
    L38:
        r18 = null;
        goto L39
    L30:
        r13 = null;
        goto L31
    L26:
        r11 = null;
    L22:
        r16 = null;
        goto L23
    L19:
        if (ZeusTransformUtils.instanceOf(r27, InfoCommonMemoryEntity.class) == false) goto L22;
        r1 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r27, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getTag();
        goto L21
    L10:
        if (ZeusTransformUtils.instanceOf(r27, CommonTextMemoryEntity.class) == false) goto L12;
        r5 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r27, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getCategory();
        goto L8
    L12:
        r10 = null;
        goto L14
    }

    public final void a(com.obric.memorydata.memory.api.c r3) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        NewMemoryParams r4 = b(r3);
        if (r4 == null) goto L6;
        a((Params) ZeusTransformUtils.preCheckCast(r4, Params.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void a(AutoMemoryRuleHitParams r3) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        a((Params) ZeusTransformUtils.preCheckCast(r3, Params.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Params r4) {
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        if (ZeusTransformUtils.instanceOf(r4, MemorySettingsSnapshotParams.class) == false) goto L6;
        MemoryEventType r0 = MemoryEventType.MEMORY_SETTINGS_SNAPSHOT;
    L35:
        JSONObject r3 = b(r4);
        RunLog.INSTANCE.debug("MemoryEventTracker", r0.getEventName() + r3);
        Tracker.INSTANCE.reportEvent(r0.getEventName(), r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, MemorySwitchSnapshotParams.class) == false) goto L9;
        r0 = MemoryEventType.MEMORY_SWITCH_SNAPSHOT;
        goto L35
    L9:
        if (ZeusTransformUtils.instanceOf(r4, NewMemoryParams.class) == false) goto L12;
        r0 = MemoryEventType.NEW_MEMORY;
        goto L35
    L12:
        if (ZeusTransformUtils.instanceOf(r4, MemoryDataUploadOnceParams.class) == false) goto L15;
        r0 = MemoryEventType.MEMORY_DATA_UPLOAD_ONCE;
        goto L35
    L15:
        if (ZeusTransformUtils.instanceOf(r4, PageShowParams.class) == false) goto L18;
        r0 = MemoryEventType.PAGE_SHOW;
        goto L35
    L18:
        if (ZeusTransformUtils.instanceOf(r4, ClickCardItemParams.class) == false) goto L21;
        r0 = MemoryEventType.CLICK_CARD_ITEM;
        goto L35
    L21:
        if (ZeusTransformUtils.instanceOf(r4, EditCardItemParams.class) == false) goto L24;
        r0 = MemoryEventType.EDIT_CARD_ITEM;
        goto L35
    L24:
        if (ZeusTransformUtils.instanceOf(r4, DeleteCardItemParams.class) == false) goto L27;
        r0 = MemoryEventType.DELETE_CARD_ITEM;
        goto L35
    L27:
        if (ZeusTransformUtils.instanceOf(r4, AutoMemoryRuleHitParams.class) == false) goto L30;
        r0 = MemoryEventType.AUTO_MEMORY_RULE_HIT;
        goto L35
    L30:
        if (ZeusTransformUtils.instanceOf(r4, RuleEditParams.class) == false) goto L33;
        r0 = MemoryEventType.AUTO_MEMORY_PRO_RULE_EDIT;
        goto L35
    L33:
        if (ZeusTransformUtils.instanceOf(r4, RuleDailyReportParams.class) == false) goto L38;
        r0 = MemoryEventType.AUTO_MEMORY_PRO_RULE_DAILY_REPORT;
        goto L35
    L38:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(String r19, int r20, String r21, int r22, String r23, long r24, long r26, boolean r28, boolean r29, Float r30, Float r31, String r32) {
        if (r29 == true) goto L10;
        if (r28 == true) goto L10;
        if (r20 != 3) goto L9;
        GenerateMethod r1 = GenerateMethod.UPDATE_QUERY;
    L11:
        String r2 = r1.getValue();
        String r5 = MemorySource.Companion.a(r20).getValue();
        int r7 = ResultType.SUCCESS.getValue();
        String r12 = String.valueOf(r24);
        String r13 = String.valueOf(r26);
        a((Params) ZeusTransformUtils.preCheckCast(new NewMemoryParams(new BaseMemoryParams(r19, r2, r5, r21, r7, Integer.valueOf(r22), r23, null, null, r12, r13, null, r32, 2432, null), r30, r31), Params.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        r1 = GenerateMethod.UPDATE;
    L10:
        r1 = GenerateMethod.ADD_NEW;
        goto L11
    }

    public final void a(List<String> r13, String r14) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "ids");
        Intrinsics.checkNotNullParameter(r14, "deleteMethod");
        RunLog.INSTANCE.debug("MemoryEventTracker", "ids: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), 25), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        f10515a.a((Params) ZeusTransformUtils.preCheckCast(new DeleteCardItemParams(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), r14), Params.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public final void a(boolean r12, String r13, String r14, int r15, int r16, boolean r17, boolean r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r13, "ruleTitle");
        Intrinsics.checkNotNullParameter(r14, "ruleConfig");
        Intrinsics.checkNotNullParameter(r19, "appPackages");
        Intrinsics.checkNotNullParameter(r20, AILabCheckPermissionTask.KEY_SOURCE);
        a((Params) ZeusTransformUtils.preCheckCast(new RuleDailyReportParams(r12, r13, r14, a(r15, r16), r17, r18, r19, r20), Params.class, "com.obric.memorydata.plugin"));
    }

    public final void a(boolean r12, String r13, String r14, String r15, int r16, int r17, boolean r18, boolean r19, String r20) {
        Intrinsics.checkNotNullParameter(r15, "userEditResult");
        Intrinsics.checkNotNullParameter(r20, "appPackages");
        if (r12 == false) goto L5;
        RuleEditOperation r2 = RuleEditOperation.EDIT;
    L6:
        a((Params) ZeusTransformUtils.preCheckCast(new RuleEditParams(r2.getValue(), r13, r14, r15, a(r16, r17), r18, r19, r20), Params.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r2 = RuleEditOperation.ADD_NEW;
        goto L6
    }

    public final void a(boolean r8, boolean r9, boolean r10, boolean r11, boolean r12) {
        a((Params) ZeusTransformUtils.preCheckCast(new MemorySwitchSnapshotParams(a(r8), a(r9), a(r10), a(r11), a(r12)), Params.class, "com.obric.memorydata.plugin"));
    }

    public final void a(AppEntity[] r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "appEntityArray");
        Intrinsics.checkNotNullParameter(r6, "deleteMethod");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        String r3 = r5[r2].getUuid();
        if (r3 == null) goto L7;
        r4.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L14;
        Object r1 = r9.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L10;
        r8.add(r1);
        goto L10
    L14:
        f10515a.a((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), r6);
    }

    public final boolean a(MemorySettingsSnapshotParams r5) {
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        return Tracker.INSTANCE.reportEventAccepted(MemoryEventType.MEMORY_SETTINGS_SNAPSHOT.getEventName(), b((Params) ZeusTransformUtils.preCheckCast(r5, Params.class, "com.obric.memorydata.plugin")));
    }

    public final JSONObject b(Params r10) {
        Intrinsics.checkNotNullParameter(r10, TrackerImpl.PARAMS);
        if (ZeusTransformUtils.instanceOf(r10, NewMemoryParams.class) == false) goto L6;
        Object r0 = ((NewMemoryParams) ZeusTransformUtils.preCheckCast(r10, NewMemoryParams.class, "com.obric.memorydata.plugin")).getBase();
    L9:
        JSONObject r1 = GsonUtil.INSTANCE.toJSONObject(r0);
        if (ZeusTransformUtils.instanceOf(r10, MemorySettingsSnapshotParams.class) == false) goto L14;
        r1.remove("trigger_type");
        JSONObject r2 = new JSONObject();
        r2.put("trigger_type", ((MemorySettingsSnapshotParams) ZeusTransformUtils.preCheckCast(r10, MemorySettingsSnapshotParams.class, "com.obric.memorydata.plugin")).getTriggerType());
        r2.put("trigger_switch", r1.toString());
        return r2;
    L14:
        if (ZeusTransformUtils.instanceOf(r10, NewMemoryParams.class) == false) goto L31;
        String r3 = com.obric.memorydata.memory.tracker.a.a(com.obric.memorydata.memory.tracker.a.f10530a, ((NewMemoryParams) ZeusTransformUtils.preCheckCast(r10, NewMemoryParams.class, "com.obric.memorydata.plugin")).getBase(), null, null, 6, null);
        if (r3 == null) goto L18;
        r1.put("device_source", r3);
    L18:
        Integer r4 = ((NewMemoryParams) ZeusTransformUtils.preCheckCast(r10, NewMemoryParams.class, "com.obric.memorydata.plugin")).getBase().getType();
        if (r4 == null) goto L31;
        if (r4.intValue() != 10105) goto L31;
        Integer r5 = a(((NewMemoryParams) ZeusTransformUtils.preCheckCast(r10, NewMemoryParams.class, "com.obric.memorydata.plugin")).getConfidenceScore());
        if (r5 == null) goto L27;
        r1.put("confidence_score", ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue());
    L27:
        if (Intrinsics.areEqual(((NewMemoryParams) ZeusTransformUtils.preCheckCast(r10, NewMemoryParams.class, "com.obric.memorydata.plugin")).getBase().getGenerateMethod(), GenerateMethod.ADD_NEW.getValue()) == true) goto L31;
        Integer r9 = a(((NewMemoryParams) ZeusTransformUtils.preCheckCast(r10, NewMemoryParams.class, "com.obric.memorydata.plugin")).getPreviousConfidenceScore());
        if (r9 == null) goto L31;
        r1.put("previous_confidence_score", ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue());
    L31:
        return r1;
    L6:
        if (ZeusTransformUtils.instanceOf(r10, MemoryDataUploadOnceParams.class) == false) goto L8;
        r0 = ((MemoryDataUploadOnceParams) ZeusTransformUtils.preCheckCast(r10, MemoryDataUploadOnceParams.class, "com.obric.memorydata.plugin")).getBase();
        goto L9
    L8:
        r0 = r10;
        goto L9
    }
}
