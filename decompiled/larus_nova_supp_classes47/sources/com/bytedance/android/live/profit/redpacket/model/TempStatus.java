package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.luckyBox.TempStatus")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/TempStatus;", "", "", "typeIndex", "I", "getTypeIndex", "()I", "Companion", "a", "TempStatusUnknown", "TempStatusSingle", "TempStatusHot", "TempStatusCountDown", "TempStatusManualHost", "TempStatusEnter", "TempStatusInterest", "TempStatusBehavior", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TempStatus extends Enum<TempStatus> {
    public static final a Companion = null;
    public static final TempStatus TempStatusBehavior = null;
    public static final TempStatus TempStatusCountDown = null;
    public static final TempStatus TempStatusEnter = null;
    public static final TempStatus TempStatusHot = null;
    public static final TempStatus TempStatusInterest = null;
    public static final TempStatus TempStatusManualHost = null;
    public static final TempStatus TempStatusSingle = null;
    public static final TempStatus TempStatusUnknown = null;
    public static final /* synthetic */ TempStatus[] a = null;
    private final int typeIndex;

    public static TempStatus valueOf(String r1) {
        return (TempStatus) r27.a.a(TempStatus.class, r1);
    }

    public static TempStatus[] values() {
        return (TempStatus[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.redpacket.model.TempStatus$a] */
    static {
        TempStatus r1 = new TempStatus("TempStatusUnknown", 0, 0);
        TempStatusUnknown = r1;
        TempStatus r2 = new TempStatus("TempStatusSingle", 1, 1);
        TempStatusSingle = r2;
        TempStatus r3 = new TempStatus("TempStatusHot", 2, 2);
        TempStatusHot = r3;
        TempStatus r4 = new TempStatus("TempStatusCountDown", 3, 3);
        TempStatusCountDown = r4;
        TempStatus r5 = new TempStatus("TempStatusManualHost", 4, 4);
        TempStatusManualHost = r5;
        TempStatus r6 = new TempStatus("TempStatusEnter", 5, 5);
        TempStatusEnter = r6;
        TempStatus r7 = new TempStatus("TempStatusInterest", 6, 6);
        TempStatusInterest = r7;
        TempStatus r8 = new TempStatus("TempStatusBehavior", 7, 7);
        TempStatusBehavior = r8;
        a = new TempStatus[]{r1, r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    public final int getTypeIndex() {
        return this.typeIndex;
    }

    public TempStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.typeIndex = r3;
    }
}
