package nu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/settings/provider/dora/HardwarePlayerConfig;", "", "<init>", "()V", "doraGHardwarePlayEnabled", "", "getDoraGHardwarePlayEnabled", "()Z", "setDoraGHardwarePlayEnabled", "(Z)V", "loryBHardwarePlayEnabled", "getLoryBHardwarePlayEnabled", "setLoryBHardwarePlayEnabled", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class v {

    @SerializedName("dora_g_hardware_play_enabled")
    private boolean doraGHardwarePlayEnabled;

    @SerializedName("lory_b_hardware_play_enabled")
    private boolean loryBHardwarePlayEnabled;

    public v() {
    }

    public final boolean a() {
        return this.doraGHardwarePlayEnabled;
    }
}
