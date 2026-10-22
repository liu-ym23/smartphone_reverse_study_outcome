package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/u0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableAnchorV2", "Z", "a", "()Z", "setEnableAnchorV2", "(Z)V", "enableAudienceV2", "b", "setEnableAudienceV2", BuildConfig.FLAVOR, "introMaxLines", "I", "c", "()I", "setIntroMaxLines", "(I)V", "supportAnchorProfile", "d", "setSupportAnchorProfile", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("anchor_v2_enable")
    private boolean enableAnchorV2;

    @SerializedName("audience_v2_enable")
    private boolean enableAudienceV2;

    @SerializedName("intro_max_lines")
    private int introMaxLines;

    @SerializedName("support_anchor_profile")
    private boolean supportAnchorProfile;

    public u0() {
        this.introMaxLines = 3;
    }

    public final boolean a() {
        return this.enableAnchorV2;
    }

    public final boolean b() {
        return this.enableAudienceV2;
    }

    public final int c() {
        return this.introMaxLines;
    }

    public final boolean d() {
        return this.supportAnchorProfile;
    }
}
