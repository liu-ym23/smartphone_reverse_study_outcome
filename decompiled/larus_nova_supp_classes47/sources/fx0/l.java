package fx0;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lfx0/l$a;", "", "", "previousGiftId", "J", "c", "()J", "previousGiftMoney", "d", "previousPayMoney", "f", "moneyDiff", "b", "", "previousGiftType", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "availableDiamond", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("diamond")
        private final long availableDiamond;

        @SerializedName("money_diff")
        private final long moneyDiff;

        @SerializedName("previous_gift_id")
        private final long previousGiftId;

        @SerializedName("previous_gift_money")
        private final long previousGiftMoney;

        @SerializedName("previous_gift_type")
        private final String previousGiftType;

        @SerializedName("previous_pay_money")
        private final long previousPayMoney;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L18;
            a r7 = (a) r6;
            if (this.previousGiftId == r7.previousGiftId) goto L8;
            return false;
        L8:
            if (this.previousGiftMoney == r7.previousGiftMoney) goto L10;
            return false;
        L10:
            if (this.previousPayMoney == r7.previousPayMoney) goto L12;
            return false;
        L12:
            if (this.moneyDiff == r7.moneyDiff) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.previousGiftType, r7.previousGiftType) == true) goto L16;
            return false;
        L16:
            if (this.availableDiamond == r7.availableDiamond) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            long r0 = this.previousGiftId;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.previousGiftMoney;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r4 = this.previousPayMoney;
            int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            long r6 = this.moneyDiff;
            int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
            String r8 = this.previousGiftType;
            if (r8 == null) goto L5;
            int r9 = r8.hashCode();
        L6:
            long r10 = this.availableDiamond;
            return ((r7 + r9) * 31) + ((int) (r10 ^ (r10 >>> 32)));
        L5:
            r9 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(previousGiftId=" + this.previousGiftId + ", previousGiftMoney=" + this.previousGiftMoney + ", previousPayMoney=" + this.previousPayMoney + ", moneyDiff=" + this.moneyDiff + ", previousGiftType=" + this.previousGiftType + ", availableDiamond=" + this.availableDiamond + ")";
        }

        public a() {
            Intrinsics.checkNotNullParameter("", "previousGiftType");
            this.previousGiftId = 0;
            this.previousGiftMoney = 0;
            this.previousPayMoney = 0;
            this.moneyDiff = 0;
            this.previousGiftType = "";
            this.availableDiamond = 0;
        }

        public final long a() {
            return this.availableDiamond;
        }

        public final long b() {
            return this.moneyDiff;
        }

        public final long c() {
            return this.previousGiftId;
        }

        public final long d() {
            return this.previousGiftMoney;
        }

        public final String e() {
            return this.previousGiftType;
        }

        public final long f() {
            return this.previousPayMoney;
        }
    }

    public final void onTerminate() {
    }

    public l() {
    }

    public final void invoke(Object r18, CallContext r19) {
        a r0 = (a) r18;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r19, "context");
        x2 r1 = new x2("", "", r0.c(), r0.d(), r0.f(), r0.b(), r0.e(), r0.a(), true);
        xs2.b.a().post(new HorizontalPlayEvent(1, "source_for_live_recharge", r1));
        finishWithSuccess();
    }
}
