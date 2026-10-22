package com.larus.settings.provider.dora;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/provider/dora/WakeupComfortConfig;", "", "wakeupComfortEnable", "", "wakeupComfortStyle", "", "wakeupNoneOneshotVadendDelay", "", "wakeupResponseCancelCutoffMs", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getWakeupComfortEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWakeupComfortStyle", "()Ljava/lang/String;", "getWakeupNoneOneshotVadendDelay", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWakeupResponseCancelCutoffMs", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class WakeupComfortConfig {

    @SerializedName("wakeup_comfort_enable")
    private final Boolean wakeupComfortEnable;

    @SerializedName("wakeup_comfort_style")
    private final String wakeupComfortStyle;

    @SerializedName("wakeup_none_oneshot_vadend_delay")
    private final Long wakeupNoneOneshotVadendDelay;

    @SerializedName("wakeup_response_cancel_cutoff_ms")
    private final Long wakeupResponseCancelCutoffMs;

    public WakeupComfortConfig() {
        this(null, null, null, null, 15, null);
    }

    public final Boolean getWakeupComfortEnable() {
        return this.wakeupComfortEnable;
    }

    public final String getWakeupComfortStyle() {
        return this.wakeupComfortStyle;
    }

    public final Long getWakeupNoneOneshotVadendDelay() {
        return this.wakeupNoneOneshotVadendDelay;
    }

    public final Long getWakeupResponseCancelCutoffMs() {
        return this.wakeupResponseCancelCutoffMs;
    }

    public WakeupComfortConfig(Boolean r1, String r2, Long r3, Long r4) {
        this.wakeupComfortEnable = r1;
        this.wakeupComfortStyle = r2;
        this.wakeupNoneOneshotVadendDelay = r3;
        this.wakeupResponseCancelCutoffMs = r4;
    }

    public /* synthetic */ WakeupComfortConfig(Boolean r3, String r4, Long r5, Long r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = Boolean.TRUE;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = "请你用比较正常平和、友好、有精神的语气、语调、语速说，表达方式轻一些";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 630L;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 2000L;
    L14:
        this(r3, r4, r5, r6);
    }
}
