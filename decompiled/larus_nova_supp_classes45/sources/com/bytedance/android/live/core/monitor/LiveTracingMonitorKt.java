package com.bytedance.android.live.core.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveTracingMonitorKt {
    public static final LiveTracingMonitorKt a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTracingMonitorKt$EventModule;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "PK", "MULTI_LINKER", "MEDIA_MULTI_LINKER", "SCREEN_LINKER", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EventModule extends Enum<EventModule> {
        public static final EventModule MEDIA_MULTI_LINKER = null;
        public static final EventModule MULTI_LINKER = null;
        public static final EventModule PK = null;
        public static final EventModule SCREEN_LINKER = null;
        public static final /* synthetic */ EventModule[] a = null;
        private final String typeName;

        static {
            EventModule r1 = new EventModule("PK", 0, "pk");
            PK = r1;
            EventModule r2 = new EventModule("MULTI_LINKER", 1, "muti_linker");
            MULTI_LINKER = r2;
            EventModule r3 = new EventModule("MEDIA_MULTI_LINKER", 2, "media_muti_linker");
            MEDIA_MULTI_LINKER = r3;
            EventModule r4 = new EventModule("SCREEN_LINKER", 3, "screen_linker");
            SCREEN_LINKER = r4;
            a = new EventModule[]{r1, r2, r3, r4};
        }

        public static EventModule valueOf(String r1) {
            return (EventModule) a.a(EventModule.class, r1);
        }

        public static EventModule[] values() {
            return (EventModule[]) a.clone();
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public EventModule(String r1, int r2, String r3) {
            super(r1, r2);
            this.typeName = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTracingMonitorKt$EventType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "BUSSINESS_API_CALL", "SERVER_API_CALL", "MESSAGE_RECEIVED", "SDK_INTERFACE_CALL", "SDK_CALLBACK", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType BUSSINESS_API_CALL = null;
        public static final EventType MESSAGE_RECEIVED = null;
        public static final EventType SDK_CALLBACK = null;
        public static final EventType SDK_INTERFACE_CALL = null;
        public static final EventType SERVER_API_CALL = null;
        public static final /* synthetic */ EventType[] a = null;
        private final String typeName;

        static {
            EventType r1 = new EventType("BUSSINESS_API_CALL", 0, "bussiness_api_call");
            BUSSINESS_API_CALL = r1;
            EventType r2 = new EventType("SERVER_API_CALL", 1, "server_api_call");
            SERVER_API_CALL = r2;
            EventType r3 = new EventType("MESSAGE_RECEIVED", 2, "message_received");
            MESSAGE_RECEIVED = r3;
            EventType r4 = new EventType("SDK_INTERFACE_CALL", 3, "sdk_interface_call");
            SDK_INTERFACE_CALL = r4;
            EventType r5 = new EventType("SDK_CALLBACK", 4, "sdk_callback");
            SDK_CALLBACK = r5;
            a = new EventType[]{r1, r2, r3, r4, r5};
        }

        public static EventType valueOf(String r1) {
            return (EventType) a.a(EventType.class, r1);
        }

        public static EventType[] values() {
            return (EventType[]) a.clone();
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public EventType(String r1, int r2, String r3) {
            super(r1, r2);
            this.typeName = r3;
        }
    }

    public LiveTracingMonitorKt() {
    }

    static {
        a = new LiveTracingMonitorKt();
    }

    public static EventModule a(int r1) {
        if (r1 != 1) goto L7;
        return EventModule.PK;
    L7:
        if (r1 != 17) goto L11;
        return EventModule.MEDIA_MULTI_LINKER;
    L11:
        if (r1 != 14) goto L15;
        return EventModule.SCREEN_LINKER;
    L15:
        return EventModule.MULTI_LINKER;
    }
}
