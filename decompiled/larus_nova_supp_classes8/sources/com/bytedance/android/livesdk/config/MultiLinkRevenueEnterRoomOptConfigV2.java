package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiLinkRevenueEnterRoomOptConfigV2;", "", "()V", "startEventOpt", "", "getStartEventOpt", "()Z", "setStartEventOpt", "(Z)V", "startEventOptVersion", "", "getStartEventOptVersion", "()J", "setStartEventOptVersion", "(J)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkRevenueEnterRoomOptConfigV2 {

    @SerializedName("start_event_opt")
    private boolean startEventOpt;

    @SerializedName("start_event_opt_version")
    private long startEventOptVersion;

    public MultiLinkRevenueEnterRoomOptConfigV2() {
    }

    public final boolean getStartEventOpt() {
        return this.startEventOpt;
    }

    public final long getStartEventOptVersion() {
        return this.startEventOptVersion;
    }

    public final void setStartEventOpt(boolean r1) {
        this.startEventOpt = r1;
    }

    public final void setStartEventOptVersion(long r1) {
        this.startEventOptVersion = r1;
    }
}
