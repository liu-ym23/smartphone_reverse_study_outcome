package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b>\u0010?R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR*\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR*\u0010<\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u000109j\n\u0012\u0004\u0012\u00020:\u0018\u0001`;8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lls1/m;", "", "", "predictEnable", "Z", "getPredictEnable", "()Z", "setPredictEnable", "(Z)V", "", "predictInterval", "J", "f", "()J", "setPredictInterval", "(J)V", "strategyOptEnable", "k", "setStrategyOptEnable", "strategyOptBackupEnable", "j", "setStrategyOptBackupEnable", "preloadInterval", "h", "setPreloadInterval", "allRoomPreloadInterval", "b", "setAllRoomPreloadInterval", "preloadEnable", "g", "setPreloadEnable", "", "", "predictEnableIndexList", "Ljava/util/List;", "e", "()Ljava/util/List;", "setPredictEnableIndexList", "(Ljava/util/List;)V", "runEventEnable", "i", "setRunEventEnable", "clickPredictEnable", "c", "setClickPredictEnable", "clickRefreshEnable", "d", "setClickRefreshEnable", "registerMessageHandlerEnable", "getRegisterMessageHandlerEnable", "setRegisterMessageHandlerEnable", "allNameEnable", "a", "setAllNameEnable", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "runEventList", "Ljava/util/ArrayList;", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("all_enter_name_enable")
    private boolean allNameEnable;

    @SerializedName("all_room_preload_interval")
    private long allRoomPreloadInterval;

    @SerializedName("click_predict_enable")
    private boolean clickPredictEnable;

    @SerializedName("click_refresh_enable")
    private boolean clickRefreshEnable;

    @SerializedName("predict_enable")
    private boolean predictEnable;

    @SerializedName("predict_enable_index_list")
    private List<Integer> predictEnableIndexList;

    @SerializedName("predict_interval")
    private long predictInterval;

    @SerializedName("preload_enable")
    private boolean preloadEnable;

    @SerializedName("preload_interval")
    private long preloadInterval;

    @SerializedName("register_message_handler_enable")
    private boolean registerMessageHandlerEnable;

    @SerializedName("run_event_enable")
    private boolean runEventEnable;

    @SerializedName("run_event_list")
    public ArrayList<String> runEventList;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    @SerializedName("strategy_opt_backup_enable")
    private boolean strategyOptBackupEnable;

    @SerializedName("strategy_opt_enable")
    private boolean strategyOptEnable;

    public m() {
        this.predictInterval = 3000;
        this.registerMessageHandlerEnable = true;
        this.runEventList = new ArrayList();
    }

    public final boolean a() {
        return this.allNameEnable;
    }

    public final long b() {
        return this.allRoomPreloadInterval;
    }

    public final boolean c() {
        return this.clickPredictEnable;
    }

    public final boolean d() {
        return this.clickRefreshEnable;
    }

    public final List<Integer> e() {
        return this.predictEnableIndexList;
    }

    public final long f() {
        return this.predictInterval;
    }

    public final boolean g() {
        return this.preloadEnable;
    }

    public final long h() {
        return this.preloadInterval;
    }

    public final boolean i() {
        return this.runEventEnable;
    }

    public final boolean j() {
        return this.strategyOptBackupEnable;
    }

    public final boolean k() {
        return this.strategyOptEnable;
    }
}
