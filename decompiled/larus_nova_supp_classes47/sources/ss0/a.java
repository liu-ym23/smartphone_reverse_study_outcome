package ss0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b3\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00065"}, d2 = {"Lss0/a;", "", "", "enableFollowNinePng", "Z", "e", "()Z", "setEnableFollowNinePng", "(Z)V", "enableFollowWebp", "f", "setEnableFollowWebp", "enableShopPaint", "l", "setEnableShopPaint", "enableOldShopPaint", "g", "setEnableOldShopPaint", "enableBackgroundWebp", "getEnableBackgroundWebp", "setEnableBackgroundWebp", "enableExtendTopBorder", "d", "setEnableExtendTopBorder", "enableEnterAnimation", "a", "setEnableEnterAnimation", "enableExitAnimation", "c", "setEnableExitAnimation", "enableWebpOpt", "m", "setEnableWebpOpt", "enableWebpPlaceholderOpt", "n", "setEnableWebpPlaceholderOpt", "enablePrepareWebpOpt", "k", "setEnablePrepareWebpOpt", "enablePanelEnterEffect", "h", "setEnablePanelEnterEffect", "enablePanelLoopEffect", "j", "setEnablePanelLoopEffect", "enablePanelExitEffect", "i", "setEnablePanelExitEffect", "enableExistResourceFromDressId", "b", "setEnableExistResourceFromDressId", "<init>", "()V", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable_background_webp")
    private boolean enableBackgroundWebp;

    @SerializedName("enable_enter_animation")
    private boolean enableEnterAnimation;

    @SerializedName("enable_exist_resource_from_dressid")
    private boolean enableExistResourceFromDressId;

    @SerializedName("enable_exit_animation")
    private boolean enableExitAnimation;

    @SerializedName("enable_extend_top_border")
    private boolean enableExtendTopBorder;

    @SerializedName("enable_follow_nine_png")
    private boolean enableFollowNinePng;

    @SerializedName("enable_follow_webp")
    private boolean enableFollowWebp;

    @SerializedName("enable_old_shop_paint")
    private boolean enableOldShopPaint;

    @SerializedName("enable_panel_enter_effect")
    private boolean enablePanelEnterEffect;

    @SerializedName("enable_panel_exit_effect")
    private boolean enablePanelExitEffect;

    @SerializedName("enable_panel_loop_effect")
    private boolean enablePanelLoopEffect;

    @SerializedName("enable_prepare_webp_opt")
    private boolean enablePrepareWebpOpt;

    @SerializedName("enable_shop_paint")
    private boolean enableShopPaint;

    @SerializedName("enable_webp_opt")
    private boolean enableWebpOpt;

    @SerializedName("enable_webp_placeholder_opt")
    private boolean enableWebpPlaceholderOpt;

    public a() {
        this.enableFollowNinePng = true;
        this.enableFollowWebp = true;
        this.enableShopPaint = true;
        this.enableOldShopPaint = true;
        this.enableBackgroundWebp = true;
        this.enableExtendTopBorder = true;
        this.enableEnterAnimation = true;
        this.enableExitAnimation = true;
        this.enableWebpOpt = true;
        this.enableWebpPlaceholderOpt = true;
        this.enablePrepareWebpOpt = true;
        this.enablePanelEnterEffect = true;
        this.enablePanelLoopEffect = true;
        this.enablePanelExitEffect = true;
        this.enableExistResourceFromDressId = true;
    }

    public final boolean a() {
        return this.enableEnterAnimation;
    }

    public final boolean b() {
        return this.enableExistResourceFromDressId;
    }

    public final boolean c() {
        return this.enableExitAnimation;
    }

    public final boolean d() {
        return this.enableExtendTopBorder;
    }

    public final boolean e() {
        return this.enableFollowNinePng;
    }

    public final boolean f() {
        return this.enableFollowWebp;
    }

    public final boolean g() {
        return this.enableOldShopPaint;
    }

    public final boolean h() {
        return this.enablePanelEnterEffect;
    }

    public final boolean i() {
        return this.enablePanelExitEffect;
    }

    public final boolean j() {
        return this.enablePanelLoopEffect;
    }

    public final boolean k() {
        return this.enablePrepareWebpOpt;
    }

    public final boolean l() {
        return this.enableShopPaint;
    }

    public final boolean m() {
        return this.enableWebpOpt;
    }

    public final boolean n() {
        return this.enableWebpPlaceholderOpt;
    }
}
