package n71;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Ln71/b;", "", "", "optEnable", "Ljava/lang/Boolean;", "g", "()Ljava/lang/Boolean;", "setOptEnable", "(Ljava/lang/Boolean;)V", "controlCardVisible", "c", "setControlCardVisible", "controlIntroduceCard", "e", "setControlIntroduceCard", "controlInteractiveCard", "d", "setControlInteractiveCard", "controlBanner", "b", "setControlBanner", "debug", "f", "setDebug", "traceEnable", "h", "setTraceEnable", "appLogEnable", "a", "setAppLogEnable", "", "traceSample", "D", "i", "()D", "setTraceSample", "(D)V", "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("app_log_enable")
    private Boolean appLogEnable;

    @SerializedName("control_banner")
    private Boolean controlBanner;

    @SerializedName("control_card_visible")
    private Boolean controlCardVisible;

    @SerializedName("control_interact_card")
    private Boolean controlInteractiveCard;

    @SerializedName("control_introduce_card")
    private Boolean controlIntroduceCard;

    @SerializedName("debug_mode")
    private Boolean debug;

    @SerializedName("opt_enable")
    private Boolean optEnable;

    @SerializedName("card_trace_enable")
    private Boolean traceEnable;

    @SerializedName("trace_sample")
    private double traceSample;

    public b() {
        Boolean r0 = Boolean.TRUE;
        this.optEnable = r0;
        this.controlCardVisible = r0;
        this.controlIntroduceCard = r0;
        this.controlInteractiveCard = r0;
        this.controlBanner = r0;
        Boolean r1 = Boolean.FALSE;
        this.debug = r1;
        this.traceEnable = r1;
        this.appLogEnable = r0;
        this.traceSample = 1.0E-5d;
    }

    public final Boolean a() {
        return this.appLogEnable;
    }

    public final Boolean b() {
        return this.controlBanner;
    }

    public final Boolean c() {
        return this.controlCardVisible;
    }

    public final Boolean d() {
        return this.controlInteractiveCard;
    }

    public final Boolean e() {
        return this.controlIntroduceCard;
    }

    public final Boolean f() {
        return this.debug;
    }

    public final Boolean g() {
        return this.optEnable;
    }

    public final Boolean h() {
        return this.traceEnable;
    }

    public final double i() {
        return this.traceSample;
    }
}
