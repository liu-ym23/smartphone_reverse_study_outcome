package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRealtimeValueNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "MsgCount", "EnqueueCount", "ShowCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRealtimeValueNode extends Enum<PSRealtimeValueNode> {
    public static final PSRealtimeValueNode EnqueueCount = null;
    public static final PSRealtimeValueNode MsgCount = null;
    public static final PSRealtimeValueNode ShowCount = null;
    public static final /* synthetic */ PSRealtimeValueNode[] a = null;
    private final String valueNodeName;

    static {
        PSRealtimeValueNode r1 = new PSRealtimeValueNode("MsgCount", 0, "period_msg_count");
        MsgCount = r1;
        PSRealtimeValueNode r2 = new PSRealtimeValueNode("EnqueueCount", 1, "period_enqueue_count");
        EnqueueCount = r2;
        PSRealtimeValueNode r3 = new PSRealtimeValueNode("ShowCount", 2, "period_show_count");
        ShowCount = r3;
        a = new PSRealtimeValueNode[]{r1, r2, r3};
    }

    public static PSRealtimeValueNode valueOf(String r1) {
        return (PSRealtimeValueNode) a.a(PSRealtimeValueNode.class, r1);
    }

    public static PSRealtimeValueNode[] values() {
        return (PSRealtimeValueNode[]) a.clone();
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public PSRealtimeValueNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.valueNodeName = r3;
    }
}
