package com.bytedance.android.live.profit.lottery;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u extends com.bytedance.ies.web.jsbridge2.f<a, Object> {
    public final com.bytedance.live.datacontext.k<Unit> a;
    public final LotteryState b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/u$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "lotteryId", "a", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("lotteryId")
        private final String lotteryId;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.lotteryId, r4.lotteryId) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.lotteryId;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", lotteryId=" + this.lotteryId + ")";
        }

        public final String a() {
            return this.lotteryId;
        }

        public final String getType() {
            return this.type;
        }
    }

    public final void onTerminate() {
    }

    public u(com.bytedance.live.datacontext.k<Unit> r2, LotteryState r3) {
        Intrinsics.checkNotNullParameter(r2, "onSubmit");
        this.a = r2;
        this.b = r3;
    }

    public final void invoke(Object r7, CallContext r8) {
        a r9 = (a) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        String r10 = r9.getType();
        JsonObject r1 = null;
        switch(r10.hashCode()) {
            case -1559401418: goto L33;
            case -990193242: goto L30;
            case 190538204: goto L16;
            case 1938485734: goto L6;
            default: goto L50;
        };
    L50:
        finishWithFailure();
        return;
    L6:
        if (r10.equals("get_lottery_left_time") == false) goto L50;
        JsonObject r12 = this.b;
        if ((r12 instanceof LotteryState.g) == false) goto L11;
        r1 = r12;
    L11:
        LotteryState.g r2 = (LotteryState.g) r1;
        long r13 = 0;
        if (r2 == null) goto L14;
        r13 = Math.max(r2.a.c - System.currentTimeMillis(), 0);
    L14:
        JsonObject r0 = new JsonObject();
        r0.add("timeLeft", new JsonPrimitive(String.valueOf(r13)));
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r0);
        return;
    L16:
        if (r10.equals("get_lottery_result") == false) goto L50;
        JsonObject r15 = new JsonObject();
        LotteryState r16 = this.b;
        if ((r16 instanceof LotteryState.b) == true) goto L20;
        r16 = null;
    L20:
        LotteryState.b r17 = (LotteryState.b) r16;
        if (r17 == null) goto L25;
        p0 r18 = r17.b;
        if (r18 == null) goto L25;
        r1 = r18.d;
    L25:
        if (r1 != null) goto L28;
        r1 = JsonNull.INSTANCE;
    L28:
        r15.add(Constants.Keys.DATA, r1);
        finishWithResult(r15);
        return;
    L30:
        if (r10.equals("anchor_submit_success") == false) goto L50;
        this.a.post(Unit.INSTANCE);
        finishWithSuccess();
        return;
    L33:
        if (r10.equals("get_result_extra_info") == false) goto L50;
        String r19 = r9.a();
        String r20 = "";
        if (r19 != null) goto L37;
        r19 = "";
    L37:
        ALogger.i("LotteryActionMethod", "from get_result_extra_info  lotteryId = ".concat(r19));
        JsonObject r3 = new JsonObject();
        if (TextUtils.isEmpty(r19) == true) goto L49;
        Map<String, String> r4 = b1.a;
        Intrinsics.checkNotNullParameter(r19, "key");
        Map<String, String> r5 = b1.a;
        if (r5.containsKey(r19) == false) goto L49;
        Intrinsics.checkNotNullParameter(r19, "key");
        String r6 = (String) ((LinkedHashMap) r5).get(r19);
        if (r6 != null) goto L44;
        r6 = "";
    L44:
        r3.add("resultExtraInfo", new JsonPrimitive(r6));
        StringBuilder r22 = new StringBuilder("result  lotteryId = ");
        r22.append(r19);
        r22.append("   resultExtraInfo = ");
        Intrinsics.checkNotNullParameter(r19, "key");
        String r23 = (String) ((LinkedHashMap) r5).get(r19);
        if (r23 == null) goto L48;
        r20 = r23;
    L48:
        r22.append(r20);
        ALogger.i("LotteryActionMethod", r22.toString());
    L49:
        ((LinkedHashMap) b1.a).clear();
        finishWithResult(r3);
    }
}
