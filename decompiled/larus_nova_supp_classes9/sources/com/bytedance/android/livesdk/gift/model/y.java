package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GameGiftData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/y;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/y$b;", "monkeyGameData", "Lcom/bytedance/android/livesdk/gift/model/y$b;", "getMonkeyGameData", "()Lcom/bytedance/android/livesdk/gift/model/y$b;", "setMonkeyGameData", "(Lcom/bytedance/android/livesdk/gift/model/y$b;)V", "<init>", "()V", "a", "b", "c", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y implements vh7.h {

    @SerializedName("data")
    protected b monkeyGameData;

    public static final class a {
    }

    @ProtoMessage("webcast.data.GameGiftData.MonkeyData")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R*\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/y$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "addend", "I", "getAddend", "()I", "setAddend", "(I)V", "bestScore", "getBestScore", "setBestScore", BuildConfig.FLAVOR, "bestUser", "Ljava/lang/String;", "getBestUser", "()Ljava/lang/String;", "setBestUser", "(Ljava/lang/String;)V", "bestScoreSelf", "getBestScoreSelf", "setBestScoreSelf", "multiplier", "getMultiplier", "setMultiplier", BuildConfig.FLAVOR, "seed", "J", "getSeed", "()J", "setSeed", "(J)V", "token", "getToken", "setToken", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/y$c;", "rangeDataList", "Ljava/util/List;", "getRangeDataList", "()Ljava/util/List;", "setRangeDataList", "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("addend")
        protected int addend;

        @SerializedName("anchor_rank_best_score")
        protected int bestScore;

        @SerializedName("best_score_self")
        protected int bestScoreSelf;

        @SerializedName("anchor_rank_best_user_name")
        protected String bestUser;

        @SerializedName("multiplier")
        protected int multiplier;

        @SerializedName("rangeMap")
        protected List<c> rangeDataList;

        @SerializedName("seed")
        protected long seed;

        @SerializedName("token")
        protected String token;

        public b() {
        }

        public b(am3.g r5) {
            this.rangeDataList = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L15;
            switch(r2) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            this.bestScoreSelf = r5.i();
            goto L3
        L8:
            this.bestScore = r5.i();
            goto L3
        L9:
            this.bestUser = am3.h.c(r5);
            goto L3
        L10:
            this.rangeDataList.add(new c(r5));
            goto L3
        L11:
            this.token = am3.h.c(r5);
            goto L3
        L12:
            this.seed = r5.i();
            goto L3
        L13:
            this.addend = r5.i();
            goto L3
        L14:
            this.multiplier = r5.i();
            goto L3
        L6:
            am3.h.e(r5);
            goto L3
        L15:
            r5.d(r0);
        }
    }

    @ProtoMessage("webcast.data.GameGiftData.MonkeyData.Range")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/y$c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "max", "I", "getMax", "()I", "setMax", "(I)V", "min", "getMin", "setMin", "result", "getResult", "setResult", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("max")
        protected int max;

        @SerializedName("min")
        protected int min;

        @SerializedName("result")
        protected int result;

        public c() {
        }

        public c(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            this.min = r5.i();
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.max = r5.i();
            goto L3
        L10:
            if (r2 != 3) goto L11;
            this.result = r5.i();
            goto L3
        L11:
            am3.h.e(r5);
            goto L3
        L15:
            r5.d(r0);
        }

        public final void setResult(int r1) {
            this.result = r1;
        }
    }

    static {
    }

    public y() {
    }

    public y(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.monkeyGameData = new b(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
