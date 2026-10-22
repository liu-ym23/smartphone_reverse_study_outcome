package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.luckyBox.LuckyBoxStatus")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/LuckyBoxStatus;", "", "LuckyBoxStatusUnknow", "LuckyBoxStatusCountDown", "LuckyBoxStatusReady", "LuckyBoxStatusBlock", "LuckyBoxStatusGamedraw", "LuckyBoxStatusExpired", "LuckyBoxStatusEnd", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LuckyBoxStatus extends Enum<LuckyBoxStatus> {
    public static final LuckyBoxStatus LuckyBoxStatusBlock = null;
    public static final LuckyBoxStatus LuckyBoxStatusCountDown = null;
    public static final LuckyBoxStatus LuckyBoxStatusEnd = null;
    public static final LuckyBoxStatus LuckyBoxStatusExpired = null;
    public static final LuckyBoxStatus LuckyBoxStatusGamedraw = null;
    public static final LuckyBoxStatus LuckyBoxStatusReady = null;
    public static final LuckyBoxStatus LuckyBoxStatusUnknow = null;
    public static final /* synthetic */ LuckyBoxStatus[] a = null;

    static {
        LuckyBoxStatus r1 = new LuckyBoxStatus("LuckyBoxStatusUnknow", 0);
        LuckyBoxStatusUnknow = r1;
        LuckyBoxStatus r2 = new LuckyBoxStatus("LuckyBoxStatusCountDown", 1);
        LuckyBoxStatusCountDown = r2;
        LuckyBoxStatus r3 = new LuckyBoxStatus("LuckyBoxStatusReady", 2);
        LuckyBoxStatusReady = r3;
        LuckyBoxStatus r4 = new LuckyBoxStatus("LuckyBoxStatusBlock", 3);
        LuckyBoxStatusBlock = r4;
        LuckyBoxStatus r5 = new LuckyBoxStatus("LuckyBoxStatusGamedraw", 4);
        LuckyBoxStatusGamedraw = r5;
        LuckyBoxStatus r6 = new LuckyBoxStatus("LuckyBoxStatusExpired", 5);
        LuckyBoxStatusExpired = r6;
        LuckyBoxStatus r7 = new LuckyBoxStatus("LuckyBoxStatusEnd", 6);
        LuckyBoxStatusEnd = r7;
        a = new LuckyBoxStatus[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static LuckyBoxStatus valueOf(String r1) {
        return (LuckyBoxStatus) r27.a.a(LuckyBoxStatus.class, r1);
    }

    public static LuckyBoxStatus[] values() {
        return (LuckyBoxStatus[]) a.clone();
    }

    public LuckyBoxStatus(String r1, int r2) {
        super(r1, r2);
    }
}
