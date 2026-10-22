package nd0;

import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MultiLinkEventType.values().length];
        a = r0;
        r0[MultiLinkEventType.SERVER_API_CALL.ordinal()] = 1;
        r0[MultiLinkEventType.MESSAGE_RECEIVED.ordinal()] = 2;
        r0[MultiLinkEventType.SDK_INTERFACE_CALL.ordinal()] = 3;
        r0[MultiLinkEventType.SDK_CALLBACK.ordinal()] = 4;
        r0[MultiLinkEventType.BUSSINESS_API_CALL.ordinal()] = 5;
    }
}
