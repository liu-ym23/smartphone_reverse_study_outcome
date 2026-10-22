package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/config/eg1;", "", "", "allowRoomId", "Z", "h", "()Z", "setAllowRoomId", "(Z)V", "allowRequestId", "g", "setAllowRequestId", "allowLogPb", "f", "setAllowLogPb", "allowAnchorName", "c", "setAllowAnchorName", "allowTitle", "j", "setAllowTitle", "allowCover", "e", "setAllowCover", "allowStreamUrl", "i", "setAllowStreamUrl", "allowViewCount", "k", "setAllowViewCount", "allowAnchorFollowCount", "a", "setAllowAnchorFollowCount", "allowContentLabel", "d", "setAllowContentLabel", "allowAnchorLocation", "b", "setAllowAnchorLocation", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class eg1 {

    @SerializedName("allow_anchor_follow_count")
    private boolean allowAnchorFollowCount;

    @SerializedName("allow_anchor_location")
    private boolean allowAnchorLocation;

    @SerializedName("allow_anchor_name")
    private boolean allowAnchorName;

    @SerializedName("allow_content_label")
    private boolean allowContentLabel;

    @SerializedName("allow_cover")
    private boolean allowCover;

    @SerializedName("allow_log_pb")
    private boolean allowLogPb;

    @SerializedName("allow_request_id")
    private boolean allowRequestId;

    @SerializedName("allow_room_id")
    private boolean allowRoomId;

    @SerializedName("allow_stream_url")
    private boolean allowStreamUrl;

    @SerializedName("allow_title")
    private boolean allowTitle;

    @SerializedName("allow_view_count")
    private boolean allowViewCount;

    public eg1() {
    }

    public final boolean a() {
        return this.allowAnchorFollowCount;
    }

    public final boolean b() {
        return this.allowAnchorLocation;
    }

    public final boolean c() {
        return this.allowAnchorName;
    }

    public final boolean d() {
        return this.allowContentLabel;
    }

    public final boolean e() {
        return this.allowCover;
    }

    public final boolean f() {
        return this.allowLogPb;
    }

    public final boolean g() {
        return this.allowRequestId;
    }

    public final boolean h() {
        return this.allowRoomId;
    }

    public final boolean i() {
        return this.allowStreamUrl;
    }

    public final boolean j() {
        return this.allowTitle;
    }

    public final boolean k() {
        return this.allowViewCount;
    }
}
