package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/toolbar/d;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "gameType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", BuildConfig.FLAVOR, "settingSchema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "managementSchema", "b", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("game_type")
    private final Integer gameType;

    @SerializedName("management_schema")
    private final String managementSchema;

    @SerializedName("setting_schema")
    private final String settingSchema;

    public d() {
        this.settingSchema = BuildConfig.FLAVOR;
        this.managementSchema = BuildConfig.FLAVOR;
    }

    public final Integer a() {
        return this.gameType;
    }

    public final String b() {
        return this.managementSchema;
    }

    public final String c() {
        return this.settingSchema;
    }
}
