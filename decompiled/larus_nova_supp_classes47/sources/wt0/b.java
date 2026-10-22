package wt0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lwt0/b;", "", "", "goldCoinOhrPredictEnable", "Z", "getGoldCoinOhrPredictEnable", "()Z", "setGoldCoinOhrPredictEnable", "(Z)V", "ohrResultRealTime", "getOhrResultRealTime", "setOhrResultRealTime", "", "goldCoinPosOpt", "I", "getGoldCoinPosOpt", "()I", "setGoldCoinPosOpt", "(I)V", "<init>", "()V", "a", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("gold_coin_ohr_enable")
    private boolean goldCoinOhrPredictEnable;

    @SerializedName("gold_coin_pos_opt")
    private int goldCoinPosOpt;

    @SerializedName("gold_coin_ohr_realtime")
    private boolean ohrResultRealTime;

    public static final class a {
    }

    static {
    }

    public b() {
        this.ohrResultRealTime = true;
    }
}
