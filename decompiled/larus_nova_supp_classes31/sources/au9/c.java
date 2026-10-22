package au9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/settings/provider/bot/BotCreateEntranceConfig;", "", "enable", "", "enableDiscoverEntrance", "enableSearchEntrance", "enableProfileEntrance", "botCreateDisableEnhance", "<init>", "(ZZZZZ)V", "getEnable", "()Z", "setEnable", "(Z)V", "getEnableDiscoverEntrance", "setEnableDiscoverEntrance", "getEnableSearchEntrance", "setEnableSearchEntrance", "getEnableProfileEntrance", "setEnableProfileEntrance", "getBotCreateDisableEnhance", "setBotCreateDisableEnhance", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class c {
    public static final c a = null;
    public static final c b = null;

    @SerializedName("bot_create_disable_enhance")
    private boolean botCreateDisableEnhance;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_discover_entrance")
    private boolean enableDiscoverEntrance;

    @SerializedName("enable_profile_entrance")
    private boolean enableProfileEntrance;

    @SerializedName("enable_search_entrance")
    private boolean enableSearchEntrance;

    public static final class a {
    }

    public c() {
        this(false, false, false, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (this.enableDiscoverEntrance == r6.enableDiscoverEntrance) goto L15;
        return false;
    L15:
        if (this.enableSearchEntrance == r6.enableSearchEntrance) goto L18;
        return false;
    L18:
        if (this.enableProfileEntrance == r6.enableProfileEntrance) goto L21;
        return false;
    L21:
        if (this.botCreateDisableEnhance == r6.botCreateDisableEnhance) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableDiscoverEntrance == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableSearchEntrance == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.enableProfileEntrance == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.botCreateDisableEnhance == true) goto L23;
        r1 = 1237;
    L23:
        return r8 + r1;
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BotCreateEntranceConfig(enable=" + this.enable + ", enableDiscoverEntrance=" + this.enableDiscoverEntrance + ", enableSearchEntrance=" + this.enableSearchEntrance + ", enableProfileEntrance=" + this.enableProfileEntrance + ", botCreateDisableEnhance=" + this.botCreateDisableEnhance + ')';
    }

    static {
        a = new c(true, true, true, 16);
        b = new c(false, false, false, 30);
    }

    public final boolean a() {
        return this.botCreateDisableEnhance;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableDiscoverEntrance;
    }

    public final boolean d() {
        return this.enableProfileEntrance;
    }

    public final boolean e() {
        return this.enableSearchEntrance;
    }

    public c(boolean r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this.enable = r3;
        this.enableDiscoverEntrance = false;
        this.enableSearchEntrance = r4;
        this.enableProfileEntrance = r5;
        this.botCreateDisableEnhance = false;
    }
}
