package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.luckyBox.ResultType")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/ResultType;", "", "ResultTypeUnknown", "ResultTypeWin", "ResultTypeSurpriseWin", "ResultTypeNotWin", "ResultTypeEnd", "ResultTypeExpired", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ResultType extends Enum<ResultType> {
    public static final ResultType ResultTypeEnd = null;
    public static final ResultType ResultTypeExpired = null;
    public static final ResultType ResultTypeNotWin = null;
    public static final ResultType ResultTypeSurpriseWin = null;
    public static final ResultType ResultTypeUnknown = null;
    public static final ResultType ResultTypeWin = null;
    public static final /* synthetic */ ResultType[] a = null;

    static {
        ResultType r1 = new ResultType("ResultTypeUnknown", 0);
        ResultTypeUnknown = r1;
        ResultType r2 = new ResultType("ResultTypeWin", 1);
        ResultTypeWin = r2;
        ResultType r3 = new ResultType("ResultTypeSurpriseWin", 2);
        ResultTypeSurpriseWin = r3;
        ResultType r4 = new ResultType("ResultTypeNotWin", 3);
        ResultTypeNotWin = r4;
        ResultType r5 = new ResultType("ResultTypeEnd", 4);
        ResultTypeEnd = r5;
        ResultType r6 = new ResultType("ResultTypeExpired", 5);
        ResultTypeExpired = r6;
        a = new ResultType[]{r1, r2, r3, r4, r5, r6};
    }

    public static ResultType valueOf(String r1) {
        return (ResultType) r27.a.a(ResultType.class, r1);
    }

    public static ResultType[] values() {
        return (ResultType[]) a.clone();
    }

    public ResultType(String r1, int r2) {
        super(r1, r2);
    }
}
