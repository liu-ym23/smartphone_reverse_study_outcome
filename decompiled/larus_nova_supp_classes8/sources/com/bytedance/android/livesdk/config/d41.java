package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/config/d41;", "", "", "room", "Z", "getRoom", "()Z", "setRoom", "(Z)V", "", "roomDefaultWsUrl", "Ljava/lang/String;", "getRoomDefaultWsUrl", "()Ljava/lang/String;", "setRoomDefaultWsUrl", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "channelDefaultWsUrl", "getChannelDefaultWsUrl", "setChannelDefaultWsUrl", "preview", "getPreview", "setPreview", "previewDefaultWsUrl", "getPreviewDefaultWsUrl", "setPreviewDefaultWsUrl", "venue", "getVenue", "setVenue", "venueDefaultWsUrl", "getVenueDefaultWsUrl", "setVenueDefaultWsUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d41 {

    @SerializedName("channel_enable")
    private boolean channel;

    @SerializedName("channel_default_ws_url")
    private String channelDefaultWsUrl;

    @SerializedName("preview_enable")
    private boolean preview;

    @SerializedName("preview_default_ws_url")
    private String previewDefaultWsUrl;

    @SerializedName("room_enable")
    private boolean room;

    @SerializedName("room_default_ws_url")
    private String roomDefaultWsUrl;

    @SerializedName("venue_enable")
    private boolean venue;

    @SerializedName("venue_default_ws_url")
    private String venueDefaultWsUrl;

    public d41() {
        this.channelDefaultWsUrl = "";
        this.preview = true;
        this.previewDefaultWsUrl = "";
    }
}
