package com.bytedance.android.live.recharge.panel.aio;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.recharge.panel.CustomPanelMode")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/CustomPanelMode;", "", "", "mode", "I", "getMode", "()I", "UNKNOWN", "RECHARGE", "INPUT", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CustomPanelMode extends Enum<CustomPanelMode> {
    public static final CustomPanelMode INPUT = null;
    public static final CustomPanelMode RECHARGE = null;
    public static final CustomPanelMode UNKNOWN = null;
    public static final /* synthetic */ CustomPanelMode[] a = null;
    private final int mode;

    static {
        CustomPanelMode r1 = new CustomPanelMode("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        CustomPanelMode r2 = new CustomPanelMode("RECHARGE", 1, 1);
        RECHARGE = r2;
        CustomPanelMode r3 = new CustomPanelMode("INPUT", 2, 2);
        INPUT = r3;
        a = new CustomPanelMode[]{r1, r2, r3};
    }

    public static CustomPanelMode valueOf(String r1) {
        return (CustomPanelMode) a.a(CustomPanelMode.class, r1);
    }

    public static CustomPanelMode[] values() {
        return (CustomPanelMode[]) a.clone();
    }

    public final int getMode() {
        return this.mode;
    }

    public CustomPanelMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mode = r3;
    }
}
