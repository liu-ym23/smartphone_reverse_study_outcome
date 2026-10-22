package com.obric.aiagent.ipc.utils;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u000245B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010J.\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010J&\u0010#\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010J.\u0010$\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010J<\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\"H\u0002JB\u0010)\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000eH\u0002J\f\u0010-\u001a\u00020\u0005*\u00020\"H\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace;", "", "<init>", "()V", "EVENT_NAME", "", "PARAM_DIRECTION", "PARAM_TAG", "PARAM_METHOD", "PARAM_ANOMALY_TYPE", "PARAM_COST", "PARAM_WINDOW_COUNT", "PARAM_EXCEPTION", "MAX_EXCEPTION_LENGTH", "", "MICROSECONDS_PER_MILLISECOND", "", "NANOS_PER_MILLISECOND", "runtimeConfig", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace$RuntimeConfig;", "reporting", "Ljava/lang/ThreadLocal;", "", "updateConfig", "", "config", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyConfig;", "onCallResult", LocationMonitorConst.TAG, "method", "durationUs", "endNs", "onCallFail", "e", "Lcom/obric/aiagent/ipc/utils/IPCException;", "onInvokeResult", "onInvokeFail", "detectAndReport", "direction", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace$Direction;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "reportDecision", "anomalyType", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyType;", "windowCount", "reportSummary", "logFailure", "tr", "", "reportEvent", "paramBundle", "Landroid/os/Bundle;", "Direction", "RuntimeConfig", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IPCAnomalyTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IPCAnomalyTrace f5937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f5938b;
    private static final ThreadLocal<Boolean> c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace$Direction;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CALL", "INVOKE", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction CALL = null;
        public static final Direction INVOKE = null;
        private final String value;

        private static final /* synthetic */ Direction[] $values() {
            return new Direction[]{CALL, INVOKE};
        }

        static {
            CALL = new Direction("CALL", 0, NotificationCompat.CATEGORY_CALL);
            INVOKE = new Direction("INVOKE", 1, "invoke");
            Direction[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Direction(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }

        public static Direction valueOf(String r2) {
            return (Direction) ZeusTransformUtils.preCheckCast(Enum.valueOf(Direction.class, r2), Direction.class, "com.obric.memorydata.plugin");
        }

        public static Direction[] values() {
            return (Direction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Direction[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace$RuntimeConfig;", "", "enabled", "", "detector", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyDetector;", "<init>", "(ZLcom/obric/aiagent/ipc/utils/IPCAnomalyDetector;)V", "getEnabled", "()Z", "getDetector", "()Lcom/obric/aiagent/ipc/utils/IPCAnomalyDetector;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0240a f5939a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5940b;
        private final b c;

        /* JADX INFO: renamed from: com.obric.aiagent.ipc.utils.IPCAnomalyTrace$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace$RuntimeConfig$Companion;", "", "<init>", "()V", "from", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace$RuntimeConfig;", "config", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyConfig;", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0240a {
            private C0240a() {
            }

            public /* synthetic */ C0240a(DefaultConstructorMarker r1) {
                this();
            }

            public final a a(com.obric.aiagent.ipc.utils.a r21) {
                Intrinsics.checkNotNullParameter(r21, "config");
                com.obric.aiagent.ipc.utils.a r0 = new com.obric.aiagent.ipc.utils.a(false, 0, 0, 0, 15, null);
                Long r2 = Long.valueOf(r21.b());
                boolean r5 = true;
                if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L5;
                boolean r3 = true;
            L6:
                Integer r7 = null;
                if (r3 == true) goto L10;
                r2 = null;
            L10:
                if (r2 == null) goto L12;
                long r4 = r2.longValue();
            L13:
                Integer r8 = Integer.valueOf(r21.c());
                if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L16;
                boolean r9 = true;
            L17:
                if (r9 == true) goto L20;
                r8 = null;
            L20:
                if (r8 == null) goto L22;
                int r10 = r8.intValue();
            L23:
                int r14 = r10;
                Integer r11 = Integer.valueOf(r21.d());
                if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L27;
                r5 = false;
            L27:
                if (r5 == false) goto L29;
                r7 = r11;
            L29:
                if (r7 == null) goto L31;
                int r1 = r7.intValue();
            L33:
                return new a(r21.a(), new b(0, RangesKt.coerceAtMost(r4, 9223372036854775L) * 1000, r14, r1, 0, 17, null));
            L31:
                r1 = r0.d();
                goto L33
            L22:
                r10 = r0.c();
                goto L23
            L16:
                r9 = false;
                goto L17
            L12:
                r4 = r0.b();
                goto L13
            L5:
                r3 = false;
                goto L6
            }
        }

        static {
            f5939a = new C0240a(null);
        }

        public a(boolean r2, b r3) {
            Intrinsics.checkNotNullParameter(r3, "detector");
            this.f5940b = r2;
            this.c = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f5940b == r6.f5940b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f5940b) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "RuntimeConfig(enabled=" + this.f5940b + ", detector=" + this.c + ')';
        }
    }

    static {
        f5937a = new IPCAnomalyTrace();
        f5938b = a.f5939a.a(new com.obric.aiagent.ipc.utils.a(false, 0, 0, 0, 14, null));
        c = new ThreadLocal();
    }

    private IPCAnomalyTrace() {
    }
}
