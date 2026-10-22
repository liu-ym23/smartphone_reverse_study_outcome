package fv1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lfv1/a;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "delayForDraw", "J", "b", "()J", "delayForClick", "a", "<init>", "()V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("delay_for_click")
    private final long delayForClick;

    @SerializedName("delay_for_draw")
    private final long delayForDraw;

    @SerializedName("enable")
    private boolean enable;

    public a() {
        this.delayForDraw = 10;
        this.delayForClick = 3;
    }

    public final long a() {
        return this.delayForClick;
    }

    public final long b() {
        return this.delayForDraw;
    }

    public final boolean c() {
        return this.enable;
    }
}
