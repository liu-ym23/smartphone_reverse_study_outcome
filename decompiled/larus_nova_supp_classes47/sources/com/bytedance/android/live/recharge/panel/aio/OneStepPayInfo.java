package com.bytedance.android.live.recharge.panel.aio;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/OneStepPayInfo;", "", "", "isSupportOneStepPay", "Z", "()Z", "b", "(Z)V", "", "oneStepPayType", "I", "getOneStepPayType", "()I", "a", "(I)V", "<init>", "()V", "OneStepPayType", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.panel.OneStepPayInfo")
public final class OneStepPayInfo {

    @SerializedName("is_support_one_step_pay")
    private boolean isSupportOneStepPay;

    @SerializedName("one_step_pay_type")
    private int oneStepPayType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/OneStepPayInfo$OneStepPayType;", "", "", "type", "I", "getType", "()I", "UNKNOWN", "NEW_STYLE", "ONE_STEP", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcEnum(messageName = "webcast.revenue.biz.recharge.panel.OneStepPayInfo.OneStepPayType")
    public static final enum OneStepPayType extends Enum<OneStepPayType> {
        public static final OneStepPayType NEW_STYLE = null;
        public static final OneStepPayType ONE_STEP = null;
        public static final OneStepPayType UNKNOWN = null;
        public static final /* synthetic */ OneStepPayType[] a = null;
        private final int type;

        static {
            OneStepPayType r1 = new OneStepPayType("UNKNOWN", 0, 0);
            UNKNOWN = r1;
            OneStepPayType r2 = new OneStepPayType("NEW_STYLE", 1, 1);
            NEW_STYLE = r2;
            OneStepPayType r3 = new OneStepPayType("ONE_STEP", 2, 2);
            ONE_STEP = r3;
            a = new OneStepPayType[]{r1, r2, r3};
        }

        public static OneStepPayType valueOf(String r1) {
            return (OneStepPayType) a.a(OneStepPayType.class, r1);
        }

        public static OneStepPayType[] values() {
            return (OneStepPayType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public OneStepPayType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public OneStepPayInfo() {
        this.oneStepPayType = OneStepPayType.UNKNOWN.getType();
    }

    public final void a(int r1) {
        this.oneStepPayType = r1;
    }

    public final void b(boolean r1) {
        this.isSupportOneStepPay = r1;
    }
}
