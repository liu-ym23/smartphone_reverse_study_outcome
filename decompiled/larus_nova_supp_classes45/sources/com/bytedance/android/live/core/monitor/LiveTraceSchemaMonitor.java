package com.bytedance.android.live.core.monitor;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveTraceSchemaMonitor extends BaseMonitor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTraceSchemaMonitor$HybridType;", "", "ANNIE", "LYNX", "WEB", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        public static final HybridType ANNIE = null;
        public static final HybridType LYNX = null;
        public static final HybridType WEB = null;
        public static final /* synthetic */ HybridType[] a = null;

        static {
            HybridType r1 = new HybridType("ANNIE", 0);
            ANNIE = r1;
            HybridType r2 = new HybridType("LYNX", 1);
            LYNX = r2;
            HybridType r3 = new HybridType("WEB", 2);
            WEB = r3;
            a = new HybridType[]{r1, r2, r3};
        }

        public static HybridType valueOf(String r1) {
            return (HybridType) a.a(HybridType.class, r1);
        }

        public static HybridType[] values() {
            return (HybridType[]) a.clone();
        }

        public HybridType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTraceSchemaMonitor$Status;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "SDK_INIT_UNFINISHED", "URI_INVALID", "ERROR_UNKNOWN", "ENTER_ROOM_PARAMS_INVALID", "ENTER_ROOM_GET_USER_INFO_FAIL", "ENTER_ROOM_COIN_TASK_FAIL", "ENTER_ROOM_ACTIVITY_CREATE_FAIL", "ENTER_ROOM_FRAGMENT_CREATE_FAIL", "BROADCAST_MODULE_NOT_LAUNCH", "BROADCAST_PAGE_CREATE_FAIL", "HYBRID_URL_INVALID", "HYBRID_GET_CONTAINER_TYPE_FAIL", "HYBRID_ANNIE_LOAD_FAIL", "HYBRID_LYNX_LOAD_FAIL", "HYBRID_WEB_LOAD_FAIL", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        public static final Status BROADCAST_MODULE_NOT_LAUNCH = null;
        public static final Status BROADCAST_PAGE_CREATE_FAIL = null;
        public static final Status ENTER_ROOM_ACTIVITY_CREATE_FAIL = null;
        public static final Status ENTER_ROOM_COIN_TASK_FAIL = null;
        public static final Status ENTER_ROOM_FRAGMENT_CREATE_FAIL = null;
        public static final Status ENTER_ROOM_GET_USER_INFO_FAIL = null;
        public static final Status ENTER_ROOM_PARAMS_INVALID = null;
        public static final Status ERROR_UNKNOWN = null;
        public static final Status HYBRID_ANNIE_LOAD_FAIL = null;
        public static final Status HYBRID_GET_CONTAINER_TYPE_FAIL = null;
        public static final Status HYBRID_LYNX_LOAD_FAIL = null;
        public static final Status HYBRID_URL_INVALID = null;
        public static final Status HYBRID_WEB_LOAD_FAIL = null;
        public static final Status SDK_INIT_UNFINISHED = null;
        public static final Status SUCCESS = null;
        public static final Status URI_INVALID = null;
        public static final /* synthetic */ Status[] a = null;
        private final int value;

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        static {
            Status r1 = new Status("SUCCESS", 0, 0);
            SUCCESS = r1;
            Status r2 = new Status("SDK_INIT_UNFINISHED", 1, 1);
            SDK_INIT_UNFINISHED = r2;
            Status r3 = new Status("URI_INVALID", 2, 2);
            URI_INVALID = r3;
            Status r4 = new Status("ERROR_UNKNOWN", 3, 3);
            ERROR_UNKNOWN = r4;
            Status r5 = new Status("ENTER_ROOM_PARAMS_INVALID", 4, 11);
            ENTER_ROOM_PARAMS_INVALID = r5;
            Status r6 = new Status("ENTER_ROOM_GET_USER_INFO_FAIL", 5, 12);
            ENTER_ROOM_GET_USER_INFO_FAIL = r6;
            Status r7 = new Status("ENTER_ROOM_COIN_TASK_FAIL", 6, 13);
            ENTER_ROOM_COIN_TASK_FAIL = r7;
            Status r8 = new Status("ENTER_ROOM_ACTIVITY_CREATE_FAIL", 7, 14);
            ENTER_ROOM_ACTIVITY_CREATE_FAIL = r8;
            Status r9 = new Status("ENTER_ROOM_FRAGMENT_CREATE_FAIL", 8, 15);
            ENTER_ROOM_FRAGMENT_CREATE_FAIL = r9;
            Status r11 = new Status("BROADCAST_MODULE_NOT_LAUNCH", 9, 21);
            BROADCAST_MODULE_NOT_LAUNCH = r11;
            Status r12 = new Status("BROADCAST_PAGE_CREATE_FAIL", 10, 22);
            BROADCAST_PAGE_CREATE_FAIL = r12;
            Status r13 = new Status("HYBRID_URL_INVALID", 11, 31);
            HYBRID_URL_INVALID = r13;
            Status r14 = new Status("HYBRID_GET_CONTAINER_TYPE_FAIL", 12, 32);
            HYBRID_GET_CONTAINER_TYPE_FAIL = r14;
            Status r15 = new Status("HYBRID_ANNIE_LOAD_FAIL", 13, 33);
            HYBRID_ANNIE_LOAD_FAIL = r15;
            Status r16 = new Status("HYBRID_LYNX_LOAD_FAIL", 14, 34);
            HYBRID_LYNX_LOAD_FAIL = r16;
            Status r17 = new Status("HYBRID_WEB_LOAD_FAIL", 15, 35);
            HYBRID_WEB_LOAD_FAIL = r17;
            a = new Status[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17};
        }

        public final int getValue() {
            return this.value;
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @JvmStatic
    public static final void l(BaseMonitor.MonitorEventModule r0, Status r1, String r2, String r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        Intrinsics.checkNotNullParameter(r1, "status");
        Intrinsics.checkNotNullParameter(r2, "statusMsg");
    }

    static {
        new LiveTraceSchemaMonitor();
    }

    public LiveTraceSchemaMonitor() {
    }

    public static /* synthetic */ void m(BaseMonitor.MonitorEventModule r6, Status r7, String r8, String r9, String r11) {
        l(r6, r7, r8, r9, r11, null);
    }
}
