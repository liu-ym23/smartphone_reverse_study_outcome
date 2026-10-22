package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/InputConstantNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "nodeName", "Ljava/lang/String;", "getNodeName", "()Ljava/lang/String;", "InputLoadTime", "InputPrepareViewTime", "InputShowCostTime", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputConstantNode extends Enum<InputConstantNode> {
    public static final InputConstantNode InputLoadTime = null;
    public static final InputConstantNode InputPrepareViewTime = null;
    public static final InputConstantNode InputShowCostTime = null;
    public static final /* synthetic */ InputConstantNode[] a = null;
    private final String nodeName;

    static {
        InputConstantNode r1 = new InputConstantNode("InputLoadTime", 0, "input_load_cost_time");
        InputLoadTime = r1;
        InputConstantNode r2 = new InputConstantNode("InputPrepareViewTime", 1, "input_prepare_view_cost_time");
        InputPrepareViewTime = r2;
        InputConstantNode r3 = new InputConstantNode("InputShowCostTime", 2, "input_show_cost_time");
        InputShowCostTime = r3;
        a = new InputConstantNode[]{r1, r2, r3};
    }

    public static InputConstantNode valueOf(String r1) {
        return (InputConstantNode) a.a(InputConstantNode.class, r1);
    }

    public static InputConstantNode[] values() {
        return (InputConstantNode[]) a.clone();
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public InputConstantNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.nodeName = r3;
    }
}
