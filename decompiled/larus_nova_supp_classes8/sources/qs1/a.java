package qs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\b¨\u00060"}, d2 = {"Lqs1/a;", "", "", "autoIntroEnabled", "Z", "getAutoIntroEnabled", "()Z", "setAutoIntroEnabled", "(Z)V", "allRoomAutoIntroEnabled", "getAllRoomAutoIntroEnabled", "setAllRoomAutoIntroEnabled", "", "enterRoomDelay", "I", "getEnterRoomDelay", "()I", "setEnterRoomDelay", "(I)V", "manualIntroInterval", "getManualIntroInterval", "setManualIntroInterval", "autoIntroInterval", "getAutoIntroInterval", "setAutoIntroInterval", "autoIntroMaxTimes", "getAutoIntroMaxTimes", "setAutoIntroMaxTimes", "manualShowDelayMilliseconds", "getManualShowDelayMilliseconds", "setManualShowDelayMilliseconds", "canIntroDownloadedApps", "getCanIntroDownloadedApps", "setCanIntroDownloadedApps", "sameShowingPriority", "getSameShowingPriority", "setSameShowingPriority", "showWhenIntroducingManually", "getShowWhenIntroducingManually", "setShowWhenIntroducingManually", "autoIntroWhenEnter", "getAutoIntroWhenEnter", "setAutoIntroWhenEnter", "showAutoIntroTag", "getShowAutoIntroTag", "setShowAutoIntroTag", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("all_room_auto_intro_enabled")
    private boolean allRoomAutoIntroEnabled;

    @SerializedName("auto_intro_enabled")
    private boolean autoIntroEnabled;

    @SerializedName("auto_intro_interval_seconds")
    private int autoIntroInterval;

    @SerializedName("auto_intro_max_times")
    private int autoIntroMaxTimes;

    @SerializedName("auto_intro_when_enter")
    private boolean autoIntroWhenEnter;

    @SerializedName("can_intro_downloaded_apps")
    private boolean canIntroDownloadedApps;

    @SerializedName("enter_room_delay_seconds")
    private int enterRoomDelay;

    @SerializedName("manual_intro_interval_seconds")
    private int manualIntroInterval;

    @SerializedName("manual_override_show_delay_milliseconds")
    private int manualShowDelayMilliseconds;

    @SerializedName("same_showing_priority")
    private boolean sameShowingPriority;

    @SerializedName("show_auto_intro_tag")
    private boolean showAutoIntroTag;

    @SerializedName("show_when_introducing_manually")
    private boolean showWhenIntroducingManually;

    public a() {
        this.enterRoomDelay = 100;
        this.manualIntroInterval = 5;
        this.autoIntroInterval = 360;
        this.autoIntroMaxTimes = 100;
        this.manualShowDelayMilliseconds = 300;
        this.canIntroDownloadedApps = true;
        this.sameShowingPriority = true;
    }
}
