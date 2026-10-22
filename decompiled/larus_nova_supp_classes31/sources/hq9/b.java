package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/platform/model/AISDKConfig;", "", "initWhenShowWidget", "", "ugcBot", "", "<init>", "(ZLjava/lang/String;)V", "getInitWhenShowWidget", "()Z", "getUgcBot", "()Ljava/lang/String;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b {

    @SerializedName("init_when_show_widget")
    private final boolean initWhenShowWidget;

    @SerializedName("ugc_bot")
    private final String ugcBot;

    public b() {
        this(0);
    }

    public final boolean a() {
        return this.initWhenShowWidget;
    }

    public final String b() {
        return this.ugcBot;
    }

    public b(int r1) {
        this.initWhenShowWidget = true;
        this.ugcBot = "7626957768951480347";
    }
}
