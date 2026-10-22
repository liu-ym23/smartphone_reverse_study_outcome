package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/j;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableSend", "Z", "a", "()Z", "setEnableSend", "(Z)V", BuildConfig.FLAVOR, "fusionEmojiResizeFactor", "F", "b", "()F", "setFusionEmojiResizeFactor", "(F)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("enable_send")
    private boolean enableSend;

    @SerializedName("fusion_emoji_resize_factor")
    private float fusionEmojiResizeFactor;

    public j() {
        this.fusionEmojiResizeFactor = 1.0f;
    }

    public final boolean a() {
        return this.enableSend;
    }

    public final float b() {
        return this.fusionEmojiResizeFactor;
    }
}
