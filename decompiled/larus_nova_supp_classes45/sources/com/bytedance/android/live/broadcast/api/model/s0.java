package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/s0;", "", "", "containerId", "Ljava/lang/String;", "getContainerId", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", LiveSlardarConstants.EXTRA_KEY_URL, "getUrl", "e", "payload", "getPayload", "c", "position", "getPosition", "d", "extra", "getExtra", "b", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("container_id")
    private String containerId;

    @SerializedName("extra")
    private String extra;

    @SerializedName("payload")
    private String payload;

    @SerializedName("position")
    private String position;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private String url;

    public s0() {
    }

    public final void a(String r1) {
        this.containerId = r1;
    }

    public final void b(String r1) {
        this.extra = r1;
    }

    public final void c(String r1) {
        this.payload = r1;
    }

    public final void d(String r1) {
        this.position = r1;
    }

    public final void e(String r1) {
        this.url = r1;
    }
}
