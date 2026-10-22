package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/platform/model/chat/NexPulseDialogConfig;", "", "chatPageTimeLimit", "", "chatMonitorTimeLimit", "enableUserInteractionIntercept", "", "dismissWhenBackground", "enableSwipeDownClose", "pauseVideoWhenDragging", "<init>", "(JJZZZZ)V", "getChatPageTimeLimit", "()J", "getChatMonitorTimeLimit", "getEnableUserInteractionIntercept", "()Z", "getDismissWhenBackground", "getEnableSwipeDownClose", "getPauseVideoWhenDragging", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class j0 {

    @SerializedName("chat_monitor_time_limit")
    private final long chatMonitorTimeLimit;

    @SerializedName("chat_page_time_limit")
    private final long chatPageTimeLimit;

    @SerializedName("dismiss_when_background")
    private final boolean dismissWhenBackground;

    @SerializedName("enable_swipe_down_close")
    private final boolean enableSwipeDownClose;

    @SerializedName("enable_user_interaction_intercept")
    private final boolean enableUserInteractionIntercept;

    @SerializedName("pause_video_when_dragging")
    private final boolean pauseVideoWhenDragging;

    public j0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r9 = (j0) r8;
        if (this.chatPageTimeLimit == r9.chatPageTimeLimit) goto L12;
        return false;
    L12:
        if (this.chatMonitorTimeLimit == r9.chatMonitorTimeLimit) goto L15;
        return false;
    L15:
        if (this.enableUserInteractionIntercept == r9.enableUserInteractionIntercept) goto L18;
        return false;
    L18:
        if (this.dismissWhenBackground == r9.dismissWhenBackground) goto L21;
        return false;
    L21:
        if (this.enableSwipeDownClose == r9.enableSwipeDownClose) goto L24;
        return false;
    L24:
        if (this.pauseVideoWhenDragging == r9.pauseVideoWhenDragging) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.chatPageTimeLimit;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.chatMonitorTimeLimit;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        int r4 = 1231;
        if (this.enableUserInteractionIntercept == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r2 + r5) * 31;
        if (this.dismissWhenBackground == false) goto L9;
        int r7 = 1231;
    L10:
        int r8 = (r6 + r7) * 31;
        if (this.enableSwipeDownClose == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r8 + r9) * 31;
        if (this.pauseVideoWhenDragging == true) goto L19;
        r4 = 1237;
    L19:
        return r10 + r4;
    L13:
        r9 = 1237;
        goto L14
    L9:
        r7 = 1237;
        goto L10
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "NexPulseDialogConfig(chatPageTimeLimit=" + this.chatPageTimeLimit + ", chatMonitorTimeLimit=" + this.chatMonitorTimeLimit + ", enableUserInteractionIntercept=" + this.enableUserInteractionIntercept + ", dismissWhenBackground=" + this.dismissWhenBackground + ", enableSwipeDownClose=" + this.enableSwipeDownClose + ", pauseVideoWhenDragging=" + this.pauseVideoWhenDragging + ')';
    }

    public final long a() {
        return this.chatMonitorTimeLimit;
    }

    public final long b() {
        return this.chatPageTimeLimit;
    }

    public final boolean c() {
        return this.dismissWhenBackground;
    }

    public final boolean d() {
        return this.enableSwipeDownClose;
    }

    public final boolean e() {
        return this.enableUserInteractionIntercept;
    }

    public final boolean f() {
        return this.pauseVideoWhenDragging;
    }

    public j0(int r3) {
        this.chatPageTimeLimit = 1500;
        this.chatMonitorTimeLimit = 2500;
        this.enableUserInteractionIntercept = false;
        this.dismissWhenBackground = false;
        this.enableSwipeDownClose = false;
        this.pauseVideoWhenDragging = false;
    }
}
