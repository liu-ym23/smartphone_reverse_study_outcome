package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/f9;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "rankType", "I", "b", "()I", "setRankType", "(I)V", "", "realtimeSchema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setRealtimeSchema", "(Ljava/lang/String;)V", "singingRankSchema", "d", "setSingingRankSchema", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f9 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("rank_type")
    private int rankType;

    @SerializedName("realtime_schema")
    private String realtimeSchema;

    @SerializedName("singing_rank_schema")
    private String singingRankSchema;

    public f9() {
        this.enable = true;
        this.realtimeSchema = "sslocal://webcast_lynxview?type=popup&gravity=bottom&height=450&load_taro=0&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_douyin%2Fpages%2Fktv%2Fdaily%2Ftemplate.js";
        this.singingRankSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Fs3.bytecdn.cn%2Fies%2Flive%2Fwebcast_native_lynx_douyin%2Fpages%2Faudiencelist%2Ftemplate.js%3FinitialProps%3D%255B%2522current_room%2522%252C%2522current_user%2522%252C%2522linkmic%2522%252C%2522setting%253Alive_audience_list_combine_config%253Alive_audience_list_combine_style%253Alive_anchor_perception_of_fans_badge_enable%253Alive_audience_list_new_rights_config%253Alive_enable_visibility_scope_share%253Alive_anchor_local_badge_enable%2522%255D%26defaultTab%3Dweekrank%26source%3Dsong_rank&load_taro=0&gravity=bottom&type=popup&lynx_thread=2&window_floating=0&height=450&landscape_custom_width=1&abandon_coordinate=1&enable_lynx_bg=1";
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.rankType;
    }

    public final String c() {
        return this.realtimeSchema;
    }

    public final String d() {
        return this.singingRankSchema;
    }
}
