package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "topEffectEnable", "Z", "getTopEffectEnable", "()Z", "floatAssetVideoRoomEnable", "c", "floatAssetAudioRoomEnable", "a", BuildConfig.FLAVOR, "floatAssetLynxSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("float_asset_audio_room_enable")
    private final boolean floatAssetAudioRoomEnable;

    @SerializedName("live_gift_audio_room_float_asset_lynx_url")
    private final String floatAssetLynxSchema;

    @SerializedName("float_asset_video_room_enable")
    private final boolean floatAssetVideoRoomEnable;

    @SerializedName("top_asset_enable")
    private final boolean topEffectEnable;

    public a() {
        this.topEffectEnable = true;
        this.floatAssetVideoRoomEnable = true;
        this.floatAssetAudioRoomEnable = true;
        this.floatAssetLynxSchema = "sslocal://webcast_lynxview?enable_dynamic_v8=1&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Feffects_sar_creator_gift_lynx_douyin%2Fpages%2Ftop_effect%2Ftemplate.js&enable_canvas=1&type=popup&gravity=bottom&width_percent=100&height_percent=100&open_animate=0";
    }

    public final boolean a() {
        return this.floatAssetAudioRoomEnable;
    }

    public final String b() {
        return this.floatAssetLynxSchema;
    }

    public final boolean c() {
        return this.floatAssetVideoRoomEnable;
    }
}
