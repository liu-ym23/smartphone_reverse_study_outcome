package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRoomStatConstantNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "nodeName", "Ljava/lang/String;", "getNodeName", "()Ljava/lang/String;", "FirstMessageShowDelay", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRoomStatConstantNode extends Enum<PSRoomStatConstantNode> {
    public static final PSRoomStatConstantNode FirstMessageShowDelay = null;
    public static final /* synthetic */ PSRoomStatConstantNode[] a = null;
    private final String nodeName;

    static {
        PSRoomStatConstantNode r1 = new PSRoomStatConstantNode();
        FirstMessageShowDelay = r1;
        a = new PSRoomStatConstantNode[]{r1};
    }

    public static PSRoomStatConstantNode valueOf(String r1) {
        return (PSRoomStatConstantNode) a.a(PSRoomStatConstantNode.class, r1);
    }

    public static PSRoomStatConstantNode[] values() {
        return (PSRoomStatConstantNode[]) a.clone();
    }

    public PSRoomStatConstantNode() {
        super("FirstMessageShowDelay", 0);
        this.nodeName = "first_message_show_delay";
    }

    public final String getNodeName() {
        return this.nodeName;
    }
}
