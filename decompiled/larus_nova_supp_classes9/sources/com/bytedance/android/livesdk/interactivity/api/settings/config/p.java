package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/p;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "danmakuSpeed", "I", "a", "()I", "setDanmakuSpeed", "(I)V", "giftDanmakuMaxCount", "b", "setGiftDanmakuMaxCount", "specialDanmakuMaxCount", "c", "setSpecialDanmakuMaxCount", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("danmaku_speed")
    private int danmakuSpeed;

    @SerializedName("gift_danmaku_max_count")
    private int giftDanmakuMaxCount;

    @SerializedName("special_danmaku_max_count")
    private int specialDanmakuMaxCount;

    public p() {
        this.danmakuSpeed = 320;
        this.giftDanmakuMaxCount = 5;
        this.specialDanmakuMaxCount = 5;
    }

    public final int a() {
        return this.danmakuSpeed;
    }

    public final int b() {
        return this.giftDanmakuMaxCount;
    }

    public final int c() {
        return this.specialDanmakuMaxCount;
    }
}
