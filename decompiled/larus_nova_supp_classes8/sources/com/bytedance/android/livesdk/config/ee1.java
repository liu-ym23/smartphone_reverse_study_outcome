package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/config/ee1;", "", "", "enable", "Z", "b", "()Z", "", "", "entranceSource", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "loadMoreCount", "I", "e", "()I", "directEventNotify", "getDirectEventNotify", "ignoreCheck", "getIgnoreCheck", "requestStyle", "g", "enableWillShow", "c", "personalizeStopSwitch", "f", "aheadOfRoom", "a", "showInTouch", "h", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ee1 {

    @SerializedName("ahead_of_room")
    private final boolean aheadOfRoom;

    @SerializedName("direct_event_notify")
    private final boolean directEventNotify;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("will_show_enable")
    private final boolean enableWillShow;

    @SerializedName("entrance_source")
    private final List<String> entranceSource;

    @SerializedName("ignore_check")
    private final boolean ignoreCheck;

    @SerializedName("max_loadmore_count")
    private final int loadMoreCount;

    @SerializedName("personalize_stop_opt")
    private final boolean personalizeStopSwitch;

    @SerializedName("request_style")
    private final int requestStyle;

    @SerializedName("show_in_touch")
    private final boolean showInTouch;

    public ee1() {
        this.entranceSource = CollectionsKt.emptyList();
        this.loadMoreCount = -1;
        this.ignoreCheck = true;
        this.enableWillShow = true;
    }

    public final boolean a() {
        return this.aheadOfRoom;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableWillShow;
    }

    public final List<String> d() {
        return this.entranceSource;
    }

    public final int e() {
        return this.loadMoreCount;
    }

    public final boolean f() {
        return this.personalizeStopSwitch;
    }

    public final int g() {
        return this.requestStyle;
    }

    public final boolean h() {
        return this.showInTouch;
    }
}
