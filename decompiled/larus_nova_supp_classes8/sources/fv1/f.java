package fv1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00064"}, d2 = {"Lfv1/f;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "topSpeedNotesSchema", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "setTopSpeedNotesSchema", "(Ljava/lang/String;)V", "isOpenByDefault", "j", "setOpenByDefault", "", "stableDays", "J", "e", "()J", "setStableDays", "(J)V", "toastStableDays", "g", "setToastStableDays", "guideDesc", "c", "setGuideDesc", "isShowOptText", "l", "setShowOptText", "enableTrace", "b", "setEnableTrace", "pushOpt", "d", "setPushOpt", "topSpeedModeOpt", "h", "setTopSpeedModeOpt", "toastLimit", "f", "setToastLimit", "isShowBubble", "k", "setShowBubble", "<init>", "()V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_trace")
    private boolean enableTrace;

    @SerializedName("guide_desc")
    private String guideDesc;

    @SerializedName("is_open_by_default")
    private boolean isOpenByDefault;

    @SerializedName("is_show_bubble")
    private boolean isShowBubble;

    @SerializedName("is_show_opt_text")
    private boolean isShowOptText;

    @SerializedName("push_opt")
    private boolean pushOpt;

    @SerializedName("stable_days")
    private long stableDays;

    @SerializedName("toast_limit")
    private boolean toastLimit;

    @SerializedName("toast_stable_days")
    private long toastStableDays;

    @SerializedName("topspeed_mode_opt")
    private boolean topSpeedModeOpt;

    @SerializedName("top_speed_notes_schema")
    private String topSpeedNotesSchema;

    public f() {
        this.stableDays = 3;
        this.toastStableDays = 3;
        this.isShowOptText = true;
        this.enableTrace = true;
        this.pushOpt = true;
        this.toastLimit = true;
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableTrace;
    }

    public final String c() {
        return this.guideDesc;
    }

    public final boolean d() {
        return this.pushOpt;
    }

    public final long e() {
        return this.stableDays;
    }

    public final boolean f() {
        return this.toastLimit;
    }

    public final long g() {
        return this.toastStableDays;
    }

    public final boolean h() {
        return this.topSpeedModeOpt;
    }

    public final String i() {
        return this.topSpeedNotesSchema;
    }

    public final boolean j() {
        return this.isOpenByDefault;
    }

    public final boolean k() {
        return this.isShowBubble;
    }

    public final boolean l() {
        return this.isShowOptText;
    }
}
