package y50;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[LiveTracingMonitorKt.EventModule.values().length];
        a = r0;
        r0[LiveTracingMonitorKt.EventModule.PK.ordinal()] = 1;
        r0[LiveTracingMonitorKt.EventModule.MULTI_LINKER.ordinal()] = 2;
        r0[LiveTracingMonitorKt.EventModule.MEDIA_MULTI_LINKER.ordinal()] = 3;
        r0[LiveTracingMonitorKt.EventModule.SCREEN_LINKER.ordinal()] = 4;
        int[] r1 = new int[LiveTracingMonitorKt.EventType.values().length];
        b = r1;
        r1[LiveTracingMonitorKt.EventType.BUSSINESS_API_CALL.ordinal()] = 1;
        r1[LiveTracingMonitorKt.EventType.SERVER_API_CALL.ordinal()] = 2;
        r1[LiveTracingMonitorKt.EventType.MESSAGE_RECEIVED.ordinal()] = 3;
        r1[LiveTracingMonitorKt.EventType.SDK_INTERFACE_CALL.ordinal()] = 4;
        r1[LiveTracingMonitorKt.EventType.SDK_CALLBACK.ordinal()] = 5;
    }
}
