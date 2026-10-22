package com.obric.memorydata.memory.auditory;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.task.condition.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a/\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0019\u001a\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0006H\u0000\u001aL\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000eH\u0000\u001a\u0012\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0000\u001a\u0014\u0010+\u001a\u00020\u0003*\u00020*2\u0006\u0010,\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"AUDITORY_SYNC_SETTINGS_KEY", "", "AUDITORY_SCREEN_ON_FLUSH_THRESHOLD_MS", "", "AUDITORY_SYSTEM_TIME_CHANGED_REASON", "effectiveAuditoryScheduleState", "Lcom/obric/memorydata/memory/auditory/AuditoryScheduleState;", "desired", "networkPolicy", "Lcom/obric/memorydata/memory/auditory/AuditoryNetworkPolicyState;", "auditorySyncConditions", "", "Lcom/obric/memorydata/task/condition/Condition;", "cellularUploadEnabled", "", "shouldCancelAuditoryScheduleOnReconcile", InfoRequestQPSOptTraceLogger.REASON, "previous", TypedValues.AttributesType.S_TARGET, "shouldExecuteAuditoryScheduleImmediately", "shouldForceRescheduleAuditorySchedule", "shouldFlushAuditoryScheduleOnScreenOn", "current", "lastRunElapsedRealtimeMs", "nowElapsedRealtimeMs", "(Ljava/lang/String;Lcom/obric/memorydata/memory/auditory/AuditoryScheduleState;Ljava/lang/Long;J)Z", "shouldStopDrainedAuditorySchedule", "remainingTasks", "", "nextAuditoryScheduleState", "config", "Lcom/obric/memorydata/memory/auditory/AuditorySyncConfig;", "deviceState", "Lcom/obric/memorydata/memory/auditory/AuditoryDeviceState;", "accountAllowed", "systemEnabled", "platformSupport", "Lcom/obric/memorydata/memory/auditory/AuditoryPlatformSupport;", "drainIfDisabled", "hasPendingTasksWhenInactive", "parseAuditorySyncConfig", "root", "Lorg/json/JSONObject;", "positiveLong", "key", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {
    private static final long a(JSONObject r6, String r7) {
        Object r8 = r6.opt(r7);
        Long r1 = null;
        if (ZeusTransformUtils.instanceOf(r8, Number.class) == false) goto L5;
        Number r9 = (Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin");
    L7:
        if (r9 != null) goto L9;
        return 0;
    L9:
        Long r10 = Long.valueOf(r9.longValue());
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L15;
        r1 = r10;
    L15:
        if (r1 != null) goto L17;
        return 0;
    L17:
        return r1.longValue();
    L12:
        r11 = false;
        goto L13
    L5:
        r9 = null;
        goto L7
    }

    public static final e a(e r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "desired");
        Intrinsics.checkNotNullParameter(r3, "networkPolicy");
        if (r3.b() == false) goto L6;
        return r2;
    L6:
        return new e(null, false, 3, null);
    }

    public static final e a(e r4, f r5, a r6, boolean r7, boolean r8, AuditoryPlatformSupport r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r4, "previous");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "deviceState");
        Intrinsics.checkNotNullParameter(r9, "platformSupport");
        if (r9 != AuditoryPlatformSupport.SUPPORTED) goto L30;
        if (r5.b() == false) goto L30;
        if (r7 == false) goto L12;
        if (r8 == false) goto L12;
        return new e(Long.valueOf(r5.a(r6)), false);
    L12:
        if (r4.b() == false) goto L16;
        if (r7 == false) goto L16;
        return r4;
    L16:
        if (r4.a() != null) goto L24;
        if (r7 == false) goto L23;
        if (r5.a() == false) goto L23;
        if (r11 == false) goto L23;
        return new e(Long.valueOf(r5.a(r6)), true);
    L23:
        return new e(null, false, 3, null);
    L24:
        if (r10 == false) goto L28;
        if (r7 == false) goto L28;
        return new e(r4.a(), true);
    L28:
        return new e(null, false, 3, null);
    L30:
        return new e(null, false, 3, null);
    }

    public static final f a(JSONObject r11) {
        if (r11 == null) goto L7;
        JSONObject r0 = r11.optJSONObject("obric_memd_auditory_memory");
        if (r0 == null) goto L7;
        r11 = r0;
    L11:
        return new f(Intrinsics.areEqual(r11.opt("enable"), true), a(r11, "screenOnScheduleIntervalSeconds"), a(r11, "screenOffScheduleIntervalSeconds"), a(r11, "screenOffChargingScheduleIntervalSeconds"));
    L7:
        if (r11 != null) goto L11;
        return new f(false, 0, 0, 0, 15, null);
    }

    public static final List<Condition> a(boolean r2) {
        List r0 = CollectionsKt.createListBuilder();
        r0.add(Condition.NETWORK_AVAILABLE);
        if (r2 == true) goto L6;
        r0.add(Condition.WIFI_CONNECTED);
    L6:
        return CollectionsKt.build(r0);
    }

    public static final boolean a(int r1, e r2) {
        Intrinsics.checkNotNullParameter(r2, "current");
        if (r1 == 0) goto L5;
    L9:
        return false;
    L5:
        if (r2.a() == null) goto L9;
        if (r2.b() == false) goto L9;
        return true;
    }

    public static final boolean a(e r1, e r2) {
        Intrinsics.checkNotNullParameter(r1, "previous");
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        if (r2.a() != null) goto L5;
    L11:
        return false;
    L5:
        if (r1.a() != null) goto L7;
    L10:
        return true;
    L7:
        if (r1.b() == false) goto L11;
        if (r2.b() == true) goto L11;
        goto L10
    }

    public static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, InfoRequestQPSOptTraceLogger.REASON);
        return Intrinsics.areEqual(r1, "system_time_changed");
    }

    public static final boolean a(String r1, e r2, e r3) {
        Intrinsics.checkNotNullParameter(r1, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r2, "previous");
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        if (r3.a() == null) goto L5;
    L9:
        return false;
    L5:
        if (r2.a() == null) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(r1, CommonConsts.APM_INNER_EVENT_COST_START) == false) goto L9;
        goto L8
    }

    public static final boolean a(String r2, e r3, Long r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r3, "current");
        if (Intrinsics.areEqual(r2, "screen_turned_on") == true) goto L5;
    L18:
        return false;
    L5:
        if (r3.a() == null) goto L18;
        if (r3.b() == true) goto L18;
        if (r4 == null) goto L17;
        long r6 = r4.longValue();
        if (r5 < r6) goto L16;
        if ((r5 - r6) > 180000) goto L16;
        return false;
    L16:
        return true;
    L17:
        return true;
    }
}
